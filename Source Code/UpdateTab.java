import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class UpdateTab  extends JFrame implements ActionListener
{
	JLabel updateLabel,labelRollno,labelName,labelBranch,labelYear,labelSem;
	JTextField textRollno,textName;
	JComboBox cb,sem,year;
	JButton btnUpdateName,btnUpdateBranch,btnUpdateYear,btnUpdateSem;
	Connection con;
	Statement st,st1;
	
	public UpdateTab()
	{
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
	   updateLabel=new JLabel("Update Student Information");

	   textName=new JTextField();
       textRollno=new JTextField();
	   btnUpdateName=new JButton("Update Name");
       btnUpdateBranch=new JButton("Update Branch");
	   btnUpdateYear=new JButton("Update Year");
       btnUpdateSem=new JButton("Update Semester");
      
      btnUpdateBranch.addActionListener(this);
	  btnUpdateName.addActionListener(this);
	  btnUpdateSem.addActionListener(this);
	  btnUpdateYear.addActionListener(this);
	   
	   setLayout(null);
	    updateLabel.setBounds(300,00,400,100);
       updateLabel.setFont(new Font("Times New Roman",1,30));
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
	  
	   btnUpdateName.setBounds(250,400,120,30);
       btnUpdateBranch.setBounds(400,400,120,30);
	   btnUpdateYear.setBounds(550,400,120,30);
	   btnUpdateSem.setBounds(700,400,150,30);
	   
	   
      add(updateLabel);add(labelName);add(textName);add(labelBranch);add(labelRollno);add(textRollno);add(cb);
	  add(labelYear);add(labelSem);add(year);add(sem);add(btnUpdateName);add(btnUpdateBranch);add(btnUpdateSem);add(btnUpdateYear);
	}

	public void actionPerformed(ActionEvent ae)
    {
	try
       {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           con=DriverManager.getConnection("jdbc:odbc:studnt");
           st=con.createStatement();
		   st1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
         }
         catch(Exception e){System.out.println(e);}
 
		
		if(ae.getSource()==btnUpdateName)
      {
		
            String nm=textName.getText();
		    String rollno=textRollno.getText();
		  
		  if(rollno.equals("")||nm.equals(""))
		  {
			  JOptionPane.showMessageDialog(this,"Please enter proper data...","Error...",JOptionPane.INFORMATION_MESSAGE);
		  }
		  else
		  {
            int roll=Integer.parseInt(rollno);
            String sql="update student set NameStudent='"+nm+"' where Rollno="+roll;
			try
			{
			int sss=st.executeUpdate(sql);
				 if(sss<=0)
				JOptionPane.showMessageDialog(this,"Sorry...No data available","Student data",JOptionPane.INFORMATION_MESSAGE);	   
			else
				JOptionPane.showMessageDialog(this,"Data updated...","Student data",JOptionPane.INFORMATION_MESSAGE);
            } 
             
		  
		  catch(Exception e)
		  {
			  System.out.println(e);
		  }
		  textName.setText("");
          textRollno.setText("");
		  }
	  }
	 
     else if(ae.getSource()==btnUpdateBranch)
      {
		  
           String br=cb.getSelectedItem().toString();  
            String rollno=(textRollno.getText());
			if(rollno.equals(""))
		  {
			  JOptionPane.showMessageDialog(this,"Please enter proper data...","Error...",JOptionPane.INFORMATION_MESSAGE);
		  }
		  else
		  {
            int roll=Integer.parseInt(rollno);
          
            String sql="update student set Branch='"+br+"' where Rollno="+roll;
             try
            {
            int sss=st.executeUpdate(sql);
				 if(sss<=0)
				JOptionPane.showMessageDialog(this,"Sorry...No data available","Student data",JOptionPane.INFORMATION_MESSAGE);	   
			else
				JOptionPane.showMessageDialog(this,"Data updated...","Student data",JOptionPane.INFORMATION_MESSAGE);
            } 
             catch(Exception e){}
              textName.setText("");
			  textRollno.setText("");
			  cb.setSelectedIndex(0);
         }
	  }
		
		
		
		else if(ae.getSource()==btnUpdateYear)
      {
           String yr=year.getSelectedItem().toString();
            String rollno=(textRollno.getText());
			if(rollno.equals(""))
		  {
			  JOptionPane.showMessageDialog(this,"Please enter proper data...","Error...",JOptionPane.INFORMATION_MESSAGE);
		  }
		  else
		  {
            int roll=Integer.parseInt(rollno);
          String sql="update student set AYear='"+yr+"' where Rollno="+roll;
             try
            {
            int sss=st.executeUpdate(sql);
				 if(sss<=0)
				JOptionPane.showMessageDialog(this,"Sorry...No data available","Student data",JOptionPane.INFORMATION_MESSAGE);	   
			else
				JOptionPane.showMessageDialog(this,"Data updated...","Student data",JOptionPane.INFORMATION_MESSAGE);
             }
             catch(Exception e){}
              textName.setText("");
              textRollno.setText("");
			  year.setSelectedIndex(0);
          }
         }
     else if(ae.getSource()==btnUpdateSem)
      {
           String sm=sem.getSelectedItem().toString();  
          String rollno=(textRollno.getText());
			if(rollno.equals(""))
		  {
			  JOptionPane.showMessageDialog(this,"Please enter proper data...","Error...",JOptionPane.INFORMATION_MESSAGE);
		  }
		  else
		  {
            int roll=Integer.parseInt(rollno);
            String sql="update student set Semester='"+sm+"' where rollno="+roll;
             try
            {
            int sss=st.executeUpdate(sql);
				 if(sss<=0)
				JOptionPane.showMessageDialog(this,"Sorry...No data available","Student data",JOptionPane.INFORMATION_MESSAGE);	   
			else
				JOptionPane.showMessageDialog(this,"Data updated...","Student data",JOptionPane.INFORMATION_MESSAGE);
             
             }
             catch(Exception e){}
              textRollno.setText("");
			  textName.setText("");
			sem.setSelectedIndex(0);
             
         }
	  }
	 
	}
	
	 public static void main(String args[])throws Exception
    {
         UpdateTab si=new UpdateTab();
          si.setVisible(true);
          si.setSize(1500,1000); 
          }
}