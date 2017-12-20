/**
 * 
 */
package View;

import Controller.Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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
    private final JButton btnRango;
    
    /**
     * Botón Número de Ocurrencias.
     */
    private final JButton btnOcurrencia;
    
    /**
     * Botón Número de Valores Distintos.
     */
    private final JButton btnDistinto;
    
    /**
     * Botón Valores más Frecuente.
     */
    private final JButton btnFrecuente;
    
    /**
     * Campo Elementos en un Rango.
     */
    private final JTextField txtRango;
    
    /**
     * Campos Numero de Ocurrencias.
     */
    private final JTextField txtOcurrencia;
    
    /**
     * Campo Numero de Valores Distintos.
     */
    private final JTextField txtDistinto;
    
    /**
     * Campo Valor mas Frecuente.
     */
    private final JTextField txtFrecuente;
    
    /**
     * Campo Elementos en un Rango Tiempo.
     */
    private final JTextField txtRangoTiempo;
    
    /**
     * Campo Numero de Ocurrencias Tiempo.
     */
    private final JTextField txtOcurrenciaTiempo;
    
    /**
     * Campo Numero de Valores Distintos Tiempo.
     */
    private final JTextField txtDistintoTiempo;
    
    /**
     * Campo Valor mas Frecuente Tiempo.
     */
    private final JTextField txtFrencuennteTiempo;
    
    /**
     * Controlador principal de la aplicación.
     */
    private final Controlador ctrl;
    
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye el Panel Otras Busquedas.
     * @param ctrl Controlador principal de la aplicación.
     */
    public PanelOtrasBusquedas(Controlador ctrl)
    {
        this.ctrl = ctrl;
        this.setBorder(new TitledBorder("Otras búsquedas"));
        GroupLayout grupo = new GroupLayout(this);
        
        this.setLayout(grupo);
        
        //Creacion de los elementos del panel.
        btnRango = new JButton("Elementos en un Rango");
        btnRango.setActionCommand(RANGO);
        btnRango.addActionListener((ActionListener)this);
        
        btnOcurrencia = new JButton("Número de Ocurrencias");
        btnOcurrencia.setActionCommand(OCURRENCIA);
        btnOcurrencia.addActionListener((ActionListener)this);
        
        btnDistinto = new JButton("Número de Valores Distintos");
        btnDistinto.setActionCommand(DISTINTOS);
        btnDistinto.addActionListener((ActionListener)this);
        
        btnFrecuente = new JButton("Valor más Frecuente");
        btnFrecuente.setActionCommand(FRECUENCIA);
        btnFrecuente.addActionListener((ActionListener)this);
        
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
    
    /**
     * Escucha los eventos de los botones.
     * @param e Accion que genero el evento. e != null.
     */
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String comando = e.getActionCommand();
        
        if(comando.equalsIgnoreCase(RANGO))
        {
            try
            {
                int limiteInferior = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el límite inferior para el rango de búsqueda", "Límite Inferior", JOptionPane.INFORMATION_MESSAGE));
                int limiteSuperior = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el límite superior para el rango de búsqueda", "Límite Superior", JOptionPane.INFORMATION_MESSAGE));
                ctrl.elementosRango(limiteInferior, limiteSuperior);
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, ex.getMessage(),"Elementos en un Rango", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            if(comando.equalsIgnoreCase(OCURRENCIA))
            {
                try
                {
                    int numeroBuscado = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el número para el que se van a contar las ocurrencias", "Número Buscado", JOptionPane.QUESTION_MESSAGE));
                    ctrl.numeroDeOcurrencias(numeroBuscado);
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Número de Ocurrencias", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                if(comando.equalsIgnoreCase(DISTINTOS))
                {
                    try
                    {
                        ctrl.numeroDeValoresDistintos();
                    }
                    catch(Exception ex)
                    {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Número de Valores Distintos", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    if(comando.equalsIgnoreCase(FRECUENCIA))
                    {
                        try
                        {
                            ctrl.valorMasFrecuente();
                        }
                        catch(Exception ex)
                        {
                            JOptionPane.showMessageDialog(this, ex.getMessage(), "Valor más Frecuente", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Actualiza el campo Numero rango.
     * @param cantidad Cantidad de elementos en el rango determinado.
     */
    public void setNumeroRango(String cantidad)
    {
        this.txtRango.setText(cantidad);
    }
    
    /**
     * Actualiza el campo Tiempo Rango.
     * @param tiempo Tiempo invertido por el algoritmo.
     */
    public void setTiempoRango(String tiempo)
    {
        this.txtRangoTiempo.setText(tiempo);
    }
    
    /**
     * Actualiza el campo Numero de Ocurrencias.
     * @param cantidad Cantidad de ocurrencias del elemento determinado.
     */
    public void setNumeroOcurrencias(String cantidad)
    {
        this.txtOcurrencia.setText(cantidad);
    }
    
    /**
     * Actualiza el campo Tiempo Ocurrencias.
     * @param tiempo Tiempo invertido por el algoritmo.
     */
    public void setTiempoOcurrencias(String tiempo)
    {
        this.txtOcurrenciaTiempo.setText(tiempo);
    }
    
    /**
     * Actualiza el Numero de elementos distintos en la muestra.
     * @param cantidad Numero de elementos distintos.
     */
    public void setNumerosDistintos(String cantidad)
    {
        this.txtDistinto.setText(cantidad);
    }
    
    /**
     * Actualiza el campo Tiempo Numeros Distintos.
     * @param tiempo Tiempo invertido por el algoritmo.
     */
    public void setTiempoNumerosDistintos(String tiempo)
    {
        this.txtDistintoTiempo.setText(tiempo);
    }
    
    /**
     * Actualiza el campo valor repetido.
     * @param valor Elemento que mas se repite en la muestra.
     */
    public void setValorRepetido(String valor)
    {
        this.txtFrecuente.setText(valor);
    }
    
    /**
     * Actualiza el Tiempo Valor Frecuente.
     * @param tiempo Tiempo invertido por el algoritmo.
     */
    public void setTiempoValorFrecuente(String tiempo)
    {
        this.txtFrencuennteTiempo.setText(tiempo);
    }
    
}
