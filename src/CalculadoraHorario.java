import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public final class CalculadoraHorario extends JFrame {
    private Sobre sobre = new Sobre();
    private String horas_painel = "";
    private String operacao = "";
    private String primeiro_horario = "";
    private String resultado = "";
    private JButton jButton_0;
    private JButton jButton_1;
    private JButton jButton_2;
    private JButton jButton_3;
    private JButton jButton_4;
    private JButton jButton_5;
    private JButton jButton_6;
    private JButton jButton_7;
    private JButton jButton_8;
    private JButton jButton_9;
    private JButton jButton_Adicao;
    private JButton jButton_BSP;
    private JButton jButton_CE;
    private JButton jButton_Igual;
    private JButton jButton_Subtracao;
    private JLabel jLabel_Painel;
    private JMenuBar jMenuBar_Principal;
    private JMenuItem jMenuItem_Colar;
    private JMenuItem jMenuItem_ConverterHoras;
    private JMenuItem jMenuItem_ConverterMinutos;
    private JMenuItem jMenuItem_ConverterSegundos;
    private JMenuItem jMenuItem_Copiar;
    private JMenuItem jMenuItem_HoraAtual;
    private JMenu jMenu_Converter;
    private JMenu jMenu_Editar;
    private JMenu jMenu_Sair;
    private JMenu jMenu_Sobre;
    private JPanel jPanel_Principal;
    private JTextField jTextField_Painel;

    public CalculadoraHorario() {
        initComponents();
        getjTextField_Painel().addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                CalculadoraHorario.this.pegarApenasCharAceito(Character.valueOf(e.getKeyChar()), e);
            }

            public void keyPressed(KeyEvent e) {
                if (((e.getKeyCode() == 8) || (e.getKeyCode() == 127)) && (CalculadoraHorario.this.getjTextField_Painel().getCaretPosition() != CalculadoraHorario.this.getjTextField_Painel().getText().length()))
                    e.consume();
            }

            public void keyReleased(KeyEvent e) {
            }
        });
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
        } catch (Exception e) {
            Logger.getLogger(CalculadoraHorario.class.getName()).log(Level.SEVERE, null, e);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraHorario().setVisible(true);
            }
        });
    }

    public void pegarApenasCharAceito(Character caractere, KeyEvent e) {
        if (getjTextField_Painel().getCaretPosition() == getjTextField_Painel().getText().length()) {
            if (Character.isDigit(caractere.charValue())) {
                int digito = Integer.parseInt(caractere.toString().trim());
                if (getjTextField_Painel().getText().length() == 0) {
                    if ((digito != 0) && (digito != 1) && (digito != 2) && (digito != 3) && (digito != 4) && (digito != 5) && (digito != 6) && (digito != 7) && (digito != 8) && (digito != 9)) {
                        if (e != null) {
                            e.consume();
                        }
                    } else if ((digito == 0) || (digito == 1) || (digito == 2)) {
                        if (e == null) {
                            getjTextField_Painel().setText(getjTextField_Painel().getText() + digito);
                        }
                    } else if (e == null)
                        getjTextField_Painel().setText(getjTextField_Painel().getText() + "0" + digito);
                    else {
                        getjTextField_Painel().setText("0" + getjTextField_Painel().getText());
                    }
                } else if (getjTextField_Painel().getText().length() == 1) {
                    double valor = Double.parseDouble(getjTextField_Painel().getText() + digito);
                    if ((valor > 23.0D) || (valor < 0.0D)) {
                        if (e != null) {
                            e.consume();
                        }
                    } else if (e == null) {
                        getjTextField_Painel().setText(getjTextField_Painel().getText() + digito);
                    }
                } else if (getjTextField_Painel().getText().length() == 2) {
                    if ((digito != 0) && (digito != 1) && (digito != 2) && (digito != 3) && (digito != 4) && (digito != 5)) {
                        if (e != null) e.consume();
                    } else {
                        getjTextField_Painel().setText(getjTextField_Painel().getText() + ":");
                        if (e == null) getjTextField_Painel().setText(getjTextField_Painel().getText() + digito);
                    }
                } else if (getjTextField_Painel().getText().length() == 4) {
                    if ((digito != 0) && (digito != 1) && (digito != 2) && (digito != 3) && (digito != 4) && (digito != 5) && (digito != 6) && (digito != 7) && (digito != 8) && (digito != 9)) {
                        if (e != null) {
                            e.consume();
                        }
                    } else if (e == null) {
                        getjTextField_Painel().setText(getjTextField_Painel().getText() + digito);
                    }
                } else if (getjTextField_Painel().getText().length() == 5) {
                    if ((digito != 0) && (digito != 1) && (digito != 2) && (digito != 3) && (digito != 4) && (digito != 5)) {
                        if (e != null) e.consume();
                    } else {
                        getjTextField_Painel().setText(getjTextField_Painel().getText() + ":");
                        if (e == null) getjTextField_Painel().setText(getjTextField_Painel().getText() + digito);
                    }
                } else if (getjTextField_Painel().getText().length() == 7) {
                    if ((digito != 0) && (digito != 1) && (digito != 2) && (digito != 3) && (digito != 4) && (digito != 5) && (digito != 6) && (digito != 7) && (digito != 8) && (digito != 9)) {
                        if (e != null) {
                            e.consume();
                        }
                    } else if (e == null) {
                        getjTextField_Painel().setText(getjTextField_Painel().getText() + digito);
                    }
                } else if (e != null) {
                    e.consume();
                }
            } else if (!"".equals(getjTextField_Painel().getText())) {
                String ultimo_char = getjTextField_Painel().getText().trim().substring(getjTextField_Painel().getText().trim().length() - 1, getjTextField_Painel().getText().trim().length());
                if (":".equals(ultimo_char)) {
                    getjTextField_Painel().setText(getjTextField_Painel().getText().trim().substring(0, getjTextField_Painel().getText().trim().length() - 1));
                } else if (e != null) {
                    e.consume();
                }
            } else if (e != null) {
                e.consume();
            }
        } else if (e != null) e.consume();
    }

    public String validarETransformarValor(String valor) {
        String retorno = "";
        if (!"".equals(valor.trim())) {
            String[] array = valor.split(Pattern.quote(":"));
            if (array.length == 1) {
                if ((array[0].length() > 0) && (array[0].length() < 3)) {
                    if (array[0].length() == 1) retorno = "0" + array[0] + ":00:00";
                    else retorno = array[0] + ":00:00";
                } else retorno = "00:00:00";
            } else if (array.length == 2) {
                if ((array[1].length() > 0) && (array[1].length() < 3)) {
                    if (array[1].length() == 1) retorno = array[0] + ":0" + array[1] + ":00";
                    else retorno = array[0] + ":" + array[1] + ":00";
                } else retorno = "00:00:00";
            } else {
                if (array[0].length() == 1) {
                    array[0] = ("0" + array[0]);
                }
                if (array[1].length() == 1) {
                    array[1] = ("0" + array[1]);
                }
                if ((array[2].length() > 0) && (array[2].length() < 3)) {
                    if (array[2].length() == 1) retorno = array[0] + ":" + array[1] + ":0" + array[2];
                    else retorno = array[0] + ":" + array[1] + ":" + array[2];
                } else retorno = "00:00:00";
            }
        } else {
            retorno = "00:00:00";
        }
        return retorno;
    }

    public void pegarOperador(String caractere) {
        if ("".equals(getPrimeiro_horario())) {
            if ("".equals(getResultado())) {
                setPrimeiro_horario(validarETransformarValor(getjTextField_Painel().getText()));
                setOperacao(caractere);
                getjLabel_Painel().setText(getPrimeiro_horario() + " " + getOperacao());
                getjTextField_Painel().setText("");
            } else if (!"".equals(getOperacao())) {
                setPrimeiro_horario(getResultado());
                setOperacao(caractere);
                getjLabel_Painel().setText(getPrimeiro_horario() + " " + getOperacao());
                getjTextField_Painel().setText("");
            } else if ("".equals(getjTextField_Painel().getText())) {
                setPrimeiro_horario(getResultado());
                setOperacao(caractere);
                getjLabel_Painel().setText(getPrimeiro_horario() + " " + getOperacao());
                getjTextField_Painel().setText("");
            } else {
                setPrimeiro_horario(validarETransformarValor(getjTextField_Painel().getText()));
                setOperacao(caractere);
                getjLabel_Painel().setText(getPrimeiro_horario() + " " + getOperacao());
                getjTextField_Painel().setText("");
            }
        } else if (!"".equals(getPrimeiro_horario())) {
            setPrimeiro_horario(calculoHorarios(getOperacao(), getPrimeiro_horario(), validarETransformarValor(getjTextField_Painel().getText())));
            setOperacao(caractere);
            setResultado("");
            getjLabel_Painel().setText(getPrimeiro_horario() + " " + getOperacao());
            getjTextField_Painel().setText("");
        }
    }

    public String calculoHorarios(String operador, String valor01, String valor02) {
        String[] array_valor01 = valor01.split(Pattern.quote(":"));
        String[] array_valor02 = valor02.split(Pattern.quote(":"));
        int segundos = 0;
        int minutos = 0;
        int horas = 0;
        if ("+".equals(operador)) {
            int soma_segundos = Integer.parseInt(array_valor01[2]) + Integer.parseInt(array_valor02[2]);
            if (soma_segundos - 60 > 0) {
                segundos += soma_segundos - 60;
                minutos += 1;
            } else {
                segundos += soma_segundos;
            }
            int soma_minutos = Integer.parseInt(array_valor01[1]) + Integer.parseInt(array_valor02[1]);
            if (soma_minutos - 60 > 0) {
                minutos += soma_minutos - 60;
                horas += 1;
            } else {
                minutos += soma_minutos;
            }
            int soma_horas = Integer.parseInt(array_valor01[0]) + Integer.parseInt(array_valor02[0]) + horas;
            if (soma_horas - 24 > 0) horas = soma_horas - 24;
            else horas = soma_horas;
        } else {
            int subtracao_segundos = Integer.parseInt(array_valor01[2]) - Integer.parseInt(array_valor02[2]);
            if (subtracao_segundos + 60 < 60) {
                segundos += subtracao_segundos + 60;
                minutos += -1;
            } else {
                segundos += subtracao_segundos;
            }
            int subtracao_minutos = Integer.parseInt(array_valor01[1]) - Integer.parseInt(array_valor02[1]);
            if (subtracao_minutos + 60 < 60) {
                minutos += subtracao_minutos + 60;
                horas += -1;
            } else {
                minutos += subtracao_minutos;
            }
            int subtracao_horas = Integer.parseInt(array_valor01[0]) - Integer.parseInt(array_valor02[0]) + horas;
            if (subtracao_horas + 24 < 24) horas = subtracao_horas + 24;
            else {
                horas = subtracao_horas;
            }
        }
        return validarETransformarValor(horas + ":" + minutos + ":" + segundos);
    }

    public String transformarValorCasasDecimais(float valor, int qtd_decimais) {
        BigDecimal valor_big_decimal = new BigDecimal(valor);
        valor_big_decimal = valor_big_decimal.setScale(qtd_decimais, RoundingMode.HALF_EVEN);
        if ("0".equals(("" + valor_big_decimal.floatValue()).split(Pattern.quote("."))[1])) {
            return String.valueOf(valor_big_decimal.intValue());
        }
        return String.valueOf(valor_big_decimal.floatValue());
    }

    private void initComponents() {
        this.jPanel_Principal = new JPanel();
        this.jButton_BSP = new JButton();
        this.jButton_CE = new JButton();
        this.jButton_Igual = new JButton();
        this.jButton_Adicao = new JButton();
        this.jButton_2 = new JButton();
        this.jButton_3 = new JButton();
        this.jButton_8 = new JButton();
        this.jButton_6 = new JButton();
        this.jButton_0 = new JButton();
        this.jButton_7 = new JButton();
        this.jButton_5 = new JButton();
        this.jButton_1 = new JButton();
        this.jButton_4 = new JButton();
        this.jButton_9 = new JButton();
        this.jLabel_Painel = new JLabel();
        this.jTextField_Painel = new JTextField();
        this.jButton_Subtracao = new JButton();
        this.jMenuBar_Principal = new JMenuBar();
        this.jMenu_Editar = new JMenu();
        this.jMenuItem_Copiar = new JMenuItem();
        this.jMenuItem_Colar = new JMenuItem();
        this.jMenuItem_HoraAtual = new JMenuItem();
        this.jMenu_Converter = new JMenu();
        this.jMenuItem_ConverterHoras = new JMenuItem();
        this.jMenuItem_ConverterMinutos = new JMenuItem();
        this.jMenuItem_ConverterSegundos = new JMenuItem();
        this.jMenu_Sobre = new JMenu();
        this.jMenu_Sair = new JMenu();
        setDefaultCloseOperation(3);
        setTitle("Calculadora de Horário");
        setResizable(false);
        this.jButton_BSP.setBackground(new Color(255, 255, 255));
        this.jButton_BSP.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_BSP.setText("BSP");
        this.jButton_BSP.setToolTipText("Apagar último caractere");
        this.jButton_BSP.setCursor(new Cursor(0));
        this.jButton_BSP.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_BSP.setMaximumSize(new Dimension(50, 50));
        this.jButton_BSP.setMinimumSize(new Dimension(50, 50));
        this.jButton_BSP.setPreferredSize(new Dimension(100, 50));
        this.jButton_BSP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculadoraHorario.this.jButton_BSPActionPerformed(evt);
            }
        });
        this.jButton_CE.setBackground(new Color(255, 255, 255));
        this.jButton_CE.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_CE.setText("CE");
        this.jButton_CE.setToolTipText("Limpar tudo");
        this.jButton_CE.setCursor(new Cursor(0));
        this.jButton_CE.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_CE.setMaximumSize(new Dimension(50, 50));
        this.jButton_CE.setMinimumSize(new Dimension(50, 50));
        this.jButton_CE.setPreferredSize(new Dimension(100, 50));
        this.jButton_CE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculadoraHorario.this.jButton_CEActionPerformed(evt);
            }
        });
        this.jButton_Igual.setBackground(new Color(255, 255, 255));
        this.jButton_Igual.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_Igual.setText("=");
        this.jButton_Igual.setToolTipText("Igual");
        this.jButton_Igual.setCursor(new Cursor(0));
        this.jButton_Igual.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_Igual.setMaximumSize(new Dimension(50, 50));
        this.jButton_Igual.setMinimumSize(new Dimension(50, 50));
        this.jButton_Igual.setPreferredSize(new Dimension(100, 50));
        this.jButton_Igual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculadoraHorario.this.jButton_IgualActionPerformed(evt);
            }
        });
        this.jButton_Adicao.setBackground(new Color(255, 255, 255));
        this.jButton_Adicao.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_Adicao.setText("+");
        this.jButton_Adicao.setToolTipText("Somar");
        this.jButton_Adicao.setCursor(new Cursor(0));
        this.jButton_Adicao.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_Adicao.setMaximumSize(new Dimension(50, 50));
        this.jButton_Adicao.setMinimumSize(new Dimension(50, 50));
        this.jButton_Adicao.setPreferredSize(new Dimension(100, 50));
        this.jButton_Adicao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculadoraHorario.this.jButton_AdicaoActionPerformed(evt);
            }
        });
        this.jButton_2.setBackground(new Color(255, 255, 255));
        this.jButton_2.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_2.setText("2");
        this.jButton_2.setToolTipText("2");
        this.jButton_2.setCursor(new Cursor(0));
        this.jButton_2.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_2.setMaximumSize(new Dimension(50, 50));
        this.jButton_2.setMinimumSize(new Dimension(50, 50));
        this.jButton_2.setPreferredSize(new Dimension(100, 50));
        this.jButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculadoraHorario.this.jButton_2ActionPerformed(evt);
            }
        });
        this.jButton_3.setBackground(new Color(255, 255, 255));
        this.jButton_3.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_3.setText("3");
        this.jButton_3.setToolTipText("3");
        this.jButton_3.setCursor(new Cursor(0));
        this.jButton_3.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_3.setMaximumSize(new Dimension(50, 50));
        this.jButton_3.setMinimumSize(new Dimension(50, 50));
        this.jButton_3.setPreferredSize(new Dimension(100, 50));
        this.jButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculadoraHorario.this.jButton_3ActionPerformed(evt);
            }
        });
        this.jButton_8.setBackground(new Color(255, 255, 255));
        this.jButton_8.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_8.setText("8");
        this.jButton_8.setToolTipText("8");
        this.jButton_8.setCursor(new Cursor(0));
        this.jButton_8.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_8.setMaximumSize(new Dimension(50, 50));
        this.jButton_8.setMinimumSize(new Dimension(50, 50));
        this.jButton_8.setPreferredSize(new Dimension(100, 50));
        this.jButton_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculadoraHorario.this.jButton_8ActionPerformed(evt);
            }
        });
        this.jButton_6.setBackground(new Color(255, 255, 255));
        this.jButton_6.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_6.setText("6");
        this.jButton_6.setToolTipText("6");
        this.jButton_6.setCursor(new Cursor(0));
        this.jButton_6.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_6.setMaximumSize(new Dimension(50, 50));
        this.jButton_6.setMinimumSize(new Dimension(50, 50));
        this.jButton_6.setPreferredSize(new Dimension(100, 50));
        this.jButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculadoraHorario.this.jButton_6ActionPerformed(evt);
            }
        });
        this.jButton_0.setBackground(new Color(255, 255, 255));
        this.jButton_0.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_0.setText("0");
        this.jButton_0.setToolTipText("0");
        this.jButton_0.setCursor(new Cursor(0));
        this.jButton_0.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_0.setMaximumSize(new Dimension(50, 50));
        this.jButton_0.setMinimumSize(new Dimension(50, 50));
        this.jButton_0.setPreferredSize(new Dimension(100, 50));
        this.jButton_0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculadoraHorario.this.jButton_0ActionPerformed(evt);
            }
        });
        this.jButton_7.setBackground(new Color(255, 255, 255));
        this.jButton_7.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_7.setText("7");
        this.jButton_7.setToolTipText("7");
        this.jButton_7.setCursor(new Cursor(0));
        this.jButton_7.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_7.setMaximumSize(new Dimension(50, 50));
        this.jButton_7.setMinimumSize(new Dimension(50, 50));
        this.jButton_7.setPreferredSize(new Dimension(100, 50));
        this.jButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculadoraHorario.this.jButton_7ActionPerformed(evt);
            }
        });
        this.jButton_5.setBackground(new Color(255, 255, 255));
        this.jButton_5.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_5.setText("5");
        this.jButton_5.setToolTipText("5");
        this.jButton_5.setCursor(new Cursor(0));
        this.jButton_5.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_5.setMaximumSize(new Dimension(50, 50));
        this.jButton_5.setMinimumSize(new Dimension(50, 50));
        this.jButton_5.setPreferredSize(new Dimension(100, 50));
        this.jButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculadoraHorario.this.jButton_5ActionPerformed(evt);
            }
        });
        this.jButton_1.setBackground(new Color(255, 255, 255));
        this.jButton_1.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_1.setText("1");
        this.jButton_1.setToolTipText("1");
        this.jButton_1.setCursor(new Cursor(0));
        this.jButton_1.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_1.setMaximumSize(new Dimension(50, 50));
        this.jButton_1.setMinimumSize(new Dimension(50, 50));
        this.jButton_1.setPreferredSize(new Dimension(100, 50));
        this.jButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculadoraHorario.this.jButton_1ActionPerformed(evt);
            }
        });
        this.jButton_4.setBackground(new Color(255, 255, 255));
        this.jButton_4.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_4.setText("4");
        this.jButton_4.setToolTipText("4");
        this.jButton_4.setCursor(new Cursor(0));
        this.jButton_4.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_4.setMaximumSize(new Dimension(50, 50));
        this.jButton_4.setMinimumSize(new Dimension(50, 50));
        this.jButton_4.setPreferredSize(new Dimension(100, 50));
        this.jButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculadoraHorario.this.jButton_4ActionPerformed(evt);
            }
        });
        this.jButton_9.setBackground(new Color(255, 255, 255));
        this.jButton_9.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_9.setText("9");
        this.jButton_9.setToolTipText("9");
        this.jButton_9.setCursor(new Cursor(0));
        this.jButton_9.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_9.setMaximumSize(new Dimension(50, 50));
        this.jButton_9.setMinimumSize(new Dimension(50, 50));
        this.jButton_9.setPreferredSize(new Dimension(100, 50));
        this.jButton_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculadoraHorario.this.jButton_9ActionPerformed(evt);
            }
        });
        this.jLabel_Painel.setFont(new Font("Times New Roman", 1, 36));
        this.jLabel_Painel.setHorizontalAlignment(0);
        this.jTextField_Painel.setFont(new Font("Times New Roman", 0, 48));
        this.jTextField_Painel.setHorizontalAlignment(4);
        this.jTextField_Painel.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent evt) {
                CalculadoraHorario.this.jTextField_PainelCaretUpdate(evt);
            }
        });
        this.jButton_Subtracao.setBackground(new Color(255, 255, 255));
        this.jButton_Subtracao.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_Subtracao.setText("-");
        this.jButton_Subtracao.setToolTipText("Subtrair");
        this.jButton_Subtracao.setCursor(new Cursor(0));
        this.jButton_Subtracao.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_Subtracao.setMaximumSize(new Dimension(50, 50));
        this.jButton_Subtracao.setMinimumSize(new Dimension(50, 50));
        this.jButton_Subtracao.setPreferredSize(new Dimension(100, 50));
        this.jButton_Subtracao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculadoraHorario.this.jButton_SubtracaoActionPerformed(evt);
            }
        });
        GroupLayout jPanel_PrincipalLayout = new GroupLayout(this.jPanel_Principal);
        this.jPanel_Principal.setLayout(jPanel_PrincipalLayout);
        jPanel_PrincipalLayout.setHorizontalGroup(jPanel_PrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel_PrincipalLayout.createSequentialGroup().addContainerGap().addGroup(jPanel_PrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel_PrincipalLayout.createSequentialGroup().addGroup(jPanel_PrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel_PrincipalLayout.createSequentialGroup().addGroup(jPanel_PrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jButton_BSP, -1, -1, 32767).addComponent(this.jButton_1, -1, -1, 32767)).addGroup(jPanel_PrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel_PrincipalLayout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jButton_CE, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton_0, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton_Adicao, -2, -1, -2)).addGroup(jPanel_PrincipalLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton_2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton_3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton_Subtracao, -2, 100, -2)))).addGroup(jPanel_PrincipalLayout.createSequentialGroup().addGroup(jPanel_PrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jButton_7, -1, -1, 32767).addComponent(this.jButton_4, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel_PrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jButton_8, -1, -1, 32767).addComponent(this.jButton_5, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel_PrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jButton_6, -1, -1, 32767).addComponent(this.jButton_9, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton_Igual, -2, -1, -2))).addContainerGap(-1, 32767)).addGroup(jPanel_PrincipalLayout.createSequentialGroup().addGroup(jPanel_PrincipalLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel_Painel, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jTextField_Painel, -1, 417, 32767)).addGap(0, 0, 32767)))));
        jPanel_PrincipalLayout.setVerticalGroup(jPanel_PrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel_PrincipalLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel_Painel, -2, 45, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextField_Painel, -2, 74, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel_PrincipalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton_BSP, -1, -1, 32767).addComponent(this.jButton_CE, -1, -1, 32767).addComponent(this.jButton_0, -2, -1, -2).addComponent(this.jButton_Adicao, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel_PrincipalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton_2, -1, -1, 32767).addComponent(this.jButton_1, -1, -1, 32767).addComponent(this.jButton_3, -1, -1, 32767).addComponent(this.jButton_Subtracao, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel_PrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel_PrincipalLayout.createSequentialGroup().addGroup(jPanel_PrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButton_4, -2, 50, -2).addGroup(jPanel_PrincipalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton_5, -1, -1, 32767).addComponent(this.jButton_6, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel_PrincipalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton_8, -1, -1, 32767).addComponent(this.jButton_7, -1, -1, 32767).addComponent(this.jButton_9, -1, -1, 32767))).addComponent(this.jButton_Igual, -1, -1, 32767)).addContainerGap()));
        this.jMenu_Editar.setText("Editar");
        this.jMenuItem_Copiar.setText("Copiar");
        this.jMenuItem_Copiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculadoraHorario.this.jMenuItem_CopiarActionPerformed(evt);
            }
        });
        this.jMenu_Editar.add(this.jMenuItem_Copiar);
        this.jMenuItem_Colar.setText("Colar");
        this.jMenuItem_Colar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculadoraHorario.this.jMenuItem_ColarActionPerformed(evt);
            }
        });
        this.jMenu_Editar.add(this.jMenuItem_Colar);
        this.jMenuItem_HoraAtual.setText("Hora Atual");
        this.jMenuItem_HoraAtual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculadoraHorario.this.jMenuItem_HoraAtualActionPerformed(evt);
            }
        });
        this.jMenu_Editar.add(this.jMenuItem_HoraAtual);
        this.jMenuBar_Principal.add(this.jMenu_Editar);
        this.jMenu_Converter.setText("Converter");
        this.jMenuItem_ConverterHoras.setText("Horas");
        this.jMenuItem_ConverterHoras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculadoraHorario.this.jMenuItem_ConverterHorasActionPerformed(evt);
            }
        });
        this.jMenu_Converter.add(this.jMenuItem_ConverterHoras);
        this.jMenuItem_ConverterMinutos.setText("Minutos");
        this.jMenuItem_ConverterMinutos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculadoraHorario.this.jMenuItem_ConverterMinutosActionPerformed(evt);
            }
        });
        this.jMenu_Converter.add(this.jMenuItem_ConverterMinutos);
        this.jMenuItem_ConverterSegundos.setText("Segundos");
        this.jMenuItem_ConverterSegundos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculadoraHorario.this.jMenuItem_ConverterSegundosActionPerformed(evt);
            }
        });
        this.jMenu_Converter.add(this.jMenuItem_ConverterSegundos);
        this.jMenuBar_Principal.add(this.jMenu_Converter);
        this.jMenu_Sobre.setText("Sobre");
        this.jMenu_Sobre.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                CalculadoraHorario.this.jMenu_SobreMouseClicked(evt);
            }
        });
        this.jMenuBar_Principal.add(this.jMenu_Sobre);
        this.jMenu_Sair.setText("Sair");
        this.jMenu_Sair.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                CalculadoraHorario.this.jMenu_SairMouseClicked(evt);
            }
        });
        this.jMenuBar_Principal.add(this.jMenu_Sair);
        setJMenuBar(this.jMenuBar_Principal);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jPanel_Principal, -2, -1, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel_Principal, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
        setLocationRelativeTo(null);
    }

    private void jButton_0ActionPerformed(ActionEvent evt) {
        pegarApenasCharAceito(Character.valueOf('0'), null);
    }

    private void jButton_1ActionPerformed(ActionEvent evt) {
        pegarApenasCharAceito(Character.valueOf('1'), null);
    }

    private void jButton_2ActionPerformed(ActionEvent evt) {
        pegarApenasCharAceito(Character.valueOf('2'), null);
    }

    private void jButton_3ActionPerformed(ActionEvent evt) {
        pegarApenasCharAceito(Character.valueOf('3'), null);
    }

    private void jButton_4ActionPerformed(ActionEvent evt) {
        pegarApenasCharAceito(Character.valueOf('4'), null);
    }

    private void jButton_5ActionPerformed(ActionEvent evt) {
        pegarApenasCharAceito(Character.valueOf('5'), null);
    }

    private void jButton_6ActionPerformed(ActionEvent evt) {
        pegarApenasCharAceito(Character.valueOf('6'), null);
    }

    private void jButton_7ActionPerformed(ActionEvent evt) {
        pegarApenasCharAceito(Character.valueOf('7'), null);
    }

    private void jButton_8ActionPerformed(ActionEvent evt) {
        pegarApenasCharAceito(Character.valueOf('8'), null);
    }

    private void jButton_9ActionPerformed(ActionEvent evt) {
        pegarApenasCharAceito(Character.valueOf('9'), null);
    }

    private void jTextField_PainelCaretUpdate(CaretEvent evt) {
        if (getjTextField_Painel().getCaretPosition() != getjTextField_Painel().getText().length())
            getjTextField_Painel().setCaretPosition(getjTextField_Painel().getText().length());
    }

    private void jMenuItem_CopiarActionPerformed(ActionEvent evt) {
        if (!"".equals(getjTextField_Painel().getText())) {
            setHoras_painel(validarETransformarValor(getjTextField_Painel().getText()));
        } else if (!"".equals(getjLabel_Painel().getText()))
            if (("+".equals(getjLabel_Painel().getText().trim().substring(getjLabel_Painel().getText().trim().length() - 1, getjLabel_Painel().getText().trim().length()))) || ("-".equals(getjLabel_Painel().getText().trim().substring(getjLabel_Painel().getText().trim().length() - 1, getjLabel_Painel().getText().trim().length()))))
                setHoras_painel(validarETransformarValor(getjLabel_Painel().getText().trim().substring(0, getjLabel_Painel().getText().trim().length() - 1).trim()));
            else setHoras_painel(validarETransformarValor(getjLabel_Painel().getText().trim()));
    }

    private void jMenuItem_ColarActionPerformed(ActionEvent evt) {
        if (!"".equals(getHoras_painel())) getjTextField_Painel().setText(getHoras_painel());
    }

    private void jMenuItem_ConverterHorasActionPerformed(ActionEvent evt) {
        String horas_string = JOptionPane.showInputDialog(null, "Horas:", "Converter", 3);
        if (horas_string != null) try {
            if (horas_string.contains(",")) {
                horas_string = horas_string.replace(",", ".");
            }
            float horas_float = Float.parseFloat(horas_string.trim());
            if (horas_float > 0.0F)
                JOptionPane.showMessageDialog(null, transformarValorCasasDecimais(horas_float, 2) + " horas equivale a\n" + transformarValorCasasDecimais(horas_float * 3600.0F, 2) + " segundos\n" + transformarValorCasasDecimais(horas_float * 60.0F, 2) + " minutos", "Resultado", 1);
            else JOptionPane.showMessageDialog(null, "Valor deve ser maior que 0!", "Erro", 0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", 0);
        }
    }

    private void jMenuItem_ConverterMinutosActionPerformed(ActionEvent evt) {
        String minutos_string = JOptionPane.showInputDialog(null, "Minutos:", "Converter", 3);
        if (minutos_string != null) try {
            if (minutos_string.contains(",")) {
                minutos_string = minutos_string.replace(",", ".");
            }
            float minutos_float = Float.parseFloat(minutos_string.trim());
            if (minutos_float > 0.0F)
                JOptionPane.showMessageDialog(null, transformarValorCasasDecimais(minutos_float, 2) + " minutos equivale a\n" + transformarValorCasasDecimais(minutos_float * 60.0F, 2) + " segundos\n" + transformarValorCasasDecimais(minutos_float / 60.0F, 2) + " horas", "Resultado", 1);
            else JOptionPane.showMessageDialog(null, "Valor deve ser maior que 0!", "Erro", 0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", 0);
        }
    }

    private void jMenuItem_ConverterSegundosActionPerformed(ActionEvent evt) {
        String segundos_string = JOptionPane.showInputDialog(null, "Segundos:", "Converter", 3);
        if (segundos_string != null) try {
            if (segundos_string.contains(",")) {
                segundos_string = segundos_string.replace(",", ".");
            }
            float segundos_int = Float.parseFloat(segundos_string.trim());
            if (segundos_int > 0.0F)
                JOptionPane.showMessageDialog(null, transformarValorCasasDecimais(segundos_int, 2) + " segundos equivale a\n" + transformarValorCasasDecimais(segundos_int / 60.0F, 2) + " minutos\n" + transformarValorCasasDecimais(segundos_int / 3600.0F, 2) + " horas", "Resultado", 1);
            else JOptionPane.showMessageDialog(null, "Valor deve ser maior que 0!", "Erro", 0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", 0);
        }
    }

    private void jMenu_SobreMouseClicked(MouseEvent evt) {
        getSobre().show();
    }

    private void jMenu_SairMouseClicked(MouseEvent evt) {
        System.exit(0);
    }

    private void jButton_AdicaoActionPerformed(ActionEvent evt) {
        pegarOperador("+");
    }

    private void jButton_SubtracaoActionPerformed(ActionEvent evt) {
        pegarOperador("-");
    }

    private void jButton_IgualActionPerformed(ActionEvent evt) {
        if (!"".equals(getPrimeiro_horario())) {
            setResultado(calculoHorarios(getOperacao(), getPrimeiro_horario(), validarETransformarValor(getjTextField_Painel().getText())));
            setPrimeiro_horario("");
            setOperacao("");
            getjLabel_Painel().setText(getResultado());
            getjTextField_Painel().setText("");
        }
    }

    private void jButton_BSPActionPerformed(ActionEvent evt) {
        if (!"".equals(getjTextField_Painel().getText().trim())) {
            getjTextField_Painel().setText(getjTextField_Painel().getText().trim().substring(0, getjTextField_Painel().getText().trim().length() - 1));
            if ((!"".equals(getjTextField_Painel().getText().trim())) && (":".equals(getjTextField_Painel().getText().trim().substring(getjTextField_Painel().getText().trim().length() - 1, getjTextField_Painel().getText().trim().length()))))
                getjTextField_Painel().setText(getjTextField_Painel().getText().trim().substring(0, getjTextField_Painel().getText().trim().length() - 1));
        }
    }

    private void jButton_CEActionPerformed(ActionEvent evt) {
        setHoras_painel("");
        setOperacao("");
        setPrimeiro_horario("");
        setResultado("");
        getjLabel_Painel().setText("");
        getjTextField_Painel().setText("");
    }

    private void jMenuItem_HoraAtualActionPerformed(ActionEvent evt) {
        getjTextField_Painel().setText(validarETransformarValor(new SimpleDateFormat("HH:mm:s").format(new GregorianCalendar().getTime())));
    }

    public Sobre getSobre() {
        return this.sobre;
    }

    public void setSobre(Sobre sobre) {
        this.sobre = sobre;
    }

    public String getHoras_painel() {
        return this.horas_painel;
    }

    public void setHoras_painel(String horas_painel) {
        this.horas_painel = horas_painel;
    }

    public String getOperacao() {
        return this.operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getPrimeiro_horario() {
        return this.primeiro_horario;
    }

    public void setPrimeiro_horario(String primeiro_horario) {
        this.primeiro_horario = primeiro_horario;
    }

    public String getResultado() {
        return this.resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public JButton getjButton_0() {
        return this.jButton_0;
    }

    public void setjButton_0(JButton jButton_0) {
        this.jButton_0 = jButton_0;
    }

    public JButton getjButton_1() {
        return this.jButton_1;
    }

    public void setjButton_1(JButton jButton_1) {
        this.jButton_1 = jButton_1;
    }

    public JButton getjButton_2() {
        return this.jButton_2;
    }

    public void setjButton_2(JButton jButton_2) {
        this.jButton_2 = jButton_2;
    }

    public JButton getjButton_3() {
        return this.jButton_3;
    }

    public void setjButton_3(JButton jButton_3) {
        this.jButton_3 = jButton_3;
    }

    public JButton getjButton_4() {
        return this.jButton_4;
    }

    public void setjButton_4(JButton jButton_4) {
        this.jButton_4 = jButton_4;
    }

    public JButton getjButton_5() {
        return this.jButton_5;
    }

    public void setjButton_5(JButton jButton_5) {
        this.jButton_5 = jButton_5;
    }

    public JButton getjButton_6() {
        return this.jButton_6;
    }

    public void setjButton_6(JButton jButton_6) {
        this.jButton_6 = jButton_6;
    }

    public JButton getjButton_7() {
        return this.jButton_7;
    }

    public void setjButton_7(JButton jButton_7) {
        this.jButton_7 = jButton_7;
    }

    public JButton getjButton_8() {
        return this.jButton_8;
    }

    public void setjButton_8(JButton jButton_8) {
        this.jButton_8 = jButton_8;
    }

    public JButton getjButton_9() {
        return this.jButton_9;
    }

    public void setjButton_9(JButton jButton_9) {
        this.jButton_9 = jButton_9;
    }

    public JButton getjButton_Adicao() {
        return this.jButton_Adicao;
    }

    public void setjButton_Adicao(JButton jButton_Adicao) {
        this.jButton_Adicao = jButton_Adicao;
    }

    public JButton getjButton_BSP() {
        return this.jButton_BSP;
    }

    public void setjButton_BSP(JButton jButton_BSP) {
        this.jButton_BSP = jButton_BSP;
    }

    public JButton getjButton_CE() {
        return this.jButton_CE;
    }

    public void setjButton_CE(JButton jButton_CE) {
        this.jButton_CE = jButton_CE;
    }

    public JButton getjButton_Igual() {
        return this.jButton_Igual;
    }

    public void setjButton_Igual(JButton jButton_Igual) {
        this.jButton_Igual = jButton_Igual;
    }

    public JButton getjButton_Subtracao() {
        return this.jButton_Subtracao;
    }

    public void setjButton_Subtracao(JButton jButton_Subtracao) {
        this.jButton_Subtracao = jButton_Subtracao;
    }

    public JLabel getjLabel_Painel() {
        return this.jLabel_Painel;
    }

    public void setjLabel_Painel(JLabel jLabel_Painel) {
        this.jLabel_Painel = jLabel_Painel;
    }

    public JMenuBar getjMenuBar_Principal() {
        return this.jMenuBar_Principal;
    }

    public void setjMenuBar_Principal(JMenuBar jMenuBar_Principal) {
        this.jMenuBar_Principal = jMenuBar_Principal;
    }

    public JMenuItem getjMenuItem_Colar() {
        return this.jMenuItem_Colar;
    }

    public void setjMenuItem_Colar(JMenuItem jMenuItem_Colar) {
        this.jMenuItem_Colar = jMenuItem_Colar;
    }

    public JMenuItem getjMenuItem_ConverterHoras() {
        return this.jMenuItem_ConverterHoras;
    }

    public void setjMenuItem_ConverterHoras(JMenuItem jMenuItem_ConverterHoras) {
        this.jMenuItem_ConverterHoras = jMenuItem_ConverterHoras;
    }

    public JMenuItem getjMenuItem_ConverterMinutos() {
        return this.jMenuItem_ConverterMinutos;
    }

    public void setjMenuItem_ConverterMinutos(JMenuItem jMenuItem_ConverterMinutos) {
        this.jMenuItem_ConverterMinutos = jMenuItem_ConverterMinutos;
    }

    public JMenuItem getjMenuItem_ConverterSegundos() {
        return this.jMenuItem_ConverterSegundos;
    }

    public void setjMenuItem_ConverterSegundos(JMenuItem jMenuItem_ConverterSegundos) {
        this.jMenuItem_ConverterSegundos = jMenuItem_ConverterSegundos;
    }

    public JMenuItem getjMenuItem_Copiar() {
        return this.jMenuItem_Copiar;
    }

    public void setjMenuItem_Copiar(JMenuItem jMenuItem_Copiar) {
        this.jMenuItem_Copiar = jMenuItem_Copiar;
    }

    public JMenuItem getjMenuItem_HoraAtual() {
        return this.jMenuItem_HoraAtual;
    }

    public void setjMenuItem_HoraAtual(JMenuItem jMenuItem_HoraAtual) {
        this.jMenuItem_HoraAtual = jMenuItem_HoraAtual;
    }

    public JMenu getjMenu_Converter() {
        return this.jMenu_Converter;
    }

    public void setjMenu_Converter(JMenu jMenu_Converter) {
        this.jMenu_Converter = jMenu_Converter;
    }

    public JMenu getjMenu_Editar() {
        return this.jMenu_Editar;
    }

    public void setjMenu_Editar(JMenu jMenu_Editar) {
        this.jMenu_Editar = jMenu_Editar;
    }

    public JMenu getjMenu_Sair() {
        return this.jMenu_Sair;
    }

    public void setjMenu_Sair(JMenu jMenu_Sair) {
        this.jMenu_Sair = jMenu_Sair;
    }

    public JMenu getjMenu_Sobre() {
        return this.jMenu_Sobre;
    }

    public void setjMenu_Sobre(JMenu jMenu_Sobre) {
        this.jMenu_Sobre = jMenu_Sobre;
    }

    public JPanel getjPanel_Principal() {
        return this.jPanel_Principal;
    }

    public void setjPanel_Principal(JPanel jPanel_Principal) {
        this.jPanel_Principal = jPanel_Principal;
    }

    public JTextField getjTextField_Painel() {
        return this.jTextField_Painel;
    }

    public void setjTextField_Painel(JTextField jTextField_Painel) {
        this.jTextField_Painel = jTextField_Painel;
    }
}