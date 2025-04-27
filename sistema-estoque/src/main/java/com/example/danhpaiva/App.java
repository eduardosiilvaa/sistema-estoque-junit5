package com.example.danhpaiva;

public class App {
    public static void main(String[] args) {
        SistemaEstoque sistemaEstoque = new SistemaEstoque();

        sistemaEstoque.adicionarProduto("Iphone 16e", 5);
        for (String transacao : sistemaEstoque.obterHistoricoTransacoes()) {
            System.out.println(transacao);
        }
        
    }
}
