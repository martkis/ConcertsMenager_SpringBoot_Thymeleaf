package fitnessclub.com.init;

import fitnessclub.com.entity.*;
import fitnessclub.com.repository.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

@Component
@Profile("!production")
public class RepositoryInitializer2 implements InitializingBean {

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    ActivitiesTypeRepository activitiesTypeRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
       if(roomRepository.count() != 0 ||
               activitiesTypeRepository.count() != 0 ||
               userRepository.count() != 0 ||
               eventRepository.count() != 0) {
           return;
       }
        Room room = new Room();
        room.setNumberOfPlaces(30);
        room.setRoomNumber(1);
        roomRepository.save(room);

        Room room1 = new Room();
        room1.setNumberOfPlaces(30);
        room1.setRoomNumber(2);
        roomRepository.save(room1);

        Room room2 = new Room();
        room2.setNumberOfPlaces(30);
        room2.setRoomNumber(3);
        roomRepository.save(room2);

        Room room3 = new Room();
        room3.setNumberOfPlaces(30);
        room3.setRoomNumber(4);
        roomRepository.save(room3);

        Role roleUser = new Role();
        roleUser.setName("USER");
        roleRepository.save(roleUser);

        Role roleAdmin = new Role();
        roleAdmin.setName("ADMIN");
        roleRepository.save(roleAdmin);

        User user = new User();
        user.setName("Janina");
        user.setSurname("Kowalska");
        user.setUsername("janina_kowalska");
        user.setPassword(passwordEncoder.encode("passpass"));
        user.setRoles(Collections.singleton(roleUser));
        //user.setActivitiesTypes();
        userRepository.save(user);

        User user2 = new User();
        user2.setName("user");
        user2.setSurname("user");
        user2.setUsername("user");
        user2.setPassword(passwordEncoder.encode("user"));
        user2.setRoles(Collections.singleton(roleUser));
        //user.setActivitiesTypes();
        userRepository.save(user2);

        User user3 = new User();
        user3.setName("Admin");
        user3.setSurname("Admin");
        user3.setUsername("admin");
        user3.setPassword(passwordEncoder.encode("admin"));
        user3.setRoles(Collections.singleton(roleAdmin));
        //user.setActivitiesTypes();
        userRepository.save(user3);

        ActivitiesType activitiesType = new ActivitiesType();
        activitiesType.setCoachName("Kowalski Jan");
        activitiesType.setName("Zumba");
        activitiesType.setUsers(Arrays.asList(user, user2));
        activitiesTypeRepository.save(activitiesType);

        ActivitiesType activitiesType1 = new ActivitiesType();
        activitiesType1.setCoachName("Ivo Smirnoff");
        activitiesType1.setName("Aerobik");
        activitiesType1.setUsers(Arrays.asList(user2, user));
        activitiesTypeRepository.save(activitiesType1);

     ActivitiesType activitiesType2 = new ActivitiesType();
     activitiesType2.setCoachName("Agnieszka Mazurska");
     activitiesType2.setName("Pool Dance");
     activitiesType2.setUsers(Arrays.asList(user2, user));
     activitiesTypeRepository.save(activitiesType2);

        Event event = new Event();
        event.setActivitiesType(activitiesType);
        event.setRoom(room);
        event.setTime((15*60)+30);
        event.setDate(LocalDate.of(2018, 01, 28));
        eventRepository.save(event);

        Event event1 = new Event();
        event1.setActivitiesType(activitiesType1);
        event1.setRoom(room1);
        event1.setTime((17*60)+30);
        event1.setDate(LocalDate.of(2018, 01, 31));
        eventRepository.save(event1);

        Event event2 = new Event();
        event2.setActivitiesType(activitiesType1);
        event2.setRoom(room2);
        event2.setTime((15*60)+30);
        event2.setDate(LocalDate.of(2018, 01, 27));
        eventRepository.save(event2);

        Event event3 = new Event();
        event3.setActivitiesType(activitiesType);
        event3.setRoom(room3);
        event3.setTime((17*60)+30);
        event3.setDate(LocalDate.of(2018, 02, 28));
        eventRepository.save(event3);

        Event event4 = new Event();
        event4.setActivitiesType(activitiesType2);
        event4.setRoom(room);
        event4.setTime((17*60)+30);
        event4.setDate(LocalDate.of(2018, 02, 28));
        eventRepository.save(event4);

        Event event5 = new Event();
        event5.setActivitiesType(activitiesType2);
        event5.setRoom(room1);
        event5.setTime((15*60)+30);
        event5.setDate(LocalDate.of(2018, 02, 28));
        eventRepository.save(event5);
    }
}
