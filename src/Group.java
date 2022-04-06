import java.util.ArrayList;
import java.util.List;

public class Group implements Comparable<Group> {

    private final List<Node> groupState;

    public Group() {
        this.groupState = new ArrayList<>();
    }

    public void add(Node node) {
        if (node.getType()) {
            groupState.add(node);
        }
    }

    public int size() {
        return groupState.size();
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Node x : groupState) {
            stringBuilder.append(x.getName()).append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public int compareTo(Group o) {
        return Integer.compare(o.size(), this.size());
    }
}
