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

			Delay.delay(1);
			lblTexto();
			panel.repaint();
		}
	}

	@Override
	public void lblTexto() {
		Main.lblCambios.setText("Cambios en el Array: " + cambiosArray);
		Main.lblAccesos.setText("Accesos al Array: " + accesoArray);
	}

	@Override
	public String getNombre() {
		return "Seleccion Sort";
	}

}
