package Spring_learning.Employee_Mang_Sys.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	//extra
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
