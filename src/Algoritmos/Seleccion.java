package Algoritmos;

import javax.swing.JPanel;

import principal.*;

public class Seleccion extends Sorts implements Sort {

	public Seleccion(long accesoArray, long cambiosArray, JPanel panel, int[] n) {
		super(accesoArray, cambiosArray, panel, n);
		sort();
	}

	@Override
	public void sort() {
		inicio = System.currentTimeMillis();
		for (int i = 0; i < n.length; i++) {
			int min = i;
			accesoArray++;
			for (int j = i + 1; j < n.length; j++) {
				accesoArray++;
				if (n[j] < n[min]) {
					min = j;
					cambiosArray++;
				}
			}
			int aux = n[i];
			n[i] = n[min];
			n[min] = aux;

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
		return "Seleccion Sort";
	}

}
