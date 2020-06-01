package Sorts.Algoritmos;

import Adicionales.Delay;
import Interfaz.Sort;
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
			}
			m.textos();
			setFin(System.currentTimeMillis());
			Main.getPanelBarras().repaint();
			Delay.delay();
		}
	}

	@Override
	public String getNombre() {
		return null;
	}

}
