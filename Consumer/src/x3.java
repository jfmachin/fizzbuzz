public class x3 implements IFizzBuzz{
    @Override
    public boolean match(int n) {
        return n % 3 == 0;
    }

    @Override
    public String message() {
        return "Fizz";
    }
}
