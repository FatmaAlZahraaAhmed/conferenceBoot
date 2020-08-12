package com.prularSight.Conference.conferenceBoot.controllers;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.prularSight.Conference.conferenceBoot.models.Speaker;
import com.prularSight.Conference.conferenceBoot.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/speakers")
public class SpeakerController {

    @Autowired
    private SpeakerRepository speakerRepository;

    //return all
    @GetMapping
    public List<Speaker> list(){
        return speakerRepository.findAll();
    }

    //get by id
    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id){
        return speakerRepository.getOne(id);
    }

    //delete by id
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id ){
        speakerRepository.deleteById(id);
    }

    //update
    @PostMapping
    public Speaker create(@PathVariable final Speaker speaker){
        return speakerRepository.saveAndFlush(speaker);
    }

    //update
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id ,@RequestBody Speaker speaker){
        Speaker existing_speaker = speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker,existing_speaker,"speaker_id");
        return speakerRepository.saveAndFlush(existing_speaker);
    }
}
