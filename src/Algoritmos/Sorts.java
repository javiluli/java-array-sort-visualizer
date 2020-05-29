package Algoritmos;

import javax.swing.JPanel;

public abstract class Sorts {
	protected static JPanel panel;
	protected static int[] n;
	protected static long accesoArray;
	protected static long cambiosArray;

	public Sorts(long accesoArray, long cambiosArray, JPanel panel, int[] n) {
		Sorts.panel = panel;
		Sorts.n = n;
		Sorts.accesoArray = accesoArray;
		Sorts.cambiosArray = cambiosArray;
	}
}
