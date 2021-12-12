package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TablePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private Integer[] xValues;
	private Integer[] yValues;
	private JTable table;
	
	public TablePanel(Integer[] xValues, Integer[] yValues) {
		init(xValues, yValues);
		this.setVisible(true);
	}
	
	public void init(Integer[] xValues, Integer[] yValues) {
		this.xValues = xValues;
		this.yValues = yValues;
		setBackground(Color.WHITE);
		initTable();
	}
	
	public void initTable() {
		Integer[][] data = new Integer[xValues.length][2];
		for (int i = 0; i < yValues.length; i++) {
			data[i][0] = xValues[i];
			data[i][1] = yValues[i];
		}
		String[] names = new String[] {"X", "Y"};
		table = new JTable(data, names);
		add(new JScrollPane(table));
	}
	
	public void setTable(Integer[] xValues, Integer[] yValues) {
		this.xValues = xValues;
		this.yValues = yValues;
	}
	
	public void hideTable() {
		this.table.setVisible(false);
	}
}
