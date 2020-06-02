package Principal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.border.LineBorder;

import Adicionales.*;
import Sorts.*;
import Sorts.Algoritmos.*;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import javax.swing.event.ChangeEvent;
import java.awt.Panel;
import java.awt.SystemColor;

public class Main extends Sorts {
	// Nombre de cada algoritmo Sort
	private String[] nombreAlgoritmos = { "Bubble", "Cocktail", "Cycle", "Gnome", "Heap", "Insertion", "Merge",
			"Odd Even", "Pancake", "Pigeonhole", "Quick", "Radix", "Selection" };
	// JFRAME PRINCIPAL
	private JFrame frame = new JFrame();
	// JPANEL
	private JPanel panelMenu = new JPanel();
	private JPanel panelOpcionesMenu = new JPanel();
	private static JPanel panelBarras = new JPanel();
	private Panel panelVisorMemoria = new Panel();
	// COMBOBOX
	private JComboBox<String> comboBoxTipoSort = new JComboBox<String>(nombreAlgoritmos);
	// JLABEL
	private JLabel lblTitleAlgoritmo = new JLabel("Algoritmo de ordenacion");
	private JLabel lblTitle = new JLabel("Panel de control");
	private JLabel lblNumeroBarras = new JLabel("Numero de barras");
	private JLabel lblRetardo = new JLabel("Retardo: 1 ms");
	private static JLabel lblTiempo = new JLabel("Tiempo: 0 s 0 ms");
	private static JLabel lblMemoriaUsada = new JLabel("Memoria usada: 0 MB");
	private static JLabel lblMemoriaMax = new JLabel("Memoria maxima: 0 MB");
	private static JLabel lblMemoriaLibre = new JLabel("Memoria libre: 0 MB");
	private static JLabel lblMemoriaTotal = new JLabel("Memoria total: 0 MB");
	private static JLabel lblCambios = new JLabel("Cambios en el Array: 0");
	private static JLabel lblAccesos = new JLabel("Accesos al Array: 0");
	// JBUTTON
	private JButton btnOrdenar = new JButton("Ordenar");
	private JButton btnDesordenar = new JButton("Desordenar");
	private JButton btnSaltarSort = new JButton("Saltar Sort");
	// JSLIDER
	private JSlider sliderTamBarras = new JSlider();
	private JSlider sliderRetardo = new JSlider();
	// Tamaño de la ventana.
	public final static int WIN_WIDTH = 1340;
	public final static int WIN_HEIGHT = 1063;
	// Variables antes y despues de la ejecucion de una ordenacion.
	private int seleccionAlgoritmo = -1;
	private boolean puedeOrdenar = false;
	private boolean puedeDesordenar = true;
	// Objetos de mis Clases
	Barras barras;
	SliderNumBarasPersonalizado snbp = new SliderNumBarasPersonalizado();

