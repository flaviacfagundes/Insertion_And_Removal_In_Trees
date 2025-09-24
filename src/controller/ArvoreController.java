package controller;

import model.Node;
import model.service.ArvoreService;

public class ArvoreController {
    private ArvoreService service;

    public ArvoreController(ArvoreService service) {
        this.service = service;
    }

    public void inserirNumero(int data, boolean balanceada) {
        service.inserir(data, balanceada);
    }

    public void removerNumero(int data, boolean balanceada) {
        service.remover(data, balanceada);
    }

    public Node getRaiz(boolean balanceada) {
        return service.getRaiz(balanceada);
    }
}
