package org.jhotdraw.draw.scenarios.ungroup;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class UngroupActionScenarioTest extends ScenarioTest<GivenFigure, WhenUngroup, ThenUngroup> {
    @Test
    public void ungrouping_composite_figure_should_ungroup() {
        given()
                .an_initialized_system()
                .and()
                .composite_figure_with_$_diamond_figures(2);

        when()
                .ungrouping_is_performed();

        then()
                .$_figures_are_ungrouped(2);
    }
}
