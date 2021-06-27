import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;
class ViewFrame extends JFrame
{
Container c;
TextArea ta;
JButton btnBack;
String data = "";
ViewFrame()
{
c=getContentPane();
c.setLayout(new FlowLayout());
ta = new TextArea(10,30);
btnBack = new JButton("Back");
c.add(ta);
c.add(btnBack);
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact = cfg.buildSessionFactory();
Session session = sfact.openSession();
try
{
java.util.List<Employee> stu = new ArrayList<>();
stu = session.createQuery("from Employee").list();
for (Employee em : stu)
	 ta.append("id:"+em.getId() +" N:" +em.getName()+" S:"+em.getSalary()+" $"+"\n");
//System.out.println("end");
}
catch(Exception e)
{
System.out.println(e);
}
finally
{
session.close();
}
btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
MainFrame a = new MainFrame();
dispose();
}
});
setTitle("View E");
setSize(300,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
setResizable(false);
}
}