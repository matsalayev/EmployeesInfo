package uz.works.employeesinfo.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import uz.works.employeesinfo.model.Employee;
import uz.works.employeesinfo.service.HomeService;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final HomeService service;

    public EmployeeController(HomeService service){
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Employee> findById(@Valid @PathVariable Integer id){
            return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/{name}")
    public  ResponseEntity<Employee> findByName(@Valid @PathVariable String name){
        return ResponseEntity.ok(service.findByName(name));
    }

    @PostMapping()
    public ResponseEntity<Employee> create(@Valid @RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(employee));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Employee> update(@Valid @PathVariable Integer id, @RequestBody Employee employee){
        return ResponseEntity.ok(service.update(id, employee));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<List<Employee>> delete(@Valid @PathVariable Integer id){
        return ResponseEntity.ok(service.delete(id));
    }
}
