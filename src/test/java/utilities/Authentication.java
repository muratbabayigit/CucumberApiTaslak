package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class Authentication {

    private static RequestSpecification spec;


    public void generateToken(){

        spec =new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("pp1","api","pp2","getToken");

        JSONObject reqBody=new JSONObject();

        reqBody.put("email",ConfigReader.getProperty("email"));
        reqBody.put("password",ConfigReader.getProperty("pasword"));

    }
}
