import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;

public class Main {
    public static void main(String [] args){
        Calc obj = new Calc("Calculator");
    }
}
class Calc extends JFrame implements ActionListener{
    JPanel p;
    JTextField t1, t2;
    JRadioButton b1, b2, b3, b4, b5;
    ButtonGroup option;
    JButton submit;
    JLabel d1,d2,d3;
    JLabel answer;

    public Calc(String appName){
        super(appName,null);
        //text area for taking two inputs
        t1 = new JTextField(1);
        t2 = new JTextField(1);

        //text area for choosing operation
        b1 = new JRadioButton("Add");
        b2 = new JRadioButton("Subtract");
        b3 = new JRadioButton("Multiply");
        b4 = new JRadioButton("Divide");
        b5 = new JRadioButton("Power");
        option = new ButtonGroup();
        option.add(b1);
        option.add(b2);
        option.add(b3);
        option.add(b4);
        option.add(b5);

        //Submit Operation
        submit = new JButton("Calculate");

        //Answer display
        answer = new JLabel("null",JLabel.CENTER);

        //Labels for users
        d1 = new JLabel("Inputs",JLabel.CENTER);
        d2 = new JLabel("Choose Operation",JLabel.CENTER);
        d3 = new JLabel("Answer",JLabel.CENTER);

        //Add components to panel
        p = new JPanel();
        p.add(d1);
        p.add(t1);
        p.add(t2);
        //p.add(new JSeparator(SwingConstants.HORIZONTAL));
        p.add(d2);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        //p.add(new JSeparator(SwingConstants.HORIZONTAL));
        p.add(submit);
        //p.add(new JSeparator(SwingConstants.HORIZONTAL));
        p.add(d3);
        p.add(answer);

        //Setting panel size
        p.setBackground(Color.decode("#c2c2d6"));
        p.setLayout(new GridLayout(12,1));

        //Adding Panel to Frame
        add(p);

        //Adding features to JFrame
        setLayout(new GridLayout());
        setSize(300,350);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add Action
        submit.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        Integer value = null;
        Double power = null;
        Integer a = Integer.parseInt(t1.getText());
        Integer b = Integer.parseInt(t2.getText());
        if(b1.isSelected())
            value = a + b;
        if(b2.isSelected())
            value = a - b;
        if(b3.isSelected())
            value = a * b;
        if(b4.isSelected())
            value = a / b;
        if(b5.isSelected())
            power = Math.pow(a,b);

        answer.setText(value + "");
        if(b4.isSelected())
            answer.setText("Quotient: "+value + ", Remainder: "+(a%b));
        if(b5.isSelected())
            answer.setText(power+"");
    }
}
