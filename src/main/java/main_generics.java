import generics.Generics;
import generics.NumericFns;

public class main_generics
{
    public static void main(String[] args)
    {
        Generics<Integer> object = new Generics<>(10);

        NumericFns<Double> dOb = new NumericFns<>(10.0);
        NumericFns<Integer> iOb = new NumericFns<>(10);
        System.out.println(iOb.square());

        System.out.println(iOb.absEqual(dOb));
    }
}
