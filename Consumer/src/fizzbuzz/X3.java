package fizzbuzz;

public class X3 extends AbstractFizzBuzz {
    @Override
    public int getPriority() { return 3; }

    @Override
    public boolean match(int n) { return n % 3 == 0; }

    @Override
    public String message() { return "Fizz"; }
}
