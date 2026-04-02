package com.meta12.yuni01.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "memberNo") 실제 DB 테이블에 memberNo로 저장된다.
    private long id;

    @Column(name = "username", insertable = true, updatable=false, length = 50, nullable = false, unique = true)
    private String username;

    private String password;

    @Transient //DB 테이블 필드로 생성되지 않게 할 때.
    private String passwordChk;

    private String name;
    private String ssn;
    private String phone;
    private String email;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String grade;

}
