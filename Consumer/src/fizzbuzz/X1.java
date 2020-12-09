package fizzbuzz;

public class X1 extends AbstractFizzBuzz {
    private int n;
    @Override
    public int getPriority() { return 4; }

    @Override
    public boolean match(int n) {
        this.n = n;
        return true;
    }

    @Override
    public String message() { return Integer.toString(n); }
}
