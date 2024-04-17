package kz.project.test.model;

import lombok.Data;

@Data
public class EmployeeDto {
    private String name;
    private String age;
    private String email;
    private AddressDto addressDto;
}
