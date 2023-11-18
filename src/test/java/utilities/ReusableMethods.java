package utilities;

import hooks.api.HooksAPI;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.Arrays;

import static hooks.api.HooksAPI.spec;
import static io.restassured.RestAssured.given;

public class ReusableMethods {
    static String fullPath;

    public static String pathParameters(String rawPaths) {

        // https://trendlifebuy.com/api/profile/allCountries

        // spec.pathParams("pp1","api","pp2","profile","pp3","allCountries");

        String[] paths = rawPaths.split("/"); // ["api","profile","allCountries"]

        System.out.println(Arrays.toString(paths));
       /*
        spec.pathParam("pp1","api");
        spec.pathParam ("pp2","profile");
        spec.pathParam("pp3","allCountries");
        */

        StringBuilder tempPath = new StringBuilder("/{");
            // .post("/{pp1}/{pp2}/{pp3}")

        for (int i = 0; i < paths.length; i++) {

            String key = "pp" + (i+1);
            String value = paths[i].trim();

            HooksAPI.spec.pathParam(key, value);

            tempPath.append(key + "}/{");
        }
        tempPath.deleteCharAt(tempPath.lastIndexOf("{"));
        tempPath.deleteCharAt(tempPath.lastIndexOf("/"));

        fullPath = "https://qa.wonderworldcollege.com"+tempPath.toString();
        System.out.println("fullPath = " + fullPath);

        return fullPath;
    }

    public static Response postRequest(String path) {
        JSONObject reqBody=new JSONObject();

        reqBody.put("email",ConfigReader.getProperty("email"));
        reqBody.put("password",ConfigReader.getProperty("pasword"));

        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                // .header("Accept","application/json")
                .headers("Authorization","Bearer " + HooksAPI.token)
                .when().body(reqBody.toString())
                .post(path);

        return response;

    }

}
