package Algoritmos;

import javax.swing.JPanel;

import principal.*;

public class Inserccion extends Sorts implements Sort {

	public Inserccion(long accesoArray, long cambiosArray, JPanel panel, int[] n) {
		super(accesoArray, cambiosArray, panel, n);
		sort();
	}

	@Override
	public void sort() {
		inicio = System.currentTimeMillis();
		for (int i = 0; i < n.length; i++) {
			int pos = i;
			int aux = n[i];
			accesoArray++;
			while ((pos > 0) && (n[pos - 1] > aux)) {
				n[pos] = n[pos - 1];
				pos--;
				cambiosArray++;
			}

			n[pos] = aux;
			fin = System.currentTimeMillis();
			lblTexto();
			panel.repaint();
			Delay.delay();
		}
	}

	@Override
	public void lblTexto() {
		Main.lblCambios.setText("Cambios en el Array: " + cambiosArray);
		Main.lblAccesos.setText("Accesos al Array: " + accesoArray);
		cambioTiempoMedicion();
	}

	@Override
	public long calcularTiempo() {
		return tiempo = (fin - inicio);
	}

	@Override
	public void cambioTiempoMedicion() {
		if (calcularTiempo() <= 1000)
			Main.lblTiempo.setText("Tiempo real: " + calcularTiempo() + " ms");
		else if (calcularTiempo() > 1000)
			Main.lblTiempo.setText("Tiempo real: " + calcularTiempo() / 1000 + " s");
	}

	@Override
	public String getNombre() {
		return "Inserccion Sort";
	}
}