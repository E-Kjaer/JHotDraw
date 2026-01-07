package org.jhotdraw.draw.scenarios.group;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.figure.CompositeFigure;
import static org.assertj.core.api.Assertions.*;

public class ThenGroup extends Stage<ThenGroup> {
    @ExpectedScenarioState
    CompositeFigure group;

    public void $_figures_are_grouped(int figureCount) {
        assertThat(figureCount).isSameAs(group.getChildCount());
    }
}
