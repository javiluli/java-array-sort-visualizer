package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class Gnome extends AdicionalesSorts implements ISort {
	public Gnome(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	@Override
	public void sort(int[] array) {
		setInicio(System.currentTimeMillis());
		int index = 0;
		while (index < array.length) {
			accesoArray++;
			if (index == 0)
				index++;
			if (array[index] >= array[index - 1])
				index++;
			else {
				int temp = 0;
				temp = array[index];
				array[index] = array[index - 1];
				array[index - 1] = temp;
				index--;
				cambiosArray++;
			}
			mainApp.updateAnimaciones();
		}
		DibujarGraficos.finSort = true;
	}
}
