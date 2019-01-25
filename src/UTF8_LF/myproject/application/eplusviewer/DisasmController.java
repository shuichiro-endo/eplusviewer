package myproject.application.eplusviewer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.DefaultStringConverter;

public class DisasmController implements Initializable {

	//FXML
	@FXML
	private TextArea idDisasmConsole;
	
	@FXML
	private Label idDisasmLabelFormat;
	
	@FXML
	private Label idDisasmLabelMachine;
	
	@FXML
	private Label idDisasmLabelSyntax;
	
	@FXML
	private Label idDisasmLabelEndian;
	
	@FXML
	private Label idDisasmLabelStartAddress;
	
	@FXML
	private Label idDisasmLabelStopAddress;
	
	@FXML
	private Label idDisasmLabelSection;
	
	@FXML
	private RadioButton idDisasmFormatBinary;
	
	@FXML
	private RadioButton idDisasmMachineI386;
	
	@FXML
	private RadioButton idDisasmMachineX8664;
	
	@FXML
	private RadioButton idDisasmSyntaxIntel;
	
	@FXML
	private RadioButton idDisasmSyntaxATT;
	
	@FXML
	private RadioButton idDisasmEndianLittle;
	
	@FXML
	private RadioButton idDisasmEndianBig;
	
	@FXML
	private TextField idDisasmStartAddress;
	
	@FXML
	private TextField idDisasmStopAddress;
	
	@FXML
	private TextField idDisasmSection;
	
	@FXML
	private Button idDisasmOk;
	
	@FXML
	private Button idDisasmClose;
	
	
	private ApplicationController ac		= null;
	private Stage disasmstage				= null;

