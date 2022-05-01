package generics;

public class Generics<T>
{
    T ob;

    public Generics(T ob)
    {
        this.ob = ob;
        showType();
    }

    void showType()
    {
        System.out.println(ob.getClass().getName());
    }
}
