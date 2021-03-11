class Nodo{ //estrutura do nodo
    int valor = 0;
    Nodo esq;
    Nodo dir;

    Nodo(){ //criação de nodo (vazio)
        valor = 0;
        esq = null;
        dir = null;
    }

    Nodo(int valor){ //criação de nodo (com um inteiro como parâmetro)
        this.valor = valor;
        esq = null;
        dir = null;
    }

    void imprimir(){ //impressão da arvore
        if(esq != null){
            esq.imprimir();
        }
        if(dir != null){
            dir.imprimir();
        }
    }

    void procurar(int valor){ //procurar valor do nodo
        Nodo novo = new Nodo(valor);
        if (this.valor < novo.valor && dir != null){
            dir.procurar(novo.valor);
        }else if(novo.valor < this.valor && esq != null){
            esq.procurar(novo.valor);
        }else if(novo.valor == this.valor){
            System.out.println("Nodo atual: " + novo);
            System.out.println("Valor atual: " + this.valor);
        }else{
            System.out.println("Nenhum valor encontrado!");
        }

    }

    void adicionar(int novo_valor){ //adicionar nodo
        if (novo_valor > valor){
            if(dir == null){
                dir = new Nodo(novo_valor);
            }else{
                dir.adicionar(novo_valor);
            }
        }else{
            if(esq == null){
                esq = new Nodo(novo_valor);
            }else{
                esq.adicionar(novo_valor);
            }
        }
    }
}

public class Arvore {
    public static void main(String[] args) throws Exception {
        Nodo raiz = new Nodo(8); //instanciando um nodo-raiz
        raiz.adicionar(5);
        raiz.adicionar(0);
        raiz.adicionar(-2);
        raiz.adicionar(10);
        raiz.adicionar(20);
        raiz.adicionar(12);

        raiz.procurar(10);
    }
}
