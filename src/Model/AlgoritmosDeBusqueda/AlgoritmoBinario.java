/**
 * 
 */
package Model.AlgoritmosDeBusqueda;

import Controller.Controlador;
import Model.Muestra;

/**
 * Clase que representa el subProceso del Algoritmo de busqueda Bianrio.
 * @author Cristhian Eduardo Castillo Erazo
 */
@SuppressWarnings("serial")
public class AlgoritmoBinario extends Thread
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    //  Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Muestra de enteros para ejecutar el algormitmo de busqueda secuencial.
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
     * Construye el SubProceso Algoritmo binario.
     * @param muestra Muestra que contiene la lista de elementos.
     * @param ctrl Controlador principal de la aplicación.
     */
    public AlgoritmoBinario(Muestra muestra, Controlador ctrl)
    {
        this.muestra = muestra;
        this.ctrl = ctrl;
    }
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
    
   
    @Override
    /**
     * Metodo principal del sub proceso.
     */
    
    public void run()
    {
        int minimo = Muestra.LIMITE_INFERIOR;
        int limite = muestra.getLimite();
        long tiempo = 0;
        for(int i = minimo; i <= limite; i ++)
        {
            long t1 = System.currentTimeMillis();
            busquedaBinaria(i);
            long t2 = System.currentTimeMillis();
            tiempo += (t2-t1);
            ctrl.estadoProceso(i);
        } 
        ctrl.tiempoBusquedaBinaria((double)tiempo/(double)muestra.getTamanio());
        this.stop();
    }
    
    /**
     * Realiza la busuqeda binaria de un elemento en la lista ordenada.
     * @param elemento Elemento a buscar en la lista.
     * @return true: Si el elemento esta en la lista. false: Si el elemento no
     * esta en la lista.
     */
    public boolean busquedaBinaria(int elemento)
    {
        int inicio = 0;
        int [] muestraNumerosOrdenados = muestra.getListaNumeros();
        int fin = muestraNumerosOrdenados.length - 1;
        while( inicio <= fin)
        {
            int medio = ( inicio + fin ) / 2;
            if( muestraNumerosOrdenados[ medio ] == elemento )
            {
                return true;
            }
            else if( muestraNumerosOrdenados[ medio ] > elemento )
            {
                fin = medio - 1;
            }
            else
            {
                inicio = medio + 1;
            }
        }
        return false;
    }
    
}
