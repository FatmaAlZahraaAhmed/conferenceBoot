package com.prularSight.Conference.conferenceBoot.controllers;

import com.prularSight.Conference.conferenceBoot.models.Session;
import com.prularSight.Conference.conferenceBoot.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list() {
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id) {
        return sessionRepository.getOne(id);
    }

    @PostMapping
    public Session creat(@RequestBody final Session session) {
        return sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(method = RequestMethod.DELETE ,value = "{id}")
    public void delete(@PathVariable Long id){
        //need to check for children delete
        sessionRepository.deleteById(id);
    }

    @RequestMapping (method =RequestMethod.PUT ,value = "{id}")
    public Session update(@PathVariable Long id , @RequestBody Session session){
        // we accept everything but the id
        //we're gonna to change it by id no need to update id
        Session existing_session = sessionRepository.getOne(id);
        //holding the session to update id
        // using BeanUtils to cope the upcoming session at existing session and ignore id
        BeanUtils.copyProperties(session,existing_session,"session_id");
        return sessionRepository.saveAndFlush(existing_session);
     }
}
