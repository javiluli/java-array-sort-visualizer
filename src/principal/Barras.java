package principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Barras extends JPanel {
	public final static int WIN_WIDTH = 964;
	public final static int WIN_HEIGHT = 681;
	public final static int BAR_WIDTH = 2;
	public final static int NUM_BARS = WIN_WIDTH / BAR_WIDTH;
	public final static int BAR_HEIGHT = WIN_HEIGHT / NUM_BARS;
	public static int[] n;

	/**
	 * Constructor de iniciar el array con numeros ordenados.
	 */
	public Barras() {
		n = new int[NUM_BARS];
		for (int i = 0; i < NUM_BARS; i++) {
			n[i] = i;
		}
		setBackground(Color.DARK_GRAY);
	}

	/**
	 * Desordena un Array.
	 *
	 * @param p el JFrame principal
	 */
	public void shuffleArray(JPanel panel) {
		Random rng = new Random();
		for (int i = 0; i < NUM_BARS; i++) {
			int swapWidthIndex = rng.nextInt(NUM_BARS - 1);
			int temp = n[i];
			n[i] = n[swapWidthIndex];
			n[swapWidthIndex] = temp;
			panel.repaint();
		}
	}

	public static int mismo;

	/**
	 * Pinta los componentes.
	 *
	 * @param g the g
	 */
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D graphics = (Graphics2D) g;
		super.paintComponent(graphics);
		for (int i = 0; i < NUM_BARS; i++) {
			graphics.setColor(Color.WHITE);
//			if (i == mismo)
//				graphics.setColor(Color.red);

			int height = n[i] * BAR_HEIGHT;
			int xBegin = i + (BAR_WIDTH - 1) * i;
			int yBegin = WIN_HEIGHT - height;
			graphics.fillRect(xBegin, yBegin, BAR_WIDTH, height);
		}
	}

	/**
	 * Gets the preferred size.
	 *
	 * @return the preferred size
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(WIN_WIDTH, WIN_HEIGHT);
	}

}
