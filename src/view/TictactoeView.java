package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.TictactoeController;
import model.TictactoeModel;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

import javax.swing.JTextArea;

public class TictactoeView extends JFrame {
	public TictactoeModel model;
	
	private static Clip clip;
	private static Clip clip1;
	public JLabel btn_batdau;
	public JButton btn_choivoimay;
	public JButton btn_taydoi;
	public JButton btn_thoat;
	public JButton btn_giup;
	public JButton btn_caidat;
	public JButton btn_trove;
	public JLabel label_huongdan;
	private JPanel panel_demo;
	private JPanel panel_huongdan;
	public JPanel panel_caidat;
	private JButton btn_setting_trove;
	private JLabel label_caidat;
	private JPanel panel_tuychinh;
	private JLabel label_tuychinh;
	private JPanel panel_play;
	private JLabel label_play;
	public JButton btn_home;
	private JLabel label_thoigian;
	private JPanel panel_tuychinh_conten;
	private JLabel label_capdo;
	private JLabel label_taydoi_cq;
	public JButton btn_de;
	public JButton btn_kho;
	public JButton btn_x;
	public JButton btn_o;
	private JLabel label_ditruoc;
	public JButton btn_ditruoc;
	public JButton btn_play;
	public JButton[] btn_gameplay;
	TictactoeController ctrl;
	public javax.swing.Timer timer;
	public JPanel panel_banco;
	public JButton btn_lammoi;
	public JButton btn_30;
	public JButton btn_60;
	private JPanel panel_tuychon;
	private JLabel label_tuychon;
	public JButton btn_taydoi_play;
	private JLabel label_taydoi_tg;
	public JButton btn_taydoi_30;
	public JButton btn_taydoi_60;
	public JButton btn_taydoi_90;
	public JButton btn_caidatBackground1;
	public JButton btn_caidatBackground2;
	public JButton btn_caidatBackground3;
	public JButton btn_taydoi_x;
	public JButton btn_taydoi_o;
	private JLabel label_chonquan;
	private JLabel label_taydoi_win;
	private JLabel label_tyso1;
	private JLabel label_tyso2;
	private JLabel label_tyso1_1;
	private JLabel label_tyso1_2;
	private JLabel label_tyso2_1;
	private JLabel label_tyso2_2;
	private JLabel label_demnguoc;
	private JLabel label_background;

	private JLabel label_caidatAmthanh;

	public JButton btn_caidatAmthanh;
	
	
	
	public TictactoeView() {
		this.model = new TictactoeModel();
		this.init();
		this.play();
	}
	
	public void demThoiGian() {
		if(model.checkWin()==-2) {
			label_demnguoc.setText(""+model.second);
		}
		timer = new javax.swing.Timer(1000, new ActionListener() {
			int tg = model.second;
			@Override
			public void actionPerformed(ActionEvent e) {
				tg--;
				label_demnguoc.setText(""+tg);
				if(tg==0) {
					int tam = model.second;
					model.second = 0;
					checkWin();
					model.second = tam;
				}
			}
		});
		timer.start();
	}

	public void init() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(614, 636);
		this.setIconImage(Toolkit.getDefaultToolkit().createImage("icon_samurai.jpg"));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setExtendedState(JFrame.NORMAL);
		getContentPane().setLayout(new GridLayout());
		getContentPane().setLayout(null);
		
		ctrl = new TictactoeController(this);
		
		Font font = new Font("Forte", Font.BOLD, 22);
		Font font45 = new Font("Arial", Font.BOLD, 45);
		Font font30 = new Font("Arial", Font.BOLD, 30);
		Font font_Lon = new Font("Arial", Font.BOLD, 25);
		Font font_co = new Font("Forte", Font.BOLD, 130);
		Font font_win = new Font("Forte", Font.BOLD, 30);
		
		btn_home = new JButton(new ImageIcon("icon_home.png"));
		btn_home.setBorder(null);
		btn_home.setBounds(430, 512, 120, 40);
		btn_home.addActionListener(ctrl);
		btn_home.setBackground(Color.cyan);
		btn_home.setFocusable(false);
		
		
//		Phần cứu
		
		panel_huongdan = new JPanel();
		panel_huongdan.setBounds(0, 0, 600, 600);
		panel_huongdan.setOpaque(false);
		this.add(panel_huongdan);
		panel_huongdan.setLayout(null);
		
		label_huongdan = new JLabel(new ImageIcon("background_content.png"));
		label_huongdan.setBounds(100, 60, 400, 400);
		
		btn_trove = new JButton("Trở lại");
		btn_trove.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btn_trove.setBackground(Color.cyan);
		btn_trove.setBounds(430, 512, 120, 40);
		btn_trove.addActionListener(ctrl);
		btn_trove.setBorder(null);
		btn_trove.setFocusable(false);
		panel_huongdan.add(label_huongdan);
		
		JTextArea txtrGameTictactoeRt = new JTextArea("Game TicTacToe rất đơn giản, bạn phải tạo thành hàng ngang hoặc chéo gòm 3 quân cờ để giành chiến thắng. \nNgược lại, nếu bạn để cho đối phương làm đều tương tự, bạn sẽ thua cuộc. \nBàn cò có 9 ô, nếu sau đã lấp đầy 9 ô đó mà không có ai tạo ra bàn thắng =>Trận đấu sẽ kết thúc với kết quả hòa");
		txtrGameTictactoeRt.setEditable(false);
		txtrGameTictactoeRt.setLineWrap(true);
		txtrGameTictactoeRt.setWrapStyleWord(true);
		txtrGameTictactoeRt.setForeground(Color.white);
		txtrGameTictactoeRt.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtrGameTictactoeRt.setBounds(50, 90, 300, 300);
		txtrGameTictactoeRt.setOpaque(false);
		label_huongdan.setLayout(null);
		label_huongdan.add(txtrGameTictactoeRt);
		
