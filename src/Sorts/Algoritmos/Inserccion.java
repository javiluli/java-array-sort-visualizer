package Sorts.Algoritmos;

import Adicionales.*;
import Interfaz.Sort;
import Principal.*;
import Sorts.Sorts;

public class Inserccion extends Sorts implements Sort {

	public Inserccion(Main m) {
		this.m = m;
		sort();
	}

	@Override
	public void sort() {
		setInicio(System.currentTimeMillis());
		for (int i = 0; i < n.length; i++) {
			int pos = i;
			int aux = n[i];
			accesoArray++;
			while ((pos > 0) && (n[pos - 1] > aux)) {
				n[pos] = n[pos - 1];
				pos--;
				cambiosArray++;
			}
			n[pos] = aux;
			setFin(System.currentTimeMillis());
			m.textos();
			Main.getPanelBarras().repaint();
			Delay.delay();
		}
	}

	@Override
	public String getNombre() {
		return "Inserccion Sort";
	}
}