import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Screen extends Canvas implements KeyListener {
		
	private Car carList[] = new Car[2];
	
	private BufferedImage image;
	private static final long serialVersionUID = 1L;
	
	public Screen() {
		try {
			image = ImageIO.read(new File("src/car.png"));
			
			addKeyListener(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		carList[0] = new Car(0, 0);
		carList[1] = new Car(0, 50);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(image, carList[0].x, carList[0].y, this);
		g.drawImage(image, carList[1].x, carList[1].y, this);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int gap = 10;
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_UP:
			carList[0].y -= gap;
			carList[1].y -= gap;
			break;
		case KeyEvent.VK_DOWN:
			carList[0].y += gap;
			carList[1].y += gap;
			break;
		case KeyEvent.VK_LEFT:
			carList[0].x -= gap;
			carList[1].x -= gap;
			break;
		case KeyEvent.VK_RIGHT:
			carList[0].x += gap;
			carList[1].x += gap;
			break;
		}
		System.out.println("car1: (" + carList[0].x + "," + carList[0].y + "), car2: (" + carList[1].x + "," + carList[1].y + ")");
		repaint();
	}
}

