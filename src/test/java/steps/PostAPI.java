package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import POJO.Post;
import utils.Helper;
import utils.Endpoints;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PostAPI {

    private Response response;

    @Given("the API is available")
    public void the_api_is_available() {
        response = Helper.getRequest(Endpoints.POSTS);
        assertThat("API is not available", response.getStatusCode(), is(200));
    }


    @When("I create a post with title {string}, body {string} and userId {int}")
    public void i_create_a_post(String title, String body, int userId) {
        Post post = new Post(title, body, userId);
        response = Helper.postRequest(Endpoints.POSTS, post);
    }

    @When("I retrieve all posts")
    public void i_retrieve_all_posts() {
        response = Helper.getRequest(Endpoints.POSTS);
    }

    @When("I retrieve the post with ID {int}")
    public void i_retrieve_post_by_id(int id) {

        response = Helper.getRequest(Endpoints.POSTS + "/" + id);
    }

    @Then("the response status should be {int}")
    public void the_response_status_should_be(int statusCode) {
        assertThat(response.getStatusCode(), equalTo(statusCode));
    }

    @Then("the response should contain title {string} and body {string}")
    public void the_response_should_contain_title_and_body(String title, String body) {
        assertThat(response.jsonPath().getString("title"), equalTo(title));
        assertThat(response.jsonPath().getString("body"), equalTo(body));
    }

    @Then("the total number of posts should be {int}")
    public void the_total_number_of_posts_should_be(int total) {
        assertThat(response.jsonPath().getList("$").size(), equalTo(total));
    }

    @Then("the response should contain ID {int}")
    public void the_response_should_contain_id(int id) {
        assertThat(response.jsonPath().getInt("id"), equalTo(id));
    }
}
