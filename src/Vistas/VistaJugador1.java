/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import Logica.LogicaJuego;
import Logica.LogicaJuego;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
                if(LogicaJuego.jugadores == 2){
                    //Crear la ventana del jugador 2
                    dispose();
                    System.out.println(LogicaJuego.jugadores);
                }else{
                    VistaJuego vistajuego = new VistaJuego();
                    dispose();
                    System.out.println(LogicaJuego.jugadores);
                }
                
            }
        };        
        btnSiguiente.addActionListener(siguiente);
    }
    
}
