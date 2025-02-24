package br.com.neuro.msemployees.dto;

import br.com.neuro.msemployees.model.Employee;

import java.time.LocalDate;

public record EmployeeRequestDTO(String name,
                                 String cpf,
                                 String email,
                                 Double salary,
                                 LocalDate birthDate) {

    public EmployeeRequestDTO(Employee employee) {
        this(employee.getName(), employee.getCpf(), employee.getEmail(),
                employee.getSalary(), employee.getBirthDate());
    }
}
