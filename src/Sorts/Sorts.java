package Sorts;

import Principal.Main;

public class Sorts {
//	protected static JPanel panel;
	public static int[] n;
	protected static long accesoArray;
	protected static long cambiosArray;
	protected static long inicio;
	protected static long fin;
	protected static long tiempo;
	public Main m;

	public Sorts() {
		cambiosArray = 0;
		accesoArray = 0;
		tiempo = 0;
	}

	public static long getInicio() {
		return inicio;
	}

	public void setInicio(long inicio) {
		Sorts.inicio = inicio;
	}

	public long getTiempo() {
		return tiempo;
	}

	public void setTiempo(long tiempo) {
		Sorts.tiempo = tiempo;
	}

	public static long getFin() {
		return fin;
	}

	public void setFin(long fin) {
		Sorts.fin = fin;
	}

}
