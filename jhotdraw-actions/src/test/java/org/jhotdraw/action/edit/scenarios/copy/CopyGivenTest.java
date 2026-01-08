package org.jhotdraw.action.edit.scenarios.copy;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;


public class CopyGivenTest
        extends ScenarioTest<GivenComponent, WhenCopy, ThenExportToClipboardCalled> {

    @Test
    public void selected_figures_are_copied_to_clipboard() {
        given().a_component_with_a_recording_transfer_handler();
        when().copy_is_triggered();
        then().the_component_should_export_to_clipboard();
    }
}
