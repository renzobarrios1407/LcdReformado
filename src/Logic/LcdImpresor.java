package Logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LcdImpresor {

    static final String CARACTER_VERTICAL = "|";
    static final String CARACTER_HORIZONTAL = "-";
    static final String POSICION_X = "X";
    static final String POSICION_Y = "Y";
    public Matriz matriz = new Matriz();
    public SieteSegmento sieteSegmentos = new SieteSegmento();
    // TODO code application logic here

    public LcdImpresor(){
    }

    /**
     * Metodo encargado de procesar la entrada de datos que contiene el tamaño, los numeros a imprimir y el espacio entre los digitos
     *
     * @param cadenaNumeros cadena que contiene el tamaño y los numeros a imprimir
     * @param espacioDigitos Espacio Entre digitos
     */
    public void procesarEntrada(String cadenaNumeros, int espacioDigitos) { //metodo encargado de la validacion de la entrada, no "procesa" algo exactamente

        String[] cadenaDigitos;
        int tamañoDigito;

        verificarSeparadorDeCadena(cadenaNumeros);
        cadenaDigitos = cadenaNumeros.split(","); //Se hace el split de la cadena de numeros digitada [X,ABCDE]

        verificarCantidadParametros(cadenaDigitos,cadenaNumeros);
        tamañoDigito =  asignacionTamaño(cadenaDigitos[0]);

        validarImpresionDigitos(tamañoDigito, cadenaDigitos[1],espacioDigitos); // Realiza la impresion del numero, tam es el tamaño, parametros[1] manda los numeros que se van a imprimir "12345.." y el espacio entre ellos
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
    public int asignacionTamaño(String parametroCadena)
    {
        int tamañoNumero;

        if(cadenaEsNumerico(parametroCadena))
        {
            tamañoNumero = Integer.parseInt(parametroCadena);
        }
        else
        {
            throw new IllegalArgumentException("Parametro Size [" + parametroCadena
                    + "] no es un numero");
        }
        return tamañoNumero;
    }

    /**
     * Metodo encargado de validar y convertir si una cadena es numerica
     *
     * @param cadena variable a convertir en tipo numerico
     */
    static boolean cadenaEsNumerico(String cadena){
        try
        {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    /**
     * Metodo encargado de validar los paramrametros ingresados sean digitos,
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
        vectorDeDigitos = cadenaDigitos.toCharArray(); // crea el arreglo de digitos

        for (char digito : vectorDeDigitos){ //cambiar por un for normal, aunque se esta utilizando el patron Iterator

            if(!Character.isDigit(digito)){ //Valida que el caracter sea un digito
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
     * Metodo encargado de definir los segmentos que componen un digito y
     * a partir de los segmentos adicionar la representacion del digito a la matriz
     *
     * @param digitoIndividual contiene un digito para agregar a la matriz
     */
    private void adicionarDigito(int digitoIndividual){

        // Establece los segmentos de cada numero
        List<Integer> listaSegmentos = new ArrayList<>();
        listaSegmentos = seleccionarDigito(listaSegmentos);



        switch (digitoIndividual){
            case 1:
                listaSegmentos = seleccionarDigito(listaSegmentos);
                listaSegmentos.add(3); //este SegList se utiliza para agregar el tipo de "segmento" para formar el numero que queremos
                listaSegmentos.add(4);
                break;
            case 2:
                listaSegmentos.add(5);
                listaSegmentos.add(3);
                listaSegmentos.add(6);
                listaSegmentos.add(2);
                listaSegmentos.add(7);
                break;
            case 3:
                listaSegmentos.add(5);
                listaSegmentos.add(3);
                listaSegmentos.add(6);
                listaSegmentos.add(4);
                listaSegmentos.add(7);
                break;
            case 4:
                listaSegmentos.add(1);
                listaSegmentos.add(6);
                listaSegmentos.add(3);
                listaSegmentos.add(4);
                break;
            case 5:
                listaSegmentos.add(5);
                listaSegmentos.add(1);
                listaSegmentos.add(6);
                listaSegmentos.add(4);
                listaSegmentos.add(7);
                break;
            case 6:
                listaSegmentos.add(5);
                listaSegmentos.add(1);
                listaSegmentos.add(6);
                listaSegmentos.add(2);
                listaSegmentos.add(7);
                listaSegmentos.add(4);
                break;
            case 7:
                listaSegmentos.add(5);
                listaSegmentos.add(3);
                listaSegmentos.add(4);
                break;
            case 8:
                listaSegmentos.add(1);
                listaSegmentos.add(2);
                listaSegmentos.add(3);
                listaSegmentos.add(4);
                listaSegmentos.add(5);
                listaSegmentos.add(6);
                listaSegmentos.add(7);
                break;
            case 9:
                listaSegmentos.add(1);
                listaSegmentos.add(3);
                listaSegmentos.add(4);
                listaSegmentos.add(5);
                listaSegmentos.add(6);
                listaSegmentos.add(7);
                break;
            case 0:
                listaSegmentos.add(1);
                listaSegmentos.add(2);
                listaSegmentos.add(3);
                listaSegmentos.add(4);
                listaSegmentos.add(5);
                listaSegmentos.add(7);
                break;
            default:
                break;
        }

        Iterator<Integer> iterator = listaSegmentos.iterator(); // mete toda la lista de "segList" en un Iterator

        while (iterator.hasNext()) { //mientras exista objetos en el iterator mientras tenga algun valor siguiente, sigue en el while
            adicionarSegmento(iterator.next());  //adiciona un segmento en el valor actual del Iterador
        }
    }

    public ArrayList<Integer> seleccionarDigito(int numeros){

        List<Integer> elementosDigitos = new ArrayList<>();

        if (numeros==1){
            elementosDigitos.add(1)
        }





    }


    /**
     *
     * Metodo encargado de un segmento a la matriz de Impresion
     *
     * @param segmento Segmento a adicionar
     */
    private void adicionarSegmento(int segmento) { // metodo que se encarga de clasificar la creacion de un numero del 0 al 9

        switch (segmento) { //son solo 7 cases porque así se define el "Seven Segment Display" para la visualizacion de numeros
            case 1: // agrega el segmento superior o numero 1 del "Seven Segment Display"
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
     * Metodo encargado de añadir una linea a la matriz de Impresion
     *
     * @param matriz Matriz Impresion
     * @param puntoFijo Punto Pivote
     * @param posFija Posicion Fija
     * @param tamañoSegmento Tamaño Segmento
     * @param caracter Caracter Segmento
     */
    private void adicionarLinea(String[][] matriz, int[] puntoFijo, String posFija, int tamañoSegmento, String caracter) // recibe la matriz completa, un punto fijo para empezar a dibujar la linea, una posicion fija sea "X" o "Y", el tamaño y el caracter a pintar
    {
        // sea  "|" o "-"
        if (posFija.equalsIgnoreCase(POSICION_X)){
            for (int i = 1; i <= tamañoSegmento; i++){
                int valor = puntoFijo[1] + i; //punto[1] (en la posicion 1) suma 1 para ir pasando de espacio sea horizontal o vertical
                matriz[puntoFijo[0]][valor] = caracter; //aqui se mueve el espacio de la matriz por la columna hasta que llegue al valor se "tamaño" deteniendo el for y llenando lo requerido
            }
        }
        else if (posFija.equalsIgnoreCase(POSICION_Y)){
            for (int j = 1; j <= tamañoSegmento; j++){
                int valor = puntoFijo[0] + j;
                matriz[valor][puntoFijo[1]] = caracter; //aqui se mueve el espacio de la matriz por la fila hasta que llegue al valor se "tamaño" deteniendo el for y llenando lo requerido
            }
        }
    }
}
