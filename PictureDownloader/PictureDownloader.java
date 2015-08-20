import java.io.*;
import java.net.*;
import java.awt.image.*;
import javax.imageio.*;

public class PictureDownloader
{
  public static String URL;
  public static String URL_SUFFIX;
  public static int START_I;
  public static int END_I;
  public static String SAVE;
  
  public static void main(String[] args)
  {
    if (args.length != 4)
    {
      System.err.println("Usage: <url> <urlsuffix> <start-i> <end-i>");
      return;
    }
    URL = args[0];
    URL_SUFFIX = args[1];
    START_I = Integer.parseInt(args[2]);
    END_I = Integer.parseInt(args[3]);
    SAVE = System.getProperty("user.dir") + System.getProperty("file.separator");
    for (int i = START_I; i <= END_I; i++)
    {
      try
      {
        System.out.println("i: " + i);
        URL url = new URL(URL + i + URL_SUFFIX);
        InputStream is = url.openStream();
        BufferedImage image = ImageIO.read(is);
        ImageIO.write(image, "jpg", new File(SAVE + i + ".jpg"));
        is.close();
      }
      catch (Exception e)
      {
        System.err.println(e);
      }
    }
  }
}