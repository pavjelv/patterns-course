package geometry;

public class Line extends ACurve {
    public Line(IPoint a, IPoint b) {
        super(a, b);
    }

    @Override
    protected IPoint calculatePoint(Double t, IPoint a, IPoint b) {
        IPoint result = new Point();
        result.setX((1 - t) * a.getX() + t * b.getX());
        result.setY((1 - t) * a.getY() + t * b.getY());
        return result;
    }
}
