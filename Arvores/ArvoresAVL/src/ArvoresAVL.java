public class ArvoresAVL {
    public static void main(String[] args) {
        Arvore arvore = new Arvore(new Nodo(10));
        arvore.inserir(new Nodo(5));
        arvore.inserir(new Nodo(1));
        arvore.inserir(new Nodo(8));
        arvore.inserir(new Nodo(15));
        arvore.inserir(new Nodo(12));
        arvore.inserir(new Nodo(18));
    }
}

class Nodo{ //estrutura do nodo
    int valor;

    Nodo(int valor){ //instanciando nodo (com inteiro como parametro)
        this.valor = valor;
    }

    int getValor(){	//pegar valor do nodo
        return this.valor;
    }
}

class Arvore{ //estrutura da arvore
    Nodo nodo;
    Arvore right;
    Arvore left;

    Arvore(){ //instanciando arvore (inicializando com nodo nulo)
        this.right = null;
        this.left = null;
        this.nodo = null;
    }

    Arvore(Nodo nodo){ //instanciando arvore (com nodo como parâmetro)
        this.left = null;
        this.right = null;
        this.nodo = nodo;
    }

    boolean isEmpty(){ //verifica se a arvore é vazia
        return (this.nodo == null);
    }

    void pesquisarValor(int valor){ //pesquisando valor na arvore
        if(!isEmpty()){
            if((valor > this.nodo.getValor()) && (this.right != null)){
                this.right.pesquisarValor(valor);

            }else if((valor < this.nodo.getValor()) && (this.left != null)){
                this.left.pesquisarValor(valor);

            }else if(this.nodo.getValor() == valor){
                System.out.println(this.nodo);
                System.out.println("Valor do nodo: " + this.nodo.getValor());
            
            }else{
                System.out.println("Nodo inexistente!");
            }

        }else{
            System.out.println("Lista vazia!");
        }
    }

    void imprimirPreOrdem(){ //imprime em pre ordem
        if(!isEmpty()){
            System.out.println(this.nodo.getValor());
            if(this.left != null){
                this.left.imprimirPreOrdem();
            }
            if(this.right != null){
                this.right.imprimirPreOrdem();
            }
        }else{
            System.out.println("Lista vazia!");
        }
    }

    void imprimirInOrdem(){ //imprime em ordem
        if(!isEmpty()){
            if(this.left != null){
                this.left.imprimirInOrdem();
            }
            System.out.println(this.nodo.getValor());
            if(this.right != null){
                this.right.imprimirInOrdem();
            }

        }else{
            System.out.println("Lista vazia!");
        }
    }

    void imprimirInverso(){ //imprime em ordem inversa
        if(!isEmpty()){
            if(this.right != null){
                this.right.imprimirInverso();
            }
            System.out.println(this.nodo.getValor());
            if(this.left != null){
                this.left.imprimirInverso();
            }
        }else{
            System.out.println("Lista vazia!");
        }
    }

    void setNodo(Nodo nodo){ //incluir nodo
        this.nodo = nodo;
    }

    void setRight(Arvore right){ //incluir nodo a direita
        this.right = right;
    }

    void setNodo(Arvore left){ //incluir nodo a esquerda
        this.left = left;
    }

    Arvore getRight(){ //receber nodo da direita
        return this.right;
    }

    Arvore getLeft(){ //receber nodo da esquerda
        return this.left;
    }

    Nodo getNodo(){ //receber nodo
        return this.nodo;
    }

    void inserir(Nodo novo){ //inserindo um novo nodo
        if(isEmpty()){
            this.nodo = novo;
        }else{
            Arvore novaArvore = new Arvore(novo);
            if(novo.getValor() < this.nodo.getValor()){ //verificando o valor do nodo (para inserir a esquerda)
                if(this.left == null){ //se for uma folha
                    this.left = novaArvore;
                }else{
                    this.left.inserir(novo); //chama a sub-arvore da esquerda
                }
            }else{
                if(novo.getValor() > this.nodo.getValor()){ //mesmos casos acima só que para a direita
                    if(this.right == null){
                        this.right = novaArvore;
                    }else{
                        this.right.inserir(novo);
                    }
                }
            }
        }
    }

    boolean busca(int valor){ //busca na arvore
        if(isEmpty()){
            return false;
        }
        if(this.nodo.getValor() == valor){
            return true;
        }else{
            if(valor < this.nodo.getValor()){
                if(this.left == null){
                    return false;
                }else{
                    return this.left.busca(valor);
                }
            }else if(valor > this.nodo.getValor()){
                if(this.right == null){
                    return false;
                }else{
                    return this.right.busca(valor);
                }
            }
            return false;
        }
    }
}
