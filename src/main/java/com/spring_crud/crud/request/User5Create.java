package com.spring_crud.crud.request;

import com.spring_crud.crud.domain.SexType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class User5Create {
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
}
