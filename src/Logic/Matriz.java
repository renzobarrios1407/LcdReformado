package Logic;

/**
 * Created by Renzo Barrios
 */
public class Matriz{

    // Calcula el numero de filas de cada Digito en la matriz de impresion
    public int filasDigito; // calcula el total de filas de cada numero
    public int columDigito; // calcula el total de columnas de cada numero
    public int totalFilasMatriz;
    public int totalColumnasMatriz;

    public String[][] matrizImpresion;

    public int tamaño;

    // Puntos fijos para la ubicacion de un numero al escribir la matriz
    public int[] puntofijo1 = new int[2] ;
    public int[] puntofijo2 = new int[2];
    public int[] puntofijo3 = new int[2];
    public int[] puntofijo4 = new int[2];
    public int[] puntofijo5 = new int[2];

    public Matriz(){
    }

    /**
     * crea las dimensiones de la matriz  y la inicializa
     *
     * @param tamaño valor que contiene el tamaño de los digitos
     * @param cadenaDigitos cadena con la cantidad de numeros ingresado
     * @param espacioDigito espacio vacio entre digitos
     */

    public void crearMatriz(int tamaño, String cadenaDigitos, int espacioDigito){

        this.tamaño = tamaño;

        // Calcula el numero de filas cada digito
        this.filasDigito = (2 * this.tamaño) + 3;

        // Calcula el numero de columna de cada digito
        this.columDigito = this.tamaño + 2;
        this.totalFilasMatriz = this.filasDigito;
        this.totalColumnasMatriz = (this.columDigito * cadenaDigitos.length())
                + (espacioDigito * cadenaDigitos.length());

        // se asigna el valor de la matriz
        this.matrizImpresion = new String[this.totalFilasMatriz][this.totalColumnasMatriz];

        // Inicializa matriz
        for (int i = 0; i < this.totalFilasMatriz; i++) {
            for (int j = 0; j < this.totalColumnasMatriz; j++) {
                this.matrizImpresion[i][j] = " ";
            }
        }
    }

    /**
     * imprime el contenido de la matriz
     *
     */
    public void imprimirMatriz(){
        for (int i = 0; i < this.totalFilasMatriz; i++) {
            for (int j = 0; j < this.totalColumnasMatriz; j++) {
                System.out.print(this.matrizImpresion[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * calcula los puntos fijos para distribuir el espacio de un digito
     *
     * @param pivoteInicial valor que contiene el pivote inicial del digito en la matriz
     * @return el pivote inicial para empezar a calcular los puntos fijos del siguiente digito
     *
     */
    public int calcularPuntosFijos(int pivoteInicial){

        this.puntofijo1[0] = 0;
        this.puntofijo1[1] = 0 + pivoteInicial;

        this.puntofijo2[0] = (this.filasDigito / 2);
        this.puntofijo2[1] = 0 + pivoteInicial;

        this.puntofijo3[0] = (this.filasDigito - 1);
        this.puntofijo3[1] = 0 + pivoteInicial;

        this.puntofijo4[0] = (this.columDigito - 1);
        this.puntofijo4[1] = (this.filasDigito / 2) + pivoteInicial;

        this.puntofijo5[0] = 0;
        this.puntofijo5[1] = (this.columDigito - 1) + pivoteInicial;

        return pivoteInicial;
    }
}
