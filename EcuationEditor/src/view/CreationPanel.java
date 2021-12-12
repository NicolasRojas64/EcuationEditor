package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.ControllerListener;

public class CreationPanel extends JPanel{
	private static final long serialVersionUID = -6055755052972883337L;
	private JPanel stylePanel;
	private JPanel colorPanel;
	private EcuationEditorPanel ecuationEditorPanel;
	private ControllerListener controllerListener;
	private GridBagConstraints gridBagConstraints;
	
	public CreationPanel(ControllerListener controllerListener) {
		init(controllerListener);
	}
	
	public void init(ControllerListener controllerListener) {
		gridBagConstraints = new GridBagConstraints();
		setBackground(Color.WHITE);
		this.controllerListener = controllerListener;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		setLayout(new GridBagLayout());
		initEcuationEditorPanel();
		initStylePanel();
	}
	
	private void initEcuationEditorPanel() {
		this.ecuationEditorPanel = new EcuationEditorPanel(controllerListener);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		add(ecuationEditorPanel, gridBagConstraints);
	}
	
	private void initStylePanel() {
		this.stylePanel = new JPanel();
		stylePanel.setLayout(new BorderLayout());
		stylePanel.setBorder(new TitledBorder("Estilos"));
		stylePanel.setBackground(Color.WHITE);
		addColorButtons();
		addtStylesPanel();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		add(stylePanel, gridBagConstraints);
	}
	
	private void addColorButtons() {
		this.colorPanel = new JPanel();
		colorPanel.setLayout(new GridLayout(1,4));
		addColorButton(Color.RED, "RED");
		addColorButton(Color.BLUE, "BLUE");
		addColorButton(Color.GREEN, "GREEN");
		addColorButton(Color.ORANGE, "ORANGE");
		stylePanel.add(colorPanel, BorderLayout.NORTH);
	}
	
	private void addColorButton(Color color, String actionCommand) {
		JButton button = new JButton();
		button.setBackground(color);
		button.addActionListener(controllerListener);
		button.setActionCommand(actionCommand);
		colorPanel.add(button);
	}
	
	private void addtStylesPanel() {
		stylePanel.add(new StylePanel(controllerListener), BorderLayout.CENTER);
	}
	
	public EcuationEditorPanel getEcuationEditorPanel() {
		return ecuationEditorPanel;
	}
}
