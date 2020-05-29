package principal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.border.LineBorder;

import Algoritmos.*;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends Sorts {

	private JFrame frame;
	static Barras barras;
	public static JPanel panelMenu;
	JPanel panelOpcionesMenu;
	JLabel lblTitleAlgoritmo;
	JComboBox<String> comboBoxTipoSort;
	JButton btnOrdenar;
	JButton btnDesordenar;
	JLabel lblTitle;
	public static JLabel lblCambios;
	public static JLabel lblAccesos;
	private static JPanel panelPintar;

	public final static int WIN_WIDTH = 1280;
	public final static int WIN_HEIGHT = 720;

	int seleccionAlgoritmo = -1;
	boolean puedeOrdenar = false;
	boolean puedeDesordenar = true;

//	public static long accesoArray, cambiosArray;

	Bubble bubble;
	Inserccion inserccion;
	Seleccion seleccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//		public void run() {
//			try {
		Main window = new Main(accesoArray, cambiosArray, panel, n);
		window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the application.
	 */
	public Main(long accesArr, long cambArr, JPanel panel, int[] n) {
		super(accesArr, cambArr, panel, n);
		initialize();
		panelPintar.setLayout(null);
		barras = new Barras();
		barras.setBounds(0, 0, 964, 681);

		panelPintar.add(barras);
		barras.setLayout(null);
//		barras.shuffleArray(panelPintar);
		barras.repaint();

		panelPintar.setVisible(true);
		lblCambios.setText("Cambios en el Array: " + cambiosArray);
		lblAccesos.setText("Accesos al Array: " + accesoArray);

		frame.setVisible(true);

		sorting();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, WIN_WIDTH, WIN_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panelPintar = new JPanel();
		panelPintar.setBackground(Color.BLACK);
		panelPintar.setBounds(300, 0, 964, 681);
		frame.getContentPane().add(panelPintar);

		panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 300, 681);
		frame.getContentPane().add(panelMenu);
		panelMenu.setLayout(null);

		panelOpcionesMenu = new JPanel();
		panelOpcionesMenu.setBounds(10, 46, 280, 624);
		panelOpcionesMenu.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelMenu.add(panelOpcionesMenu);
		panelOpcionesMenu.setLayout(null);

		lblTitleAlgoritmo = new JLabel("Algoritmo de ordenacion");
		lblTitleAlgoritmo.setFont(new Font("Arial", Font.BOLD, 13));
		lblTitleAlgoritmo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleAlgoritmo.setBounds(47, 11, 186, 25);
		panelOpcionesMenu.add(lblTitleAlgoritmo);

		comboBoxTipoSort = new JComboBox<String>();
		comboBoxTipoSort.setFont(new Font("Arial", Font.BOLD, 13));
		comboBoxTipoSort
				.setModel(new DefaultComboBoxModel<String>(new String[] { "Burbuja", "Insercion", "Seleccion" }));
		comboBoxTipoSort.setBounds(80, 46, 120, 30);
		panelOpcionesMenu.add(comboBoxTipoSort);

		btnOrdenar = new JButton("Ordenar");
		btnOrdenar.setFont(new Font("Arial", Font.BOLD, 13));
		btnOrdenar.setBounds(24, 95, 110, 30);
		btnOrdenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puedeOrdenar = true;
				puedeDesordenar = false;
				seleccionAlgoritmo = comboBoxTipoSort.getSelectedIndex();
			}
		});
		panelOpcionesMenu.add(btnOrdenar);

		btnDesordenar = new JButton("Desordenar");
		btnDesordenar.setFont(new Font("Arial", Font.BOLD, 13));
		btnDesordenar.setBounds(153, 95, 110, 30);
		btnDesordenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (puedeDesordenar) {
					barras.shuffleArray(panelPintar);
				}
			}
		});
		panelOpcionesMenu.add(btnDesordenar);

		lblCambios = new JLabel("Cambios en el Array:");
		lblCambios.setFont(new Font("Arial", Font.BOLD, 13));
		lblCambios.setBounds(10, 212, 260, 30);
		panelOpcionesMenu.add(lblCambios);

		lblAccesos = new JLabel("Accesos al Array:");
		lblAccesos.setFont(new Font("Arial", Font.BOLD, 13));
		lblAccesos.setBounds(10, 267, 260, 30);
		panelOpcionesMenu.add(lblAccesos);

		lblTitle = new JLabel("Controles");
		lblTitle.setBounds(10, 11, 280, 24);
		panelMenu.add(lblTitle);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 13));

	}

	public void sorting() {
		if (puedeOrdenar) {
			switch (seleccionAlgoritmo) {
			case 0:
				bubble = new Bubble(seleccionAlgoritmo, seleccionAlgoritmo, panelPintar, Barras.n);
				break;
			case 1:
				inserccion = new Inserccion(seleccionAlgoritmo, seleccionAlgoritmo, panelPintar, Barras.n);
				break;
			case 2:
				seleccion = new Seleccion(seleccionAlgoritmo, seleccionAlgoritmo, panelPintar, Barras.n);
				break;
			default:
				break;
			}
		}
		reset();
		pause();
	}

	// Reinicia algunas variables despues de terminar un sort
	public void reset() {
		puedeOrdenar = false;
		puedeDesordenar = true;
		cambiosArray = 0;
		accesoArray = 0;
	}

	// mantiene un llop cerrado para la seleccion del Sort
	public void pause() {
		for (; !puedeOrdenar;) {
			try {
				Thread.sleep(1);
			} catch (Exception e) {
			}
		}

		sorting();
	}
}
