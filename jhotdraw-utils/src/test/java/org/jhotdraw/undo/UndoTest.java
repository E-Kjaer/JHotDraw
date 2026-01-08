package org.jhotdraw.undo;

import org.jhotdraw.undo.UndoRedoManager;
import org.testng.annotations.Test;

import javax.swing.undo.AbstractUndoableEdit;

import static org.testng.Assert.assertEquals;

public class UndoTest {
    @Test
    public void testUndoRedo() {
        UndoRedoManager manager = new UndoRedoManager();
        int[] value = {0};
        value[0]++;
        manager.addEdit(new AbstractUndoableEdit() {
            @Override
            public void undo() {
                super.undo();
                value[0]--;
            }

            @Override
            public void redo() {
                super.redo();
                value[0]++;
            }
        });

        assertEquals(value[0], 1);

        manager.undo();
        assertEquals(value[0], 0);

        manager.redo();
        assertEquals(value[0], 1);
    }

}
