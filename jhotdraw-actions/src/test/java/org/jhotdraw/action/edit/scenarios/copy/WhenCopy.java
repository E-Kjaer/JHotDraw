package org.jhotdraw.action.edit.scenarios.copy;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.action.edit.CopyAction;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class WhenCopy extends Stage<WhenCopy> {
    @ExpectedScenarioState
    JComponent component;

    @ExpectedScenarioState
    CopyAction copyAction;

    @ProvidedScenarioState
    ActionEvent actionEvent;

    public WhenCopy copy_is_triggered() {
        actionEvent = new ActionEvent(component, ActionEvent.ACTION_PERFORMED, "copy");
        copyAction.actionPerformed(actionEvent);
        return this;
    }
}
