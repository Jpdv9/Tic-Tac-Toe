
package Logica;


import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;

/**
 *
 * @author jeanp
 */
public class LogicaJuego {
    
    public static int jugadores = 0;
    public static boolean jugandoContraCpu = false;
    public static int numeroPartidas = 0;
    public JButton[][] botones;
    public static boolean ganar;
    public static int turno = 1;
    public static int partidasGanadas1 = 0;
    public static int partidasGanadas2 = 0;
    public static int ultimoJugador;
   
    
    
    public LogicaJuego(JButton[][] botones){
        this.botones = botones;
        this.ultimoJugador = 0;
    }
    

    public boolean verificar(JButton[][] botones){
        
        //Verifica las filas
        
        for(int i = 0; i < 3; i++){
            if(botones[i][0].getText().equals(botones[i][1].getText()) && botones[i][0].getText().equals(botones[i][2].getText()) && !botones[i][0].getText().equals("")){
                ganar = true;
            }
        }
        
        //Verifica las columnas
        for(int i = 0; i < 3; i++){
            if(botones[0][i].getText().equals(botones[1][i].getText()) && botones[0][i].getText().equals(botones[2][i].getText()) && !botones[0][i].getText().equals("")){
                ganar = true;
            }
        }
        
        //Verfica las diagonales
        if(botones[0][0].getText().equals(botones[1][1].getText()) && botones[0][0].getText().equals(botones[2][2].getText()) && !botones[0][0].getText().equals("")){
            ganar = true;
        }
        
        if(botones[0][2].getText().equals(botones[1][1].getText()) && botones[0][2].getText().equals(botones[2][0].getText()) && !botones[0][2].getText().equals("")){
            ganar = true;
        }
        
        
        return ganar;
        
    }
    
    
    public boolean empate(JButton[][] botones){
        
        return !(espacioDisponible(botones) ||  verificar(botones));
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
        ultimoJugador = 0;
    }
    
    
    public void cpu(JButton[][] botones){
        
       
        
        if(jugandoContraCpu){
             
            if(espacioDisponible(botones)){
                
                
                outer :for(JButton[] filaBoton : botones){
                    
                    col : for(JButton columnaBoton : filaBoton){
                        
                        if(columnaBoton.getText().equals("")){
                            
                            
                            columnaBoton.setText("O");
                            columnaBoton.setEnabled(false);
                            columnaBoton.setFont(new Font ("Agency FB", Font.BOLD, 35));
                            
                            ultimoJugador = 1;
                            turno--;
                            
                            
                            return;
                            
                        }else if(columnaBoton.getText().equals("X")){
                            if(verificar(botones)){
                                ultimoJugador = 0;
                                break outer;
                            }
                            
                            continue col;
                            
                            
                        }
                    }
                    
                }
                
            }
           
           ultimoJugador = 0;
           if(verificar(botones)){
            ultimoJugador = 0;
        }
        }
        
    }
    
    
    public boolean espacioDisponible(JButton[][] botones){
        
        for(JButton[] filaBoton : botones){
            for(JButton columnaBoton : filaBoton){
                if(columnaBoton.getText().equals("")){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    
}
