package bsu.rfe.java.group7.lab3.Lipnitskij.varB;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

	private Double[] coef;
	private Double from;
	private Double to;
	private Double step;
	
	public TableModel(Double from, Double to, Double step, Double[]
			coef) {
			this.from = from;
			this.to = to;
			this.step = step;
			this.coef = coef;
		}
	
	public Double getFrom() {
		return from;
	}
	public Double getTo() {
		return to;
	}
	public Double getStep() {
		return step;
	}

	public Class<?> getColumnClass(int column) {
		switch (column) {
		case 0:
			return Double.class;
		case 1:
			return Double.class;
		default:
		return Boolean.class;
		}
	}

	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Значение X";
		case 1:
			return "Значение многочлена";
		default:
		return "Последовательный ряд ?";
		}

	}


	public int getColumnCount() {
		return 3;
	}

	public int getRowCount() {
		return new Double(Math.ceil((to-from)/step)).intValue()+1;
	}

	public Object getValueAt(int arg0, int arg1) {
		double x = from + step*arg0;
		if (arg1==0) {
		return x;
		} else {
		Double result;
		
		
		
		return result;
		}

	}

}
