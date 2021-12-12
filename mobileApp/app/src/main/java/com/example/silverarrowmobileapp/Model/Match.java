package com.example.silverarrowmobileapp.Model;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private final float matchPersent;
    private final List<String> locations;

    public Match(List<String> locations, List<String> userLocations) {
        this.locations = locations;

        List<String> matchedLocations = new ArrayList<String>();
        int arrayLenght = Math.min(locations.size(), userLocations.size());
        System.out.println(locations);
        System.out.println(userLocations);
        for (int i = 0; i < locations.size(); i++) {
            if (userLocations.contains(locations.get(i)))
                matchedLocations.add(locations.get(i));
        }
        matchPersent = (matchedLocations.size() * 1.0f / arrayLenght)*100;
        System.out.println(arrayLenght);
        System.out.println(matchedLocations.size());
    }

    public float getMatchPersent() {
        return matchPersent;
    }

    public List<String> getLocations() {
        return locations;
    }
}
