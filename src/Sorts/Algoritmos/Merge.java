package Sorts.Algoritmos;

import Adicionales.Delay;
import Interfaz.Sort;
import Principal.Main;
import Sorts.Sorts;

public class Merge extends Sorts implements Sort {

	public Merge(Main m) {
		this.m = m;
		sort();
	}

	@Override
	public void sort() {
		setInicio(System.currentTimeMillis());
		sortingMerge(0, n.length - 1);
	}

	public void sortingMerge(int left, int right) {
		if (left < right) {
			cambiosArray++;
			int mitad = (left + right) / 2;
			sortingMerge(left, mitad);
			sortingMerge(mitad + 1, right);
			merge(left, mitad, right);
		}
	}

	void merge(int left, int mitad, int right) {
		int len_left = mitad - left + 1;
		int len_right = right - mitad;

		int arr_left[] = new int[len_left];
		int arr_right[] = new int[len_right];

		for (int i = 0; i < len_left; i++) {
			arr_left[i] = n[left + i];
			accesoArray++;
		}
		for (int j = 0; j < len_right; j++) {
			arr_right[j] = n[mitad + 1 + j];
			accesoArray++;
		}
		int i = 0, j = 0;
		int k = left;
		while (i < len_left && j < len_right) {
			if (arr_left[i] <= arr_right[j]) {
				n[k] = arr_left[i];
				i++;
				accesoArray++;
			} else {
				n[k] = arr_right[j];
				j++;
				accesoArray++;
			}
			k++;
			cambiosArray++;
			m.textos();
			Main.getPanelBarras().repaint();
			Delay.delay();
		}

		while (i < len_left) {
			n[k] = arr_left[i];
			i++;
			k++;
			accesoArray++;
			m.textos();
			Main.getPanelBarras().repaint();
			Delay.delay();
		}

		while (j < len_right) {
			n[k] = arr_right[j];
			j++;
			k++;
			accesoArray++;
			m.textos();
			Main.getPanelBarras().repaint();
			Delay.delay();
		}
		m.textos();
		setFin(System.currentTimeMillis());
	}

	@Override
	public String getNombre() {
		return "Merge Sort";
	}

}
