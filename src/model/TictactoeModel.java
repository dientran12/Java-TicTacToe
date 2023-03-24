package model;

import java.util.Random;


public class TictactoeModel {
	private boolean quanX;
	private boolean nguoi;
	private boolean ditruoc;
	private boolean chonQuan;
	private int giaTri[];
	private boolean cheDoDe; // true la de, false la kho
	private boolean choiTayDoi;
	private int kiemTraThang; // -1 thua, 0 hoa, 1 thang
	public int vitri[];
	private int demO;
	private int demX;
	private int demNguoi;
	private int demMay;
	public int second;

	public TictactoeModel() {
		kiemTraThang = -2;
		//cheDoDe = true;
		taoViTriMoi();
		demO = 0;
		demX = 0;
		demNguoi=0;
		demMay=0;
		second= 10;
		setChonQuan(true);
		setDitruoc(true);;
		setQuanX(getChonQuan());
		setCheDoDe(true);
		khoiTaoMaTran();
	}
	
	public String getDemO() {
		return String.valueOf(demO);
	}

	public void setDemO() {
		this.demO++;
	}

	public String getDemX() {
		return String.valueOf(demX);
	}

	public void setDemX() {
		this.demX++;
	}
	
	public String getDemNguoi() {
		return demNguoi+"";
	}

	public void setDemNguoi() {
		demNguoi++;
	}

	public String getDemMay() {
		return demMay+"";
	}

	public void setDemMay() {
		demMay++;
	}

	public int getKiemTraThang() {
		return kiemTraThang;
	}
	
	public void setKiemTraThang(int kiemTraThang) {
		this.kiemTraThang = kiemTraThang;
	}
	
	public boolean isChoiTayDoi() {
		return choiTayDoi;
	}

	public void setChoiTayDoi(boolean choiTayDoi) {
		this.choiTayDoi = choiTayDoi;
	}
	
	public boolean isQuanX() {
		return quanX;
	}

	public void setQuanX(boolean quan) {
		this.quanX = quan;
	}

	public boolean isCheDoDe() {
		return cheDoDe;
	}
	
	public void setCheDoDe(boolean cheDo) {
		this.cheDoDe = cheDo;
	}

	
	public int getGiaTri(int a) {
		return giaTri[a];
	}

	public void setGiaTri(int a,int giaTri) {
		this.giaTri[a] = giaTri;
	}
	
	public boolean getChonQuan() {
		return chonQuan;
	}

	public void setChonQuan(Boolean chonQuan) {
		this.chonQuan = chonQuan;
	}

	public boolean isDitruoc() {
		return ditruoc;
	}

	public void setDitruoc(boolean ditruoc) {
		this.ditruoc = ditruoc;
	}

	public boolean isNguoi() {
		return nguoi;
	}

	public void setNguoi(boolean nguoi) {
		this.nguoi = nguoi;
	}
	
	public void taoViTriMoi() {
		vitri = new int[4];
		for(int i = 1; i<=3;i++) {
			vitri[i] = 0;
		}
	}
	
	public void khoiTaoMaTran() {
		giaTri = new int[10];
		for(int i = 1; i<=9;i++) {
			giaTri[i] = 0;
		}
	}
	
	public void lietKe(int a, int b, int c) {
		vitri[1] = a;
		vitri[2] = b;
		vitri[3] = c;
	}

	public boolean kiemTraDay() {
		int i =1;
		while(getGiaTri(i) != 0) {
			i++;
			if(i>9) 
				return true;
		}
		return false;
	}
	
	public int nuocDiDe() {
		Random rd = new Random();
		int x = rd.nextInt(9)+1;
		if(!kiemTraDay()) {
			while (getGiaTri(x)!= 0) {
				x = rd.nextInt(9)+1;
			}
			return x;
		}else
			return 0;
	}
	
