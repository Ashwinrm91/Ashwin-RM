package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import utils.TestUtils;

public class UserApiMethod {

	WebDriver driver;

	// Post API Call for Creating Single User
	@Given("^Creating a new user$")
	public Response CreateSingleUser() throws IOException {
		Properties prop = TestUtils.readPropertiesFile("Swagger.properties");
		final Response resp = given().headers("Accept", "application/json").headers("Content-Type", "application/json")
				.body("{\r\n"
						+ "  \"id\": 10,\r\n"
						+ "  \"username\": \"John\",\r\n"
						+ "  \"firstName\": \"John\",\r\n"
						+ "  \"lastName\": \"James\",\r\n"
						+ "  \"email\": \"john@email.com\",\r\n"
						+ "  \"password\": \"12345\",\r\n"
						+ "  \"phone\": \"12345\",\r\n"
						+ "  \"userStatus\": 1\r\n"
						+ "}")
				.when().post(prop.getProperty("URL") + "user").then().statusCode(200).extract().response();
		System.out.println("Response Body :" + resp.getBody().asString());
		System.out.println("StatusCode :" + resp.getStatusCode());
		Type type = new TypeToken<Map<String, Object>>() {}.getType();
		Map<String, Object> myMap = new Gson().fromJson(resp.getBody().asString(), type);
		Assert.assertEquals("Getting the ID of the user",(Double) 10.0, myMap.get("id"));
		Assert.assertEquals("Getting the username of the user", "John", myMap.get("username"));
		Assert.assertEquals("Getting the firstname of the user", "John", myMap.get("firstName"));
		Assert.assertEquals("Getting the lastname of the user","James", myMap.get("lastName"));
		Assert.assertEquals("Getting the email of the user", "john@email.com", myMap.get("email"));
		Assert.assertEquals("Getting the password of the user", "12345", myMap.get("password"));
		Assert.assertEquals("Getting the phone number of the user", "12345", myMap.get("phone"));
		Assert.assertEquals("Getting the user status", (Double) 1.0, myMap.get("userStatus"));
	
		for (Map.Entry<String, Object> entry : myMap.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			System.out.println("Key: " + key + ", value: " + value);
		}
		return resp;
	}
	
	// Post API Call for create list of users
	@Then("^Creating a list of user$")
	public Response CreateListOfUser() throws IOException {
		Properties prop = TestUtils.readPropertiesFile("Swagger.properties");
		final Response resp = given().headers("Accept", "application/json").headers("Content-Type", "application/json")
				.body("[\r\n"
						+ "  {\r\n"
						+ "    \"id\": 10,\r\n"
						+ "    \"username\": \"theUser10\",\r\n"
						+ "    \"firstName\": \"John\",\r\n"
						+ "    \"lastName\": \"James\",\r\n"
						+ "    \"email\": \"john@email.com\",\r\n"
						+ "    \"password\": \"12345\",\r\n"
						+ "    \"phone\": \"12345\",\r\n"
						+ "    \"userStatus\": 1\r\n"
						+ "  },\r\n"
						+ "  {\r\n"
						+ "    \"id\": 11,\r\n"
						+ "    \"username\": \"theUser11\",\r\n"
						+ "    \"firstName\": \"Kevin\",\r\n"
						+ "    \"lastName\": \"Smith\",\r\n"
						+ "    \"email\": \"jKevin@email.com\",\r\n"
						+ "    \"password\": \"12345\",\r\n"
						+ "    \"phone\": \"12345\",\r\n"
						+ "    \"userStatus\": 1\r\n"
						+ "  },\r\n"
						+ "  {\r\n"
						+ "    \"id\": 11,\r\n"
						+ "    \"username\": \"theUser12\",\r\n"
						+ "    \"firstName\": \"Chris\",\r\n"
						+ "    \"lastName\": \"Harris\",\r\n"
						+ "    \"email\": \"Chris@email.com\",\r\n"
						+ "    \"password\": \"12345\",\r\n"
						+ "    \"phone\": \"12345\",\r\n"
						+ "    \"userStatus\": 1\r\n"
						+ "  }\r\n"
						+ "]")
				.when().post(prop.getProperty("URL") + "user/createWithList").then().statusCode(200).extract().response();
		System.out.println("Response Body :" + resp.getBody().asString());
		System.out.println("StatusCode :" + resp.getStatusCode());
		return resp;
	}


