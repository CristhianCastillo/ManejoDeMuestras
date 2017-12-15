/**
 * 
 */
package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class PanelBusqueda extends JPanel implements ActionListener
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    /**
     * Constante utilizada para modificar el comando eviado del boton Secuencia.
     */
    public static final String SECUENCIA = "Secuencia";
    
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
    private JLabel lblAlgoritmo;
    
    /**
     * Etiqueta Tiempo Promedio.
     */
    private JLabel lblTiempoPromedio;
    
    /**
     * Botón Secuencia.
     */
    private JButton btnSecuencia;
    
    /**
     * Boton Binaria.
     */
    private JButton btnBinaria;
    
    /**
     * Campo de texto para el tiempo promedio al ejecutar el algoritmo Secuencial.
     */
    private JTextField txtSecuencia;
    
    /**
     * Campo de texto paral el tiempo promedio al ejecutar el algoritmo Binario.
     */
    private JTextField txtBinaria;
    
    
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye el panel de Busqueda.
     */
    public PanelBusqueda()
    {
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
        btnSecuencia.setActionCommand(SECUENCIA);
        btnSecuencia.addActionListener(this);
       
        btnBinaria = new JButton("Binaria");
        btnBinaria.setActionCommand(BINARIA);
        btnBinaria.addActionListener(this);
        
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
    }
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
    }
}
