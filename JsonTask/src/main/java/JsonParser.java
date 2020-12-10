import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public List<ChildCompany> getChildCompanies() {
        JSONObject json = readJson();

        if (json == null) {
            return new ArrayList<>();
        }
        JSONObject childCompanies = (JSONObject) ((JSONObject) json.get("manufacturers")).get("childCompanies");

        List<ChildCompany> companies = new ArrayList<>();

        for (Object key : childCompanies.keySet()) {
            companies.add(
                    getChildCompanyByName(childCompanies, key.toString())
            );
        }

        return companies;
    }

    private JSONObject readJson() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("JsonTask")) {
            return (JSONObject) jsonParser.parse(reader);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ChildCompany getChildCompanyByName(JSONObject childCompanies, String name) {
        JSONObject companyObject = (JSONObject) childCompanies.get(name);
        return new ChildCompany(
                name,
                companyObject.get("address").toString(),
                companyObject.get("state").toString(),
                companyObject.get("phone").toString()
        );
    }
}
