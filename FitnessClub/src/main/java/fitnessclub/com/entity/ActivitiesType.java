package fitnessclub.com.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ActivitiesType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String coachName;
    @ManyToMany(mappedBy = "activitiesTypes", cascade = CascadeType.MERGE)
    List<User> users;
}
