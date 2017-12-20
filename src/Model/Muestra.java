/**
 * 
 */
package Model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Clase que representa la muestra de datos.
 * @author Cristhian Eduardo Castillo Erazo.
 */
@SuppressWarnings("serial")
public class Muestra
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    /**
     * Constante que representa el limite inferior de la muetra.
     */
    public static final int LIMITE_INFERIOR = 1;
    
    // -------------------------------------------------------------------------
    //  Atributos
    // -------------------------------------------------------------------------
    
    
    /**
     * Secuencia de enteros para la muestra.
     */
    private int [] listaDeNumeros;
    
    /**
     * Limite superior de la muestra.
     */
    
    private final int limiteSuperior;
    
    /**
     * Tamaño de la muestra.
     */
    private final int tamanio;
    
    /**
     * Dato minimo de la muestra.
     */
    private int minimo;
    
    /**
     * Dato maximo de la muestra.
     */
    private int maximo;
    
    /**
     * Promedio de la muestra.
     */
    private double promedio;
    
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye la muestra.
     * @param tamanio Tamaño de la muestra.
     * @param limiteSuperior
     */
    public Muestra(int tamanio, int limiteSuperior)
    {
        this.tamanio = tamanio;
        this.limiteSuperior = limiteSuperior;
        this.promedio = 0;
        this.minimo = 0;
        this.maximo = 0;
        listaDeNumeros = new int [tamanio];
    }
    
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
    
    /**
     * Genera numeros enterior aleatorios para la muestra.
     * Encuentra el numero menor de la muestra.
     * Encuentra el numero mayor de la muestra.
     * Encuentra el promedio de la muestra.
     */
    public void nuevaMuestra()
    {
        BigInteger suma = new BigInteger("0");
        int mayor = 0;
        int menor = 0;
        int numeroMuestra;
        
        for(int i = 0; i < listaDeNumeros.length; i ++)
        {
            numeroMuestra = (int)(Math.random()* limiteSuperior + LIMITE_INFERIOR);
            listaDeNumeros[i] = numeroMuestra;
            BigInteger numeroActual = new BigInteger(numeroMuestra + "");
            suma = suma.add(numeroActual);
            
            if(i == 0)
            {
                mayor = numeroMuestra;
                menor = numeroMuestra;
            }
            else
            {
                if(numeroMuestra > mayor)
                {
                    mayor = numeroMuestra;
                }
                
                if(numeroMuestra < menor)
                {
                    menor = numeroMuestra;
                }    
            }
        }
        
        //Promedio
        BigDecimal sumaBig = new BigDecimal(suma);
        BigDecimal tamanioTemp = new BigDecimal(tamanio);
        sumaBig = sumaBig.divide(tamanioTemp, 2, RoundingMode.HALF_UP);
        
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        
        DecimalFormat promedioFormateado = new DecimalFormat("#.00", separadoresPersonalizados);
        
        double promedioTemp = sumaBig.doubleValue();
        String real = promedioFormateado.format(promedioTemp);
        
        this.promedio = Double.parseDouble(real);
        
        //Minimo
        this.minimo = menor;
 
        //Maximo
        this.maximo = mayor;
    }
    
    /**
     * Determina la cantidad de numeros en un rango especifico.
     * @param limiteInferior Limite Inferior del rango.
     * @param limiteSuperior Limite Superior del rango.
     * @return Cantidad de numeros.
     */
    public int numerosDentroRango(int limiteInferior, int limiteSuperior)
    {
        int posicionInferior = 0;
        int posicionSuperior = 0;
        
        //Obteniendo posición inferior.
        for(int i = 0; i < listaDeNumeros.length; i ++)
        {
            int elemento = listaDeNumeros[i];
            if(elemento >= limiteInferior)
            {
                posicionInferior = i;
                break;
            }
        }
        
        //Obteniendo posición superior
        for(int j = listaDeNumeros.length - 1; j >= 0; j --)
        {
            int elemento = listaDeNumeros[j];
            if(elemento <= limiteSuperior)
            {
                posicionSuperior = j;
                break;
            }
        }
        
        return (posicionSuperior - posicionInferior)+1;
        
    }
    
    /**
     * Obtiene el numero de ocurrencias de un numero entregado por el usuario.
     * @param elemento Elemento a buscar en la lista.
     * @return Cantidad de ocurencias del numero en la lista.
     */
    public int numeroOcurrencias(int elemento)
    {
        int cantidad = 0;
        for (int i = 0; i < listaDeNumeros.length; i ++)
        {
            int elementoActual = listaDeNumeros[i];
            if(elementoActual == elemento)
            {
                cantidad ++;
            }
        }
        
        return cantidad;
    }
    
    /**
     * Obtiene la cantidad de numeros distintos de la muestra.
     * @return Numero de elementos distintos.
     */
    public int numerosDistintos()
    {
        int cantidad = 0;
        int numeroActual = 0;
        for(int i =0; i < listaDeNumeros.length; i ++)
        {
            int elementoTemp = listaDeNumeros[i];
            if(numeroActual != elementoTemp)
            {
                cantidad ++;
                numeroActual = elementoTemp;
            }
        }
        
        return cantidad;
    }
    
    /**
     * Obtiene el elemento mas frecuente de la lista.
     * @return Elemento mas frecuente.
     */
    public int valorMasFrecuente()
    {
        int numeroMasFrecuente = 0;
        int cantidadMasFrencuente = 0;
        
        int numeroMasFrecuenteTemp = 0;
        int cantidadMasFrecuenteTemp = 0;
        
        int numeroActual = 0;
        for(int i = 0; i < listaDeNumeros.length; i ++)
        {
            int elementoTemp = listaDeNumeros[i];
            if(numeroActual != elementoTemp)
            {
                //Validar el cambio del mas frecuente hasta el momento...
                if(cantidadMasFrencuente < cantidadMasFrecuenteTemp)
                {
                    cantidadMasFrencuente = cantidadMasFrecuenteTemp;
                    numeroMasFrecuente = numeroMasFrecuenteTemp;
                }
                
                //Refresco de los nuevos elementos
                numeroActual = elementoTemp;
                cantidadMasFrecuenteTemp = 0;
                
                numeroMasFrecuenteTemp = elementoTemp;
                cantidadMasFrecuenteTemp ++;
            }
            else
            {
                cantidadMasFrecuenteTemp ++;
            }
        }
        
        return numeroMasFrecuente;
    }
    
    /**
     * Obtiene el tamaño de la muestra.
     * @return Tamaño de la muestra.
     */
    public int getTamanio()
    {
        return tamanio;
    }
    
    /**
     * Obtiene el limite superior de la muestra.
     * @return Limite superior de la muestra.
     */
    public int getLimite()
    {
        return limiteSuperior;
    }
    
    /**
     * Obtiene el promedio de la muestra.
     * @return Promedio de la muestra.
     */
    public double getPromedio()
    {
        return promedio;
    }
    
    /**
     * Obtiene el minimo de la muestra.
     * @return Minimo valor de la muestra.
     */
    public int getMinimo()
    {
        return minimo;
    }
    
    /**
     * Obtiene el valor maximo de la muestra.
     * @return Maximo valor de la muestra.
     */
    public int getMaximo()
    {
        return maximo;
    }
    
    /**
     * Obtiene la lista de elementos generados.
     * @return Lista de elementos.
     */
    public int[] getListaNumeros()
    {
        return this.listaDeNumeros;
    }
    
    /**
     * Actualiza la lista de elementos.
     * @param nuevaLista Lista de elementos. nuevaLista != null.
     */
    public void setListaNumeros(int [] nuevaLista)
    {
        this.listaDeNumeros = nuevaLista;
    }
   
}
