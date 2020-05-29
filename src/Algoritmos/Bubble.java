package Algoritmos;

import javax.swing.JPanel;

import Adicionales.*;
import Principal.*;

public class Bubble extends Sorts implements Sort {

//	Sorts s;
	Memoria memoria;

	public Bubble(long accesoArray, long cambiosArray, JPanel panel, int[] n) {
		super(accesoArray, cambiosArray, panel, n);
		sort();
	}

	// @Override
	public void sort() {
		inicio = System.currentTimeMillis();
		for (int i = 0; i < n.length; i++) {
			accesoArray++;
			for (int j = 0; j < n.length - 1 - i; j++) {
				accesoArray++;
				if (n[j] > n[j + 1]) {
					int temp = n[j];
					n[j] = n[j + 1];
					n[j + 1] = temp;
					cambiosArray++;
				}
				lblTexto();
				fin = System.currentTimeMillis();
				panel.repaint();
				Delay.delay();
			}
			lblTexto();
		}
	}

	@Override
	public void lblTexto() {
		Main.lblCambios.setText("Cambios en el Array: " + cambiosArray);
		Main.lblAccesos.setText("Accesos al Array: " + accesoArray);
		Main.lblMemoriaMax.setText("Memoria maxima: " + Memoria.max() + " MB");
		Main.lblMemoriaTotal.setText("Memoria total: " + Memoria.total() + " MB");
		Main.lblMemoriaLibre.setText("Memoria libre: " + Memoria.libre() + " MB");
		Main.lblMemoriaUsada.setText("Memoria usada: " + Memoria.usada() + " MB");
		cambioTiempoMedicion();
	}

	@Override
	public long calcularTiempo() {
		return tiempo = (fin - inicio);
	}

	@Override
	public void cambioTiempoMedicion() {
		if (calcularTiempo() <= 1000)
			Main.lblTiempo.setText("Tiempo: " + calcularTiempo() + " ms");
		else if (calcularTiempo() > 1000)
			Main.lblTiempo.setText("Tiempo: " + calcularTiempo() / 1000 + " s");
	}

	@Override
	public String getNombre() {
		return "Bubble Sort";
	}
}
