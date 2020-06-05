package Sorts.Algoritmos;

import Interfaz.Sort;
import Principal.Barras;
import Principal.Main;
import Sorts.Sorts;

public class Gnome extends Sorts implements Sort {
	public Gnome(Main m) {
		this.m = m;
		sort();
	}

	@Override
	public void sort() {
		setInicio(System.currentTimeMillis());
		int index = 0;
		while (index < n.length) {
			accesoArray++;
			if (index == 0)
				index++;
			if (n[index] >= n[index - 1])
				index++;
			else {
				int temp = 0;
				temp = n[index];
				n[index] = n[index - 1];
				n[index - 1] = temp;
				index--;
				cambiosArray++;
			}
			m.updateAnimaciones();
		}
		Barras.finSort = true;
	}

	@Override
	public String getNombre() {
		return "Gnome Sort";
	}

}
