package org.jhotdraw.samples.svg.figures;

import org.jhotdraw.draw.*;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.draw.tool.CreationTool;
import org.jhotdraw.draw.tool.Tool;
import org.junit.Test;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import static org.junit.Assert.*;

public class SVGRectFigureTest {

    DrawingEditor editor = new DefaultDrawingEditor();
    DrawingView view = new DefaultDrawingView();
    Drawing drawing = new DefaultDrawing();Tool rectTool;



    // Test fpr checking if you can create a rectangle with the creation tool
    @Test
    public void testCreateRectangleWithCorrectBounds() {

        view.setDrawing(drawing);
        editor.add(view);
        editor.setActiveView(view);
        rectTool = new CreationTool(new SVGRectFigure());

        editor.setTool(rectTool);
        rectTool.activate(editor);


        Component component = view.getComponent();

        int startX = 10;
        int endX = 20;
        int startY = 10;
        int endY = 30;


        assertEquals(0, drawing.getChildCount());
        rectTool.mousePressed(new MouseEvent(component, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0, startX,  startY, 1, false));
        rectTool.mouseDragged(new MouseEvent(component, MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(), 0, endX,  endY, 1, false));
        rectTool.mouseReleased(new MouseEvent(component, MouseEvent.MOUSE_RELEASED, System.currentTimeMillis(), 0,  endX,  endY, 1, false));

        assertEquals(1, drawing.getChildCount());
        Figure rectangle = drawing.getChild(0);

        assertTrue(rectangle instanceof SVGRectFigure);

        Rectangle2D.Double bounds = rectangle.getBounds();

        assertEquals(10, bounds.getX(), 0.0);
        assertEquals(10, bounds.getY(), 0.0);
        assertEquals(10, bounds.getWidth(), 0.0);
        assertEquals(20, bounds.getHeight(), 0.0);

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