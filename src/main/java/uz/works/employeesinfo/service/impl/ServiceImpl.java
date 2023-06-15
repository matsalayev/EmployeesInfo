package uz.works.employeesinfo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.works.employeesinfo.model.Employee;
import uz.works.employeesinfo.repository.EmployeeRepository;
import uz.works.employeesinfo.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public Employee save(Employee employee){
        return repository.save(employee);
    }

    public List<Employee> findByName(String name){
        return repository.findByName(name);
    }

    public Employee findById(Integer id){
        Optional<Employee> optional = repository.findById(id);
        return optional.orElse(null);
    }

    public List<Employee> findAll(){
        return repository.findAll();
    }


    public Employee update(Integer id, Employee employee) {
        Optional<Employee> optional = repository.findById(id);
        if(optional.isPresent()) {
            Employee newEmployee = optional.get();
            newEmployee.setFirstName(employee.getFirstName());
            newEmployee.setLastName(employee.getLastName());
            newEmployee.setPhone(employee.getPhone());
            newEmployee.setEmail(employee.getEmail());
            newEmployee.setImageUrl(employee.getImageUrl());
            repository.save(newEmployee);
            return newEmployee;
        }
        return null;
    }

    public void delete(Integer id) {
        Optional<Employee> optional = repository.findById(id);
        if(optional.isPresent()) {
            Employee oldEmployee = optional.get();
            repository.delete(oldEmployee);
        }
    }

}
