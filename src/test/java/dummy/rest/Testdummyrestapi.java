package dummy.rest;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Testdummyrestapi {

	@Test
	public void verifyAllEmployeesGetStatusCode() {
		Response res = get("http://dummy.restapiexample.com/api/v1/employees");
		int statusCode = res.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test
	public void verifySingleEmployeeGetStatusCode() {
		/** Let me use Given when then here */
		given().get("http://dummy.restapiexample.com/api/v1/employee/1").then().statusCode(200);
	}

	@Test
	public void verifyEmployeeDeleteStatusCode() {
		/** returning 404s */

		Response res = get("http://dummy.restapiexample.com/public/api/v1/delete/2");
		int statusCode = res.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test
	public void verifySpecificEmployeeDetails() {

		given().get("http://dummy.restapiexample.com/api/v1/employee/1").then()
				.body("data.employee_name", equalTo("Tiger Nixon")).body("data.employee_salary", equalTo(320800))
				.body("data.employee_age", equalTo(61)).body("data.profile_image", equalTo(""));
	}

	@Test
	public void verifyDeleteMessage() {
		Response resp=get("http://dummy.restapiexample.com/public/api/v1/delete/2");
		Assert.assertEquals(resp.jsonPath().getJsonObject("message"), "successfully! deleted Records");
	}

}