		JLabel jlabel_headerHuongDan = new JLabel("Hướng Dẫn", JLabel.CENTER);
		jlabel_headerHuongDan.setFont(new Font("Times New Roman", Font.BOLD, 30));
		jlabel_headerHuongDan.setForeground(Color.orange);
		jlabel_headerHuongDan.setBounds(0, 10, 400, 50);
		jlabel_headerHuongDan.setOpaque(false);
		label_huongdan.add(jlabel_headerHuongDan);
		
		panel_huongdan.setVisible(false);
		
//		Setting
		panel_caidat = new JPanel();
		panel_caidat.setLayout(null);
		panel_caidat.setBounds(0, 0, 600, 600);
		panel_caidat.setOpaque(false);
		
		btn_setting_trove = new JButton("Trở lại");
		btn_setting_trove.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btn_setting_trove.setBackground(Color.cyan);
		btn_setting_trove.setBounds(430, 512, 120, 40);
		btn_setting_trove.addActionListener(ctrl);
		btn_setting_trove.setBorder(null);
		btn_setting_trove.setFocusable(false);
		panel_caidat.add(btn_setting_trove);
		
		label_caidat = new JLabel(new ImageIcon("background_content.png"));
		label_caidat.setBounds(100, 60, 400, 400);
		label_caidat.setLayout(null);
		
		JLabel jlabel_headerCaiDat = new JLabel("Cài Đặt", JLabel.CENTER);
		jlabel_headerCaiDat.setFont(new Font("Times New Roman", Font.BOLD, 30));
		jlabel_headerCaiDat.setForeground(Color.orange);
		jlabel_headerCaiDat.setBounds(0, 10, 400, 50);
		jlabel_headerCaiDat.setOpaque(false);
		label_caidat.add(jlabel_headerCaiDat);
		
		btn_caidatBackground1 = new JButton("Nền 1");
		btn_caidatBackground1.setFocusable(false);
		btn_caidatBackground1.setBounds(50, 100, 90, 45);
		btn_caidatBackground1.setFont(font_Lon);
		btn_caidatBackground1.setBorder(null);
		btn_caidatBackground1.setBackground(Color.ORANGE);
		btn_caidatBackground1.addActionListener(ctrl);
		label_caidat.add(btn_caidatBackground1);
		
		btn_caidatBackground2 = new JButton("Nền 2");
		btn_caidatBackground2.setFocusable(false);
		btn_caidatBackground2.setBounds(155, 100, 90, 45);
		btn_caidatBackground2.setFont(font_Lon);
		btn_caidatBackground2.setBorder(null);
		btn_caidatBackground2.setForeground(Color.white);
		btn_caidatBackground2.setBackground(Color.DARK_GRAY);
		btn_caidatBackground2.addActionListener(ctrl);
		label_caidat.add(btn_caidatBackground2);
		
		btn_caidatBackground3 = new JButton("Nền 3");
		btn_caidatBackground3.setFocusable(false);
		btn_caidatBackground3.setBounds(260, 100, 90, 45);
		btn_caidatBackground3.setFont(font_Lon);
		btn_caidatBackground3.setBorder(null);
		btn_caidatBackground3.setForeground(Color.black);
		btn_caidatBackground3.setBackground(Color.cyan);
		btn_caidatBackground3.addActionListener(ctrl);
		label_caidat.add(btn_caidatBackground3);
		
		label_caidatAmthanh = new JLabel("Nhạc game: ");
		label_caidatAmthanh.setBounds(60, 195, 200, 50);
		label_caidatAmthanh.setForeground(Color.white);
		label_caidatAmthanh.setFont(new Font("Time new roman", Font.BOLD, 26));
		
		btn_caidatAmthanh = new JButton("Tắt");
		btn_caidatAmthanh.setFocusable(false);
		btn_caidatAmthanh.setBounds(240, 202, 90, 40);
		btn_caidatAmthanh.setFont(font_Lon);
		btn_caidatAmthanh.setBorder(null);
		btn_caidatAmthanh.setBackground(Color.green);
		btn_caidatAmthanh.addActionListener(ctrl);
		label_caidat.add(label_caidatAmthanh);
		label_caidat.add(btn_caidatAmthanh);
		
		panel_caidat.add(label_caidat);
		panel_caidat.setVisible(false);
		getContentPane().add(panel_caidat);

//		giao dien chinh
		
		panel_demo = new JPanel();
		panel_demo.setLayout(null);
		panel_demo.setBounds(0, 0, 600, 600);
		panel_demo.setOpaque(false);
		this.add(panel_demo);

		btn_batdau = new JLabel();
		btn_batdau.setIcon(new ImageIcon(new ImageIcon("F:\\eclipse-workspace\\NLCS\\btn_batdau.png").getImage().getScaledInstance(340, 80, DO_NOTHING_ON_CLOSE)));
		btn_batdau.setBounds(130, 138, 340, 100);
		btn_batdau.addMouseListener(ctrl);
		btn_batdau.setFocusable(false);
		
