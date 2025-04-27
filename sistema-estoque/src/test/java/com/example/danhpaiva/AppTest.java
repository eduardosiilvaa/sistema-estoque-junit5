package com.example.danhpaiva;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testMain() {
        // Chama o método main para simular a execução do programa
        App.main(new String[0]);

        // Verifica a saída, ignorando quebras de linha extras
        String expectedOutput = "Adicionado 5 unidade(s) de Iphone 16e";


        assertEquals(expectedOutput, outContent.toString().trim());
    }
}
