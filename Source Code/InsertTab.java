import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class InsertTab extends JFrame implements ActionListener
{ 
     JLabel labelName,labelBranch,labelRollno,labelSub1,labelSub2,labelSub3,labelSub4,labelSub5,labelYear,labelSem,labelForm;
     JTextField textName,textRollno,textSub1,textSub2,textSub3,textSub4,textSub5;
     JButton btnInsert;
     JComboBox cb,year,sem;   
     Connection con;
     Statement st,st1;
     Container c;
      String msg;
	  ResultSet rs;

     public InsertTab()
     {
      msg=""; 
		cb=new JComboBox();
       cb.addItem("Computer Science and Engg.");
       cb.addItem("Information Technology");
       cb.addItem("Civil Engineering");
       cb.addItem("Mechanical Engineering");
       cb.addItem("Electrical Engineering");
       cb.addItem("Eletronics and Telecommunications");
       cb.addItem("Textile Engineering");

	   year=new JComboBox();
	   year.addItem("First Year");
	   year.addItem("Second Year");
	   year.addItem("Third Year");
	   year.addItem("Final Year");
	   
	   sem=new JComboBox();
	   sem.addItem("I");
	   sem.addItem("II");
	   
       labelName=new JLabel("Enter Student Name : "); 
       labelBranch=new JLabel("Enter Branch Name : ");
       labelRollno=new JLabel("Enter Rollno : ");
	   labelYear=new JLabel("Enter Year : ");
	   labelSem=new JLabel("Enter Semester : ");
       labelSub1=new JLabel("Enter Subject1 marks : ");
       labelSub2=new JLabel("Enter Subject2 marks : ");
       labelSub3=new JLabel("Enter Subject3 marks : ");
       labelSub4=new JLabel("Enter Subject4 marks : ");
	   labelSub5=new JLabel("Enter Subject5 marks : ");
       labelForm=new JLabel("Insert Student Information");

       textName=new JTextField();
       textRollno=new JTextField();
       textSub1=new JTextField();
       textSub2=new JTextField();
       textSub3=new JTextField();
       textSub4=new JTextField();
	   textSub5=new JTextField();

       btnInsert=new JButton("Insert Data");
	   

       btnInsert.addActionListener(this); 
       
       setLayout(null);

       labelForm.setBounds(300,00,400,100);
       labelForm.setFont(new Font("Times New Roman",1,30));
       labelName.setBounds(200,150,200,30);
       textName.setBounds(400,150,200,30);
       labelBranch.setBounds(200,200,200,30);
       cb.setBounds(400,200,200,30);
       labelRollno.setBounds(200,100,200,30);
       textRollno.setBounds(400,100,200,30);
	   
	   labelYear.setBounds(200,250,200,30);
	   year.setBounds(400,250,200,30);
	   labelSem.setBounds(200,300,200,30);
	   sem.setBounds(400,300,200,30);
	   
      labelSub1.setBounds(200,350,200,30);
       textSub1.setBounds(400,350,200,30);
       labelSub2.setBounds(200,400,200,30);
       textSub2.setBounds(400,400,200,30);
       labelSub3.setBounds(200,450,200,30);
       textSub3.setBounds(400,450,200,30);
       labelSub4.setBounds(200,500,200,30);
       textSub4.setBounds(400,500,200,30);
	   labelSub5.setBounds(200,550,200,30);
       textSub5.setBounds(400,550,200,30);
       
       btnInsert.setBounds(350,600,120,30);
       

        add(labelForm);add(labelName);add(textName);add(labelBranch);add(labelRollno);add(textRollno);add(labelSub1);add(textSub1);
        add(labelSub2);add(textSub2);add(labelSub3);add(textSub3);add(labelSub4);add(textSub4);
        add(btnInsert);add(cb);
		add(labelYear);add(labelSem);add(labelSub5);add(year);add(sem);add(textSub5);
        setBackground(Color.cyan);
		

   }
    public void actionPerformed(ActionEvent ae)
    {
      try
       {
          // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           con=DriverManager.getConnection("jdbc:odbc:studnt");
           st=con.createStatement();
		   st1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
         }
         catch(Exception e){System.out.println(e);}
        if(ae.getSource()==btnInsert)
        { 
			String nm="",yr="",sm="",br="",rollno="",ss1="0",ss2="0",ss3="0",ss4="0",ss5="0";
			int s1,s2,s3,s4,s5,roll,flag=0; 
			try
			{
             nm=textName.getText();
			 yr=year.getSelectedItem().toString();               
			 sm=sem.getSelectedItem().toString();
             br=cb.getSelectedItem().toString();               
             rollno=textRollno.getText();
             ss1=textSub1.getText();
             ss2=textSub2.getText();
             ss3=textSub3.getText();
             ss4=textSub4.getText();
			 ss5=textSub5.getText();
			 roll=Integer.parseInt(rollno);
			
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this,"Please enter proper data...","Error...",JOptionPane.INFORMATION_MESSAGE);
				
			}
			if(ss1.equals("")||ss2.equals("")||ss3.equals("")||ss4.equals("")||ss5.equals(""))
			{
				//JOptionPane.showMessageDialog(this,"Please enter proper data...","Error...",JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
			roll=Integer.parseInt(rollno);
			s1=Integer.parseInt(ss1);
			s2=Integer.parseInt(ss2);
			s3=Integer.parseInt(ss3);
			s4=Integer.parseInt(ss4);
			s5=Integer.parseInt(ss5);
           
		   if((s1>100 || s1<0) || (s2>100 || s2<0) || (s3>100 || s3<0) || (s4>100 || s4<0)|| (s5>100 || s5<0))
			JOptionPane.showMessageDialog(this,"Please enter marks between 0 and 100...","Error...",JOptionPane.INFORMATION_MESSAGE);
			else
			{
            msg="";
            int t=s1+s2+s3+s4+s5;
            int per=t/5;
            String g;
            if(per>=75)       g="Distinction";
            else if(per>=60)				g="First Class";
            else if(per>=50)   g="Second Class";
            else if(per>=40)   g="Pass Class";
             else        g="Failed";
            String sql="insert into student values("+roll+",'"+nm+"','"+br+"','"+yr+"','"+sm+"',"+t+","+per+",'"+g+"',"+s1+","+s2+","+s3+","+s4+","+s5+")";
            try
            {
               int sss=st.executeUpdate(sql);
			   if(sss<=0)
				JOptionPane.showMessageDialog(this,"Error...Data not inserted...","Student data",JOptionPane.INFORMATION_MESSAGE);	   
			else
				JOptionPane.showMessageDialog(this,"Data inserted...","Student data",JOptionPane.INFORMATION_MESSAGE);
            }
             catch(Exception e){System.out.println(e);}
            textName.setText("");
            textRollno.setText("");
            textSub1.setText("");
            textSub2.setText("");
            textSub3.setText("");
            textSub4.setText("");
			textSub5.setText("");
			cb.setSelectedIndex(0);
			year.setSelectedIndex(0);
			sem.setSelectedIndex(0);
			}
			}
     }
}
 
  public static void main(String args[])throws Exception
    {
         InsertTab si=new InsertTab();
          si.setVisible(true);
          si.setSize(1500,1000); 
          }
}