		btn_choivoimay = new JButton(new ImageIcon(new ImageIcon("F:\\eclipse-workspace\\NLCS\\btn_choivoimay.png").getImage().getScaledInstance(260, 70, DO_NOTHING_ON_CLOSE)));
		btn_choivoimay.setBounds(170, 267, 260, 70);
		btn_choivoimay.addMouseListener(ctrl);
		btn_choivoimay.setBorderPainted(false);
		btn_choivoimay.addActionListener(ctrl);
		
		btn_taydoi = new JButton(new ImageIcon(new ImageIcon("F:\\eclipse-workspace\\NLCS\\btn_taydoi.png").getImage().getScaledInstance(260, 70, DO_NOTHING_ON_CLOSE)));
		btn_taydoi.setBounds(170, 364, 260, 70);
		btn_taydoi.addMouseListener(ctrl);
		btn_taydoi.setBorderPainted(false);
		btn_taydoi.addActionListener(ctrl);
		
		btn_thoat = new JButton("Thoát");
		btn_thoat.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btn_thoat.setBackground(Color.cyan);
		btn_thoat.setBounds(430, 512, 120, 40);
		btn_thoat.setBorder(null);
		btn_thoat.addActionListener(ctrl);
		btn_thoat.addMouseListener(ctrl);
		btn_thoat.setFocusable(false);
		
		btn_giup = new JButton("Trợ giúp");
		btn_giup.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btn_giup.setBackground(Color.cyan);
		btn_giup.setBounds(50, 512, 120, 40);
		btn_giup.addActionListener(ctrl);;
		btn_giup.addMouseListener(ctrl);
		btn_giup.setBorder(null);
		btn_giup.setFocusable(false);
		
		btn_caidat = new JButton("Cài đặt");
		btn_caidat.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btn_caidat.setBackground(Color.cyan);
		btn_caidat.setBounds(50, 28, 120, 40);
		btn_caidat.addActionListener(ctrl);
		btn_caidat.addMouseListener(ctrl);
		btn_caidat.setBorder(null);
		btn_caidat.setFocusable(false);
		

		panel_demo.add(btn_batdau);
		panel_demo.add(btn_choivoimay);
		panel_demo.add(btn_taydoi);
		panel_demo.add(btn_thoat);
		panel_demo.add(btn_giup);
		panel_demo.add(btn_caidat);
		
//		Tuy chọn
		
		panel_tuychon = new JPanel();
		panel_tuychon.setOpaque(false);
		panel_tuychon.setBounds(0,0,600,600);
		panel_tuychon.setLayout(null);
		label_tuychon = new JLabel(new ImageIcon("background_tuychon.png"));
		label_tuychon.setBounds(100, 60, 400, 400);
		
		panel_tuychon.setVisible(false);
		getContentPane().add(panel_tuychon);
		
		//Play
		btn_taydoi_play = new JButton(new ImageIcon("icon_play.png"));
		btn_taydoi_play.setBounds(135, 320, 130, 40);
		btn_taydoi_play.setBorder(null);
		btn_taydoi_play.setBackground(Color.ORANGE);
		btn_taydoi_play.setFocusable(false);
		btn_taydoi_play.addActionListener(ctrl);
		btn_taydoi_play.addMouseListener(ctrl);
		label_tuychon.add(btn_taydoi_play);
		
		// thoi gian choi tay doi
		label_taydoi_tg = new JLabel("Thời gian", JLabel.CENTER);
		label_taydoi_tg.setFont(font30);
		label_taydoi_tg.setBounds(0, 20, 400, 40);
		btn_taydoi_30 = new JButton("5s");
		btn_taydoi_30.setFocusable(false);
		btn_taydoi_30.setBounds(50, 80, 90, 50);
		btn_taydoi_30.setFont(font30);
		btn_taydoi_30.setBorder(null);
		btn_taydoi_30.setBackground(Color.CYAN);
		btn_taydoi_30.addActionListener(ctrl);
		btn_taydoi_30.addMouseListener(ctrl);
		btn_taydoi_60 = new JButton("10s");
		btn_taydoi_60.setFocusable(false);
		btn_taydoi_60.setBackground(Color.CYAN);
		btn_taydoi_60.setBounds(155, 80, 90, 50);
		btn_taydoi_60.addMouseListener(ctrl);
		btn_taydoi_60.setFont(font30);
		btn_taydoi_60.setBorder(null);
		btn_taydoi_60.addActionListener(ctrl);
		btn_taydoi_90 = new JButton("15s");
		btn_taydoi_90.setFocusable(false);
		btn_taydoi_90.setBackground(Color.CYAN);
		btn_taydoi_90.setBounds(260, 80, 90, 50);
		btn_taydoi_90.addMouseListener(ctrl);
		btn_taydoi_90.setFont(font30);
		btn_taydoi_90.setBorder(null);
		btn_taydoi_90.addActionListener(ctrl);
		
		label_tuychon.add(label_taydoi_tg);
		label_tuychon.add(btn_taydoi_30);
		label_tuychon.add(btn_taydoi_60);
		label_tuychon.add(btn_taydoi_90);
		
		// chon quan tay doi
		label_taydoi_cq = new JLabel("Quân đi trước", JLabel.CENTER);
		label_taydoi_cq.setFont(font30);
		label_taydoi_cq.setBounds(0, 140, 400, 40);
		label_tuychon.add(label_taydoi_cq);
		
		btn_taydoi_x = new JButton("X");
		btn_taydoi_x.setFont(font45);
		btn_taydoi_x.setBounds(100, 190, 80, 50);
		btn_taydoi_x.setBackground(Color.green);
		btn_taydoi_x.setForeground(Color.BLUE);
		btn_taydoi_x.setBorder(null);
		btn_taydoi_x.setFocusable(false);
		btn_taydoi_x.addActionListener(ctrl);
		btn_taydoi_x.addMouseListener(ctrl);
		label_tuychon.add(btn_taydoi_x);
		
