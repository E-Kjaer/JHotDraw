package org.jhotdraw.samples.svg.figures.bdd.rectangle;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;

public class GivenDrawing extends Stage<GivenDrawing> {

    @ProvidedScenarioState
    DrawingEditor editor = new DefaultDrawingEditor();
    @ProvidedScenarioState
    DrawingView view = new DefaultDrawingView();
    @ProvidedScenarioState
    Drawing drawing = new DefaultDrawing();

    @ProvidedScenarioState
    SVGRectFigure rectangle;


    public void setup() {
        view.setDrawing(drawing);
        editor.setActiveView(view);
    }

    public GivenDrawing an_empty_drawing() {
        setup();
        return this;
    }

    public GivenDrawing a_rectangle_exist(double x, double y, double width, double height) {
        rectangle = new SVGRectFigure(x, y, width, height);

        return this;
    }



}
