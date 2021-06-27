import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;
import java.io.*;
class AddFrame extends JFrame
{
Container c;
double salary;
String name;
int flag =0;
JLabel lblId,lblName,lblSalary;
JTextField  txtId,txtName,txtSalary;
JButton  btnSave , btnBack;
AddFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout());
lblId =new  JLabel("Id");
lblName =new  JLabel("Name");
lblSalary =new  JLabel("Salary");
lblId.setPreferredSize(new Dimension (40,15));
lblName.setPreferredSize(new Dimension (40,15));
lblSalary.setPreferredSize(new Dimension (40,15));
txtId =new  JTextField(20);
txtName = new JTextField(20);
txtSalary =new  JTextField(20);
btnSave = new JButton("Save");
btnBack = new JButton("Back");

c.add(lblId);
c.add(txtId);
c.add(lblName);
c.add(txtName);
c.add(lblSalary);
c.add(txtSalary);
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
Employee em = new Employee();
int id =Integer.parseInt(txtId.getText());


name= txtName.getText();
/*try
{
if(name.matches(".*\\d+.*"))
throw new NullPointerException();
}
catch(NullPointerException npe)
{
t.rollback();
JOptionPane.showMessageDialog(new JDialog(),"Enter alphabets only");
txtName.requestFocus();
txtName.setName("");
}
*/
try
{
salary = Double.parseDouble(txtSalary.getText());
}
catch(NumberFormatException nfee)
{
JOptionPane.showMessageDialog(c,"Enter valid Salary");
txtSalary.setText("");
txtSalary.requestFocus();
}
if(id<=0)
{
JOptionPane.showMessageDialog(c,"Id must be positive integer");
txtId.setText("");
txtId.requestFocus();
}
else if(name.length()<2)
{
 JOptionPane.showMessageDialog(c,"Enter correct name");
txtName.setText("");
txtName.requestFocus();
}
else if(salary<8000)
{
JOptionPane.showMessageDialog(c,"Minimum salary should be 8000");
txtSalary.requestFocus();
txtSalary.setText("");
}
else if(!((name!=null) && name.chars().allMatch(Character::isLetter)))
{
JOptionPane.showMessageDialog(c,"Enter alphabets only ");
txtName.setText("");
txtName.requestFocus();
}
else
{
em.setId(id);
em.setName(name);
em.setSalary(salary);
session.save(em);		t.commit();
JOptionPane.showMessageDialog(c,"Record inserted");
txtId.setText("");
txtName.setText("");
txtSalary.setText("");
txtId.requestFocus();
//session.close();

}
}
catch(NumberFormatException e)
{
t.rollback();
JOptionPane.showMessageDialog(c,"Characters are not allowed in ID");
txtId.requestFocus();
txtId.setText("");
}
/*catch(HibernateException he)
{
JOptionPane.showMessageDialog(c,"Hibernate Exception");
txtId.setText("");
txtId.requestFocus();
}
*/
catch(Exception sc)
{
t.rollback();
JOptionPane.showMessageDialog(c,sc);
}
finally
{
//session.close();
}
int id =Integer.parseInt(txtId.getText());
String name=txtName.getText();
double salary = Double.parseDouble(txtSalary.getText());
}
});
setTitle("Add E");
setSize(300,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
setResizable(false);
}
}
