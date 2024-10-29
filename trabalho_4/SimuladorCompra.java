package com.trabalho_4;

public class SimuladorCompra {
    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();
        Checkout checkout = new Checkout();
        MediadorCompra mediador = new MediadorCompra(carrinho, checkout);

        carrinho.adicionarProduto(29.99);
        carrinho.adicionarProduto(89.99);
    }
}
