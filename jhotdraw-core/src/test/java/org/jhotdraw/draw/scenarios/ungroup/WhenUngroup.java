package org.jhotdraw.draw.scenarios.ungroup;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.action.UngroupAction;
import org.jhotdraw.draw.figure.CompositeFigure;
import org.jhotdraw.draw.figure.Figure;

import java.util.Collection;

public class WhenUngroup extends Stage<WhenUngroup> {
    @ExpectedScenarioState
    DrawingView view;

    @ExpectedScenarioState
    UngroupAction ungroupAction;

    @ProvidedScenarioState
    Collection<Figure> figures;

    @ExpectedScenarioState
    CompositeFigure group;

    public WhenUngroup ungrouping_is_performed() {
        figures = ungroupAction.ungroupFigures(view, group);
        return this;
    }
}
