package TaskOne;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class OrgParseJSON {

    private List<Person> people = new ArrayList<>();

    public void readFile(String fileName) throws FileNotFoundException, JSONException {
        InputStream jsonData = new FileInputStream(fileName);

        JSONTokener tokener = new JSONTokener(jsonData);
        JSONObject object = new JSONObject(tokener);

        String name = object.getString("name");

        JSONArray jsonknownFor = object.getJSONArray("knownFor");
        List<String> knownFor = new ArrayList<>();
        for (int i = 0; i < jsonknownFor.length(); i++) {
            knownFor.add(jsonknownFor.get(i).toString());
        }

        JSONArray jsonAwards = object.getJSONArray("awards");
        List<Award> awards = new ArrayList<>();

        for (int i = 0; i < jsonAwards.length(); i++) {
            String awardName = jsonAwards.getJSONObject(i).getString("name");
            int awardYear = jsonAwards.getJSONObject(i).getInt("year");
            awards.add(new Award(awardName, awardYear));
        }

        people.add(new Person(name, knownFor, awards));
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Person person : this.people)
            result.append(person.toString());

        return result.toString();
    }

}
