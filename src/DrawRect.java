import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class DrawRect extends JPanel {
	
	public static final int HEIGHT = 900;
	public static final int WIDTH = 30;
	public static final Color RECT_COLOR = new Color(135, 206, 235);
	
	ArrayList<Integer> arr;
	
	public DrawRect(ArrayList<Integer> heights) {
		// Deep Cloning
		arr = new ArrayList<>();
		for (int i = 0; i < heights.size(); i++)
			arr.add(heights.get(i));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D graphics = (Graphics2D) g;
		super.paintComponent(graphics);
		for (int i = 0, x = 5; x <= 1600; x += WIDTH + 5, i++) {
			int y = arr.get(i);
			graphics.setColor(RECT_COLOR);
			graphics.fillRect(x, y, WIDTH, HEIGHT);
		}
	}
}