		btn_taydoi_o = new JButton("O");
		btn_taydoi_o.setFont(font45);
		btn_taydoi_o.setBounds(220, 190, 80, 50);
		btn_taydoi_o.setBackground(Color.cyan);
		btn_taydoi_o.setForeground(Color.RED);
		btn_taydoi_o.setBorder(null);
		btn_taydoi_o.setFocusable(false);
		btn_taydoi_o.addActionListener(ctrl);
		btn_taydoi_o.addMouseListener(ctrl);
		label_tuychon.add(btn_taydoi_o);
		
//		tuy chinh
		
		panel_tuychinh = new JPanel();
		panel_tuychinh.setOpaque(false);
		panel_tuychinh.setBounds(0,0,600,600);
		panel_tuychinh.setLayout(null);
		label_tuychinh = new JLabel(new ImageIcon("background_tuychon.png"));
		label_tuychinh.setBounds(100, 60, 400, 400);
		
		panel_tuychinh.setVisible(false);
		getContentPane().add(panel_tuychinh);
		
		
		panel_tuychinh_conten = new JPanel();
		panel_tuychinh.add(panel_tuychinh_conten);
		panel_tuychinh_conten.setLayout(null);
		panel_tuychinh_conten.setOpaque(false);
		panel_tuychinh_conten.setBounds(100, 60, 400, 400);		
		label_thoigian = new JLabel("Thời gian: ");
		label_thoigian.setFont(font_Lon);
		label_thoigian.setBounds(10, 20, 130, 40);
		btn_30 = new JButton("10s");
		btn_30.setFocusable(false);
		btn_30.setBounds(180, 22, 90, 50);
		btn_30.setFont(font30);
		btn_30.setBorder(null);
		btn_30.setBackground(Color.GREEN);
		btn_30.addActionListener(ctrl);
		btn_30.addMouseListener(ctrl);
		btn_60 = new JButton("15s");
		btn_60.setFocusable(false);
		btn_60.setBackground(Color.CYAN);
		btn_60.setBounds(280, 22, 90, 50);
		btn_60.addMouseListener(ctrl);
		btn_60.setFont(font30);
		btn_60.setBorder(null);
		btn_60.addActionListener(ctrl);
		
		panel_tuychinh_conten.add(label_thoigian);
		panel_tuychinh_conten.add(btn_30);
		panel_tuychinh_conten.add(btn_60);
		
		//cấp độ
		label_capdo = new JLabel("Cấp độ: ");
		label_capdo.setFont(new Font("Arial", Font.BOLD, 30));
		label_capdo.setBounds(15, 70, 130, 40);
		panel_tuychinh_conten.add(label_capdo);
		
		btn_de = new JButton("Dễ");
		btn_de.setFont(new Font("Arial", Font.BOLD, 35));
		btn_de.setBounds(50, 135, 130, 40);
		btn_de.setBorder(null);
		btn_de.setBackground(Color.GREEN);
		btn_de.setFocusable(true);
		btn_de.setFocusPainted(false);
		btn_de.addActionListener(ctrl);
		btn_de.addMouseListener(ctrl);
		panel_tuychinh_conten.add(btn_de);
		
		btn_kho = new JButton("Khó");
		btn_kho.setFont(new Font("Arial", Font.BOLD, 35));
		btn_kho.setBounds(220, 135, 130, 40);
		btn_kho.setBorder(null);
		btn_kho.setBackground(Color.CYAN);
		btn_kho.setFocusable(false);
		btn_kho.addActionListener(ctrl);
		btn_kho.addMouseListener(ctrl);
		panel_tuychinh_conten.add(btn_kho);
		
		//chon quân
		label_chonquan = new JLabel("Chọn quân: ");
		label_chonquan.setFont(new Font("Arial", Font.BOLD, 30));
		label_chonquan.setBounds(15, 200, 177, 40);
		panel_tuychinh_conten.add(label_chonquan);
		
		btn_x = new JButton("X");
		btn_x.setFont(font45);
		btn_x.setBounds(200, 190, 80, 60);
		btn_x.setBackground(Color.green);
		btn_x.setForeground(Color.BLUE);
		btn_x.setBorder(null);
		btn_x.setFocusable(false);
		btn_x.addActionListener(ctrl);
		btn_x.addMouseListener(ctrl);
		panel_tuychinh_conten.add(btn_x);
		
		btn_o = new JButton("O");
		btn_o.setFont(font45);
		btn_o.setBounds(300, 190, 80, 60);
		btn_o.setForeground(Color.RED);
		btn_o.setBorder(null);
		btn_o.setContentAreaFilled(false);
		btn_o.setFocusable(false);
		btn_o.addActionListener(ctrl);
		btn_o.addMouseListener(ctrl);
		panel_tuychinh_conten.add(btn_o);
		
		// đi trước
		label_ditruoc = new JLabel("Đi trước:");
		label_ditruoc.setFont(new Font("Arial", Font.BOLD, 30));
		label_ditruoc.setBounds(50, 265, 177, 40);
		panel_tuychinh_conten.add(label_ditruoc);
		
		btn_ditruoc = new JButton("Bạn");
		btn_ditruoc.setFont(new Font("Arial", Font.BOLD, 30));
		btn_ditruoc.setBounds(250, 267, 80, 40);
		btn_ditruoc.setBackground(Color.green);
		btn_ditruoc.setBorder(null);
		btn_ditruoc.setFocusable(false);
		btn_ditruoc.addActionListener(ctrl);
		btn_ditruoc.addMouseListener(ctrl);
		panel_tuychinh_conten.add(btn_ditruoc);
		
