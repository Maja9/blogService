package controler;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import repository.UserRepository;

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
		if (userRepository.findUserByUsername(username).isPresent()) {
			throw new IllegalArgumentException("Użytkwnik o podanym loginie już istnieje");
		}
	}

}