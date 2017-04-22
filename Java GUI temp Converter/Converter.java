import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Converter extends JFrame {

	JPanel panel = new JPanel();

	JButton FButton = new JButton("Convert>>>");
	JTextField FText = new JTextField("", 10);
	JLabel FLabel = new JLabel("Fahrenheit");

	JButton CButton = new JButton("<<<<Convert");
	JTextField CText = new JTextField("", 10);
	JLabel CLabel = new JLabel("Celsius");

	public static void main(String[] args) {
		new Converter();
	}

	public Converter() {
		super("Temperature Converter");
		setSize(300, 300);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		FButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					double output = convertToC(Double.parseDouble(FText.getText()));
					System.out.println(output);
					FText.setText("");
					CText.setText(output+"");
				} catch (Exception e) {
					System.out.print("enter a number");
				}
			}
		});
		CButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					double output = convertToF(Double.parseDouble(CText.getText()));
					System.out.println(output);
					CText.setText("");
					FText.setText(output+"");
				} catch (Exception e) {
					System.out.print("enter a number");
				}
			}

		});
		// panel
		panel.add(FLabel);
		panel.add(FText);
		panel.add(FButton);
		panel.add(CLabel);
		panel.add(CText);
		panel.add(CButton);

		add(panel);

		setVisible(true);
	}

	public double convertToC(double f) {
		return ((f - 32) * 5) / 9;
	}
	private double convertToF(double c) {
		return 32 + (c * 9 / 5);
	}
}
