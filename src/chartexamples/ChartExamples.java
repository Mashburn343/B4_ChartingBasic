package chartexamples;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChartExamples extends JFrame {

	// field

	JPanel myPanel = new JPanel();
	JPanel minMaxPanel = new JPanel();
	JPanel constraintsPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JButton lineButton = new JButton("Line");
	JButton polarButton = new JButton("Polar");
	JButton barButton = new JButton("Bar");
	JButton pieButton = new JButton("Pie");
	JButton updateButton = new JButton("Update");

	JTextField Xmin = new JTextField("X-Min");
	JTextField Xmax = new JTextField("X-Max");
	JTextField Ymin = new JTextField("Y-Min");
	JTextField Ymax = new JTextField("Y-Max");
	JTextField xThird = new JTextField("X^3");
	JTextField xSecond = new JTextField("X^2");
	JTextField xFirst = new JTextField("X");
	JTextField constant = new JTextField("Constant");
	// data arrays
	double[] x = new double[200];
	double[] y = new double[200];
	double[] yd = new double[200];
	Color[] plotColor = new Color[10];
	Random myRandom = new Random();
	int ecks = 500;
	String ecksString = "";
	int wie = 500;
	String wieString = "";

	// constructor

	public ChartExamples() {

		setTitle("ジャック・イン・ザ・ボックス");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exitForm(e);
			}
		});

		ecksString = JOptionPane.showInputDialog("How wide do you want the window?");
		ecks = Integer.valueOf(ecksString);
		// System.out.println(ecks);
		wieString = JOptionPane.showInputDialog("How tall do you want the window?");
		wie = Integer.valueOf(wieString);
		// System.out.println(wie);

		getContentPane().setLayout(new GridBagLayout());

		myPanel.setPreferredSize(new Dimension(ecks, wie));
		myPanel.setBackground(Color.WHITE);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 4;
		constraints.gridheight = 4;
		constraints.insets = new Insets(10, 10, 10, 10);
		getContentPane().add(myPanel, constraints);

		minMaxPanel.setPreferredSize(new Dimension(110, 180));
		minMaxPanel.setLayout(new GridBagLayout());
		minMaxPanel.setBackground(Color.BLACK);
		constraints = new GridBagConstraints();
		constraints.gridx = 4;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.NORTH;
		// constraints.gridheight = 2;
		constraints.insets = new Insets(10, 10, 10, 10);
		getContentPane().add(minMaxPanel, constraints);

		constraintsPanel.setPreferredSize(new Dimension(110, 150));
		constraintsPanel.setLayout(new GridBagLayout());
		constraintsPanel.setBackground(Color.BLACK);
		constraints = new GridBagConstraints();
		constraints.gridx = 4;
		constraints.gridy = 2;
		constraints.anchor = GridBagConstraints.NORTH;
		// constraints.gridheight = 2;
		constraints.insets = new Insets(10, 10, 10, 10);
		getContentPane().add(constraintsPanel, constraints);
		
		buttonPanel.setPreferredSize(new Dimension(450, 50));
		buttonPanel.setLayout(new GridBagLayout());
		buttonPanel.setBackground(Color.BLACK);
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 4;
		//constraints.anchor = GridBagConstraints.NORTH;
		// constraints.gridheight = 2;
		constraints.insets = new Insets(10, 10, 10, 10);
		getContentPane().add(buttonPanel, constraints);

		lineButton.setPreferredSize(new Dimension(100, 25));
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(5, 5, 5, 5);
		buttonPanel.add(lineButton, constraints);
		lineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineButtonActionPerformed(e);
			}
		});

		polarButton.setPreferredSize(new Dimension(100, 25));
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(5, 5, 5, 5);
		buttonPanel.add(polarButton, constraints);
		polarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				polarButtonActionPerformed(e);
			}
		});

		barButton.setPreferredSize(new Dimension(100, 25));
		constraints = new GridBagConstraints();
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(5, 5, 5, 5);
		buttonPanel.add(barButton, constraints);
		barButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				barButtonActionPerformed(e);
			}
		});

		pieButton.setPreferredSize(new Dimension(100, 25));
		constraints = new GridBagConstraints();
		constraints.gridx = 3;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(5, 5, 5, 5);
		buttonPanel.add(pieButton, constraints);
		pieButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pieButtonActionPerformed(e);
			}
		});

		updateButton.setPreferredSize(new Dimension(100, 25));
		constraints = new GridBagConstraints();
		constraints.gridx = 5;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.NORTH;
		constraints.insets = new Insets(5, 5, 5, 5);
		minMaxPanel.add(updateButton, constraints);
		//constraintsPanel.add(updateButton, constraints);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateButtonActionPerformed(e);
			}
		});

		Xmin.setPreferredSize(new Dimension(100, 25));
		constraints = new GridBagConstraints();
		constraints.gridx = 5;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.NORTH;
		constraints.insets = new Insets(5, 5, 5, 5);
		minMaxPanel.add(Xmin, constraints);

		Xmax.setPreferredSize(new Dimension(100, 25));
		constraints = new GridBagConstraints();
		constraints.gridx = 5;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.NORTH;
		constraints.insets = new Insets(5, 5, 5, 5);
		minMaxPanel.add(Xmax, constraints);

		Ymin.setPreferredSize(new Dimension(100, 25));
		constraints = new GridBagConstraints();
		constraints.gridx = 5;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.NORTH;
		constraints.insets = new Insets(5, 5, 5, 5);
		minMaxPanel.add(Ymin, constraints);

		Ymax.setPreferredSize(new Dimension(100, 25));
		constraints = new GridBagConstraints();
		constraints.gridx = 5;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.NORTH;
		constraints.insets = new Insets(5, 5, 5, 5);
		minMaxPanel.add(Ymax, constraints);
		
		// power of x
		xThird.setPreferredSize(new Dimension(100, 25));
		constraints = new GridBagConstraints();
		constraints.gridx = 5;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.NORTH;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraintsPanel.add(xThird, constraints);

		xSecond.setPreferredSize(new Dimension(100, 25));
		constraints = new GridBagConstraints();
		constraints.gridx = 5;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.NORTH;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraintsPanel.add(xSecond, constraints);

		xFirst.setPreferredSize(new Dimension(100, 25));
		constraints = new GridBagConstraints();
		constraints.gridx = 5;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.NORTH;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraintsPanel.add(xFirst, constraints);

		constant.setPreferredSize(new Dimension(100, 25));
		constraints = new GridBagConstraints();
		constraints.gridx = 5;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.NORTH;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraintsPanel.add(constant, constraints);

		setVisible(true);
		pack();
		setLocationRelativeTo(null);

		plotColor[0] = Color.LIGHT_GRAY;
		plotColor[1] = Color.BLUE;
		plotColor[2] = Color.GREEN;
		plotColor[3] = Color.CYAN;
		plotColor[4] = Color.RED;
		plotColor[5] = Color.MAGENTA;
		plotColor[6] = Color.ORANGE;
		plotColor[7] = Color.DARK_GRAY;
		plotColor[8] = Color.GRAY;
		plotColor[9] = Color.BLACK;

	}

	// methods (handlers)

	private void exitForm(WindowEvent e) {
		System.exit(0);
	}

	private void lineButtonActionPerformed(ActionEvent e) {
		// System.out.println("line");
		double alpha = 0.1 - myRandom.nextDouble() * 0.2;
		double beta = myRandom.nextDouble() * 10 + 5;
		for (int i = 0; i < 200; i++) {
			// x[i] = i; // CHANGE THIS!!

			x[i] = i - 100;

			double a = 1.0, b = 50.0, c = 3.0, m = .5;
			// y[i] = a * x[i] * x[i] + b * x[i] + c;
			// y[i] = a * Math.pow(x[i], 2.0) + b * x[i] + c;

			// y = mx+b

			y[i] = m * x[i] + b;

			// y[i] = x[i];

		}

		Rectangle2D.Double borderRectangle = new Rectangle2D.Double(20, 20, (ecks - 40), (wie - 50));
		LineChartPanel myLineChart = new LineChartPanel();
		if (e.getActionCommand().equals(lineButton.getText())) {
			myLineChart = new LineChartPanel(borderRectangle, 200, x, y, plotColor[myRandom.nextInt(10)]);
		} else {
			myLineChart = new LineChartPanel(borderRectangle, 200, y, yd, plotColor[myRandom.nextInt(10)]);
		}
		myLineChart.setPreferredSize(new Dimension(ecks, wie));
		myLineChart.setBackground(Color.WHITE);
		myPanel.removeAll();
		myPanel.add(myLineChart);
		this.pack();

	}

	private void polarButtonActionPerformed(ActionEvent e) {
		System.out.println("polar");

	}

	private void barButtonActionPerformed(ActionEvent e) {
		System.out.println("bar");

	}

	private void pieButtonActionPerformed(ActionEvent e) {
		System.out.println("pie");

	}

	private void updateButtonActionPerformed(ActionEvent e) {
		System.out.println("update");
	}
}
