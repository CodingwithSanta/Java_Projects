import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class MouseEventDemo
{
 public static void main(String[] args)
 {
  SwingUtilities.invokeLater(MouseEventDemo::createAndShowGUI);
 }
  private static void createAndShowGUI()
  {
   JFrame frame = new JFrame("Mouse Event Demo");
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setSize(400,300);
   frame.setLocationRelativeTo(null);
   
   MousePanel mousePanel = new MousePanel();
   frame.add(mousePanel);
   
   frame.setVisible(true);
  }
}
 class MousePanel extends JPanel
 {
  private String eventName = "";
  
  public MousePanel()
  {
   addMouseListener(new MouseAdapter()
   {
    @Override
    public  void mouseClicked(MouseEvent e)
    {
     eventName = "Mouse Clicked";
     repaint();
    }
    @Override
    public  void mousePressed(MouseEvent e)
    {
     eventName = "Mouse Pressed";
     repaint();
    }
    @Override
    public  void mouseReleased(MouseEvent e)
    {
     eventName = "Mouse Released";
     repaint();
    }
    @Override
    public  void mouseEntered(MouseEvent e)
    {
     eventName = "Mouse Entered";
     repaint();
    }
    @Override
    public  void mouseExited(MouseEvent e)
    {
     eventName = "Mouse Exited";
     repaint();
    }
   });
   addMouseMotionListener(new MouseAdapter()
   {
    @Override
    public void mouseDragged(MouseEvent e)
    {
     eventName = "Mouse Dragged";
     repaint();
    }
    @Override
    public void mouseMoved(MouseEvent e)
    {
     eventName = "Mouse Moved";
     repaint();
    }
   });
  }
  @Override
  protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   drawCenteredString(g, eventName, getWidth(), getHeight());
  }
  private void drawCenteredString(Graphics g, String text, int width, int height)
  {
   FontMetrics metrics = g.getFontMetrics(g.getFont());
   int x = (width - metrics.stringWidth(text))/2;
   int y = ((height - metrics.getHeight()) / 2) + metrics.getAscent();
   g.drawString(text,x,y);
  }
 }
