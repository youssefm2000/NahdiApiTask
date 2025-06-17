package steps;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import POJO.Post;
import utils.Helper;
import utils.Endpoints;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import io.qameta.allure.*;

public class PostAPI {

    private Response response;

    /**
     * Step to check if the API is reachable and responding with HTTP 200.
     */
    @Epic("PostAPI")
    @Feature("check if the API is reachable")
    @Story("GET /posts")
    @Severity(SeverityLevel.NORMAL)
    @Description("check if the API is reachable and responding with HTTP 200")
    @Given("the API is available")
    public void checkApiIsAvailable() {
        response = Helper.getRequest(Endpoints.POSTS);
        assertThat("API is not available", response.getStatusCode(), is(200));
    }

    /**
     * Step to create a new post by sending a POST request with a JSON body.
     */
    @Epic("PostAPI")
    @Feature("create a new post")
    @Story("POST /posts")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test create a new post via the POST endpoint")
    @When("I create a post with title {string}, body {string} and userId {int}")
    public void createPost(String title, String body, int userId) {
        Post post = new Post(title, body, userId);
        response = Helper.postRequest(Endpoints.POSTS, post);
    }

    /**
     * Step to retrieve all posts from the API.
     */
    @Epic("PostAPI")
    @Feature("retrieve all posts")
    @Story("GET /posts")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test retrieve all posts via the GET endpoint")
    @When("I retrieve all posts")
    public void retrieveAllPosts() {
        response = Helper.getRequest(Endpoints.POSTS);
    }

    /**
     * Step to retrieve a specific post by its ID.
     */
    @Epic("PostAPI")
    @Feature("retrieve a specific post")
    @Story("GET /posts/ID")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test retrieve retrieve a specific post by its ID via the GET endpoint")
    @When("I retrieve the post with ID {int}")
    public void retrievePostById(int id) {
        response = Helper.getRequest(Endpoints.POSTS + "/" + id);
    }

    /**
     * Step to validate that the response status code matches the expected one.
     */
    @Epic("PostAPI")
    @Feature("Asserts actual status code matches expected")
    @Story("Asssertion For All Status Code")
    @Severity(SeverityLevel.NORMAL)
    @Description("validate that the response status code matches the expected one")
    @Then("the response status should be {int}")
    public void validateResponseStatus(int statusCode) {
        assertThat(response.getStatusCode(), equalTo(statusCode));
    }

    /**
     * Step to verify that the response contains specific title and body values.
     */
    @Epic("PostAPI")
    @Feature("Asserts response contains specific title and body values")
    @Story("Asssertion For Title and Body")
    @Severity(SeverityLevel.NORMAL)
    @Description("verify that the response contains specific title and body values")
    @Then("the response should contain title {string} and body {string}")
    public void verifyResponseTitle(String title, String body) {
        assertThat(response.jsonPath().getString("title"), equalTo(title));
        assertThat(response.jsonPath().getString("body"), equalTo(body));
    }

    /**
     * Step to verify the total number of posts returned by the API.
     */
    @Epic("PostAPI")
    @Feature("Asserts The Total API Number")
    @Story("Asssertion For total number of posts returned by the API")
    @Severity(SeverityLevel.NORMAL)
    @Description("verify the total number of posts returned by the API")
    @Then("the total number of posts should be {int}")
    public void verifyNumOfPosts(int total) {
        assertThat(response.jsonPath().getList("$").size(), equalTo(total));
    }

    /**
     * Step to ensure the response contains the expected post ID.
     */
    @Epic("PostAPI")
    @Feature("Asserts response ID")
    @Story("Asssertion For the response contains the expected post ID ")
    @Severity(SeverityLevel.NORMAL)
    @Description("verify the response contains the expected post ID")
    @Then("the response should contain ID {int}")
    public void assertResponseId(int id) {
        assertThat(response.jsonPath().getInt("id"), equalTo(id));
    }
}
