package org.meetup.lib;


import org.apache.commons.lang3.text.WordUtils;

public class NameNormalizer {

    public String normalize(String name) {
        return WordUtils.capitalize(name);
    }



}
