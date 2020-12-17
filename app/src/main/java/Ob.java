public class Ob {
    private int x;
    private Ob2 y;

    public Ob(int x, Ob2 y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Ob{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
