import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener{
   private JTextField display;
   private JPanel panel;
private StringBuilder currentInput; //Store current number input
private double result;
private String operator;
private boolean isOperatorClicked;

public SimpleCalculator() {
// Initialize calculator frame 
setTitle("Simple Calculator");
setSize(400,500);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new BorderLayout());

//Initialize the display field 
display = new JTextField();
display.setEditable(false);
display.setFont(new Font("Arial",Font.BOLD,30));
display.setHorizontalAlignment(SwingConstants.RIGHT);
add(display, BorderLayout.NORTH);

//Initialize panel with grid layout for buttons
panel = new JPanel();
panel.setLayout(new GridLayout(5,5,10,10)); // 4*4 grid
add(panel,BorderLayout.CENTER);

//Initialize number and operator buttons 

String[] buttonLabels = {
      "7", "8", "9", "/",
      "4", "5", "6", "*",
      "1", "2" ,"3", "-",
      "0", "C", "=" , "+" 
};

for (String label : buttonLabels){
   JButton button = new JButton(label);
   button.setFont(new Font("Arial", Font.BOLD,20));
   button.addActionListener(this);
   panel.add(button);
}

//Initialize variables 
currentInput = new StringBuilder();
result = 0;
operator = "";
isOperatorClicked = false;
}

@Override
public void actionPerformed(ActionEvent e){
 String command = e.getActionCommand();

//Handle number inputs 
if(command.matches("\\d")){
  if (isOperatorClicked){
      currentInput.setLength(0); //clear the input buffer after an operator
      isOperatorClicked = false;
   
}
currentInput.append(command);
display.setText(currentInput.toString());
}

//handle operator inputs 
else if (command.matches("[+\\-*/]")){
handleOperator(command);
}

//Handle equals 
else if (command.equals("=")){
calculateResult();
}

else if (command.equals("=")){
clearCalculator();
  }
}


private void handleOperator(String op){
  if (currentInput.length()  >0 ){
    if (!operator.isEmpty()){
        calculateResult();  //perform the various operation
} 
else{
 result = Double.parseDouble(currentInput.toString());
}
operator = op;
isOperatorClicked = true;
  }
}


private void calculateResult(){
 try{
   double currentValue = Double.parseDouble(currentInput.toString());
   switch (operator){
    case "+":
       result += currentValue;
       break;
    case "-":
       result -= currentValue;
       break;
    case "*":
       result *= currentValue;
       break;
    case "/":
      if (currentValue == 0){
                throw new ArithmeticException("Cannot divided by zero");
      }
      result /= currentValue;
      break;
}

display.setText(String.valueOf(result));

currentInput.setLength(0); //clear the input buffer 
currentInput.append(result); //keep the result as input for further calculation 
operator = "";
}

catch (ArithmeticException e){
  display.setText("Error:" + e.getMessage());
}

catch (Exception e){
display.setText("Error");
}

}

private void clearCalculator() {
   currentInput.setLength(0);
   result = 0;
   operator = "";
   display.setText("");
}

public static void main(String[] args){
  SwingUtilities.invokeLater(() -> {
         SimpleCalculator calculator = new SimpleCalculator();
         calculator.setVisible(true);

     });

  }

}




























