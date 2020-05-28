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

public class Main {
	private JFrame frame;
	static Barras barras;
	public static JPanel panelMenu;
	JPanel panelOpcionesMenu;
	JLabel lblTitleAlgoritmo;
	JComboBox<String> comboBoxTipoSort;
	JButton btnOrdenar;
	JButton btnDesordenar;
	JLabel lblTitle;
	private static JPanel panelPintar;

	public final static int WIN_WIDTH = 1280; // ancho del menu * 2
	public final static int WIN_HEIGHT = 720;

	int curAlg = -1;
	boolean ordenar = false;
	boolean desordenar = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//		public void run() {
//			try {
		Main window = new Main();
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
	public Main() {
		initialize();
		panelPintar.setLayout(null);
		barras = new Barras();
		barras.setBounds(0, 0, 964, 681);

		panelPintar.add(barras);
		barras.setLayout(null);
		barras.shuffleArray(panelPintar);
		barras.repaint();

		panelPintar.setVisible(true);
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
		panelOpcionesMenu.add(btnOrdenar);
		btnOrdenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ordenar = true;
				desordenar = false;
				curAlg = comboBoxTipoSort.getSelectedIndex();

			}
		});

		btnDesordenar = new JButton("Desordenar");
		btnDesordenar.setFont(new Font("Arial", Font.BOLD, 13));
		btnDesordenar.setBounds(153, 95, 110, 30);
		btnDesordenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (desordenar) {
					barras.shuffleArray(panelPintar);
				}
			}
		});
		panelOpcionesMenu.add(btnDesordenar);

		lblTitle = new JLabel("Controles");
		lblTitle.setBounds(10, 11, 280, 24);
		panelMenu.add(lblTitle);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 13));

	}

	public void sorting() {
		if (ordenar) {
			switch (curAlg) {
			case 0:
				Bubble bubble = new Bubble(panelPintar, Barras.n);
				break;
			case 1:
				Inserccion inserccion = new Inserccion(panelPintar, Barras.n);
				break;
			case 2:
				Seleccion seleccion = new Seleccion(panelPintar, Barras.n);
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
		ordenar = false;
		desordenar = true;
	}

	// mantiene un llop cerrado para la seleccion del Sort
	public void pause() {
		int i = 0;
		do {
			i++;
			if (i > 100)
				i = 0;
			try {
				Thread.sleep(1);
			} catch (Exception e) {
			}
		} while (!ordenar);
		sorting();
	}
}
