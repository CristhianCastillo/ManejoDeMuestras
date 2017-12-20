/**
 * 
 */
package Model.AlgoritmosDeBusqueda;

import Controller.Controlador;
import Model.Muestra;

/**
 * Clase que representa el subProceso del Algoritmo de busqueda Secuencial.
 * @author Cristhian Eduardo Castillo Erazo.
 */
@SuppressWarnings("serial")
public class AlgoritmoSecuencia extends Thread
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
     * Construye el Sub-proceso Algoritmo Secuencial.
     * @param muestra Muestra que contiene la lista ordenada.
     * @param ctrl Controlador principal de la aplicación.
     */
    public AlgoritmoSecuencia(Muestra muestra, Controlador ctrl)
    {
        this.muestra = muestra;
        this.ctrl = ctrl;
    }
    
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
    
    @Override
    /**
     * Metodo principal del Sub-Proceso.
     */
    public void run()
    {
        int minimo = Muestra.LIMITE_INFERIOR;
        int limite = muestra.getLimite();
        long tiempo = 0;
        for(int i = minimo; i <= limite; i ++)
        {
            long t1 = System.currentTimeMillis();
            busquedaSecuancial(i);
            long t2 = System.currentTimeMillis();
            tiempo += (t2-t1);
            ctrl.estadoProceso(i);
        } 
        ctrl.tiempoBusquedaSecuencial((double)tiempo/(double)muestra.getTamanio());
       this.stop();
    }
    
    /**
     * Realiza la busqueda secuencial de un elementos en la lista Ordenada.
     * @param elemento Elemento generado por el usuario.
     * @return true: Si el elemento se encuentra en la lista. false: Si el
     * elemento no se encuentra en la lista.
     */
    public boolean busquedaSecuancial(int elemento)
    {
        int [] listaNumeros = muestra.getListaNumeros();
        for (int i =0; i < listaNumeros.length; i ++ )
        {
            if(elemento == listaNumeros[i])
                return true;
        }
        return false;
    }
}
