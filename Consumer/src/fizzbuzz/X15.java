package fizzbuzz;

public class X15 extends AbstractFizzBuzz {
    @Override
    public int getPriority() { return 1; }

    @Override
    public boolean match(int n) {
        return n % 15 == 0;
    }

    @Override
    public String message() {
        return "FizzBuzz";
    }
}
