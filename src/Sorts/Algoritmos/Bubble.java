package Sorts.Algoritmos;

import Adicionales.*;
import Interfaz.Sort;
import Principal.*;
import Sorts.Sorts;

public class Bubble extends Sorts implements Sort {

	public Bubble(Main m) {
		this.m = m;
		sort();
	}

	// @Override
	public void sort() {
		setInicio(System.currentTimeMillis());
		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n.length - 1 - i; j++) {
				if (Sorts.n[j] > n[j + 1]) {
					int temp = n[j];
					n[j] = n[j + 1];
					n[j + 1] = temp;
					cambiosArray++;
				}
				accesoArray += 2;
				m.textos();
				setFin(System.currentTimeMillis());
				Main.getPanelBarras().repaint();
				Delay.delay();
			}
			m.textos();
		}
	}

	@Override
	public String getNombre() {
		return "Bubble Sort";
	}
}
