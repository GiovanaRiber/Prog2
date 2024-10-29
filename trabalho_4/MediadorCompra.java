package com.trabalho_4;

class MediadorCompra implements Mediador {
    private Carrinho carrinho;
    private Checkout checkout;

    public MediadorCompra(Carrinho carrinho, Checkout checkout) {
        this.carrinho = carrinho;
        this.checkout = checkout;

        this.carrinho.setMediador(this); // referencia ao mediador
    }

    @Override
    public void notificar(String evento) {
        if (evento.equals("produto_adicionado")) {
            checkout.atualizarTotal(carrinho.calcularTotal());
        }
    }
}
