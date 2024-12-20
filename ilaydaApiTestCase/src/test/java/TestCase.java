import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class TestCase {

    public String token;
    public String bookingId;

    @Test
    public void testGetToken() {
        String requestBody = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("https://restful-booker.herokuapp.com/auth");

        // Check the status code
        response.then()
                .statusCode(200);

        // Set the token
        token = response.jsonPath().getString("token");

    }

    @Test(dependsOnMethods = "testGetToken")
    public void testCreateABook() {
        String requestBody = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("https://restful-booker.herokuapp.com/booking");

        System.out.println(response.getBody().asString());
        // Check the status code
        response.then()
                .statusCode(200);
        System.out.println("statusCode: " + response.getStatusCode());


        // Check the response body
        //nested json object
        response.then()
                .body("booking.firstname", equalTo("Jim"))
                .body("booking.lastname", equalTo("Brown"))
                .body("booking.totalprice", equalTo(111))
                .body("booking.depositpaid", equalTo(true))
                .body("booking.bookingdates.checkin", equalTo("2018-01-01"))
                .body("booking.bookingdates.checkout", equalTo("2019-01-01"))
                .body("booking.additionalneeds", equalTo("Breakfast"));

        // Check the bookingid is not null
        response.then()
                .body("bookingid", notNullValue());
        // Set the bookingId
        bookingId = response.jsonPath().getString("bookingid");

    }

    @Test(dependsOnMethods = "testCreateABook")
    public void testDeleteABook() {
        System.out.println("bookingId: " + bookingId);
        System.out.println("token: " + token);
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Cookie", "token=" + token)
                .when()
                .delete("https://restful-booker.herokuapp.com/booking/" + bookingId);

        response.then()
                .statusLine("HTTP/1.1 201 Created");

        System.out.println(response.getBody().asString());
        System.out.println("statusCode: " + response.getStatusCode());

    }

    @Test(dependsOnMethods = "testDeleteABook")
    public void testGetNonExistingBooking() {
        Response response = RestAssured.given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/"+ bookingId);

        /*// Check the status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, HttpStatus.SC_NOT_FOUND, "Status code is not 404");
*/
        response.then()
                .statusCode(404);
        System.out.println("statusCode: " + response.getStatusCode());


    }




}

