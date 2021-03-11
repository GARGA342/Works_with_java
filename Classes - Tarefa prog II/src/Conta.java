package orientacaoobjetos;

public class Conta { //estrutura de conta

    private float saldo; //saldo da conta
    private Pessoa dono; //dono da conta (classe pessoa)

    Conta(float valor, Pessoa donoP) { //instancia da conta 
        saldo = valor;
        dono = donoP;
        if (dono != null) {
            dono.registraConta(this);
        }
    }

    public float getSaldo() { //retorna o saldo da conta
        return saldo;
    }
}
