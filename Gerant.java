package firstapp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class Gerant implements ActionListener{
JFrame f=new JFrame("GESTION DES GERANTS");
	
	JButton buttonsup=new JButton("SUPPRIMER");
	JButton buttonmod=new JButton("MODIFIER");
	JButton rech=new JButton("RECHERCHER");
	JButton act=new JButton("ACTUALISER");


	JLabel label=new JLabel("Entrer l'ID:");
	JLabel titre=new JLabel("FICHE DU GERANT");
	JLabel gid=new JLabel("ID");
	JTextField fid=new JTextField();
	JLabel gnom=new JLabel("Nom");
	JTextField fnom=new JTextField();
	JLabel gprenom=new JLabel("Prenom");
	JTextField fprenom=new JTextField();
	JLabel gcin=new JLabel("CIN");
	JTextField fcin=new JTextField();
	JLabel gsexe=new JLabel("Sexe");
	JRadioButton fsexem=new JRadioButton("Homme");
	JRadioButton fsexef=new JRadioButton("Femme");
	ButtonGroup groupb=new ButtonGroup();
	JLabel gtel=new JLabel("Telephone");
	JTextField ftel=new JTextField();
	JLabel gadresse=new JLabel("Adresse");
	JTextField fadresse=new JTextField();
	JLabel gsalaire=new JLabel("Salaire");
	JTextField fsalaire=new JTextField();
	JLabel glogin=new JLabel("Login");
	JTextField flogin=new JTextField();
	JLabel gpassword=new JLabel("Password");
	JTextField fpassword=new JTextField();
	
	JButton valide=new JButton("ENREGISTRER");
	JButton annuler=new JButton("REINITIALISER");
	
	
    JPanel panel = new JPanel();
    JPanel pajout=new JPanel();
    
    Border bajout=BorderFactory.createLineBorder(Color.white,3);
    
	JTextField textf=new JTextField();
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    JScrollPane pane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    String columns[] = { "id","cin", "nom", "prenom","sexe","adresse","tel","salaire","login","password" };
    String data[][] = new String[25][15];
	
	  public Gerant() throws ClassNotFoundException {
	    try 
	  {
	      Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp","root", "mehdi");
      	  PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from gerant");
          ResultSet rs = st.executeQuery();
	    	
	    
	      int i = 0;
	      while (rs.next()) {
	        int id = rs.getInt(1);
	        String cin = rs.getString(2);
	        String nom = rs.getString(3);
	        String prenom= rs.getString(4);
	        String sexe= rs.getString(5);
	        String  adresse= rs.getString(6);
	        String  tel= rs.getString(7);
	        String  salaire= rs.getString(8);
	        String  login=rs.getString(9);
	        String  password=rs.getString(10);
	        data[i][0] = id+"";
	        data[i][1] = cin;
	        data[i][2] = nom;
	        data[i][3] = prenom;
	        data[i][4] = sexe ;
	        data[i][5] = adresse ;
	        data[i][6] = tel ;
	        data[i][7] = salaire ;
	        data[i][8] = login;
	        data[i][9] = password;
	        i++;
	      }
	      model.setDataVector(data, columns);
	      table.setShowGrid(true);
	      table.setShowVerticalLines(true);
	      table.setPreferredScrollableViewportSize(new Dimension(800,360));
	      table.setFillsViewportHeight(true);
	      table.setBounds(0,0,800,500);
	      pane.setVisible(true);
	      
	      textf.setBounds(700, 50, 150, 25);
	      
	      label.setBounds(600, 52, 300, 30);
	      label.setFont(new Font("CALIBRI",Font.BOLD,20));
	      label.setForeground(Color.white);
	      
	      buttonsup.setBounds(1100,50,150,30);
	      buttonsup.setFocusable(false);
	      buttonsup.setBackground(new Color(0xFFEF5350));
	      buttonsup.addActionListener(this);
	      
	      act.setBounds(1250, 500, 200, 30);
	      act.setFocusable(false);
	      act.setBackground(Color.MAGENTA);
	      act.addActionListener(this);
	      
	      buttonmod.setBounds(1300, 50, 150, 30);
	      buttonmod.setFocusable(false);
	      buttonmod.setBackground(new Color(0xFFF157));
	      buttonmod.addActionListener(this);
	      
	      rech.setBounds(920, 50, 150, 30);
	      rech.setFocusable(false);
	      rech.setBackground(new Color(0xADD8E6));
	      rech.addActionListener(this);
	      
	      f.add(buttonsup);
	      f.add(buttonmod);
	      f.add(act);
	      f.add(textf);
	      f.add(label);
	      f.add(rech);
	      f.setLayout(null);
	      
	      panel.add(pane);
	      panel.setBounds(600,100,900,400);
	      panel.setBackground(new Color(0x212121));
	      
	      titre.setBounds(177,3,200,20);
	      titre.setForeground(Color.white);
	      titre.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      
	      gid.setBounds(25,39,200,30);
	      gid.setForeground(Color.white);
	      gid.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      gcin.setBounds(25,96,200,30);
	      gcin.setForeground(Color.white);
	      gcin.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      gnom.setBounds(25,153,200,30);
	      gnom.setForeground(Color.white);
	      gnom.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      gprenom.setBounds(25,210,200,30);
	      gprenom.setForeground(Color.white);
	      gprenom.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      gsexe.setBounds(25,276,200,30);
	      gsexe.setForeground(Color.white);
	      gsexe.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      gadresse.setBounds(25,324,200,30);
	      gadresse.setForeground(Color.white);
	      gadresse.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      gtel.setBounds(25,381,323,30);
	      gtel.setForeground(Color.white);
	      gtel.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      gsalaire.setBounds(25,438,323,30);
	      gsalaire.setForeground(Color.white);
	      gsalaire.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      glogin.setBounds(25,495,323,30);
	      glogin.setForeground(Color.white);
	      glogin.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      gpassword.setBounds(25,552,323,30);
	      gpassword.setForeground(Color.white);
	      gpassword.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      
	      
	      valide.setBounds(120, 609, 150, 30);
	      valide.setFocusable(false);
	      annuler.setBounds(300, 609, 150, 30);
	      annuler.setFocusable(false);
	      
	      fid.setBounds(250, 39, 300, 30);
	      fcin.setBounds(250, 96, 300, 30);
	      fnom.setBounds(250, 153, 300, 30);
	      fprenom.setBounds(250, 210, 300, 30);
	      fsexef.setBounds(150, 276, 100, 30);
	      fsexef.setBackground(new Color(0x313131));
	      fsexem.setBackground(new Color(0x313131));
	      fsexef.setFocusable(false);
	      fsexem.setFocusable(false);
	      fsexef.setFont(new Font("ARIAL BLACK",Font.PLAIN,14));
	      fsexem.setFont(new Font("ARIAL BLACK",Font.PLAIN,14));
	      groupb.add(fsexef);
	      groupb.add(fsexem);
	      fsexef.setForeground(Color.white);
	      fsexem.setForeground(Color.white);
	      fsexem.setBounds(350, 276, 100, 30);
	      fadresse.setBounds(250, 324, 300, 30);
	      ftel.setBounds(250, 381,300 , 30);
	      fsalaire.setBounds(250, 438, 300, 30);
	      flogin.setBounds(250, 495, 300, 30);
	      fpassword.setBounds(250, 552, 300, 30);
	      
	      valide.setBackground(new Color(0x90EE90));
	      valide.addActionListener(this);
	      annuler.setBackground(new Color(0xFFEF5350));
	      annuler.addActionListener(this);
	      
	      pajout.setBounds(3,3, 580, 657);
	      pajout.setBorder(bajout);
	      pajout.setBackground(new Color(0x313131));
	      pajout.add(titre);
	      pajout.add(gid);
	      pajout.add(gcin);
	      pajout.add(gnom);
	      pajout.add(gprenom);
	      pajout.add(gsexe);
	      pajout.add(gadresse);
	      pajout.add(gtel);
	      pajout.add(gsalaire);
	      pajout.add(glogin);
	      pajout.add(gpassword);
	      pajout.add(valide);
	      pajout.add(annuler);
	      pajout.add(fid);
	      pajout.add(fcin);
	      pajout.add(fnom);
	      pajout.add(fprenom);
	      pajout.add(fsexem);
	      pajout.add(fadresse);
	      pajout.add(fsexef);
	      pajout.add(ftel);
	      pajout.add(fsalaire);
	      pajout.add(flogin);
	      pajout.add(fpassword);
	      pajout.setLayout(null);
	      
	      f.add(panel);
	      f.add(pajout);
	      f.setSize(1500, 700);
	      f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      f.setVisible(true);
	      f.getContentPane().setBackground(new Color(0x212121));
	      f.setResizable(false);
	      
	     
	      
	      con.close();
	    } catch(SQLException e) {
	      e.printStackTrace();
	    }
	  }
//	@Override
	public void actionPerformed(ActionEvent e) {
		//pour rechercher
		if(e.getSource()==rech) {
		try 
		  { 
			String t=textf.getText();Integer.parseInt(t);
				Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp","root", "mehdi");
				PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from gerant where id_gerant="+t+"");
				ResultSet rs = st.executeQuery();   
	          
	          	if(rs.next() )
	          		{
	          		   for (int i = 0; i < table.getRowCount(); i++) {
	        		    for (int j = 0; j < table.getColumnCount(); j++) {
	        		    	data[i][j] = "";
	        		    }
	        		}
	          		
	          		int id = rs.getInt(1);
	     	        String cin = rs.getString(2);
	     	        String nom = rs.getString(3);
	     	        String prenom= rs.getString(4);
	     	        String sexe= rs.getString(5);
	     	        String  adresse= rs.getString(6);
	     	        String  tel= rs.getString(7);
	     	        String  salaire= rs.getString(8);
	     	        String  login= rs.getString(9);
	     	        String  password= rs.getString(10);
	     	        data[0][0] = id+"";
	     	        data[0][1] = cin;
	     	        data[0][2] = nom;
	     	        data[0][3] = prenom;
	     	        data[0][4] = sexe ;
	     	        data[0][5] = adresse ;
	     	        data[0][6] = tel ;
	     	        data[0][7] = salaire ;
	     	        data[0][8] = login;
	     	        data[0][9] = password;
		  	        model.setDataVector(data, columns);
		  	        table.setModel(model);
				    table.setShowGrid(true);
				    table.setShowVerticalLines(true);
				    table.setPreferredScrollableViewportSize(new Dimension(750,360));
				    table.setFillsViewportHeight(true);
				    table.setSize(750,500);
				    pane.setVisible(true);
				    panel.add(pane);
	          }
	          else JOptionPane.showMessageDialog(rech,"Il n'existe pas un gerant avec tel id");
	          	con.close();
		  }catch(SQLException a) {a.printStackTrace();}
		}
		//pour supprimer
		else if(e.getSource()==buttonsup)
		{
			try 
			  {
				String t=textf.getText();Integer.parseInt(t);
				Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp","root", "mehdi");
		      	  PreparedStatement st = (PreparedStatement) con.prepareStatement("delete from gerant where id_gerant="+t+"");
		      	  int input = JOptionPane.showConfirmDialog(buttonsup,"VOULEZ-VOUS CONTINUEZ?", "CHOISISSEZ UNE OPTION:",JOptionPane.YES_NO_OPTION);//0=yes, 1=no, 2=cancel
		      	  if(input==0) {
		      		  int a=st.executeUpdate();
		      		  if(a==1) {
		      			JOptionPane.showMessageDialog(null, "LE GERANT EST SUPPRIME AVEC SUCCES");
		      		  }
		      		  else JOptionPane.showMessageDialog(null, "ERREUR A LA BASE DE DONNEE");
		      		 }
		      	  else JOptionPane.showMessageDialog(null, "AUCUN GERANT EST SUPPRIME");
		      	con.close();
		}catch(SQLException s) {s.printStackTrace();}
	}
		//pour actualiser
		else if(e.getSource().equals(act))
		{
			try 
			  { 
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp","root", "mehdi");
					PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from gerant");
					ResultSet rs = st.executeQuery();          
					for (int i = 0; i < table.getRowCount(); i++) {
						for (int j = 0; j < table.getColumnCount(); j++) {
		        		    	data[i][j] = "";
		        		    }
		        		}
					int i=0;
					while (rs.next()) {
				        int id = rs.getInt(1);
				        String cin = rs.getString(2);
				        String nom = rs.getString(3);
				        String prenom= rs.getString(4);
				        String sexe= rs.getString(5);
				        String  adresse= rs.getString(6);
				        String  tel= rs.getString(7);
				        String  salaire= rs.getString(8);
				        String  login= rs.getString(9);
				        String  password= rs.getString(10);
				        data[i][0] = id+"";
				        data[i][1] = cin;
				        data[i][2] = nom;
				        data[i][3] = prenom;
				        data[i][4] = sexe ;
				        data[i][5] = adresse ;
				        data[i][6] = tel ;
				        data[i][7] = salaire ;
				        data[i][8] = login;
				        data[i][9] = password;
				        i++;
				      }
			  	        model.setDataVector(data, columns);
			  	        table.setModel(model);
					    table.setShowGrid(true);
					    table.setShowVerticalLines(true);
					    table.setPreferredScrollableViewportSize(new Dimension(750,360));
					    table.setFillsViewportHeight(true);
					    table.setSize(750,500);
					    pane.setVisible(true);
					    panel.add(pane);
		          	con.close();
			  }catch(SQLException a) {a.printStackTrace();}
		}
		//pour modifier
		else if(e.getSource()==buttonmod) {
			String id=textf.getText();Integer.parseInt(id);
			try {
				Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp","root", "mehdi");
				PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from gerant where id_gerant="+id+"");
				ResultSet rs=st.executeQuery();
				if(rs.next()) {
					fid.setText(rs.getInt(1)+"");
					fcin.setText(rs.getString(2));
					fnom.setText(rs.getString(3));
					fprenom.setText(rs.getString(4));
					fadresse.setText(rs.getString(6));
					ftel.setText(rs.getString(7));
					if(rs.getString(5).equalsIgnoreCase("homme") || rs.getString(5).equalsIgnoreCase("m")) {
						fsexem.setSelected(true);
					}
					
					else if(rs.getString(5).equalsIgnoreCase("femme") || rs.getString(5).equalsIgnoreCase("f")) {
						fsexef.setSelected(true);
					}
					fsalaire.setText(rs.getString(8));
					flogin.setText(rs.getString(9));
					fpassword.setText(rs.getString(10));
			}
		}catch (SQLException e1) {e1.printStackTrace();}
	}
		//pour enregistrer
		else if(e.getSource()==valide)
			{
				String id=fid.getText(); Integer.parseInt(id);
				String cin=fcin.getText();
				String nom=fnom.getText();
				String prenom=fprenom.getText();
				String sexe=getSelectedButtonText(groupb);
				String tel=ftel.getText();
				String adresse=fadresse.getText();
				String salaire=fsalaire.getText(); Integer.parseInt(salaire);
				String login=flogin.getText();
				String password=fpassword.getText();
				try {
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp","root", "mehdi");
					PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from gerant where id_gerant="+id+"");
					ResultSet rs=st.executeQuery();
					if(rs.next()) {
						int input = JOptionPane.showConfirmDialog(valide,"LE GERANT EXISTE DEJA\nVOULEZ-VOUS LE MODIFIEZ ?", "UPDATE",JOptionPane.YES_NO_OPTION);
						if(input==0) {
							st = (PreparedStatement) con.prepareStatement("update gerant set cin_gerant='"+cin+"',nom_gerant='"+nom+"',prenom_gerant='"+prenom+"',sexe_gerant='"+sexe+"',adresse_gerant='"+adresse+"',tel_gerant='"+tel+"',salaire_gerant='"+salaire+"',login_gerant='"+login+"' ,password_gerant='"+password+"' where id_gerant="+id+"");
							int a=st.executeUpdate();
						if(a==1) {
							JOptionPane.showMessageDialog(valide, "LE GERANT EST MODIFIE AVEC SUCCES");
			  		  	}
						else JOptionPane.showMessageDialog(valide, "GERANT NON MODIFIE");
						}
			  		  	else JOptionPane.showMessageDialog(valide, "GERANT NON MODIFIE"); 
					}
					else {
						st = (PreparedStatement) con.prepareStatement("insert into gerant values("+id+",'"+cin+"','"+nom+"','"+prenom+"','"+sexe+"','"+adresse+"','"+tel+"',"+salaire+",'"+login+"','"+password+"')");
						int a=st.executeUpdate();
						if(a==1) {
							JOptionPane.showMessageDialog(valide, "LE GERANT EST AJOUTE AVEC SUCCES");
			  		  	}
			  		  	else JOptionPane.showMessageDialog(valide, "GERANT NON AJOUTE");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		else if(e.getSource()==annuler)
		{
			fid.setText("");
			fcin.setText("");
			fnom.setText("");
			fprenom.setText("");
			groupb.clearSelection();
			ftel.setText("");
			fsalaire.setText("");
			fadresse.setText("");
			flogin.setText("");
			fpassword.setText("");
		}
}
	
	
	
	 public String getSelectedButtonText(ButtonGroup buttonGroup) {
	        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
	            AbstractButton button = buttons.nextElement();

	            if (button.isSelected()) {
	                return button.getText();
	            }
	        }

	        return null;
}
}
