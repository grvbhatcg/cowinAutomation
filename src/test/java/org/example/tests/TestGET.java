package org.example.tests;
import org.example.helpers.CowinServiceHelper;
import org.example.models.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Date;
import java.util.List;

import static org.testng.Assert.*;

public class TestGET {
    private CowinServiceHelper cowinServiceHelper;
    private StateResponse stateResponse;
    private int stateId;
    private int districtId;

    @BeforeClass
    public void init() {
        cowinServiceHelper = new CowinServiceHelper();
        stateResponse = cowinServiceHelper.getAllStates();

    }


/*
Validates that the state ID of Karnataka is 16
 */
    @Test
    public void validateStateID(){
        assertNotNull(stateResponse, "GET States returned empty list");
        List<State> states = stateResponse.getStates();
        boolean found = false;
        for (State s : states) {
            if (s.getState_name().equals("Karnataka")) {
                found = true;
                assertEquals(s.getState_id(), 16, "State ID of Karnataka not found to be 16");
                return;
            }
        }
        assertNotEquals(found, false, "State not found");
    }

    /*
    Validates that the district ID of Bengaluru is 265
     */
    @Test
    public void validateDistrictId(){
        DistrictResponse districtResponse = cowinServiceHelper.getDistricts(16);
        assertNotNull(districtResponse, "GET Districts returned empty list");
        List<District> districts = districtResponse.getDistricts();
        boolean found = false;
        for (District d: districts) {
            if (d.getDistrict_name().equals("Bangalore Urban")) {
                found = true;
                assertEquals(d.getDistrict_id(), 265, "District ID of Bangalore Urban not found to be 265");
                return;
            }
        }
        assertNotEquals(found, false, "District not found");
    }

    /*
    Validates that every state and UT has an ID
     */
    @Test
    public void testGetStates(){
        assertNotNull(stateResponse, "GET States returned non-empty list");
        List<State> states = stateResponse.getStates();
        for (State s : states) {
            assertNotNull(s.getState_id(), "All States and Union Territories should have their unique ids");
        }
    }

    /*
     Validates that Springleaf's vaccine fees > Rs 300
    */
    @Test
    public void testSpringleafHealthcare(){
        HospitalsResponse hospitalsResponse = cowinServiceHelper.getHospitals(265, new Date());
        assertNotNull(hospitalsResponse, "GET Hospitals returned non-empty list");
        List<Session> sessions = hospitalsResponse.getSessions();
        boolean found = false;
        for (Session session : sessions) {
            String name = session.getName();
            double fee = Double.parseDouble(session.getFee());
            if (name.equals("Springleaf Healthcare")) {
                found = true;
                assertTrue(fee > 300.0, "Springleaf Healthcare's fees do not exceed INR 300");
            }
        }
        assertNotEquals(found, false, "Hospital not found");
    }

    /*
     Validates that there exists at least 1 free vaccine center
     */
    @Test
    public void testFreeCenters(){
        List<State> states = stateResponse.getStates();
        boolean atLeastOneFree = false;
        for (State state : states) {
            DistrictResponse districtResponse = cowinServiceHelper.getDistricts(state.getState_id());
            List<District> districts = districtResponse.getDistricts();
            for (District district : districts) {
                HospitalsResponse hospitalsResponse = cowinServiceHelper.getHospitals(district.getDistrict_id(), new Date());
                List<Session> sessions = hospitalsResponse.getSessions();
                for (Session session : sessions) {
                    String fee_type = session.getFee_type();
                    double fee = Double.parseDouble(session.getFee());
                    if (fee_type.equals("Free") || fee == 0.0) {
                        atLeastOneFree = true;
                        assertTrue(atLeastOneFree == true);
                        return;
                    }

                }
            }
        }
        assertNotEquals(atLeastOneFree, false, "No hospital found that provides free vaccination");
    }






















}
