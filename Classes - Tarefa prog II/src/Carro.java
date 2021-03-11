package orientacaoobjetos;

class Carro { //estrutura do carro
    
    private String marca;
    private float valor;
    private float velocidadeMaxima;
    private int ano;
    private Pessoa dono;
    
    Carro(String marcaP, float valorP, float velocidadeMaximaP, int anoP, Pessoa donoP) { //instancia do carro
        marca = marcaP;
        valor = valorP;
        velocidadeMaxima = velocidadeMaximaP;
        ano = anoP;
        dono = donoP;
        
        if (dono != null) {
            dono.registraCarro(this);
        }
    }
    
    public float getVelocidade() { //retorna a velocidade maxima do carro
        return velocidadeMaxima;
    }
    
    public int getAno() { //retorna o ano do carro
        return ano;
    }
}
