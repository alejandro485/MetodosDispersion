package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import Logica.Dispersion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaEntrada extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private Dispersion dispersion;
	
	private JPanel contentPane;
	private JTextField txtNumero;
	private JTextField txtDato;
	private JTextField txtDatoDos;
	
	private JLabel lblNumero;
	private JLabel lblCodigoDeDispersion;
	private JLabel lblDatoAuxiliar;
	private JLabel lblArreglo;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaEntrada frame = new PantallaEntrada();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PantallaEntrada() {
		
		dispersion=new Dispersion();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(144, 25, 288, 24);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		txtDatoDos=new JTextField();
		txtDatoDos.setBounds(144, 200, 288, 24);
		contentPane.add(txtDatoDos);
		txtDatoDos.setColumns(10);
		
		lblArreglo=new JLabel("Arreglo0: ");
		lblArreglo.setBounds(12, 200, 116,15);
		contentPane.add(lblArreglo);
		
		lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(12, 29, 70, 15);
		contentPane.add(lblNumero);
		
		lblCodigoDeDispersion = new JLabel("Codigo de dispersion:");
		lblCodigoDeDispersion.setBounds(12, 100, 421, 15);
		contentPane.add(lblCodigoDeDispersion);
		
		lblDatoAuxiliar = new JLabel("Dato auxiliar");
		lblDatoAuxiliar.setBounds(12, 65, 116, 15);
		contentPane.add(lblDatoAuxiliar);
		
		txtDato = new JTextField();
		txtDato.setColumns(10);
		txtDato.setBounds(144, 61, 288, 24);
		contentPane.add(txtDato);
		
		JButton btnPlegamiento = new JButton("Plegamiento");
		btnPlegamiento.addActionListener(this);
		btnPlegamiento.setActionCommand("p");
		btnPlegamiento.setBounds(22, 127, 193, 25);
		contentPane.add(btnPlegamiento);
		
		JButton btnMidSquare = new JButton("Mid Square");
		btnMidSquare.addActionListener(this);
		btnMidSquare.setActionCommand("m");
		btnMidSquare.setBounds(239, 127, 193, 25);
		contentPane.add(btnMidSquare);
		
		JButton btnDivision = new JButton("Division");
		btnDivision.addActionListener(this);
		btnDivision.setActionCommand("d");
		btnDivision.setBounds(22, 164, 193, 25);
		contentPane.add(btnDivision);
		
		JButton btnLlaves = new JButton("T. de llaves");
		btnLlaves.addActionListener(this);
		btnLlaves.setActionCommand("t");
		btnLlaves.setBounds(239, 164, 193, 25);
		contentPane.add(btnLlaves);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String r="Codigo de dispersion: ";
		switch(e.getActionCommand()){
			case "p":
				r+=dispersion.plegamiento(Integer.parseInt(txtNumero.getText()),Integer.parseInt(txtDato.getText()));
				break;
			case "m":
				r+=dispersion.midSquare(Integer.parseInt(txtNumero.getText()),Integer.parseInt(txtDato.getText()));
				break;
			case "d":
				r+=dispersion.division(Integer.parseInt(txtNumero.getText()),Integer.parseInt(txtDato.getText()));
				break;
			case "t":
				r+=dispersion.tLlaves(Integer.parseInt(txtNumero.getText()),Integer.parseInt(txtDato.getText()), Integer.parseInt(txtDatoDos.getText()));
				break;
		}
		lblCodigoDeDispersion.setText(r);
	}
}
