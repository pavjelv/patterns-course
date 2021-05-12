package geometry;

public class MoveTo implements ICurve{
    private ICurve source;
    IPoint startPosition;

    public MoveTo(ICurve source, IPoint startPosition) {
        this.source = source;
        this.startPosition = startPosition;
    }

    @Override
    public IPoint getPoint(Double t) {
        IPoint result = source.getPoint(t);
        result.setX(result.getX() + startPosition.getX());
        result.setY(result.getY() + startPosition.getY());
        return result;
    }
}
