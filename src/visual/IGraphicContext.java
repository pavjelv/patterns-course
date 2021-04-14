package visual;

import geometry.IPoint;

public interface IGraphicContext {
    void visualizeFirstPoint(IPoint point);
    void visualizeLastPoint(IPoint point);
    void visualizeSegment(IPoint p1, IPoint p2);
    void visualizePoint(IPoint point);
    void save(IDrawable drawable);
}
