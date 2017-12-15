/**
 * 
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

/**
 * Representa el Panel de Ordenamiento.
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class PanelOrdenamiento extends JPanel implements ActionListener 
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    /**
     * Comando para ejecutar el Algoritmo de Ordenamiento por Selección.
     */
    public static final String SELECCION ="Seleccion";
    
    /**
     * Comando para ejecutar el Algoritmo de Ordenamiento por Burbuja.
     */
    public static final String BURBUJA = "Burbuja";
    
    /**
     * Comando par ejecutar el Algoritmo de Ordemaniento por Inserción.
     */
    public static final String INSERCION = "Insercion";
    
    
    // -------------------------------------------------------------------------
    //  Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Etiqueta Algortimo.
     */
    private JLabel lblAlgoritmo;
    
    /**
     * Etiqueta Tiempo.
     */
    private JLabel lblTiempo;
    
    /**
     * Boton Selección.
     */
    private JButton btnSeleccion;
    
    /**
     * Botón Burbuja.
     */
    private JButton btnBurbuja;
    
    /**
     * Botón Inserción.
     */
    private JButton btnInsercion;
    
    /**
     * Campo de texto Selección.
     */
    private JTextField txtSeleccion;
    
    /**
     * Campo de texto Burbuja.
     */
    private JTextField txtBurbuja;
    
    /**
     * Campo de texto Inserción.
     */
    private JTextField txtInsercion;
    
    // -------------------------------------------------------------------------
    //  Cosntructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye el Panel Ordenamiento.
     */
    public PanelOrdenamiento()
    {
        this.setBorder(new TitledBorder("Ordenamiento"));
        GroupLayout grupo = new GroupLayout(this);
        this.setLayout(grupo);
        

        lblAlgoritmo = new JLabel("Algoritmo");

        lblTiempo = new JLabel("Tiempo");
        
        btnSeleccion = new JButton("Selección");
        btnSeleccion.setActionCommand(SELECCION);
        btnSeleccion.addActionListener(this);
        
        btnBurbuja = new JButton("Burbuja");
        btnBurbuja.setActionCommand(BURBUJA);
        btnBurbuja.addActionListener(this);
        
        btnInsercion = new JButton("Inserción");
        btnInsercion.setActionCommand(INSERCION);
        btnInsercion.addActionListener(this);
        
        txtSeleccion = new JTextField("0ms");
        txtSeleccion.setEditable(false);
        txtSeleccion.setBorder(null);
        txtSeleccion.setHorizontalAlignment(SwingConstants.CENTER);
        
        txtBurbuja = new JTextField("0ms");
        txtBurbuja.setEditable(false);
        txtBurbuja.setBorder(null);
        txtBurbuja.setHorizontalAlignment(SwingConstants.CENTER);
        
        txtInsercion = new JTextField("0000000000000ms");
        txtInsercion.setEditable(false);
        txtInsercion.setBorder(null);
        txtInsercion.setHorizontalAlignment(SwingConstants.CENTER);
        
        //Crear espacio entre los componentes
        grupo.setAutoCreateGaps(true);
        
        //Crear espacio entre componentes contenedor
        grupo.setAutoCreateContainerGaps(true);
        
        // Set Horizontal
        grupo.setHorizontalGroup(
                grupo.createSequentialGroup()
                .addGroup(grupo.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(lblAlgoritmo)
                        .addComponent(btnSeleccion)
                        .addComponent(btnBurbuja)
                        .addComponent(btnInsercion)
                )
                
                .addGroup(grupo.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(lblTiempo)
                        .addComponent(txtSeleccion)
                        .addComponent(txtBurbuja)
                        .addComponent(txtInsercion)
                )
        );
        
        grupo.linkSize(SwingConstants.HORIZONTAL, btnSeleccion, btnBurbuja, btnInsercion);
        
        // Set Vertical
        grupo.setVerticalGroup(
                grupo.createSequentialGroup()
                .addGroup(grupo.createParallelGroup()
                        .addComponent(lblAlgoritmo)
                        .addComponent(lblTiempo)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(btnSeleccion)
                        .addComponent(txtSeleccion)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(btnBurbuja)
                        .addComponent(txtBurbuja)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(btnInsercion)
                        .addComponent(txtInsercion)
                )
        );
        
        
    }
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
    }
    
}
