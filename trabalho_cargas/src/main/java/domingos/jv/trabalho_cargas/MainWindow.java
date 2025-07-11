package domingos.jv.trabalho_cargas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame {
    // Componentes Gráficos
    private JPanel painelNorte;
    private JPanel painelCentro;
    private JPanel painelCentroEsq;
    private JPanel painelCentroC;
    private JPanel painelCentroSul;
    private JPanel painelSul;
    private JPanel painelLado;
    private JPanel painelCarga;
    private JPanel painelRadio;
    private PainelDesenho painelDesenho;
    
    private JLabel titulo;
    
    //private JLabel labelDescricao;
    private JTextArea labelDescricao;
    private JLabel labelLado;
    private JLabel labelCarga;
    private JLabel labelUnidade;
    private JLabel labelResultado;
    
    private JTextField inputLado;
    private JTextField inputCarga;
    
    private ButtonGroup radioGroup;
    private JRadioButton radioCentimetro;
    private JRadioButton radioMetro;
    
    private JButton btnCalcular;
    private JButton btnResetar;
    
    private Font fonteTitulo;
    private Font fonteLabels;
    private Font fonteRadio;
    private Font fonteBtn;
    private Font fonteRes;
    
    // Variáveis de Entrada
    private double lado;
    private int carga;
    private String unidadeMed;
    
    // Constantes
    private final double CONSTANTE = -9e9;
    private final double CARGA_ELEMENTAR = 1.6e-19;
    
    private List<Particula> particulas;

    public MainWindow() {
        super("Trabalho de Cargas");
        
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        
        fonteTitulo = new Font("Space Grotesk", Font.PLAIN, 36);
        fonteLabels = new Font("Open Sans", Font.PLAIN, 20);
        fonteRadio = new Font("Open Sans", Font.PLAIN, 16);
        fonteBtn = new Font("Open Sans", Font.PLAIN, 18);
        fonteRes = new Font("Open Sans", Font.BOLD, 20);
        
        // Região norte - Titulo
        painelNorte = new JPanel();
        painelNorte.setBorder(new EmptyBorder(20, 0, 20, 0));
        add(painelNorte, BorderLayout.NORTH);
        
        titulo = new JLabel("Trabalho de Cargas");
        titulo.setFont(fonteTitulo);
        painelNorte.add(titulo);
        
        // Região Central - Entrada de dados e Botões
        painelCentro = new JPanel();
        painelCentro.setLayout(new BorderLayout(20, 20));
        painelCentro.setBorder(new EmptyBorder(0, 40, 0, 0));
        //painelCentro.setBackground(Color.red);
        add(painelCentro, BorderLayout.CENTER);
        
        painelCentroEsq = new JPanel();
        painelCentroEsq.setLayout(new BoxLayout(painelCentroEsq, BoxLayout.Y_AXIS));
        painelCentroEsq.setMinimumSize(new Dimension(300, 300));
        painelCentroEsq.setPreferredSize(new Dimension(370, 300));
        painelCentroEsq.setMaximumSize(new Dimension(400, 300));
        //painelCentroEsq.setBorder(new EmptyBorder(0, 40, 20, 20));
        //painelCentroEsq.setBackground(Color.YELLOW);
        painelCentro.add(painelCentroEsq, BorderLayout.WEST);
        
        //labelDescricao = new JLabel("Clique em cada partícula para adicionar a carga.");
        //labelDescricao.setFont(fonteLabels);
        labelDescricao = new JTextArea("Clique em cada partícula para\nadicionar a carga.");
        //labelDescricao.setBackground(Color.LIGHT_GRAY);
        labelDescricao.setEditable(false);
        labelDescricao.setFont(fonteLabels);
        labelDescricao.setMinimumSize(new Dimension(300, 60));
        labelDescricao.setPreferredSize(new Dimension(370, 60));
        labelDescricao.setMaximumSize(new Dimension(400, 60));
        // Quebra de linha
        // Painel Desenho
        painelCentroEsq.add(labelDescricao);
        painelCentroEsq.add(Box.createVerticalStrut(10));
        painelDesenho = new PainelDesenho(this);
        painelCentroEsq.add(painelDesenho);
        /*
        JPanel p = new JPanel();
        p.setBackground(Color.PINK);
        p.add(new JLabel("Painel Desenho"));
        painelCentroEsq.add(p);
        */
        
        painelCentroC = new JPanel();
        painelCentroC.setLayout(new BoxLayout(painelCentroC, BoxLayout.Y_AXIS));
        //painelCentroC.setBackground(Color.BLUE);
        painelCentroC.setBorder(new EmptyBorder(60, 0, 0, 0));
        painelCentro.add(painelCentroC, BorderLayout.CENTER);
        
        painelLado = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 20));
        painelLado.setMinimumSize(new Dimension(360, 50));
        painelLado.setPreferredSize(new Dimension(450, 70));
        painelLado.setMaximumSize(new Dimension(420, 80));
        
        labelLado = new JLabel("Lado do Quadrado: ");
        labelLado.setFont(fonteLabels);
        labelLado.setLabelFor(inputLado);
        inputLado = new JTextField(5);
        inputLado.setFont(fonteRadio);
        inputLado.setText("4");
        
        painelLado.add(labelLado);
        painelLado.add(inputLado);
        painelCentroC.add(painelLado);
        
        painelCarga = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 20));
        painelCarga.setMinimumSize(new Dimension(360, 50));
        painelCarga.setPreferredSize(new Dimension(450, 70));
        painelCarga.setMaximumSize(new Dimension(420, 80));
        
        labelCarga = new JLabel("Carga da partícula alvo: ");
        labelCarga.setFont(fonteLabels);
        labelCarga.setLabelFor(inputLado);
        inputCarga = new JTextField(5);
        inputCarga.setFont(fonteRadio);
        inputCarga.setText("6");
        
        painelCarga.add(labelCarga);
        painelCarga.add(inputCarga);
        painelCentroC.add(painelCarga);
        
        painelRadio = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 20));
        painelRadio.setMinimumSize(new Dimension(360, 50));
        painelRadio.setPreferredSize(new Dimension(450, 70));
        painelRadio.setMaximumSize(new Dimension(420, 80));
        
        labelUnidade = new JLabel("Unidade de Medida: ");
        labelUnidade.setFont(fonteLabels);
        
        radioGroup = new ButtonGroup();
        radioCentimetro = new JRadioButton("Centímetro");
        radioCentimetro.setFont(fonteRadio);
        radioCentimetro.setSelected(true);
        radioMetro = new JRadioButton("Metro");
        radioMetro.setFont(fonteRadio);
        radioGroup.add(radioCentimetro);
        radioGroup.add(radioMetro);
        
        painelRadio.add(labelUnidade);
        painelRadio.add(radioCentimetro);
        painelRadio.add(radioMetro);
        painelCentroC.add(painelRadio);
        
        painelCentroSul = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        //painelCentroDir.setBorder(new EmptyBorder(0, 20, 20, 40));
        //painelCentroSul.setBackground(Color.MAGENTA);
        painelCentro.add(painelCentroSul, BorderLayout.SOUTH);
        
        btnCalcular = new JButton("Calcular");
        btnCalcular.setFont(fonteBtn);
        btnResetar = new JButton("Resetar");
        btnResetar.setFont(fonteBtn);
        painelCentroSul.add(btnCalcular);
        painelCentroSul.add(btnResetar);
        
        // Região Sul
        painelSul = new JPanel();
        painelSul.setLayout(new FlowLayout(FlowLayout.CENTER));
        painelSul.setBorder(new EmptyBorder(60, 20, 30, 20));
        //painelSul.setBackground(Color.CYAN);
        add(painelSul, BorderLayout.SOUTH);
        
        labelResultado = new JLabel("Resultado: ");
        labelResultado.setFont(fonteRes);
        painelSul.add(labelResultado);
        
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calcular
                if(inputCarga.getText().isEmpty() || inputLado.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, 
                            "Preencha o Lado e a Carga da partícula alvo!", 
                            "Faltando Valores", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    if(checarEntradas()) {
                        painelDesenho.setDistancia(lado);
                        particulas = painelDesenho.getParticulas();
                        calcular();
                    }
                }
            }
        });
        
        btnResetar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Resetar
                inputLado.setText("4");
                inputCarga.setText("6");
                radioMetro.setSelected(false);
                radioCentimetro.setSelected(true);
                labelResultado.setText("Resultado:");
                painelDesenho.resetarDesenho();
            }
        });
        
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private boolean checarEntradas() {
        try {
            lado = Double.parseDouble(inputLado.getText());
            carga = Integer.parseInt(inputCarga.getText());
            
            if(lado <= 0) {
                JOptionPane.showMessageDialog(MainWindow.this, 
                    "Digite um número positivo!", 
                    "Lado inválido", JOptionPane.ERROR_MESSAGE);
                return false;
            } else if((radioCentimetro.isSelected() && lado > 20.0) ||
                        (radioMetro.isSelected() && lado > 10.0)) {
                JOptionPane.showMessageDialog(MainWindow.this, 
                    "Lado máximo de 20 centímetros e, de 10 metros!", 
                    "Lado muito grande.", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
            else {
                if(carga < -10 || carga > 10) {
                    JOptionPane.showMessageDialog(MainWindow.this, 
                    "A carga da partícula deve ter valor máxima de 10 e mínima de -10!", 
                    "Carga grande ou pequena", JOptionPane.INFORMATION_MESSAGE);
                    return false;
                }
                else {
                    return true;
                }
            }
            
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(MainWindow.this, 
                    "Digite um número positivo para o lado!\n"
                            + "Digite um número inteiro para a carga!", 
                    "Entrada inválida", JOptionPane.ERROR_MESSAGE);
        }
        
        return false;
    }
    
    private void calcular() {
        JOptionPane.showMessageDialog(rootPane, "Constante: " + CONSTANTE);
        
        double res = 0.0;
        
        for(Particula p : particulas) {
            res += carga * p.getCarga() / p.getDistancia();
        }
        
        res *= CONSTANTE * Math.pow(CARGA_ELEMENTAR, 2);
        
        labelResultado.setText("É necessário um trabalho de " + res + 
                "J para deslocar a particula alvo para o centro do quadrado");
    }
}
