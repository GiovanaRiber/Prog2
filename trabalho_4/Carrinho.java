package com.trabalho_4;

class Carrinho {
    private double total;
    private Mediador mediador;

    public void setMediador(Mediador mediador) {
        this.mediador = mediador;
    }

    public void adicionarProduto(double preco) {
        total += preco;
        System.out.println("Produto adicionado: R$" + preco);
        if (mediador != null) {
            mediador.notificar("produto_adicionado"); // se comunica com o mediador
        }
    }

    public double calcularTotal() {
        return total;
    }
}
