package br.com.neuro.msemployees.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Long id;

    @Column(name = "name_employee")
    private String name;

    @Column(name = "cpf_employee")
    private String cpf;

    @Column(name = "email_employee")
    private String email;

    @Column(name = "salary_employee")
    private Double salary;

    @Column(name = "birth_date_employee")
    private LocalDate birthDate;

    public Employee() { }

    public Employee(Long id, String name, String cpf, String email, Double salary, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
