package com.mock_project_102024_nhom02.dao;

import jakarta.persistence.criteria.*;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.mock_project_102024_nhom02.dto.response.IncomeResponse;
import com.mock_project_102024_nhom02.entity.Income;
import com.mock_project_102024_nhom02.hibernate.HibernateUtil;
import com.mock_project_102024_nhom02.mapper.IncomeMapper;

@Repository
public class IncomeDAO {

    private final SessionFactory entityManager = HibernateUtil.getFACTORY();

    @Autowired
    IncomeMapper incomeMapper;


    @Transactional
    public Page<IncomeResponse> filterWithCondition(String apartmentId, String serviceId,
                                                    LocalDate startDate, LocalDate endDate, int currentPage, int pageSize) {

        try (Session session = entityManager.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Income> query = builder.createQuery(Income.class);
            Root<Income> root = query.from(Income.class);
            query.select(root);

            List<Predicate> predicates = new ArrayList<>();

            Predicate predicateWithApartment = null;
            Predicate predicateWithService = null;
            Predicate predicateWithDate = null;

            Pageable pageable  = PageRequest.of(currentPage / pageSize, pageSize);

            if (!Objects.isNull(apartmentId)) {
                predicateWithApartment = builder.like(root.get("apartment").get("id"), "%" + apartmentId + "%" );
                predicates.add(predicateWithApartment);
            }

            if (!Objects.isNull(serviceId)) {
                predicateWithService = builder.equal(root.get("service").get("id"), serviceId);
                predicates.add(predicateWithService);
            }

            if (!Objects.isNull(startDate) & !Objects.isNull(endDate)) {
                predicateWithDate = builder.between(root.get("paymentDeadline"), startDate, endDate);
                predicates.add(predicateWithDate);
            } else if(!Objects.isNull(startDate)) {
                predicateWithDate = builder.greaterThan(root.get("paymentDeadline"), startDate);
                predicates.add(predicateWithDate);
            } else if(!Objects.isNull(endDate)) {
                predicateWithDate = builder.lessThan(root.get("paymentDeadline"), endDate);
                predicates.add(predicateWithDate);
            }



            Predicate finalPredicate = builder.and(predicates.toArray(new Predicate[0]));
            query.select(root).where(finalPredicate);

            Query<Income> incomeQuery = session.createQuery(query);

            long totalItems = incomeQuery.getResultList().size();
            incomeQuery.setFirstResult(currentPage == 1 ? 0 : (currentPage - 1) * pageSize);
            incomeQuery.setMaxResults(pageSize);
            List<IncomeResponse> departments = incomeQuery.getResultList().stream().map(incomeMapper::toIncomeResponse).toList();

            return new PageImpl<>(departments, pageable, totalItems);

        }

    }
}
