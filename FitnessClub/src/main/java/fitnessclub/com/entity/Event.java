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
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    LocalDate date;
    int time;
    @ManyToOne(cascade = CascadeType.MERGE)
    Room room;
    @ManyToOne()
    ActivitiesType activitiesType;

    public void setHour(int hour) {
        time = hour * 60 + getMinute();
    }

    public int getHour() {
      return time / 60;
    }

    public void setMinute(int minute) {
        time = getHour() + minute;
    };

    public int getMinute(){
        return time % 60;
    };

}
