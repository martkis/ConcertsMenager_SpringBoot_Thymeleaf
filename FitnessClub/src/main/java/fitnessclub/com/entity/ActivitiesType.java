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
    String soloistName;
    @ManyToMany(cascade = CascadeType.MERGE)
    List<User> users;

    public void addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
        }
    }

    public void removeUser(User user) {
        if (users.contains(user)) {
            users.remove(user);
        }
    }

    public String getSoloistName() {
        return soloistName;
    }

    public void setSoloistName(String soloistName) {
        this.soloistName = soloistName;
    }
}
