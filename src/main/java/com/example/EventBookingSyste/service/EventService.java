package com.example.EventBookingSyste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EventBookingSyste.Request.EventRequest;
import com.example.EventBookingSyste.model.Event;
import com.example.EventBookingSyste.repository.EventRepository;

@Service
public class EventService {


    @Autowired
     private EventRepository eventRepository;


    public Event addEvent(EventRequest eventRequest) {

        Event event = new Event();
        event.setName(eventRequest.getName());
        event.setDate(eventRequest.getDate());
        event.setLocation(eventRequest.getLocation());
        // Here you would typically save the event to a database and return the saved entity.

        // For this example, we'll just return the event object.
        event = eventRepository.save(event);
        return event;


        
        
    }
    
}
