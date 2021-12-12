package view;

import java.awt.Color;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.JPanel;

public class PlanePanel extends JPanel{
	private static final long serialVersionUID = -419064692510897704L;
	private int[] xValues;
	private int[] yValues;
	private int[] xPositions;
	private int[] yPositions;
	private Color color;
	private String style;
	private DecimalFormat decimalFormat;
	
	public PlanePanel(int[] xValues, int[] yValues, String style, Color color) {
		this.color = color;
		this.xValues = xValues;
		this.yValues = yValues;
		this.style = style;
		initPlane();
	}
	
	private void initPlane() {
		setLayout(null);
		setBackground(Color.WHITE);
		initDecmalFormat();
		setVisible(true);
	}
	
	private void xPositions() {
		int maximunValue = getMaximunIntervalValue(xValues);
        double[] intervalPositions = new double[getMaximunIntervalValue(xValues)*2 +1];
        double[] intervalArray = new  double[intervalPositions.length];
        this.xPositions = new int[xValues.length];
        double axisSize = decimalFormat(getWidth()/2);
        double xUnit = decimalFormat(axisSize/maximunValue);
        
        for(double i = 0, j = maximunValue*-1, k = 0; k < intervalArray.length;i += xUnit, j++, k++) {
            intervalPositions[(int)k] = decimalFormat(i);
            intervalArray[(int)k] = decimalFormat(j);
        }
        
        for (int i = 0; i < xValues.length; i++) {
            for (int j = 0; j < intervalPositions.length; j++) {    
                if(xValues[i] == intervalArray[j]) {
                	xPositions[i] = (int)intervalPositions[j];
                }
            }
        }
       
    }
	
	private void yPositions() {
		int maximunValue = getMaximunIntervalValue(yValues);
        double[] intervalPositions = new double[getMaximunIntervalValue(yValues)*2 +1];
        double[] intervalArray = new  double[intervalPositions.length];
        this.yPositions = new int[yValues.length];
        double axisSize = decimalFormat(getHeight()/2);
        double yUnit = decimalFormat(axisSize/maximunValue);
        
        for(double i = 0, j = maximunValue, k = 0; k < intervalArray.length;i += yUnit, j--, k++) {
            intervalPositions[(int)k] = decimalFormat(i);
            intervalArray[(int)k] = decimalFormat(j);
        }
        
        for (int i = 0; i < yValues.length; i++) {
            for (int j = 0; j < intervalPositions.length; j++) {    
                if(yValues[i] == intervalArray[j]) {
                	yPositions[i] = (int)intervalPositions[j];
                }
            }
        }
       
    }
	
	private void drawAxis(Graphics g) {
		g.drawLine(getWidth()/2, getHeight()/2, 0, getHeight()/2);
		g.drawLine(getWidth()/2, getHeight()/2, getWidth()/2, 0);
		g.drawLine(getWidth()/2, getHeight()/2, getWidth(), getHeight()/2);
		g.drawLine(getWidth()/2, getHeight()/2, getWidth()/2, getHeight());
	}
	
	private void drawAxisEnd(Graphics g) {
		g.drawLine(0, getHeight()/2, 20, getHeight()/2 + 20);
		g.drawLine(0, getHeight()/2, 20, getHeight()/2 - 20);
		g.drawLine(getWidth()/2, 0, getWidth()/2 + 20, 20);
		g.drawLine(getWidth()/2, 0, getWidth()/2 - 20, 20);
		g.drawLine(getWidth(), getHeight()/2, getWidth() - 20, getHeight()/2 - 20);
		g.drawLine(getWidth(), getHeight()/2, getWidth() - 20, getHeight()/2 + 20);
		g.drawLine(getWidth()/2, getHeight(), getWidth()/2 - 20, getHeight() - 20);
		g.drawLine(getWidth()/2, getHeight(), getWidth()/2 + 20, getHeight() - 20);
	}
	
