package visual;

import geometry.ICurve;
import geometry.IPoint;

public abstract class VisualCurve implements ICurve, IDrawable {
    private ICurve curve;

    public VisualCurve(ICurve curve) {
        this.curve = curve;
    }

    @Override
    public final IPoint getPoint(Double t) {
        return curve.getPoint(t);
    }
}
