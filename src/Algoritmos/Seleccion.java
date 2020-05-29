package Algoritmos;

import Adicionales.*;
import Principal.*;

public class Seleccion extends Sorts implements Sort {

	public Seleccion() {
		sort();
	}

	@Override
	public void sort() {
		setInicio(System.currentTimeMillis());
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

			setFin(System.currentTimeMillis());
			lblTexto();
			Main.getPanelBarras().repaint();
			Delay.delay();
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
			Main.getLblTiempo().setText("Tiempo real: " + calcularTiempo() + " ms");
		else if (calcularTiempo() > 1000)
			Main.getLblTiempo().setText("Tiempo real: " + calcularTiempo() / 1000 + " s");
	}

	@Override
	public String getNombre() {
		return "Seleccion Sort";
	}

}
