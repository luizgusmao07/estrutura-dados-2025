public class NodoArvoreUser {
    User usuario;
    NodoArvoreUser filhoEsquerda;
    NodoArvoreUser filhoDireita;

    public NodoArvoreUser(User usuario) {
        this.usuario = usuario;
        this.filhoEsquerda = null;
        this.filhoDireita = null;
    }
}
