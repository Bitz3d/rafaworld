package pl.rafalab.rafalworld.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.rafalab.rafalworld.Constants.RafConstants;
import pl.rafalab.rafalworld.Model.User;
import pl.rafalab.rafalworld.RafUtils.RafUtils;

public class ChangePasswordValidator implements Validator {



    @Override
    public boolean supports(Class<?> cls){

        return User.class.equals(cls);

    }

    @Override
    public void validate(Object o, Errors errors) {
        @SuppressWarnings("unused")
        User user = (User) o;

        ValidationUtils.rejectIfEmpty(errors,"newPassword", "error.userPassword.empty");

    }

    public void checkPassword(String newPass, Errors errors){

        if(!newPass.equals(null)){
            boolean isMatch = RafUtils.checkEmailOrPassword(RafConstants.PASSWORD_PATTERN, newPass);
            if(!isMatch){
                errors.rejectValue("newPassword", "error.userPasswordIsNotMatch");
            }


        }

    }


}
