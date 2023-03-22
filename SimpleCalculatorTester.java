import javax.swing.JFrame;
import java.awt.Color;

public class SimpleCalculatorTester
{
    public static void main(String[] args)
    {
        JFrame frame = new SimpleCalculator() ;

        frame.setTitle("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

