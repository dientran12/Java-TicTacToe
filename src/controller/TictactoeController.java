package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.TimerTask;

import view.TictactoeView;

public class TictactoeController implements ActionListener, MouseListener {
	private TictactoeView tictactoeView;
	
	public TictactoeController(TictactoeView tictactoeView) {
		this.tictactoeView = tictactoeView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String xetNut = e.getActionCommand();
		this.tictactoeView.audioClick();
		Object nhanDang = e.getSource();
		
		if(xetNut.equals("Trợ giúp")) {
			this.tictactoeView.huongDan();
		}
		if(xetNut.equals("Trở lại") || nhanDang == this.tictactoeView.btn_home) {
			this.tictactoeView.home();
		}
		if(xetNut.equals("Thoát")) {
			System.exit(0);
		}
		if(xetNut.equals("Làm mới")) {
			this.tictactoeView.reset();
		}
		if(xetNut.equals("Nền 1")) {
			this.tictactoeView.chonBackground(xetNut);
		}
		if(xetNut.equals("Nền 2")) {
			this.tictactoeView.chonBackground(xetNut);
		}
		if(xetNut.equals("Nền 3")) {
			this.tictactoeView.chonBackground(xetNut);
		}
		if(nhanDang == tictactoeView.btn_caidatAmthanh) {
			this.tictactoeView.chonNhac(xetNut);
		}
		if(nhanDang == tictactoeView.btn_30) {
			this.tictactoeView.xetThoiGian(nhanDang);
		}
		if(nhanDang == tictactoeView.btn_60) {
			this.tictactoeView.xetThoiGian(nhanDang);
		}
		if (nhanDang == tictactoeView.btn_taydoi_30) {
			this.tictactoeView.xetThoiGian(tictactoeView.btn_taydoi_30);
		}
		if (nhanDang == tictactoeView.btn_taydoi_60) {
			this.tictactoeView.xetThoiGian(tictactoeView.btn_taydoi_60);
		}
		if (nhanDang == tictactoeView.btn_taydoi_90) {
			this.tictactoeView.xetThoiGian(tictactoeView.btn_taydoi_90);
		}
		
		if(nhanDang == this.tictactoeView.btn_caidat) {
			this.tictactoeView.setTing();
		}
		if(nhanDang == this.tictactoeView.btn_choivoimay) {
			this.tictactoeView.tuyChinh();
		}
		if(nhanDang == this.tictactoeView.btn_taydoi) {
			this.tictactoeView.tuyChon();
		}
		if(nhanDang == this.tictactoeView.btn_play) {
			this.tictactoeView.banCo();
		}
		if(nhanDang == this.tictactoeView.btn_taydoi_play) {
			this.tictactoeView.banCo();
		}
		if(nhanDang == this.tictactoeView.btn_x) {
			this.tictactoeView.chonCo(nhanDang);
		}
		if(nhanDang == this.tictactoeView.btn_o) {
			this.tictactoeView.chonCo(nhanDang);
		}
		if(nhanDang == this.tictactoeView.btn_taydoi_x) {
			this.tictactoeView.chonCo(nhanDang);
		}
		if(nhanDang == this.tictactoeView.btn_taydoi_o) {
			this.tictactoeView.chonCo(nhanDang);
		}
		
		if(nhanDang == this.tictactoeView.btn_ditruoc) {
			this.tictactoeView.chonDiTruoc(xetNut);
		}
		
		// nuoc di
		for(int i=1;i<=9;i++) {
			if(nhanDang == tictactoeView.btn_gameplay[i]) {
				this.tictactoeView.nguoiDanh(i);
			}
		}
		
		if(nhanDang == tictactoeView.btn_de) {
			this.tictactoeView.capDo(tictactoeView.btn_de);
		}
		if(nhanDang == tictactoeView.btn_kho) {
			this.tictactoeView.capDo(tictactoeView.btn_kho);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Object nhanDang = e.getSource();
		if (nhanDang == tictactoeView.btn_choivoimay) {
			this.tictactoeView.enter(tictactoeView.btn_choivoimay);
		}
		if (nhanDang == tictactoeView.btn_taydoi) {
			this.tictactoeView.enter(tictactoeView.btn_taydoi);
		}
		if (nhanDang == tictactoeView.btn_play) {
			this.tictactoeView.enter(tictactoeView.btn_play);
		}
		if (nhanDang == tictactoeView.btn_taydoi_play) {
			this.tictactoeView.enter(tictactoeView.btn_taydoi_play);
		}
		if(nhanDang == tictactoeView.btn_de) {
			this.tictactoeView.enter(tictactoeView.btn_de);
		}
		if(nhanDang == tictactoeView.btn_kho) {
			this.tictactoeView.enter(tictactoeView.btn_kho);
		}
		if (nhanDang == tictactoeView.btn_taydoi_30) {
			this.tictactoeView.enter(tictactoeView.btn_taydoi_30);
		}
		if (nhanDang == tictactoeView.btn_taydoi_60) {
			this.tictactoeView.enter(tictactoeView.btn_taydoi_60);
		}
		if (nhanDang == tictactoeView.btn_taydoi_90) {
			this.tictactoeView.enter(tictactoeView.btn_taydoi_90);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Object nhanDang = e.getSource();
		
		if (nhanDang == tictactoeView.btn_choivoimay) {
			this.tictactoeView.exit(tictactoeView.btn_choivoimay);
		}
		if (nhanDang == tictactoeView.btn_taydoi) {
			this.tictactoeView.exit(tictactoeView.btn_taydoi);
		}
		if (nhanDang == tictactoeView.btn_play) {
			this.tictactoeView.exit(tictactoeView.btn_play);
		}
		if (nhanDang == tictactoeView.btn_taydoi_play) {
			this.tictactoeView.exit(tictactoeView.btn_taydoi_play);
		}
		if(nhanDang == tictactoeView.btn_de) {
			this.tictactoeView.exit(tictactoeView.btn_de);
		}
		if(nhanDang == tictactoeView.btn_kho) {
			this.tictactoeView.exit(tictactoeView.btn_kho);
		}
		if (nhanDang == tictactoeView.btn_taydoi_30) {
			this.tictactoeView.exit(tictactoeView.btn_taydoi_30);
		}
		if (nhanDang == tictactoeView.btn_taydoi_60) {
			this.tictactoeView.exit(tictactoeView.btn_taydoi_60);
		}
		if (nhanDang == tictactoeView.btn_taydoi_90) {
			this.tictactoeView.exit(tictactoeView.btn_taydoi_90);
		}
	}

}
