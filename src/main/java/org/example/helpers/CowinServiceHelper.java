package org.example.helpers;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.example.constants.Endpoints;
import org.example.models.DistrictResponse;
import org.example.models.HospitalsResponse;
import org.example.models.StateResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.testng.Assert.assertEquals;

public class CowinServiceHelper {
    private static final String BASE_URL = "https://cdn-api.co-vin.in/api/v2/";

    public CowinServiceHelper() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.useRelaxedHTTPSValidation();
    }

    public StateResponse getAllStates() {
        Response response = RestAssured.given().contentType(ContentType.JSON).get(Endpoints.GET_ALL_STATES).andReturn();
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK, response.getBody().asString());
        StateResponse stateResponse = new Gson().fromJson(response.asString(), StateResponse.class);
        System.out.println(stateResponse.toString());
        return stateResponse;
    }

    public DistrictResponse getDistricts(int stateId) {
        Response response = RestAssured.given().pathParam("state_id", String.valueOf(stateId)).contentType(ContentType.JSON).get(Endpoints.GET_DISTRICTS_FOR_STATE).andReturn();
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK, response.getBody().asString());
        DistrictResponse districtResponse = new Gson().fromJson(response.asString(), DistrictResponse.class);
        System.out.println(districtResponse.toString());
        return districtResponse;
    }

    public HospitalsResponse getHospitals(int districtId, Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Response response = RestAssured.given().queryParam("district_id", String.valueOf(districtId)).queryParam("date", formatter.format(date)).contentType(ContentType.JSON).get(Endpoints.GET_HOSPITALS_FOR_DISTRICT).andReturn();
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK, response.getBody().asString());
        HospitalsResponse hospitalsResponse = new Gson().fromJson(response.asString(), HospitalsResponse.class);
        System.out.println(hospitalsResponse.toString());
        return hospitalsResponse;
    }


}
