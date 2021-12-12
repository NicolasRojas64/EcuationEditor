package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import controller.ControllerListener;

public class MainFrame extends JFrame{
	private static final long serialVersionUID = 262722566845017667L;
	private CreationPanel creationPanel;
	private JScrollPane scrollPane;
	private ControllerListener controllerListener;
	
	
	public MainFrame(ControllerListener control) {
		controllerListener = control;
		initFrame();
		initComponents();
	}
	
	private void initFrame(){
		setSize(1000, 1000);
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void initComponents() {
		scrollPane = new JScrollPane();
		initCreationPanel();
	}
  
	private void initCreationPanel() {
		this.creationPanel = new CreationPanel(controllerListener);
		add(creationPanel, BorderLayout.SOUTH);
	}	
  
	public void initPlanePanel(PlanePanel planePanel) {
		add(planePanel, BorderLayout.CENTER);
		planePanel.setBackground(Color.WHITE);
		planePanel.setVisible(true);
	}
	
	public void initTablePanel(TablePanel tablePanel) {
		scrollPane = new JScrollPane(tablePanel);
		scrollPane.setPreferredSize(new Dimension(1000, 200));
		add(scrollPane, BorderLayout.NORTH);
		scrollPane.setVisible(true);
	}
	
	public void hideScrollPane() {
		this.scrollPane.setVisible(false);
	}
  
	public CreationPanel getCreationPanel() {
		return creationPanel;
	}
}
