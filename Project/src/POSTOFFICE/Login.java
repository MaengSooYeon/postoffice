package POSTOFFICE;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;

import javax.swing.JPanel;
import javax.swing.JRootPane;


public class Login extends Frame implements ActionListener {
	// jdbc ����
	private String url = "jdbc:mysql://localhost/testlist1?characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false\\r\\n&serverTimezone=UTC&useSSL=false";// user���̺��� �����ϸ�
	private String strUser = "root"; // ���� id
	private String strPassword = "se9703709"; // ���� �н�����
	private String strMySQLDriver = "com.mysql.jdbc.Driver"; // ����̹�
	//JPanel p1;
	Connection con;
	Statement stmt;
	ResultSet rs;
	String sql;
	
	String id;
	String pawt;
	String name;
	String username;
	
	LoginGUI log = new LoginGUI(); 
	Data d = new Data();
	Select select = new Select();
	
	// ���̾�α� , ��ư, ��,
	Button ok;
	Label msg;
	Dialog info;
	/*
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	*/

	Login() {
	try {
	// �α��� ��ư�� Ŭ�� �Ǿ����ÿ� jdbc����̹��� ���
	Class.forName(strMySQLDriver);
	con = (Connection) DriverManager.getConnection(url, strUser, strPassword);
	stmt = (Statement) con.createStatement();
	
	} catch (Exception b) {
	System.out.println("db�������");
	}
	log.bt1.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	// �ش��ϴ� ��ư�� ��������
	Object obj = e.getSource();
	if (obj.equals(log.bt1)) {
	// �α���â�� �α��� ��ư
		loginCheck();
		/*
		log.setVisible(false);
		select.setTitle(name + "�� �α��� �� �Դϴ�.");
		select.setVisible(true);
		*/
		} 
	}
	

	// �α��� üũ
	void loginCheck() {
		 //UserDefaultJTableDAO dao =new UserDefaultJTableDAO();
	// �α���â�� �ؽ�Ʈ�ʵ忡 ������ ��������
	id = log.tex1.getText().trim();
	pawt = log.tex2.getText().trim();
	
	// SELECT ������ �ۼ��Ѵ�. �ش��ϴ� ���̵��� �н����带 �˻��Ѵ�.
	String query = "SELECT * FROM testlist1.member where id='" + id + "'";
	System.out.println(query);
	try {
	// executeQuery() �޼���� SELECT���� �����Ű�� ����� ResultSet ��ü�� �޴´�.
		ResultSet rs = stmt.executeQuery(query);
	// ���ڵ尡 �ִ��� �˻�
	if (rs.next()) {
	//
		username = rs.getString("name");
		System.out.println(username);
		System.out.println(rs.getString("name"));
	// �ؽ�Ʈ�ʵ忡 ������ �����ͺ��̽��� �ִ� �н����� ���� ���Ѵ�.
	if (pawt.equals(rs.getString("paw")) ) {
		System.out.println("Login Success");
		log.setVisible(false);
		select.setTitle(rs.getString("name") + "�� �α��� �� �Դϴ�.");
		select.setVisible(true);
		// ������ ����â�� ����ش�.
	}else {
		System.out.println("Login Fail");
		//Ʋ���� ��������.
		new MainJFrame();
		}
	}
	
	} catch (Exception b) {
	b.printStackTrace();
	}
	}
	}
	
