/**
 * 
 */
package View;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Panel que representa el titulo decorativo de la aplicación.
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class PanelTitulo extends JPanel
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    //  Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Etiqueta que contendra la imagen decorativa.
     */
    private final JLabel imagen;
    
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye el panel con la imagen decorativa.
     */
    public PanelTitulo()
    {
        FlowLayout layout = new FlowLayout();
        layout.setHgap(0);
        layout.setVgap(0);
        
        this.setLayout(layout);
        imagen = new JLabel(" ");
        ImageIcon icono = new ImageIcon("data/titulo.jpg");
        imagen.setIcon(icono);        
        add(imagen);
        
        this.setBackground(Color.WHITE);
        this.setBorder(new LineBorder(java.awt.Color.GRAY));
    }
    
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
    
}
