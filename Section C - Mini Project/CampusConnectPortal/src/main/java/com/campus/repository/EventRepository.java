package com.campus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.campus.model.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

}