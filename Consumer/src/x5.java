public class x5 implements IFizzBuzz{
    @Override
    public boolean match(int n) {
        return n % 5 == 0;
    }

    @Override
    public String message() {
        return "Buzz";
    }
}
