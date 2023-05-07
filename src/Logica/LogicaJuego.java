/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;


import javax.swing.JButton;

/**
 *
 * @author jeanp
 */
public class LogicaJuego {
    
    public static int jugadores = 0;
    public static int numeroPartidas = 0;
    public static int partidasSelecionadas = numeroPartidas;
    public JButton[][] botones;
    public static boolean ganar;
    public static int turno = 1;
    
    public LogicaJuego(JButton[][] botones){
        this.botones = botones;
    }
    
    
    
    public boolean verificar(JButton[][] botones){
        
        //Verifica las filas
        for(int i = 0; i < 3; i++){
            if(botones[i][0].getText().equals(botones[i][1].getText()) && botones[i][0].getText().equals(botones[i][2].getText()) && !botones[i][0].getText().equals("")){
                return ganar = true;
            }
        }
        
        //Verifica las columnas
        for(int i = 0; i < 3; i++){
            if(botones[0][i].getText().equals(botones[1][i].getText()) && botones[0][i].getText().equals(botones[2][i].getText()) && !botones[0][i].getText().equals("")){
                return ganar = true;
            }
        }
        
        //Verfica las diagonales
        if(botones[0][0].getText().equals(botones[1][1].getText()) && botones[0][0].getText().equals(botones[2][2].getText()) && !botones[0][0].getText().equals("")){
            return ganar = true;
        }
        
        if(botones[0][2].getText().equals(botones[1][1].getText()) && botones[0][2].getText().equals(botones[2][0].getText()) && !botones[0][2].getText().equals("")){
            return ganar = true;
        }
        
        return ganar = false;
    }
    
    public void reseteoTriqui(JButton[][] botones){
        for(int i = 0; i < botones.length; i++){
            for(int j = 0; j < botones[0].length; j++){
                botones[i][j].setEnabled(true);
                botones[i][j].setText("");
            }
        }
        
        turno = 1;
        ganar = false;
    }
}
