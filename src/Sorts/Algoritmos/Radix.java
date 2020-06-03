package Sorts.Algoritmos;

import java.util.Arrays;

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
			m.updateAnimaciones();
		}
	}

	public void countSort(int len, int exp) {
		int output[] = new int[len];
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);

		for (i = 0; i < len; i++) {
			count[(n[i] / exp) % 10]++;
			accesoArray++;
		}

		for (i = 1; i < 10; i++) {
			count[i] += count[i - 1];

		}

		for (i = len - 1; i >= 0; i--) {
			output[count[(n[i] / exp) % 10] - 1] = n[i];
			accesoArray++;
			count[(n[i] / exp) % 10]--;
			accesoArray++;
		}
		for (i = 0; i < len; i++) {
			n[i] = output[i];
			accesoArray++;
			m.updateAnimaciones();
		}
	}

	public int getMax(int len) {
		int mx = n[0];
		for (int i = 1; i < len; i++) {
			if (n[i] > mx)
				mx = n[i];
			accesoArray++;
			cambiosArray++;
		}
		return mx;
	}

	@Override
	public String getNombre() {
		return "Radix Sort";
	}

}
