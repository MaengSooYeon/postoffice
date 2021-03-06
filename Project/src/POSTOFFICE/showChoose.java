package POSTOFFICE;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import java.io.IOException;
import javax.imageio.ImageIO;


public class showChoose extends JFrame {
	BufferedImage img = null;
	Select select = new Select();
	
	showChoose() {
		setTitle("���� ȭ��");
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setSize(500, 200);
		layeredPane.setLayout(null);
		
		try {
			img = ImageIO.read(MainJFrame.class.getResource("/IMG/Choose.png"));
		} catch(IOException e) {
			JOptionPane.showMessageDialog(null, "�̹��� �ҷ����� ����");
			System.exit(0);
		}
		
		// button
		JButton mailCheckBtn = new JButton("��������ȸ");
		mailCheckBtn.setFont(new Font("�������ڸ��� Medium", Font.PLAIN, 13));
		mailCheckBtn.setBackground(new Color(247, 0, 0));
		mailCheckBtn.setForeground(new Color(255, 255, 255));
		mailCheckBtn.setBounds(60, 103, 150, 44);
		layeredPane.add(mailCheckBtn);
			      
		mailCheckBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hide();
				new MailCheck();
			}
		});
			      
		JButton parcelCheckBtn = new JButton("�ù�����ȸ");
		parcelCheckBtn.setFont(new Font("�������ڸ��� Medium", Font.PLAIN, 13));
		parcelCheckBtn.setBackground(new Color(247, 0, 0));
		parcelCheckBtn.setForeground(new Color(255, 255, 255));
		parcelCheckBtn.setBounds(282, 103, 150, 44);
		layeredPane.add(parcelCheckBtn);
			      
		parcelCheckBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hide();
				new ParcelCheck();
			}
		});
		
		JButton backBtn = new JButton("�ڷΰ���");
		backBtn.setFont(new Font("�������ڸ��� Medium", Font.PLAIN, 13));
		backBtn.setBackground(new Color(255, 255, 255));
		backBtn.setForeground(new Color(255, 139, 0));
		backBtn.setBounds(400, 5, 90, 23);
		layeredPane.add(backBtn);
	    
		backBtn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
				hide();
				select.setTitle("�α��� �� �Դϴ�.");
				select.setVisible(true);
	    	}
	    });
				
				
		// panel
		showChoosePanel panel = new showChoosePanel();
		panel.setSize(500, 200);
		layeredPane.add(panel);		
						
		getContentPane().setLayout(null);
		getContentPane().add(layeredPane);
				
						
		// base settings
		setBounds(0, 0, 515, 230);
		setVisible(true);									// ȭ�鿡 ǥ��
		setResizable(false);								// ������ ũ�� ����
		setLocationRelativeTo(null);						// â ��� ����
		setDefaultCloseOperation(EXIT_ON_CLOSE);			// ���� ��ư Ȱ��ȭ
	}

	class showChoosePanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}
}