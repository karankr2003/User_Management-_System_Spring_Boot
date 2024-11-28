package Spring_learning.Employee_Mang_Sys.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Spring_learning.Employee_Mang_Sys.dto.EmployeeDto;
import Spring_learning.Employee_Mang_Sys.entity.Employee;
import Spring_learning.Employee_Mang_Sys.exception.ResourceNotFoundException;
import Spring_learning.Employee_Mang_Sys.mapper.EmployeeMapper;
import Spring_learning.Employee_Mang_Sys.repository.EmployeeRepository;
import Spring_learning.Employee_Mang_Sys.service.EmployeeService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceimpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	 

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // Map EmployeeDto to Employee entity
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		
        // Save the employee and get the saved entity
		Employee savedEmployee = employeeRepository.save(employee);
		
        // Map the saved employee entity to EmployeeDto and return
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}


	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {	
		Employee employee =   employeeRepository.findById(employeeId)
		.orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id :" + employeeId));
		
		return EmployeeMapper.mapToEmployeeDto(employee);
	}


	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}


	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
			() -> new ResourceNotFoundException("Employee is not exist with given id : " + employeeId)						
	);
	employee.setFirstName(updatedEmployee.getFirstName());
	employee.setLastName(updatedEmployee.getLastName());
	employee.setEmail(updatedEmployee.getEmail());
	Employee updatedEmployeeObj = employeeRepository.save(employee);
	return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);	
	}


	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exist with given id : " + employeeId)						
		);
		employeeRepository.deleteById(employeeId);
		
		
		
		
		
	}	

}
