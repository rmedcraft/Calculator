import java.awt.event.*; 
import javax.swing.*; 
import java.awt.*; 

public class SimpleCalculator extends JFrame implements ActionListener { 
    // create a textfield 
    private JTextField output; 

    //private JButton bd;
    private JButton [] bts = new JButton[20]; // all the buttons in the program

    private String math_exp = ""; // for the final mathematical expression
    
    final int FRAME_WIDTH = 360;
    final int FRAME_HEIGHT = 320;
    // default constrcutor 
    public SimpleCalculator() { 
        // set ouput area
        output = new JTextField(21); 
        output.setPreferredSize(new Dimension(30, 40));
        output.setFont(new Font("Arial", Font.PLAIN, 20));
        output.setHorizontalAlignment(SwingConstants.RIGHT);

        // create number buttons and some operators 
        // create a button object
        bts[0] = newButton("(", "gray");
        bts[1] = newButton(")", "gray");
        bts[2] = newButton("%", "gray");
        bts[3] = newButton("CE", "gray");
        bts[4] = newButton("7", "white");
        bts[5] = newButton("8", "white");
        bts[6] = newButton("9", "white");
        bts[7] = newButton("/", "gray");
        bts[8] = newButton("4", "white");
        bts[9] = newButton("5", "white");
        bts[10] = newButton("6", "white");
        bts[11] = newButton("*", "gray");
        bts[12] = newButton("1", "white");
        bts[13] = newButton("2", "white");
        bts[14] = newButton("3", "white");        
        bts[15] = newButton("-", "gray");
        bts[16] = newButton("0", "white");
        bts[17] = newButton(".", "white");
        bts[18] = newButton("=", "blue");
        bts[19] = newButton("+", "gray");
        
        // create a panel 
        JPanel p = new JPanel(); 
        p.add(output);
        for(int i = 0; i < bts.length; i++){
            p.add(bts[i]);
        }
        
        // add panel to frame 
        this.add(p); 

        // set frame size
        setSize(FRAME_WIDTH, FRAME_HEIGHT); 
    } 

    // creates a new button with desired proportions
    public JButton newButton(String title, String color){
        JButton button = new JButton(title);
        button.setPreferredSize(new Dimension(80, 40));
        button.setFont(new Font("Arial", Font.PLAIN, 20));
        if(color.toLowerCase().equals("blue")){
            button.setContentAreaFilled(false);
            button.setBorderPainted(true);
            button.setOpaque(true);
            button.setForeground(Color.WHITE);
            button.setBackground(new Color(51, 153, 255)); 
        } else if(color.toLowerCase().equals("gray")){
            button.setBackground(new Color(204, 204, 204));
        }
        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent e) 
    { 
        String s = e.getActionCommand();  // saves the name of the button pressed
        //System.out.println("You Pressed: " + s);
        if(s.equals("CE")){
            // clears the expression
            math_exp = "";
            output.setText("");
        } else if(s.equals("=")){
            // performs the operation
            String result = PostFixCalculator.calculate(math_exp) + "";
            // rounds to 2 decimal places
            // if(result.substring(result.indexOf(".")).length() < 3){
                // result = result + "0";
            // } else if(result.substring(result.indexOf(".")).length() > 3){
                // result = result.substring(0, result.indexOf(".")) + 
                // result.substring(result.indexOf("."), result.indexOf(".") + 3);
            // }
            
            // puts the operation in the text field in case you want to do 
            // something else with it
            output.setText(result);
            math_exp = result;
        } else {
            // adds the button to the expression
            math_exp += s;
            output.setText(output.getText() + s);
        }
    } 
} 