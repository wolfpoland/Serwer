package com.example.pacio_000.picswapper2;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author pacio_000
 */
public class NewJFrame extends JFrame {

    /**
     * Creates new form NewJFrame
     * @throws IOException
     */
    public NewJFrame() throws IOException {
        initComponents();
        this.setLocationRelativeTo(null);
        try {
            TestBaza.CreateTable();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() throws IOException {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
       // jLabel1.setBackground(new Color(255,255,255));
        jLabel1.setForeground(new Color(255,255,255));
        jLabel2.setForeground(new Color(255,255,255));
        jLabel3.setForeground(new Color(255,255,255));
        jLabel4.setForeground(new Color(255,255,255));
        jLabel5.setForeground(new Color(255,154,0));
      //  this.pack();
     //   Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
       // int x=(int) ((dimension.getWidth()-this.getWidth())/2);
       // int y=(int) ((dimension.getHeight()-this.getHeight())/2);
       // this.setLocation(x, y);
        BufferedImage ic=ImageIO.read(new File("C:/PicSwaper/Temp/cloud-icon.png"));
        ImageIcon imicon=new ImageIcon(ic);
        Image imo=imicon.getImage();
        setIconImage(imo);
        getContentPane().setBackground(new Color(95,89,89));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        //Font font;

        jLabel1.setFont(new Font("Verdana", 0, 36)); // NOI18N
        jLabel1.setText("Logowanie");

        jLabel2.setFont(new Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Email");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Haslo");
        jLabel3.setToolTipText("");
      //  ActionListener lol;


        jButton1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent event){
        		String mail=jTextField2.getText();
        		String haslo=jTextField3.getText();
        		System.out.println("Mail: "+mail+"\n haslo: "+haslo);

        		try {
					Uzytkownik uz= TestBaza.Logowanie(mail, haslo);
					if(uz!=null && !mail.equals("") && !haslo.equals("")){
						System.out.println("Zalogowano");
						File plik=new File("C:/PicSwaper/Users/U"+uz.getID());
						if(!plik.exists()){
							plik.mkdir();
						}
						File plik1=new File("C:/PicSwaper/Temp/tmp.dat");
						plik1.createNewFile();
						FileOutputStream lol2=new FileOutputStream(plik1);
						ObjectOutputStream lol =new ObjectOutputStream(lol2);
						lol.writeObject((Object)uz);
						lol.close();
						lol2.close();
						try {
							JFrame ramka=new PanelGlowny(uz.getID());
							ramka.pack();
							PanelGlowny lolo=(PanelGlowny) ramka;
							lolo.robiePanle(lolo.getjComboBox1());
					        ramka.setLocationRelativeTo(null);
							ramka.setVisible(true);

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						dispose();
					}else{
						  jLabel4.setForeground(new Color(255,0,0));
						 jLabel4.setText("Bl�d Logowania ! ");
					}

				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

        	}

        });
        jTextField2.setFont(new Font("Verdana", 0, 14)); // NOI18N
        jTextField2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setFont(new Font("Verdana", 0, 14)); // NOI18N
        jTextField3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton1.setFont(new Font("Verdana", 0, 11)); // NOI18N
        jButton1.setText("Zaloguj");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setText("Je�eli nie posiadasz konta to Rejestracja!");

        jLabel5.setFont(new Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setText("Rejestracja");
        Font font=jLabel5.getFont();
        Map atrybuty=font.getAttributes();


        atrybuty.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        jLabel5.setFont(font.deriveFont(atrybuty));
        jLabel5.addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent e){

        		JFrame ramka= new Rejestracja();
        		ramka.setVisible(true);
        		dispose();
        	}
        	public void mouseEntered(MouseEvent e){
        		   jLabel5.setForeground(new Color(255,255,255));
        	}
        	public void mouseExited(MouseEvent e){
        		 jLabel5.setForeground(new Color(255,154,0));
        	}
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel5)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
					new NewJFrame().setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}