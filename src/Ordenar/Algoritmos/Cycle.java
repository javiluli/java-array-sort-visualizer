package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class Cycle extends AdicionalesSorts implements ISort {
	public Cycle(MainAplicacion m, int[] n) {
		this.m = m;
		sort(n);
	}

	// @Override
	public void sort(int[] n) {
		setInicio(System.currentTimeMillis());

		for (int cycle_start = 0; cycle_start <= n.length - 2; cycle_start++) {
			accesoArray++;
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
				cambiosArray++;
			}

			while (pos != cycle_start) {
				accesoArray++;
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
					cambiosArray++;
				}
				m.updateAnimaciones();
			}
		}
		DibujarGraficos.finSort = true;
	}
}
