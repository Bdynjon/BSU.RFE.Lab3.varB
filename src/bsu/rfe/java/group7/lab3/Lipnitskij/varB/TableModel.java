package bsu.rfe.java.group7.lab3.Lipnitskij.varB;

import java.awt.FlowLayout;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

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
		Double result;
	    result = coef[0];
	
	    for(int i=1; i<coef.length; i++)
	    {
		    result *= x;
		    result += coef[i];
	    }
	    
		if (arg1==0) {
		return x;
		} else if ( arg1 ==1 ) {
		    
		
		return result;
		}
		else
		{
			double val = result;
			
			String vs =Double.toString(val);
			
			int k= 0;
			
			for( int i=vs.length()-1; i>0; i--)
			{
				if( (double)vs.charAt(i) != 0 ) 
				{
					k=i;
					break;
				}
			}
			
			k = k-(Double.toString((int)val).length()-2);
			
			
			if( ((val / 100) >= 1) || ( k>=3) )
			{
				return true;
			}
			else return false;
			
		}  
	} 

}
