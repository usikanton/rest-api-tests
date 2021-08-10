package qase.services;

import static io.restassured.RestAssured.given;

import com.google.gson.Gson;
import io.restassured.http.ContentType;

public class BaseService {

  protected static final String BASE_URI = "https://api.qase.io/v1/";
  public static final String TOKEN = "cb32d9e2a156ddf83660dc641dc8074fd5aa247e";
  Gson gson = new Gson();

  public String post(String URL, String body, int statusCode) {
    return given().
        baseUri(BASE_URI).
        header("Token", TOKEN).
        header("Content-Type", ContentType.JSON).
    when().
        log().all().
        body(body).
        post(URL).
    then().
        log().all().
        statusCode(statusCode).
        extract().body().asString();
  }

  public void get() {

  }

  public void getAll() {

  }

  public void put() {

  }

  public void delete() {

  }

}