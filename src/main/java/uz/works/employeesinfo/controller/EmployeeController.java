package uz.works.employeesinfo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.works.employeesinfo.model.Employee;
import uz.works.employeesinfo.service.impl.ServiceImpl;
import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final ServiceImpl service;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Employee> findById(@Valid @PathVariable Integer id){
            return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/name/{name}")
    public  ResponseEntity<List<Employee>> findByName(@Valid @PathVariable String name){
        return ResponseEntity.ok(service.findByName(name));
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> create(@Valid @RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(employee));
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity<Employee> update(@Valid @PathVariable Integer id, @RequestBody Employee employee){
        return ResponseEntity.ok(service.update(id, employee));
    }

    @DeleteMapping("/delete{id}")
    public void delete(@Valid @PathVariable Integer id){
        service.delete(id);
    }
}
