package Sorts.Algoritmos;

import java.util.Arrays;

import Adicionales.Delay;
import Interfaz.Sort;
import Principal.Main;
import Sorts.Sorts;

public class Radix extends Sorts implements Sort {
	public Radix(Main m) {
		this.m = m;
		sort();
	}

	@Override
	public void sort() {
		setInicio(System.currentTimeMillis());

		int max = getMax(n.length);
		for (int exp = 1; max / exp > 0; exp *= 10) {
			countSort(n.length, exp);
		}
	}

	public void countSort(int len, int exp) {
		int output[] = new int[len];
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);

		for (i = 0; i < len; i++) {
			count[(n[i] / exp) % 10]++;
			m.textos();
			setFin(System.currentTimeMillis());
			Main.getPanelBarras().repaint();
			Delay.delay();
		}

		for (i = 1; i < 10; i++) {
			count[i] += count[i - 1];
			m.textos();
			setFin(System.currentTimeMillis());
			Main.getPanelBarras().repaint();
			Delay.delay();
		}

		for (i = len - 1; i >= 0; i--) {
			output[count[(n[i] / exp) % 10] - 1] = n[i];
			count[(n[i] / exp) % 10]--;
			m.textos();
			setFin(System.currentTimeMillis());
			Main.getPanelBarras().repaint();
			Delay.delay();
		}
		for (i = 0; i < len; i++) {
			n[i] = output[i];
			m.textos();
			setFin(System.currentTimeMillis());
			Main.getPanelBarras().repaint();
			Delay.delay();
		}
	}

	public int getMax(int len) {
		int mx = n[0];
		for (int i = 1; i < len; i++) {
			if (n[i] > mx)
				mx = n[i];
		}
		return mx;
	}

	@Override
	public String getNombre() {
		return null;
	}

}
