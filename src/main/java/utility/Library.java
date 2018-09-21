package utility;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Library {
	public static String takeScreenshot(String screenname)
	{
		try {
			Robot r=new Robot();
			BufferedImage bi=r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(bi, "png", new File(".\\screenshot\\"+screenname+".png"));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return screenname;
		
	}

}
