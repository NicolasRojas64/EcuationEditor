package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import controller.ControllerListener;

public class IntervalPanel extends JPanel{
	private static final long serialVersionUID = 4760943396289595868L;
	private int intervalBegining;
	private int intervalEnd;
	private JTextField intervalBeginingField;
	private JTextField intervalEndField;
	private JButton reInitButton;
	private JButton finishButton;
	private ControllerListener controllerListener;
	private GridBagConstraints gridBagConstraints;
	private JPanel buttonPanel;
	
	public IntervalPanel(ControllerListener controllerListener) {
		init(controllerListener);
	}
	
	private void init(ControllerListener controllerListener) {
		setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		initAtributes(controllerListener);
		initComponents();
	}

	private void initAtributes(ControllerListener controllerListener) {
		this.controllerListener = controllerListener;
		this.gridBagConstraints = new GridBagConstraints();
		intervalBeginingField = new JTextField();
		intervalEndField = new JTextField();
	}

	private void initComponents() {
		initInterval();
		initButtonPanel();
	}

	private void initButtonPanel() {
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridwidth = 8;
		this.buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,2));
		initReInitButton();
		initFinishButton();
		add(buttonPanel, gridBagConstraints);
	}
	
	private void initInterval() {
		setBorder(new TitledBorder("Intervalo"));
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		add(new JLabel("	"), gridBagConstraints);
		add(new JLabel("["), gridBagConstraints);
		add(intervalBeginingField, gridBagConstraints);
		add(new JLabel(" ,"), gridBagConstraints);
		add(intervalEndField, gridBagConstraints);
		add(new JLabel("	"), gridBagConstraints);
		add(new JLabel("]"), gridBagConstraints);
		add(new JLabel("	"), gridBagConstraints);
	}
	
	private void initReInitButton() {
		this.reInitButton = new JButton("Reiniciar");
		reInitButton.addActionListener(controllerListener);
		reInitButton.setActionCommand("RE_INIT");
		buttonPanel.add(reInitButton);
	}
	
	private void initFinishButton() {
		finishButton = new JButton("Terminar");
		finishButton.addActionListener(controllerListener);
		finishButton.setActionCommand("FINISH_INTERVAL");
		buttonPanel.add(finishButton);
	}	
	
	public int[] getXValues() {
		int[] xValues = new int[(intervalEnd - intervalBegining) + 1];
		for (int i = 0, j = intervalBegining; j <= intervalEnd; i++, j++) {
			xValues[i] = j;
		}
		return xValues;
	}
	
	public int getMaximunIntervalValue() {
		int maximunValue = 0;
		if(Math.abs(intervalBegining) > intervalEnd) {
			maximunValue = Math.abs(intervalBegining);
		}else {
			maximunValue = Math.abs(intervalBegining);
		}
		return maximunValue;
	}
	
	public int getIntervalBegining() {
		return intervalBegining;
	}

	public int getIntervalEnd() {
		return intervalEnd;
	}

	public JTextField getIntervalBeginingField() {
		return intervalBeginingField;
	}

	public JTextField getIntervalEndField() {
		return intervalEndField;
	}

	public void setIntervalBegining(int intervalBegining) {
		this.intervalBegining = intervalBegining;
	}

	public void setIntervalEnd(int intervalEnd) {
		this.intervalEnd = intervalEnd;
	}
	
	
}
