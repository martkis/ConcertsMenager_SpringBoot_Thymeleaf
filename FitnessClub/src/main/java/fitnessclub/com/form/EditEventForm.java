package fitnessclub.com.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EditEventForm {
    @NotNull
    String status;
}
