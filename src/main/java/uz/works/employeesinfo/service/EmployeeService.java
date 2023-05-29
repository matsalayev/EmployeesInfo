package uz.works.employeesinfo.service;

import org.springframework.stereotype.Service;
import uz.works.employeesinfo.model.Employee;
import uz.works.employeesinfo.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository){
        this.repository = repository;
    }

    public Employee save(Employee employee){
        return repository.save(employee);
    }

    public Employee findByName(String name){
        return repository.findByName(name).get(0);
    }

    public Employee findById(Integer id){
        return repository.findById(id).get();
    }

    public List<Employee> findAll(){
        return repository.findAll();
    }

    public Employee update(Integer id, Employee employee) {
        Employee newEmployee = repository.findById(id).get();
        newEmployee.setName(employee.getName());
        newEmployee.setLastName(employee.getLastName());
        repository.save(newEmployee);
        return newEmployee;
    }

    public List<Employee> delete(Integer id) {
        Employee oldEmployee = repository.findById(id).get();
        repository.delete(oldEmployee);
        return repository.findAll();
    }
}
