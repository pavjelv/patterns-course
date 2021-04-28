package userinterface;

import geometry.IPoint;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import visual.IGraphicContext;

public class FormGraphicContext implements IGraphicContext {
    GraphicsContext wrapper;

    public FormGraphicContext(final GraphicsContext gc) {
        this.wrapper = gc;
        initGraphics();
    }

    private void initGraphics () {
        this.wrapper.setStroke(Color.GREEN);
        this.wrapper.setFill(Color.GREEN);
    }

    @Override
    public void visualizeFirstPoint(IPoint point) {
        wrapper.fillOval(point.getX(), point.getY(), 7, 7);
    }

    @Override
    public void visualizePoint(IPoint point) {
        wrapper.fillOval(point.getX(), point.getY(), 1, 1);
    }

    @Override
    public void visualizeLastPoint(IPoint point) {
        wrapper.strokeLine(point.getX(), point.getY(), point.getX() - 10, point.getY() - 10);
        wrapper.strokeLine(point.getX(), point.getY(), point.getX() - 5, point.getY());
        wrapper.strokeLine(point.getX(), point.getY(), point.getX(), point.getY() - 5);
    }

    @Override
    public void visualizeSegment(IPoint p1, IPoint p2) {
        wrapper.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
}
