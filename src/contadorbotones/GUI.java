
package contadorbotones;
import Contador.Contador;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.concurrent.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
class GUI extends JFrame {
        Contador con = new Contador();
        public JLabel cont1;
        public JLabel cont2;
	public JPanel vent;
	public Container contenedor;
	public GUI(){
		contenedor=getContentPane();
                cont1= new JLabel();
                cont2= new JLabel();
		vent=new JPanel(null);
                this.setTitle("Pulsaciones");
		setSize(400,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		conf();
		
	}
	public void conf (){
                //propuedades de la ventana
		vent.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
                vent.setPreferredSize(new Dimension (400, 400));
                vent.setSize(400, 200);
                //botones
                Botones bot=new Botones();
                vent.add(bot.boton1);
                vent.add(bot.boton2);
                vent.add(bot.boton3);
                contenedor.add(vent, BorderLayout.NORTH);
                
               //añexion del jlabel boton1
              
                vent.add(cont1);
                cont1.setText("Presione el boton 1");
                cont1.setBounds(20,100,200,50);
                //anexion del jlabel boton2
                cont2.setText("Presione el boton 2");
                cont2.setBounds(200,100,200,50);
                vent.add(cont2);
                //creacion de oyente
                Oyenteboton1 oBoton1= new Oyenteboton1();
                Oyenteboton2 oBoton2= new Oyenteboton2();
                Oyenteboton3 oBoton3 = new Oyenteboton3();
                //asginar boton al oyente
                bot.boton1.addActionListener((ActionListener)oBoton1);
                bot.boton2.addActionListener((ActionListener)oBoton2);
                bot.boton3.addActionListener((ActionListener)oBoton3);
	}
      public class Oyenteboton1 implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            con.incrementa();
            
            cont1.setText("A pulsado: "+con.getPulsaciones()+" veces el boton 1");

            System.out.println(""+con.getPulsaciones());
            
            
        }
    }

    public class Oyenteboton2 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            con.incrementa1();
            
            cont2.setText("A pulsado: "+con.getpu()+" veces el boton 2");
            
        }
    }
    public class Oyenteboton3 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            con.reinicio();
            cont1.setText("Precione el boton 1");
            cont2.setText("Precione el boton 2");
            
        }
    }
     
     
        
}
