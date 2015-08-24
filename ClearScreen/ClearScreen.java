import java.awt.Color;
import javax.swing.JFrame;

public class ClearScreen extends JFrame
{
  private static Color c = Color.BLACK;
  
  public ClearScreen()
  { 
    super("ClearScreen");
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setUndecorated(true); 
    if (c.getAlpha() == 255) getContentPane().setBackground(c);
    else setBackground(c);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setVisible(true);
  }
  
  public static void main(String[] args)
  {
    if (args.length == 3 || args.length == 4)
    {
      try
      {
        int r = Integer.parseInt(args[0],16);
        int g = Integer.parseInt(args[1],16);
        int b = Integer.parseInt(args[2],16);
        if (args.length == 4)
        {
          int a = Integer.parseInt(args[3],16);
          c = new Color(r, g, b, a);
        }
        else c = new Color(r, g, b);
      }
      catch (NumberFormatException e) { /* NO-OP*/ }
    }
    new ClearScreen();
  }
}
