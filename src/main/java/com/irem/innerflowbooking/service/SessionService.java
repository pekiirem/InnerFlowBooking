package com.irem.innerflowbooking.service;

import com.irem.innerflowbooking.entity.Session;
import com.irem.innerflowbooking.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAllByOrderByIdAsc();
    }

    public Session saveSession(Session session) {
        return sessionRepository.save(session);
    }
    /**bu kısım kont sayı dusurmek ıcın*/
    public Session getSessionById(Long id) {
        return sessionRepository.findById(id).orElse(null);
    }
    public Session updateSession(Session session) {
        return sessionRepository.save(session);
    }
}
