package com.example.silverarrowmobileapp.Model;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private final float matchPersent;
    private final List<String> locations;

    public Match(List<String> locations, List<String> userLocations) {
        this.locations = locations;

        List<String> matchedLocations = new ArrayList<String>();
        int arrayLenght = Math.max(locations.size(), userLocations.size());
        for (int i = 0; i < locations.size(); i++) {
            if (userLocations.contains(locations.get(i)))
                matchedLocations.add(locations.get(i));
        }
        matchPersent = Float.intBitsToFloat(matchedLocations.size() / arrayLenght);

    }

    public float getMatchPersent() {
        return matchPersent;
    }

    public List<String> getLocations() {
        return locations;
    }
}
