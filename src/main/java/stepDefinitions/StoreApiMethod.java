package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cucumber.api.java.en.Given;
import io.restassured.response.Response;
import junit.framework.Assert;
import utils.TestUtils;

public class StoreApiMethod {
	WebDriver driver;

	// Post API Call
	@SuppressWarnings("deprecation")
	@Given("^User Posts the new details for Store$")
	public Response PostRequest() throws IOException {
		Properties prop = TestUtils.readPropertiesFile("Swagger.properties");
		final Response resp = given().headers("Accept", "application/json").headers("Content-Type", "application/json")
				.body("{\r\n"
						+ "  \"id\": 10,\r\n"
						+ "  \"petId\": 198772,\r\n"
						+ "  \"quantity\": 7,\r\n"
						+ "  \"shipDate\": \"2022-03-25T11:11:01.521Z\",\r\n"
						+ "  \"status\": \"approved\",\r\n"
						+ "  \"complete\": true\r\n"
						+ "}")
				.when().post(prop.getProperty("URL") + "store/order").then().statusCode(200).extract().response();
		System.out.println("Response Body :" + resp.getBody().asString());
		System.out.println("StatusCode :" + resp.getStatusCode());
		Type type = new TypeToken<Map<String, Object>>() {}.getType();
		Map<String, Object> myMap = new Gson().fromJson(resp.getBody().asString(), type);
		
		//Validating Response against Request
		
		Assert.assertEquals("Getting the Order ID",(Double) 10.0, myMap.get("id"));
		Assert.assertEquals("Getting the Pet ID",(Double) 198772.0, myMap.get("petId"));
		Assert.assertEquals("Getting the Quantity",(Double) 7.0, myMap.get("quantity"));
		Assert.assertEquals("Getting the status of the order","approved", myMap.get("status"));
		Assert.assertEquals("Getting the status of the order",true, myMap.get("complete"));
		System.out.println("Validating whether the posted details are coming in response");
		
		for (Map.Entry<String, Object> entry : myMap.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			System.out.println("Key: " + key + ", value: " + value);
		}
		return resp;
	}

	// Get API Calls for Getby order ID

	@Given("^User gets the Store details by order id \"([^\"]*)\"$")
	public Response GetByOrderID(String ID) throws IOException {
		Properties prop = TestUtils.readPropertiesFile("Swagger.properties");
			final Response resp = given().headers("Accept", "application/json")
					.headers("Content-Type", "application/json").body("").when()
					.get(prop.getProperty("URL") + "store/order/" + ID).then().statusCode(200).extract()
					.response();
			System.out.println("Response Body :" + resp.getBody().asString());
			System.out.println("StatusCode :" + resp.getStatusCode());
			return resp;
		}
	//Get API Calls for Getby status

	@Given("^User gets the inventory details by status$")
	public Response GetInvertorybyStatus() throws IOException {
		Properties prop = TestUtils.readPropertiesFile("Swagger.properties");
			final Response resp = given().headers("Accept", "application/json")
					.headers("Content-Type", "application/json").body("").when()
					.get(prop.getProperty("URL") + "store/inventory").then().statusCode(200)
					.extract().response();
			System.out.println("Response Body :" + resp.getBody().asString());
			System.out.println("StatusCode :" + resp.getStatusCode());
			return resp;
	}

	// Delete API Call

	@SuppressWarnings("deprecation")
	@Given("^User deletes the Order ID \"([^\"]*)\"$")
	public Response DeleteRequest(String ID) throws IOException {
		Properties prop = TestUtils.readPropertiesFile("Swagger.properties");
		final Response resp = given().headers("Accept", "application/json").headers("Content-Type", "application/json")
				.body("").when().delete(prop.getProperty("URL") + "store/order/" + ID).then().statusCode(200).extract()
				.response();
		System.out.println("Response Body :" + resp.getBody().asString());
		System.out.println("StatusCode :" + resp.getStatusCode());
		return resp;
	}
	
	@Given("^User validates whether order details deleted or not by getting the order id$")
	public Response GetDeletedRequest() throws IOException {
		Properties prop = TestUtils.readPropertiesFile("Swagger.properties");
	final Response resp = given().headers("Accept", "application/json")
			.headers("Content-Type", "application/json").body("").when()
			.get(prop.getProperty("URL") + "store/order/10").then().statusCode(404)
			.extract().response();
	System.out.println("Response Body :" + resp.getBody().asString());
	System.out.println("StatusCode :" + resp.getStatusCode());
	return resp;
	}

}
