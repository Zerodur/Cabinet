package ru.homework.cabinet.validators;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator("ru.homework.cabinet.validators.UserPasswordValidator")
public class UserPasswordValidator implements Validator{

    private static final String PASS_PATTERN =
            "[a-zA-Z0-9]{6,20}";

    private Pattern pattern;

    public UserPasswordValidator()
    {
        pattern = Pattern.compile(PASS_PATTERN);
    }

    public void validate(FacesContext context, UIComponent component,
                         Object value) throws ValidatorException
    {
        Matcher matcher = pattern.matcher(value.toString());
        if (!matcher.matches()) {
            FacesMessage msg = new FacesMessage("Error!",
                    "Пароль минимум 6 знаков");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
