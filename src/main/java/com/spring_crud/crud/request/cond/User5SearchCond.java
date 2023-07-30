package com.spring_crud.crud.request.cond;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User5SearchCond {
    private String name;
    private Integer minAge;
    private Integer maxAge;
    private String sex;

    public User5SearchCond(String name, Integer minAge, Integer maxAge,String sex) {
        this.name = name;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.sex = sex;
    }
}
