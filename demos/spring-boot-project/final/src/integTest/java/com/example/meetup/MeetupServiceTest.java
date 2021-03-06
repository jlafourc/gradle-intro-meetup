package com.example.meetup;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeetupServiceTest {
    @Autowired
    MeetupService meetupService;

    @Test
    public void testMeetupSave() {
        Meetup savedMeetup = meetupService.save("Venir découvrir Gradle");
        assertEquals("Venir découvrir Gradle", meetupService.getById(savedMeetup.getId()).getTitre());
    }
}
