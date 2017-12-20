/**
 * 
 */
package Model.AlgoritmosDeOrdenamiento;

import Controller.Controlador;
import Model.Muestra;

/**
 * Clase que representa el Sub-Proceso Algoritmo de Inserción.
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class AlgoritmoInsercion extends Thread
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    //  Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Muestra no ordenada.
     */
    private final Muestra muestra;
    
    /**
     * Controlador principal de la aplicación.
     */
    private final Controlador ctrl;
    
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Contruye el Sub-Proceso Algoritmo de Ordenamiento Inserción.
     * @param muestra Muestra generada por el usuario no ordenada.
     * @param ctrl Controlador principal de la aplicación.
     */
    public AlgoritmoInsercion(Muestra muestra, Controlador ctrl)
    {
        this.muestra = muestra;
        this.ctrl = ctrl;
    }
    
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
    
    @Override
    /**
     * Metodo principal del sub-proceso.
     */
    public void run()
    {
        long t1 = System.currentTimeMillis();
        int [] muesraOrganizada = ordenamientoInsercion();
        long t2 = System.currentTimeMillis(); 
        long tiempo = t2 - t1;
        muestra.setListaNumeros(muesraOrganizada);
        ctrl.actualizarMuestraOrdenada(muestra);
        ctrl.tiempoOrdenamientoInsercion(tiempo);
        this.stop();
        
    }
    
    /**
     * Ordena la lista de elementos de la muestra haciendo uso de Algoritmo
     * Inserción.
     * @return Lista de elementos ordenados.
     */
    public int [] ordenamientoInsercion()
    {
        int [] muestraNoOrganizada = muestra.getListaNumeros();
        int tamanio = muestraNoOrganizada.length;
        for( int i = 1; i < tamanio; i++ )
        {
            for( int j = i; j > 0 && muestraNoOrganizada[ j - 1 ] > muestraNoOrganizada[ j ]; j-- )
            {
                int temp = muestraNoOrganizada[ j ];
                muestraNoOrganizada[ j ] = muestraNoOrganizada[ j - 1 ];
                muestraNoOrganizada[ j - 1 ] = temp;
            }
            ctrl.estadoProceso(i);
        }
        
        return muestraNoOrganizada;
    }
}
