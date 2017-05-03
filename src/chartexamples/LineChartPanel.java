package chartexamples;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class LineChartPanel extends JPanel {
	private Rectangle2D.Double borderRectangle;
	private int n;
	private double[] x;
	private double[] y;
	private Color c;

	public LineChartPanel() {
		// default constructor for initialization
	}

	public LineChartPanel(Rectangle2D.Double border, int nPoints, double[] xValues, double[] yValues,
			Color colorValue) {
		this.borderRectangle = border;
		this.n = nPoints;
		this.x = xValues;
		this.y = yValues;
		this.c = colorValue;
	}

	public void paintComponent(Graphics g) {

		// super.paint(g); // fixes the immediate problem.

		if (n < 2) {
			return;
		}
		double xMin = x[0];
		double xMax = x[0];
		double yMin = y[0];
		double yMax = y[0];
		// STOPPED HERE FOR BUGSHOOT

		
		
		xMin = -100;
		xMax = 100;
		yMin = -100;
		yMax = 100;



		/*
		 for (int i = 100; i < n; i++) { xMin = Math.min(xMin, x[i]); xMax =
		 Math.max(xMax, x[i]); yMin = Math.min(yMin, y[i]); yMax =
		 Math.max(yMax, y[i]);
		 }
		*/

		//System.out.println((getWidth() / 2));
		//System.out.println((getHeight() / 2));

		yMin = (1 - 0.05 * Double.compare(yMin, 0)) * yMin;
		yMax = (1 + 0.05 * Double.compare(yMax, 0)) * yMax;
		Graphics2D g2D = (Graphics2D) g;
		super.paintComponent(g2D);
		Line2D.Double myLine;
		Line2D lin = new Line2D.Double((getWidth() - 20), getHeight() / 2, 20, getHeight() / 2);
		g2D.draw(lin);
		Line2D lin2 = new Line2D.Double(getWidth() / 2, 20, getWidth() / 2, getHeight() - 30);
		g2D.draw(lin2);
		g2D.setPaint(c);
		for (int i = 0; i < n - 1; i++) {
			myLine = new Line2D.Double(xPhysicalToxUser(borderRectangle, x[i], xMin, xMax),
					yPhysicalToyUser(borderRectangle, y[i], yMin, yMax),
					xPhysicalToxUser(borderRectangle, x[i + 1], xMin, xMax),
					yPhysicalToyUser(borderRectangle, y[i + 1], yMin, yMax));
			g2D.draw(myLine);
		}
		g2D.setPaint(Color.BLACK);
		g2D.draw(borderRectangle);
		g2D.dispose();

	}

	private double xPhysicalToxUser(Rectangle2D.Double r, double xPhysical, double xMin, double xMax) {
		return (r.x + (xPhysical - xMin) * (r.width - 1) / (xMax - xMin));
	}

	private double yPhysicalToyUser(Rectangle2D.Double r, double yPhysical, double yMin, double yMax) {
		return (r.y + (yMax - yPhysical) * (r.height - 1) / (yMax - yMin));

	}

} // end of class
