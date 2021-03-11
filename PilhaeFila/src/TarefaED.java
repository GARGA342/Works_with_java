public class TarefaED {

    public static void main(String[] args) {
    	/* instancia de pilha */
        Pilha minhaPilha = new Pilha();
        minhaPilha.empilhar(3);
        minhaPilha.empilhar(10);
        minhaPilha.empilhar(9);

        int a = minhaPilha.desempilhar();

        System.out.println("DESEMPILHADO: " + a);
        System.out.println("PRIMEIRO: " + minhaPilha.primeiro.valor);
        System.out.println("ULTIMO: " + minhaPilha.ultimo.valor);

	/* instancia de lista */
        Lista minhaLista = new Lista();
        minhaLista.inserirInicio(40);
        minhaLista.inserirFinal(123);
        minhaLista.removerInicio();
        
	/* instancia de fila */
        Fila minhaFila = new Fila();
        minhaFila.add(30);
        minhaFila.get();
    }
    
}

class Lista{ //estrutura da lista
    Nodo primeiro = null;
    Nodo ultimo = null;
    int quantidade = 0;
    
    void inserirFinal(int val) { //insere no final da lista
        if (primeiro == null) {
            Nodo tmp = new Nodo(val);
            primeiro = tmp;
            ultimo = tmp;
        } else {
            Nodo novo = new Nodo(val);
            Nodo tmp = ultimo;                  
            tmp.proximo = novo;                 
            ultimo = novo;                      
        }
        quantidade++;
    }

    void inserirInicio(int val) { //insere no inicio da lista
        if (primeiro == null) {
            Nodo novo = new Nodo(val);
            novo.proximo = primeiro;
            primeiro = novo;
            ultimo = novo;
        } else {
            Nodo novo = new Nodo(val);
            novo.proximo = primeiro;
            primeiro = novo;
        }
        quantidade++;
    }

    void removerInicio() { //remove no inicio da lista
        if (primeiro == null) {
            System.out.println("Lista vazia!");
        } else {
            Nodo tmp = primeiro.proximo;
            primeiro = tmp;
            quantidade--;
        }
    }
}

class Fila extends Lista{ //como a fila utiliza os mesmos metodos da lista, a declaracao da fila estende a da lista
    void add(int valor){ //para adicionar na fila
        inserirFinal(valor);
    }
    
    int get(){ //para receber o valor da fila
        if(primeiro == null){
            System.out.println("Lista vazia!");
            return 0;
        }else{                              
            Nodo segundo = primeiro.proximo;
            primeiro = segundo;
            quantidade--;
            return quantidade;
        }
    }
}

class Pilha extends Lista{ //como a pilha utiliza os mesmos metodos da lista, a declaracao da pilha estende a da lista
    void empilhar(int valor){ //adiciona a pilha
        inserirInicio(valor);
    }
    
    int desempilhar(){ //remove da pilha
        if(primeiro == null){
            System.out.println("Pilha vazia!");
            return 0;
        }else if(primeiro == ultimo){
            Nodo tmp = ultimo;
            ultimo = primeiro = null;        
            quantidade--;
            return tmp.valor;
        }else{
            Nodo tmp = primeiro;
            if(primeiro.proximo == ultimo){
                primeiro = ultimo;
            }else{
                primeiro = primeiro.proximo;
            }
            quantidade--;
            return tmp.valor;
        }
    }
}

class Nodo{ //estrutura do nodo
    Nodo proximo;
    int valor;
    
    Nodo(int valor){ //declaracao do nodo com um valor
        this.valor = valor;
    }
}
