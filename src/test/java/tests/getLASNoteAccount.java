package tests;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.parsing.Parser;
import org.junit.Test;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class getLASNoteAccount{

    @Test
    public void getLASNoteAccountTest(){
        RestAssured.useRelaxedHTTPSValidation();
        String json = get("https://httpbin.org/get").asString();
        //String json = given().contentType("application/json").param("Account", "501").when().get("https://10.231.211.35:8084/api/1/rest/feed-master/queue/LOBDev/projects/Fiserv/LOAN_GetLASNoteAccount%20Task").asString();
        //String json = get("https://10.231.211.35:8084/api/1/rest/feed-master/queue/LOBDev/projects/Fiserv/LOAN_GetLASNoteAccount%20Task?Account=501").asString();
        //String requestBody = "{\"Input\":{\"System\":{\"StepId\":\"CBC\",\"SingleServiceOnly\":\"1\",\"DisableCallBacks\":\"1\",\"SFUrl\":\"QA\"}}}";
        String node = "Response.Status";
        String success = "{\"StatusCode\":\"0\",\"ServerStatusCode\":\"0\",\"Severity\":\"0\",\"StatusDesc\":\"Success\"}";

        System.out.println("Response" + json);

        //validateResponse(node, success);

    }

    public void validateResponse(String node, String success){

        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.defaultParser = Parser.JSON;

        expect().
                body(node, hasToString(success)).
                when().
                get("https://10.231.211.35:8084/api/1/rest/feed-master/queue/LOBDev/projects/Fiserv/LOAN_GetLASNoteAccount%20Task?Account=501");
    }

}