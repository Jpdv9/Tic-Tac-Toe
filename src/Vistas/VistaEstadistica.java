
package Vistas;

import Logica.LogicaJuego;
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

/**
 *
 * @author jeanp
 */
public class VistaEstadistica extends JFrame{
    
    private Fondo jpFondo;
    private JLabel lblNombreJugador1;
    private JLabel lblNombreJugador2;
    private JLabel lblPartidasGanadas1;
    private JLabel lblPartidasGanadas2;
    private JButton btnJugarDeNuevo;
    private JButton btnFinalizar;
    private JPanel jpContenido;
    private LogicaJugador jugador1;
    private LogicaJugador jugador2;
    
    public VistaEstadistica(LogicaJugador jugador1, LogicaJugador jugador2){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        
        //configuracion de la pantalla
        setTitle("Tic Tac Toe");
        setSize(550,550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        jpFondo = new Fondo("/IMAGENES/FondoEstadisticas.jpg");
        jpContenido = new JPanel();
        jpFondo.setSize(540,520);
        
        add(jpContenido);
        
        
        /* 
        * Estadisticas del Jugador 1
        */
        
        //NOMBRE
        
        String nombre1 = jugador1.getNombre();
        
        nombre1 = nombre1.substring(0, 1).toUpperCase() + 
                nombre1.substring(1).toLowerCase();
        lblNombreJugador1 = new JLabel("<html>Nombre del Jugador 1: <br>" + nombre1 + "</html>");
        lblNombreJugador1.setBounds(100, 150, 200,200);
        lblNombreJugador1.setFont(new Font ("Comic Sans MS", Font.BOLD, 15));
        
        //PARTIDAS GANADAS
        
        lblPartidasGanadas1 = new JLabel("<html>Partidas Ganadas: <br> " + LogicaJuego.partidasGanadas1 + "</html>");
        lblPartidasGanadas1.setBounds(100, 200, 200,200);
        lblPartidasGanadas1.setFont(new Font ("Comic Sans MS", Font.BOLD, 15));
        
        /* 
        * Estadisticas del Jugador 2
        */
        
        //NOMBRE
        
        String nombre2 = jugador2.getNombre();
        
        nombre1 = nombre2.substring(0, 1).toUpperCase() + 
                nombre2.substring(1).toLowerCase();
        lblNombreJugador2 = new JLabel("<html>Nombre del Jugador 2: <br> " + nombre1 + "</html>");
        lblNombreJugador2.setBounds(300, 150, 200,200);
        lblNombreJugador2.setFont(new Font ("Comic Sans MS", Font.BOLD, 15));
        
        //PARTIDAS GANADAS
        
        lblPartidasGanadas2 = new JLabel("<html>Partidas Ganadas:  <br>" + LogicaJuego.partidasGanadas2 + "</html>");
        lblPartidasGanadas2.setBounds(300, 200, 200,200);
        lblPartidasGanadas2.setFont(new Font ("Comic Sans MS", Font.BOLD, 15));
        
        btnJugarDeNuevo = new JButton("Volver a Jugar");
        btnJugarDeNuevo.setBounds(90,400, 150,50);
        btnJugarDeNuevo.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        btnJugarDeNuevo.setForeground(Color.BLACK);
        btnJugarDeNuevo.setOpaque(false);
        btnJugarDeNuevo.setContentAreaFilled(false);
        btnJugarDeNuevo.setFocusable(false);

        btnFinalizar = new JButton("Salir");
        btnFinalizar.setBounds(265,400, 150,50);
        btnFinalizar.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        btnFinalizar.setForeground(Color.BLACK);
        btnFinalizar.setOpaque(false);
        btnFinalizar.setContentAreaFilled(false);
        btnFinalizar.setFocusable(false);
        
        
        
        jpContenido.setLayout(null);
        jpContenido.setSize(500, 500);
        
        jpContenido.add(btnJugarDeNuevo);
        jpContenido.add(btnFinalizar);
        jpContenido.add(lblNombreJugador1);
        jpContenido.add(lblPartidasGanadas1);
        jpContenido.add(lblNombreJugador2);
        jpContenido.add(lblPartidasGanadas2);
        jpContenido.add(jpFondo);

        ActionListener VolverJugar;
        VolverJugar = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                LogicaJuego.partidasGanadas1 = 0 ;
                LogicaJuego.partidasGanadas2 = 0 ;
                VistaInicio Vistainicio = new VistaInicio();
                dispose();
            }
        };
        
        btnJugarDeNuevo.addActionListener(VolverJugar);
        
        ActionListener Salir = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta;

                respuesta = JOptionPane.showConfirmDialog(
                            null,"¿Quieres terminar el juego?", "Advertencia",
                            JOptionPane.YES_NO_OPTION, 
                            JOptionPane.WARNING_MESSAGE);
                if(respuesta == JOptionPane.YES_OPTION){
                    dispose();
                }
            }       
        };
        btnFinalizar.addActionListener(Salir);
    }
}
