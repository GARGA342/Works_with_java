class Nodo{ //estrutura do nodo
    int valor, quantidade, balanceamento;
    Nodo esquerda, direita;

    Nodo(){ //inicializando nodo (vazio)
        this.valor = 0;
        this.esquerda = null;
        this.direita = null;
    }

    Nodo(int valor){ //inicializando nodo (com inteiro como parametro)
        this.valor = valor;
        esquerda = null;
        direita = null;
    }

    int getBalanceamento() { //receber o balanceamento
        return balanceamento;
    }

    void adicionar(int novo_valor){ //adicionando valor a arvore
        if(novo_valor > valor){
            if(direita == null){
                direita = new Nodo(novo_valor);
            }else{
                direita.adicionar(novo_valor);
            }
            quantidade++;
        }else if(novo_valor < valor){
            if(esquerda == null){
                esquerda = new Nodo(novo_valor);
            }else{
                esquerda.adicionar(novo_valor);
            }
            quantidade++;
        }
    }

    void imprimir(){ //imprimindo em ordem
        if(direita != null){
            direita.imprimir();
        }

        System.out.println(valor);

        if(esquerda != null){
            esquerda.imprimir();
        }
    }

    void buscar(int valor){ //buscando valores na arvore
        if((valor > this.valor) && (direita != null)){
            direita.buscar(valor);
        }else if((valor < this.valor) && ((esquerda != null))){
            esquerda.buscar(valor);
        }else if(valor == this.valor){
            System.out.println(this.toString());
        }else{
            System.out.println("null");
        }    
    }

    int calcularAltura(){ //medindo os níveis (camadas) da arvore
        if(esquerda == null && direita == null){
            return 1;
        }else if(direita != null && esquerda == null){
            return 1 + direita.calcularAltura();
        }else if(esquerda != null && direita == null){
            return 1 + (esquerda.calcularAltura());
        }else{    
            return 1 + Math.max(direita.calcularAltura(), esquerda.calcularAltura());
        }    
    }

    void calcularBalanceamento(){ //calcula o balanceamento dos níveis (camadas) da arvore
        if(direita == null && esquerda == null){
            balanceamento = 0;
        }else if(esquerda == null && direita != null){
            balanceamento = direita.calcularAltura();
        }else if(esquerda != null && direita == null){
            balanceamento = 0 - esquerda.calcularAltura();
        }else{
            balanceamento = direita.calcularAltura() - esquerda.calcularAltura();
        }
        if(direita != null){
            direita.calcularBalanceamento();
        }
        if(esquerda != null){
            esquerda.calcularBalanceamento();
        }
    }

    Nodo rotacaoSimplesDireita(){ //rotacionar a direita (rotação simples)
        Nodo filhoDireito;
        Nodo neto = null;

        filhoDireito = direita;
        if(direita != null){
            if(direita.esquerda != null){
                neto = direita.esquerda;
            }
        }
        filhoDireito.esquerda = this;
        this.direita = neto;

        return filhoDireito;
    }

    Nodo rotacaoDuplaDireita(){ //rotacionar a direita (rotação dupla)
        Nodo este = this;
        Nodo filhoDireito = direita;
        Nodo neto = filhoDireito.esquerda;
        Nodo nodoInsercao = neto.direita;

        filhoDireito.esquerda = nodoInsercao;
        neto.direita = filhoDireito;
        this.direita = neto;

        Nodo novo = this.direita;
        este.direita = null;
        novo.esquerda = este;
        
        return novo;
    }

    Nodo rotacaoSimplesEsquerda(){ //rotacionar a esquerda (rotação simples)
        Nodo filhoEsquerdo;
        Nodo neto = null;

        filhoEsquerdo = esquerda;
        if(esquerda != null){
            if(esquerda.direita != null){
                neto = esquerda.direita;
            }
        }

        filhoEsquerdo.direita = this;
        this.esquerda = neto;

        return filhoEsquerdo;
    }

    Nodo rotacaoDuplaEsquerda(){ //rotacionar a esquerda (rotação dupla)
        Nodo este = this;
        Nodo filhoEsquerdo = esquerda;
        Nodo neto = filhoEsquerdo.direita;
        Nodo nodoInsercao = neto.esquerda;

        filhoEsquerdo.direita = nodoInsercao;
        neto.esquerda = filhoEsquerdo;
        this.esquerda = neto;

        Nodo novo = this.esquerda;
        este.esquerda = null;
        novo.direita = este;
        
        return novo;
    }

    Nodo verificarBalanceamento(){ //efetua os respectivos balanceamentos 
        if(balanceamento >= 2 || balanceamento <= -2){
            if(balanceamento >= 2){
                if(balanceamento * direita.getBalanceamento() > 0){
                    System.out.println("Fiz rotação simples a direita");
                    return rotacaoSimplesDireita();
                }else{
                    System.out.println("Fiz rotação dupla a direita");
                    return rotacaoDuplaDireita();
                }
            }else{
                if(balanceamento * esquerda.getBalanceamento() > 0){
                    System.out.println("Rotação simples a esquerda");
                    return rotacaoSimplesEsquerda();
                }else{
                    System.out.println("Rotação dupla a esquerda");
                    return rotacaoDuplaEsquerda();
                }
            }
        }
        this.calcularBalanceamento();
        if(esquerda != null) esquerda = esquerda.verificarBalanceamento();
        if(direita != null) direita = direita.verificarBalanceamento();
        return this;
    }
}

public class Arvore{
    public static void main(String[] args) {
        Nodo raiz = new Nodo(10);
        raiz.adicionar(5);
        raiz.adicionar(15);
        raiz.adicionar(12);
        raiz.adicionar(20);
        raiz.adicionar(25);
        raiz.imprimir();
        raiz.calcularBalanceamento();
        raiz = raiz.verificarBalanceamento();
    }   
}
