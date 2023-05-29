package uz.works.employeesinfo.service;

import org.springframework.stereotype.Service;
import uz.works.employeesinfo.model.Employee;
import uz.works.employeesinfo.model.Task;
import uz.works.employeesinfo.repository.EmployeeRepository;
import uz.works.employeesinfo.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

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
        Optional<Employee> optional = repository.findById(id);
        return optional.orElse(null);
    }

    public List<Employee> findAll(){
        return repository.findAll();
    }

    public List<Task> findAllTask(){
        return taskRepository.findAll();
    }

    public Employee update(Integer id, Employee employee) {
        Optional<Employee> optional = repository.findById(id);
        if(optional.isPresent()) {
            Employee newEmployee = optional.get();
            newEmployee.setName(employee.getName());
            newEmployee.setLastName(employee.getLastName());
            repository.save(newEmployee);
            return newEmployee;
        }
        return null;
    }

    public List<Employee> delete(Integer id) {
        Optional<Employee> optional = repository.findById(id);
        if(optional.isPresent()) {
            Employee oldEmployee = optional.get();
            repository.delete(oldEmployee);
            return repository.findAll();
        }
        return null;
    }

    public Employee createTask(Integer id, List<Task> task) {
        Optional<Employee> optional = repository.findById(id);
        if(optional.isPresent()) {
            Employee employee = optional.get();
            List<Task> tasks = employee.getTasks();
            for (Task i : task) {
                tasks.add(i);
                taskRepository.save(i);
            }
            employee.setTasks(tasks);
            repository.save(employee);
            return employee;
        }
        return null;
    }

    public List<Task> updateTask(Integer id, Task task) {
        Optional<Task> optional = taskRepository.findById(id);
        if(optional.isPresent()){
            Task item = optional.get();
            item.setName(task.getName());
            item.setDescription(task.getDescription());
            item.setCompleted(task.getCompleted());
            item.setDurationDay(task.getDurationDay());
            taskRepository.save(item);
            return taskRepository.findAll();
        }
        return null;
    }
}
