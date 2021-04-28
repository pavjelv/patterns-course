package userinterface;

import geometry.IPoint;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import visual.IDrawable;
import visual.IGraphicContext;

public class FormGraphicContext2 implements IGraphicContext {
    GraphicsContext graphicsContext;

    public FormGraphicContext2(final GraphicsContext gc) {
        this.graphicsContext = gc;
        initGraphics();
    }

    private void initGraphics () {
        this.graphicsContext.setStroke(Color.BLACK);
        this.graphicsContext.setFill(Color.BLACK);
    }

    @Override
    public void visualizeFirstPoint(IPoint point) {
        graphicsContext.fillRect(point.getX(), point.getY(), 7, 7);
    }

    @Override
    public void visualizePoint(IPoint point) {
        graphicsContext.fillOval(point.getX(), point.getY(), 1, 1);
    }

    @Override
    public void visualizeLastPoint(IPoint point) {
        this.visualizeFirstPoint(point);
    }

    @Override
    public void visualizeSegment(IPoint p1, IPoint p2) {
        graphicsContext.setLineDashes(2d);
        graphicsContext.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
}
