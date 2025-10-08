
package model;

import java.util.Dictionary;
import java.util.Hashtable;

public class ArvoreBalanceada extends ArvoreBinaria {
    private int altura(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(altura(node.getLeft()), altura(node.getRight()));
    }
    private int fatorBalanceamento(Node node) {
        if (node == null) return 0;
        return altura(node.getLeft()) - altura(node.getRight());
    }
    private Node rotacaoDireita(Node y) {
        Node x = y.getLeft();
        Node T2 = x.getRight();
        x.setRight(y);
        y.setLeft(T2);
        return x;
    }
    private Node rotacaoEsquerda(Node x) {
        Node y = x.getRight();
        Node T2 = y.getLeft();
        y.setLeft(x);
        x.setRight(T2);
        return y;
    }
    @Override
    protected Node inserirRec(Node node, int data) {
        if (node == null) return new Node(data);
        if (data < node.getData()) { node.setLeft(inserirRec(node.getLeft(), data)); }
        else if (data > node.getData()) { node.setRight(inserirRec(node.getRight(), data)); }
        int balance = fatorBalanceamento(node);
        if (balance > 1) { if (data < node.getLeft().getData()) { node.setLeft(rotacaoEsquerda(node.getLeft())); } return rotacaoDireita(node); }
        if (balance < -1) { if (data < node.getRight().getData()) { node.setRight(rotacaoDireita(node.getRight())); } return rotacaoEsquerda(node); }
        return node;
    }
}
