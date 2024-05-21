package com.conversorDeMoeda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Menu();

        int opcao = scanner.nextInt();
        String[] moedas = EscolhaMoeda(opcao);

        PerguntaValor();

        double valor = scanner.nextDouble();

        Request.RequestApi(moedas[0], moedas[1], valor);

    }

    private static void Menu() {
        System.out.println("1 - Converter de Real para Dólar");
        System.out.println("2 - Converter de Dólar para Real");
        System.out.println("3 - Converter de Real para Euro");
        System.out.println("4 - Converter de Euro para Real");
        System.out.println("5 - Converter de Dólar para Euro");
        System.out.println("6 - Converter de Euro para Dólar");
    }

    private static void PerguntaValor() {
        System.out.println("Digite o valor a ser convertido: ");
    }

    private static String[] EscolhaMoeda(int opcao) {
        String[] moedas = new String[2];
        switch (opcao) {
            case 1:
                moedas[0] = "BRL";
                moedas[1] = "USD";
                break;
            case 2:
                moedas[0] = "USD";
                moedas[1] = "BRL";
                break;
            case 3:
                moedas[0] = "BRL";
                moedas[1] = "EUR";
                break;
            case 4:
                moedas[0] = "EUR";
                moedas[1] = "BRL";
                break;
            case 5:
                moedas[0] = "USD";
                moedas[1] = "EUR";
                break;
            case 6:
                moedas[0] = "EUR";
                moedas[1] = "USD";
                break;
            default:
                moedas[0] = "BRL";
                moedas[1] = "USD";
        }
        return moedas;
    }
}