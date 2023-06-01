/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import ConnectDB.ConnectionDB;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import services.DayNhaService;
import services.TangService;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.ChiTietPhongHoc;
import models.CoSo;
import models.GiaoVien;
import services.ChiTietPhongService;
import services.CoSoService;
import services.GiaoVienService;
import services.PhongService;

/**
 *
 * @author Son
 */
public class DangKyPhong_Form extends javax.swing.JFrame {

    /**
     * Creates new form DangKyPhong_Form
     */
    DefaultTableModel tableModel;

    ArrayList<ChiTietPhongHoc> phongGiaoVienDaDangKi = new ArrayList<ChiTietPhongHoc>();

    public DangKyPhong_Form() throws SQLException {
        initComponents();
        showComboData();
        String MaND = DangNhap_Form.maNDHT;
//        String MaND = "005";
        tableModel = (DefaultTableModel) tblCTPhong.getModel();
        phongGiaoVienDaDangKi = ChiTietPhongService.getChiTietPhongTheoMaND(MaND);
        System.out.println("Ket qua 2: " + phongGiaoVienDaDangKi.size());

        for (int i = 0; i < phongGiaoVienDaDangKi.size(); i++) {
            tableModel.addRow(
                    new Object[]{
                        phongGiaoVienDaDangKi.get(i).getTenPhong(),
                        phongGiaoVienDaDangKi.get(i).getNgay(),
                        phongGiaoVienDaDangKi.get(i).getTietHocBatDau(),
                        phongGiaoVienDaDangKi.get(i).getTietHocKetThuc()
                    }
            );
        }
        
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/haui-logo.jpg"));
        setIconImage(image);
        this.getContentPane().setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
    }

    private void showComboData() throws SQLException {
        List<CoSo> dsCoSo = CoSoService.readAllCoSo();
        for (CoSo coSo : dsCoSo) {
            cboxCoSo.addItem(coSo.getMaCoSo());
        }
    }

    final static String DATE_FORMAT = "dd-MM-yyyy";

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCTPhong = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        cboxCoSo = new javax.swing.JComboBox<>();
        cboxToaNha = new javax.swing.JComboBox<>();
        cboxTang = new javax.swing.JComboBox<>();
        cboxPhong = new javax.swing.JComboBox<>();
        dateNgay = new com.toedter.calendar.JDateChooser();
        cboxTietBatDau = new javax.swing.JComboBox<>();
        cboxTietKetThuc = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnDangKy = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();

        jLabel4.setText("Cơ Sở");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng ký phòng học");

        tblCTPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblCTPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Phòng", "Ngày", "Tiết bắt đầu", "Tiết kết thúc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCTPhong.setRowHeight(32);
        tblCTPhong.setShowGrid(false);
        tblCTPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTPhongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCTPhong);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đăng kí phòng học", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        cboxCoSo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboxCoSo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxCoSoActionPerformed(evt);
            }
        });

        cboxToaNha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboxToaNha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxToaNhaActionPerformed(evt);
            }
        });

        cboxTang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboxTang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxTangActionPerformed(evt);
            }
        });

        cboxPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboxPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxPhongActionPerformed(evt);
            }
        });

        cboxTietBatDau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboxTietBatDau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" }));
        cboxTietBatDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxTietBatDauActionPerformed(evt);
            }
        });

        cboxTietKetThuc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboxTietKetThuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" }));
        cboxTietKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxTietKetThucActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Cơ Sở");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Dãy Nhà");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tầng");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Phòng");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Ngày");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Tiết bắt đầu:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Tiết kết thúc:");

        btnDangKy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDangKy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tick.png"))); // NOI18N
        btnDangKy.setText("Đăng Ký");
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete.png"))); // NOI18N
        jButton1.setText("Xóa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(51, 51, 51))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboxTietKetThuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboxTietBatDau, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateNgay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboxToaNha, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboxTang, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboxPhong, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboxCoSo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDangKy)))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxCoSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxToaNha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxTang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxTietBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxTietKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDangKy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btnHome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Home.png"))); // NOI18N
        btnHome.setText("Trang chủ");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnHome)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("Đăng Kí Phòng");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static boolean isDateValid(String date) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private void cboxToaNhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxToaNhaActionPerformed
        // TODO add your handling code here:
        try {
            String selectToaNha = cboxToaNha.getSelectedItem().toString();

            ArrayList<String> listTang = TangService.getTangFromMaDayNha(selectToaNha);

            cboxTang.removeAllItems();

            for (String i : listTang) {
                cboxTang.addItem(i.toString());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_cboxToaNhaActionPerformed

    private void cboxCoSoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxCoSoActionPerformed

        //String cboxCoSo.getSelectedItem());
        String selectCoSo = cboxCoSo.getSelectedItem().toString();

        ArrayList<String> listToaNha = DayNhaService.getDayNhaFromMaCoSo(selectCoSo);

        cboxToaNha.removeAllItems();
        for (String i : listToaNha) {
            cboxToaNha.addItem(i.toString());
        }
    }//GEN-LAST:event_cboxCoSoActionPerformed

    private void cboxTangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxTangActionPerformed

        try {
            // TODO add your handling code here:
            String selectTang = cboxTang.getSelectedItem().toString();
            //System.out.println("hehe" + selectTang);

            ArrayList<String> listPhong = PhongService.getTenPhongFromTenTang(selectTang);

            cboxPhong.removeAllItems();

            for (String i : listPhong) {
                cboxPhong.addItem(i.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_cboxTangActionPerformed

    private void cboxPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxPhongActionPerformed
        // TODO add your handling code here:\


    }//GEN-LAST:event_cboxPhongActionPerformed

    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed
        // TODO add your handling code here:

        String sqlSelectUser = "insert into chitietphonghoc (maPhong, maND, ngay, tietHocBatDau,tietHocKetThuc) values ( ?, ? ,? ,? ,?)";

        java.sql.Connection conn = null;
        try {
            String MaND = DangNhap_Form.maNDHT;
//            String MaND = "005";
            String MaPhong = PhongService.getMaPhongFromTenPhong(cboxPhong.getSelectedItem().toString());
            String TenPhong = cboxPhong.getSelectedItem().toString();
            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
            
            // kiem tra ngay khong duoc de trong
            if(dateNgay.getDate() == null) {
                throw  new Exception("Ngày không được để trống");
            }
            String ngay = dt1.format(dateNgay.getDate());
            int tietBatDau = Integer.parseInt(cboxTietBatDau.getSelectedItem().toString());
            int tietKetThuc = Integer.parseInt(cboxTietKetThuc.getSelectedItem().toString());

            ArrayList<Integer> listTietBatDau = ChiTietPhongService.getTietBatDau(MaPhong, ngay);
            ArrayList<Integer> listTietKetThuc = ChiTietPhongService.getTietKetThuc(MaPhong, ngay);
            
            

            // kiem tra xem tiet do da dang ki hay chua
            if (tietBatDau >= tietKetThuc) {
                throw new Exception(" Tiết bắt đầu phải bé hơn tiết kết thúc");
            }
            for (int i = 0; i < listTietBatDau.size(); i++) {
                if (tietBatDau > listTietKetThuc.get(i) || tietKetThuc < listTietBatDau.get(i)) {
                    continue;
                } else {
                    throw new Exception("Đăng kí không thành công, Đã có lịch học ở tiết này");
                }
            }

            java.sql.Connection connectDB = ConnectionDB.ConnectionDB();

            PreparedStatement preparedStatement = connectDB.prepareStatement(sqlSelectUser);

            preparedStatement.setString(1, MaPhong);
            preparedStatement.setString(2, MaND);
            preparedStatement.setString(3, ngay);
            preparedStatement.setInt(4, tietBatDau);
            preparedStatement.setInt(5, tietKetThuc);
            preparedStatement.execute();

            tableModel.addRow(
                    new Object[]{
                        TenPhong, ngay, tietBatDau, tietKetThuc
                    }
            );

            JOptionPane.showMessageDialog(rootPane, "Đăng Kí Thành Công");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }


    }//GEN-LAST:event_btnDangKyActionPerformed

    private void cboxTietBatDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxTietBatDauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxTietBatDauActionPerformed

    private void cboxTietKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxTietKetThucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxTietKetThucActionPerformed

    private void tblCTPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTPhongMouseClicked
        // TODO add your handling code here:
//        int row = tblCTPhong.getSelectedRow();
//        String tenPhong = tblCTPhong.getValueAt(row, 0).toString();
//        String ngay = tblCTPhong.getValueAt(row, 1).toString();
//        int tietBatDau = (int) tblCTPhong.getValueAt(row, 2);
//        int tietKetThuc = (int) tblCTPhong.getValueAt(row, 2);
//        
//        System.out.println("ngay " + ngay); 


    }//GEN-LAST:event_tblCTPhongMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int kq = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xoá không?", "Xác nhận xoá", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (kq == JOptionPane.YES_OPTION) {
            int row = tblCTPhong.getSelectedRow();
            String tenPhong = tableModel.getValueAt(row, 0).toString();
            String maPhong = PhongService.getMaPhongFromTenPhong(tenPhong);
            String ngay = tableModel.getValueAt(row, 1).toString();
            int tietBatDau = (int) tableModel.getValueAt(row, 2);
            int tietKetThuc = (int) tableModel.getValueAt(row, 3);

            System.out.println("ngay " + ngay + " " + tietBatDau + " " + tietKetThuc + "maPhong " + maPhong);
            ChiTietPhongService.xoaChiTietPhong(maPhong, ngay, tietBatDau, tietKetThuc);

            tableModel.removeRow(row);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        MenuGiangVien_Form giangVienMenu = new MenuGiangVien_Form();
        this.dispose();
        giangVienMenu.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

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
            java.util.logging.Logger.getLogger(DangKyPhong_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangKyPhong_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangKyPhong_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangKyPhong_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DangKyPhong_Form().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(DangKyPhong_Form.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangKy;
    private javax.swing.JButton btnHome;
    private javax.swing.JComboBox<String> cboxCoSo;
    private javax.swing.JComboBox<String> cboxPhong;
    private javax.swing.JComboBox<String> cboxTang;
    private javax.swing.JComboBox<String> cboxTietBatDau;
    private javax.swing.JComboBox<String> cboxTietKetThuc;
    private javax.swing.JComboBox<String> cboxToaNha;
    private com.toedter.calendar.JDateChooser dateNgay;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable tblCTPhong;
    // End of variables declaration//GEN-END:variables
}
