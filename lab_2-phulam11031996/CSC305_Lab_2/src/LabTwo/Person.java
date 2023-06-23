package LabTwo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class Person {
    private String name;
    private List<String> knownFor = new ArrayList<String>();
    private List<Award> awards = new ArrayList<Award>();

    @JsonCreator
    private Person(@JsonProperty("name") String name,
            @JsonProperty("knownFor") List<String> knownFor,
            @JsonProperty("awards") List<Award> awards
            ) {
        this.name = name;
        this.knownFor = knownFor;
        this.awards = awards;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.name);
        result.append("\n\tKnown For:");
        for (String ele : this.knownFor)
            result.append("\n\t" + ele);

        result.append("\n\tAwards:");
        for (Award ele : this.awards){
            result.append("\n\t" + ele.toString());
        }

        return result.toString();
    }

}
