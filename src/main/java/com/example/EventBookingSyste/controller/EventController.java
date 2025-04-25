package com.example.EventBookingSyste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EventBookingSyste.Request.EventRequest;
import com.example.EventBookingSyste.model.Event;
import com.example.EventBookingSyste.service.EventService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/events")
@Slf4j
public class EventController {


    @Autowired
    private EventService eventService;

    @PostMapping("/add")
    public ResponseEntity<Event> addEvent(@RequestBody EventRequest eventRequest){
        log.info("recieved a request to create event : "+eventRequest+ "By :"+eventRequest.getName());
        return ResponseEntity.ok().body(eventService.addEvent(eventRequest));
    }







    
}
