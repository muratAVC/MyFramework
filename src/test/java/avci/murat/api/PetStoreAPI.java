package avci.murat.api;

import io.cucumber.java.it.Ma;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PetStoreAPI {


    @BeforeAll
    public static void  init() {
        baseURI = "https://petstore.swagger.io/v2/pet";
    }

    @Test
    public void petStoreApiTest1(){
        Response response= RestAssured.given().accept(ContentType.JSON)
                .when().get("/10");

        System.out.println("response.statusCode() = " + response.statusCode());
        response.prettyPrint();

    }

    @Test
    public void createPet(){
        Map<String,Object> body=new HashMap<>();
        Map<String,Object> category=new HashMap<>();
        category.put("id",11);
        category.put("name","Abizittin");

        List<String> photoURL=new ArrayList<>();
        photoURL.add("www.hursit.com");

        List<Map<String,Object>> tags=new ArrayList<>();
        Map<String,Object> tag=new HashMap<>();
        tag.put("id",10);
        tag.put("name","kedicik");
        tags.add(tag);

        body.put("id",101);
        body.put("category",category);
        body.put("name","hursit");
        body.put("photoUrls",photoURL);
        body.put("tags",tags);
        body.put("status","unavaible");

        Response response=given().accept(ContentType.JSON)
                        .body(body).when().put();



        System.out.println("response.statusCode() = " + response.statusCode());


        //System.out.println("body.toString() = " + body.toString());

    }



}
