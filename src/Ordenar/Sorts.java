package Ordenar;

import Principal.MainAplicacion;

public class Sorts {
//	protected static JPanel panel;
	public static int[] n;
	protected static long accesoArray;
	protected static long cambiosArray;
	protected static long inicio;
	protected long fin;
	protected long tiempo;
	public MainAplicacion m;

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
		this.tiempo = tiempo;
	}

	public long getFin() {
		return fin;
	}

	public void setFin(long fin) {
		this.fin = fin;
	}

}
