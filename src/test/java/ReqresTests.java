import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReqresTests {

  public static final String BASE_URI = "https://reqres.in/";

  @Test
  public void getListOfUsersTest() {
    given().
        baseUri(BASE_URI).
        when().
        get("/api/users?page=2").
        then().
        log().all().
        statusCode(200);
  }

  @Test
  public void getSingleUserTest() {
    int id = 2;
    given().
        baseUri(BASE_URI).
        when().
        get(String.format("/api/users/%d", id)).
        then().
        log().all().
        statusCode(200).
        assertThat().body("data.id", equalTo(4));
  }

  @Test
  public void createNewUserTest() {
    Gson gson = new Gson();

    User user = User.builder()
        .name("John Doe")
        .job("TESTER")
        .build();

    String response = given().
        baseUri(BASE_URI).
    when().
        body(user).
        post("api/users").                     
    then().
        log().all().
        statusCode(201).
        extract().asString();

    Assert.assertEquals(gson.fromJson(response, User.class), user);
  }
}