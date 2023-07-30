package com.spring_crud.crud.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.spring_crud.crud.domain.User5;
import com.spring_crud.crud.request.User5Update;
import com.spring_crud.crud.request.cond.User5SearchCond;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.spring_crud.crud.domain.QUser5.user5;

@Repository
@Transactional
public class User5JpaRepository implements User5Repository{
    private final EntityManager em;
    private final JPAQueryFactory query;

    public User5JpaRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }
    @Override
    public Long save(User5 user5) {
        em.persist(user5);
        return user5.getId();
    }

    @Override //Todo: null시 exception처리 하기
    public User5 findById(Long id) {
        return em.find(User5.class, id);
    }

    @Override
    public List<User5> findAll(User5SearchCond searchCond) {
        String userName = searchCond.getName();
        String userSex = searchCond.getSex();
        Integer maxAge = searchCond.getMaxAge();
        return query.selectFrom(user5)
                .where(likeUserName(userName), maxAge(maxAge),likeSex(userSex))
                .fetch();
    }

    private BooleanExpression likeSex(String userSex) {
        if (StringUtils.hasText(userSex)) {
            return user5.sex.stringValue().like(userSex);
        }
        return null;
    }

    private BooleanExpression maxAge(Integer maxAge) {
        if (maxAge != null) {
            return user5.age.loe(maxAge);
        }
        return null;
    }

    private BooleanExpression likeUserName(String userName) {
        if (StringUtils.hasText(userName)) {
            return user5.name.like("%" + userName + "%");
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Query query = em.createQuery("delete from User5 u where u.id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public Long update(Long id, User5Update dto) {
        User5 target = em.find(User5.class, id);
        target.edit(dto);
        return target.getId();
    }
}
