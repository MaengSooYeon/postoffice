package POSTOFFICE;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import POSTOFFICE.MainJFrame.backgroundPanel;

import java.sql.*;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

//import POSTOFFICE.showPayChoose.pay;


public class Receipt extends JFrame {
	BufferedImage img = null;
	  
	Select select = new Select();
	showMailChoose showmail = new showMailChoose();
	LoginGUI log = new LoginGUI();
	
	
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/testlist1?characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false\\r\\n&serverTimezone=UTC&useSSL=false";
	
	Receipt(){
		setTitle("���� �Ϸ�");
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setSize(300, 250);
		layeredPane.setLayout(null);
		
		try {
			img = ImageIO.read(MainJFrame.class.getResource("/IMG/receipt.png"));
		} catch(IOException e) {
			JOptionPane.showMessageDialog(null, "�̹��� �ҷ����� ����");
			System.exit(0);
		}
		
		// button
		JButton go_to_mainBtn = new JButton("��������");
		go_to_mainBtn.setFont(new Font("�������ڸ��� Medium", Font.PLAIN, 13));
		go_to_mainBtn.setBackground(new Color(255, 255, 255));
		go_to_mainBtn.setForeground(new Color(247, 0, 0));
		go_to_mainBtn.setBounds(75, 110, 150, 43);
		layeredPane.add(go_to_mainBtn);
		
		go_to_mainBtn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
				hide();
				select.setTitle("�α��� �� �Դϴ�.");
				select.setVisible(true);
				//new PrintJFrame();
	    	}
	    });
		
		
		try {
	          // �ε�
	          Class.forName(driver);
	          // ����
	          Connection con = DriverManager.getConnection(url,"root", "se9703709");
	          java.util.Scanner in = new java.util.Scanner(System.in);
	  			java.sql.Statement stmt = con.createStatement();
	          java.io.InputStreamReader isr = new java.io.InputStreamReader(System.in);
	          int random = (int) Math.random();
	          
//	          ps = con.prepareStatement("insert into testlist1.order values(?,?,?,?,?,?,?)");
//	          ps.setString(1, "123");
//	          ps.setString(2, log.tex1.getText());
//	          ps.setString(3, showmail.w1.getText());
//	          ps.setString(4, showmail.c1.getText());
//	          ps.setString(5, showmail.ad1.getText());
//	          ps.setString(6, showmail.ad2.getText());
//	          ps.setString(7, showmail.ad3.getText());
	          
	          
	          String idstr = log.idText.getText().trim();
	          String w1str = showmail.weightText.getText().trim();
	          String c1str =showmail.countText.getText().trim();
	          String ad1str= showmail.addresseeText.getText().trim();
	          String ad2str = showmail.senderText.getText().trim();
	          String ad3str = showmail.addressText.getText().trim();
	          //System.out.println(id);
	          //��� ���� �ʿ� 
	          //��� ����...
	          String dbCommand = "INSERT testlist1.order VALUES('111','"+idstr+"','"+w1str+"','"+c1str+"','"+ad1str+"','"+ad2str+"','"+ad3str+"')";
	          stmt.executeUpdate(dbCommand);
	          
	      } catch (ClassNotFoundException e) {
	          System.out.println(e + "=> �ε� fail");
	      } catch (SQLException e) {
	          System.out.println(e + "=> ���� fail");
	      }
		
		
		// panel
		receiptPanel panel = new receiptPanel();
		panel.setSize(300, 250);
		layeredPane.add(panel);		
				
		setLayout(null);
		add(layeredPane);
				
				
		// base settings
		setBounds(0, 0, 310, 290);
		setVisible(true);									// ȭ�鿡 ǥ��
		setResizable(false);								// ������ ũ�� ����
		setLocationRelativeTo(null);						// â ��� ����
		setDefaultCloseOperation(EXIT_ON_CLOSE);			// ���� ��ư Ȱ��ȭ
	}
			
	class receiptPanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}
}