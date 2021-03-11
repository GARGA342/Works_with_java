import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;

public class Consultor { //estrutura do consultor
    String nome;
    float valorHora;
    float  horasTrabalhadas;
    static int cont = 0;
    static Timer timer;

    Consultor(String nome, float valorHora){ // declaraçao do consultor
        this.nome = nome;
        this.valorHora = valorHora;
    }

    void registrarHora(float horas){ //registro de horas trabalhadas
        this.horasTrabalhadas += horas;
    } 

    float getSalario(){ //retorna o salario do consultor
        return (valorHora*horasTrabalhadas);
    }

    public static boolean contagem(){ //retorna o final da contagem
        if(cont >= 14){
            timer.cancel();
            return true;
        }
        cont++;
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Consultor> lista = new ArrayList<Consultor>(); //lista de consultores
        
        /* declaraçao dos consultores */
        Consultor c1 = new Consultor("Gilmar Rinendy", (float)200.00);
        Consultor c2 = new Consultor("Anderson Adalbertinson", (float)28.00);
        Consultor c3 = new Consultor("Valeriana Mendonsas", (float)80.00);
        
        /* adicionando os consultores declarados a lista*/
        lista.add(c1);
        lista.add(c2);
        lista.add(c3);

        TimerTask retorno = new TimerTask(){ //timer
            @Override
            public void run(){ //registro de horas dos consultores
                c1.registrarHora(2);
                c2.registrarHora(2);
                c3.registrarHora(2);
                if(contagem()){
                    System.out.println(String.format("Salário do consultor 1: %.2f", c1.getSalario()));
                    System.out.println(String.format("Salário do consultor 2: %.2f", c2.getSalario()));
                    System.out.println(String.format("Salário do consultor 3: %.2f", c3.getSalario()));
                }  
            }
        };    
        
        timer = new Timer();
        final long SEGUNDOS = (1000);
        timer.scheduleAtFixedRate(retorno, 0, SEGUNDOS);

    }
}
