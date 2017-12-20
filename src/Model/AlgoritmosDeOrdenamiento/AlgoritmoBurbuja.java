/**
 * 
 */
package Model.AlgoritmosDeOrdenamiento;

import Controller.Controlador;
import Model.Muestra;

/**
 * Clase que representa el subProceso del Algoritmo de ordenamiento Burbuja.
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class AlgoritmoBurbuja extends Thread implements Runnable
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    //  Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Representa la muestra ordenada.
     */
    private final Muestra muestra;
    
    /**
     * Representa el Controlador principal de la aplicación.
     */
    private final Controlador ctrl;
    
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Contruye el Sub-Proceso Algoritmo Burbuja.
     * @param muestra Muestra generada por el usuario.
     * @param ctrl Controlador principal de la aplicación.
     */
    public AlgoritmoBurbuja(Muestra muestra, Controlador ctrl)
    {
       this.muestra = muestra;
       this.ctrl = ctrl;
    }
    
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
    
    @Override
    /**
     * Metodo principal del Sub-proceso.
     */
    public void run()
    {
        int [] muestraNoOrganizada = muestra.getListaNumeros();
        long t1 = System.currentTimeMillis();
        int [] muesraOrganizada = ordenamientoBurbuja(muestraNoOrganizada);
        long t2 = System.currentTimeMillis(); 
        long tiempo = t2 - t1;
        
        muestra.setListaNumeros(muesraOrganizada);
        ctrl.actualizarMuestraOrdenada(muestra);
        ctrl.tiempoOrdenamientoBurbuja(tiempo);
        this.stop();
        
    }
    
    /**
     * Ordena la muestra generada por el usuario 
     * @param n Lista de elementos.
     * @return Lista de elementos ordenados.
     */
    public int [] ordenamientoBurbuja( int [] n)
    {
        int tamanio = n.length;
        for( int i = tamanio; i > 0; i-- )
        {
            for( int j = 0; j < i - 1; j++ )
            {
                if(n[ j ] > n[ j + 1 ] )
                {
                    int temp = n[ j ];
                    n[ j ] = n[ j + 1 ];
                    n[ j + 1 ] = temp;
                }
            }
            
            ctrl.estadoProceso((tamanio+1) - i);
        }
        return n;
    }
}
