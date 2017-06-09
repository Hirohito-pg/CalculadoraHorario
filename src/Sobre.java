import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sobre extends JFrame {
    private JLabel jLabel_Nome;
    private JLabel jLabel_Plataforma;
    private JLabel jLabel_VersaoData;
    private JLabel jLabel_VersaoTexto;
    private JPanel jPanel_Painel;

    public Sobre() {
        initComponents();
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
        } catch (Exception e) {
            Logger.getLogger(Sobre.class.getName()).log(Level.SEVERE, null, e);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sobre().setVisible(true);
            }
        });
    }

    private void initComponents() {
        this.jPanel_Painel = new JPanel();
        this.jLabel_Nome = new JLabel();
        this.jLabel_VersaoTexto = new JLabel();
        this.jLabel_VersaoData = new JLabel();
        this.jLabel_Plataforma = new JLabel();
        setTitle("Sobre");
        setBackground(new Color(255, 255, 255));
        setLocationByPlatform(true);
        setName("Sobre");
        setResizable(false);
        this.jPanel_Painel.setBorder(BorderFactory.createTitledBorder(null, "", 0, 0, new Font("Times New Roman", 1, 14)));
        this.jPanel_Painel.setFont(new Font("Times New Roman", 0, 14));
        this.jLabel_Nome.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_Nome.setText("Hirohito Pereira Gonçalves");
        this.jLabel_Nome.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel_Nome.setMaximumSize(new Dimension(50, 50));
        this.jLabel_Nome.setMinimumSize(new Dimension(50, 50));
        this.jLabel_Nome.setPreferredSize(new Dimension(50, 50));
        this.jLabel_VersaoTexto.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_VersaoTexto.setText("Última versão:");
        this.jLabel_VersaoTexto.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel_VersaoTexto.setMaximumSize(new Dimension(50, 50));
        this.jLabel_VersaoTexto.setMinimumSize(new Dimension(50, 50));
        this.jLabel_VersaoTexto.setPreferredSize(new Dimension(50, 50));
        this.jLabel_VersaoData.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_VersaoData.setText("08/08/2014");
        this.jLabel_VersaoData.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel_VersaoData.setMaximumSize(new Dimension(50, 50));
        this.jLabel_VersaoData.setMinimumSize(new Dimension(50, 50));
        this.jLabel_VersaoData.setPreferredSize(new Dimension(50, 50));
        this.jLabel_Plataforma.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_Plataforma.setText("Plataforma Java");
        this.jLabel_Plataforma.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel_Plataforma.setMaximumSize(new Dimension(50, 50));
        this.jLabel_Plataforma.setMinimumSize(new Dimension(50, 50));
        this.jLabel_Plataforma.setPreferredSize(new Dimension(50, 50));
        GroupLayout jPanel_PainelLayout = new GroupLayout(this.jPanel_Painel);
        this.jPanel_Painel.setLayout(jPanel_PainelLayout);
        jPanel_PainelLayout.setHorizontalGroup(jPanel_PainelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel_PainelLayout.createSequentialGroup().addContainerGap().addGroup(jPanel_PainelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel_Nome, -2, 210, -2).addComponent(this.jLabel_Plataforma, -2, 210, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel_PainelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel_VersaoTexto, -2, 210, -2).addComponent(this.jLabel_VersaoData, -2, 210, -2)).addContainerGap(-1, 32767)));
        jPanel_PainelLayout.setVerticalGroup(jPanel_PainelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel_PainelLayout.createSequentialGroup().addContainerGap().addGroup(jPanel_PainelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel_PainelLayout.createSequentialGroup().addComponent(this.jLabel_VersaoTexto, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel_PainelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel_VersaoData, -2, 30, -2).addComponent(this.jLabel_Plataforma, -2, 30, -2))).addComponent(this.jLabel_Nome, -2, 30, -2)).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel_Painel, -2, -1, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel_Painel, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
        setLocationRelativeTo(null);
    }
}