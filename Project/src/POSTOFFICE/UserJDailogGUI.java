package POSTOFFICE;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UserJDailogGUI extends JDialog implements ActionListener{
 
  JPanel pw=new JPanel(new GridLayout(7,1));
  JPanel pc=new JPanel(new GridLayout(7,1));
  JPanel ps=new JPanel();

  JLabel lable_Id = new JLabel("ID");
  JLabel label_Pw = new JLabel("PW");
  JLabel lable_Name=new JLabel("�� ��");
  JLabel lable_Birth=new JLabel("�� ��");
  JLabel lable_Pn = new JLabel("��ȭ��ȣ");
  JLabel lable_Addr=new JLabel("�� ��");
  JLabel lable_Users = new JLabel("SELECT");


  JTextField id=new JTextField();
  JTextField paw=new JTextField();
  JTextField name=new JTextField();
  JTextField birth=new JTextField();
  JTextField pn=new JTextField();
  JTextField addr=new JTextField();
  JTextField users=new JTextField();
  JComboBox comboBox = new JComboBox();
 

  JButton confirm;
  JButton reset=new JButton("���");

 MenuJTabaleExam me;

 JPanel idCkP =new JPanel(new BorderLayout());
 JButton idCkBtn = new JButton("IDCheck");
 
 UserDefaultJTableDAO dao =new UserDefaultJTableDAO();
 

  public UserJDailogGUI(MenuJTabaleExam me, String index){
      super(me,"ȸ������");
      this.me=me;
      if(index.equals("����")){
          confirm=new JButton(index);
      }else{
          confirm=new JButton("����"); 
         
          //text�ڽ��� ���õ� ���ڵ��� ���� �ֱ�
          int row = me.jt.getSelectedRow();//���õ� ��
          id.setText( me.jt.getValueAt(row, 0).toString() );
          //paw.setText( me.jt.getValueAt(row, 1).toString() );
          name.setText( me.jt.getValueAt(row, 1).toString() );
          birth.setText( me.jt.getValueAt(row, 2).toString() );
          pn.setText( me.jt.getValueAt(row, 3).toString() );
          addr.setText( me.jt.getValueAt(row, 4).toString() );
          users.setText( me.jt.getValueAt(row, 5).toString() );
          
         
          //id text�ڽ� ��Ȱ��
          id.setEditable(false);
 
          //IDCheck��ư ��Ȱ��ȭ
          idCkBtn.setEnabled(false);
      }
     
     
      //Label�߰��κ�
      pw.add(lable_Id);//ID
      pw.add(label_Pw); //PW
      pw.add(lable_Name);//�̸�
      pw.add(lable_Birth);//����
      pw.add(lable_Pn); //��ȭ��ȣ
      pw.add(lable_Addr);//�ּ�
      pw.add(lable_Users); //����
 
     
      idCkP.add(id,"Center");
      idCkP.add(idCkBtn,"East");
     
      //TextField �߰�
      pc.add(idCkP);
      pc.add(paw);
      pc.add(name);
      pc.add(birth);
      pc.add(pn);
      pc.add(addr);
      users.setText("ex) �մ� / ���");
      pc.add(users);
      
      //pc.add(comboBox);
      //comboBox.setModel(new DefaultComboBoxModel(new String[] {"�մ�", "���"})); //�մ�, ���
     
     
      ps.add(confirm);
      ps.add(reset);
      ps.setBackground(Color.RED);
      
      add(pw,"West");
      add(pc,"Center");
      add(ps,"South");
     
      setSize(476,320);
      setVisible(true);
      setResizable(false);
      //�������
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
     
      //�̺�Ʈ���
      confirm.addActionListener(this); //����/���� �̺�Ʈ���
      reset.addActionListener(this); //��� �̺�Ʈ���
      idCkBtn.addActionListener(this);// ID�ߺ�üũ �̺�Ʈ ���
     
  }//�����ڳ�
 
  /**
   * ����/����/���� ��ɿ� ���� �κ�
   * */
  @Override
  public void actionPerformed(ActionEvent e) {
     String btnLabel =e.getActionCommand();//�̺�Ʈ��ü ���� Label ��������
     
     if(btnLabel.equals("����")){
         if(dao.userListInsert(this) > 0 ){//���Լ���
             messageBox(this , name.getText()+"�� ���ԵǾ����ϴ�.");
             dispose();//JDialog â�ݱ�
             
             dao.userSelectAll(me.dt);//��緹�ڵ尡���ͼ� DefaultTableModel�� �ø���
             
             if(me.dt.getRowCount() > 0)
                 me.jt.setRowSelectionInterval(0, 0);//ù��° �� ����
             
         }else{//���Խ���
             messageBox(this,"���Ե��� �ʾҽ��ϴ�.");
         }
         
     }else if(btnLabel.equals("����")){
         
          if( dao.userUpdate(this) > 0){
              messageBox(this, "�����Ϸ�Ǿ����ϴ�.");
              dispose();
              dao.userSelectAll(me.dt);
              if(me.dt.getRowCount() > 0 ) me.jt.setRowSelectionInterval(0, 0);
             
          }else{
              messageBox(this, "�������� �ʾҽ��ϴ�.");
          }
         
         
         
     }else if(btnLabel.equals("���")){
         dispose();
         
     }else if(btnLabel.equals("IDCheck")){
         //id�ؽ�Ʈ�ڽ��� �� ������ �޼��� ��� ������ DB�����Ѵ�.
         if(id.getText().trim().equals("")){
             messageBox(this,"ID�� �Է����ּ���.");
             id.requestFocus();//��Ŀ���̵�
         }else{
             
            if(  dao.getIdByCheck(id.getText()) ){ //�ߺ��ƴϴ�.(��밡��)
                messageBox(this, id.getText()+"�� ��밡���մϴ�.");  
            }else{ //�ߺ��̴�.
                messageBox(this,id.getText()+"�� �ߺ��Դϴ�.");
               
                id.setText("");//text�ڽ������
                id.requestFocus();//Ŀ������
            }
             
         }
         
     }
     
     
  }//actionPerformed��
 
  /**
   * �޽����ڽ� ����ִ� �޼ҵ� �ۼ�
   * */
  public static void messageBox(Object obj , String message){
      JOptionPane.showMessageDialog( (Component)obj , message);
  }

}//Ŭ������