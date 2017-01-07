import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class DeleteTab  extends JFrame implements ActionListener
{
	JButton btnDelete;
	JTextField textRollno;
	JLabel labelRollno,labelForm;
	Connection con;
	Statement st,st1;
	
	
	public DeleteTab()
	{
		btnDelete=new JButton("Delete Data");
		labelRollno=new JLabel("Enter student roll no to deleted");
		textRollno=new JTextField();
		labelForm=new JLabel("Delete Student Information");
		
		btnDelete.addActionListener(this);
		setLayout(null);
		labelForm.setBounds(300,00,400,100);
       labelForm.setFont(new Font("Times New Roman",1,30));
       labelRollno.setBounds(200,100,200,30);
       textRollno.setBounds(450,100,200,30);
	   btnDelete.setBounds(450,200,120,30);   
       
	   
	   add(labelForm);add(labelRollno);add(btnDelete);add(textRollno);
	   
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
      
		if(ae.getSource()==btnDelete)
      {
		  String rollno="";
		  int roll;
		  try
		  {
             rollno=textRollno.getText();
		  }
		  catch(Exception e)
		  {
			  //JOptionPane.showMessageDialog(this,"Please enter proper data...","Error...",JOptionPane.INFORMATION_MESSAGE);
		  }
		  if(rollno.equals(""))
		  {
			    JOptionPane.showMessageDialog(this,"Please enter proper data...","Error...",JOptionPane.INFORMATION_MESSAGE);
		  }		
			else
			{
				roll=Integer.parseInt(rollno);
			
            String sql="delete from student where rollno="+roll;
             try
            {
                int sss=st.executeUpdate(sql);
				 if(sss<=0)
				JOptionPane.showMessageDialog(this,"Sorry...No data available","Student data",JOptionPane.INFORMATION_MESSAGE);	   
			else
				JOptionPane.showMessageDialog(this,"Data deleted...","Student data",JOptionPane.INFORMATION_MESSAGE);
            
             }
             catch(Exception e){System.out.println(e);}
              textRollno.setText("");
              
         }
	  }
	}
	
	 public static void main(String args[])throws Exception
    {
         DeleteTab si=new DeleteTab();
          si.setVisible(true);
          si.setSize(1500,1000); 
          }
}