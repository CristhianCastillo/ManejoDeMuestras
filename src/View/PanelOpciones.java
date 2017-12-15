/**
 * 
 */
package View;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
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
    private JButton btnOpcionUno;
    
    /**
     * Boton Opcion Dos.
     */
    private JButton btnOpcionDos;
    
    /**
     * Boton Opcion Tres.
     */
    private JButton btnOpcionTres;
    
    /**
     * Boton Opcion Cuatro.
     */
    private JButton btnOpcionCuatro;
    
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye el panel Opciones.
     */
    public PanelOpciones()
    {
        this.setBorder(new TitledBorder("Opciones"));
        this.setLayout(new GridLayout(1,4));
        
        btnOpcionUno = new JButton("Opción 1");
        btnOpcionUno.setActionCommand(OPCION_UNO);
        btnOpcionUno.addActionListener(this);
        
        btnOpcionDos = new JButton("Opción 2");
        btnOpcionDos.setActionCommand(OPCION_DOS);
        btnOpcionDos.addActionListener(this);
        
        btnOpcionTres = new JButton("Opción 3");
        btnOpcionTres.setActionCommand(OPCION_TRES);
        btnOpcionTres.addActionListener(this);
        
        btnOpcionCuatro = new JButton("Opción 4");
        btnOpcionCuatro.setActionCommand(OPCION_CUATRO);
        btnOpcionCuatro.addActionListener(this);
        
        this.add(btnOpcionUno);
        this.add(btnOpcionDos);
        this.add(btnOpcionTres);
        this.add(btnOpcionCuatro);
    }
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
    }
    
}
