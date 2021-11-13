package fciencias.edatos.practica04;
import java.util.Arrays;

public class Ordenamiento {

  /**
   * Método que intercambia dos elementos en un arreglo
   * @param array - el arreglo en el que vamos a cambiar las posiciones
   * @param i - posición de uno de los elementos en el arreglo
   * @param n - posición de uno de los elementos en el arreglo
   */
  public void swap(int array[], int i, int n){
    // Guardamos el valor para no perderlo
    int aux = array[i];
    array[i] = array[n];
    array[n] = aux;
  }

  public void quickSort(int array[], int lo, int hi){
    if(hi <= lo)
      return;
    int j = auxParticion(array, lo, hi);
    quickSort(array, lo, j-1);
    quickSort(array, j+1, hi);
  }

  public int auxParticion(int array[], int lo, int hi){
    int i = lo;
    int j = hi+1;
    int piv = array[lo];
    while(true){
      while(array[++i] < piv){
        if(i == hi)
          break;
      }
      while(piv < array[--j]){
        if(j == lo)
            break;
      }
      if(i >= j)
        break;
      swap(array, i, j);
    }
    swap(array, lo, j);
    return j;
  }

  /**
	 * Método que ordena un arreglo de forma ascendente
	 * @param arr - el arreglo a ordenar
	 */
	public static void mergeSort(int[] arr){
		mergeSort(arr, 0, arr.length-1);
	}

	/**
	 * Método auxiliar de mergeSort para dividir y mezclar
	 * @param arr - el arreglo con los elementos a dividir y mezclar
	 * @param lo - el índice de inicio a modificación
	 * @param hi - el índice del último elemento a modificación
	 */
	private static void mergeSort(int[] arr, int lo, int hi){
		// Cuando ya esta ordenado el fragmento de lo hasta hi
		if(hi <= lo)
			return;

		// La mitad del corte del arreglo
		int mid = lo + (hi-lo) / 2;
		mergeSort(arr, lo, mid);
		mergeSort(arr, mid+1, hi);

		merge(arr, lo, mid, hi);
    for (int m = 0; m < arr.length; m++) {
      // System.out.print(arr[m] + " ");
    }
    // System.out.println();
	}

  /**
	 * Método que mezcla dos arreglos, ordenando de menor a mayor
	 * @param arr - el arreglo con los elementos a modificar
	 * @param lo - el inicio de la primera mitad
	 * @param mid - el índice de la mitad del subarreglo
	 * @param hi - el índice del último elemento
	 */
	private static void merge(int[] arr, int lo, int mid, int hi){
		int i = 0;
		int j = ((hi-lo) / 2) + 1;
		int[] aux = Arrays.copyOfRange(arr, 0, hi+1);

		for(int k = 0; k <= hi; k++){
			// Si ya nos acabamos los elementos de la primera mitad
			if(i > mid) {
        arr[k] = aux[j++];
      }
      // Si ya nos acabamos la segunda mitad
			else if(j > hi) {
        arr[k] = aux[i++];
      }
      // El menor está en la primera mitad
			else if(aux[j] < aux[i]) {
        arr[k] = aux[j++];
      }
      // El mayor está en la segunda mitad
			else {
        arr[k] = aux[i++];
      }
		}
    for (int m = 0; m < aux.length; m++) {
      System.out.print(aux[m] + " ");
    }
    System.out.println();
	}

  /**
   * Método que implemente la lista binaria en un arreglo
   * @param array - arreglo en el que vamos a buscar
   * @param elem - elemento que vamos a buscar
   * @param min - índice mínimo del arreglo en donde vamos a buscar
   * @param max - índice máximo del arreglo en donde vamos a buscar
   * @return int - la posición donde encontramos el elemento y si no lo encontramos -1
   */
  public int busquedaBinaria(int array[], int elem, int min, int max){
    // Si se da este caso, no está el elemento en el arreglo
    if(min > max)
      return -1;
    // El elemento medio del subarreglo en donde estamos buscando
    int mid = min + (max-min)/2;
    // Si encontramos el elemento regresamos la posición donde lo encontramos
    if(array[mid] == elem)
      return mid;
    // Ya que asumimos que estamos buscando en un arreglo ordenado, podemos saber en
    // cuál mitad del arreglo buscar
    if(elem < array[mid]){
      // Si el elemento que buscamos es menor al medio del subarreglo, está en
      // la primera mitad del subarreglo
      return busquedaBinaria(array, elem, min, mid-1);
    }else{
      // En caso contrario, está en la segunda mitad
      return busquedaBinaria(array, elem, mid+1, max);
    }
  }

  public static String printArray(int array[]){
    String contenido = "";
    for(int i = 0; i < array.length; i++)
      contenido += "[" + array[i] + "] ";
    return contenido;
  }

  public static void main(String[] args) {
    Ordenamiento ord = new Ordenamiento();
    int arreglo[] = new int[5];
    for(int i = 0; i < 5; i++)
      arreglo[i] = i*3+1;
    int arreglo2[] = {arreglo[2], arreglo[4], arreglo[1], arreglo[3], arreglo[0]};
    System.out.println(printArray(arreglo));
    System.out.println(printArray(arreglo2));
    mergeSort(arreglo2);
  }
}
