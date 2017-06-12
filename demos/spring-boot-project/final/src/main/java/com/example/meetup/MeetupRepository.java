package com.example.meetup;


import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface MeetupRepository extends CrudRepository<Meetup, BigInteger> {
}
