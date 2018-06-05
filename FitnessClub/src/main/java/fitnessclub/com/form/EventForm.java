package fitnessclub.com.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EventForm {

    int hour;

    int minute;
    @NotNull
    int room;
    @NotNull
    float cost;
    @NotNull
    String status;
    @NotNull
    String contractor;
    @NotNull
    String activitiesName;
    @NotNull
    String soloistName;
}
