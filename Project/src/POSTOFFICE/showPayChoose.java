package POSTOFFICE;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*; 
import javax.swing.*; 

public class showPayChoose extends JFrame {
	JPanel p; //p ���
	JLabel la;
	JButton Money, Card, bt1, bt2;
	JTextField tf;
	public showPayChoose() {
		// setting
	    setTitle("PAY");
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
	    
	    Money = new JButton("����");
	    Card = new JButton("ī��");
	    
	    //�������� ���� �� -> ���� �� �� ������ �Է��� �޴� â�� �ؿ� �߰��� �߰� ��. �ƴϸ� �� ���� ��â���ζ߰ų� ���� â�� �ٲ�� ����.
	    //��!!!!!!!!��ư ��ġ�� �������� ������!!!!!!!!!!
	    
	    // add
	    la = new JLabel("���� ������ �������ּ���");
	    la.setFont(new Font("����ü", Font.PLAIN, 14));
	    la.setBounds(65, 20, 189, 38);
	    
	    p.add(la);
	    p.add(Money);
	    p.add(Card);
	    
	   
	    Money.setForeground(new Color(0, 128, 128));
	    Money.setBackground(Color.WHITE);
	    Money.setBounds(79, 75, 140, 41);
	    
	    Money.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
					hide();
					new pay();
					//new PrintJFrame();
	    	}
	    	});
	    
	    Card.setForeground(new Color(0, 128, 128));
	    Card.setBackground(Color.WHITE);
	    Card.setBounds(79, 136, 140, 41);
	    
	    Card.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
					hide();
					new pay();
					//new PrintJFrame();   	
			}
	    	});
	}
	
class pay extends showPayChoose{
	public pay() {
		// setting
	    setTitle("PAY");
	    setSize(300, 250);
		setResizable(false);
		setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    // visible
	    setVisible(true);
	   
	    // Layout
	    p.setLayout(null);
	    
	    p = new JPanel();
	    p.setBackground(new Color(255, 255, 255));
	    getContentPane().add(p);
	    
	    bt1 = new JButton("Ȯ��");
        bt2 = new JButton("���");
	    
	    // add
	    la = new JLabel("���� �ݾ� �Է��ּ���");
	    la.setFont(new Font("����ü", Font.PLAIN, 14));
	    la.setBounds(65, 20, 189, 38);
	    
	    p.add(la);
	    
	    tf = new JTextField(20);
	    tf.setBounds(65, 60, 189, 38);
	    
	    bt1.setForeground(new Color(245, 245, 245));
        bt1.setBounds(30, 110, 69, 21);
        bt1.setBackground(new Color(47, 79, 79));
        bt1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
					hide();
					new PrintJFrame(); 
	    	}
	    	});
        
        bt2.setForeground(new Color(245, 245, 245));
        bt2.setBounds(80, 110, 69, 21);
        bt2.setBackground(new Color(47, 79, 79));
        bt2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
					hide();
					new showPayChoose();
	    	}
	    	});
	}
}
}
