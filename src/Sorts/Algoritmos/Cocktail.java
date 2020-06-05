package Sorts.Algoritmos;

import Interfaz.Sort;
import Principal.Barras;
import Principal.Main;
import Sorts.Sorts;

public class Cocktail extends Sorts implements Sort {

	public Cocktail(Main m) {
		this.m = m;
		sort();
	}

	@Override
	public void sort() {
		boolean cambiar = true;
		int inicio = 0;
		int fin = n.length;

		setInicio(System.currentTimeMillis());
		while (cambiar == true) {
			cambiar = false;
			for (int i = inicio; i < fin - 1; ++i) {
				accesoArray++;
				if (n[i] > n[i + 1]) {
					int temp = n[i];
					n[i] = n[i + 1];
					n[i + 1] = temp;
					cambiar = true;
					cambiosArray++;
				}
				m.updateAnimaciones();
			}

			if (cambiar == false)
				break;

			cambiar = false;
			fin = fin - 1;

			for (int i = fin - 1; i >= inicio; i--) {
				accesoArray++;
				if (n[i] > n[i + 1]) {
					int temp = n[i];
					n[i] = n[i + 1];
					n[i + 1] = temp;
					cambiar = true;
					cambiosArray++;
				}
				m.updateAnimaciones();
			}
			inicio = inicio + 1;
		}
		Barras.finSort = true;
	}

	@Override
	public String getNombre() {
		return "Cocktail Sort";
	}
}
