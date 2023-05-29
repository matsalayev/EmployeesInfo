package uz.works.employeesinfo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.works.employeesinfo.model.Employee;
import uz.works.employeesinfo.model.Task;
import uz.works.employeesinfo.service.HomeService;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final HomeService service;

    public TaskController(HomeService service){
        this.service = service;
    }

    @PostMapping("/newTask/{id}")
    public ResponseEntity<Employee> createTask(@PathVariable Integer id, @RequestBody Task task){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createTask(id, task));
    }
}
