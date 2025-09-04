import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TesteArvoreBinariaUser {

    public static void main(String[] args) {
        System.out.println("=== TESTE DA ÁRVORE BINÁRIA COM USUÁRIOS ===\n");
        
        // Criar uma árvore binária para objetos User
        ArvoreBinariaUser arvore = new ArvoreBinariaUser();

        // Criar 10 usuários
        User[] usuarios = {
            new User(1L, "Maria Silva", "maria"),
            new User(2L, "João Santos", "joao"),
            new User(3L, "Ana Costa", "ana"),
            new User(4L, "Pedro Lima", "pedro"),
            new User(5L, "Carlos Souza", "carlos"),
            new User(6L, "Lucia Ferreira", "lucia"),
            new User(7L, "Bruno Oliveira", "bruno"),
            new User(8L, "Fernanda Alves", "fernanda"),
            new User(9L, "Roberto Martins", "roberto"),
            new User(10L, "Juliana Pereira", "juliana")
        };

        List<User> listaUsuarios = Arrays.asList(usuarios);
        Collections.shuffle(listaUsuarios);

        System.out.println("=== INSERINDO USUÁRIOS NA ÁRVORE (ORDEM ALEATÓRIA) ===");
        for (User usuario : listaUsuarios) {
            arvore.inserir(usuario);
            System.out.println("Inserido: " + usuario);
        }

        System.out.println("\n=== IMPRESSÕES DA ÁRVORE ===");
        
        arvore.imprime_preFixado();
        
        arvore.imprime_inOrdem();
        
        arvore.imprime_posFixado();

        System.out.println("\n=== TESTES DE PESQUISA ===");
        
        User usuarioBusca1 = new User(0L, "", "maria");
        NodoArvoreUser encontrado1 = arvore.pesquisa(usuarioBusca1);
        if (encontrado1 != null) {
            System.out.println("Usuário 'maria' encontrado: " + encontrado1.usuario);
        } else {
            System.out.println("Usuário 'maria' não encontrado");
        }
        
        User usuarioBusca2 = new User(0L, "", "inexistente");
        NodoArvoreUser encontrado2 = arvore.pesquisa(usuarioBusca2);
        if (encontrado2 != null) {
            System.out.println("Usuário 'inexistente' encontrado: " + encontrado2.usuario);
        } else {
            System.out.println("Usuário 'inexistente' não encontrado (esperado)");
        }

        System.out.println("\n=== TESTE DE REMOÇÃO ===");
        
        System.out.println("Árvore antes da remoção:");
        arvore.imprime_inOrdem();
        
        User usuarioRemover = new User(0L, "", "maria");
        System.out.println("Removendo usuário 'maria'...");
        arvore.remover(usuarioRemover);
        
        System.out.println("Árvore após remoção de 'maria':");
        arvore.imprime_inOrdem();
        
        User usuarioRemover2 = new User(0L, "", "ana");
        System.out.println("Removendo usuário 'ana'...");
        arvore.remover(usuarioRemover2);
        
        System.out.println("Árvore após remoção de 'ana':");
        arvore.imprime_inOrdem();
        
        System.out.println("\n=== VERIFICAÇÃO PÓS-REMOÇÃO ===");
        NodoArvoreUser verificacao1 = arvore.pesquisa(new User(0L, "", "maria"));
        NodoArvoreUser verificacao2 = arvore.pesquisa(new User(0L, "", "ana"));
        
        System.out.println("Busca por 'maria': " + (verificacao1 == null ? "Não encontrado (correto)" : "Ainda existe (erro)"));
        System.out.println("Busca por 'ana': " + (verificacao2 == null ? "Não encontrado (correto)" : "Ainda existe (erro)"));
        
        System.out.println("\n=== IMPRESSÃO FINAL ===");
        arvore.imprime_preFixado();
        arvore.imprime_inOrdem();
        arvore.imprime_posFixado();
    }
}
