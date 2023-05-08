
package Logica;

/**
 *
 * @author jeanp
 */
public class LogicaJugador {
      
    private String nombre;
    
    public LogicaJugador(){
        nombre = "NPC";
    }
    
    public LogicaJugador(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
