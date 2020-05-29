package Principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

import Adicionales.Delay;

public class Barras extends JPanel {
	private static final long serialVersionUID = 1L;
	final static int WIN_WIDTH = 964;
	final static int WIN_HEIGHT = 681;
	static int NUM_BARS = WIN_WIDTH / Main.BAR_WIDTH;
	static int BAR_HEIGHT = WIN_HEIGHT / NUM_BARS;
	private static int[] n;

	/**
	 * Constructor de iniciar el array con numeros ordenados.
	 */
	public Barras() {
		barras();
		setBackground(Color.DARK_GRAY);
	}

	/**
	 * Constructor de iniciar el array con numeros ordenados.
	 */
	public void barras() {
		setN(new int[NUM_BARS]);
		for (int i = 0; i < NUM_BARS; i++) {
			getN()[i] = i;
		}
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
			int temp = getN()[i];
			getN()[i] = getN()[swapWidthIndex];
			getN()[swapWidthIndex] = temp;
			Delay.delay(1);
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

			int height = getN()[i] * BAR_HEIGHT;
			int xBegin = i + (Main.BAR_WIDTH - 1) * i;
			int yBegin = WIN_HEIGHT - height;
			graphics.fillRect(xBegin, yBegin, Main.BAR_WIDTH, height);
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

	public static int[] getN() {
		return n;
	}

	public static void setN(int[] n) {
		Barras.n = n;
	}

}
