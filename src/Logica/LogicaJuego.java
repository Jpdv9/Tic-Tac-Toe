/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Vistas.VistaJuego;
import javax.swing.JButton;

/**
 *
 * @author jeanp
 */
public class LogicaJuego {
    
    public static int jugadores = 0;
    public static int numeroPartidas = 0;
    public static int partidasSelecionadas = numeroPartidas;
    public static boolean ganar;
    public static int turno;
    public String[][] estadoBotones;
    public JButton[][] botones;
    
    
    public LogicaJuego(){
        this.turno = 0;
        this.ganar = false;
        
        
        
    }
    
    
    public void triqui(){
        //estadoBotones = new String[this.botones.length][this.botones[0].length];
        botones = new JButton[3][3];
        VistaJuego vistajuego = new VistaJuego();

    }
    
}
