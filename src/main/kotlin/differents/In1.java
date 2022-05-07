package differents;

interface In1
{
    int a = 10;

    default void display()
    {
        //a = 1;
        System.out.println("hello");
    }
}