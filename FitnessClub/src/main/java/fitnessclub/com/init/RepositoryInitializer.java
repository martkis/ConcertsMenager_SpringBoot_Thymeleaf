package fitnessclub.com.init;

import fitnessclub.com.entity.*;
import fitnessclub.com.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Component
public class RepositoryInitializer {

    ActivitiesTypeRepository activitiesTypeRepository;
    EventRepository eventRepository;
    RoleRepository roleRepository;
    RoomRepository roomRepository;
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    public RepositoryInitializer(
    EventRepository eventRepository,
    ActivitiesTypeRepository activitiesTypeRepository,
    RoleRepository roleRepository,
    RoomRepository roomRepository,
    UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.activitiesTypeRepository = activitiesTypeRepository;
        this.roleRepository = roleRepository;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;

    }
    {

        Role role = new Role();
        role.setName("USER");
        Role role1 = new Role();
        role1.setName("ADMIN");
        List<User> users = new ArrayList<User>();

        for(int i = 0; i < 5; i++){
            ActivitiesType activitiesType = new ActivitiesType();
            activitiesType.setName("Zajecia "+ i);
            activitiesType.setCoachName("Instruktor"+i);

            Room room = new Room();
            room.setRoomNumber(i+1);
            room.setNumberOfPlaces(20);

            Event event = new Event();
            event.setDate(LocalDate.of(2018, 1, 19));
            event.setTime(12+i);
            event.setActivitiesType(activitiesType);
            event.setRoom(room);

            for(int j = 0; j < 2; j++) {
                User user = new User();
                user.setName("User" + i + "-" + j);
                user.setPassword(encoder.encode("user" + i + "" + j));
                user.setSurname("Kowalski" + i + "" + j);
                user.setUsername("user" + i + "" + j);
                user.setRoles(new HashSet<>(Arrays.asList(role)));
                users.add(user);
                activitiesType.setUsers(users);
            }

        }
        User user1 = new User();
        user1.setName("Admin");
        user1.setPassword(encoder.encode("Admin"));
        user1.setSurname("Admin");
        user1.setUsername("Admin");
    }


}
