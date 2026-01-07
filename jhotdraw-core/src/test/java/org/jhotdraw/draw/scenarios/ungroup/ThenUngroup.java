package org.jhotdraw.draw.scenarios.ungroup;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.figure.Figure;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class ThenUngroup extends Stage<ThenUngroup> {
    @ExpectedScenarioState
    Collection<Figure> figures;

    public void $_figures_are_ungrouped(int figureCount) {
        assertThat(figureCount).isSameAs(figures.size());
    }
}
