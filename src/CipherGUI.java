import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.AlgorithmConstraints;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import java.awt.SystemColor;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class CipherGUI {

	private JFrame frmTheCipher;
	JPanel panel;
	JRadioButton rdbtnDecrypt;
	JRadioButton rdbtnEncrypt;
	JComboBox algoComboBox;
	JPanel attributePanel;
	JLabel attributeLabel;
	JSpinner attributeSpinner;
	JButton btnReady;
	JLabel statusLabel;
	JEditorPane normalText;
	JEditorPane encryptText;
	JButton btnExecute;
	JButton btnClear;
	JButton btnClear_1;

	String algoList[] = { "Caesar", "Rail Fence" };
	String algoAttribute[] = { "Shift", "Row" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CipherGUI window = new CipherGUI();
					window.frmTheCipher.setVisible(true);
					window.doCipher();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CipherGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTheCipher = new JFrame();
		frmTheCipher.setBackground(Color.PINK);
		frmTheCipher.setResizable(false);
		frmTheCipher.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmTheCipher.setTitle("The Cipher");
		frmTheCipher.setBounds(100, 100, 800, 550);
		frmTheCipher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTheCipher.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(5, 5, 200, 225);
		frmTheCipher.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel step1Label = new JLabel("Step 1 : Select Type");
		step1Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		step1Label.setBounds(10, 10, 170, 30);
		panel.add(step1Label);

		JLabel step2Label = new JLabel("Step 2 : Select Algorithm");
		step2Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		step2Label.setBounds(10, 130, 170, 30);
		panel.add(step2Label);

		ButtonGroup group = new ButtonGroup();
		rdbtnEncrypt = new JRadioButton("Encrypt");
		rdbtnEncrypt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnEncrypt.setBounds(10, 50, 110, 30);
		panel.add(rdbtnEncrypt);

		rdbtnDecrypt = new JRadioButton("Decrypt");
		rdbtnDecrypt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnDecrypt.setBounds(10, 80, 110, 30);
		panel.add(rdbtnDecrypt);

		group.add(rdbtnEncrypt);
		group.add(rdbtnDecrypt);

		algoComboBox = new JComboBox();
		algoComboBox.setBounds(10, 175, 170, 30);
		for (int i = 0; i < algoList.length; i++) {
			algoComboBox.addItem(algoList[i]);
		}
		panel.add(algoComboBox);

		attributePanel = new JPanel();
		attributePanel.setBounds(5, 240, 200, 225);
		frmTheCipher.getContentPane().add(attributePanel);
		attributePanel.setLayout(null);

		JLabel step3Label = new JLabel("Step 3 : Adjust Attribute");
		step3Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		step3Label.setBounds(10, 10, 170, 30);
		attributePanel.add(step3Label);

		attributeLabel = new JLabel(algoAttribute[0]);
		attributeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		attributeLabel.setBounds(20, 100, 45, 30);
		attributePanel.add(attributeLabel);

		algoComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indexSelect = algoComboBox.getSelectedIndex();
				attributeLabel.setText(algoAttribute[indexSelect]);
			}
		});

		attributeSpinner = new JSpinner();
		attributeSpinner.setModel(new SpinnerNumberModel(2, -26, 26, 1));
		attributeSpinner.setBounds(65, 100, 50, 30);
		attributePanel.add(attributeSpinner);

		btnReady = new JButton("Ready !!!");
		btnReady.setBounds(5, 470, 200, 45);
		frmTheCipher.getContentPane().add(btnReady);

		JPanel statusPanel = new JPanel();
		statusPanel.setBounds(210, 470, 580, 45);
		frmTheCipher.getContentPane().add(statusPanel);
		statusPanel.setLayout(null);

		statusLabel = new JLabel("");
		statusLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		statusLabel.setBounds(10, 10, 550, 25);
		statusPanel.add(statusLabel);

		JPanel normalTextPanel = new JPanel();
		normalTextPanel.setBackground(new Color(60, 179, 113));
		normalTextPanel.setBounds(210, 5, 450, 225);
		normalTextPanel.setVisible(false);
		frmTheCipher.getContentPane().add(normalTextPanel);
		normalTextPanel.setLayout(null);

		JLabel normalTextLabel = new JLabel("Normal Text");
		normalTextLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		normalTextLabel.setBounds(175, 10, 200, 20);
		normalTextPanel.add(normalTextLabel);

		normalText = new JEditorPane();
		normalText.setBounds(25, 50, 400, 140);
		normalTextPanel.add(normalText);

		JPanel encryptTextPanel = new JPanel();
		encryptTextPanel.setBackground(new Color(255, 99, 71));
		encryptTextPanel.setBounds(210, 240, 450, 225);
		encryptTextPanel.setVisible(false);
		frmTheCipher.getContentPane().add(encryptTextPanel);
		encryptTextPanel.setLayout(null);

		JLabel encryptTextLabel = new JLabel("Encrypt Text");
		encryptTextLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		encryptTextLabel.setBounds(175, 10, 200, 20);
		encryptTextPanel.add(encryptTextLabel);

		encryptText = new JEditorPane();
		encryptText.setBounds(25, 50, 400, 140);
		encryptTextPanel.add(encryptText);

		btnExecute = new JButton("Execute");
		btnExecute.setBounds(665, 100, 125, 270);
		btnExecute.setVisible(false);
		frmTheCipher.getContentPane().add(btnExecute);

		btnClear = new JButton("Clear");
		btnClear.setBounds(665, 5, 125, 90);
		btnClear.setVisible(false);
		frmTheCipher.getContentPane().add(btnClear);

		btnClear_1 = new JButton("Clear");
		btnClear_1.setBounds(665, 375, 125, 90);
		btnClear_1.setVisible(false);
		frmTheCipher.getContentPane().add(btnClear_1);

		btnReady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				statusLabel.setText("");
				if (rdbtnEncrypt.isSelected() == false && rdbtnDecrypt.isSelected() == false) {
					statusLabel.setForeground(Color.RED);
					statusLabel.setText("Please Choose Encrypt or Decrypt");
				} else {
					if (rdbtnDecrypt.isSelected()) {
						normalTextPanel.setBounds(210, 240, 450, 225);
						encryptTextPanel.setBounds(210, 5, 450, 225);
					} else {
						normalTextPanel.setBounds(210, 5, 450, 225);
						encryptTextPanel.setBounds(210, 240, 450, 225);
					}
					normalTextPanel.setVisible(true);
					encryptTextPanel.setVisible(true);
					btnExecute.setVisible(true);
					btnClear.setVisible(true);
					btnClear_1.setVisible(true);
				}
			}
		});
	}

	private void doCipher() {
		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusLabel.setText("");
				String planText = "";
				String cipherText = "";
				String status = "";
				if (algoList[algoComboBox.getSelectedIndex()].equals("Caesar")) {
					Caesar c = new Caesar();
					int shift = (int) attributeSpinner.getValue();
					status += "Caesar ";
					if (rdbtnEncrypt.isSelected()) {
						planText = normalText.getText();
						String result = c.encrypt(planText, shift);
						encryptText.setText(result);
						status += "Encrypt ";
					} else {
						cipherText = encryptText.getText();
						String result = c.decrypt(cipherText, shift);
						normalText.setText(result);
						status += "Decrypt";
					}
				}
				else if (algoList[algoComboBox.getSelectedIndex()].equals("Rail Fence")) {
					RailFence r = new RailFence();
					int row = (int) attributeSpinner.getValue();
					status += "Rail Fence ";
					if (rdbtnEncrypt.isSelected()) {
						planText = normalText.getText();
						String result = r.encrypt(planText, row);
						encryptText.setText(result);
						status += "Encrypt";
					} else {
						cipherText = encryptText.getText();
						String result = r.decrypt(cipherText, row);
						normalText.setText(result);
						status += "Decrypt";
					}
				}
				status += "complete";
				statusLabel.setForeground(Color.black);
				statusLabel.setText(status);
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				normalText.setText("");
				encryptText.setText("");
			}
		});
	}
}
