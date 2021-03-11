import java.util.Arrays;

public class MergeSort { 
	public static void main(String[] args) {
			int []vetor = {12, 11, 13, 5, 6, 7}; //vetor
			int []aux = new int [vetor.length]; //vetor auxiliar com o tamanho do anterior

			System.out.println("Vetor antes: " + Arrays.toString(vetor));

			//método de ordenação (passando os vetores, o início e o fim)
			mergeSort(vetor, aux, 0, vetor.length-1); 

			System.out.println("Vetor após: " + Arrays.toString(vetor));
	}

	public static void mergeSort(int[] vetor, int[] aux, int ini, int fim){
		if(ini < fim){ //recursão chamada enquanto o inicio for menor do que o fim
			int meio = (ini + fim)/2; //calculo para saber o elemento do meio

			mergeSort(vetor, aux, ini, meio); //primeira metade
			mergeSort(vetor, aux, meio+1, fim); //segunda metade
			
			intercalacao(vetor, aux, ini, meio, fim); //intercalando
		}
	}

	public static void intercalacao(int[] vetor, int[] aux, int ini, int meio, int fim){
		for(int i = ini; i <= fim; i++){
			aux[i] = vetor[i]; //coloca os elementos do vetor no auxiliar (cópia)
		}

		int j = ini; //anda na primeira metade do vetor
		int k = meio + 1; //anda na segunda metade do vetor

		for(int i = ini; i <= fim; i++){ //percorre o vetor para fazer a intercalação
			if(j > meio){ //pasando do elemento do meio
				vetor[i] = aux[k++]; //coloca os elementos da outra metade pro vetor

			}else if(k > fim){ //segunda metade passou o final
				vetor[i] = aux[j++]; //copia todos os elementos da primeira metade pro vetor

			}else if(aux[j] < aux[k]){ //compara os elementos dos dois vetores
				vetor[i] = aux[j++]; //pega o elemento da posição j
				
			}else{ 
				vetor[i] = aux[k++]; //pega o elemento da posição k
			}
		}
	}
}