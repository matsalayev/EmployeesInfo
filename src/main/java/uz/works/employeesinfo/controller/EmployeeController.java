package uz.works.employeesinfo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.works.employeesinfo.model.Employee;
import uz.works.employeesinfo.service.EmployeeService;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service){
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Employee> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/{name}")
    public  ResponseEntity<Employee> findByName(@PathVariable String name){
        return ResponseEntity.ok(service.findByName(name));
    }

    @PostMapping()
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(employee));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Employee> update(@PathVariable Integer id, @RequestBody Employee employee){
        return ResponseEntity.ok(service.update(id, employee));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<List<Employee>> delete(@PathVariable Integer id){
        return ResponseEntity.ok(service.delete(id));
    }
}
