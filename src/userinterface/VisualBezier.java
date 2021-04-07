package userinterface;

import geometry.Bezier;
import visual.IGraphicContext;
import visual.VisualCurve;

public class VisualBezier extends VisualCurve {
    public VisualBezier(Bezier curve) {
        super(curve);
    }

    @Override
    public void draw(IGraphicContext context) {
        for (int i = 0; i < 100; i++) {
            context.visualizePoint(getPoint(0 + 0.01 * i));
        }
    }
}