		//Play
		btn_play = new JButton(new ImageIcon("icon_play.png"));
		btn_play.setBounds(135, 320, 130, 40);
		btn_play.setBorder(null);
		btn_play.setBackground(Color.ORANGE);
		btn_play.setFocusable(false);
		btn_play.addActionListener(ctrl);
		btn_play.addMouseListener(ctrl);
		panel_tuychinh_conten.add(btn_play);
		
//		bàn cờ
		
		panel_play = new JPanel();
		panel_play.setOpaque(false);
		panel_play.setBounds(0,0,600,600);
		panel_play.setLayout(null);
		
		// nut lam moi
		btn_lammoi = new JButton("Làm mới");
		btn_lammoi.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btn_lammoi.setBackground(Color.cyan);
		btn_lammoi.setBounds(50, 512, 120, 40);
		btn_lammoi.addActionListener(ctrl);
		btn_lammoi.setBorder(null);
		btn_lammoi.setFocusable(false);
		
		panel_play.add(btn_lammoi);
		panel_play.add(btn_home);
		
		panel_banco = new JPanel();
		panel_banco.setOpaque(false);
		panel_banco.setBounds(110, 70, 380, 380);
		panel_banco.setLayout(new GridLayout(3,3, 10,10));
		panel_banco.addMouseListener(ctrl);
		
		label_play = new JLabel(new ImageIcon("background_play.png"));
		label_play.setBounds(100, 60, 400, 400);
		
		// check win
		label_taydoi_win = new JLabel("", JLabel.CENTER);
		label_taydoi_win.setBackground(Color.BLACK);
		label_taydoi_win.setOpaque(true);
		label_taydoi_win.setFont(font_win);
		label_taydoi_win.setBounds(220, 10, 160, 40);
		label_taydoi_win.setVisible(true);
		panel_play.add(label_taydoi_win);
		
		label_tyso1 = new JLabel();
		label_tyso1.setLayout(new GridLayout(1,2));
		label_tyso1.setBackground(Color.BLACK);
		label_tyso1.setOpaque(true);
		label_tyso1.setBounds(100, 10, 100, 40);
		label_tyso1.setVisible(true);
		panel_play.add(label_tyso1);
		
		label_tyso1_1 = new JLabel("O:", JLabel.CENTER);
		label_tyso1_1.setFont(font);
		label_tyso1_1.setVisible(true);
		label_tyso1.add(label_tyso1_1);
		
		label_tyso1_2 = new JLabel("0",JLabel.CENTER);
		label_tyso1_2.setFont(font);
		label_tyso1_2.setForeground(Color.orange);
		label_tyso1_2.setVisible(true);
		label_tyso1.add(label_tyso1_2);
		
		
		label_tyso2 = new JLabel();
		label_tyso2.setBackground(Color.BLACK);
		label_tyso2.setLayout(new GridLayout(1,2));
		label_tyso2.setOpaque(true);
		label_tyso2.setBounds(400, 10, 100, 40);
		label_tyso2.setVisible(true);
		panel_play.add(label_tyso2);
		
		label_tyso2_1 = new JLabel("X:", JLabel.CENTER);
		label_tyso2_1.setFont(font);
		label_tyso2_1.setVisible(true);
		label_tyso2.add(label_tyso2_1);
		
		label_tyso2_2 = new JLabel("0",JLabel.CENTER);
		label_tyso2_2.setFont(font);
		label_tyso2_2.setForeground(Color.orange);
		label_tyso2_2.setVisible(true);
		label_tyso2.add(label_tyso2_2);
		
		label_demnguoc = new JLabel("", JLabel.CENTER);
		label_demnguoc.setFont(font);
		label_demnguoc.setForeground(Color.orange);
		label_demnguoc.setBackground(Color.BLACK);
		label_demnguoc.setOpaque(true);
		label_demnguoc.setBounds(220, 470, 160, 40);
		label_demnguoc.setVisible(true);
		panel_play.add(label_demnguoc);
		demThoiGian(); // khống chế lỗi phát sinh null timer
		timer.stop();
		
		panel_play.add(panel_banco);
		panel_play.add(label_play);
		panel_play.setVisible(false);
		getContentPane().add(panel_play);
		
//		Ma trận
	
		// tạo nút
		 btn_gameplay= new JButton[10];
		
		for(int i=1;i<=9;i++) {
			btn_gameplay[i] = new JButton();
			btn_gameplay[i].setFocusable(false);
			btn_gameplay[i].setBackground(Color.green);
			btn_gameplay[i].setContentAreaFilled(false);
			btn_gameplay[i].setBorder(null);
			btn_gameplay[i].setFont(font_co);
		}
		
		themEventNut();
		themNut();
		
//		phần background
		
		label_background = new JLabel(new ImageIcon("background.gif"));
		label_background.setBounds(0, 0, 600, 600);
		label_background.setBorder(null);
		this.add(label_background);
		
