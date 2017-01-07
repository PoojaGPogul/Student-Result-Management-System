import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.table.*;


public class ViewTab  extends JFrame
{
	ResultSet rs;
	ResultSetMetaData rsmd;
	JTable jtable;
	Connection con;
	Statement st,st1;
	Container c;
	
	JScrollPane s;
	
	public ViewTab(int ff)
	{
	
		c=getContentPane();
		try
       {
			
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           con=DriverManager.getConnection("jdbc:odbc:studnt");
           st=con.createStatement();
		   st1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		   
	       rs=st1.executeQuery("select Rollno,NameStudent,Branch,AYear,Semester,Total,Percentage,Grade from student");
		   rs.first();
		   	jtable=new JTable(build(rs));
			s=new JScrollPane(jtable);
			c.add(s);
		  rs.close();
		  st.close();
	   st1.close();
	   con.close();
		  }
		  catch(Exception e)
		  {
			  if(ff!=0)
			  {
 			  JOptionPane.showMessageDialog(this,"Table is empty...","Caution...",JOptionPane.INFORMATION_MESSAGE);
				System.out.println(e);
			  }
		  }
		}
		
	


	public DefaultTableModel build(ResultSet rs)
        throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }
	columnNames.setElementAt("Student Name",1);
	columnNames.setElementAt("Year",3);
	columnNames.setElementAt("Total Marks",5);
	
	rs.first();
    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	int iiii=0;
	        Vector<Object> vector1 = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector1.add(rs.getObject(columnIndex));
        }
        data.add(vector1);

	 while (rs.next()) {
		 iiii=1;
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }
	return new DefaultTableModel(data, columnNames);

}
		
	 public static void main(String args[])throws Exception
    {
         ViewTab si=new ViewTab(0);
          si.setVisible(true);
          si.setSize(1500,1000); 
          }
	
}
