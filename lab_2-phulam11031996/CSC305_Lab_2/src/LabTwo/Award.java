package LabTwo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

final class Award {

    private String name;
    private int year;

    @JsonCreator
    private Award(@JsonProperty("name") String name,
            @JsonProperty("year") int year) {
        this.name = name;
        this.year = year;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.name + ", " + this.year);
        return result.toString();
    }

}