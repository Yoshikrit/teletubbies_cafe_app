
import javax.naming.spi.NamingManager;
import teletubies.Order;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Hall_PC
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        showWindow();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loginPanel1 = new LoginPanel();
        employeePanel1 = new EmployeePanel();
        managerPanel1 = new ManagerPanel();
        reportEmpPanel1 = new ReportEmpPanel();
        reportSale1 = new ReportSale();
        reportSaledaily1 = new ReportSaledaily();
        getOrder1 = new GetOrder();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Teletubbies Cafe");
        setResizable(false);

        jPanel1.setLayout(new java.awt.CardLayout());
        jPanel1.add(loginPanel1, "loginPage");
        jPanel1.add(employeePanel1, "empManagePage");
        jPanel1.add(managerPanel1, "managerPage");
        jPanel1.add(reportEmpPanel1, "reportEmpPage");
        jPanel1.add(reportSale1, "reportSalePage");
        jPanel1.add(reportSaledaily1, "reportSaleDailyPage");
        jPanel1.add(getOrder1, "orderPage");

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    private void showWindow(){
        kw = new KitchenWindow();
        kw.setVisible(true);
        
        qf = new QueueCustomerFrame();
        qf.setVisible(true);
        
        cp = new CustomerWindow();
        cp.setVisible(true);
    }
    
    public void setOrder(Order order){
//        JPanel kp = (JPanel) kw.getComponent(0);
//        kp.addOrder(order);
    }
    
    private CustomerWindow cp;
    private QueueCustomerFrame qf;
    private KitchenWindow kw;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private EmployeePanel employeePanel1;
    private GetOrder getOrder1;
    private javax.swing.JPanel jPanel1;
    private LoginPanel loginPanel1;
    private ManagerPanel managerPanel1;
    private ReportEmpPanel reportEmpPanel1;
    private ReportSale reportSale1;
    private ReportSaledaily reportSaledaily1;
    // End of variables declaration//GEN-END:variables
}