package com.learn.event.controller;

import com.learn.event.model.EventBook;
import com.learn.event.repository.EventBookRepository;
import com.learn.event.service.EventBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("eventbook/api/v1")
public class EventBookController {
    @Autowired
    private EventBookService eventBookService;

    @GetMapping("/all")
    public List<EventBook> getAllMyEvents(){
        return this.eventBookService.getAllEvents();
    }


    @PostMapping("/addevent")
    public EventBook addNewEvent(@RequestBody EventBook eventBook){
        return this.eventBookService.addEventData(eventBook);

    }

    @PutMapping("/update/{id}")
    public EventBook updateEventData( @PathVariable Integer id,@RequestBody EventBook eventBook){
        return this.eventBookService.updateEvent(id,eventBook);
    }

    @DeleteMapping("/delete/{eventid}")
    public void deleteEventData(@PathVariable Integer eventid){
        this.eventBookService.deleteEvent(eventid);
    }

    @GetMapping("/event/{eventId}")
    public EventBook getEvent(@PathVariable Integer eventId){
        return this.eventBookService.getSpecificEvent(eventId);
    }


    //partial data update

    @PatchMapping("/partialupdate/{id}")
    public String partialupdate( @PathVariable Integer id,@RequestBody String location){
        return this.eventBookService.partialupdateData(id,location);
    }



}
