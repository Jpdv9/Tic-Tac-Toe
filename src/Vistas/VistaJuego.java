package Vistas;

import Logica.LogicaJuego;
//import Logica.LogicaJuego.ManejadorEventoKey;
import Logica.LogicaJugador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
    private JButton btnTerminar;
    private LogicaJugador jugador1;
    private LogicaJugador jugador2;
    private LogicaJuego logicaJuego;
    //private ManejadorEventoKey keyListener;
    private Fondo jpFondo ;
   
   
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
        
        Border bordePersonalizado = BorderFactory.createLineBorder(Color.GREEN, 3);
        Border bordePersonalizado2 = BorderFactory.createLineBorder(Color.WHITE, 3);
       
        jpFondo = new Fondo("/IMAGENES/FondoSJuego.jpg");
        jpContenido = new JPanel();
       
        jpFondo.setSize(700,300);
       
        JPanel jpLabels = new JPanel();
        jpLabels.setOpaque(false);
       
        btnTerminar = new JButton("TERMINAR");
        btnTerminar.setBounds(213,100,150,50);
        btnTerminar.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        btnTerminar.setForeground(Color.BLACK);
        btnTerminar.setOpaque(false);
        btnTerminar.setContentAreaFilled(false);
        btnTerminar.setBorder(bordePersonalizado);
        btnTerminar.setFocusable(false);
        /*
        * Nombre de los jugadores
        */
       
        lblJugador1 = new JLabel("JUGADOR 1:");
        lblJugador1.setBounds(0,0,100,100);
        lblJugador1.setFont(new Font ("Comic Sans MS", Font.BOLD, 15));
       
        String nombre1 = jugador1.getNombre();
       
        nombre1 = nombre1.substring(0,1).toUpperCase() +
                nombre1.substring(1).toLowerCase();
        lblNombreJugador1 = new JLabel(nombre1);
        lblNombreJugador1.setBounds(0, 25, 100,100);
        lblNombreJugador1.setForeground(Color.GRAY);
        lblNombreJugador1.setFont(new Font ("Comic Sans MS", Font.BOLD, 15));
       
       
        //Jugador 2
        lblJugador2 = new JLabel("JUGADOR 2:");
        lblJugador2.setBounds(480,0,100,100);
        lblJugador2.setFont(new Font ("Comic Sans MS", Font.BOLD, 15));
       
        String nombre2 = jugador2.getNombre();
       
        nombre2 = nombre2.substring(0,1).toUpperCase() +
                nombre2.substring(1).toLowerCase();
        lblNombreJugador2 = new JLabel(nombre2);
        lblNombreJugador2.setBounds(500, 25, 100,100);
        lblNombreJugador2.setForeground(Color.GRAY);
        lblNombreJugador2.setFont(new Font ("Comic Sans MS", Font.BOLD, 15));
       
       
        //Numero de partidas disponible
        lblNumeroPartidas = new JLabel("Partida: " + LogicaJuego.numeroPartidas);
        lblNumeroPartidas.setBounds(250,0,100,100);
        lblNumeroPartidas.setFont(new Font ("Comic Sans MS", Font.BOLD, 16));
       
       
        // Partidas ganadas
        lblPartidasGanadas1 = new JLabel("Ganadas: " + LogicaJuego.partidasGanadas1);
        lblPartidasGanadas1.setBounds(0,70,100,100);
        lblPartidasGanadas1.setFont(new Font ("Comic Sans MS", Font.BOLD, 15));
       
        lblPartidasGanadas2 = new JLabel("Ganadas: " + LogicaJuego.partidasGanadas2);
        lblPartidasGanadas2.setBounds(500,70,100,100);
        lblPartidasGanadas2.setFont(new Font ("Comic Sans MS", Font.BOLD, 15));
       
       
        jpLabels.setLayout(null);
        jpLabels.setPreferredSize(new Dimension(500, 300));

        jpLabels.add(lblJugador1);
        jpLabels.add(lblNombreJugador1);
        jpLabels.add(lblJugador2);
        jpLabels.add(lblNombreJugador2);
        jpLabels.add(lblNumeroPartidas);
        jpLabels.add(btnTerminar);
        jpLabels.add(lblPartidasGanadas1);
        jpLabels.add(lblPartidasGanadas2);
        jpLabels.add(jpFondo);
        jpContenido.add(jpLabels);
        jpContenido.setBackground(Color.BLACK);
       
       
       
        jpContenido.setLayout(new BoxLayout(jpContenido, BoxLayout.Y_AXIS));
       
        /*
        * Configuracion de la matriz en la vista y funcionalidades
        */
        btnTerminar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta;

                respuesta = JOptionPane.showConfirmDialog(
                            null,"¿Quieres terminar el juego?", "Advertencia",
                            JOptionPane.YES_NO_OPTION, 
                            JOptionPane.WARNING_MESSAGE);
                if(respuesta == JOptionPane.YES_OPTION){
                    VistaEstadistica vistaEstadisticas = new VistaEstadistica(jugador1, jugador2);
                    dispose();
                }
            }

        });
        //Agrega los botones
        botones = new JButton[3][3];
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[0].length; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                botones[i][j].setVerticalAlignment(SwingConstants.CENTER);
                botones[i][j].setPreferredSize(new Dimension(100,200));
                //botones[i][j].addKeyListener(keyListener);
                botones[i][j].setFocusable(true);
               
               
                botones[i][j].addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent e){
                        JButton botonPresionado = (JButton) e.getSource();
                        // Jugador 1, el jugador utiliza el boton Izquiedo del mouse para jugar
                        if(e.getButton() == MouseEvent.BUTTON1 && LogicaJuego.turno == 1 && botonPresionado.isEnabled()){
                           
                            botonPresionado.setText("X");
                            botonPresionado.setEnabled(false);
                            botonPresionado.setFocusable(false);
                            botonPresionado.setFont(new Font ("Agency FB", Font.BOLD, 35));
                           
                            LogicaJuego.ultimoJugador = 0;
                           
                            logicaJuego.cpu(botones);
                           
                            if(logicaJuego.empate(botones)){
                               
                                JOptionPane.showMessageDialog(null, "El juego termino en empate",
                                        "Informacion", JOptionPane.INFORMATION_MESSAGE);
                               
                                logicaJuego.reseteoTriqui(botones);
                                LogicaJuego.numeroPartidas--;
                               
                                lblNumeroPartidas.setText("Partida: " + LogicaJuego.numeroPartidas);
                            }    
                            else if(logicaJuego.verificar(botones)){
                               
                               
                                String nombreJugador = jugador1.getNombre();
                                String ganador = LogicaJuego.ultimoJugador == 0 ? nombreJugador : "CPU";
                                
                                JOptionPane.showMessageDialog(null, "El jugador " + ganador +" ha ganado",
                                        "Informacion", JOptionPane.INFORMATION_MESSAGE);
                                logicaJuego.reseteoTriqui(botones);
                                switch(ganador){
                                    case "CPU":
                                        LogicaJuego.numeroPartidas--;
                                        LogicaJuego.partidasGanadas2++;
                                        lblNumeroPartidas.setText("Partida: " + LogicaJuego.numeroPartidas);
                                        lblPartidasGanadas2.setText("Ganadas: " + LogicaJuego.partidasGanadas2);
                                        break;
                                    default:
                                        LogicaJuego.numeroPartidas--;
                                        LogicaJuego.partidasGanadas1++;
                                        lblNumeroPartidas.setText("Partida: " + LogicaJuego.numeroPartidas);
                                        lblPartidasGanadas1.setText("Ganadas: " + LogicaJuego.partidasGanadas1);
                                    break;  
                                }
                               
                                
                               
                            }else{
                                LogicaJuego.turno++;
                            }
                        }
                       
                        //Jugador 2, el jugador utiliza el boton Derecho del mouse o el teclado para jugar
                        if(e.getButton() == MouseEvent.BUTTON3 && LogicaJuego.turno == 2 && botonPresionado.isEnabled() && !LogicaJuego.jugandoContraCpu){
                            botonPresionado.setText("O");
                            botonPresionado.setEnabled(false);
                            botonPresionado.setFont(new Font ("Agency FB", Font.BOLD, 35));
                           
                           
                            if(logicaJuego.verificar(botones)){
                               
                                JOptionPane.showMessageDialog(null, "El jugador " + jugador2.getNombre() +" ha ganado",
                                        "Informacion", JOptionPane.INFORMATION_MESSAGE);
                               
                                logicaJuego.reseteoTriqui(botones);
                               
                                LogicaJuego.numeroPartidas--;
                                LogicaJuego.partidasGanadas2++;
                               
                                lblNumeroPartidas.setText("Partida: " + LogicaJuego.numeroPartidas);
                                lblPartidasGanadas2.setText("Ganadas: " + LogicaJuego.partidasGanadas2);
                               
                            }else{
                                LogicaJuego.turno--;
                            }
                        }
                        if(LogicaJuego.numeroPartidas == 0){  
                           
                            VistaEstadistica vistaestadistica = new VistaEstadistica(jugador1, jugador2);
                            dispose();
                        }
                    }
                });
               
                botones[i][j].setBorder(bordePersonalizado2);
               
                botones[i][j].addKeyListener(new KeyAdapter(){
                   
                   
                    private int filaActual = 1;
                    private int columnaActual = 1;
 
                   
                    public void keyPressed(KeyEvent e){
                       
                            int codigo = e.getKeyCode();
                            if(codigo == KeyEvent.VK_UP && filaActual > 0){
                                botones[filaActual][columnaActual].setBorder(bordePersonalizado2);
                                filaActual --;
                                botones[filaActual][columnaActual].setBorder(bordePersonalizado);
                            }

                            else if(codigo == KeyEvent.VK_DOWN && filaActual < 2){
                                botones[filaActual][columnaActual].setBorder(bordePersonalizado2);
                                filaActual ++;
                                botones[filaActual][columnaActual].setBorder(bordePersonalizado);
                            }

                            else if(codigo == KeyEvent.VK_LEFT && columnaActual > 0){
                                botones[filaActual][columnaActual].setBorder(bordePersonalizado2);
                                columnaActual --;
                                botones[filaActual][columnaActual].setBorder(bordePersonalizado);
                            }

                            else if(codigo == KeyEvent.VK_RIGHT && columnaActual < 2){
                                botones[filaActual][columnaActual].setBorder(bordePersonalizado2);
                                columnaActual ++;
                                botones[filaActual][columnaActual].setBorder(bordePersonalizado);
                            }
                           
                            if(codigo == KeyEvent.VK_ENTER){
                                if(LogicaJuego.turno == 1 && botones[filaActual][columnaActual].isEnabled()){
                                    botones[filaActual][columnaActual].setText("X");
                                    botones[filaActual][columnaActual].setEnabled(false);
                                    botones[filaActual][columnaActual].setFont(new Font ("Agency FB", Font.BOLD, 35));
                                   
                                   LogicaJuego.ultimoJugador = 0;
                                   logicaJuego.cpu(botones);
                                   
                                    if(logicaJuego.empate(botones)){
                               
                                        JOptionPane.showMessageDialog(null, "El juego termino en empate",
                                                "Informacion", JOptionPane.INFORMATION_MESSAGE);

                                        logicaJuego.reseteoTriqui(botones);
                                        LogicaJuego.numeroPartidas--;
                                       

                                        lblNumeroPartidas.setText("Partida: " + LogicaJuego.numeroPartidas);
                                    }    
                                    else if(logicaJuego.verificar(botones)){


                                        String nombreJugador = jugador1.getNombre();
                                        String ganador = LogicaJuego.ultimoJugador == 0 ? nombreJugador : "CPU";

                                        JOptionPane.showMessageDialog(null, "El jugador " + ganador +" ha ganado",
                                                "Informacion", JOptionPane.INFORMATION_MESSAGE);
                                        logicaJuego.reseteoTriqui(botones);
                                        botones[filaActual][columnaActual].setBorder(bordePersonalizado2);

                                        switch(ganador){
                                    case "CPU":
                                        LogicaJuego.numeroPartidas--;
                                        LogicaJuego.partidasGanadas2++;
                                        lblNumeroPartidas.setText("Partida: " + LogicaJuego.numeroPartidas);
                                        lblPartidasGanadas2.setText("Ganadas: " + LogicaJuego.partidasGanadas2);
                                        break;
                                    default:
                                        LogicaJuego.numeroPartidas--;
                                        LogicaJuego.partidasGanadas1++;
                                        lblNumeroPartidas.setText("Partida: " + LogicaJuego.numeroPartidas);
                                        lblPartidasGanadas1.setText("Ganadas: " + LogicaJuego.partidasGanadas1);
                                    break;  
                                }

                                    }else{
                                        LogicaJuego.turno++;
                                    }
                                   
                                }
                               
                            }
                       
                       
                        if(LogicaJuego.numeroPartidas == 0){  
                           
                            VistaEstadistica vistaestadistica = new VistaEstadistica(jugador1, jugador2);
                            dispose();
                        }
                    }
                });
               
               
                botones[i][j].setFocusable(true);

               
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
        panel.setOpaque(false);
        jpContenido.add(panel, BorderLayout.CENTER);

    }
   
}
