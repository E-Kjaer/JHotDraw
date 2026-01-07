package org.jhotdraw.draw.scenarios.ellipse;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.figure.EllipseFigure;
import org.assertj.core.api.Assertions.*;

import java.awt.geom.Rectangle2D;

import static org.assertj.core.api.Assertions.assertThat;

public class ThenEllipse extends Stage<ThenEllipse> {

    @ProvidedScenarioState
    Drawing drawing;

    @ProvidedScenarioState
    EllipseFigure ellipse;

    public void an_ellipse_should_exist_in_the_drawing() {
        assertThat(drawing.contains(ellipse)).isTrue();
    }

    public void the_ellipse_should_have_positive_size() {
        Rectangle2D.Double b = ellipse.getBounds();
        assertThat(b.width).isPositive();
        assertThat(b.height).isPositive();
    }
}
