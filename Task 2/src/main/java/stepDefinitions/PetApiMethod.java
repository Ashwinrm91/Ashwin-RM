package stepDefinitions;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static io.restassured.RestAssured.given;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.TestUtils;

public class PetApiMethod {
	WebDriver driver;

	static Logger logger = Logger.getLogger(PetApiMethod.class);
	
	// Post API Call
	@Given("^User Posts the new details for Pet$")
	public Response PostRequest() throws IOException {
		Properties prop = TestUtils.readPropertiesFile("Swagger.properties");
		final Response resp = given().headers("Accept", "application/json").headers("Content-Type", "application/json")
				.body("{\r\n" + "  \"id\": 10,\r\n" + "  \"name\": \"doggie\",\r\n" + "  \"category\": {\r\n"
						+ "    \"id\": 1,\r\n" + "    \"name\": \"Dogs\"\r\n" + "  },\r\n" + "  \"photoUrls\": [\r\n"
						+ "    \"string\"\r\n" + "  ],\r\n" + "  \"tags\": [\r\n" + "    {\r\n" + "      \"id\": 0,\r\n"
						+ "      \"name\": \"Mark\"\r\n" + "    }\r\n" + "  ],\r\n"
						+ "  \"status\": \"available\"\r\n" + "}")
				.when().post(prop.getProperty("URL") + "pet").then().statusCode(200).extract().response();
		System.out.println(resp.getStatusCode());
		System.out.println("response: " + resp.getBody().asString());
		Type type = new TypeToken<Map<String, Object>>() {}.getType();
		Map<String, Object> myMap = new Gson().fromJson(resp.getBody().asString(), type);
		Assert.assertEquals("Getting the ID of the pet",(Double) 10.0, myMap.get("id"));
		Assert.assertEquals("Getting the name of the pet", "doggie", myMap.get("name"));
		Assert.assertEquals("Getting the status of the pet", "available", myMap.get("status"));
		List<Map<String, Object>> tags = (List<Map<String, Object>>) myMap.get("tags");
		for (Map<String, Object> tag : tags) {
			Assert.assertEquals((Double) 0.0, tag.get("id"));
			Assert.assertEquals("Mark", tag.get("name"));
		}
		for (Map.Entry<String, Object> entry : myMap.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			System.out.println("Key: " + key + ", value: " + value);
		}
		
		return resp;
	}

	// Put API Call

	@Given("^User updates the existing details for Pet$")
	public Response PutRequest() throws IOException {
		Properties prop = TestUtils.readPropertiesFile("Swagger.properties");
		final Response resp = given().headers("Accept", "application/json").headers("Content-Type", "application/json")
				.body("{\r\n" + "  \"id\": 12,\r\n" + "  \"name\": \"doggie\",\r\n" + "  \"category\": {\r\n"
						+ "    \"id\": 1,\r\n" + "    \"name\": \"Dogs\"\r\n" + "  },\r\n" + "  \"photoUrls\": [\r\n"
						+ "    \"string\"\r\n" + "  ],\r\n" + "  \"tags\": [\r\n" + "    {\r\n" + "      \"id\": 0,\r\n"
						+ "      \"name\": \"string\"\r\n" + "    }\r\n" + "  ],\r\n"
						+ "  \"status\": \"available\"\r\n" + "}")
				.when().put(prop.getProperty("URL") + "pet").then().statusCode(200).extract().response();
		//System.out.println("Response Body :" + resp.getBody().asString());
		//System.out.println("StatusCode :" + resp.getStatusCode());
		logger.info(resp.getStatusCode()+ "***************");
		
		return resp;
	}

	// Get API Call

	@Given("^User gets the pet details by \"([^\"]*)\"$")
	public Response GetRequest(String Value) throws IOException {
		Properties prop = TestUtils.readPropertiesFile("Swagger.properties");
		if (Value.equalsIgnoreCase("Mark")) {
			final Response resp = given().headers("Accept", "application/json")
					.headers("Content-Type", "application/json").body("").when()
					.get(prop.getProperty("URL") + "pet/findByTags?tags=" + Value).then().statusCode(200).extract()
					.response();
			System.out.println("Response Body :" + resp.getBody().asString());
			System.out.println("StatusCode :" + resp.getStatusCode());
			return resp;
		}

		else if (Value.equalsIgnoreCase("available") || Value.equalsIgnoreCase("pending") || Value.equalsIgnoreCase("sold")) {
			final Response resp = given().headers("Accept", "application/json")
					.headers("Content-Type", "application/json").body("").when()
					.get(prop.getProperty("URL") + "pet/findByStatus?status=" + Value).then().statusCode(200)
					.extract().response();
			System.out.println("Response Body :" + resp.getBody().asString());
			System.out.println("StatusCode :" + resp.getStatusCode());
			System.out.println(resp);
			return resp;
		} else {
			final Response resp = given().headers("Accept", "application/json")
					.headers("Content-Type", "application/json").body("").when()
					.get(prop.getProperty("URL") + "pet/" + Value).then().statusCode(200).extract().response();
			System.out.println("Response Body :" + resp.getBody().asString());
			System.out.println("StatusCode :" + resp.getStatusCode());
			return resp;
		}
	}

	// Delete API Call

	@Given("^User deletes the Pet ID \"([^\"]*)\"$")
	public Response DeleteRequest(String URL) throws IOException {
		Properties prop = TestUtils.readPropertiesFile("Swagger.properties");
		final Response resp = given().headers("Accept", "application/json").headers("Content-Type", "application/json")
				.body("").when().delete(prop.getProperty("URL") + "pet/" + URL).then().statusCode(200).extract()
				.response();
		System.out.println("Response Body :" + resp.getBody().asString());
		System.out.println("StatusCode :" + resp.getStatusCode());
		return resp;
	}
	
	
	@Given("^User uploads images$")
	public Response PostImage() throws IOException {
		Properties prop = TestUtils.readPropertiesFile("Swagger.properties");
            // String s1 = System.getProperty("user.dir") + "\\src\\main\\Image\\download.jpg";
		    File file = new File("C:\\Users\\asrm\\Documents\\BDDTest\\src\\main\\Image\\download.jpg");
		    FileInputStream fileInputStream = new FileInputStream(file);
			final Response resp = given()
					.multiPart("file", "download.jpg", fileInputStream, "application/octet-stream")
		            .accept(ContentType.JSON)
		        .when()
		        .post(prop.getProperty("URL") + "pet/10/uploadImage").then().statusCode(200).extract()
					.response();
			fileInputStream.close();
			System.out.println("Response Body :" + resp.getBody().asString());
			System.out.println("StatusCode :" + resp.getStatusCode());
			return resp;
		}


}