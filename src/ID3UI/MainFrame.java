package ID3UI;

import AlgoID3.DataBase;
import AlgoID3.ESTreeAlgo;
import AlgoID3.GrapTree;
import AlgoID3.ID3Algo;
import ID3UI.JInternalFramePatient;
import ID3UI.data;

import algo.TreeLayoutDemoPT;
import com.l2fprod.gui.plaf.skin.Skin;

import com.l2fprod.gui.plaf.skin.SkinLookAndFeel;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame extends javax.swing.JFrame {

    public static MainFrame obj = null;

    public MainFrame() {
        initComponents();
        DataBase.getOracleConnection();
        obj = this;
        java.awt.Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

        String lnfName = "com.jgoodies.plaf.plastic.PlasticXPLookAndFeel";
//        try {
//            Skin theSkinToUse = SkinLookAndFeel.loadThemePack("Themes//roueGreenthemepack.zip");
//            SkinLookAndFeel.setSkin(theSkinToUse);
//            // finally set the Skin Look And Feel
//            UIManager.setLookAndFeel(new SkinLookAndFeel());
//            javax.swing.SwingUtilities.updateComponentTreeUI(this);
        setSize(screensize.width, screensize.height);
//        } catch (Exception ex1) {
//            System.err.println("Unsupported LookAndFeel: " + lnfName);
//        }
        IDSMenu.setEnabled(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        SystemMenu = new javax.swing.JMenu();
        LoginMenu = new javax.swing.JMenuItem();
        LogoutMenu = new javax.swing.JMenuItem();
        ExitMenu = new javax.swing.JMenuItem();
        IDSMenu = new javax.swing.JMenu();
        TrainingMenu = new javax.swing.JMenuItem();
        TestingMenu = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Heart disease prediction system");
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(jDesktopPane1);

        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setMaximumSize(new java.awt.Dimension(161, 32769));

        SystemMenu.setText("System");
        SystemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SystemMenuActionPerformed1(evt);
            }
        });

        LoginMenu.setText("Login");
        LoginMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginMenuMouseClicked(evt);
            }
        });
        LoginMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginMenuActionPerformed(evt);
            }
        });
        SystemMenu.add(LoginMenu);

        LogoutMenu.setText("Logout");
        LogoutMenu.setEnabled(false);
        LogoutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutMenuActionPerformed1(evt);
            }
        });
        SystemMenu.add(LogoutMenu);

        ExitMenu.setText("Exit");
        ExitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuActionPerformed(evt);
            }
        });
        SystemMenu.add(ExitMenu);

        jMenuBar1.add(SystemMenu);

        IDSMenu.setText("Algo");
        IDSMenu.setEnabled(false);
        IDSMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDSMenuActionPerformed(evt);
            }
        });

        TrainingMenu.setText("Training");
        TrainingMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrainingMenuActionPerformed(evt);
            }
        });
        IDSMenu.add(TrainingMenu);

        TestingMenu.setText("Testing");
        TestingMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TestingMenuActionPerformed(evt);
            }
        });
        IDSMenu.add(TestingMenu);

        jMenuItem1.setText("Patient");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        IDSMenu.add(jMenuItem1);

        jMenuItem2.setText("View Tree");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        IDSMenu.add(jMenuItem2);

        jMenuItem3.setText("Graph");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        IDSMenu.add(jMenuItem3);

        jMenuBar1.add(IDSMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginMenuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginMenuMouseClicked

    private void LoginMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginMenuActionPerformed
        // TODO add your handling code here:
        java.awt.Toolkit tk = java.awt.Toolkit.getDefaultToolkit();
        java.awt.Dimension screen = tk.getScreenSize();
        Login f = new Login();
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension Wsize = null;
        int x = screensize.width / 2;
        int y = screensize.height / 2;
        Wsize = f.getSize();
        f.setSize(Wsize.width, Wsize.height + 10);
        Wsize = f.getSize();
        f.setLocation((x - Wsize.width / 2), (y - Wsize.height / 2));
        jDesktopPane1.add(f, javax.swing.JDesktopPane.CENTER_ALIGNMENT);
        f.show();
    }//GEN-LAST:event_LoginMenuActionPerformed

    private void SystemMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SystemMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SystemMenuActionPerformed

    private void ExitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitMenuActionPerformed

    private void IDSMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDSMenuActionPerformed
        // TODO add your handling code here:
        java.awt.Toolkit tk = java.awt.Toolkit.getDefaultToolkit();
        java.awt.Dimension screen = tk.getScreenSize();
