package geometry;

public class Fragment implements ICurve{
    private ICurve source;
    private double start;
    private double finish;

    public Fragment(ICurve source, double start, double finish) {
        this.source = source;
        this.start = start;
        this.finish = finish;
    }

    @Override
    public IPoint getPoint(Double t) {
        if (t <= start) return source.getPoint(start);
        if (t >= finish) return source.getPoint(finish);
        return source.getPoint(t);
    }
}
