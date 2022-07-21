package calculator;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator extends JFrame {

    public Calculator() {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);

        JLabel resultLabel = new JLabel("0");
        resultLabel.setName("ResultLabel");
        resultLabel.setBounds(200, 10, 50, 50);
        add(resultLabel);

        JLabel EquationTextField = new JLabel();
        EquationTextField.setName("EquationLabel");
        EquationTextField.setBounds(200, 60, 150, 30);
        add(EquationTextField);


        JButton Solve = new JButton("=");
        Solve.setName("Equals");
        Solve.setBounds(140, 280, 50, 40);
        add(Solve);
        Solve.addActionListener(e -> {
            EquationTextField.setForeground(Color.BLACK.darker());
            List<String> exp = new ArrayList<>();
            String expression = EquationTextField.getText();
            Pattern pattern = Pattern.compile("([0-9.]+)([\u002B\u2212\u00F7\u00D7\\-])*");
            Matcher matcher = pattern.matcher(expression);

            Pattern divisionByZero = Pattern.compile("\u00F70");
            Matcher divisionCheck = divisionByZero.matcher(expression);

            if (expression.charAt(expression.length() - 1) == '\u002B' | expression.endsWith("-") | expression.endsWith("\u00F7") | expression.endsWith("\u00D7")) {
                EquationTextField.setForeground(Color.RED.darker());
            } else if (divisionCheck.find()) {
                EquationTextField.setForeground(Color.RED.darker());
            } else {

                while (matcher.find()) {
                    if (matcher.group(1) != null) exp.add(matcher.group(1));
                    if (matcher.group(2) != null) exp.add(matcher.group(2));
                }

                EquationTextField.setText(expression);
                resultLabel.setText(String.valueOf(recursiveCalc(exp)));
            }
        });

        JButton Add = new JButton("\u002B");
        Add.setName("Add");
        Add.setBounds(200, 220, 50, 40);
        add(Add);

        Add.addActionListener(e -> {
            String text = EquationTextField.getText();

            if (text.length() != 0) {
                if (text.charAt(text.length() - 1) == '\u002B' | text.endsWith("-") | text.endsWith("\u00F7") | text.endsWith("\u00D7")) {
                    EquationTextField.setText(EquationTextField.getText().substring(0, EquationTextField.getText().length() - 1));
                    EquationTextField.setText(EquationTextField.getText() + "\u002B");
                } else if (text.endsWith(".")) {
                    EquationTextField.setText(EquationTextField.getText() + "0\u002B");
                } else if (text.startsWith(".")) {
                    EquationTextField.setText(0 + EquationTextField.getText() + "\u002B");
                } else EquationTextField.setText(EquationTextField.getText() + "\u002B");
            }
        });

        JButton Subtract = new JButton("-"); //"\u2212"
        Subtract.setName("Subtract");
        Subtract.setBounds(200, 170, 50, 40);
        add(Subtract);

        Subtract.addActionListener(e -> {
            String text = EquationTextField.getText();
            if (text.length() != 0) {
                if (text.charAt(text.length() - 1) == '\u002B' | text.endsWith("-") | text.endsWith("\u00F7") | text.endsWith("\u00D7")) {
                    EquationTextField.setText(EquationTextField.getText().substring(0, EquationTextField.getText().length() - 1));
                    EquationTextField.setText(EquationTextField.getText() + "-");
                } else if (text.endsWith(".")) {
                    EquationTextField.setText(EquationTextField.getText() + "0-");
                } else if (text.startsWith(".")) {
                    EquationTextField.setText(0 + EquationTextField.getText() + "-");
                } else EquationTextField.setText(EquationTextField.getText() + "-");
        }});

        JButton Divide = new JButton("\u00F7");
        Divide.setName("Divide");
        Divide.setBounds(200, 120, 50, 40);
        add(Divide);

        Divide.addActionListener(e -> {
            String text = EquationTextField.getText();
            if (text.length() != 0) {
                if (text.charAt(text.length() - 1) == '\u002B' | text.endsWith("-") | text.endsWith("\u00F7") | text.endsWith("\u00D7")) {
                    EquationTextField.setText(EquationTextField.getText().substring(0, EquationTextField.getText().length() - 1));
                    EquationTextField.setText(EquationTextField.getText() + "\u00F7");
                } else if (text.endsWith(".")) {
                    EquationTextField.setText(EquationTextField.getText() + "0\u00F7");
                } else if (text.startsWith(".")) {
                    EquationTextField.setText(0 + EquationTextField.getText() + "\u00F7");
                } else EquationTextField.setText(EquationTextField.getText() + "\u00F7");
        }});

        JButton Multiply = new JButton("\u00D7");
        Multiply.setName("Multiply");
        Multiply.setBounds(200, 280, 50, 40);
        add(Multiply);

        Multiply.addActionListener(e -> {
            String text = EquationTextField.getText();
            if (text.length() != 0) {
                if (text.charAt(text.length() - 1) == '\u002B' | text.endsWith("-") | text.endsWith("\u00F7") | text.endsWith("\u00D7")) {
                    EquationTextField.setText(EquationTextField.getText().substring(0, EquationTextField.getText().length() - 1));
                    EquationTextField.setText(EquationTextField.getText() + "\u00D7");
                } else if (text.endsWith(".")) {
                    EquationTextField.setText(EquationTextField.getText() + "0\u00D7");
                } else if (text.startsWith(".")) {
                    EquationTextField.setText(0 + EquationTextField.getText() + "\u00D7");
                } else EquationTextField.setText(EquationTextField.getText() + "\u00D7");
        }});

        JButton zero = new JButton("0");
        zero.setBounds(20, 280, 50, 40);
        zero.setName("Zero");
        add(zero);
        zero.addActionListener(e -> {
            EquationTextField.setText(EquationTextField.getText() + "0");
        });
        JButton one = new JButton("1");
        one.setBounds(20, 220, 50, 40);
        one.setName("One");
        add(one);
        one.addActionListener(e -> {
            EquationTextField.setText(EquationTextField.getText() + "1");
        });
        JButton two = new JButton("2");
        two.setBounds(80, 220, 50, 40);
        two.setName("Two");
        add(two);
        two.addActionListener(e -> {
            EquationTextField.setText(EquationTextField.getText() + "2");
        });
        JButton three = new JButton("3");
        three.setBounds(140, 220, 50, 40);
        three.setName("Three");
        add(three);
        three.addActionListener(e -> {
            EquationTextField.setText(EquationTextField.getText() + "3");
        });

        JButton four = new JButton("4");
        four.setBounds(20, 170, 50, 40);
        four.setName("Four");
        add(four);
        four.addActionListener(e -> {
            EquationTextField.setText(EquationTextField.getText() + "4");
        });
        JButton five = new JButton("5");
        five.setBounds(80, 170, 50, 40);
        five.setName("Five");
        add(five);
        five.addActionListener(e -> {
            EquationTextField.setText(EquationTextField.getText() + "5");
        });
        JButton six = new JButton("6");
        six.setBounds(140, 170, 50, 40);
        six.setName("Six");
        add(six);
        six.addActionListener(e -> {
            EquationTextField.setText(EquationTextField.getText() + "6");
        });

        JButton seven = new JButton("7");
        seven.setBounds(20, 120, 50, 40);
        seven.setName("Seven");
        add(seven);
        seven.addActionListener(e -> {
            EquationTextField.setText(EquationTextField.getText() + "7");
        });
        JButton eight = new JButton("8");
        eight.setBounds(80, 120, 50, 40);
        eight.setName("Eight");
        add(eight);
        eight.addActionListener(e -> {
            EquationTextField.setText(EquationTextField.getText() + "8");
        });
        JButton nine = new JButton("9");
        nine.setBounds(140, 120, 50, 40);
        nine.setName("Nine");
        add(nine);
        nine.addActionListener(e -> {
            EquationTextField.setText(EquationTextField.getText() + "9");
        });

        JButton clear = new JButton("C");
        clear.setBounds(20, 10, 70, 40);
        clear.setName("Clear");
        add(clear);
        clear.addActionListener(e -> {
            EquationTextField.setText("");
            resultLabel.setText("");
        });

        JButton point = new JButton(".");
        point.setBounds(80, 280, 50, 40);
        point.setName("Dot");
        add(point);
        point.addActionListener(e -> {
            String text = EquationTextField.getText();
        /*if (EquationTextField.getText().isEmpty()) {
            EquationTextField.setText(EquationTextField.getText() + "0.");
        } else*/

            if (text.endsWith("\u002B") | text.endsWith("-") | text.endsWith("\u00F7") | text.endsWith("\u00D7")) {
            EquationTextField.setText(EquationTextField.getText() + "0.");
        } else EquationTextField.setText(EquationTextField.getText() + ".");
        });

        JButton delete = new JButton("Del");
        delete.setBounds(20, 60, 70, 40);
        delete.setName("Delete");
        add(delete);
        delete.addActionListener(e -> {
            if (EquationTextField.getText().length() > 0)
            EquationTextField.setText(EquationTextField.getText().substring(0, EquationTextField.getText().length() - 1));
        });

    }

    public String calculate(List<String> exp) {

       // long count = exp.stream().filter(s -> s.matches("\u00F7") | s.matches("\u00D7")).count();
       // System.out.println("count of multi/div" + count);

        for (int i = 0; i < exp.size(); i++) {
            int e = 0;

            if (exp.get(i).equals("\u00F7")) {  // divide ÷
                e = Integer.parseInt(exp.get(i - 1)) / Integer.parseInt(exp.get(i + 1));
                exp.set(i, String.valueOf(e));
                exp.set(i - 1, "");
                exp.set(i + 1, "");
                break;
            }
        }

       /* exp.forEach(e -> {
            if (e.equals("")) exp.remove(e);
        });*/

        for (int i = 0; i < exp.size(); i++) {
            if (exp.get(i).equals("")) exp.remove(i);
        }


            for (int i = 0; i < exp.size(); i++) {
                int e = 0;
                if (exp.get(i).equals("\u00D7")) {  // multi ×
                    e = Integer.parseInt(exp.get(i - 1)) * Integer.parseInt(exp.get(i + 1));
                    exp.set(i, String.valueOf(e));
                    exp.set(i - 1, "");
                    exp.set(i + 1, "");
                }
            }


        for (int i = 0; i < exp.size(); i++) {
            if (exp.get(i).equals("")) exp.remove(i);
        }

            System.out.println("after 1st: " + exp);

            long count2 = exp.stream().filter(s -> s.matches("\\u002B") | s.matches("\u2212")).count();
            System.out.println("count of add/sub" + count2);

            for (int i = 0; i < exp.size(); i++) {
                int e = 0;
                if (exp.get(i).equals("\u002B")) {  // add
                    e = Integer.parseInt(exp.get(i - 1)) + Integer.parseInt(exp.get(i + 1));
                    exp.set(i, String.valueOf(e));
                    exp.set(i - 1, "");
                    exp.set(i + 1, "");
                }
            }

        for (int i = 0; i < exp.size(); i++) {
            if (exp.get(i).equals("")) exp.remove(i);
        }
                for (int i = 0; i < exp.size(); i++) {
                    int e = 0;
                if (exp.get(i).equals("\u2212")) {  // minus
                    e = Integer.parseInt(exp.get(i - 1)) - Integer.parseInt(exp.get(i - 1));
                    exp.set(i, String.valueOf(e));
                    exp.set(i - 1, "");
                    exp.set(i + 1, "");
                }
            }
        for (int i = 0; i < exp.size(); i++) {
            if (exp.get(i).equals("")) exp.remove(i);
        }
            System.out.println("after 2nd: " + exp);
            return exp.get(0);
        }

        public String recursiveCalc (List<String> exp) {
        String result;
            DecimalFormat df = new DecimalFormat("#.##");

             long count = 0;
             count = exp.stream().filter(s -> s.equals("\u00F7") | s.equals("\u00D7")).count();

            if (count > 0) {
                for (int i = 0; i < exp.size(); i++) {
                    double e = 0;
                    if (exp.get(i).equals("\u00F7")) {  // divide ÷
                        e = Double.parseDouble(exp.get(i - 1)) / Double.parseDouble(exp.get(i + 1));
                        exp.set(i, String.valueOf(e));
                        exp.remove(i + 1);
                        exp.remove(i - 1);
                        break;
                    }
                }
                for (int i = 0; i < exp.size(); i++) {
                    double e = 0;
                    if (exp.get(i).equals("\u00D7")) {  // multi
                        e = Double.parseDouble(exp.get(i - 1)) * Double.parseDouble(exp.get(i + 1));
                        exp.set(i, String.valueOf(e));
                        exp.remove(i + 1);
                        exp.remove(i - 1);
                        break;
                    }
                }
            } else {
                for (int i = 0; i < exp.size(); i++) {
                    double e = 0;
                    if (exp.get(i).equals("-")) {  // sub
                        e = Double.parseDouble(exp.get(i - 1)) - Double.parseDouble(exp.get(i + 1));
                        exp.set(i, String.valueOf(e));
                        exp.remove(i + 1);
                        exp.remove(i - 1);
                        break;
                    }
                }
                for (int i = 0; i < exp.size(); i++) {
                    double e = 0;
                    if (exp.get(i).equals("\u002B")) {  // add
                        e = Double.parseDouble(exp.get(i - 1)) + Double.parseDouble(exp.get(i + 1));
                        exp.set(i, String.valueOf(e));
                        exp.remove(i + 1);
                        exp.remove(i - 1);
                        break;
                    }
                }
            }
        if (exp.size() > 1) {
            recursiveCalc(exp);
        }
        if (Double.parseDouble(exp.get(0))%1 == 0) {
            int a = (int) Double.parseDouble(exp.get(0));
            result = df.format(a);
        } else result = String.valueOf(df.format(Double.parseDouble(exp.get(0))));
        return result;
        }
        public boolean isValid (String text) {


        return true;
        }
}

