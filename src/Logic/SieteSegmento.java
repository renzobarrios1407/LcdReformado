package Logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Renzo Barrios
 */
public class SieteSegmento {



    public SieteSegmento(){


    }

    /**
     * representa el digito en una Lista de enteros para luego adicionar sus segmentos
     *
     * @param digito un numero representando el digito a adicionar a la matriz
     * @return Lista de enteros que contiene la representacion de segmentos del numero
     */

    public List<Integer> representarDigito(int digito){

        List<Integer> listaSegmentos = new ArrayList<>();

        switch (digito){
            case 1:
                digitoUno(listaSegmentos);
                break;
            case 2:
                digitoDos(listaSegmentos);
                break;
            case 3:
                digitoTres(listaSegmentos);
                break;
            case 4:
                digitoCuatro(listaSegmentos);
                break;
            case 5:
                digitoCinco(listaSegmentos);
                break;
            case 6:
                digitoSeis(listaSegmentos);
                break;
            case 7:
                digitoSiete(listaSegmentos);
                break;
            case 8:
                digitoOcho(listaSegmentos);
                break;
            case 9:
                digitoNueve(listaSegmentos);
                break;
            case 0:
                digitoCero(listaSegmentos);
                break;
            default:
                break;
        }
       return listaSegmentos;
    }

    /**
     * Metodos que se encargan de agregar a la lista enteros que representan los segmentos de los digitos
     */

    public void digitoUno(List<Integer> segmentosDigitoUno){
        segmentosDigitoUno.add(3); //este SegList se utiliza para agregar el tipo de "segmento" para formar el numero que queremos
        segmentosDigitoUno.add(4);
    }

    public void digitoDos(List<Integer> segmentosDigitoDos){
        segmentosDigitoDos.add(5);
        segmentosDigitoDos.add(3);
        segmentosDigitoDos.add(6);
        segmentosDigitoDos.add(2);
        segmentosDigitoDos.add(7);
    }

    public void digitoTres(List<Integer> segmentosDigitoTres){
        segmentosDigitoTres.add(5);
        segmentosDigitoTres.add(3);
        segmentosDigitoTres.add(6);
        segmentosDigitoTres.add(4);
        segmentosDigitoTres.add(7);
    }

    public void digitoCuatro(List<Integer> segmentosDigitoCuatro){
        segmentosDigitoCuatro.add(1);
        segmentosDigitoCuatro.add(6);
        segmentosDigitoCuatro.add(3);
        segmentosDigitoCuatro.add(4);
    }

    public void digitoCinco(List<Integer> segmentosDigitoCinco){
        segmentosDigitoCinco.add(5);
        segmentosDigitoCinco.add(1);
        segmentosDigitoCinco.add(6);
        segmentosDigitoCinco.add(4);
        segmentosDigitoCinco.add(7);
    }

    public void digitoSeis(List<Integer> segmentosDigitoSeis){
        segmentosDigitoSeis.add(5);
        segmentosDigitoSeis.add(1);
        segmentosDigitoSeis.add(6);
        segmentosDigitoSeis.add(2);
        segmentosDigitoSeis.add(7);
        segmentosDigitoSeis.add(4);
    }

    public void digitoSiete(List<Integer> segmentosDigitoSiete){
        segmentosDigitoSiete.add(5);
        segmentosDigitoSiete.add(3);
        segmentosDigitoSiete.add(4);
    }

    public void digitoOcho(List<Integer> segmentosDigitoOcho){
        segmentosDigitoOcho.add(1);
        segmentosDigitoOcho.add(2);
        segmentosDigitoOcho.add(3);
        segmentosDigitoOcho.add(4);
        segmentosDigitoOcho.add(5);
        segmentosDigitoOcho.add(6);
        segmentosDigitoOcho.add(7);
    }

    public void digitoNueve(List<Integer> segmentosDigitoNueve){
        segmentosDigitoNueve.add(1);
        segmentosDigitoNueve.add(3);
        segmentosDigitoNueve.add(4);
        segmentosDigitoNueve.add(5);
        segmentosDigitoNueve.add(6);
        segmentosDigitoNueve.add(7);
    }

    public void digitoCero(List<Integer> segmentosDigitoCero){
        segmentosDigitoCero.add(1);
        segmentosDigitoCero.add(2);
        segmentosDigitoCero.add(3);
        segmentosDigitoCero.add(4);
        segmentosDigitoCero.add(5);
        segmentosDigitoCero.add(7);
    }





}
