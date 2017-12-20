/**
 * 
 */
package View;

import Controller.Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    private final JLabel lblTamanio;
    
    /**
     * Muestra la etiqueta Límite.
     */
    private final JLabel lblLimite;
    
    /**
     * Muestra la etiqueta Promedio.
     */
    private final JLabel lblPromedio;
    
    /**
     * Muestra la etiqueta Mínimo.
     */
    private final JLabel lblMinimo;
    
    /**
     * Muestra la etiqueta Máximo.
     */
    private final JLabel lblMaximo;
    
    /**
     * Muestra el campo de texto Tamaño.
     */
    private final JTextField txtTamanio;
    
    /**
     * Muestra el campo de texto Limite.
     */
    private final JTextField txtLimite;
    
    /**
     * Muestra el campo de texto Promedio.
     */
    private final JTextField txtPromedio;
    
    /**
     * Muestra el campo de texto Minimo.
     */
    private final JTextField txtMinimo;
    
    /**
     * Muestra el campo de texto Maximo.
     */
    private final JTextField txtMaximo;
    
    /**
     * Muestra el boton Nueva Muestra.
     */
    private final JButton btnNuevaMuestra;
    
    /**
     * Controlador principal de la aplicación.
     */
    private final Controlador ctrl;
    
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye el Panel Datos de la muestra.
     * @param ctrl Controlador principal de la aplicación.
     */
    public PanelMuestra(Controlador ctrl)
    {
        this.ctrl = ctrl;
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
        btnNuevaMuestra.addActionListener((ActionListener)this);
        
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
    

    /**
     * Escucha los eventos de los botones.
     * @param e Acción que generó el evento. e != null.
     */
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String comando = e.getActionCommand();
        
        if(comando.equalsIgnoreCase(NUEVA_MUESTRA))
        {
            try
            {
                String numeroElementos  = JOptionPane.showInputDialog(this,"Ingrese el número de elementos de la muestra", "Número de elementos", JOptionPane.INFORMATION_MESSAGE);
                String limite = JOptionPane.showInputDialog(this, "Ingrese el límite superior para los valores de la muestra", "Límite Superior", JOptionPane.INFORMATION_MESSAGE);
                int numeroElementosReales = Integer.parseInt(numeroElementos);
                int limiteReal = Integer.parseInt(limite);
                ctrl.generarNuevaMuestra(numeroElementosReales, limiteReal);
            }
            catch(Exception x)
            {
               JOptionPane.showMessageDialog(this, "La información no fue proporcionada de manera correcta." + x.getMessage(), "Nueva Muestra", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /**
     * Actualiza el campo Tamaño de la muestra.
     * @param tamanio Nuevo tamaño de la muestra generada.
     */
    public void setTamanio(String tamanio)
    {
        this.txtTamanio.setText(tamanio);
    }
    
    /**
     * Actualiza el campo Limite de la muestra.
     * @param limite Limite de la muetra generada.
     */
    public void setLimite (String limite)
    {
        this.txtLimite.setText(limite);
    }
    
    /**
     * Actualiza el campo Promedio de la muetsra.
     * @param promedio Promedio de la muestra.
     */
    public void setPromedio(String promedio)
    {
        this.txtPromedio.setText(promedio);
    }
    
    /**
     * Actualiza el campo Minimo de la muestra.
     * @param minimo Numero menor de la muestra.
     */
    public void setMinimo(String minimo)
    {
        this.txtMinimo.setText(minimo);
    }
    
    /**
     * Actualiza el campo Maximo de la muestra.
     * @param maximo Numero maximo de la muestra.
     */
    public void setMaximo(String maximo)
    {
        this.txtMaximo.setText(maximo);
    }
}
