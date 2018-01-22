package fitnessclub.com.service;

import fitnessclub.com.entity.Room;
import fitnessclub.com.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public Room save(Room s) {
        return roomRepository.save(s);
    }

    public void delete(Room room) {
        roomRepository.delete(room);
    }
}
