package org.jhotdraw.action.edit;

import org.junit.Test;

import javax.swing.*;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CopyActionTest {

    private static class RecordingTransferHandler extends TransferHandler {
        boolean called = false;
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

    @Test
    public void copiesFromExplicitTargetComponent() {
        // Arrange
        JPanel panel = new JPanel();
        RecordingTransferHandler th = new RecordingTransferHandler();
        panel.setTransferHandler(th);

        CopyAction action = new CopyAction(panel);

        // Act
        action.actionPerformed(new ActionEvent(panel, ActionEvent.ACTION_PERFORMED, "copy"));

        // Assert
        assertThat(th.called)
                .as("exportToClipboard should be called")
                .isTrue();

        assertThat(th.passedComponent)
                .as("Should pass the same component")
                .isSameAs(panel);

        assertThat(th.passedClipboard)
                .as("Clipboard should not be null")
                .isNotNull();

        assertThat(th.passedAction)
                .as("Should use COPY action")
                .isEqualTo(TransferHandler.COPY);
    }

    @Test
    public void copyingIsAllowedEvenIfComponentIsDisabled() {
        // Arrange
        JPanel panel = new JPanel();
        panel.setEnabled(false);
        RecordingTransferHandler th = new RecordingTransferHandler();
        panel.setTransferHandler(th);

        CopyAction action = new CopyAction(panel);

        // Act
        action.actionPerformed(new ActionEvent(panel, ActionEvent.ACTION_PERFORMED, "copy"));

        // Assert
        assertThat(th.called)
                .as("exportToClipboard should still be called for disabled components")
                .isTrue();

        assertThat(th.passedComponent)
                .isSameAs(panel);

        assertThat(th.passedAction)
                .isEqualTo(TransferHandler.COPY);
    }
}
