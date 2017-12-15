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
import javax.swing.border.TitledBorder;

/**
 * Panel permite visualizar los parametros de la muestra.
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class PanelMuestra extends JPanel implements ActionListener 
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    /**
     * Constante usada para modificar el comando del boton Nueva Muestra.
     */
    public static final String NUEVA_MUESTRA = "NuevaMuestra";
    
    // -------------------------------------------------------------------------
    //  Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Muestra la etiqueta Tamaño.
     */
    private JLabel lblTamanio;
    
    /**
     * Muestra la etiqueta Límite.
     */
    private JLabel lblLimite;
    
    /**
     * Muestra la etiqueta Promedio.
     */
    private JLabel lblPromedio;
    
    /**
     * Muestra la etiqueta Mínimo.
     */
    private JLabel lblMinimo;
    
    /**
     * Muestra la etiqueta Máximo.
     */
    private JLabel lblMaximo;
    
    /**
     * Muestra el campo de texto Tamaño.
     */
    private JTextField txtTamanio;
    
    /**
     * Muestra el campo de texto Limite.
     */
    private JTextField txtLimite;
    
    /**
     * Muestra el campo de texto Promedio.
     */
    private JTextField txtPromedio;
    
    /**
     * Muestra el campo de texto Minimo.
     */
    private JTextField txtMinimo;
    
    /**
     * Muestra el campo de texto Maximo.
     */
    private JTextField txtMaximo;
    
    /**
     * Muestra el boton Nueva Muestra.
     */
    private JButton btnNuevaMuestra;
    
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye el Panel Datos de la muestra.
     */
    public PanelMuestra()
    {
        this.setBorder(new TitledBorder("Datos de la muestra"));
        GroupLayout grupo = new GroupLayout(this);
        this.setLayout(grupo);
        
        //Creación de los componentes.
        
        lblTamanio = new JLabel("Tamaño");
        lblLimite = new JLabel("Límite");
        lblPromedio = new JLabel("Promedio");
        lblMinimo = new JLabel("Mínimo");
        lblMaximo = new JLabel("Máximo");
        
        txtTamanio = new JTextField(20);
        txtTamanio.setEditable(false);
        
        txtLimite = new JTextField();
        txtLimite.setEditable(false);
        
        txtPromedio = new JTextField();
        txtPromedio.setEditable(false);
        
        txtMinimo = new JTextField(20);
        txtMinimo.setEditable(false);
        
        txtMaximo = new JTextField();
        txtMaximo.setEditable(false);

        btnNuevaMuestra = new JButton("Nueva Muestra");
        btnNuevaMuestra.setActionCommand(NUEVA_MUESTRA);
        btnNuevaMuestra.addActionListener(this);
        
        //Crear espacio entre los componentes
        grupo.setAutoCreateGaps(true);
        
        //Crear espacio entre componentes contenedor
        grupo.setAutoCreateContainerGaps(true);
        
        //Set Group Horizontal
        grupo.setHorizontalGroup
        (grupo.createSequentialGroup()
                .addGroup(grupo.createParallelGroup()
                    .addComponent(lblTamanio)
                    .addComponent(lblLimite)
                    .addComponent(lblPromedio)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(txtTamanio)
                        .addComponent(txtLimite)
                        .addComponent(txtPromedio)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(lblMinimo)
                        .addComponent(lblMaximo)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(txtMinimo)
                        .addComponent(txtMaximo)
                        .addComponent(btnNuevaMuestra, GroupLayout.Alignment.CENTER)
                )
           
        );
        
        //Set Group Vertical
        grupo.setVerticalGroup(
                grupo.createSequentialGroup()
                .addGroup(grupo.createParallelGroup()
                        .addComponent(lblTamanio)
                        .addComponent(txtTamanio)
                        .addComponent(lblMinimo)
                        .addComponent(txtMinimo)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(lblLimite)
                        .addComponent(txtLimite)
                        .addComponent(lblMaximo)
                        .addComponent(txtMaximo)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(lblPromedio)
                        .addComponent(txtPromedio)
                        .addComponent(btnNuevaMuestra, GroupLayout.Alignment.CENTER)
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
