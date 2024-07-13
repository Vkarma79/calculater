import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.script.*;

class Fdemo extends JFrame implements ActionListener 
{
	int x=0,y=100,k=0;
	JTextField tx1;
	JButton b[]=new JButton[20];
	String s1[]={"B","C","1/x","sqrt","7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
	
Fdemo()
{
	setTitle("CALCULATER BY VIKAS");
 setLayout(null);
 Font f=new Font("",Font.BOLD,30);
 for(int j=1;j<=5;j++)
 {
 for(int i=1;i<=4;i++)
 { 
 b[k]=new JButton(s1[k]);
 b[k].setSize(100,100);
b[k].setLocation(x,y);
b[k].setFont(f);
add(b[k]);
b[k].addActionListener(this);
x=x+100;
k++;
 }
 x=0;
 y=y+100;
 }
 
 
 tx1=new JTextField();
 tx1.setSize(400,100);
tx1.setLocation(0,0);
tx1.setFont(f);
tx1.setHorizontalAlignment(JTextField.RIGHT);
add(tx1);

}
public void actionPerformed(ActionEvent e)
 {
	 if(e.getSource()==b[0])
	 {
		 String s1=tx1.getText();
		 tx1.setText(s1.substring(0,s1.length()-1));
		 
	 }
	else if(e.getSource()==b[1])
	 {
		tx1.setText(""); 
	 }
	 
	 else if(e.getSource()==b[2])
	 {
		String s1=tx1.getText();
		double a=Double.parseDouble(s1);
		a=1/a;
		tx1.setText(""+a);
        		
	 }
	 else if(e.getSource()==b[3])
	 {
		 String s1=tx1.getText();
		 double a=Double.parseDouble(s1);
		 tx1.setText(""+Math.sqrt(a));
		 
		 
	 }
	 else if(e.getSource()==b[18])
	 {
		 String s1=tx1.getText();
		ScriptEngineManager sem=new ScriptEngineManager();
        ScriptEngine se=sem.getEngineByName("js");
		try
		{
       tx1.setText(""+se.eval(s1));		
		}
		catch(Exception ec)
		{}
	 }
	 else
	 {
	JButton b1=(JButton)e.getSource();
    String s1=tx1.getText()+b1.getLabel();
    tx1.setText(""+s1);	
 }}
}

class calculater
{
public static void main(String ar[])
{
Fdemo f=new Fdemo();
f.setVisible(true);
f.setSize(425,650);
f.setLocation(100,100);
f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
}
}
