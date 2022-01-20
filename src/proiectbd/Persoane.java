package proiectbd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class Persoane extends JFrame {

	public Persoane() {
		 initComponents();
	     this.setLocationRelativeTo(null);
	     findPersoane();
	}
	
	public Connection getConnection()
    {
        Connection con = null;
        
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","admin1234");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return con;
    }
	
	 public ArrayList<Persoane> ListPers(String cnp, String telefon, String adresa)
	    {
	        ArrayList<Persoane> persList = new ArrayList<Persoane>();
	        
	        Statement st;
	        ResultSet rs;
	        
	        try{
	            Connection con = getConnection();
	            st = con.createStatement();
	            String searchQuery = "SELECT * FROM `pers` WHERE cnp='"+cnp+"' and telefon='"+telefon+"' and adresa='"+adresa+"'";
	            rs = st.executeQuery(searchQuery);
	            
	            Persoane pers;
	            
	            while(rs.next())
	            {
	                pers = new Persoane(
	                                 rs.getInt("cnp"),
	                                 rs.getString("nume"),
	                                 rs.getString("telefon"),
	                                 rs.getString("adresa"),
	                                 rs.getString("cetatenie"),
	                                 rs.getDate("datan")
	                                );
	                persList.add(pers);
	            }
	            
	        }catch(Exception ex){
	            System.out.println(ex.getMessage());
	        }
	        
	        return persList;
	    }
	 
	 public void findPersoane() {
	        ArrayList<Pers1> pers = ListPers(textField.getText(),textField_1.getText(),textField_2.getText());
	        DefaultTableModel model = new DefaultTableModel();
	        model.setColumnIdentifiers(new Object[]{"CNP","Nume","Telefon","Adresa","Cetatenie","Data Nasterii"});
	        Object[] row = new Object[6];
	        
	        for(int i = 0; i < pers.size(); i++)
	        {
	            row[0] = pers.get(i).getCnp();
	            row[1] = pers.get(i).getNume();
	            row[2] = pers.get(i).getTelefon();
	            row[3] = pers.get(i).getAdresa();
	            row[4] = pers.get(i).getCetatenie();
	            row[5] = pers.get(i).getDatan();
	            model.addRow(row);
	        }
	       
	    }
	
	@SuppressWarnings("unchecked")
   private void initComponents() {

       jPanel1 = new javax.swing.JPanel();
       jPanel2 = new javax.swing.JPanel();
       jButton1 = new javax.swing.JButton();
       jButton2 = new javax.swing.JButton();

       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
       setUndecorated(true);
       setPreferredSize(new java.awt.Dimension(850, 680));

       jPanel1.setBackground(new java.awt.Color(1, 50, 67));

       jPanel2.setBackground(new java.awt.Color(0, 0, 0));

       jButton1.setBackground(new java.awt.Color(153, 0, 0));
       jButton1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
       jButton1.setForeground(new java.awt.Color(255, 255, 255));
       jButton1.setText("X");
       jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
           public void mouseClicked(java.awt.event.MouseEvent evt) {
               jButton1MouseClicked(evt);
           }
       });

       jButton2.setBackground(new java.awt.Color(0, 153, 153));
       jButton2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
       jButton2.setForeground(new java.awt.Color(255, 255, 255));
       jButton2.setText("-");
       jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
           public void mouseClicked(java.awt.event.MouseEvent evt) {
               jButton2MouseClicked(evt);
           }
       });
       
       JLabel lblNewLabel_2 = new JLabel("Căutare persoane");
       lblNewLabel_2.setFont(new Font("Myriad Pro Light", Font.PLAIN, 21));
       lblNewLabel_2.setForeground(Color.WHITE);

       javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
       jPanel2Layout.setHorizontalGroup(
       	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
       		.addGroup(jPanel2Layout.createSequentialGroup()
       			.addGap(328)
       			.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
       			.addPreferredGap(ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
       			.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
       			.addPreferredGap(ComponentPlacement.UNRELATED)
       			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
       			.addGap(19))
       );
       jPanel2Layout.setVerticalGroup(
       	jPanel2Layout.createParallelGroup(Alignment.LEADING)
       		.addGroup(jPanel2Layout.createSequentialGroup()
       			.addContainerGap()
       			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
       				.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
       				.addGroup(jPanel2Layout.createSequentialGroup()
       					.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
       						.addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
       						.addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
       					.addContainerGap())))
       );
       jPanel2.setLayout(jPanel2Layout);
       
       JPanel jPanel3 = new JPanel();
       jPanel3.setBackground(new java.awt.Color(0, 86, 115));
       
       JPanel panel = new JPanel();
       
       textField = new JTextField();
       textField.setColumns(10);
       
       textField_1 = new JTextField();
       textField_1.setColumns(10);
       
       lblNewLabel = new JLabel("CNP:");
       lblNewLabel.setFont(new Font("Myriad Pro Light", Font.PLAIN, 19));
       lblNewLabel.setForeground(Color.WHITE);
       
       lblNewLabel_1 = new JLabel("Telefon:");
       lblNewLabel_1.setFont(new Font("Myriad Pro Light", Font.PLAIN, 18));
       lblNewLabel_1.setForeground(Color.WHITE);
       
       btnNewButton_1 = new JButton("Căutare");
       btnNewButton_1.addMouseListener(new MouseAdapter() {
       	public void mouseClicked(MouseEvent evt) {
       		btnNewButton_1MouseClicked(evt);
       	}
       });
       btnNewButton_1.setFont(new Font("Myriad Pro Light", Font.PLAIN, 18));
       btnNewButton_1.setBackground(new Color(34, 139, 34));
       btnNewButton_1.setForeground(Color.WHITE);
       
       JLabel lblNewLabel_1_1 = new JLabel("Adresa de domiciliu:");
       lblNewLabel_1_1.setForeground(Color.WHITE);
       lblNewLabel_1_1.setFont(new Font("Myriad Pro Light", Font.PLAIN, 18));
       
       textField_2 = new JTextField();
       textField_2.setColumns(10);
       
       JButton btnNewButton_1_1 = new JButton("Filtrare");
       btnNewButton_1_1.setForeground(Color.WHITE);
       btnNewButton_1_1.setFont(new Font("Myriad Pro Light", Font.PLAIN, 18));
       btnNewButton_1_1.setBackground(new Color(34, 139, 34));
       
       JButton btnNewButton_1_2 = new JButton("Sortare");
       btnNewButton_1_2.setForeground(Color.WHITE);
       btnNewButton_1_2.setFont(new Font("Myriad Pro Light", Font.PLAIN, 18));
       btnNewButton_1_2.setBackground(new Color(34, 139, 34));
       
       JButton btnNewButton_1_3 = new JButton("Ștergere");
       btnNewButton_1_3.setForeground(Color.WHITE);
       btnNewButton_1_3.setFont(new Font("Myriad Pro Light", Font.PLAIN, 18));
       btnNewButton_1_3.setBackground(new Color(34, 139, 34));

       javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
       jPanel1Layout.setHorizontalGroup(
       	jPanel1Layout.createParallelGroup(Alignment.LEADING)
       		.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
       		.addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
       		.addGroup(jPanel1Layout.createSequentialGroup()
       			.addGap(25)
       			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
       				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
       				.addComponent(textField, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
       				.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
       				.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
       				.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
       				.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
       				.addGroup(jPanel1Layout.createSequentialGroup()
       					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
       					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
       					.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
       				.addGroup(jPanel1Layout.createSequentialGroup()
       					.addComponent(btnNewButton_1_2, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
       					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
       					.addComponent(btnNewButton_1_3, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
       			.addGap(48)
       			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
       			.addContainerGap(30, Short.MAX_VALUE))
       );
       jPanel1Layout.setVerticalGroup(
       	jPanel1Layout.createParallelGroup(Alignment.LEADING)
       		.addGroup(jPanel1Layout.createSequentialGroup()
       			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
       			.addPreferredGap(ComponentPlacement.RELATED)
       			.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
       			.addGap(30)
       			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
       				.addGroup(jPanel1Layout.createSequentialGroup()
       					.addComponent(lblNewLabel)
       					.addPreferredGap(ComponentPlacement.RELATED)
       					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
       					.addPreferredGap(ComponentPlacement.UNRELATED)
       					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
       					.addGap(2)
       					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
       					.addGap(18)
       					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
       					.addPreferredGap(ComponentPlacement.RELATED)
       					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
       					.addGap(30)
       					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
       						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
       						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
       					.addGap(18)
       					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
       						.addComponent(btnNewButton_1_3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
       						.addComponent(btnNewButton_1_2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
       				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 534, GroupLayout.PREFERRED_SIZE))
       			.addContainerGap(28, Short.MAX_VALUE))
       );
       panel.setLayout(null);
       
       table = new JTable();
       table.setBounds(10, 519, 396, -508);
       panel.add(table);
       jPanel3.setLayout(null);
       
       JButton btnNewButton = new JButton("Persoane");
       btnNewButton.addMouseListener(new MouseAdapter() {
       	public void mouseClicked(MouseEvent evt) {
       		btnNewButtonMouseClicked(evt);
       	}
       });
       btnNewButton.setFont(new Font("Myriad Pro Light", Font.BOLD, 17));
       btnNewButton.setForeground(Color.WHITE);
       btnNewButton.setBounds(30, 0, 105, 35);
       btnNewButton.setBackground(new java.awt.Color(0,86,115));
       jPanel3.add(btnNewButton);
       
       JButton btnNewButton2 = new JButton("Documente");
       btnNewButton2.setFont(new Font("Myriad Pro Light", Font.PLAIN, 17));
       btnNewButton2.setForeground(Color.WHITE);
       btnNewButton2.setBounds(145, 0, 117, 35);
       btnNewButton2.setBackground(new java.awt.Color(0,86,115));
       jPanel3.add(btnNewButton2);
       jPanel1.setLayout(jPanel1Layout);
       

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
       );

       pack();
   }// </editor-fold>//GEN-END:initComponents

   private void btnNewButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
   	Persoane ps = new Persoane();
       ps.setVisible(true);
       ps.pack();
       ps.setLocationRelativeTo(null);
       ps.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.dispose();
   }//GEN-LAST:event_jButton3MouseClicked
   
   private void btnNewButton_1MouseClicked(java.awt.event.MouseEvent evt) {
   	try {
   		Class.forName("com.mysql.jdbc.Driver");
   		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","admin1234");
   		
   		String cnp = textField.getText();
		String telefon = textField_1.getText();
		String adresa = textField_2.getText();
   		
   		Statement stm = conn.createStatement();
   		String sql = "select * from pers where cnp='"+cnp+"' and telefon='"+telefon+"' and adresa='"+adresa+"'";
   		ResultSet rs = stm.executeQuery(sql);
   	} catch(Exception e) {
   		System.out.println(e.getMessage());
   	}
   }
   
   private void btnNewButton_1_1MouseClicked(java.awt.event.MouseEvent evt) {
	   findPersoane();
   }

   private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       System.exit(0);
   }//GEN-LAST:event_jButton1MouseClicked

   private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
       this.setState(JFrame.ICONIFIED);
   }//GEN-LAST:event_jButton2MouseClicked

   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
       try {
           for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               if ("Nimbus".equals(info.getName())) {
                   javax.swing.UIManager.setLookAndFeel(info.getClassName());
                   break;
               }
           }
       } catch (ClassNotFoundException ex) {
           java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (javax.swing.UnsupportedLookAndFeelException ex) {
           java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
       //</editor-fold>

       /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               new Welcome().setVisible(true);
           }
       });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton jButton1;
   private javax.swing.JButton jButton2;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JPanel jPanel2;
   private JTable table;
   private JTextField textField;
   private JTextField textField_1;
   private JLabel lblNewLabel;
   private JLabel lblNewLabel_1;
   private JButton btnNewButton_1;
   private JTextField textField_2;
}
