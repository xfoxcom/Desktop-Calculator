package calculator;

import javax.swing.*;

public class ApplicationRunner {
    public static void main(String[] args) throws Exception {
        Runnable calculator =Calculator::new;

        SwingUtilities.invokeAndWait(calculator);
    }
}
