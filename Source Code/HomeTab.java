import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class HomeTab extends JFrame implements AdjustmentListener
{
  JLabel title,image,labelFormColor;
   Scrollbar sc1,sc2,sc3;
       int r,g,b;
      Color clr;
	  ImageIcon img;
    
	
  public HomeTab()
  {
	  img=new ImageIcon("logo.png");
	  title=new JLabel("Student Result Generation System");
      title.setFont(new Font("Times New Roman",1,35));
		image=new JLabel(img);
	  
	  
	   labelFormColor=new JLabel("Adjust Background Color");
	  labelFormColor.setFont(new Font("Times New Roman",1,20));

       sc1=new Scrollbar(Scrollbar.HORIZONTAL,0,0,0,255);
       sc2=new Scrollbar(Scrollbar.HORIZONTAL,0,0,0,255);
       sc3=new Scrollbar(Scrollbar.HORIZONTAL,0,0,0,255);
	   
	   sc1.setValue(255);
	   sc2.setValue(255);
	   sc3.setValue(255);

	   sc1.addAdjustmentListener(this);
       sc2.addAdjustmentListener(this);
       sc3.addAdjustmentListener(this);

	   setLayout(null);
	   sc1.setBounds(1000,30,300,25);  
       sc2.setBounds(1000,60,300,25);  
       sc3.setBounds(1000,90,300,25);  
	   labelFormColor.setBounds(1000,00,300,25); 
	   title.setBounds(250,-30,600,250);
	   image.setBounds(60,120,1000,500);


	   add(sc1);add(sc2);add(sc3);add(labelFormColor);add(title);add(image);
  }


  public void adjustmentValueChanged(AdjustmentEvent ade)
 {
        if(ade.getSource()==sc1)
          r=sc1.getValue(); 
       else if(ade.getSource()==sc2)
          g=sc2.getValue();
       else if(ade.getSource()==sc3)
          b=sc3.getValue();
       clr=new Color(r,g,b);
      this.getContentPane().setBackground(clr);
 
 }
 
 public static void main(String args[])throws Exception
    {
         HomeTab si=new HomeTab();
          si.setVisible(true);
          si.setSize(1500,1000); 
          }
  
  
}
  
