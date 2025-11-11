package org.jhotdraw.draw.scenarios.group;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.action.GroupAction;
import org.jhotdraw.draw.figure.DiamondFigure;
import org.jhotdraw.draw.figure.Figure;

import java.util.Collection;
import java.util.HashSet;

public class GivenFigures extends Stage<GivenFigures> {
    @ProvidedScenarioState
    DrawingEditor editor = new DefaultDrawingEditor();

    @ProvidedScenarioState
    DrawingView view = new DefaultDrawingView();

    @ProvidedScenarioState
    Drawing drawing = new DefaultDrawing();

    @ProvidedScenarioState
    GroupAction groupAction = new GroupAction(editor);

    @ProvidedScenarioState
    Collection<Figure> figures = new HashSet<>();

    public void setup() {
        view.setDrawing(drawing);
        editor.setActiveView(view);
    }

    public GivenFigures initialized_system() {
        setup();
        return this;
    }

    public GivenFigures the_figures(Collection<Figure> figures) {
        this.figures.addAll(figures);
        drawing.addAll(this.figures);
        return this;
    }

    public GivenFigures $_diamond_figures(int figures) {
        HashSet<Figure> collection = new HashSet<>();
        for (int i = 0; i < figures; i++) {
            collection.add(new DiamondFigure());
        }
        return the_figures(collection);
    }
}
