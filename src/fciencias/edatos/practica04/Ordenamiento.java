package fciencias.edatos.practica04;
public class Ordenamiento {

    /**
     * Método que intercambia dos elementos en un arreglo
     * @param array el arreglo en el que vamos a cambiar las posiciones
     * @param i posicion de uno de los elementos en el arreglo
     * @param n posicion de uno de los elementos en el arreglo
     */
    public void swap(int array[], int i, int n){
        //guardamos el valor para no perderlo
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
     * Método que implemente la lista binaria en un arreglo 
     * @param array arreglo en el que vamos a buscar
     * @param elem elemento que vamos a buscar
     * @param min indice minimo del arreglo en donde vamos a buscar
     * @param max indice maximo del arreglo en donde vamos a buscar
     * @return la posicion donde encontramos el elemento y si no lo encontramos -1
     */
    public int busquedaBinaria(int array[], int elem, int min, int max){
        //Si se da este caso no está el elemento en el arreglo
        if(min > max)
            return -1;
        //el elemento medio del subarreglo en donde estamos buscando
        int mid = min + (max-min)/2;
        //Si encontramos el elemento regresamos la posicion donde lo encontramos
        if(array[mid] == elem)
            return mid;
        //Ya que asumimos que estamos buscando en un arreglo ordenado podemos saber en cual mitad del arreglo buscar
        if(elem < array[mid]){
            //si el elemento que buscamos es menor al medio del subarreglo esta en la primera mitad del subarreglo
            return busquedaBinaria(array, elem, min, mid-1);
        }else{
            //en caso contrario está en la segunda mitad
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
        int arreglo[] = new int[20];
        for(int i = 0; i < 20; i++)
            arreglo[i] = i*3+1;
        System.out.println(printArray(arreglo));
        System.out.println(ord.busquedaBinaria(arreglo, 2, 0, 20));
    }
}
