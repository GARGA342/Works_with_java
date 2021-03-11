import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;

/*
	Criar uma classe Pessoa

        	-Possuindo Nome, idade e sexo

	        -Criar um método que retorna um JSONObject

	Criar um ArrayList de <Pessoa>

	        -Gerar um JSON com todas as pessoas da lista

        ----------------------------------------------

	Ler o JSON com uma lista de pessoas

		-Criar um ArrayList de <Pessoa> condizendo com o arquivo lido
*/

public class App {
    public static void main(String[] args) {
	/* declaraçao de lista */
        ArrayList<Pessoa> listaDePessoas = new ArrayList<Pessoa>();
        
       /* declaracao de JSON */
        JSONArray arr = new JSONArray();
        JSONParser parser = new JSONParser();
        JSONObject aux, pessoa1  = new JSONObject();
        JSONObject pessoa2 = new JSONObject();
        
	/* input de dados de pessoa */
        pessoa1.put("nome", "Bernardo");
        pessoa1.put("sexo", "masculino");
        pessoa1.put("idade", 29);

        pessoa2.put("nome", "Gabi");
        pessoa2.put("sexo", "feminino");
        pessoa2.put("idade", 3);

	/* instanciando pessoas */
        Pessoa p1 = new Pessoa(pessoa1);
        Pessoa p2 = new Pessoa(pessoa2);
        
        /* adicionando pessoas a lista */
        listaDePessoas.add(p1);
        listaDePessoas.add(p2);

	/* percorrendo a lista */
        System.out.println("Lista antes: " + listaDePessoas);
        for(int i=0; i<listaDePessoas.size(); i++){
            JSONObject obj = new JSONObject();
            obj = listaDePessoas.get(i).registrar();
            arr.add(obj);
        }
        listaDePessoas.clear(); //limpando a lista para reaproveita-la posteriormente

        /* escrevendo a lista de pessoas com JSON */
        try(FileWriter meuArquivo = new FileWriter("./Lista.json")){ //ESCREVE
            meuArquivo.write(arr.toString());
            meuArquivo.close();
            System.out.println("\nArquivo criado com sucesso!\n");           
        }catch (IOException ex){
            System.out.println("Erro!");
        }

        System.out.println("OBJETOS: ");
        
        /* lendo o JSON */
        try(FileReader arquivo = new FileReader("./Lista.json")){ //LÊ
            JSONArray leitura = (JSONArray) parser.parse(arquivo);

            for(int i=0; i<leitura.size(); i++){
                System.out.println(aux = (JSONObject) leitura.get(i));

                String nome = (String) aux.get("nome");
                String sexo = (String) aux.get("sexo");
                long idade = (long) aux.get("idade"); 

                Pessoa novaPessoa = new Pessoa();
                novaPessoa.idade = idade;
                novaPessoa.nome = nome;
                novaPessoa.sexo = sexo;
                listaDePessoas.add(novaPessoa);
            }

            System.out.println("\nLista após: " + listaDePessoas);

        }catch (Exception ex){
            System.out.println("File not found or not parsed!" + ex);
        }  
    }
}

class Pessoa{ //estrutura da pessoa
    String nome, sexo;
    long idade; //para evitar problemas de cast

    Pessoa(){ //declaraçao de pessoas (com valores nulos)
        this.nome = null;
        this.sexo = null;
    }

    Pessoa(JSONObject obj){ //pegando os dados do JSON para declarar a pessoa
        this.nome = (String) obj.get("nome");
        this.sexo = (String) obj.get("sexo");
        this.idade = (Integer) obj.get("idade");
    }

    JSONObject registrar(){ //pegando os dados da pessoa para colocar no JSON
        JSONObject objeto = new JSONObject();
        objeto.put("nome", this.nome);
        objeto.put("idade", this.idade);
        objeto.put("sexo", this.sexo);

        return objeto;
    }
}
