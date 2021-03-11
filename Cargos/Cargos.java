package cargos;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Cargos {

    public static void main(String[] args) {
        ArrayList<Consultor> lista = new ArrayList<>(); //lista de funcionários
        Consultor c1 = new Consultor("Rafael", 50);
        Consultor c2 = new Consultor("Miguel", 20);
        Consultor c3 = new Consultor("Adriana", 75);
        
        TimerTask retorno = new TimerTask(){ //timer para registro de horas
            @Override
            public void run(){ //registro de horas para os funcionários
                c1.registrarHoras(2);
                c2.registrarHoras(2);
                c3.registrarHoras(2);
                //System.exit(0);        
            }    
        };
        Timer timer = new Timer();
        final long SEGUNDOS = (1000);
        timer.scheduleAtFixedRate(retorno, 0, SEGUNDOS);
    }
}    

class Funcionario{ //estrutura do funcionario
    String RG;
    String nome;
    protected float salarioBase;
    
    Funcionario(String nome){ //instancia de funcionario (inicializando com nome)
        this.nome = nome;
        this.salarioBase = salarioBase;
    }
    
    float getSalario(){ //recebe o salario do funcionario
        return salarioBase;
    }
}

class Consultor extends Funcionario{ //estrutura do consultor
    protected float valorHora;
    protected float horasTrabalhadas;
    
    Consultor(String nome, float valorHora){ //instancia de consultor (inicializando com nome e valor da hora)
        super(nome);
        this.valorHora = valorHora;
    }
    
    void registrarHoras(float horas){ //registra horas trabalhadas
        horasTrabalhadas += horas;
    }
    
    @Override
    float getSalario(){ //recebe o salario do consultor
        return (horasTrabalhadas*valorHora) + salarioBase;
    }

}