//        JFrame f = new AddNewUser();
//        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
//        Dimension Wsize = null;
//        int x = screensize.width / 2;
//        int y = screensize.height / 2;
//        Wsize = f.getSize();
//        f.setSize(Wsize.width, Wsize.height + 10);
//        Wsize = f.getSize();
//        f.setLocation((x - Wsize.width / 2), (y - Wsize.height / 2));
//        jDesktopPane1.add(f, javax.swing.JDesktopPane.CENTER_ALIGNMENT);
//        f.show();
    }//GEN-LAST:event_IDSMenuActionPerformed

    private void TrainingMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrainingMenuActionPerformed
        // TODO add your handling code here:
        java.awt.Toolkit tk = java.awt.Toolkit.getDefaultToolkit();
        java.awt.Dimension screen = tk.getScreenSize();
        Training f = new Training();
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension Wsize = null;
        int x = screensize.width / 2;
        int y = screensize.height / 2;
        Wsize = f.getSize();
        f.setSize(Wsize.width, Wsize.height + 10);
        Wsize = f.getSize();
        f.setLocation((x - Wsize.width / 2), (y - Wsize.height / 2));
        jDesktopPane1.add(f, javax.swing.JDesktopPane.CENTER_ALIGNMENT);
        f.show();
    }//GEN-LAST:event_TrainingMenuActionPerformed

    private void SystemMenuActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SystemMenuActionPerformed1
        // TODO add your handling code here:
    }//GEN-LAST:event_SystemMenuActionPerformed1

    private void LogoutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutMenuActionPerformed

    private void LogoutMenuActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutMenuActionPerformed1
        // TODO add your handling code here:
        IDSMenu.setEnabled(false);
        LoginMenu.setEnabled(true);
        ExitMenu.setEnabled(true);
        LogoutMenu.setEnabled(false);
    }//GEN-LAST:event_LogoutMenuActionPerformed1

    private void TestingMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TestingMenuActionPerformed
        // TODO add your handling code here:
        java.awt.Toolkit tk = java.awt.Toolkit.getDefaultToolkit();
        java.awt.Dimension screen = tk.getScreenSize();
        Testing f = new Testing();
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension Wsize = null;
        int x = screensize.width / 2;
        int y = screensize.height / 2;
        Wsize = f.getSize();
        f.setSize(Wsize.width, Wsize.height + 10);
        Wsize = f.getSize();
        f.setLocation((x - Wsize.width / 2), (y - Wsize.height / 2));
        jDesktopPane1.add(f, javax.swing.JDesktopPane.CENTER_ALIGNMENT);
        f.show();
    }//GEN-LAST:event_TestingMenuActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        java.awt.Toolkit tk = java.awt.Toolkit.getDefaultToolkit();
        java.awt.Dimension screen = tk.getScreenSize();
        JInternalFramePatient f = new JInternalFramePatient();
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension Wsize = null;
        int x = screensize.width / 2;
        int y = screensize.height / 2;
        Wsize = f.getSize();

        Wsize = f.getSize();
        f.setLocation((x - Wsize.width / 2), (y - Wsize.height / 2));
        jDesktopPane1.add(f, javax.swing.JDesktopPane.CENTER_ALIGNMENT);
        f.show();

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:

        JFrame frame = new JFrame();
        Container content = frame.getContentPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GrapTree c = new GrapTree();
        if (Training.obj.jComboBox1.getSelectedIndex() == 0) {
            c.buildTree(ID3Algo.datastr);
            //  ID3Algo.train(jComboBox2.getSelectedItem().toString(), 13);
        } else {
            String[] s1 = ESTreeAlgo.datastr.split("ExtendedSubtree");
            String[] s2 = new String[s1.length - 1];
            for (int i = 0; i < s2.length; i++) {
                s2[i] = String.valueOf(i + 1);
            }
            String no = (String) JOptionPane.showInputDialog(frame,
                    "Select Tree No?",
                    "Tree No.",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    s2,
                    s2[0]);
            c.buildTree1(ESTreeAlgo.datastr, Integer.parseInt(no));
            //ESTreeAlgo.train("id3.csv", 13);
        }

        content.add(new TreeLayoutDemoPT(c));
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        java.awt.Toolkit tk = java.awt.Toolkit.getDefaultToolkit();
        java.awt.Dimension screen = tk.getScreenSize();

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension Wsize = null;
        int x = screensize.width / 2;
        int y = screensize.height / 2;
        Wsize = frame.getSize();
        frame.setSize(Wsize.width, Wsize.height + 10);
        Wsize = frame.getSize();
        frame.setLocation((x - Wsize.width / 2), (y - Wsize.height / 2));
        //   jDesktopPane1.add(frame, javax.swing.JDesktopPane.CENTER_ALIGNMENT);
        frame.setVisible(true);
