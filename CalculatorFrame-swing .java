	package com;

	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.EventQueue;
	import java.awt.Font;
	import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JMenu;
	import javax.swing.JMenuBar;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;

	public class CalculatorFrame extends JFrame implements ActionListener{

		private JPanel contentPane;
		private JMenu jMenuFile, jMenuHelp , jMenuExit;
		private JPanel jMaster, jplBackSpace, jplControl;
		private JLabel jLabelOuput;
		private JButton JbnButtons[];
		private boolean firstInput = true;
		private String numStr1 = "";
		private String numStr2 = "";
		Font f12 = new Font("Times New Roman", 0, 12);
		Font f121 = new Font("Times New Roman", 1, 12);
		private char op;


		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						CalculatorFrame frame = new CalculatorFrame();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public CalculatorFrame() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 700, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);

			jMenuFile = new JMenu("File");
			jMenuHelp = new JMenu("Help");
			jMenuExit = new JMenu("Exit");

			// Menu Bar
			JMenuBar mb = new JMenuBar();
			mb.add(jMenuFile);
			mb.add(jMenuHelp);
			mb.add(jMenuExit);
			setJMenuBar(mb);

			// frame component
			jMaster = new JPanel();
			jLabelOuput = new JLabel("Result");

			// add our component to frame
			getContentPane().add(jLabelOuput, BorderLayout.NORTH);
			JbnButtons = new JButton[32];

			for(int i = 0; i<= 9; i++) {
				JbnButtons[i] = new JButton(String.valueOf(i));
			}


			// Create operator Jbuttons
			JbnButtons[10] = new JButton("+/-");
			JbnButtons[11] = new JButton(".");
			JbnButtons[12] = new JButton("=");
			JbnButtons[13] = new JButton("/");
			JbnButtons[14] = new JButton("*");
			JbnButtons[15] = new JButton("-");
			JbnButtons[16] = new JButton("+");
			JbnButtons[17] = new JButton("sqrt");
			JbnButtons[18] = new JButton("1/x");
			JbnButtons[19] = new JButton("%");
			jplBackSpace = new JPanel();
			jplBackSpace.setLayout(new GridLayout(1, 1, 1, 1));
			JbnButtons[20] = new JButton("Backspace");
			jplBackSpace.add(JbnButtons[20]);
			jplControl = new JPanel();
			jplControl.setLayout(new GridLayout(1, 8, 1, 1));
			JbnButtons[21] = new JButton(" CE ");
			JbnButtons[22] = new JButton("C");
			JbnButtons[23] = new JButton("sinh");
			JbnButtons[24] = new JButton("cosh");
			JbnButtons[25] = new JButton("tan");
			JbnButtons[26] = new JButton("ln");
			JbnButtons[27] = new JButton("exp");
			JbnButtons[28] = new JButton("abs");
			JbnButtons[29] = new JButton("hex");
			JbnButtons[30] = new JButton("bin");
			JbnButtons[31] = new JButton("%");
			jplControl.add(JbnButtons[23]);
			jplControl.add(JbnButtons[21]);
			jplControl.add(JbnButtons[22]);
			jplControl.add(JbnButtons[23]);
			jplControl.add(JbnButtons[24]);
			jplControl.add(JbnButtons[25]);
			jplControl.add(JbnButtons[26]);
			jplControl.add(JbnButtons[27]);
			jplControl.add(JbnButtons[28]);
			jplControl.add(JbnButtons[29]);
			jplControl.add(JbnButtons[30]);
			jplControl.add(JbnButtons[31]);
			//Setting all Numbered JButton's to Blue. The rest to Red
			for (int i = 0; i < JbnButtons.length; i++) {
				JbnButtons[i].setFont(f12);
				if (i < 10)
					JbnButtons[i].setForeground(Color.blue);
				else
					JbnButtons[i].setForeground(Color.red);
			}

			JPanel jPLButtons = new JPanel();
			jPLButtons.setLayout(new GridLayout(4, 5, 2, 2));

			// add button to the jPLButtons
			for(int i = 7; i<=9; i++) {
				jPLButtons.add(JbnButtons[i]);
			}
			// add button / and sqrt
			jPLButtons.add(JbnButtons[13]);
			jPLButtons.add(JbnButtons[17]);
			// Second row
			for (int i = 4; i <= 6; i++) {
				jPLButtons.add(JbnButtons[i]);
			}
			// add button * and x^2
			jPLButtons.add(JbnButtons[14]);
			jPLButtons.add(JbnButtons[18]);
			// Third row
			for (int i = 1; i <= 3; i++) {
				jPLButtons.add(JbnButtons[i]);
			}
			//adds button - and %
			jPLButtons.add(JbnButtons[15]);
			jPLButtons.add(JbnButtons[19]);
			//Fourth Row
			// add 0, +/-, ., +, and =
			jPLButtons.add(JbnButtons[0]);
			jPLButtons.add(JbnButtons[10]);
			jPLButtons.add(JbnButtons[11]);
			jPLButtons.add(JbnButtons[16]);
			jPLButtons.add(JbnButtons[12]);

			jMaster.setLayout(new BorderLayout());
			jMaster.add(jPLButtons, BorderLayout.SOUTH);
			jMaster.add(jplBackSpace, BorderLayout.WEST);
			jMaster.add(jplControl, BorderLayout.EAST);
			getContentPane().add(jMaster, BorderLayout.SOUTH);
			requestFocus();

			for(int i = 0; i< JbnButtons.length; i++) {
				JbnButtons[i].addActionListener(this);
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String resultStr;
			String str = String.valueOf(e.getActionCommand());
			char ch = str.charAt(0);

			if(str.equals("hex") || str.equals("ln") || str.equals("e") || str.equals("cosh")||str.equals("sinh") ||str.equals("tan") ||str.equals("abs") ||str.equals("bin")){
				jLabelOuput.setText(e.getActionCommand() + "(" + numStr1 + ")"  );
				op = e.getActionCommand().charAt(0);
			}
			switch(ch)
			{
				case '0': case '1': case '2':
				case '3': case '4': case '5':
				case '6': case '7': case '8':
				case '9': if(firstInput)
				{
					numStr1 = numStr1 + ch;
					jLabelOuput.setText(numStr1);
				}
				else
				{
					numStr2 = numStr2 + ch;
					jLabelOuput.setText(numStr2);
				}
					break;
				case '+': case '-': case '*':                       //Step 4b
				case '/': case '%' : op = ch;
					firstInput = false;
					break;
				case '=': resultStr = evaluate();                   //Step 4c
					jLabelOuput.setText(resultStr);
					numStr1 = resultStr;
					numStr2 = "";
					firstInput = false;
					break;
				case 'C': jLabelOuput.setText("");                  //Step 4c
					numStr1 = "";
					numStr2 = "";
					firstInput = true;
			}
		}

		private String evaluate() {
			double resultat = 0;
			switch(op)
			{
				case '+': resultat = Integer.parseInt(numStr1) + Integer.parseInt(numStr2);; break;
				case '-': resultat = Integer.parseInt(numStr1) - Integer.parseInt(numStr2);; break;
				case '*': resultat = Integer.parseInt(numStr1) * Integer.parseInt(numStr2);; break;
				case 'h': resultat = Integer.parseInt(numStr1,16); break;
				case 'b': resultat = Integer.parseInt(numStr1,2); break;
				case 'e': resultat = Math.exp(Double.parseDouble(numStr1));break;
				case 'l': resultat = Math.log(Double.parseDouble(numStr1));break;
				case 's': resultat = Math.sinh(Double.parseDouble(numStr1));break;
				case 'c': resultat = Math.cosh(Double.parseDouble(numStr1));break;
				case 't': resultat = Math.tan(Double.parseDouble(numStr1));break;
				case 'a': resultat = Math.abs(Double.parseDouble(numStr1));break;
				case '/': resultat = Integer.parseInt(numStr1) / Integer.parseInt(numStr2);break;
				case '%': resultat = Integer.parseInt(numStr1) % Integer.parseInt(numStr2); break;
			}

			return String.valueOf(resultat);
		}



	}