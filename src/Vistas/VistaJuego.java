/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import Logica.LogicaJuego;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author jeanp
 */
public class VistaJuego extends JFrame{
    
    private JLabel lblNombreJugador1;
    private JLabel lblNombreJugador2;
    private JLabel lblPartidasGanadas1;
    private JLabel lblPartidasGanadas2;
    private JLabel etiqueta;
    private JButton[][] botones;
    private JPanel jpContenido;
    
    
    public VistaJuego(){
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
        jpContenido.setLayout(new BoxLayout(jpContenido, BoxLayout.Y_AXIS));
        
        
        
        //Colocar un espacio vacio arriba
        JPanel emptyBoxTop = new JPanel();
        emptyBoxTop.setPreferredSize(new Dimension(0, 100));
        jpContenido.add(emptyBoxTop);
        
        
        //Agrega los botones
        botones = new JButton[3][3];
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[0].length; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                botones[i][j].setVerticalAlignment(SwingConstants.CENTER);
                botones[i][j].setPreferredSize(new Dimension(150,200));
                
                botones[i][j].addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent e){
                        JButton botonPresionado = (JButton) e.getSource();
                        if(e.getButton() == MouseEvent.BUTTON1){
                            botonPresionado.setEnabled(false);
                            botonPresionado.setText("X");
                            
                        }
                        if(e.getButton() == MouseEvent.BUTTON3){
                            botonPresionado.setEnabled(false);
                            botonPresionado.setText("O");
                        }
                    }
                });
            }
        }
        
        mostrarBotones(botones, 3, 3);
        jpContenido.add(Box.createVerticalGlue());
        
        //Colocar un espacio vacio abajo
        JPanel emptyBoxBottom = new JPanel();
        emptyBoxBottom.setPreferredSize(new Dimension(0, 100));
        jpContenido.add(emptyBoxBottom);
        
        // Un border
        Border borde = BorderFactory.createEmptyBorder(150,150, 150, 150);
        jpContenido.setBorder(borde);
        
        add(jpContenido);
    }
    
    public void mostrarBotones(JButton[][] botones, int filas, int columnas){
        JPanel panel = new JPanel(new GridLayout(filas, columnas, 5, 5));
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                panel.add(botones[i][j]);
                
            }
        }
        
        jpContenido.add(panel, BorderLayout.CENTER); 
  
    }
    
}
