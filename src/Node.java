import java.util.ArrayList;
import java.util.List;

public class Node {
    private final boolean type; //true - full string, false - peace string
    private final List<Pointer> neighbours;
    private boolean visit;
    private final String name;

    public Node(boolean type, String name) {
        this.type = type;
        this.visit = false;
        this.neighbours = new ArrayList<>();
        this.name = name;
    }

    public void addNeighbour(Pointer pointer) {
        neighbours.add(pointer);
    }

    public List<Pointer> getNeighbours() {
        return neighbours;
    }

    public boolean getType() {
        return type;
    }

    public boolean isVisit() {
        return visit;
    }

    public String getName() {
        return name;
    }

    public void changeVisit() {
        this.visit = true;
    }
}
