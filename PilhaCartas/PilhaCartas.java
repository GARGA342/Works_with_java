package pilhacartas;

import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

public class PilhaCartas {
    
    public static void main(String[] args) {
        Stack<String> pilha = new Stack<String>(); //instancia da pilha
        pilha.push("A");
        pilha.push("K");
        pilha.push("Q");
        pilha.push("J");
        pilha.push("10");
        pilha.push("9");
        pilha.push("8");
        pilha.push("7");
        pilha.push("6");
        pilha.push("5");
        pilha.push("4");
        pilha.push("3");
        pilha.push("2");
        pilha.push("1");
        
        TimerTask retorno = new TimerTask(){ //timer
            @Override
            public void run(){ //remove um elemento da pilha e retorna o valor
                if(pilha.empty() != true){
                    String retornoTopo = pilha.pop();
                    System.out.println(retornoTopo);
                }else{
                    System.exit(0);
                }    
            }    
        };    
        
        Timer timer = new Timer();
        final long SEGUNDOS = (1000);
        
        timer.scheduleAtFixedRate(retorno, 0, SEGUNDOS);
    } 
  
}
