package userinterface;

import geometry.Line;
import visual.IGraphicContext;
import visual.VisualCurve;

public class VisualLine extends VisualCurve {
    public VisualLine(Line curve, Integer numberOfPoints) {
        super(curve, numberOfPoints);
    }

    @Override
    public void draw(IGraphicContext context) {
        context.visualizeFirstPoint(getPoint(0.0));
        context.visualizeLastPoint(getPoint(1.0));
        for (int i = 0; i < getNumberOfPoints() - 1; i++) {
            context.visualizeSegment(getPoint((double) i / getNumberOfPoints()), getPoint((double) (i + 1) / getNumberOfPoints()));
        }
    }
}
