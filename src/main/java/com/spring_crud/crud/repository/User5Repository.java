package com.spring_crud.crud.repository;

import com.spring_crud.crud.domain.User5;
import com.spring_crud.crud.request.User5Update;
import com.spring_crud.crud.request.cond.User5SearchCond;

import java.util.List;

public interface User5Repository {
    public Long save(User5 user5);

    public User5 findById(Long id);

    public List<User5> findAll(User5SearchCond cond);

    public void delete(Long id);

    public Long update(Long id, User5Update dto);

}
