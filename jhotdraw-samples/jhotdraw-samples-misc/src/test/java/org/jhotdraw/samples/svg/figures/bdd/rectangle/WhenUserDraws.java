package org.jhotdraw.samples.svg.figures.bdd.rectangle;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;

import java.awt.geom.Point2D;

public class WhenUserDraws extends Stage<WhenUserDraws> {
    @ProvidedScenarioState
    Drawing drawing;

    @ProvidedScenarioState
    SVGRectFigure rectangle;

    @ProvidedScenarioState
    boolean isSelected;

    public WhenUserDraws a_user_drags_mouse(double x1, double y1, double x2, double y2) {
        rectangle = new SVGRectFigure();
        rectangle.setBounds(new Point2D.Double(x1, y1), new Point2D.Double(x2, y2));
        drawing.add(rectangle);
        return this;
    }

    public WhenUserDraws a_user_selects_rectangle(double x, double y) {
        isSelected = rectangle.contains(new Point2D.Double(x,y));

        return this;
    }
}
