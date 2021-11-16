package blogService.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import blogService.repository.UserRepository;

public class LoginIsAvailableValidator implements ConstraintValidator<LoginIsAvailable, String> {

	private UserRepository userRepository;
	
	
	public LoginIsAvailableValidator (final UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void initialize(final LoginIsAvailable loginIsAvailable) {
	}

	@Override
	public boolean isValid(final String username,final ConstraintValidatorContext context) {
		return !(userRepository.findUserByUsername(username).isPresent());
		}
	}
