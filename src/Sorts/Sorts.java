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
	}

	public Sorts(int n) {
		cambiosArray = n;
		accesoArray = n;
		inicio = 0;
		fin = 0;
		tiempo = n;
	}

	public long getInicio() {
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

	public long getFin() {
		return fin;
	}

	public void setFin(long fin) {
		Sorts.fin = fin;
	}

}
