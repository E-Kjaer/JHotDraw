package org.jhotdraw.draw.scenarios.group;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.action.GroupAction;
import org.jhotdraw.draw.figure.CompositeFigure;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.draw.figure.GroupFigure;

import java.util.Collection;

public class WhenGroup extends Stage<WhenGroup> {
    @ExpectedScenarioState
    DrawingView view;

    @ExpectedScenarioState
    GroupAction groupAction;

    @ExpectedScenarioState
    Collection<Figure> figures;

    @ProvidedScenarioState
    CompositeFigure group;

    public WhenGroup grouping_is_performed() {
        group = new GroupFigure();
        groupAction.groupFigures(view, group, figures);
        return this;
    }
}
