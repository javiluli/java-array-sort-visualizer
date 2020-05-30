package Sorts.Algoritmos;

import Adicionales.*;
import Interfaz.Sort;
import Principal.*;
import Sorts.Sorts;

public class Seleccion extends Sorts implements Sort {

	public Seleccion(Main m) {
		this.m = m;
		sort();
	}

	@Override
	public void sort() {
		m = new Main();
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
			m.textos();
			Main.getPanelBarras().repaint();
			Delay.delay();
		}
	}

	@Override
	public String getNombre() {
		return "Seleccion Sort";
	}

}
