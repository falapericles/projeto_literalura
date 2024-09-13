package com.challenge.literalura.principal;

import com.challenge.literalura.model.DadoLivro;
import com.challenge.literalura.service.ConsumoApi;
import com.challenge.literalura.service.ConverteDados;

import java.util.Scanner;

public class Principal {
    private ConsumoApi consumo = new ConsumoApi();
    private final String ENDERECO = "https://gutendex.com/books/";
    private ConverteDados conversor = new ConverteDados();
    private Scanner leitura = new Scanner(System.in);
    public void exibeMenu() throws Exception {
        var opcao = -1;
        while(opcao != 0) {
            var menu = """
                    1 - Buscar livro
                    
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarLivro();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }

    }

    private void buscarLivro() {
        System.out.println("Digite o nome do autor ou do livro para busca");
        var nomeLivro = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + "?search="+nomeLivro.replace(" ", "+"));
        DadoLivro dados = conversor.obterDados(json, DadoLivro.class);
        System.out.println(dados);
    }
}
