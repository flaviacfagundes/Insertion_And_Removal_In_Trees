package model.service;

import model.ArvoreBalanceada;
import model.ArvoreBinaria;
import model.Node;

public class ArvoreService {
    private final ArvoreBinaria arvoreBinaria;
    private final ArvoreBalanceada arvoreBalanceada;

    public ArvoreService() {
        arvoreBinaria = new ArvoreBinaria();
        arvoreBalanceada = new ArvoreBalanceada();
    }

    public void inserir(int data, boolean balanceada) {
        if (balanceada) arvoreBalanceada.inserir(data);
        else arvoreBinaria.inserir(data);
    }

    public void remover(int data, boolean balanceada) {
        if (balanceada) arvoreBalanceada.remover(data);
        else arvoreBinaria.remover(data);
    }

    public Node getRaiz(boolean balanceada) {
        return balanceada ? arvoreBalanceada.getRaiz() : arvoreBinaria.getRaiz();
    }
}
