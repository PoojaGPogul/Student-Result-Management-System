import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class Ex extends JFrame
{
	JTabbedPane tb;
	HomeTab home;
	InsertTab insert;
	UpdateTab update;
	DeleteTab delete;
	ViewTab view;
	Container con;
	
	public Ex()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		tb=new JTabbedPane();
		con=getContentPane();
		insert=new InsertTab();
		update=new UpdateTab();
		view=new ViewTab(0);
		delete=new DeleteTab();
		home=new HomeTab();
		
		tb.addTab("Home",home.getContentPane());
		tb.addTab("Insert Data",insert.getContentPane());
		tb.addTab("Update Data",update.getContentPane());
		tb.addTab("Delete Data",delete.getContentPane());
		tb.addTab("View Data",view.getContentPane());
		
		
		con.add(tb);
		
	tb.addChangeListener(new ChangeListener() {
    public void stateChanged(ChangeEvent e) 
	{
        if(tb.getSelectedIndex()==1)
		{
			insert=new InsertTab();
			tb.setComponentAt(1,insert.getContentPane());
		}
		else if(tb.getSelectedIndex()==2)
		{
			update=new UpdateTab();
			tb.setComponentAt(2,update.getContentPane());
		}
		else if(tb.getSelectedIndex()==3)
		{
			delete=new DeleteTab();
			tb.setComponentAt(3,delete.getContentPane());
		}
		else if(tb.getSelectedIndex()==4)
		{
			view=new ViewTab(1);
			tb.setComponentAt(4,view.getContentPane());
		}
    }
});
	}
	
	public static void main(String args[])
	{
		Ex e=new Ex();
		e.setVisible(true);
		e.setSize(1500,1000);
	}
}



