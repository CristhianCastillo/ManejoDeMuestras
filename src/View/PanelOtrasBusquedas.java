/**
 * 
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

/**
 * Panel Otras búsquedas.
 * @author Cristhian Eduardo Castillo Erazo
 */
public class PanelOtrasBusquedas extends JPanel implements ActionListener
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    /**
     * Comando para ejecutar la busqueda por elementos en un rango.
     */
    public static final String  RANGO = "Elementos en un Rango";
    
    /**
     * Comando para ejecutar la busqueda por Numero de Ocurrencias.
     */
    public static final String OCURRENCIA = "Numero de Ocurrencia";
    
    /**
     * Comando para ejecutar la busqueda por Numero de Valores Distintos.
     */
    public static final String DISTINTOS = "Numero de Valores Distintos";
    
    /**
     * Comando para ejecutar la busqueda por Valor mas Frecuente.
     */
    public static final String FRECUENCIA = "Valor mas Frecuente";
    
    // -------------------------------------------------------------------------
    //  Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Boton Elementos en un Rango.
     */
    private JButton btnRango;
    
    /**
     * Botón Número de Ocurrencias.
     */
    private JButton btnOcurrencia;
    
    /**
     * Botón Número de Valores Distintos.
     */
    private JButton btnDistinto;
    
    /**
     * Botón Valores más Frecuente.
     */
    private JButton btnFrecuente;
    
    /**
     * Campo Elementos en un Rango.
     */
    private JTextField txtRango;
    
    /**
     * Campos Numero de Ocurrencias.
     */
    private JTextField txtOcurrencia;
    
    /**
     * Campo Numero de Valores Distintos.
     */
    private JTextField txtDistinto;
    
    /**
     * Campo Valor mas Frecuente.
     */
    private JTextField txtFrecuente;
    
    /**
     * Campo Elementos en un Rango Tiempo.
     */
    private JTextField txtRangoTiempo;
    
    /**
     * Campo Numero de Ocurrencias Tiempo.
     */
    private JTextField txtOcurrenciaTiempo;
    
    /**
     * Campo Numero de Valores Distintos Tiempo.
     */
    private JTextField txtDistintoTiempo;
    
    /**
     * Campo Valor mas Frecuente Tiempo.
     */
    private JTextField txtFrencuennteTiempo;
    
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye el Panel Otras Busquedas.
     */
    public PanelOtrasBusquedas()
    {
        this.setBorder(new TitledBorder("Otras búsquedas"));
        GroupLayout grupo = new GroupLayout(this);
        
        this.setLayout(grupo);
        
        //Creacion de los elementos del panel.
        btnRango = new JButton("Elementos en un Rango");
        btnRango.setActionCommand(RANGO);
        btnRango.addActionListener(this);
        
        btnOcurrencia = new JButton("Número de Ocurrencias");
        btnOcurrencia.setActionCommand(OCURRENCIA);
        btnOcurrencia.addActionListener(this);
        
        btnDistinto = new JButton("Número de Valores Distintos");
        btnDistinto.setActionCommand(DISTINTOS);
        btnDistinto.addActionListener(this);
        
        btnFrecuente = new JButton("Valor más Frecuente");
        btnFrecuente.setActionCommand(FRECUENCIA);
        btnFrecuente.addActionListener(this);
        
        txtRango = new JTextField();
        txtRango.setEditable(false);
        
        txtOcurrencia = new JTextField();
        txtOcurrencia.setEditable(false);
        
        txtDistinto = new JTextField();
        txtDistinto.setEditable(false);
        
        txtFrecuente = new JTextField();
        txtFrecuente.setEditable(false);
        
        txtRangoTiempo = new JTextField();
        txtRangoTiempo.setEditable(false);
        
        txtOcurrenciaTiempo = new JTextField();
        txtOcurrenciaTiempo.setEditable(false);
        
        txtDistintoTiempo = new JTextField();
        txtDistintoTiempo.setEditable(false);
        
        txtFrencuennteTiempo = new JTextField();
        txtFrencuennteTiempo.setEditable(false);
        
        grupo.setAutoCreateContainerGaps(true);
        grupo.setAutoCreateGaps(true);
        
        //Set Horizontal
        grupo.setHorizontalGroup(
                grupo.createSequentialGroup()
                .addGroup(grupo.createParallelGroup()
                        .addComponent(btnRango)
                        .addComponent(btnOcurrencia)
                        .addComponent(btnDistinto)
                        .addComponent(btnFrecuente)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(txtRango)
                        .addComponent(txtOcurrencia)
                        .addComponent(txtDistinto)
                        .addComponent(txtFrecuente)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(txtRangoTiempo)
                        .addComponent(txtOcurrenciaTiempo)
                        .addComponent(txtDistintoTiempo)
                        .addComponent(txtFrencuennteTiempo)
                )
        
                    
        );
        
        grupo.linkSize(SwingConstants.HORIZONTAL, btnRango, btnOcurrencia, btnDistinto, btnFrecuente);
        
        grupo.setVerticalGroup(
                grupo.createSequentialGroup()
                .addGroup(grupo.createParallelGroup()
                        .addComponent(btnRango)
                        .addComponent(txtRango)
                        .addComponent(txtRangoTiempo)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(btnOcurrencia)
                        .addComponent(txtOcurrencia)
                        .addComponent(txtOcurrenciaTiempo)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(btnDistinto)
                        .addComponent(txtDistinto)
                        .addComponent(txtDistintoTiempo)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(btnFrecuente)
                        .addComponent(txtFrecuente)
                        .addComponent(txtFrencuennteTiempo)
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
