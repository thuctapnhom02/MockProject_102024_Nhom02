package com.mock_project_102024_nhom02.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.mock_project_102024_nhom02.dto.response.StaffResponse;
import com.mock_project_102024_nhom02.entity.Staff;
import com.mock_project_102024_nhom02.hibernate.HibernateUtil;
import com.mock_project_102024_nhom02.mapper.StaffMapper;

@Repository
public class StaffDAO {

    private final SessionFactory entityManager = HibernateUtil.getFACTORY();

    @Autowired
    StaffMapper staffMapper;


    @Transactional
    public Page<StaffResponse> filterWithCondition(String phone, String status, String role,
                                                    int currentPage, int pageSize) {

        try (Session session = entityManager.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Staff> query = builder.createQuery(Staff.class);
            Root<Staff> root = query.from(Staff.class);
            query.select(root);

            List<Predicate> predicates = new ArrayList<>();

            Predicate predicateWithPhone = null;
            Predicate predicateWithRole = null;
            Predicate predicateWithStatus = null;

            Pageable pageable  = PageRequest.of(currentPage / pageSize, pageSize);

            if (!Objects.isNull(phone)) {
                predicateWithPhone = builder.like(root.get("phone").as(String.class), "%" + phone + "%" );
                predicates.add(predicateWithPhone);
            }

            if (!Objects.isNull(role)) {
                predicateWithRole = builder.equal(root.get("role").get("id").as(String.class), role);
                predicates.add(predicateWithRole);
            }

            if (!Objects.isNull(status)) {
                predicateWithStatus = builder.equal(root.get("status").as(String.class), status);
                predicates.add(predicateWithStatus);
            }

            Predicate finalPredicate = builder.and(predicates.toArray(new Predicate[0]));
            query.select(root).where(finalPredicate);

            Query<Staff> staffQuery = session.createQuery(query);

            long totalItems = staffQuery.getResultList().size();
            staffQuery.setFirstResult(currentPage == 1 ? 0 : (currentPage - 1) * pageSize);
            staffQuery.setMaxResults(pageSize);
            List<StaffResponse> departments = staffQuery.getResultList().stream().map(staffMapper::toStaffResponse).toList();

            return new PageImpl<>(departments, pageable, totalItems);

        }

    }
}
