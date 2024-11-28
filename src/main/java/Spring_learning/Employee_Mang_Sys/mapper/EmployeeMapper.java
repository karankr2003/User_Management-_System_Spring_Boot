package Spring_learning.Employee_Mang_Sys.mapper;

import Spring_learning.Employee_Mang_Sys.dto.EmployeeDto;
import Spring_learning.Employee_Mang_Sys.entity.Employee;

	
public class EmployeeMapper {

    // Maps EmployeeDto to Employee entity
    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            return null;
        }

        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        // The 'id' field is generated automatically after saving, so no need to set it here.
        return employee;
    }

    // Maps Employee entity to EmployeeDto
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        if (employee == null) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        return employeeDto;
    }
}
