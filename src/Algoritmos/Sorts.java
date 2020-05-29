package Algoritmos;

import javax.swing.JPanel;

public class Sorts {
	protected static JPanel panel;
	protected static int[] n;
	protected static long accesoArray;
	protected static long cambiosArray;
	public static long inicio, fin, tiempo;

	public Sorts() {
		cambiosArray = 0;
		accesoArray = 0;
		tiempo = 0;
	}

	public Sorts(long accesoArray, long cambiosArray, JPanel panel, int[] n) {
		Sorts.panel = panel;
		Sorts.n = n;
		Sorts.accesoArray = accesoArray;
		Sorts.cambiosArray = cambiosArray;
	}

}