//        frame.setMaximizable(true);
//        frame.setClosable(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        java.awt.Toolkit tk = java.awt.Toolkit.getDefaultToolkit();
        java.awt.Dimension screen = tk.getScreenSize();
        Graph f = new Graph();
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension Wsize = null;
        int x = screensize.width / 2;
        int y = screensize.height / 2;
        Wsize = f.getSize();

        Wsize = f.getSize();
        f.setLocation((x - Wsize.width / 2), (y - Wsize.height / 2));
        jDesktopPane1.add(f, javax.swing.JDesktopPane.CENTER_ALIGNMENT);
        f.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    public static void main(String args[]) throws UnsupportedLookAndFeelException {

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();

        try {

            String[] lafs = {
                "de.javasoft.plaf.synthetica.SyntheticaClassyLookAndFeel",
                "de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel",
                "de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel",
                "de.javasoft.plaf.synthetica.SyntheticaWhiteVisionLookAndFeel",
                "de.javasoft.plaf.synthetica.SyntheticaSkyMetallicLookAndFeel",
                "de.javasoft.plaf.synthetica.SyntheticaMauveMetallicLookAndFeel",
                "de.javasoft.plaf.synthetica.SyntheticaOrangeMetallicLookAndFeel",
                "de.javasoft.plaf.synthetica.SyntheticaStandardLookAndFeel",
                "de.javasoft.plaf.synthetica.SyntheticaBlueSteelLookAndFeel",
                "de.javasoft.plaf.synthetica.SyntheticaBlueMoonLookAndFeel",
                "de.javasoft.plaf.synthetica.SyntheticaBlackMoonLookAndFeel",
                "de.javasoft.plaf.synthetica.SyntheticaSilverMoonLookAndFeel",
                "de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel",
                "de.javasoft.plaf.synthetica.SyntheticaGreenDreamLookAndFeel",
                "de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel",
                "javax.swing.plaf.metal.MetalLookAndFeel"};

            System.out.println(System.getProperty("user.dir"));
            String[] li = {"Licensee=Jyloo Software", "LicenseRegistrationNumber=------", "Product=Synthetica", "LicenseType=For internal tests only", "ExpireDate=--.--.----", "MaxVersion=2.999.999"};

            UIManager.put(
                    "Synthetica.license.info", li);
            UIManager.put(
                    "Synthetica.license.key", "E1CBD033-B07718A2-1E181B5F-A78A6DFF-813D8FB4");

            UIManager.setLookAndFeel(
                    lafs[4]);

            try {
                //mf.setBackground (new java.awt.Color (253, 153, 255));
            } catch (Exception x) {
                x.printStackTrace();
            }
        } catch (ClassNotFoundException ex) {
            // Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            //   Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            //  Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            // Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem ExitMenu;
    public javax.swing.JMenu IDSMenu;
    public javax.swing.JMenuItem LoginMenu;
    public javax.swing.JMenuItem LogoutMenu;
    private javax.swing.JMenu SystemMenu;
    private javax.swing.JMenuItem TestingMenu;
    private javax.swing.JMenuItem TrainingMenu;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    // End of variables declaration//GEN-END:variables
}
