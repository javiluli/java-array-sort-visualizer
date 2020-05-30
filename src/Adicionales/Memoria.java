package Adicionales;

public class Memoria {
	public int total;
	public int max;
	public int libre;
	public int usada;
	private final int MEGABYTES = (int) Math.pow(1024, 2);
	Runtime runtime = Runtime.getRuntime();

	public Memoria() {
		max();
		total();
		libre();
		usada();
	}

	public Memoria(int n) {
		this.max = n;
		this.total = n;
		this.libre = n;
		this.usada = n;
	}

	public void max() {
		max = (int) (runtime.maxMemory() / MEGABYTES);
	}

	public void total() {
		total = (int) (runtime.totalMemory() / MEGABYTES);
	}

	public void libre() {
		libre = (int) (runtime.freeMemory() / MEGABYTES);
	}

	public void usada() {
		usada = (int) ((runtime.totalMemory() - runtime.freeMemory()) / MEGABYTES);
	}

}
