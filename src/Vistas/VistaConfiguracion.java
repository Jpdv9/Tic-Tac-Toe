/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class VistaConfiguracion extends JFrame{
    private JLabel lbl1vs1;
    private JLabel lbl1vscpu;
    private JLabel lblNumeroPartidas;
    private JButton btn1vs1;
    private JButton btn1vscpu;
    private JButton btnPartida1;
    private JButton btnPartida2; 
    private JButton btnPartida3; 
    private JButton btnPartida4;
    private JButton btnSiguiente;
    private JButton btnAtras; 
    private JPanel jpContenido;
    
    
    public VistaConfiguracion(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        
        //configuracion de la pantalla
        setTitle("Tic Tac Toe");
        setSize(700,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        
        jpContenido = new JPanel();
        add(jpContenido);
        
        lbl1vs1 = new JLabel("1 vs 1");
        lbl1vs1.setBounds(175,15,100,100);
        lbl1vs1.setFont(new Font ("Agency FB", Font.BOLD, 20));
        
        lbl1vscpu = new JLabel("1 vs CPU");
        lbl1vscpu.setBounds(450,15,100,100);
        lbl1vscpu.setFont(new Font ("Agency FB", Font.BOLD, 20));
        
        lblNumeroPartidas = new JLabel("Numero De Partidas");
        lblNumeroPartidas.setBounds(275, 150, 150,150);
        lblNumeroPartidas.setFont(new Font ("Agency FB", Font.BOLD, 20));
        
        
        //Imagenes en el botton de dos muñecos, el texto colocado es temporal
        btn1vs1 = new JButton("1 vs 1");
        btn1vs1.setBounds(425,90,100,100);
        
        //Imagen de computador y un muñeco, el texto colocado es temporal
        btn1vscpu = new JButton("1 vs CPU");
        btn1vscpu.setBounds(140,90,100,100);
        
        btnPartida1 = new JButton("1");
        btnPartida1.setBounds(160,250,50,50);
        
        btnPartida2 = new JButton("2");
        btnPartida2.setBounds(260,250,50,50);
        
        btnPartida3 = new JButton("3");
        btnPartida3.setBounds(360,250,50,50);
        
        btnPartida4 = new JButton("4");
        btnPartida4.setBounds(460,250,50,50);
        
        btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setBounds(550,405,125,50);
        
        btnAtras = new JButton("Atras");
        btnAtras.setBounds(5,405,125,50);
        
        jpContenido.setSize(700,500);
        jpContenido.setLayout(null);
        
        jpContenido.add(lbl1vs1);
        jpContenido.add(lbl1vscpu);
        jpContenido.add(lblNumeroPartidas);
        jpContenido.add(btn1vs1);
        jpContenido.add(btn1vscpu);
        jpContenido.add(btnPartida1);
        jpContenido.add(btnPartida2);
        jpContenido.add(btnPartida3);
        jpContenido.add(btnPartida4);
        jpContenido.add(btnSiguiente);
        jpContenido.add(btnAtras);
        
        
        ActionListener siguiente = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaJugador1 vistajugador1 = new VistaJugador1();
                dispose();
            }
        };
        
        btnSiguiente.addActionListener(siguiente);
    }
}
