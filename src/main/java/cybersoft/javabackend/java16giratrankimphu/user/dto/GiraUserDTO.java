package cybersoft.javabackend.java16giratrankimphu.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import cybersoft.javabackend.java16giratrankimphu.user.modal.UserStatus;
import cybersoft.javabackend.java16giratrankimphu.user.validation.annotation.UniqueEmail;
import cybersoft.javabackend.java16giratrankimphu.user.validation.annotation.UniqueUsername;
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class GiraUserDTO {
	// mandatory
	@Size(min = 3, max = 100, message = "{user.username.size}")
	@UniqueUsername(message = "{user.username.existed}")
	@NotBlank
	private String username;
	
	private String password;
	
	private String displayName;
	
	@UniqueEmail(message = "{user.email.existed}")
	@NotBlank
	private String email;
	
	private UserStatus status;
}