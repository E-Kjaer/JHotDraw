package org.jhotdraw.undo.scenarios;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.undo.UndoRedoManager;

public class WhenUndo extends Stage<WhenUndo> {

    @ExpectedScenarioState
    UndoRedoManager manager;

    public WhenUndo i_press_undo() {
        manager.undo();
        return this;
    }
}
