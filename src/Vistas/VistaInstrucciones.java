package Vistas;

/**
 *
 * @author Franklin Aguirre
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Franklin Aguirre
 */
public class VistaInstrucciones extends JFrame{
    private JLabel lblTexto;
    private JButton btnJugar;
    private JButton btnVolver;
    private JPanel jpContenido;
    private Fondo jpFondo;
    
    public VistaInstrucciones(){
        iniciarComponentes();

    }
    private void iniciarComponentes(){
        //creacion panel
                setTitle("Fuga de Letras");
        setSize(670,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        jpFondo = new Fondo("/IMAGENES/FondoInstruccciones.jpg"); 
        jpContenido = new JPanel();
        jpFondo.setSize(655,630);
        add(jpContenido);
        
        lblTexto = new JLabel("<html><body>Instrucciones: <br> aqui van las instrucciiones <br>Gracias por leer, Exitos en el juego  </body></html>");
        lblTexto.setBounds(50,50,550,420);
        lblTexto.setFont(new Font("Comic Sans MS",Font.BOLD,25));
        lblTexto.setHorizontalAlignment(JLabel.LEFT);
        
        btnJugar = new JButton("Jugar");
        btnJugar.setBounds(90,400, 150,50);
        btnJugar.setFont(new Font("Comic Sans MS",Font.BOLD,25));
        btnJugar.setForeground(Color.BLACK);
        btnJugar.setOpaque(false);
        btnJugar.setContentAreaFilled(false);
        btnJugar.setFocusable(false);

        btnVolver = new JButton("Salir");
        btnVolver.setBounds(265,400, 150,50);
        btnVolver.setFont(new Font("Comic Sans MS",Font.BOLD,25));
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setOpaque(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setFocusable(false);
        
        
        jpContenido.setSize(500,500);
        jpContenido.setLayout(null);
        
        jpContenido.add(lblTexto);
        jpContenido.add(btnJugar);
        jpContenido.add(btnVolver);
        jpContenido.add(jpFondo);
        ActionListener jugar = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                VistaConfiguracion vistaconfiguracion = new VistaConfiguracion();
                dispose();
            }
        };
        
        btnJugar.addActionListener(jugar);
        
        ActionListener instrucciones = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaInicio vistainicio = new VistaInicio() ; 
                dispose();
            }       
        };
        btnVolver.addActionListener(instrucciones);
    }
    }
