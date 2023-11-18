package stepDefinitions.api;


import hooks.api.HooksAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import utilities.ReusableMethods;

public class CommonAPI {
String fullpath;
Response response;
    @Given("Api Kullanicisi {string} set eder")
    public void api_kullanicisi_set_eder(String rawPaths) {

        fullpath= ReusableMethods.pathParameters(rawPaths);

    }

    @Then("Api kullanicisi token islemi icin bir post request yapar")
    public void api_kullanicisi_token_islemi_icin_bir_post_request_yapar() {
        response=ReusableMethods.postRequest(fullpath);
        response.prettyPrint();
    }
    @Then("Api kullanicisi aldigi tokeni yazdirir")
    public void api_kullanicisi_aldigi_tokeni_yazdirir() {
        System.out.println(HooksAPI.token);
    }





}
