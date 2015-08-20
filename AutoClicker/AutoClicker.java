import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;

public class AutoClicker
{
  private static final String U = "usage: AutoClicker <left/right> [<amount/-1=infty> <delayInbetweenClicks>]";
  
  public static void main(String[] args)
  {
    int amount = -1;
    int delay = 20;
    if (args.length != 1)
    {
      if (args.length != 3)
      {
        System.out.println(U);
        return;
      }
      try
      {
        amount = Integer.parseInt(args[1]);
        delay = Integer.parseInt(args[2]);
      }
      catch (NumberFormatException e)
      {
        System.out.println(U);
        return;
      }
    }
    Robot r = null;
    try
    {
      r = new Robot();
    }
    catch (AWTException e)
    {
      System.err.println("robot doesn't work on your system :(");
      return;
    }
    r.setAutoDelay(delay);
    int i = 0;
    int b = 0;
    if (args[0].equals("left")) b = 1024;
    else if (args[0].equals("right")) b = 2048;
    else
    {
      System.out.println(U);
      return;
    }
    System.out.println("sleeping for 5 seconds...");
    try
    {
      Thread.sleep(5000);
    }
    catch (Exception e) {}
    int x = MouseInfo.getPointerInfo().getLocation().x;
    int y = MouseInfo.getPointerInfo().getLocation().y;
    System.out.println("starting at " + x + "|" + y);
    while (amount == -1 || i < amount)
    {
      if (Math.abs(x-MouseInfo.getPointerInfo().getLocation().x) > 10 || Math.abs(y-MouseInfo.getPointerInfo().getLocation().y) > 10)
      {
        break;
      }
      r.mousePress(b);
      r.mouseRelease(b);
      i++;
    }
    System.out.println("done");
  }
}