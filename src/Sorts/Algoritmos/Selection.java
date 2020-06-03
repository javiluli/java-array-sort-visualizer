package Sorts.Algoritmos;

import Interfaz.Sort;
import Principal.Main;
import Sorts.Sorts;

public class Selection extends Sorts implements Sort {

	public Selection(Main m) {
		this.m = m;
		sort();
	}

	@Override
	public void sort() {
		m = new Main();
		setInicio(System.currentTimeMillis());
		for (int i = 0; i < n.length; i++) {
			int min = i;

			for (int j = i + 1; j < n.length; j++) {
				if (n[j] < n[min]) {
					min = j;
					cambiosArray++;
				}
				accesoArray += 2;
			}
			int aux = n[i];
			n[i] = n[min];
			n[min] = aux;

			m.updateAnimaciones();
		}
	}

	@Override
	public String getNombre() {
		return "Seleccion Sort";
	}

}
