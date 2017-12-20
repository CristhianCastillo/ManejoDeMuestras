/**
 * 
 */
package Model.AlgoritmosDeOrdenamiento;

import Controller.Controlador;
import Model.Muestra;

/**
 * Clase que representa el Sub Proceso Algoritmo de ordenamiento Selección.
 * @author Cristhian Eduardo Castillo Erazo
 */
public class AlgoritmoSeleccion extends Thread
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    //  Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Muestra generada por el usuario no ordenada.
     */
    private final Muestra muestra;
    
    /**
     * Controlador principal de la aplicación.
     */
    private final Controlador ctrl;
    
    // -------------------------------------------------------------------------
    //  Constructor
    // -------------------------------------------------------------------------
    
    /**
     * Construye el sub proceso Algoritmo de Selección.
     * @param muestra Muestra no ordenada.
     * @param ctrl Cotrolador principal de la aplicación.
     */
    public AlgoritmoSeleccion(Muestra muestra, Controlador ctrl)
    {
        this.muestra = muestra;
        this.ctrl = ctrl;
    }
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
    
    @Override
    /**
     * Metodo principal del Sub Proceso.
     */
    public void run()
    {
        long t1 = System.currentTimeMillis();
        int [] muesraOrganizada = ordenamientoSeleccion();
        long t2 = System.currentTimeMillis(); 
        long tiempo = t2 - t1;
        
        muestra.setListaNumeros(muesraOrganizada);
        ctrl.actualizarMuestraOrdenada(muestra);
        ctrl.tiempoOrdenamientoSeleccion(tiempo);
        this.stop();
        
    }
    
    /**
     * Ordena la lista de elementos utilizando el ordenamiento por Selección.
     * @return Lista de elementos ordenados.
     */
    public int [] ordenamientoSeleccion()
    {
        int [] muestraNoOrganizada = muestra.getListaNumeros();
        int tamanio = muestraNoOrganizada.length;
        for( int i = 0; i < tamanio - 1; i++ )
        {
            int menor = muestraNoOrganizada[ i ];
            int cual = i;
            // Busca el mínimo elemento entre una posición i y el final de la lista
            for( int j = i + 1; j < tamanio; j++ )
            {
                if( muestraNoOrganizada[ j ] < menor )
                {
                    menor = muestraNoOrganizada[ j ];
                    cual = j;
                }
            }
            // Intercambia el mínimo con el elemento de la posición i
            int temp = muestraNoOrganizada[ i ];
            muestraNoOrganizada[ i ] = menor;
            muestraNoOrganizada[ cual ] = temp;
            ctrl.estadoProceso(i + 1);
        }
        
        return muestraNoOrganizada;
    }
    
}
