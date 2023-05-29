package uz.works.employeesinfo.service;

import org.springframework.stereotype.Service;
import uz.works.employeesinfo.model.Employee;
import uz.works.employeesinfo.model.Task;
import uz.works.employeesinfo.repository.EmployeeRepository;
import uz.works.employeesinfo.repository.TaskRepository;

import java.util.List;

@Service
public class HomeService {

    private final EmployeeRepository repository;
    private final TaskRepository taskRepository;

    public HomeService(EmployeeRepository repository, TaskRepository taskRepository){
        this.repository = repository;
        this.taskRepository = taskRepository;
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

    public Employee createTask(Integer id, List<Task> task) {
        Employee employee = repository.findById(id).get();
        List<Task> tasks = employee.getTasks();
        for(Task i : task){
            tasks.add(i);
            taskRepository.save(i);
        }
        employee.setTasks(tasks);
        repository.save(employee);
        return employee;
    }

    public Object updateTask(Integer id, Task task) {
        return null;
    }
}
