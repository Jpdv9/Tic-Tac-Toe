/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import Logica.LogicaJuego;
import Logica.LogicaJugador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author jeanp
 */
public class VistaJuego extends JFrame{
    
    private JLabel lblJugador1;
    private JLabel lblJugador2;
    private JLabel lblNombreJugador1;
    private JLabel lblNombreJugador2;
    private JLabel lblPartidasGanadas1;
    private JLabel lblPartidasGanadas2;
    private JLabel lblNumeroPartidas;
    private JButton[][] botones;
    private JPanel jpContenido;
    private LogicaJugador jugador1;
    private LogicaJugador jugador2;
    private LogicaJuego logicaJuego;
    
    
    public VistaJuego(LogicaJugador jugador1, LogicaJugador jugador2){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.logicaJuego = new LogicaJuego(botones);
        
        iniciarComponentes();        
    }
    
    private void iniciarComponentes(){
        
        //configuracion de la pantalla
        setTitle("Tic Tac Toe");
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        jpContenido = new JPanel();
        
        JPanel jpLabels = new JPanel();

        
        
        lblJugador1 = new JLabel("JUGADOR 1:");
        lblJugador1.setBounds(0,0,100,100);
        lblJugador1.setFont(new Font("Agency FB", Font.BOLD, 18));
        
        String nombre1 = jugador1.getNombre();
        
        nombre1 = nombre1.substring(0,1).toUpperCase() +
                nombre1.substring(1).toLowerCase();
        lblNombreJugador1 = new JLabel(nombre1);
        lblNombreJugador1.setBounds(0, 25, 100,100);
        lblNombreJugador1.setForeground(Color.GRAY);
        lblNombreJugador1.setFont(new Font("arial", Font.BOLD, 18));
        
        lblJugador2 = new JLabel("JUGADOR 2:");
        lblJugador2.setBounds(490,0,100,100);
        lblJugador2.setFont(new Font("Agency FB", Font.BOLD, 18));
        
        String nombre2 = jugador2.getNombre();
        
        nombre2 = nombre2.substring(0,1).toUpperCase() +
                nombre2.substring(1).toLowerCase();
        lblNombreJugador2 = new JLabel(nombre2);
        lblNombreJugador2.setBounds(500, 25, 100,100);
        lblNombreJugador2.setForeground(Color.GRAY);
        lblNombreJugador2.setFont(new Font("arial", Font.BOLD, 18));
        
        lblNumeroPartidas = new JLabel("Partida: " + LogicaJuego.numeroPartidas);
        lblNumeroPartidas.setBounds(250,0,100,100);
        lblNumeroPartidas.setFont(new Font("Agency FB", Font.BOLD, 20));
        
        jpLabels.setLayout(null);
        jpLabels.setPreferredSize(new Dimension(500, 300));

        
        jpLabels.add(lblJugador1);
        jpLabels.add(lblNombreJugador1);
        jpLabels.add(lblJugador2);
        jpLabels.add(lblNombreJugador2);
        jpLabels.add(lblNumeroPartidas);
        jpContenido.add(jpLabels);
        
        jpContenido.setLayout(new BoxLayout(jpContenido, BoxLayout.Y_AXIS));
        /*
        * Configuracion de la matriz en la vista y funcionalidades
        */
        
        //Agrega los botones
        botones = new JButton[3][3];
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[0].length; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                botones[i][j].setVerticalAlignment(SwingConstants.CENTER);
                botones[i][j].setPreferredSize(new Dimension(100,200));
                
                botones[i][j].addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent e){
                        JButton botonPresionado = (JButton) e.getSource();
                        if(e.getButton() == MouseEvent.BUTTON1 && LogicaJuego.turno == 1){
                            
                            botonPresionado.setEnabled(false);
                            botonPresionado.setText("X");
                            botonPresionado.setFont(new Font ("Agency FB", Font.BOLD, 35));
                            if(logicaJuego.verificar(botones) == true){
                                JOptionPane.showMessageDialog(null, "El jugador " + jugador1.getNombre() +" ha ganado",
                                        "Informacion", JOptionPane.INFORMATION_MESSAGE);
                                logicaJuego.reseteoTriqui(botones);
                                LogicaJuego.numeroPartidas--;
                                lblNumeroPartidas.setText("Partida: " + LogicaJuego.numeroPartidas);
                                
                            }else{
                                LogicaJuego.turno++; 
                            }
                            
                        }
                        if(e.getButton() == MouseEvent.BUTTON3 && LogicaJuego.turno == 2){
                            botonPresionado.setEnabled(false);
                            botonPresionado.setText("O");
                            botonPresionado.setFont(new Font ("Agency FB", Font.BOLD, 35));
                            if(logicaJuego.verificar(botones) == true){
                                JOptionPane.showMessageDialog(null, "El jugador " + jugador2.getNombre() +" ha ganado",
                                        "Informacion", JOptionPane.INFORMATION_MESSAGE);
                                logicaJuego.reseteoTriqui(botones);
                                LogicaJuego.numeroPartidas--;
                                lblNumeroPartidas.setText("Partida: " + LogicaJuego.numeroPartidas);
                            }else{
                                LogicaJuego.turno--;
                            }
                            
                        }
                    }
                });
            }
        }
        
        mostrarBotones(botones, 3, 3);
        
        // Un border
        Border borde = BorderFactory.createEmptyBorder(0,100, 100, 100);
        jpContenido.setBorder(borde);
        
        add(jpContenido);
    }
    
    public void mostrarBotones(JButton[][] botones, int filas, int columnas){
        JPanel panel = new JPanel(new GridLayout(filas, columnas,5, 5));
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                panel.add(botones[i][j]);
                
            }
        }
        
        jpContenido.add(panel, BorderLayout.CENTER); 
    }
}
