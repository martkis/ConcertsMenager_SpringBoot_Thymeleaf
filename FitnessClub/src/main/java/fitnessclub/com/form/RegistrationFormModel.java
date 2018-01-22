package fitnessclub.com.form;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RegistrationFormModel {
    @Size(min=5)
    @NotNull
    String username;
    @Size(min=5)
    @NotNull
    String name;
    @Size(min=5)
    @NotNull
    String surname;
    @Size(min=5)
    @NotNull
    String password;
    @Size(min=5)
    @NotNull
    String passwordConfirm;

    @Valid
    public boolean isPasswordMatch() {
        return password != null && password.equals(passwordConfirm);
    }
}
