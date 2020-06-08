package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class Gnome extends AdicionalesSorts implements ISort {
	public Gnome(MainAplicacion m, int[] n) {
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
		DibujarGraficos.finSort = true;
	}
}
