
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class cal implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    StringBuilder equation;
//Ink Free
    Font myFont = new Font("Calibri", Font.PLAIN, 30);

    double num1 = -1, num2 = 0, result = 0;
    char operator;

    public cal() {
        equation = new StringBuilder();
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        textfield.setBackground(new Color(30, 30, 30));
        textfield.setForeground(Color.WHITE);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(new Color(30, 30, 30));
            functionButtons[i].setForeground(Color.WHITE);
            functionButtons[i].setMargin(new Insets(20, 10, 5, 10));
        }
        functionButtons[4].setMargin(new Insets(30, 10, 5, 10));

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(new Color(30, 30, 30));
            numberButtons[i].setForeground(Color.WHITE);
            numberButtons[i].setMargin(new Insets(20, 10, 5, 10)); // Set margin for each button
        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(new Color(25, 25, 25));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        @SuppressWarnings("unused")
        cal calc = new cal();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                equation.append(i);
                textfield.setText(equation.toString());
            }
        }
        if (e.getSource() == decButton) {
            equation.append(".");
            textfield.setText(equation.toString());
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            equation.append(" + ");
            textfield.setText(equation.toString());
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            equation.append(" - ");
            textfield.setText(equation.toString());
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            equation.append(" * ");
            textfield.setText(equation.toString());
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            equation.append(" / ");
            textfield.setText(equation.toString());
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textfield.getText().split(" ")[2]);
            equation.append(" = ");

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            equation.append(result);
            textfield.setText(equation.toString());
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            equation.setLength(0);
            textfield.setText("");
        }
        if (e.getSource() == delButton) {
            if (equation.length() > 0) {
                equation.deleteCharAt(equation.length() - 1);
                textfield.setText(equation.toString());
            }
        }
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            equation.setLength(0);
            equation.append(temp);
            textfield.setText(equation.toString());
        }
    }
}