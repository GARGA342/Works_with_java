package orientacaoobjetos;

import java.util.ArrayList;

class Pessoa { //estrutura da pessoa

    String nome;
    public ArrayList<Conta> contas = new ArrayList<Conta>(); //lista de contas da pessoa
    public ArrayList<Carro> carros = new ArrayList<Carro>(); //lista de carros da pessoa

    Pessoa(String nomeP) { //nome da pessoa
        nome = nomeP;
    }

    float getSaldoTotal() { //receber o saldo das contas da pessoa (entre todas as contas)
        int numContas = contas.size();
        System.out.println(numContas);
        float valor = 0;
        int i = 0;

        while (i != numContas) {
            valor += contas.get(i).getSaldo();
            i++;
        }

        return valor;
    }

    public void registraConta(Conta conta) { //registrar conta
        contas.add(conta);
    }

    public void registraCarro(Carro carro) { //registrar carro
        carros.add(carro);
    }

    public int getNumContas() { //recebe o numero de contas que a pessoa possui
        return contas.size();
    }

    Carro getMaisRapido() { //retorna o carro mais rapido que a pessoa possui
        Carro aux = null;
        float velocidade = 0;
        int i = 0;
        int quantidade = carros.size();

        while (i != quantidade) {

            if (carros.get(i).getVelocidade() > velocidade) {
                velocidade = carros.get(i).getVelocidade();
                aux = carros.get(i);
            }
            i++;
        }

        return aux;
    }

    Carro getMaisAntigo() { //retorna o carro mais antigo da pessoa
        Carro aux = null;
        int ano = carros.get(0).getAno();
        int i = 0;
        int quantidade = carros.size();

        while (i != quantidade) {

            if (carros.get(i).getAno() <= ano) {
                ano = carros.get(i).getAno();
                aux = carros.get(i);
            }
            i++;
        }

        return aux;
    }
}