		this.setVisible(true);
	}
	
	public void enter(JButton jb) {
		if(jb == btn_choivoimay) {
			btn_choivoimay.setIcon(new ImageIcon(new ImageIcon("F:\\eclipse-workspace\\NLCS\\btn_choivoimay.png").getImage().getScaledInstance(290, 80, DO_NOTHING_ON_CLOSE)));
			btn_choivoimay.setBounds(155, 262, 290, 80);
		}
		if(jb == btn_taydoi) {
			btn_taydoi.setIcon(new ImageIcon(new ImageIcon("F:\\eclipse-workspace\\NLCS\\btn_taydoi.png").getImage().getScaledInstance(290, 80, DO_NOTHING_ON_CLOSE)));
			btn_taydoi.setBounds(155, 359, 290, 80);
		}
		if(jb == btn_play) {
			btn_play.setIcon(new ImageIcon(new ImageIcon("icon_play.png").getImage().getScaledInstance(170, 60, DO_NOTHING_ON_CLOSE)));
			btn_play.setBounds(115, 310, 170, 60);
		}
		if(jb == btn_taydoi_play) {
			btn_taydoi_play.setIcon(new ImageIcon(new ImageIcon("icon_play.png").getImage().getScaledInstance(170, 60, DO_NOTHING_ON_CLOSE)));
			btn_taydoi_play.setBounds(115, 310, 170, 60);
		}
		if(jb == btn_taydoi_30) {
			btn_taydoi_30.setForeground(Color.red);
		}
		if(jb == btn_taydoi_60) {
			btn_taydoi_60.setForeground(Color.red);
		}
		if(jb == btn_taydoi_90) {
			btn_taydoi_90.setForeground(Color.red);
		}
	}
	
	public void exit(JButton jb) {
		if(jb == btn_choivoimay) {
			btn_choivoimay.setIcon(new ImageIcon(new ImageIcon("F:\\eclipse-workspace\\NLCS\\btn_choivoimay.png").getImage().getScaledInstance(260, 70, DO_NOTHING_ON_CLOSE)));
			btn_choivoimay.setBounds(170, 267, 260, 70);
		}
		if(jb == btn_taydoi) {
			btn_taydoi.setIcon(new ImageIcon(new ImageIcon("F:\\eclipse-workspace\\NLCS\\btn_taydoi.png").getImage().getScaledInstance(260, 70, DO_NOTHING_ON_CLOSE)));
			btn_taydoi.setBounds(170, 364, 260, 70);
		}
		if(jb == btn_play) {
			btn_play.setIcon(new ImageIcon("icon_play.png"));
			btn_play.setBounds(135, 320, 130, 40);
		}
		if(jb == btn_taydoi_play) {
			btn_taydoi_play.setIcon(new ImageIcon("icon_play.png"));
			btn_taydoi_play.setBounds(135, 320, 130, 40);
		}
		if(jb == btn_taydoi_30) {
			btn_taydoi_30.setForeground(Color.black);
		}
		if(jb == btn_taydoi_60) {
			btn_taydoi_60.setForeground(Color.black);
		}
		if(jb == btn_taydoi_90) {
			btn_taydoi_90.setForeground(Color.black);
		}
	}
	
	public void huongDan() {
		panel_demo.setVisible(false);
		panel_huongdan.setVisible(true);
		panel_huongdan.add(btn_trove);
	}
	
	public void setTing() {
		panel_demo.setVisible(false);
		panel_caidat.setVisible(true);
	}
	
	public void home() {
		panel_huongdan.setVisible(false);
		panel_caidat.setVisible(false);
		panel_tuychinh.setVisible(false);
		panel_tuychon.setVisible(false);
		panel_play.setVisible(false);
		panel_demo.setVisible(true);
		timer.stop();
		//new TictactoeModel();
		// Mac dinh JFrame
		btn_ditruoc.setText("Bạn");
		btn_de.setBackground(Color.GREEN);
		btn_kho.setBackground(Color.cyan);
		btn_x.setBackground(Color.GREEN);
		btn_x.setContentAreaFilled(true);
		btn_o.setContentAreaFilled(false);
		label_tyso1_2.setText("0");
		label_tyso2_2.setText("0");
	}
	
	public void tuyChinh() {
		model.setChoiTayDoi(false);
		panel_demo.setVisible(false);
		this.panel_tuychinh.setVisible(true);
		panel_tuychinh.add(btn_trove);
		panel_tuychinh.add(label_tuychinh);
		model = new TictactoeModel();
		label_tyso1_1.setText("Ai:");
		label_tyso2_1.setText("You:");
		btn_30.setBackground(Color.GREEN);
		btn_60.setBackground(Color.CYAN);
		model.second= 10;
	}
	
	public void tuyChon() {
		panel_demo.setVisible(false);
		this.panel_tuychon.setVisible(true);
		panel_tuychon.add(btn_trove);
		panel_tuychon.add(label_tuychon);
		model = new TictactoeModel();
		model.setChoiTayDoi(true);
		label_tyso1_1.setText("O: ");
		label_tyso1_1.setForeground(Color.red);
		label_tyso2_1.setText("X: ");
		label_tyso2_1.setForeground(Color.blue);
		btn_taydoi_30.setBackground(Color.green);
		btn_taydoi_60.setBackground(Color.cyan);
		btn_taydoi_90.setBackground(Color.cyan);
		model.second= 5;
		model.setCheDoDe(false);
	}
	
	public void chonDiTruoc(String textBtn) {
		if(textBtn == "Bạn") {
			btn_ditruoc.setText("Máy");
			model.setDitruoc(false);
		}else {
			btn_ditruoc.setText("Bạn");
			model.setDitruoc(true);
		}
	}

	public void themNut() {
		for(int i =1; i<=9;i++) {
			btn_gameplay[i].setText("");
			btn_gameplay[i].setContentAreaFilled(false);;
			panel_banco.add(btn_gameplay[i]);
		}
	}
	
	public void voHieuNut() {
		for(int i =1; i<=9;i++) {
			btn_gameplay[i].setEnabled(false);
		}
	}
	
	public void batHieuNut() {
		for(int i =1; i<=9;i++) {
			btn_gameplay[i].setEnabled(true);
		}
	}
	
	public void themEventNut() {
		for(int i =1; i<=9;i++) {
			btn_gameplay[i].addActionListener(ctrl);
		}
	}
	
	public void xoaEventNut() {
		for(int i =1; i<=9;i++) {
			btn_gameplay[i].removeActionListener(ctrl);
		}
	}
	
	public void banCo() {
		panel_demo.setVisible(false);
		panel_tuychinh.setVisible(false);
		panel_tuychon.setVisible(false);
		panel_play.setVisible(true);
		reset();
		if(model.getChonQuan()) {
			label_tyso1_1.setForeground(Color.red);
			label_tyso2_1.setForeground(Color.blue);

		}else {
			label_tyso1_1.setForeground(Color.blue);
			label_tyso2_1.setForeground(Color.red);
		}
	}
	
	public void reset() {
		label_taydoi_win.setText("...");
		model.setQuanX(model.getChonQuan());
		model.khoiTaoMaTran();
		model.taoViTriMoi();
		batHieuNut();
		themNut();
		timer.stop();
		demThoiGian();
		if(model.isChoiTayDoi()) {
			model.setQuanX(model.getChonQuan());
		}else {
			if(!model.isDitruoc()) {
				model.setQuanX(model.getChonQuan());
				mayDanh();
			}else {
				model.setQuanX(model.getChonQuan());
			}
		}
		
	}
	
	public void nguoiDanh(int jb) {
		if (model.isChoiTayDoi()) {
			model.setNguoi(false);
			model.isQuanX();
			danh(jb);
		}else {
			model.setNguoi(true);
			model.setQuanX(model.getChonQuan());
			danh(jb);
		}
	}
	
	public void mayDanh() {
		model.setNguoi(false);
		model.setQuanX(!model.getChonQuan());
		if(model.isCheDoDe()) {
			danh(model.nuocDiDe());
		}else 
			danh(model.nuocDiKho());
	}
	
	public void danh(int jb) {
		for(int i=0; i<10;i++) {
			if(jb == i && btn_gameplay[i].getText() == "") {
				timer.start();
				if (model.isQuanX()) {
					btn_gameplay[i].setText("x");
					btn_gameplay[i].setForeground(Color.BLUE);
					model.setGiaTri(i, 10);
					model.setQuanX(false);
				}else {
					btn_gameplay[i].setText("o");
					btn_gameplay[i].setForeground(Color.red);
					model.setGiaTri(i, -10);
					model.setQuanX(true);
				}
				checkWin();
				if(model.isNguoi() && model.checkWin()==-2) {
					mayDanh();
				}
			}
		}
		
	}

	public void chonCo(Object jb) {
		if (jb == btn_x) {
			btn_x.setBackground(Color.green);
			btn_x.setContentAreaFilled(true);
			btn_o.setContentAreaFilled(false);
			model.setChonQuan(true);
		}
		if (jb == btn_o) {
			btn_o.setBackground(Color.green);
			btn_o.setContentAreaFilled(true);
			btn_x.setContentAreaFilled(false);
			model.setChonQuan(false);
		}
		if (jb == btn_taydoi_x) {
			btn_taydoi_x.setBackground(Color.green);
			btn_taydoi_o.setBackground(Color.cyan);
			model.setChonQuan(true);
		}
		if (jb == btn_taydoi_o) {
			btn_taydoi_o.setBackground(Color.green);
			btn_taydoi_x.setBackground(Color.cyan);
			model.setChonQuan(false);
		}
	}

	public void chonBackground(String nen) {
		if(nen == "Nền 1") {
			btn_caidatBackground1.setForeground(Color.red);
			label_background.setIcon(new ImageIcon("background.gif"));
			label_background.setBackground(Color.DARK_GRAY);
			btn_caidatBackground2.setForeground(Color.white);
			btn_caidatBackground3.setForeground(Color.black);
		}
		if(nen == "Nền 2") {
			btn_caidatBackground2.setForeground(Color.red);
			label_background.setIcon(new ImageIcon("background_2.png"));
			btn_caidatBackground1.setForeground(Color.black);
			btn_caidatBackground3.setForeground(Color.black);
		}
		if(nen == "Nền 3") {
			btn_caidatBackground3.setForeground(Color.red);
			label_background.setIcon(new ImageIcon("background_3.gif"));
			label_background.setBackground(Color.DARK_GRAY);
			btn_caidatBackground1.setForeground(Color.black);
			btn_caidatBackground2.setForeground(Color.white);
		}
	}
	
	public void chonNhac(String s) {
		if(s=="Tắt") {
			clip.stop();
			btn_caidatAmthanh.setText("Bật");
		} else {
			play();
			btn_caidatAmthanh.setText("Tắt");
		}
	}
	
	public void capDo(Object jb) {
		if (jb == btn_de) {
			model.setCheDoDe(true);
			btn_de.setBackground(Color.green);
			btn_kho.setBackground(Color.cyan);
		}
		if (jb == btn_kho) {
			model.setCheDoDe(false);
			btn_kho.setBackground(Color.green);
			btn_de.setBackground(Color.cyan);
		}
	}
	
	public void xetThoiGian(Object jb) {
		if (jb == btn_30) {
			btn_30.setBackground(Color.green);
			btn_60.setBackground(Color.cyan);
			model.second = 10;
		}
		if (jb == btn_60) {
			btn_60.setBackground(Color.green);
			btn_30.setBackground(Color.cyan);
			model.second = 15;
		}
		if (jb == btn_taydoi_30) {
			btn_taydoi_30.setBackground(Color.green);
			btn_taydoi_60.setBackground(Color.cyan);
			btn_taydoi_90.setBackground(Color.cyan);
			model.second = 5;
			
		}
		if (jb == btn_taydoi_60) {
			btn_taydoi_60.setBackground(Color.green);
			btn_taydoi_30.setBackground(Color.cyan);
			btn_taydoi_90.setBackground(Color.cyan);
			model.second = 10;
		}
		if (jb == btn_taydoi_90) {
			btn_taydoi_90.setBackground(Color.green);
			btn_taydoi_60.setBackground(Color.cyan);
			btn_taydoi_30.setBackground(Color.cyan);
			model.second = 15;
		}
	}
