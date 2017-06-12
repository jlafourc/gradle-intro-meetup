package com.example.meetup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class MeetupService {

    @Autowired
    private MeetupRepository meetupRepository;

    public Meetup save(String name) {
        Meetup meetup = new Meetup();
        meetup.setTitre(name);
        return meetupRepository.save(meetup);
    }

    public Meetup getById(BigInteger id) {
        return meetupRepository.findOne(id);
    }

}
