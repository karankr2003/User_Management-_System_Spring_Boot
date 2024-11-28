package Spring_learning.Employee_Mang_Sys.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Spring_learning.Employee_Mang_Sys.dto.EmployeeDto;
import Spring_learning.Employee_Mang_Sys.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	//@Autowired
//	private EmployeeService employeeService;
    private final EmployeeService employeeService;

	
	//Build Add Employee REST API
	@PostMapping
	public  ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);	
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}	
	
	//Build Get Employee REST API
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeByid(@PathVariable("id") Long employeeId){
		EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeDto);	
	}
	
	//Build get all the Employees REST API
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
	 List<EmployeeDto> employees= employeeService.getAllEmployees();
	 return ResponseEntity.ok(employees);
	}
	
	
	//Build Update Employee REST API
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee){
	EmployeeDto employeeDto = 	employeeService.updateEmployee(employeeId, updatedEmployee);
	return ResponseEntity.ok(employeeDto);
	}
	
	//Build Delete Employee REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok("Employee Deleted Successfully");
	}
}


