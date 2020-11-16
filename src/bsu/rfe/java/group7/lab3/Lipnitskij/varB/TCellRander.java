package bsu.rfe.java.group7.lab3.Lipnitskij.varB;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class TCellRander implements TableCellRenderer {

	private Double needle = null;
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JCheckBox cb = new JCheckBox();
	private DecimalFormat formatter = (DecimalFormat)NumberFormat.getInstance();
	
	public void setNeedle(Double needle) {
	this.needle = needle;
	}
	
	public TCellRander() {
		formatter.setMaximumFractionDigits(5);
		formatter.setGroupingUsed(false);
		DecimalFormatSymbols dottedDouble = formatter.getDecimalFormatSymbols();
		dottedDouble.setDecimalSeparator('.');
		formatter.setDecimalFormatSymbols(dottedDouble);
		panel.add(label);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));

	}

	public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2, boolean arg3, int arg4,
	int arg5) {
		if( arg5!= 2) {

		String formattedDouble = formatter.format(arg1);
		label.setText(String.valueOf(formattedDouble));
		
		if( (arg5 == 1) && ( ( (double)arg1>=0 && (double)arg0.getValueAt(arg4, 0)<0  ) || ((double)arg1<0 && (double)arg0.getValueAt(arg4, 0)>=0  ))   ) {
			panel.setBackground(Color.BLUE);
			
		}else  if (arg5==1 && needle!=null && (needle==(double)arg1) ) {

		panel.setBackground(Color.RED);
			
		}else {
		panel.setBackground(Color.WHITE);
		}
		return panel;
	}
	else {
		boolean b = (boolean)arg1;
		cb.setSelected(b);
		cb.setBackground(Color.WHITE);
		return cb;
	}
	    
	}
	    
	

	

}
