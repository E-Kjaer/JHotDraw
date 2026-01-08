package org.jhotdraw.action.edit.scenarios.copy;


import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.action.edit.CopyAction;

import javax.swing.*;
import java.awt.datatransfer.Clipboard;

public class GivenComponent extends Stage<GivenComponent> {
    @ProvidedScenarioState
    JComponent component = new JPanel();

    @ProvidedScenarioState
    RecordingTransferHandler transferHandler = new RecordingTransferHandler();

    @ProvidedScenarioState
    CopyAction copyAction;

    private void setup(){
        component.setTransferHandler(transferHandler);
        copyAction = new CopyAction(component);
    }


    public GivenComponent a_component_with_a_recording_transfer_handler(){
        setup();
        return self();
    }

    static class RecordingTransferHandler extends TransferHandler {
        boolean called;
        JComponent passedComponent;
        Clipboard passedClipboard;
        int passedAction;

        @Override
        public void exportToClipboard(JComponent comp, Clipboard clip, int action) {
            called = true;
            passedComponent = comp;
            passedClipboard = clip;
            passedAction = action;
        }
    }
}
