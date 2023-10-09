import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInput implements ActionListener{
    private Controller c;

    private JFrame f;
    private JPanel p;
    private JTextArea ta;

    private JButton btnModel1;
    private JButton btnModel2;

    private JLabel lbOutput;

    public UserInput(){
        c = new Controller();

        f = new JFrame();
        initComponent();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initComponent(){
        p = new JPanel();
        p.setLayout(null);
        p.setPreferredSize(new Dimension(400, 600));

        ta = new JTextArea();
        ta.setBounds(20, 20, 200, 200);

        btnModel1 = new JButton("Model 1");
        btnModel1.setBounds(80, 300, 90, 20);

        btnModel2 = new JButton("Model 2");
        btnModel2.setBounds(230, 300, 90, 20);

        lbOutput = new JLabel();
        lbOutput.setBounds(50, 350, 300, 250);

        p.add(ta);
        p.add(btnModel1);
        p.add(btnModel2);
        p.add(lbOutput);

        f.getContentPane().add(p);
        f.pack();

        btnModel1.addActionListener(this);
        btnModel2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if(source == btnModel1){
            c.getUserInputM1andSendOutput(ta.getText(), this);
        }else if (source == btnModel2){
            c.getUserInputM2andSendOutput(ta.getText(), this);
        }
    }

    public void showOutput(String msg){
        lbOutput.setText(msg);
    }
}