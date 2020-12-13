package parser;

import model.ChildCompany;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class JsonParserTest {

    @Test
    public void testContainChildCompanies() {
        ChildCompany childCompany = new ChildCompany("Amazon", "Amazon Address", "LA", "123456");
        Assert.assertTrue(checkCompanies(childCompany, JsonParser.getChildCompanies()));
    }

    @Test
    public void testNotContainChildCompanies() {
        ChildCompany childCompany = new ChildCompany("Microsoft", "Microsoft Address", "LA", "1234236");
        Assert.assertFalse(checkCompanies(childCompany, JsonParser.getChildCompanies()));
    }

    private boolean checkCompanies(ChildCompany expected, List<ChildCompany> actual) {
        return actual.stream().anyMatch(childCompany -> childCompany.equals(expected));
    }
}
