public class Node20 {
    int value;
    Node20 left;
    Node20 right;

    public Node20() {
    }

    public Node20(Node20 left, int value, Node20 right) {
        this.left = left;
        this.value = value;
        this.right = right;
    }
}