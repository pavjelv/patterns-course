package userinterface;

import geometry.IPoint;
import javafx.scene.canvas.GraphicsContext;
import visual.IGraphicContext;

public class FormGraphicContext implements IGraphicContext {
    GraphicsContext innerContext;

    public FormGraphicContext(GraphicsContext innerContext) {
        this.innerContext = innerContext;
    }

    @Override
    public void visualizePoint(IPoint point) {
        innerContext.fillOval(point.getX(), point.getY(), 1, 1);
    }
}
