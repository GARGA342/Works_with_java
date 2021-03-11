public class Conta{ //estrutura da conta
    String nome;
    float saldo;

    Conta(String nome, float saldo){ 
        this.nome = nome;
        this.saldo = saldo;
    }

    public void sacar(float valor) throws SaqueNegativoException, SaldoInsuficienteException{ //testando algumas exceções
        if(valor < 0){
            throw new SaqueNegativoException("Valor negativo. Erro na transação!"); //saque negativo
        }else if(this.saldo < valor){
            throw new SaldoInsuficienteException("Saldo insuficiente para a transação!"); //saldo insuficiente
        }else{
            this.saldo-=valor;
            System.out.println("SUCESSO!");
        }
    }
}
