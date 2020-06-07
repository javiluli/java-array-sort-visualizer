package Sorts;

import Interfaz.Sort;
import Principal.Barras;
import Principal.Main;

public class FinSort extends AdicionalesSorts implements Sort {

	public FinSort(Main m, int [] n) {
		this.m = m;
		sort(n);
	}

	@Override
	public void sort(int [] n) {
		for (int i = 0; i < n.length; i++) {
			Barras.mismo = i + 1;
			Barras.anterioresMismo = i;
			m.updateAnimacionesSinTiempo();
		}
		Barras.finSort = false;
		m.updateAnimacionesSinTiempo();
	}

	@Override
	public String getNombre() {
		return null;
	}
}
