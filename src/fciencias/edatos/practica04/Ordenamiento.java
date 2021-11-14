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
    // Guardamos el valor en una variable auxiliar para no perderlo
    int aux = array[i];
    //intercambiamos uno de los valores
    array[i] = array[n];
    //Y asignamos el auxiliar al otro
    array[n] = aux;
  }

  /**
   * Método que ordena un arreglo de forma ascendente con quick sort
   * @param array[] - arreglo a ordenar
   * @param lo - índice del primer elemento del arreglo
   * @param hi - índice del último elemento del arreglo
   */
  public void quickSort(int array[], int lo, int hi){
    //dado que se cambian las estos valores cada vez que se puede dar este caso
    //si se da este caso ya recorrió todo el arreglo
    if(hi <= lo)
      return;
    int j = auxParticion(array, lo, hi);
    //primero vamos a los valores de la derecha
    quickSort(array, lo, j-1);
    //despues a los valores de la izquierda
    quickSort(array, j+1, hi);
  }

  /**
   * Método auxiliar de quickSort
   * @param array[] - arreglo a ordenar
   * @param lo - índice del primer elemento del arreglo
   * @param hi - índice del último elemento del arreglo
   * @return int - regresa el nuevo valor de j
   */
  public int auxParticion(int array[], int lo, int hi){
    // asignamos el valor de i basandonos en la posicion minima que estamos buscando
    int i = lo;
    // asignamos el valor de j basandonos en la posicion maxima que estamos buscando
    int j = hi+1;
    //elegimos el pivote en la primera posicion del arreglo que estamos tomando
    int piv = array[lo];
    while(true){
        //cambiamos las referencias de i basandonos en el pivote
        while(array[++i] < piv){
            //Si se da este caso nos salimos del ciclo
            if(i == hi)
              break;
        }
        //cambiamos las referencias de j basandonos en el pivote
        while(piv < array[--j]){
            //Si se da este caso nos salimos del ciclo
          if(j == lo)
              break;
        }
        //Si el valor minimo que estamos buscando esta en la posicion mayor o igual al valor maximo que estamos buscando nos salimos del ciclo
        if(i >= j)
          break;
        //cambiamos la posicion minima del arreglo y la maxima
        swap(array, i, j);
    }
    //Finalmente cambiamos la posicion minima inicial con la ultima maxima
    swap(array, lo, j);
    return j;
  }

  /**
	 * Método que ordena un arreglo de forma ascendente con merge sort
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
		int i = lo;
		int j = mid+1;
		int[] aux = Arrays.copyOfRange(arr, 0, hi+1);
    int index = 0;
		for(int k = lo; k <= hi; k++){
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
      //System.out.print(arr[k] + " ");
		}
    //System.out.println();
	}

  /**
   * Método que implementa la lista binaria en un arreglo
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


  /**
   * Método que imprime el arreglo de manera correcta
   * @param array[] - el arreglo
   * @return String - el arreglo con el formato elegido
   */
  public static String printArray(int array[]){
    String contenido = "";
    for(int i = 0; i < array.length; i++)
      contenido += "[" + array[i] + "] ";
    return contenido;
  }

  public static void main(String[] args) {
    Ordenamiento ord = new Ordenamiento();
    int arreglo[] = new int[15];
    for(int i = 0; i < 15; i++)
      arreglo[i] = i*3+1;
    int arreglo2[] = {arreglo[2], arreglo[4], arreglo[1], arreglo[3], arreglo[0],arreglo[9], arreglo[2], arreglo[14], arreglo[10], arreglo[8], arreglo[7], arreglo[12], arreglo[11]};
    //System.out.println(printArray(arreglo));
    System.out.println(printArray(arreglo2));
    mergeSort(arreglo2);
    System.out.println(printArray(arreglo2));
  }
}
