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

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class Membre implements ActionListener{
	JFrame f=new JFrame("GESTION DES MEMBRES");
	
	JButton buttonsup=new JButton("SUPPRIMER");
	JButton buttonmod=new JButton("MODIFIER");
	JButton rech=new JButton("RECHERCHER");
	JButton act=new JButton("ACTUALISER");


	JLabel label=new JLabel("Entrer l'ID:");
	JLabel titre=new JLabel("FICHE DU MEMBRE");
	JLabel gid=new JLabel("ID");
	JTextField fid=new JTextField();
	JLabel gnom=new JLabel("Nom");
	JTextField fnom=new JTextField();
	JLabel gprenom=new JLabel("Prenom");
	JTextField fprenom=new JTextField();
	JLabel gcin=new JLabel("CIN");
	JTextField fcin=new JTextField();
	JLabel gdaten=new JLabel("Date de naissance");
	JTextField fdate=new JTextField();
	JLabel gsexe=new JLabel("Sexe");
	JRadioButton fsexem=new JRadioButton("Homme");
	JRadioButton fsexef=new JRadioButton("Femme");
	ButtonGroup groupb=new ButtonGroup();
	JLabel gtel=new JLabel("Telephone");
	JTextField ftel=new JTextField();
	JLabel gadresse=new JLabel("Adresse");
	JTextField fadresse=new JTextField();
	
	JButton valide=new JButton("ENREGISTRER");
	JButton annuler=new JButton("REINITIALISER");
	
	
    JPanel panel = new JPanel();
    JPanel pajout=new JPanel();
    
    Border bajout=BorderFactory.createLineBorder(Color.white,3);
    
	JTextField textf=new JTextField();
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    JScrollPane pane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    String columns[] = { "id","cin", "nom", "prenom","date_naissance","sexe","adresse","tel" };
    String data[][] = new String[25][10];
	
	  public Membre() throws ClassNotFoundException {
	    try 
	  {
	      Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp","root", "mehdi");
      	  PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from membre");
          ResultSet rs = st.executeQuery();
	    	
	    
	      int i = 0;
	      while (rs.next()) {
	        int id = rs.getInt(1);
	        String cin = rs.getString(2);
	        String nom = rs.getString(3);
	        String prenom= rs.getString(4);
	        String date_naissance = rs.getString(5);
	        String sexe = rs.getString(6);
	        String adresse = rs.getString(7);
	        String tel = rs.getString(8);
	        data[i][0] = id+"";
	        data[i][1] = cin;
	        data[i][2] = nom;
	        data[i][3] = prenom;
	        data[i][4] = date_naissance ;
	        data[i][5] = sexe ;
	        data[i][6] = adresse ;
	        data[i][7] = tel ;
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
	      
	      gid.setBounds(25,43,200,30);
	      gid.setForeground(Color.white);
	      gid.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      gcin.setBounds(25,113,200,30);
	      gcin.setForeground(Color.white);
	      gcin.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      gnom.setBounds(25,183,200,30);
	      gnom.setForeground(Color.white);
	      gnom.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      gprenom.setBounds(25,253,200,30);
	      gprenom.setForeground(Color.white);
	      gprenom.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      gdaten.setBounds(25,323,200,30);
	      gdaten.setForeground(Color.white);
	      gdaten.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      gsexe.setBounds(25,393,200,30);
	      gsexe.setForeground(Color.white);
	      gsexe.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      gadresse.setBounds(25,463,200,30);
	      gadresse.setForeground(Color.white);
	      gadresse.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      gtel.setBounds(25,533,323,30);
	      gtel.setForeground(Color.white);
	      gtel.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      valide.setBounds(120, 603, 150, 30);
	      valide.setFocusable(false);
	      annuler.setBounds(300, 603, 150, 30);
	      annuler.setFocusable(false);
	      
	      fid.setBounds(250, 43, 300, 30);
	      fcin.setBounds(250, 113, 300, 30);
	      fnom.setBounds(250, 183, 300, 30);
	      fprenom.setBounds(250, 253, 300, 30);
	      fdate.setBounds(250, 323, 300, 30);
	      fsexef.setBounds(150, 393, 100, 30);
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
	      fsexem.setBounds(350, 393, 100, 30);
	      fadresse.setBounds(250, 463, 300, 30);
	      ftel.setBounds(250, 533,300 , 30);
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
	      pajout.add(gdaten);
	      pajout.add(gadresse);
	      pajout.add(gtel);
	      pajout.add(gsexe);
	      pajout.add(valide);
	      pajout.add(annuler);
	      pajout.add(fid);
	      pajout.add(fcin);
	      pajout.add(fnom);
	      pajout.add(fprenom);
	      pajout.add(fsexem);
	      pajout.add(fadresse);
	      pajout.add(fdate);
	      pajout.add(fsexef);
	      pajout.add(ftel);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		//pour rechercher
		if(e.getSource()==rech) {
		try 
		  { 
				String t=textf.getText();Integer.parseInt(t);
				Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp","root", "mehdi");
				PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from membre where id_membre="+t+"");
				ResultSet r = st.executeQuery();          
	          
	          	if(r.next())
	          		{
	          		   for (int i = 0; i < table.getRowCount(); i++) {
	        		    for (int j = 0; j < table.getColumnCount(); j++) {
	        		    	data[i][j] = "";
	        		    }
	        		}
	          		
	        	  	int id = r.getInt(1);
		  	        String cin = r.getString(2);
		  	        String nom = r.getString(3);
		  	        String prenom= r.getString(4);
		  	        String date_naissance = r.getString(5);
		  	        String sexe = r.getString(6);
		  	        String adresse = r.getString(7);
		  	        String tel = r.getString(8);
//		  	        data[0][0] = id+"";
//		  	        data[0][1] = cin;
//		  	        data[0][2] = nom;
//		  	        data[0][3] = prenom;
//		  	        data[0][4] = date_naissance ;
//		  	        data[0][5] = sexe ;
//		  	        data[0][6] = adresse ;
//		  	        data[0][7] = tel ;
		  	        for(int i=0;i<table.getColumnCount();i++)
		  	        {
		  	        	data[0][i]=r.getString(i+1);
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
	          }
	          else JOptionPane.showMessageDialog(rech,"Il n'existe pas un membre avec tel id");
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
		      	  PreparedStatement st = (PreparedStatement) con.prepareStatement("delete from membre where id_membre="+t+"");
		      	  int input = JOptionPane.showConfirmDialog(buttonsup,"VOULEZ-VOUS CONTINUEZ?", "CHOISISSEZ UNE OPTION:",JOptionPane.YES_NO_OPTION);//0=yes, 1=no, 2=cancel
		      	  if(input==0) {
		      		  int a=st.executeUpdate();
		      		  if(a==1) {
		      			JOptionPane.showMessageDialog(null, "LE MEMBRE EST SUPPRIMER AVEC SUCCES");
		      		  }
		      		  else JOptionPane.showMessageDialog(null, "ERREUR A LA BASE DE DONNEE");
		      		 }
		      	  else JOptionPane.showMessageDialog(null, "AUCUN MEMBRE EST SUPPRIMER");
		      	con.close();
		}catch(SQLException s) {s.printStackTrace();}
	}
		//pour actualiser
		else if(e.getSource().equals(act))
		{
			try 
			  { 
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp","root", "mehdi");
					PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from membre");
					ResultSet rs = st.executeQuery();          
					for (int i = 0; i < table.getRowCount(); i++) {
						for (int j = 0; j < table.getColumnCount(); j++) {
		        		    	data[i][j] = "";
		        		    }
		        		}
		        	    int i = 0;
		      	      	while (rs.next()) {
		      	        int id = rs.getInt(1);
		      	        String cin = rs.getString(2);
		      	        String nom = rs.getString(3);
		      	        String prenom= rs.getString(4);
		      	        String date_naissance = rs.getString(5);
		      	        String sexe = rs.getString(6);
		      	        String adresse = rs.getString(7);
		      	        String tel = rs.getString(8);
		      	        data[i][0] = id+"";
		      	        data[i][1] = cin;
		      	        data[i][2] = nom;
		      	        data[i][3] = prenom;
		      	        data[i][4] = date_naissance ;
		      	        data[i][5] = sexe ;
		      	        data[i][6] = adresse ;
		      	        data[i][7] = tel ;
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
		
		else if(e.getSource()==buttonmod) {
			String id=textf.getText();Integer.parseInt(id);
			try {
				Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp","root", "mehdi");
				PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from membre where id_membre="+id+"");
				ResultSet rs=st.executeQuery();
				if(rs.next()) {
					fid.setText(rs.getInt(1)+"");
					fcin.setText(rs.getString(2));
					fnom.setText(rs.getString(3));
					fprenom.setText(rs.getString(4));
					fdate.setText(rs.getString(5));
					fadresse.setText(rs.getString(7));
					ftel.setText(rs.getString(8));
					if(rs.getString(6).equalsIgnoreCase("homme") || rs.getString(6).equalsIgnoreCase("m")) {
						fsexem.setSelected(true);
					}
					
					else if(rs.getString(6).equalsIgnoreCase("femme") || rs.getString(6).equalsIgnoreCase("f")) {
						fsexef.setSelected(true);
					}
					
			}
		}catch (SQLException e1) {e1.printStackTrace();}
	}
		else if(e.getSource()==valide)
			{
				String id=fid.getText(); Integer.parseInt(id);
				String cin=fcin.getText();
				String nom=fnom.getText();
				String prenom=fprenom.getText();
				String daten=fdate.getText();
				String sexe=getSelectedButtonText(groupb);
				String tel=ftel.getText();
				String adresse=fadresse.getText();
				try {
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp","root", "mehdi");
					PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from membre where id_membre="+id+"");
					ResultSet rs=st.executeQuery();
					if(rs.next()) {
						int input = JOptionPane.showConfirmDialog(valide,"LE MEMBRE EXISTE DEJA\nVOULEZ-VOUS LE MODIFIEZ ?", "UPDATE",JOptionPane.YES_NO_OPTION);
						if(input==0) {
							st = (PreparedStatement) con.prepareStatement("update membre set cin_membre= '"+cin+"',nom_membre='"+nom+"',prenom_membre='"+prenom+"',date_naissance_membre='"+daten+"',sexe_membre='"+sexe+"',adresse_membre='"+adresse+"',tel_membre='"+tel+"' where id_membre="+id+"");
							int a=st.executeUpdate();
						if(a==1) {
							JOptionPane.showMessageDialog(valide, "LE MEMBRE EST MODIFIE AVEC SUCCES");
			  		  	}
						else JOptionPane.showMessageDialog(valide, "MEMBRE NON MODIFIE");
						}
			  		  	else JOptionPane.showMessageDialog(valide, "MEMBRE NON MODIFIE"); 
					}
					else {
						st = (PreparedStatement) con.prepareStatement("insert into membre values("+id+",'"+cin+"','"+nom+"','"+prenom+"','"+daten+"','"+sexe+"','"+adresse+"','"+tel+"')");
						int a=st.executeUpdate();
						if(a==1) {
							JOptionPane.showMessageDialog(valide, "LE MEMBRE EST AJOUTE AVEC SUCCES");
			  		  	}
			  		  	else JOptionPane.showMessageDialog(valide, "MEMBRE NON AJOUTE");
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
			fdate.setText("");
			groupb.clearSelection();
			ftel.setText("");
			fadresse.setText("");
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
