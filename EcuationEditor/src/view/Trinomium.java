package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ControllerListener;

public class Trinomium extends JPanel{
	private static final long serialVersionUID = 8911654630631686531L;
	private String aCoeficent;
	private String bCoeficent;
	private String independentTerm;
	private String exponent;
	private String sign1;
	private String sign2;
	private JTextField aCoeficentField;
	private JTextField bCoeficentField;
	private JTextField exponentField;
	private JTextField independentTermField;
	private JComboBox<String> signs1ComboBox;
	private JComboBox<String> signs2ComboBox;
	private JButton finishButton;
	private String stringRepresentation;
	private GridBagConstraints gridBagConstraints;
	private ControllerListener controllerListener;
	
	public Trinomium(ControllerListener controllerListener) {
		initPanel();
		initComponents(controllerListener);
	}
	
	private void initPanel() {
	    this.setBackground(Color.WHITE);
	    this.setLayout(new GridBagLayout());
	}
	
	private void initComponents(ControllerListener controllerListener) {
		this.controllerListener = controllerListener;
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.weighty = 1.0;
	    gridBagConstraints.weightx = 1.0;
	    initLabels();
	    initTextFields();
	    initSignsBoxes();
	    initFinishButton();
	}
	  
	private void initLabels() {
	      gridBagConstraints.gridx = 0;
	      gridBagConstraints.gridy = 1;
	      this.add(new JLabel("Y"), gridBagConstraints);
	      gridBagConstraints.gridx = 1;
	      gridBagConstraints.gridy = 1;
	      this.add(new JLabel(" = "), gridBagConstraints);
	      gridBagConstraints.gridx = 3;
	      gridBagConstraints.gridy = 1;
	      this.add(new JLabel("X"), gridBagConstraints);
	      gridBagConstraints.gridx = 7;
	      gridBagConstraints.gridy = 1;
	      this.add(new JLabel("X"), gridBagConstraints);
	  }
	  
	private void initTextFields() {
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		initExponentField();
		initACoeficientField();
		initBCoeficientField();
		initIndependentTerm();
	}
	
	private void initSignsBoxes() {
		initSigns1ComboBox();
		initSigns2ComboBox();
	}
	  
	private void initExponentField() {
		  exponentField = new JTextField();
		  gridBagConstraints.gridx = 4;
	      gridBagConstraints.gridy = 0;
	      this.add(exponentField, gridBagConstraints);
	  }
	  
	private void initACoeficientField() {
		  aCoeficentField = new JTextField();
		  gridBagConstraints.gridx = 2;
	      gridBagConstraints.gridy = 1;
	      this.add(aCoeficentField, gridBagConstraints);
	}
	
	private void initBCoeficientField() {
		  bCoeficentField = new JTextField();
		  gridBagConstraints.gridx = 6;
	      gridBagConstraints.gridy = 1;
	      this.add(bCoeficentField, gridBagConstraints);
	  }
	  
	private void initIndependentTerm() {
		  independentTermField = new JTextField();
		  gridBagConstraints.gridx = 9;
	      gridBagConstraints.gridy = 1;
	      this.add(independentTermField, gridBagConstraints);
	  }
	  
	private void initSigns1ComboBox() {
		  signs1ComboBox = new JComboBox<String>(new String[] {"+", "-"});
		  gridBagConstraints.gridx = 5;
		  gridBagConstraints.gridy = 1;
		  this.add(signs1ComboBox, gridBagConstraints);
	}
	
	private void initSigns2ComboBox() {
		  signs2ComboBox = new JComboBox<String>(new String[] {"+", "-"});
		  gridBagConstraints.gridx = 8;
		  gridBagConstraints.gridy = 1;
		  this.add(signs2ComboBox, gridBagConstraints);
	}
	
	private void initFinishButton() {
	    finishButton = new JButton("Terminar");
	    finishButton.addActionListener(controllerListener);
	    finishButton.setActionCommand("FINISH_TRINOMIUM");
	    gridBagConstraints.gridx = 10;
	    gridBagConstraints.gridy = 3;
	    this.add(finishButton, gridBagConstraints);
	}
	
	public void stringRepresentation() {
		stringRepresentation = aCoeficent + "*X^" + exponent +sign1 + bCoeficent+ "*X" + sign2 + independentTerm;
	}
	
	public String getaCoeficent() {
		return aCoeficent;
	}

	public String getbCoeficent() {
		return bCoeficent;
	}

	public String getIndependentTerm() {
		return independentTerm;
	}

	public String getExponent() {
		return exponent;
	}

	public String getSign1() {
		return sign1;
	}

	public String getSign2() {
		return sign2;
	}

	public JTextField getaCoeficentField() {
		return aCoeficentField;
	}

	public JTextField getbCoeficentField() {
		return bCoeficentField;
	}

	public JTextField getExponentField() {
		return exponentField;
	}

	public JTextField getIndependentTermField() {
		return independentTermField;
	}

	public JComboBox<String> getSigns1ComboBox() {
		return signs1ComboBox;
	}

	public JComboBox<String> getSigns2ComboBox() {
		return signs2ComboBox;
	}

	public JButton getFinishButton() {
		return finishButton;
	}

	public String getStringRepresentation() {
		return stringRepresentation;
	}

	public GridBagConstraints getGridBagConstraints() {
		return gridBagConstraints;
	}

	public ControllerListener getControllerListener() {
		return controllerListener;
	}

	public void setaCoeficent(String aCoeficent) {
		this.aCoeficent = aCoeficent;
	}

	public void setbCoeficent(String bCoeficent) {
		this.bCoeficent = bCoeficent;
	}

	public void setIndependentTerm(String independentTerm) {
		this.independentTerm = independentTerm;
	}

	public void setExponent(String exponent) {
		this.exponent = exponent;
	}

	public void setSign1(String sign1) {
		this.sign1 = sign1;
	}

	public void setSign2(String sign2) {
		this.sign2 = sign2;
	}

	public void setaCoeficentField(JTextField aCoeficentField) {
		this.aCoeficentField = aCoeficentField;
	}

	public void setbCoeficentField(JTextField bCoeficentField) {
		this.bCoeficentField = bCoeficentField;
	}

	public void setExponentField(JTextField exponentField) {
		this.exponentField = exponentField;
	}

	public void setIndependentTermField(JTextField independentTermField) {
		this.independentTermField = independentTermField;
	}

	public void setSigns1ComboBox(JComboBox<String> signs1ComboBox) {
		this.signs1ComboBox = signs1ComboBox;
	}

	public void setSigns2ComboBox(JComboBox<String> signs2ComboBox) {
		this.signs2ComboBox = signs2ComboBox;
	}

	public void setFinishButton(JButton finishButton) {
		this.finishButton = finishButton;
	}

	public void setStringRepresentation(String stringRepresentation) {
		this.stringRepresentation = stringRepresentation;
	}

	public void setGridBagConstraints(GridBagConstraints gridBagConstraints) {
		this.gridBagConstraints = gridBagConstraints;
	}

	public void setControllerListener(ControllerListener controllerListener) {
		this.controllerListener = controllerListener;
	}

	
}
