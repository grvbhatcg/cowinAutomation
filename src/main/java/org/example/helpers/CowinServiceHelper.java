package org.example.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.example.constants.Endpoints;
import org.example.models.DistrictResponse;
import org.example.models.StateResponse;

import java.lang.reflect.Type;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class CowinServiceHelper {
    private static final String BASE_URL="https://cdn-api.co-vin.in/api/v2/";
    public CowinServiceHelper() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.useRelaxedHTTPSValidation();
    }


    public StateResponse getAllStates() {
        Response response = RestAssured.given().contentType(ContentType.JSON).get(Endpoints.GET_ALL_STATES).andReturn();
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Ok");
        JsonPath jsnPath = response.jsonPath();
        Type type = new TypeReference<StateResponse>(){}.getType();
        StateResponse stateResponse = response.as(type);
        System.out.println(stateResponse.toString());
        return stateResponse;
    }

    public DistrictResponse getDistricts(int state_id) {
        Response response = RestAssured.given().pathParam("state_id", String.valueOf(state_id)).contentType(ContentType.JSON).get(Endpoints.GET_DISTRICTS_FOR_STATE).andReturn();
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Ok");
        JsonPath jsnPath = response.jsonPath();
        Type type = new TypeReference<DistrictResponse>(){}.getType();
        DistrictResponse districtResponse = response.as(type);
        System.out.println(districtResponse.toString());
        return districtResponse;
    }




}
