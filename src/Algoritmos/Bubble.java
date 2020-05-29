package Algoritmos;

import javax.swing.JPanel;

import principal.*;

public class Bubble extends Sorts implements Sort {

	public Bubble(long accesoArray, long cambiosArray, JPanel panel, int[] n) {
		super(accesoArray, cambiosArray, panel, n);
		sort();
	}

	// @Override
	public void sort() {
		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n.length - 1 - i; j++) {
				if (n[j] > n[j + 1]) {
					int temp = n[j];
					n[j] = n[j + 1];
					n[j + 1] = temp;
					cambiosArray++;
				}
//				Barras.mismo = j + 1;
				accesoArray++;
				lblTexto();
				Delay.delay(1);
				panel.repaint();
			}
			accesoArray++;
			lblTexto();
		}
		pintar();
	}

	public void pintar() {
		for (int i = 0; i < n.length; i++) {
			Barras.mismo = i;

		}

	}

	@Override
	public void lblTexto() {
		Main.lblCambios.setText("Cambios en el Array: " + cambiosArray);
		Main.lblAccesos.setText("Accesos al Array: " + accesoArray);
	}

	@Override
	public String getNombre() {
		return "Bubble Sort";
	}
}
