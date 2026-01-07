package org.jhotdraw.draw.figure;

import org.junit.Test;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import static org.junit.Assert.*;

public class EllipseFigureTest {

    @Test
    public void setBoundsCreatesEllipseWithCorrectBounds() {
        EllipseFigure f = new EllipseFigure();
        f.setBounds(new Point2D.Double(10, 20), new Point2D.Double(30, 50));

        Rectangle2D.Double b = f.getBounds();
        assertEquals(10.0, b.x, 0.0);
        assertEquals(20.0, b.y, 0.0);
        assertEquals(20.0, b.width, 0.0);
        assertEquals(30.0, b.height, 0.0);
    }

    @Test
    public void setBoundsEnforcesMinimumSize() {
        EllipseFigure f = new EllipseFigure();
        f.setBounds(new Point2D.Double(10, 10), new Point2D.Double(10, 10));

        Rectangle2D.Double b = f.getBounds();
        assertTrue(b.width > 0.0);
        assertTrue(b.height > 0.0);
    }
}
