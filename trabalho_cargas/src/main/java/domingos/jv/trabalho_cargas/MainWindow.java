package domingos.jv.trabalho_cargas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame {
    private JPanel painelNorte;
    private JPanel painelCentro;
    private JPanel painelCentroEsq;
    private JPanel painelCentroC;
    private JPanel painelCentroSul;
    private JPanel painelSul;
    private JPanel painelLado;
    private JPanel painelRadio;
    // Painel Personalizado
    
    private JLabel titulo;
    
    //private JLabel labelDescricao;
    private JTextArea labelDescricao;
    private JLabel labelLado;
    private JLabel labelUnidade;
    private JLabel labelResultado;
    
    private JTextField inputLado;
    
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
        //labelDescricao.setBackground(null);
        labelDescricao.setEditable(false);
        labelDescricao.setFont(fonteLabels);
        labelDescricao.setMinimumSize(new Dimension(300, 60));
        labelDescricao.setPreferredSize(new Dimension(370, 60));
        labelDescricao.setMaximumSize(new Dimension(400, 60));
        // Quebra de linha
        // Painel Desenho
        painelCentroEsq.add(labelDescricao);
        painelCentroEsq.add(Box.createVerticalStrut(10));
        // Adição Painel Desenho
        JPanel p = new JPanel();
        p.setBackground(Color.PINK);
        p.add(new JLabel("Painel Desenho"));
        painelCentroEsq.add(p);
        
        painelCentroC = new JPanel();
        painelCentroC.setLayout(new BoxLayout(painelCentroC, BoxLayout.Y_AXIS));
        //painelCentroC.setBackground(Color.BLUE);
        painelCentroC.setBorder(new EmptyBorder(80, 0, 0, 0));
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
        
        painelLado.add(labelLado);
        painelLado.add(inputLado);
        painelCentroC.add(painelLado);
        
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
        
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
}
