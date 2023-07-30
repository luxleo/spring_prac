package com.spring_crud.crud.response;

import com.spring_crud.crud.domain.SexType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class User5UpdateForm {
    // memberUpdate.html에서 포스트시 id가 필요하다
    @NotNull
    private Long id;
    @NotEmpty
    private String name;
    @NotNull
    private int age;
    @NotEmpty
    private String addr;
    @NotEmpty
    private String hp;
    @NotNull
    private LocalDate birth;
    @NotNull
    private SexType sex;
    @Builder
    public User5UpdateForm(Long id, String name, int age, String addr, String hp, LocalDate birth, SexType sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.addr = addr;
        this.hp = hp;
        this.birth = birth;
        this.sex = sex;
    }
}
