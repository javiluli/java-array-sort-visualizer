package EstilosGraficos;

import javax.swing.JPanel;

public abstract class EstiloGrafico extends JPanel {
	private static final long serialVersionUID = 1L;

	public final static int WIN_WIDTH = 1024;
	public final static int WIN_HEIGHT = WIN_WIDTH;
	public static int NUM_BARS = 32;
	public static int BAR_WIDTH = WIN_WIDTH / NUM_BARS;
	public static int BAR_HEIGHT = WIN_HEIGHT / NUM_BARS;
	public boolean activarMulticolor = false;

	public static int mismo;
	public static int anterioresMismo;
	public static boolean finSort = false;

	// Medidas y posicion de los graficos
	public int height, xBegin, yBegin;
}
