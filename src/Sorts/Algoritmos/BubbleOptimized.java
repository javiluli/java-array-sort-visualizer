package Sorts.Algoritmos;

import Interfaz.Sort;
import Principal.Barras;
import Principal.Main;
import Sorts.Sorts;

public class BubbleOptimized extends Sorts implements Sort {

	public BubbleOptimized(Main m) {
		this.m = m;
		sort();
	}

	// @Override
	public void sort() {
		setInicio(System.currentTimeMillis());
		boolean needNextPass = true;
		for (int i = 1; i < n.length && needNextPass; i++) {
			needNextPass = false;
			for (int j = 0; j < n.length - i; j++) {
				if (n[j] > n[j + 1]) {
					int temp = n[j];
					n[j] = n[j + 1];
					n[j + 1] = temp;
					cambiosArray++;
					needNextPass = true;
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
