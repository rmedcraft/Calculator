import javax.swing.JFrame;

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

