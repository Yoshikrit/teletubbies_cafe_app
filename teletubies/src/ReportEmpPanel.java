

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import teletubies.database.DatabaseHandler;
import teletubies.model.EmployeeReport;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author Hall_PC
 */
public class ReportEmpPanel extends javax.swing.JPanel {

    /**
     * Creates new form ReportEmpPanel
     */
    public ReportEmpPanel() {
        initComponents();
        reportEmpGen();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reportEmpTitleLabel = new javax.swing.JLabel();
        CookingTableScrollPane = new javax.swing.JScrollPane();
        reportEmpTable = new javax.swing.JTable();
        printEmployeeButton = new javax.swing.JButton();
        searchBar = new javax.swing.JTextField();

        setLayout(null);

        reportEmpTitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        reportEmpTitleLabel.setText("Report_Employee");
        add(reportEmpTitleLabel);
        reportEmpTitleLabel.setBounds(440, 10, 420, 80);

        reportEmpTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "emp ID", "FirstName", "Lastname", "Phone Number", "Address", "Level of Work", "Login TimeStamp", "Logout TimeStamp"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reportEmpTable.setAlignmentX(-10.0F);
        reportEmpTable.setGridColor(new java.awt.Color(0, 102, 255));
        reportEmpTable.setRowHeight(40);
        reportEmpTable.setRowMargin(5);
        CookingTableScrollPane.setViewportView(reportEmpTable);

        add(CookingTableScrollPane);
        CookingTableScrollPane.setBounds(40, 110, 1180, 550);

        printEmployeeButton.setBackground(new java.awt.Color(204, 204, 204));
        printEmployeeButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        printEmployeeButton.setText("Print");
        printEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printEmployeeButtonActionPerformed(evt);
            }
        });
        add(printEmployeeButton);
        printEmployeeButton.setBounds(1050, 40, 170, 50);

        searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBarKeyReleased(evt);
            }
        });
        add(searchBar);
        searchBar.setBounds(50, 70, 290, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void printEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printEmployeeButtonActionPerformed
        String path = "./Report";
        
        Date date = new Date();
        SimpleDateFormat format= new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss",Locale.ENGLISH);
        SimpleDateFormat reportformat= new SimpleDateFormat("dd/MM/yyyy_hh/mm/ss",Locale.ENGLISH);
        
        String filepath = path + "/"+"ReportEmployee"+format.format(date) + ".pdf";
        
        String dochead = "Report Employee (" + reportformat.format(date) + ")";
        
        Document doc = new Document();
        try{
            PdfWriter.getInstance(doc, new FileOutputStream(filepath) );
            doc.open();
            
            Paragraph head = new Paragraph(dochead,FontFactory.getFont(FontFactory.TIMES_ROMAN,30, Font.BOLD, BaseColor.BLACK));
            head.setAlignment(Paragraph.ALIGN_CENTER);
            doc.add(head);
            
            doc.add(new Paragraph("\n"));
            
            PdfPTable tbl = new PdfPTable(8);

            //add header
            tbl.addCell("EmployeeID");
            tbl.addCell("FirstName");
            tbl.addCell("LastName");
            tbl.addCell("Phone Number");
            tbl.addCell("Address");
            tbl.addCell("Level of Work");
            tbl.addCell("Login Timestamp");
            tbl.addCell("Logout Timestamp");

            for(int i = 0 ; i < reportEmpTable.getRowCount() ; i++){
                String empid = reportEmpTable.getValueAt(i,0).toString();
                String firstname = reportEmpTable.getValueAt(i,1).toString();
                String lastname = reportEmpTable.getValueAt(i,2).toString();
                String phonenumber = reportEmpTable.getValueAt(i,3).toString();
                String address = reportEmpTable.getValueAt(i,4).toString();
                String worklevel = reportEmpTable.getValueAt(i,5).toString();
                String logintimestamp = reportEmpTable.getValueAt(i,6).toString();
                String logouttimestamp = reportEmpTable.getValueAt(i,7).toString();

                tbl.addCell(empid);
                tbl.addCell(firstname);
                tbl.addCell(lastname);
                tbl.addCell(phonenumber);
                tbl.addCell(address);
                tbl.addCell(worklevel);
                tbl.addCell(logintimestamp);
                tbl.addCell(logouttimestamp);

            }
            doc.add(tbl);
            JOptionPane.showMessageDialog(null , "Print Report Employee Success" , "ALERT MESSAGE" , JOptionPane.INFORMATION_MESSAGE);

        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(ReportSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(DocumentException ex){
            Logger.getLogger(ReportSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        doc.close();
        
        openReport(filepath);
    }//GEN-LAST:event_printEmployeeButtonActionPerformed
    
    public void openReport(String path){
        try{
            File file = new File(path);
            if(file.exists()){
                if(Desktop.isDesktopSupported()){
                    Desktop.getDesktop().open(file);
                }
                else{
                    JOptionPane.showMessageDialog(null , "Not Supported" , "ALERT MESSAGE" , JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null , "No Bill Exist" , "ALERT MESSAGE" , JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    private void searchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBarKeyReleased
        String search = searchBar.getText();
        DefaultTableModel empModel = (DefaultTableModel) reportEmpTable.getModel();
        empModel.setNumRows(0);
        if(!search.equals("") ){
            try {
                ArrayList<EmployeeReport> employeeReportDBs = DatabaseHandler.findFirstNameReportEmployeeOrderByIdASC(new DatabaseHandler(), search);
                int length = employeeReportDBs.size();
                if (length > 0) {
                    for (int i = 0; i < length; i++) {
                        empModel.addRow(new Object[]{employeeReportDBs.get(i).getEmployeeID(),
                            employeeReportDBs.get(i).getFirstName(),
                            employeeReportDBs.get(i).getLastName(),
                            employeeReportDBs.get(i).getPhoneNumber(),
                            employeeReportDBs.get(i).getAddress(),
                            employeeReportDBs.get(i).getEmployeelevel(),
                            employeeReportDBs.get(i).getDateLogIn(),
                            employeeReportDBs.get(i).getDateLogOut()});
                    }
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        else if(search.equals("")){
            reportEmpGen();
        }
    }//GEN-LAST:event_searchBarKeyReleased

    //Show report employee on gui
    public void reportEmpGen() {
        DefaultTableModel empModel = (DefaultTableModel) reportEmpTable.getModel();
        try {
            ArrayList<EmployeeReport> employeeReportDBs = DatabaseHandler.findAllReportEmployee(new DatabaseHandler());
            int length = employeeReportDBs.size();
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    empModel.addRow(new Object[]{employeeReportDBs.get(i).getEmployeeID(),
                        employeeReportDBs.get(i).getFirstName(),
                        employeeReportDBs.get(i).getLastName(),
                        employeeReportDBs.get(i).getPhoneNumber(),
                        employeeReportDBs.get(i).getAddress(),
                        employeeReportDBs.get(i).getEmployeelevel(),
                        employeeReportDBs.get(i).getDateLogIn(),
                        employeeReportDBs.get(i).getDateLogOut()});
                }
            }
        } catch (Exception e) {
            System.err.println("Error!");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane CookingTableScrollPane;
    private javax.swing.JButton printEmployeeButton;
    private javax.swing.JTable reportEmpTable;
    private javax.swing.JLabel reportEmpTitleLabel;
    private javax.swing.JTextField searchBar;
    // End of variables declaration//GEN-END:variables
}
