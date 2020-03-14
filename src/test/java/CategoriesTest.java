import helpers.HttpClientFactory;
import helpers.JsonManager;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.UnirestInstance;
import kong.unirest.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(JUnit4.class)
public class CategoriesTest {


    @Test
    public void createCategoryTest() {

        UUID id = UUID.randomUUID();
        String name = "TestCategory";

        UnirestInstance httpClient = HttpClientFactory.getHttpClient();
        JSONObject jsonCategory = JsonManager.getCategoryJson(id.toString(), name);

        HttpResponse<JsonNode> postResponse = httpClient.post("http://localhost:3030/categories").body(jsonCategory).asJson();
        assertThat(postResponse.isSuccess(), equalTo(true));
        HttpResponse<JsonNode> getResponse = httpClient.get("http://localhost:3030/categories/" + id).asJson();

        assertThat(getResponse.getBody().getObject().get("name"), equalTo(name));

    }

}
