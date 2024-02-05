package com.learn.event.service;

import com.learn.event.model.EventBook;
import com.learn.event.repository.EventBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventBookService {
    @Autowired
    private EventBookRepository eventBookRepository;

    //addEventData
    public EventBook addEventData(EventBook eventBook){
        return this.eventBookRepository.save(eventBook);

    }


    //get event data
    public List<EventBook> getAllEvents(){
        return this.eventBookRepository.findAll();
    }


    //update event data
    public EventBook updateEvent(Integer id,EventBook newEventData){
        EventBook oldEventData=this.eventBookRepository.findById(id).get();
        oldEventData.setEventName(newEventData.getEventName());
        oldEventData.setEventLocation(newEventData.getEventLocation());
        oldEventData.setNoOfGuests(newEventData.getNoOfGuests());
        this.eventBookRepository.save(oldEventData);
        return oldEventData;
    }


    //delete eventdata
    public void deleteEvent(Integer id){
        this.eventBookRepository.deleteById(id);
    }


    //get specific eventid

    public EventBook getSpecificEvent(Integer eventId){
        EventBook selectedEvent=this.eventBookRepository.findById(eventId).get();
        return selectedEvent;

    }

    //partial data update
    public String partialupdateData(Integer id,String location){
        EventBook oldEvent=this.eventBookRepository.findById(id).get();
        oldEvent.setEventName(location);
        this.eventBookRepository.save(oldEvent);
        return "Partially Updated the Data";
    }
}
