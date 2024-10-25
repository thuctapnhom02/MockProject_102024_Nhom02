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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.mock_project_102024_nhom02.dto.response.OutcomeResponse;
import com.mock_project_102024_nhom02.entity.Outcome;
import com.mock_project_102024_nhom02.hibernate.HibernateUtil;
import com.mock_project_102024_nhom02.mapper.OutcomeMapper;

@Repository
public class OutcomeDAO {

    private final SessionFactory entityManager = HibernateUtil.getFACTORY();

    @Autowired
    OutcomeMapper outcomeMapper;


    @Transactional
    public Page<OutcomeResponse> filterWithCondition(String typeOutcomeId, LocalDate startDate,
                                                     LocalDate endDate, int currentPage, int pageSize) {

        try (Session session = entityManager.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Outcome> query = builder.createQuery(Outcome.class);
            Root<Outcome> root = query.from(Outcome.class);
            query.select(root);

            List<Predicate> predicates = new ArrayList<>();

            Predicate predicateWithApartment = null;
            Predicate predicateWithService = null;
            Predicate predicateWithDate = null;

            Pageable pageable  = PageRequest.of(currentPage / pageSize, pageSize);

            if (!Objects.isNull(typeOutcomeId)) {
                predicateWithService = builder.like(root.get("typeOutcome").get("id"), "%" + typeOutcomeId + "%");
                predicates.add(predicateWithService);
            }

            if (!Objects.isNull(startDate) & !Objects.isNull(endDate)) {
                predicateWithDate = builder.between(root.get("dayOutcome"), startDate, endDate);
                predicates.add(predicateWithDate);
            } else if(!Objects.isNull(startDate)) {
                predicateWithDate = builder.greaterThan(root.get("dayOutcome"), startDate);
                predicates.add(predicateWithDate);
            } else if(!Objects.isNull(endDate)) {
                predicateWithDate = builder.lessThan(root.get("dayOutcome"), endDate);
                predicates.add(predicateWithDate);
            }



            Predicate finalPredicate = builder.and(predicates.toArray(new Predicate[0]));
            query.select(root).where(finalPredicate);

            Query<Outcome> OutcomeQuery = session.createQuery(query);

            long totalItems = OutcomeQuery.getResultList().size();
            OutcomeQuery.setFirstResult(currentPage == 1 ? 0 : (currentPage - 1) * pageSize);
            OutcomeQuery.setMaxResults(pageSize);
            List<OutcomeResponse> departments = OutcomeQuery.getResultList().stream().map(outcomeMapper::toOutcomeResponse).toList();

            return new PageImpl<>(departments, pageable, totalItems);

        }

    }
}
