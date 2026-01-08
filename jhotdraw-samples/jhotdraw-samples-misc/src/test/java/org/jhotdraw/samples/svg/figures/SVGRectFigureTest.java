package org.jhotdraw.samples.svg.figures;

import org.junit.Test;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import static org.junit.Assert.*;

public class SVGRectFigureTest {


    // Test fpr checking if you can create a rectangle
    @Test
    public void testCreateRectangleWithCorrectBounds() {
        SVGRectFigure rectangle = new SVGRectFigure();
        rectangle.setBounds(new Point2D.Double(10, 10), new Point2D.Double(40, 50));

        Rectangle2D.Double bounds = rectangle.getBounds();
        assertEquals(10.0, bounds.x, 0.0);
        assertEquals(10.0, bounds.y, 0.0);
        assertEquals(30.0, bounds.width, 0.0);
        assertEquals(40.0, bounds.height, 0.0);
    }


    // test for checking if a rectangle can get rounded corners
    @Test
    public void roundedRectanglesCanBeCreated() {
        SVGRectFigure rectangle = new SVGRectFigure();
        rectangle.setBounds(new Point2D.Double(10, 10), new Point2D.Double(40, 50));

        rectangle.setArc(10, 15);

        assertEquals(10, rectangle.getArcWidth(), 0.0);
        assertEquals(15, rectangle.getArcHeight(), 0.0);
    }


    // test for seeing that the figure registers if the mouse is inside it or not
    @Test
    public void canHoverRectangle() {
        SVGRectFigure rectangle = new SVGRectFigure(10, 10, 20, 20);

        assertTrue(rectangle.contains(new Point2D.Double(15, 15)));
        assertFalse(rectangle.contains(new Point2D.Double(100, 100)));

    }
}