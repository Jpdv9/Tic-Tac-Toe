
package Vistas;


import Logica.LogicaJugador;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jeanp
 */
public class VistaJugador2 extends JFrame{
    
    private JLabel lblNombreJugador;
    private JTextField txtDigitarNombre;
    private JButton btnSiguiente;
    private JPanel jpContenido;
    private LogicaJugador jugador1;
    private Fondo jpFondo;
    
    
    
    public VistaJugador2(LogicaJugador jugador1){
        this.jugador1 = jugador1;
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        
        //configuracion de la pantalla
        setTitle("Tic Tac Toe");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        

        
        jpFondo = new Fondo("/IMAGENES/FondoJugador2.jpg");
        jpContenido = new JPanel();
        
        jpFondo.setSize(500,465);
        add(jpContenido);

        
        lblNombreJugador = new JLabel("Nombre Jugador 2");
        lblNombreJugador.setBounds(150, 20, 250, 150);
        lblNombreJugador.setFont(new Font("Comic Sans MS",Font.BOLD,21));
        lblNombreJugador.setForeground(Color.WHITE);
        
        txtDigitarNombre = new JTextField(15);
        txtDigitarNombre.setBounds(210, 180, 170, 50);
        txtDigitarNombre.setFont(new Font("Comic Sans MS",Font.BOLD,21));
        txtDigitarNombre.setForeground(Color.WHITE);
        txtDigitarNombre.setOpaque(false);
        
        btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setBounds(150, 350, 200, 50);
        btnSiguiente.setFont(new Font("Comic Sans MS",Font.BOLD,21));
        btnSiguiente.setForeground(Color.WHITE);
        btnSiguiente.setOpaque(false);
        btnSiguiente.setContentAreaFilled(false);
        
        jpContenido.setLayout(null);
        
        jpContenido.add(lblNombreJugador);
        jpContenido.add(txtDigitarNombre);
        jpContenido.add(btnSiguiente);
        jpContenido.add(jpFondo);
        
        ActionListener siguiente = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {             
                String nombre2 = txtDigitarNombre.getText();
                if(!nombre2.trim().isEmpty() || nombre2.trim().length() > 0){
   
                    LogicaJugador jugador2 = new LogicaJugador(nombre2);
                    VistaJuego vistajuego = new VistaJuego(jugador1, jugador2); 
                    dispose(); 
                }
                else{
                JOptionPane.showMessageDialog(null,"Por favor ingrese su nombre", 
                        "Advertencia", JOptionPane.ERROR_MESSAGE);
                    txtDigitarNombre.requestFocusInWindow();
                }
            }
        };        
        btnSiguiente.addActionListener(siguiente);
    }

}
