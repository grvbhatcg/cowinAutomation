package org.example.tests;
import org.example.helpers.CowinServiceHelper;
import org.example.models.State;
import org.example.models.StateResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class TestGETStates {
    private CowinServiceHelper cowinServiceHelper;

    @BeforeClass
    public void init() {
        cowinServiceHelper = new CowinServiceHelper();
    }

    @Test
    public void testStateIDKarnataka(){
        StateResponse st = cowinServiceHelper.getAllStates();
        assertNotNull(st, "GET States returned non-empty list");
        List<State> states = st.getStates();
        for (State s : states) {
            if (s.getState_name().equals("Karnataka")) {
                assertEquals(s.getState_id(), 16);
            }
        }
    }




}
