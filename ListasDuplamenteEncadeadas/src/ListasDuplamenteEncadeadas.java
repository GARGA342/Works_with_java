public class ListasDuplamenteEncadeadas {
    public static void main(String[] args) {
        
    }
}

class Nodo{ //estrutura de nodo
    int elemento;
    Nodo proximo;
    Nodo anterior;

    Nodo(){ //nodo vazio
        proximo = null;
        anterior = null;
    }

    Nodo(int valor){ //nodo com valor
        this.elemento = valor;
    }
}

class Lista{ //estrutura de lista
    Nodo inicio;
    Nodo fim;
    int quantidade = 0;
    
    boolean isEmpty(){ //verificar se a lista e vazia
        return (this.inicio == null);
    }

    void inserirNoFinal(int elemento){ //insere no final da lista
        Nodo novo = new Nodo(elemento);

        if (isEmpty()){
            inicio = novo;
            fim = novo;
        }else{
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
        quantidade++;
    }

    void inserirNoInicio(int elemento){ //insere no inicio da lista
        Nodo novo = new Nodo(elemento);

        if(isEmpty()){
            inicio = novo;
            fim = novo;
        }else{
            novo.proximo = inicio;
            inicio = novo;
        }
        quantidade++;
    }
    
    void inserirNaPosicao(int valor, int indice){ //insere na posiçao especifica
        Nodo novo = new Nodo(valor);
        if(isEmpty()){
            inicio = novo;
            fim = novo;
        }else{
            if(indice == 0){
                novo.proximo = inicio;
                inicio = novo;
            }else{
                Nodo tmp = inicio;
                int posicao = 0;

                while((posicao < indice) && (tmp != null)){
                    tmp = tmp.proximo;
                    posicao++;
                }

                if(posicao < quantidade){
                    novo.proximo = tmp;
                    novo.anterior = tmp.anterior;
                    Nodo aux = novo.anterior;
                    aux.proximo = novo;
                    novo.anterior = aux;
                    aux = novo.proximo;
                    aux.anterior = novo;
                }else{
                    novo.proximo = fim.proximo;
                    fim.proximo = novo;
                    novo.anterior = fim;
                    novo.proximo = null;
                    fim = novo;
                }
            }
        }
        quantidade++;
    }
    
    void removerNoFinal(){ //remove o ultimo elemento da lista
        if(isEmpty()){
            System.out.println("Lista vazia!");
        }else{
            if(inicio == fim){
                inicio = null;
                fim = null;
            }else{
                fim = fim.anterior;
                fim.proximo = null;
            }
            quantidade--;
        }
    }
    
    void removerNoInicio(){ //remove o primeiro elemento da lista
        if(isEmpty()){
            System.out.println("Lista vazia!");
        }else{
            if(inicio == fim){
                fim = null;
                inicio = fim;
            }else{
                inicio = inicio.proximo;
                inicio.anterior = null;
            }
            quantidade--;    
        }
    }

    void removerDaPosicao(int indice){ //remove de uma posiçao especifica
        if(isEmpty()){
            System.out.println("Lista vazia!");
        }else{
            if(indice == 0){
                removerNoInicio();
            }else{
                Nodo tmp = inicio;
                int posicao = 0;

                while((posicao < indice) && (tmp != null)){
                    tmp = tmp.proximo;
                    posicao++;
                }

                if(posicao < quantidade){
                    tmp.anterior.proximo = tmp.proximo;
                    if(tmp.proximo != null){
                        tmp.proximo.anterior = tmp.anterior;
                    }
                }else{
                    removerNoFinal();
                }
                quantidade--;
            }
        }

    }

    int getNumeroElementos(){ //retorna o numero de elementos da lista
        return quantidade;
    }

    void mostrarNaOrdem(){ //mostra os elementos em ordem
        if(isEmpty()){
            //print lista vazia
        }else{
            Nodo tmp;
            tmp = inicio;
            while(tmp != null){
                System.out.println("Elemento: " + tmp.elemento);
                tmp = tmp.proximo;
            }
        }
    }

    void mostrarNaOrdemInversa(){ //mostra os elementos na ordem inversa
        if(isEmpty()){
            //print lista vazia
        }else{
            Nodo tmp;
            tmp = fim;
            while(tmp != null){
                System.out.println("Elemento: " + tmp.elemento);
                tmp = tmp.anterior;
            }
        }
    }
}
