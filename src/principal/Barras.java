package Principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import java.util.Vector;

import Adicionales.Delay;
import EstilosGraficos.*;
import Sorts.Sorts;

public class Barras extends Transfomaciones {
	private static final long serialVersionUID = 1L;
	EstiloGrafico estiloGrafico;

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
	public void desordenarArray() {
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
		int opcionGrafico = Main.getComboboxtiposgraficos().getSelectedIndex();
		configEstilo(opcionGrafico, graphics);

		for (int i = 0; i < NUM_BARS; i++) {
			// Activar el modo multiculor.
			if (activarMulticolor)
				graphics.setPaint(getGradientPaint(i, Sorts.n[i], BAR_WIDTH));
			// Color por defecto de todos los graficos.
			else
				graphics.setColor(Color.WHITE);

			// Animacion de final del Sort.
			if (finSort) {
				if (mismo == i)
					graphics.setColor(Color.red);
				else if (anterioresMismo >= i)
					graphics.setColor(Color.green);
			}

			// Selecciona el tipo de grafico.
			menuSeleccionGraficos(opcionGrafico, i, graphics);
		}
	}

	/**
	 * Almacenar estilos.
	 *
	 * @return the vector
	 */
	public Vector<EstiloGrafico> almacenarEstilos() {
		Vector<EstiloGrafico> estilos = new Vector<EstiloGrafico>();
		estilos.add(estiloGrafico = new Columnas());
		estilos.add(estiloGrafico = new Piramide());
		estilos.add(estiloGrafico = new Pixel());
		estilos.add(estiloGrafico = new Circulo());
		estilos.add(estiloGrafico = new Circunferencia());
		estilos.add(estiloGrafico = new Espital());
		return estilos;
	}

	/**
	 * Configuraciones.
	 *
	 * @param opcionGrafico the opcion grafico
	 * @param graphics      the graphics
	 */
	private void configEstilo(int opcionGrafico, Graphics2D graphics) {
		Vector<EstiloGrafico> estilos = almacenarEstilos();
		// Cambio la cantidad de elementos que se pintan en pantalla.
		// Simepre que sean Objetos Transfomaciones tendran multicolor.
		if (estilos.get(opcionGrafico) instanceof Transfomaciones) {
			graphics.translate(translateX, translateY);
			Main.getSliderTamBarras().setMinimum(6);
			activarMulticolor = true;
			Main.tglbtnMulticolor.setSelected(activarMulticolor);
		} else {
			Main.getSliderTamBarras().setMinimum(1);

		}
	}

	/**
	 * Selecciona y crea un Objeto del estilo seleccionado.
	 *
	 * @param opcionGrafico the opcion grafico
	 * @param i             the i
	 * @param graphics      the graphics
	 */
	private void menuSeleccionGraficos(int opcionGrafico, int i, Graphics2D graphics) {
		switch (opcionGrafico) {
		case 0:
			estiloGrafico = new Columnas(i, graphics);
			break;
		case 1:
			estiloGrafico = new Piramide(i, graphics);
			break;
		case 2:
			estiloGrafico = new Pixel(i, graphics);
			break;
		case 3:
			estiloGrafico = new Circulo(graphics);
			break;
		case 4:
			estiloGrafico = new Circunferencia(i, graphics);
			break;
		case 5:
			estiloGrafico = new Espital(i, graphics);
			break;
		}
	}

	protected GradientPaint getGradientPaint(int position, int value, int columnWidth) {
		float startH = value / (NUM_BARS * 1f);
		float finishH = (value + 1) / (NUM_BARS * 1f);
		float S = 1; // Saturacion
		float B = 1; // Brillo
		Color startColor = Color.getHSBColor(startH, S, B);
		Color finishColor = Color.getHSBColor(finishH, S, B);
		int x = 2 * BAR_WIDTH + columnWidth * position;
		return new GradientPaint(x, 0, startColor, x + columnWidth, 0, finishColor);
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

	public static void setBAR_WIDTH(int bAR_WIDTH) {
		BAR_WIDTH = bAR_WIDTH;
	}

	public static void setBAR_HEIGHT(int bAR_HEIGHT) {
		BAR_HEIGHT = bAR_HEIGHT;
	}
}
