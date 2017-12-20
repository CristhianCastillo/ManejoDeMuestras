/**
 * 
 */
package View;

import Controller.Controlador;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Clase que representa la interfaz principal de la aplicación.
 * @author Cristhian Eduardo Castillo Erazo.
 */
@SuppressWarnings({"serial", "all"})
public class InterfazApp extends JFrame
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    //  Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Panel Titulo (Imagen Decorativa)
     */
    private final PanelTitulo pnlTitulo;
    
    /**
     * Panel Datos de la muestra.
     */
    private final PanelMuestra pnlMuestra;
    
    /**
     * Panel Busqueda.
     */
    private final PanelBusqueda pnlPanelbusqueda;
    
    /**
     * Panel Ordenamiento.
     */
    private final PanelOrdenamiento pnlOrdenamiento;
    
    /**
     * Panel Otras Busquedas.
     */
    private final PanelOtrasBusquedas pnlOtrasBusquedas;
    
    /**
     * Panel Opciones.
     */
    private final PanelOpciones pnlOpciones;
    
    /**
     * Controlador de la aplicación principal.
     */
    private final Controlador ctrl;
    
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye la ventana principal de la aplicación.
     */

    public InterfazApp()
    {
        ctrl = new Controlador();
        this.setTitle("Manejo de muestras");
        this.setLayout(new BorderLayout());
        
        
        pnlTitulo = new PanelTitulo();
        
        JPanel pnlCentro = new JPanel();
        pnlCentro.setLayout(new BorderLayout());
        
        pnlMuestra = new PanelMuestra(ctrl);
        pnlPanelbusqueda = new PanelBusqueda(ctrl);
        pnlOrdenamiento = new PanelOrdenamiento(ctrl);
        pnlOtrasBusquedas = new PanelOtrasBusquedas(ctrl);
        
        pnlCentro.add(pnlMuestra, BorderLayout.NORTH);
        pnlCentro.add(pnlPanelbusqueda, BorderLayout.WEST);
        pnlCentro.add(pnlOrdenamiento, BorderLayout.CENTER);
        pnlCentro.add(pnlOtrasBusquedas, BorderLayout.SOUTH);
        
        pnlOpciones = new PanelOpciones(ctrl);
        
        this.add(pnlTitulo, BorderLayout.NORTH);
        this.add(pnlCentro, BorderLayout.CENTER);
        this.add(pnlOpciones, BorderLayout.SOUTH);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(530,644);
        this.setLocationRelativeTo(null);
        
        ctrl.conectar(pnlMuestra, pnlPanelbusqueda, pnlOrdenamiento, pnlOtrasBusquedas);
    }
    
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
    
    /**
     * Metodo principal de la aplicación.
     * @param arg0s No son necesarios.
     */
    public static void main(String [] arg0s)
    {
        InterfazApp interfaz = new InterfazApp();
        interfaz.setVisible(true);
    }
    
}
