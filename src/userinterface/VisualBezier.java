package userinterface;

import geometry.Bezier;
import visual.IGraphicContext;
import visual.VisualCurve;

public class VisualBezier extends VisualCurve {
    public VisualBezier(Bezier curve, Integer numberOfPoints) {
        super(curve, numberOfPoints);
    }

    @Override
    public void draw(IGraphicContext context) {
        context.visualizeFirstPoint(getPoint(0.0));
        context.visualizeLastPoint(getPoint(1.0));
        for (int i = 0; i < getNumberOfPoints(); i++) {
            context.visualizeSegment(getPoint((double) i / getNumberOfPoints()), getPoint((double) (i + 1) / getNumberOfPoints()));
        }
    }
}
