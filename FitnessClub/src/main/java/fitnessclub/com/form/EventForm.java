package fitnessclub.com.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EventForm {
    @NotNull
    int hour;
    @NotNull
    int minute;
    @NotNull
    int room;
    @NotNull
    String coachName;
    @NotNull
    String activitiesName;

}
