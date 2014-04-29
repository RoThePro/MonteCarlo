import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Main extends Applet implements Runnable {
	Random pos = new Random();
	int x;
	int y;
	int blue;
	int yellow;
	int radius = 400;
	int fps = 60;
	int centerx = 0;
	int centery = 400;

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

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		if (Math.pow((x - centerx), 2) + Math.pow((y - centery), 2) <= Math
				.pow(radius, 2)) {
			g.setColor(Color.BLUE);
		} else {
			g.setColor(Color.YELLOW);
		}
		g.drawOval(x, y, 2, 2);
		g.fillOval(x, y, 2, 2);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			x = pos.nextInt(radius);
			y = pos.nextInt(radius);
			System.out.println(x);
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
