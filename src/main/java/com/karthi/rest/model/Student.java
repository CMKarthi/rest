package com.karthi.rest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Component
@AllArgsConstructor
@Getter
@Setter
public class Student {
Long id;
    @NotNull
            @Size(min=2, message="The Name should have a minimum of 2 Characters")
    String name;
    @NotNull
    @Size(min=1, message="The Gender should have a minimum of 1 Character")
    String gender;
public Student()
{

}

}
