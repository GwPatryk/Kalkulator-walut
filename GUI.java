import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class GUI implements ActionListener {

    private JLabel calculatedValueLabel;
    private JFrame frame;
    private JPanel panel;
    private JTextField euroValueField;
    private JComboBox box;

    public GUI(){
        frame = new JFrame();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new GridLayout(0, 1)); 

        euroValueField = new JTextField();
        panel.add(euroValueField);

        box = new JComboBox<>(XmlParser.currencyList);
        panel.add(box);

        JButton button = new JButton("Calculate");
        button.setBackground(Color.GREEN);
        button.addActionListener(this);
        panel.add(button);

        calculatedValueLabel = new JLabel("result");
        panel.add(calculatedValueLabel);        

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Kalkulator walut");
        frame.pack();
        frame.setVisible(true);
        frame.setSize(300, 400);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        try {
            float input = Float.parseFloat(euroValueField.getText());
            calculatedValueLabel.setText(euroValueField.getText());

            Calculator calculator = new Calculator();
            String currency = box.getSelectedItem().toString().substring(0, 3);
            calculatedValueLabel.setText(euroValueField.getText() + " EUR = " + calculator.calculate(input, currency) + " " + currency);
        } catch (Exception ee) {
            calculatedValueLabel.setText("Enter a numeric value");
        }
    }

    public static void main(String[] args){
        new XmlParser();
        new GUI();
    }
}