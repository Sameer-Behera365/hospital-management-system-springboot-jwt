package com.example.hms.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    private Long id;
    private String name;
    private Integer age;
    private String gender;
    private String disease;
    private String address;
    private String phoneNumber;
}
