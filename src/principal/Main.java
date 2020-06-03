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
import javax.swing.ImageIcon;

public class Main extends Sorts {
	// Nombre de cada algoritmo Sort
	private final String[] nombreAlgoritmos = { "Bubble", "Cocktail", "Cycle", "Gnome", "Heap", "Insertion", "Merge",
			"Odd Even", "Pancake", "Pigeonhole", "Quick", "Radix", "Selection" };
	// DISEÑO GRAFICO DE LA ANIMACION
	private final static String[] nombreGrafico = { "Escalera", "Piramide horizontal", "Cuadrado", "Punto" };
	// JFRAME PRINCIPAL
	private final JFrame frame = new JFrame();
	// JPANEL
	private final JPanel panelMenu = new JPanel();
	private JPanel panelOpcionesMenu = new JPanel();
	private static JPanel panelBarras = new JPanel();
	private final Panel panelVisorMemoria = new Panel();
	// COMBOBOX
	private final JComboBox<String> comboBoxTipoSort = new JComboBox<String>(nombreAlgoritmos);
	private static final JComboBox<Object> comboBoxTiposGraficos = new JComboBox<Object>(nombreGrafico);
	// JLABEL
	private final JLabel lblTitleAlgoritmo = new JLabel("Seleccionar algoritmo de ordenacion");
	private final JLabel lblTitle = new JLabel("Panel de control");
	private JLabel lblNumeroBarras = new JLabel("Numero de barras");
	private JLabel lblRetardo = new JLabel("Retardo: 1 ms");
	private static JLabel lblTiempo = new JLabel("Tiempo: 0 m 0 s 0 ms");
	private static JLabel lblMemoriaUsada = new JLabel("Memoria usada: 0 MB");
	private static JLabel lblMemoriaMax = new JLabel("Memoria maxima: 0 MB");
	private static JLabel lblMemoriaLibre = new JLabel("Memoria libre: 0 MB");
	private static JLabel lblMemoriaTotal = new JLabel("Memoria total: 0 MB");
	private static JLabel lblCambios = new JLabel("Cambios en el Array: 0");
	private static JLabel lblAccesos = new JLabel("Accesos al Array: 0");
	private final JLabel lblTituloGraficos = new JLabel("Dise\u00F1o grafico");
	// JBUTTON
	private final JButton btnOrdenar = new JButton("Ordenar");
	private final JButton btnDesordenar = new JButton("Desordenar");
	private final JButton btnSaltarSort = new JButton("Saltar Sort");
	private final JButton btnInformacion = new JButton("Informacion");
	private final JButton btnGithub = new JButton();
	private final JButton btnCodepen = new JButton();
	// JSLIDER
	private final JSlider sliderTamBarras = new JSlider();
	private final JSlider sliderRetardo = new JSlider();
	// Tamaño de la ventana.
	public final static int WIN_WIDTH = 1330;
	public final static int WIN_HEIGHT = 1053;
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
	// ---------------------------------------------------------------------------------------------

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
	// ---------------------------------------------------------------------------------------------

	public void main() {
		initialize();
		getPanelBarras().setLayout(null);
		barras = new Barras();
		barras.setBounds(0, 0, Barras.getWinWidth(), Barras.getWinHeight());
		getPanelBarras().add(barras);
		barras.setLayout(null);
		getPanelBarras().setVisible(true);
		frame.setResizable(false);
		frame.setTitle("Visualizador de ordenacion de matrices");
		frame.setVisible(true);
		sorting();
	}
	// ---------------------------------------------------------------------------------------------

