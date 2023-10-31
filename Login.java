package firstapp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.*;

public class Login implements ActionListener{
	JFrame ac=new JFrame();
	JLabel tr=new JLabel("TRAIN ");
	JLabel t=new JLabel("BM");
	JButton lb=new JButton("CONNECTEZ VOUS");
	JButton res=new JButton("ANNULER");
	JLabel user=new JLabel("Nom d'utilisateur:");	
	JLabel pas=new JLabel("Mot de de passe:");
	JTextField username=new JTextField();
	JPasswordField password=new JPasswordField();

	
	public Login()
	{
		ac.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ac.setVisible(true);
		ac.setResizable(false);
		ac.setSize(800,700);
		ac.setTitle("LOGIN");
		ac.getContentPane().setBackground(new Color(0x212121));
		
		t.setBounds(440, 35, 100, 100);
		t.setForeground(new Color(0xff6f91));
		t.setFont(new Font("Rage Italic",Font.BOLD,40));
			
		tr.setBounds(300, 10, 180, 100);
		tr.setForeground(new Color(0xFEFEdf));
		tr.setFont(new Font("Arial Black",Font.BOLD,40));
		
		user.setBounds(150, 200, 200, 30);
		user.setForeground(new Color(0xFEFEdf) );
		user.setFont(new Font("CALIBRI",Font.BOLD,20));
		
		username.setBounds(320,200,250,25);
		username.setFont(new Font("CALIBRI",Font.PLAIN,18));
		
		pas.setBounds(150, 300, 200,30);
		pas.setForeground(new Color(0xFEFEdf));
		pas.setFont(new Font("CALIBRI",Font.BOLD,20));
		
		password.setBounds(320,300,250,25);
		
		lb.setBounds(200,470,150,30);
		lb.setFocusable(false);
		lb.addActionListener(this);
		
		res.setBounds(450,470,150,30);
		res.setFocusable(false);
		res.addActionListener(this);
		
		ac.add(tr);
		ac.add(t);
		ac.add(lb);
		ac.add(user);
		ac.add(pas);
		ac.add(username);
		ac.add(password);
		ac.add(res);
		ac.setLayout(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		String u = username.getText();
        String p = password.getText();
    try{ 
    	if(e.getSource()==res)
    	{
    		username.setText("");
    		password.setText("");
    	}
    	else if(e.getSource()==lb)
    		 {  
	        	Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp","root", "mehdi");
	            ResultSet rs = con.prepareStatement("Select login_gerant,password_gerant from gerant where login_gerant='"+u+"' and password_gerant='"+p+"' ").executeQuery();
            	if(rs.next())
            	{
            	ac.dispose();
				PagePrincipale pg=new PagePrincipale();
                JOptionPane.showMessageDialog(lb, "Vous etes connecter");
                con.close();
            	}
            	else {
            		JOptionPane.showMessageDialog(lb, "Loggin ou mot de passe incorrecte");
            	}
    		 }
    }catch(Exception se){
        se.printStackTrace();
    	}
	}
}
