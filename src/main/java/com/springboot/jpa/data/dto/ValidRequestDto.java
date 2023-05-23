package com.springboot.jpa.data.dto;

import com.springboot.jpa.data.group.ValidationGroup1;
import com.springboot.jpa.data.group.ValidationGroup2;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidRequestDto {

    @NotBlank
    String name;

    @Email
    String email;

    String phoneNumber;

    @Min(value = 20, groups = ValidationGroup1.class)
    @Max(value = 40, groups = ValidationGroup2.class)
    int age;

    @Size(min =0, max = 40)
    String description;

    @Positive
    int count;

    @AssertTrue
    boolean booleanCheck;

}
