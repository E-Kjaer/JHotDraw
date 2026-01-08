package org.jhotdraw.action.edit.scenarios.copy;


import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import javax.swing.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ThenExportToClipboardCalled extends Stage<ThenExportToClipboardCalled> {
    @ExpectedScenarioState
    GivenComponent.RecordingTransferHandler transferHandler;

    @ExpectedScenarioState
    JComponent component;

    public ThenExportToClipboardCalled the_component_should_export_to_clipboard() {

        assertThat(transferHandler.called)
                .as("CopyAction should trigger exportToClipboard")
                .isTrue();

        assertThat(transferHandler.passedComponent)
                .as("exportToClipboard should be called with the same component")
                .isSameAs(component);

        assertThat(transferHandler.passedClipboard)
                .as("exportToClipboard should be called with a non-null Clipboard")
                .isNotNull();

        assertThat(transferHandler.passedAction)
                .as("exportToClipboard should use TransferHandler.COPY")
                .isEqualTo(TransferHandler.COPY);

        return this;
    }
}
