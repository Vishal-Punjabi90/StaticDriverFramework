package TestCasePackage;
import java.time.LocalDateTime;
import org.testng.Assert;
import Package_CommonFunction.APICommonFunction;
import ReqRepository.ReqRepository_Post;
import io.restassured.path.json.JsonPath;

public class Post_Class {
	public static void execute() {
		
		// Step 1: Fetch the status code/.
		int statusCode=APICommonFunction.statusCode(ReqRepository_Post.baseURI(), ReqRepository_Post.resource(), ReqRepository_Post.requestBody());
		System.out.println(statusCode);
		
		// Step 2 : Fetch response body/.
		String responseBody=APICommonFunction.responseBody(ReqRepository_Post.baseURI(), ReqRepository_Post.resource(), ReqRepository_Post.requestBody());
		System.out.println(responseBody);
		
		// Step 3: Configure request body params.
		JsonPath jspreq=new JsonPath(ReqRepository_Post.requestBody());
		String req_name=jspreq.getString("name");
		String req_job=jspreq.getString("job");
		
		// Step 3.1 : Set expected date.
		String expDate=LocalDateTime.now().toString().substring(0,10);
		
		// Step 4 : Configure response body params.
		JsonPath jspres=new JsonPath(responseBody);
		String res_name=jspres.getString("name");
		String res_job=jspres.getString("job");
		String res_id=jspres.getString("id");
		String res_createdAt=jspres.getString("createdAt").substring(0,10);
		
		// Step 5 : Validation of response body params.
		Assert.assertEquals(res_name, req_name);
		Assert.assertEquals(res_job, req_job);
		Assert.assertNotNull(res_id);
		Assert.assertEquals(res_createdAt, expDate);
		
		System.out.println("Validated Successfully");
	}

}
