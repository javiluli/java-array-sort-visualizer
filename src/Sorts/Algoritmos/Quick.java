package Sorts.Algoritmos;

import Interfaz.Sort;
import Principal.Barras;
import Principal.Main;
import Sorts.Sorts;

public class Quick extends Sorts implements Sort {

	public Quick(Main m) {
		this.m = m;
		setInicio(System.currentTimeMillis());
		sort();
	}

	@Override
	public void sort() {
		quickSort(n, 0, n.length - 1);
		Barras.finSort = true;
	}

	public void quickSort(int array[], int izq, int der) {
		int pivote = array[izq];
		int i = izq;
		int j = der;
		int aux;
		while (i < j) {
			while (array[i] <= pivote && i < j)
				i++;
			while (array[j] > pivote)
				j--;
			if (i < j) {
				aux = array[i];
				array[i] = array[j];
				array[j] = aux;
			}
			accesoArray++;
			cambiosArray++;
			m.updateAnimaciones();
		}

		array[izq] = array[j];
		array[j] = pivote;
		if (izq < j - 1)
			quickSort(array, izq, j - 1);
		if (j + 1 < der)
			quickSort(array, j + 1, der);
		m.updateAnimaciones();
	}

	// @Override
	public String getNombre() {
		return "Quick Sort";
	}

}