	//ToggleGroup
	private ToggleGroup formatTg	= null;
	private ToggleGroup machineTg	= null;
	private ToggleGroup syntaxTg	= null;
	private ToggleGroup endianTg	= null;
	
	
	public DisasmController(Stage disasmstage, ApplicationController ac){
		this.disasmstage	= disasmstage;
		this.ac				= ac;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		//初期化
		formatTg	= new ToggleGroup();
		machineTg	= new ToggleGroup();
		syntaxTg	= new ToggleGroup();
		endianTg	= new ToggleGroup();
		
//		idDisasmFormatBinary.setToggleGroup(formatTg);
		idDisasmMachineI386.setToggleGroup(machineTg);
		idDisasmMachineX8664.setToggleGroup(machineTg);
		idDisasmSyntaxIntel.setToggleGroup(syntaxTg);
		idDisasmSyntaxATT.setToggleGroup(syntaxTg);
		idDisasmEndianLittle.setToggleGroup(endianTg);
		idDisasmEndianBig.setToggleGroup(endianTg);
		
		idDisasmFormatBinary.setUserData("binary");
		idDisasmMachineI386.setUserData("i386");
		idDisasmMachineX8664.setUserData("x86-64");
		idDisasmSyntaxIntel.setUserData("intel");
		idDisasmSyntaxATT.setUserData("at&t");
		idDisasmEndianLittle.setUserData("little");
		idDisasmEndianBig.setUserData("big");
		
//		formatTg.selectToggle(idDisasmFormatBinary);
		machineTg.selectToggle(idDisasmMachineI386);
		syntaxTg.selectToggle(idDisasmSyntaxIntel);
		endianTg.selectToggle(idDisasmEndianLittle);

	}

	
	@FXML
	protected void onDisasmOk(ActionEvent evt) {
	
		//初期処理
		ac.setConsoleClear();
		idDisasmConsole.clear();
		
		String command				= "";
		String inputBinFilePath		= ac.getInputBinFilePath();
		
//		String selectedFotmatTg		= (String)formatTg.getSelectedToggle().getUserData();
		String selectedMachineTg	= (String)machineTg.getSelectedToggle().getUserData();
		String selectedSyntaxTg		= (String)syntaxTg.getSelectedToggle().getUserData();
		String selectedEndianTg		= (String)endianTg.getSelectedToggle().getUserData();
		
		String strStartAddress		= idDisasmStartAddress.getText();
		String strStopAddress		= idDisasmStopAddress.getText();
		String strSection			= idDisasmSection.getText();
		Pattern p					= Pattern.compile("^[0-9A-F]{8}$");
		Pattern p2					= Pattern.compile("^\\.[0-9a-zA-Z_]+$");
		int startRaw				= 0;
		int stopRaw					= 0;
		int binTableLastByteNum		= ac.getBinTableLastByteNum();
		
		String OS_NAME		= System.getProperty("os.name").toLowerCase();
		
		
		if(OS_NAME.startsWith("windows")){
			command					= "objdump -D ";
			String argFormat		= "";
			String argMachine		= "";
			String argSyntax		= "";
			String argEndian		= "";
			String argStartAddress	= "";
			String argStopAddress	= "";
			String argSection		= "";
			
			if(idDisasmFormatBinary.isSelected()){
				argFormat	= "binary";
				command		+= "-b binary ";
			}
			
			if(selectedMachineTg.equals("i386")){
				argMachine	= "i386";
				command		+= "-m i386 ";
			}else if(selectedMachineTg.equals("x86-64")){
				argMachine	= "i386:x86-64";
				command		+= "-m i386:x86-64 ";
			}
			
			if(selectedSyntaxTg.equals("intel")){
				argSyntax	= "intel";
				command		+= "-M intel ";
			}else if(selectedSyntaxTg.equals("at&t")){
				argSyntax	= "att";
				command		+= "-M att ";
			}
			
			if(selectedEndianTg.equals("little")){
				argEndian	= "--endian=little";
				command		+= "--endian=little ";
			}else if(selectedEndianTg.equals("big")){
				argEndian	= "--endian=big";
				command		+= "--endian=big ";
			}
			
			if(strStartAddress.length()==0 || strStartAddress.length()==8){
				Matcher startm	= p.matcher(strStartAddress);
				if(startm.find()){
					startRaw	= ac.getStringToInt(strStartAddress, false);
					if(startRaw < binTableLastByteNum){
						argStartAddress	= "--start-address=0x"+strStartAddress;
						command			+= "--start-address=0x"+strStartAddress+" ";
					}
				}
			}else{
				idDisasmConsole.setText("Please enter start-address in 8 hex characters.");
				return;
			}

			if(strStopAddress.length()==0 || strStopAddress.length()==8){
				Matcher stopm	= p.matcher(strStopAddress);
				if(stopm.find()){
					stopRaw	= ac.getStringToInt(strStopAddress, false);
					if(stopRaw > startRaw && stopRaw < binTableLastByteNum){
						argStopAddress	= "--stop-address=0x"+strStopAddress;
						command			+= "--stop-address=0x"+strStopAddress+" ";
					}
				}
			}else{
				idDisasmConsole.setText("Please enter stop-address in 8 hex characters.");
				return;
			}
			
			Matcher sectionm	= p2.matcher(strSection);
			if(strSection.startsWith(".") && sectionm.find()){
				argSection	= strSection;
				command		+= "-j "+strSection+" ";
			}else if(!strSection.equals("")){
				idDisasmConsole.setText("Please enter section name that begin with a dot.");
				return;
			}

			command	+= inputBinFilePath;
			
			ProcessBuilder pb	= null;
			if(argFormat.equals("binary")){
				pb	= new ProcessBuilder("CMD.EXE", "/C", 
										 "objdump",
										 "-D",
										 "-b", argFormat,
										 "-m", argMachine,
										 "-M", argSyntax,
										 argEndian,
										 argStartAddress,
										 argStopAddress,
										 inputBinFilePath
										 );
			}else{
				pb	= new ProcessBuilder("CMD.EXE", "/C", 
						 				 "objdump",
						 				 "-D",
						 				 "-m", argMachine,
						 				 "-M", argSyntax,
						 				 argEndian,
						 				 "-j", argSection,
						 				 inputBinFilePath);
			}

			String output	= executeCommandWindows(pb);
			String disasmText	= ">"+"CMD.EXE /C "+command+"\n"+output;
			idDisasmConsole.setText(disasmText);	
		}else{
			command	= "objdump -D ";
			
			if(idDisasmFormatBinary.isSelected()){
				command	+= "-b binary ";
			}
			
			if(selectedMachineTg.equals("i386")){
				command	+= "-m i386 ";
			}else if(selectedMachineTg.equals("x86-64")){
				command	+= "-m i386:x86-64 ";
			}
			
			if(selectedSyntaxTg.equals("intel")){
				command	+= "-M intel ";
			}else if(selectedSyntaxTg.equals("at&t")){
				command	+= "-M att ";
			}
			
			if(selectedEndianTg.equals("little")){
				command	+= "--endian=little ";
			}else if(selectedEndianTg.equals("big")){
				command	+= "--endian=big ";
			}
			
			if(strStartAddress.length()==0 || strStartAddress.length()==8){
				Matcher startm	= p.matcher(strStartAddress);
				if(startm.find()){
					startRaw	= ac.getStringToInt(strStartAddress, false);
					if(startRaw < binTableLastByteNum){
						command	+= "--start-address=0x"+strStartAddress+" ";
					}
				}
			}else{
				idDisasmConsole.setText("Please enter start-address in 8 hex characters.");
				return;
			}

			if(strStopAddress.length()==0 || strStopAddress.length()==8){
				Matcher stopm	= p.matcher(strStopAddress);
				if(stopm.find()){
					stopRaw	= ac.getStringToInt(strStopAddress, false);
					if(stopRaw > startRaw && stopRaw < binTableLastByteNum){
						command	+= "--stop-address=0x"+strStopAddress+" ";
					}
				}
			}else{
				idDisasmConsole.setText("Please enter stop-address in 8 hex characters.");
				return;
			}
			
			Matcher sectionm	= p2.matcher(strSection);
			if(strSection.startsWith(".") && sectionm.find()){
				command		+= "-j "+strSection+" ";
			}else if(!strSection.equals("")){
				idDisasmConsole.setText("Please enter section name that begin with a dot.");
				return;
			}
			
			command	+= inputBinFilePath;
			
			String output	= executeCommandLinux(command);
			String disasmText	= ">"+command+"\n"+output;
			idDisasmConsole.setText(disasmText);
		}
	}
	
