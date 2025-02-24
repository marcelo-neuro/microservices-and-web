package br.com.neuro.msemployees.service;

import br.com.neuro.msemployees.dto.EmployeeRequestDTO;
import br.com.neuro.msemployees.dto.EmployeeResponseDTO;
import br.com.neuro.msemployees.model.Employee;
import br.com.neuro.msemployees.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Transactional
    public EmployeeResponseDTO insert(EmployeeRequestDTO requestDTO) {
        Employee employee = new Employee();
        employee.setName(requestDTO.name());
        employee.setCpf(requestDTO.cpf());
        employee.setEmail(requestDTO.email());
        employee.setSalary(requestDTO.salary());
        employee.setBirthDate(requestDTO.birthDate());

        return new EmployeeResponseDTO(repository.save(employee));
    }

    @Transactional(readOnly = true)
    public List<EmployeeResponseDTO> getAll() {
        return repository.findAll()
                .stream().map(EmployeeResponseDTO::new)
                .toList();
    }

    @Transactional
    public EmployeeResponseDTO update(EmployeeRequestDTO requestDTO, Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee don't exist. Id: " + id));

        employee.setName(requestDTO.name());
        employee.setCpf(requestDTO.cpf());
        employee.setEmail(requestDTO.email());
        employee.setSalary(requestDTO.salary());
        employee.setBirthDate(requestDTO.birthDate());

        return new EmployeeResponseDTO(repository.save(employee));
    }

    @Transactional
    public void delete(Long id) {
        if(!repository.existsById(id)) {
            throw new EntityNotFoundException("Employee don't exist. Id: " + id);
        }

        repository.deleteById(id);
    }
}
