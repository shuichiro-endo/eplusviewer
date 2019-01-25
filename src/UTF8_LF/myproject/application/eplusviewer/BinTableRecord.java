package myproject.application.eplusviewer;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BinTableRecord {
	private StringProperty lineno;
	private StringProperty bin00;
	private StringProperty bin01;
	private StringProperty bin02;
	private StringProperty bin03;
	private StringProperty bin04;
	private StringProperty bin05;
	private StringProperty bin06;
	private StringProperty bin07;
	private StringProperty bin08;
	private StringProperty bin09;
	private StringProperty bin0A;
	private StringProperty bin0B;
	private StringProperty bin0C;
	private StringProperty bin0D;
	private StringProperty bin0E;
	private StringProperty bin0F;
	private StringProperty binspace;
	private StringProperty bin0;
	private StringProperty bin1;
	private StringProperty bin2;
	private StringProperty bin3;
	private StringProperty bin4;
	private StringProperty bin5;
	private StringProperty bin6;
	private StringProperty bin7;
	private StringProperty bin8;
	private StringProperty bin9;
	private StringProperty binA;
	private StringProperty binB;
	private StringProperty binC;
	private StringProperty binD;
	private StringProperty binE;
	private StringProperty binF;

	//初期データ保存
	private String bin00Old;
	private String bin01Old;
	private String bin02Old;
	private String bin03Old;
	private String bin04Old;
	private String bin05Old;
	private String bin06Old;
	private String bin07Old;
	private String bin08Old;
	private String bin09Old;
	private String bin0AOld;
	private String bin0BOld;
	private String bin0COld;
	private String bin0DOld;
	private String bin0EOld;
	private String bin0FOld;
	private String bin0Old;
	private String bin1Old;
	private String bin2Old;
	private String bin3Old;
	private String bin4Old;
	private String bin5Old;
	private String bin6Old;
	private String bin7Old;
	private String bin8Old;
	private String bin9Old;
	private String binAOld;
	private String binBOld;
	private String binCOld;
	private String binDOld;
	private String binEOld;
	private String binFOld;	
	
	public BinTableRecord(String lineno) {
		this.lineno	= new SimpleStringProperty(lineno);
		this.bin00		= new SimpleStringProperty("");
		this.bin01		= new SimpleStringProperty("");
		this.bin02		= new SimpleStringProperty("");
		this.bin03		= new SimpleStringProperty("");
		this.bin04		= new SimpleStringProperty("");
		this.bin05		= new SimpleStringProperty("");
		this.bin06		= new SimpleStringProperty("");
		this.bin07		= new SimpleStringProperty("");
		this.bin08		= new SimpleStringProperty("");
		this.bin09		= new SimpleStringProperty("");
		this.bin0A		= new SimpleStringProperty("");
		this.bin0B		= new SimpleStringProperty("");
		this.bin0C		= new SimpleStringProperty("");
		this.bin0D		= new SimpleStringProperty("");
		this.bin0E		= new SimpleStringProperty("");
		this.bin0F		= new SimpleStringProperty("");
		this.binspace	= new SimpleStringProperty("");
		this.bin0		= new SimpleStringProperty("");
		this.bin1		= new SimpleStringProperty("");
		this.bin2		= new SimpleStringProperty("");
		this.bin3		= new SimpleStringProperty("");
		this.bin4		= new SimpleStringProperty("");
		this.bin5		= new SimpleStringProperty("");
		this.bin6		= new SimpleStringProperty("");
		this.bin7		= new SimpleStringProperty("");
		this.bin8		= new SimpleStringProperty("");
		this.bin9		= new SimpleStringProperty("");
		this.binA		= new SimpleStringProperty("");
		this.binB		= new SimpleStringProperty("");
		this.binC		= new SimpleStringProperty("");
		this.binD		= new SimpleStringProperty("");
		this.binE		= new SimpleStringProperty("");
		this.binF		= new SimpleStringProperty("");
		this.bin00Old	= "";
		this.bin01Old	= "";
		this.bin02Old	= "";
		this.bin03Old	= "";
		this.bin04Old	= "";
		this.bin05Old	= "";
		this.bin06Old	= "";
		this.bin07Old	= "";
		this.bin08Old	= "";
		this.bin09Old	= "";
		this.bin0AOld	= "";
		this.bin0BOld	= "";
		this.bin0COld	= "";
		this.bin0DOld	= "";
		this.bin0EOld	= "";
		this.bin0FOld	= "";
		this.bin0Old	= "";
		this.bin1Old	= "";
		this.bin2Old	= "";
		this.bin3Old	= "";
		this.bin4Old	= "";
		this.bin5Old	= "";
		this.bin6Old	= "";
		this.bin7Old	= "";
		this.bin8Old	= "";
		this.bin9Old	= "";
		this.binAOld	= "";
		this.binBOld	= "";
		this.binCOld	= "";
		this.binDOld	= "";
		this.binEOld	= "";
		this.binFOld	= "";
	}
	
	public BinTableRecord(	String lineno, 
							String bin00, 
							String bin01, 
							String bin02,
							String bin03, 
							String bin04, 
							String bin05, 
							String bin06, 
							String bin07, 
							String bin08, 
							String bin09, 
							String bin0A, 
							String bin0B, 
							String bin0C,
							String bin0D, 
							String bin0E, 
							String bin0F,
							String binspace,
							String bin0, 
							String bin1, 
							String bin2,
							String bin3, 
							String bin4, 
							String bin5, 
							String bin6, 
							String bin7, 
							String bin8, 
							String bin9, 
							String binA, 
							String binB, 
							String binC,
							String binD, 
							String binE, 
							String binF) {
		this.lineno		= new SimpleStringProperty(lineno);
		this.bin00		= new SimpleStringProperty(bin00);
		this.bin01		= new SimpleStringProperty(bin01);
		this.bin02		= new SimpleStringProperty(bin02);
		this.bin03		= new SimpleStringProperty(bin03);
		this.bin04		= new SimpleStringProperty(bin04);
		this.bin05		= new SimpleStringProperty(bin05);
		this.bin06		= new SimpleStringProperty(bin06);
		this.bin07		= new SimpleStringProperty(bin07);
		this.bin08		= new SimpleStringProperty(bin08);
		this.bin09		= new SimpleStringProperty(bin09);
		this.bin0A		= new SimpleStringProperty(bin0A);
		this.bin0B		= new SimpleStringProperty(bin0B);
		this.bin0C		= new SimpleStringProperty(bin0C);
		this.bin0D		= new SimpleStringProperty(bin0D);
		this.bin0E		= new SimpleStringProperty(bin0E);
		this.bin0F		= new SimpleStringProperty(bin0F);
		this.binspace	= new SimpleStringProperty(binspace);
		this.bin0		= new SimpleStringProperty(bin0);
		this.bin1		= new SimpleStringProperty(bin1);
		this.bin2		= new SimpleStringProperty(bin2);
		this.bin3		= new SimpleStringProperty(bin3);
		this.bin4		= new SimpleStringProperty(bin4);
		this.bin5		= new SimpleStringProperty(bin5);
		this.bin6		= new SimpleStringProperty(bin6);
		this.bin7		= new SimpleStringProperty(bin7);
		this.bin8		= new SimpleStringProperty(bin8);
		this.bin9		= new SimpleStringProperty(bin9);
		this.binA		= new SimpleStringProperty(binA);
		this.binB		= new SimpleStringProperty(binB);
		this.binC		= new SimpleStringProperty(binC);
		this.binD		= new SimpleStringProperty(binD);
		this.binE		= new SimpleStringProperty(binE);
		this.binF		= new SimpleStringProperty(binF);
		this.bin00Old	= "";
		this.bin01Old	= "";
		this.bin02Old	= "";
		this.bin03Old	= "";
		this.bin04Old	= "";
		this.bin05Old	= "";
		this.bin06Old	= "";
		this.bin07Old	= "";
		this.bin08Old	= "";
		this.bin09Old	= "";
		this.bin0AOld	= "";
		this.bin0BOld	= "";
		this.bin0COld	= "";
		this.bin0DOld	= "";
		this.bin0EOld	= "";
		this.bin0FOld	= "";
		this.bin0Old	= "";
		this.bin1Old	= "";
		this.bin2Old	= "";
		this.bin3Old	= "";
		this.bin4Old	= "";
		this.bin5Old	= "";
		this.bin6Old	= "";
		this.bin7Old	= "";
		this.bin8Old	= "";
		this.bin9Old	= "";
		this.binAOld	= "";
		this.binBOld	= "";
		this.binCOld	= "";
		this.binDOld	= "";
		this.binEOld	= "";
		this.binFOld	= "";
	}
	
	public StringProperty linenoProperty() {
		return lineno;
	}

	public void setLineno(String lineno) {
		this.lineno = new SimpleStringProperty(lineno);
	}

	public StringProperty bin00Property() {
		return bin00;
	}

	public void setBin00(String bin00) {
		this.bin00 = new SimpleStringProperty(bin00);
	}

	public StringProperty bin01Property() {
		return bin01;
	}

	public void setBin01(String bin01) {
		this.bin01 = new SimpleStringProperty(bin01);
	}

	public StringProperty bin02Property() {
		return bin02;
	}

	public void setBin02(String bin02) {
		this.bin02 = new SimpleStringProperty(bin02);
	}

	public StringProperty bin03Property() {
		return bin03;
	}

	public void setBin03(String bin03) {
		this.bin03 = new SimpleStringProperty(bin03);
	}

	public StringProperty bin04Property() {
		return bin04;
	}

	public void setBin04(String bin04) {
		this.bin04 = new SimpleStringProperty(bin04);
	}

	public StringProperty bin05Property() {
		return bin05;
	}

	public void setBin05(String bin05) {
		this.bin05 = new SimpleStringProperty(bin05);
	}

	public StringProperty bin06Property() {
		return bin06;
	}

	public void setBin06(String bin06) {
		this.bin06 = new SimpleStringProperty(bin06);
	}

	public StringProperty bin07Property() {
		return bin07;
	}

	public void setBin07(String bin07) {
		this.bin07 = new SimpleStringProperty(bin07);
	}

	public StringProperty bin08Property() {
		return bin08;
	}

	public void setBin08(String bin08) {
		this.bin08 = new SimpleStringProperty(bin08);
	}

	public StringProperty bin09Property() {
		return bin09;
	}

	public void setBin09(String bin09) {
		this.bin09 = new SimpleStringProperty(bin09);
	}

	public StringProperty bin0AProperty() {
		return bin0A;
	}

	public void setBin0A(String bin0A) {
		this.bin0A = new SimpleStringProperty(bin0A);
	}

	public StringProperty bin0BProperty() {
		return bin0B;
	}

	public void setBin0B(String bin0B) {
		this.bin0B = new SimpleStringProperty(bin0B);
	}

	public StringProperty bin0CProperty() {
		return bin0C;
	}

	public void setBin0C(String bin0C) {
		this.bin0C = new SimpleStringProperty(bin0C);
	}

	public StringProperty bin0DProperty() {
		return bin0D;
	}

	public void setBin0D(String bin0D) {
		this.bin0D = new SimpleStringProperty(bin0D);
	}

	public StringProperty bin0EProperty() {
		return bin0E;
	}

	public void setBin0E(String bin0E) {
		this.bin0E = new SimpleStringProperty(bin0E);
	}

	public StringProperty bin0FProperty() {
		return bin0F;
	}

	public void setBin0F(String bin0F) {
		this.bin0F = new SimpleStringProperty(bin0F);
	}
	
	public StringProperty binspaceProperty() {
		return binspace;
	}

	public void setBinspace(String binspace) {
		this.binspace = new SimpleStringProperty(binspace);
	}	
	
	public StringProperty bin0Property() {
		return bin0;
	}

	public void setBin0(String bin0) {
		this.bin0 = new SimpleStringProperty(bin0);
	}

	public StringProperty bin1Property() {
		return bin1;
	}

	public void setBin1(String bin1) {
		this.bin1 = new SimpleStringProperty(bin1);
	}

	public StringProperty bin2Property() {
		return bin2;
	}

	public void setBin2(String bin2) {
		this.bin2 = new SimpleStringProperty(bin2);
	}

	public StringProperty bin3Property() {
		return bin3;
	}

	public void setBin3(String bin3) {
		this.bin3 = new SimpleStringProperty(bin3);
	}

	public StringProperty bin4Property() {
		return bin4;
	}

	public void setBin4(String bin4) {
		this.bin4 = new SimpleStringProperty(bin4);
	}

	public StringProperty bin5Property() {
		return bin5;
	}

	public void setBin5(String bin5) {
		this.bin5 = new SimpleStringProperty(bin5);
	}

	public StringProperty bin6Property() {
		return bin6;
	}

	public void setBin6(String bin6) {
		this.bin6 = new SimpleStringProperty(bin6);
	}

	public StringProperty bin7Property() {
		return bin7;
	}

	public void setBin7(String bin7) {
		this.bin7 = new SimpleStringProperty(bin7);
	}

	public StringProperty bin8Property() {
		return bin8;
	}

	public void setBin8(String bin8) {
		this.bin8 = new SimpleStringProperty(bin8);
	}

	public StringProperty bin9Property() {
		return bin9;
	}

	public void setBin9(String bin9) {
		this.bin9 = new SimpleStringProperty(bin9);
	}

	public StringProperty binAProperty() {
		return binA;
	}

	public void setBinA(String binA) {
		this.binA = new SimpleStringProperty(binA);
	}

	public StringProperty binBProperty() {
		return binB;
	}

	public void setBinB(String binB) {
		this.binB = new SimpleStringProperty(binB);
	}

	public StringProperty binCProperty() {
		return binC;
	}

	public void setBinC(String binC) {
		this.binC = new SimpleStringProperty(binC);
	}

	public StringProperty binDProperty() {
		return binD;
	}

	public void setBinD(String binD) {
		this.binD = new SimpleStringProperty(binD);
	}

	public StringProperty binEProperty() {
		return binE;
	}

	public void setBinE(String binE) {
		this.binE = new SimpleStringProperty(binE);
	}

	public StringProperty binFProperty() {
		return binF;
	}

	public void setBinF(String binF) {
		this.binF = new SimpleStringProperty(binF);
	}
	
	public String getBinData(int index) {

		if(index == 0) {
			return bin00.getValue();
		}else if(index == 1) {
			return bin01.getValue();
		}else if(index == 2) {
			return bin02.getValue();
		}else if(index == 3) {
			return bin03.getValue();
		}else if(index == 4) {
			return bin04.getValue();
		}else if(index == 5) {
			return bin05.getValue();
		}else if(index == 6) {
			return bin06.getValue();
		}else if(index == 7) {
			return bin07.getValue();
		}else if(index == 8) {
			return bin08.getValue();
		}else if(index == 9) {
			return bin09.getValue();
		}else if(index == 10) {
			return bin0A.getValue();
		}else if(index == 11) {
			return bin0B.getValue();
		}else if(index == 12) {
			return bin0C.getValue();
		}else if(index == 13) {
			return bin0D.getValue();
		}else if(index == 14) {
			return bin0E.getValue();
		}else if(index == 15) {
			return bin0F.getValue();
		}else {
			return null;
		}
	}
	
	public int getBlankColumnStartBinNumber(){
		
		if(bin00.getValue().equals("")){
			return 0;
		}else if(bin01.getValue().equals("")){
			return 1;
		}else if(bin02.getValue().equals("")){
			return 2;
		}else if(bin03.getValue().equals("")){
			return 3;
		}else if(bin04.getValue().equals("")){
			return 4;
		}else if(bin05.getValue().equals("")){
			return 5;
		}else if(bin06.getValue().equals("")){
			return 6;
		}else if(bin07.getValue().equals("")){
			return 7;
		}else if(bin08.getValue().equals("")){
			return 8;
		}else if(bin09.getValue().equals("")){
			return 9;
		}else if(bin0A.getValue().equals("")){
			return 10;
		}else if(bin0B.getValue().equals("")){
			return 11;
		}else if(bin0C.getValue().equals("")){
			return 12;
		}else if(bin0D.getValue().equals("")){
			return 13;
		}else if(bin0E.getValue().equals("")){
			return 14;
		}else if(bin0F.getValue().equals("")){
			return 15;
		}else{
			return 16;
		}

	}
	
	public String getBin00Old() {
		return bin00Old;
	}

	public void setBin00Old(String bin00Old) {
		this.bin00Old = bin00Old;
	}

	public String getBin01Old() {
		return bin01Old;
	}

	public void setBin01Old(String bin01Old) {
		this.bin01Old = bin01Old;
	}

	public String getBin02Old() {
		return bin02Old;
	}

	public void setBin02Old(String bin02Old) {
		this.bin02Old = bin02Old;
	}

	public String getBin03Old() {
		return bin03Old;
	}

	public void setBin03Old(String bin03Old) {
		this.bin03Old = bin03Old;
	}

	public String getBin04Old() {
		return bin04Old;
	}

	public void setBin04Old(String bin04Old) {
		this.bin04Old = bin04Old;
	}

	public String getBin05Old() {
		return bin05Old;
	}

	public void setBin05Old(String bin05Old) {
		this.bin05Old = bin05Old;
	}

	public String getBin06Old() {
		return bin06Old;
	}

	public void setBin06Old(String bin06Old) {
		this.bin06Old = bin06Old;
	}

	public String getBin07Old() {
		return bin07Old;
	}

	public void setBin07Old(String bin07Old) {
		this.bin07Old = bin07Old;
	}

	public String getBin08Old() {
		return bin08Old;
	}

	public void setBin08Old(String bin08Old) {
		this.bin08Old = bin08Old;
	}

	public String getBin09Old() {
		return bin09Old;
	}

	public void setBin09Old(String bin09Old) {
		this.bin09Old = bin09Old;
	}

	public String getBin0AOld() {
		return bin0AOld;
	}

	public void setBin0AOld(String bin0aOld) {
		bin0AOld = bin0aOld;
	}

	public String getBin0BOld() {
		return bin0BOld;
	}

	public void setBin0BOld(String bin0bOld) {
		bin0BOld = bin0bOld;
	}

	public String getBin0COld() {
		return bin0COld;
	}

	public void setBin0COld(String bin0cOld) {
		bin0COld = bin0cOld;
	}

	public String getBin0DOld() {
		return bin0DOld;
	}

	public void setBin0DOld(String bin0dOld) {
		bin0DOld = bin0dOld;
	}

	public String getBin0EOld() {
		return bin0EOld;
	}

	public void setBin0EOld(String bin0eOld) {
		bin0EOld = bin0eOld;
	}

	public String getBin0FOld() {
		return bin0FOld;
	}

	public void setBin0FOld(String bin0fOld) {
		bin0FOld = bin0fOld;
	}
	
	public String getBin0OldData(int index) {

		if(index == 0) {
			return bin00Old;
		}else if(index == 1) {
			return bin01Old;
		}else if(index == 2) {
			return bin02Old;
		}else if(index == 3) {
			return bin03Old;
		}else if(index == 4) {
			return bin04Old;
		}else if(index == 5) {
			return bin05Old;
		}else if(index == 6) {
			return bin06Old;
		}else if(index == 7) {
			return bin07Old;
		}else if(index == 8) {
			return bin08Old;
		}else if(index == 9) {
			return bin09Old;
		}else if(index == 10) {
			return bin0AOld;
		}else if(index == 11) {
			return bin0BOld;
		}else if(index == 12) {
			return bin0COld;
		}else if(index == 13) {
			return bin0DOld;
		}else if(index == 14) {
			return bin0EOld;
		}else if(index == 15) {
			return bin0FOld;
		}else {
			return null;
		}
	}
	
	public String getBin0Old() {
		return bin0Old;
	}

	public void setBin0Old(String bin0Old) {
		this.bin0Old = bin0Old;
	}

	public String getBin1Old() {
		return bin1Old;
	}

	public void setBin1Old(String bin1Old) {
		this.bin1Old = bin1Old;
	}

	public String getBin2Old() {
		return bin2Old;
	}

	public void setBin2Old(String bin2Old) {
		this.bin2Old = bin2Old;
	}

	public String getBin3Old() {
		return bin3Old;
	}

	public void setBin3Old(String bin3Old) {
		this.bin3Old = bin3Old;
	}

	public String getBin4Old() {
		return bin4Old;
	}

	public void setBin4Old(String bin4Old) {
		this.bin4Old = bin4Old;
	}

	public String getBin5Old() {
		return bin5Old;
	}

	public void setBin5Old(String bin5Old) {
		this.bin5Old = bin5Old;
	}

	public String getBin6Old() {
		return bin6Old;
	}

	public void setBin6Old(String bin6Old) {
		this.bin6Old = bin6Old;
	}

	public String getBin7Old() {
		return bin7Old;
	}

	public void setBin7Old(String bin7Old) {
		this.bin7Old = bin7Old;
	}

	public String getBin8Old() {
		return bin8Old;
	}

	public void setBin8Old(String bin8Old) {
		this.bin8Old = bin8Old;
	}

	public String getBin9Old() {
		return bin9Old;
	}

	public void setBin9Old(String bin9Old) {
		this.bin9Old = bin9Old;
	}

	public String getBinAOld() {
		return binAOld;
	}

	public void setBinAOld(String binAOld) {
		this.binAOld = binAOld;
	}

	public String getBinBOld() {
		return binBOld;
	}

	public void setBinBOld(String binBOld) {
		this.binBOld = binBOld;
	}

	public String getBinCOld() {
		return binCOld;
	}

	public void setBinCOld(String binCOld) {
		this.binCOld = binCOld;
	}

	public String getBinDOld() {
		return binDOld;
	}

	public void setBinDOld(String binDOld) {
		this.binDOld = binDOld;
	}

	public String getBinEOld() {
		return binEOld;
	}

	public void setBinEOld(String binEOld) {
		this.binEOld = binEOld;
	}

	public String getBinFOld() {
		return binFOld;
	}

	public void setBinFOld(String binFOld) {
		this.binFOld = binFOld;
	}
	
	public String getBinOldData(int index) {

		if(index == 0) {
			return bin0Old;
		}else if(index == 1) {
			return bin1Old;
		}else if(index == 2) {
			return bin2Old;
		}else if(index == 3) {
			return bin3Old;
		}else if(index == 4) {
			return bin4Old;
		}else if(index == 5) {
			return bin5Old;
		}else if(index == 6) {
			return bin6Old;
		}else if(index == 7) {
			return bin7Old;
		}else if(index == 8) {
			return bin8Old;
		}else if(index == 9) {
			return bin9Old;
		}else if(index == 10) {
			return binAOld;
		}else if(index == 11) {
			return binBOld;
		}else if(index == 12) {
			return binCOld;
		}else if(index == 13) {
			return binDOld;
		}else if(index == 14) {
			return binEOld;
		}else if(index == 15) {
			return binFOld;
		}else {
			return null;
		}
	}

}
