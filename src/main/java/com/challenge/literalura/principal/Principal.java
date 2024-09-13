package com.challenge.literalura.principal;

import com.challenge.literalura.model.Autor;
import com.challenge.literalura.model.DadoLivro;
import com.challenge.literalura.model.Livro;
import com.challenge.literalura.repository.AutorRepository;
import com.challenge.literalura.repository.LivroRepository;
import com.challenge.literalura.service.ConsumoApi;
import com.challenge.literalura.service.ConverteDados;
import com.challenge.literalura.service.LivroResposta;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class Principal {
    private final LivroRepository repositorio;
    private ConsumoApi consumo = new ConsumoApi();
    private final String ENDERECO = "https://gutendex.com/books/";
    private ConverteDados conversor = new ConverteDados();
    private Scanner leitura = new Scanner(System.in);
    private LivroResposta resposta;
    private Optional<Autor> autorBuscado;
    private AutorRepository autorRepositorio;
    private List<Livro> livros;
    private List<Autor> autores;
    public Principal(LivroRepository repositorio, AutorRepository autorRepositorio) {
        this.repositorio = repositorio;
        this.autorRepositorio=autorRepositorio;
    }

    public void exibeMenu() throws Exception {
        var opcao = -1;
        while(opcao != 0) {
            var menu = """
                    1 - Buscar e salvar livro da web
                    2 - Listar todos os livros armazenados
                    3 - Buscar por livros no banco de dados
                    4 - Listar autores cadastrados
                    5 - Insira um ano e descubra autores vivos
                    6 - Estatisticas sobre idiomas
                    
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarLivro();
                    break;
                case 2:
                    livrosDoBanco();
                    break;
                case 3:
                    buscarLivrosNoBanco();
                    break;
                case 4:
                    listaDeAutores();
                    break;
                case 5:
                    listaAutoresPorAno();
                    break;
                case 6:
                    estatisticaIdiomas();
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
        var json = consumo.obterDados(ENDERECO + "?search=" + nomeLivro.replace(" ", "+"));
        resposta = conversor.obterDados(json, LivroResposta.class);
        List<DadoLivro> dado = resposta.results();
        livros = dado.stream()
                .map(d -> new Livro(d))
                .collect(Collectors.toList());

        // Verificar se o livro e autor já existem antes de salvar
        livros.forEach(l -> {
            Autor autor = l.getAutor();
            Optional<Autor> autorBuscado = autorRepositorio.findByNome(l.getAutorNome());
            if (autorBuscado.isEmpty()) {
                autor = autorRepositorio.save(autor);
            } else {
                autor = autorBuscado.get();
            }
            l.setAutor(autor);
            // Verifica no repositório se o livro já está salvo, usando o título como exemplo
            if (!repositorio.existsByTitulo(l.getTitulo())) {
                repositorio.save(l);
            }
            else
            {
                System.out.println("O livro '" + l.getTitulo() + "' já está no banco de dados.");
            }
        });
        // Exibir todos os livros da busca
      livros.forEach(System.out::println);
    }

    private void livrosDoBanco() {
        livros=repositorio.findAll();
        livros.forEach(System.out::println);
    }

    private void buscarLivrosNoBanco() {
        System.out.println("Qual livro deseja buscar?");
        String busca = leitura.nextLine();
        try {
            List<Livro> livrosEncontrados = repositorio.findByTituloContainingIgnoreCase(busca);
            if (livrosEncontrados.isEmpty()) {
                System.out.println("Nenhum livro encontrado com o título: " + busca);
            } else {
                System.out.println("Esses foram os resultados encontrados: ");
                livrosEncontrados.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar livro: " + e.getMessage());
        }
    }

    private void listaDeAutores(){
        autores=autorRepositorio.findAll();
        autores.forEach(System.out::println);

    }

    private void listaAutoresPorAno() {
        System.out.println("Qual ano deseja procurar?");
        int ano = leitura.nextInt();
        leitura.nextLine();
        autores = autorRepositorio.encontreOsVivos(ano);
        autores.forEach(System.out::println);
    }

    private void estatisticaIdiomas(){
        System.out.println("Digite a sigla do idioma:");
        String sigla = leitura.nextLine();
        int contagem = repositorio.countByIdiomaContainingIgnoreCase(sigla);
        System.out.println("Para o idioma '"+sigla+"' temos "+contagem+" livros " +
                "cadastrados em nosso banco");
    }
}
