package Sorts.Algoritmos;

import Adicionales.*;
import Interfaz.Sort;
import Principal.*;
import Sorts.Sorts;

public class Bubble extends Sorts implements Sort {

	public Bubble() {
		sort();
	}

	// @Override
	public void sort() {
		setInicio(System.currentTimeMillis());
		for (int i = 0; i < n.length; i++) {
			accesoArray++;
			for (int j = 0; j < n.length - 1 - i; j++) {
				accesoArray++;
				if (Sorts.n[j] > n[j + 1]) {
					int temp = n[j];
					n[j] = n[j + 1];
					n[j + 1] = temp;
					cambiosArray++;
				}
				lblTexto();
				setFin(System.currentTimeMillis());
				Main.getPanelBarras().repaint();
				Delay.delay();
			}
			lblTexto();
		}
	}

	@Override
	public void lblTexto() {
		Main.getLblCambios().setText("Cambios en el Array: " + cambiosArray);
		Main.getLblAccesos().setText("Accesos al Array: " + accesoArray);
		Main.getLblMemoriaMax().setText("Memoria maxima: " + Memoria.max() + " MB");
		Main.getLblMemoriaTotal().setText("Memoria total: " + Memoria.total() + " MB");
		Main.getLblMemoriaLibre().setText("Memoria libre: " + Memoria.libre() + " MB");
		Main.getLblMemoriaUsada().setText("Memoria usada: " + Memoria.usada() + " MB");
		cambioTiempoMedicion();
	}

	@Override
	public long calcularTiempo() {
		return setTiempo((getFin() - getInicio()));
	}

	@Override
	public void cambioTiempoMedicion() {
		if (calcularTiempo() <= 1000)
			Main.getLblTiempo().setText("Tiempo: " + calcularTiempo() + " ms");
		else if (calcularTiempo() > 1000)
			Main.getLblTiempo().setText("Tiempo: " + calcularTiempo() / 1000 + " s");
	}

	@Override
	public String getNombre() {
		return "Bubble Sort";
	}
}
