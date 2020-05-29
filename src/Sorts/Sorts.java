package Sorts;

public class Sorts {
//	protected static JPanel panel;
	public static int[] n;
	protected long accesoArray;
	protected long cambiosArray;
	private static long inicio, fin, tiempo;

	public Sorts() {
		cambiosArray = 0;
		accesoArray = 0;
		setTiempo(0);
	}

	public static long getInicio() {
		return inicio;
	}

	public static void setInicio(long inicio) {
		Sorts.inicio = inicio;
	}

	public static long getTiempo() {
		return tiempo;
	}

	public static long setTiempo(long tiempo) {
		Sorts.tiempo = tiempo;
		return tiempo;
	}

	public static long getFin() {
		return fin;
	}

	public static void setFin(long fin) {
		Sorts.fin = fin;
	}

}
