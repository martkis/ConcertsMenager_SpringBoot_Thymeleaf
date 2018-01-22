package fitnessclub.com.service;

import fitnessclub.com.entity.ActivitiesType;
import fitnessclub.com.entity.Event;
import fitnessclub.com.entity.Room;
import fitnessclub.com.repository.ActivitiesTypeRepository;
import fitnessclub.com.repository.EventRepository;
import fitnessclub.com.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    void deleteEvent(Long id){

    }
    void saveEvent(Event event){

    }
    Page<Event> getAllEvents(Event event, Pageable pageable){
        return null;
    }
    Room getRoom(){
        return null;
    }
    ActivitiesType getActivitiesType(){
        return null;
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }
}
