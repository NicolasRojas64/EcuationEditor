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

public class Binomium extends JPanel{
	private static final long serialVersionUID = -7692675599414259229L;
	private String coeficent;
	private String exponent;
	private String secondTerm;
	private String sign; 
	private JTextField coeficentField;
	private JTextField exponentField;
	private JTextField secondTermField;
	private JComboBox<String> signsComboBox;
	private JButton finishButton;
	private String stringRepresentation;
	private GridBagConstraints gridBagConstraints;
	private ControllerListener controllerListener;
	
	public Binomium(ControllerListener controllerListener) {
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
	    initSignsComboBox();
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
	  }
	  
	private void initTextFields() {
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		initExponentField();
		initCoeficientField();
		initSecondTerm();
	}
	  
	private void initExponentField() {
		  exponentField = new JTextField();
		  gridBagConstraints.gridx = 4;
	      gridBagConstraints.gridy = 0;
	      this.add(exponentField, gridBagConstraints);
	  }
	  
	private void initCoeficientField() {
		  coeficentField = new JTextField();
		  gridBagConstraints.gridx = 2;
	      gridBagConstraints.gridy = 1;
	      this.add(coeficentField, gridBagConstraints);
	  }
	  
	private void initSecondTerm() {
		  secondTermField = new JTextField();
		  gridBagConstraints.gridx = 6;
	      gridBagConstraints.gridy = 1;
	      this.add(secondTermField, gridBagConstraints);
	  }
	  
	private void initSignsComboBox() {
		  signsComboBox = new JComboBox<String>(new String[] {"+", "-"});
		  gridBagConstraints.gridx = 5;
		  gridBagConstraints.gridy = 1;
		  this.add(signsComboBox, gridBagConstraints);
	  }
	
	private void initFinishButton() {
	    finishButton = new JButton("Terminar");
	    finishButton.addActionListener(controllerListener);
	    finishButton.setActionCommand("FINISH_BINOMIUM");
	    gridBagConstraints.gridx = 7;
	    gridBagConstraints.gridy = 3;
	    this.add(finishButton, gridBagConstraints);
	}
	
	public void stringRepresentation() {
		stringRepresentation = coeficent + "*X^" + exponent +sign+secondTerm;
	}

	public JTextField getCoeficentField() {
		return coeficentField;
	}

	public JTextField getExponentField() {
		return exponentField;
	}

	public JTextField getSecondTermField() {
		return secondTermField;
	}

	public JComboBox<String> getSignsComboBox() {
		return signsComboBox;
	}

	public JButton getFinishButton() {
		return finishButton;
	}

	public void setCoeficent(String coeficent) {
		this.coeficent = coeficent;
	}

	public void setExponent(String exponent) {
		this.exponent = exponent;
	}

	public void setSecondTerm(String secondTerm) {
		this.secondTerm = secondTerm;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
	public String getStringRepresentation() {
		return stringRepresentation;
	}

}
