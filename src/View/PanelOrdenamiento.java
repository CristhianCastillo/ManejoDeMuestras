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
    private final JLabel lblAlgoritmo;
    
    /**
     * Etiqueta Tiempo.
     */
    private final JLabel lblTiempo;
    
    /**
     * Boton Selección.
     */
    private final JButton btnSeleccion;
    
    /**
     * Botón Burbuja.
     */
    private final JButton btnBurbuja;
    
    /**
     * Botón Inserción.
     */
    private final JButton btnInsercion;
    
    /**
     * Campo de texto Selección.
     */
    private final JTextField txtSeleccion;
    
    /**
     * Campo de texto Burbuja.
     */
    private final JTextField txtBurbuja;
    
    /**
     * Campo de texto Inserción.
     */
    private final JTextField txtInsercion;
    
    /**
     * Contrlador principal de la aplicación.
     */
    private final Controlador ctrl;
    
    // -------------------------------------------------------------------------
    //  Cosntructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye el Panel Ordenamiento.
     * @param ctrl Controlador principal de la aplicación.
     */
    public PanelOrdenamiento(Controlador ctrl)
    {
        this.ctrl = ctrl;
        this.setBorder(new TitledBorder("Ordenamiento"));
        GroupLayout grupo = new GroupLayout(this);
        this.setLayout(grupo);
        

        lblAlgoritmo = new JLabel("Algoritmo");

        lblTiempo = new JLabel("Tiempo");
        
        btnSeleccion = new JButton("Selección");
        btnSeleccion.setActionCommand(SELECCION);
        btnSeleccion.addActionListener((ActionListener)this);
        
        btnBurbuja = new JButton("Burbuja");
        btnBurbuja.setActionCommand(BURBUJA);
        btnBurbuja.addActionListener((ActionListener)this);
        
        btnInsercion = new JButton("Inserción");
        btnInsercion.setActionCommand(INSERCION);
        btnInsercion.addActionListener((ActionListener)this);
        
        txtSeleccion = new JTextField("0ms");
        txtSeleccion.setEditable(false);
        txtSeleccion.setBorder(null);
        txtSeleccion.setHorizontalAlignment(SwingConstants.CENTER);
        
        txtBurbuja = new JTextField("0ms");
        txtBurbuja.setEditable(false);
        txtBurbuja.setBorder(null);
        txtBurbuja.setHorizontalAlignment(SwingConstants.CENTER);
        
        txtInsercion = new JTextField("0ms");
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
        
        reiniciarTiempos();
    }
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
    
    /**
     * Reinicia los tableros.
     */
    public void reiniciarTiempos()
    {
        this.txtInsercion.setText("N/A");
        this.txtBurbuja.setText("N/A");
        this.txtSeleccion.setText("N/A");
    }
    
    /**
     * Escucha los eventos de los botónes.
     * @param e Acción que genero el evento. e != null.
     */
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String comando = e.getActionCommand();
        
        if(comando.equalsIgnoreCase(BURBUJA))
        {
            try
            {
                ctrl.ordenamientoBurbuja();
            }
            catch(Exception x)
            {
                JOptionPane.showMessageDialog(this, x.getMessage(), "Algoritmo Burbuja", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        else
        {
            if(comando.equalsIgnoreCase(SELECCION))
            {
                try{
                    ctrl.ordenamientoSeleccion();
                }
                catch(Exception x){
                    JOptionPane.showMessageDialog(this, x.getMessage(), "Algoritmo Selección", JOptionPane.ERROR_MESSAGE);
                }
                
            }
            else
            {
                if(comando.equalsIgnoreCase(INSERCION))
                {
                    try
                    {
                        ctrl.ordenamientoInsercion();
                    }
                    catch(Exception x)
                    {
                        JOptionPane.showMessageDialog(this, x.getMessage(), "Algoritmo Inserción", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        
        
    }
    
    /**
     * Actualiza el campo Tiempo Burbuja.
     * @param tiempo Tiempo invertido por el algoritmo.
     */
    public void setTiempoBurbuja(String tiempo)
    {
        this.txtBurbuja.setText(tiempo);
    }
    
    /**
     * Actualiza el campo Tiempo Selección.
     * @param tiempo Tiempo invertido por el algoritmo.
     */
    public void setTiempoSeleccion(String tiempo)
    {
        this.txtSeleccion.setText(tiempo);
    }
    
    /**
     * Actualiza el campo Tiempo Inserción.
     * @param tiempo Tiempo invertido por el algoritmo.
     */
    public void setTiempoInsercion(String tiempo)
    {
        this.txtInsercion.setText(tiempo);
    }
    
}
