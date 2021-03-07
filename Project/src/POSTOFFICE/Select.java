package POSTOFFICE;
 
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import java.io.IOException;
import javax.imageio.ImageIO;


public class Select extends JFrame{
	BufferedImage img = null;
	
    Select() {
    	setTitle("SELECT");

    	JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setSize(800, 510);
		layeredPane.setLayout(null);
		
		try {
			img = ImageIO.read(MainJFrame.class.getResource("/IMG/select.png"));
		} catch(IOException e) {
			JOptionPane.showMessageDialog(null, "�̹��� �ҷ����� ����");
			System.exit(0);
		}
		
		// button
		JButton mailBtn = new JButton();				// ���� ���� ��ư
		mailBtn.setIcon(new ImageIcon(MainJFrame.class.getResource("/IMG/mailChooseIcon.png")));
		mailBtn.setBorderPainted(false); 				// �ܰ��� x
		mailBtn.setContentAreaFilled(false); 			// ���� ä��� x
		mailBtn.setFocusPainted(false); 				// �׵θ� x
		mailBtn.setBounds(18, 140, 179, 210);
		layeredPane.add(mailBtn);
	    
		mailBtn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
					hide();
					new showMailChoose();
	    	}
	    });
		
		
		JButton postBtn = new JButton();				// �ù� ���� ��ư
		postBtn.setIcon(new ImageIcon(MainJFrame.class.getResource("/IMG/parcelChooseIcon.png")));
		postBtn.setBorderPainted(false); 				// �ܰ��� x
		postBtn.setContentAreaFilled(false); 			// ���� ä��� x
		postBtn.setFocusPainted(false); 				// �׵θ� x
		postBtn.setBounds(215, 140, 179, 210);
		layeredPane.add(postBtn);
	    
		postBtn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
					hide();
					new showParcelChoose();
	    	}
	    });
		
		
		JButton searchBtn = new JButton();				// ��� ��ȸ ��ư
		searchBtn.setIcon(new ImageIcon(MainJFrame.class.getResource("/IMG/searchMoney.png")));
		searchBtn.setBorderPainted(false); 				// �ܰ��� x
		searchBtn.setContentAreaFilled(false); 			// ���� ä��� x
		searchBtn.setFocusPainted(false); 				// �׵θ� x
		searchBtn.setBounds(410, 140, 179, 210);
		layeredPane.add(searchBtn);
	    
		searchBtn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
					hide();
					new showChoose();
	    	}
	    });
		
		
		JButton cancelBtn = new JButton();				// ���� ��� ��ư
		cancelBtn.setIcon(new ImageIcon(MainJFrame.class.getResource("/IMG/cancel.png")));
		cancelBtn.setBorderPainted(false); 				// �ܰ��� x
		cancelBtn.setContentAreaFilled(false); 			// ���� ä��� x
		cancelBtn.setFocusPainted(false); 				// �׵θ� x
		cancelBtn.setBounds(600, 140, 179, 210);
		layeredPane.add(cancelBtn);
	    
		cancelBtn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
					hide();
					new UserJDailogGUI(null, "����");
	    	}
	    });
    	
		
		// panel
		selectPanel panel = new selectPanel();
		panel.setSize(800, 510);
		layeredPane.add(panel);		
						
		getContentPane().setLayout(null);
		getContentPane().add(layeredPane);
    	
    	
		// base settings
		setBounds(0, 0, 815, 535);
		setVisible(true);									// ȭ�鿡 ǥ��
		setResizable(false);								// ������ ũ�� ����
		setLocationRelativeTo(null);						// â ��� ����
		setDefaultCloseOperation(EXIT_ON_CLOSE);			// ���� ��ư Ȱ��ȭ
    }
		
		
    	//-------------------------------------------
//			Ifq = new JButton(); //������ȸ
//			Ifq.setBounds(67, 298, 163, 69);
//			Ifq.setIcon(new ImageIcon(MainJFrame.class.getResource("/IMG/Searchnumber.png")));
//			Ifq.setBorderPainted(false); //�ܰ��� x
//		    Ifq.setContentAreaFilled(false); //���� ä��� x
//		    Ifq.setFocusPainted(false); //�׵θ� x
//		    Ifq.setSize(175,165);
//			p.add(Ifq);
//			
//			la3 = new JLabel("������ȸ");
//			la3.setFont(new Font("����", Font.PLAIN, 14));
//			la3.setBounds(139, 412, 57, 15);
//			p.add(la3);
//			
//			Ifq.addActionListener(new ActionListener() {
//		    	public void actionPerformed(ActionEvent e) {
//						hide();
//						//new MenuJTabaleExam();
////						new Check();
//		    	}
//		    });
			

//			ChangeIf = new JButton(); //��������
//			ChangeIf.setBounds(531, 298, 163, 69);
//			ChangeIf.setIcon(new ImageIcon(MainJFrame.class.getResource("/IMG/Modify.png")));
//			ChangeIf.setBorderPainted(false); //�ܰ��� x
//		    ChangeIf.setContentAreaFilled(false); //���� ä��� x
//		    ChangeIf.setFocusPainted(false); //�׵θ� x
//		    ChangeIf.setSize(175,165);
//			p.add(ChangeIf);
//			
//			la5 = new JLabel("��������");
//			la5.setFont(new Font("����", Font.PLAIN, 14));
//			la5.setBounds(608, 413, 57, 15);
//			p.add(la5);
//			
//			ChangeIf.addActionListener(new ActionListener() {
//		    	public void actionPerformed(ActionEvent e) {
//						hide();
//						new MenuJTabaleExam(); //���� �κ��� ȸ������ â���� ���õ� ���� �����ϴ°Ŷ� ���� �� â�� �� ����.
//						//new UserJDailogGUI(null, "����");
//		    	}
//		    });
//			
//			
//			Management = new JButton(); //ȸ������
//			Management.setBounds(677, 346, 107, 125);
//			Management.setIcon(new ImageIcon(MainJFrame.class.getResource("/IMG/Gearwhell.png"))); //�����������ϱ�
//			Management.setBorderPainted(false); //�ܰ��� x
//		    Management.setContentAreaFilled(false); //���� ä��� x
//		    Management.setFocusPainted(false); //�׵θ� x
//		    Management.setSize(105,125);
//			p.add(Management);
//			
//			Management.addActionListener(new ActionListener() {
//		    	public void actionPerformed(ActionEvent e) {
//						hide();
//						new MenuJTabaleExam();
//		    	}
//		    	});
	//-------------------------------------------

	class selectPanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}	
}