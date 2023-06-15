package uz.works.employeesinfo.service;

import uz.works.employeesinfo.model.Employee;
import java.util.*;

public interface EmployeeService {

    Employee save(Employee Employee);

    List<Employee> findAll();
    Employee findById(Integer id);
    List<Employee> findByName(String name);

    Employee update(Integer id, Employee employee);

    void delete(Integer id);
}
