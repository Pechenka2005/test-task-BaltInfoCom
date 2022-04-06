
public class Pointer {
    private final String name;
    private final int number;

    Pointer(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pointer)) return false;

        Pointer pointer = (Pointer) o;

        if (getNumber() != pointer.getNumber()) return false;
        return getName().equals(pointer.getName());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getNumber();
        return result;
    }
}
