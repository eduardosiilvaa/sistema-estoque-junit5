package com.example.danhpaiva;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class SistemaEstoqueTest {
    private SistemaEstoque sistemaEstoque;

    @Before
    public void setUp() {
        sistemaEstoque = new SistemaEstoque();
    }

    @Test
    public void testAdicionarProduto() {
        sistemaEstoque.adicionarProduto("Iphone 16e", 5);
        int quantidade = sistemaEstoque.consultarEstoque("Iphone 16e");
        assertEquals(5, quantidade);
    }

    @Test
    public void testAdicionarProdutoComQuantidadeNegativa() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistemaEstoque.adicionarProduto("Iphone 16e", -5);
        });
        assertEquals("A quantidade deve ser maior que zero.", exception.getMessage());
    }

    @Test
    public void testRemoverProduto() {
        sistemaEstoque.adicionarProduto("Iphone 16e", 5);
        sistemaEstoque.removerProduto("Iphone 16e", 3);
        int quantidade = sistemaEstoque.consultarEstoque("Iphone 16e");
        assertEquals(2, quantidade);
    }

    @Test
    public void testRemoverProdutoComEstoqueInsuficiente() {
        sistemaEstoque.adicionarProduto("Iphone 16e", 5);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistemaEstoque.removerProduto("Iphone 16e", 10);
        });
        assertEquals("Estoque insuficiente para remover 10 unidade(s) de Iphone 16e.", exception.getMessage());
    }

    @Test
    public void testVerificarDisponibilidade() {
        sistemaEstoque.adicionarProduto("Iphone 16e", 5);
        boolean disponivel = sistemaEstoque.verificarDisponibilidade("Iphone 16e", 3);
        assertEquals(true, disponivel);
    }

    @Test
    public void testObterHistoricoTransacoes() {
        sistemaEstoque.adicionarProduto("Iphone 16e", 5);
        sistemaEstoque.removerProduto("Iphone 16e", 2);
        assertEquals(2, sistemaEstoque.obterHistoricoTransacoes().size());
    }
}
