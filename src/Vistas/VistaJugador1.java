/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import Logica.LogicaJuego;
import Logica.LogicaJugador;
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
public class VistaJugador1 extends JFrame{
    
    private JLabel lblNombreJugador;
    private JTextField txtDigitarNombre;
    private JButton btnSiguiente;
    private JPanel jpContenido;
    private LogicaJugador jugador2;
    
    
    public VistaJugador1(){
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
        
        lblNombreJugador = new JLabel("Nombre Jugador 1");
        lblNombreJugador.setBounds(183, 50, 150, 150);
        lblNombreJugador.setFont(new Font ("Agency FB", Font.BOLD, 25));
        
        txtDigitarNombre = new JTextField(15);
        txtDigitarNombre.setBounds(168, 180, 170, 50);
        
        btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setBounds(180, 250, 150, 50);
        
        jpContenido.setLayout(null);
        
        jpContenido.add(lblNombreJugador);
        jpContenido.add(txtDigitarNombre);
        jpContenido.add(btnSiguiente);
        
        ActionListener siguiente = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String nombre1 = txtDigitarNombre.getText();
                if(!nombre1.trim().isEmpty() || nombre1.trim().length() > 0){
                    if(LogicaJuego.jugadores == 2){
                        LogicaJugador jugador1 = new LogicaJugador(nombre1);
                        VistaJugador2 vistajugador2 = new VistaJugador2(jugador1);
                        dispose();
                    }else{
                        LogicaJugador jugador1 = new LogicaJugador(nombre1);
                        LogicaJugador jugador2 = new LogicaJugador();
                        
                        VistaJuego vistajuego = new VistaJuego(jugador1, jugador2);
                        dispose();
                    }
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
