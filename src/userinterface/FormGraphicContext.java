package userinterface;

import geometry.IPoint;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import visual.IDrawable;
import visual.IGraphicContext;

public class FormGraphicContext implements IGraphicContext {
    GraphicContextWrapper wrapper;

    private interface GraphicContextWrapper {
        void fillOval(double x, double y, double w, double h);
        void setStroke(Paint p);
        void strokeLine(double x1, double y1, double x2, double y2);
        void setFill(Color color);
    }

    public FormGraphicContext(final GraphicsContext gc) {
        this.wrapper = new GraphicContextWrapper() {
            @Override
            public void fillOval(double x, double y, double w, double h) {
                gc.fillOval(x, y, w, h);
            }

            @Override
            public void setStroke(Paint p) {
                gc.setStroke(p);
            }

            @Override
            public void strokeLine(double x1, double y1, double x2, double y2) {
                gc.strokeLine(x1, y1, x2, y2);
            }

            @Override
            public void setFill(Color color) {
                gc.setFill(color);
            }
        };
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

    @Override
    public void save(IDrawable drawable) {
        GraphicContextWrapper oldWrapper = this.wrapper;
        this.wrapper = new GraphicContextWrapper() {
            @Override
            public void fillOval(double x, double y, double w, double h) {
                // fill to SVG file
            }

            @Override
            public void setStroke(Paint p) { }

            @Override
            public void strokeLine(double x1, double y1, double x2, double y2) { }

            @Override
            public void setFill(Color color) { }
        };
        initGraphics();
        drawable.draw(this);
        this.wrapper = oldWrapper;
    }
}
