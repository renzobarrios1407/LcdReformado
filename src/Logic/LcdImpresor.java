package Logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Renzo Barrios
 */

public class LcdImpresor {

    // Caracteres fijos
    static final String CARACTER_VERTICAL = "|";
    static final String CARACTER_HORIZONTAL = "-";
    static final String POSICION_X = "X";
    static final String POSICION_Y = "Y";

    // atributos objetos de clases
    public Matriz matriz = new Matriz();
    public SieteSegmento sieteSegmentos = new SieteSegmento();

    public LcdImpresor(){
    }

    /**
     * Metodo encargado de procesar la entrada de datos que contiene el tamaño, los numeros a imprimir y el espacio entre los digitos
     *
     * @param cadenaNumeros cadena que contiene el tamaño y los numeros a imprimir
     * @param espacioDigitos Espacio Entre digitos
     */
    public void procesarEntrada(String cadenaNumeros, int espacioDigitos) {

        String[] cadenaDigitos;
        int tamañoDigito;

        verificarSeparadorDeCadena(cadenaNumeros);
        cadenaDigitos = cadenaNumeros.split(",");

        verificarCantidadParametros(cadenaDigitos,cadenaNumeros);
        tamañoDigito =  asignacionTamaño(cadenaDigitos[0]);

        validarImpresionDigitos(tamañoDigito, cadenaDigitos[1],espacioDigitos);
    }

    /**
     * Metodo que verifica si contiene un caracter separador del tamaño con los numeros
     *
     * @param cadenaCaracteres cadena que contiene el tamaño y los numeros ingresados
     */
    public void verificarSeparadorDeCadena(String cadenaCaracteres){
        if (!cadenaCaracteres.contains(",")){
            throw new IllegalArgumentException("Cadena " + cadenaCaracteres
                    + " no contiene caracter ,");
        }
    }

    /**
     * Metodo a cargo de comprobar que la longuitud del vector contenedor de los numerosea exactamente igual a dos
     *
     * @param parametrosEntrada Es el vector de String que contiene los elementos ingresados separados
     * @param cadenaNumeros es la cadena completa sin separar
     */
    public void verificarCantidadParametros(String[] parametrosEntrada, String cadenaNumeros){
        if(parametrosEntrada.length>2){
            throw new IllegalArgumentException("Cadena " + cadenaNumeros
                    + " contiene mas caracter ,");
        }
        else if(parametrosEntrada.length<2){
            throw new IllegalArgumentException("Cadena " + cadenaNumeros
                    + " no contiene los parametros requeridos");
        }
    }

    /**
     * Metodo que verifica y asigna el tamaño de los numeros
     *
     * @param parametroCadena String que contiene el tamaño de los numeros
     * @return string convertido a entero
     */
    public int asignacionTamaño(String parametroCadena){
        int tamañoNumero;

        if(cadenaEsNumerico(parametroCadena)){
            tamañoNumero = Integer.parseInt(parametroCadena);
        }
        else{
            throw new IllegalArgumentException("Parametro Tamaño [" + parametroCadena
                    + "] no es un numero");
        }
        return tamañoNumero;
    }

