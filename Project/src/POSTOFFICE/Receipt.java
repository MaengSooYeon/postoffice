package POSTOFFICE;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import POSTOFFICE.showPayChoose.pay;

public class Receipt extends JFrame {
	JPanel p; //p ���
	JLabel la;
	JTextField tf;
	JButton b1;
	 Connection con;
	  Statement st;
	  PreparedStatement ps;
	  ResultSet rs;
	Select select = new Select();
	showMailChoose showmail = new showMailChoose();
	LoginGUI log = new LoginGUI();
	
	
	String driver = "com.mysql.jdbc.Driver";
	  String url = "jdbc:mysql://localhost/testlist1?characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false\\r\\n&serverTimezone=UTC&useSSL=false";
	  
	Receipt(){
		// setting
		System.out.println("�α���"+log.tex1.getText().trim());
		System.out.println(showmail.w1.getText());
	    setTitle("�����Ϸ�");
	    setSize(300, 250);
		setResizable(false);
		setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    // visible
	    setVisible(true);
	   
	    // Layout
	    p = new JPanel(); 
	    p.setLayout(null);
	    p.setBackground(new Color(230, 230, 250));
	    getContentPane().add(p);
	    
	    b1 = new JButton("��������");
	    // add
	    la = new JLabel("������ �Ϸ�Ǿ����ϴ�.");
	    la.setFont(new Font("����ü", Font.PLAIN, 14));
	    la.setBounds(65, 20, 189, 38);

	    p.add(la);
	    p.add(b1);
	    
	    b1.setForeground(new Color(0, 128, 128));
	    b1.setBackground(Color.WHITE);
	    b1.setBounds(79, 75, 140, 41);
	    
	    b1.addActionListener(new ActionListener() {
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
	          con = DriverManager.getConnection(url,"root", "se9703709");
	          java.util.Scanner in = new java.util.Scanner(System.in);
	  			java.sql.Statement stmt = con.createStatement();
	          java.io.InputStreamReader isr = new java.io.InputStreamReader(System.in);
	          //String id = log.tex1.getText().trim();
	          String w1 = showmail.w1.getText().trim();
	          String c1 =showmail.c1.getText().trim();
	          String ad1= showmail.ad1.getText().trim();
	          String ad2 = showmail.ad2.getText().trim();
	          String ad3 = showmail.ad3.getText().trim();
	          //System.out.println(id);
	          System.out.println(w1);
	          String dbCommand = "INSERT testlist1.order VALUES('"+203233+"','id','"+w1+"','"+c1+"','"+ad1+"','"+ad2+"','"+ad3+"')";
	          stmt.executeUpdate(dbCommand);
	      } catch (ClassNotFoundException e) {
	          System.out.println(e + "=> �ε� fail");
	      } catch (SQLException e) {
	          System.out.println(e + "=> ���� fail");
	      }
	}
}
