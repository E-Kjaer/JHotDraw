package org.jhotdraw.draw.action;

import org.jhotdraw.draw.*;
import org.jhotdraw.draw.figure.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class UngroupActionTest {
    CompositeFigure group = new GroupFigure();
    DrawingEditor editor = new DefaultDrawingEditor();
    DrawingView view = new DefaultDrawingView();
    Drawing drawing = new DefaultDrawing();
    UngroupAction ungroupAction = new UngroupAction(editor);

    @Before
    public void setup() {
       group = new GroupFigure();
       editor = new DefaultDrawingEditor();
       view = new DefaultDrawingView();
       view.setDrawing(drawing);
       editor.setActiveView(view);
    }

    @Test
    public void canUngroupCompositeWithTwoFigures() {
        group.add(new DiamondFigure());
        group.add(new LabelFigure());
        drawing.add(group);

        assertEquals(2, group.getChildren().size());

        Collection<Figure> figures = ungroupAction.ungroupFigures(view, group);

        assertEquals(2, figures.size());
        assertFalse(drawing.contains(group));
    }

    @Test
    public void canUngroupCompositeWithZeroFigures() {
        drawing.add(group);

        assertEquals(0, group.getChildren().size());

        Collection<Figure> figures = ungroupAction.ungroupFigures(view, group);

        assertEquals(0, figures.size());
        assertFalse(drawing.contains(group));
    }

    @Test(expected = NullPointerException.class)
    public void cannotUngroupNullCompositeFigure() {
        group = null;
        drawing.add(group);

        ungroupAction.ungroupFigures(view, group);
    }
}