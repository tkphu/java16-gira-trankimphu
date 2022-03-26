package cybersoft.javabackend.java16giratrankimphu.user.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.java16giratrankimphu.user.modal.GiraUser;
import cybersoft.javabackend.java16giratrankimphu.user.repository.GiraUserRepository;
import cybersoft.javabackend.java16giratrankimphu.user.validation.annotation.ExistedUser;

public class ExistedUserValidator implements ConstraintValidator<ExistedUser, String> {
	private String message;
	@Autowired 
	private GiraUserRepository repository;
	
	@Override
	public void initialize(ExistedUser existedUser) {
		message = existedUser.message();
	}
	
	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		Optional<GiraUser> userOpt = repository.findByUsername(username);
		if(!(userOpt.isEmpty())) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(message)
		.addConstraintViolation()
		.disableDefaultConstraintViolation();
		return false;
	}

}
