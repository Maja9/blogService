package blogService.controler;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import blogService.repository.UserRepository;

public class LoginIsAvailableValidator implements ConstraintValidator<LoginIsAvailable, String> {

	private UserRepository userRepository;
	
	
	public LoginIsAvailableValidator (UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void initialize(LoginIsAvailable loginIsAvailable) {
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		return !(userRepository.findUserByUsername(username).isPresent());
		}
	}
