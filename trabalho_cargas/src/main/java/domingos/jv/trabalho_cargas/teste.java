package domingos.jv.trabalho_cargas;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class teste extends JFrame {
    
    private JPanel p;
    

    public teste() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 300);
        
        p = new Painel();
        add(p);
        
        
        
        setVisible(true);  
    }
    
}
