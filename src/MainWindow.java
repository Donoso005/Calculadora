import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Boolean primerNumero = true, mostrarResultado = false;
	Double n1, n2;
	String operacion;

	public Double realizarOperacion(Double n1, Double n2, String operacion) throws ArithmeticException{
		Double resultado = null;
		
		try {
			switch(operacion) {
				case "+":
					resultado = n1 + n2;
					break;
				case "-":
					resultado = n1 - n2;
					break;
				case "/":
					resultado = n1 / n2;
					break;
				case "*":
					resultado = n1 * n2;
					break;
			}
		}catch(ArithmeticException e) {
			throw e;
		}
		
		return resultado;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 660);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(110, 110, 110));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 334, 99);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextField labelOutput = new JTextField("");
		labelOutput.setEditable(false);
		labelOutput.setBounds(0, 0, 334, 99);
		panel.add(labelOutput);
		labelOutput.setHorizontalAlignment(SwingConstants.LEFT);
		labelOutput.setFont(new Font("Arial Black", Font.PLAIN, 57));
		labelOutput.setBackground(new Color(255, 255, 255));
		
		JButton btnButton_eliminar = new JButton("Eliminar");
		btnButton_eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelOutput.setText("");
				primerNumero = true;
				mostrarResultado = false;
				n1 = null;
				n2 = null;
			}
		});
		btnButton_eliminar.setBorderPainted(false);
		btnButton_eliminar.setBounds(354, 10, 106, 99);
		btnButton_eliminar.setFocusPainted(false);
		btnButton_eliminar.setFont(new Font("Arial Black", Font.BOLD, 15));
		
		btnButton_eliminar.setBackground(new Color(250, 0, 0));
		contentPane.add(btnButton_eliminar);
		
		JButton btnButton_Div = new JButton("X");
		btnButton_Div.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(labelOutput.getText().equalsIgnoreCase(null)) {
					labelOutput.setText("*");
				} else if(!mostrarResultado) {
					if(primerNumero) {
						n1 = Double.parseDouble(labelOutput.getText());
						operacion = "*";
						primerNumero = false;
						labelOutput.setText("");
					} else {
						n2 = Double.parseDouble(labelOutput.getText());
						Double resultado = realizarOperacion(n1, n2, operacion);
						labelOutput.setText(String.valueOf(resultado));
						n1 = resultado;
						mostrarResultado = true;
					}
				}
			}
		});
		btnButton_Div.setFont(new Font("Arial Black", Font.BOLD, 50));
		btnButton_Div.setBounds(238, 120, 106, 99);
		btnButton_Div.setFont(new Font("Arial Black", Font.BOLD, 50));
		contentPane.add(btnButton_Div);
		
		JButton btnButton_Cuadrada = new JButton("x²");
		btnButton_Cuadrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!labelOutput.getText().equalsIgnoreCase("")) {
					Double number;
					if(mostrarResultado) {
						number = n1;
					} else {
						number = Double.parseDouble(labelOutput.getText());
					}
					
					number = Math.pow(number, 2);
					labelOutput.setText(String.valueOf(Math.round(number)));
					if(!primerNumero) {
						n1 = number;
					} else {
						n2 = number;
					}
				}
			}
		});
		btnButton_Cuadrada.setBounds(122, 120, 106, 99);
		btnButton_Cuadrada.setFont(new Font("Arial Black", Font.BOLD, 50));
		contentPane.add(btnButton_Cuadrada);
		
		JButton btnButton_raiz = new JButton("√");
		btnButton_raiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!labelOutput.getText().equalsIgnoreCase("")) {
					Double number = Double.parseDouble(labelOutput.getText());
					
					number = Math.sqrt(number);
					labelOutput.setText(String.valueOf(Math.round(number)));
					if(!primerNumero) {
						n1 = number;
					}
				}
			}
		});
		btnButton_raiz.setBounds(6, 120, 106, 99);
		btnButton_raiz.setFont(new Font("Arial Black", Font.BOLD, 50));
		contentPane.add(btnButton_raiz);
		
		JButton btnButton_1 = new JButton("1");
		btnButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mostrarResultado) {
					labelOutput.setText("");
					mostrarResultado = false;
				}
				labelOutput.setText(labelOutput.getText() + "1");
			}
		});
		btnButton_1.setBounds(6, 453, 106, 99);
		btnButton_1.setFont(new Font("Arial Black", Font.BOLD, 50));
		contentPane.add(btnButton_1);
		
		JButton btnButton_2 = new JButton("2");
		btnButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mostrarResultado) {
					labelOutput.setText("");
					mostrarResultado = false;
				}
				labelOutput.setText(labelOutput.getText() + "2");
			}
		});
		btnButton_2.setBounds(122, 453, 106, 99);
		btnButton_2.setFont(new Font("Arial Black", Font.BOLD, 50));
		contentPane.add(btnButton_2);
		
		JButton btnButton_3 = new JButton("3");
		btnButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mostrarResultado) {
					labelOutput.setText("");
					mostrarResultado = false;
				}
				labelOutput.setText(labelOutput.getText() + "3");
			}
		});
		btnButton_3.setBounds(238, 453, 106, 99);
		btnButton_3.setFont(new Font("Arial Black", Font.BOLD, 50));
		contentPane.add(btnButton_3);
		
		JButton btnButton_4 = new JButton("4");
		btnButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mostrarResultado) {
					labelOutput.setText("");
					mostrarResultado = false;
				}
				labelOutput.setText(labelOutput.getText() + "4");
			}
		});
		btnButton_4.setBounds(6, 343, 106, 99);
		btnButton_4.setFont(new Font("Arial Black", Font.BOLD, 50));
		contentPane.add(btnButton_4);
		
		JButton btnButton_5 = new JButton("5");
		btnButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mostrarResultado) {
					labelOutput.setText("");
					mostrarResultado = false;
				}
				labelOutput.setText(labelOutput.getText() + "5");
			}
		});
		btnButton_5.setBounds(122, 343, 106, 99);
		btnButton_5.setFont(new Font("Arial Black", Font.BOLD, 50));
		contentPane.add(btnButton_5);
		
		JButton btnButton_6 = new JButton("6");
		btnButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mostrarResultado) {
					labelOutput.setText("");
					mostrarResultado = false;
				}
				labelOutput.setText(labelOutput.getText() + "6");
			}
		});
		btnButton_6.setBounds(238, 343, 106, 99);
		btnButton_6.setFont(new Font("Arial Black", Font.BOLD, 50));
		contentPane.add(btnButton_6);
		
		JButton btnButton_7 = new JButton("7");
		btnButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mostrarResultado) {
					labelOutput.setText("");
					mostrarResultado = false;
				}
				labelOutput.setText(labelOutput.getText() + "7");
			}
		});
		btnButton_7.setBounds(6, 230, 106, 99);
		btnButton_7.setFont(new Font("Arial Black", Font.BOLD, 50));
		contentPane.add(btnButton_7);
		
		JButton btnButton_8 = new JButton("8");
		btnButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mostrarResultado) {
					labelOutput.setText("");
					mostrarResultado = false;
				}
				labelOutput.setText(labelOutput.getText() + "8");
			}
		});
		btnButton_8.setBounds(122, 230, 106, 99);
		btnButton_8.setFont(new Font("Arial Black", Font.BOLD, 50));
		contentPane.add(btnButton_8);
		
		JButton btnButton_9 = new JButton("9");
		btnButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mostrarResultado) {
					labelOutput.setText("");
					mostrarResultado = false;
				}
				labelOutput.setText(labelOutput.getText() + "9");
			}
		});
		btnButton_9.setBounds(238, 230, 106, 99);
		btnButton_9.setFont(new Font("Arial Black", Font.BOLD, 50));
		contentPane.add(btnButton_9);
		
		JButton btnButton_0 = new JButton("0");
		btnButton_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mostrarResultado) {
					labelOutput.setText("");
					mostrarResultado = false;
				}
				labelOutput.setText(labelOutput.getText() + "0");
			}
		});
		btnButton_0.setBounds(122, 559, 106, 51);
		btnButton_0.setFont(new Font("Arial Black", Font.BOLD, 50));
		contentPane.add(btnButton_0);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!labelOutput.getText().equalsIgnoreCase("")) {
					String numero = labelOutput.getText().substring(0, labelOutput.getText().toString().length() - 1);
					labelOutput.setText(numero);
				}
			}
		});
		btnC.setBounds(354, 120, 106, 99);
		btnC.setFont(new Font("Arial Black", Font.BOLD, 50));
		contentPane.add(btnC);
		
		JButton btnButton_dividir = new JButton("÷");
		btnButton_dividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(labelOutput.getText().equalsIgnoreCase(null)) {
					labelOutput.setText("/");
				} else if(!mostrarResultado) {
					if(primerNumero) {
						n1 = Double.parseDouble(labelOutput.getText());
						operacion = "/";
						primerNumero = false;
						labelOutput.setText("");
					} else {
						n2 = Double.parseDouble(labelOutput.getText());
						Double resultado = realizarOperacion(n1, n2, operacion);
						labelOutput.setText(String.valueOf(resultado));
						n1 = resultado;
						mostrarResultado = true;
					}
				}
			}
		});
		btnButton_dividir.setBounds(354, 230, 106, 99);
		btnButton_dividir.setFont(new Font("Arial Black", Font.BOLD, 50));
		contentPane.add(btnButton_dividir);
		
		JButton btnButton_menos = new JButton("-");
		btnButton_menos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(labelOutput.getText().equalsIgnoreCase("")) {
					labelOutput.setText("-");
				} else if(!mostrarResultado) {
					if(primerNumero) {
						n1 = Double.parseDouble(labelOutput.getText());
						operacion = "-";
						primerNumero = false;
						labelOutput.setText("");
					} else {
						n2 = Double.parseDouble(labelOutput.getText());
						Double resultado = realizarOperacion(n1, n2, operacion);
						labelOutput.setText(String.valueOf(resultado));
						n1 = resultado;
						mostrarResultado = true;
					}
				}
			}
		});
		btnButton_menos.setVerticalAlignment(SwingConstants.BOTTOM);
		btnButton_menos.setBounds(354, 343, 106, 99);
		btnButton_menos.setFont(new Font("Arial Black", Font.BOLD, 74));
		contentPane.add(btnButton_menos);
		
		JButton btnButton_mas = new JButton("+");
		btnButton_mas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(labelOutput.getText().equalsIgnoreCase("")) {
					labelOutput.setText("+");
				} else if(!mostrarResultado) {
					if(primerNumero) {
						n1 = Double.parseDouble(labelOutput.getText());
						operacion = "+";
						primerNumero = false;
						labelOutput.setText("");
					} else {
						n2 = Double.parseDouble(labelOutput.getText());
						Double resultado = realizarOperacion(n1, n2, operacion);
						labelOutput.setText(String.valueOf(resultado));
						n1 = resultado;
						mostrarResultado = true;
					}
				}
			}
		});
		btnButton_mas.setBounds(354, 453, 106, 99);
		btnButton_mas.setFont(new Font("Arial Black", Font.BOLD, 50));
		contentPane.add(btnButton_mas);
		
		JButton btnButton_resultado = new JButton("=");
		btnButton_resultado.setBounds(354, 559, 106, 51);
		btnButton_resultado.setFont(new Font("Arial Black", Font.BOLD, 50));
		contentPane.add(btnButton_resultado);
		
		JButton btnButton_coma = new JButton(",");
		btnButton_coma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelOutput.setText(labelOutput.getText() + ".");
			}
		});
		btnButton_coma.setVerticalAlignment(SwingConstants.BOTTOM);
		btnButton_coma.setBounds(238, 559, 106, 51);
		btnButton_coma.setFont(new Font("Arial Black", Font.BOLD, 47));
		contentPane.add(btnButton_coma);
		
		JButton btnButton_mas_menos = new JButton("+/-");
		btnButton_mas_menos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double numero = -Double.parseDouble(labelOutput.getText());
				labelOutput.setText(String.valueOf(numero));
			}
		});
		btnButton_mas_menos.setBounds(6, 559, 106, 51);
		btnButton_mas_menos.setFont(new Font("Arial Black", Font.BOLD, 50));
		contentPane.add(btnButton_mas_menos);
	}
}
