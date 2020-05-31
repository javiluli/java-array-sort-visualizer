package Sorts.Algoritmos;

import Adicionales.Delay;
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
				m.textos();
				Main.getPanelBarras().repaint();
				setFin(System.currentTimeMillis());
				Delay.delay();
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
				m.textos();
				Main.getPanelBarras().repaint();
				setFin(System.currentTimeMillis());
				Delay.delay();
			}
			m.textos();
		}

	}

	@Override
	public String getNombre() {
		return "Odd Even";
	}
}
