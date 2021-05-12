package geometry;

public class MoveTo implements ICurve{
    private ICurve source;
    IPoint startPosition;
    private double dx;
    private double dy;

    public MoveTo(ICurve source, IPoint startPosition) {
        this.source = source;
        this.startPosition = startPosition;

        IPoint startCurve = source.getPoint(0.0);
        dx = startCurve.getX() - startPosition.getX();
        dy = startCurve.getY() - startPosition.getY();
    }

    @Override
    public IPoint getPoint(Double t) {
        IPoint result = source.getPoint(t);
        result.setX(result.getX() - dx);
        result.setY(result.getY() - dy);
        return result;
    }
}
