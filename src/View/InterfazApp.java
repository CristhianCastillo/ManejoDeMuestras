/**
 * 
 */
package View;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Cristhian Eduardo Castillo Erazo.
 */
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
    private PanelTitulo pnlTitulo;
    
    /**
     * Panel Datos de la muestra.
     */
    private PanelMuestra pnlMuestra;
    
    /**
     * Panel Busqueda.
     */
    private PanelBusqueda pnlPanelbusqueda;
    
    /**
     * Panel Ordenamiento.
     */
    private PanelOrdenamiento pnlOrdenamiento;
    
    /**
     * Panel Otras Busquedas.
     */
    private PanelOtrasBusquedas pnlOtrasBusquedas;
    
    /**
     * Panel Opciones.
     */
    private PanelOpciones pnlOpciones;
    
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye la ventana principal de la aplicación.
     */
    public InterfazApp()
    {
        this.setTitle("Manejo de muestras");
        this.setLayout(new BorderLayout());
        
        
        pnlTitulo = new PanelTitulo();
        
        JPanel pnlCentro = new JPanel();
        pnlCentro.setLayout(new BorderLayout());
        
        pnlMuestra = new PanelMuestra();
        pnlPanelbusqueda = new PanelBusqueda();
        pnlOrdenamiento = new PanelOrdenamiento();
        pnlOtrasBusquedas = new PanelOtrasBusquedas();
        
        pnlCentro.add(pnlMuestra, BorderLayout.NORTH);
        pnlCentro.add(pnlPanelbusqueda, BorderLayout.WEST);
        pnlCentro.add(pnlOrdenamiento, BorderLayout.CENTER);
        pnlCentro.add(pnlOtrasBusquedas, BorderLayout.SOUTH);
        
        pnlOpciones = new PanelOpciones();
        
        this.add(pnlTitulo, BorderLayout.NORTH);
        this.add(pnlCentro, BorderLayout.CENTER);
        this.add(pnlOpciones, BorderLayout.SOUTH);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(530,644);
        this.setLocationRelativeTo(null);
    }
    
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
    
    public static void main(String [] arg0s)
    {
        InterfazApp interfaz = new InterfazApp();
        interfaz.setVisible(true);
    }
    
}
