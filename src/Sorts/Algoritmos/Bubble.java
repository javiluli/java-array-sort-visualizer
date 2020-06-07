package Sorts.Algoritmos;

import Interfaz.Sort;
import Principal.Barras;
import Principal.Main;
import Sorts.AdicionalesSorts;

public class Bubble extends AdicionalesSorts implements Sort {

	public Bubble(Main m, int[] n) {
		this.m = m;
		sort(n);
	}

	// @Override
	public void sort(int[] n) {
		setInicio(System.currentTimeMillis());
		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n.length - 1; j++) {
				if (n[j] > n[j + 1]) {
					int temp = n[j];
					n[j] = n[j + 1];
					n[j + 1] = temp;
					cambiosArray++;
				}
				accesoArray += 2;
				m.updateAnimaciones();
			}
			m.textos();
		}
		Barras.finSort = true;
	}

	@Override
	public String getNombre() {
		return "Bubble Sort";
	}
}
