package org.jhotdraw.draw.scenarios.ellipse;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.figure.EllipseFigure;

import java.awt.geom.Point2D;

public class WhenEllipse extends Stage<WhenEllipse> {

    @ProvidedScenarioState
    Drawing drawing;

    @ProvidedScenarioState
    EllipseFigure ellipse;

    public void the_user_creates_an_ellipse(double x1, double y1, double x2, double y2) {
        ellipse = new EllipseFigure();
        ellipse.setBounds(new Point2D.Double(x1, y1), new Point2D.Double(x2, y2));
        drawing.add(ellipse);
    }
}
