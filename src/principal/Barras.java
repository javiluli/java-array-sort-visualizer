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
	private boolean marcarSepacaion = false;

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

		for (int i = 0; i < getNUM_BARS(); i++) {
			comunes(i, graphics, opcionGrafico);
		}
	}

	private void comunes(int i, Graphics2D graphics, int opcionGrafico) {
		int height = 0, xBegin = 0, yBegin = 0;
		height = (Sorts.n[i] * getBAR_HEIGHT()) + getBAR_HEIGHT();
		xBegin = i + (getBAR_WIDTH() - 1) * i;
		// --------------------------------------------------------------------------------------------

		// SELECCION ENTRE EL ESTILO GRAFICO DE "ESCALERAS" Y "PIRAMIDE HORIZONTAL"
		if (opcionGrafico == 1) { // GRAFICOS "Piramide horizontal"
			// Al dividir entre 2 de divide el espacio entre las barras y los lados de la
			// ventana.
			yBegin = ((getWinHeight() - height) / 2);
		} else if (opcionGrafico != 1) { // GRAFICOS "Escalera"
			yBegin = ((getWinHeight() - height));
		}
		// --------------------------------------------------------------------------------------------

		// SELECCION ENTRE LOS DISTINTOS TIPOS DE ESTILOS GRAFICOS
		if (opcionGrafico == 0 || opcionGrafico == 1) { // GRAFICOS "Escalera" Y "Piramide horizontal"
			if (marcarSepacaion) { // EFECTO GRAFICO CON EL CONTORNO BARRAS
				graphics.fill3DRect(xBegin, yBegin, getBAR_WIDTH(), height, true);
			} else if (!marcarSepacaion) { // EFECTO GRAFICO SIN EL CONTORNO BARRAS
				graphics.fillRect(xBegin, yBegin, getBAR_HEIGHT(), height);
			}
		} else if (opcionGrafico == 2) { // GRAFICOS "Cuadrado"
			graphics.fillRect(xBegin, yBegin, getBAR_HEIGHT(), getBAR_HEIGHT());
		} else if (opcionGrafico == 3) { // GRAFICOS "Punto"
			graphics.fillOval(xBegin, yBegin, getBAR_HEIGHT(), getBAR_HEIGHT());
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

	public boolean isMarcarSepacaion() {
		return marcarSepacaion;
	}

	public void setMarcarSepacaion(boolean marcarSepacaion) {
		this.marcarSepacaion = marcarSepacaion;
	}
}
