package firstapp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class PagePrincipale implements ActionListener{
	JFrame frame=new JFrame();
	
	JButton membre=new JButton();
	JLabel m=new JLabel();
	ImageIcon me=new ImageIcon(getClass().getResource("group.png"));

	
	JButton entraineur=new JButton();
	JLabel e=new JLabel();
	ImageIcon ent=new ImageIcon(getClass().getResource("trainer.png"));
	
	JButton abo=new JButton();
	JLabel ab=new JLabel();
	ImageIcon abon=new ImageIcon(getClass().getResource("subscription.png"));
	
	JButton act=new JButton();
	JLabel ac=new JLabel();
	ImageIcon acti=new ImageIcon(getClass().getResource("gym.png"));
	
	
	JButton gerant=new JButton();
	JLabel g=new JLabel();
	ImageIcon ger=new ImageIcon(getClass().getResource("profile.png"));
	
	Border b=BorderFactory.createLineBorder(Color.white,3);
	
	
	
	public PagePrincipale()
	{
		frame.setSize(1132,800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(0x212121));
		frame.setTitle("PAGE PRINCIPALE");
		
		
		membre.setBounds(166, 450, 200, 200);
		membre.setBackground(new Color(0xff9671));
		membre.setFocusable(false);
		m.setText("MEMBRE");
		m.setIcon(me);
		m.setVerticalTextPosition(JLabel.BOTTOM);
		m.setHorizontalTextPosition(JLabel.CENTER);
		membre.setLayout(null);
		m.setBounds(50, 30, 150, 150);
		m.setFont(new Font("CALIBRI",Font.BOLD,24));
		membre.add(m);
		membre.setBorder(b);
		membre.addActionListener(this);
		
		
		entraineur.setBounds(766, 150, 200, 200);
		entraineur.setBackground(new Color(0x2582e3));
		e.setFont(new Font("CALIBRI",Font.BOLD,24));
		entraineur.setFocusable(false);
		e.setText("ENTRAINEUR");
		e.setIcon(ent);
		e.setVerticalTextPosition(JLabel.BOTTOM);
		e.setHorizontalTextPosition(JLabel.CENTER);
		entraineur.setLayout(null);
		e.setBounds(30, 30, 150, 150);
		e.setIconTextGap(15);
		entraineur.add(e);
		entraineur.setBorder(b);
		entraineur.addActionListener(this);
		
		gerant.setBounds(166, 150, 200, 200);
		gerant.setBackground(new Color(0xA0604A));
		g.setFont(new Font("CALIBRI",Font.BOLD,24));
		gerant.setFocusable(false);
		g.setText("GERANT");
		g.setIcon(ger);
		g.setVerticalTextPosition(JLabel.BOTTOM);
		g.setHorizontalTextPosition(JLabel.CENTER);
		gerant.setLayout(null);
		g.setBounds(60, 30, 150, 150);
		g.setIconTextGap(15);
		gerant.add(g);
		gerant.setBorder(b);
		gerant.addActionListener(this);
		
		act.setBounds(466, 300, 200, 200);
		act.setBackground(new Color(0x0089ba));
		ac.setFont(new Font("CALIBRI",Font.BOLD,24));
		ac.setText("ACTIVITE");
		ac.setIcon(acti);
		ac.setVerticalTextPosition(JLabel.BOTTOM);
		ac.setHorizontalTextPosition(JLabel.CENTER);
		act.setLayout(null);
		ac.setBounds(55, 30, 150, 150);
		ac.setIconTextGap(10);
		act.add(ac);
		act.setBorder(b);
		act.addActionListener(this);
		
		abo.setBounds(766, 450, 200, 200);
		abo.setBackground(new Color(0xf45849));
		ab.setFont(new Font("CALIBRI",Font.BOLD,24));
		abo.setFocusable(false);
		ab.setText("INSCRIPTION");
		ab.setIcon(abon);
		ab.setVerticalTextPosition(JLabel.BOTTOM);
		ab.setHorizontalTextPosition(JLabel.CENTER);
		abo.setLayout(null);
		ab.setBounds(30, 30, 150, 150);
		ab.setIconTextGap(15);
		abo.add(ab);
		abo.setBorder(b);
		abo.addActionListener(this);
		
		frame.add(membre);
		frame.add(entraineur);
		frame.add(gerant);
		frame.add(act);
		frame.add(abo);

		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		try {
				if(e.getSource()==membre) 
					new Membre(); 
				else if(e.getSource()==entraineur) 
					new Coach(); 
				else if(e.getSource()==gerant)
					new Gerant(); 
				else if(e.getSource()==act)
					new Activite();
				else if(e.getSource()==abo)
					new Inscription(); 
		}catch(Exception se) { se.printStackTrace();}
	}
}
