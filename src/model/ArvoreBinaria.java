
package model;

public class ArvoreBinaria {
    protected Node raiz;
    public Node getRaiz() {
        return raiz;
    }
    public void inserir(int data) {
        raiz = inserirRec(raiz, data);
    }
    protected Node inserirRec(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.getData()) {
            node.setLeft(inserirRec(node.getLeft(), data));
        } else if (data > node.getData()) {
            node.setRight(inserirRec(node.getRight(), data));
        }
        return node;
    }
    public void remover(int data) {
        raiz = removerRec(raiz, data);
    }
    private Node removerRec(Node node, int data) {
        if (node == null) return null;

        if (data < node.getData()) {
            node.setLeft(removerRec(node.getLeft(), data));
        } else if (data > node.getData()) {
            node.setRight(removerRec(node.getRight(), data));
        } else {
            if (node.getLeft() == null) return node.getRight();
            if (node.getRight() == null) return node.getLeft();

            Node minNode = minValueNode(node.getRight());
            node.setData(minNode.getData());
            node.setRight(removerRec(node.getRight(), minNode.getData()));
        }
        return node;
    }
    private Node minValueNode(Node node) {
        Node current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }
}
