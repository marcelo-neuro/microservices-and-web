package br.com.neuro.msemployees.dto;

import br.com.neuro.msemployees.model.Employee;

import java.time.LocalDate;

public record EmployeeResponseDTO(Long id,
                                  String name,
                                  String cpf,
                                  String email,
                                  Double salary,
                                  LocalDate birthDate) {

    public EmployeeResponseDTO(Employee employee) {
        this(employee.getId(), employee.getName(), employee.getCpf(), employee.getEmail(),
                employee.getSalary(), employee.getBirthDate());
    }

}
