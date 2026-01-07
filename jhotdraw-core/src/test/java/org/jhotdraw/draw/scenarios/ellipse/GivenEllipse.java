package org.jhotdraw.draw.scenarios.ellipse;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DefaultDrawing;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;

public class GivenEllipse extends Stage<GivenEllipse> {

    @ProvidedScenarioState
    DrawingEditor editor = new DefaultDrawingEditor();

    @ProvidedScenarioState
    DrawingView view = new DefaultDrawingView();

    @ProvidedScenarioState
    Drawing drawing = new DefaultDrawing();

    private void setup() {
        view.setDrawing(drawing);
        editor.setActiveView(view);
    }

    public void no_ellipse_exists() {
        setup();
    }
}
