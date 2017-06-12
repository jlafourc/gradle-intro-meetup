package org.meetup.lib;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class NameNormalizerTest {

    private NameNormalizer nameNormalizer;

    @Before
    public void setUp() {
        nameNormalizer = new NameNormalizer();
    }

    @Test
    public void testUnMot() {
        String mot = "meetup";
        assertEquals("Meetup", nameNormalizer.normalize(mot));
    }

    @Test
    public void testUnePhrase() {
        String phrase = "gradle meetup";
        assertEquals("Gradle Meetup", nameNormalizer.normalize(phrase));
    }

}
