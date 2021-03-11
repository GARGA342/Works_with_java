package filadeelementos;

import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import java.util.LinkedList;

public class FilaDeElementos {

    public static void main(String[] args) {
        Queue<Integer> fila = new LinkedList<Integer>(); //fila
        Random rand = new Random(); //randomizaçao
        
        
        TimerTask retorno = new TimerTask(){ //timer
            @Override
            public void run(){ //adicionando a fila de acordo com o timer
                if(fila.size() > 30){
                    System.exit(0);
                }else{
                    int valor = rand.nextInt(100);
                    fila.add(valor);
                    System.out.println(valor);
                }
            }    
        };    
        
        Timer timer = new Timer();
        final long SEGUNDOS = (1000);
        
        timer.scheduleAtFixedRate(retorno, 0, SEGUNDOS);
    }
    
}
