package com.example.GraduationBackend.services.Event;

import com.example.GraduationBackend.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventService implements IEvent{

    private final EventRepository eventRepository;

}
