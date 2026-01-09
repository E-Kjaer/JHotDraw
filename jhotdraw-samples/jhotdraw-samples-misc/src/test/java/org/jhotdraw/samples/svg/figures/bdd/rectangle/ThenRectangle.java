package org.jhotdraw.samples.svg.figures.bdd.rectangle;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;
import static org.junit.Assert.*;


import java.awt.geom.Rectangle2D;

public class ThenRectangle extends Stage<ThenRectangle> {

    @ProvidedScenarioState
    Drawing drawing;

    @ProvidedScenarioState
    boolean isSelected;

    public ThenRectangle a_rectangle_is_created(double x, double y, double width, double height) {

        assertEquals(1, drawing.getChildCount());
        Figure rectangle = drawing.getChild(0);

        assertTrue(rectangle instanceof SVGRectFigure);

        Rectangle2D.Double bounds = rectangle.getBounds();

        assertEquals(x, bounds.getX(), 0.0);
        assertEquals(y, bounds.getY(), 0.0);
        assertEquals(width, bounds.getWidth(), 0.0);
        assertEquals(height, bounds.getHeight(), 0.0);

        return this;
    }

    public ThenRectangle a_rectangle_is_selected() {
        assertTrue(isSelected);

        return this;
    }


}
