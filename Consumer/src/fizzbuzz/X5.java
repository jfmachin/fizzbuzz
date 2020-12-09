package fizzbuzz;

public class X5 extends AbstractFizzBuzz {
    @Override
    public int getPriority() { return 2; }

    @Override
    public boolean match(int n) {
        return n % 5 == 0;
    }

    @Override
    public String message() {
        return "Buzz";
    }

}
