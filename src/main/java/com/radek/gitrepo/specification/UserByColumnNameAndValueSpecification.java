package com.radek.gitrepo.specification;

import com.radek.gitrepo.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@AllArgsConstructor
public class UserByColumnNameAndValueSpecification implements Specification<User> {

    private String fieldName;
    private Object value;

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        return builder.equal(root.get(fieldName), value);
    }
}