    /**
     * Metodo encargado de validar y convertir si una cadena es numerica
     *
     * @param cadena variable a convertir en tipo numerico
     * @return un boolean con un verdadero o falso si convirtio la cadena
     */
    static boolean cadenaEsNumerico(String cadena){
        try{
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }

    /**
     * valida los paramrametros ingresados sean digitos,
     * comprobar los puntos fijos de cada digito e impresion de los digitos
     *
     * @param tamañoCadenaDigitos Tamaño de cada digito
     * @param cadenaDigitos contiene los 5 digitos ingresados
     * @param espacioDigito Espacio entre los digitos
     * @see Matriz
     */
    private void validarImpresionDigitos(int tamañoCadenaDigitos, String cadenaDigitos, int espacioDigito){
        int pivoteDeInicio = 0;
        char[] vectorDeDigitos;

        matriz.crearMatriz(tamañoCadenaDigitos,cadenaDigitos,espacioDigito);
        vectorDeDigitos = cadenaDigitos.toCharArray();

        for (char digito : vectorDeDigitos){

            if(!Character.isDigit(digito)){
                throw new IllegalArgumentException("Caracter " + digito
                        + " no es un digito");
            }
            int digitoIndividual = Integer.parseInt(String.valueOf(digito));
            pivoteDeInicio = matriz.calcularPuntosFijos(pivoteDeInicio);
            pivoteDeInicio = pivoteDeInicio + matriz.columDigito + espacioDigito;
            adicionarDigito(digitoIndividual);
        }
        matriz.imprimirMatriz();
    }

    /**
     *
     * definie los segmentos que componen un digito
     *
     * @param digitoIndividual contiene un digito para agregar a la matriz
     * @see SieteSegmento
     */
    private void adicionarDigito(int digitoIndividual){

        List<Integer> listaSegmentos;

        // ListaSegmentos adquiere la lista de segmentos que componen el digito ingresado
        listaSegmentos = sieteSegmentos.representarDigito(digitoIndividual);

        Iterator<Integer> iterator = listaSegmentos.iterator();

        while (iterator.hasNext()) {
            adicionarSegmento(iterator.next());
        }
    }

    /**
     * fija un segmento a la matriz de Impresion
     *
     * @param segmento contiene la parte del segmento a adicionar
     * @see Matriz
     */
    private void adicionarSegmento(int segmento) {

        switch (segmento) {
            case 1:
                adicionarLinea(this.matriz.matrizImpresion, this.matriz.puntofijo1, POSICION_Y,
                        this.matriz.tamaño, CARACTER_VERTICAL);
                break;
            case 2:
                adicionarLinea(this.matriz.matrizImpresion, this.matriz.puntofijo2, POSICION_Y,
                        this.matriz.tamaño, CARACTER_VERTICAL);
                break;
            case 3:
                adicionarLinea(this.matriz.matrizImpresion, this.matriz.puntofijo5, POSICION_Y,
                        this.matriz.tamaño, CARACTER_VERTICAL);
                break;
            case 4:
                adicionarLinea(this.matriz.matrizImpresion, this.matriz.puntofijo4, POSICION_Y,
                        this.matriz.tamaño, CARACTER_VERTICAL);
                break;
            case 5:
                adicionarLinea(this.matriz.matrizImpresion, this.matriz.puntofijo1, POSICION_X,
                        this.matriz.tamaño, CARACTER_HORIZONTAL);
                break;
            case 6:
                adicionarLinea(this.matriz.matrizImpresion, this.matriz.puntofijo2, POSICION_X,
                        this.matriz.tamaño, CARACTER_HORIZONTAL);
                break;
            case 7:
                adicionarLinea(this.matriz.matrizImpresion, this.matriz.puntofijo3, POSICION_X,
                        this.matriz.tamaño, CARACTER_HORIZONTAL);
                break;
            default:
                break;
        }
    }

    /**
     *
     * verifica y añade una linea a la matriz de Impresion
     *
     * @param matriz Matriz Impresion
     * @param puntoFijo Punto Pivote
     * @param posicionFija Posicion Fija
     * @param tamañoSegmento Tamaño Segmento
     * @param caracter Caracter Segmento
     */
    private void adicionarLinea(String[][] matriz, int[] puntoFijo, String posicionFija, int tamañoSegmento, String caracter){

        if (posicionFija.equalsIgnoreCase(POSICION_X)){
            for (int i = 1; i <= tamañoSegmento; i++){
                int valor = puntoFijo[1] + i;
                matriz[puntoFijo[0]][valor] = caracter;
            }
        }
        else if (posicionFija.equalsIgnoreCase(POSICION_Y)){
            for (int j = 1; j <= tamañoSegmento; j++){
                int valor = puntoFijo[0] + j;
                matriz[valor][puntoFijo[1]] = caracter;
            }
        }
    }
}