	// Put API Call for updating the user details

	@Given("^Updating the existing details of \"([^\"]*)\"$")
	public Response UpdatesTheUser(String username) throws IOException {
		Properties prop = TestUtils.readPropertiesFile("Swagger.properties");
		final Response resp = given().headers("Accept", "application/json").headers("Content-Type", "application/json")
				.body("{\r\n"
						+ "  \"id\": 10,\r\n"
						+ "  \"username\": \"John\",\r\n"
						+ "  \"firstName\": \"John1\",\r\n"
						+ "  \"lastName\": \"James Adam\",\r\n"
						+ "  \"email\": \"john@emaill.com\",\r\n"
						+ "  \"password\": \"12345\",\r\n"
						+ "  \"phone\": \"12345\",\r\n"
						+ "  \"userStatus\": 1\r\n"
						+ "}")
				.when().put(prop.getProperty("URL") + "user/"+username).then().statusCode(200).extract().response();
		System.out.println("Response Body :" + resp.getBody().asString());
		System.out.println("StatusCode :" + resp.getStatusCode());
		return resp;
	}

	// Get API Call for Logging in

	@Given("^User login to the system by using username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public Response GetUserLogIn(String username, String password) throws IOException {
		Properties prop = TestUtils.readPropertiesFile("Swagger.properties");
			final Response resp = given().headers("Accept", "application/json")
					.headers("Content-Type", "application/json").body("").when()
					.get(prop.getProperty("URL") + "user/login?username="+ username + "&password=" + password).then().statusCode(200).extract()
					.response();
			System.out.println("Response Body :" + resp.getBody().asString());
			System.out.println("StatusCode :" + resp.getStatusCode());
			return resp;
		}

	// Get API Call for Get User
	@Then("^Getting the user detail of \"([^\"]*)\"$")
	public Response GetUser(String username) throws IOException {
		Properties prop = TestUtils.readPropertiesFile("Swagger.properties");
			final Response resp = given().headers("Accept", "application/json")
					.headers("Content-Type", "application/json").body("").when()
					.get(prop.getProperty("URL") + "user/" + username).then().statusCode(200)
					.extract().response();
			System.out.println("Response Body :" + resp.getBody().asString());
			System.out.println("StatusCode :" + resp.getStatusCode());
			return resp;
		} 
	// Get API Call for User Logout
	
	@Then("^User is logging out$")
	public Response GetUserLogout() throws IOException {
		Properties prop = TestUtils.readPropertiesFile("Swagger.properties");
			final Response resp = given().headers("Accept", "application/json")
					.headers("Content-Type", "application/json").body("").when()
					.get(prop.getProperty("URL") + "user/logout").then().statusCode(200).extract().response();
			System.out.println("Response Body :" + resp.getBody().asString());
			System.out.println("StatusCode :" + resp.getStatusCode());
			return resp;
		}

	// Delete API Call for deleting the user

	@Given("^Deleting the user \"([^\"]*)\"$")
	public Response DeleteUser(String username) throws IOException {
		Properties prop = TestUtils.readPropertiesFile("Swagger.properties");
			final Response resp = given().headers("Accept", "application/json")
					.headers("Content-Type", "application/json").body("").when()
					.delete(prop.getProperty("URL") + "user/" + username).then().statusCode(200)
					.extract().response();
			System.out.println("Response Body :" + resp.getBody().asString());
			System.out.println("StatusCode :" + resp.getStatusCode());
			return resp;
		} 
	
	@Given("^Validating whether user got deleted or not by getting the username$")
	public Response UserDeletedRequest() throws IOException {
		Properties prop = TestUtils.readPropertiesFile("Swagger.properties");
	final Response resp = given().headers("Accept", "application/json")
			.headers("Content-Type", "application/json").body("").when()
			.get(prop.getProperty("URL") + "user/john").then().statusCode(404)
			.extract().response();
	System.out.println("Response Body :" + resp.getBody().asString());
	System.out.println("StatusCode :" + resp.getStatusCode());
	return resp;
	}

}
