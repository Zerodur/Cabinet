package ru.homework.cabinet.validators;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator("ru.homework.cabinet.validators.DocumentTypeValidator")
public class DocumentTypeValidator implements Validator{

    private static final String TYPE_PATTERN =
            "[a-zA-Z0-9]{1,5}";

    private Pattern pattern;

    public DocumentTypeValidator()
    {
        pattern = Pattern.compile(TYPE_PATTERN);
    }

    public void validate(FacesContext context, UIComponent component,
                         Object value) throws ValidatorException
    {
        Matcher matcher = pattern.matcher(value.toString());
        if (!matcher.matches()) {
            FacesMessage msg = new FacesMessage("Error!",
                    "Некорректный тип!");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