//	Check matran
	//chack win
	
	public void noiBat() {
		for (int i = 1;i <=3;i++) {
			if(model.vitri[i]!=0) {
				btn_gameplay[model.vitri[i]].setContentAreaFilled(true);
				btn_gameplay[model.vitri[i]].setEnabled(true);
			}
		}
		if(model.vitri[2]==0)
			voHieuNut();
	}
	
	public boolean checkWin() {
		if(model.checkWin() == 1) {
			timer.stop();
			label_taydoi_win.setVisible(true);
			if(model.isChoiTayDoi()) {
				label_taydoi_win.setText("X Win");
				winEffect();
				label_taydoi_win.setForeground(Color.blue);
				model.setDemX();
				label_tyso2_2.setText(model.getDemX());
			}else { // choi voi may
				if (model.getChonQuan()) {
					winEffect();
					label_taydoi_win.setText("You Win");
					label_taydoi_win.setForeground(Color.BLUE);
					model.setDemNguoi();
					label_tyso2_2.setText(model.getDemNguoi());
				}
				else {
					label_taydoi_win.setText("You Lose");
					label_taydoi_win.setForeground(Color.BLUE);
					model.setDemMay();
					duckEffect();
					label_tyso1_2.setText(model.getDemMay());
				}
			}
			voHieuNut();
			noiBat();
			return true;
		}else if(model.checkWin() == -1) {
				timer.stop();
				label_taydoi_win.setVisible(true);
				if(model.isChoiTayDoi()) {
					winEffect();
					label_taydoi_win.setText("O Win");
					label_taydoi_win.setForeground(Color.RED);
					model.setDemO();
					label_tyso1_2.setText(model.getDemO());
				}else {
					if (model.getChonQuan()) {
						duckEffect();
						label_taydoi_win.setText("You Lose");
						label_taydoi_win.setForeground(Color.RED);
						model.setDemMay();
						label_tyso1_2.setText(model.getDemMay());
					}
					else {
						winEffect();
						label_taydoi_win.setText("You Win");
						label_taydoi_win.setForeground(Color.RED);
						model.setDemNguoi();
						label_tyso2_2.setText(model.getDemNguoi());
					}
					
				}
				voHieuNut();
				noiBat();
				return true;
		}else if(model.checkWin() == 0) {
			timer.stop();
			duckEffect();
			label_taydoi_win.setVisible(true);
			label_taydoi_win.setText("Draw");
			label_taydoi_win.setForeground(Color.ORANGE);
			//xoaEventNut();
			voHieuNut();
			//noiBat();
			return true;
		}
		timer.stop();
		demThoiGian();
		return false;
	}
	
	public static void play() {
		  try {
		   File file = new File("song.wav");
		   clip = AudioSystem.getClip();
		   clip.open(AudioSystem.getAudioInputStream(file));
//		   Thread.sleep(10);
		   clip.loop(Clip.LOOP_CONTINUOUSLY); // infinite loop play music 
		   
		   FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		   volume.setValue(-10f);
		   
		   //Thread.sleep(clip.getMicrosecondLength());
		  } catch (Exception e) {
		   System.err.println(e.getMessage());
		  }
	}
	
	public static void audioClick() {
		try {
			File fileAudio = new File("audio_click.wav");
			clip1 = AudioSystem.getClip();
			clip1.open(AudioSystem.getAudioInputStream(fileAudio));
			clip1.start();
			
			FloatControl volumeClick = (FloatControl) clip1.getControl(FloatControl.Type.MASTER_GAIN);
			volumeClick.setValue(3f);
		} catch (Exception e) {
			 System.err.println(e.getMessage());
		}
	}
	
	public static void duckEffect() {
		try {
			File fileAudio = new File("duck_effect.wav");
			clip1 = AudioSystem.getClip();
			clip1.open(AudioSystem.getAudioInputStream(fileAudio));
			clip1.start();
			
			FloatControl volumeClick = (FloatControl) clip1.getControl(FloatControl.Type.MASTER_GAIN);
			volumeClick.setValue(3f);
		} catch (Exception e) {
			 System.err.println(e.getMessage());
		}
	}
	
	public static void winEffect() {
		try {
			File fileAudio = new File("win_audio.wav");
			clip1 = AudioSystem.getClip();
			clip1.open(AudioSystem.getAudioInputStream(fileAudio));
			clip1.start();
			
			FloatControl volumeClick = (FloatControl) clip1.getControl(FloatControl.Type.MASTER_GAIN);
			volumeClick.setValue(3f);
		} catch (Exception e) {
			 System.err.println(e.getMessage());
		}
	}
	
	
}
