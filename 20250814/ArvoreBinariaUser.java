public class ArvoreBinariaUser implements ArvoreUser {
    private NodoArvoreUser raiz;

    public ArvoreBinariaUser() {
        this.raiz = null;
    }

    @Override
    public void inserir(User usuario) {
        this.raiz = inserirRecursivo(this.raiz, usuario);
    }

    private NodoArvoreUser inserirRecursivo(NodoArvoreUser noAtual, User usuario) {
        if (noAtual == null) {
            return new NodoArvoreUser(usuario);
        }

        int comparacao = usuario.compareTo(noAtual.usuario);
        
        if (comparacao < 0) {
            noAtual.filhoEsquerda = inserirRecursivo(noAtual.filhoEsquerda, usuario);
        } else if (comparacao > 0) {
            noAtual.filhoDireita = inserirRecursivo(noAtual.filhoDireita, usuario);
        }

        return noAtual;
    }

    @Override
    public NodoArvoreUser pesquisa(User usuario) {
        return pesquisaRecursivo(this.raiz, usuario);
    }

    private NodoArvoreUser pesquisaRecursivo(NodoArvoreUser noAtual, User usuario) {
        if (noAtual == null) {
            return null;
        }

        int comparacao = usuario.compareTo(noAtual.usuario);
        
        if (comparacao == 0) {
            return noAtual;
        } else if (comparacao < 0) {
            return pesquisaRecursivo(noAtual.filhoEsquerda, usuario);
        } else {
            return pesquisaRecursivo(noAtual.filhoDireita, usuario);
        }
    }

    @Override
    public void imprime_preFixado() {
        System.out.print("Pré-fixado: ");
        imprime_preFixadoRecursivo(this.raiz);
        System.out.println();
    }

    private void imprime_preFixadoRecursivo(NodoArvoreUser noAtual) {
        if (noAtual == null) {
            return;
        }

        System.out.print(noAtual.usuario.getUsername() + " ");
        imprime_preFixadoRecursivo(noAtual.filhoEsquerda);
        imprime_preFixadoRecursivo(noAtual.filhoDireita);
    }

    @Override
    public void imprime_posFixado() {
        System.out.print("Pós-fixado: ");
        imprime_posFixadoRecursivo(this.raiz);
        System.out.println();
    }

    private void imprime_posFixadoRecursivo(NodoArvoreUser noAtual) {
        if (noAtual == null) {
            return;
        }

        imprime_posFixadoRecursivo(noAtual.filhoEsquerda);
        imprime_posFixadoRecursivo(noAtual.filhoDireita);
        System.out.print(noAtual.usuario.getUsername() + " ");
    }

    @Override
    public void imprime_inOrdem() {
        System.out.print("Em ordem: ");
        imprime_inOrdemRecursivo(this.raiz);
        System.out.println();
    }

    private void imprime_inOrdemRecursivo(NodoArvoreUser noAtual) {
        if (noAtual == null) {
            return;
        }

        imprime_inOrdemRecursivo(noAtual.filhoEsquerda);
        System.out.print(noAtual.usuario.getUsername() + " ");
        imprime_inOrdemRecursivo(noAtual.filhoDireita);
    }

    @Override
    public void remover(User usuario) {
        this.raiz = removerRecursivo(this.raiz, usuario);
    }

    private NodoArvoreUser removerRecursivo(NodoArvoreUser noAtual, User usuario) {
        if (noAtual == null) {
            return null; // Usuário não encontrado
        }

        int comparacao = usuario.compareTo(noAtual.usuario);

        if (comparacao < 0) {
            noAtual.filhoEsquerda = removerRecursivo(noAtual.filhoEsquerda, usuario);
        } else if (comparacao > 0) {
            noAtual.filhoDireita = removerRecursivo(noAtual.filhoDireita, usuario);
        } else {
            
            if (noAtual.filhoEsquerda == null && noAtual.filhoDireita == null) {
                return null;
            }
            
            if (noAtual.filhoEsquerda == null) {
                return noAtual.filhoDireita;
            }
            // Caso 2: Nó com apenas um filho à esquerda
            if (noAtual.filhoDireita == null) {
                return noAtual.filhoEsquerda;
            }
            
            NodoArvoreUser sucessor = encontrarMinimo(noAtual.filhoDireita);
            
            noAtual.usuario = sucessor.usuario;
            
            noAtual.filhoDireita = removerRecursivo(noAtual.filhoDireita, sucessor.usuario);
        }

        return noAtual;
    }

    private NodoArvoreUser encontrarMinimo(NodoArvoreUser no) {
        while (no.filhoEsquerda != null) {
            no = no.filhoEsquerda;
        }
        return no;
    }

    public boolean estaVazia() {
        return this.raiz == null;
    }
}
