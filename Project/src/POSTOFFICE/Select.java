//�׽�Ʈ������
package POSTOFFICE;
 
import java.awt.*;

import java.awt.event.*; 
import javax.swing.*;

public class Select extends JFrame{
		JPanel p;
		JLabel la, la1, la2, la3, la4, la5;
		JButton Mail, Post, Iq1, Ifq, Cancel, ChangeIf, Management;
    	public Select() {
    	setTitle("receipt");
			// setting
	        setSize(800, 510);
			setResizable(false);
			setLocationRelativeTo(null);
			setVisible(false);
	        
	        p = new JPanel();
		    p.setLayout(null);
	        p.setBackground(new Color(230, 230, 250));
	        getContentPane().add(p);
	        
	        Mail = new JButton(); //��������
	        Mail.setBounds(84,71,102,37);
	        Mail.setIcon(new ImageIcon(MainJFrame.class.getResource("/TEST/IMG/Mailchoose1.PNG")));
	        Mail.setBorderPainted(false); //�ܰ��� x
	        Mail.setContentAreaFilled(false); //���� ä��� x
	        Mail.setFocusPainted(false); //�׵θ� x
	        Mail.setSize(140,180);
	        p.add(Mail);
	        
	        la = new JLabel("��������");
	        la.setFont(new Font("����", Font.PLAIN, 14));
	        la.setBounds(129, 181, 57, 23);
	        p.add(la);
	        
	        Mail.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		hide();
						new showMailChoose();
		    	}
		    });
			
	        Post = new JButton(); //�ù�����
	        Post.setBounds(312,53,140,219);
	        Post.setIcon(new ImageIcon(MainJFrame.class.getResource("/TEST/IMG/Parcelchoose1.PNG")));
	        Post.setBorderPainted(false); //�ܰ��� x
	        Post.setContentAreaFilled(false); //���� ä��� x
	        Post.setFocusPainted(false); //�׵θ� x
	        Post.setSize(175,190);
	        p.add(Post);
	        
	        
	       	la1 = new JLabel("�ù�����");
			la1.setFont(new Font("����", Font.PLAIN, 14));
			la1.setBounds(368, 189, 57, 15);
			p.add(la1);
	        
	        Post.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
						hide();
						new showParcelChoose();
		    	}
		    });
	        
	        Iq1 = new JButton(); //�����ȸ
			Iq1.setBounds(509,53,230,180);
			Iq1.setIcon(new ImageIcon(MainJFrame.class.getResource("/TEST/IMG/Searchmail1.PNG")));
			Iq1.setBorderPainted(false); //�ܰ��� x
		    Iq1.setContentAreaFilled(false); //���� ä��� x
		    Iq1.setFocusPainted(false); //�׵θ� x
		    Iq1.setSize(205,170);
			p.add(Iq1);
			
			la2 = new JLabel("�����ȸ");
			la2.setFont(new Font("����", Font.PLAIN, 14));
			la2.setBounds(608, 189, 57, 15);
			p.add(la2);
			
			Iq1.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
						hide();
						new showChoose();
		    	}
		    });
			 
			Ifq = new JButton(); //������ȸ
			Ifq.setBounds(67, 298, 163, 69);
			Ifq.setIcon(new ImageIcon(MainJFrame.class.getResource("/TEST/IMG/Searchnumber1.PNG")));
			Ifq.setBorderPainted(false); //�ܰ��� x
		    Ifq.setContentAreaFilled(false); //���� ä��� x
		    Ifq.setFocusPainted(false); //�׵θ� x
		    Ifq.setSize(175,165);
			p.add(Ifq);
			
			la3 = new JLabel("������ȸ");
			la3.setFont(new Font("����", Font.PLAIN, 14));
			la3.setBounds(139, 412, 57, 15);
			p.add(la3);
			
			Ifq.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
						hide();
						//new MenuJTabaleExam();
						new Check();
		    	}
		    });
			/*
			Cancel = new JButton(); //���
			Cancel.setBounds(299, 286, 163, 69);
			Cancel.setIcon(new ImageIcon(MainJFrame.class.getResource("/TEST/IMG/Cancel1.PNG")));
			Cancel.setBorderPainted(false); //�ܰ��� x
		    Cancel.setContentAreaFilled(false); //���� ä��� x
		    Cancel.setFocusPainted(false); //�׵θ� x
		    Cancel.setSize(175,165);
			p.add(Cancel);
			
			la4 = new JLabel("�������");
			la4.setFont(new Font("����", Font.PLAIN, 14));
			la4.setBounds(368, 413, 57, 15);
			p.add(la4);
			
			Cancel.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
						hide();
						//new UserJDailogGUI(null, "����");
		    	}
		    });

			ChangeIf = new JButton(); //��������
			ChangeIf.setBounds(531, 298, 163, 69);
			ChangeIf.setIcon(new ImageIcon(MainJFrame.class.getResource("/TEST/IMG/Modify1.PNG")));
			ChangeIf.setBorderPainted(false); //�ܰ��� x
		    ChangeIf.setContentAreaFilled(false); //���� ä��� x
		    ChangeIf.setFocusPainted(false); //�׵θ� x
		    ChangeIf.setSize(175,165);
			p.add(ChangeIf);
			
			la5 = new JLabel("��������");
			la5.setFont(new Font("����", Font.PLAIN, 14));
			la5.setBounds(608, 413, 57, 15);
			p.add(la5);
			
			ChangeIf.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
						hide();
						new MenuJTabaleExam(); //���� �κ��� ȸ������ â���� ���õ� ���� �����ϴ°Ŷ� ���� �� â�� �� ����.
						//new UserJDailogGUI(null, "����");
		    	}
		    });
			
			
			Management = new JButton(); //ȸ������
			Management.setBounds(677, 346, 107, 125);
			Management.setIcon(new ImageIcon(MainJFrame.class.getResource("/TEST/IMG/Gearwhell1.PNG"))); //�����������ϱ�
			Management.setBorderPainted(false); //�ܰ��� x
		    Management.setContentAreaFilled(false); //���� ä��� x
		    Management.setFocusPainted(false); //�׵θ� x
		    Management.setSize(105,125);
			p.add(Management);
			
			Management.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
						hide();
						new MenuJTabaleExam();
		    	}
		    	});
		    	*/
    }
}
