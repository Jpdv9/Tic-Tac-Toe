
package Vistas;

import Logica.LogicaJuego;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author jeanp
 */
public class VistaConfiguracion extends JFrame{
    private JLabel lblModoPartida;
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
    private Fondo jpFondo;
    
    
    public VistaConfiguracion(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        
        Border bordePersonalizado = BorderFactory.createLineBorder(Color.WHITE, 3);
        Border bordePersonalizado2 = BorderFactory.createLineBorder(Color.GREEN, 3);
        //configuracion de la pantalla
        setTitle("Tic Tac Toe");
        setSize(700,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        jpFondo = new Fondo("/IMAGENES/VistaConfiguracion.jpg");
        jpContenido = new JPanel();
        jpFondo.setSize(700,465);
        add(jpContenido);
        

        
        lblModoPartida = new JLabel("<html><body> Escoge el modo <br> de partida :</body></html>");
        lblModoPartida.setBounds(75,0,200,100);
        lblModoPartida.setFont(new Font ("Comic Sans MS", Font.BOLD, 18));
        lblModoPartida.setHorizontalAlignment(JLabel.LEFT);
        lblModoPartida.setForeground(Color.WHITE);
        
        lblNumeroPartidas = new JLabel("Numero De Partidas");
        lblNumeroPartidas.setBounds(475, 0, 250,100);
        lblNumeroPartidas.setFont(new Font ("Comic Sans MS", Font.BOLD, 18));
        lblNumeroPartidas.setHorizontalAlignment(JLabel.LEFT);
        lblNumeroPartidas.setForeground(Color.WHITE);
        
        
        //Imagenes en el botton de dos muñecos, el texto colocado es temporal
        btn1vs1 = new JButton();
        btn1vs1.setBounds(30,80,77,92);
        btn1vs1.setOpaque(false);
        btn1vs1.setContentAreaFilled(false);
        btn1vs1.setBorder(bordePersonalizado);
        
        //Imagen de computador y un muñeco, el texto colocado es temporal
        btn1vscpu = new JButton();
        btn1vscpu.setBounds(142,80,80,90);
        btn1vscpu.setOpaque(false);
        btn1vscpu.setContentAreaFilled(false);
        btn1vscpu.setBorder(bordePersonalizado);
        
        btnPartida1 = new JButton("1");
        btnPartida1.setBounds(495,80,50,50);
        btnPartida1.setFont(new Font("Comic Sans MS",Font.BOLD,21));
        btnPartida1.setForeground(Color.WHITE);
        btnPartida1.setOpaque(false);
        btnPartida1.setContentAreaFilled(false);

        
        btnPartida2 = new JButton("2");
        btnPartida2.setBounds(570,80,50,50);
        btnPartida2.setFont(new Font("Comic Sans MS",Font.BOLD,21));
        btnPartida2.setForeground(Color.WHITE);
        btnPartida2.setOpaque(false);
        btnPartida2.setContentAreaFilled(false);

        
        btnPartida3 = new JButton("3");
        btnPartida3.setBounds(495,140,50,50);
        btnPartida3.setFont(new Font("Comic Sans MS",Font.BOLD,21));
        btnPartida3.setForeground(Color.WHITE);
        btnPartida3.setOpaque(false);
        btnPartida3.setContentAreaFilled(false);

        
        btnPartida4 = new JButton("4");
        btnPartida4.setBounds(570,140,50,50);
        btnPartida4.setFont(new Font("Comic Sans MS",Font.BOLD,21));
        btnPartida4.setForeground(Color.WHITE);
        btnPartida4.setOpaque(false);
        btnPartida4.setContentAreaFilled(false);

        
        btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setBounds(440,405,145,50);
        btnSiguiente.setFont(new Font("Comic Sans MS",Font.BOLD,21));
        btnSiguiente.setForeground(Color.WHITE);
        btnSiguiente.setOpaque(false);
        btnSiguiente.setContentAreaFilled(false);
        btnSiguiente.setBorder(bordePersonalizado);

        btnSiguiente.setEnabled(false);
        
        btnAtras = new JButton("Atras");
        btnAtras.setBounds(5,405,125,50);
        btnAtras.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        btnAtras.setForeground(Color.WHITE);
        btnAtras.setOpaque(false);
        btnAtras.setContentAreaFilled(false);

        
        
        jpContenido.setSize(700,500);
        jpContenido.setLayout(null);
        

        jpContenido.add(lblModoPartida);
        jpContenido.add(lblNumeroPartidas);
        jpContenido.add(btn1vs1);
        jpContenido.add(btn1vscpu);
        jpContenido.add(btnPartida1);
        jpContenido.add(btnPartida2);
        jpContenido.add(btnPartida3);
        jpContenido.add(btnPartida4);
        jpContenido.add(btnSiguiente);
        jpContenido.add(btnAtras);
        jpContenido.add(jpFondo);
        
        
        
         ActionListener atras = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaInicio vistainicio = new VistaInicio();
                dispose();
            }
        };
        
