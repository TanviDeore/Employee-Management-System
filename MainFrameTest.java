import org.hibernate.*;
import org.hibernate.cfg.*;
import  javax.swing.*;
import  java.awt.*;
import  java.awt.event.*;
import java.sql.*;
class MainFrame extends JFrame
{
Container c;
JButton btnAdd , btnView,btnUpdate,btnDelete;
MainFrame()
{
c = getContentPane();
btnAdd = new  JButton("Add");
btnView = new  JButton("View");
btnUpdate = new JButton("Update");
btnDelete = new JButton("Delete");
btnAdd.setPreferredSize(new Dimension (100,50));
btnView.setPreferredSize(new Dimension (100,50));
btnUpdate.setPreferredSize(new Dimension (100,50));
btnDelete.setPreferredSize(new Dimension (100,50));
c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);
btnAdd.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
AddFrame a = new AddFrame();
dispose();
}
});
btnView.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
ViewFrame a = new ViewFrame();
dispose();
}
});
btnUpdate.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
UpdateFrame a = new UpdateFrame();
dispose();
}
});
btnDelete.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
DeleteFrame a = new DeleteFrame();
dispose();
}
});
setTitle("E M S");
setSize(300,400);
c.setLayout(new FlowLayout());
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
setResizable(false);
}
}
class MainFrameTest{
public static void main(String args[])
{
MainFrame mf = new MainFrame();
/*
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact = cfg.buildSessionFactory();
Session session = sfact.openSession();
session.close();
*/
}
}
