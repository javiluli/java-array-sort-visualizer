package Principal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.border.LineBorder;

import Adicionales.*;
import Sorts.*;
import Sorts.Algoritmos.*;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import javax.swing.event.ChangeEvent;
import java.awt.Panel;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Main extends Sorts {
	private String[] nombreAlgoritmos = { "Buuble", "Insertion", "Selection", "Cocktail", "Merge", "Odd Even", "Quick",
			"Heap", "Pigeonhole", "Radix", "Gnome", "Cycle", "Pancake" };
	private JFrame frame = new JFrame();
	private JPanel panelMenu = new JPanel();
	private JPanel panelOpcionesMenu = new JPanel();
	private static JPanel panelBarras = new JPanel();
	private Panel panelVisorMemoria = new Panel();
	private JComboBox<String> comboBoxTipoSort = new JComboBox<String>(nombreAlgoritmos);
//	private JComboBox comboBoxTipoSort = new JComboBox();
	private JLabel lblTitleAlgoritmo = new JLabel("Algoritmo de ordenacion");
	private JLabel lblTitle = new JLabel("Panel de control");
	private JLabel lblTamBarras = new JLabel("Tama\u00F1o de las barras: " + Barras.BAR_WIDTH + " px");
	private JLabel lblRetardo = new JLabel("Retardo: 1 ms");
	private static JLabel lblTiempo = new JLabel("Tiempo: 0 s 0 ms");
	private static JLabel lblMemoriaUsada = new JLabel("Memoria usada: 0 MB");
	private static JLabel lblMemoriaMax = new JLabel("Memoria maxima: 0 MB");
	private static JLabel lblMemoriaLibre = new JLabel("Memoria libre: 0 MB");
	private static JLabel lblMemoriaTotal = new JLabel("Memoria total: 0 MB");
	private static JLabel lblCambios = new JLabel("Cambios en el Array: 0");
	private static JLabel lblAccesos = new JLabel("Accesos al Array: 0");
	private JButton btnOrdenar = new JButton("Ordenar");
	private JButton btnDesordenar = new JButton("Desordenar");
	private JSlider sliderTamBarras = new JSlider();
	private JSlider sliderRetardo = new JSlider();

	// Tamaño de la ventana.
	public final static int WIN_WIDTH = 1280;
	public final static int WIN_HEIGHT = 720;

	// Variables antes y despues de la ejecucion de una ordenacion.
	private int seleccionAlgoritmo = -1;
	private boolean puedeOrdenar = false;
	private boolean puedeDesordenar = true;

	// Objetos de mis Clases
	Barras barras;

	public static void main(String[] args) {
		try {
			Main window = new Main();
			window.main();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Main() {
	}

	Memoria memoria = new Memoria();

	Main(Memoria memoria) {
		this.memoria = memoria;
	}

	Sorts sorts = new Sorts();

	Main(Sorts sorts) {
		this.sorts = sorts;
	}

	public void main() {
		initialize();
		getPanelBarras().setLayout(null);
		barras = new Barras();
		barras.setBounds(0, 0, 964, 681);
		getPanelBarras().add(barras);
		barras.setLayout(null);
		getPanelBarras().setVisible(true);
		frame.setVisible(true);
		sorting();
	}

	private void initialize() {

		// Frame principal.
		frame.setBounds(100, 100, WIN_WIDTH, WIN_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Panel donde se dibujan las barras.
		panelBarras.setBackground(SystemColor.desktop);
		panelBarras.setBounds(300, 0, 964, 681);
		frame.getContentPane().add(panelBarras);
		panelMenu.setBackground(SystemColor.activeCaptionText);

		// Panel para el menu de occiones.
		panelMenu.setBounds(0, 0, 300, 681);
		panelMenu.setLayout(null);
		frame.getContentPane().add(panelMenu);
		panelOpcionesMenu.setBackground(Color.DARK_GRAY);

		// Panel hijo para las ocopnes.
		panelOpcionesMenu.setBounds(10, 46, 280, 593);
		panelOpcionesMenu.setBorder(new LineBorder(SystemColor.textInactiveText));
		panelOpcionesMenu.setLayout(null);
		panelMenu.add(panelOpcionesMenu);
		lblTitleAlgoritmo.setForeground(Color.WHITE);

		// Titulo para seleccion del algoritmo de ordenacion.
		lblTitleAlgoritmo.setFont(new Font("Arial", Font.BOLD, 13));
		lblTitleAlgoritmo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleAlgoritmo.setBounds(10, 11, 186, 25);
		panelOpcionesMenu.add(lblTitleAlgoritmo);
		comboBoxTipoSort.setForeground(Color.WHITE);
		comboBoxTipoSort.setBackground(Color.DARK_GRAY);

//		 Menu desplegable para la seleccion de algoritmo.
		comboBoxTipoSort.setFont(new Font("Arial", Font.BOLD, 13));
		comboBoxTipoSort.setBounds(10, 47, 120, 30);
		panelOpcionesMenu.add(comboBoxTipoSort);
		btnOrdenar.setBackground(Color.BLACK);
		btnOrdenar.setForeground(Color.WHITE);

		// Boton para iniciar la ordenacion.
		btnOrdenar.setFont(new Font("Arial", Font.BOLD, 13));
		btnOrdenar.setBounds(153, 47, 110, 30);
		btnOrdenar.addActionListener(new ActionListener() {
			/*
			 * Este obtiene la posicion en la lista de algorimos para su seleccion, y una
			 * vez iniciada la orneacion evita que se pueda desordenar o reiniciar la
			 * ordenacion.
			 */
			public void actionPerformed(ActionEvent e) {
				puedeOrdenar = true;
				puedeDesordenar = false;
				seleccionAlgoritmo = comboBoxTipoSort.getSelectedIndex();
			}
		});
		panelOpcionesMenu.add(btnOrdenar);
		btnDesordenar.setBackground(Color.BLACK);
		btnDesordenar.setForeground(Color.WHITE);

		// Boton para desordenar el array.
		btnDesordenar.setFont(new Font("Arial", Font.BOLD, 13));
		btnDesordenar.setBounds(153, 95, 110, 30);
		btnDesordenar.addActionListener(new ActionListener() {
			/*
			 * Evitar que durante la desordenacion se pueda volver a marcar y se pueda
			 * ordenar durante la desordenacion. Este obtiene la longitud del comboBox donde
			 * se almacenan el nombre de los algoritmos, permitiendo que en la seleccion
			 * salte la opcion por defecto en metodo sorting(), siendo esta la desordenacion
			 * del array.
			 */
			public void actionPerformed(ActionEvent e) {
				if (puedeDesordenar) {
					puedeOrdenar = true;
					puedeDesordenar = false;
					seleccionAlgoritmo = comboBoxTipoSort.getWidth();
				}
			}
		});
		panelOpcionesMenu.add(btnDesordenar);
		lblCambios.setForeground(Color.WHITE);

		// Label para el recuento de cambios realizados en el array.
		lblCambios.setFont(new Font("Arial", Font.BOLD, 13));
		lblCambios.setBounds(10, 136, 250, 30);
		panelOpcionesMenu.add(lblCambios);
		lblAccesos.setForeground(Color.WHITE);

		// Label para el recuento de accesos realizados en el array.
		lblAccesos.setFont(new Font("Arial", Font.BOLD, 13));
		lblAccesos.setBounds(10, 177, 237, 30);
		panelOpcionesMenu.add(lblAccesos);
		lblTamBarras.setForeground(Color.WHITE);

		// Label para el tamaño de las barras pintadas en pantalla.
		lblTamBarras.setFont(new Font("Arial", Font.BOLD, 13));
		lblTamBarras.setBounds(10, 218, 191, 30);
		panelOpcionesMenu.add(lblTamBarras);
		sliderTamBarras.setForeground(Color.WHITE);
		sliderTamBarras.setBackground(Color.DARK_GRAY);
		sliderTamBarras.setMaximum(74);
		sliderTamBarras.setFont(new Font("Arial", Font.PLAIN, 10));
		sliderTamBarras.setMinorTickSpacing(1);
		sliderTamBarras.setSnapToTicks(true);
		sliderTamBarras.setMajorTickSpacing(8);
		sliderTamBarras.setPaintLabels(true);

		// Slider para seleccionar el tamaño de las barras pintadas en pantalla.
		sliderTamBarras.setValue(Barras.BAR_WIDTH);
		sliderTamBarras.setMinimum(2);
		sliderTamBarras.setPaintTicks(true);
		sliderTamBarras.setBounds(10, 259, 260, 40);
		sliderTamBarras.addChangeListener(new ChangeListener() {
			/*
			 * Este realizara el cambio de tamaño siempre que no se este ejecutando la
			 * ordenacion o desordenacion de un array.
			 */
			public void stateChanged(ChangeEvent e) {
				if (puedeDesordenar)
					cambioTamBarras();
			}
		});
		panelOpcionesMenu.add(sliderTamBarras);
		lblRetardo.setForeground(Color.WHITE);

		// Label para el retardo en la que se ordena.
		lblRetardo.setFont(new Font("Arial", Font.BOLD, 13));
		lblRetardo.setBounds(11, 310, 190, 30);
		panelOpcionesMenu.add(lblRetardo);
		sliderRetardo.setBackground(Color.DARK_GRAY);
		sliderRetardo.setForeground(Color.WHITE);
		sliderRetardo.setMinorTickSpacing(1);
		sliderRetardo.setMajorTickSpacing(10);
		sliderRetardo.setPaintLabels(true);
		sliderRetardo.setFont(new Font("Arial", Font.PLAIN, 10));

		// Slider para la seleccion del retardo.
		sliderRetardo.setValue(1);
		sliderRetardo.setPaintTicks(true);
		sliderRetardo.setBounds(10, 351, 260, 40);
		sliderRetardo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (sliderRetardo.getValue() == 0)
					sliderRetardo.setValue(1);
				cambioRetardo();
			}
		});
		panelOpcionesMenu.add(sliderRetardo);
		lblTiempo.setForeground(Color.WHITE);

		// Tiempo de ejecucion de un Sort/
		lblTiempo.setFont(new Font("Arial", Font.BOLD, 13));
		lblTiempo.setBounds(10, 402, 253, 30);
		panelOpcionesMenu.add(lblTiempo);

		// Panel para visualizar la memoria.
		panelVisorMemoria.setBackground(SystemColor.desktop);
		panelVisorMemoria.setBounds(10, 443, 260, 140);
		panelOpcionesMenu.add(panelVisorMemoria);
		panelVisorMemoria.setLayout(null);
		lblMemoriaUsada.setForeground(SystemColor.text);

		// Label para visualizar la memoria utilizada.

		lblMemoriaUsada.setFont(new Font("Monospaced", Font.PLAIN, 14));
		lblMemoriaUsada.setBounds(10, 12, 240, 20);
		panelVisorMemoria.add(lblMemoriaUsada);
		lblMemoriaMax.setForeground(SystemColor.text);

		// Label para visualizar la memoria maxima.
		lblMemoriaMax.setFont(new Font("Monospaced", Font.PLAIN, 14));
		lblMemoriaMax.setBounds(10, 44, 240, 20);
		panelVisorMemoria.add(lblMemoriaMax);
		lblMemoriaLibre.setForeground(SystemColor.text);

		// Label para visualizar la memoria libre.
		lblMemoriaLibre.setFont(new Font("Monospaced", Font.PLAIN, 14));
		lblMemoriaLibre.setBounds(10, 76, 240, 20);
		panelVisorMemoria.add(lblMemoriaLibre);
		lblMemoriaTotal.setForeground(SystemColor.text);

		// Label para visualizar la memoria total.
		lblMemoriaTotal.setFont(new Font("Monospaced", Font.PLAIN, 14));
		lblMemoriaTotal.setBounds(10, 108, 240, 20);
		panelVisorMemoria.add(lblMemoriaTotal);

		JButton btnSaltarSort = new JButton("Saltar Sort");
		btnSaltarSort.setBackground(Color.BLACK);
		btnSaltarSort.setForeground(Color.WHITE);
		btnSaltarSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delay.n = 1 / 2;
			}
		});
		btnSaltarSort.setFont(new Font("Arial", Font.BOLD, 13));
		btnSaltarSort.setBounds(10, 95, 110, 30);
		panelOpcionesMenu.add(btnSaltarSort);
		lblTitle.setForeground(Color.WHITE);

		// Label para el titulo de los controles.
		lblTitle.setBounds(10, 11, 280, 24);
		panelMenu.add(lblTitle);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 18));

	}

	/**
	 * Seleccion se cada uno de los metodos de ordenacion.
	 */
	public void sorting() {
		if (puedeOrdenar) {
			textos();
			switch (seleccionAlgoritmo) {
			case 0:
				sorts = new Bubble(new Main());
				break;
			case 1:
				sorts = new Inserccion(new Main());
				break;
			case 2:
				sorts = new Selection(new Main());
				break;
			case 3:
				sorts = new Cocktail(new Main());
				break;
			case 4:
				sorts = new Merge(new Main());
				break;
			case 5:
				sorts = new OddEven(new Main());
				break;
			case 6:
				sorts = new Quick(new Main());
				break;
			case 7:
				sorts = new Heap(new Main());
				break;
			case 8:
				sorts = new Pigeonhole(new Main());
				break;
			case 9:
				sorts = new Radix(new Main());
				break;
			case 10:
				sorts = new Gnome(new Main());
				break;
			case 11:
				sorts = new Cycle(new Main());
				break;
			case 12:
				sorts = new Pancake(new Main());
				break;
			default:
				barras.shuffleArray();
				break;
			}
		}
		reinicio();
		pausa();
	}

	/**
	 * Pinta los textos debidamente actualizados en funcion del metodo de
	 * ordenacion.
	 */
	public void textos() {
		lblCambios.setText("Cambios en el Array: " + cambiosArray);
		lblAccesos.setText("Accesos al Array: " + accesoArray);
		calcularTiempo();
		calcularMemoria();
	}

	/**
	 * Calcula la memoria y cambia los labels correspondientes.
	 */
	public void calcularMemoria() {
		lblMemoriaTotal.setText("Memoria total: " + memoria.total + " MB");
		lblMemoriaMax.setText("Memoria maxima: " + memoria.max + " MB");
		lblMemoriaLibre.setText("Memoria libre: " + memoria.libre + " MB");
		lblMemoriaUsada.setText("Memoria usada: " + memoria.usada + " MB");
	}

	/**
	 * Tiempo usado para en la ejecucion entre el inicio y final de un algoritmo de
	 * ordenacion.
	 */
	private int calcSegundos(int tiempo) {
		return (int) (tiempo / 1000);
	}

	private int calcMilisegundos(int tiempo) {
		tiempo = tiempo - (1000 * calcSegundos((int) tiempo));
		return tiempo;
	}

	public void calcularTiempo() {
		tiempo = fin - inicio;
		lblTiempo.setText("Tiempo: " + calcSegundos((int) tiempo) + " s " + calcMilisegundos((int) tiempo) + " ms");
	}

	/**
	 * Reinicia algunas variables y textos despues de terminar un sort.
	 */
	public void reinicio() {
		puedeOrdenar = false;
		puedeDesordenar = true;
		sorts = new Sorts(0);
		memoria = new Memoria(0);
		Delay.n = sliderRetardo.getValue();
	}

	/**
	 * Mantiene un cicuito cerrado para la seleccion del Sort evitando que el
	 * programa termine despues de una ejecicion.
	 */
	public void pausa() {
		for (; !puedeOrdenar;) {
			try {
				Thread.sleep(1);
			} catch (Exception e) {
			}
		}
		sorting();
	}

	/**
	 * Obtiene el tamaño seleccionado en el menu y cambia el tamaño de las barras
	 * pintandolas en patanlla.
	 */
	public void cambioTamBarras() {
		Barras.BAR_WIDTH = sliderTamBarras.getValue();
		Barras.NUM_BARS = Barras.WIN_WIDTH / Barras.BAR_WIDTH;
		Barras.BAR_HEIGHT = Barras.WIN_HEIGHT / Barras.NUM_BARS;
		barras.barras();
		barras.repaint();
		lblTamBarras.setText("Tama\u00F1o de las barras: " + Barras.BAR_WIDTH + " px");
	}

	/**
	 * Cambio el retardo o lentitud con la que se sejecuta la animacion de la
	 * ordenacion;
	 */
	public void cambioRetardo() {
		Delay.n = sliderRetardo.getValue();
		Delay.delay();
		lblRetardo.setText("Retardo: " + Delay.n + " ms");
	}

	public static JLabel getLblAccesos() {
		return lblAccesos;
	}

	public static void setLblAccesos(JLabel lblAccesos) {
		Main.lblAccesos = lblAccesos;
	}

	public static JLabel getLblMemoriaMax() {
		return lblMemoriaMax;
	}

	public static void setLblMemoriaMax(JLabel lblMemoriaMax) {
		Main.lblMemoriaMax = lblMemoriaMax;
	}

	public static JLabel getLblMemoriaTotal() {
		return lblMemoriaTotal;
	}

	public static void setLblMemoriaTotal(JLabel lblMemoriaTotal) {
		Main.lblMemoriaTotal = lblMemoriaTotal;
	}

	public static JLabel getLblMemoriaLibre() {
		return lblMemoriaLibre;
	}

	public static void setLblMemoriaLibre(JLabel lblMemoriaLibre) {
		Main.lblMemoriaLibre = lblMemoriaLibre;
	}

	public static JLabel getLblMemoriaUsada() {
		return lblMemoriaUsada;
	}

	public static void setLblMemoriaUsada(JLabel lblMemoriaUsada) {
		Main.lblMemoriaUsada = lblMemoriaUsada;
	}

	public static JLabel getLblTiempo() {
		return lblTiempo;
	}

	public static void setLblTiempo(JLabel lblTiempo) {
		Main.lblTiempo = lblTiempo;
	}

	public static JPanel getPanelBarras() {
		return panelBarras;
	}

	public void setPanelBarras(JPanel panelBarras) {
		Main.panelBarras = panelBarras;
	}
}
