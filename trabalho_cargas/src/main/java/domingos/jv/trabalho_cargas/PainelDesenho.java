package domingos.jv.trabalho_cargas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PainelDesenho extends JPanel {
    private List<Particula> particulas;
    
    private JFrame mainWindow;

    public PainelDesenho(JFrame mainWindow) {
        this.mainWindow = mainWindow;
        
        particulas = new ArrayList<>();
        
        particulas.add(new Particula(40, 30));
        particulas.add(new Particula(150, 30));
        particulas.add(new Particula(260, 30));
        particulas.add(new Particula(40, 90));
        particulas.add(new Particula(260, 90));
        particulas.add(new Particula(40, 150));
        particulas.add(new Particula(150, 150));
        particulas.add(new Particula(260, 150));
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Point point = e.getPoint();
                for(Particula particula : particulas) {
                    if(particula.getForma().contains(point)) {
                        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    } else 
                        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                Point point = e.getPoint();
                for(Particula particula : particulas) {
                    if(particula.getForma().contains(point)) {
                        try {
                            int carga = Integer.parseInt(JOptionPane.showInputDialog(mainWindow, 
                                                            "Digite o valor da carga", "0"));
                            
                            if(carga < -10 || carga > 10) 
                                JOptionPane.showMessageDialog(mainWindow, 
                                "A carga da partícula deve ter valor máxima de 10 e mínima de -10!", 
                                "Carga grande ou pequena", JOptionPane.INFORMATION_MESSAGE);
                            else {
                                particula.setCarga(carga);
                                repaint();
                            }
                        } catch(NumberFormatException ex) {
                            JOptionPane.showMessageDialog(mainWindow, 
                                    "Digite apenas números inteiros!", 
                                    "Carga Inválida", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
            
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor(Color.CYAN);
        g2.setStroke(new BasicStroke(2));
        g2.drawRect(47, 37, 222, 122);
        
        g2.setColor(Color.MAGENTA);
        g2.setStroke(new BasicStroke(1));
        g2.fillOval(150, 90, 15, 15);
        
        g2.setColor(Color.RED);
        for(Particula particula : particulas) {
            g2.setStroke(new BasicStroke(1));
            if(particula.getCarga() != 0) {
                g2.fill(particula.getForma());
                int[] pos = posLegenda(particula);
                g2.setFont(new Font("Open Sans", Font.BOLD, 14));
                g2.drawString(particula.getCarga() + "e", pos[0], pos[1]);
                
            } else {
                g2.draw(particula.getForma());
            }
        }
    }
    
    private int[] posLegenda(Particula p) {
        int[] pos = new int[2];
        
        if(p.getPosX() == Position.LEFT) {
            pos[0] = p.getPosX().getValor() - 15;
            pos[1] = p.getPosY().getValor();
        } else if(p.getPosX() == Position.RIGHT) {
            pos[0] = p.getPosX().getValor() + 15;
            pos[1] = p.getPosY().getValor();
        } else if(p.getPosY() == Position.TOP) {
            pos[0] = p.getPosX().getValor();
            pos[1] = p.getPosY().getValor() - 5;
        } else if(p.getPosY() == Position.BOTTOM) {
            pos[0] = p.getPosX().getValor();
            pos[1] = p.getPosY().getValor() + 30;
        }
            
        return pos;
    }
    
    public void resetarDesenho() {
        for(Particula p : particulas){
            p.setCarga(0);
            p.resetDistancia();
        }
        repaint();
    }
    
    public void setDistancia(double lado) {
        for(Particula p : particulas) {
            p.setDistancia(lado);
        }
    }
    
    public List<Particula> getParticulas() {
        return particulas;
    }
}
