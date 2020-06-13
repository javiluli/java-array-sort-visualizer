package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class Shell extends AdicionalesSorts implements ISort {

	public Shell(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	@Override
	public void sort(int[] array) {
		setInicio(System.currentTimeMillis());
		int increment = array.length / 2;

		while (increment > 0) {

			for (int i = increment; i < array.length; i++) {
				int j = i;
				int temp = array[i];

				while (j >= increment && array[j - increment] > temp) {
					array[j] = array[j - increment];
					j = j - increment;
					cambiosArray++;
					mainApp.updateAnimaciones();
				}
				array[j] = temp;
				accesoArray++;
			}

			if (increment == 2)
				increment = 1;
			else
				increment *= (5.0 / 11);

		}
		DibujarGraficos.finSort = true;
	}
}
