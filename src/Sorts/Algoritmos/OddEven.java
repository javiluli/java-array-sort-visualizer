package Sorts.Algoritmos;

import Interfaz.Sort;
import Principal.Main;
import Sorts.Sorts;

public class OddEven extends Sorts implements Sort {
	public OddEven(Main m) {
		this.m = m;
		sort();
	}

	@Override
	public void sort() {
		boolean isSorted = false;
		setInicio(System.currentTimeMillis());
		while (!isSorted) {
			isSorted = true;
			int temp = 0;
			for (int i = 1; i <= n.length - 2; i = i + 2) {
				accesoArray++;
				if (n[i] > n[i + 1]) {
					temp = n[i];
					n[i] = n[i + 1];
					n[i + 1] = temp;
					isSorted = false;
					cambiosArray++;
				}
				m.updateAnimaciones();
			}
			for (int i = 0; i <= n.length - 2; i = i + 2) {
				accesoArray++;
				if (n[i] > n[i + 1]) {
					temp = n[i];
					n[i] = n[i + 1];
					n[i + 1] = temp;
					isSorted = false;
					cambiosArray++;
				}
				m.updateAnimaciones();
			}
			m.textos();
		}

	}

	@Override
	public String getNombre() {
		return "Odd Even Sort";
	}
}
