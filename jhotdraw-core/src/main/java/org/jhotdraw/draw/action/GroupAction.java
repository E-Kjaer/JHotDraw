/*
 * @(#)GroupAction.java
 *
 * Copyright (c) 1996-2010 The authors and contributors of JHotDraw.
 * You may not use, copy or modify this file, except in compliance with the
 * accompanying license terms.
 */
package org.jhotdraw.draw.action;

import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.draw.figure.CompositeFigure;
import org.jhotdraw.draw.figure.GroupFigure;
import java.util.*;
import javax.swing.undo.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * GroupAction.
 *
 * @author Werner Randelshofer
 * @version $Id$
 */
public class GroupAction extends GroupBaseAction {

    private static final long serialVersionUID = 1L;
    public static final String ID = "edit.groupSelection";
    public static final String DRAW_LABELS = "org.jhotdraw.draw.Labels";
    private CompositeFigure prototype;

    /**
     * Creates a new instance.
     */
    public GroupAction(DrawingEditor editor) {
        this(editor, new GroupFigure());
    }

    public GroupAction(DrawingEditor editor, CompositeFigure prototype) {
        super(editor);
        this.prototype = prototype;
        ResourceBundleUtil labels
                = ResourceBundleUtil.getBundle(DRAW_LABELS);
        labels.configureAction(this, ID);
        updateEnabledState();
    }

    @Override
    protected void updateEnabledState() {
        if (getView() != null) {
            setEnabled(canGroup());
        } else {
            setEnabled(false);
        }
    }

    protected boolean canGroup() {
        return getView() != null && getView().getSelectionCount() > 1;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (canGroup()) {
            final DrawingView view = getView();
            final LinkedList<Figure> ungroupedFigures = new LinkedList<>(view.getSelectedFigures());
            final CompositeFigure group = (CompositeFigure) prototype.clone();
            UndoableEdit edit = createGroupEdit(view, group, ungroupedFigures);
            groupFigures(view, group, ungroupedFigures);
            fireUndoableEditHappened(edit);
        }
    }

    private UndoableEdit createGroupEdit(DrawingView view, CompositeFigure group, LinkedList<Figure> ungroupedFigures) {
        return new AbstractUndoableEdit() {
            private static final long serialVersionUID = 1L;

            @Override
            public String getPresentationName() {
                ResourceBundleUtil labels
                        = ResourceBundleUtil.getBundle(DRAW_LABELS);
                return labels.getString("edit.groupSelection.text");
            }

            @Override
            public void redo() throws CannotRedoException {
                super.redo();
                groupFigures(view, group, ungroupedFigures);
            }

            @Override
            public void undo() throws CannotUndoException {
                ungroupFigures(view, group);
                super.undo();
            }
        };
    }
}
