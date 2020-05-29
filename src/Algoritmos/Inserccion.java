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
		return "Inserccion Sort";
	}
}