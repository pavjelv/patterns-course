package geometry;

public class Fragment implements ICurve{
    private ICurve source;
    private double start;
    private double finish;
    boolean reverse;

    public Fragment(ICurve source, double start, double finish) {
        this.source = source;
        if (start > 1 || start < 0 || finish < 0 || finish > 1) {
            throw new IllegalArgumentException("Provided incorrect start or finish!!");
        }
        this.start = start;
        this.finish = finish;
        reverse = start > finish;
    }

    @Override
    public IPoint getPoint(Double t) {
        if (reverse) {
            t = 1.0 - t;
            if (t >= start) return source.getPoint(start);
            if (t <= finish) return source.getPoint(finish);
        } else {
            if (t <= start) return source.getPoint(start);
            if (t >= finish) return source.getPoint(finish);
        }
        return source.getPoint(t);
    }
}
