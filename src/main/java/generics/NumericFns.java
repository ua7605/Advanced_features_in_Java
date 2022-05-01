package generics;

public class NumericFns<T extends Number>
{
    T num;

    public NumericFns(T num)
    {
        this.num = num;
    }

    public double square()
    {
        return num.intValue() * num.intValue();
    }

    public boolean absEqual(NumericFns<?> ob)
    {
        return Math.abs(num.doubleValue()) == Math.abs(ob.num.doubleValue());
    }
}
