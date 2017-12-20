/**
 * 
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

/**
 * Clase que representa el dialogo de un Sub proceso
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class VentanaProceso extends JDialog implements ActionListener
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    /**
     * Comando para el boton Cerrar.
     */
    public static final String CERRAR = "Cerrar";
    
    // -------------------------------------------------------------------------
    //  Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Proceso ejecutado.
     */
    private Thread actividad;
    
    /**
     * Etiqueta Proceso.
     */
    private final JLabel lblProceso;
    
    /**
     * Boton Cerrar.
     */
    private final JButton btnCerrar;
    
    /**
     * Barra de progreso.
     */
    private final JProgressBar barraProgreso; 
    
    /**
     * Tamaño de la muestra.
     */
    private final int tamanio;
    
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Contruye el Dialogo que muestra el estado actual del Sub Proceso ejecutado.
     * @param titulo Titulo del proceso. titulo != null && "".
     * @param actividad Activada a ejecutar en el sub proceso. actividad != null.
     * @param tamanio Tamaño de la muestra. tamaño > 0.
     */
    public VentanaProceso(String titulo, Thread actividad, int tamanio)
    {
        this.actividad = actividad;
        this.tamanio = tamanio;
        this.setTitle(titulo);
        
        GroupLayout grupo = new GroupLayout(getContentPane());
        this.setLayout(grupo);
        
        lblProceso = new JLabel("Proceso Iniciado....");
        
        barraProgreso = new JProgressBar(0, this.tamanio);
        barraProgreso.setStringPainted(true);
        
        btnCerrar = new JButton("Cerrar");
        btnCerrar.setActionCommand(CERRAR);
        btnCerrar.addActionListener((ActionListener)this);
        btnCerrar.setHorizontalAlignment(SwingConstants.RIGHT);
        btnCerrar.setEnabled(false);
        
        grupo.setAutoCreateContainerGaps(true);
        grupo.setAutoCreateGaps(true);
        
        // --------------------------------------
        //  Horizontal
        // --------------------------------------
        
        grupo.setHorizontalGroup(
                grupo.createSequentialGroup()
                    .addGroup(grupo.createParallelGroup()
                            .addComponent(lblProceso)
                            .addComponent(barraProgreso)
                            .addComponent(btnCerrar, GroupLayout.Alignment.TRAILING)
                    )
                    
                    
        );
        
        // --------------------------------------
        //  Vertical
        // --------------------------------------
        
        grupo.setVerticalGroup(
                grupo.createSequentialGroup()
                    .addGroup(grupo.createParallelGroup()
                            .addComponent(lblProceso)
                    )
                
                    .addGroup(grupo.createParallelGroup()
                            .addComponent(barraProgreso)
                    )
                
                    .addGroup(grupo.createParallelGroup()
                            .addComponent(btnCerrar)
                    )
        );
        
        
        this.setSize(300,130);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        this.actividad.start();
        
    }
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
    
    /**
     * Actualiza el estado actual del proceso.
     * @param actual Valor del Sub proceso.
     */
    public void actualizarProgreso(int actual)
    {
        barraProgreso.setValue(actual);
        if(tamanio == actual)
        {
            lblProceso.setText("Proceso finalizado!");
            btnCerrar.setEnabled(true);
            
        }
    }
    
    /**
     * Escucha los eventos de los botones.
     * @param e Accion que genero el evento. e != null.
     */
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String comando = e.getActionCommand();
        
        if(comando.equalsIgnoreCase(CERRAR))
        {
            actividad = null;
            this.dispose();
        }
    }
    
    
}
