package pl.rafalab.rafalworld.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.rafalab.rafalworld.Constants.RafConstants;
import pl.rafalab.rafalworld.Model.User;
import pl.rafalab.rafalworld.RafUtils.RafUtils;



public class EditUserProfileValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> cls) {
		return User.class.equals(cls);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		User u = (User) obj;
		
		ValidationUtils.rejectIfEmpty(errors, "name", "error.userName.empty");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "error.userLastName.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "error.userEmail.empty");
		
		if (!u.getEmail().equals(null)) {
			boolean isMatch = RafUtils.checkEmailOrPassword(RafConstants.EMAIL_PATTERN, u.getEmail());
			if(!isMatch) {
				errors.rejectValue("email", "error.userEmailIsNotMatch");
			}
		}
		
	}

}