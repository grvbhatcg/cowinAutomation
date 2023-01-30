package org.example.tests;
import org.example.helpers.CowinServiceHelper;
import org.example.models.District;
import org.example.models.DistrictResponse;
import org.example.models.State;
import org.example.models.StateResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class TestGET {
    private CowinServiceHelper cowinServiceHelper;
    private int stateId;
    private int districtId;

    @BeforeClass
    public void init() {
        cowinServiceHelper = new CowinServiceHelper();
        stateId = 16;
        districtId = 265;
    }

    @Test
    public void testStateIDKarnataka(){
        StateResponse st = cowinServiceHelper.getAllStates();
        assertNotNull(st, "GET States returned non-empty list");
        List<State> states = st.getStates();
        boolean found = false;
        for (State s : states) {
            if (s.getState_name().equals("Karnataka")) {
                found = true;
                assertEquals(s.getState_id(), 16);
            }
        }
        assertEquals(found, true);
    }

    @Test
    public void validateDistrictId(){
        DistrictResponse ds = cowinServiceHelper.getDistricts(stateId);
        assertNotNull(ds, "GET Districts returned empty list");
        List<District> districts = ds.getDistricts();
        boolean found = false;
        for (District d: districts) {
            if (d.getDistrict_name().equals("Bangalore Urban")) {
                found = true;
                assertEquals(d.getDistrict_id(), 265, "Ok");
            }
        }
        assertEquals(found, true);
    }

    @Test
    public void testGetStates(){
        StateResponse st = cowinServiceHelper.getAllStates();
        assertNotNull(st, "GET States returned non-empty list");
        List<State> states = st.getStates();
        for (State s : states) {
            assertNotNull(s.getState_id(), "All States and Union Territories should have their unique ids");
        }
    }


















}
