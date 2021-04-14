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
}
