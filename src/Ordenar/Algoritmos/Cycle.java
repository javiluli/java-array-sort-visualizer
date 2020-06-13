package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class Cycle extends AdicionalesSorts implements ISort {
	public Cycle(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	// @Override
	public void sort(int[] array) {
		setInicio(System.currentTimeMillis());

		for (int cycle_start = 0; cycle_start <= array.length - 2; cycle_start++) {
			accesoArray++;
			int item = array[cycle_start];

			int pos = cycle_start;
			for (int i = cycle_start + 1; i < array.length; i++)
				if (array[i] < item)
					pos++;

			if (pos == cycle_start)
				continue;

			while (item == array[pos])
				pos += 1;

			if (pos != cycle_start) {
				int temp = item;
				item = array[pos];
				array[pos] = temp;
				cambiosArray++;
			}

			while (pos != cycle_start) {
				accesoArray++;
				pos = cycle_start;

				for (int i = cycle_start + 1; i < array.length; i++)
					if (array[i] < item)
						pos += 1;

				while (item == array[pos])
					pos += 1;

				if (item != array[pos]) {
					int temp = item;
					item = array[pos];
					array[pos] = temp;
					cambiosArray++;
				}
				mainApp.updateAnimaciones();
			}
		}
		DibujarGraficos.finSort = true;
	}
}