	public static void main(String[] args) {
		try {
			Main window = new Main();
			window.main();
		} catch (Exception e) {
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
		barras.setBounds(0, 0, Barras.getWinWidth(), Barras.getWinHeight());
		getPanelBarras().add(barras);
		barras.setLayout(null);
		getPanelBarras().setVisible(true);
		frame.setTitle("Visualizador de prdenacion de matrices");
		frame.setResizable(false);
		frame.setVisible(true);
		sorting();
	}

	private void initialize() {
		Color oscuro = new Color(15, 15, 15);
		// Frame principal.
		frame.setBounds(100, 100, WIN_WIDTH, WIN_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Panel donde se dibujan las barras.
		panelBarras.setBackground(SystemColor.desktop);
		panelBarras.setBounds(300, 0, Barras.getWinWidth(), Barras.getWinHeight());
		frame.getContentPane().add(panelBarras);
		panelMenu.setBackground(SystemColor.activeCaptionText);

		// Panel para el menu de occiones.
		panelMenu.setBounds(0, 0, 300, 1024);
		panelMenu.setLayout(null);
		frame.getContentPane().add(panelMenu);
		panelOpcionesMenu.setBackground(oscuro);

		// Panel hijo para las ocopnes.
		panelOpcionesMenu.setBounds(10, 46, 280, 873);
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

		// Menu desplegable para la seleccion de algoritmo.
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
		lblNumeroBarras.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroBarras.setForeground(Color.WHITE);

		// Label para el tamaño de las barras pintadas en pantalla.
		lblNumeroBarras.setFont(new Font("Arial", Font.BOLD, 13));
		lblNumeroBarras.setBounds(139, 259, 131, 30);
		panelOpcionesMenu.add(lblNumeroBarras);

		// Slider para seleccionar el tamaño de las barras pintadas en pantalla.
		int maximum = 9;
		sliderTamBarras.setOrientation(SwingConstants.VERTICAL);
		sliderTamBarras.setMajorTickSpacing(1);
		sliderTamBarras.setForeground(Color.WHITE);
		sliderTamBarras.setBackground(oscuro);
		sliderTamBarras.setLabelTable(snbp.establecerValoresSlider(maximum));
		sliderTamBarras.setMinimum(1);
		sliderTamBarras.setMaximum(maximum);
		sliderTamBarras.setFont(new Font("Arial", Font.BOLD, 13));
		sliderTamBarras.setMinorTickSpacing(1);
		sliderTamBarras.setSnapToTicks(true);
		sliderTamBarras.setPaintLabels(true);
		sliderTamBarras.setValue(5);
		sliderTamBarras.setPaintTicks(true);
		sliderTamBarras.setBounds(173, 300, 90, 360);
		sliderTamBarras.addChangeListener(new ChangeListener() {
			/*
			 * Este realizara el cambio de tamaño siempre que no se este ejecutando la
			 * ordenacion o desordenacion de un array.
			 */
			public void stateChanged(ChangeEvent e) {
				if (puedeDesordenar)
					cambioNumBarras();
			}
		});
		panelOpcionesMenu.add(sliderTamBarras);
		lblRetardo.setForeground(Color.WHITE);

		// Label para el retardo en la que se ordena.
		lblRetardo.setFont(new Font("Arial", Font.BOLD, 13));
		lblRetardo.setBounds(10, 259, 120, 30);
		panelOpcionesMenu.add(lblRetardo);
		sliderRetardo.setOrientation(SwingConstants.VERTICAL);
		sliderRetardo.setBackground(oscuro);
		sliderRetardo.setForeground(Color.WHITE);
		sliderRetardo.setMinorTickSpacing(1);
		sliderRetardo.setMajorTickSpacing(10);
		sliderRetardo.setPaintLabels(true);
		sliderRetardo.setFont(new Font("Arial", Font.BOLD, 13));

		// Slider para la seleccion del retardo.
		sliderRetardo.setValue(1);
		sliderRetardo.setPaintTicks(true);
		sliderRetardo.setBounds(10, 300, 90, 360);
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
		lblTiempo.setBounds(10, 218, 253, 30);
		panelOpcionesMenu.add(lblTiempo);

		// Panel para visualizar la memoria.
		panelVisorMemoria.setBackground(SystemColor.desktop);
		panelVisorMemoria.setBounds(10, 673, 260, 140);
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

		// Boton para saltar o salir de la animacion
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

		JButton btnInformacion = new JButton("Informacion");
		btnInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int c = 2202;
				String symbol = "\\u" + c;

				String s = Character.toString((char) c);
				JOptionPane.showMessageDialog(frame,
						"Visualizador de ordenacion de matrices\n" + "                      Copyleft 2020\n"
								+ "                            Javiluli\n" + "       Fecha de creacion: Julio 1, 2020");
			}
		});
		btnInformacion.setForeground(Color.WHITE);
		btnInformacion.setBackground(Color.BLACK);
		btnInformacion.setFont(new Font("Arial", Font.BOLD, 13));
		btnInformacion.setBounds(10, 832, 110, 30);
		panelOpcionesMenu.add(btnInformacion);
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
		Main main = new Main();
		if (puedeOrdenar) {
			textos();
			switch (seleccionAlgoritmo) {
			case 0:
				sorts = new Bubble(main);
				break;
			case 1:
				sorts = new Cocktail(main);
				break;
			case 2:
				sorts = new Cycle(main);
				break;
			case 3:
				sorts = new Gnome(main);
				break;
			case 4:
				sorts = new Heap(main);
				break;
			case 5:
				sorts = new Inserccion(main);
				break;
			case 6:
				sorts = new Merge(main);
				break;
			case 7:
				sorts = new OddEven(main);
				break;
			case 8:
				sorts = new Pancake(main);
				break;
			case 9:
				sorts = new Pigeonhole(main);
				break;
			case 10:
				sorts = new Quick(main);
				break;
			case 11:
				sorts = new Radix(main);
				break;
			case 12:
				sorts = new Selection(main);
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
	public void cambioNumBarras() {
		Barras.setNUM_BARS((int) Math.pow(2, sliderTamBarras.getValue()));
		Barras.setBAR_WIDTH(Barras.getWinWidth() / Barras.getNUM_BARS());
		Barras.setBAR_HEIGHT(Barras.getWinHeight() / Barras.getNUM_BARS());
		barras.barras();
		barras.repaint();
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

	class SliderNumBarasPersonalizado {

		private String convertirIntToString(int n) {
			final int base = 2;
			String valor = String.valueOf((int) Math.pow(base, n));
			return valor;
		}

		public Hashtable<Integer, JLabel> establecerValoresSlider(int n) {
			Hashtable<Integer, JLabel> position = new Hashtable<Integer, JLabel>();
			JLabel lblLabel;
			for (int i = 0; i <= n; i++) {
				position.put(i, lblLabel = new JLabel(convertirIntToString(i)));
				lblLabel.setForeground(Color.WHITE);
			}
			return position;
		}
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
