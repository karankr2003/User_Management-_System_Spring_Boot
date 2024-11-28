package Spring_learning.Employee_Mang_Sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Spring_learning.Employee_Mang_Sys.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {	

}
