import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class JsonParserTest {

    private JsonParser jsonParser;

    @BeforeClass
    public void init() {
        this.jsonParser = new JsonParser();
    }

    @Test
    public void testContainChildCompanies() {
        Assert.assertTrue(checkCompanies(createValidChildCompany(), this.jsonParser.getChildCompanies()));
    }

    @Test
    public void testNotContainChildCompanies() {
        Assert.assertFalse(checkCompanies(createInvalidChildCompany(), this.jsonParser.getChildCompanies()));
    }

    private boolean checkCompanies(ChildCompany expected, List<ChildCompany> actual) {
        return actual.stream().anyMatch(childCompany -> childCompany.equals(expected));
    }

    private ChildCompany createValidChildCompany() {
        return new ChildCompany("Amazon", "Amazon Address", "LA", "123456");
    }

    private ChildCompany createInvalidChildCompany() {
        return new ChildCompany("Microsoft", "Microsoft Address", "LA", "1234236");
    }
}
