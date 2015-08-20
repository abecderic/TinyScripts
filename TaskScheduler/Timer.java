import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Timer implements Runnable
{
	/** the interval the task should run; in milliseconds */
	private static final long INTERVAL = 15 * 60 * 1000;
	/** times to repeat; use -1 for infinity */
	private static final int AMOUNT = -1;
	private static DecimalFormat df = new DecimalFormat("#,##0");

	private long next = (System.currentTimeMillis() / INTERVAL) * INTERVAL + INTERVAL;
	private int iteration = 0;

	private Logger logger = Logger.getLogger("logger");

	public Timer()
	{
		FileHandler fh;
		try
		{  
			fh = new FileHandler(next + ".log");
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			logger.info("log starting");
		}
		catch (SecurityException e)
		{  
			e.printStackTrace();  
		}
		catch (IOException e)
		{  
			e.printStackTrace();  
		}
	}

	@Override
	public void run()
	{
		while (AMOUNT == -1 || iteration < AMOUNT)
		{
			logger.log(Level.INFO, "next scheduled for: " + new Date(next));
			int toSleep = (int)(next-System.currentTimeMillis());
			if (toSleep > 0)
			{
				try
				{
					Thread.sleep(toSleep);
				}
				catch (InterruptedException e)
				{
					logger.log(Level.WARNING, "sleep interrupt", e);
				}
			}

			logger.log(Level.INFO, "[RUN] " + iteration + " | " + new Date(System.currentTimeMillis()));

			try
			{
				/* #################### Action Here #################### */
				
				/* #################### Action End  #################### */
			}
			catch (Exception e)
			{
				logger.log(Level.SEVERE, "action exception", e);
			}

			logger.log(Level.INFO, "[END] " + iteration + " | took: " + df.format(System.currentTimeMillis()-next) + " ms");
			next += INTERVAL;
			iteration++;
		}
	}

	public static void main(String[] args)
	{
		Timer t = new Timer();
		Thread t2 = new Thread(t);
		t2.start();
	}
}
