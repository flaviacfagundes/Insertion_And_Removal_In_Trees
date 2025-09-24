package model;

public class ArvoreBalanceada extends ArvoreBinaria {
    private int altura(Node node) {
        if (node == null) return 0;
        int left = altura(node.getLeft());
        int right = altura(node.getRight());
        return 1 + Math.max(left, right);
    }

    private int fatorBalanceamento (Node node) {
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
        y.setRight(T2);

        return y;
    }

    @Override
    protected Node inserirRec(Node node, int data) {
        if (node == null) return new Node("Raiz", data);

        if (data < node.getData()) node.setLeft(inserirRec(node.getLeft(), data));
        else if (data > node.getData()) node.setRight(inserirRec(node.getRight(), data));
        else return node;

        int balance = fatorBalanceamento(node);

        if (balance > 1 && data < node.getLeft().getData()) return rotacaoDireita(node);
        if (balance < -1 && data > node.getRight().getData()) return rotacaoEsquerda(node);

        if (balance > 1 && data > node.getLeft().getData()) {
            node.setLeft(rotacaoEsquerda(node.getLeft()));
            return rotacaoDireita(node);
        }

        if (balance < -1 && data < node.getRight().getData()) {
            node.setRight(rotacaoDireita(node.getRight()));
            return  rotacaoEsquerda(node);
        }

        return node;
    }

    @Override
    public void inserir(int data) {
        raiz = inserirRec(raiz, data);
    }

}
