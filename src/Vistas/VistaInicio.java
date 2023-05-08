
package Vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jeanp
 */
public class VistaInicio extends JFrame{
    
    private Fondo jpFondo;
    private JLabel lblTitulo;
    private JButton btnJugar;
    private JButton btnInstrucciones;
    private JPanel jpContenido;
    
  
    public VistaInicio(){
        iniciarComponentes();
        
    }
    
      
    
    private void iniciarComponentes(){
        //configuracion de la pantalla
        setTitle("Tic Tac Toe");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        jpFondo = new Fondo("/IMAGENES/FondoVistaInicio.jpg");
        jpContenido = new JPanel();
        
        jpFondo.setSize(500,465);
        add(jpContenido);
        
        lblTitulo = new JLabel("Tic Tac Toe");
        lblTitulo.setBounds(155,80,250,60);
        lblTitulo.setFont(new Font ("Comic Sans MS", Font.BOLD, 30));
        lblTitulo.setHorizontalAlignment(JLabel.LEFT);
        lblTitulo.setForeground(Color.WHITE);
        
        btnJugar = new JButton("Jugar");
        btnJugar.setBounds(175,330, 150,50);
        btnJugar.setFont(new Font("Comic Sans MS",Font.BOLD,21));
        btnJugar.setForeground(Color.WHITE);
        btnJugar.setOpaque(false);
        btnJugar.setContentAreaFilled(false);

        btnInstrucciones = new JButton("Instrucciones");
        btnInstrucciones.setBounds(150,400, 200,50);
        btnInstrucciones.setFont(new Font("Comic Sans MS",Font.BOLD,21));
        btnInstrucciones.setForeground(Color.WHITE);
        btnInstrucciones.setOpaque(false);
        btnInstrucciones.setContentAreaFilled(false);
        
        jpContenido.setSize(550,475);
        jpContenido.setLayout(null);
        
        jpContenido.add(lblTitulo);
        jpContenido.add(btnJugar);
        jpContenido.add(btnInstrucciones);
        jpContenido.add(jpFondo);

        
        ActionListener jugar = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                VistaConfiguracion vistaconfiguracion = new VistaConfiguracion();
                dispose();
            }
        };
        btnJugar.addActionListener(jugar);
        
        ActionListener instrucciones = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }       
        };
        btnInstrucciones.addActionListener(instrucciones);
        
    }
}
