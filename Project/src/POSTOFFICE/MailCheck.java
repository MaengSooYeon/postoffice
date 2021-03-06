package POSTOFFICE;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import java.io.IOException;
import javax.imageio.ImageIO;


public class MailCheck extends JFrame {
	BufferedImage img = null;
	
	MailCheck() {
		setTitle("���� �����ȸ");
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setSize(400, 300);
		layeredPane.setLayout(null);
		
		try {
			img = ImageIO.read(MainJFrame.class.getResource("/IMG/mailCheck.png"));
		} catch(IOException e) {
			JOptionPane.showMessageDialog(null, "�̹��� �ҷ����� ����");
			System.exit(0);
		}
		
		
		// button
		JButton okBtn = new JButton("Ȯ��");
		okBtn.setFont(new Font("�������ڸ��� Medium", Font.PLAIN, 13));
		okBtn.setBackground(new Color(255, 255, 255));
		okBtn.setForeground(new Color(247, 0, 0));
		okBtn.setBounds(217, 238, 80, 38);
		layeredPane.add(okBtn);
	      
		okBtn.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
				hide();
				new PrintJFrame();
		    }
		});
	      
		JButton cancelBtn = new JButton("���");
		cancelBtn.setFont(new Font("�������ڸ��� Medium", Font.PLAIN, 13));
		cancelBtn.setBackground(new Color(255, 255, 255));
		cancelBtn.setForeground(new Color(247, 0, 0));
		cancelBtn.setBounds(307, 238, 80, 38);
		layeredPane.add(cancelBtn);
	      
		cancelBtn.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
				hide();
		    	new Select();
		   }
		});
		
		
		// panel
		mailCheckPanel panel = new mailCheckPanel();
		panel.setSize(400, 300);
		layeredPane.add(panel);		
				
		getContentPane().setLayout(null);
		getContentPane().add(layeredPane);
		
		
		// textfield
		JTextField idText = new JTextField();
		idText.setBounds(31, 79, 155, 30);
		idText.setColumns(5);
		layeredPane.add(idText);
				
		JTextField pwText = new JTextField();
		pwText.setBounds(31, 175, 155, 30);
		pwText.setColumns(5);
		layeredPane.add(pwText);
		
				
		// base settings
		setBounds(0, 0, 415, 330);
		setVisible(true);									// ȭ�鿡 ǥ��
		setResizable(false);								// ������ ũ�� ����
		setLocationRelativeTo(null);						// â ��� ����
		setDefaultCloseOperation(EXIT_ON_CLOSE);			// ���� ��ư Ȱ��ȭ
	}

	class mailCheckPanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}
}