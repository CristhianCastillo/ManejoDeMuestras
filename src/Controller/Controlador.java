/**
 * 
 */
package Controller;

import Model.AlgoritmosDeBusqueda.AlgoritmoBinario;
import Model.AlgoritmosDeBusqueda.AlgoritmoSecuencia;
import Model.AlgoritmosDeOrdenamiento.AlgoritmoBurbuja;
import Model.AlgoritmosDeOrdenamiento.AlgoritmoInsercion;
import Model.AlgoritmosDeOrdenamiento.AlgoritmoSeleccion;
import Model.Muestra;
import View.PanelBusqueda;
import View.PanelMuestra;
import View.PanelOrdenamiento;
import View.PanelOtrasBusquedas;
import View.VentanaProceso;
import javax.swing.JOptionPane;

/**
 * Controlador principal de la aplicación.
 * @author Cristhian Eduardo Castillo Erazo.
 */
@SuppressWarnings("serial")
public class Controlador
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    //  Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Corresponde a la muestra de datos.
     */
    private Muestra muestra;
    
    /**
     * Corresponde a la muestra de datos organizada.
     */
    private Muestra muestraOrganizada;
    
    /**
     * Representa el Panel Datos de la muestra.
     */
    private PanelMuestra pnlMuestra;
    
    /**
     * Representa el Panel Búsqueda.
     */
    private PanelBusqueda pnlBusqueda;
    
    /**
     * Representa la ventana para visualizar el proceso.
     */
    private VentanaProceso proceso;
    
    /**
     * Representa el Panel Ordenamiento.
     */
    private PanelOrdenamiento pnlOrdenamiento;
    
    /**
     * Representa el Panel Otras busquedas.
     */
    private PanelOtrasBusquedas pnlOtrasBusquedas;
    
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye el controlador principal de la aplicación.
     */
    public Controlador()
    {
        this.muestra = null;
        this.muestraOrganizada = null;
        this.proceso = null;
    }
    
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
    
    /**
     * Conecta los paneles con el Controlador para la actualizacion de algunos
     * valores contenidos en los paneles.
     * @param pnlMuestra Panel Muestra.
     * @param pnlBusqueda Panel Busqueda.
     * @param pnlOrdenamiento Panel Ordenamiento.
     * @param pnlOtrasBusquedas Panel Otras Busquedas.
     */
    public void conectar(PanelMuestra pnlMuestra, PanelBusqueda pnlBusqueda, PanelOrdenamiento pnlOrdenamiento, PanelOtrasBusquedas pnlOtrasBusquedas )
    {
        this.pnlMuestra = pnlMuestra;
        this.pnlBusqueda = pnlBusqueda;
        this.pnlOrdenamiento = pnlOrdenamiento; 
        this.pnlOtrasBusquedas = pnlOtrasBusquedas;
    }
    
    /**
     * Genera una nueva muestra.
     * @param tamanio Tamaño de la muestra.
     * @param limite Limite superior de la muestra.
     */
    public void generarNuevaMuestra(int tamanio, int limite)
    {
        muestra = null;
        muestraOrganizada = null;
        
        muestra = new Muestra(tamanio, limite);
        muestra.nuevaMuestra();
        
        pnlMuestra.setTamanio(muestra.getTamanio() + "");
        pnlMuestra.setLimite(muestra.getLimite() + "");
        pnlMuestra.setPromedio(muestra.getPromedio() + "");
        pnlMuestra.setMinimo(muestra.getMinimo() + "");
        pnlMuestra.setMaximo(muestra.getMaximo() + "");  
       
    }
    
    /**
     * Inicializa el proceso para realizar la busqueda Secuencial de cada
     * elemento de la muestra.
     * @throws Exception 
     */
    public void busquedaSecuancial() throws Exception
    {
        if(muestra != null)
        {
            AlgoritmoSecuencia busquedaSecuancial = new AlgoritmoSecuencia(muestra, this);
            proceso = new VentanaProceso("Algoritmo de Búsqueda Secuencial",busquedaSecuancial, muestra.getTamanio());
            
        }
        else
        {
            throw new Exception("Debe generar una muestra primero.");
        }
    }
    
    /**
     * Inicializa el proceso para realizar la busqueda binaria de cada elemento
     * de la muestra.
     * @throws Exception 
     */
    public void busquedaBinaria() throws Exception
    {
        if(muestraOrganizada != null)
        {
            AlgoritmoBinario busquedaBinaria = new AlgoritmoBinario(muestraOrganizada, this);
            proceso = new VentanaProceso("Algoritmo de búsqueda Binaria", busquedaBinaria, muestraOrganizada.getTamanio());
        }
        else
        {
            throw new Exception("Debe generar una muestra primero y organizarla.");
        }
    }
    
    /**
     * Actualiza la barra de progreso del Dialogo emergente del proceso que se 
     * este ejecutando.
     * @param estado Valor del estado actual. estado != null.
     */
    public void estadoProceso(int estado)
    {
        proceso.actualizarProgreso(estado);
    }
    
    /**
     * Actualiza en el Panel Busqueda el tiempo requerido por el algoritmo de
     * busqueda secuancial para cada elemento del rango elegido por el usuario.
     * @param tiempo Tiempo invertido. tiempo >= 0.0.
     */
    public void tiempoBusquedaSecuencial(double tiempo)
    {
        pnlBusqueda.setTiempoSecuencial(tiempo + "ms");
    }
    
    /**
     * Actualiza en el Panel Busqueda el tiempo requerido por el algoritmo de
     * busqueda Binaria, para cada elemento del rango elegido por el usuario.
     * @param tiempo Tiempo invertido. tiempo >= 0.0.
     */
    public void tiempoBusquedaBinaria(double tiempo)
    {
        pnlBusqueda.setTiempoBinaria(tiempo + "ms");
    }
    
    /**
     * Actualiza en el Panel Ordenamiento el tiempo requerido por el algoritmo
     * de Ordenamiento Burbuja, para ordenar la muestra generada.
     * @param tiempo Tiempo invertido. tiempo >= 0.0.
     */
    public void tiempoOrdenamientoBurbuja(double tiempo)
    {
        pnlOrdenamiento.setTiempoBurbuja(tiempo + "ms");
    }
    
    /**
     * Actualiza en el Panel Ordenamiento el tiempo requerido por el algoritmo
     * de Ordenamiento Selección, para ordenar la muestra generada.
     * @param tiempo Tiempo invertido. tiempo >= 0.0.
     */
    public void tiempoOrdenamientoSeleccion(double tiempo)
    {
        pnlOrdenamiento.setTiempoSeleccion(tiempo + "ms");
    }
    
    /**
     * Actualiza en el Panel Ordenamiento el tiempo requerido por el algoritmo
     * de Ordenamiento Insercipon, para ordenar la muestra generada.
     * @param tiempo Tiempo invertido. tiempo >= 0.0.
     */
    public void tiempoOrdenamientoInsercion(double tiempo)
    {
        pnlOrdenamiento.setTiempoInsercion(tiempo + "ms");
    }
    
    /**
     * Inicializa el proceso para realizar el ordenamiento de la lista generada
     * utilizando el Algoritmo Burbuja.
     * @throws Exception 
     */
    public void ordenamientoBurbuja() throws Exception
    {
        if(muestra != null)
        {
            int tamanio = muestra.getTamanio();
            int limite = muestra.getLimite();
            int listaNumeros[] = muestra.getListaNumeros().clone();
            
            Muestra muestraTemp = new Muestra(tamanio, limite);
            muestraTemp.setListaNumeros(listaNumeros);
            
            AlgoritmoBurbuja ordenBurbuja = new AlgoritmoBurbuja(muestraTemp, this);
            proceso = new VentanaProceso("Algoritmo de ordenamiento Burbuja", ordenBurbuja,tamanio);
        }
        else
        {
            throw new Exception("Debe generar una muestra primero.");
        }
        
    }
    
    /**
     * Inicializa el proceso para realizar el ordenamiento de la lista generada
     * utilizando el Algoritmo Selección.
     * @throws Exception 
     */
    public void ordenamientoSeleccion() throws Exception
    {
        if(muestra != null)
        {
            int tamanio = muestra.getTamanio();
            int limite = muestra.getLimite();
            int listaNumeros[] = muestra.getListaNumeros().clone();
            
            Muestra muestraTemp = new Muestra(tamanio, limite);
            muestraTemp.setListaNumeros(listaNumeros);
            
            AlgoritmoSeleccion ordenSeleccion = new AlgoritmoSeleccion(muestraTemp, this);
            proceso = new VentanaProceso("Algoritmo de ordenamiento Selección", ordenSeleccion, tamanio-1);
        }
        else
        {
            throw new Exception("Debe generar una muestra primero.");
        }
        
    }
    
    /**
     * Inicializa el proceso para realizar el ordenamiento de la lista generada,
     * utilizando el Algoritmo Inserción.
     * @throws Exception 
     */
    public void ordenamientoInsercion() throws Exception
    {
        if(muestra != null)
        {
            int tamanio = muestra.getTamanio();
            int limite = muestra.getLimite();
            int listaNumeros[] = muestra.getListaNumeros().clone();
            
            Muestra muestraTemp = new Muestra(tamanio, limite);
            muestraTemp.setListaNumeros(listaNumeros);
            
            AlgoritmoInsercion ordenamientoInsercion = new AlgoritmoInsercion(muestraTemp, this);
            proceso = new VentanaProceso("Algoritmo de ordenamiento Inserción", ordenamientoInsercion, tamanio-1);
        }
        else
        {
            throw new Exception("Debe generar una muestra primero.");
        }
    }
    
    /**
     * Obtiene el numero de elementos en un rango dado por el usuario. Determina
     * el tiempo invertido en realizar la busqueda.
     * @param limiteInferior Limite inferior.
     * @param limiteSuperior Limite superior.
     * @throws Exception 
     */
    public void elementosRango(int limiteInferior, int limiteSuperior) throws Exception
    {
        
        if(muestraOrganizada != null)
        {
            @SuppressWarnings("unused")
            long tiempo;
            long t1 = System.currentTimeMillis();
            int cantidad = muestraOrganizada.numerosDentroRango(limiteInferior, limiteSuperior);
            long t2 = System.currentTimeMillis();
            
            tiempo = t2- t1;
            pnlOtrasBusquedas.setNumeroRango(cantidad + "");
            pnlOtrasBusquedas.setTiempoRango((double)tiempo + "ms");
            //mostrarEstadoArreglos();
        }
        else
        {
            throw new Exception("Debe generar una muestra y ordenarla primero.");
        }
    }
    
    /**
     * Obtiene el numero de ocurrencias de un numero entregado por el usuario.
     * @param elementoBuscado Elemento a buscar en la lista.
     * @throws Exception 
     */
    public void numeroDeOcurrencias(int elementoBuscado) throws Exception
    {
        if(muestraOrganizada != null)
        {
            @SuppressWarnings("unused")
            long tiempo;
            long t1 = System.currentTimeMillis();
            int cantidad = muestraOrganizada.numeroOcurrencias(elementoBuscado);
            long t2 = System.currentTimeMillis();
            tiempo = t2 - t1;

            pnlOtrasBusquedas.setNumeroOcurrencias(cantidad + "");
            pnlOtrasBusquedas.setTiempoOcurrencias((double)tiempo + "ms");
            //mostrarEstadoArreglos();
        }
        else
        {
            throw new Exception("Debe generar una muestra y ordenarla primero.");
        }  
    }
    
    /**
     * Obtiene el numero de valores distintos en la muestra Ordenanda de datos.
     * @throws Exception 
     */
    public void numeroDeValoresDistintos() throws Exception
    {
        if(muestraOrganizada != null)
        {
            @SuppressWarnings("unused")
            long tiempo;
            long t1 = System.currentTimeMillis();
            int cantidad = muestraOrganizada.numerosDistintos();
            long t2 = System.currentTimeMillis();
            tiempo = t2 - t1;
            
            pnlOtrasBusquedas.setNumerosDistintos(cantidad + "");
            pnlOtrasBusquedas.setTiempoNumerosDistintos((double)tiempo + "ms");
            //mostrarEstadoArreglos();
        }
        else
        {
            throw new Exception("Debe generar una muestra y ordenarla primero.");
        }
    }
    
    /**
     * Obtiene el valor mas frecuente de la muestra Ordenada de datos.
     * @throws Exception 
     */
    public void valorMasFrecuente() throws Exception
    {
        if(muestraOrganizada != null)
        {
            @SuppressWarnings("unused")
            long tiempo;
            long t1 = System.currentTimeMillis();
            int valor = muestraOrganizada.valorMasFrecuente();
            long t2 = System.currentTimeMillis();
            tiempo = t2 - t1;
            
            pnlOtrasBusquedas.setValorRepetido(valor + "");
            pnlOtrasBusquedas.setTiempoValorFrecuente((double)tiempo + "ms");
            //mostrarEstadoArreglos();
        }
        else
        {
            throw new Exception("Debe generar una muestra y ordenarla primero.");
        }
    }
    
    /**
     * Método para la extensión 1.
     */
    public void opcionUno()
    {
        JOptionPane.showMessageDialog(null, "respuesta1", "Respuesta", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Método para la extensión 2.
     */
    public void opcionDos()
    {
        JOptionPane.showMessageDialog(null, "respuesta2", "Respuesta", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Método para la extensión 3.
     */
    public void opcionTres()
    {
        JOptionPane.showMessageDialog(null, "respuesta3", "Respuesta", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Método para la extensión 4.
     */
    public void opcionCuatro()
    {
        JOptionPane.showMessageDialog(null, "respuesta4", "Respuesta", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Actualiza la musetra ordenada.
     * @param pMuestra Muestra ordenada. pMuestra != null.
     */
    public void actualizarMuestraOrdenada(Muestra pMuestra)
    {
        this.muestraOrganizada = pMuestra;        
    }
    
    /**
     * Permite visualizar la muestra generada y la muestra ordenada.
     */
    public void mostrarEstadoArreglos()
    {
        System.out.println("-----Sin Ordenar");
        for(int i = 0; i < muestra.getTamanio(); i ++)
        {
            System.out.print(muestra.getListaNumeros()[i] + ",");
        }
        System.out.println();
        System.out.println("-----ORDENADA");
        
        if(muestraOrganizada != null)
        {
             for(int i = 0; i < muestraOrganizada.getTamanio(); i ++)
            {
                System.out.print(muestraOrganizada.getListaNumeros()[i] + ",");
            }
        }
        System.out.println();
    }
}
