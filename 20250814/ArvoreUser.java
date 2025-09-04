public interface ArvoreUser {
    void inserir(User usuario);
    NodoArvoreUser pesquisa(User usuario);
    void remover(User usuario);
    void imprime_preFixado();
    void imprime_posFixado();
    void imprime_inOrdem();
}
