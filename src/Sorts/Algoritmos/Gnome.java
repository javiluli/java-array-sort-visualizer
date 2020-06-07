package Sorts.Algoritmos;

import Interfaz.Sort;
import Principal.Barras;
import Principal.Main;
import Sorts.AdicionalesSorts;

public class Gnome extends AdicionalesSorts implements Sort {
	public Gnome(Main m, int[] n) {
		this.m = m;
		sort(n);
	}

	@Override
	public void sort(int[] n) {
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
