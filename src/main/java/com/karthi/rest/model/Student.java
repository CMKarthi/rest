package com.karthi.rest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Getter
@Setter
public class Student {
    Long id;
    String name;
    String gender;
public Student()
{

}

}