	public int checkWin() {
		if(second == 0) {
			if(isQuanX()) {
				return -1;
			}else
				return 1;
		}else if(this.getGiaTri(1) + this.getGiaTri(2) + this.getGiaTri(3) == 30) {
			lietKe(1,2,3);
			return 1;
		} else if(this.getGiaTri(4) + this.getGiaTri(5) + this.getGiaTri(6) == 30) {
			lietKe(4,5,6);
			return 1;
		} else if(this.getGiaTri(7) + this.getGiaTri(8) + this.getGiaTri(9) == 30) {
			lietKe(7,8,9);
			return 1;
		} else if(this.getGiaTri(1) + this.getGiaTri(5) + this.getGiaTri(9) == 30) {
			lietKe(1,5,9);
			return 1;
		} else if(this.getGiaTri(7) + this.getGiaTri(5) + this.getGiaTri(3) == 30) {
			lietKe(7,5,3);
			return 1;
		} else if(this.getGiaTri(1) + this.getGiaTri(4) + this.getGiaTri(7) == 30) {
			lietKe(1,4,7);
			return 1;
		} else if(this.getGiaTri(2) + this.getGiaTri(5) + this.getGiaTri(8) == 30) {
			lietKe(2,5,8);
			return 1;
		} else if(this.getGiaTri(3) + this.getGiaTri(6) + this.getGiaTri(9) == 30) {
			lietKe(3,6,9);
			return 1;
		}else if(this.getGiaTri(1) + this.getGiaTri(2) + this.getGiaTri(3) == -30) {
			lietKe(1,2,3);
			return -1;
		} else if(this.getGiaTri(4) + this.getGiaTri(5) + this.getGiaTri(6) == -30) {
			lietKe(4,5,6);
			return -1;
		} else if(this.getGiaTri(7) + this.getGiaTri(8) + this.getGiaTri(9) == -30) {
			lietKe(7,8,9);
			return -1;
		} else if(this.getGiaTri(1) + this.getGiaTri(5) + this.getGiaTri(9) == -30) {
			lietKe(1,5,9);
			return -1;
		} else if(this.getGiaTri(7) + this.getGiaTri(5) + this.getGiaTri(3) == -30) {
			lietKe(7,5,3);
			return -1;
		} else if(this.getGiaTri(1) + this.getGiaTri(4) + this.getGiaTri(7) == -30) {
			lietKe(1,4,7);
			return -1;
		} else if(this.getGiaTri(2) + this.getGiaTri(5) + this.getGiaTri(8) == -30) {
			lietKe(2,5,8);
			return -1;
		} else if(this.getGiaTri(3) + this.getGiaTri(6) + this.getGiaTri(9) == -30) {
			lietKe(3,6,9);
			return -1;
		}else if (this.kiemTraDay()) {
			return 0;
		}
		return -2;
	}
	
	
	public int nuocDiKho() {
		int bestScore = -999;
		int x = 0;
		for(int i = 1; i<= 9; i++) {
			if(giaTri[i] == 0 && !isQuanX()) {
				giaTri[i] = -10;
				int score = minimax(giaTri, false);
				giaTri[i] = 0;
				if(score > bestScore) {
					x=i;
					bestScore = score;
				}
			}
			else 
			if(giaTri[i] == 0 && isQuanX()) {
				giaTri[i] = 10;
				int score = minimax(giaTri, false);
				giaTri[i] = 0;
				if(score > bestScore) {
					x=i;
					bestScore = score;
				}
			}
		}
		return x;
	}
	
	public int scores(int cw) {
		if(!isQuanX()) {
			if(cw == 1) {
				return -10;
			}else if(cw == -1) {
				return 10;
			}
			if (cw == 0)
				return 0;
			return -55;
		}
		else {
			if(cw == 1) {
				return 10;
			}else if(cw == -1) {
				return -10;
			}
			if (cw == 0)
				return 0;
			return -55;
			
		}
	}
	
	public int minimax(int giaTri[], boolean isMax) {
		int ketQua = checkWin();
		if(ketQua !=-2) {
			return scores(ketQua);
		}
		if(isMax) {
			int bestScore = -999;
			for (int i = 1; i < 10;i++) {
				if (giaTri[i] ==0) {
					if(isQuanX()) {
						giaTri[i] = 10;
					} else
						giaTri[i] = -10;
					int score = minimax(giaTri, false);
					giaTri[i] = 0;
					bestScore = Math.max(score, bestScore);
				}
			}
			return bestScore;
		} else {
			int bestScore = +999;
			for (int i = 1; i < 10;i++) {
				if (giaTri[i] ==0) {
					if(isQuanX()) {
						giaTri[i] = -10;
					} else
						giaTri[i] = 10;
					int score = minimax(giaTri, true);
					giaTri[i] = 0;
					bestScore = Math.min(score, bestScore);
				}
			}
			return bestScore;
		}
	}
	
}
