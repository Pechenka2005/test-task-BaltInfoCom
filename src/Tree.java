import java.util.*;

public class Tree {
    private final Map<Pointer, Node> store = new HashMap<>();

    public void add(CSVString csvString) {
        String fullString = csvString.getFullString();
        Pointer fullPointer = new Pointer(fullString, 0);
        if (store.containsKey(fullPointer)) {
            return;
        }
        Node node = new Node(true, fullString);
        store.put(fullPointer, node);
        addNeighbours(node, fullPointer, new Pointer(csvString.getFirst(), 1));
        addNeighbours(node, fullPointer, new Pointer(csvString.getSecond(), 2));
        addNeighbours(node, fullPointer, new Pointer(csvString.getThird(), 3));
    }

    private void addNeighbours(Node parent, Pointer parentPointer, Pointer pointer) {
        String childName = pointer.getName();
        if (!childName.equals("\"\"") && !childName.equals("")) {
            Node x;
            if (store.containsKey(pointer)) {
                x = store.get(pointer);
            } else {
                x = getChildNode(childName);
                store.put(pointer, x);
            }
            parent.addNeighbour(pointer);
            x.addNeighbour(parentPointer);
        }
    }

    private Node getChildNode(String str) {
        return new Node(false, str);
    }

    public List<Group> detour() {
        List<Group> result = new ArrayList<>();
        for (Map.Entry<Pointer, Node> entry : store.entrySet()) {
            Node node = entry.getValue();
            if (node.isVisit()) {
                continue;
            }
            result.add(dfs(node, new Group()));
        }
        return result;
    }

    private Group dfs(Node node, Group group) {
        node.changeVisit();
        group.add(node);
        List<Pointer> children = node.getNeighbours();
        for (Pointer p : children) {
            Node x = store.get(p);
            if (!x.isVisit()) {
                dfs(x, group);
            }
        }
        return group;
    }
}