	private void initialize() {
		final Color BLACK_SECUNDARIO = new Color(15, 15, 15);
		// Frame principal.
		frame.setBounds(100, 100, WIN_WIDTH, WIN_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// Panel donde se dibujan las barras.
		panelBarras.setBackground(SystemColor.desktop);
		panelBarras.setBounds(300, 0, Barras.getWinWidth(), Barras.getWinHeight());
		frame.getContentPane().add(panelBarras);

		// Panel para el menu de occiones.
		panelMenu.setBackground(SystemColor.activeCaptionText);
		panelMenu.setBounds(0, 0, 300, 1024);
		panelMenu.setLayout(null);
		frame.getContentPane().add(panelMenu);

		// Panel hijo para las ocopnes.
		panelOpcionesMenu.setBackground(BLACK_SECUNDARIO);
		panelOpcionesMenu.setBorder(new LineBorder(SystemColor.textInactiveText));
		panelOpcionesMenu.setBounds(10, 46, 280, 952);
		panelOpcionesMenu.setLayout(null);
		panelMenu.add(panelOpcionesMenu);

		// Titulo para seleccion del algoritmo de ordenacion.
		lblTitleAlgoritmo.setBounds(10, 11, 260, 25);
		lblTitleAlgoritmo.setFont(new Font("Arial", Font.BOLD, 13));
		lblTitleAlgoritmo.setForeground(Color.WHITE);
		panelOpcionesMenu.add(lblTitleAlgoritmo);

		// Menu desplegable para la seleccion de algoritmo.
		comboBoxTipoSort.setFont(new Font("Arial", Font.BOLD, 13));
		comboBoxTipoSort.setForeground(Color.WHITE);
		comboBoxTipoSort.setBackground(Color.DARK_GRAY);
		comboBoxTipoSort.setBounds(10, 47, 140, 30);
		panelOpcionesMenu.add(comboBoxTipoSort);

		// Boton para iniciar la ordenacion.
		btnOrdenar.setFont(new Font("Arial", Font.BOLD, 13));
		btnOrdenar.setBackground(Color.BLACK);
		btnOrdenar.setForeground(Color.WHITE);
		btnOrdenar.setBounds(160, 47, 110, 30);
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
		btnDesordenar.setBounds(160, 88, 110, 30);
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
		lblCambios.setBounds(10, 215, 250, 30);
		panelOpcionesMenu.add(lblCambios);
		lblAccesos.setForeground(Color.WHITE);

		// Label para el recuento de accesos realizados en el array.
		lblAccesos.setFont(new Font("Arial", Font.BOLD, 13));
		lblAccesos.setBounds(10, 256, 237, 30);
		panelOpcionesMenu.add(lblAccesos);
		lblNumeroBarras.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroBarras.setForeground(Color.WHITE);

		// Label para el tamaño de las barras pintadas en pantalla.
		lblNumeroBarras.setFont(new Font("Arial", Font.BOLD, 13));
		lblNumeroBarras.setBounds(139, 338, 131, 30);
		panelOpcionesMenu.add(lblNumeroBarras);

		// Slider para seleccionar el tamaño de las barras pintadas en pantalla.
		final int maxNumBars = 9;
		sliderTamBarras.setOrientation(SwingConstants.VERTICAL);
		sliderTamBarras.setMajorTickSpacing(1);
		sliderTamBarras.setForeground(Color.WHITE);
		sliderTamBarras.setBackground(BLACK_SECUNDARIO);
		sliderTamBarras.setLabelTable(snbp.establecerValoresSlider(maxNumBars));
		sliderTamBarras.setMinimum(1);
		sliderTamBarras.setMaximum(maxNumBars);
		sliderTamBarras.setFont(new Font("Arial", Font.BOLD, 13));
		sliderTamBarras.setMinorTickSpacing(1);
		sliderTamBarras.setSnapToTicks(true);
		sliderTamBarras.setPaintLabels(true);
		sliderTamBarras.setValue(5);
		sliderTamBarras.setPaintTicks(true);
		sliderTamBarras.setBounds(173, 379, 90, 360);
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

		// Label para el retardo en la que se ordena.
		lblRetardo.setForeground(Color.WHITE);
		lblRetardo.setFont(new Font("Arial", Font.BOLD, 13));
		lblRetardo.setBounds(10, 338, 120, 30);
		panelOpcionesMenu.add(lblRetardo);

		// Slider para la seleccion del retardo.
		sliderRetardo.setOrientation(SwingConstants.VERTICAL);
		sliderRetardo.setBackground(BLACK_SECUNDARIO);
		sliderRetardo.setForeground(Color.WHITE);
		sliderRetardo.setMinorTickSpacing(1);
		sliderRetardo.setMajorTickSpacing(10);
		sliderRetardo.setPaintLabels(true);
		sliderRetardo.setFont(new Font("Arial", Font.BOLD, 13));
		sliderRetardo.setValue(1);
		sliderRetardo.setPaintTicks(true);
		sliderRetardo.setBounds(10, 379, 90, 360);
		sliderRetardo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (sliderRetardo.getValue() == 0)
					sliderRetardo.setValue(1);
				cambioRetardo();
			}
		});
		panelOpcionesMenu.add(sliderRetardo);

		// Tiempo de ejecucion de un Sort/
		lblTiempo.setForeground(Color.WHITE);
		lblTiempo.setFont(new Font("Arial", Font.BOLD, 13));
		lblTiempo.setBounds(10, 297, 253, 30);
		panelOpcionesMenu.add(lblTiempo);

		// Panel para visualizar la memoria.
		panelVisorMemoria.setBackground(SystemColor.desktop);
		panelVisorMemoria.setBounds(10, 753, 260, 140);
		panelVisorMemoria.setLayout(null);
		panelOpcionesMenu.add(panelVisorMemoria);

		// Label para visualizar la memoria utilizada.
		lblMemoriaUsada.setForeground(SystemColor.text);
		lblMemoriaUsada.setFont(new Font("Monospaced", Font.PLAIN, 14));
		lblMemoriaUsada.setBounds(10, 12, 240, 20);
		panelVisorMemoria.add(lblMemoriaUsada);

		// Label para visualizar la memoria maxima.
		lblMemoriaMax.setForeground(SystemColor.text);
		lblMemoriaMax.setFont(new Font("Monospaced", Font.PLAIN, 14));
		lblMemoriaMax.setBounds(10, 44, 240, 20);
		panelVisorMemoria.add(lblMemoriaMax);

		// Label para visualizar la memoria libre.
		lblMemoriaLibre.setForeground(SystemColor.text);
		lblMemoriaLibre.setFont(new Font("Monospaced", Font.PLAIN, 14));
		lblMemoriaLibre.setBounds(10, 76, 240, 20);
		panelVisorMemoria.add(lblMemoriaLibre);

		// Label para visualizar la memoria total.
		lblMemoriaTotal.setForeground(SystemColor.text);
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
		btnSaltarSort.setBounds(160, 129, 110, 30);
		panelOpcionesMenu.add(btnSaltarSort);

		// Boton para ver informacion sobre la aplicacion
		btnInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,
						"Visualizador de ordenacion de matrices\n" + "                      Copyleft 2020\n"
								+ "                            Javiluli\n" + "       Fecha de creacion: Julio 1, 2020");
			}
		});
		btnInformacion.setForeground(Color.WHITE);
		btnInformacion.setBackground(Color.BLACK);
		btnInformacion.setFont(new Font("Arial", Font.BOLD, 13));
		btnInformacion.setBounds(10, 911, 110, 30);
		panelOpcionesMenu.add(btnInformacion);

		// Boton de red social para GitHub
		btnGithub.setBounds(200, 911, 30, 30);
		btnGithub.setContentAreaFilled(false);
		btnGithub.setIcon(new ImageIcon("data\\media\\img\\github.jpg"));
		btnGithub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Social.redes(Social.getGithub());
			}
		});
		panelOpcionesMenu.add(btnGithub);

		// Boton de red social para Codepen
		btnCodepen.setBounds(240, 911, 30, 30);
		btnCodepen.setContentAreaFilled(false);
		btnCodepen.setIcon(new ImageIcon("data\\media\\img\\codepen.jpg"));
		btnCodepen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Social.redes(Social.getCodepen());
			}
		});
		panelOpcionesMenu.add(btnCodepen);

		// CombooBox para los diseños graficos de la animacion de ordenacion.
		comboBoxTiposGraficos.setFont(new Font("Arial", Font.BOLD, 13));
		comboBoxTiposGraficos.setBounds(10, 129, 140, 30);
		comboBoxTiposGraficos.setForeground(Color.WHITE);
		comboBoxTiposGraficos.setBackground(Color.DARK_GRAY);
		panelOpcionesMenu.add(comboBoxTiposGraficos);

		// JLabel para titulo en la seleccion del diseño grafico.
		lblTituloGraficos.setFont(new Font("Arial", Font.BOLD, 13));
		lblTituloGraficos.setForeground(Color.WHITE);
		lblTituloGraficos.setBounds(10, 88, 120, 30);
		panelOpcionesMenu.add(lblTituloGraficos);

		// Label para el titulo de los controles.
		lblTitle.setBounds(10, 11, 280, 24);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
		panelMenu.add(lblTitle);
	}
	// ---------------------------------------------------------------------------------------------

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
	// ---------------------------------------------------------------------------------------------

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

	public void updateAnimaciones() {
		textos();
		fin = System.currentTimeMillis();
		panelBarras.repaint();
		Delay.delay();
	}

	public void updateAnimacionesSinTiempo() {
		textos();
		panelBarras.repaint();
		Delay.delay();
	}
	// ---------------------------------------------------------------------------------------------

	/**
	 * Calcula la memoria y cambia los labels correspondientes.
	 */
	public void calcularMemoria() {
		lblMemoriaTotal.setText("Memoria total: " + memoria.total + " MB");
		lblMemoriaMax.setText("Memoria maxima: " + memoria.max + " MB");
		lblMemoriaLibre.setText("Memoria libre: " + memoria.libre + " MB");
		lblMemoriaUsada.setText("Memoria usada: " + memoria.usada + " MB");
	}
	// ---------------------------------------------------------------------------------------------

	/**
	 * Tiempo usado para en la ejecucion entre el inicio y final de un algoritmo de
	 * ordenacion.
	 */
	private int calcMin(int tiempo) {
		int min = tiempo;
		min = (min / 1000) / 60;
		return min;

	}

	private int calcSeg(int tiempo) {
		int seg = tiempo;
		seg = (seg / 1000) - (60 * calcMin(seg));
		return seg;
	}

	private int calcMil(int tiempo) {
		int mil = tiempo;
		mil = mil - (1000 * (mil / 1000));
		return mil;
	}

	public void calcularTiempo() {
		tiempo = fin - inicio;
		lblTiempo.setText("Tiempo: " + calcMin((int) tiempo) + " m " + calcSeg((int) tiempo) + " s "
				+ calcMil((int) tiempo) + " ms");
	}
	// ---------------------------------------------------------------------------------------------

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
	// ---------------------------------------------------------------------------------------------

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
	// ---------------------------------------------------------------------------------------------

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
	// ---------------------------------------------------------------------------------------------

	/**
	 * Cambio el retardo o lentitud con la que se sejecuta la animacion de la
	 * ordenacion;
	 */
	public void cambioRetardo() {
		Delay.n = sliderRetardo.getValue();
		Delay.delay();
		lblRetardo.setText("Retardo: " + Delay.n + " ms");
	}
	// ---------------------------------------------------------------------------------------------

	/**
	 * La clase SliderNumBarasPersonalizado agrega valores a un Slider para
	 * personalizar la forma de mostrar los distintos valores. En concreto agrega
	 * valores en base 2 del binario.
	 */
	class SliderNumBarasPersonalizado {

		/**
		 * Convierte un numero entero en un String.
		 *
		 * @param n la n indica el exponente por el cual se calcula.
		 * @return the string
		 */
		private String convertirIntToString(int n) {
			final int base = 2;
			String valor = String.valueOf((int) Math.pow(base, n));
			return valor;
		}

		/**
		 * Establece los valores em funcion de la cantidad recividad por parametro.
		 *
		 * @param n la n es el numero de valores agreados.
		 * @return un hashtable con los valores agregados en base 2.
		 */
		public Hashtable<Integer, JLabel> establecerValoresSlider(int n) {
			Hashtable<Integer, JLabel> posiciones = new Hashtable<Integer, JLabel>();
			JLabel lblLabel;
			for (int i = 0; i <= n; i++) {
				posiciones.put(i, lblLabel = new JLabel(convertirIntToString(i)));
				lblLabel.setForeground(Color.WHITE);
			}
			return posiciones;
		}
	}
	// ---------------------------------------------------------------------------------------------

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

	public static JComboBox<Object> getComboboxtiposgraficos() {
		return comboBoxTiposGraficos;
	}

//	public static JComboBox<Object> getComboboxtiposgraficos() {
//		return comboBoxTiposGraficos;
//	}
}
