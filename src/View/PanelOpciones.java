/**
 * 
 */
package View;

import Controller.Controlador;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Clase que repesenta el Panel Opciones de extensión.
 * @author Cristhin Eduardo Castillo Erazo.
 */
public class PanelOpciones extends JPanel implements ActionListener
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    /**
     * Comando Opcion Uno.
     */
    public static final String OPCION_UNO = "OpcionUno";
    
    /**
     * Comando Ocpion Dos.
     */
    public static final String OPCION_DOS = "OpcionDos";
    
    /**
     * Comando Opcion Tres.
     */
    public static final String OPCION_TRES = "OpcionTres";
    
    /**
     * Comando Opcion Cuatro.
     */
    public static final String OPCION_CUATRO = "OpcionCuatro";
    
    // -------------------------------------------------------------------------
    //  Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Boton Opcion Uno.
     */
    private final JButton btnOpcionUno;
    
    /**
     * Boton Opcion Dos.
     */
    private final JButton btnOpcionDos;
    
    /**
     * Boton Opcion Tres.
     */
    private final JButton btnOpcionTres;
    
    /**
     * Boton Opcion Cuatro.
     */
    private final JButton btnOpcionCuatro;
    
    /**
     * Controlador principal de la aplicación.
     */
    private final Controlador ctrl;
    
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye el panel Opciones.
     * @param ctrl Controlador principal de la aplicación.
     */
    public PanelOpciones(Controlador ctrl)
    {
        this.ctrl = ctrl;
        this.setBorder(new TitledBorder("Opciones"));
        this.setLayout(new GridLayout(1,4));
        
        btnOpcionUno = new JButton("Opción 1");
        btnOpcionUno.setActionCommand(OPCION_UNO);
        btnOpcionUno.addActionListener((ActionListener)this);
        
        btnOpcionDos = new JButton("Opción 2");
        btnOpcionDos.setActionCommand(OPCION_DOS);
        btnOpcionDos.addActionListener((ActionListener)this);
        
        btnOpcionTres = new JButton("Opción 3");
        btnOpcionTres.setActionCommand(OPCION_TRES);
        btnOpcionTres.addActionListener((ActionListener)this);
        
        btnOpcionCuatro = new JButton("Opción 4");
        btnOpcionCuatro.setActionCommand(OPCION_CUATRO);
        btnOpcionCuatro.addActionListener((ActionListener)this);
        
        this.add(btnOpcionUno);
        this.add(btnOpcionDos);
        this.add(btnOpcionTres);
        this.add(btnOpcionCuatro);
    }
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
    
    /**
     * Escucha los eventos generados por los botónes.
     * @param e Acción que genero el evento. e != null.
     */
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String comando = e.getActionCommand();
        
        if(comando.equalsIgnoreCase(OPCION_UNO))
        {
            ctrl.opcionUno();
        }
        else
        {
            if(comando.equalsIgnoreCase(OPCION_DOS))
            {
                ctrl.opcionDos();
            }
            else
            {
                if(comando.equalsIgnoreCase(OPCION_TRES))
                {
                    ctrl.opcionTres();
                }
                else
                {
                    if(comando.equalsIgnoreCase(OPCION_CUATRO))
                    {
                        ctrl.opcionCuatro();
                    }
                }
            }
        }
    }
    
}
