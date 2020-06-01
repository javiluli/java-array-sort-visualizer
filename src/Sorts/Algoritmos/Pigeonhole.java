package Sorts.Algoritmos;

import Adicionales.Delay;
import Interfaz.Sort;
import Principal.Main;
import Sorts.Sorts;

public class Pigeonhole extends Sorts implements Sort {
	public Pigeonhole(Main m) {
		this.m = m;
		sort();
	}

	@Override
	public void sort() {
		setInicio(System.currentTimeMillis());
		int min = n[0], max = n[0];
		for (int i : n) {
			min = Math.min(i, min);
			max = Math.max(i, max);
		}
		final int size = max - min + 1;

		int[] holes = new int[size];

		for (int i : n)
			holes[i - min]++;

		int i = 0;
		for (int count = 0; count < size; count++) {
			while (holes[count]-- > 0) {
				n[i++] = count + min;
				accesoArray++;
				m.textos();
				setFin(System.currentTimeMillis());
				Main.getPanelBarras().repaint();
				Delay.delay();
			}
		}
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

}
