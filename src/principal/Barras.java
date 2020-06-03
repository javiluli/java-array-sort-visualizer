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
	private final static int WIN_WIDTH = 1024;
	private final static int WIN_HEIGHT = 1024;
	private static int NUM_BARS = 32;
	private static int BAR_WIDTH = getWinWidth() / getNUM_BARS();
	private static int BAR_HEIGHT = getWinHeight() / getNUM_BARS();

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
		Sorts.n = new int[getNUM_BARS()];
		for (int i = 0; i < getNUM_BARS(); i++) {
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
		for (int i = 0; i < getNUM_BARS(); i++) {
			int swapWidthIndex = rng.nextInt(getNUM_BARS() - 1);
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
		graphics.setColor(Color.WHITE);
		int opcionGrafico = Main.getComboboxtiposgraficos().getSelectedIndex();
		if (opcionGrafico == 0)
			pintarPiramide(graphics);
		else if (opcionGrafico == 1)
			pintarPiramideHorizontal(graphics);
		else if (opcionGrafico == 2)
			pintarCuadrados(graphics);
	}

	private void pintarPiramide(Graphics2D graphics) {
		for (int i = 0; i < getNUM_BARS(); i++) {
			int height = (Sorts.n[i] * getBAR_HEIGHT()) + getBAR_HEIGHT();
			int xBegin = i + (getBAR_WIDTH() - 1) * i;
			int yBegin = getWinHeight() - height;
			graphics.fillRect(xBegin, yBegin, getBAR_WIDTH(), height);
		}
	}

	private void pintarPiramideHorizontal(Graphics2D graphics) {
		for (int i = 0; i < getNUM_BARS(); i++) {
			int height = (Sorts.n[i] * getBAR_HEIGHT()) + getBAR_HEIGHT();
			int xBegin = i + (getBAR_WIDTH() - 1) * i;
			int yBegin = ((getWinHeight() - height) / 2);
			graphics.fillRect(xBegin, yBegin, getBAR_WIDTH(), height);
		}
	}

	private void pintarCuadrados(Graphics2D graphics) {
		for (int i = 0; i < getNUM_BARS(); i++) {
			int xBegin = i + (getBAR_WIDTH() - 1) * i;
			int auxDistancia = (Sorts.n[i] * getBAR_HEIGHT()) + getBAR_HEIGHT();
			int yBegin = getWinHeight() - auxDistancia;
			graphics.fillRect(xBegin, yBegin, getBAR_HEIGHT(), getBAR_HEIGHT());
		}
	}

	/**
	 * Gets the preferred size.
	 *
	 * @return the preferred size
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(getWinWidth(), getWinHeight());
	}

	public static int getWinWidth() {
		return WIN_WIDTH;
	}

	public static int getWinHeight() {
		return WIN_HEIGHT;
	}

	public static int getNUM_BARS() {
		return NUM_BARS;
	}

	public static void setNUM_BARS(int nUM_BARS) {
		NUM_BARS = nUM_BARS;
	}

	public static int getBAR_WIDTH() {
		return BAR_WIDTH;
	}

	public static void setBAR_WIDTH(int bAR_WIDTH) {
		BAR_WIDTH = bAR_WIDTH;
	}

	public static int getBAR_HEIGHT() {
		return BAR_HEIGHT;
	}

	public static void setBAR_HEIGHT(int bAR_HEIGHT) {
		BAR_HEIGHT = bAR_HEIGHT;
	}
}
