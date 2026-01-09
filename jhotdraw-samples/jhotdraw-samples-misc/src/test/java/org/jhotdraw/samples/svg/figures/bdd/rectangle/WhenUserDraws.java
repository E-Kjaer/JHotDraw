package org.jhotdraw.samples.svg.figures.bdd.rectangle;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.figure.RectangleFigure;
import org.jhotdraw.draw.tool.CreationTool;
import org.jhotdraw.draw.tool.Tool;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class WhenUserDraws extends Stage<WhenUserDraws> {
    @ProvidedScenarioState
    DrawingEditor editor;
    @ProvidedScenarioState
    DrawingView view;

    @ProvidedScenarioState
    SVGRectFigure rectangle;

    @ProvidedScenarioState
    boolean isSelected;

    @ProvidedScenarioState
    Tool rectTool;

    public WhenUserDraws a_user_drags_mouse(double x1, double y1, double x2, double y2) {

        editor.setTool(rectTool);
        rectTool.activate(editor);


        Component component = view.getComponent();

        editor.getTool().mousePressed(new MouseEvent(component, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0, (int) x1, (int) y1, 1, false));
        editor.getTool().mouseDragged(new MouseEvent(component, MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(), 0, (int) x2, (int) y2, 1, false));
        editor.getTool().mouseReleased(new MouseEvent(component, MouseEvent.MOUSE_RELEASED, System.currentTimeMillis(), 0, (int) x2, (int) y2, 1, false));

        return this;
    }

    public WhenUserDraws a_user_clicks_on_a_rectangle(double x, double y) {
        isSelected = rectangle.contains(new Point2D.Double(x,y));

        return this;
    }
}
