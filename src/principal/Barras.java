package Principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

import Adicionales.Delay;
import Sorts.Sorts;

public class Barras extends JPanel {
	private static final long serialVersionUID = 1L;
	final static int WIN_WIDTH = 964;
	final static int WIN_HEIGHT = 681;
	static int BAR_WIDTH = 4;
	static int NUM_BARS = WIN_WIDTH / BAR_WIDTH;
	static int BAR_HEIGHT = WIN_HEIGHT / NUM_BARS;

	/**
	 * Constructor de iniciar el array con numeros ordenados.
	 */
	public Barras() {
		barras();
		setBackground(Color.BLACK);
	}

	/**
	 * Constructor de iniciar el array con numeros ordenados.
	 */
	public void barras() {
		Sorts.n = new int[NUM_BARS];
		for (int i = 0; i < NUM_BARS; i++) {
			Sorts.n[i] = i;
		}
	}

	/**
	 * Desordena un Array.
	 *
	 * @param p el JFrame principal
	 */
	public void shuffleArray() {
		Random rng = new Random();
		for (int i = 0; i < NUM_BARS; i++) {
			int swapWidthIndex = rng.nextInt(NUM_BARS - 1);
			int temp = Sorts.n[i];
			Sorts.n[i] = Sorts.n[swapWidthIndex];
			Sorts.n[swapWidthIndex] = temp;
			Delay.delay(1);
			Main.getPanelBarras().repaint();
		}
	}

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
			int height = Sorts.n[i] * BAR_HEIGHT;
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
