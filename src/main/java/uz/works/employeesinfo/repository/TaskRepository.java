package uz.works.employeesinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.works.employeesinfo.model.Employee;
import uz.works.employeesinfo.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
