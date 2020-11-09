package bsu.rfe.java.group7.lab3.Lipnitskij.varB;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class TCellRander implements TableCellRenderer {

	private String needle = null;
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	private DecimalFormat formatter = (DecimalFormat)NumberFormat.getInstance();
	
	public void setNeedle(String needle) {
	this.needle = needle;
	}
	
	public TCellRander() {
		formatter.setMaximumFractionDigits(5);
		formatter.setGroupingUsed(false);
		DecimalFormatSymbols dottedDouble = formatter.getDecimalFormatSymbols();
		dottedDouble.setDecimalSeparator('.');
		formatter.setDecimalFormatSymbols(dottedDouble);

	}

	public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2, boolean arg3, int arg4,
			int arg5) {
		String formattedDouble = formatter.format(arg1);

		label.setText(formattedDouble);
		panel.add(label);

		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		if (arg5==1 && needle!=null && needle.equals(arg1)) {

		panel.setBackground(Color.RED);
		} else {
		panel.setBackground(Color.WHITE);
		}
		return panel;

	}

}
