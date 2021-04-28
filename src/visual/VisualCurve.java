package visual;

import geometry.ICurve;
import geometry.IPoint;

public abstract class VisualCurve implements ICurve, IDrawable {
    private ICurve curve;
    Integer numberOfPoints;

    public VisualCurve(ICurve curve, Integer numberOfPoints) {
        this.curve = curve;
        this.numberOfPoints = numberOfPoints;
    }

    protected Integer getNumberOfPoints() {
        return numberOfPoints;
    }

    @Override
    public final IPoint getPoint(Double t) {
        return curve.getPoint(t);
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
