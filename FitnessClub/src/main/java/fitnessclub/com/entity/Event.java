package fitnessclub.com.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate date;
    int time;
    float cost; // koszt zagrania koncertu
    String contractor; // kontrachent - strona transakcji
    String status; // status - 1.planowany, 2.umowiony, 3.zagrany, 4.zagrany i zaplacony
    @ManyToOne(cascade = CascadeType.MERGE)
    Room room; // miejsce
    @ManyToOne()
    ActivitiesType activitiesType;

    public void setHour(int hour) {
        time = hour * 60 + getMinute();
    }

    public int getHour() {
        return time / 60;
    }

    public void setMinute(int minute) {
        time = getHour() * 60 + minute;
    }

    ;

    public int getMinute() {
        return time % 60;
    }

    ;

}
