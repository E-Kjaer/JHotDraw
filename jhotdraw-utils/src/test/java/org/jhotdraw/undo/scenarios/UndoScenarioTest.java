package org.jhotdraw.undo.scenarios;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class UndoScenarioTest extends ScenarioTest<GivenEdit, WhenUndo, ThenEdit> {

    @Test
    public void given_edit_when_undo_then_edit_disappears() {
        given()
                .initialized_manager()
                .and()
                .i_have_made_an_edit();
        when()
                .i_press_undo();
        then()
                .the_edit_has_disappeared();
    }
}