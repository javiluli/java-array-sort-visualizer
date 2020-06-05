package Sorts;

import Interfaz.Sort;
import Principal.Barras;
import Principal.Main;

public class FinSort extends Sorts implements Sort {

	public FinSort(Main m) {
		this.m = m;
		sort();
	}

	@Override
	public void sort() {
		for (int i = 0; i < n.length; i++) {
			Barras.mismo = i + 1;
			Barras.anterioresMismo = i;
			m.updateAnimaciones();
		}
		Barras.finSort = false;
		m.updateAnimaciones();
	}

	@Override
	public String getNombre() {
		return null;
	}
}
