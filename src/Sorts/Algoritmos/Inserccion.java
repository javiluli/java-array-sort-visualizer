package Sorts.Algoritmos;

import Interfaz.Sort;
import Principal.Main;
import Sorts.Sorts;

public class Inserccion extends Sorts implements Sort {

	public Inserccion(Main m) {
		this.m = m;
		sort();
	}

	@Override
	public void sort() {
		setInicio(System.currentTimeMillis());
		for (int i = 0; i < n.length; i++) {
			int pos = i;
			int aux = n[i];

			while ((pos > 0) && (n[pos - 1] > aux)) {
				n[pos] = n[pos - 1];
				pos--;
				cambiosArray++;
				accesoArray += 2;
				n[pos] = aux;
				m.updateAnimaciones();
			}
		}
	}

	@Override
	public String getNombre() {
		return "Inserccion Sort";
	}
}