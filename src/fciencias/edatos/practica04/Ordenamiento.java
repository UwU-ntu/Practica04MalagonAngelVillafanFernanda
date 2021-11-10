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
            arreglo[i] = i+1;
        ord.swap(arreglo, 0, 4);
        ord.swap(arreglo, 3, 13);
        ord.swap(arreglo, 2, 6);
        ord.swap(arreglo, 15, 19);
        ord.swap(arreglo, 14, 2);
        ord.swap(arreglo, 4, 19);
        ord.swap(arreglo, 3, 7);
        ord.swap(arreglo, 9, 3);
        System.out.println(printArray(arreglo));
        ord.quickSort(arreglo, 0, 19);
        System.out.println(printArray(arreglo));
    }
}
