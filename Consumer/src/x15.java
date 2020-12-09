public class x15 implements IFizzBuzz{
    @Override
    public boolean match(int n) {
        return n % 15 == 0;
    }

    @Override
    public String message() {
        return "FizzBuzz";
    }
}
