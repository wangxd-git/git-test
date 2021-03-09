package com.study.springboot.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private String stunumber;

}
