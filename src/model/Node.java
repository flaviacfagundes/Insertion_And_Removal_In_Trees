package model;

import java.util.Objects;

public class Node {
    private String type;
    private int data;
    private Node left;
    private Node right;
    public Node(String type, int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    //? GETTERS AND SETTERS
    public void     setType(String type)    { this.type = type; }
    public String   getType()               { return this.type; }
    public void     setData(int data)       { this.data = data; }
    public int      getData()               { return this.data; }
    public void     setLeft(Node left)      { this.left = left;     updateType(); }
    public Node     getLeft()               { return this.left; }
    public void     setRight(Node right)    { this.right = right;   updateType(); }
    public Node     getRight()              { return this.right; }

    private void updateType() {
        if ((right != null || left != null) && !Objects.equals(type, "Raiz")) { type = "Pai"; }
        if ((right == null && left == null) && !Objects.equals(type, "Raiz")) {  type = "filho"; }
    }
}
