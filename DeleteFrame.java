import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;
import java.io.*;
class DeleteFrame extends JFrame
{
Container c;
int id;
JLabel lblId;
JTextField  txtId;
JButton  btnSave , btnBack;
DeleteFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout());
lblId =new  JLabel("Id");
lblId.setPreferredSize(new Dimension (40,15));
txtId =new  JTextField(20);
btnSave = new JButton("Save");
btnBack = new JButton("Back");

c.add(lblId);
c.add(txtId);
c.add(btnSave);
c.add(btnBack);
Console co = System.console();
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact = cfg.buildSessionFactory();
Session session = sfact.openSession();

btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
MainFrame a = new MainFrame();
dispose();
session.close();
}
});
btnSave.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
Transaction t =null;  
try
{
t =session.beginTransaction();
id = Integer.parseInt(txtId.getText());
Employee em = (Employee)session.get(Employee.class ,id);
if(em!=null)
{
try
{
session.delete(em);
t.commit();
JOptionPane.showMessageDialog(c,"Record Deleted");
txtId.requestFocus();
txtId.setText("");
}
catch(Exception ew)
{
JOptionPane.showMessageDialog(c,ew);
}
}
else
{
JOptionPane.showMessageDialog(c,"Record does not exist");
txtId.setText("");
txtId.requestFocus();
}
}
catch(NumberFormatException e)
{
JOptionPane.showMessageDialog(c,"Enter integer value");
txtId.requestFocus();
txtId.setText("");
}
catch(HibernateException he)
{
JOptionPane.showMessageDialog(c,"session is closed..enter back button ");
}
catch(Exception ee)
{
t.rollback();
JOptionPane.showMessageDialog(c,ee);
}
finally
{
//session.close();
}
id =Integer.parseInt(txtId.getText());
}
});
setTitle("Delete E");
setSize(300,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
setResizable(false);
}
}
