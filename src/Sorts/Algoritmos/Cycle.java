package Sorts.Algoritmos;

import Adicionales.Delay;
import Interfaz.Sort;
import Principal.Main;
import Sorts.Sorts;

public class Cycle extends Sorts implements Sort {
	public Cycle(Main m) {
		this.m = m;
		sort();
	}

	// @Override
	public void sort() {
		int writes = 0;

		for (int cycle_start = 0; cycle_start <= n.length - 2; cycle_start++) {
			int item = n[cycle_start];

			int pos = cycle_start;
			for (int i = cycle_start + 1; i < n.length; i++)
				if (n[i] < item)
					pos++;

			if (pos == cycle_start)
				continue;

			while (item == n[pos])
				pos += 1;

			if (pos != cycle_start) {
				int temp = item;
				item = n[pos];
				n[pos] = temp;
				writes++;
			}

			while (pos != cycle_start) {
				pos = cycle_start;

				for (int i = cycle_start + 1; i < n.length; i++)
					if (n[i] < item)
						pos += 1;

				while (item == n[pos])
					pos += 1;

				if (item != n[pos]) {
					int temp = item;
					item = n[pos];
					n[pos] = temp;
					writes++;
				}
				m.textos();
				setFin(System.currentTimeMillis());
				Main.getPanelBarras().repaint();
				Delay.delay();

			}
			m.textos();
			setFin(System.currentTimeMillis());
			Main.getPanelBarras().repaint();
			Delay.delay();
		}
	}

	// @Override
	public String getNombre() {
		return null;
	}

}