        btnAtras.addActionListener(atras);
        
        ActionListener siguiente = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                VistaJugador1 vistajugador1 = new VistaJugador1();
                dispose();
            }
        };
        
        btnSiguiente.addActionListener(siguiente);
        
        btn1vs1.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                LogicaJuego.jugadores = 2;
                LogicaJuego.jugandoContraCpu = false;                
                btn1vs1.setBorder(bordePersonalizado2);
                btn1vscpu.setBorder(BorderFactory.createLoweredBevelBorder());
                btn1vscpu.setBackground(null);
                
                if(LogicaJuego.numeroPartidas > 0){
                    btnSiguiente.setEnabled(true);
                } 
            }  
        });
        
        btn1vscpu.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                LogicaJuego.jugadores = 1;
                LogicaJuego.jugandoContraCpu = true;
                
                btn1vscpu.setBorder(bordePersonalizado2);
                btn1vs1.setBorder(BorderFactory.createLoweredBevelBorder());
                btn1vs1.setBackground(null);
                
                if(LogicaJuego.numeroPartidas > 0){
                    btnSiguiente.setBorder(bordePersonalizado2);
                    btnSiguiente.setEnabled(true);
                } 
            }  
        });
        
        btnPartida1.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                LogicaJuego.numeroPartidas = 1;
                
                btnPartida1.setBorder(bordePersonalizado2);
                btnPartida2.setBorder(BorderFactory.createLoweredBevelBorder());
                btnPartida2.setBackground(null);
                btnPartida3.setBorder(BorderFactory.createLoweredBevelBorder());
                btnPartida3.setBackground(null);
                btnPartida4.setBorder(BorderFactory.createLoweredBevelBorder());
                btnPartida4.setBackground(null);
                
                if(LogicaJuego.jugadores > 0){
                    btnSiguiente.setBorder(bordePersonalizado2);
                    btnSiguiente.setEnabled(true);
                } 
            }  
        });
        
        btnPartida2.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                LogicaJuego.numeroPartidas = 2;
                
                btnPartida2.setBorder(bordePersonalizado2);
                btnPartida1.setBorder(BorderFactory.createLoweredBevelBorder());
                btnPartida1.setBackground(null);
                btnPartida3.setBorder(BorderFactory.createLoweredBevelBorder());
                btnPartida3.setBackground(null);
                btnPartida4.setBorder(BorderFactory.createLoweredBevelBorder());
                btnPartida4.setBackground(null);
                
                if(LogicaJuego.jugadores > 0){
                    btnSiguiente.setBorder(bordePersonalizado2);
                    btnSiguiente.setEnabled(true);
                } 
            }  
        });
        
        btnPartida3.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                LogicaJuego.numeroPartidas = 3;
                
                btnPartida3.setBorder(bordePersonalizado2);
                btnPartida1.setBorder(BorderFactory.createLoweredBevelBorder());
                btnPartida1.setBackground(null);
                btnPartida2.setBorder(BorderFactory.createLoweredBevelBorder());
                btnPartida2.setBackground(null);
                btnPartida4.setBorder(BorderFactory.createLoweredBevelBorder());
                btnPartida4.setBackground(null);
                
                if(LogicaJuego.jugadores > 0){
                    btnSiguiente.setBorder(bordePersonalizado2);
                    btnSiguiente.setEnabled(true);
                } 
            }  
        });
        
        btnPartida4.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                LogicaJuego.numeroPartidas = 4;
                
                btnPartida4.setBorder(bordePersonalizado2);
                btnPartida1.setBorder(BorderFactory.createLoweredBevelBorder());
                btnPartida1.setBackground(null);
                btnPartida2.setBorder(BorderFactory.createLoweredBevelBorder());
                btnPartida2.setBackground(null);
                btnPartida3.setBorder(BorderFactory.createLoweredBevelBorder());
                btnPartida3.setBackground(null);
                
                if(LogicaJuego.jugadores > 0){
                    btnSiguiente.setBorder(bordePersonalizado2);
                    btnSiguiente.setEnabled(true);
                } 
            }  
        }); 
    }  
}
