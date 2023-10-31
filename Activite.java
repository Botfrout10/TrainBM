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

public class Activite implements ActionListener{
JFrame f=new JFrame("GESTION DES ACTIVITES");
	
	JButton buttonsup=new JButton("SUPPRIMER");
	JButton buttonmod=new JButton("MODIFIER");
	JButton rech=new JButton("RECHERCHER");
	JButton act=new JButton("ACTUALISER");


	JLabel label=new JLabel("Entrer l'ID:");
	JLabel titre=new JLabel("FICHE DE L'ACTIVITE");
	JLabel gid=new JLabel("ID");
	JTextField fid=new JTextField();
	JLabel gnom=new JLabel("activite");
	JTextField fnom=new JTextField();
	JLabel gtype=new JLabel("type_activite");
	JTextField ftype=new JTextField();
	JLabel gabo=new JLabel("id_abonnement");
	JTextField fabo=new JTextField();

	
	JButton valide=new JButton("ENREGISTRER");
	JButton annuler=new JButton("REINITIALISER");
	
	
    JPanel panel = new JPanel();
    JPanel pajout=new JPanel();
    
    Border bajout=BorderFactory.createLineBorder(Color.white,3);
    
	JTextField textf=new JTextField();
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    JScrollPane pane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    String columns[] = { "id","activite", "type_activite", "id_abonnement" };
    String data[][] = new String[25][7];
	
