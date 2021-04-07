package geometry;

public class Bezier extends ACurve{
    private IPoint c;
    private IPoint d;

    public Bezier(IPoint a, IPoint b, IPoint c, IPoint d) {
        super(a, b);
        this.c = c;
        this.d = d;
    }

    @Override
    protected IPoint calculatePoint(Double t, IPoint a, IPoint b) {
        IPoint result = new Point();
        result.setX(Math.pow(1 - t, 3) * a.getX() + 3 * t * Math.pow(1 - t, 2) * c.getX() + 3 * t * t * (1 - t) * d.getX() + t * t * t * b.getX());
        result.setY(Math.pow(1 - t, 3) * a.getY() + 3 * t * Math.pow(1 - t, 2) * c.getY() + 3 * t * t * (1 - t) * d.getY() + t * t * t * b.getY());
        return result;
    }
}
