package org.jhotdraw.undo.scenarios;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;


import static org.junit.Assert.assertEquals;

public class ThenEdit extends Stage<ThenEdit> {

    @ExpectedScenarioState
    GivenEdit.Counter counter;

    public void the_edit_has_disappeared() {
        assertEquals(0, counter.value);
    }
}
