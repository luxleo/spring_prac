package com.spring_crud.crud.domain;

import com.spring_crud.crud.request.User5Update;
import com.spring_crud.crud.response.User5UpdateForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User5 {
    @Id @GeneratedValue
    @Column(name = "USER5_ID")
    private Long id;
    @Column(nullable = false,length = 10)
    private String name;
    @ColumnDefault("1")
    private int age;
    @Column(length = 10)
    private String addr;
    @Column(length=20)
    private String hp;
    @ColumnDefault("0000-00-00")
    private LocalDate birth;
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false, length = 10)
    private SexType sex;

    @Builder
    public User5(String name, int age, String addr, String hp, LocalDate birth, SexType sex) {
        this.name = name;
        this.age = age;
        this.addr = addr;
        this.hp = hp;
        this.birth = birth;
        this.sex = sex;
    }
    public void edit(User5Update dto) {
        name = dto.getName();
        age = dto.getAge();
        addr = dto.getAddr();
        hp = dto.getHp();
        birth = dto.getBirth();
        sex = dto.getSex();
    }

    public User5UpdateForm.User5UpdateFormBuilder toUpdateForm() {
        return User5UpdateForm.builder()
                .id(id)
                .name(name)
                .age(age)
                .addr(addr)
                .hp(hp)
                .birth(birth)
                .sex(sex);
    }
}
