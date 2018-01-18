import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JApplet;

public class Main extends JApplet implements Runnable {
	Random pos = new Random();
	int x;
	int y;
	int blue;
	int yellow;
	int radius = 200;
	int fps = 120;
	int centerx = 200;
	int centery = 200;

	int blueNum = 0;
	int yellowNum = 0;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		setSize(400, 400);
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		Thread t = new Thread(this);
		t.start();
	}


	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		if (Math.pow((x - centerx), 2) + Math.pow((y - centery), 2) <= Math
				.pow(radius, 2)) {
			g.setColor(Color.BLUE);
			blueNum++;
		} else {
			g.setColor(Color.YELLOW);
			yellowNum++;
		}
		g.drawOval(x, y, 2, 2);
		g.fillOval(x, y, 2, 2);
		
		double pi = ((double)blueNum*4)/((double) blueNum+ (double) yellowNum);
		String piVal = String.format("The value of pi is %.5f", pi);
		
		showStatus(piVal);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			x = pos.nextInt(400);
			y = pos.nextInt(400);
			repaint();
			try {
				Thread.sleep(1000 / fps);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}