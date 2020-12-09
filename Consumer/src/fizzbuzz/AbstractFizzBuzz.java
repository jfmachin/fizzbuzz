package fizzbuzz;

public abstract class AbstractFizzBuzz implements IFizzBuzz {
    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.getPriority(), ((IFizzBuzz) o).getPriority());
    }
}
