package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ControllerListener;

public class Fraction extends JPanel{
	private static final long serialVersionUID = 4752706316011006325L;
	private String denominatr;
	private String exponen;
	private JTextField denominatorField;
	private JTextField exponentField;
	private String stringRepresentation;
	private GridBagConstraints gridBagConstraints;
	private JButton finishButton;
	private ControllerListener controllerListener;
	
	public Fraction(ControllerListener controllerListener) {
		initPanel();
		initComponents(controllerListener);
	}
	
	private void initPanel() {
		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());	
	}
	
	private void initComponents(ControllerListener controllerListener) {
		gridBagConstraints = new GridBagConstraints();
		this.controllerListener = controllerListener;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.weightx = 1.0;
		initLabels();
		initTextFields();
		initFinishButton();
	}
	
	private void initLabels() {
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		add(new JLabel("Y"), gridBagConstraints);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		add(new JLabel(" = "), gridBagConstraints);
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 1;
		add(new JLabel("X"), gridBagConstraints);
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		add(new JLabel("------"), gridBagConstraints);
	}
	
	private void initTextFields() {
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		initExponentField();
		initDenominatorField();
	}
	
	private void initExponentField() {
		exponentField = new JTextField();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 0;
		add(exponentField, gridBagConstraints);
	}
	
	private void initDenominatorField() {
		denominatorField = new JTextField();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 4;
		add(denominatorField, gridBagConstraints);
	}
	
	private void initFinishButton() {
		finishButton = new JButton("Terminar");
	    finishButton.addActionListener(controllerListener);
	    finishButton.setActionCommand("FINISH_FRACTION");
	    gridBagConstraints.gridx = 5;
	    gridBagConstraints.gridy = 7;
	    this.add(finishButton, gridBagConstraints);
	}
	
	public void stringRepresentation(){
		stringRepresentation = "x^" + exponent + "/" + denominator;
	}

	public String getStringRepresentation() {
		return stringRepresentation;
	}

	public String getDenominator() {
		return denominator;
	}

	public String getExponent() {
		return exponent;
	}

	public JTextField getDenominatorField() {
		return denominatorField;
	}

	public JTextField getExponentField() {
		return exponentField;
	}

	public GridBagConstraints getGridBagConstraints() {
		return gridBagConstraints;
	}

	public JButton getFinishButton() {
		return finishButton;
	}

	public void setDenominator(String denominator) {
		this.denominator = denominator;
	}

	public void setExponent(String exponent) {
		this.exponent = exponent;
	}

	public void setDenominatorField(JTextField denominatorField) {
		this.denominatorField = denominatorField;
	}

	public void setExponentField(JTextField exponentField) {
		this.exponentField = exponentField;
	}

	public void setStringRepresentation(String stringRepresentation) {
		this.stringRepresentation = stringRepresentation;
	}

	public void setGridBagConstraints(GridBagConstraints gridBagConstraints) {
		this.gridBagConstraints = gridBagConstraints;
	}

	public void setFinishButton(JButton finishButton) {
		this.finishButton = finishButton;
	}

	public void setControllerListener(ControllerListener controllerListener) {
		this.controllerListener = controllerListener;
	}
	
	

}
