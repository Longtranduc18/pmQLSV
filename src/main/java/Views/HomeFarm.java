/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DAO.ChienDichCDDAO;
import DAO.ChienDichDAO;
import DAO.ChuyenNganhDAO;
import DAO.DanhGia1D3DAO;
import DAO.DanhGiaENDAO;
import DAO.DanhGiaHPDAO;
import DAO.DanhGiaVHDAO;
import DAO.DropListCTDAO;
import DAO.DropListDAO;
import DAO.HocKiDAO;
import DAO.LichSuChamSOC1D3DAO;
import DAO.LichSuChamSOCHPDAO;
import DAO.LichSuChamSocENDAO;
import DAO.LichSuChamSocVHDAO;
import DAO.NhanSuDAO;
import DAO.PhanCongDAO;
import DAO.SinhVienDAO;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.persistence.TypedQuery;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.ChamSocTamThoi;
import model.ChienDich;
import model.ChienDichCD;
import model.ChuyenNganh;

import model.DanhGia1D3;
import model.DanhGiaEN;
import model.DanhGiaHP;
import model.DanhGiaVH;
import model.DropList;
import model.DropListCT;
import model.HocKi;
import model.LichSuChamSoc1D3;
import model.LichSuChamSocEN;
import model.LichSuChamSocHP;
import model.LichSuChamSocVH;
import model.NhanSu;
import model.PhanCong;
import model.SinhVien;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.Auth;
import util.CampaignTableRenderer;
import util.ExportToExcel;
import util.HibernateUtil;
import util.MsgBox;
import util.TienIch;

/**
 *
 * @author ASUS
 */
// Ngày 19/4/2023
public class HomeFarm extends javax.swing.JFrame {

    /**
     * Creates new form HomeFarm
     */
    public HomeFarm() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("IOCare - Hệ thống chăm sóc");
        // Tao icon cho Jfram va cac Jdialog
        setIcon();
        listModelDSIP = new DefaultListModel();
        JListDanhSachIP.setModel(listModelDSIP);
        JListDanhSachIP.setCellRenderer(new MyListRenderer());
        modelDSNS = (DefaultTableModel) tblDanhSachNS.getModel();
        tblDanhSachNS.setModel(modelDSNS);
        modelNS_PC_CN = (DefaultTableModel) tblNsPhuTrachCN.getModel();
        tblNsPhuTrachCN.setModel(modelNS_PC_CN);
        modelSvCanCS = (DefaultTableModel) jtbSVCanCS.getModel();
        jtbSVCanCS.setModel(modelSvCanCS);
        jtbSVCanCS.setDefaultRenderer(Object.class, new RenderTablaPrestamos());
        modelSvCanC = (DefaultTableModel) jtbCSDT.getModel();
        jtbCSDT.setModel(modelSvCanC);
        CampaignTableRenderer renderer = new CampaignTableRenderer();
        jtbCSDT.getColumnModel().getColumn(0).setCellRenderer(renderer);
        modelLichSuCSCN = (DefaultTableModel) jtbLichSuCS.getModel();
        jtbLichSuCS.setModel(modelLichSuCSCN);
        modelLichSuCS = (DefaultTableModel) jtb_home_lichSuCs.getModel();
        jtb_home_lichSuCs.setModel(modelLichSuCS);
        jtb_home_lichSuCs.setDefaultRenderer(Object.class, new RenderTablaPrestamos());
        model_qlcd_doiPhanCong = (DefaultTableModel) jtb_qlcd_chuaPC.getModel();
        jtb_qlcd_chuaPC.setModel(model_qlcd_doiPhanCong);
        jtb_qlcd_chuaPC.setDefaultRenderer(Object.class, new RenderTablaPrestamos());
        modelPhanCong = (DefaultTableModel) Jtable_PhanCongRoi.getModel();
        Jtable_PhanCongRoi.setModel(modelPhanCong);
        Jtable_PhanCongRoi.setDefaultRenderer(Object.class, new RenderTablaPrestamos());
        modelDropList = (DefaultTableModel) jtb_DropList.getModel();
        jtb_DropList.setModel(modelDropList);
        jProgressBar1.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dalImportData = new javax.swing.JDialog();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        txtLinkFileData = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        cboChonHocKi = new javax.swing.JComboBox<>();
        jLabel63 = new javax.swing.JLabel();
        cboChienDich = new javax.swing.JComboBox<>();
        jLabel64 = new javax.swing.JLabel();
        txtTenChienDichChuDong = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jlb_importData_Enroll = new javax.swing.JLabel();
        jlb_enroll_import = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        txtLinkFileHistory = new javax.swing.JTextField();
        jButton25 = new javax.swing.JButton();
        jLabel96 = new javax.swing.JLabel();
        cboHistory = new javax.swing.JComboBox<>();
        jLabel98 = new javax.swing.JLabel();
        jButton26 = new javax.swing.JButton();
        dalTaoHocKi = new javax.swing.JDialog();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        txtTenHocKi = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        dcsBatDauHK = new com.toedter.calendar.JDateChooser();
        dcsKetThucHocKi = new com.toedter.calendar.JDateChooser();
        jButton12 = new javax.swing.JButton();
        txtMaHocKi = new javax.swing.JTextField();
        DialogExportCSVH = new javax.swing.JDialog();
        jPanelListChk = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        btnSelectAll = new javax.swing.JButton();
        jdlImportHP_BL = new javax.swing.JDialog();
        jLabel29 = new javax.swing.JLabel();
        txt_import_HP_BL = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        cbo_Import_HPBL = new javax.swing.JComboBox<>();
        btn_Import_HpBl = new javax.swing.JButton();
        jlb_enroll_ImportHPBL = new javax.swing.JLabel();
        jdlQuanLyNhanSu = new javax.swing.JDialog();
        cboTatCaNS = new javax.swing.JRadioButton();
        cboNhanSuOn = new javax.swing.JRadioButton();
        cboNhanSuOff = new javax.swing.JRadioButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblDanhSachNS = new javax.swing.JTable();
        txtMaNS = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        txtTenNhanSu = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        cboNhanSuNam = new javax.swing.JRadioButton();
        cboNhanSuNu = new javax.swing.JRadioButton();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        rdoAdmin = new javax.swing.JRadioButton();
        rdoTrangThaiOn = new javax.swing.JRadioButton();
        rdoTrangThaiOff = new javax.swing.JRadioButton();
        rdoUser1 = new javax.swing.JRadioButton();
        jLabel77 = new javax.swing.JLabel();
        txtEmailNS = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblNsPhuTrachCN = new javax.swing.JTable();
        jLabel78 = new javax.swing.JLabel();
        btnLuuTTNS = new javax.swing.JButton();
        btnLuuTTNS1 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        rdoUser2 = new javax.swing.JRadioButton();
        DialogPhanCong = new javax.swing.JDialog();
        cbbChienDich = new javax.swing.JComboBox<>();
        jButton13 = new javax.swing.JButton();
        cbbChuyenNganh = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        DialogChuyenSV = new javax.swing.JDialog();
        jLabel39 = new javax.swing.JLabel();
        cbbChuyenDoiPC = new javax.swing.JComboBox<>();
        btnXacNhan = new javax.swing.JButton();
        lblTongSV = new javax.swing.JLabel();
        JmenuTongSvChon = new javax.swing.JMenuItem();
        jMenuDeleteObj = new javax.swing.JMenuItem();
        jdlChamSocDongThoi = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        txt_jdlCSDT_LoaiCD = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        txt_jdl_csdt_TgTao = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        txt_jdl_CSDT_DienGiaiCT = new javax.swing.JTextArea();
        jLabel46 = new javax.swing.JLabel();
        cbo_jdl_csdt_dt = new javax.swing.JComboBox<>();
        jLabel48 = new javax.swing.JLabel();
        cbo_jdl_csdt_plnc = new javax.swing.JComboBox<>();
        jLabel82 = new javax.swing.JLabel();
        cbo_jdl_csdt_ldgn = new javax.swing.JComboBox<>();
        jLabel83 = new javax.swing.JLabel();
        cbo_jdl_csdt_nvsv = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        txt_jdl_csdt_HocPhi = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        txt_jdl_csdt_tthp = new javax.swing.JLabel();
        txt_jdl_csdt_ttbl = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jcb_csdt = new javax.swing.JCheckBox();
        jdlImportSV = new javax.swing.JDialog();
        jLabel10 = new javax.swing.JLabel();
        txtLinkFileImportSV = new javax.swing.JTextField();
        jButton21 = new javax.swing.JButton();
        cboThayThe = new javax.swing.JRadioButton();
        jButton22 = new javax.swing.JButton();
        jlb_enroll_importSV = new javax.swing.JLabel();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jdlThongTinCaNhan = new javax.swing.JDialog();
        jLabel11 = new javax.swing.JLabel();
        jlb_ttcn_Mans = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_ttcn_Hoten = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_ttcn_matKhau = new javax.swing.JPasswordField();
        jButton24 = new javax.swing.JButton();
        Jmenu_dsip_an = new javax.swing.JMenuItem();
        Jmenu_dsip_xoa = new javax.swing.JMenuItem();
        Jmn_ChuyenSv = new javax.swing.JMenuItem();
        jdl_editLSCS = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        cbo_edit_nvsv = new javax.swing.JComboBox<>();
        cbo_edit_ldgn = new javax.swing.JComboBox<>();
        cbo_edit_dt = new javax.swing.JComboBox<>();
        cbo_edit_plnc = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        btn_edit_luu = new javax.swing.JButton();
        txt_edit_dgct = new javax.swing.JTextField();
        txt_edit_Loaicd = new javax.swing.JLabel();
        txt_edit_mssv = new javax.swing.JLabel();
        jdl_ThemDG = new javax.swing.JDialog();
        jLabel42 = new javax.swing.JLabel();
        jlb_loaiDopList = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        txt_themMoiDG = new javax.swing.JTextField();
        jButton18 = new javax.swing.JButton();
        jdl_quanLyDl = new javax.swing.JDialog();
        jLabel65 = new javax.swing.JLabel();
        cbo_TieuChi = new javax.swing.JComboBox<>();
        jLabel85 = new javax.swing.JLabel();
        jlb_maLoaiDl = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jLabel89 = new javax.swing.JLabel();
        cbo_ChienDichDL = new javax.swing.JComboBox<>();
        jScrollPane11 = new javax.swing.JScrollPane();
        jtb_DropList = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_noiDungDl = new javax.swing.JTextArea();
        jButton28 = new javax.swing.JButton();
        txt_editDropList_enroll = new javax.swing.JLabel();
        JpmViewCt = new javax.swing.JPopupMenu();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jpnViewct = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        txt_viewCT = new javax.swing.JTextArea();
        jDialog1 = new javax.swing.JDialog();
        txtLinkExport = new javax.swing.JTextField();
        jButton27 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        JtpHome = new javax.swing.JTabbedPane();
        jpnChamSocSV = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jlb_CSSV_ChuaCS = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbo_Cs_ChienDich = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jdc_qlcd_firstDay = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jdc_qlcd_endDay = new com.toedter.calendar.JDateChooser();
        jButton7 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtCSSV_MSSV = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt_CSSV_KiHoc = new javax.swing.JLabel();
        txt_CSSV_ChuyenNganh = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txt_CSSV_HoTen = new javax.swing.JLabel();
        txt_CSSV_TrangThai = new javax.swing.JLabel();
        txt_CSSV_NX = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jlb_cs_monHoc = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        txt_CSSV_HocPhi = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txt_CSSV_TrangThaiHP = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txt_CSSV_TrangThaiBL = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        cboPhanLoaiNguyCo = new javax.swing.JComboBox<>();
        cboNguyenVongCuaSV = new javax.swing.JComboBox<>();
        jLabel57 = new javax.swing.JLabel();
        cboLyDoNghiNhan = new javax.swing.JComboBox<>();
        jLabel58 = new javax.swing.JLabel();
        cboDoiTuong = new javax.swing.JComboBox<>();
        jLabel59 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtDienGiaiCT = new javax.swing.JTextArea();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        btn_LuaCS = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbCSDT = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtbLichSuCS = new javax.swing.JTable();
        btn_themldgn = new javax.swing.JButton();
        btn_themNvsv = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        jtbSVCanCS = new javax.swing.JTable();
        jpnQuanLyCD = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jpnDanhSachIP = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton3 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton4 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton5 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jButton14 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        JListDanhSachIP = new javax.swing.JList<>();
        jpnQuanLyChienDich_Content = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jlb_qlcd_tong = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        cbo_qLcd_hocKi = new javax.swing.JComboBox<>();
        jlb_qlcd_ChuaCS = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jlb_qlcd_Dacs = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        cbo_qlcd_chienDich = new javax.swing.JComboBox<>();
        jLabel49 = new javax.swing.JLabel();
        cbo_qlcd_chuyenNganh = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        cbo_qlcd_NhanSu = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        txt_qlcd_mssv = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jdc_qlcd_tuNgay = new com.toedter.calendar.JDateChooser();
        jLabel81 = new javax.swing.JLabel();
        jdc_qlcd_denNgay = new com.toedter.calendar.JDateChooser();
        btn_qlcd_Tim = new javax.swing.JButton();
        jtp_qlcd_daPC = new javax.swing.JTabbedPane();
        jpnSvCho = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        Jtable_PhanCongRoi = new javax.swing.JTable();
        jpnCSVH = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtb_qlcd_chuaPC = new javax.swing.JTable();
        jpnHome = new javax.swing.JPanel();
        jpnHomContent = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_home_lichSuCs = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_Home_mssv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbo_home_HocKy = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbo_Home_ChienDich = new javax.swing.JComboBox<>();
        cbo_Home_NhanSu = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jdc_Home_tuNgay = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jdc_home_denNgay = new com.toedter.calendar.JDateChooser();
        btn_Home_TraCuuTheoNgay = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_home_tongData = new javax.swing.JLabel();
        jButton23 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txt_Home_Mans = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        txt_taiData = new javax.swing.JLabel();
        JmbMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mni_qlttcn = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        dalImportData.setModal(true);
        dalImportData.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                dalImportDataComponentResized(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                dalImportDataComponentShown(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel56.setText("Link file:");

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/folder.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel62.setText("Chọn học kì:");

        cboChonHocKi.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel63.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel63.setText("Chọn chiến dịch:");

        cboChienDich.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboChienDich.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chăm sóc vắng học", "Chăm sóc học phí", "Chăm sóc 1/3 block", "Chăm sóc tiếng Anh" }));

        jLabel64.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel64.setText("Tên chiến dịch chủ động:");

        jButton9.setText("Import");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jlb_importData_Enroll.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlb_importData_Enroll.setForeground(new java.awt.Color(255, 51, 51));
        jlb_importData_Enroll.setText("Chú ý: Tên không chứa dấu và các kí tự đặc biệt!");

        jlb_enroll_import.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlb_enroll_import.setForeground(new java.awt.Color(255, 0, 51));
        jlb_enroll_import.setText(" ");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlb_enroll_import, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb_importData_Enroll)
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                            .addComponent(jLabel62)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cboChonHocKi, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                            .addComponent(jLabel63)
                                            .addGap(18, 18, 18)
                                            .addComponent(cboChienDich, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel64)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTenChienDichChuDong, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLinkFileData, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 73, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jlb_enroll_import)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtLinkFileData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel56))
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(cboChonHocKi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(cboChienDich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(txtTenChienDichChuDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_importData_Enroll)
                    .addComponent(jButton9))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("New data", jPanel10);

        jLabel79.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel79.setText("Link file:");

        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/folder.png"))); // NOI18N
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jLabel96.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel96.setText("Chọn chiến dịch:");

        cboHistory.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboHistory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chăm sóc vắng học", "Chăm sóc học phí", "Chăm sóc 1/3 block" }));

        jLabel98.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 51, 51));
        jLabel98.setText("Chú ý: Mẫu file import phải trùng khớp với mẫu Export");

        jButton26.setText("Import");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addComponent(jLabel79)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtLinkFileHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addComponent(jLabel96)
                            .addGap(18, 18, 18)
                            .addComponent(cboHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel79)
                        .addComponent(txtLinkFileHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel96)
                    .addComponent(cboHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel98)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jButton26)
                .addGap(64, 64, 64))
        );

        jTabbedPane1.addTab("History", jPanel11);

        javax.swing.GroupLayout dalImportDataLayout = new javax.swing.GroupLayout(dalImportData.getContentPane());
        dalImportData.getContentPane().setLayout(dalImportDataLayout);
        dalImportDataLayout.setHorizontalGroup(
            dalImportDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        dalImportDataLayout.setVerticalGroup(
            dalImportDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dalImportDataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        dalTaoHocKi.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                dalTaoHocKiComponentShown(evt);
            }
        });

        jLabel66.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel66.setText("Mã học kì:");

        jLabel67.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel67.setText("Chú ý: mã học kì chứa tối đa 50 ký tự không bao gồm ký tự có dấu và các kí tự đặc biệt");

        jLabel68.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel68.setText("Tên học kì:");

        txtTenHocKi.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel69.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 51, 51));
        jLabel69.setText("Chứa tôi đa 255 ký tự");

        jLabel70.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel70.setText("Thời gian bắt đầu:");

        jLabel71.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel71.setText("Thời gian kết thúc:");

        dcsBatDauHK.setDateFormatString("yyyy-MM-dd");
        dcsBatDauHK.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        dcsKetThucHocKi.setDateFormatString("yyyy-MM-dd");
        dcsKetThucHocKi.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jButton12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton12.setText("Tạo");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        txtMaHocKi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout dalTaoHocKiLayout = new javax.swing.GroupLayout(dalTaoHocKi.getContentPane());
        dalTaoHocKi.getContentPane().setLayout(dalTaoHocKiLayout);
        dalTaoHocKiLayout.setHorizontalGroup(
            dalTaoHocKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dalTaoHocKiLayout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(txtMaHocKi, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(298, 298, 298))
            .addGroup(dalTaoHocKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dalTaoHocKiLayout.createSequentialGroup()
                    .addGroup(dalTaoHocKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dalTaoHocKiLayout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addGroup(dalTaoHocKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel69)
                                .addGroup(dalTaoHocKiLayout.createSequentialGroup()
                                    .addComponent(jLabel68)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtTenHocKi, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel67)
                                .addComponent(jLabel66)
                                .addGroup(dalTaoHocKiLayout.createSequentialGroup()
                                    .addGroup(dalTaoHocKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dalTaoHocKiLayout.createSequentialGroup()
                                            .addComponent(jLabel70)
                                            .addGap(18, 18, 18))
                                        .addGroup(dalTaoHocKiLayout.createSequentialGroup()
                                            .addComponent(jLabel71)
                                            .addGap(16, 16, 16)))
                                    .addGroup(dalTaoHocKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(dcsBatDauHK, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                        .addComponent(dcsKetThucHocKi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGroup(dalTaoHocKiLayout.createSequentialGroup()
                            .addGap(388, 388, 388)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(31, Short.MAX_VALUE)))
        );
        dalTaoHocKiLayout.setVerticalGroup(
            dalTaoHocKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dalTaoHocKiLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(txtMaHocKi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
            .addGroup(dalTaoHocKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dalTaoHocKiLayout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(jLabel66)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel67)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(dalTaoHocKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel68)
                        .addComponent(txtTenHocKi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel69)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(dalTaoHocKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel70)
                        .addComponent(dcsBatDauHK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(dalTaoHocKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel71)
                        .addComponent(dcsKetThucHocKi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12)
                    .addGap(40, 40, 40)))
        );

        DialogExportCSVH.setModal(true);

        jPanelListChk.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanelListChk.setPreferredSize(new java.awt.Dimension(284, 724));
        jPanelListChk.setLayout(null);

        jButton15.setFont(new java.awt.Font(".VnArial", 0, 14)); // NOI18N
        jButton15.setText("Export");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font(".VnArial", 0, 14)); // NOI18N
        jButton11.setText("DeSelect");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        btnSelectAll.setFont(new java.awt.Font(".VnArial", 0, 14)); // NOI18N
        btnSelectAll.setText("SelectAll");
        btnSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelectAll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnSelectAll, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout DialogExportCSVHLayout = new javax.swing.GroupLayout(DialogExportCSVH.getContentPane());
        DialogExportCSVH.getContentPane().setLayout(DialogExportCSVHLayout);
        DialogExportCSVHLayout.setHorizontalGroup(
            DialogExportCSVHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogExportCSVHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelListChk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DialogExportCSVHLayout.setVerticalGroup(
            DialogExportCSVHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogExportCSVHLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DialogExportCSVHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(DialogExportCSVHLayout.createSequentialGroup()
                        .addComponent(jPanelListChk, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel29.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel29.setText("Chọn file:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/folder.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel33.setText("Chọn loại (Học phí / Bảo lưu):");

        cbo_Import_HPBL.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbo_Import_HPBL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Học phí", "Bảo lưu", "Rút học phí" }));

        btn_Import_HpBl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_Import_HpBl.setText("Import");
        btn_Import_HpBl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Import_HpBlActionPerformed(evt);
            }
        });

        jlb_enroll_ImportHPBL.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlb_enroll_ImportHPBL.setForeground(new java.awt.Color(255, 0, 51));
        jlb_enroll_ImportHPBL.setText(" ");

        javax.swing.GroupLayout jdlImportHP_BLLayout = new javax.swing.GroupLayout(jdlImportHP_BL.getContentPane());
        jdlImportHP_BL.getContentPane().setLayout(jdlImportHP_BLLayout);
        jdlImportHP_BLLayout.setHorizontalGroup(
            jdlImportHP_BLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdlImportHP_BLLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdlImportHP_BLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlb_enroll_ImportHPBL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jdlImportHP_BLLayout.createSequentialGroup()
                        .addGroup(jdlImportHP_BLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jdlImportHP_BLLayout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_import_HP_BL, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1))
                            .addGroup(jdlImportHP_BLLayout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addGap(18, 18, 18)
                                .addComponent(cbo_Import_HPBL, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdlImportHP_BLLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Import_HpBl)
                .addGap(32, 32, 32))
        );
        jdlImportHP_BLLayout.setVerticalGroup(
            jdlImportHP_BLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdlImportHP_BLLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_enroll_ImportHPBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jdlImportHP_BLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jdlImportHP_BLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(txt_import_HP_BL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jdlImportHP_BLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(cbo_Import_HPBL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btn_Import_HpBl)
                .addGap(21, 21, 21))
        );

        buttonGroup1.add(cboTatCaNS);
        cboTatCaNS.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboTatCaNS.setText("Tất cả");
        cboTatCaNS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTatCaNSActionPerformed(evt);
            }
        });

        buttonGroup1.add(cboNhanSuOn);
        cboNhanSuOn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboNhanSuOn.setText("On");
        cboNhanSuOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNhanSuOnActionPerformed(evt);
            }
        });

        buttonGroup1.add(cboNhanSuOff);
        cboNhanSuOff.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboNhanSuOff.setText("OFF");
        cboNhanSuOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNhanSuOffActionPerformed(evt);
            }
        });

        tblDanhSachNS.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblDanhSachNS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MNS", "Họ và tên", "Trạng thái"
            }
        ));
        tblDanhSachNS.setRowHeight(20);
        tblDanhSachNS.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblDanhSachNS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachNSMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblDanhSachNS);

        jLabel72.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel72.setText("Mã nhân sự:");

        jLabel73.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel73.setText("Tên nhân sự:");

        jLabel74.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel74.setText("Giới tính:");

        buttonGroup4.add(cboNhanSuNam);
        cboNhanSuNam.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboNhanSuNam.setText("Nam");

        buttonGroup4.add(cboNhanSuNu);
        cboNhanSuNu.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboNhanSuNu.setText("Nữ");

        jLabel75.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel75.setText("Trạng thái:");

        jLabel76.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel76.setText("Vai trò:");

        buttonGroup3.add(rdoAdmin);
        rdoAdmin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rdoAdmin.setText("Admin");

        buttonGroup2.add(rdoTrangThaiOn);
        rdoTrangThaiOn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rdoTrangThaiOn.setText("On");

        buttonGroup2.add(rdoTrangThaiOff);
        rdoTrangThaiOff.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rdoTrangThaiOff.setText("Off");

        buttonGroup3.add(rdoUser1);
        rdoUser1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rdoUser1.setText("User1");
        rdoUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoUser1ActionPerformed(evt);
            }
        });

        jLabel77.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel77.setText("Email:");

        tblNsPhuTrachCN.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblNsPhuTrachCN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã chuyên ngành", "Mã chiến dịch"
            }
        ));
        tblNsPhuTrachCN.setRowHeight(20);
        tblNsPhuTrachCN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNsPhuTrachCNMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblNsPhuTrachCN);

        jLabel78.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel78.setText("Chú ý: Nhân sự chưa tồn tại khi lưu sẻ tạo mới");

        btnLuuTTNS.setText("Lưu");
        btnLuuTTNS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuTTNSActionPerformed(evt);
            }
        });

        btnLuuTTNS1.setText("Làm mới");
        btnLuuTTNS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuTTNS1ActionPerformed(evt);
            }
        });

        jButton16.setText("Phân công");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("Xoá");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        buttonGroup3.add(rdoUser2);
        rdoUser2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rdoUser2.setText("User2");
        rdoUser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoUser2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jdlQuanLyNhanSuLayout = new javax.swing.GroupLayout(jdlQuanLyNhanSu.getContentPane());
        jdlQuanLyNhanSu.getContentPane().setLayout(jdlQuanLyNhanSuLayout);
        jdlQuanLyNhanSuLayout.setHorizontalGroup(
            jdlQuanLyNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdlQuanLyNhanSuLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jdlQuanLyNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdlQuanLyNhanSuLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(cboTatCaNS)
                        .addGap(18, 18, 18)
                        .addComponent(cboNhanSuOn)
                        .addGap(34, 34, 34)
                        .addComponent(cboNhanSuOff)
                        .addGap(759, 759, 759))
                    .addGroup(jdlQuanLyNhanSuLayout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jdlQuanLyNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jdlQuanLyNhanSuLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jdlQuanLyNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jdlQuanLyNhanSuLayout.createSequentialGroup()
                                        .addGroup(jdlQuanLyNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jdlQuanLyNhanSuLayout.createSequentialGroup()
                                                .addComponent(jLabel74)
                                                .addGap(38, 38, 38)
                                                .addComponent(cboNhanSuNam)
                                                .addGap(18, 18, 18)
                                                .addComponent(cboNhanSuNu))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jdlQuanLyNhanSuLayout.createSequentialGroup()
                                                .addComponent(jLabel77)
                                                .addGap(59, 59, 59)
                                                .addComponent(txtEmailNS, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jdlQuanLyNhanSuLayout.createSequentialGroup()
                                        .addGroup(jdlQuanLyNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel73)
                                            .addComponent(jLabel72))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jdlQuanLyNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTenNhanSu, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                            .addComponent(txtMaNS))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jdlQuanLyNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel75)
                                            .addComponent(jLabel76))
                                        .addGap(18, 18, 18)
                                        .addGroup(jdlQuanLyNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rdoTrangThaiOn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rdoAdmin))
                                        .addGap(14, 14, 14)))
                                .addGroup(jdlQuanLyNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rdoUser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rdoTrangThaiOff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rdoUser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(33, 33, 33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdlQuanLyNhanSuLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jdlQuanLyNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jdlQuanLyNhanSuLayout.createSequentialGroup()
                                        .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnLuuTTNS, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLuuTTNS1))
                                    .addGroup(jdlQuanLyNhanSuLayout.createSequentialGroup()
                                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jdlQuanLyNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(64, 64, 64))))))
        );
        jdlQuanLyNhanSuLayout.setVerticalGroup(
            jdlQuanLyNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdlQuanLyNhanSuLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jdlQuanLyNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jdlQuanLyNhanSuLayout.createSequentialGroup()
                        .addGroup(jdlQuanLyNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jdlQuanLyNhanSuLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jdlQuanLyNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel72)
                                    .addComponent(jLabel75)
                                    .addComponent(rdoTrangThaiOn)
                                    .addComponent(rdoTrangThaiOff)))
                            .addComponent(txtMaNS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jdlQuanLyNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel73)
                            .addComponent(txtTenNhanSu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel76)
                            .addComponent(rdoAdmin)
                            .addComponent(rdoUser1))
                        .addGap(18, 18, 18)
                        .addGroup(jdlQuanLyNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel74)
                            .addComponent(cboNhanSuNam)
                            .addComponent(cboNhanSuNu)
                            .addComponent(rdoUser2))
                        .addGap(18, 18, 18)
                        .addGroup(jdlQuanLyNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel77)
                            .addComponent(txtEmailNS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jdlQuanLyNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jdlQuanLyNhanSuLayout.createSequentialGroup()
                                .addComponent(jButton16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton17))
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jdlQuanLyNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLuuTTNS1)
                            .addComponent(btnLuuTTNS)
                            .addComponent(jLabel78)))
                    .addGroup(jdlQuanLyNhanSuLayout.createSequentialGroup()
                        .addGroup(jdlQuanLyNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboTatCaNS)
                            .addComponent(cboNhanSuOn)
                            .addComponent(cboNhanSuOff))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
        );

        DialogPhanCong.setModal(true);
        DialogPhanCong.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                DialogPhanCongComponentShown(evt);
            }
        });

        cbbChienDich.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbbChienDich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbChienDichActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton13.setText("Xác nhận");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        cbbChuyenNganh.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbbChuyenNganh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel37.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel37.setText("Phân công chuyên ngành");

        javax.swing.GroupLayout DialogPhanCongLayout = new javax.swing.GroupLayout(DialogPhanCong.getContentPane());
        DialogPhanCong.getContentPane().setLayout(DialogPhanCongLayout);
        DialogPhanCongLayout.setHorizontalGroup(
            DialogPhanCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DialogPhanCongLayout.createSequentialGroup()
                .addGroup(DialogPhanCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DialogPhanCongLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DialogPhanCongLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(DialogPhanCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbChuyenNganh, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbChienDich, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(DialogPhanCongLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        DialogPhanCongLayout.setVerticalGroup(
            DialogPhanCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogPhanCongLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbChienDich, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(cbbChuyenNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel39.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel39.setText("Tổng SV đã chọn : ");

        cbbChuyenDoiPC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnXacNhan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        lblTongSV.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTongSV.setForeground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout DialogChuyenSVLayout = new javax.swing.GroupLayout(DialogChuyenSV.getContentPane());
        DialogChuyenSV.getContentPane().setLayout(DialogChuyenSVLayout);
        DialogChuyenSVLayout.setHorizontalGroup(
            DialogChuyenSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogChuyenSVLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(DialogChuyenSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbChuyenDoiPC, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DialogChuyenSVLayout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTongSV, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DialogChuyenSVLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXacNhan)
                .addGap(34, 34, 34))
        );
        DialogChuyenSVLayout.setVerticalGroup(
            DialogChuyenSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogChuyenSVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DialogChuyenSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DialogChuyenSVLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblTongSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbChuyenDoiPC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JmenuTongSvChon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JmenuTongSvChon.setText("Tổng sv đã chọn");

        jMenuDeleteObj.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuDeleteObj.setText("Xóa");
        jMenuDeleteObj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuDeleteObjActionPerformed(evt);
            }
        });

        jdlChamSocDongThoi.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jdlChamSocDongThoiComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jdlChamSocDongThoiComponentShown(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jPanel4ComponentHidden(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel38.setText("Loại chiến dịch:");

        txt_jdlCSDT_LoaiCD.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_jdlCSDT_LoaiCD.setForeground(new java.awt.Color(153, 204, 255));
        txt_jdlCSDT_LoaiCD.setText("\"\"");

        jLabel44.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel44.setText("Thời gian tạo:");

        txt_jdl_csdt_TgTao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_jdl_csdt_TgTao.setText("\"\"");

        txt_jdl_CSDT_DienGiaiCT.setColumns(20);
        txt_jdl_CSDT_DienGiaiCT.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_jdl_CSDT_DienGiaiCT.setRows(5);
        jScrollPane12.setViewportView(txt_jdl_CSDT_DienGiaiCT);

        jLabel46.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel46.setText("Phân loại nguy cơ:");

        cbo_jdl_csdt_dt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel48.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel48.setText("Đối tượng:");

        cbo_jdl_csdt_plnc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel82.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel82.setText("Lý do ghi nhận:");

        cbo_jdl_csdt_ldgn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel83.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel83.setText("Nguyện vọng SV/PH:");

        cbo_jdl_csdt_nvsv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin HP/BL (nếu có)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        jLabel45.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel45.setText("Học phí:");

        txt_jdl_csdt_HocPhi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_jdl_csdt_HocPhi.setText("0");

        jLabel86.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel86.setText("Trạng thái học phí:");

        jLabel87.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel87.setText("Trạng thái bảo lưu:");

        txt_jdl_csdt_tthp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_jdl_csdt_tthp.setText("\"\"");

        txt_jdl_csdt_ttbl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_jdl_csdt_ttbl.setText("\"\"");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addGap(18, 18, 18)
                        .addComponent(txt_jdl_csdt_HocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel86)
                        .addGap(18, 18, 18)
                        .addComponent(txt_jdl_csdt_tthp, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel87)
                        .addGap(18, 18, 18)
                        .addComponent(txt_jdl_csdt_ttbl, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 78, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(txt_jdl_csdt_HocPhi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(txt_jdl_csdt_tthp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(txt_jdl_csdt_ttbl))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jLabel84.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel84.setText("Diễn giải chi tiết:");

        jcb_csdt.setSelected(true);
        jcb_csdt.setText("Chăm sóc");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel82)
                            .addComponent(jLabel46)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbo_jdl_csdt_ldgn, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbo_jdl_csdt_plnc, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addComponent(jLabel83)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbo_jdl_csdt_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbo_jdl_csdt_nvsv, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jcb_csdt, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel38)
                                            .addComponent(jLabel44))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_jdl_csdt_TgTao, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_jdlCSDT_LoaiCD, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel84))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(txt_jdlCSDT_LoaiCD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(txt_jdl_csdt_TgTao))
                        .addGap(48, 48, 48)
                        .addComponent(jLabel84))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82)
                    .addComponent(jLabel83))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_jdl_csdt_nvsv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_jdl_csdt_ldgn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_jdl_csdt_plnc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_jdl_csdt_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcb_csdt)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jdlChamSocDongThoiLayout = new javax.swing.GroupLayout(jdlChamSocDongThoi.getContentPane());
        jdlChamSocDongThoi.getContentPane().setLayout(jdlChamSocDongThoiLayout);
        jdlChamSocDongThoiLayout.setHorizontalGroup(
            jdlChamSocDongThoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdlChamSocDongThoiLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jdlChamSocDongThoiLayout.setVerticalGroup(
            jdlChamSocDongThoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Đường dẫn file excel:");

        jButton21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/folder.png"))); // NOI18N
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        buttonGroup5.add(cboThayThe);
        cboThayThe.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboThayThe.setSelected(true);
        cboThayThe.setText("Thay thế");

        jButton22.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton22.setText("Lưu");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jlb_enroll_importSV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlb_enroll_importSV.setForeground(new java.awt.Color(255, 0, 51));
        jlb_enroll_importSV.setText(" ");

        javax.swing.GroupLayout jdlImportSVLayout = new javax.swing.GroupLayout(jdlImportSV.getContentPane());
        jdlImportSV.getContentPane().setLayout(jdlImportSVLayout);
        jdlImportSVLayout.setHorizontalGroup(
            jdlImportSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdlImportSVLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(jdlImportSVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdlImportSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10)
                    .addComponent(jlb_enroll_importSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jdlImportSVLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jdlImportSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboThayThe)
                            .addGroup(jdlImportSVLayout.createSequentialGroup()
                                .addComponent(txtLinkFileImportSV, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jdlImportSVLayout.setVerticalGroup(
            jdlImportSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdlImportSVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_enroll_importSV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jdlImportSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLinkFileImportSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboThayThe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jButton22)
                .addContainerGap())
        );

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Mans:");

        jlb_ttcn_Mans.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jlb_ttcn_Mans.setText("\"\"");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Họ tên:");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Mật khẩu:");

        jButton24.setText("Lưu thay đổi");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jdlThongTinCaNhanLayout = new javax.swing.GroupLayout(jdlThongTinCaNhan.getContentPane());
        jdlThongTinCaNhan.getContentPane().setLayout(jdlThongTinCaNhanLayout);
        jdlThongTinCaNhanLayout.setHorizontalGroup(
            jdlThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdlThongTinCaNhanLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jdlThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jdlThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlb_ttcn_Mans, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ttcn_Hoten, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ttcn_matKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdlThongTinCaNhanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton24)
                .addGap(49, 49, 49))
        );
        jdlThongTinCaNhanLayout.setVerticalGroup(
            jdlThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdlThongTinCaNhanLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jdlThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jlb_ttcn_Mans))
                .addGap(18, 18, 18)
                .addGroup(jdlThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_ttcn_Hoten, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jdlThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_ttcn_matKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton24)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Jmenu_dsip_an.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Jmenu_dsip_an.setText("Ẩn");
        Jmenu_dsip_an.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jmenu_dsip_anActionPerformed(evt);
            }
        });

        Jmenu_dsip_xoa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Jmenu_dsip_xoa.setText("Xóa");
        Jmenu_dsip_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jmenu_dsip_xoaActionPerformed(evt);
            }
        });

        Jmn_ChuyenSv.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Jmn_ChuyenSv.setText("Chuyển");
        Jmn_ChuyenSv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jmn_ChuyenSvActionPerformed(evt);
            }
        });

        jdl_editLSCS.setModal(true);
        jdl_editLSCS.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jdl_editLSCSComponentHidden(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Loại chiến dịch:");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setText("MSSV:");

        jLabel20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel20.setText("Lý do ghi nhận:");

        jLabel25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel25.setText("Nguyện vọng của sinh viên:");

        jLabel28.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel28.setText("Phân loại nguy cơ:");

        jLabel31.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel31.setText("Đối tượng:");

        cbo_edit_nvsv.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cbo_edit_ldgn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cbo_edit_dt.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cbo_edit_plnc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel35.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel35.setText("Diễn giải chi tiêt:");

        btn_edit_luu.setText("Lưu thay đổi");
        btn_edit_luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_luuActionPerformed(evt);
            }
        });

        txt_edit_dgct.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txt_edit_Loaicd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_edit_Loaicd.setText(" ");

        txt_edit_mssv.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_edit_mssv.setText(" ");

        javax.swing.GroupLayout jdl_editLSCSLayout = new javax.swing.GroupLayout(jdl_editLSCS.getContentPane());
        jdl_editLSCS.getContentPane().setLayout(jdl_editLSCSLayout);
        jdl_editLSCSLayout.setHorizontalGroup(
            jdl_editLSCSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdl_editLSCSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdl_editLSCSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdl_editLSCSLayout.createSequentialGroup()
                        .addGroup(jdl_editLSCSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_edit_dgct, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_edit_luu))
                        .addGap(21, 21, 21))
                    .addGroup(jdl_editLSCSLayout.createSequentialGroup()
                        .addGroup(jdl_editLSCSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jdl_editLSCSLayout.createSequentialGroup()
                                .addGroup(jdl_editLSCSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jdl_editLSCSLayout.createSequentialGroup()
                                        .addGroup(jdl_editLSCSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel28)
                                            .addComponent(cbo_edit_plnc, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE))
                                    .addGroup(jdl_editLSCSLayout.createSequentialGroup()
                                        .addComponent(cbo_edit_ldgn, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(58, 58, 58)))
                                .addGroup(jdl_editLSCSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel25)
                                    .addComponent(cbo_edit_nvsv, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbo_edit_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jdl_editLSCSLayout.createSequentialGroup()
                                .addGroup(jdl_editLSCSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35)
                                    .addGroup(jdl_editLSCSLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_edit_Loaicd, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_edit_mssv, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jdl_editLSCSLayout.setVerticalGroup(
            jdl_editLSCSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdl_editLSCSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdl_editLSCSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdl_editLSCSLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdl_editLSCSLayout.createSequentialGroup()
                        .addGroup(jdl_editLSCSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_edit_Loaicd)
                            .addComponent(jLabel15)
                            .addComponent(txt_edit_mssv))
                        .addGap(18, 18, 18)))
                .addGroup(jdl_editLSCSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jdl_editLSCSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_edit_nvsv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_edit_ldgn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jdl_editLSCSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jdl_editLSCSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_edit_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_edit_plnc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_edit_dgct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_edit_luu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jdl_ThemDG.setModal(true);
        jdl_ThemDG.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jdl_ThemDGComponentShown(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel42.setText("Loại:");

        jlb_loaiDopList.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlb_loaiDopList.setText(" ");

        jLabel52.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel52.setText("Nội dung:");

        txt_themMoiDG.setText(" ");

        jButton18.setText("Lưu");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jdl_ThemDGLayout = new javax.swing.GroupLayout(jdl_ThemDG.getContentPane());
        jdl_ThemDG.getContentPane().setLayout(jdl_ThemDGLayout);
        jdl_ThemDGLayout.setHorizontalGroup(
            jdl_ThemDGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdl_ThemDGLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdl_ThemDGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdl_ThemDGLayout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlb_loaiDopList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jdl_ThemDGLayout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txt_themMoiDG))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdl_ThemDGLayout.createSequentialGroup()
                .addContainerGap(451, Short.MAX_VALUE)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jdl_ThemDGLayout.setVerticalGroup(
            jdl_ThemDGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdl_ThemDGLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdl_ThemDGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jlb_loaiDopList))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_themMoiDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jdl_quanLyDl.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jdl_quanLyDlComponentHidden(evt);
            }
        });

        jLabel65.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel65.setText("Loại:");

        cbo_TieuChi.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbo_TieuChi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lựa chọn", "Lý do ghi nhận", "Phân loại nguy cơ", "Đối tượng", "Nguyện vọng của sinh viên", " " }));
        cbo_TieuChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_TieuChiActionPerformed(evt);
            }
        });

        jLabel85.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel85.setText("Mã loại:");

        jlb_maLoaiDl.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlb_maLoaiDl.setText(" ");

        jLabel88.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel88.setText("Nội dung:");

        jButton19.setText("Xóa");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setText("Tạo mới");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jLabel89.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel89.setText("Chiến dịch:");

        cbo_ChienDichDL.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbo_ChienDichDL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CSHP", "CSVH", " " }));
        cbo_ChienDichDL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_ChienDichDLActionPerformed(evt);
            }
        });

        jtb_DropList.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtb_DropList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Loại", "Nội dung"
            }
        ));
        jtb_DropList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_DropListMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jtb_DropList);
        if (jtb_DropList.getColumnModel().getColumnCount() > 0) {
            jtb_DropList.getColumnModel().getColumn(0).setPreferredWidth(30);
            jtb_DropList.getColumnModel().getColumn(0).setMaxWidth(30);
            jtb_DropList.getColumnModel().getColumn(1).setPreferredWidth(20);
            jtb_DropList.getColumnModel().getColumn(2).setPreferredWidth(500);
        }

        txt_noiDungDl.setColumns(20);
        txt_noiDungDl.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_noiDungDl.setRows(5);
        jScrollPane3.setViewportView(txt_noiDungDl);

        jButton28.setText("Làm mới");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        txt_editDropList_enroll.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_editDropList_enroll.setForeground(new java.awt.Color(255, 0, 0));
        txt_editDropList_enroll.setText(" ");

        javax.swing.GroupLayout jdl_quanLyDlLayout = new javax.swing.GroupLayout(jdl_quanLyDl.getContentPane());
        jdl_quanLyDl.getContentPane().setLayout(jdl_quanLyDlLayout);
        jdl_quanLyDlLayout.setHorizontalGroup(
            jdl_quanLyDlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdl_quanLyDlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdl_quanLyDlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdl_quanLyDlLayout.createSequentialGroup()
                        .addGroup(jdl_quanLyDlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel85)
                            .addComponent(jLabel88))
                        .addGroup(jdl_quanLyDlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jdl_quanLyDlLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jlb_maLoaiDl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jdl_quanLyDlLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jdl_quanLyDlLayout.createSequentialGroup()
                        .addComponent(jButton19)
                        .addGap(18, 18, 18)
                        .addComponent(jButton20)
                        .addGap(18, 18, 18)
                        .addComponent(jButton28))
                    .addGroup(jdl_quanLyDlLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jdl_quanLyDlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_editDropList_enroll, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jdl_quanLyDlLayout.createSequentialGroup()
                                .addComponent(jLabel89)
                                .addGap(18, 18, 18)
                                .addComponent(cbo_ChienDichDL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel65)
                                .addGap(18, 18, 18)
                                .addComponent(cbo_TieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane11)
        );
        jdl_quanLyDlLayout.setVerticalGroup(
            jdl_quanLyDlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdl_quanLyDlLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txt_editDropList_enroll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jdl_quanLyDlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_TieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel89)
                    .addComponent(cbo_ChienDichDL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65))
                .addGap(10, 10, 10)
                .addGroup(jdl_quanLyDlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85)
                    .addComponent(jlb_maLoaiDl))
                .addGap(10, 10, 10)
                .addGroup(jdl_quanLyDlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel88)
                    .addGroup(jdl_quanLyDlLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(jdl_quanLyDlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton20)
                            .addComponent(jButton19)
                            .addComponent(jButton28))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane14.setViewportView(jTextArea1);

        txt_viewCT.setColumns(20);
        txt_viewCT.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_viewCT.setLineWrap(true);
        txt_viewCT.setRows(5);
        jScrollPane15.setViewportView(txt_viewCT);

        javax.swing.GroupLayout jpnViewctLayout = new javax.swing.GroupLayout(jpnViewct);
        jpnViewct.setLayout(jpnViewctLayout);
        jpnViewctLayout.setHorizontalGroup(
            jpnViewctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );
        jpnViewctLayout.setVerticalGroup(
            jpnViewctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
        );

        jButton27.setText("Lưu");

        jLabel9.setText("TenFile");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLinkExport)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(0, 342, Short.MAX_VALUE)
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtLinkExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton27)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        JtpHome.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        JtpHome.setToolTipText("");
        JtpHome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JtpHome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JtpHome.setOpaque(true);

        jpnChamSocSV.setRequestFocusEnabled(false);
        jpnChamSocSV.setVerifyInputWhenFocusTarget(false);
        jpnChamSocSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnChamSocSVMouseClicked(evt);
            }
        });
        jpnChamSocSV.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jpnChamSocSVComponentShown(evt);
            }
        });
        jpnChamSocSV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpnChamSocSVKeyPressed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Truy vấn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        jPanel6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel6KeyPressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 153, 0));
        jLabel14.setText("Chưa chăm sóc:");

        jlb_CSSV_ChuaCS.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlb_CSSV_ChuaCS.setForeground(new java.awt.Color(255, 153, 0));
        jlb_CSSV_ChuaCS.setText("0");

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("Loại chiến dịch:");

        cbo_Cs_ChienDich.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbo_Cs_ChienDich.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lựa chọn chiến dịch", "CSVH", "CSHP", "CS1D3", "CSEN" }));
        cbo_Cs_ChienDich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_Cs_ChienDichActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setText("Đến ngày:");

        jdc_qlcd_firstDay.setDateFormatString("yyyy-MM-dd");
        jdc_qlcd_firstDay.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setText("Từ ngày:");

        jdc_qlcd_endDay.setDateFormatString("yyyy-MM-dd");
        jdc_qlcd_endDay.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jdc_qlcd_endDay.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jdc_qlcd_endDayInputMethodTextChanged(evt);
            }
        });
        jdc_qlcd_endDay.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdc_qlcd_endDayPropertyChange(evt);
            }
        });
        jdc_qlcd_endDay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jdc_qlcd_endDayKeyReleased(evt);
            }
        });

        jButton7.setText("Tìm");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/refresh.png"))); // NOI18N
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jlb_CSSV_ChuaCS, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(cbo_Cs_ChienDich, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(jdc_qlcd_firstDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(jdc_qlcd_endDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jButton10)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel17)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdc_qlcd_endDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdc_qlcd_firstDay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jlb_CSSV_ChuaCS)
                        .addComponent(jLabel16)
                        .addComponent(cbo_Cs_ChienDich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18))
                    .addComponent(jButton7))
                .addContainerGap())
        );

        jSplitPane1.setDividerLocation(250);
        jSplitPane1.setDividerSize(0);
        jSplitPane1.setAlignmentY(1.0F);
        jSplitPane1.setDoubleBuffered(true);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sinh viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14), new java.awt.Color(102, 153, 255))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setText("MSSV:");

        txtCSSV_MSSV.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCSSV_MSSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCSSV_MSSVMouseClicked(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel21.setText("Chuyên ngành:");

        jLabel22.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel22.setText("Kì học:");

        jLabel23.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel23.setText("Nhận xét của giảng viên:");

        txt_CSSV_KiHoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txt_CSSV_ChuyenNganh.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel26.setText("Họ và tên:");

        jLabel27.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel27.setText("Trạng thái:");

        txt_CSSV_HoTen.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txt_CSSV_TrangThai.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txt_CSSV_NX.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel24.setText("Môn học:");

        jlb_cs_monHoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_CSSV_NX)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCSSV_MSSV, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(140, 140, 140)
                                        .addComponent(jLabel26))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel21)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_CSSV_ChuyenNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel24)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jlb_cs_monHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel22)
                                            .addComponent(jLabel27))))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_CSSV_KiHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_CSSV_HoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                        .addComponent(txt_CSSV_TrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jLabel23))
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtCSSV_MSSV)
                    .addComponent(jLabel26)
                    .addComponent(txt_CSSV_HoTen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txt_CSSV_ChuyenNganh)
                    .addComponent(jLabel27)
                    .addComponent(txt_CSSV_TrangThai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(txt_CSSV_KiHoc))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(jlb_cs_monHoc)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_CSSV_NX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Học phí & Bảo lưu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14), new java.awt.Color(102, 153, 255))); // NOI18N

        jLabel30.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel30.setText("Tổng học phí:");

        txt_CSSV_HocPhi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel32.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel32.setText("Trạng thái:");

        txt_CSSV_TrangThaiHP.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel34.setText("Trạng thái bảo lưu:");

        txt_CSSV_TrangThaiBL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_CSSV_HocPhi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_CSSV_TrangThaiHP, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_CSSV_TrangThaiBL, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txt_CSSV_HocPhi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_CSSV_TrangThaiHP)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txt_CSSV_TrangThaiBL))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel54.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 51, 51));
        jLabel54.setText("(Click vào để chăm sóc đồng thời) *");

        jLabel55.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel55.setText("Lý do ghi nhận:");

        cboPhanLoaiNguyCo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        cboNguyenVongCuaSV.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboNguyenVongCuaSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNguyenVongCuaSVActionPerformed(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel57.setText("Phân loại nguy cơ:");

        cboLyDoNghiNhan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel58.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel58.setText("Nguyện vọng của sinh viên:");

        cboDoiTuong.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel59.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel59.setText("Diễn giải chi tiết: *");

        txtDienGiaiCT.setColumns(20);
        txtDienGiaiCT.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDienGiaiCT.setRows(5);
        jScrollPane7.setViewportView(txtDienGiaiCT);

        jLabel60.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel60.setText("Lịch sử chăm sóc:");

        jLabel61.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel61.setText("Đối tượng:");

        btn_LuaCS.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_LuaCS.setText("Lưu");
        btn_LuaCS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LuaCSActionPerformed(evt);
            }
        });

        jtbCSDT.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtbCSDT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Loai", "Thời gian tạo"
            }
        ));
        jtbCSDT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtbCSDT.setRowHeight(20);
        jtbCSDT.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtbCSDT.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtbCSDT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbCSDTMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbCSDT);
        if (jtbCSDT.getColumnModel().getColumnCount() > 0) {
            jtbCSDT.getColumnModel().getColumn(0).setPreferredWidth(25);
        }

        jtbLichSuCS.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtbLichSuCS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Loại", "Nhân sự", "Thời gian", "PLNC", "Lý do", "Diễn giải chi tiết"
            }
        ));
        jtbLichSuCS.setRowHeight(20);
        jtbLichSuCS.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtbLichSuCS.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane6.setViewportView(jtbLichSuCS);
        if (jtbLichSuCS.getColumnModel().getColumnCount() > 0) {
            jtbLichSuCS.getColumnModel().getColumn(0).setPreferredWidth(15);
            jtbLichSuCS.getColumnModel().getColumn(1).setPreferredWidth(15);
            jtbLichSuCS.getColumnModel().getColumn(2).setPreferredWidth(20);
            jtbLichSuCS.getColumnModel().getColumn(3).setPreferredWidth(20);
            jtbLichSuCS.getColumnModel().getColumn(4).setPreferredWidth(200);
            jtbLichSuCS.getColumnModel().getColumn(5).setPreferredWidth(300);
        }

        btn_themldgn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_themldgn.setText("+");
        btn_themldgn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themldgnActionPerformed(evt);
            }
        });

        btn_themNvsv.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_themNvsv.setText("+");
        btn_themNvsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themNvsvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59)
                            .addComponent(jLabel60))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel54))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55)
                            .addComponent(jLabel57)
                            .addComponent(cboPhanLoaiNguyCo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(cboLyDoNghiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_themldgn)))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(cboNguyenVongCuaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_themNvsv))
                            .addComponent(jLabel61)
                            .addComponent(cboDoiTuong, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_LuaCS, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(jLabel55)
                    .addComponent(jLabel58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboLyDoNghiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboNguyenVongCuaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_themNvsv, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_themldgn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel61)
                            .addComponent(jLabel57))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboPhanLoaiNguyCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboDoiTuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jLabel59)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_LuaCS)
                .addGap(8, 8, 8))
        );

        jSplitPane1.setRightComponent(jPanel7);

        jtbSVCanCS.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtbSVCanCS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "MSSV", "TC"
            }
        ));
        jtbSVCanCS.setRowHeight(20);
        jtbSVCanCS.setSelectionForeground(new java.awt.Color(102, 153, 255));
        jtbSVCanCS.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtbSVCanCS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbSVCanCSMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(jtbSVCanCS);
        if (jtbSVCanCS.getColumnModel().getColumnCount() > 0) {
            jtbSVCanCS.getColumnModel().getColumn(0).setPreferredWidth(20);
            jtbSVCanCS.getColumnModel().getColumn(1).setPreferredWidth(40);
        }

        jSplitPane1.setLeftComponent(jScrollPane13);

        javax.swing.GroupLayout jpnChamSocSVLayout = new javax.swing.GroupLayout(jpnChamSocSV);
        jpnChamSocSV.setLayout(jpnChamSocSVLayout);
        jpnChamSocSVLayout.setHorizontalGroup(
            jpnChamSocSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jpnChamSocSVLayout.setVerticalGroup(
            jpnChamSocSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnChamSocSVLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSplitPane1)
                .addGap(0, 0, 0))
        );

        JtpHome.addTab("Chăm sóc", jpnChamSocSV);

        jpnQuanLyCD.setVerifyInputWhenFocusTarget(false);
        jpnQuanLyCD.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jpnQuanLyCDComponentResized(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jpnQuanLyCDComponentShown(evt);
            }
        });

        jSplitPane2.setDividerLocation(200);
        jSplitPane2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jSplitPane2.setOneTouchExpandable(true);

        jToolBar1.setRollover(true);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/folder.png"))); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);
        jToolBar1.add(jSeparator1);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/graduated (1).png"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);
        jToolBar1.add(jSeparator4);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/financial-profit.png"))); // NOI18N
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);
        jToolBar1.add(jSeparator3);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/terms-and-conditions.png"))); // NOI18N
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);
        jToolBar1.add(jSeparator5);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/refresh.png"))); // NOI18N
        jButton14.setFocusable(false);
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton14);

        JListDanhSachIP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JListDanhSachIP.setVisibleRowCount(20);
        JListDanhSachIP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JListDanhSachIPMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(JListDanhSachIP);

        javax.swing.GroupLayout jpnDanhSachIPLayout = new javax.swing.GroupLayout(jpnDanhSachIP);
        jpnDanhSachIP.setLayout(jpnDanhSachIPLayout);
        jpnDanhSachIPLayout.setHorizontalGroup(
            jpnDanhSachIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
        );
        jpnDanhSachIPLayout.setVerticalGroup(
            jpnDanhSachIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDanhSachIPLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jSplitPane2.setLeftComponent(jpnDanhSachIP);

        jpnQuanLyChienDich_Content.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jpnQuanLyChienDich_ContentComponentShown(evt);
            }
        });

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Truy vấn:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        jLabel36.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(102, 153, 255));
        jLabel36.setText("Tổng:");

        jlb_qlcd_tong.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlb_qlcd_tong.setForeground(new java.awt.Color(102, 153, 255));
        jlb_qlcd_tong.setText("0");

        jLabel40.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 153, 0));
        jLabel40.setText("Chưa chăm sóc:");

        jLabel41.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel41.setText("Học kì:");

        cbo_qLcd_hocKi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbo_qLcd_hocKi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_qLcd_hocKiActionPerformed(evt);
            }
        });

        jlb_qlcd_ChuaCS.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlb_qlcd_ChuaCS.setForeground(new java.awt.Color(255, 153, 0));
        jlb_qlcd_ChuaCS.setText("0");

        jLabel43.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(51, 153, 0));
        jLabel43.setText("Đã chăm sóc:");

        jlb_qlcd_Dacs.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlb_qlcd_Dacs.setForeground(new java.awt.Color(51, 153, 0));
        jlb_qlcd_Dacs.setText("0");

        jLabel47.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel47.setText("Chiến dịch:");

        cbo_qlcd_chienDich.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbo_qlcd_chienDich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_qlcd_chienDichActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel49.setText("Chuyên ngành:");

        cbo_qlcd_chuyenNganh.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbo_qlcd_chuyenNganh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_qlcd_chuyenNganhActionPerformed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel50.setText("Nhân sự:");

        cbo_qlcd_NhanSu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbo_qlcd_NhanSu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_qlcd_NhanSuActionPerformed(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel51.setText("Tìm với MSSV:");

        txt_qlcd_mssv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_qlcd_mssv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_qlcd_mssvKeyReleased(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel53.setText("Từ ngày:");

        jdc_qlcd_tuNgay.setDateFormatString("yyyy-MM-dd");
        jdc_qlcd_tuNgay.setDoubleBuffered(false);
        jdc_qlcd_tuNgay.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel81.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel81.setText("Từ ngày:");

        jdc_qlcd_denNgay.setDateFormatString("yyyy-MM-dd");
        jdc_qlcd_denNgay.setDoubleBuffered(false);
        jdc_qlcd_denNgay.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btn_qlcd_Tim.setText("Tìm");
        btn_qlcd_Tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_qlcd_TimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlb_qlcd_tong, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel40)
                        .addGap(18, 18, 18)
                        .addComponent(jlb_qlcd_ChuaCS, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel43)
                        .addGap(18, 18, 18)
                        .addComponent(jlb_qlcd_Dacs, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addGap(32, 32, 32)
                                .addComponent(cbo_qLcd_hocKi, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel50)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbo_qlcd_NhanSu, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addComponent(jLabel47))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbo_qlcd_chuyenNganh, 0, 201, Short.MAX_VALUE)
                            .addComponent(cbo_qlcd_chienDich, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addGap(18, 18, 18)
                                .addComponent(txt_qlcd_mssv, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel53)
                                .addGap(11, 11, 11)
                                .addComponent(jdc_qlcd_tuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel81)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jdc_qlcd_denNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_qlcd_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(4, 4, 4))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jlb_qlcd_tong)
                    .addComponent(jLabel40)
                    .addComponent(jlb_qlcd_ChuaCS)
                    .addComponent(jLabel43)
                    .addComponent(jlb_qlcd_Dacs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel41)
                        .addComponent(cbo_qLcd_hocKi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbo_qlcd_chienDich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel51)
                        .addComponent(txt_qlcd_mssv)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbo_qlcd_chuyenNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel49)
                        .addComponent(cbo_qlcd_NhanSu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel50)
                        .addComponent(jLabel53))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel81)
                        .addComponent(jdc_qlcd_tuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jdc_qlcd_denNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_qlcd_Tim))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtp_qlcd_daPC.setBackground(new java.awt.Color(153, 204, 255));
        jtp_qlcd_daPC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtp_qlcd_daPC.setOpaque(true);

        jpnSvCho.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jpnSvChoComponentShown(evt);
            }
        });

        Jtable_PhanCongRoi.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Jtable_PhanCongRoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Loại chiến dịch", "MSSV", "Chuyên ngành", "Nhân sự phụ trách", "Thời gian tạo"
            }
        ));
        Jtable_PhanCongRoi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Jtable_PhanCongRoi.setRowHeight(20);
        Jtable_PhanCongRoi.setSelectionForeground(new java.awt.Color(51, 153, 255));
        Jtable_PhanCongRoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jtable_PhanCongRoiMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(Jtable_PhanCongRoi);

        javax.swing.GroupLayout jpnSvChoLayout = new javax.swing.GroupLayout(jpnSvCho);
        jpnSvCho.setLayout(jpnSvChoLayout);
        jpnSvChoLayout.setHorizontalGroup(
            jpnSvChoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE)
        );
        jpnSvChoLayout.setVerticalGroup(
            jpnSvChoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
        );

        jtp_qlcd_daPC.addTab("Đã phân công", jpnSvCho);

        jpnCSVH.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jpnCSVHComponentShown(evt);
            }
        });

        jtb_qlcd_chuaPC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtb_qlcd_chuaPC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Loại chiến dịch", "MSSV", "Chuyên ngành", "Nhân sự phụ trách", "Thời gian tạo"
            }
        ));
        jtb_qlcd_chuaPC.setRowHeight(20);
        jtb_qlcd_chuaPC.setSelectionForeground(new java.awt.Color(102, 153, 255));
        jtb_qlcd_chuaPC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_qlcd_chuaPCMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jtb_qlcd_chuaPC);

        javax.swing.GroupLayout jpnCSVHLayout = new javax.swing.GroupLayout(jpnCSVH);
        jpnCSVH.setLayout(jpnCSVHLayout);
        jpnCSVHLayout.setHorizontalGroup(
            jpnCSVHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE)
        );
        jpnCSVHLayout.setVerticalGroup(
            jpnCSVHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
        );

        jtp_qlcd_daPC.addTab("Chưa phân công", jpnCSVH);

        javax.swing.GroupLayout jpnQuanLyChienDich_ContentLayout = new javax.swing.GroupLayout(jpnQuanLyChienDich_Content);
        jpnQuanLyChienDich_Content.setLayout(jpnQuanLyChienDich_ContentLayout);
        jpnQuanLyChienDich_ContentLayout.setHorizontalGroup(
            jpnQuanLyChienDich_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jtp_qlcd_daPC)
        );
        jpnQuanLyChienDich_ContentLayout.setVerticalGroup(
            jpnQuanLyChienDich_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQuanLyChienDich_ContentLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jtp_qlcd_daPC)
                .addGap(0, 0, 0))
        );

        jSplitPane2.setRightComponent(jpnQuanLyChienDich_Content);

        javax.swing.GroupLayout jpnQuanLyCDLayout = new javax.swing.GroupLayout(jpnQuanLyCD);
        jpnQuanLyCD.setLayout(jpnQuanLyCDLayout);
        jpnQuanLyCDLayout.setHorizontalGroup(
            jpnQuanLyCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );
        jpnQuanLyCDLayout.setVerticalGroup(
            jpnQuanLyCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );

        JtpHome.addTab("Phân công", jpnQuanLyCD);
        jpnQuanLyCD.getAccessibleContext().setAccessibleName("công");

        jpnHome.setVerifyInputWhenFocusTarget(false);
        jpnHome.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jpnHomeComponentShown(evt);
            }
        });

        jtb_home_lichSuCs.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtb_home_lichSuCs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Loại", "MSSV", "Lý do", "Diễn giải chi tiết", "Phân loại", "Nhân sự", "Thời gian"
            }
        ));
        jtb_home_lichSuCs.setRowHeight(20);
        jtb_home_lichSuCs.setSelectionForeground(new java.awt.Color(102, 153, 255));
        jtb_home_lichSuCs.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtb_home_lichSuCs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_home_lichSuCsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb_home_lichSuCs);
        if (jtb_home_lichSuCs.getColumnModel().getColumnCount() > 0) {
            jtb_home_lichSuCs.getColumnModel().getColumn(0).setPreferredWidth(15);
            jtb_home_lichSuCs.getColumnModel().getColumn(1).setPreferredWidth(30);
            jtb_home_lichSuCs.getColumnModel().getColumn(2).setPreferredWidth(300);
            jtb_home_lichSuCs.getColumnModel().getColumn(3).setPreferredWidth(380);
            jtb_home_lichSuCs.getColumnModel().getColumn(4).setPreferredWidth(60);
            jtb_home_lichSuCs.getColumnModel().getColumn(5).setPreferredWidth(30);
            jtb_home_lichSuCs.getColumnModel().getColumn(6).setPreferredWidth(60);
        }

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Truy vấn:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("MSSV:");

        txt_Home_mssv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_Home_mssv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Home_mssvKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Học kì:");

        cbo_home_HocKy.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbo_home_HocKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_home_HocKyActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Chiến dịch:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Nhân sự:");

        cbo_Home_ChienDich.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbo_Home_ChienDich.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lựa chọn chiến dịch", "CSVH", "CSHP", "CS1D3", "CSEN" }));
        cbo_Home_ChienDich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_Home_ChienDichActionPerformed(evt);
            }
        });

        cbo_Home_NhanSu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbo_Home_NhanSu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbo_Home_NhanSuMouseClicked(evt);
            }
        });
        cbo_Home_NhanSu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_Home_NhanSuActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Từ ngày: ");

        jdc_Home_tuNgay.setDateFormatString("yyyy-MM-dd");
        jdc_Home_tuNgay.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Đến ngày:");

        jdc_home_denNgay.setDateFormatString("yyyy-MM-dd");
        jdc_home_denNgay.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btn_Home_TraCuuTheoNgay.setText("Tìm");
        btn_Home_TraCuuTheoNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Home_TraCuuTheoNgayActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/sheets.png"))); // NOI18N
        jButton6.setText("Xuất excel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 153, 255));
        jLabel8.setText("Tổng data:");

        txt_home_tongData.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_home_tongData.setForeground(new java.awt.Color(102, 153, 255));
        txt_home_tongData.setText("0");

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/refresh.png"))); // NOI18N
        jButton23.setBorderPainted(false);
        jButton23.setContentAreaFilled(false);
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_Home_mssv, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbo_home_HocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbo_Home_NhanSu, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txt_home_tongData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbo_Home_ChienDich, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jdc_Home_tuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(24, 24, 24)
                .addComponent(jdc_home_denNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_Home_TraCuuTheoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                        .addComponent(jButton23)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txt_Home_mssv, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(cbo_Home_ChienDich, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jdc_Home_tuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Home_TraCuuTheoNgay)
                        .addComponent(jdc_home_denNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel6)))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbo_home_HocKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbo_Home_NhanSu, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_home_tongData))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jButton23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpnHomContentLayout = new javax.swing.GroupLayout(jpnHomContent);
        jpnHomContent.setLayout(jpnHomContentLayout);
        jpnHomContentLayout.setHorizontalGroup(
            jpnHomContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jpnHomContentLayout.setVerticalGroup(
            jpnHomContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHomContentLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnHomeLayout = new javax.swing.GroupLayout(jpnHome);
        jpnHome.setLayout(jpnHomeLayout);
        jpnHomeLayout.setHorizontalGroup(
            jpnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnHomContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnHomeLayout.setVerticalGroup(
            jpnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnHomContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        JtpHome.addTab("Lịch sử", jpnHome);

        txt_Home_Mans.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_Home_Mans.setText(" ");

        jProgressBar1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txt_taiData.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_taiData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txt_taiData.setText(" ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_Home_Mans, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_taiData, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_taiData)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE))
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_Home_Mans)
                        .addContainerGap())))
        );

        jMenu1.setText("Công cụ");

        jMenuItem1.setText("Quản lý nhân sự");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        mni_qlttcn.setText("Cá nhân");
        mni_qlttcn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mni_qlttcnActionPerformed(evt);
            }
        });
        jMenu1.add(mni_qlttcn);

        jMenuItem2.setText("Tùy chình tiêu chí đánh giá");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        JmbMenu.add(jMenu1);

        setJMenuBar(JmbMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JtpHome)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JtpHome)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JtpHome.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuDeleteObjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuDeleteObjActionPerformed
        // TODO add your handling code here:
        boolean check = MsgBox.confirm(null, "Bạn có chắc chắn muốn xóa không?");
        if (check) {
            XoaData();
        }
    }//GEN-LAST:event_jMenuDeleteObjActionPerformed

    private void Jmenu_dsip_anActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jmenu_dsip_anActionPerformed
        // TODO add your handling code here:
        ChienDichCD chienDichCD = dsChienDichCD.get(JListDanhSachIP.getSelectedIndex());
        chienDichCDDAO.updateTrangThai(chienDichCD.getMaChienDichChuDong());
        getDanhSachIP();
    }//GEN-LAST:event_Jmenu_dsip_anActionPerformed

    private void Jmenu_dsip_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jmenu_dsip_xoaActionPerformed
        // TODO add your handling code here:
        boolean check = MsgBox.confirm(this, "Bạn có chắc chắn muốn xóa đợt chăm sóc này. \n Dữ liệu không thể phục hồi.");
        if (check) {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            ChienDichCD chienDichCD = dsChienDichCD.get(JListDanhSachIP.getSelectedIndex());
            if (lichSuChamSOC1D3DAO.countheomacdcd(chienDichCD.getMaChienDichChuDong()) == 0 && lichSuChamSOCHPDAO.countheomacdcd(chienDichCD.getMaChienDichChuDong()) == 0 && lichSuChamSocVHDAO.countheomacdcd(chienDichCD.getMaChienDichChuDong()) == 0 && lichSuChamSOCENDAO.countheomacdcd(chienDichCD.getMaChienDichChuDong()) == 0) {
                if (danhGia1D3DAO.deleteofCDCD(chienDichCD.getMaChienDichChuDong()) && danhGiaHPDAO.deleteofCDCD(chienDichCD.getMaChienDichChuDong()) && danhGiaVHDAO.deleteofCDCD(chienDichCD.getMaChienDichChuDong()) && danhGiaENDAO.deleteofCDCD(chienDichCD.getMaChienDichChuDong())) {
                    chienDichCDDAO.delete(chienDichCD);
                    getDanhSachIP();
                    loadDataPhanCong();
                    fillToTabledaPhanCong();
                    fillToTableChuaPhanCong();
                }
            } else {
                MsgBox.alert(this, "Đợt đã được chăm sóc, không thể xóa đợt!");
            }
            setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_Jmenu_dsip_xoaActionPerformed

    private void jPanel6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel6KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel6KeyPressed

    private void jpnChamSocSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnChamSocSVMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jpnChamSocSVMouseClicked

    private void jpnChamSocSVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpnChamSocSVKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpnChamSocSVKeyPressed

    private void jpnChamSocSVComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jpnChamSocSVComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jpnChamSocSVComponentShown

    private void Jmn_ChuyenSvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jmn_ChuyenSvActionPerformed
        // TODO add your handling code here:
        DialogChuyenSV.setVisible(true);
        DialogChuyenSV.setSize(496, 186);
        DialogChuyenSV.setLocationRelativeTo(null);
        int indexTab = jtp_qlcd_daPC.getSelectedIndex();
        String titleTab = jtp_qlcd_daPC.getTitleAt(indexTab);
        if (titleTab.equals("Đã phân công")) {
            lblTongSV.setText(tongs.length + "");
        } else {
            lblTongSV.setText(tongsChuaPC.length + "");
        }
        fillToCboNS(cbbChuyenDoiPC);
    }//GEN-LAST:event_Jmn_ChuyenSvActionPerformed

    private void jdlChamSocDongThoiComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jdlChamSocDongThoiComponentShown
        // TODO add your handling code here:
        jcb_csdt.setSelected(true);
    }//GEN-LAST:event_jdlChamSocDongThoiComponentShown

    private void txtCSSV_MSSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCSSV_MSSVMouseClicked
        // TODO add your handling code here:
        StringSelection stringSelection = new StringSelection(txtCSSV_MSSV.getText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }//GEN-LAST:event_txtCSSV_MSSVMouseClicked

    private void btn_edit_luuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_luuActionPerformed
        // TODO add your handling code here:
        if (txt_edit_Loaicd.getText().equals("Chăm sóc vắng học")) {
            lichSuChamSocVHDAO.insert(lichSuChamSocVHedit);
            int index = lichSuChamSocVHALL.indexOf(lichSuChamSocVHedit);
            lichSuChamSocVHedit.setLyDoGhiNhan(String.valueOf(cbo_edit_ldgn.getSelectedItem()));
            lichSuChamSocVHedit.setNguyenVongSvPh(String.valueOf(cbo_edit_nvsv.getSelectedItem()));
            lichSuChamSocVHedit.setDoiTuong(String.valueOf(cbo_edit_dt.getSelectedItem().toString()));
            lichSuChamSocVHedit.setPhanLoaiNguyCo(String.valueOf(cbo_edit_plnc.getSelectedItem()));
            lichSuChamSocVHedit.setDienGiaiCT(txt_edit_dgct.getText());
            lichSuChamSocVHDAO.insert(lichSuChamSocVHedit);
            lichSuChamSocVHALL.set(index, lichSuChamSocVHedit);
            fillToTableLichSuCSALL();
        } else if (txt_edit_Loaicd.getText().equals("Chăm sóc học phí")) {
            lichSuChamSOCHPDAO.insert(lichSuChamSocHPedit);
            int index = lichSuChamSocHPALL.indexOf(lichSuChamSocHPedit);
            lichSuChamSocHPedit.setLyDoGhiNhan(String.valueOf(cbo_edit_ldgn.getSelectedItem()));
            lichSuChamSocHPedit.setNguyenVongSvPh(String.valueOf(cbo_edit_nvsv.getSelectedItem()));
            lichSuChamSocHPedit.setDoiTuong(String.valueOf(cbo_edit_dt.getSelectedItem().toString()));
            lichSuChamSocHPedit.setPhanLoaiNguyCo(String.valueOf(cbo_edit_plnc.getSelectedItem()));
            lichSuChamSocHPedit.setDienGiaiCT(txt_edit_dgct.getText());
            lichSuChamSOCHPDAO.insert(lichSuChamSocHPedit);
            lichSuChamSocHPALL.set(index, lichSuChamSocHPedit);
            fillToTableLichSuCSALL();
        } else if (txt_edit_Loaicd.getText().equals("Chăm sóc 1D3")) {
            lichSuChamSOC1D3DAO.insert(lichSuChamSoc1D3edit);
            int index = lichSuChamSoc1DALL.indexOf(lichSuChamSoc1D3edit);
            lichSuChamSoc1D3edit.setLyDoGhiNhan(String.valueOf(cbo_edit_ldgn.getSelectedItem()));
            lichSuChamSoc1D3edit.setNguyenVongSvPh(String.valueOf(cbo_edit_nvsv.getSelectedItem()));
            lichSuChamSoc1D3edit.setDoiTuong(String.valueOf(cbo_edit_dt.getSelectedItem().toString()));
            lichSuChamSoc1D3edit.setPhanLoaiNguyCo(String.valueOf(cbo_edit_plnc.getSelectedItem()));
            lichSuChamSoc1D3edit.setDienGiaiCT(txt_edit_dgct.getText());
            lichSuChamSOC1D3DAO.insert(lichSuChamSoc1D3edit);
            lichSuChamSoc1DALL.set(index, lichSuChamSoc1D3edit);
            fillToTableLichSuCSALL();
        } else if (txt_edit_Loaicd.getText().equals("Chăm sóc EN")) {
            lichSuChamSOCENDAO.insert(lichSuChamSocENedit);
            int index = lichSuChamSocENALL.indexOf(lichSuChamSocENedit);
            lichSuChamSocENedit.setLyDoGhiNhan(String.valueOf(cbo_edit_ldgn.getSelectedItem()));
            lichSuChamSocENedit.setNguyenVongSvPh(String.valueOf(cbo_edit_nvsv.getSelectedItem()));
            lichSuChamSocENedit.setDoiTuong(String.valueOf(cbo_edit_dt.getSelectedItem().toString()));
            lichSuChamSocENedit.setPhanLoaiNguyCo(String.valueOf(cbo_edit_plnc.getSelectedItem()));
            lichSuChamSocENedit.setDienGiaiCT(txt_edit_dgct.getText());
            lichSuChamSOCENDAO.insert(lichSuChamSocENedit);
            lichSuChamSocENALL.set(index, lichSuChamSocENedit);
            fillToTableLichSuCSALL();
        }
        jdl_editLSCS.setVisible(false);
    }//GEN-LAST:event_btn_edit_luuActionPerformed

    private void cboNguyenVongCuaSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNguyenVongCuaSVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNguyenVongCuaSVActionPerformed

    private void mni_qlttcnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_qlttcnActionPerformed
        // TODO add your handling code here:
        this.jdlThongTinCaNhan.setTitle("Thông tin cá nhân");
        this.jdlThongTinCaNhan.setSize(354, 230);
        this.jdlThongTinCaNhan.setLocationRelativeTo(this);
        jlb_ttcn_Mans.setText(Auth.user.getMans());
        txt_ttcn_Hoten.setText(Auth.user.getHoVaten());
        txt_ttcn_matKhau.setText(Auth.user.getMatKhau());
        this.jdlThongTinCaNhan.setVisible(true);
    }//GEN-LAST:event_mni_qlttcnActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        String loaiDropList = jlb_loaiDopList.getText();
        switch (loaiDropList) {
            case "Lý do ghi nhận":
                cboLyDoNghiNhan.addItem(txt_themMoiDG.getText());
                cboLyDoNghiNhan.setSelectedItem(txt_themMoiDG.getText());
                this.jdl_ThemDG.setVisible(false);
                break;
            case "Nguyện vọng của sinh viên":
                cboNguyenVongCuaSV.addItem(txt_themMoiDG.getText());
                cboNguyenVongCuaSV.setSelectedItem(txt_themMoiDG.getText());
                this.jdl_ThemDG.setVisible(false);
                break;
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void btn_themldgnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themldgnActionPerformed
        // TODO add your handling code here:
        this.jdl_ThemDG.setTitle("Thêm đánh giá");
        this.jdl_ThemDG.setLocationRelativeTo(this);
        this.jdl_ThemDG.setSize(549, 161);
        this.jdl_ThemDG.setVisible(true);
        jlb_loaiDopList.setText("Lý do ghi nhận");
    }//GEN-LAST:event_btn_themldgnActionPerformed

    private void btn_themNvsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themNvsvActionPerformed
        // TODO add your handling code here:
        this.jdl_ThemDG.setTitle("Thêm đánh giá");
        this.jdl_ThemDG.setLocationRelativeTo(this);
        this.jdl_ThemDG.setSize(549, 161);
        this.jdl_ThemDG.setVisible(true);
        jlb_loaiDopList.setText("Nguyện vọng của sinh viên");
    }//GEN-LAST:event_btn_themNvsvActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        jdl_quanLyDl.setTitle("Tùy chỉnh tiêu chí");
        jdl_quanLyDl.setSize(770, 445);
        jdl_quanLyDl.setLocationRelativeTo(null);
        jdl_quanLyDl.setVisible(true);

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void cbo_TieuChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_TieuChiActionPerformed
        // TODO add your handling code here:
        fillToTableDl();
    }//GEN-LAST:event_cbo_TieuChiActionPerformed

    private void cbo_ChienDichDLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_ChienDichDLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_ChienDichDLActionPerformed

    private void jdl_ThemDGComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jdl_ThemDGComponentShown
        // TODO add your handling code here:
        txt_themMoiDG.setText("");
    }//GEN-LAST:event_jdl_ThemDGComponentShown

    private void jtb_DropListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_DropListMouseClicked
        // TODO add your handling code here:
        indexTableDl = jtb_DropList.getSelectedRow();
        jlb_maLoaiDl.setText(String.valueOf(jtb_DropList.getValueAt(indexTableDl, 1)));
        txt_noiDungDl.setText(String.valueOf(jtb_DropList.getValueAt(indexTableDl, 2)));
    }//GEN-LAST:event_jtb_DropListMouseClicked

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:

        if (dropListCTDAO.delete(new DropListCT(new DropList(jlb_maLoaiDl.getText()), new ChienDich(String.valueOf(cbo_ChienDichDL.getSelectedItem())), txt_noiDungDl.getText()))) {
            lamMoiFormTieuChi();
            String tieuChi = String.valueOf(cbo_TieuChi.getSelectedItem());
            modelDropList.setRowCount(0);
            int count = 1;
            switch (tieuChi) {
                case "Lý do ghi nhận":
                    cbo_ChienDichDL.setEnabled(true);
                    if (cbo_ChienDichDL.getSelectedItem().equals("CSHP")) {
                        dropListldgnhp.remove(indexTableDl);
                        for (DropListCT dropListCT : dropListldgnhp) {
                            modelDropList.addRow(new Object[]{count, dropListCT.getDropList().getMaLoaiDl(), dropListCT.getNoiDung()});
                            count++;
                        }
                    } else {
                        dropListldgnvh.remove(indexTableDl);
                        for (DropListCT dropListCT : dropListldgnvh) {
                            modelDropList.addRow(new Object[]{count, dropListCT.getDropList().getMaLoaiDl(), dropListCT.getNoiDung()});
                            count++;
                        }
                    }
                    break;
                case "Nguyện vọng":
                    cbo_ChienDichDL.setEnabled(true);
                    if (cbo_ChienDichDL.getSelectedItem().equals("CSHP")) {
                        dropListplnvhp.remove(indexTableDl);
                        for (DropListCT dropListCT : dropListplnvhp) {
                            modelDropList.addRow(new Object[]{count, dropListCT.getDropList().getMaLoaiDl(), dropListCT.getNoiDung()});
                            count++;
                        }
                    } else {
                        dropListnvvh.remove(indexTableDl);
                        for (DropListCT dropListCT : dropListnvvh) {
                            modelDropList.addRow(new Object[]{count, dropListCT.getDropList().getMaLoaiDl(), dropListCT.getNoiDung()});
                            count++;
                        }
                    }
                    break;
                case "Phân loại nguy cơ":
                    cbo_ChienDichDL.setEnabled(false);
                    cbo_ChienDichDL.setSelectedItem("CSVH");
                    dropListplnc.remove(indexTableDl);
                    for (DropListCT dropListCT : dropListplnc) {
                        modelDropList.addRow(new Object[]{count, dropListCT.getDropList().getMaLoaiDl(), dropListCT.getNoiDung()});
                        count++;
                    }
                    break;
                case "Đối tượng":
                    cbo_ChienDichDL.setEnabled(false);
                    cbo_ChienDichDL.setSelectedItem("CSVH");
                    dropListdt.remove(indexTableDl);
                    for (DropListCT dropListCT : dropListdt) {
                        modelDropList.addRow(new Object[]{count, dropListCT.getDropList().getMaLoaiDl(), dropListCT.getNoiDung()});
                        count++;
                    }
                    break;
            }
        } else {
            MsgBox.alert(this, "Vui lòng chọn DropList cần xóa.");
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jdl_editLSCSComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jdl_editLSCSComponentHidden
        // TODO add your handling code here:
        txt_edit_Loaicd.setText("");
        txt_edit_dgct.setText("");
        txt_edit_mssv.setText("");
        cbo_edit_dt.removeAllItems();
        cbo_edit_ldgn.removeAllItems();
        cbo_edit_nvsv.removeAllItems();
        cbo_edit_plnc.removeAllItems();
    }//GEN-LAST:event_jdl_editLSCSComponentHidden

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
        txt_noiDungDl.setText("");
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        if (!txt_noiDungDl.getText().equals("") || !String.valueOf(cbo_TieuChi.getSelectedItem()).equals("Lựa chọn")) {
            DropListCT dropListCT1 = new DropListCT(new DropList(jlb_maLoaiDl.getText()), new ChienDich(String.valueOf(cbo_ChienDichDL.getSelectedItem())), txt_noiDungDl.getText());
            if (dropListCTDAO.insert(dropListCT1)) {
                String tieuChi = String.valueOf(cbo_TieuChi.getSelectedItem());
                modelDropList.setRowCount(0);
                int count = 1;
                switch (tieuChi) {
                    case "Lý do ghi nhận":
                        cbo_ChienDichDL.setEnabled(true);
                        if (cbo_ChienDichDL.getSelectedItem().equals("CSHP")) {
                            dropListldgnhp.add(dropListCT1);
                            for (DropListCT dropListCT : dropListldgnhp) {
                                modelDropList.addRow(new Object[]{count, dropListCT.getDropList().getMaLoaiDl(), dropListCT.getNoiDung()});
                                count++;
                            }
                        } else {
                            dropListldgnvh.add(dropListCT1);
                            for (DropListCT dropListCT : dropListldgnvh) {
                                modelDropList.addRow(new Object[]{count, dropListCT.getDropList().getMaLoaiDl(), dropListCT.getNoiDung()});
                                count++;
                            }
                        }
                        break;
                    case "Nguyện vọng":
                        cbo_ChienDichDL.setEnabled(true);
                        dropListplnvhp.add(dropListCT1);
                        if (cbo_ChienDichDL.getSelectedItem().equals("CSHP")) {
                            for (DropListCT dropListCT : dropListplnvhp) {
                                modelDropList.addRow(new Object[]{count, dropListCT.getDropList().getMaLoaiDl(), dropListCT.getNoiDung()});
                                count++;
                            }
                        } else {
                            dropListnvvh.add(dropListCT1);
                            for (DropListCT dropListCT : dropListnvvh) {
                                modelDropList.addRow(new Object[]{count, dropListCT.getDropList().getMaLoaiDl(), dropListCT.getNoiDung()});
                                count++;
                            }
                        }
                        break;
                    case "Phân loại nguy cơ":
                        cbo_ChienDichDL.setEnabled(false);
                        cbo_ChienDichDL.setSelectedItem("CSVH");
                        dropListplnc.add(dropListCT1);
                        for (DropListCT dropListCT : dropListplnc) {
                            modelDropList.addRow(new Object[]{count, dropListCT.getDropList().getMaLoaiDl(), dropListCT.getNoiDung()});
                            count++;
                        }
                        break;
                    case "Đối tượng":
                        cbo_ChienDichDL.setEnabled(false);
                        cbo_ChienDichDL.setSelectedItem("CSVH");
                        dropListdt.add(dropListCT1);
                        for (DropListCT dropListCT : dropListdt) {
                            modelDropList.addRow(new Object[]{count, dropListCT.getDropList().getMaLoaiDl(), dropListCT.getNoiDung()});
                            count++;
                        }
                        break;

                }
            }
        } else {
            txt_editDropList_enroll.setText("Không thể để trống nội dung");
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jdl_quanLyDlComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jdl_quanLyDlComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jdl_quanLyDlComponentHidden

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
        txtLinkFileHistory.setText(TienIch.ChonFile());
    }// GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        if (cboHistory.getSelectedItem().equals("Chăm sóc vắng học")) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // Hiển thị ProgressBar
                    setProgressBarVisible(true);
                    int count = 0;
                    int cellNum = 0;
                    try {
                        String maChienDich = String.valueOf(System.currentTimeMillis());
                        ChienDichCD cdcd = new ChienDichCD(maChienDich, txtTenChienDichChuDong.getText(),
                                new Timestamp(System.currentTimeMillis()), false, Auth.user);
                        chienDichCDDAO.insert(cdcd);
                        ChienDich chienDich = new ChienDich("CSVH");
                        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                        if (sessionFactory != null) {
                            Session session = sessionFactory.openSession();
                            try {

                                try {

                                    FileInputStream fileInputStream = new FileInputStream(txtLinkFileHistory.getText());
                                    XSSFWorkbook xssfw = new XSSFWorkbook(fileInputStream);
                                    XSSFSheet sheet = xssfw.getSheetAt(0);
                                    FormulaEvaluator formulaEvaluator = xssfw.getCreationHelper()
                                            .createFormulaEvaluator();
                                    int totalRowCount = sheet.getLastRowNum();

                                    for (org.apache.poi.ss.usermodel.Row row : sheet) {
                                        Transaction transaction = session.beginTransaction();
                                        count++;
                                        LichSuChamSocVH lichSuChamSocVH = new LichSuChamSocVH();
                                        cellNum = 0;
                                        for (Cell cell : row) {
                                            switch (cellNum) {
                                                case 0:
                                                    lichSuChamSocVH.setHocKi(new HocKi(cell.getStringCellValue()));
                                                    try {
                                                    } catch (Exception e) {
                                                        lichSuChamSocVH.setHocKi(
                                                                new HocKi(String.valueOf(cell.getNumericCellValue())));
                                                    }

                                                    break;
                                                case 1:

                                                    lichSuChamSocVH.setChienDich(chienDich);

                                                    break;
                                                case 2:
												try {
                                                    lichSuChamSocVH.setMssv(cell.getStringCellValue());
                                                } catch (Exception e) {

                                                    break;
                                                }

                                                break;
                                                case 3:
												try {
                                                    lichSuChamSocVH.setChuyenNganh(cell.getStringCellValue());
                                                } catch (Exception e) {
                                                    System.out.println(e);
                                                }

                                                break;
                                                case 4:
												try {
                                                    lichSuChamSocVH.setMaMon(cell.getStringCellValue());
                                                } catch (Exception e) {
                                                    System.out.println(e);
                                                }

                                                break;
                                                case 5:
												try {
                                                    java.util.Date date = cell.getDateCellValue();
                                                    lichSuChamSocVH
                                                            .setThoiGianCS(new java.sql.Timestamp(date.getTime()));

                                                } catch (Exception e) {
                                                    System.out.println(e);
                                                }

                                                break;
                                                case 6:
												try {
                                                    lichSuChamSocVH.setKyHoc((int) cell.getNumericCellValue());
                                                } catch (Exception e) {
                                                    System.out.println(e);
                                                }

                                                break;
                                                case 7:
												try {
                                                    lichSuChamSocVH.setNhanSu(new NhanSu(cell.getStringCellValue()));
                                                } catch (Exception e) {
                                                    System.out.println(e);
                                                }

                                                break;
                                                case 8:
												try {
                                                    lichSuChamSocVH.setLyDoGhiNhan(cell.getStringCellValue());

                                                } catch (Exception e) {
                                                    System.out.println(e);
                                                }

                                                break;

                                                case 9:
												try {
                                                    lichSuChamSocVH.setDoiTuong(cell.getStringCellValue());

                                                } catch (Exception e) {
                                                    System.out.println(e);
                                                }

                                                break;
                                                case 10:
												try {
                                                    lichSuChamSocVH.setDienGiaiCT(cell.getStringCellValue());

                                                } catch (Exception e) {
                                                    System.out.println(e);
                                                }

                                                break;
                                                case 11:
												try {
                                                    lichSuChamSocVH.setPhanLoaiNguyCo(cell.getStringCellValue());

                                                } catch (Exception e) {
                                                    System.out.println(e);
                                                }

                                                break;
                                            }
                                            cellNum++;
                                        }

                                        lichSuChamSocVH.setChienDichCD(cdcd);
                                        try {
                                            session.saveOrUpdate(lichSuChamSocVH);
                                        } catch (Exception e) {

                                        }
                                        try {
                                            transaction.commit();
                                        } catch (Exception e) {
                                            System.out.println("Lỗi tại 22 %" + e);
                                        }

                                        int percentComplete = (int) (((double) count / (double) totalRowCount) * 100);
                                        jProgressBar1.setString(percentComplete + "%");
                                        // Xử lý chiến dịch chủ động ở đây
                                    }

                                    xssfw.close();
                                    fileInputStream.close();

                                } catch (Exception e) {

                                    System.out.println("Lỗi tại dòng: " + count + "  cột: " + cellNum
                                            + " Vui lòng kiểm tra lại file");
                                    System.out.println(e);
                                    return;

                                }

                                //     tjpro("Đang lưu");
                                //   txtTienTrinh.setText("Hoàn tất");
                                // Ẩn ProgressBar khi tác vụ đã hoàn thành
                                setProgressBarVisible(false);
                                MsgBox.alert(null, "Thành công!");
                            } finally {
                                session.close();
                            }
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e);
                    }
                }
            }).start();
            this.jdlImportSV.setVisible(false);
        }

    }// GEN-LAST:event_jButton26ActionPerformed

    private void jdc_qlcd_endDayKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jdc_qlcd_endDayKeyReleased
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String firstDay = sdf.format(jdc_qlcd_firstDay.getDate());
        String NextDay = sdf.format(jdc_qlcd_endDay.getDate());
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date fiDate = sdf.parse(firstDay);
            java.util.Date nDate = sdf.parse(NextDay);
            if (fiDate.compareTo(nDate) > 0) {
                MsgBox.alert(this, "Ngày không hợp lệ");
            } else {
            }
        } catch (ParseException ex) {

        }
    }// GEN-LAST:event_jdc_qlcd_endDayKeyReleased

    private void jdc_qlcd_endDayInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {// GEN-FIRST:event_jdc_qlcd_endDayInputMethodTextChanged
        // TODO add your handling code here:

    }// GEN-LAST:event_jdc_qlcd_endDayInputMethodTextChanged

    private void jdc_qlcd_endDayPropertyChange(java.beans.PropertyChangeEvent evt) {// GEN-FIRST:event_jdc_qlcd_endDayPropertyChange
//        // TODO add your handling code here:

    }// GEN-LAST:event_jdc_qlcd_endDayPropertyChange

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        java.util.Date firstDay = jdc_qlcd_firstDay.getDate();
        java.util.Date endDay = jdc_qlcd_endDay.getDate();
        if (!(firstDay == null || firstDay == null)) {
            if (firstDay.compareTo(endDay) > 0) {
                MsgBox.alert(this, "Ngày không hợp lệ");
            } else {
                Calendar startCal = Calendar.getInstance();
                startCal.setTime(firstDay);
                startCal.set(Calendar.HOUR_OF_DAY, 0);
                startCal.set(Calendar.MINUTE, 0);
                startCal.set(Calendar.SECOND, 0);
                startCal.set(Calendar.MILLISECOND, 0);
                java.util.Date startOfDay = startCal.getTime();

                Calendar endCal = Calendar.getInstance();
                endCal.setTime(endDay);
                endCal.set(Calendar.HOUR_OF_DAY, 23);
                endCal.set(Calendar.MINUTE, 59);
                endCal.set(Calendar.SECOND, 59);
                endCal.set(Calendar.MILLISECOND, 999);
                java.util.Date endOfDay = endCal.getTime();

                Timestamp startTimestamp = new Timestamp(startOfDay.getTime());
                Timestamp endTimestamp = new Timestamp(endOfDay.getTime());
                String chienDich = String.valueOf(cbo_Cs_ChienDich.getSelectedItem());
                if (chienDich.equals("CSVH")) {
                    modelSvCanCS.setRowCount(0);
                    List<DanhGiaVH> list = new ArrayList<>();
                    danhSachDGVHCn = danhGiaVHDAO.getChamSocCN(Auth.user.getMans());
                    for (DanhGiaVH danhGiaVH : danhSachDGVHCn) {
                        if (danhGiaVH.getChienDichCD().getThoiGianTao().compareTo(startTimestamp) >= 0
                                && danhGiaVH.getChienDichCD().getThoiGianTao().compareTo(endTimestamp) <= 0) {
                            list.add(danhGiaVH);
                        }
                    }
                    danhSachDGVHCn = list;
                    fillTableCanChamSocVH();
                } else if (chienDich.equals("CSHP")) {
                    modelSvCanCS.setRowCount(0);
                    List<DanhGiaHP> list = new ArrayList<>();
                    danhSachDGHPCn = danhGiaHPDAO.getChamSocCN(Auth.user.getMans());
                    for (DanhGiaHP danhGiaHP : danhSachDGHPCn) {
                        if (danhGiaHP.getChienDichCD().getThoiGianTao().compareTo(startTimestamp) >= 0
                                && danhGiaHP.getChienDichCD().getThoiGianTao().compareTo(endTimestamp) <= 0) {
                            list.add(danhGiaHP);
                        }
                    }
                    danhSachDGHPCn = list;
                    fillTableCanChamSocHP();
                } else if (chienDich.equals("CS1D3")) {
                    modelSvCanCS.setRowCount(0);
                    List<DanhGia1D3> list = new ArrayList<>();
                    danhSachDG1D3Cn = danhGia1D3DAO.getChamSocCN(Auth.user.getMans());
                    for (DanhGia1D3 danhGia1D3 : danhSachDG1D3Cn) {
                        if (danhGia1D3.getChienDichCD().getThoiGianTao().compareTo(startTimestamp) >= 0
                                && danhGia1D3.getChienDichCD().getThoiGianTao().compareTo(endTimestamp) <= 0) {
                            list.add(danhGia1D3);
                        }
                    }
                    danhSachDG1D3Cn = list;
                    fillTableCanChamSoc1D3();
                }
                if (chienDich.equals("CSEN")) {
                    modelSvCanCS.setRowCount(0);
                    List<DanhGiaEN> list = new ArrayList<>();
                    danhSachDGENCn = danhGiaENDAO.getChamSocCN(Auth.user.getMans());
                    for (DanhGiaEN danhGiaVH : danhSachDGENCn) {
                        if (danhGiaVH.getChienDichCD().getThoiGianTao().compareTo(startTimestamp) >= 0
                                && danhGiaVH.getChienDichCD().getThoiGianTao().compareTo(endTimestamp) <= 0) {
                            list.add(danhGiaVH);
                        }
                    }
                    danhSachDGENCn = list;
                    fillTableCanChamSocEN();
                }
            }
        }
    }// GEN-LAST:event_jButton7ActionPerformed

    private void jpnQuanLyCDComponentResized(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_jpnQuanLyCDComponentResized
        // TODO add your handling code here:
    }// GEN-LAST:event_jpnQuanLyCDComponentResized
// Xử lý sự kiện click vào bảng sinh viên cần chăm sóc

    private void jtbSVCanCSMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jtbSVCanCSMouseClicked
// + Lấy dòng người dùng chọn
        rowTableCS = jtbSVCanCS.getSelectedRow();
        // + Hiển thị thông tin đối tượng chăm sóc lên form chăm só
        fillToCS(rowTableCS);
    }// GEN-LAST:event_jtbSVCanCSMouseClicked

    private void jpnHomeComponentShown(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_jpnHomeComponentShown
// Kiem tra da hien thi chua
        JpmViewCt.add(jpnViewct);
        checkViewH = true;
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Hiển thị thanh ProgressBar và thực hiện tác vụ import
                setProgressBarVisible(true);
                jProgressBar1.setString("tải lịch sử...");
                loadDataLichSuCS();
                fillToTableLichSuCSALL();
                return null;
            }

            @Override
            protected void done() {
                setProgressBarVisible(false);
            }
        };
        // Khởi động SwingWorker
        worker.execute();
    }// GEN-LAST:event_jpnHomeComponentShown

    private void JListDanhSachIPMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_JListDanhSachIPMouseClicked
        // TODO add your handling code here:
        countClick++;
        if (countClick == 2) {
            countClick = 0;
            ChienDichCD chienDichCD = dsChienDichCD.get(JListDanhSachIP.getSelectedIndex());
            loadDataPhanCongTheoCDCD(chienDichCD.getMaChienDichChuDong());
            fillToTabledaPhanCong();
            fillToTableChuaPhanCong();
        }

        if (SwingUtilities.isRightMouseButton(evt)) {
            if (checkAD) {
                popupMenuDSIP.add(Jmenu_dsip_an);
                popupMenuDSIP.add(Jmenu_dsip_xoa);
                // Hiển thị JPopupMenu tại vị trí chuột click
                popupMenuDSIP.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }

    }// GEN-LAST:event_JListDanhSachIPMouseClicked

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        ExportFileExcel();

    }// GEN-LAST:event_jButton15ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        DeSelectAll();
    }// GEN-LAST:event_jButton11ActionPerformed

    private void btnSelectAllActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSelectAllActionPerformed
        // TODO add your handling code here:
        SelectAll();
    }// GEN-LAST:event_btnSelectAllActionPerformed

    private void btn_Home_TraCuuTheoNgayActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_Home_TraCuuTheoNgayActionPerformed
        // TODO add your handling code here:
        java.util.Date firstDay = jdc_Home_tuNgay.getDate();
        java.util.Date endDay = jdc_home_denNgay.getDate();
        if (!(jdc_Home_tuNgay.getDate() == null || jdc_home_denNgay.getDate() == null)) {

            if (firstDay.compareTo(endDay) > 0) {
                MsgBox.alert(this, "Ngày không hợp lệ");
            } else {
                Calendar startCal = Calendar.getInstance();
                startCal.setTime(firstDay);
                startCal.set(Calendar.HOUR_OF_DAY, 0);
                startCal.set(Calendar.MINUTE, 0);
                startCal.set(Calendar.SECOND, 0);
                startCal.set(Calendar.MILLISECOND, 0);
                java.util.Date startOfDay = startCal.getTime();

                Calendar endCal = Calendar.getInstance();
                endCal.setTime(endDay);
                endCal.set(Calendar.HOUR_OF_DAY, 23);
                endCal.set(Calendar.MINUTE, 59);
                endCal.set(Calendar.SECOND, 59);
                endCal.set(Calendar.MILLISECOND, 999);
                java.util.Date endOfDay = endCal.getTime();

                Timestamp fiDate = new Timestamp(startOfDay.getTime());
                Timestamp nDate = new Timestamp(endOfDay.getTime());
                boolean checkChonCD = cbo_Home_ChienDich.getSelectedItem().equals("Lựa chọn chiến dịch");
                boolean checkChonNS = cbo_Home_NhanSu.getSelectedItem().equals("Lựa chọn nhân sự");
                if (checkChonCD && checkChonNS) {
                    modelLichSuCS.setRowCount(0);
                    if (!(lichSuChamSocVHALL.isEmpty())) {
                        for (LichSuChamSocVH lichSuChamSoc : lichSuChamSocVHALL) {
                            if (fiDate.compareTo(lichSuChamSoc.getThoiGianCS()) <= 0
                                    && lichSuChamSoc.getThoiGianCS().compareTo(nDate) <= 0) {
                                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getTenChienDich(),
                                    lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                    lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                    lichSuChamSoc.getThoiGianCS()});
                            }
                        }
                    }
                    if (!(lichSuChamSocHPALL.isEmpty())) {
                        for (LichSuChamSocHP lichSuChamSoc : lichSuChamSocHPALL) {
                            if (fiDate.compareTo(lichSuChamSoc.getThoiGianCS()) <= 0
                                    && nDate.compareTo(lichSuChamSoc.getThoiGianCS()) >= 0) {
                                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                    lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                    lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                    lichSuChamSoc.getThoiGianCS()});
                            }
                        }
                    }
                    if (!(lichSuChamSoc1DALL.isEmpty())) {
                        for (LichSuChamSoc1D3 lichSuChamSoc : lichSuChamSoc1DALL) {
                            if (fiDate.compareTo(lichSuChamSoc.getThoiGianCS()) <= 0
                                    && nDate.compareTo(lichSuChamSoc.getThoiGianCS()) >= 0) {
                                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                    lichSuChamSoc.getMSSV(), lichSuChamSoc.getLyDoGhiNhan(),
                                    lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                    lichSuChamSoc.getThoiGianCS()});
                            }
                        }
                    }
                } else if (!checkChonCD && checkChonNS) {
                    if (cbo_Home_ChienDich.getSelectedItem().equals("CSVH")) {
                        modelLichSuCS.setRowCount(0);
                        for (LichSuChamSocVH lichSuChamSoc : lichSuChamSocVHALL) {
                            if (fiDate.compareTo(lichSuChamSoc.getThoiGianCS()) <= 0
                                    && nDate.compareTo(lichSuChamSoc.getThoiGianCS()) >= 0) {
                                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                    lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                    lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                    lichSuChamSoc.getThoiGianCS()});
                            }
                        }

                    } else if (cbo_Home_ChienDich.getSelectedItem().equals("CSHP")) {
                        modelLichSuCS.setRowCount(0);
                        for (LichSuChamSocHP lichSuChamSoc : lichSuChamSocHPALL) {
                            if (fiDate.compareTo(lichSuChamSoc.getThoiGianCS()) <= 0
                                    && nDate.compareTo(lichSuChamSoc.getThoiGianCS()) >= 0) {
                                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getTenChienDich(),
                                    lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                    lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                    lichSuChamSoc.getThoiGianCS()});
                            }
                        }
                    } else if (cbo_Home_ChienDich.getSelectedItem().equals("CS1D3")) {
                        modelLichSuCS.setRowCount(0);
                        for (LichSuChamSoc1D3 lichSuChamSoc : lichSuChamSoc1DALL) {
                            if (fiDate.compareTo(lichSuChamSoc.getThoiGianCS()) <= 0
                                    && nDate.compareTo(lichSuChamSoc.getThoiGianCS()) >= 0
                                    && lichSuChamSoc.getNhanSu().getMans().equals(cbo_Home_NhanSu.getSelectedItem())) {
                                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                    lichSuChamSoc.getMSSV(), lichSuChamSoc.getLyDoGhiNhan(),
                                    lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                    lichSuChamSoc.getThoiGianCS()});
                            }
                        }
                    } else if (cbo_Home_ChienDich.getSelectedItem().equals("CSEN")) {
                        modelLichSuCS.setRowCount(0);
                        for (LichSuChamSocEN lichSuChamSoc : lichSuChamSocENALL) {
                            if (fiDate.compareTo(lichSuChamSoc.getThoiGianCS()) <= 0
                                    && nDate.compareTo(lichSuChamSoc.getThoiGianCS()) >= 0) {
                                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                    lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                    lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                    lichSuChamSoc.getThoiGianCS()});
                            }
                        }

                    }

                } else if (!checkChonCD && !checkChonNS) {
                    if (cbo_Home_ChienDich.getSelectedItem().equals("CSVH")) {
                        modelLichSuCS.setRowCount(0);
                        for (LichSuChamSocVH lichSuChamSoc : lichSuChamSocVHALL) {
                            if (fiDate.compareTo(lichSuChamSoc.getThoiGianCS()) <= 0
                                    && nDate.compareTo(lichSuChamSoc.getThoiGianCS()) >= 0
                                    && lichSuChamSoc.getNhanSu().getMans().equals(cbo_Home_NhanSu.getSelectedItem())) {
                                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getTenChienDich(),
                                    lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                    lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                    lichSuChamSoc.getThoiGianCS()});
                            }
                        }

                    } else if (cbo_Home_ChienDich.getSelectedItem().equals("CSHP")) {
                        modelLichSuCS.setRowCount(0);
                        for (LichSuChamSocHP lichSuChamSoc : lichSuChamSocHPALL) {
                            if (fiDate.compareTo(lichSuChamSoc.getThoiGianCS()) <= 0
                                    && nDate.compareTo(lichSuChamSoc.getThoiGianCS()) >= 0
                                    && lichSuChamSoc.getNhanSu().getMans().equals(cbo_Home_NhanSu.getSelectedItem())) {
                                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                    lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                    lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                    lichSuChamSoc.getThoiGianCS()});
                            }
                        }
                    } else if (cbo_Home_ChienDich.getSelectedItem().equals("CS1D3")) {
                        modelLichSuCS.setRowCount(0);
                        for (LichSuChamSoc1D3 lichSuChamSoc : lichSuChamSoc1DALL) {
                            if (fiDate.compareTo(lichSuChamSoc.getThoiGianCS()) <= 0
                                    && nDate.compareTo(lichSuChamSoc.getThoiGianCS()) >= 0) {
                                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                    lichSuChamSoc.getMSSV(), lichSuChamSoc.getLyDoGhiNhan(),
                                    lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                    lichSuChamSoc.getThoiGianCS()});
                            }
                        }
                    } else if (cbo_Home_ChienDich.getSelectedItem().equals("CSEN")) {
                        modelLichSuCS.setRowCount(0);
                        for (LichSuChamSocEN lichSuChamSoc : lichSuChamSocENALL) {
                            if (fiDate.compareTo(lichSuChamSoc.getThoiGianCS()) <= 0
                                    && nDate.compareTo(lichSuChamSoc.getThoiGianCS()) >= 0
                                    && lichSuChamSoc.getNhanSu().getMans().equals(cbo_Home_NhanSu.getSelectedItem())) {
                                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                    lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                    lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                    lichSuChamSoc.getThoiGianCS()});
                            }
                        }

                    }

                } else if (checkChonCD && !checkChonNS) {
                    modelLichSuCS.setRowCount(0);
                    if (!(lichSuChamSocVHALL.isEmpty())) {
                        for (LichSuChamSocVH lichSuChamSoc : lichSuChamSocVHALL) {
                            if (fiDate.compareTo(lichSuChamSoc.getThoiGianCS()) <= 0
                                    && nDate.compareTo(lichSuChamSoc.getThoiGianCS()) >= 0
                                    && lichSuChamSoc.getNhanSu().getMans().equals(cbo_Home_NhanSu.getSelectedItem())) {
                                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                    lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                    lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                    lichSuChamSoc.getThoiGianCS()});
                            }
                        }
                    }
                    if (!(lichSuChamSocHPALL.isEmpty())) {
                        for (LichSuChamSocHP lichSuChamSoc : lichSuChamSocHPALL) {
                            if (fiDate.compareTo(lichSuChamSoc.getThoiGianCS()) <= 0
                                    && nDate.compareTo(lichSuChamSoc.getThoiGianCS()) >= 0
                                    && lichSuChamSoc.getNhanSu().getMans().equals(cbo_Home_NhanSu.getSelectedItem())) {
                                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                    lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                    lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                    lichSuChamSoc.getThoiGianCS()});
                            }
                        }
                    }
                    if (!(lichSuChamSoc1DALL.isEmpty())) {
                        for (LichSuChamSoc1D3 lichSuChamSoc : lichSuChamSoc1DALL) {
                            if (fiDate.compareTo(lichSuChamSoc.getThoiGianCS()) <= 0
                                    && nDate.compareTo(lichSuChamSoc.getThoiGianCS()) >= 0
                                    && lichSuChamSoc.getNhanSu().getMans().equals(cbo_Home_NhanSu.getSelectedItem())) {
                                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                    lichSuChamSoc.getMSSV(), lichSuChamSoc.getLyDoGhiNhan(),
                                    lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                    lichSuChamSoc.getThoiGianCS()});
                            }
                        }
                    }

                }

            }

        }
    }// GEN-LAST:event_btn_Home_TraCuuTheoNgayActionPerformed

    private void cbo_home_HocKyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbo_home_HocKyActionPerformed
        // TODO add your handling code here:
        if (cbo_Home_ChienDich.getItemCount() != 0 && cbo_Home_NhanSu.getItemCount() != 0
                && cbo_home_HocKy.getItemCount() != 0) {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            lichSuChamSocVHALL = lichSuChamSocVHDAO.LayLichSuTheoHK(String.valueOf(cbo_home_HocKy.getSelectedItem()));
            lichSuChamSocHPALL = lichSuChamSOCHPDAO.LayLichSuTheoHK(String.valueOf(cbo_home_HocKy.getSelectedItem()));
            lichSuChamSoc1DALL = lichSuChamSOC1D3DAO.LayLichSuTheoHK(String.valueOf(cbo_home_HocKy.getSelectedItem()));
            lichSuChamSocENALL = lichSuChamSOCENDAO.LayLichSuTheoHK(String.valueOf(cbo_home_HocKy.getSelectedItem()));
            cbo_Home_ChienDich.setSelectedIndex(0);
            cbo_Home_NhanSu.setSelectedIndex(0);
            fillToTableLichSuCSALL();
            setCursor(Cursor.getDefaultCursor());
        }
    }// GEN-LAST:event_cbo_home_HocKyActionPerformed

    private void cbo_home_HocKyMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_cbo_home_HocKyMouseClicked

    }// GEN-LAST:event_cbo_home_HocKyMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        hienThiForm();

    }// GEN-LAST:event_jButton6ActionPerformed

    private void txt_Home_mssvKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txt_Home_mssvKeyReleased
        // Tra cuu lich su cham soc theo ma so sinh vien
        modelLichSuCS.setRowCount(0);
        if (!(lichSuChamSocVHALL.isEmpty())) {
            for (LichSuChamSocVH lichSuChamSoc : lichSuChamSocVHALL) {
                if (lichSuChamSoc.getMssv().toLowerCase().contains(txt_Home_mssv.getText().toLowerCase())) {
                    modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                        lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(), lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(),
                        lichSuChamSoc.getNhanSu().getMans(), lichSuChamSoc.getThoiGianCS()});
                }
            }
        }
        if (!(lichSuChamSocHPALL.isEmpty())) {
            for (LichSuChamSocHP lichSuChamSoc : lichSuChamSocHPALL) {
                if (lichSuChamSoc.getMssv().toLowerCase().contains(txt_Home_mssv.getText().toLowerCase())) {
                    modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                        lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(), lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(),
                        lichSuChamSoc.getNhanSu().getMans(), lichSuChamSoc.getThoiGianCS()});
                }
            }
        }
        if (!(lichSuChamSoc1DALL.isEmpty())) {

            for (LichSuChamSoc1D3 lichSuChamSoc : lichSuChamSoc1DALL) {
                if (lichSuChamSoc.getMSSV().toLowerCase().contains(txt_Home_mssv.getText().toLowerCase())) {
                    modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                        lichSuChamSoc.getMSSV(), lichSuChamSoc.getLyDoGhiNhan(), lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(),
                        lichSuChamSoc.getNhanSu().getMans(), lichSuChamSoc.getThoiGianCS()});
                }
            }
        }
    }// GEN-LAST:event_txt_Home_mssvKeyReleased

    private void cbo_Home_NhanSuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbo_Home_NhanSuActionPerformed
        // TODO add your handling code here:
        boolean checkChonCD = cbo_Home_ChienDich.getSelectedItem().equals("Lựa chọn chiến dịch");
        if (cbo_Home_NhanSu.getSelectedItem().equals("Lựa chọn nhân sự")) {
            if (!checkChonCD) {
                if (cbo_Home_ChienDich.getSelectedItem().equals("CSVH")) {
                    modelLichSuCS.setRowCount(0);
                    if (!(lichSuChamSocVHALL.isEmpty())) {
                        for (LichSuChamSocVH lichSuChamSoc : lichSuChamSocVHALL) {

                            modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                lichSuChamSoc.getThoiGianCS()});
                        }
                    }
                } else if (cbo_Home_ChienDich.getSelectedItem().equals("CSHP")) {
                    modelLichSuCS.setRowCount(0);
                    if (!(lichSuChamSocHPALL.isEmpty())) {
                        for (LichSuChamSocHP lichSuChamSoc : lichSuChamSocHPALL) {

                            modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                lichSuChamSoc.getThoiGianCS()});
                        }
                    }
                } else if (cbo_Home_ChienDich.getSelectedItem().equals("CS1D3")) {
                    modelLichSuCS.setRowCount(0);
                    if (!(lichSuChamSoc1DALL.isEmpty())) {
                        for (LichSuChamSoc1D3 lichSuChamSoc : lichSuChamSoc1DALL) {

                            modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                lichSuChamSoc.getMSSV(), lichSuChamSoc.getLyDoGhiNhan(),
                                lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                lichSuChamSoc.getThoiGianCS()});
                        }
                    }
                }
                if (cbo_Home_ChienDich.getSelectedItem().equals("CSEN")) {
                    modelLichSuCS.setRowCount(0);
                    if (!(lichSuChamSocENALL.isEmpty())) {
                        for (LichSuChamSocEN lichSuChamSoc : lichSuChamSocENALL) {

                            modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                lichSuChamSoc.getThoiGianCS()});
                        }
                    }
                }
            } else {
                fillToTableLichSuCSALL();
            }
        } else {
            if (!checkChonCD) {
                if (cbo_Home_ChienDich.getSelectedItem().equals("CSVH")) {
                    modelLichSuCS.setRowCount(0);
                    if (!(lichSuChamSocVHALL.isEmpty())) {
                        for (LichSuChamSocVH lichSuChamSoc : lichSuChamSocVHALL) {
                            if (lichSuChamSoc.getNhanSu().getMans().equals(cbo_Home_NhanSu.getSelectedItem())) {
                                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                    lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                    lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                    lichSuChamSoc.getThoiGianCS()});
                            }
                        }
                    }
                } else if (cbo_Home_ChienDich.getSelectedItem().equals("CSHP")) {
                    modelLichSuCS.setRowCount(0);
                    if (!(lichSuChamSocHPALL.isEmpty())) {
                        for (LichSuChamSocHP lichSuChamSoc : lichSuChamSocHPALL) {
                            if (lichSuChamSoc.getNhanSu().getMans().equals(cbo_Home_NhanSu.getSelectedItem())) {
                                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getTenChienDich(),
                                    lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                    lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                    lichSuChamSoc.getThoiGianCS()});
                            }
                        }
                    }
                } else if (cbo_Home_ChienDich.getSelectedItem().equals("CS1D3")) {
                    modelLichSuCS.setRowCount(0);
                    if (!(lichSuChamSoc1DALL.isEmpty())) {
                        for (LichSuChamSoc1D3 lichSuChamSoc : lichSuChamSoc1DALL) {
                            if (lichSuChamSoc.getNhanSu().getMans().equals(cbo_Home_NhanSu.getSelectedItem())) {
                                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getTenChienDich(),
                                    lichSuChamSoc.getMSSV(), lichSuChamSoc.getLyDoGhiNhan(),
                                    lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                    lichSuChamSoc.getThoiGianCS()});
                            }
                        }
                    }
                } else if (cbo_Home_ChienDich.getSelectedItem().equals("CSVH")) {
                    modelLichSuCS.setRowCount(0);
                    if (!(lichSuChamSocENALL.isEmpty())) {
                        for (LichSuChamSocEN lichSuChamSoc : lichSuChamSocENALL) {
                            if (lichSuChamSoc.getNhanSu().getMans().equals(cbo_Home_NhanSu.getSelectedItem())) {
                                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getTenChienDich(),
                                    lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                    lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                    lichSuChamSoc.getThoiGianCS()});
                            }
                        }
                    }
                }
            } else {
                modelLichSuCS.setRowCount(0);
                if (!(lichSuChamSocVHALL.isEmpty())) {
                    for (LichSuChamSocVH lichSuChamSoc : lichSuChamSocVHALL) {
                        if (lichSuChamSoc.getNhanSu().getMans().equals(cbo_Home_NhanSu.getSelectedItem())) {
                            modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getTenChienDich(),
                                lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                lichSuChamSoc.getThoiGianCS()});
                        }
                    }
                }
                if (!(lichSuChamSocHPALL.isEmpty())) {
                    for (LichSuChamSocHP lichSuChamSoc : lichSuChamSocHPALL) {
                        if (lichSuChamSoc.getNhanSu().getMans().equals(cbo_Home_NhanSu.getSelectedItem())) {
                            modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                lichSuChamSoc.getThoiGianCS()});
                        }
                    }
                }
                if (!(lichSuChamSoc1DALL.isEmpty())) {
                    for (LichSuChamSoc1D3 lichSuChamSoc : lichSuChamSoc1DALL) {
                        if (lichSuChamSoc.getNhanSu().getMans().equals(cbo_Home_NhanSu.getSelectedItem())) {
                            modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                lichSuChamSoc.getMSSV(), lichSuChamSoc.getLyDoGhiNhan(),
                                lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                lichSuChamSoc.getThoiGianCS()});
                        }
                    }
                }

            }
        }
    }// GEN-LAST:event_cbo_Home_NhanSuActionPerformed

    private void cbo_Home_ChienDichActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbo_Home_ChienDichActionPerformed
        // TODO add your handling code here:
        boolean checkChonNS = cbo_Home_NhanSu.getSelectedItem().equals("Lựa chọn nhân sự");
        if (cbo_Home_ChienDich.getSelectedItem().equals("Lựa chọn chiến dịch")) {
            if (!checkChonNS) {
                modelLichSuCS.setRowCount(0);
                if (!(lichSuChamSocVHALL.isEmpty())) {
                    for (LichSuChamSocVH lichSuChamSoc : lichSuChamSocVHALL) {
                        if (lichSuChamSoc.getNhanSu().getMans().equals(cbo_Home_NhanSu.getSelectedItem())) {
                            modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                lichSuChamSoc.getThoiGianCS()});
                        }
                    }
                }
                if (!(lichSuChamSocHPALL.isEmpty())) {
                    for (LichSuChamSocHP lichSuChamSoc : lichSuChamSocHPALL) {
                        if (lichSuChamSoc.getNhanSu().getMans().equals(cbo_Home_NhanSu.getSelectedItem())) {
                            modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                lichSuChamSoc.getThoiGianCS()});
                        }
                    }
                }
                if (!(lichSuChamSoc1DALL.isEmpty())) {
                    for (LichSuChamSoc1D3 lichSuChamSoc : lichSuChamSoc1DALL) {
                        if (lichSuChamSoc.getNhanSu().getMans().equals(cbo_Home_NhanSu.getSelectedItem())) {
                            modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                lichSuChamSoc.getMSSV(), lichSuChamSoc.getLyDoGhiNhan(),
                                lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                lichSuChamSoc.getThoiGianCS()});
                        }
                    }
                }
            } else {
                fillToTableLichSuCSALL();
            }
        } else {
            if (!checkChonNS) {
                if (cbo_Home_ChienDich.getSelectedItem().equals("CSVH")) {
                    modelLichSuCS.setRowCount(0);
                    if (!(lichSuChamSocVHALL.isEmpty())) {
                        for (LichSuChamSocVH lichSuChamSoc : lichSuChamSocVHALL) {
                            if (lichSuChamSoc.getNhanSu().getMans().equals(cbo_Home_NhanSu.getSelectedItem())) {
                                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                    lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                    lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                    lichSuChamSoc.getThoiGianCS()});
                            }
                        }
                    }
                } else if (cbo_Home_ChienDich.getSelectedItem().equals("CSHP")) {
                    modelLichSuCS.setRowCount(0);
                    if (!(lichSuChamSocHPALL.isEmpty())) {
                        for (LichSuChamSocHP lichSuChamSoc : lichSuChamSocHPALL) {
                            if (lichSuChamSoc.getNhanSu().getMans().equals(cbo_Home_NhanSu.getSelectedItem())) {
                                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                    lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                    lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                    lichSuChamSoc.getThoiGianCS()});
                            }
                        }
                    }
                } else if (cbo_Home_ChienDich.getSelectedItem().equals("CS1D3")) {
                    modelLichSuCS.setRowCount(0);
                    if (!(lichSuChamSoc1DALL.isEmpty())) {
                        for (LichSuChamSoc1D3 lichSuChamSoc : lichSuChamSoc1DALL) {
                            if (lichSuChamSoc.getNhanSu().getMans().equals(cbo_Home_NhanSu.getSelectedItem())) {
                                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                    lichSuChamSoc.getMSSV(), lichSuChamSoc.getLyDoGhiNhan(),
                                    lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                    lichSuChamSoc.getThoiGianCS()});
                            }
                        }
                    }
                } else if (cbo_Home_ChienDich.getSelectedItem().equals("CSEN")) {
                    modelLichSuCS.setRowCount(0);
                    if (!(lichSuChamSocENALL.isEmpty())) {
                        for (LichSuChamSocEN lichSuChamSoc : lichSuChamSocENALL) {
                            if (lichSuChamSoc.getNhanSu().getMans().equals(cbo_Home_NhanSu.getSelectedItem())) {
                                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                    lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                    lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                    lichSuChamSoc.getThoiGianCS()});
                            }
                        }
                    }
                }
            } else {
                if (cbo_Home_ChienDich.getSelectedItem().equals("CSVH")) {
                    modelLichSuCS.setRowCount(0);
                    if (!(lichSuChamSocVHALL.isEmpty())) {
                        for (LichSuChamSocVH lichSuChamSoc : lichSuChamSocVHALL) {

                            modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                lichSuChamSoc.getThoiGianCS()});
                        }
                    }
                } else if (cbo_Home_ChienDich.getSelectedItem().equals("CSHP")) {
                    modelLichSuCS.setRowCount(0);
                    if (!(lichSuChamSocHPALL.isEmpty())) {
                        for (LichSuChamSocHP lichSuChamSoc : lichSuChamSocHPALL) {

                            modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                lichSuChamSoc.getThoiGianCS()});
                        }
                    }
                } else if (cbo_Home_ChienDich.getSelectedItem().equals("CS1D3")) {
                    modelLichSuCS.setRowCount(0);
                    if (!(lichSuChamSoc1DALL.isEmpty())) {
                        for (LichSuChamSoc1D3 lichSuChamSoc : lichSuChamSoc1DALL) {
                            modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                lichSuChamSoc.getMSSV(), lichSuChamSoc.getLyDoGhiNhan(),
                                lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                lichSuChamSoc.getThoiGianCS()});
                        }
                    }
                } else if (cbo_Home_ChienDich.getSelectedItem().equals("CSEN")) {
                    modelLichSuCS.setRowCount(0);
                    if (!(lichSuChamSocENALL.isEmpty())) {
                        for (LichSuChamSocEN lichSuChamSoc : lichSuChamSocENALL) {

                            modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                                lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(),
                                lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(), lichSuChamSoc.getNhanSu().getMans(),
                                lichSuChamSoc.getThoiGianCS()});
                        }
                    }
                }

            }
        }
    }// GEN-LAST:event_cbo_Home_ChienDichActionPerformed

    private void cbo_Home_NhanSuMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_cbo_Home_NhanSuMouseClicked
        // TODO add your handling code here:
    }// GEN-LAST:event_cbo_Home_NhanSuMouseClicked

    private void jtb_home_lichSuCsMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jtb_home_lichSuCsMouseClicked
        JpmViewCt.show(evt.getComponent(), evt.getX(), evt.getY());
        txt_viewCT.setText(getValueAt(jtb_home_lichSuCs));
        countLickTableLS++;
        if (countLickTableLS == 2) {
            countLickTableLS = 0;
            int row = jtb_home_lichSuCs.getSelectedRow();
            String tgcs = String.valueOf(jtb_home_lichSuCs.getValueAt(row, 6));
            String mssv = String.valueOf(jtb_home_lichSuCs.getValueAt(row, 1));
            if (String.valueOf(jtb_home_lichSuCs.getValueAt(row, 0)).equals("CSVH")) {
                for (LichSuChamSocVH lichSuChamSocVHs : lichSuChamSocVHALL) {
                    if (String.valueOf(lichSuChamSocVHs.getThoiGianCS()).equals(tgcs) && lichSuChamSocVHs.getMssv().equals(mssv)) {
                        lichSuChamSocVHedit = lichSuChamSocVHs;
                        txt_edit_mssv.setText(mssv);
                        txt_edit_Loaicd.setText(lichSuChamSocVHs.getChienDich().getTenChienDich());
                        txt_edit_dgct.setText(lichSuChamSocVHedit.getDienGiaiCT());
                        fillToDropListEdit("CSVH", lichSuChamSocVHedit.getLyDoGhiNhan(), lichSuChamSocVHedit.getDoiTuong(), lichSuChamSocVHedit.getPhanLoaiNguyCo(), lichSuChamSocVHedit.getNguyenVongSvPh());
                        break;
                    }
                }
            } else if (String.valueOf(jtb_home_lichSuCs.getValueAt(row, 0)).equals("CSHP")) {
                for (LichSuChamSocHP lichSuChamSocHPs : lichSuChamSocHPALL) {
                    if (String.valueOf(lichSuChamSocHPs.getThoiGianCS()).equals(tgcs) && lichSuChamSocHPs.getMssv().equals(mssv)) {
                        lichSuChamSocHPedit = lichSuChamSocHPs;
                        txt_edit_mssv.setText(mssv);
                        txt_edit_Loaicd.setText(lichSuChamSocHPs.getChienDich().getTenChienDich());
                        txt_edit_dgct.setText(lichSuChamSocHPedit.getDienGiaiCT());
                        fillToDropListEdit("CSHP", lichSuChamSocHPedit.getLyDoGhiNhan(), lichSuChamSocHPedit.getDoiTuong(), lichSuChamSocHPedit.getPhanLoaiNguyCo(), lichSuChamSocHPedit.getNguyenVongSvPh());
                        break;
                    }
                }
            } else if (String.valueOf(jtb_home_lichSuCs.getValueAt(row, 0)).equals("CS1D3")) {
                for (LichSuChamSoc1D3 lichSuChamSoc1D3s : lichSuChamSoc1DALL) {
                    if (String.valueOf(lichSuChamSoc1D3s.getThoiGianCS()).equals(tgcs) && lichSuChamSoc1D3s.getMSSV().equals(mssv)) {
                        lichSuChamSoc1D3edit = lichSuChamSoc1D3s;
                        txt_edit_mssv.setText(mssv);
                        txt_edit_Loaicd.setText(lichSuChamSoc1D3s.getChienDich().getTenChienDich());
                        txt_edit_dgct.setText(lichSuChamSoc1D3edit.getDienGiaiCT());
                        fillToDropListEdit("CSVH", lichSuChamSoc1D3edit.getLyDoGhiNhan(), lichSuChamSoc1D3edit.getDoiTuong(), lichSuChamSoc1D3edit.getPhanLoaiNguyCo(), lichSuChamSoc1D3edit.getNguyenVongSvPh());
                        break;
                    }
                }
            } else if (String.valueOf(jtb_home_lichSuCs.getValueAt(row, 0)).equals("CSEN")) {
                for (LichSuChamSocEN lichSuChamSocENs : lichSuChamSocENALL) {
                    if (String.valueOf(lichSuChamSocENs.getThoiGianCS()).equals(tgcs) && lichSuChamSocENs.getMssv().equals(mssv)) {
                        lichSuChamSocENedit = lichSuChamSocENs;
                        txt_edit_mssv.setText(mssv);
                        txt_edit_Loaicd.setText(lichSuChamSocENs.getChienDich().getTenChienDich());
                        txt_edit_dgct.setText(lichSuChamSocENedit.getDienGiaiCT());
                        fillToDropListEdit("CSVH", lichSuChamSocENedit.getLyDoGhiNhan(), lichSuChamSocENedit.getDoiTuong(), lichSuChamSocENedit.getPhanLoaiNguyCo(), lichSuChamSocENedit.getNguyenVongSvPh());
                        break;
                    }
                }
            }
            jdl_editLSCS.setTitle("Chỉnh sửa lịch sử chăm sóc");
            jdl_editLSCS.setSize(616, 320);
            jdl_editLSCS.setVisible(true);
            jdl_editLSCS.setLocationRelativeTo(this);
        }
    }// GEN-LAST:event_jtb_home_lichSuCsMouseClicked

    private void cbo_qlcd_NhanSuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbo_qlcd_NhanSuActionPerformed
        // TODO add your handling code here:
        if (cbo_qlcd_chienDich.getItemCount() != 0 && cbo_qlcd_NhanSu.getItemCount() != 0
                && cbo_qlcd_chuyenNganh.getItemCount() != 0) {
            int tabIndex = jtp_qlcd_daPC.getSelectedIndex();
            String tabName = jtp_qlcd_daPC.getTitleAt(tabIndex);
            boolean checkChonChuyenNganh = cbo_qlcd_chuyenNganh.getSelectedItem().equals("Lựa chọn chuyên ngành");
            boolean checkChonChienDich = cbo_qlcd_chienDich.getSelectedItem().equals("Lựa chọn chiến dịch");
            if (tabName.equals("Đã phân công")) {
                if (cbo_qlcd_NhanSu.getSelectedItem().equals("Lựa chọn nhân sự")) {
                    fillToCboCN(cbo_qlcd_chuyenNganh);
                    jlb_qlcd_ChuaCS.setText(tongChuaCS + "");
                    jlb_qlcd_Dacs.setText(tongdaCS + "");
                    jlb_qlcd_tong.setText((tongChuaCS + tongdaCS) + "");
                    if (checkChonChienDich && checkChonChuyenNganh) {
                        fillToTabledaPhanCong();
                    } else if (!checkChonChienDich && checkChonChuyenNganh) {
                        modelPhanCong.setRowCount(0);
                        int count = 1;
                        if (cbo_qlcd_chienDich.getSelectedItem().equals("CSHP")) {
                            for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSVH")) {
                            for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CS1D3")) {
                            for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSEN")) {
                            for (DanhGiaEN danhGiaVH : danhSachDGENdaPc) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                    } else if (!checkChonChienDich && !checkChonChuyenNganh) {
                        modelPhanCong.setRowCount(0);
                        int count = 1;
                        if (cbo_qlcd_chienDich.getSelectedItem().equals("CSHP")) {
                            for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                                if (danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSVH")) {
                            for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                                if (danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSEN")) {
                            for (DanhGiaEN danhGiaVH : danhSachDGENdaPc) {
                                if (danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CS1D3")) {
                            for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                                if (danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        }
                    } else if (checkChonChienDich && !checkChonChuyenNganh) {
                        modelPhanCong.setRowCount(0);
                        int count = 1;
                        for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                            if (danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                            if (danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                            if (danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                    }
                } else {
                    String maHki = String.valueOf(cbo_qLcd_hocKi.getSelectedItem());
                    String mans = String.valueOf(cbo_qlcd_NhanSu.getSelectedItem());
                    tongChuaCSofNS = danhGiaHPDAO.countByMans(mans) + danhGiaVHDAO.countByMans(mans)
                            + danhGia1D3DAO.countByMans(mans);
                    jlb_qlcd_ChuaCS.setText(tongChuaCSofNS + "");
                    tongdaCSofNS = lichSuChamSOC1D3DAO.countheoHKVaMans(maHki, mans)
                            + lichSuChamSOCHPDAO.countHKVaMans(maHki, mans)
                            + lichSuChamSocVHDAO.countheoHKVaMans(maHki, mans);
                    jlb_qlcd_Dacs.setText(tongdaCSofNS + "");
                    jlb_qlcd_tong.setText((tongChuaCSofNS + tongdaCSofNS) + "");
                    List<PhanCong> jobOfStaff = new ArrayList<>();
                    jobOfStaff = phanCongDAO.selectByMans(String.valueOf(cbo_qlcd_NhanSu.getSelectedItem()));
                    cbo_qlcd_chuyenNganh.removeAllItems();
                    cbo_qlcd_chuyenNganh.addItem("Lựa chọn chuyên ngành");
                    for (PhanCong phanCong : jobOfStaff) {
                        cbo_qlcd_chuyenNganh.addItem(phanCong.getChuyenNganh().getMaChuyenNganh());
                    }
                    if (checkChonChienDich && checkChonChuyenNganh) {
                        modelPhanCong.setRowCount(0);
                        int count = 1;
                        for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                            if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGiaEN danhGiaVH : danhSachDGENdaPc) {
                            if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                            if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                            if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                    } else if (!checkChonChienDich && checkChonChuyenNganh) {
                        modelPhanCong.setRowCount(0);
                        int count = 1;
                        if (cbo_qlcd_chienDich.getSelectedItem().equals("CSHP")) {
                            for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                                if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSVH")) {
                            for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                                if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSEN")) {
                            for (DanhGiaEN danhGiaVH : danhSachDGENdaPc) {
                                if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CS1D3")) {
                            for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                                if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        }
                    } else if (!checkChonChienDich && !checkChonChuyenNganh) {
                        modelPhanCong.setRowCount(0);
                        int count = 1;
                        if (cbo_qlcd_chienDich.getSelectedItem().equals("CSHP")) {
                            for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                                if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())
                                        && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSVH")) {
                            for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                                if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())
                                        && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSEN")) {
                            for (DanhGiaEN danhGiaVH : danhSachDGENdaPc) {
                                if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())
                                        && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CS1D3")) {
                            for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                                if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())
                                        && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        }
                    } else if (checkChonChienDich && !checkChonChuyenNganh) {
                        modelPhanCong.setRowCount(0);
                        int count = 1;
                        for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                            if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem()) && danhGiaVH
                                    .getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                            if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem()) && danhGiaVH
                                    .getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                            if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem()) && danhGiaVH
                                    .getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }

                    }
                }
            }
        }
    }// GEN-LAST:event_cbo_qlcd_NhanSuActionPerformed

    private void cbo_home_HocKyItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_cbo_home_HocKyItemStateChanged
        // TODO add your handling code here:

    }// GEN-LAST:event_cbo_home_HocKyItemStateChanged

    private void cbo_qLcd_hocKiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbo_qLcd_hocKiActionPerformed
        if (cbo_qLcd_hocKi.getItemCount() != 0 && cbo_qlcd_chienDich.getItemCount() != 0
                && cbo_qlcd_NhanSu.getItemCount() != 0 && cbo_qlcd_chuyenNganh.getItemCount() != 0) {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            danhSachDGVHdaPc = danhGiaVHDAO.layDanhSachDaPhanCong(String.valueOf(cbo_qLcd_hocKi.getSelectedItem()));
            danhSachDGVHchuaPc = danhGiaVHDAO.layDanhSachChoPhanCong(String.valueOf(cbo_qLcd_hocKi.getSelectedItem()));
            danhSachDGENdaPc = danhGiaENDAO.layDanhSachDaPhanCong(String.valueOf(cbo_qLcd_hocKi.getSelectedItem()));
            danhSachDGENchuaPc = danhGiaENDAO.layDanhSachChoPhanCong(String.valueOf(cbo_qLcd_hocKi.getSelectedItem()));
            danhSachDGHPdaPc = danhGiaHPDAO.layDanhSachDaPhanCong(String.valueOf(cbo_qLcd_hocKi.getSelectedItem()));
            List<DanhGiaHP> list = new ArrayList<>();
            for (DanhGiaHP danhGiaHP1 : danhSachDGHPdaPc) {
                if (danhGiaHP1.getTrangThai() || (danhGiaHP1.isTrangThaiBL() && danhGiaHP1.isTrangThaiHP()) || (danhGiaHP1.isTrangThaiBL() == false && danhGiaHP1.isTrangThaiHP() == false)) {
                    list.add(danhGiaHP1);
                }
            }
            danhSachDGHPdaPc = list;
            danhSachDGHPchuaPc = danhGiaHPDAO.layDanhSachChoPhanCong(String.valueOf(cbo_qLcd_hocKi.getSelectedItem()));
            List<DanhGiaHP> list2 = new ArrayList<>();
            for (DanhGiaHP danhGiaHP1 : danhSachDGHPchuaPc) {
                if (danhGiaHP1.getTrangThai() || (danhGiaHP1.isTrangThaiBL() && danhGiaHP1.isTrangThaiHP()) || (danhGiaHP1.isTrangThaiBL() == false && danhGiaHP1.isTrangThaiHP() == false)) {
                    list2.add(danhGiaHP1);
                }
            }
            danhSachDGHPchuaPc = list2;
            danhSachDG1D3daPc = danhGia1D3DAO.layDanhSachDaPhanCong(String.valueOf(cbo_qLcd_hocKi.getSelectedItem()));
            danhSachDG1D3chuaPc = danhGia1D3DAO
                    .layDanhSachChoPhanCong(String.valueOf(cbo_qLcd_hocKi.getSelectedItem()));
            cbo_qlcd_NhanSu.setSelectedIndex(0);
            cbo_qlcd_chienDich.setSelectedIndex(0);
            cbo_qlcd_chuyenNganh.setSelectedIndex(0);
            fillToTabledaPhanCong();
            fillToTableChuaPhanCong();
            setCursor(Cursor.getDefaultCursor());
        }
    }// GEN-LAST:event_cbo_qLcd_hocKiActionPerformed

    private void cbo_qlcd_chienDichActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbo_qlcd_chienDichActionPerformed
        // TODO add your handling code here:
        if (cbo_qlcd_chienDich.getItemCount() != 0 && cbo_qlcd_NhanSu.getItemCount() != 0
                && cbo_qlcd_chuyenNganh.getItemCount() != 0) {
            int tabIndex = jtp_qlcd_daPC.getSelectedIndex();
            String tabName = jtp_qlcd_daPC.getTitleAt(tabIndex);
            // boolean checkChonNhanSu = cbo_qlcd_NhanSu.getSelectedItem().equals("Lựa chọn
            // nhân sự");
            boolean checkChonChuyenNganh = cbo_qlcd_chuyenNganh.getSelectedItem().equals("Lựa chọn chuyên ngành");
            boolean checkChonNhanSu = cbo_qlcd_NhanSu.getSelectedItem().equals("Lựa chọn nhân sự");
            if (tabName.equals("Đã phân công")) {
                if (cbo_qlcd_chienDich.getSelectedItem().equals("Lựa chọn chiến dịch")) {
                    if (checkChonChuyenNganh && checkChonNhanSu) {
                        fillToTabledaPhanCong();
                    } else if (!checkChonChuyenNganh && !checkChonNhanSu) {
                        modelPhanCong.setRowCount(0);
                        int count = 1;
                        for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                            if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())
                                    && danhGiaVH.getMacn()
                                            .equalsIgnoreCase(String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                            }
                            count++;
                        }
                        for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                            if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())
                                    && danhGiaVH.getMacn()
                                            .equalsIgnoreCase(String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                            if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())
                                    && danhGiaVH.getMacn()
                                            .equalsIgnoreCase(String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                    } else if (checkChonChuyenNganh && !checkChonNhanSu) {
                        modelPhanCong.setRowCount(0);
                        int count = 1;
                        for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                            if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }

                        }
                        for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                            if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                            if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                    } else if (!checkChonChuyenNganh && checkChonNhanSu) {

                        modelPhanCong.setRowCount(0);
                        int count = 1;
                        for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                            if (danhGiaVH.getMacn()
                                    .equalsIgnoreCase(String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                            }
                            count++;
                        }
                        for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                            if (danhGiaVH.getMacn()
                                    .equalsIgnoreCase(String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                            if (danhGiaVH.getMacn()
                                    .equalsIgnoreCase(String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                    }
                } // co lua chon
                else {
                    if (cbo_qlcd_chienDich.getSelectedItem().equals("CSVH")) {
                        if (checkChonChuyenNganh && checkChonNhanSu) {
                            modelPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }

                        } else if (!checkChonChuyenNganh && !checkChonNhanSu) {
                            modelPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                                if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())
                                        && danhGiaVH.getMacn().equalsIgnoreCase(
                                                String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                }
                                count++;
                            }
                        } else if (!checkChonChuyenNganh && checkChonNhanSu) {
                            modelPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                                if (danhGiaVH.getMacn()
                                        .equalsIgnoreCase(String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }

                            }
                        } else if (checkChonChuyenNganh && !checkChonNhanSu) {
                            modelPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                                if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }

                            }
                        }

                    } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSHP")) {
                        if (checkChonChuyenNganh && checkChonNhanSu) {
                            modelPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        } else if (!checkChonChuyenNganh && !checkChonNhanSu) {
                            int count = 1;
                            modelPhanCong.setRowCount(0);
                            for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                                if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())
                                        && danhGiaVH.getMacn().equalsIgnoreCase(
                                                String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (!checkChonChuyenNganh && checkChonNhanSu) {
                            int count = 1;
                            modelPhanCong.setRowCount(0);
                            for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                                if (danhGiaVH.getMacn()
                                        .equalsIgnoreCase(String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (checkChonChuyenNganh && !checkChonNhanSu) {
                            int count = 1;
                            modelPhanCong.setRowCount(0);
                            for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                                if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        }
                    } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CS1D3")) {
                        if (checkChonChuyenNganh && checkChonNhanSu) {
                            modelPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        } else if (!checkChonChuyenNganh && !checkChonNhanSu) {
                            int count = 1;
                            modelPhanCong.setRowCount(0);
                            for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                                if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())
                                        && danhGiaVH.getMacn().equalsIgnoreCase(
                                                String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (!checkChonChuyenNganh && checkChonNhanSu) {
                            int count = 1;
                            modelPhanCong.setRowCount(0);
                            for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                                if (danhGiaVH.getMacn()
                                        .equalsIgnoreCase(String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (checkChonChuyenNganh && !checkChonNhanSu) {
                            int count = 1;
                            modelPhanCong.setRowCount(0);
                            for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                                if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        }
                    }
                    if (cbo_qlcd_chienDich.getSelectedItem().equals("CSEN")) {
                        if (checkChonChuyenNganh && checkChonNhanSu) {
                            modelPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaEN danhGiaVH : danhSachDGENdaPc) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }

                        } else if (!checkChonChuyenNganh && !checkChonNhanSu) {
                            modelPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaEN danhGiaVH : danhSachDGENdaPc) {
                                if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())
                                        && danhGiaVH.getMacn().equalsIgnoreCase(
                                                String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                }
                                count++;
                            }
                        } else if (!checkChonChuyenNganh && checkChonNhanSu) {
                            modelPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaEN danhGiaVH : danhSachDGENdaPc) {
                                if (danhGiaVH.getMacn()
                                        .equalsIgnoreCase(String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }

                            }
                        } else if (checkChonChuyenNganh && !checkChonNhanSu) {
                            modelPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaEN danhGiaVH : danhSachDGENdaPc) {
                                if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }

                            }
                        }

                    }
                }

            } // tab doi phan chia
            else {
                if (cbo_qlcd_chienDich.getSelectedItem().equals("Lựa chọn chiến dịch")) {
                    if (checkChonChuyenNganh) {
                        fillToTableChuaPhanCong();
                    } else {
                        model_qlcd_doiPhanCong.setRowCount(0);
                        int count = 1;
                        for (DanhGiaVH danhGiaVH : danhSachDGVHchuaPc) {
                            if (danhGiaVH.getMacn() != null) {
                                if (danhGiaVH.getMacn()
                                        .equalsIgnoreCase(String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                    model_qlcd_doiPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(), "Đang đợi",
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        }
                        for (DanhGiaHP danhGiaVH : danhSachDGHPchuaPc) {
                            if (danhGiaVH.getMacn() != null) {
                                if (danhGiaVH.getMacn()
                                        .equalsIgnoreCase(String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                    model_qlcd_doiPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(), "Đang đợi",
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        }
                        for (DanhGia1D3 danhGiaVH : danhSachDG1D3chuaPc) {
                            if (danhGiaVH.getMacn() != null) {
                                if (danhGiaVH.getMacn()
                                        .equalsIgnoreCase(String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                    model_qlcd_doiPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(), "Đang đợi",
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        }
                    }
                } else {
                    if (!checkChonChuyenNganh) {
                        if (cbo_qlcd_chienDich.getSelectedItem().equals("CSVH")) {
                            model_qlcd_doiPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaVH danhGiaVH : danhSachDGVHchuaPc) {
                                if (danhGiaVH.getMacn() != null) {
                                    if (danhGiaVH.getMacn()
                                            .equalsIgnoreCase(String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                        model_qlcd_doiPhanCong
                                                .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                            danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                            "Đang đợi", danhGiaVH.getChienDichCD().getThoiGianTao()});
                                        count++;
                                    }
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSHP")) {
                            model_qlcd_doiPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaHP danhGiaVH : danhSachDGHPchuaPc) {
                                if (danhGiaVH.getMacn() != null) {
                                    if (danhGiaVH.getMacn()
                                            .equalsIgnoreCase(String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                        model_qlcd_doiPhanCong
                                                .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                            danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                            "Đang đợi", danhGiaVH.getChienDichCD().getThoiGianTao()});
                                        count++;
                                    }
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CS1D3")) {
                            for (DanhGia1D3 danhGiaVH : danhSachDG1D3chuaPc) {
                                model_qlcd_doiPhanCong.setRowCount(0);
                                int count = 1;
                                if (danhGiaVH.getMacn() != null) {
                                    if (danhGiaVH.getMacn()
                                            .equalsIgnoreCase(String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                        model_qlcd_doiPhanCong
                                                .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                            danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                            "Đang đợi", danhGiaVH.getChienDichCD().getThoiGianTao()});
                                        count++;
                                    }
                                }
                            }
                        }
                        if (cbo_qlcd_chienDich.getSelectedItem().equals("CSEN")) {
                            model_qlcd_doiPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaEN danhGiaVH : danhSachDGENchuaPc) {
                                if (danhGiaVH.getMacn() != null) {
                                    if (danhGiaVH.getMacn()
                                            .equalsIgnoreCase(String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                        model_qlcd_doiPhanCong
                                                .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                            danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                            "Đang đợi", danhGiaVH.getChienDichCD().getThoiGianTao()});
                                        count++;
                                    }
                                }
                            }
                        }
                    } else {
                        if (cbo_qlcd_chienDich.getSelectedItem().equals("CSVH")) {
                            model_qlcd_doiPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaVH danhGiaVH : danhSachDGVHchuaPc) {
                                model_qlcd_doiPhanCong.addRow(new Object[]{count,
                                    danhGiaVH.getChienDich().getMaChienDich(), danhGiaVH.getSinhVien().getMssv(),
                                    danhGiaVH.getMacn(), "Đang đợi", danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSHP")) {
                            model_qlcd_doiPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaHP danhGiaVH : danhSachDGHPchuaPc) {
                                model_qlcd_doiPhanCong.addRow(new Object[]{count,
                                    danhGiaVH.getChienDich().getMaChienDich(), danhGiaVH.getSinhVien().getMssv(),
                                    danhGiaVH.getMacn(), "Đang đợi", danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CS1D3")) {
                            int count = 1;
                            model_qlcd_doiPhanCong.setRowCount(0);
                            for (DanhGia1D3 danhGiaVH : danhSachDG1D3chuaPc) {
                                model_qlcd_doiPhanCong.addRow(new Object[]{count,
                                    danhGiaVH.getChienDich().getMaChienDich(), danhGiaVH.getSinhVien().getMssv(),
                                    danhGiaVH.getMacn(), "Đang đợi", danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        if (cbo_qlcd_chienDich.getSelectedItem().equals("CSEN")) {
                            model_qlcd_doiPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaEN danhGiaVH : danhSachDGENchuaPc) {
                                model_qlcd_doiPhanCong.addRow(new Object[]{count,
                                    danhGiaVH.getChienDich().getMaChienDich(), danhGiaVH.getSinhVien().getMssv(),
                                    danhGiaVH.getMacn(), "Đang đợi", danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                    }
                }

            }
        }

    }// GEN-LAST:event_cbo_qlcd_chienDichActionPerformed

    private void cbo_qlcd_chuyenNganhActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbo_qlcd_chuyenNganhActionPerformed
        // TODO add your handling code here:
        if (cbo_qlcd_chienDich.getItemCount() != 0 && cbo_qlcd_NhanSu.getItemCount() != 0
                && cbo_qlcd_chuyenNganh.getItemCount() != 0) {
            int tabIndex = jtp_qlcd_daPC.getSelectedIndex();
            String tabName = jtp_qlcd_daPC.getTitleAt(tabIndex);
            boolean checkChonNhanSu = cbo_qlcd_NhanSu.getSelectedItem().equals("Lựa chọn nhân sự");
            boolean checkChonChienDich = cbo_qlcd_chienDich.getSelectedItem().equals("Lựa chọn chiến dịch");
            if (tabName.equals("Đã phân công")) {
                if (cbo_qlcd_chuyenNganh.getSelectedItem().equals("Lựa chọn chuyên ngành")) {
                    if (checkChonChienDich && checkChonNhanSu) {
                        fillToTabledaPhanCong();
                    } else if (!checkChonChienDich && checkChonNhanSu) {
                        modelPhanCong.setRowCount(0);
                        int count = 1;
                        if (cbo_qlcd_chienDich.getSelectedItem().equals("CSHP")) {
                            for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSVH")) {
                            for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CS1D3")) {
                            for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSEN")) {
                            for (DanhGiaEN danhGiaVH : danhSachDGENdaPc) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                    } else if (!checkChonChienDich && !checkChonNhanSu) {
                        modelPhanCong.setRowCount(0);
                        int count = 1;
                        if (cbo_qlcd_chienDich.getSelectedItem().equals("CSHP")) {
                            for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                                if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSVH")) {
                            for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                                if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSEN")) {
                            for (DanhGiaEN danhGiaVH : danhSachDGENdaPc) {
                                if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CS1D3")) {
                            for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                                if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        }
                    } else if (checkChonChienDich && !checkChonNhanSu) {
                        modelPhanCong.setRowCount(0);
                        int count = 1;
                        for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                            if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                            if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                            if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }

                    }
                } // combox co lua chon
                else {
                    if (checkChonChienDich && checkChonNhanSu) {
                        modelPhanCong.setRowCount(0);
                        int count = 1;
                        for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                            if (danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGiaEN danhGiaVH : danhSachDGENdaPc) {
                            if (danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                            if (danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                            if (danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                    } else if (!checkChonChienDich && checkChonNhanSu) {
                        modelPhanCong.setRowCount(0);
                        int count = 1;
                        if (cbo_qlcd_chienDich.getSelectedItem().equals("CSHP")) {
                            for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                                if (danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSVH")) {
                            for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                                if (danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSEN")) {
                            for (DanhGiaEN danhGiaVH : danhSachDGENdaPc) {
                                if (danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CS1D3")) {
                            for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                                if (danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        }
                    } else if (!checkChonChienDich && !checkChonNhanSu) {
                        modelPhanCong.setRowCount(0);
                        int count = 1;
                        if (cbo_qlcd_chienDich.getSelectedItem().equals("CSHP")) {
                            for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                                if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())
                                        && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSVH")) {
                            for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                                if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())
                                        && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSEN")) {
                            for (DanhGiaEN danhGiaVH : danhSachDGENdaPc) {
                                if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())
                                        && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CS1D3")) {
                            for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                                if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())
                                        && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        }
                    } else if (checkChonChienDich && !checkChonNhanSu) {
                        modelPhanCong.setRowCount(0);
                        int count = 1;
                        for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                            if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem()) && danhGiaVH
                                    .getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                            if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem()) && danhGiaVH
                                    .getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                            if (danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem()) && danhGiaVH
                                    .getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }

                    }
                }
            } // tab doi phan chia
            else {
                if (cbo_qlcd_chuyenNganh.getSelectedItem().equals("Lựa chọn chuyên ngành")) {
                    if (checkChonChienDich) {
                        fillToTableChuaPhanCong();
                    } else {
                        if (cbo_qlcd_chienDich.getSelectedItem().equals("CSVH")) {
                            model_qlcd_doiPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaVH danhGiaVH : danhSachDGVHchuaPc) {
                                model_qlcd_doiPhanCong.addRow(new Object[]{count,
                                    danhGiaVH.getChienDich().getMaChienDich(), danhGiaVH.getSinhVien().getMssv(),
                                    danhGiaVH.getMacn(), "Đang đợi", danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSHP")) {
                            model_qlcd_doiPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaHP danhGiaVH : danhSachDGHPchuaPc) {

                                model_qlcd_doiPhanCong.addRow(new Object[]{count,
                                    danhGiaVH.getChienDich().getMaChienDich(), danhGiaVH.getSinhVien().getMssv(),
                                    danhGiaVH.getMacn(), "Đang đợi", danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CS1D3")) {
                            model_qlcd_doiPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGia1D3 danhGiaVH : danhSachDG1D3chuaPc) {
                                model_qlcd_doiPhanCong.addRow(new Object[]{count,
                                    danhGiaVH.getChienDich().getMaChienDich(), danhGiaVH.getSinhVien().getMssv(),
                                    danhGiaVH.getMacn(), "Đang đợi", danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSEN")) {
                            model_qlcd_doiPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaEN danhGiaVH : danhSachDGENchuaPc) {
                                model_qlcd_doiPhanCong.addRow(new Object[]{count,
                                    danhGiaVH.getChienDich().getMaChienDich(), danhGiaVH.getSinhVien().getMssv(),
                                    danhGiaVH.getMacn(), "Đang đợi", danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                    }
                } else {
                    if (!checkChonChienDich) {
                        if (cbo_qlcd_chienDich.getSelectedItem().equals("CSVH")) {
                            model_qlcd_doiPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaVH danhGiaVH : danhSachDGVHchuaPc) {
                                if (danhGiaVH.getMacn() != null) {
                                    if (danhGiaVH.getMacn()
                                            .equalsIgnoreCase(String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                        model_qlcd_doiPhanCong
                                                .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                            danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                            "Đang đợi", danhGiaVH.getChienDichCD().getThoiGianTao()});
                                        count++;
                                    }
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSHP")) {
                            model_qlcd_doiPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaHP danhGiaVH : danhSachDGHPchuaPc) {
                                if (danhGiaVH.getMacn() != null) {
                                    if (danhGiaVH.getMacn()
                                            .equalsIgnoreCase(String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                        model_qlcd_doiPhanCong
                                                .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                            danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                            "Đang đợi", danhGiaVH.getChienDichCD().getThoiGianTao()});
                                        count++;
                                    }
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CS1D3")) {
                            for (DanhGia1D3 danhGiaVH : danhSachDG1D3chuaPc) {
                                model_qlcd_doiPhanCong.setRowCount(0);
                                int count = 1;
                                if (danhGiaVH.getMacn() != null) {
                                    if (danhGiaVH.getMacn()
                                            .equalsIgnoreCase(String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                        model_qlcd_doiPhanCong
                                                .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                            danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                            "Đang đợi", danhGiaVH.getChienDichCD().getThoiGianTao()});
                                        count++;
                                    }
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSEN")) {
                            model_qlcd_doiPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaEN danhGiaVH : danhSachDGENchuaPc) {
                                if (danhGiaVH.getMacn() != null) {
                                    if (danhGiaVH.getMacn()
                                            .equalsIgnoreCase(String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                        model_qlcd_doiPhanCong
                                                .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                            danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                            "Đang đợi", danhGiaVH.getChienDichCD().getThoiGianTao()});
                                        count++;
                                    }
                                }
                            }
                        }
                    } else {
                        model_qlcd_doiPhanCong.setRowCount(0);
                        int count = 1;
                        for (DanhGiaVH danhGiaVH : danhSachDGVHchuaPc) {
                            if (danhGiaVH.getMacn() != null) {
                                if (danhGiaVH.getMacn()
                                        .equalsIgnoreCase(String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                    model_qlcd_doiPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(), "Đang đợi",
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        }
                        for (DanhGiaHP danhGiaVH : danhSachDGHPchuaPc) {
                            if (danhGiaVH.getMacn() != null) {
                                if (danhGiaVH.getMacn()
                                        .equalsIgnoreCase(String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                    model_qlcd_doiPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(), "Đang đợi",
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        }
                        for (DanhGia1D3 danhGiaVH : danhSachDG1D3chuaPc) {
                            if (danhGiaVH.getMacn() != null) {
                                if (danhGiaVH.getMacn()
                                        .equalsIgnoreCase(String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                    model_qlcd_doiPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(), "Đang đợi",
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
        }
    }// GEN-LAST:event_cbo_qlcd_chuyenNganhActionPerformed

    private void txt_qlcd_mssvKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txt_qlcd_mssvKeyReleased

        int tabIndex = jtp_qlcd_daPC.getSelectedIndex();
        String tabName = jtp_qlcd_daPC.getTitleAt(tabIndex);
        if (tabName.equals("Đã phân công")) {
            modelPhanCong.setRowCount(0);
            int count = 1;
            for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                if (danhGiaVH.getSinhVien().getMssv().toLowerCase().contains(txt_qlcd_mssv.getText().toLowerCase())) {
                    modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(), danhGiaVH.getNhanSu().getMans(),
                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                    count++;
                }
            }
            for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                if (danhGiaVH.getSinhVien().getMssv().toLowerCase().contains(txt_qlcd_mssv.getText().toLowerCase())) {
                    modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(), danhGiaVH.getNhanSu().getMans(),
                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                    count++;
                }
            }
            for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                if (danhGiaVH.getSinhVien().getMssv().toLowerCase().contains(txt_qlcd_mssv.getText().toLowerCase())) {
                    modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(), danhGiaVH.getNhanSu().getMans(),
                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                    count++;
                }
            }
        } else {
            model_qlcd_doiPhanCong.setRowCount(0);
            int count = 1;
            for (DanhGiaVH danhGiaVH : danhSachDGVHchuaPc) {
                if (danhGiaVH.getSinhVien().getMssv().toLowerCase().contains(txt_qlcd_mssv.getText().toLowerCase())) {
                    model_qlcd_doiPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(), "Đang đợi",
                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                    count++;
                }
            }
            for (DanhGiaHP danhGiaVH : danhSachDGHPchuaPc) {
                if (danhGiaVH.getSinhVien().getMssv().toLowerCase().contains(txt_qlcd_mssv.getText().toLowerCase())) {
                    model_qlcd_doiPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(), "Đang đợi",
                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                    count++;
                }
            }
            for (DanhGia1D3 danhGiaVH : danhSachDG1D3chuaPc) {
                if (danhGiaVH.getSinhVien().getMssv().toLowerCase().contains(txt_qlcd_mssv.getText().toLowerCase())) {
                    model_qlcd_doiPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(), "Đang đợi",
                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                    count++;
                }
            }
        }
    }// GEN-LAST:event_txt_qlcd_mssvKeyReleased

    private void jpnCSVHMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jpnCSVHMouseClicked
        // TODO add your handling code here:

    }// GEN-LAST:event_jpnCSVHMouseClicked

    private void jpnSvChoMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jpnSvChoMouseClicked
        // TODO add your handling code here:

    }// GEN-LAST:event_jpnSvChoMouseClicked

    private void jpnCSVHComponentShown(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_jpnCSVHComponentShown
        // TODO add your handling code here:
        cbo_qlcd_NhanSu.setEnabled(false);
        fillToCboCN(cbo_qlcd_chuyenNganh);
        cbo_qlcd_chienDich.setSelectedIndex(0);
    }// GEN-LAST:event_jpnCSVHComponentShown

    private void jpnSvChoComponentShown(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_jpnSvChoComponentShown
         cbo_qlcd_NhanSu.setEnabled(true);
        // TODO add your handling code here:
    }// GEN-LAST:event_jpnSvChoComponentShown

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (checkAD || checkUr1) {
            jdlImportHP_BL.setSize(518, 176);
            jdlImportHP_BL.setLocationRelativeTo(this);
            jdlImportHP_BL.setTitle("Import học phí / bảo lưu");
            jdlImportHP_BL.setVisible(true);
            txt_import_HP_BL.setText("");
            cbo_Import_HPBL.setSelectedIndex(0);
        } else {
            MsgBox.alert(this, "Không thể truy cập tính năng này!");
        }
    }// GEN-LAST:event_jButton4ActionPerformed

    private void btn_Import_HpBlActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_Import_HpBlActionPerformed
        // TODO add your handling code here:
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Hiển thị ProgressBar
                setProgressBarVisible(true);
                int count = 0;
                if (cbo_Import_HPBL.getSelectedItem().equals("Học phí")) {
                    if (danhGiaHPDAO.updateHP()) {
                        DanhGiaHP danhGiaHP;
                        String masvip = "";
                        try {
                            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                            if (sessionFactory != null) {
                                Session session = sessionFactory.openSession();
                                try {
                                    Transaction transaction = session.beginTransaction();
                                    try {
                                        FileInputStream fileInputStream = new FileInputStream(txt_import_HP_BL.getText());
                                        XSSFWorkbook xssfw = new XSSFWorkbook(fileInputStream);
                                        XSSFSheet sheet = xssfw.getSheetAt(0);
                                        FormulaEvaluator formulaEvaluator = xssfw.getCreationHelper().createFormulaEvaluator();
                                        int totalRowCount = sheet.getLastRowNum();
                                        for (org.apache.poi.ss.usermodel.Row row : sheet) {
                                            int cellNum = 0;
                                            for (Cell cell : row) {
                                                switch (cellNum) {
                                                    case 0:							try {
                                                        masvip = cell.getStringCellValue();
                                                    } catch (Exception e) {
                                                        masvip = String.valueOf(cell.getNumericCellValue());
                                                    }
                                                    break;
                                                }
                                                cellNum++;
                                            }
                                            danhGiaHP = danhGiaHPDAO.selectByMssv(masvip);
                                            if (danhGiaHP != null) {
                                                danhGiaHP.setTrangThaiHP(true);
                                                session.saveOrUpdate(danhGiaHP);
                                            }
                                            count++;
                                            int percentComplete = (int) (((double) count / (double) totalRowCount) * 100);
                                            jProgressBar1.setString(percentComplete + "%");
                                        }

                                        xssfw.close();
                                        fileInputStream.close();
                                    } catch (Exception e) {
                                        System.out.println("Lỗi rồi:" + e);
                                        if (e instanceof java.io.FileNotFoundException) {
                                            jlb_enroll_ImportHPBL.setText("Không tìm thấy file. Vui Lòng kiểm tra lại đường dẫn.");
                                            setProgressBarVisible(false);
                                            return;
                                        }
                                    }
                                    transaction.commit();
                                    MsgBox.alert(null, "Import danh sách đã nộp học phí thành công.");
                                    loadDataPhanCong();
                                    fillToTableChuaPhanCong();
                                    fillToTabledaPhanCong();
                                    jdlImportHP_BL.setVisible(false);
                                } finally {
                                    session.close();
                                }
                            }
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                    } else {
                        MsgBox.alert(null, "Vui lòng thử lại");
                    }
                } else if (cbo_Import_HPBL.getSelectedItem().equals("Bảo lưu")) {
                    if (danhGiaHPDAO.updateBL()) {
                        DanhGiaHP danhGiaHP;
                        String masvip = "";
                        try {
                            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                            if (sessionFactory != null) {
                                Session session = sessionFactory.openSession();
                                try {
                                    Transaction transaction = session.beginTransaction();
                                    try {
                                        FileInputStream fileInputStream = new FileInputStream(txt_import_HP_BL.getText());
                                        XSSFWorkbook xssfw = new XSSFWorkbook(fileInputStream);
                                        XSSFSheet sheet = xssfw.getSheetAt(0);
                                        FormulaEvaluator formulaEvaluator = xssfw.getCreationHelper().createFormulaEvaluator();
                                        int totalRowCount = sheet.getLastRowNum();
                                        for (org.apache.poi.ss.usermodel.Row row : sheet) {

                                            int cellNum = 0;
                                            for (Cell cell : row) {
                                                switch (cellNum) {
                                                    case 0:
										try {
                                                        masvip = cell.getStringCellValue();
                                                    } catch (Exception e) {
                                                        masvip = String.valueOf(cell.getNumericCellValue());
                                                    }
                                                    break;
                                                }
                                                cellNum++;
                                            }
                                            danhGiaHP = danhGiaHPDAO.selectByMssv(masvip);
                                            if (danhGiaHP != null) {
                                                danhGiaHP.setTrangThaiBL(true);
                                                session.saveOrUpdate(danhGiaHP);
                                            }
                                            count++;
                                            int percentComplete = (int) (((double) count / (double) totalRowCount) * 100);
                                            jProgressBar1.setString("Đang tải: " + percentComplete + " / " + "100%");
                                        }
                                        xssfw.close();
                                        fileInputStream.close();

                                    } catch (Exception e) {
                                        System.out.println("Lỗi rồi:" + e);
                                        if (e instanceof java.io.FileNotFoundException) {
                                            jlb_enroll_ImportHPBL.setText("Không tìm thấy file. Vui Lòng kiểm tra lại đường dẫn.");
                                            setProgressBarVisible(false);
                                            return;
                                        }
                                    }
                                    transaction.commit();
                                    MsgBox.alert(null, "Import danh sách đã bảo lưu thành công.");
                                    loadDataPhanCong();
                                    fillToTableChuaPhanCong();
                                    fillToTabledaPhanCong();
                                    jdlImportHP_BL.setVisible(false);
                                } finally {
                                    session.close();
                                }
                            }
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                    } else {
                        MsgBox.alert(null, "Vui lòng thử lại");
                    }

                } else {

                    DanhGiaHP danhGiaHP;
                    String masvip = "";
                    try {
                        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                        if (sessionFactory != null) {
                            Session session = sessionFactory.openSession();
                            try {
                                Transaction transaction = session.beginTransaction();
                                try {
                                    FileInputStream fileInputStream = new FileInputStream(txt_import_HP_BL.getText());
                                    XSSFWorkbook xssfw = new XSSFWorkbook(fileInputStream);
                                    XSSFSheet sheet = xssfw.getSheetAt(0);
                                    FormulaEvaluator formulaEvaluator = xssfw.getCreationHelper().createFormulaEvaluator();
                                    int totalRowCount = sheet.getLastRowNum();
                                    for (org.apache.poi.ss.usermodel.Row row : sheet) {
                                        int cellNum = 0;
                                        for (Cell cell : row) {
                                            switch (cellNum) {
                                                case 0:							try {
                                                    masvip = cell.getStringCellValue();
                                                } catch (Exception e) {
                                                    masvip = String.valueOf(cell.getNumericCellValue());
                                                }
                                                break;
                                            }
                                            cellNum++;
                                        }
                                        danhGiaHP = danhGiaHPDAO.selectByMssv(masvip);
                                        if (danhGiaHP != null) {
                                            danhGiaHP.setTrangThaiHP(false);
                                            danhGiaHP.setTrangThai(true);
                                            session.saveOrUpdate(danhGiaHP);
                                        }
                                        count++;
                                        int percentComplete = (int) (((double) count / (double) totalRowCount) * 100);
                                        jProgressBar1.setString(percentComplete + "%");
                                    }
                                    xssfw.close();
                                    fileInputStream.close();

                                } catch (Exception e) {
                                    System.out.println("Lỗi rồi:" + e);
                                    if (e instanceof java.io.FileNotFoundException) {
                                        jlb_enroll_ImportHPBL.setText("Không tìm thấy file. Vui Lòng kiểm tra lại đường dẫn.");
                                        setProgressBarVisible(false);
                                        return;
                                    }
                                }
                                transaction.commit();
                                MsgBox.alert(null, "Import danh sách rút học phí thành công.");
                                loadDataPhanCong();
                                fillToTableChuaPhanCong();
                                fillToTabledaPhanCong();
                                jdlImportHP_BL.setVisible(false);
                            } finally {
                                session.close();
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                // Ẩn ProgressBar khi tác vụ đã hoàn thành
                setProgressBarVisible(false);
            }
        }).start();
        setCursor(Cursor.getDefaultCursor());
    }// GEN-LAST:event_btn_Import_HpBlActionPerformed

    private void cboTatCaNSActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cboTatCaNSActionPerformed
        // TODO add your handling code here:

        FilloTableDSNSALL();
    }// GEN-LAST:event_cboTatCaNSActionPerformed

    private void cboNhanSuOnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cboNhanSuOnActionPerformed
        // TODO add your handling code here:
        FilloTableDSNSON();
    }// GEN-LAST:event_cboNhanSuOnActionPerformed

    private void cboNhanSuOffActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cboNhanSuOffActionPerformed
        // TODO add your handling code here:
        FilloTableDSNSOFF();
    }// GEN-LAST:event_cboNhanSuOffActionPerformed

    private void tblDanhSachNSMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblDanhSachNSMouseClicked
        // TODO add your handling code here:
        this.row = tblDanhSachNS.getSelectedRow();
        fillToForm();
    }// GEN-LAST:event_tblDanhSachNSMouseClicked

    private void rdoUser1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rdoUser1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_rdoUser1ActionPerformed

    private void tblNsPhuTrachCNMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblNsPhuTrachCNMouseClicked
        // TODO add your handling code here:
        this.rowTablePC = tblNsPhuTrachCN.getSelectedRow();
        // NhanSu ns = nhanSuDAO.selectById(txtMaNS.getText());

    }// GEN-LAST:event_tblNsPhuTrachCNMouseClicked

    private void btnLuuTTNSActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLuuTTNSActionPerformed
        // TODO add your handling code here:
        luuNhanSu();
    }// GEN-LAST:event_btnLuuTTNSActionPerformed

    private void btnLuuTTNS1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLuuTTNS1ActionPerformed
        // TODO add your handling code here:
        clearFormNhanSu();
    }// GEN-LAST:event_btnLuuTTNS1ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        DialogPhanCong.setTitle("Phân công chuyên ngành");
        DialogPhanCong.setSize(450, 220);
        DialogPhanCong.setLocationRelativeTo(null);
        DialogPhanCong.setVisible(true);

    }// GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:

        xoaNhanSuPhuTrach();

    }// GEN-LAST:event_jButton17ActionPerformed

    private void cbbChienDichActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbbChienDichActionPerformed
        // TODO add your handling code here:

    }// GEN-LAST:event_cbbChienDichActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:

        String tenCD = String.valueOf(cbbChienDich.getSelectedItem());
        String tenCN = String.valueOf(cbbChuyenNganh.getSelectedItem());
        tenCN = tenCN.substring(0, tenCN.indexOf(" - "));
        NhanSu nhanSu = dsns.get(row);
        ChienDich chienDich = chienDichDAO.selectByName(tenCD);
        ChuyenNganh chuyenNganh = chuyenNganhDAO.selectByName(tenCN);
        PhanCong pc = new PhanCong(nhanSu, chienDich, chuyenNganh);
        listPhanCongCuaMotNhanSu.add(pc);
        filltoTablePCSua();

        // fillToTablePhanCong();
        // pc.setNhanSu();
    }// GEN-LAST:event_jButton13ActionPerformed

    private void DialogPhanCongComponentShown(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_DialogPhanCongComponentShown
        // TODO add your handling code here:
        List<ChienDich> listcd = chienDichDAO.selectAll();
        cbbChienDich.removeAllItems();
        cbbChuyenNganh.removeAllItems();
        for (ChienDich cs : listcd) {
            cbbChienDich.addItem(cs.getTenChienDich());
        }
        List<ChuyenNganh> listcn = chuyenNganhDAO.selectAll();
        for (ChuyenNganh cn : listcn) {
            cbbChuyenNganh.addItem(cn.getTenChuyenNganh() + " - " + cn.getMaChuyenNganh());
        }
    }// GEN-LAST:event_DialogPhanCongComponentShown

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXacNhanActionPerformed
        // TODO add your handling code here:
        ChuyenPhanCong();

    }// GEN-LAST:event_btnXacNhanActionPerformed

    private void Jtable_PhanCongRoiMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_Jtable_PhanCongRoiMouseClicked
        // TODO add your handling code here:
        if (cbo_qlcd_chienDich.getSelectedItem().equals("Lựa chọn chiến dịch")) {
            MsgBox.alert(null, "Bạn cần lựa chọn theo loại chiến dịch để chuyển đổi");
        } else {
            tongs = Jtable_PhanCongRoi.getSelectedRows();
            listMasv.clear();
            for (int i = 0; i < tongs.length; i++) {
                String masv = String.valueOf(Jtable_PhanCongRoi.getValueAt(tongs[i], 2));
                // hiển thị mã sv đã chọn
                listMasv.add(masv);
            }
            if (SwingUtilities.isRightMouseButton(evt)) {
                if (checkAD) {
                    JmenuTongSvChon.setText("Số lượng : " + tongs.length);
                    popupMenuDaPc.add(JmenuTongSvChon);
                    popupMenuDaPc.add(Jmn_ChuyenSv);
                    popupMenuDaPc.add(jMenuDeleteObj);
                    // Hiển thị JPopupMenu tại vị trí chuột click
                    popupMenuDaPc.show(evt.getComponent(), evt.getX(), evt.getY());
                }
            }

        }

    }// GEN-LAST:event_Jtable_PhanCongRoiMouseClicked

    private void DialogProgressBarWindowOpened(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_DialogProgressBarWindowOpened
        // TODO add your handling code here:
    }// GEN-LAST:event_DialogProgressBarWindowOpened

    private void jtb_qlcd_chuaPCMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jtb_qlcd_chuaPCMouseClicked
        // TODO add your handling code here:
        if (cbo_qlcd_chienDich.getSelectedItem().equals("Lựa chọn chiến dịch")) {
            MsgBox.alert(null, "Lựa chọn chiến dịch cần theo tác");
        } else {
            tongsChuaPC = jtb_qlcd_chuaPC.getSelectedRows();
            // fillToTableChuaPhanCong();
            listMasv.clear();
            for (int i = 0; i < tongsChuaPC.length; i++) {
                String masv = String.valueOf(jtb_qlcd_chuaPC.getValueAt(tongsChuaPC[i], 2));
                listMasv.add(masv);
            }
            if (SwingUtilities.isRightMouseButton(evt)) {
                if (checkAD) {
                    JmenuTongSvChon.setText("Số lượng : " + tongsChuaPC.length);
                    popupMenuChuaPc.add(JmenuTongSvChon);
                    popupMenuChuaPc.add(Jmn_ChuyenSv);
                    popupMenuChuaPc.add(jMenuDeleteObj);
                    // Hiển thị JPopupMenu tại vị trí chuột click
                    popupMenuChuaPc.show(evt.getComponent(), evt.getX(), evt.getY());
                }
            }
        }

    }// GEN-LAST:event_jtb_qlcd_chuaPCMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        txt_import_HP_BL.setText(TienIch.ChonFile());
    }

    private void btn_qlcd_TimActionPerformed(java.awt.event.ActionEvent evt) {
        java.util.Date firstDay = jdc_qlcd_tuNgay.getDate();
        java.util.Date endDay = jdc_qlcd_denNgay.getDate();
        if (!(firstDay == null || firstDay == null)) {
            if (firstDay.compareTo(endDay) > 0) {
                MsgBox.alert(this, "Ngày không hợp lệ");
            } else {
                Calendar startCal = Calendar.getInstance();
                startCal.setTime(firstDay);
                startCal.set(Calendar.HOUR_OF_DAY, 0);
                startCal.set(Calendar.MINUTE, 0);
                startCal.set(Calendar.SECOND, 0);
                startCal.set(Calendar.MILLISECOND, 0);
                java.util.Date startOfDay = startCal.getTime();

                Calendar endCal = Calendar.getInstance();
                endCal.setTime(endDay);
                endCal.set(Calendar.HOUR_OF_DAY, 23);
                endCal.set(Calendar.MINUTE, 59);
                endCal.set(Calendar.SECOND, 59);
                endCal.set(Calendar.MILLISECOND, 999);
                java.util.Date endOfDay = endCal.getTime();

                Timestamp fiDate = new Timestamp(startOfDay.getTime());
                Timestamp nDate = new Timestamp(endOfDay.getTime());
                boolean checkChonNS = cbo_qlcd_NhanSu.getSelectedItem().equals("Lựa chọn nhân sự");
                boolean checkChonCD = cbo_qlcd_chienDich.getSelectedItem().equals("Lựa chọn chiến dịch");
                boolean checkChonCN = cbo_qlcd_chuyenNganh.getSelectedItem().equals("Lựa chọn chuyên ngành");
                int tabIndex = jtp_qlcd_daPC.getSelectedIndex();
                String tabName = jtp_qlcd_daPC.getTitleAt(tabIndex);
                if (tabName.equals("Đã phân công")) {
                    // Đã đúng
                    if (checkChonCD && checkChonCN && checkChonNS) {
                        modelPhanCong.setRowCount(0);
                        int count = 1;
                        for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                            if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                    && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                            if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                    && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                            if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                    && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                    } // Đã đúng
                    else if (!checkChonCD && checkChonCN && checkChonNS) {
                        if (cbo_qlcd_chienDich.getSelectedItem().equals("CSVH")) {

                            for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                                modelPhanCong.setRowCount(0);
                                int count = 1;
                                if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                        && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0) {

                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }

                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSHP")) {
                            modelPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                                if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                        && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CS1D3")) {
                            modelPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                                if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                        && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }

                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSEN")) {

                            for (DanhGiaEN danhGiaVH : danhSachDGENdaPc) {
                                modelPhanCong.setRowCount(0);
                                int count = 1;
                                if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                        && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0) {

                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }

                        }
                    } // Test pass
                    else if (!checkChonCD && !checkChonCN && checkChonNS) {
                        if (cbo_qlcd_chienDich.getSelectedItem().equals("CSVH")) {

                            for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                                modelPhanCong.setRowCount(0);
                                int count = 1;
                                if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                        && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                        && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }

                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSHP")) {
                            modelPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                                if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                        && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                        && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CS1D3")) {
                            modelPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                                if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                        && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                        && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }

                        }
                        if (cbo_qlcd_chienDich.getSelectedItem().equals("CSEN")) {

                            for (DanhGiaEN danhGiaVH : danhSachDGENdaPc) {
                                modelPhanCong.setRowCount(0);
                                int count = 1;
                                if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                        && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                        && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }

                        }
                    } // Test past
                    else if (!checkChonCD && checkChonCN && !checkChonNS) {
                        if (cbo_qlcd_chienDich.getSelectedItem().equals("CSVH")) {

                            for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                                modelPhanCong.setRowCount(0);
                                int count = 1;
                                if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                        && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                        && danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }

                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSHP")) {
                            modelPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                                if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                        && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                        && danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CS1D3")) {
                            modelPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                                if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                        && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                        && danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }

                        }
                        if (cbo_qlcd_chienDich.getSelectedItem().equals("CSEN")) {

                            for (DanhGiaEN danhGiaVH : danhSachDGENdaPc) {
                                modelPhanCong.setRowCount(0);
                                int count = 1;
                                if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                        && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                        && danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }

                        }
                    } else if (!checkChonCD && !checkChonCN && !checkChonNS) {
                        if (cbo_qlcd_chienDich.getSelectedItem().equals("CSVH")) {

                            for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                                modelPhanCong.setRowCount(0);
                                int count = 1;
                                if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                        && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                        && danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())
                                        && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }

                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSHP")) {
                            modelPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                                if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                        && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                        && danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())
                                        && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CS1D3")) {
                            modelPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                                if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                        && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                        && danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())
                                        && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }

                        }
                        if (cbo_qlcd_chienDich.getSelectedItem().equals("CSEN")) {

                            for (DanhGiaEN danhGiaVH : danhSachDGENdaPc) {
                                modelPhanCong.setRowCount(0);
                                int count = 1;
                                if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                        && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                        && danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())
                                        && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                    modelPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                        danhGiaVH.getNhanSu().getMans(),
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }

                        }

                    } // trường hợp chọn cả 3
                    // Test pass
                    else if (checkChonCD && !checkChonCN && !checkChonNS) {
                        modelPhanCong.setRowCount(0);
                        int count = 1;
                        for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                            if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                    && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                    && danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())
                                    && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                            if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                    && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                    && danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())
                                    && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                            if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                    && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                    && danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())
                                    && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                    } // Test pass
                    else if (checkChonCD && !checkChonCN && checkChonNS) {
                        modelPhanCong.setRowCount(0);
                        int count = 1;
                        for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                            if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                    && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                    && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                            if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                    && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                    && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                            if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                    && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                    && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                    } //
                    else if (checkChonCD && checkChonCN && !checkChonNS) {
                        modelPhanCong.setRowCount(0);
                        int count = 1;
                        for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                            if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                    && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                    && danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                            if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                    && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                    && danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                        for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                            if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                    && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                    && danhGiaVH.getNhanSu().getMans().equals(cbo_qlcd_NhanSu.getSelectedItem())) {
                                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                    danhGiaVH.getNhanSu().getMans(), danhGiaVH.getChienDichCD().getThoiGianTao()});
                                count++;
                            }
                        }
                    }
                } else {
                    if (cbo_qlcd_chienDich.getSelectedItem().equals("Lựa chọn chiến dịch")) {
                        // Test pass
                        if (checkChonCN) {
                            model_qlcd_doiPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaVH danhGiaVH : danhSachDGVHchuaPc) {
                                if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                        && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0) {
                                    model_qlcd_doiPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(), "Đang đợi",
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                            for (DanhGiaHP danhGiaVH : danhSachDGHPchuaPc) {
                                if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                        && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0) {
                                    model_qlcd_doiPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(), "Đang đợi",
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                            for (DanhGia1D3 danhGiaVH : danhSachDG1D3chuaPc) {
                                if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                        && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0) {
                                    model_qlcd_doiPhanCong
                                            .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(), "Đang đợi",
                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                    count++;
                                }
                            }
                        } // Test pass
                        else {
                            model_qlcd_doiPhanCong.setRowCount(0);
                            int count = 1;
                            for (DanhGiaVH danhGiaVH : danhSachDGVHchuaPc) {
                                if (danhGiaVH.getMacn() != null) {
                                    if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                            && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                            && danhGiaVH.getMacn().equalsIgnoreCase(
                                                    String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                        model_qlcd_doiPhanCong
                                                .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                            danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                            "Đang đợi", danhGiaVH.getChienDichCD().getThoiGianTao()});
                                        count++;
                                    }
                                }
                            }
                            for (DanhGiaHP danhGiaVH : danhSachDGHPchuaPc) {
                                if (danhGiaVH.getMacn() != null) {
                                    if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                            && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                            && danhGiaVH.getMacn().equalsIgnoreCase(
                                                    String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {
                                        model_qlcd_doiPhanCong
                                                .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                            danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                            "Đang đợi", danhGiaVH.getChienDichCD().getThoiGianTao()});
                                        count++;
                                    }
                                }
                            }
                            for (DanhGia1D3 danhGiaVH : danhSachDG1D3chuaPc) {
                                if (danhGiaVH.getMacn() != null) {
                                    if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                            && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                            && danhGiaVH.getMacn().equalsIgnoreCase(
                                                    String.valueOf(cbo_qlcd_chuyenNganh.getSelectedItem()))) {

                                        model_qlcd_doiPhanCong
                                                .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                            danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                            "Đang đợi", danhGiaVH.getChienDichCD().getThoiGianTao()});
                                        count++;
                                    }
                                }
                            }
                        }

                    } else {
                        if (checkChonCN) {
                            if (cbo_qlcd_chienDich.getSelectedItem().equals("CSVH")) {
                                modelPhanCong.setRowCount(0);
                                int count = 1;
                                for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {

                                    if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                            && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0) {
                                        modelPhanCong
                                                .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                            danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                            danhGiaVH.getNhanSu().getMans(),
                                            danhGiaVH.getChienDichCD().getThoiGianTao()});
                                        count++;
                                    }
                                }

                            } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSHP")) {
                                modelPhanCong.setRowCount(0);
                                int count = 1;
                                for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                                    if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                            && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0) {
                                        modelPhanCong
                                                .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                            danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                            danhGiaVH.getNhanSu().getMans(),
                                            danhGiaVH.getChienDichCD().getThoiGianTao()});
                                        count++;
                                    }
                                }
                            } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CS1D3")) {
                                modelPhanCong.setRowCount(0);
                                int count = 1;
                                for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                                    if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                            && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0) {
                                        modelPhanCong
                                                .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                            danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                            danhGiaVH.getNhanSu().getMans(),
                                            danhGiaVH.getChienDichCD().getThoiGianTao()});
                                        count++;
                                    }
                                }
                            }
                            if (cbo_qlcd_chienDich.getSelectedItem().equals("CSEN")) {
                                modelPhanCong.setRowCount(0);
                                int count = 1;
                                for (DanhGiaEN danhGiaVH : danhSachDGENdaPc) {

                                    if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                            && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0) {
                                        modelPhanCong
                                                .addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                            danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                            danhGiaVH.getNhanSu().getMans(),
                                            danhGiaVH.getChienDichCD().getThoiGianTao()});
                                        count++;
                                    }
                                }

                            }
                        } else {
                            if (cbo_qlcd_chienDich.getSelectedItem().equals("CSVH")) {

                                for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                                    modelPhanCong.setRowCount(0);
                                    int count = 1;
                                    if (danhGiaVH.getMacn() != null) {
                                        if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                                && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                                && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                            modelPhanCong.addRow(
                                                    new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                                        danhGiaVH.getNhanSu().getMans(),
                                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                            count++;
                                        }
                                    }
                                }

                            } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSHP")) {
                                modelPhanCong.setRowCount(0);
                                int count = 1;
                                for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                                    if (danhGiaVH.getMacn() != null) {
                                        if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                                && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                                && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                            modelPhanCong.addRow(
                                                    new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                                        danhGiaVH.getNhanSu().getMans(),
                                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                            count++;
                                        }
                                    }
                                }
                            } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CS1D3")) {
                                modelPhanCong.setRowCount(0);
                                int count = 1;

                                for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                                    if (danhGiaVH.getMacn() != null) {
                                        if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                                && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                                && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                            modelPhanCong.addRow(
                                                    new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                                        danhGiaVH.getNhanSu().getMans(),
                                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                            count++;
                                        }
                                    }
                                }
                            }
                            if (cbo_qlcd_chienDich.getSelectedItem().equals("CSEN")) {

                                for (DanhGiaEN danhGiaVH : danhSachDGENdaPc) {
                                    modelPhanCong.setRowCount(0);
                                    int count = 1;
                                    if (danhGiaVH.getMacn() != null) {
                                        if (fiDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) <= 0
                                                && nDate.compareTo(danhGiaVH.getChienDichCD().getThoiGianTao()) >= 0
                                                && danhGiaVH.getMacn().equals(cbo_qlcd_chuyenNganh.getSelectedItem())) {
                                            modelPhanCong.addRow(
                                                    new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                                                        danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(),
                                                        danhGiaVH.getNhanSu().getMans(),
                                                        danhGiaVH.getChienDichCD().getThoiGianTao()});
                                            count++;
                                        }
                                    }
                                }

                            }
                        }
                    }

                }
            }
        }
    }

    private void jPanel4ComponentHidden(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_jPanel4ComponentHidden
        // TODO add your handling code here:

    }// GEN-LAST:event_jPanel4ComponentHidden

    private void jdlChamSocDongThoiComponentHidden(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_jdlChamSocDongThoiComponentHidden
        if (txt_jdlCSDT_LoaiCD.getText().equals("Chăm sóc vắng học")) {
            chamSocTamThoiVh.setDienGiaiCT(txt_jdl_CSDT_DienGiaiCT.getText());
            chamSocTamThoiVh.setLyDoGhiNhan(String.valueOf(cbo_jdl_csdt_ldgn.getSelectedItem()));
            chamSocTamThoiVh.setDoiTuong(String.valueOf(cbo_jdl_csdt_dt.getSelectedItem()));
            chamSocTamThoiVh.setPhanLoaiNguyCo(String.valueOf(cbo_jdl_csdt_plnc.getSelectedItem()));
            chamSocTamThoiVh.setNuyenVongSvPh(String.valueOf(cbo_jdl_csdt_nvsv.getSelectedItem()));
            chamSocTamThoiVh.setCheckLuu(jcb_csdt.isSelected());
            chamSocTamThoiVh.setCheck(true);
        } else if (txt_jdlCSDT_LoaiCD.getText().equals("Chăm sóc 1/3 Block")) {
            chamSocTamThoi1D3.setDienGiaiCT(txt_jdl_CSDT_DienGiaiCT.getText());
            chamSocTamThoi1D3.setLyDoGhiNhan(String.valueOf(cbo_jdl_csdt_ldgn.getSelectedItem()));
            chamSocTamThoi1D3.setDoiTuong(String.valueOf(cbo_jdl_csdt_dt.getSelectedItem()));
            chamSocTamThoi1D3.setPhanLoaiNguyCo(String.valueOf(cbo_jdl_csdt_plnc.getSelectedItem()));
            chamSocTamThoi1D3.setCheckLuu(jcb_csdt.isSelected());
            // chamSocTamThoi1D3.setNuyenVongSvPh(String.valueOf(
            // cbo_jdl_csdt_nvsv.getSelectedItem()));
            chamSocTamThoi1D3.setCheck(true);
        } else if (txt_jdlCSDT_LoaiCD.getText().equals("Chăm sóc học phí")) {
            chamSocTamThoiHP.setDienGiaiCT(txt_jdl_CSDT_DienGiaiCT.getText());
            chamSocTamThoiHP.setLyDoGhiNhan(String.valueOf(cbo_jdl_csdt_ldgn.getSelectedItem()));
            chamSocTamThoiHP.setDoiTuong(String.valueOf(cbo_jdl_csdt_dt.getSelectedItem()));
            chamSocTamThoiHP.setPhanLoaiNguyCo(String.valueOf(cbo_jdl_csdt_plnc.getSelectedItem()));
            chamSocTamThoiHP.setNuyenVongSvPh(String.valueOf(cbo_jdl_csdt_nvsv.getSelectedItem()));
            chamSocTamThoiHP.setCheckLuu(jcb_csdt.isSelected());
            chamSocTamThoiHP.setCheck(true);

        } else if (txt_jdlCSDT_LoaiCD.getText().equals("Chăm sóc vắng học tiếng Anh")) {
            chamSocTamThoiEN.setDienGiaiCT(txt_jdl_CSDT_DienGiaiCT.getText());
            chamSocTamThoiEN.setLyDoGhiNhan(String.valueOf(cbo_jdl_csdt_ldgn.getSelectedItem()));
            chamSocTamThoiEN.setDoiTuong(String.valueOf(cbo_jdl_csdt_dt.getSelectedItem()));
            chamSocTamThoiEN.setPhanLoaiNguyCo(String.valueOf(cbo_jdl_csdt_plnc.getSelectedItem()));
            chamSocTamThoiEN.setNuyenVongSvPh(String.valueOf(cbo_jdl_csdt_nvsv.getSelectedItem()));
            chamSocTamThoiEN.setCheckLuu(jcb_csdt.isSelected());
            chamSocTamThoiEN.setCheck(true);
        }
        cbo_jdl_csdt_dt.removeAllItems();
        cbo_jdl_csdt_ldgn.removeAllItems();
        cbo_jdl_csdt_nvsv.removeAllItems();
        cbo_jdl_csdt_plnc.removeAllItems();
        txt_jdl_CSDT_DienGiaiCT.setText("");
        txt_jdl_csdt_ttbl.setText("");
        txt_jdl_csdt_tthp.setText("");
        txt_jdlCSDT_LoaiCD.setText("");
        txt_jdl_csdt_HocPhi.setText("0");

    }// GEN-LAST:event_jdlChamSocDongThoiComponentHidden

    private void jtbCSDTMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jtbCSDTMouseClicked
        // TODO add your handling code here:
        // Hiển thị form chăm sóc đồng thời
        jdlChamSocDongThoi.setSize(682, 400);
        jdlChamSocDongThoi.setTitle("Chăm sóc đồng thời");
        jdlChamSocDongThoi.setLocationRelativeTo(this);
        jdlChamSocDongThoi.setVisible(true);
        // Lấy dòng chọn
        int row = jtbCSDT.getSelectedRow();
        // Lấy tên loại chiến dịch
        String loaidCD = String.valueOf(jtbCSDT.getValueAt(row, 0));
        // Kiểm tra loại chiến dịch nào
        if (loaidCD.equals("CSHP")) {
            txt_jdlCSDT_LoaiCD.setText("Chăm sóc học phí");
            txt_jdl_csdt_TgTao.setText(danhGiaHPDT.getChienDichCD().getThoiGianTao() + "");
            txt_jdl_csdt_HocPhi.setText(danhGiaHPDT.getHocPhi() + "");
            if (danhGiaHPDT.getTrangThai()) {
                txt_jdl_csdt_tthp.setText("Rút học phí");
                txt_jdl_csdt_tthp.setBackground(Color.ORANGE);
            } else {
                txt_jdl_csdt_tthp.setText(danhGiaHPDT.isTrangThaiHP() ? "Đã đóng" : "Chưa đóng");
                if (!danhGiaHPDT.isTrangThaiHP()) {
                    txt_jdl_csdt_tthp.setBackground(Color.ORANGE);
                } else {
                    txt_jdl_csdt_tthp.setBackground(Color.GREEN);
                }
            }
            txt_jdl_csdt_ttbl.setText(danhGiaHPDT.isTrangThaiBL() ? "Đã bảo lưu" : "Chưa bảo lưu");
            if (!danhGiaHPDT.isTrangThaiBL()) {
                txt_jdl_csdt_ttbl.setBackground(Color.ORANGE);
            } else {
                txt_jdl_csdt_ttbl.setBackground(Color.GREEN);
            }
            txt_jdl_csdt_tthp.setOpaque(true);
            txt_jdl_csdt_ttbl.setOpaque(true);
            txt_jdl_csdt_tthp.repaint();
            txt_jdl_csdt_ttbl.repaint();
            txt_jdl_csdt_HocPhi.setText(currencyFormatter.format(danhGiaHPDT.getHocPhi()));
            fillToComBoxCSDT("CSHP");
            if (chamSocTamThoiHP.isCheck()) {
                txt_jdl_CSDT_DienGiaiCT.setText(chamSocTamThoiHP.getDienGiaiCT());
                cbo_jdl_csdt_dt.setSelectedItem(chamSocTamThoiHP.getDoiTuong());
                cbo_jdl_csdt_ldgn.setSelectedItem(chamSocTamThoiHP.getLyDoGhiNhan());
                cbo_jdl_csdt_nvsv.setSelectedItem(chamSocTamThoiHP.getNuyenVongSvPh());
                cbo_jdl_csdt_plnc.setSelectedItem(chamSocTamThoiHP.getPhanLoaiNguyCo());
                jcb_csdt.setSelected(chamSocTamThoiHP.isCheckLuu());
            }
        } else if (loaidCD.equals("CSVH")) {
            txt_jdlCSDT_LoaiCD.setText("Chăm sóc vắng học");
            txt_jdl_csdt_TgTao.setText(danhGiaVHDT.getChienDichCD().getThoiGianTao() + "");
            fillToComBoxCSDT("CSVH");
            if (chamSocTamThoiVh.isCheck()) {
                txt_jdl_CSDT_DienGiaiCT.setText(chamSocTamThoiVh.getDienGiaiCT());
                cbo_jdl_csdt_dt.setSelectedItem(chamSocTamThoiVh.getDoiTuong());
                cbo_jdl_csdt_ldgn.setSelectedItem(chamSocTamThoiVh.getLyDoGhiNhan());
                cbo_jdl_csdt_nvsv.setSelectedItem(chamSocTamThoiVh.getNuyenVongSvPh());
                cbo_jdl_csdt_plnc.setSelectedItem(chamSocTamThoiVh.getPhanLoaiNguyCo());
                jcb_csdt.setSelected(chamSocTamThoiVh.isCheckLuu());
            } else if (!cbo_Cs_ChienDich.getSelectedItem().equals("CSHP")) {
                txt_jdl_CSDT_DienGiaiCT.setText(txtDienGiaiCT.getText());
                cbo_jdl_csdt_dt.setSelectedItem(cboDoiTuong.getSelectedItem());
                cbo_jdl_csdt_ldgn.removeItem(cboLyDoNghiNhan.getSelectedItem());
                cbo_jdl_csdt_ldgn.addItem(String.valueOf(cboLyDoNghiNhan.getSelectedItem()));
                cbo_jdl_csdt_ldgn.setSelectedItem(cboLyDoNghiNhan.getSelectedItem());
                cbo_jdl_csdt_ldgn.removeItem(cboNguyenVongCuaSV.getSelectedItem());
                cbo_jdl_csdt_ldgn.addItem(String.valueOf(cboNguyenVongCuaSV.getSelectedItem()));
                cbo_jdl_csdt_nvsv.setSelectedItem(cboNguyenVongCuaSV.getSelectedItem());
                cbo_jdl_csdt_plnc.setSelectedItem(cboPhanLoaiNguyCo.getSelectedItem());

            }
        } else if (loaidCD.equals("CS1D3")) {
            txt_jdlCSDT_LoaiCD.setText("Chăm sóc 1/3 Block");
            txt_jdl_csdt_TgTao.setText(danhGia1D3DT.getChienDichCD().getThoiGianTao() + "");
            fillToComBoxCSDT("CSVH");
            if (chamSocTamThoi1D3.isCheck()) {
                txt_jdl_CSDT_DienGiaiCT.setText(chamSocTamThoi1D3.getDienGiaiCT());
                cbo_jdl_csdt_dt.setSelectedItem(chamSocTamThoi1D3.getDoiTuong());
                cbo_jdl_csdt_ldgn.setSelectedItem(chamSocTamThoi1D3.getLyDoGhiNhan());
                cbo_jdl_csdt_nvsv.setSelectedItem(chamSocTamThoi1D3.getNuyenVongSvPh());
                cbo_jdl_csdt_plnc.setSelectedItem(chamSocTamThoi1D3.getPhanLoaiNguyCo());
                jcb_csdt.setSelected(chamSocTamThoi1D3.isCheckLuu());
            } else if (!cbo_Cs_ChienDich.getSelectedItem().equals("CSHP")) {
                txt_jdl_CSDT_DienGiaiCT.setText(txtDienGiaiCT.getText());
                cbo_jdl_csdt_dt.setSelectedItem(cboDoiTuong.getSelectedItem());
                cbo_jdl_csdt_ldgn.removeItem(cboLyDoNghiNhan.getSelectedItem());
                cbo_jdl_csdt_ldgn.addItem(String.valueOf(cboLyDoNghiNhan.getSelectedItem()));
                cbo_jdl_csdt_ldgn.setSelectedItem(cboNguyenVongCuaSV.getSelectedItem());
                cbo_jdl_csdt_ldgn.removeItem(cboNguyenVongCuaSV.getSelectedItem());
                cbo_jdl_csdt_ldgn.addItem(String.valueOf(cboLyDoNghiNhan.getSelectedItem()));
                cbo_jdl_csdt_nvsv.setSelectedItem(cboNguyenVongCuaSV.getSelectedItem());
                cbo_jdl_csdt_plnc.setSelectedItem(cboPhanLoaiNguyCo.getSelectedItem());

            }
        } else if (loaidCD.equals("CSEN")) {
            txt_jdlCSDT_LoaiCD.setText("Chăm sóc vắng học tiếng Anh");
            txt_jdl_csdt_TgTao.setText(danhGiaENDT.getChienDichCD().getThoiGianTao() + "");
            fillToComBoxCSDT("CSVH");
            if (chamSocTamThoiEN.isCheck()) {
                txt_jdl_CSDT_DienGiaiCT.setText(chamSocTamThoiEN.getDienGiaiCT());
                cbo_jdl_csdt_dt.setSelectedItem(chamSocTamThoiEN.getDoiTuong());
                cbo_jdl_csdt_ldgn.setSelectedItem(chamSocTamThoiEN.getLyDoGhiNhan());
                cbo_jdl_csdt_nvsv.setSelectedItem(chamSocTamThoiEN.getNuyenVongSvPh());
                cbo_jdl_csdt_plnc.setSelectedItem(chamSocTamThoiEN.getPhanLoaiNguyCo());
                jcb_csdt.setSelected(chamSocTamThoiEN.isCheckLuu());
            } else if (!cbo_Cs_ChienDich.getSelectedItem().equals("CSHP")) {
                txt_jdl_CSDT_DienGiaiCT.setText(txtDienGiaiCT.getText());
                cbo_jdl_csdt_dt.setSelectedItem(cboDoiTuong.getSelectedItem());
                cbo_jdl_csdt_ldgn.removeItem(cboLyDoNghiNhan.getSelectedItem());
                cbo_jdl_csdt_ldgn.addItem(String.valueOf(cboLyDoNghiNhan.getSelectedItem()));
                cbo_jdl_csdt_ldgn.setSelectedItem(cboLyDoNghiNhan.getSelectedItem());
                cbo_jdl_csdt_ldgn.removeItem(cboNguyenVongCuaSV.getSelectedItem());
                cbo_jdl_csdt_ldgn.addItem(String.valueOf(cboNguyenVongCuaSV.getSelectedItem()));
                cbo_jdl_csdt_nvsv.setSelectedItem(cboNguyenVongCuaSV.getSelectedItem());
                cbo_jdl_csdt_plnc.setSelectedItem(cboPhanLoaiNguyCo.getSelectedItem());

            }
        }
    }// GEN-LAST:event_jtbCSDTMouseClicked

    private void btn_LuaCSActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_LuaCSActionPerformed
        // TODO add your handling code here:
        if (!(txtCSSV_MSSV.getText().equals(""))) {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            danhGia();
            setCursor(Cursor.getDefaultCursor());
        }

    }// GEN-LAST:event_btn_LuaCSActionPerformed

    private void rdoUser2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rdoUser2ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_rdoUser2ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        String linkFileSv = TienIch.ChonFile();
        if (linkFileSv != null) {
            txtLinkFileImportSV.setText(linkFileSv);
        }
    }// GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Hiển thị ProgressBar
                setProgressBarVisible(true);
                int count = 0;
                int cellNum = 0;
                if (cboThayThe.isSelected()) {
                    try {

                        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                        if (sessionFactory != null) {
                            Session session = sessionFactory.openSession();
                            try {
                                Transaction transaction = session.beginTransaction();
                                try {
                                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                                    FileInputStream fileInputStream = new FileInputStream(
                                            txtLinkFileImportSV.getText());
                                    XSSFWorkbook xssfw = new XSSFWorkbook(fileInputStream);
                                    XSSFSheet sheet = xssfw.getSheetAt(0);
                                    FormulaEvaluator formulaEvaluator = xssfw.getCreationHelper()
                                            .createFormulaEvaluator();
                                    int totalRowCount = sheet.getLastRowNum();
                                    for (org.apache.poi.ss.usermodel.Row row : sheet) {
                                        count++;
                                        SinhVien sinhVien = new SinhVien();
                                        cellNum = 0;
                                        for (Cell cell : row) {
                                            switch (cellNum) {
                                                case 0:
													try {
                                                    sinhVien.setMssv(cell.getStringCellValue());
                                                } catch (Exception e) {
                                                    sinhVien.setMssv(String.valueOf(cell.getStringCellValue()));
                                                }

                                                break;
                                                case 1:
													try {
                                                    sinhVien.setHoVaTen(cell.getStringCellValue());
                                                } catch (Exception e) {
                                                    sinhVien.setHoVaTen(String.valueOf(cell.getNumericCellValue()));
                                                }

                                                break;
                                                case 2:
													try {
                                                    sinhVien.setKhoiTruong(cell.getStringCellValue());
                                                } catch (Exception e) {
                                                    sinhVien.setKhoiTruong(
                                                            String.valueOf(cell.getNumericCellValue()));
                                                }

                                                break;
                                                case 3:
													try {
                                                    sinhVien.setKNHNN(cell.getNumericCellValue());
                                                } catch (Exception e) {
                                                }

                                                break;
                                                case 4:
													try {
                                                    sinhVien.setKNHBD(cell.getNumericCellValue());
                                                } catch (Exception e) {
                                                }

                                                break;
                                                case 5:
													try {
                                                    sinhVien.setTrangThai(cell.getStringCellValue());
                                                } catch (Exception e) {
                                                    sinhVien.setTrangThai(
                                                            String.valueOf(cell.getNumericCellValue()));
                                                }

                                                break;
                                                case 6:
													try {
                                                    sinhVien.setKiHocHT((int) cell.getNumericCellValue());
                                                } catch (Exception e) {
                                                }

                                                break;
                                                case 7:
													try {
                                                    sinhVien.setNganhHoc(cell.getStringCellValue());
                                                } catch (Exception e) {
                                                    sinhVien.setNganhHoc(
                                                            String.valueOf(cell.getNumericCellValue()));
                                                }

                                                break;
                                                case 8:
													try {
                                                    sinhVien.setChuyenNganh(cell.getStringCellValue());

                                                } catch (Exception e) {
                                                    sinhVien.setChuyenNganh(
                                                            String.valueOf(cell.getNumericCellValue()));
                                                }

                                                break;
                                            }
                                            cellNum++;
                                        }

                                        session.saveOrUpdate(sinhVien);
                                        int percentComplete = (int) (((double) count / (double) totalRowCount)
                                                * 100);
                                        jProgressBar1.setString(percentComplete + "%");
                                    }

                                    xssfw.close();
                                    fileInputStream.close();

                                } catch (Exception e) {
                                    MsgBox.alert(null, "Lỗi tại dòng: " + count + "  " + cellNum
                                            + " Vui lòng kiểm tra lại file sinh viên");
                                    // return;
                                    if (e instanceof java.io.FileNotFoundException) {
                                        jlb_enroll_importSV.setText("Không tìm thấy file. Vui lòng kiểm tra lại đường dẫn.");
                                        setProgressBarVisible(false);
                                        return;
                                    }
                                }
                                jProgressBar1.setString("đang lưu...");
                                transaction.commit();
                                jProgressBar1.setString("Hoàn tất");
                                // Ẩn ProgressBar khi tác vụ đã hoàn thành
                                jdlImportSV.setVisible(false);
                                setProgressBarVisible(false);
                            } finally {
                                session.close();
                            }
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                        setProgressBarVisible(false);
                    }

                }

            }
        }).start();
        setCursor(Cursor.getDefaultCursor());
    }// GEN-LAST:event_jButton22ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton10ActionPerformed
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        String mans = Auth.user.getMans();
        String chienDich = String.valueOf(cbo_Cs_ChienDich.getSelectedItem());
        if (chienDich.equals("CSVH")) {
            danhSachDGVHCn = danhGiaVHDAO.getChamSocCN(mans);
            fillTableCanChamSocVH();
        } else if (chienDich.equals("CSHP")) {
            danhSachDGHPCn = danhGiaHPDAO.getChamSocCN(mans);
            fillTableCanChamSocHP();
        } else if (chienDich.equals("CS1D3")) {
            danhSachDG1D3Cn = danhGia1D3DAO.getChamSocCN(mans);
            fillTableCanChamSoc1D3();
        } else if (chienDich.equals("CSEN")) {
            danhSachDGENCn = danhGiaENDAO.getChamSocCN(mans);
            fillTableCanChamSocEN();
        }
        setCursor(Cursor.getDefaultCursor());
    }// GEN-LAST:event_jButton10ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        loadDataLichSuCS();
        fillToTableLichSuCSALL();
        cbo_Home_ChienDich.setSelectedIndex(0);
        cbo_Home_NhanSu.setSelectedIndex(0);
        setCursor(Cursor.getDefaultCursor());
    }// GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
        if (txt_ttcn_Hoten.getText().equals("") || txt_ttcn_matKhau.getText().equals("")) {
            MsgBox.alert(this, "Hãy điền đầy đủ thông tin!");
        } else {
            nhanSuDAO.UpdateTen(txt_ttcn_Hoten.getText(), jlb_ttcn_Mans.getText());
            nhanSuDAO.UpdateMatKhau(txt_ttcn_matKhau.getText(), jlb_ttcn_Mans.getText());
            MsgBox.alert(this, "Thông tin đã được cập nhật!");
        }

    }// GEN-LAST:event_jButton24ActionPerformed

// Sự kiện chọn chiến dịch từ Tab chăm sóc sinh viên
    private void cbo_Cs_ChienDichActionPerformed(java.awt.event.ActionEvent evt) {
        // + Hiển thị danh sách sinh viên cần chăm sóc lên bảng chăm sóc theo loại chiến
        // dịch

        lamMoiFormCS();
        fillToTablesinhVienCanCS();

        //fillToCS(0);
    }

    private void jpnQuanLyCDComponentShown(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_jpnQuanLyCDComponentShown
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Hiển thị thanh ProgressBar và thực hiện tác vụ import
                setProgressBarVisible(true);
                jProgressBar1.setString("tải phân công...");
                loadDataPhanCong();
                fillToTableChuaPhanCong();
                fillToTabledaPhanCong();
                return null;
            }

            @Override
            protected void done() {
                setProgressBarVisible(false);
            }
        };
        // Khởi động SwingWorker
        worker.execute();
    }// GEN-LAST:event_jpnQuanLyCDComponentShown

    private void formComponentShown(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        new Thread(new Runnable() {
            @Override
            public void run() {
                setProgressBarVisible(true);
                jProgressBar1.setString("tải giao diện...");
                dshk = hocKiDAO.selectAllMoiNhat();
                danhSachCD = chienDichDAO.selectAll();
                dsns = nhanSuDAO.selectAll();
                dsChuyenNganhs = chuyenNganhDAO.selectAll();
                dropListldgnvh = dropListCTDAO.getDropList("DRLDGN", "CSVH");
                dropListldgnhp = dropListCTDAO.getDropList("DRLDGN", "CSHP");
                dropListnvvh = dropListCTDAO.getDropList("DRNVSV", "CSVH");
                dropListplnvhp = dropListCTDAO.getDropList("DRNVSV", "CSHP");
                dropListplnc = dropListCTDAO.getDropList("DRPLNC", "CSVH");
                dropListdt = dropListCTDAO.getDropList("DRDT", "CSVH");
                jProgressBar1.setString("tải phân công...");
                loadDataPhanCong();
                fillToComBoBox();
                getDanhSachIP();
                txt_Home_Mans.setText("Nhân sự : " + Auth.user.getHoVaten() + " - " + Auth.user.getMans());
                setProgressBarVisible(false);
            }
        }).start();
        this.setCursor(Cursor.getDefaultCursor());
    }

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:

        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        getDanhSachIP();
        cbo_qlcd_NhanSu.setSelectedIndex(0);
        cbo_qlcd_chuyenNganh.setSelectedItem(0);
        cbo_qlcd_chienDich.setSelectedIndex(0);
        jdc_qlcd_tuNgay.setDate(null);
        jdc_qlcd_denNgay.setDate(null);
        txt_qlcd_mssv.setText("");
        loadDataPhanCong();
        fillToTabledaPhanCong();
        fillToTableChuaPhanCong();

        setCursor(Cursor.getDefaultCursor());

    }// GEN-LAST:event_jButton14ActionPerformed

    private void dalImportDataComponentResized(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_dalImportDataComponentResized
        // TODO add your handling code here:
    }// GEN-LAST:event_dalImportDataComponentResized

    private void jpnQuanLyChienDich_ContentComponentShown(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_jpnQuanLyChienDich_ContentComponentShown
        // TODO add your handling code here:

    }// GEN-LAST:event_jpnQuanLyChienDich_ContentComponentShown

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        // TODO add your handling code here:
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (checkAD || checkUr1) {
            this.jdlImportSV.setSize(550, 200);
            this.jdlImportSV.setTitle("Import dữ liệu sinh viên");
            this.jdlImportSV.setLocationRelativeTo(this);
            this.jdlImportSV.setVisible(true);
            txtLinkFileImportSV.setText("");

        } else {
            MsgBox.alert(this, "Không thể truy cập tính năng này");
        }
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        if (checkAD || checkUr1) {
            this.dalTaoHocKi.setTitle("Tạo học kì");
            this.dalTaoHocKi.setSize(525, 267);
            this.dalTaoHocKi.setLocationRelativeTo(this);
            this.dalTaoHocKi.setVisible(true);
        } else {
            MsgBox.alert(this, "Không thể truy cập tính năng này!");
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        if (checkAD || checkUr1) {
            this.dalImportData.setSize(527, 280);
            this.dalImportData.setTitle("Import data from excel file");
            this.dalImportData.setLocationRelativeTo(this);
            this.dalImportData.setVisible(true);
        } else {
            MsgBox.alert(this, "Không thể truy cập tính năng này");
        }

    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (checkAD) {
            this.jdlQuanLyNhanSu.setTitle("Quản lý nhân sự");
            this.jdlQuanLyNhanSu.setLocationRelativeTo(null);
            this.jdlQuanLyNhanSu.setSize(988, 500);
            this.jdlQuanLyNhanSu.setVisible(true);
            cboNhanSuOn.setSelected(true);
            FilloTableDSNSON();
        } else {
            MsgBox.alert(this, "Không thể truy cập tính năng này");

        }

    }

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        hocKiDAO.insert(getHocKi());
        dshk = hocKiDAO.selectAll();
        fillToCboHK(cbo_home_HocKy);
        fillToCboHK(cbo_qLcd_hocKi);
        loadDataPhanCong();
        loadDataLichSuCS();
        fillToTableLichSuCSALL();
        fillToTabledaPhanCong();
        fillToTableChuaPhanCong();
        MsgBox.alert(this, "Thêm học kì thành công!");
        this.dalTaoHocKi.setVisible(false);
        setCursor(Cursor.getDefaultCursor());
    }

    private void dalTaoHocKiComponentShown(java.awt.event.ComponentEvent evt) {
    }

    private void dalImportDataComponentShown(java.awt.event.ComponentEvent evt) {
        txtLinkFileData.setText("");
        txtTenChienDichChuDong.setText("");
        cboChonHocKi.removeAllItems();
        cboChonHocKi.removeAllItems();
        fillToCboHK(cboChonHocKi);

    }

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtTenChienDichChuDong.getText().equals("")) {
            jlb_enroll_import.setText("Vui lòng điền tên đợt import.");
        } else if (txtLinkFileData.getText().equals("")) {
            jlb_enroll_import.setText("Vui lòng chọn file cần import.");
        } else {
            jlb_enroll_import.setText("");
            if (cboChienDich.getSelectedItem().equals("Chăm sóc vắng học")) {
                if (checkipvh()) {
                    SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                        @Override
                        protected Void doInBackground() throws Exception {
                            // Hiển thị thanh ProgressBar và thực hiện tác vụ import
                            setProgressBarVisible(true);
                            txt_taiData.setText("Tải dữ liệu vắng học:");
                            importCSVH();
                            return null;
                        }

                        @Override
                        protected void done() {
                            // Ẩn ProgressBar khi tác vụ đã hoàn thành
                            setProgressBarVisible(false);
                            // Cập nhật giao diện người dùng
                            txt_taiData.setText("");
                        }
                    };

                    // Khởi động SwingWorker
                    worker.execute();
                }
            } else if (cboChienDich.getSelectedItem().equals("Chăm sóc học phí")) {
                if (checkiphp()) {
                    // Sử dụng SwingWorker để thực hiện tác vụ nền
                    SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                        @Override
                        protected Void doInBackground() throws Exception {
                            // Hiển thị thanh ProgressBar và thực hiện tác vụ import
                            setProgressBarVisible(true);
                            txt_taiData.setText("Tải dữ liệu học phí:");
                            importCSHP();
                            return null;
                        }

                        @Override
                        protected void done() {
                            // Ẩn ProgressBar khi tác vụ đã hoàn thành
                            setProgressBarVisible(false);
                            // Cập nhật giao diện người dùng
                            txt_taiData.setText("");
                        }
                    };

                    // Khởi động SwingWorker
                    worker.execute();
                }
            } else if (cboChienDich.getSelectedItem().equals("Chăm sóc 1/3 block")) {
                if (checkip1d3()) {
                    SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                        @Override
                        protected Void doInBackground() throws Exception {
                            // Hiển thị thanh ProgressBar và thực hiện tác vụ import
                            setProgressBarVisible(true);
                            txt_taiData.setText("Tải dữ liệu 1D3 Block:");
                            importCS1D3();
                            return null;
                        }

                        @Override
                        protected void done() {
                            // Ẩn ProgressBar khi tác vụ đã hoàn thành
                            setProgressBarVisible(false);
                            // Cập nhật giao diện người dùng
                            txt_taiData.setText("");
                        }
                    };

                    // Khởi động SwingWorker
                    worker.execute();
                }
            } else {

                if (checkipen()) {
                    SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                        @Override
                        protected Void doInBackground() throws Exception {
                            // Hiển thị thanh ProgressBar và thực hiện tác vụ import
                            setProgressBarVisible(true);
                            txt_taiData.setText("Tải dữ liệu vắng học EN:");
                            importCSEN();
                            return null;
                        }

                        @Override
                        protected void done() {
                            // Ẩn ProgressBar khi tác vụ đã hoàn thành
                            setProgressBarVisible(false);
                            // Cập nhật giao diện người dùng
                            txt_taiData.setText("");
                        }
                    };

                    // Khởi động SwingWorker
                    worker.execute();
                }
            }
        }
    }

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        txtLinkFileData.setText(TienIch.ChonFile());

    }// GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
 try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

            new HomeFarm().setVisible(true);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeFarm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeFarm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeFarm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeFarm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog DialogChuyenSV;
    private javax.swing.JDialog DialogExportCSVH;
    private javax.swing.JDialog DialogPhanCong;
    private javax.swing.JList<String> JListDanhSachIP;
    private javax.swing.JMenuBar JmbMenu;
    private javax.swing.JMenuItem JmenuTongSvChon;
    private javax.swing.JMenuItem Jmenu_dsip_an;
    private javax.swing.JMenuItem Jmenu_dsip_xoa;
    private javax.swing.JMenuItem Jmn_ChuyenSv;
    private javax.swing.JPopupMenu JpmViewCt;
    private javax.swing.JTable Jtable_PhanCongRoi;
    private javax.swing.JTabbedPane JtpHome;
    private javax.swing.JButton btnLuuTTNS;
    private javax.swing.JButton btnLuuTTNS1;
    private javax.swing.JButton btnSelectAll;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JButton btn_Home_TraCuuTheoNgay;
    private javax.swing.JButton btn_Import_HpBl;
    private javax.swing.JButton btn_LuaCS;
    private javax.swing.JButton btn_edit_luu;
    private javax.swing.JButton btn_qlcd_Tim;
    private javax.swing.JButton btn_themNvsv;
    private javax.swing.JButton btn_themldgn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JComboBox<String> cbbChienDich;
    private javax.swing.JComboBox<String> cbbChuyenDoiPC;
    private javax.swing.JComboBox<String> cbbChuyenNganh;
    private javax.swing.JComboBox<String> cboChienDich;
    private javax.swing.JComboBox<String> cboChonHocKi;
    private javax.swing.JComboBox<String> cboDoiTuong;
    private javax.swing.JComboBox<String> cboHistory;
    private javax.swing.JComboBox<String> cboLyDoNghiNhan;
    private javax.swing.JComboBox<String> cboNguyenVongCuaSV;
    private javax.swing.JRadioButton cboNhanSuNam;
    private javax.swing.JRadioButton cboNhanSuNu;
    private javax.swing.JRadioButton cboNhanSuOff;
    private javax.swing.JRadioButton cboNhanSuOn;
    private javax.swing.JComboBox<String> cboPhanLoaiNguyCo;
    private javax.swing.JRadioButton cboTatCaNS;
    private javax.swing.JRadioButton cboThayThe;
    private javax.swing.JComboBox<String> cbo_ChienDichDL;
    private javax.swing.JComboBox<String> cbo_Cs_ChienDich;
    private javax.swing.JComboBox<String> cbo_Home_ChienDich;
    private javax.swing.JComboBox<String> cbo_Home_NhanSu;
    private javax.swing.JComboBox<String> cbo_Import_HPBL;
    private javax.swing.JComboBox<String> cbo_TieuChi;
    private javax.swing.JComboBox<String> cbo_edit_dt;
    private javax.swing.JComboBox<String> cbo_edit_ldgn;
    private javax.swing.JComboBox<String> cbo_edit_nvsv;
    private javax.swing.JComboBox<String> cbo_edit_plnc;
    private javax.swing.JComboBox<String> cbo_home_HocKy;
    private javax.swing.JComboBox<String> cbo_jdl_csdt_dt;
    private javax.swing.JComboBox<String> cbo_jdl_csdt_ldgn;
    private javax.swing.JComboBox<String> cbo_jdl_csdt_nvsv;
    private javax.swing.JComboBox<String> cbo_jdl_csdt_plnc;
    private javax.swing.JComboBox<String> cbo_qLcd_hocKi;
    private javax.swing.JComboBox<String> cbo_qlcd_NhanSu;
    private javax.swing.JComboBox<String> cbo_qlcd_chienDich;
    private javax.swing.JComboBox<String> cbo_qlcd_chuyenNganh;
    private javax.swing.JDialog dalImportData;
    private javax.swing.JDialog dalTaoHocKi;
    private com.toedter.calendar.JDateChooser dcsBatDauHK;
    private com.toedter.calendar.JDateChooser dcsKetThucHocKi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuDeleteObj;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelListChk;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JCheckBox jcb_csdt;
    private com.toedter.calendar.JDateChooser jdc_Home_tuNgay;
    private com.toedter.calendar.JDateChooser jdc_home_denNgay;
    private com.toedter.calendar.JDateChooser jdc_qlcd_denNgay;
    private com.toedter.calendar.JDateChooser jdc_qlcd_endDay;
    private com.toedter.calendar.JDateChooser jdc_qlcd_firstDay;
    private com.toedter.calendar.JDateChooser jdc_qlcd_tuNgay;
    private javax.swing.JDialog jdlChamSocDongThoi;
    private javax.swing.JDialog jdlImportHP_BL;
    private javax.swing.JDialog jdlImportSV;
    private javax.swing.JDialog jdlQuanLyNhanSu;
    private javax.swing.JDialog jdlThongTinCaNhan;
    private javax.swing.JDialog jdl_ThemDG;
    private javax.swing.JDialog jdl_editLSCS;
    private javax.swing.JDialog jdl_quanLyDl;
    private javax.swing.JLabel jlb_CSSV_ChuaCS;
    private javax.swing.JLabel jlb_cs_monHoc;
    private javax.swing.JLabel jlb_enroll_ImportHPBL;
    private javax.swing.JLabel jlb_enroll_import;
    private javax.swing.JLabel jlb_enroll_importSV;
    private javax.swing.JLabel jlb_importData_Enroll;
    private javax.swing.JLabel jlb_loaiDopList;
    private javax.swing.JLabel jlb_maLoaiDl;
    private javax.swing.JLabel jlb_qlcd_ChuaCS;
    private javax.swing.JLabel jlb_qlcd_Dacs;
    private javax.swing.JLabel jlb_qlcd_tong;
    private javax.swing.JLabel jlb_ttcn_Mans;
    private javax.swing.JPanel jpnCSVH;
    private javax.swing.JPanel jpnChamSocSV;
    private javax.swing.JPanel jpnDanhSachIP;
    private javax.swing.JPanel jpnHomContent;
    private javax.swing.JPanel jpnHome;
    private javax.swing.JPanel jpnQuanLyCD;
    private javax.swing.JPanel jpnQuanLyChienDich_Content;
    private javax.swing.JPanel jpnSvCho;
    private javax.swing.JPanel jpnViewct;
    private javax.swing.JTable jtbCSDT;
    private javax.swing.JTable jtbLichSuCS;
    private javax.swing.JTable jtbSVCanCS;
    private javax.swing.JTable jtb_DropList;
    private javax.swing.JTable jtb_home_lichSuCs;
    private javax.swing.JTable jtb_qlcd_chuaPC;
    private javax.swing.JTabbedPane jtp_qlcd_daPC;
    private javax.swing.JLabel lblTongSV;
    private javax.swing.JMenuItem mni_qlttcn;
    private javax.swing.JRadioButton rdoAdmin;
    private javax.swing.JRadioButton rdoTrangThaiOff;
    private javax.swing.JRadioButton rdoTrangThaiOn;
    private javax.swing.JRadioButton rdoUser1;
    private javax.swing.JRadioButton rdoUser2;
    private javax.swing.JTable tblDanhSachNS;
    private javax.swing.JTable tblNsPhuTrachCN;
    private javax.swing.JLabel txtCSSV_MSSV;
    private javax.swing.JTextArea txtDienGiaiCT;
    private javax.swing.JTextField txtEmailNS;
    private javax.swing.JTextField txtLinkExport;
    private javax.swing.JTextField txtLinkFileData;
    private javax.swing.JTextField txtLinkFileHistory;
    private javax.swing.JTextField txtLinkFileImportSV;
    private javax.swing.JTextField txtMaHocKi;
    private javax.swing.JTextField txtMaNS;
    private javax.swing.JTextField txtTenChienDichChuDong;
    private javax.swing.JTextField txtTenHocKi;
    private javax.swing.JTextField txtTenNhanSu;
    private javax.swing.JLabel txt_CSSV_ChuyenNganh;
    private javax.swing.JLabel txt_CSSV_HoTen;
    private javax.swing.JLabel txt_CSSV_HocPhi;
    private javax.swing.JLabel txt_CSSV_KiHoc;
    private javax.swing.JTextField txt_CSSV_NX;
    private javax.swing.JLabel txt_CSSV_TrangThai;
    private javax.swing.JLabel txt_CSSV_TrangThaiBL;
    private javax.swing.JLabel txt_CSSV_TrangThaiHP;
    private javax.swing.JLabel txt_Home_Mans;
    private javax.swing.JTextField txt_Home_mssv;
    private javax.swing.JLabel txt_editDropList_enroll;
    private javax.swing.JLabel txt_edit_Loaicd;
    private javax.swing.JTextField txt_edit_dgct;
    private javax.swing.JLabel txt_edit_mssv;
    private javax.swing.JLabel txt_home_tongData;
    private javax.swing.JTextField txt_import_HP_BL;
    private javax.swing.JLabel txt_jdlCSDT_LoaiCD;
    private javax.swing.JTextArea txt_jdl_CSDT_DienGiaiCT;
    private javax.swing.JLabel txt_jdl_csdt_HocPhi;
    private javax.swing.JLabel txt_jdl_csdt_TgTao;
    private javax.swing.JLabel txt_jdl_csdt_ttbl;
    private javax.swing.JLabel txt_jdl_csdt_tthp;
    private javax.swing.JTextArea txt_noiDungDl;
    private javax.swing.JTextField txt_qlcd_mssv;
    private javax.swing.JLabel txt_taiData;
    private javax.swing.JTextField txt_themMoiDG;
    private javax.swing.JTextField txt_ttcn_Hoten;
    private javax.swing.JPasswordField txt_ttcn_matKhau;
    private javax.swing.JTextArea txt_viewCT;
    // End of variables declaration//GEN-END:variables
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Calendar calendar = Calendar.getInstance();
// Khai bao cac bien kiem tra
    boolean checkViewH = false, checkViewPC = false;
    JPopupMenu popupMenuChuaPc = new JPopupMenu();
    JPopupMenu popupMenuDaPc = new JPopupMenu();
    JPopupMenu popupMenuDSIP = new JPopupMenu();
    // Khai bao cac bien dem toan phan
    int countClick = 0;
    int countLickTableLS = 0;
    int indexTableDl = 0;
    // khai bao cac bien chua doi tuong chinh sua lich su
    LichSuChamSocEN lichSuChamSocENedit;
    LichSuChamSoc1D3 lichSuChamSoc1D3edit;
    LichSuChamSocHP lichSuChamSocHPedit;
    LichSuChamSocVH lichSuChamSocVHedit;
    // Khai bao bien chua value dung chung
    SinhVien sinhVienCS;
// Đối tượng chứa các thông tin chăm sóc tạm thời
    ChamSocTamThoi chamSocTamThoiVh;
    ChamSocTamThoi chamSocTamThoiEN;
    ChamSocTamThoi chamSocTamThoiHP;
    ChamSocTamThoi chamSocTamThoi1D3;
    // Khai báo các biến đánh giá đồng thời
    DanhGia1D3 danhGia1D3DT;
    DanhGiaHP danhGiaHPDT;
    DanhGiaVH danhGiaVHDT;
    DanhGiaEN danhGiaENDT;
    // Khai bao bien kiem tra phan phan quyen
    boolean checkAD = Auth.user.getVaiTro() == 0 ? true : false;
    boolean checkUr1 = Auth.user.getVaiTro() == 1 ? true : false;
    boolean checkUr2 = Auth.user.getVaiTro() == 2 ? true : false;
    int[] tongs;
    // Khai bao cac bien chua du lieu thong ke
    int[] tongsChuaPC;
    int tongChuaCS = 0;
    int tongdaCS = 0;
    int tongChuaCSofNS = 0;
    int tongdaCSofNS = 0;
// Khai bao dinh dang tien te VietNam
    Locale localeVN = new Locale("vi", "VN");
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(localeVN);
// Khai bao model cho cac table va list
    // + Khai bao model cho list danh sach import
    DefaultListModel listModelDSIP = new DefaultListModel();
    // + Khai model cho table danh sach nhan su
    DefaultTableModel modelDSNS = new DefaultTableModel();
    // + Khai bao model cho table phan cong chuyen nganh
    DefaultTableModel modelNS_PC_CN = new DefaultTableModel();
    // + Khai bao model cho table danh sach sinh vien can cham soc
    DefaultTableModel modelSvCanCS = new DefaultTableModel();
    DefaultTableModel modelSvCanC = new DefaultTableModel();
    DefaultTableModel modelCSDT = new DefaultTableModel();
    // + Khai bao model cho table LichSuChamSoc ca nhan sinh vien dang duoc cham soc
    DefaultTableModel modelLichSuCSCN = new DefaultTableModel();
    // + Khai bao model cho table DopList ca nhan sinh vien dang duoc cham soc
    DefaultTableModel modelDropList = new DefaultTableModel();
    // + Khai bao model cho table LichSuChamSoc cua toan bo sinh vien
    DefaultTableModel modelLichSuCS = new DefaultTableModel();
    // + Khai bao model cho table LichSuChamSoc cua toan bo sinh vien
    DefaultTableModel model_qlcd_doiPhanCong = new DefaultTableModel();
    DefaultTableModel model_qlcd_daPhanCong = new DefaultTableModel();
    DefaultTableModel modelPhanCong = new DefaultTableModel();
    // + Khai bao model hien thi danh sach chien dich
    DefaultTableModel modelDl = new DefaultTableModel();
// Khai bao DAO
    HocKiDAO hocKiDAO = new HocKiDAO();
    ChienDichCDDAO chienDichCDDAO = new ChienDichCDDAO();
    ChienDichDAO chienDichDAO = new ChienDichDAO();
    NhanSuDAO nhanSuDAO = new NhanSuDAO();
    ChuyenNganhDAO chuyenNganhDAO = new ChuyenNganhDAO();
    PhanCongDAO phanCongDAO = new PhanCongDAO();
    SinhVienDAO sinhVienDAO = new SinhVienDAO();
    DropListDAO dopDropListDAO = new DropListDAO();
    DropListCTDAO dropListCTDAO = new DropListCTDAO();
    // + KB DanhGiaVHDAO
    DanhGiaVHDAO danhGiaVHDAO = new DanhGiaVHDAO();
    // + khai bao danh gia vang hoc tieng Anh DAO
    DanhGiaENDAO danhGiaENDAO = new DanhGiaENDAO();
    // + KB DanhGiaHPDAO
    DanhGiaHPDAO danhGiaHPDAO = new DanhGiaHPDAO();
    // + KB DanhGia1d3DAO
    DanhGia1D3DAO danhGia1D3DAO = new DanhGia1D3DAO();
    // + KB LichSuChamSocVHDAO
    LichSuChamSOC1D3DAO lichSuChamSOC1D3DAO = new LichSuChamSOC1D3DAO();
    // + KB LichSuChamSocHPDAO
    LichSuChamSocVHDAO lichSuChamSocVHDAO = new LichSuChamSocVHDAO();
    // + KB LichSuChamSoc1D3DAO
    LichSuChamSOCHPDAO lichSuChamSOCHPDAO = new LichSuChamSOCHPDAO();
    // + KB LichSuChamSoc1D3DAO
    LichSuChamSocENDAO lichSuChamSOCENDAO = new LichSuChamSocENDAO();
    // - Khai bao List() danh sach
    // + List Hoc ki
    List<HocKi> dshk = new ArrayList<HocKi>();
    // + List Chien dich chu dong
    List<ChienDichCD> dsChienDichCD = new ArrayList<ChienDichCD>();
    // + List Nhan su
    List<NhanSu> dsns = new ArrayList();
    // + List chien dich
    List<ChienDich> danhSachCD = new ArrayList<ChienDich>();
    // + List Chuyen nganh
    List<ChuyenNganh> dsChuyenNganhs = new ArrayList<>();
    // + List Danh gia
    // + Khai bao list Danh gia ca nhan

    // + Khai bao list DropListCT
    List<DropListCT> dropListldgnvh = new ArrayList<>();
    // + Khai bao list DropListCT
    List<DropListCT> dropListnvvh = new ArrayList<>();
    // + Khai bao list DropListCT
    List<DropListCT> dropListldgnhp = new ArrayList<>();
    // + Khai bao list DropListCT
    List<DropListCT> dropListplnvhp = new ArrayList<>();
    // + Khai bao list DropListCT
    List<DropListCT> dropListdt = new ArrayList<>();
    // + Khai bao list DropListCT
    List<DropListCT> dropListplnc = new ArrayList<>();
    // + Khai bao list DropListCT
    // + Khai bao list cham soc dong thoi
    // + khai báo list phân công của một nhân sự
    List<PhanCong> listPhanCongCuaMotNhanSu = new ArrayList<>();
    // + Khai báo list đánh giá văn học
    List<DanhGiaVH> danhSachDGVH = new ArrayList<>();
    // + Khai báo list đánh giá học phí
    List<DanhGiaHP> danhSachDGHP = new ArrayList<>();
    // + Khai báo list đánh giá 1 / 3 block
    List<DanhGia1D3> danhSachDG1D3 = new ArrayList<>();
    // + Khai báo list đánh giá văn học cá nhân
    List<DanhGiaVH> danhSachDGVHCn = new ArrayList<>();
    // + Khai báo list đánh giá văn học tiếng ANh cá nhân
    List<DanhGiaEN> danhSachDGENCn = new ArrayList<>();
    // + Khai báo list đánh giá học phí cá nhân
    List<DanhGiaHP> danhSachDGHPCn = new ArrayList<>();
    // + Khai báo list đánh giá 1 / 3 block cá nhân
    List<DanhGia1D3> danhSachDG1D3Cn = new ArrayList<>();
    // + Khai báo list đánh giá văn học cá nhân đẫ phân công 1
    List<DanhGiaVH> danhSachDGVHdaPc = new ArrayList<>();
    // + Khai báo list đánh giá văn học cá nhân đẫ phân công 1
    List<DanhGiaEN> danhSachDGENdaPc = new ArrayList<>();
    // + Khai báo list đánh giá học phí cá nhân đã phân công 1
    List<DanhGiaHP> danhSachDGHPdaPc = new ArrayList<>();
    // + Khai báo list đánh giá 1 / 3 block cá nhân đã phân công 1
    List<DanhGia1D3> danhSachDG1D3daPc = new ArrayList<>();
    // + Khai báo list đánh giá văn học cá nhân chưa phân công 1
    List<DanhGiaVH> danhSachDGVHchuaPc = new ArrayList<>();
    // + Khai bao danh sach danh gia vang hoc tieng Anh chuamphan cong
    List<DanhGiaEN> danhSachDGENchuaPc = new ArrayList<>();
    // + Khai báo list đánh giá học phí cá nhân chưa phân công 1
    List<DanhGiaHP> danhSachDGHPchuaPc = new ArrayList<>();
    // + Khai báo list đánh giá 1 / 3 block cá nhân chưa phân công 1
    List<DanhGia1D3> danhSachDG1D3chuaPc = new ArrayList<>();
    // + Khai báo list lịch sử chăm sóc học phí
    List<LichSuChamSocHP> lichSuChamSocHPs = new ArrayList<>();
    // + Khai báo list lịch sử chăm sóc vắn học
    List<LichSuChamSocVH> lichSuChamSocVHs = new ArrayList<>();
    // + Khai báo list lịch sử chăm sóc 1 Div 3 block
    List<LichSuChamSoc1D3> lichSuChamSoc1D3s = new ArrayList<>();
    // + Khai báo list lịch sử chăm sóc học phí
    List<LichSuChamSocHP> lichSuChamSocHPcn = new ArrayList<>();
    // + Khai báo list lịch sử chăm sóc vắn học
    List<LichSuChamSocVH> lichSuChamSocVHcn = new ArrayList<>();
    // + Khai báo list lịch sử chăm sóc vắng hoc tieng Anh
    List<LichSuChamSocEN> lichSuChamSocENcn = new ArrayList<>();
    // + Khai báo list lịch sử chăm sóc 1 Div 3 block
    List<LichSuChamSoc1D3> lichSuChamSoc1Dcn = new ArrayList<>();
    // + Khai báo list lịch sử chăm sóc học phí
    List<LichSuChamSocHP> lichSuChamSocHPALL = new ArrayList<>();
    // + Khai báo list lịch sử chăm sóc vắn học
    List<LichSuChamSocVH> lichSuChamSocVHALL = new ArrayList<>();
    // + Khai báo list lịch sử chăm sóc 1 Div 3 block
    List<LichSuChamSoc1D3> lichSuChamSoc1DALL = new ArrayList<>();
    // + Khai báo list lịch sử chăm sóc tiếng Anh
    List<LichSuChamSocEN> lichSuChamSocENALL = new ArrayList<>();
// Khai báo list chứa masv người dùng chọn 
    List<String> listMasv = new ArrayList<>();
    // Khai bao bien
    int row = -1;
    int rowTableCS = -1;
    int rowTablePC = -1;
// Khai báo các hàm loadData()
    // + Khai báo load data chăm sóc các loại chiến dịch

    public void loadDataPhanCong() {
        HocKi hocKi = hocKiDAO.LayHocKiMoiNhat();
        if (hocKi != null) {
            danhSachDGVHdaPc = danhGiaVHDAO.layDanhSachDaPhanCong(hocKi.getMaHocKi());
            danhSachDGVHchuaPc = danhGiaVHDAO.layDanhSachChoPhanCong(hocKi.getMaHocKi());
            danhSachDGENdaPc = danhGiaENDAO.layDanhSachDaPhanCong(hocKi.getMaHocKi());
            danhSachDGENchuaPc = danhGiaENDAO.layDanhSachChoPhanCong(hocKi.getMaHocKi());
            danhSachDGHPdaPc = danhGiaHPDAO.layDanhSachDaPhanCong(hocKi.getMaHocKi());
            List<DanhGiaHP> list = new ArrayList<>();
            for (DanhGiaHP danhGiaHP1 : danhSachDGHPdaPc) {
                if (danhGiaHP1.getTrangThai() || (danhGiaHP1.isTrangThaiBL() && danhGiaHP1.isTrangThaiHP()) || (danhGiaHP1.isTrangThaiBL() == false && danhGiaHP1.isTrangThaiHP() == false)) {
                    list.add(danhGiaHP1);
                }
            }
            danhSachDGHPdaPc = list;
            danhSachDGHPchuaPc = danhGiaHPDAO.layDanhSachChoPhanCong(hocKi.getMaHocKi());
            List<DanhGiaHP> list2 = new ArrayList<>();
            for (DanhGiaHP danhGiaHP1 : danhSachDGHPchuaPc) {
                if (danhGiaHP1.getTrangThai() || (danhGiaHP1.isTrangThaiBL() && danhGiaHP1.isTrangThaiHP()) || (danhGiaHP1.isTrangThaiBL() == false && danhGiaHP1.isTrangThaiHP() == false)) {
                    list2.add(danhGiaHP1);
                }
            }
            danhSachDGHPchuaPc = list2;
            danhSachDG1D3daPc = danhGia1D3DAO.layDanhSachDaPhanCong(hocKi.getMaHocKi());
            danhSachDG1D3chuaPc = danhGia1D3DAO.layDanhSachChoPhanCong(hocKi.getMaHocKi());
            // Thong ke
            tongChuaCS = danhSachDGVHdaPc.size() + danhSachDGVHchuaPc.size() + danhSachDGHPdaPc.size()
                    + danhSachDGHPchuaPc.size() + danhSachDG1D3daPc.size() + danhSachDG1D3chuaPc.size();
            jlb_qlcd_ChuaCS.setText(tongChuaCS + "");
            jlb_qlcd_Dacs.setText(tongdaCS + "");
            jlb_qlcd_tong.setText("" + (tongChuaCS + tongdaCS));
        }
    }

    public void loadDataPhanCongTheoCDCD(String maChienDichCD) {

        danhSachDGVHdaPc = danhGiaVHDAO.layDsDaPcOfCDCD(maChienDichCD);
        danhSachDGVHchuaPc = danhGiaVHDAO.layDsChuaPcOfCDCD(maChienDichCD);
        danhSachDGENdaPc = danhGiaENDAO.layDsDaPcOfCDCD(maChienDichCD);
        danhSachDGENchuaPc = danhGiaENDAO.layDsChuaPcOfCDCD(maChienDichCD);
        danhSachDGHPdaPc = danhGiaHPDAO.layDsDaPcOfCDCD(maChienDichCD);
        List<DanhGiaHP> list = new ArrayList<>();
        for (DanhGiaHP danhGiaHP1 : danhSachDGHPdaPc) {
            if (danhGiaHP1.getTrangThai() || (danhGiaHP1.isTrangThaiBL() && danhGiaHP1.isTrangThaiHP()) || (danhGiaHP1.isTrangThaiBL() == false && danhGiaHP1.isTrangThaiHP() == false)) {
                list.add(danhGiaHP1);
            }
        }
        danhSachDGHPdaPc = list;
        danhSachDGHPchuaPc = danhGiaHPDAO.layDsChuaPcOfCDCD(maChienDichCD);
        danhSachDG1D3daPc = danhGia1D3DAO.layDsDaPcOfCDCD(maChienDichCD);
        danhSachDG1D3chuaPc = danhGia1D3DAO.layDsChuaPcOfCDCD(maChienDichCD);
        tongChuaCS = danhSachDGVHdaPc.size() + danhSachDGVHchuaPc.size() + danhSachDGHPdaPc.size()
                + danhSachDGHPchuaPc.size() + danhSachDG1D3daPc.size() + danhSachDG1D3chuaPc.size();
        jlb_qlcd_ChuaCS.setText(tongChuaCS + "");
        jlb_qlcd_Dacs.setText(tongdaCS + "");
        jlb_qlcd_tong.setText("" + (tongChuaCS + tongdaCS));

    }

    public void loadDataLichSuCS() {
        HocKi hocKi = hocKiDAO.LayHocKiMoiNhat();
        if (hocKi != null) {
            String maHocKi = hocKi.getMaHocKi();
            lichSuChamSocVHALL = lichSuChamSocVHDAO.LayLichSuTheoHK(maHocKi);
            lichSuChamSocHPALL = lichSuChamSOCHPDAO.LayLichSuTheoHK(maHocKi);
            lichSuChamSoc1DALL = lichSuChamSOC1D3DAO.LayLichSuTheoHK(maHocKi);
            lichSuChamSocENALL = lichSuChamSOCENDAO.LayLichSuTheoHK(maHocKi);
            tongdaCS = lichSuChamSocVHALL.size() + lichSuChamSocHPALL.size() + lichSuChamSoc1DALL.size();
            txt_home_tongData.setText(tongdaCS + "");
        }
    }

    public void fillToTableLichSuCSALL() {
        modelLichSuCS.setRowCount(0);
        if (!(lichSuChamSocVHALL.isEmpty())) {
            for (LichSuChamSocVH lichSuChamSoc : lichSuChamSocVHALL) {
                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                    lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(), lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(),
                    lichSuChamSoc.getNhanSu().getMans(), lichSuChamSoc.getThoiGianCS()});
            }
        }
        if (!(lichSuChamSocHPALL.isEmpty())) {
            for (LichSuChamSocHP lichSuChamSoc : lichSuChamSocHPALL) {
                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                    lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(), lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(),
                    lichSuChamSoc.getNhanSu().getMans(), lichSuChamSoc.getThoiGianCS()});
            }
        }
        if (!(lichSuChamSoc1DALL.isEmpty())) {
            for (LichSuChamSoc1D3 lichSuChamSoc : lichSuChamSoc1DALL) {
                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                    lichSuChamSoc.getMSSV(), lichSuChamSoc.getLyDoGhiNhan(), lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(),
                    lichSuChamSoc.getNhanSu().getMans(), lichSuChamSoc.getThoiGianCS()});
            }
        }
        if (!(lichSuChamSocENALL.isEmpty())) {
            for (LichSuChamSocEN lichSuChamSoc : lichSuChamSocENALL) {
                modelLichSuCS.addRow(new Object[]{lichSuChamSoc.getChienDich().getMaChienDich(),
                    lichSuChamSoc.getMssv(), lichSuChamSoc.getLyDoGhiNhan(), lichSuChamSoc.getDienGiaiCT(), lichSuChamSoc.getPhanLoaiNguyCo(),
                    lichSuChamSoc.getNhanSu().getMans(), lichSuChamSoc.getThoiGianCS()});
            }
        }
    }

    public void fillToTabledaPhanCong() {
        modelPhanCong.setRowCount(0);
        int count = 1;
        if (!(danhSachDGVHdaPc.isEmpty())) {
            for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(), danhGiaVH.getNhanSu().getMans(),
                    danhGiaVH.getChienDichCD().getThoiGianTao()});
                count++;
            }
        }
        if (!(danhSachDGENdaPc.isEmpty())) {
            for (DanhGiaEN danhGiaVH : danhSachDGENdaPc) {
                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(), danhGiaVH.getNhanSu().getMans(),
                    danhGiaVH.getChienDichCD().getThoiGianTao()});
                count++;
            }
        }
        if (!(danhSachDGHPdaPc).isEmpty()) {
            for (DanhGiaHP danhGiaVH : danhSachDGHPdaPc) {
                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(), danhGiaVH.getNhanSu().getMans(),
                    danhGiaVH.getChienDichCD().getThoiGianTao()});
                count++;
            }
        }
        if (!(danhSachDG1D3daPc.isEmpty())) {
            for (DanhGia1D3 danhGiaVH : danhSachDG1D3daPc) {
                modelPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(), danhGiaVH.getNhanSu().getMans(),
                    danhGiaVH.getChienDichCD().getThoiGianTao()});
                count++;
            }
        }
    }

    public void fillToTableChuaPhanCong() {
        model_qlcd_doiPhanCong.setRowCount(0);
        int count = 1;
        if (!(danhSachDGVHchuaPc.isEmpty())) {
            for (DanhGiaVH danhGiaVH : danhSachDGVHchuaPc) {
                model_qlcd_doiPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(), "Đang đợi", danhGiaVH.getChienDichCD().getThoiGianTao()});
                count++;
            }
        }
        if (!(danhSachDGENchuaPc.isEmpty())) {
            for (DanhGiaEN danhGiaVH : danhSachDGENchuaPc) {
                model_qlcd_doiPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(), "Đang đợi", danhGiaVH.getChienDichCD().getThoiGianTao()});
                count++;
            }
        }
        if (!(danhSachDGHPchuaPc.isEmpty())) {
            for (DanhGiaHP danhGiaVH : danhSachDGHPchuaPc) {
                model_qlcd_doiPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(), "Đang đợi", danhGiaVH.getChienDichCD().getThoiGianTao()});
                count++;
            }
        }
        if (!(danhSachDG1D3chuaPc.isEmpty())) {
            for (DanhGia1D3 danhGiaVH : danhSachDG1D3chuaPc) {
                model_qlcd_doiPhanCong.addRow(new Object[]{count, danhGiaVH.getChienDich().getMaChienDich(),
                    danhGiaVH.getSinhVien().getMssv(), danhGiaVH.getMacn(), "Đang đợi", danhGiaVH.getChienDichCD().getThoiGianTao()});
                count++;
            }
        }

    }

    public void loadDataChamSoctheoCD() {
        danhSachDGVH = danhGiaVHDAO.selectAll();
        danhSachDGHP = danhGiaHPDAO.selectAll();
        danhSachDG1D3 = danhGia1D3DAO.selectAll();
    }

    public void getChamSocVhCn() {
        if (!(danhSachDGVHdaPc.isEmpty())) {
            for (DanhGiaVH danhGiaVH : danhSachDGVHdaPc) {
                if (danhGiaVH.getNhanSu() != null) {
                    if (danhGiaVH.getNhanSu().getMans().equals(Auth.user.getMans())) {
                        danhSachDGVHCn.add(danhGiaVH);
                    }
                }
            }
        }
    }

    public void getChamSocHpCn() {
        if (!(danhSachDGHPdaPc.isEmpty())) {
            for (DanhGiaHP danhGiaHP : danhSachDGHPdaPc) {
                if ((danhGiaHP.getNhanSu().getMans().equals(Auth.user.getMans()))) {
                    danhSachDGHPCn.add(danhGiaHP);
                }
            }
        }
    }

    public void getChamSoc1D3Cn() {
        if (!(danhSachDG1D3daPc.isEmpty())) {
            for (DanhGia1D3 danhGia1D3 : danhSachDG1D3daPc) {
                if (danhGia1D3.getNhanSu() != null) {
                    if (danhGia1D3.getNhanSu().getMans().equals(Auth.user.getMans())) {
                        danhSachDG1D3Cn.add(danhGia1D3);
                    }
                }
            }
        }
    }

    public void fillTableCanChamSocVH() {
        modelSvCanCS.setRowCount(0);
        if (!(danhSachDGVHCn.isEmpty())) {
            int count = 1;
            for (DanhGiaVH danhGiaVH : danhSachDGVHCn) {
                modelSvCanCS.addRow(new Object[]{count, danhGiaVH.getSinhVien().getMssv(),
                    danhGiaVH.getChienDichCD().getThoiGianTao()});
                count++;
            }
            count--;
            jlb_CSSV_ChuaCS.setText(count + "");
        }
    }

    public void fillTableCanChamSocEN() {
        modelSvCanCS.setRowCount(0);
        if (!(danhSachDGENCn.isEmpty())) {
            int count = 1;
            for (DanhGiaEN danhGiaVH : danhSachDGENCn) {
                modelSvCanCS.addRow(new Object[]{count, danhGiaVH.getSinhVien().getMssv(),
                    danhGiaVH.getChienDichCD().getThoiGianTao()});
                count++;
            }
            count--;
            jlb_CSSV_ChuaCS.setText(count + "");
        }
    }

    public void fillTableCanChamSocHP() {
        modelSvCanCS.setRowCount(0);
        if (!(danhSachDGHPCn.isEmpty())) {
            int count = 1;
            for (DanhGiaHP danhGiaHP : danhSachDGHPCn) {
                modelSvCanCS.addRow(new Object[]{count, danhGiaHP.getSinhVien().getMssv(),
                    danhGiaHP.getChienDichCD().getThoiGianTao()});
                count++;
            }
            count--;
            jlb_CSSV_ChuaCS.setText(count + "");
        }

    }

    public void fillTableCanChamSoc1D3() {
        modelSvCanCS.setRowCount(0);
        if (!(danhSachDG1D3Cn.isEmpty())) {
            int count = 1;
            for (DanhGia1D3 danhGia1D3 : danhSachDG1D3Cn) {
                modelSvCanCS.addRow(new Object[]{count, danhGia1D3.getSinhVien().getMssv(),
                    danhGia1D3.getChienDichCD().getThoiGianTao()});
                count++;
            }
            count--;
            jlb_CSSV_ChuaCS.setText(count + "");
        }
    }

    public String fillToFormVH(int index) {
        DanhGiaVH danhGiaVH = danhSachDGVHCn.get(index);
        sinhVienCS = sinhVienDAO.selectById(danhGiaVH.getSinhVien());
        txtCSSV_MSSV.setText(sinhVienCS.getMssv());
        txt_CSSV_ChuyenNganh.setText(sinhVienCS.getChuyenNganh());
        txt_CSSV_KiHoc.setText(sinhVienCS.getKiHocHT() + "");
        txt_CSSV_HoTen.setText(sinhVienCS.getHoVaTen());
        txt_CSSV_TrangThai.setText(sinhVienCS.getTrangThai());
        jlb_cs_monHoc.setText(danhGiaVH.getMaMon());
        KiemTraCSDTVh(sinhVienCS.getMssv());
        return sinhVienCS.getMssv();
    }

    public String fillToFormEN(int index) {
        DanhGiaEN danhGiaVH = danhSachDGENCn.get(index);
        sinhVienCS = sinhVienDAO.selectById(danhGiaVH.getSinhVien());
        txtCSSV_MSSV.setText(sinhVienCS.getMssv());
        txt_CSSV_ChuyenNganh.setText(sinhVienCS.getChuyenNganh());
        txt_CSSV_KiHoc.setText(sinhVienCS.getKiHocHT() + "");
        txt_CSSV_HoTen.setText(sinhVienCS.getHoVaTen());
        txt_CSSV_TrangThai.setText(sinhVienCS.getTrangThai());
        jlb_cs_monHoc.setText(danhGiaVH.getMaMon());
        KiemTraCSDTEN(sinhVienCS.getMssv());
        return sinhVienCS.getMssv();
    }

    public String fillToFormHP(int index) {
        DanhGiaHP danhGiaHP = danhSachDGHPCn.get(index);
        sinhVienCS = sinhVienDAO.selectById(danhGiaHP.getSinhVien());
        txtCSSV_MSSV.setText(sinhVienCS.getMssv());
        txt_CSSV_ChuyenNganh.setText(sinhVienCS.getChuyenNganh());
        txt_CSSV_KiHoc.setText(sinhVienCS.getKiHocHT() + "");
        txt_CSSV_HoTen.setText(sinhVienCS.getHoVaTen());
        txt_CSSV_TrangThai.setText(sinhVienCS.getTrangThai());
        KiemTraCSDTHp(sinhVienCS.getMssv());
        return sinhVienCS.getMssv();
    }

    public String fillToForm1D3(int index) {
        DanhGia1D3 danhGia1D3 = danhSachDG1D3Cn.get(index);
        sinhVienCS = sinhVienDAO.selectById(danhGia1D3.getSinhVien());
        txtCSSV_MSSV.setText(sinhVienCS.getMssv());
        txt_CSSV_ChuyenNganh.setText(sinhVienCS.getChuyenNganh());
        txt_CSSV_KiHoc.setText(sinhVienCS.getKiHocHT() + "");
        txt_CSSV_HoTen.setText(sinhVienCS.getHoVaTen());
        txt_CSSV_TrangThai.setText(sinhVienCS.getTrangThai());
        txt_CSSV_NX.setText(danhGia1D3.getNhanXet());
        jlb_cs_monHoc.setText(danhGia1D3.getTenMonHoc());
        KiemTraCSDT1d3(sinhVienCS.getMssv());
        return sinhVienCS.getMssv();
    }

    public void getLichchuCSofSV(String mssv) {
        lichSuChamSocVHcn = lichSuChamSocVHDAO.getLichSuTheoMssv(mssv);
        if (!(lichSuChamSocVHcn.isEmpty())) {
            for (LichSuChamSocVH lichSuChamSocVH : lichSuChamSocVHcn) {
                modelLichSuCSCN.addRow(new Object[]{lichSuChamSocVH.getChienDich().getMaChienDich(),
                    lichSuChamSocVH.getNhanSu().getMans(), lichSuChamSocVH.getThoiGianCS(), lichSuChamSocVH.getPhanLoaiNguyCo(), lichSuChamSocVH.getLyDoGhiNhan(),
                    lichSuChamSocVH.getDienGiaiCT()});
            }
        }
        lichSuChamSocENcn = lichSuChamSOCENDAO.getLichSuTheoMssv(mssv);
        if (!(lichSuChamSocENcn.isEmpty())) {
            for (LichSuChamSocEN lichSuChamSocVH : lichSuChamSocENcn) {
                modelLichSuCSCN.addRow(new Object[]{lichSuChamSocVH.getChienDich().getMaChienDich(),
                    lichSuChamSocVH.getNhanSu().getMans(), lichSuChamSocVH.getThoiGianCS(), lichSuChamSocVH.getPhanLoaiNguyCo(), lichSuChamSocVH.getLyDoGhiNhan(),
                    lichSuChamSocVH.getDienGiaiCT()});
            }
        }
        lichSuChamSocHPcn = lichSuChamSOCHPDAO.getLichSuTheoMssv(mssv);
        if (!(lichSuChamSocHPcn.isEmpty())) {
            for (LichSuChamSocHP lichSuChamSocHP : lichSuChamSocHPcn) {
                modelLichSuCSCN.addRow(new Object[]{lichSuChamSocHP.getChienDich().getMaChienDich(),
                    lichSuChamSocHP.getNhanSu().getMans(), lichSuChamSocHP.getThoiGianCS(), lichSuChamSocHP.getPhanLoaiNguyCo(), lichSuChamSocHP.getLyDoGhiNhan(),
                    lichSuChamSocHP.getDienGiaiCT()});
            }
        }
        lichSuChamSoc1Dcn = lichSuChamSOC1D3DAO.getLichSuTheoMans(mssv);
        if (!(lichSuChamSoc1Dcn.isEmpty())) {
            for (LichSuChamSoc1D3 lichSuChamSoc1D3 : lichSuChamSoc1Dcn) {
                modelLichSuCSCN.addRow(new Object[]{lichSuChamSoc1D3.getChienDich().getMaChienDich(),
                    lichSuChamSoc1D3.getNhanSu().getMans(), lichSuChamSoc1D3.getThoiGianCS(), lichSuChamSoc1D3.getPhanLoaiNguyCo(), lichSuChamSoc1D3.getLyDoGhiNhan(),
                    lichSuChamSoc1D3.getDienGiaiCT()});
            }
        }
    }

    // clear Form nhân sự
    private void clearFormNhanSu() {
        txtMaNS.setText("");
        txtTenNhanSu.setText("");
        txtEmailNS.setText("");
        rdoTrangThaiOn.setSelected(true);
        rdoAdmin.setSelected(true);
        cboNhanSuNam.setSelected(true);
        modelNS_PC_CN.setRowCount(0);
        listPhanCongCuaMotNhanSu.clear();
    }

    // phương thức lưu thông tin nhân sự
    private void luuNhanSu() {
        try {
            NhanSu ns = getFormNhanSu();
            // lưu nhân sự
            nhanSuDAO.insert(ns);
            // xoá phân công của nhân sự phụ trách
            phanCongDAO.deleteByMans(ns.getMans());
            if (ns.getTrangThai()) {
                // lưu lại phân công của nhân sự
                for (PhanCong pc : listPhanCongCuaMotNhanSu) {
                    phanCongDAO.insert(pc);
                }
            }
            // hiển thị lại bảng nhân sự
            FilloTableDSNSON();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // get form nhân sự
    private NhanSu getFormNhanSu() {
        NhanSu ns = new NhanSu();
        ns.setMans(txtMaNS.getText());
        ns.setHoVaten(txtTenNhanSu.getText());
        ns.setEmail(txtEmailNS.getText());
        ns.setGioiTinh(cboNhanSuNam.isSelected() ? true : false);
        ns.setTrangThai(rdoTrangThaiOn.isSelected() ? true : false);
        if (rdoTrangThaiOn.isSelected()) {
            ns.setTrangThai(true);
        } else {
            ns.setTrangThai(false);
        }
        if (rdoAdmin.isSelected()) {
            ns.setVaiTro(0);
        } else if (rdoUser1.isSelected()) {
            ns.setVaiTro(1);
        } else {
            ns.setVaiTro(2);
        }

        return ns;
    }

    // phương thức hiển thị nhân sự off
    private void FilloTableDSNSOFF() {
        try {
            dsns = nhanSuDAO.selectNsOFF();
            modelDSNS.setRowCount(0);
            for (NhanSu ns : dsns) {
                Object[] row = {ns.getMans(), ns.getHoVaten(), ns.getTrangThai()};
                modelDSNS.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
//phuong thuc hien thi tat ca nhan sư

    private void FilloTableDSNSALL() {
        try {
            dsns = nhanSuDAO.selectAll();

            modelDSNS.setRowCount(0);
            for (NhanSu ns : dsns) {
                Object[] row = {ns.getMans(), ns.getHoVaten(), ns.getTrangThai()};
                modelDSNS.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Phuong thuc getFormHocKi
    public HocKi getHocKi() {

        String dateBatDauHk = sdf.format(dcsBatDauHK.getDate());
        String dateKetThucHk = sdf.format(dcsKetThucHocKi.getDate());
        HocKi hocKi = new HocKi();
        hocKi.setTenHocKi(txtTenHocKi.getText());
        hocKi.setMaHocKi(txtMaHocKi.getText());
        hocKi.setThoiGianBatDau(Date.valueOf(dateBatDauHk));
        hocKi.setThoiGianKetThuc(Date.valueOf(dateKetThucHk));
        return hocKi;
    }

    // Hiển thị danh sách nhân sự lên bảng nhân sự
    public void FilloTableDSNS() {
        dsns = nhanSuDAO.selectAll();
        if (!(dsns.isEmpty())) {
            modelDSNS.setRowCount(0);
            for (NhanSu ns : dsns) {
                Object[] row = {ns.getMans(), ns.getHoVaten(), ns.getTrangThai(),};
                modelDSNS.addRow(row);
            }
        }
    }
// Lấy một đối tượng nhân sự do admin chọn và hiển thị lên form quản lý nhân sự

    private void fillToForm() {
        NhanSu nhanSu = dsns.get(row);
        String mans = (String) tblDanhSachNS.getValueAt(this.row, 0);
        this.setForm(nhanSu);
        fillToTablePhanCong();
    }
// Nhận một đối tượng nhân sự do người dùng chọn và hiển thị lên form quản lý nhân sự

    private void setForm(NhanSu ns) {
        txtMaNS.setText(ns.getMans());
        txtTenNhanSu.setText(ns.getHoVaten());
        txtEmailNS.setText(ns.getEmail());
        if (ns.getTrangThai()) {
            rdoTrangThaiOn.setSelected(true);
        } else {
            rdoTrangThaiOff.setSelected(true);
        }
        if (ns.getVaiTro() == 0) {
            rdoAdmin.setSelected(true);
        } else if (ns.getVaiTro() == 1) {
            rdoUser1.setSelected(true);
        } else {
            rdoUser2.setSelected(true);
        }
        if (ns.getGioiTinh()) {
            cboNhanSuNam.setSelected(true);
        } else {
            cboNhanSuNu.setSelected(true);
        }

    }
// Lấy thông tin từ form quản lý nhân sự

    private NhanSu getForm() {
        NhanSu ns = new NhanSu();
        ns.setMans(txtMaNS.getText());
        ns.setHoVaten(txtTenNhanSu.getText());
        ns.setMatKhau("1");
        ns.setTrangThai(rdoTrangThaiOn.isSelected());
        ns.setGioiTinh(cboNhanSuNam.isSelected());
        ns.setEmail(txtEmailNS.getText());
//        ns.setVaiTro(rdoAdmin.isSelected());
        return ns;
    }
// Lấy danh sách file import và tải lên list file import

    public void getDanhSachIP() {
        dsChienDichCD = chienDichCDDAO.getDsChuaXuLy();
        if (!(dsChienDichCD.isEmpty())) {
            listModelDSIP.removeAllElements();
            for (ChienDichCD chienDichCD : dsChienDichCD) {
                listModelDSIP.addElement(chienDichCD);
            }

        }
    }

    public void loadData() {
        // Lấy danh sách học kì từ csdl
        dshk = hocKiDAO.selectAllMoiNhat();
        // Lấy danh sách chiến dịch từ csdl
        danhSachCD = chienDichDAO.selectAll();
        // Lấy danh sách nhân sự từ csdl
        dsns = nhanSuDAO.selectAll();
        // Lấy danh sách chuyên ngành từ csdl
        dsChuyenNganhs = chuyenNganhDAO.selectAll();
        // Lấy danh sách đánh giá từ csdl
        // tải dữ liệu trên Table home
    }

    // Hiển thị danh sách học kì lênh combobox được chọn
    public void fillToCboHK(JComboBox jComboBox) {
        if (!(dshk == null)) {
            jComboBox.removeAllItems();

            // jComboBox.addItem("Lựa chọn học kì");
            for (HocKi hocKi : dshk) {
                jComboBox.addItem(hocKi.getMaHocKi());
            }
        }
    }

    // Hiển thị danh chiến dịch lênh combobox được chọn
    public void fillToCboCD(JComboBox jComboBox) {
        if (!(danhSachCD == null)) {
            jComboBox.removeAllItems();
            jComboBox.addItem("Lựa chọn chiến dịch");
            for (ChienDich chienDich : danhSachCD) {
                jComboBox.addItem(chienDich.getMaChienDich());
            }
        }
    }
    // Hiển thị danh nhân sự lênh combobox được chọn

    public void fillToCboNS(JComboBox jComboBox) {
        if (!(dsns == null)) {
            jComboBox.removeAllItems();
            jComboBox.addItem("Lựa chọn nhân sự");
            for (NhanSu nhanSu : dsns) {

                jComboBox.addItem(nhanSu.getMans());
            }
        }

    }

    // Hiển thị danh sách chuyên ngành lênh combobox được chọn
    public void fillToCboCN(JComboBox jComboBox) {
        if (!(dsChuyenNganhs == null)) {
            jComboBox.removeAllItems();
            jComboBox.addItem("Lựa chọn chuyên ngành");
            for (ChuyenNganh chuyenNganh : dsChuyenNganhs) {
                jComboBox.addItem(chuyenNganh.getMaChuyenNganh());
            }
        }
    }

    // import danh sach sinh vien cham soc van hoc
    public void importCSVH() {
        int count = 0;
        HocKi hocKi2 = null;
        int cellNum = 0;
        ChienDich chienDich = new ChienDich("CSVH");
        List<PhanCong> phanCongs = new ArrayList<>();
        List<String> listDanhGia1 = new ArrayList<>();
        List<String> listDanhGia2 = new ArrayList<>();
        int soLuongPt = 0;
        // Tao ma chien dich
        String maChienDich = String.valueOf(System.currentTimeMillis());
        ChienDichCD cdcd = new ChienDichCD(maChienDich, txtTenChienDichChuDong.getText(),
                new Timestamp(System.currentTimeMillis()), false, Auth.user);
        String hocKi = "";
        if (cboChonHocKi.getSelectedIndex() != -1) {
            hocKi2 = new HocKi(String.valueOf(cboChonHocKi.getSelectedItem()));
        }
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                try {
                    chienDichCDDAO.insert(cdcd);
                    try {
                        FileInputStream fileInputStream = new FileInputStream(txtLinkFileData.getText());
                        XSSFWorkbook xssfw = new XSSFWorkbook(fileInputStream);
                        XSSFSheet sheet = xssfw.getSheetAt(0);
                        FormulaEvaluator formulaEvaluator = xssfw.getCreationHelper().createFormulaEvaluator();
                        int totalRowCount = sheet.getLastRowNum();
                        for (org.apache.poi.ss.usermodel.Row row : sheet) {
                            Transaction transaction = session.beginTransaction();
                            DanhGiaVH danhGiaVH = new DanhGiaVH();
                            SinhVien sinhVien = new SinhVien();
                            count++;
                            cellNum = 0;
                            for (Cell cell : row) {
                                switch (cellNum) {
                                    case 0:
									try {
                                        sinhVien.setMssv(cell.getStringCellValue());
                                        danhGiaVH.setSinhVien(sinhVien);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        sinhVien.setMssv(String.valueOf(cell.getNumericCellValue()));
                                        danhGiaVH.setSinhVien(sinhVien);
                                    }
                                    break;
                                    case 1:
									try {
                                        danhGiaVH.setMaMon(cell.getStringCellValue());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        danhGiaVH.setMaMon(String.valueOf(cell.getNumericCellValue()));
                                    }
                                    break;
                                }
                                cellNum++;
                            }
                            danhGiaVH.setChienDich(new ChienDich("CSVH"));
                            danhGiaVH.setHocKi(hocKi2);
                            sinhVien = sinhVienDAO.selectByIresultTwo(sinhVien);
                            if (sinhVien == null) {
                                sinhVien = danhGiaVH.getSinhVien();
                                session.save(sinhVien);
                            } else {
                                if (!(sinhVien.getChuyenNganh() == null)) {
                                    danhGiaVH.setMacn(sinhVien.getChuyenNganh());
                                    try {
                                        phanCongs = phanCongDAO.getPhanCong(sinhVien.getChuyenNganh(), "CSVH");
                                        if (phanCongs.size() == 1) {
                                            danhGiaVH.setNhanSu(phanCongs.get(0).getNhanSu());
                                        } else if (phanCongs.size() > 1) {
                                            boolean check = true;
                                            for (int i = 0; i < phanCongs.size(); i++) {
                                                if (i == 0) {
                                                    listDanhGia1 = danhGiaVHDAO
                                                            .Resultmans(phanCongs.get(i).getNhanSu().getMans());
                                                    if (listDanhGia1.size() == 0) {
                                                        danhGiaVH.setNhanSu(phanCongs.get(i).getNhanSu());
                                                        check = false;
                                                        break;
                                                    }
                                                } else {
                                                    soLuongPt = danhGiaVHDAO
                                                            .countByMans(phanCongs.get(i).getNhanSu().getMans());
                                                    if (soLuongPt == 0) {
                                                        danhGiaVH.setNhanSu(phanCongs.get(i).getNhanSu());
                                                        check = false;
                                                        break;
                                                    } else if (soLuongPt < listDanhGia1.size()) {
                                                        listDanhGia2 = danhGiaVHDAO
                                                                .Resultmans(phanCongs.get(i).getNhanSu().getMans());
                                                        listDanhGia1 = listDanhGia2;
                                                    }
                                                }
                                            }
                                            if (check) {
                                                danhGiaVH.setNhanSu(new NhanSu(listDanhGia1.get(0)));
                                            }
                                        }
                                    } catch (Exception e) {
                                        System.out.println("lỗi sau khi đọc file excel:  " + e);
                                    }
                                }
                            }
                            danhGiaVH.setChienDichCD(cdcd);
                            try {
                                session.save(danhGiaVH);
                                int percentComplete = (int) (((double) count / (double) totalRowCount) * 100);
                                jProgressBar1.setString(percentComplete + "%");
                            } catch (Exception e) {
                                System.out.println("Trùng khóa chính" + sinhVien.getMssv());
                                System.out.println("Lỗi 1: " + e);
                            }
                            transaction.commit();
                        }
                        xssfw.close();
                        fileInputStream.close();
                        this.dalImportData.setVisible(false);
                        jProgressBar1.setString("đang lưu");
                        danhGiaVHDAO.setHocKi(maChienDich, hocKi2.getMaHocKi());
                        danhGiaVHDAO.setChienDich(maChienDich, chienDich.getMaChienDich());
//                        danhSachDGVH = danhGiaVHDAO.selectAll();
                        loadDataPhanCong();
                        getChamSocVhCn();
                        fillToTabledaPhanCong();
                        fillToTableChuaPhanCong();
                        getDanhSachIP();
                    } catch (Exception e) {
                        MsgBox.alertcd(this, "Lỗi tại dòng " + count + " cột " + cellNum + "\n" + " Dữ liệu đã được lưu đến dòng " + --count + " bạn vui lòng kiểm tra lại dữ liệu, tách file kể từ dòng " + ++count + " và tiếp tục import.");
                        this.dalImportData.setVisible(false);
                        danhGiaVHDAO.setHocKi(maChienDich, hocKi2.getMaHocKi());
                        danhGiaVHDAO.setChienDich(maChienDich, chienDich.getMaChienDich());
                        loadDataPhanCong();
                        getChamSocVhCn();
                        fillToTabledaPhanCong();
                        fillToTableChuaPhanCong();
                        getDanhSachIP();
                    }

                } finally {
                    session.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi " + e);
        }
    }

    public void importCSEN() {
        int count = 0;
        HocKi hocKi2 = null;
        int cellNum = 0;
        ChienDich chienDich = new ChienDich("CSEN");
        List<PhanCong> phanCongs = new ArrayList<>();
        List<String> listDanhGia1 = new ArrayList<>();
        List<String> listDanhGia2 = new ArrayList<>();
        int soLuongPt = 0;
        // Tao ma chien dich
        String maChienDich = String.valueOf(System.currentTimeMillis());
        ChienDichCD cdcd = new ChienDichCD(maChienDich, txtTenChienDichChuDong.getText(),
                new Timestamp(System.currentTimeMillis()), false, Auth.user);
        String hocKi = "";
        if (cboChonHocKi.getSelectedIndex() != -1) {
            hocKi2 = new HocKi(String.valueOf(cboChonHocKi.getSelectedItem()));
        }
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                try {
                    chienDichCDDAO.insert(cdcd);
                    try {
                        FileInputStream fileInputStream = new FileInputStream(txtLinkFileData.getText());
                        XSSFWorkbook xssfw = new XSSFWorkbook(fileInputStream);
                        XSSFSheet sheet = xssfw.getSheetAt(0);
                        FormulaEvaluator formulaEvaluator = xssfw.getCreationHelper().createFormulaEvaluator();
                        int totalRowCount = sheet.getLastRowNum();
                        for (org.apache.poi.ss.usermodel.Row row : sheet) {
                            Transaction transaction = session.beginTransaction();
                            DanhGiaEN danhGiaVH = new DanhGiaEN();
                            SinhVien sinhVien = new SinhVien();
                            count++;
                            cellNum = 0;
                            for (Cell cell : row) {
                                switch (cellNum) {
                                    case 0:
									try {
                                        sinhVien.setMssv(cell.getStringCellValue());
                                        danhGiaVH.setSinhVien(sinhVien);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        sinhVien.setMssv(String.valueOf(cell.getNumericCellValue()));
                                        danhGiaVH.setSinhVien(sinhVien);
                                    }
                                    break;
                                    case 1:
									try {
                                        danhGiaVH.setMaMon(cell.getStringCellValue());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        danhGiaVH.setMaMon(String.valueOf(cell.getNumericCellValue()));
                                    }
                                    break;
                                }
                                cellNum++;
                            }
                            danhGiaVH.setChienDich(new ChienDich("CSEN"));
                            danhGiaVH.setHocKi(hocKi2);
                            sinhVien = sinhVienDAO.selectByIresultTwo(sinhVien);
                            if (sinhVien == null) {
                                sinhVien = danhGiaVH.getSinhVien();
                                session.save(sinhVien);
                            } else {
                                if (!(sinhVien.getChuyenNganh() == null)) {
                                    danhGiaVH.setMacn(sinhVien.getChuyenNganh());
                                    try {
                                        phanCongs = phanCongDAO.getPhanCong(sinhVien.getChuyenNganh(), "CSEN");
                                        if (phanCongs.size() == 1) {
                                            danhGiaVH.setNhanSu(phanCongs.get(0).getNhanSu());
                                        } else if (phanCongs.size() > 1) {
                                            boolean check = true;
                                            for (int i = 0; i < phanCongs.size(); i++) {
                                                if (i == 0) {
                                                    listDanhGia1 = danhGiaENDAO
                                                            .Resultmans(phanCongs.get(i).getNhanSu().getMans());
                                                    if (listDanhGia1.size() == 0) {
                                                        danhGiaVH.setNhanSu(phanCongs.get(i).getNhanSu());
                                                        check = false;
                                                        break;
                                                    }
                                                } else {
                                                    soLuongPt = danhGiaENDAO
                                                            .countByMans(phanCongs.get(i).getNhanSu().getMans());
                                                    if (soLuongPt == 0) {
                                                        danhGiaVH.setNhanSu(phanCongs.get(i).getNhanSu());
                                                        check = false;
                                                        break;
                                                    } else if (soLuongPt < listDanhGia1.size()) {
                                                        listDanhGia2 = danhGiaENDAO
                                                                .Resultmans(phanCongs.get(i).getNhanSu().getMans());
                                                        listDanhGia1 = listDanhGia2;
                                                    }
                                                }
                                            }
                                            if (check) {
                                                danhGiaVH.setNhanSu(new NhanSu(listDanhGia1.get(0)));
                                            }
                                        }
                                    } catch (Exception e) {
                                        System.out.println("lỗi sau khi đọc file excel:  " + e);
                                    }
                                }
                            }
                            danhGiaVH.setChienDichCD(cdcd);
                            try {
                                session.save(danhGiaVH);
                                int percentComplete = (int) (((double) count / (double) totalRowCount) * 100);
                                jProgressBar1.setString(percentComplete + "%");
                            } catch (Exception e) {
                                System.out.println("Trùng khóa chính" + sinhVien.getMssv());
                                System.out.println("Lỗi 1: " + e);
                            }
                            transaction.commit();
                        }
                        xssfw.close();
                        fileInputStream.close();
                        this.dalImportData.setVisible(false);
                        jProgressBar1.setString("đang lưu");
                        danhGiaENDAO.setHocKi(maChienDich, hocKi2.getMaHocKi());
                        danhGiaENDAO.setChienDich(maChienDich, chienDich.getMaChienDich());
//                        danhSachDGVH = danhGiaVHDAO.selectAll();
                        loadDataPhanCong();
                        getChamSocVhCn();
                        fillToTabledaPhanCong();
                        fillToTableChuaPhanCong();
                        getDanhSachIP();
                    } catch (Exception e) {
                        MsgBox.alertcd(this, "Lỗi tại dòng " + count + " cột " + cellNum + "\n" + " Dữ liệu đã được lưu đến dòng " + --count + " bạn vui lòng kiểm tra lại dữ liệu, tách file kể từ dòng " + ++count + " và tiếp tục import.");
                        this.dalImportData.setVisible(false);
                        danhGiaENDAO.setHocKi(maChienDich, hocKi2.getMaHocKi());
                        danhGiaENDAO.setChienDich(maChienDich, chienDich.getMaChienDich());
                        loadDataPhanCong();
                        getChamSocVhCn();
                        fillToTabledaPhanCong();
                        fillToTableChuaPhanCong();
                        getDanhSachIP();
                    }

                } finally {
                    session.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi " + e);
        }
    }

    // import danh sach sinh vien cham soc hoc phi
    public void importCSHP() {
        int count = 0;
        int cellNum = 0;
        HocKi hocKi2 = null;
        ChienDich chienDich = new ChienDich("CSHP");
        List<PhanCong> phanCongs = new ArrayList<>();
        List<DanhGiaHP> listDanhGiaa = new ArrayList<>();
        List<DanhGiaHP> listDanhGia = new ArrayList<>();
        List<String> listDanhGia1 = new ArrayList<>();
        List<String> listDanhGia2 = new ArrayList<>();
        int soLuongPt = 0;
        // Tao ma chien dich
        String maChienDich = String.valueOf(System.currentTimeMillis());
        ChienDichCD cdcd = new ChienDichCD(maChienDich, txtTenChienDichChuDong.getText(),
                new Timestamp(System.currentTimeMillis()), false, Auth.user);
        // Hoc ki nhan su chon
        if (cboChonHocKi.getSelectedIndex() != -1) {

            hocKi2 = new HocKi(String.valueOf(cboChonHocKi.getSelectedItem()));
        }
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                try {
                    // luu dot cham soc chu dong
                    chienDichCDDAO.insert(cdcd);
                    try {
                        FileInputStream fileInputStream = new FileInputStream(txtLinkFileData.getText());
                        XSSFWorkbook xssfw = new XSSFWorkbook(fileInputStream);
                        XSSFSheet sheet = xssfw.getSheetAt(0);
                        FormulaEvaluator formulaEvaluator = xssfw.getCreationHelper().createFormulaEvaluator();
                        int totalRowCount = sheet.getLastRowNum();
                        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
                        for (org.apache.poi.ss.usermodel.Row row : sheet) {
                            Transaction transaction = session.beginTransaction();
                            DanhGiaHP danhGiaHP = new DanhGiaHP();
                            SinhVien sinhVien = new SinhVien();
                            count++;
                            cellNum = 0;
                            for (Cell cell : row) {

                                switch (cellNum) {
                                    case 0:
									try {
                                        sinhVien.setMssv(cell.getStringCellValue());
                                        danhGiaHP.setSinhVien(sinhVien);
                                    } catch (Exception e) {
                                        sinhVien.setMssv(String.valueOf(cell.getNumericCellValue()));
                                        danhGiaHP.setSinhVien(sinhVien);
                                    }
                                    break;
                                    case 1:
									try {
                                        danhGiaHP.setHocPhi((int) cell.getNumericCellValue());
                                    } catch (Exception e) {
                                        // cần xử lý
                                    }
                                    break;
                                }
                                cellNum++;
                            }
                            sinhVien = sinhVienDAO.selectByIresultTwo(sinhVien);
                            if (sinhVien == null) {
                                sinhVien = danhGiaHP.getSinhVien();
                                session.saveOrUpdate(sinhVien);
                            } else {
                                if (!(sinhVien.getChuyenNganh() == null)) {
                                    danhGiaHP.setMacn(sinhVien.getChuyenNganh());
                                    try {
                                        phanCongs = phanCongDAO.getPhanCong(sinhVien.getChuyenNganh(), "CSHP");
                                        if (phanCongs.size() == 1) {
                                            danhGiaHP.setNhanSu(phanCongs.get(0).getNhanSu());
                                        } else if (phanCongs.size() > 1) {
                                            // Tim nhan su dang cham soc it nhat va phan sinh vien ve nhan su do
                                            boolean check = true;
                                            for (int i = 0; i < phanCongs.size(); i++) {
                                                if (i == 0) {
                                                    listDanhGia1 = danhGiaHPDAO
                                                            .Resultmans(phanCongs.get(i).getNhanSu().getMans());
                                                    if (listDanhGia1.size() == 0) {

                                                        danhGiaHP.setNhanSu(phanCongs.get(i).getNhanSu());
                                                        check = false;
                                                        break;
                                                    }
                                                } else {

                                                    soLuongPt = danhGiaHPDAO
                                                            .countByMans(phanCongs.get(i).getNhanSu().getMans());
                                                    if (soLuongPt == 0) {
                                                        danhGiaHP.setNhanSu(phanCongs.get(i).getNhanSu());
                                                        check = false;
                                                        break;
                                                    } else if (soLuongPt < listDanhGia1.size()) {
//														listDanhGiaa = danhGiaHPDAO
//														.selectByMans(phanCongs.get(i).getNhanSu().getMans());
                                                        listDanhGia2 = danhGiaHPDAO
                                                                .Resultmans(phanCongs.get(i).getNhanSu().getMans());
                                                        listDanhGia1 = listDanhGia2;
                                                    }
                                                }
                                            }
                                            if (check) {
                                                danhGiaHP.setNhanSu(new NhanSu(listDanhGia1.get(0)));
                                            }
                                        }
                                    } catch (Exception e) {
                                        // TODO: handle exception
                                        MsgBox.alert(this, e + "");
                                    }
                                }
                            }
                            // try
                            // set chien dich chu dong cho danhGia
                            danhGiaHP.setChienDichCD(cdcd);
                            try {
                                session.save(danhGiaHP);
                                int percentComplete = (int) (((double) count / (double) totalRowCount) * 100);
                                jProgressBar1.setString(percentComplete + "%");
                            } catch (Exception e) {

                            }
                            transaction.commit();
                        }
                        xssfw.close();
                        fileInputStream.close();
                        session.close();
                        this.dalImportData.setVisible(false);
                        jProgressBar1.setString("đang lưu...");
                        danhGiaHPDAO.setHocKi(maChienDich, hocKi2.getMaHocKi());
                        danhGiaHPDAO.setChienDich(maChienDich, chienDich.getMaChienDich());
                        //danhSachDGHP = danhGiaHPDAO.selectAll();
                        loadDataPhanCong();
                        getChamSocHpCn();
                        fillToTabledaPhanCong();
                        fillToTableChuaPhanCong();
                        getDanhSachIP();
                    } catch (Exception e) {
                        MsgBox.alertcd(this, "Lỗi tại dòng " + count + " cột " + cellNum + "\n" + " Dữ liệu đã được lưu đến dòng " + --count + " bạn vui lòng kiểm tra lại dữ liệu, tách file kể từ dòng " + ++count + " và tiếp tục import.");
                        this.dalImportData.setVisible(false);
                        danhGiaHPDAO.setHocKi(maChienDich, hocKi2.getMaHocKi());
                        danhGiaHPDAO.setChienDich(maChienDich, chienDich.getMaChienDich());
                        loadDataPhanCong();
                        getChamSocHpCn();
                        fillToTabledaPhanCong();
                        fillToTableChuaPhanCong();
                        getDanhSachIP();
                    }

                } finally {
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            MsgBox.alert(null, "KHỞI ĐỘNG LẠI: " + e);
        }
    }

    // import danh sach sinh vien cham soc 1D3 block
    public void importCS1D3() {
        int count = 0;
        int cellNum = 0;
        HocKi hocKi2 = null;
        ChienDich chienDich = new ChienDich("CS1D3");
        List<PhanCong> phanCongs = new ArrayList<>();
        List<DanhGia1D3> listDanhGiaa = new ArrayList<>();
        List<DanhGia1D3> listDanhGia = new ArrayList<>();
        List<String> listDanhGia1 = new ArrayList<>();
        List<String> listDanhGia2 = new ArrayList<>();
        int soLuongPt = 0;
        String maChienDich = String.valueOf(System.currentTimeMillis());
        ChienDichCD cdcd = new ChienDichCD(maChienDich, txtTenChienDichChuDong.getText(),
                new Timestamp(System.currentTimeMillis()), false, Auth.user);
        String hocKi = "";
        if (cboChonHocKi.getSelectedIndex() != -1) {
            hocKi2 = new HocKi(String.valueOf(cboChonHocKi.getSelectedItem()));
        }
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                try {
                    chienDichCDDAO.insert(cdcd);
                    try {
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                        FileInputStream fileInputStream = new FileInputStream(txtLinkFileData.getText());
                        XSSFWorkbook xssfw = new XSSFWorkbook(fileInputStream);
                        XSSFSheet sheet = xssfw.getSheetAt(0);
                        FormulaEvaluator formulaEvaluator = xssfw.getCreationHelper().createFormulaEvaluator();
                        int totalRowCount = sheet.getLastRowNum();

                        for (org.apache.poi.ss.usermodel.Row row : sheet) {
                            Transaction transaction = session.beginTransaction();
                            count++;
                            DanhGia1D3 danhGia1D3 = new DanhGia1D3();
                            SinhVien sinhVien = new SinhVien();
                            cellNum = 0;
                            for (Cell cell : row) {
                                switch (cellNum) {
                                    case 0:							try {
                                        sinhVien.setMssv(cell.getStringCellValue());
                                        danhGia1D3.setSinhVien(sinhVien);
                                    } catch (Exception e) {
                                        sinhVien.setMssv(String.valueOf(cell.getNumericCellValue()));
                                        danhGia1D3.setSinhVien(sinhVien);
                                    }
                                    break;
                                    case 1:
									try {
                                        danhGia1D3.setNganh(cell.getStringCellValue());
                                    } catch (Exception e) {
                                        danhGia1D3.setNganh(String.valueOf(cell.getNumericCellValue()));
                                    }
                                    break;
                                    case 2:
									try {
                                        danhGia1D3.setMaMon(cell.getStringCellValue());
                                    } catch (Exception e) {
                                        danhGia1D3.setMaMon(String.valueOf(cell.getNumericCellValue()));
                                    }
                                    break;
                                    case 3:
									try {
                                        danhGia1D3.setTenMonHoc(cell.getStringCellValue());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                    case 4:
									try {
                                        danhGia1D3.setLop(cell.getStringCellValue());
                                    } catch (Exception e) {
                                        danhGia1D3.setLop(String.valueOf(cell.getNumericCellValue()));
                                    }
                                    break;
                                    case 5:
									try {
                                        danhGia1D3.setBlock(cell.getStringCellValue());
                                    } catch (Exception e) {
                                        danhGia1D3.setBlock(String.valueOf(cell.getNumericCellValue()));
                                    }
                                    break;
                                    case 6:							try {
                                        String cellValue = String.valueOf(cell.getNumericCellValue());
                                        java.util.Date date = cell.getDateCellValue();
                                        danhGia1D3.setNgayBatDauLop(date);
                                    } catch (Exception e) {
                                    }
                                    break;
                                    case 7:
									try {
                                        String cellValue = String.valueOf(cell.getNumericCellValue());
                                        java.util.Date date = cell.getDateCellValue();
                                        danhGia1D3.setNgayKetThucLop(date);
                                    } catch (Exception e) {
                                    }
                                    break;
                                    case 8:							try {
                                        danhGia1D3.setTenGV(cell.getStringCellValue());
                                    } catch (Exception e) {
                                        danhGia1D3.setTenGV(String.valueOf(cell.getNumericCellValue()));
                                    }
                                    break;
                                    case 9:
									try {
                                        danhGia1D3.setTieuChi(cell.getStringCellValue());
                                    } catch (Exception e) {
                                        danhGia1D3.setTieuChi(String.valueOf(cell.getNumericCellValue()));
                                    }
                                    break;
                                    case 10:						try {
                                        danhGia1D3.setNhanXet(cell.getStringCellValue());
                                    } catch (Exception e) {
                                        danhGia1D3.setNhanXet(String.valueOf(cell.getNumericCellValue()));
                                    }
                                    break;
                                    case 11:							try {
                                        String cellValue = String.valueOf(cell.getNumericCellValue());
                                        java.util.Date date = cell.getDateCellValue();
                                        danhGia1D3.setThoiGian(date);
                                    } catch (Exception e) {
                                    }
                                    break;
                                    case 12:							try {
                                        danhGia1D3.setGhiChu(cell.getStringCellValue());
                                    } catch (Exception e) {
                                        danhGia1D3.setGhiChu(String.valueOf(cell.getNumericCellValue()));
                                    }
                                    break;
                                    case 13:						try {
                                        danhGia1D3.setNhanXetChung(cell.getStringCellValue());
                                    } catch (Exception e) {
                                        danhGia1D3.setNhanXetChung(String.valueOf(cell.getNumericCellValue()));
                                    }
                                    break;
                                }
                                cellNum++;
                            }
                            sinhVien = sinhVienDAO.selectById(sinhVien);
                            if (sinhVien == null) {
                                sinhVien = danhGia1D3.getSinhVien();
                                session.saveOrUpdate(sinhVien);
                            } else {
                                if (!(sinhVien.getChuyenNganh() == null)) {
                                    try {
                                        danhGia1D3.setMacn(sinhVien.getChuyenNganh());
                                        phanCongs = phanCongDAO.getPhanCong(sinhVien.getChuyenNganh(), "CS1D3");
                                        if (phanCongs.size() == 1) {
                                            danhGia1D3.setNhanSu(phanCongs.get(0).getNhanSu());
                                        } else if (phanCongs.size() > 1) {
                                            boolean check = true;
                                            for (int i = 0; i < phanCongs.size(); i++) {
                                                if (i == 0) {
                                                    listDanhGia1 = danhGia1D3DAO
                                                            .Resultmans(phanCongs.get(i).getNhanSu().getMans());
                                                    if (listDanhGia1.size() == 0) {

                                                        danhGia1D3.setNhanSu(phanCongs.get(i).getNhanSu());
                                                        check = false;
                                                        break;
                                                    }
                                                } else {
                                                    soLuongPt = danhGia1D3DAO
                                                            .countByMans(phanCongs.get(i).getNhanSu().getMans());
                                                    if (soLuongPt == 0) {
                                                        danhGia1D3.setNhanSu(phanCongs.get(i).getNhanSu());
                                                        check = false;
                                                        break;
                                                    } else if (soLuongPt < listDanhGia1.size()) {
                                                        listDanhGia2 = danhGia1D3DAO
                                                                .Resultmans(phanCongs.get(i).getNhanSu().getMans());
                                                        listDanhGia1 = listDanhGia2;
                                                    }
                                                }
                                            }
                                            if (check) {
                                                danhGia1D3.setNhanSu(new NhanSu(listDanhGia1.get(0)));
                                            }
                                        }
                                    } catch (Exception e) {

                                        System.out.println("lỗi hihi: " + e);
                                    }
                                }
                            }
                            danhGia1D3.setChienDichCD(cdcd);
                            try {
                                session.saveOrUpdate(danhGia1D3);
                                int percentComplete = (int) (((double) count / (double) totalRowCount) * 100);
                                jProgressBar1.setString(percentComplete + "%");
                            } catch (Exception e) {
                                System.out.println(e);
                            }

                            transaction.commit();
                        }
                        xssfw.close();
                        fileInputStream.close();
                        this.dalImportData.setVisible(false);
                        jProgressBar1.setString("đang lưu...");
                        danhGia1D3DAO.setHocKi(maChienDich, hocKi2.getMaHocKi());
                        danhGia1D3DAO.setChienDich(maChienDich, chienDich.getMaChienDich());
                        //  danhSachDG1D3 = danhGia1D3DAO.selectAll();
                        loadDataPhanCong();
                        getChamSoc1D3Cn();
                        fillToTabledaPhanCong();
                        fillToTableChuaPhanCong();
                        getDanhSachIP();
                    } catch (Exception e) {
                        MsgBox.alertcd(this, "Lỗi tại dòng " + count + " cột " + cellNum + "\n" + " Dữ liệu đã được lưu đến dòng " + --count + " bạn vui lòng kiểm tra lại dữ liệu, tách file kể từ dòng " + ++count + " và tiếp tục import.");
                        this.dalImportData.setVisible(false);
                        danhGia1D3DAO.setHocKi(maChienDich, hocKi2.getMaHocKi());
                        danhGia1D3DAO.setChienDich(maChienDich, chienDich.getMaChienDich());
                        loadDataPhanCong();
                        getChamSoc1D3Cn();
                        fillToTabledaPhanCong();
                        fillToTableChuaPhanCong();
                        getDanhSachIP();
                    }

                } finally {
                    session.close();
                }
            }
        } catch (Exception e) {
            MsgBox.alert(null, "KHỞI ĐỘNG LẠI: " + e);
        }

    }

    public void fillToTablesinhVienCanCS() {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        String mans = Auth.user.getMans();
        String chienDich = String.valueOf(cbo_Cs_ChienDich.getSelectedItem());
        if (chienDich.equals("CSVH")) {
            danhSachDGVHCn = danhGiaVHDAO.getChamSocCN(mans);
            fillTableCanChamSocVH();
            fillToDropListCSVh();
        } else if (chienDich.equals("CSHP")) {
            danhSachDGHPCn = danhGiaHPDAO.getChamSocCN(mans);
            fillToDropListCSHP();
        } else if (chienDich.equals("CS1D3")) {
            danhSachDG1D3Cn = danhGia1D3DAO.getChamSocCN(mans);
            fillTableCanChamSoc1D3();
            fillToDropListCSVh();
        } else if (chienDich.equals("CSEN")) {
            danhSachDGENCn = danhGiaENDAO.getChamSocCN(mans);
            fillTableCanChamSocEN();
            fillToDropListCSVh();
        }
        setCursor(Cursor.getDefaultCursor());
    }

    public void fillToFormCSHocPhi(int index) {
        DanhGiaHP danhGia = danhSachDGHPCn.get(index);
        if (danhGia.getTrangThai()) {
            txt_CSSV_TrangThaiHP.setText("Rút học phí");
            txt_CSSV_TrangThaiHP.setBackground(Color.ORANGE);
        } else {
            txt_CSSV_TrangThaiHP.setText(danhGia.isTrangThaiHP() ? "Đã đóng" : "Chưa đóng");
            if (!danhGia.isTrangThaiHP()) {
                txt_CSSV_TrangThaiHP.setBackground(Color.ORANGE);
            } else {
                txt_CSSV_TrangThaiHP.setBackground(Color.GREEN);
            }
        }
        txt_CSSV_TrangThaiBL.setText(danhGia.isTrangThaiBL() ? "Đã bảo lưu" : "Chưa bảo lưu");
        if (!danhGia.isTrangThaiBL()) {
            txt_CSSV_TrangThaiBL.setBackground(Color.ORANGE);
        } else {
            txt_CSSV_TrangThaiBL.setBackground(Color.GREEN);

        }
        txt_CSSV_TrangThaiHP.setOpaque(true);
        txt_CSSV_TrangThaiBL.setOpaque(true);
        txt_CSSV_TrangThaiHP.repaint();
        txt_CSSV_TrangThaiBL.repaint();
        txt_CSSV_HocPhi.setText(currencyFormatter.format(danhGia.getHocPhi()));

    }

    public void fillToDropListCSVh() {
        cboLyDoNghiNhan.removeAllItems();

        for (DropListCT dropListCT : dropListldgnvh) {
            cboLyDoNghiNhan.addItem(dropListCT.getNoiDung());
        }
        cboDoiTuong.removeAllItems();
        for (DropListCT dropListCT : dropListdt) {
            cboDoiTuong.addItem(dropListCT.getNoiDung());
        }
        cboPhanLoaiNguyCo.removeAllItems();
        for (DropListCT dropListCT : dropListplnc) {
            cboPhanLoaiNguyCo.addItem(dropListCT.getNoiDung());
        }
        cboPhanLoaiNguyCo.setSelectedItem("Nguy cơ thấp");
        cboNguyenVongCuaSV.removeAllItems();
        for (DropListCT dropListCT : dropListnvvh) {
            cboNguyenVongCuaSV.addItem(dropListCT.getNoiDung());
        }
    }

    public void fillToDropListCSHP() {
        cboLyDoNghiNhan.removeAllItems();
        for (DropListCT dropListCT : dropListldgnhp) {
            cboLyDoNghiNhan.addItem(dropListCT.getNoiDung());
        }
        cboDoiTuong.removeAllItems();
        for (DropListCT dropListCT : dropListdt) {
            cboDoiTuong.addItem(dropListCT.getNoiDung());
        }
        cboPhanLoaiNguyCo.removeAllItems();
        for (DropListCT dropListCT : dropListplnc) {
            cboPhanLoaiNguyCo.addItem(dropListCT.getNoiDung());
        }
        cboPhanLoaiNguyCo.setSelectedItem("Nguy cơ thấp");
        cboNguyenVongCuaSV.removeAllItems();
        for (DropListCT dropListCT : dropListplnvhp) {
            cboNguyenVongCuaSV.addItem(dropListCT.getNoiDung());
        }
    }

    public void fillToDropListEdit(String macd, String ldgn, String dt, String plnc, String nvsv) {
        if (macd.equals("CSHP")) {
            cbo_edit_ldgn.removeAllItems();
            for (DropListCT dropListCT : dropListldgnhp) {
                cbo_edit_ldgn.addItem(dropListCT.getNoiDung());
            }
            cbo_edit_ldgn.removeItem(ldgn);
            cbo_edit_ldgn.addItem(ldgn);
            cbo_edit_ldgn.setSelectedItem(ldgn);
            cbo_edit_dt.removeAllItems();
            for (DropListCT dropListCT : dropListdt) {
                cbo_edit_dt.addItem(dropListCT.getNoiDung());
            }
            cbo_edit_dt.setSelectedItem(dt);
            cbo_edit_plnc.removeAllItems();
            for (DropListCT dropListCT : dropListplnc) {
                cbo_edit_plnc.addItem(dropListCT.getNoiDung());
            }
            cbo_edit_plnc.setSelectedItem(plnc);
            cbo_edit_nvsv.removeAllItems();
            for (DropListCT dropListCT : dropListplnvhp) {
                cbo_edit_nvsv.addItem(dropListCT.getNoiDung());
            }
            cbo_edit_nvsv.removeItem(nvsv);
            cbo_edit_nvsv.addItem(nvsv);
            cbo_edit_nvsv.setSelectedItem(nvsv);
        } else {
            cbo_edit_ldgn.removeAllItems();
            for (DropListCT dropListCT : dropListldgnvh) {
                cbo_edit_ldgn.addItem(dropListCT.getNoiDung());
            }
            cbo_edit_ldgn.removeItem(ldgn);
            cbo_edit_ldgn.addItem(ldgn);
            cbo_edit_ldgn.setSelectedItem(ldgn);
            cbo_edit_dt.removeAllItems();
            for (DropListCT dropListCT : dropListdt) {
                cbo_edit_dt.addItem(dropListCT.getNoiDung());
            }
            cbo_edit_dt.setSelectedItem(dt);
            cbo_edit_plnc.removeAllItems();
            for (DropListCT dropListCT : dropListplnc) {
                cbo_edit_plnc.addItem(dropListCT.getNoiDung());
            }
            cbo_edit_plnc.setSelectedItem(plnc);
            cbo_edit_nvsv.removeAllItems();
            for (DropListCT dropListCT : dropListnvvh) {
                cbo_edit_nvsv.addItem(dropListCT.getNoiDung());
            }
            cbo_edit_nvsv.removeItem(nvsv);
            cbo_edit_nvsv.addItem(nvsv);
            cbo_edit_nvsv.setSelectedItem(nvsv);
        }
    }
// Nhận một đối tượng chăm sóc do người dùng chọn, tìm kiếm đối tượng chăm sóc này ở những chiến dịch khác và hiển thị lênh table chăm sóc đồng thời

    public void KiemTraCSDTVh(String mssv) {
        if (danhSachDG1D3daPc.size() > 0 || danhSachDG1D3chuaPc.size() > 0) {
            danhGia1D3DT = danhGia1D3DAO.selectByMssv(mssv);
            if (danhGia1D3DT != null) {
                modelSvCanC.addRow(new Object[]{danhGia1D3DT.getChienDich().getMaChienDich(),
                    danhGia1D3DT.getChienDichCD().getThoiGianTao()});
            }
        }
        if (danhSachDGHPdaPc.size() > 0 || danhSachDGHPchuaPc.size() > 0) {
            danhGiaHPDT = danhGiaHPDAO.selectByMssvCSDT(mssv);
            if (danhGiaHPDT != null) {
                modelSvCanC.addRow(new Object[]{danhGiaHPDT.getChienDich().getMaChienDich(),
                    danhGiaHPDT.getChienDichCD().getThoiGianTao()});
            }
        }
        if (danhSachDGENdaPc.size() > 0 || danhSachDGENchuaPc.size() > 0) {
            danhGiaENDT = danhGiaENDAO.selectByMssv(mssv);
            if (danhGiaENDT != null) {
                modelSvCanC.addRow(new Object[]{danhGiaENDT.getChienDich().getMaChienDich(),
                    danhGiaENDT.getChienDichCD().getThoiGianTao()});
            }
        }
    }

    public void KiemTraCSDTEN(String mssv) {
        danhGia1D3DT = danhGia1D3DAO.selectByMssv(mssv);
        if (danhGia1D3DT != null) {
            modelSvCanC.addRow(new Object[]{danhGia1D3DT.getChienDich().getMaChienDich(),
                danhGia1D3DT.getChienDichCD().getThoiGianTao()});
        }
        danhGiaHPDT = danhGiaHPDAO.selectByMssvCSDT(mssv);
        if (danhGiaHPDT != null) {
            modelSvCanC.addRow(new Object[]{danhGiaHPDT.getChienDich().getMaChienDich(),
                danhGiaHPDT.getChienDichCD().getThoiGianTao()});
        }
        danhGiaVHDT = danhGiaVHDAO.selectByMssv(mssv);
        if (danhGiaVHDT != null) {
            modelSvCanC.addRow(new Object[]{danhGiaVHDT.getChienDich().getMaChienDich(),
                danhGiaVHDT.getChienDichCD().getThoiGianTao()});
        }
    }

    public void KiemTraCSDTHp(String mssv) {
        danhGia1D3DT = danhGia1D3DAO.selectByMssv(mssv);
        if (danhGia1D3DT != null) {
            modelSvCanC.addRow(new Object[]{danhGia1D3DT.getChienDich().getMaChienDich(),
                danhGia1D3DT.getChienDichCD().getThoiGianTao()});
        }
        danhGiaVHDT = danhGiaVHDAO.selectByMssv(mssv);
        if (danhGiaVHDT != null) {
            modelSvCanC.addRow(new Object[]{danhGiaVHDT.getChienDich().getMaChienDich(),
                danhGiaVHDT.getChienDichCD().getThoiGianTao()});
        }
        danhGiaENDT = danhGiaENDAO.selectByMssv(mssv);
        if (danhGiaENDT != null) {
            modelSvCanC.addRow(new Object[]{danhGiaENDT.getChienDich().getMaChienDich(),
                danhGiaENDT.getChienDichCD().getThoiGianTao()});
        }
    }

    public void KiemTraCSDT1d3(String mssv) {
        danhGiaVHDT = danhGiaVHDAO.selectByMssv(mssv);
        if (danhGiaVHDT != null) {
            modelSvCanC.addRow(new Object[]{danhGiaVHDT.getChienDich().getMaChienDich(),
                danhGiaVHDT.getChienDichCD().getThoiGianTao()});
        }
        danhGiaHPDT = danhGiaHPDAO.selectByMssvCSDT(mssv);
        if (danhGiaHPDT != null) {
            modelSvCanC.addRow(new Object[]{danhGiaHPDT.getChienDich().getMaChienDich(),
                danhGiaHPDT.getChienDichCD().getThoiGianTao()});
        }
        danhGiaENDT = danhGiaENDAO.selectByMssv(mssv);
        if (danhGiaENDT != null) {
            modelSvCanC.addRow(new Object[]{danhGiaENDT.getChienDich().getMaChienDich(),
                danhGiaENDT.getChienDichCD().getThoiGianTao()});
        }
    }

    public void danhGia() {
        if (txtDienGiaiCT.getText().isEmpty()) {
            MsgBox.alert(this, "Vui lòng không để trống diễn giải chi tiết!");
        } else {
            // Kiem tra loai chien dich
            if (cbo_Cs_ChienDich.getSelectedItem().equals("CSVH")) {
                // Boi vi la chien dich csvh nen se kiem tra ton tai cham soc dong thoi cua cshp va cs1d3
                DanhGiaVH danhGiaVH = danhSachDGVHCn.get(rowTableCS);
                if (modelSvCanC.getRowCount() > 0) {
                    if (chamSocTamThoiHP.isCheck() && chamSocTamThoiHP.isCheckLuu()) {
                        LichSuChamSocHP lichSuChamSocHP = new LichSuChamSocHP(danhGiaHPDT.getChienDichCD(),
                                danhGiaHPDT.getHocKi(), danhGiaHPDT.getChienDich(), Auth.user,
                                sinhVienCS.getMssv(), sinhVienCS.getChuyenNganh(), sinhVienCS.getKiHocHT(),
                                danhGiaHPDT.isTrangThaiHP(), danhGiaHPDT.isTrangThaiBL(), danhGiaHPDT.getTrangThai(),
                                new Timestamp(System.currentTimeMillis()), chamSocTamThoiHP.getLyDoGhiNhan(),
                                chamSocTamThoiHP.getNuyenVongSvPh() == null ? "" : chamSocTamThoiHP.getNuyenVongSvPh(),
                                chamSocTamThoiHP.getDoiTuong(), chamSocTamThoiHP.getPhanLoaiNguyCo(),
                                chamSocTamThoiHP.getDienGiaiCT());
                        if (!(lichSuChamSOCHPDAO.insert(lichSuChamSocHP))) {
                            MsgBox.alert(this, "Lỗi");
                        } else {
                            danhGiaHPDAO.delete(danhGiaHPDT);

                        }
                    }
                    if (chamSocTamThoi1D3.isCheck() && chamSocTamThoi1D3.isCheckLuu()) {
                        LichSuChamSoc1D3 lichSuChamSoc1D3 = new LichSuChamSoc1D3(danhGia1D3DT.getChienDichCD(),
                                danhGia1D3DT.getHocKi(), danhGia1D3DT.getChienDich(), Auth.user,
                                sinhVienCS.getMssv(), danhGia1D3DT.getNganh(), danhGia1D3DT.getMaMon(),
                                sinhVienCS.getChuyenNganh(), danhGia1D3DT.getTenMonHoc(), danhGia1D3DT.getLop(),
                                danhGia1D3DT.getNgayBatDauLop(), danhGia1D3DT.getNgayKetThucLop(), danhGia1D3DT.getTenGV(),
                                danhGia1D3DT.getTieuChi(), danhGia1D3DT.getNhanXet(), danhGia1D3DT.getThoiGian(),
                                danhGia1D3DT.getGhiChu(), danhGia1D3DT.getNhanXetChung(),
                                new Timestamp(System.currentTimeMillis()), chamSocTamThoi1D3.getLyDoGhiNhan(),
                                chamSocTamThoi1D3.getNuyenVongSvPh(), chamSocTamThoi1D3.getDoiTuong(),
                                chamSocTamThoi1D3.getPhanLoaiNguyCo(), chamSocTamThoi1D3.getDienGiaiCT(),
                                danhGia1D3DT.getBlock());
                        if (!(lichSuChamSOC1D3DAO.insert(lichSuChamSoc1D3))) {
                            MsgBox.alert(this, "Lỗi");
                        } else {
                            danhGia1D3DAO.delete(danhGia1D3DT);

                        }
                    }
                    if (chamSocTamThoiEN.isCheck() && chamSocTamThoiEN.isCheckLuu()) {
                        LichSuChamSocEN lichSuChamSocVH = new LichSuChamSocEN(danhGiaENDT.getChienDichCD(),
                                danhGiaENDT.getHocKi(), danhGiaENDT.getChienDich(), Auth.user,
                                sinhVienCS.getMssv(), sinhVienCS.getChuyenNganh(), sinhVienCS.getKiHocHT(),
                                danhGiaENDT.getMaMon(), new Timestamp(System.currentTimeMillis()),
                                chamSocTamThoiEN.getLyDoGhiNhan(), chamSocTamThoiEN.getNuyenVongSvPh(),
                                chamSocTamThoiEN.getDoiTuong(), chamSocTamThoiEN.getPhanLoaiNguyCo(),
                                chamSocTamThoiEN.getDienGiaiCT());
                        if (!(lichSuChamSOCENDAO.insert(lichSuChamSocVH))) {
                            MsgBox.alert(this, "Lỗi");
                        } else {
                            danhGiaVHDAO.delete(danhGiaVHDT);
                        }
                    }
                }
                // Lưu chăm sóc chính
                LichSuChamSocVH lichSuChamSocVH = new LichSuChamSocVH(danhGiaVH.getChienDichCD(), danhGiaVH.getHocKi(),
                        danhGiaVH.getChienDich(), Auth.user, sinhVienCS.getMssv(),
                        sinhVienCS.getChuyenNganh(), sinhVienCS.getKiHocHT(), danhGiaVH.getMaMon(),
                        new Timestamp(System.currentTimeMillis()), String.valueOf(cboLyDoNghiNhan.getSelectedItem()),
                        String.valueOf(cboNguyenVongCuaSV.getSelectedItem() == null ? ""
                                : String.valueOf(cboNguyenVongCuaSV.getSelectedItem())),
                        String.valueOf(cboDoiTuong.getSelectedItem()),
                        String.valueOf(cboPhanLoaiNguyCo.getSelectedItem()), txtDienGiaiCT.getText());
                if (lichSuChamSocVHDAO.insert(lichSuChamSocVH)) {
                    danhGiaVHDAO.delete(danhGiaVH);
                    danhSachDGVHCn.remove(danhGiaVH);

                    try {
                        fillToCS(0);
                        MsgBox.alert(this, "Thành công!");
                    } catch (Exception e) {
                        MsgBox.alert(this, "Đã hoàn thành tất cả!");
                        jlb_CSSV_ChuaCS.setText("0");
                    }
                    fillToTablesinhVienCanCS();
                }
                // chiến dịch 1d3
            } else if (cbo_Cs_ChienDich.getSelectedItem().equals("CS1D3")) {
                DanhGia1D3 danhGia1D3 = danhSachDG1D3Cn.get(rowTableCS);
                sinhVienCS = sinhVienDAO.selectById(danhGia1D3.getSinhVien());
                // Boi vi la chien dich cham soc 1d3 nen se kiem tra cham soc dong thoi cua cshp va 
                if (modelSvCanC.getRowCount() > 0) {
                    if (chamSocTamThoiVh.isCheck() && chamSocTamThoiVh.isCheckLuu()) {
                        LichSuChamSocVH lichSuChamSocVH = new LichSuChamSocVH(danhGiaVHDT.getChienDichCD(),
                                danhGiaVHDT.getHocKi(), danhGiaVHDT.getChienDich(), Auth.user,
                                sinhVienCS.getMssv(), sinhVienCS.getChuyenNganh(), sinhVienCS.getKiHocHT(),
                                danhGiaVHDT.getMaMon(), new Timestamp(System.currentTimeMillis()),
                                chamSocTamThoiVh.getLyDoGhiNhan(), chamSocTamThoiVh.getNuyenVongSvPh(),
                                chamSocTamThoiVh.getDoiTuong(), chamSocTamThoiVh.getPhanLoaiNguyCo(),
                                chamSocTamThoiVh.getDienGiaiCT());
                        if (!(lichSuChamSocVHDAO.insert(lichSuChamSocVH))) {
                            MsgBox.alert(this, "Lỗi");
                        } else {
                            danhGiaVHDAO.delete(danhGiaVHDT);

                        }
                    }
                    if (chamSocTamThoiHP.isCheck() && chamSocTamThoiHP.isCheckLuu()) {
                        LichSuChamSocHP lichSuChamSocHP = new LichSuChamSocHP(danhGiaHPDT.getChienDichCD(),
                                danhGiaHPDT.getHocKi(), danhGiaHPDT.getChienDich(), Auth.user,
                                sinhVienCS.getMssv(), sinhVienCS.getChuyenNganh(), sinhVienCS.getKiHocHT(),
                                danhGiaHPDT.isTrangThaiHP(), danhGiaHPDT.isTrangThaiBL(), danhGiaHPDT.getTrangThai(),
                                new Timestamp(System.currentTimeMillis()), chamSocTamThoiHP.getLyDoGhiNhan(),
                                chamSocTamThoiHP.getNuyenVongSvPh() == null ? "" : chamSocTamThoiHP.getNuyenVongSvPh(),
                                chamSocTamThoiHP.getDoiTuong(), chamSocTamThoiHP.getPhanLoaiNguyCo(),
                                chamSocTamThoiHP.getDienGiaiCT());
                        if (!(lichSuChamSOCHPDAO.insert(lichSuChamSocHP))) {
                            MsgBox.alert(this, "Lỗi");
                        } else {
                            danhGiaHPDAO.delete(danhGiaHPDT);

                        }
                    }
                    if (chamSocTamThoiEN.isCheck() && chamSocTamThoiEN.isCheckLuu()) {
                        LichSuChamSocEN lichSuChamSocVH = new LichSuChamSocEN(danhGiaENDT.getChienDichCD(),
                                danhGiaENDT.getHocKi(), danhGiaENDT.getChienDich(), Auth.user,
                                sinhVienCS.getMssv(), sinhVienCS.getChuyenNganh(), sinhVienCS.getKiHocHT(),
                                danhGiaENDT.getMaMon(), new Timestamp(System.currentTimeMillis()),
                                chamSocTamThoiEN.getLyDoGhiNhan(), chamSocTamThoiEN.getNuyenVongSvPh(),
                                chamSocTamThoiEN.getDoiTuong(), chamSocTamThoiEN.getPhanLoaiNguyCo(),
                                chamSocTamThoiEN.getDienGiaiCT());
                        if (!(lichSuChamSOCENDAO.insert(lichSuChamSocVH))) {
                            MsgBox.alert(this, "Lỗi");
                        } else {
                            danhGiaVHDAO.delete(danhGiaVHDT);

                        }
                    }
                }
                LichSuChamSoc1D3 lichSuChamSoc1D3 = new LichSuChamSoc1D3(danhGia1D3.getChienDichCD(),
                        danhGia1D3.getHocKi(), danhGia1D3.getChienDich(), Auth.user, sinhVienCS.getMssv(),
                        danhGia1D3.getNganh(), danhGia1D3.getMaMon(), sinhVienCS.getChuyenNganh(),
                        danhGia1D3.getTenMonHoc(), danhGia1D3.getLop(), danhGia1D3.getNgayBatDauLop(),
                        danhGia1D3.getNgayKetThucLop(), danhGia1D3.getTenGV(), danhGia1D3.getTieuChi(),
                        danhGia1D3.getNhanXet(), danhGia1D3.getThoiGian(), danhGia1D3.getGhiChu(),
                        danhGia1D3.getNhanXetChung(), new Timestamp(System.currentTimeMillis()),
                        String.valueOf(cboLyDoNghiNhan.getSelectedItem()),
                        String.valueOf(cboNguyenVongCuaSV.getSelectedItem() == null ? ""
                                : String.valueOf(cboNguyenVongCuaSV.getSelectedItem())),
                        String.valueOf(cboDoiTuong.getSelectedItem()),
                        String.valueOf(cboPhanLoaiNguyCo.getSelectedItem()), txtDienGiaiCT.getText(),
                        danhGia1D3.getBlock());
                if (lichSuChamSOC1D3DAO.insert(lichSuChamSoc1D3)) {
                    danhGia1D3DAO.delete(danhGia1D3);
                    danhSachDG1D3Cn.remove(danhGia1D3);
                    try {
                        fillToCS(0);
                        MsgBox.alert(this, "Chăm sóc thành công!");
                    } catch (Exception e) {
                        MsgBox.alert(this, "Đã hoàn thành tất cả!");
                        jlb_CSSV_ChuaCS.setText("0");
                    }
                    fillToTablesinhVienCanCS();
                }
            } else if (cbo_Cs_ChienDich.getSelectedItem().equals("CSHP")) {
                DanhGiaHP danhGiaHP = danhSachDGHPCn.get(rowTableCS);
                sinhVienCS = sinhVienDAO.selectById(danhGiaHP.getSinhVien());
                // Boi vi cham soc hoc phi nen se kiem tra cham soc vang hoc va 1 phan 3 block dong thoi
                if (modelSvCanC.getRowCount() > 0) {
                    if (chamSocTamThoiVh.isCheck() && chamSocTamThoiVh.isCheckLuu()) {
                        LichSuChamSocVH lichSuChamSocVH = new LichSuChamSocVH(danhGiaVHDT.getChienDichCD(),
                                danhGiaVHDT.getHocKi(), danhGiaVHDT.getChienDich(), Auth.user,
                                sinhVienCS.getMssv(), sinhVienCS.getChuyenNganh(), sinhVienCS.getKiHocHT(),
                                danhGiaVHDT.getMaMon(), new Timestamp(System.currentTimeMillis()),
                                chamSocTamThoiVh.getLyDoGhiNhan(), chamSocTamThoiVh.getNuyenVongSvPh(),
                                chamSocTamThoiVh.getDoiTuong(), chamSocTamThoiVh.getPhanLoaiNguyCo(),
                                chamSocTamThoiVh.getDienGiaiCT());
                        if (!(lichSuChamSocVHDAO.insert(lichSuChamSocVH))) {
                            MsgBox.alert(this, "Lỗi");
                        } else {
                            danhGiaVHDAO.delete(danhGiaVHDT);

                        }
                    }

                    if (chamSocTamThoi1D3.isCheck() && chamSocTamThoi1D3.isCheckLuu()) {

                        LichSuChamSoc1D3 lichSuChamSoc1D3 = new LichSuChamSoc1D3(danhGia1D3DT.getChienDichCD(),
                                danhGia1D3DT.getHocKi(), danhGia1D3DT.getChienDich(), Auth.user,
                                sinhVienCS.getMssv(), danhGia1D3DT.getNganh(), danhGia1D3DT.getMaMon(),
                                sinhVienCS.getChuyenNganh(), danhGia1D3DT.getTenMonHoc(), danhGia1D3DT.getLop(),
                                danhGia1D3DT.getNgayBatDauLop(), danhGia1D3DT.getNgayKetThucLop(), danhGia1D3DT.getTenGV(),
                                danhGia1D3DT.getTieuChi(), danhGia1D3DT.getNhanXet(), danhGia1D3DT.getThoiGian(),
                                danhGia1D3DT.getGhiChu(), danhGia1D3DT.getNhanXetChung(),
                                new Timestamp(System.currentTimeMillis()), chamSocTamThoi1D3.getLyDoGhiNhan(),
                                chamSocTamThoi1D3.getNuyenVongSvPh(), chamSocTamThoi1D3.getDoiTuong(),
                                chamSocTamThoi1D3.getPhanLoaiNguyCo(), chamSocTamThoi1D3.getDienGiaiCT(),
                                danhGia1D3DT.getBlock());
                        if (!(lichSuChamSOC1D3DAO.insert(lichSuChamSoc1D3))) {
                            MsgBox.alert(this, "Lỗi");
                        } else {
                            danhGia1D3DAO.delete(danhGia1D3DT);

                        }
                    }
                    if (chamSocTamThoiEN.isCheck() && chamSocTamThoiEN.isCheckLuu()) {
                        LichSuChamSocEN lichSuChamSocVH = new LichSuChamSocEN(danhGiaENDT.getChienDichCD(),
                                danhGiaENDT.getHocKi(), danhGiaENDT.getChienDich(), Auth.user,
                                sinhVienCS.getMssv(), sinhVienCS.getChuyenNganh(), sinhVienCS.getKiHocHT(),
                                danhGiaENDT.getMaMon(), new Timestamp(System.currentTimeMillis()),
                                chamSocTamThoiEN.getLyDoGhiNhan(), chamSocTamThoiEN.getNuyenVongSvPh(),
                                chamSocTamThoiEN.getDoiTuong(), chamSocTamThoiEN.getPhanLoaiNguyCo(),
                                chamSocTamThoiEN.getDienGiaiCT());
                        if (!(lichSuChamSOCENDAO.insert(lichSuChamSocVH))) {
                            MsgBox.alert(this, "Lỗi");
                        } else {
                            danhGiaVHDAO.delete(danhGiaVHDT);

                        }
                    }
                }
                LichSuChamSocHP lichSuChamSocHP = new LichSuChamSocHP(danhGiaHP.getChienDichCD(), danhGiaHP.getHocKi(),
                        danhGiaHP.getChienDich(), Auth.user, sinhVienCS.getMssv(),
                        sinhVienCS.getChuyenNganh(), sinhVienCS.getKiHocHT(), danhGiaHP.isTrangThaiHP(),
                        danhGiaHP.isTrangThaiBL(), danhGiaHP.getTrangThai(), new Timestamp(System.currentTimeMillis()),
                        String.valueOf(cboLyDoNghiNhan.getSelectedItem()),
                        String.valueOf(cboNguyenVongCuaSV.getSelectedItem() == null ? ""
                                : String.valueOf(cboNguyenVongCuaSV.getSelectedItem())),
                        String.valueOf(cboDoiTuong.getSelectedItem()),
                        String.valueOf(cboPhanLoaiNguyCo.getSelectedItem()), txtDienGiaiCT.getText());
                if (lichSuChamSOCHPDAO.insert(lichSuChamSocHP)) {
                    danhGiaHPDAO.delete(danhGiaHP);
                    danhSachDGHPCn.remove(danhGiaHP);
                    try {
                        fillToCS(0);
                        MsgBox.alert(this, "Chăm sóc thành công!");
                    } catch (Exception e) {
                        MsgBox.alert(this, "Đã hoàn thành tất cả!");
                        jlb_CSSV_ChuaCS.setText("0");
                    }
                    fillToTablesinhVienCanCS();
                }
            }
            if (cbo_Cs_ChienDich.getSelectedItem().equals("CSEN")) {
                // Boi vi la chien dich csvh nen se kiem tra ton tai cham soc dong thoi cua cshp va cs1d3
                DanhGiaEN danhGiaVH = danhSachDGENCn.get(rowTableCS);
                if (modelSvCanC.getRowCount() > 0) {
                    if (chamSocTamThoiHP.isCheck() && chamSocTamThoiHP.isCheckLuu()) {
                        LichSuChamSocHP lichSuChamSocHP = new LichSuChamSocHP(danhGiaHPDT.getChienDichCD(),
                                danhGiaHPDT.getHocKi(), danhGiaHPDT.getChienDich(), Auth.user,
                                sinhVienCS.getMssv(), sinhVienCS.getChuyenNganh(), sinhVienCS.getKiHocHT(),
                                danhGiaHPDT.isTrangThaiHP(), danhGiaHPDT.isTrangThaiBL(), danhGiaHPDT.getTrangThai(),
                                new Timestamp(System.currentTimeMillis()), chamSocTamThoiHP.getLyDoGhiNhan(),
                                chamSocTamThoiHP.getNuyenVongSvPh() == null ? "" : chamSocTamThoiHP.getNuyenVongSvPh(),
                                chamSocTamThoiHP.getDoiTuong(), chamSocTamThoiHP.getPhanLoaiNguyCo(),
                                chamSocTamThoiHP.getDienGiaiCT());
                        if (!(lichSuChamSOCHPDAO.insert(lichSuChamSocHP))) {
                            MsgBox.alert(this, "Lỗi");
                        } else {
                            danhGiaHPDAO.delete(danhGiaHPDT);

                        }
                    }
                    if (chamSocTamThoi1D3.isCheck() && chamSocTamThoi1D3.isCheckLuu()) {
                        LichSuChamSoc1D3 lichSuChamSoc1D3 = new LichSuChamSoc1D3(danhGia1D3DT.getChienDichCD(),
                                danhGia1D3DT.getHocKi(), danhGia1D3DT.getChienDich(), Auth.user,
                                sinhVienCS.getMssv(), danhGia1D3DT.getNganh(), danhGia1D3DT.getMaMon(),
                                sinhVienCS.getChuyenNganh(), danhGia1D3DT.getTenMonHoc(), danhGia1D3DT.getLop(),
                                danhGia1D3DT.getNgayBatDauLop(), danhGia1D3DT.getNgayKetThucLop(), danhGia1D3DT.getTenGV(),
                                danhGia1D3DT.getTieuChi(), danhGia1D3DT.getNhanXet(), danhGia1D3DT.getThoiGian(),
                                danhGia1D3DT.getGhiChu(), danhGia1D3DT.getNhanXetChung(),
                                new Timestamp(System.currentTimeMillis()), chamSocTamThoi1D3.getLyDoGhiNhan(),
                                chamSocTamThoi1D3.getNuyenVongSvPh(), chamSocTamThoi1D3.getDoiTuong(),
                                chamSocTamThoi1D3.getPhanLoaiNguyCo(), chamSocTamThoi1D3.getDienGiaiCT(),
                                danhGia1D3DT.getBlock());
                        if (!(lichSuChamSOC1D3DAO.insert(lichSuChamSoc1D3))) {
                            MsgBox.alert(this, "Lỗi");
                        } else {
                            danhGia1D3DAO.delete(danhGia1D3DT);

                        }
                    }
                    if (chamSocTamThoiVh.isCheck() && chamSocTamThoiVh.isCheckLuu()) {
                        LichSuChamSocVH lichSuChamSocVH = new LichSuChamSocVH(danhGiaVHDT.getChienDichCD(),
                                danhGiaVHDT.getHocKi(), danhGiaVHDT.getChienDich(), Auth.user,
                                sinhVienCS.getMssv(), sinhVienCS.getChuyenNganh(), sinhVienCS.getKiHocHT(),
                                danhGiaVHDT.getMaMon(), new Timestamp(System.currentTimeMillis()),
                                chamSocTamThoiVh.getLyDoGhiNhan(), chamSocTamThoiVh.getNuyenVongSvPh(),
                                chamSocTamThoiVh.getDoiTuong(), chamSocTamThoiVh.getPhanLoaiNguyCo(),
                                chamSocTamThoiVh.getDienGiaiCT());
                        if (!(lichSuChamSocVHDAO.insert(lichSuChamSocVH))) {
                            MsgBox.alert(this, "Lỗi");
                        } else {
                            danhGiaVHDAO.delete(danhGiaVHDT);

                        }
                    }
                }
                // Lưu chăm sóc chính
                LichSuChamSocEN lichSuChamSocVH = new LichSuChamSocEN(danhGiaVH.getChienDichCD(), danhGiaVH.getHocKi(),
                        danhGiaVH.getChienDich(), Auth.user, sinhVienCS.getMssv(),
                        sinhVienCS.getChuyenNganh(), sinhVienCS.getKiHocHT(), danhGiaVH.getMaMon(),
                        new Timestamp(System.currentTimeMillis()), String.valueOf(cboLyDoNghiNhan.getSelectedItem()),
                        String.valueOf(cboNguyenVongCuaSV.getSelectedItem() == null ? ""
                                : String.valueOf(cboNguyenVongCuaSV.getSelectedItem())),
                        String.valueOf(cboDoiTuong.getSelectedItem()),
                        String.valueOf(cboPhanLoaiNguyCo.getSelectedItem()), txtDienGiaiCT.getText());
                if (lichSuChamSOCENDAO.insert(lichSuChamSocVH)) {
                    danhGiaENDAO.delete(danhGiaVH);
                    danhSachDGENCn.remove(danhGiaVH);
                    try {
                        fillToCS(0);
                        MsgBox.alert(this, "Thành công!");
                    } catch (Exception e) {
                        MsgBox.alert(this, "Đã hoàn thành tất cả!");
                        jlb_CSSV_ChuaCS.setText("0");
                    }
                    fillToTablesinhVienCanCS();
                }
                // chiến dịch 1d3
            }
        }

    }

    private void filltoTablePCSua() {
        modelNS_PC_CN.setRowCount(0);
        for (PhanCong a : listPhanCongCuaMotNhanSu) {
            Object[] item = {a.getChuyenNganh().getMaChuyenNganh(), a.getChienDich().getMaChienDich()};
            modelNS_PC_CN.addRow(item);
        }
    }

    private void xoaNhanSuPhuTrach() {
        String macn = String.valueOf(tblNsPhuTrachCN.getValueAt(rowTablePC, 0));
        String macd = String.valueOf(tblNsPhuTrachCN.getValueAt(rowTablePC, 1));
        int i = 0;
        for (PhanCong pc : listPhanCongCuaMotNhanSu) {
            if (pc.getNhanSu().getMans().equals(txtMaNS.getText()) && pc.getChienDich().getMaChienDich().equals(macd)
                    && pc.getChuyenNganh().getMaChuyenNganh().equals(macn)) {
                break;

            }
            i++;
        }
        listPhanCongCuaMotNhanSu.remove(i);
        filltoTablePCSua();

    }

    private void fillToTablePhanCong() {
        NhanSu nhanSu = dsns.get(row);
        List<PhanCong> dspc = phanCongDAO.selectAll();
        modelNS_PC_CN.setRowCount(0);
        listPhanCongCuaMotNhanSu.clear();
        for (PhanCong pc : dspc) {
            if (nhanSu.getMans().equals(pc.getNhanSu().getMans())) {
                Object[] item = {pc.getChuyenNganh().getMaChuyenNganh(), pc.getChienDich().getMaChienDich()};
                modelNS_PC_CN.addRow(item);
                listPhanCongCuaMotNhanSu.add(new PhanCong(nhanSu, pc.getChienDich(), pc.getChuyenNganh()));
            }
        }
    }

    public void XoaData() {
        int indexTab = jtp_qlcd_daPC.getSelectedIndex();
        String titleTab = jtp_qlcd_daPC.getTitleAt(indexTab);
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if (titleTab.equalsIgnoreCase("Đã phân công")) {
            if (cbo_qlcd_chienDich.getSelectedItem().equals("CSVH")) {
                List<DanhGiaVH> danhSachCanXoa = new ArrayList<>();
                for (int i = 0; i < danhSachDGVHdaPc.size(); i++) {
                    DanhGiaVH dgvh = danhSachDGVHdaPc.get(i);
                    for (String masv : listMasv) {
                        if (dgvh.getSinhVien().getMssv().equalsIgnoreCase(masv)) {
                            danhSachCanXoa.add(dgvh);
                        }
                    }
                }
                for (DanhGiaVH dgvh : danhSachCanXoa) {
                    danhGiaVHDAO.delete(dgvh);
                    danhSachDGVHdaPc.remove(dgvh);
                }
                tongChuaCSofNS -= danhSachCanXoa.size();
                jlb_qlcd_ChuaCS.setText(tongChuaCSofNS + "");
                jlb_qlcd_tong.setText((tongChuaCSofNS + tongdaCSofNS) + "");

                // hiển thị lại table and thay đổi trong list (xoá đối tượng trong list)
                fillToTabledaPhanCong();
                // hiển thị lại table
                fillToTabledaPhanCong();
            } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSHP")) {
                List<DanhGiaHP> danhSachCanXoa = new ArrayList<>();
                for (int i = 0; i < danhSachDGHPdaPc.size(); i++) {
                    DanhGiaHP dghp = danhSachDGHPdaPc.get(i);
                    for (String masv : listMasv) {
                        if (dghp.getSinhVien().getMssv().equalsIgnoreCase(masv)) {
                            danhSachCanXoa.add(dghp);
                        }
                    }
                }
                for (DanhGiaHP dghp : danhSachCanXoa) {
                    danhGiaHPDAO.delete(dghp);
                    danhSachDGHPdaPc.remove(dghp);
                }
                tongChuaCSofNS -= danhSachCanXoa.size();
                jlb_qlcd_ChuaCS.setText(tongChuaCSofNS + "");
                jlb_qlcd_tong.setText((tongChuaCSofNS + tongdaCSofNS) + "");
                // hiển thị lại table and thay đổi trong list (xoá đối tượng trong list)

                fillToTabledaPhanCong();

            } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CS1D3")) {
                List<DanhGia1D3> danhSachCanXoa = new ArrayList<>();
                for (int i = 0; i < danhSachDG1D3daPc.size(); i++) {
                    DanhGia1D3 dg1d3 = danhSachDG1D3daPc.get(i);
                    for (String masv : listMasv) {
                        if (dg1d3.getSinhVien().getMssv().equalsIgnoreCase(masv)) {
                            danhSachCanXoa.add(dg1d3);
                        }
                    }
                }
                for (DanhGia1D3 dg1d3 : danhSachCanXoa) {
                    danhGia1D3DAO.delete(dg1d3);
                    danhSachDG1D3daPc.remove(dg1d3);
                }
                tongChuaCSofNS -= danhSachCanXoa.size();
                jlb_qlcd_ChuaCS.setText(tongChuaCSofNS + "");
                jlb_qlcd_tong.setText((tongChuaCSofNS + tongdaCSofNS) + "");
                // hiển thị lại table
                fillToTabledaPhanCong();

            }
            if (cbo_qlcd_chienDich.getSelectedItem().equals("CSEN")) {
                List<DanhGiaEN> danhSachCanXoa = new ArrayList<>();
                for (int i = 0; i < danhSachDGENdaPc.size(); i++) {
                    DanhGiaEN dgvh = danhSachDGENdaPc.get(i);
                    for (String masv : listMasv) {
                        if (dgvh.getSinhVien().getMssv().equalsIgnoreCase(masv)) {
                            danhSachCanXoa.add(dgvh);
                        }
                    }
                }
                for (DanhGiaEN dgvh : danhSachCanXoa) {
                    danhGiaENDAO.delete(dgvh);
                    danhSachDGENdaPc.remove(dgvh);
                }
                tongChuaCSofNS -= danhSachCanXoa.size();
                jlb_qlcd_ChuaCS.setText(tongChuaCSofNS + "");
                jlb_qlcd_tong.setText((tongChuaCSofNS + tongdaCSofNS) + "");

                // hiển thị lại table and thay đổi trong list (xoá đối tượng trong list)
                fillToTabledaPhanCong();

                // hiển thị lại table
                fillToTabledaPhanCong();
            }
            MsgBox.alert(this, "Xóa thành công!");

        } else { // xử lý bên table chưa phân công
            if (cbo_qlcd_chienDich.getSelectedItem().equals("CSVH")) {
                List<DanhGiaVH> danhSachCanXoa = new ArrayList<>();
                for (int i = 0; i < danhSachDGVHchuaPc.size(); i++) {
                    DanhGiaVH dgvh = danhSachDGVHchuaPc.get(i);
                    for (String masv : listMasv) {
                        if (dgvh.getSinhVien().getMssv().equalsIgnoreCase(masv)) {
                            danhSachCanXoa.add(dgvh);
                        }
                    }
                }
                for (DanhGiaVH dgvh : danhSachCanXoa) {
                    danhGiaVHDAO.delete(dgvh);
                    danhSachDGVHchuaPc.remove(dgvh);
                }
                tongChuaCS -= danhSachCanXoa.size();
                jlb_qlcd_ChuaCS.setText(tongChuaCS + "");
                jlb_qlcd_tong.setText((tongChuaCS + tongdaCS) + "");

                // hiển thị lại table and thay đổi trong list (xoá đối tượng trong list)
                fillToTableChuaPhanCong();
            } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSHP")) {
                List<DanhGiaHP> danhSachCanXoa = new ArrayList<>();
                for (int i = 0; i < danhSachDGHPchuaPc.size(); i++) {
                    DanhGiaHP dghp = danhSachDGHPchuaPc.get(i);
                    for (String masv : listMasv) {
                        if (dghp.getSinhVien().getMssv().equalsIgnoreCase(masv)) {
                            danhSachCanXoa.add(dghp);
                        }
                    }
                }
                for (DanhGiaHP dghp : danhSachCanXoa) {
                    danhGiaHPDAO.delete(dghp);
                    danhSachDGHPchuaPc.remove(dghp);
                }
                tongChuaCS -= danhSachCanXoa.size();
                jlb_qlcd_ChuaCS.setText(tongChuaCS + "");
                jlb_qlcd_tong.setText((tongChuaCS + tongdaCS) + "");
                // hiển thị lại table and thay đổi trong list (xoá đối tượng trong list)
                fillToTableChuaPhanCong();
            } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CS1D3")) {
                List<DanhGia1D3> danhSachCanXoa = new ArrayList<>();
                for (int i = 0; i < danhSachDG1D3chuaPc.size(); i++) {
                    DanhGia1D3 dg1d3 = danhSachDG1D3chuaPc.get(i);
                    for (String masv : listMasv) {
                        if (dg1d3.getSinhVien().getMssv().equalsIgnoreCase(masv)) {
                            danhSachCanXoa.add(dg1d3);
                        }
                    }
                }
                for (DanhGia1D3 dg1d3 : danhSachCanXoa) {
                    danhGia1D3DAO.delete(dg1d3);
                    danhSachDG1D3chuaPc.remove(dg1d3);
                }
                tongChuaCS -= danhSachCanXoa.size();
                jlb_qlcd_ChuaCS.setText(tongChuaCS + "");
                jlb_qlcd_tong.setText((tongChuaCS + tongdaCS) + "");
                // hiển thị lại table and thay đổi trong list (xoá đối tượng trong list)
                fillToTableChuaPhanCong();
            } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSEN")) {
                List<DanhGiaEN> danhSachCanXoa = new ArrayList<>();
                for (int i = 0; i < danhSachDGENchuaPc.size(); i++) {
                    DanhGiaEN dgvh = danhSachDGENchuaPc.get(i);
                    for (String masv : listMasv) {
                        if (dgvh.getSinhVien().getMssv().equalsIgnoreCase(masv)) {
                            danhSachCanXoa.add(dgvh);
                        }
                    }
                }
                for (DanhGiaEN dgvh : danhSachCanXoa) {
                    danhGiaENDAO.delete(dgvh);
                    danhSachDGENchuaPc.remove(dgvh);
                }
                tongChuaCS -= danhSachCanXoa.size();
                jlb_qlcd_ChuaCS.setText(tongChuaCS + "");
                jlb_qlcd_tong.setText((tongChuaCS + tongdaCS) + "");

                // hiển thị lại table and thay đổi trong list (xoá đối tượng trong list)
                fillToTableChuaPhanCong();
            }
            MsgBox.alert(this, "Xóa thành công!");
            listMasv.clear();

        }
        DialogChuyenSV.setVisible(false);
        setCursor(Cursor.getDefaultCursor());
    }

    private void setProgressBarVisible(boolean visible) {
        jProgressBar1.setIndeterminate(visible);
        jProgressBar1.setStringPainted(visible);
        jProgressBar1.setVisible(visible);
    }

    private void ChuyenPhanCong() {
        int indexTab = jtp_qlcd_daPC.getSelectedIndex();
        String titleTab = jtp_qlcd_daPC.getTitleAt(indexTab);
        if (cbbChuyenDoiPC.getSelectedItem().equals("Lựa chọn nhân sự")) {
            MsgBox.alert(this, "Bạn chưa chọn nhân sự để chuyển");
        } else {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            if (titleTab.equalsIgnoreCase("Đã phân công")) {
                if (cbo_qlcd_chienDich.getSelectedItem().equals("CSVH")) {
                    for (DanhGiaVH dgvh : danhSachDGVHdaPc) { // duyệt qua từng sinh viên CSVH đã có phân công
                        for (String masv : listMasv) {// duyệt qua từng mã sv người dùng đã chọn
                            if (dgvh.getSinhVien().getMssv().equalsIgnoreCase(masv)) {
                                NhanSu ns = new NhanSu();
                                ns.setMans(String.valueOf(cbbChuyenDoiPC.getSelectedItem()));
                                dgvh.setNhanSu(ns); // thay đổi trong list
                                danhGiaVHDAO.insert(dgvh); // thay đổi trong data base
                            }
                        }
                    }
                    // hiển thị lại table

                    jlb_qlcd_ChuaCS.setText((tongChuaCSofNS -= listMasv.size()) + "");
                    jlb_qlcd_tong.setText((tongChuaCSofNS + tongdaCSofNS) + "");
                    for (int i = 0; i < tongs.length; i++) {
                        modelPhanCong.setValueAt(cbbChuyenDoiPC.getSelectedItem(), tongs[i], 4);
                    }
                } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSHP")) {
                    for (DanhGiaHP dghp : danhSachDGHPdaPc) { // duyệt qua từng sinh viên CSHP đã có phân công
                        for (String masv : listMasv) {// duyệt qua từng mã sv người dùng đã chọn
                            if (dghp.getSinhVien().getMssv().equalsIgnoreCase(masv)) {
                                NhanSu ns = new NhanSu();
                                ns.setMans(String.valueOf(cbbChuyenDoiPC.getSelectedItem()));
                                dghp.setNhanSu(ns); // thay đổi trong list
                                danhGiaHPDAO.insert(dghp); // thay đổi trong data base
                            }
                        }
                    }
                    // hiển thị lại table
                    jlb_qlcd_ChuaCS.setText((tongChuaCSofNS -= listMasv.size()) + "");
                    jlb_qlcd_tong.setText((tongChuaCSofNS + tongdaCSofNS) + "");
                    for (int i = 0; i < tongs.length; i++) {
                        modelPhanCong.setValueAt(cbbChuyenDoiPC.getSelectedItem(), tongs[i], 4);
                    }
                } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CS1D3")) {
                    for (DanhGia1D3 dg1d3 : danhSachDG1D3daPc) { // duyệt qua từng sinh viên CS1D3 đã có phân công
                        for (String masv : listMasv) {// duyệt qua từng mã sv người dùng đã chọn
                            if (dg1d3.getSinhVien().getMssv().equalsIgnoreCase(masv)) {
                                NhanSu ns = new NhanSu();
                                ns.setMans(String.valueOf(cbbChuyenDoiPC.getSelectedItem()));
                                dg1d3.setNhanSu(ns); // thay đổi trong list
                                danhGia1D3DAO.insert(dg1d3); // thay đổi trong data base
                            }
                        }
                    }
                    // hiển thị lại table
                    jlb_qlcd_ChuaCS.setText((tongChuaCSofNS -= listMasv.size()) + "");
                    jlb_qlcd_tong.setText((tongChuaCSofNS + tongdaCSofNS) + "");
                    for (int i = 0; i < tongs.length; i++) {
                        modelPhanCong.setValueAt(cbbChuyenDoiPC.getSelectedItem(), tongs[i], 4);
                    }
                } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSEN")) {
                    for (DanhGiaEN dgvh : danhSachDGENdaPc) { // duyệt qua từng sinh viên CSVH đã có phân công
                        for (String masv : listMasv) {// duyệt qua từng mã sv người dùng đã chọn
                            if (dgvh.getSinhVien().getMssv().equalsIgnoreCase(masv)) {
                                NhanSu ns = new NhanSu();
                                ns.setMans(String.valueOf(cbbChuyenDoiPC.getSelectedItem()));
                                dgvh.setNhanSu(ns); // thay đổi trong list
                                danhGiaENDAO.insert(dgvh); // thay đổi trong data base
                            }
                        }
                    }
                    // hiển thị lại table

                    jlb_qlcd_ChuaCS.setText((tongChuaCSofNS -= listMasv.size()) + "");
                    jlb_qlcd_tong.setText((tongChuaCSofNS + tongdaCSofNS) + "");
                    for (int i = 0; i < tongs.length; i++) {
                        modelPhanCong.setValueAt(cbbChuyenDoiPC.getSelectedItem(), tongs[i], 4);
                    }
                }
                MsgBox.alert(this, "Chuyển đổi thành công");

            } else {
// xử lý bên table chưa phân công
                if (cbo_qlcd_chienDich.getSelectedItem().equals("CSVH")) {
                    List<DanhGiaVH> listXoa = new ArrayList<>();
                    for (DanhGiaVH dgvh : danhSachDGVHchuaPc) { // duyệt qua từng sinh viên CSVH chưa có phân công
                        for (String masv : listMasv) {// duyệt qua từng mã sv người dùng đã chọn
                            if (dgvh.getSinhVien().getMssv().equalsIgnoreCase(masv)) {
                                NhanSu ns = new NhanSu();
                                ns.setMans(String.valueOf(cbbChuyenDoiPC.getSelectedItem()));
                                dgvh.setNhanSu(ns);
                                danhSachDGVHdaPc.add(dgvh);
                                listXoa.add(dgvh);
                                danhGiaVHDAO.insert(dgvh); // thay đổi trong data base

                            }
                        }
                    }
                    for (DanhGiaVH danhGiaVH : listXoa) {
                        danhSachDGVHchuaPc.remove(danhGiaVH);
                    }
                    // hiển thị lại table and thay đổi trong list (xoá đối tượng trong list)
                    fillToTableChuaPhanCong();
                } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSHP")) {
                    List<DanhGiaHP> listXoa = new ArrayList<>();
                    for (DanhGiaHP dghp : danhSachDGHPchuaPc) { // duyệt qua từng sinh viên CSHP chưa có phân công
                        for (String masv : listMasv) {// duyệt qua từng mã sv người dùng đã chọn
                            if (dghp.getSinhVien().getMssv().equalsIgnoreCase(masv)) {
                                NhanSu ns = new NhanSu();
                                ns.setMans(String.valueOf(cbbChuyenDoiPC.getSelectedItem()));
                                dghp.setNhanSu(ns);
                                danhSachDGHPdaPc.add(dghp);
                                listXoa.add(dghp);
                                danhGiaHPDAO.insert(dghp); // thay đổi trong data base
                            }
                        }
                    }
                    for (DanhGiaHP danhGiaHP : listXoa) {
                        danhSachDGHPchuaPc.remove(danhGiaHP);
                    }
                    // hiển thị lại table and thay đổi trong list (xoá đối tượng trong list)
                    fillToTableChuaPhanCong();
                } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CS1D3")) {
                    List<DanhGia1D3> listXoa = new ArrayList<>();
                    for (DanhGia1D3 dghp : danhSachDG1D3chuaPc) { // duyệt qua từng sinh viên CSHP chưa có phân công
                        for (String masv : listMasv) {// duyệt qua từng mã sv người dùng đã chọn
                            if (dghp.getSinhVien().getMssv().equalsIgnoreCase(masv)) {
                                NhanSu ns = new NhanSu();
                                ns.setMans(String.valueOf(cbbChuyenDoiPC.getSelectedItem()));
                                dghp.setNhanSu(ns);
                                danhSachDG1D3daPc.add(dghp);
                                listXoa.add(dghp);
                                danhGia1D3DAO.insert(dghp); // thay đổi trong data base
                            }
                        }
                    }
                    for (DanhGia1D3 danhGia1D3 : listXoa) {
                        danhSachDG1D3chuaPc.remove(danhGia1D3);
                    }
                    // hiển thị lại table and thay đổi trong list (xoá đối tượng trong list)
                    fillToTableChuaPhanCong();
                } else if (cbo_qlcd_chienDich.getSelectedItem().equals("CSEN")) {
                    List<DanhGiaEN> listXoa = new ArrayList<>();
                    for (DanhGiaEN dgvh : danhSachDGENchuaPc) { // duyệt qua từng sinh viên CSVH chưa có phân công
                        for (String masv : listMasv) {// duyệt qua từng mã sv người dùng đã chọn
                            if (dgvh.getSinhVien().getMssv().equalsIgnoreCase(masv)) {
                                NhanSu ns = new NhanSu();
                                ns.setMans(String.valueOf(cbbChuyenDoiPC.getSelectedItem()));
                                dgvh.setNhanSu(ns);
                                danhSachDGENdaPc.add(dgvh);
                                listXoa.add(dgvh);
                                danhGiaENDAO.insert(dgvh); // thay đổi trong data base
                            }
                        }
                    }
                    // hiển thị lại table and thay đổi trong list (xoá đối tượng trong list)
                    for (DanhGiaEN danhGiaEN : listXoa) {
                        danhSachDGENchuaPc.remove(danhGiaEN);
                    }
                    fillToTableChuaPhanCong();
                }
                MsgBox.alert(this, "Chuyển đổi thành công");
            }
            DialogChuyenSV.setVisible(false);
        }
        setCursor(Cursor.getDefaultCursor());
    }

    public void setIcon() {
        URL iconClass = HomeFarm.class.getResource("/Icons/AppIcon.png");
        Image img1 = Toolkit.getDefaultToolkit().createImage(iconClass);
        this.setIconImage(img1);
        jdlImportSV.setIconImage(img1);
        dalImportData.setIconImage(img1);
        dalTaoHocKi.setIconImage(img1);
        jdlChamSocDongThoi.setIconImage(img1);
        jdlImportHP_BL.setIconImage(img1);
        jdlQuanLyNhanSu.setIconImage(img1);
        jdlThongTinCaNhan.setIconImage(img1);
        DialogChuyenSV.setIconImage(img1);
        DialogExportCSVH.setIconImage(img1);
        DialogPhanCong.setIconImage(img1);
        jdl_editLSCS.setIconImage(img1);
        jdl_ThemDG.setIconImage(img1);
        jdl_quanLyDl.setIconImage(img1);
    }
//new Color(0xb2d8b2)

    private void lamMoiFormTieuChi() {
        jlb_maLoaiDl.setText("");
        txt_noiDungDl.setText("");
    }

    public class RenderTablaPrestamos extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            c.setBackground(row % 2 == 0 ? Color.decode("#F0F0F0") : Color.WHITE);
            return c;
        }
    }

    public void fillToCS(int index) {
        lamMoiFormCS();
        if (cbo_Cs_ChienDich.getSelectedItem().equals("CSVH")) {
            getLichchuCSofSV(fillToFormVH(index));
            chamSocTamThoi1D3 = new ChamSocTamThoi();
            chamSocTamThoiHP = new ChamSocTamThoi();
            chamSocTamThoiEN = new ChamSocTamThoi();
        } else if (cbo_Cs_ChienDich.getSelectedItem().equals("CS1D3")) {
            getLichchuCSofSV(fillToForm1D3(index));
            chamSocTamThoiHP = new ChamSocTamThoi();
            chamSocTamThoiVh = new ChamSocTamThoi();
            chamSocTamThoiEN = new ChamSocTamThoi();
        } else if (cbo_Cs_ChienDich.getSelectedItem().equals("CSHP")) {
            getLichchuCSofSV(fillToFormHP(index));
            fillToFormCSHocPhi(index);
            chamSocTamThoiVh = new ChamSocTamThoi();
            chamSocTamThoi1D3 = new ChamSocTamThoi();
            chamSocTamThoiEN = new ChamSocTamThoi();
        } else if (cbo_Cs_ChienDich.getSelectedItem().equals("CSEN")) {
            getLichchuCSofSV(fillToFormEN(index));
            chamSocTamThoi1D3 = new ChamSocTamThoi();
            chamSocTamThoiHP = new ChamSocTamThoi();
            chamSocTamThoiVh = new ChamSocTamThoi();
        }

    }

    public void fillToComBoBox() {
        fillToCboHK(cbo_home_HocKy);
        fillToCboNS(cbo_Home_NhanSu);
        fillToCboHK(cbo_qLcd_hocKi);
        fillToCboNS(cbo_qlcd_NhanSu);
        fillToCboCN(cbo_qlcd_chuyenNganh);
        fillToCboCD(cbo_qlcd_chienDich);
    }

    // Làm mới form chăm sóc ở giao diện chăm sóc sinh viên khi chọn chiến dịch mới,
    // sinh viên mới và chăm sóc xong sinh viên
    public void lamMoiFormCS() {
        txt_CSSV_ChuyenNganh.setText("");
        txt_CSSV_HoTen.setText("");
        txtCSSV_MSSV.setText("");
        txt_CSSV_HocPhi.setText("");
        txt_CSSV_KiHoc.setText("");
        txt_CSSV_NX.setText("");
        txt_CSSV_TrangThai.setText("");
        txt_CSSV_TrangThaiBL.setText("");
        txt_CSSV_TrangThaiHP.setText("");
        txtDienGiaiCT.setText("");
        jlb_cs_monHoc.setText("");
        modelSvCanC.setRowCount(0);
        modelLichSuCSCN.setRowCount(0);
        modelCSDT.setRowCount(0);
        chamSocTamThoi1D3 = null;
        chamSocTamThoiHP = null;
        chamSocTamThoiVh = null;
    }

    public String getValueAt(JTable j) {
        int row = j.getSelectedRow();
        int col = j.getSelectedColumn();
        return String.valueOf(j.getValueAt(row, col));
    }

    public void fillToComBoxCSDT(String macd) {
        if (macd.equals("CSHP")) {
            for (DropListCT dropListCT : dropListldgnhp) {
                cbo_jdl_csdt_ldgn.addItem(dropListCT.getNoiDung());
            }
            for (DropListCT dropListCT : dropListplnvhp) {
                cbo_jdl_csdt_nvsv.addItem(dropListCT.getNoiDung());
            }
        } else {
            for (DropListCT dropListCT : dropListldgnvh) {
                cbo_jdl_csdt_ldgn.addItem(dropListCT.getNoiDung());
            }
            for (DropListCT dropListCT : dropListnvvh) {
                cbo_jdl_csdt_nvsv.addItem(dropListCT.getNoiDung());
            }
        }
        for (DropListCT dropListCT : dropListdt) {
            cbo_jdl_csdt_dt.addItem(dropListCT.getNoiDung());
        }
        for (DropListCT dropListCT : dropListplnc) {
            cbo_jdl_csdt_plnc.addItem(dropListCT.getNoiDung());
        }

    }

    private void hienThiForm() {
        String tenChienDich = String.valueOf(cbo_Home_ChienDich.getSelectedItem());
        jPanelListChk.setLayout(new BoxLayout(jPanelListChk, BoxLayout.Y_AXIS));
        jPanelListChk.setPreferredSize(new Dimension(283, 700));
        DialogExportCSVH.setPreferredSize(new Dimension(435, 600));
        jPanelListChk.removeAll();
        if (tenChienDich.equals("CSVH") || tenChienDich.equals("CSEN")) {
            JCheckBox[] checkBoxes = new JCheckBox[13];
            taoCheckBoxVhAndHp(checkBoxes);
            SelectAll();
            jPanelListChk.revalidate();
            jPanelListChk.repaint();
            DialogExportCSVH.pack();
            DialogExportCSVH.setLocationRelativeTo(this);
            DialogExportCSVH.setVisible(true);
        } else if (tenChienDich.equals("CSHP")) {
            JCheckBox[] checkBoxes = new JCheckBox[13];
            taoCheckBoxHp(checkBoxes);
            SelectAll();
            jPanelListChk.revalidate();
            jPanelListChk.repaint();
            DialogExportCSVH.pack();
            DialogExportCSVH.setLocationRelativeTo(this);
            DialogExportCSVH.setVisible(true);
        } else if (tenChienDich.equals("CS1D3")) {
            JCheckBox[] checkBoxes = new JCheckBox[23];
            taoCheckBox13(checkBoxes);
            SelectAll();
            jPanelListChk.revalidate();
            jPanelListChk.repaint();
            DialogExportCSVH.pack();
            DialogExportCSVH.setLocationRelativeTo(this);
            DialogExportCSVH.setVisible(true);
        } else {
            MsgBox.alert(this, "Bạn chưa chọn loại chiến dịch để export");
        }
    }

    private boolean checkip1d3() {
        try {
            FileInputStream fileInputStream;
            fileInputStream = new FileInputStream(txtLinkFileData.getText());
            XSSFWorkbook xssfw = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = xssfw.getSheetAt(0);
            FormulaEvaluator formulaEvaluator = xssfw.getCreationHelper().createFormulaEvaluator();

            int numberOfColumns = sheet.getRow(0).getLastCellNum();
            if (numberOfColumns > 2) {
                return true;
            } else {
                jlb_enroll_import.setText("Vui lòng import file đúng định dạng");
                return false;
            }
        } catch (Exception e) {
            if (e instanceof java.io.FileNotFoundException) {
                jlb_enroll_import.setText("Không tìm thấy file. Vui lòng kiểm tra lại đường dẫn.");
            } else {
            }
            return false;
        }
    }

    public void fillToTableDl() {
        jlb_maLoaiDl.setText("");
        txt_noiDungDl.setText("");
        String tieuChi = String.valueOf(cbo_TieuChi.getSelectedItem());
        modelDropList.setRowCount(0);
        int count = 1;
        switch (tieuChi) {
            case "Lý do ghi nhận":
                cbo_ChienDichDL.setEnabled(true);
                jlb_maLoaiDl.setText("DRLDGN");
                if (cbo_ChienDichDL.getSelectedItem().equals("CSHP")) {
                    for (DropListCT dropListCT : dropListldgnhp) {
                        modelDropList.addRow(new Object[]{count, dropListCT.getDropList().getMaLoaiDl(), dropListCT.getNoiDung()});
                        count++;
                    }
                } else {
                    for (DropListCT dropListCT : dropListldgnvh) {
                        modelDropList.addRow(new Object[]{count, dropListCT.getDropList().getMaLoaiDl(), dropListCT.getNoiDung()});
                        count++;
                    }
                }
                break;
            case "Nguyện vọng":
                cbo_ChienDichDL.setEnabled(true);
                jlb_maLoaiDl.setText("DRNVSV");
                if (cbo_ChienDichDL.getSelectedItem().equals("CSHP")) {
                    for (DropListCT dropListCT : dropListplnvhp) {
                        modelDropList.addRow(new Object[]{count, dropListCT.getDropList().getMaLoaiDl(), dropListCT.getNoiDung()});
                        count++;
                    }
                } else {
                    for (DropListCT dropListCT : dropListnvvh) {
                        modelDropList.addRow(new Object[]{count, dropListCT.getDropList().getMaLoaiDl(), dropListCT.getNoiDung()});
                        count++;
                    }
                }
                break;
            case "Phân loại nguy cơ":
                cbo_ChienDichDL.setEnabled(false);
                cbo_ChienDichDL.setSelectedItem("CSVH");
                jlb_maLoaiDl.setText("DRPLNC");
                for (DropListCT dropListCT : dropListplnc) {
                    modelDropList.addRow(new Object[]{count, dropListCT.getDropList().getMaLoaiDl(), dropListCT.getNoiDung()});
                    count++;
                }
                break;
            case "Đối tượng":
                cbo_ChienDichDL.setEnabled(false);
                cbo_ChienDichDL.setSelectedItem("CSVH");
                jlb_maLoaiDl.setText("DRDT");
                for (DropListCT dropListCT : dropListdt) {
                    modelDropList.addRow(new Object[]{count, dropListCT.getDropList().getMaLoaiDl(), dropListCT.getNoiDung()});
                    count++;
                }
                break;

        }
    }

    private boolean checkiphp() {
        try {
            FileInputStream fileInputStream;
            fileInputStream = new FileInputStream(txtLinkFileData.getText());
            XSSFWorkbook xssfw = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = xssfw.getSheetAt(0);
            FormulaEvaluator formulaEvaluator = xssfw.getCreationHelper().createFormulaEvaluator();

            int numberOfColumns = sheet.getRow(0).getLastCellNum();
            if (numberOfColumns > 2) {
                jlb_enroll_import.setText("Chiến dịch học phí không thể tải file 1 / 3 Block");
                return false;
            }
            int dem = 0;
            for (org.apache.poi.ss.usermodel.Row row : sheet) {
                // Transaction transaction = session.beginTransaction();
                double hocphi = 0;
                int cellNum = 0;
                for (Cell cell : row) {
                    switch (cellNum) {
                        case 1:				try {
                            hocphi = cell.getNumericCellValue();
                            return true;
                        } catch (Exception e) {
                            jlb_enroll_import.setText("Chiến dịch học phí không thể tải file vắng học hoặc tiếng Anh");
                            return false;
                        }
                    }
                    cellNum++;
                }
                dem++;
                if (dem == 1) {
                    break;
                }
            }
        } catch (Exception e) {

            if (e instanceof java.io.FileNotFoundException) {
                jlb_enroll_import.setText("Không tìm thấy file. Vui lòng kiểm tra lại đường dẫn.");
            } else {

            }
            return false;
        }
        return false;
    }

    private boolean checkipvh() {
        try {
            FileInputStream fileInputStream;
            fileInputStream = new FileInputStream(txtLinkFileData.getText());
            XSSFWorkbook xssfw = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = xssfw.getSheetAt(0);
            FormulaEvaluator formulaEvaluator = xssfw.getCreationHelper().createFormulaEvaluator();

            int numberOfColumns = sheet.getRow(0).getLastCellNum();
            if (numberOfColumns > 2) {

                jlb_enroll_import.setText("Chiến dịch vắng học không thể tải file 1 / 3 Block");
                return false;
            }
            int dem = 0;
            for (org.apache.poi.ss.usermodel.Row row : sheet) {
                // Transaction transaction = session.beginTransaction();
                String maMon = "";
                int cellNum = 0;
                for (Cell cell : row) {
                    switch (cellNum) {
                        case 1:				try {
                            maMon = cell.getStringCellValue();
                            maMon = maMon.substring(0, 3);
                            if (maMon.equals("ENT")) {
                                jlb_enroll_import.setText("Chiến dịch vắng học không thể tải file vắng học tiếng Anh");
                                return false;
                            } else {
                                return true;
                            }
                        } catch (Exception e) {
                            jlb_enroll_import.setText("Chiến dịch vắng học không thể tải file học phí");
                            return false;
                        }
                    }
                    cellNum++;
                }
                dem++;
                if (dem == 1) {
                    break;
                }
            }
        } catch (Exception e) {

            if (e instanceof java.io.FileNotFoundException) {
                jlb_enroll_import.setText("Không tìm thấy file. Vui lòng kiểm tra lại đường dẫn.");
            } else {

            }
            return false;
        }
        return false;
    }

    private boolean checkipen() {
        try {
            FileInputStream fileInputStream;
            fileInputStream = new FileInputStream(txtLinkFileData.getText());
            XSSFWorkbook xssfw = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = xssfw.getSheetAt(0);
            FormulaEvaluator formulaEvaluator = xssfw.getCreationHelper().createFormulaEvaluator();

            int numberOfColumns = sheet.getRow(0).getLastCellNum();
            if (numberOfColumns > 2) {

                jlb_enroll_import.setText("Chiến dịch vắng học không thể tải file 1 / 3 Block");
                return false;
            }
            int dem = 0;
            for (org.apache.poi.ss.usermodel.Row row : sheet) {
                // Transaction transaction = session.beginTransaction();
                String maMon = "";
                int cellNum = 0;
                for (Cell cell : row) {
                    switch (cellNum) {
                        case 1:				try {
                            maMon = cell.getStringCellValue();
                            maMon = maMon.substring(0, 3);
                            if (maMon.equals("ENT")) {
                                return true;
                            } else {
                                jlb_enroll_import.setText("Chiến dịch tiếng Anh không thể tải file vắng học ");
                                return false;
                            }
                        } catch (Exception e) {
                            jlb_enroll_import.setText("Chiến dịch vắng học không thể tải file học phí");
                            return false;
                        }
                    }
                    cellNum++;
                }
                dem++;
                if (dem == 1) {
                    break;
                }
            }
        } catch (Exception e) {

            if (e instanceof java.io.FileNotFoundException) {
                jlb_enroll_import.setText("Không tìm thấy file. Vui lòng kiểm tra lại đường dẫn.");
            } else {

            }
            return false;
        }
        return false;
    }

    private void taoCheckBoxVhAndHp(JCheckBox[] checkBoxes) {
        checkBoxes[0] = new JCheckBox("Học kỳ");
        checkBoxes[1] = new JCheckBox("Tên chiến dịch");
        checkBoxes[2] = new JCheckBox("MSSV");
        checkBoxes[3] = new JCheckBox("Chuyên Ngành");
        checkBoxes[4] = new JCheckBox("Kỳ học");
        checkBoxes[5] = new JCheckBox("Mã môn");
        checkBoxes[6] = new JCheckBox("Người chăm sóc");
        checkBoxes[7] = new JCheckBox("Thời gian chăm sóc");
        checkBoxes[8] = new JCheckBox("Lý do ghi nhận");
        checkBoxes[9] = new JCheckBox("Nguyện vọng của SV/PH");
        checkBoxes[10] = new JCheckBox("Đối tượng");
        checkBoxes[11] = new JCheckBox("Phân loại nguy cơ");
        checkBoxes[12] = new JCheckBox("Diễn giải chi tiết");
        for (JCheckBox checkBox : checkBoxes) {
            jPanelListChk.add(checkBox);

        }
    }

    private void taoCheckBoxVhAndEN(JCheckBox[] checkBoxes) {
        checkBoxes[0] = new JCheckBox("Học kỳ");
        checkBoxes[1] = new JCheckBox("Tên chiến dịch");
        checkBoxes[2] = new JCheckBox("MSSV");
        checkBoxes[3] = new JCheckBox("Chuyên Ngành");
        checkBoxes[4] = new JCheckBox("Kỳ học");
        checkBoxes[5] = new JCheckBox("Mã môn");
        checkBoxes[6] = new JCheckBox("Người chăm sóc");
        checkBoxes[7] = new JCheckBox("Thời gian chăm sóc");
        checkBoxes[8] = new JCheckBox("Lý do ghi nhận");
        checkBoxes[9] = new JCheckBox("Nguyện vọng của SV/PH");
        checkBoxes[10] = new JCheckBox("Đối tượng");
        checkBoxes[11] = new JCheckBox("Phân loại nguy cơ");
        checkBoxes[12] = new JCheckBox("Diễn giải chi tiết");
        for (JCheckBox checkBox : checkBoxes) {
            jPanelListChk.add(checkBox);

        }
    }

    private void taoCheckBoxHp(JCheckBox[] checkBoxes) {
        checkBoxes[0] = new JCheckBox("Học kỳ");
        checkBoxes[1] = new JCheckBox("Tên chiến dịch");
        checkBoxes[2] = new JCheckBox("MSSV");
        checkBoxes[3] = new JCheckBox("Chuyên Ngành");
        checkBoxes[4] = new JCheckBox("Kỳ học");
        checkBoxes[5] = new JCheckBox("Trạng thái");
        checkBoxes[6] = new JCheckBox("Người chăm sóc");
        checkBoxes[7] = new JCheckBox("Thời gian chăm sóc");
        checkBoxes[8] = new JCheckBox("Lý do ghi nhận");
        checkBoxes[9] = new JCheckBox("Nguyện vọng của SV/PH");
        checkBoxes[10] = new JCheckBox("Đối tượng");
        checkBoxes[11] = new JCheckBox("Phân loại nguy cơ");
        checkBoxes[12] = new JCheckBox("Diễn giải chi tiết");
        for (JCheckBox checkBox : checkBoxes) {
            jPanelListChk.add(checkBox);

        }
    }

    private void taoCheckBox13(JCheckBox[] checkBoxes) {
        checkBoxes[0] = new JCheckBox("Học kỳ");
        checkBoxes[1] = new JCheckBox("Tên chiến dịch");
        checkBoxes[2] = new JCheckBox("MSSV");
        checkBoxes[3] = new JCheckBox("Ngành");
        checkBoxes[4] = new JCheckBox("Chuyên ngành");
        checkBoxes[5] = new JCheckBox("Mã môn học");
        checkBoxes[6] = new JCheckBox("Tên môn học");
        checkBoxes[7] = new JCheckBox("Lớp");
        checkBoxes[8] = new JCheckBox("Block");
        checkBoxes[9] = new JCheckBox("Ngày bắt đầu lớp");
        checkBoxes[10] = new JCheckBox("Ngày kết thúc lớp ");
        checkBoxes[11] = new JCheckBox("Tên GV");
        checkBoxes[12] = new JCheckBox("Tiêu chí");
        checkBoxes[13] = new JCheckBox("Nhận xét");
        checkBoxes[14] = new JCheckBox("Thời gian");
        checkBoxes[15] = new JCheckBox("Ghi chú");
        checkBoxes[16] = new JCheckBox("Nhận xét chung");
        checkBoxes[17] = new JCheckBox("Người chăm sóc");
        checkBoxes[18] = new JCheckBox("Thời gian chăm sóc");
        checkBoxes[19] = new JCheckBox("Lý do ghi nhận");
        checkBoxes[20] = new JCheckBox("Nguyện vọng của SV/PH");
        checkBoxes[21] = new JCheckBox("Đối tượng");
        checkBoxes[22] = new JCheckBox("Phân loại nguy cơ");
        for (JCheckBox checkBox : checkBoxes) {
            jPanelListChk.add(checkBox);
        }
    }

    private void SelectAll() {
        Component[] components = jPanelListChk.getComponents();
        for (Component component : components) {
            if (component instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) component;
                checkBox.setSelected(true);
            }
        }

    }

    private void DeSelectAll() {
        Component[] components = jPanelListChk.getComponents();
        for (Component component : components) {
            if (component instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) component;
                checkBox.setSelected(false);
            }
        }
    }

    private void ExportFileExcel() {
        try {
//          String desktopPath = System.getProperty("user.home") + "/Desktop";
//       final String duongDan = desktopPath + "/" + System.currentTimeMillis();
// String desktopPath = System.getProperty("user.home") + "/Desktop";
        
        // Tạo đối tượng LocalDate đại diện cho ngày hiện tại
     //   LocalDate currentDate = LocalDate.now();
        
        // Định dạng ngày tháng
     //   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        
        // Chuyển đổi LocalDate thành chuỗi ngày tháng
//        String dateStr = currentDate.format(formatter);
        
        //final  String duongDan = desktopPath + "/KQCS_" + dateStr;
        	final  String duongDan = TienIch.ChonFile();
            if (!(duongDan == null)) {
                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String tenCD = (String) cbo_Home_ChienDich.getSelectedItem();
                        // lấy các cột người dùng chọn muốn export
                        List<String> tenCot = new ArrayList<>();
                        Component[] components = jPanelListChk.getComponents();
                        for (Component component : components) {
                            if (component instanceof JCheckBox) {
                                JCheckBox checkBox = (JCheckBox) component;
                                if (checkBox.isSelected()) {
                                    tenCot.add(checkBox.getText());
                                }
                            }
                        }
                        // Hiển thị ProgressBar
                        setProgressBarVisible(true);
                        if (tenCD.equalsIgnoreCase("CSVH")) {
                            DialogExportCSVH.setVisible(false);
                            jProgressBar1.setString("Đang xuất...");
                            ExportToExcel.exportVH(tenCD, lichSuChamSocVHALL, tenCot, duongDan);
                            jProgressBar1.setString("Hoàn tất");
                            setProgressBarVisible(false);
                        } else if (tenCD.equalsIgnoreCase("CSHP")) {
                            DialogExportCSVH.setVisible(false);
                            jProgressBar1.setString("Đang xuất...");
                            ExportToExcel.exportHP(tenCD, lichSuChamSocHPALL, tenCot, duongDan);
                            jProgressBar1.setString("Hoàn tất");
                            setProgressBarVisible(false);
                        } else if (tenCD.equalsIgnoreCase("CS1D3")) {
                            DialogExportCSVH.setVisible(false);
                            jProgressBar1.setString("Đang xuất...");
                            ExportToExcel.export1D3(tenCD, lichSuChamSoc1DALL, tenCot, duongDan);
                            jProgressBar1.setString("Hoàn tất");
                            setProgressBarVisible(false);
                        } else if (tenCD.equalsIgnoreCase("CSEN")) {
                            DialogExportCSVH.setVisible(false);
                            jProgressBar1.setString("Đang xuất...");
                            ExportToExcel.exportEN(tenCD, lichSuChamSocENALL, tenCot, duongDan);
                            jProgressBar1.setString("Hoàn tất");
                            setProgressBarVisible(false);
                        }
                    }
                }).start();
                setCursor(Cursor.getDefaultCursor());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        setProgressBarVisible(false);
    }

    public void FilloTableDSNSON() {
        try {
            dsns = nhanSuDAO.selectNsON();
            modelDSNS.setRowCount(0);
            for (NhanSu ns : dsns) {
                Object[] row = {ns.getMans(), ns.getHoVaten(), ns.getTrangThai()};
                modelDSNS.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public class MyListRenderer extends DefaultListCellRenderer {

        private static final long serialVersionUID = 1L;
        private final Border separator = BorderFactory.createMatteBorder(1, 0, 0, 0, Color.GRAY);

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (index > 0) {
                label.setBorder(separator);
            }
            return label;
        }
    }
}
