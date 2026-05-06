package com.campus.service;

import java.util.List;
import com.campus.model.Event;

public interface EventService {

    void saveEvent(Event event);

    List<Event> getAllEvents();
}