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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class Inscription implements ActionListener{
JFrame f=new JFrame("GESTION DES INSCRIPTIONS");
	
	JButton buttonsup=new JButton("SUPPRIMER");
	JButton buttonmod=new JButton("MODIFIER");
	JButton rech=new JButton("RECHERCHER");
	JButton act=new JButton("ACTUALISER");


	JLabel label=new JLabel("ID Membre:");
	JLabel label1=new JLabel("ID Activite:");
	JLabel titre=new JLabel("FICHE D'INSCRIPTION");
	JLabel gid=new JLabel("Membre");
	JTextField fid=new JTextField();
	JLabel gid_act=new JLabel("Activite");
	JTextField fid_act=new JTextField();
	JLabel gstatut=new JLabel("Statut");
	JTextField fstatut=new JTextField();

	
	JButton valide=new JButton("ENREGISTRER");
	JButton annuler=new JButton("REINITIALISER");
	
	
    JPanel panel = new JPanel();
    JPanel pajout=new JPanel();
    
    Border bajout=BorderFactory.createLineBorder(Color.white,3);
    
	JTextField mf=new JTextField();
	JTextField af=new JTextField();
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    JScrollPane pane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    String columns[] = { "id membre","nom","prenom","id activite", "activite","duree abonnement","nbr jour","statut abo","prix" };
    String data[][] = new String[25][10];
	
	  public Inscription() throws ClassNotFoundException {
	    try 
	  {
	      Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp","root", "mehdi");
      	  PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from InfoAboMem");
          ResultSet rs = st.executeQuery();
          
	      int i = 0;
	      while(rs.next()) {
    		int id = rs.getInt(1);
   	        String nom = rs.getString(2);
   	        String prenom = rs.getString(3);
   	        int id_activite = rs.getInt(4);
   	        String activite= rs.getString(5);
   	        String dure_abonement = rs.getString(7);
   	        int nbr_jr = rs.getInt(8);
   	        String statut = rs.getString(9);
   	        int prix = rs.getInt(10);
   	        data[i][0] = id+"";
   	        data[i][1] = nom;
   	        data[i][2] = prenom;
   	        data[i][3] = id_activite+"";
   	        data[i][4] = activite;
   	        data[i][5] = dure_abonement;
   	        data[i][6] = nbr_jr+"";
   	        data[i][7] = statut;
   	        data[i][8] = prix+"";
   	        i++;
    		}
	      model.setDataVector(data, columns);
	      table.setShowGrid(true);
	      table.setShowVerticalLines(true);
	      table.setPreferredScrollableViewportSize(new Dimension(1000,360));
	      table.setFillsViewportHeight(true);
	      table.setBounds(0,0,800,500);
	      pane.setVisible(true);
	      
	      mf.setBounds(550, 50, 70, 25);
	      af.setBounds(750, 50, 70, 25);
	      
	      label.setBounds(440, 52, 150, 30);
	      label.setFont(new Font("CALIBRI",Font.BOLD,20));
	      label.setForeground(Color.white);
	      label1.setBounds(650, 52, 150, 30);
	      label1.setFont(new Font("CALIBRI",Font.BOLD,20));
	      label1.setForeground(Color.white);
	      
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
	      f.add(mf);
	      f.add(af);
	      f.add(label);
	      f.add(label1);
	      f.add(rech);
	      f.setLayout(null);
	      
	      panel.add(pane);
	      panel.setBounds(420,100,1050,400);
	      panel.setBackground(new Color(0x212121));
	      
	      titre.setBounds(100,3,350,20);
	      titre.setForeground(Color.white);
	      titre.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      
	      
	      gid.setBounds(25,74,100,30);
	      gid.setForeground(Color.white);
	      gid.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      gid_act.setBounds(25,206,100,30);
	      gid_act.setForeground(Color.white);
	      gid_act.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      gstatut.setBounds(25,338,100,30);
	      gstatut.setForeground(Color.white);
	      gstatut.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      
	      valide.setBounds(35, 470, 130, 30);
	      valide.setFocusable(false);
	      annuler.setBounds(235, 470, 130, 30);
	      annuler.setFocusable(false);
	      
	      fid.setBounds(150, 74, 150, 30);
	      fid_act.setBounds(150, 206, 150, 30);
	      fstatut.setBounds(150, 338, 150, 30);
	      
	      valide.setBackground(new Color(0x90EE90));
	      valide.addActionListener(this);
	      annuler.setBackground(new Color(0xFFEF5350));
	      annuler.addActionListener(this);
	      
	      pajout.setBounds(3,3, 400, 657);
	      pajout.setBorder(bajout);
	      pajout.setBackground(new Color(0x313131));
	      pajout.add(titre);
	      pajout.add(gid);
	      pajout.add(gid_act);
	      pajout.add(gstatut);
	      pajout.add(valide);
	      pajout.add(annuler);
	      pajout.add(fid);
	      pajout.add(fid_act);
	      pajout.add(fstatut);
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
			String t=mf.getText(); 
			Integer.parseInt(t);
			System.out.print(t);
			String id_a=af.getText(); 
			Integer.parseInt(id_a);
			System.out.print(id_a);
				Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp","root", "mehdi");
				PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from InfoAboMem where id_membre="+t+" and id_activite="+id_a+"");
				ResultSet rs = st.executeQuery();   
	          	if(rs.next() )
	          		{
	          		   for (int i = 0; i < table.getRowCount(); i++) {
	        		    for (int j = 0; j < table.getColumnCount(); j++) {
	        		    	data[i][j] = "";
	        		    }
	          		   }
	          		   	int i=0;
	          			int id = rs.getInt(1);
	          	        String nom = rs.getString(2);
	          	        String prenom = rs.getString(3);
	          	        int id_activite = rs.getInt(4);
	          	        String activite= rs.getString(5);
	          	        String dure_abonement = rs.getString(7);
	          	        int nbr_jr = rs.getInt(8);
	          	        String statut = rs.getString(9);
	          	        int prix = rs.getInt(10);
	          	        data[i][0] = id+"";
	          	        data[i][1] = nom;
	          	        data[i][2] = prenom;
	          	        data[i][3] = id_activite+"";
	          	        data[i][4] = activite;
	          	        data[i][5] = dure_abonement;
	          	        data[i][6] = nbr_jr+"";
	          	        data[i][7] = statut;
	          	        data[i][8] = prix+"";
	          		model.setDataVector(data, columns);
		      	    table.setShowGrid(true);
		      	    table.setShowVerticalLines(true);
		      	    table.setPreferredScrollableViewportSize(new Dimension(1000,360));
		      	    table.setFillsViewportHeight(true);
		      	    table.setBounds(0,0,800,500);
				    table.setSize(750,500);
				    pane.setVisible(true);
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
				String t=mf.getText(); Integer.parseInt(t);
				String t1=af.getText(); Integer.parseInt(t1);
				Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp","root", "mehdi");
		      	  PreparedStatement st = (PreparedStatement) con.prepareStatement("delete from paiement where id_activite="+t1+" and id_membre="+t+"");
		      	  int input = JOptionPane.showConfirmDialog(buttonsup,"VOULEZ-VOUS CONTINUEZ?", "CHOISISSEZ UNE OPTION:",JOptionPane.YES_NO_OPTION);//0=yes, 1=no, 2=cancel
		      	  if(input==0) {
		      		  int a=st.executeUpdate();
		      		  if(a==1) {
		      			JOptionPane.showMessageDialog(null, "L'ACTIVITE DU MEMBRE EST SUPPRIMEE AVEC SUCCES");
		      		  }
		      		  else JOptionPane.showMessageDialog(null, "ERREUR A LA BASE DE DONNEE");
		      		 }
		      	  else JOptionPane.showMessageDialog(null, "AUCUN ENREGISTREMENT EST SUPPRIME");
		      	con.close();
		}catch(SQLException s) {s.printStackTrace();}
	}
		//pour actualiser
		else if(e.getSource().equals(act))
		{
			try 
			  { 
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp","root", "mehdi");
					PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from InfoAboMem");
					ResultSet rs = st.executeQuery();
					for (int i = 0; i < table.getRowCount(); i++) {
						for (int j = 0; j < table.getColumnCount(); j++) {
		        		    	data[i][j] = "";
		        		    }
		        		}
						int i = 0;
						while(rs.next()) {
				    		int id = rs.getInt(1);
				   	        String nom = rs.getString(2);
				   	        String prenom = rs.getString(3);
				   	        int id_activite = rs.getInt(4);
				   	        String activite= rs.getString(5);
				   	        String dure_abonement = rs.getString(7);
				   	        int nbr_jr = rs.getInt(8);
				   	        String statut = rs.getString(9);
				   	        int prix = rs.getInt(10);
				   	        data[i][0] = id+"";
				   	        data[i][1] = nom;
				   	        data[i][2] = prenom;
				   	        data[i][3] = id_activite+"";
				   	        data[i][4] = activite;
				   	        data[i][5] = dure_abonement;
				   	        data[i][6] = nbr_jr+"";
				   	        data[i][7] = statut;
				   	        data[i][8] = prix+"";
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
			String id=mf.getText();Integer.parseInt(id);
			String id_a=af.getText();Integer.parseInt(id_a);
			try {
				Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp","root", "mehdi");
				PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from InfoAboMem where id_activite="+id_a+" and id_membre="+id+"");
				ResultSet rs=st.executeQuery();
				if(rs.next()) {
					fid.setText(rs.getInt(1)+"");
					fid_act.setText(rs.getString(4));
					fstatut.setText(rs.getString(9));
			}
		}catch (SQLException e1) {e1.printStackTrace();}
	}
		//pour enregistrer
		else if(e.getSource()==valide)
			{
				String id=fid.getText(); Integer.parseInt(id);
				String id_act=fid_act.getText(); Integer.parseInt(id_act);
				String statut=fstatut.getText();
				try {
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp","root", "mehdi");
					PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from paiement where id_activite="+id_act+" and id_membre="+id+"");
					ResultSet rs=st.executeQuery();
					if(rs.next()) {
						int input = JOptionPane.showConfirmDialog(valide,"EXISTE DEJA\nVOULEZ-VOUS LE MODIFIEZ ?", "UPDATE",JOptionPane.YES_NO_OPTION);
						if(input==0) {
							st = (PreparedStatement) con.prepareStatement("update paiement set id_activite='"+id_act+"',statut='"+statut+"' where id_activite="+id_act+" and id_membre='"+id+"'");
							int a=st.executeUpdate();
						if(a==1) {
							JOptionPane.showMessageDialog(valide, "MODIFIEE AVEC SUCCES");
			  		  	}
						else JOptionPane.showMessageDialog(valide, "NON MODIFIE");
						}
			  		  	else JOptionPane.showMessageDialog(valide, "NON MODIFIE"); 
					}
					else {
						st = (PreparedStatement) con.prepareStatement("insert into paiement values("+id+","+id_act+",'"+statut+"')");
						int a=st.executeUpdate();
						if(a==1) {
							JOptionPane.showMessageDialog(valide, "AJOUTEE AVEC SUCCES");
			  		  	}
			  		  	else JOptionPane.showMessageDialog(valide, "NON AJOUTEE");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		else if(e.getSource()==annuler)
		{
			fid.setText("");
			fid_act.setText("");
			fstatut.setText("");
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
