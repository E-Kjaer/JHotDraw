package org.jhotdraw.draw.scenarios.group;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.figure.CompositeFigure;
import org.junit.Assert;

public class ThenGroup extends Stage<ThenGroup> {
    @ExpectedScenarioState
    CompositeFigure group;

    public void $_figures_are_grouped(int figureCount) {
        Assert.assertEquals(figureCount, group.getChildren().size());
    }
}
