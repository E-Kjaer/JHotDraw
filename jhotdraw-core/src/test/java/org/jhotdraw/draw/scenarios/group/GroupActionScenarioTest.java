package org.jhotdraw.draw.scenarios.group;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class GroupActionScenarioTest extends ScenarioTest<GivenFigures, WhenGroup, ThenGroup> {
    @Test
    public void grouping_two_figures_should_group() {
        given()
                .an_initialized_system()
                .and()
                .$_diamond_figures(2);

        when()
                .grouping_is_performed();

        then()
                .$_figures_are_grouped(2);
    }
}
