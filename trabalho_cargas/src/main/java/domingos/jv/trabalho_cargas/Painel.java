package domingos.jv.trabalho_cargas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Painel extends JPanel {
    
    public Ellipse2D.Float forma;

    public Painel() {
        forma = new Ellipse2D.Float(100, 50, 20, 20);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();
                
                if(forma.contains(p)) {
                    JOptionPane.showMessageDialog(null, "Clicou na partícula");
                }
            }
            
        });
        
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                 Point p = e.getPoint();
                 if(forma.contains(p)) {
                     setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                 } else {
                     setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                 }
            }
            
        });
    }
    
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        g2.fill(forma);
    }
}
