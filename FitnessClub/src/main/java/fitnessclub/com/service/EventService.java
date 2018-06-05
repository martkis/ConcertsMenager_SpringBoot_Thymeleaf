package fitnessclub.com.service;

import fitnessclub.com.entity.ActivitiesType;
import fitnessclub.com.entity.Event;
import fitnessclub.com.entity.Room;
import fitnessclub.com.entity.User;
import fitnessclub.com.form.AssignUserForm;
import fitnessclub.com.form.EditEventForm;
import fitnessclub.com.form.EventForm;
import fitnessclub.com.repository.ActivitiesTypeRepository;
import fitnessclub.com.repository.EventRepository;
import fitnessclub.com.repository.RoomRepository;
import fitnessclub.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    ActivitiesTypeRepository activitiesTypeRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    UserRepository userRepository;


    void deleteEvent(Long id) {
    }

    void saveEvent(Event event) {
    }


    Page<Event> getAllEvents(Event event, Pageable pageable) {
        return null;
    }

    Room getRoom() {
        return null;
    }

    ActivitiesType getActivitiesType() {
        return null;
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event save(EventForm form) {

        ActivitiesType activitiesType = new ActivitiesType();
        // activitiesType.setSoloistName(form.getCoachName());
        activitiesType.setName(form.getActivitiesName());
        activitiesTypeRepository.save(activitiesType);

        Room room = new Room();
        room.setRoomNumber(form.getRoom());
        room.setNumberOfPlaces(150);
        roomRepository.save(room);

        Event event = new Event();
        event.setContractor(form.getContractor());
        event.setCost(form.getCost());
        event.setStatus(form.getStatus());
        event.setHour(form.getHour());
        event.setMinute(form.getHour());
        event.setActivitiesType(activitiesType);
        event.setRoom(room);
        eventRepository.save(event);

        return event;
    }

    public void assignUser(AssignUserForm userCommand) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);
        ActivitiesType activityType = activitiesTypeRepository.findOne(userCommand.getActivityType());
        activityType.addUser(user);
        activitiesTypeRepository.save(activityType);
    }

    public void update(EditEventForm formData, Event entity) {
        entity.setStatus(formData.getStatus());
        eventRepository.save(entity);
    }

    public void delete(Event entity) {
        eventRepository.delete(entity);
    }
}