	  public Activite() throws ClassNotFoundException {
	    try 
	  {
	      Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp","root", "mehdi");
      	  PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from activite");
          ResultSet rs = st.executeQuery();
	    	
	    
	      int i = 0;
	      while (rs.next()) {
	        int id = rs.getInt(1);
	        String activite = rs.getString(2);
	        String type = rs.getString(3);
	        int id_abonement= rs.getInt(4);
	        data[i][0] = id+"";
	        data[i][1] = activite;
	        data[i][2] = type;
	        data[i][3] = id_abonement+"";
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
	      
	      titre.setBounds(177,3,250,20);
	      titre.setForeground(Color.white);
	      titre.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      
	      gid.setBounds(25,60,200,30);
	      gid.setForeground(Color.white);
	      gid.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      gnom.setBounds(25,164,200,30);
	      gnom.setForeground(Color.white);
	      gnom.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      gtype.setBounds(25,268,200,30);
	      gtype.setForeground(Color.white);
	      gtype.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      gabo.setBounds(25,372,200,30);
	      gabo.setForeground(Color.white);
	      gabo.setFont(new Font("ARIAL BLACK",Font.PLAIN,18));
	      
	      
	      valide.setBounds(120, 580, 150, 30);
	      valide.setFocusable(false);
	      annuler.setBounds(300, 580, 150, 30);
	      annuler.setFocusable(false);
	      
	      fid.setBounds(250, 60, 300, 30);
	      fnom.setBounds(250, 164, 300, 30);
	      ftype.setBounds(250, 268, 300, 30);
	      fabo.setBounds(250, 372, 300, 30);
	      
	      valide.setBackground(new Color(0x90EE90));
	      valide.addActionListener(this);
	      annuler.setBackground(new Color(0xFFEF5350));
	      annuler.addActionListener(this);
	      
	      pajout.setBounds(3,3, 580, 657);
	      pajout.setBorder(bajout);
	      pajout.setBackground(new Color(0x313131));
	      pajout.add(titre);
	      pajout.add(gid);
	      pajout.add(gnom);
	      pajout.add(gtype);
	      pajout.add(gabo);
	      pajout.add(valide);
	      pajout.add(annuler);
	      pajout.add(fid);
	      pajout.add(fnom);
	      pajout.add(ftype);
	      pajout.add(fabo);
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
				PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from activite where id_activite="+t+"");
				ResultSet rs = st.executeQuery();   
	          
	          	if(rs.next() )
	          		{
	          		   for (int i = 0; i < table.getRowCount(); i++) {
	        		    for (int j = 0; j < table.getColumnCount(); j++) {
	        		    	data[i][j] = "";
	        		    }
	        		}
	          		
	          		int id = rs.getInt(1);
	     	        String nom = rs.getString(2);
	     	        String type = rs.getString(3);
	     	        int abo= rs.getInt(4);
	     	        data[0][0] = id+"";
	     	        data[0][1] = nom;
	     	        data[0][2] = type;
	     	        data[0][3] = abo +"";
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
	          else JOptionPane.showMessageDialog(rech,"Il n'existe pas une activite avec tel id");
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
		      	  PreparedStatement st = (PreparedStatement) con.prepareStatement("delete from activite where id_activite="+t+"");
		      	  int input = JOptionPane.showConfirmDialog(buttonsup,"VOULEZ-VOUS CONTINUEZ?", "CHOISISSEZ UNE OPTION:",JOptionPane.YES_NO_OPTION);//0=yes, 1=no, 2=cancel
		      	  if(input==0) {
		      		  int a=st.executeUpdate();
		      		  if(a==1) {
		      			JOptionPane.showMessageDialog(null, "L'ACTIVITE EST SUPPRIMEE AVEC SUCCES");
		      		  }
		      		  else JOptionPane.showMessageDialog(null, "ERREUR A LA BASE DE DONNEE");
		      		 }
		      	  else JOptionPane.showMessageDialog(null, "AUCUNE ACTIVITE EST SUPPRIMEE");
		      	con.close();
		}catch(SQLException s) {s.printStackTrace();}
	}
		//pour actualiser
		else if(e.getSource().equals(act))
		{
			try 
			  { 
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp","root", "mehdi");
					PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from activite");
					ResultSet rs = st.executeQuery();          
					for (int i = 0; i < table.getRowCount(); i++) {
						for (int j = 0; j < table.getColumnCount(); j++) {
		        		    	data[i][j] = "";
		        		    }
		        		}
					int i=0;
					 while (rs.next()) {
					        int id = rs.getInt(1);
					        String activite = rs.getString(2);
					        String type = rs.getString(3);
					        int id_abonement= rs.getInt(4);
					        data[i][0] = id+"";
					        data[i][1] = activite;
					        data[i][2] = type;
					        data[i][3] = id_abonement+"";
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
				PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from activite where id_activite="+id+"");
				ResultSet rs=st.executeQuery();
				if(rs.next()) {
					fid.setText(rs.getInt(1)+"");
					fnom.setText(rs.getString(2));
					ftype.setText(rs.getString(3));
					fabo.setText(rs.getInt(4)+"");
			}
		}catch (SQLException e1) {e1.printStackTrace();}
	}
		//pour enregistrer
		else if(e.getSource()==valide)
			{
				String id=fid.getText(); Integer.parseInt(id);
				String nom=fnom.getText();
				String type=ftype.getText();
				String abo=fabo.getText(); Integer.parseInt(abo);
				try {
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp","root", "mehdi");
					PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from activite where id_activite="+id+"");
					ResultSet rs=st.executeQuery();
					if(rs.next()) {
						int input = JOptionPane.showConfirmDialog(valide,"L'ACTIVITE EXISTE DEJA\nVOULEZ-VOUS LE MODIFIEZ ?", "UPDATE",JOptionPane.YES_NO_OPTION);
						if(input==0) {
							st = (PreparedStatement) con.prepareStatement("update activite set nom_activite='"+nom+"',type_activite='"+type+"',id_abonement="+abo+" where id_activite="+id+"");
							int a=st.executeUpdate();
						if(a==1) {
							JOptionPane.showMessageDialog(valide, "L'ACTIVITE EST MODIFIEE AVEC SUCCES");
			  		  	}
						else JOptionPane.showMessageDialog(valide, "ACTIVITE NON MODIFIE");
						}
			  		  	else JOptionPane.showMessageDialog(valide, "ACTIVITE NON MODIFIE"); 
					}
					else {
						st = (PreparedStatement) con.prepareStatement("insert into activite values("+id+",'"+nom+"','"+type+"',"+abo+")");
						int a=st.executeUpdate();
						if(a==1) {
							JOptionPane.showMessageDialog(valide, "L'ACTIVITE EST AJOUTEE AVEC SUCCES");
			  		  	}
			  		  	else JOptionPane.showMessageDialog(valide, "ACTIVITE NON AJOUTEE");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		else if(e.getSource()==annuler)
		{
			fid.setText("");
			fnom.setText("");
			ftype.setText("");
			fabo.setText("");
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
