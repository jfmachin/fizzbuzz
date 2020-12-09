package fizzbuzz;

public interface IFizzBuzz extends Comparable {
    // the higher, the worse
    int getPriority();
    boolean match(int n);
    String message();
}