	private String executeCommandWindows(ProcessBuilder pb){
		
		StringBuffer output = new StringBuffer();
		Process p			= null;
		
		try{
			p	= pb.start();
//			p.waitFor();
			BufferedReader reader	= new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line	= "";
			while((line=reader.readLine())!=null){
				output.append(line+"\n");
			}
		}catch(Exception e){
			String message	= "An error occured.";	
			ac.setConsoleMessage(message);
				
			String alertType				= "ERROR";
			String title					= "ERROR";
			String headerText				= "ERROR";
			String contentText				= "An error occured.";
			StringWriter sw	= new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String expandableContentText	= sw.toString();
			
			ac.alertMessageBox(alertType, title, headerText, contentText, expandableContentText);
		}
		
		return output.toString();
	}
	
	private String executeCommandLinux(String command){
		
		StringBuffer output = new StringBuffer();
		Process p			= null;
		
		try{			
			p	= Runtime.getRuntime().exec(command);
//			p.waitFor();
			BufferedReader reader	= new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line	= "";
			while((line=reader.readLine())!=null){
				output.append(line+"\n");
			}
		}catch(Exception e){
			String message	= "An error occured.";	
			ac.setConsoleMessage(message);
				
			String alertType				= "ERROR";
			String title					= "ERROR";
			String headerText				= "ERROR";
			String contentText				= "An error occured.";
			StringWriter sw	= new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String expandableContentText	= sw.toString();
			
			ac.alertMessageBox(alertType, title, headerText, contentText, expandableContentText);
		}
		
		return output.toString();
	}

	@FXML
	protected void onDisasmClose(ActionEvent evt) {
		disasmstage.close();
	}
	
}
