package org.jhotdraw.draw.scenarios.ungroup;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.action.UngroupAction;
import org.jhotdraw.draw.figure.CompositeFigure;
import org.jhotdraw.draw.figure.DiamondFigure;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.draw.figure.GroupFigure;

import java.util.Collection;
import java.util.HashSet;

public class GivenFigure extends Stage<GivenFigure> {
    @ProvidedScenarioState
    DrawingEditor editor = new DefaultDrawingEditor();

    @ProvidedScenarioState
    DrawingView view = new DefaultDrawingView();

    @ProvidedScenarioState
    Drawing drawing = new DefaultDrawing();

    @ProvidedScenarioState
    UngroupAction ungroupAction = new UngroupAction(editor);

    @ProvidedScenarioState
    CompositeFigure figure = new GroupFigure();

    public void setup() {
        view.setDrawing(drawing);
        editor.setActiveView(view);
    }

    public GivenFigure an_initialized_system() {
        setup();
        return this;
    }

    public GivenFigure the_figure(Collection<Figure> figures) {
        for (Figure figure : figures) {
            this.figure.add(figure);
        }
        drawing.add(this.figure);
        return this;
    }

    public GivenFigure composite_figure_with_$_diamond_figures(int figures) {
        HashSet<Figure> collection = new HashSet<>();
        for (int i = 0; i < figures; i++) {
            collection.add(new DiamondFigure());
        }
        return the_figure(collection);
    }
}
