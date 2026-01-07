package org.jhotdraw.draw.scenarios.ellipse;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.figure.EllipseFigure;
import org.junit.Assert;

import java.awt.geom.Rectangle2D;

public class ThenEllipse extends Stage<ThenEllipse> {

    @ProvidedScenarioState
    Drawing drawing;

    @ProvidedScenarioState
    EllipseFigure ellipse;

    public void an_ellipse_should_exist_in_the_drawing() {
        Assert.assertTrue(drawing.contains(ellipse));
    }

    public void the_ellipse_should_have_positive_size() {
        Rectangle2D.Double b = ellipse.getBounds();
        Assert.assertTrue("Width should be > 0", b.width > 0.0);
        Assert.assertTrue("Height should be > 0", b.height > 0.0);
    }
}
