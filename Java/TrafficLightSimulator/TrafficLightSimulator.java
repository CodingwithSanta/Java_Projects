import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLightSimulator extends JFrame implements ActionListener
{
 private JLabel messageLabel;
 private JRadioButton redButton, yellowButton, greenButton;
 private ButtonGroup buttonGroup;
 
 public TrafficLightSimulator()
 {
  setTitle("Traffic Light Simulator");
  setSize(300,200);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setLayout(new BorderLayout());

  messageLabel = new JLabel("",SwingConstants.CENTER);
  messageLabel.setFont(new Font("Arial",Font.BOLD,24));
  add(messageLabel,BorderLayout.NORTH);

  redButton = new JRadioButton("Red");
  yellowButton = new JRadioButton("Yellow");
  greenButton = new JRadioButton("Green");

  redButton.addActionListener(this);
  yellowButton.addActionListener(this);
  greenButton.addActionListener(this);

 buttonGroup = new ButtonGroup();
 buttonGroup.add (redButton);
 buttonGroup.add (yellowButton);
 buttonGroup.add (greenButton);

 JPanel buttonPanel = new JPanel();
 buttonPanel.setLayout(new GridLayout(1,3));
 buttonPanel.add(redButton);
 buttonPanel.add(yellowButton);
 buttonPanel.add(greenButton);
 add(buttonPanel,BorderLayout.CENTER);
}
@Override
public void actionPerformed(ActionEvent e)
{
 if(redButton.isSelected())
 {
  messageLabel.setText("Stop");
  messageLabel.setForeground(Color.RED);
 }
  else if(yellowButton.isSelected())
 {
  messageLabel.setText("Ready");
  messageLabel.setForeground(Color.YELLOW);
 }
  else if(greenButton.isSelected())
 {
  messageLabel.setText("Go");
  messageLabel.setForeground(Color.GREEN);
 }
}
public static void main(String[] args)
{
 SwingUtilities.invokeLater(() ->
 {
  TrafficLightSimulator simulator = new TrafficLightSimulator();
  simulator.setVisible(true);
 });
}
}