	private void paintXAxisValues(Graphics g) {
		int maximunXValue = getMaximunIntervalValue(this.xValues);
		int maximunXValueModul = findModul(maximunXValue);
		int xUnit = (getWidth()/2)/maximunXValue;
		for(int i = 0, j = maximunXValue * -1; i <= getWidth();i += xUnit, j++) {
			if(j != 0 && maximunXValue > 10 && j % maximunXValueModul == 0) {
				g.drawString("|", i, getHeight()/2 + 5);
				g.drawString(String.valueOf(j), i, getHeight()/2 + 20);
			}else {
				g.drawString("|", i, getHeight()/2 + 5);
				g.drawString(String.valueOf(j), i, getHeight()/2 + 20);
			}
		}
	}
	
	private void paintYAxisValues(Graphics g) {
		int maximunYValue = getMaximunIntervalValue(this.yValues);
		int maximunYValueModul = findModul(maximunYValue);
		double axisSize = decimalFormat(getHeight()/2);
		double yUnit = axisSize/maximunYValue;
		for(double i = 0, j = maximunYValue; i <= getHeight();i += yUnit, j--) {
			if(j != 0 && maximunYValueModul > 10 && j % maximunYValueModul == 0) {
				g.drawString("-", getWidth()/2, (int) i);
				g.drawString(String.valueOf(j), getWidth()/2 + 10, (int) i);
			}else if(maximunYValueModul <= 10){
				g.drawString("-", getWidth()/2, (int) i);
				g.drawString(String.valueOf(j), getWidth()/2 + 10, (int) i);
			}
		}	
	}
	
	private void paintPoints(Graphics g) {
		xPositions();
		yPositions();
		g.setColor(color);
		for (int i = 0; i < xPositions.length ; i++) {
			g.drawString("0", xPositions[i], yPositions[i]);
		}
	}
	
	private void paintLineAndPoints(Graphics g) {
		xPositions();
		yPositions();
		g.setColor(color);
		g.drawPolyline(xPositions, yPositions, xPositions.length);
		for (int i = 0; i < xPositions.length ; i++) {
			g.drawString("0", xPositions[i], yPositions[i]);
		}
	}
	
	private void paintLine(Graphics g) {
		xPositions();
		yPositions();
		g.setColor(color);
		g.drawPolyline(xPositions, yPositions, xPositions.length);
	}
	
	private void paintSquares(Graphics g) {
		xPositions();
		yPositions();
		g.setColor(color);
		for (int i = 0; i < xPositions.length ; i++) {
			if(yPositions[i] > getHeight()/2) {
				g.fillRect(xPositions[i], getHeight()/2, 10, yPositions[i] - getHeight()/2);
			}else{
				g.fillRect(xPositions[i], yPositions[i], 10, getHeight()/2 - yPositions[i]);
			}
		}
	}
	
	private void paintData(Graphics g) {
		switch(style) {
		case "Default":
			paintPoints(g);
			break;
		case "Line and points":
			paintLineAndPoints(g);
			break;
		case "Line":
			paintLine(g);
			break;
		case "Squares":
			paintSquares(g);
			break;
		}
	}
	
	public void paint(Graphics g) {
		drawAxis(g);
		drawAxisEnd(g);
		paintXAxisValues(g);
		paintYAxisValues(g);
		paintData(g);
	}
	
	private int getMaximunIntervalValue(int[] interval) {
		int maximunValue = 0;
		if(Math.abs(interval[0]) > interval[interval.length-1]) {
			maximunValue = Math.abs(interval[0]);
		}else {
			maximunValue = interval[interval.length-1];
		}
		return maximunValue;
	} 
	
	private void initDecmalFormat() {
		DecimalFormatSymbols separator = new DecimalFormatSymbols();
		separator.setDecimalSeparator('.');
		decimalFormat = new DecimalFormat("#.##", separator);
	}
	
	private double decimalFormat(double number) {
		double result = Double.parseDouble(decimalFormat.format(number));
		return result;
	}
	
	private int findModul(int number) {
		int modul = 0;
		for (int i = 2; i <= number-1; i++) {
			if(number%i == 0) {modul = i;}
		}
		
		return modul;
	}
}
