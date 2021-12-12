package controller;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Funtion;
import view.MainFrame;
import view.PlanePanel;
import view.TablePanel;
import view.Trinomium;
import view.Binomium;
import view.EcuationEditorPanel;
import view.Fraction;
import view.IntervalPanel;


public class ControllerListener implements ActionListener{
	private MainFrame mainFrame;
	private String ecuation;
	private String style;
	private Color color;
	private PlanePanel planePanel;
	private TablePanel tablePanel;
	int[] xValues;
	int[] yValues;
	
	public ControllerListener() {
		mainFrame = new MainFrame(this);
		mainFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		Binomium binomium;
		Trinomium trinomium;
		Fraction fraction;
		EcuationEditorPanel ecuationEditor = mainFrame.getCreationPanel().getEcuationEditorPanel();
		IntervalPanel intervalPanel = mainFrame.getCreationPanel().getEcuationEditorPanel().getIntervalPanel();
		Funtion function;
		switch(e.getActionCommand()) {
		case "BINOMIUM_BUTTON":
			ecuationEditor.getCardLayout().show(ecuationEditor.getEcuationPanel(), "binomium");
			break;
		case "FRACTION_BUTTON":
			ecuationEditor.getCardLayout().show(ecuationEditor.getEcuationPanel(), "fraction");
			break;
		case "TRINOMIUM_BUTTON":
			ecuationEditor.getCardLayout().show(ecuationEditor.getEcuationPanel(), "trinomium");
			break;
			
		case "FINISH_BINOMIUM":
			binomium = ecuationEditor.getBinomiumPanel();
			ecuation = finishBinomium(binomium);
			break;
			
		case "FINISH_TRINOMIUM":
			trinomium = ecuationEditor.getTrinomiumPanel();
			ecuation = finishTrinomium(trinomium);
			break;
			
		case "FINISH_FRACTION":
			fraction = ecuationEditor.getFractionPanel();
			ecuation = finishFraction(fraction);
			break;
			
		case "FINISH_INTERVAL":
			style = "Default";
			color = Color.RED;
			int intervalBegining = Integer.parseInt(intervalPanel.getIntervalBeginingField().getText());
			int intervalEnd = Integer.parseInt(intervalPanel.getIntervalEndField().getText());
			intervalPanel.setIntervalBegining(intervalBegining);
			intervalPanel.setIntervalEnd(intervalEnd);
			function = new Funtion(ecuation, intervalBegining, intervalEnd);
			xValues = intervalPanel.getXValues();
			function.calculateData();
			yValues = function.getData();
			this.planePanel = new PlanePanel(xValues, yValues, style, color);
			tablePanel =  new TablePanel(intArrayToIntegerArray(xValues), intArrayToIntegerArray(yValues));
			this.tablePanel.setTable(intArrayToIntegerArray(xValues), intArrayToIntegerArray(yValues));
			planePanel.setBackground(Color.WHITE);
			this.mainFrame.initPlanePanel(planePanel);
			this.mainFrame.initTablePanel(tablePanel);
			break;
		case "RE_INIT":
			planePanel.setVisible(false);
			mainFrame.hideScrollPane();
			break;
		case "LINE":
			style = "Line"; 
			modifyPlane(xValues, yValues, style, color);
			break;
		case "POINTS":
			style = "Default"; 
			modifyPlane(xValues, yValues, style, color);
			break;
		case "LINE_AND_POINT":
			style = "Line and points";
			modifyPlane(xValues, yValues, style, color);
			break;
		case "SQUARES":
			style = "Squares";
			modifyPlane(xValues, yValues, style, color);
			break;
		case "BLUE":
			color = Color.BLUE;
			modifyPlane(xValues, yValues, style, color);
			break;
		case "RED":
			color = Color.RED;
			modifyPlane(xValues, yValues, style, color);
			break;
		case "GREEN":
			color = Color.GREEN;
			modifyPlane(xValues, yValues, style, color);
			break;
		case "ORANGE":
			color = Color.ORANGE;
			modifyPlane(xValues, yValues, style, color);
			break;
		}
	}
	
	private void modifyPlane(int[] xValues, int[] yValues, String style, Color color) {
		this.planePanel.setVisible(false);
		this.planePanel = new PlanePanel(xValues, yValues, style, color);
		this.mainFrame.initPlanePanel(this.planePanel);
		this.planePanel.setVisible(true);
	}
	
	private String finishBinomium(Binomium binomium) {
		binomium.setCoeficent(binomium.getCoeficentField().getText());
        binomium.setExponent(binomium.getExponentField().getText());
        binomium.setSecondTerm(binomium.getSecondTermField().getText());
        binomium.setSign((String) binomium.getSignsComboBox().getSelectedItem());
        binomium.stringRepresentation();
        return binomium.getStringRepresentation();
	}
	
	private String finishFraction(Fraction fraction) {
		fraction.setExponent(fraction.getExponentField().getText());
		fraction.setDenominator(fraction.getDenominatorField().getText());
		fraction.stringRepresentation();
		return fraction.getStringRepresentation();
	}
	
	private String finishTrinomium(Trinomium trinomium) {
		trinomium.setaCoeficent(trinomium.getaCoeficentField().getText());
		trinomium.setbCoeficent(trinomium.getbCoeficentField().getText());
        trinomium.setExponent(trinomium.getExponentField().getText());
        trinomium.setIndependentTerm(trinomium.getIndependentTermField().getText());
        trinomium.setSign1((String) trinomium.getSigns1ComboBox().getSelectedItem());
        trinomium.setSign2((String) trinomium.getSigns2ComboBox().getSelectedItem());
        trinomium.stringRepresentation();
        return trinomium.getStringRepresentation();
	}
	
	private Integer[] intArrayToIntegerArray(int[] intArray) {
		Integer[] integerArray = new Integer[intArray.length];
		for (int i = 0; i < integerArray.length; i++) {
			integerArray[i] = new Integer(intArray[i]);
		}
		return integerArray;
	}
}
