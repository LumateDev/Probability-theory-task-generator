import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {

    App(){
        super("Генератора задач по Теории вероятности");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(mainPanel);
        setSize(720, 460);
        setResizable(false);
        setVisible(true);

        topPanel.setBackground(new Color(194, 194, 194));
        buttonPanel.setBackground(new Color(194, 194, 194));
        lowPanel.setBackground(new Color(130,193,196));
        mainPanel.setBackground(new Color(194, 194, 194));



        labelInputCountVar.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        labelInputCountVar.setForeground(new Color(1,1,1));
        labelInputCountVar.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));

        labelChoseTask.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        labelChoseTask.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        labelChoseTask.setForeground(new Color(1,1,1));

        textFieldCountVar.setForeground(new Color(164, 164, 164));


        checkAllTask.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        checkAllTask.setFont(new Font("Segoe UI" , Font.PLAIN , 24));
        checkAllTask.setForeground(new Color(1,1,1));
        buttonCreateVar.setFont(new Font("Segoe UI" , Font.PLAIN , 20));
        class ColorListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if(button.getBackground() !=  new JButton().getBackground())
                    button.setBackground(new JButton().getBackground());
                else
                    button.setBackground( new Color(66,144,224) );

            }
        }

        ColorListener cl = new ColorListener();
        buttonTask1.addActionListener(cl);
        buttonTask1.setFont(new Font("Segoe UI" , Font.PLAIN , 18));
        buttonTask2.addActionListener(cl);
        buttonTask2.setFont(new Font("Segoe UI" , Font.PLAIN , 18));
        buttonTask3.addActionListener(cl);
        buttonTask3.setFont(new Font("Segoe UI" , Font.PLAIN , 18));
        buttonTask4.addActionListener(cl);
        buttonTask4.setFont(new Font("Segoe UI" , Font.PLAIN , 18));
        buttonTask5.addActionListener(cl);
        buttonTask5.setFont(new Font("Segoe UI" , Font.PLAIN , 18));
        buttonTask6.addActionListener(cl);
        buttonTask6.setFont(new Font("Segoe UI" , Font.PLAIN , 18));
        buttonTask7.addActionListener(cl);
        buttonTask7.setFont(new Font("Segoe UI" , Font.PLAIN , 18));
        buttonTask8.addActionListener(cl);
        buttonTask8.setFont(new Font("Segoe UI" , Font.PLAIN , 18));
        buttonTask9.addActionListener(cl);
        buttonTask9.setFont(new Font("Segoe UI" , Font.PLAIN , 18));
        buttonTask10.addActionListener(cl);
        buttonTask10.setFont(new Font("Segoe UI" , Font.PLAIN , 18));
        buttonTask11.addActionListener(cl);
        buttonTask11.setFont(new Font("Segoe UI" , Font.PLAIN , 18));
        buttonTask12.addActionListener(cl);
        buttonTask12.setFont(new Font("Segoe UI" , Font.PLAIN , 18));
        buttonTask13.addActionListener(cl);
        buttonTask13.setFont(new Font("Segoe UI" , Font.PLAIN , 18));
        buttonTask14.addActionListener(cl);
        buttonTask14.setFont(new Font("Segoe UI" , Font.PLAIN , 18));





    }

    private JPanel mainPanel;
    private JPanel buttonPanel;

    private JButton buttonTask1;
    private JButton buttonTask2;
    private JButton buttonTask3;
    private JButton buttonTask4;
    private JButton buttonTask5;
    private JButton buttonTask6;
    private JButton buttonTask7;
    private JButton buttonTask8;
    private JButton buttonTask9;
    private JButton buttonTask10;
    private JButton buttonTask11;
    private JButton buttonTask12;
    private JButton buttonTask13;
    private JButton buttonTask14;
    private JTextField textFieldCountVar;


    private JLabel labelTitle;
    private JLabel labelInputCountVar;
    private JPanel lowPanel;
    private JButton buttonCreateVar;
    private JCheckBox checkAllTask;
    private JLabel labelChoseTask;
    private JPanel topPanel;


    public static void main(String[] args) {
        try {

            UIManager.setLookAndFeel(new FlatDarkLaf());

        } catch (Exception e) {
            setDefaultLookAndFeelDecorated(true);
            e.printStackTrace();
        }
        new App();
    }
}
