package com.csi.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int empId;

    @Size(min = 2, message = "Employee Name Should be 2 Characters")
    private String empName;

    @NotNull
    private String empAddress;

    @Column(unique = true)
    @Range(min = 1000000000, max = 9999999999L, message = "Contact Number Should be 10 Digit")
    private long empContactNumber;

    private double empSalary;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date empDOB;

    @Column(unique = true)
    @Email(message = "Email ID Must be Valid")
    private String empEmailId;

    @Size(min = 4, message = "Employee Password Should be 4 Characters")
    private String empPassword;
}
