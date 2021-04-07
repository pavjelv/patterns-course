package geometry;

public abstract class ACurve implements ICurve{
    private IPoint a;
    private IPoint b;

    public ACurve(IPoint a, IPoint b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public IPoint getPoint(Double t) {
        if (t < 0.0 || t > 1.0)
            throw new IllegalArgumentException("Parameter should be more than zero and less that one.");
        return calculatePoint(t, a, b);
    }

    protected abstract IPoint calculatePoint(Double t, IPoint a, IPoint b);
}
