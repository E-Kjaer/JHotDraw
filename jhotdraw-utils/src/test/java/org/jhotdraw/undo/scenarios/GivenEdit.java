package org.jhotdraw.undo.scenarios;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import javax.swing.undo.AbstractUndoableEdit;
import org.jhotdraw.undo.UndoRedoManager;

public class GivenEdit extends Stage<GivenEdit> {
    @ProvidedScenarioState
    UndoRedoManager manager;
    @ProvidedScenarioState
    Counter counter;
    @ProvidedScenarioState
    AbstractUndoableEdit edit;

    public GivenEdit initialized_manager() {
        manager = new UndoRedoManager();
        return this;
    }
    public GivenEdit i_have_made_an_edit() {
        counter = new Counter();
        counter.value = 0;
        counter.value++;

        edit = new AbstractUndoableEdit() {
            @Override
            public void undo() {
                super.undo();
                counter.value--;
            }

            @Override
            public void redo() {
                super.redo();
                counter.value++;
            }
        };
        manager.addEdit(edit);
        return this;
    }
    public static class Counter {
        public int value;
    }
}
