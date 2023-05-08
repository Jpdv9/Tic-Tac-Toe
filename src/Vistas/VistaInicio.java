
package Vistas;

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
        
        jpContenido = new JPanel();
        
        
        add(jpContenido);
        
        lblTitulo = new JLabel("Tic Tac Toe");
        lblTitulo.setBounds(155,80,250,60);
        lblTitulo.setFont(new Font ("Comic Sans MS", Font.BOLD, 30));
        lblTitulo.setHorizontalAlignment(JLabel.LEFT);
        
        btnJugar = new JButton("Jugar");
        btnJugar.setBounds(175,180, 150,50);
            btnJugar.setFont(new Font("Comic Sans MS",Font.BOLD,21));

        btnInstrucciones = new JButton("Instrucciones");
        btnInstrucciones.setBounds(150,250, 200,50);
        btnInstrucciones.setFont(new Font("Comic Sans MS",Font.BOLD,21));
        
        jpContenido.setSize(550,475);
        jpContenido.setLayout(null);
        
        jpContenido.add(lblTitulo);
        jpContenido.add(btnJugar);
        jpContenido.add(btnInstrucciones);

        
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
