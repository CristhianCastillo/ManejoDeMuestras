/**
 * 
 */
package View;

import Controller.Controlador;
import java.awt.BorderLayout;
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
 *
 * @author Cristhian Eduardo Castillo Erazo.
 */
@SuppressWarnings("all")
public class PanelBusqueda extends JPanel implements ActionListener
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    /**
     * Constante utilizada para modificar el comando eviado del boton Secuencia.
     */
    public static final String SECUENCIAL = "Secuencial";
    
    /**
     * Constante utilizada para modificar el coamndo enviado del botón Binaria.
     */
    public static final String BINARIA  = "Binaria";
    
    // -------------------------------------------------------------------------
    //  Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Etiqueta Algoritmo.
     */
    private final JLabel lblAlgoritmo;
    
    /**
     * Etiqueta Tiempo Promedio.
     */
    private final JLabel lblTiempoPromedio;
    
    /**
     * Botón Secuencia.
     */
    private final JButton btnSecuencia;
    
    /**
     * Boton Binaria.
     */
    private final JButton btnBinaria;
    
    /**
     * Campo de texto para el tiempo promedio al ejecutar el algoritmo Secuencial.
     */
    private final JTextField txtSecuencia;
    
    /**
     * Campo de texto paral el tiempo promedio al ejecutar el algoritmo Binario.
     */
    private final JTextField txtBinaria;
    
    /**
     * Controlador principal de la aplicación.
     */
    private final Controlador ctrl;
    
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye el panel de Busqueda.
     * @param ctrl Controlador principal de la aplicación.
     */
    public PanelBusqueda(Controlador ctrl)
    {
        this.ctrl = ctrl;
        this.setBorder(new TitledBorder("Búsqueda"));
        JPanel pnlTemporal = new JPanel();
        GroupLayout grupo = new GroupLayout(pnlTemporal);
        
        
        pnlTemporal.setLayout(grupo);
        
        this.setLayout(new BorderLayout());
        this.add(pnlTemporal, BorderLayout.NORTH);
        
        //Creación de los componentes.
        lblAlgoritmo = new JLabel("Algoritmo");
        lblTiempoPromedio = new JLabel("Tiempo Promedio");
        
        btnSecuencia = new JButton("Secuencia");
        btnSecuencia.setActionCommand(SECUENCIAL);
        btnSecuencia.addActionListener((ActionListener)this);
       
        btnBinaria = new JButton("Binaria");
        btnBinaria.setActionCommand(BINARIA);
        btnBinaria.addActionListener((ActionListener)this);
        
        txtSecuencia = new JTextField("0.0ms");
        txtSecuencia.setEditable(false);
        txtSecuencia.setBorder(null);
        txtSecuencia.setHorizontalAlignment(SwingConstants.CENTER);
        
        txtBinaria = new JTextField("0.0ms");
        txtBinaria.setEditable(false);
        txtBinaria.setBorder(null);
        txtBinaria.setHorizontalAlignment(SwingConstants.CENTER);
        

        
        //Crear espacio entre los componentes
        grupo.setAutoCreateGaps(true);
        
        //Crear espacio entre componentes contenedor
        grupo.setAutoCreateContainerGaps(true);
        
        //Set Horizontal
        grupo.setHorizontalGroup(
                grupo.createSequentialGroup()
                    .addGroup(grupo.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addComponent(lblAlgoritmo)
                            .addComponent(btnSecuencia)
                            .addComponent(btnBinaria)

                    )
                
                .addGroup(grupo.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(lblTiempoPromedio)
                        .addComponent(txtSecuencia)
                        .addComponent(txtBinaria)

                )
        );
        
        grupo.linkSize(SwingConstants.HORIZONTAL, btnSecuencia, btnBinaria);
        //Set Vertical
        grupo.setVerticalGroup(
                grupo.createSequentialGroup()
                .addGroup(grupo.createParallelGroup()
                        .addComponent(lblAlgoritmo)
                        .addComponent(lblTiempoPromedio)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(btnSecuencia)
                        .addComponent(txtSecuencia)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(btnBinaria)
                        .addComponent(txtBinaria)
                )

        );
        
        reiniciarTiempos();
    }
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
    
    /**
     * Reiniciar tableros.
     */
    public void reiniciarTiempos()
    {
        this.txtSecuencia.setText("N/A");
        this.txtBinaria.setText("N/A");
    }
    
    /**
     * Manejo de los eventos de los botones.
     * @param e Acción que genero el evento. e != null.
     */
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String comando = e.getActionCommand();
        
        if(comando.equalsIgnoreCase(SECUENCIAL))
        {
           try
            {
                ctrl.busquedaSecuancial();
            }
            catch (Exception x)
            {
               JOptionPane.showMessageDialog(this, x.getMessage(), "Búsqueda Secuencial", JOptionPane.ERROR_MESSAGE);
            }

        }
        
        if(comando.equalsIgnoreCase(BINARIA))
        {
            try
            {
                ctrl.busquedaBinaria();
            }
            catch(Exception x)
            {
                JOptionPane.showMessageDialog(this, x.getMessage(), "Búsqueda Binaria", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /**
     * Actualiza en el campo Tiempo Secuencial, el tiempo invertido por el
     * algoritmo.
     * @param tiempo Tiempo invertido. tiempo >=0.
     */
    public void setTiempoSecuencial(String tiempo)
    {
        this.txtSecuencia.setText(tiempo);
    }
    
    /**
     * Actualiza el campo Tiempo Binaria, el tiempo invertido por el
     * algoritmo.
     * @param tiempo Tiempo invertido. tiempo >=0. 
     */
    public void setTiempoBinaria(String tiempo)
    {
        this.txtBinaria.setText(tiempo);
    }
}
