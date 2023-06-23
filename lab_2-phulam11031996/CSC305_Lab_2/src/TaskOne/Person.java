package TaskOne;

import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private List<String> knownFor = new ArrayList<>();
    private List<Award> awards = new ArrayList<>();

    Person(
            String name,
            List<String> knownFor,
            List<Award> awards) {
        this.name = name;
        this.knownFor = knownFor;
        this.awards = awards;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(this.name);
        result.append("\nKnown For:");
        for (String ele : this.knownFor) {
            result.append("\n\t" + ele);
        }
        result.append("\nAwards:");
        for (Award award : this.awards) {
            result.append("\n\t" + award.getName() + ", " + award.getYear());
        }
        result.append("\n");

        return result.toString();
    }

}
