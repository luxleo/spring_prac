package com.spring_crud.crud.service;

import com.spring_crud.crud.domain.User5;
import com.spring_crud.crud.repository.User5Repository;
import com.spring_crud.crud.request.User5Create;
import com.spring_crud.crud.request.User5Update;
import com.spring_crud.crud.request.cond.User5SearchCond;
import com.spring_crud.crud.response.User5UpdateForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class User5Service {
    private final User5Repository user5Repository;

    public Long create(User5Create dto) {
        User5 temp = User5.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .birth(dto.getBirth())
                .hp(dto.getHp())
                .addr(dto.getAddr())
                .sex(dto.getSex())
                .build();
        user5Repository.save(temp);
        return temp.getId();
    }

    public List<User5> getList(User5SearchCond searchCond) {
        return user5Repository.findAll(searchCond);
    }

    public User5 getOne(Long id) {
        return user5Repository.findById(id);
    }
    public User5UpdateForm getUpdateForm(Long id) {
        User5 user5 = user5Repository.findById(id);
        User5UpdateForm.User5UpdateFormBuilder formBuilder = user5.toUpdateForm();
        return formBuilder.build();
    }

    public Long updateUser(Long id, User5Update dto) {
        return user5Repository.update(id, dto);
    }

    public void deleteUser(Long id) {
        user5Repository.delete(id);
    }
}
