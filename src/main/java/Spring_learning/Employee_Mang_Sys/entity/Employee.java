package Spring_learning.Employee_Mang_Sys.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    
	@NotBlank(message = "First name is mandatory")
	@Column(name = "first_name")
	private String firstName;
    
    @NotBlank(message = "Last name is mandatory")
	@Column(name ="last_name")
	private String lastName;

	@Column(name = "email_id", nullable = false, unique = true)
	private String email;

}
