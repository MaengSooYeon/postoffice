package POSTOFFICE;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*; 
import javax.swing.*; 


public class showChoose extends JFrame {
	JPanel p;
	JLabel la;
	JButton bt1, bt2;
	public showChoose() {
		// setting
	    setTitle("Choose");
	    setSize(350, 150);
		setResizable(false);
		setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	   
	    // panel
	    p = new JPanel();
	    p.setLayout(null);
	    p.setBackground(new Color(245, 245, 245));
	    getContentPane().add(p);
	
	    // visible
	    setVisible(true);
	    
	    // add
	    la = new JLabel("�����ȸ�� ���Ͻô� �׸��� �������ּ���");
	    la.setFont(new Font("����ü", Font.PLAIN, 14));
	    la.setBounds(32, 23, 286, 25);
	    p.add(la);
	    
	    bt1 = new JButton("��������ȸ");
	    bt1.setForeground(new Color(0, 0, 128));
	    bt1.setBackground(Color.WHITE);
	    bt1.setBounds(32, 70, 134, 23);
	    p.add(bt1);
	    bt1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
					hide();
					new MailCheck();
	    	}
	    	});
	    
	    bt2 = new JButton("�ù�����ȸ");
	    bt2.setForeground(new Color(0, 0, 128));
	    bt2.setBackground(Color.WHITE);
	    bt2.setBounds(178, 70, 140, 23);
	    p.add(bt2);
	    bt2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
					hide();
					new ParcelCheck();
	    	}
	    	});
    }
}