package myproject.application.eplusviewer;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.DefaultStringConverter;

public class DumpController implements Initializable {

	//FXML
	@FXML
	private TableView<DumpTableRecord> idDumpTable;
	
	@FXML
	private TableColumn<DumpTableRecord, String> idDumpNo;
	
	@FXML
	private TableColumn<DumpTableRecord, String> idDumpStartRaw;
	
	@FXML
	private TableColumn<DumpTableRecord, String> idDumpEndRaw;	
	
	@FXML
	private TableColumn<DumpTableRecord, String> idDumpSize;
	
	@FXML
	private TableColumn<DumpTableRecord, Boolean> idDump00Dump;
	
	@FXML
	private Button idDumpOk;
	
	@FXML
	private Button idDumpCancel;
	
	
	private ApplicationController ac		= null;
	private Stage dumpstage					= null;
	private FileChooser fileExportChooser	= new FileChooser();
	private ObservableList<DumpTableRecord> dumpTableRecordList = FXCollections.observableArrayList();
//	private ObservableList<DumpTableRecord> dumpTableRecordList = FXCollections.observableArrayList(
//																	new Callback<DumpTableRecord, Observable[]>(){
//																		@Override
//																		public Observable[] call(DumpTableRecord record){
//																			return new Observable[]{record.zeroDumpProperty()};
//																	}});	
	
	public DumpController(Stage dumpstage, ApplicationController ac){
		this.dumpstage	= dumpstage;
		this.ac			= ac;
		fileExportChooser.setTitle("Dump Export");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		//初期化
		dumpTableRecordList.clear();
		
		//1レコード目
		DumpTableRecord	record01	= new DumpTableRecord(String.format("%02d", 1));
		dumpTableRecordList.add(record01);
		
		//2レコード目
		DumpTableRecord	record02	= new DumpTableRecord(String.format("%02d", 2));
		dumpTableRecordList.add(record02);
		
		//3レコード目
		DumpTableRecord	record03	= new DumpTableRecord(String.format("%02d", 3));
		dumpTableRecordList.add(record03);
		
		//4レコード目
		DumpTableRecord	record04	= new DumpTableRecord(String.format("%02d", 4));
		dumpTableRecordList.add(record04);
		
		//5レコード目
		DumpTableRecord	record05	= new DumpTableRecord(String.format("%02d", 5));
		dumpTableRecordList.add(record05);
		
		//6レコード目
		DumpTableRecord	record06	= new DumpTableRecord(String.format("%02d", 6));
		dumpTableRecordList.add(record06);
		
		//7レコード目
		DumpTableRecord	record07	= new DumpTableRecord(String.format("%02d", 7));
		dumpTableRecordList.add(record07);
		
		//8レコード目
		DumpTableRecord	record08	= new DumpTableRecord(String.format("%02d", 8));
		dumpTableRecordList.add(record08);
		
		//9レコード目
		DumpTableRecord	record09	= new DumpTableRecord(String.format("%02d", 9));
		dumpTableRecordList.add(record09);
		
		//10レコード目
		DumpTableRecord	record10	= new DumpTableRecord(String.format("%02d", 10));
		dumpTableRecordList.add(record10);
		
		//
		idDumpNo.setCellValueFactory(new PropertyValueFactory<DumpTableRecord, String>("no"));
		idDumpStartRaw.setCellValueFactory(new PropertyValueFactory<DumpTableRecord, String>("startRaw"));
		idDumpEndRaw.setCellValueFactory(new PropertyValueFactory<DumpTableRecord, String>("endRaw"));
		idDumpSize.setCellValueFactory(new PropertyValueFactory<DumpTableRecord, String>("size"));
		idDump00Dump.setCellValueFactory(new PropertyValueFactory<DumpTableRecord, Boolean>("zeroDump"));

		idDumpStartRaw.setCellFactory(
				new Callback<TableColumn<DumpTableRecord, String>, TableCell<DumpTableRecord, String>>(){
					@Override
					public TableCell<DumpTableRecord, String> call(TableColumn<DumpTableRecord, String> record) {	
						return new TextFieldTableCell<DumpTableRecord, String>(new DefaultStringConverter());
					}});	
		idDumpStartRaw.setOnEditCommit(new EventHandler<CellEditEvent<DumpTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<DumpTableRecord, String> t) {
				
				String newData			= t.getNewValue();
				Pattern p				= Pattern.compile("^[0-9A-F]{8}$");
				DumpTableRecord	record	= t.getRowValue();
				
				if(!record.getStartRaw().equals(newData) && newData.length()==8){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						int startRaw			= ac.getStringToInt(newData, false);
						int endRaw				= ac.getStringToInt(record.getEndRaw(), false);
						int size				= 0;
						boolean zerodump		= record.getZeroDump();
						int binTableLastByteNum = ac.getBinTableLastByteNum();

						//バイナリテーブルのサイズを超えていないか
						if(startRaw < binTableLastByteNum && !zerodump){
							record.setStartRaw(newData);
							if(endRaw>=startRaw){
								size	= endRaw-startRaw+1;
								record.setSize(String.format("%08X", size));;
							}
						}else{
							record.setStartRaw("00000000");
						}
					}else{
						record.setStartRaw("00000000");
					}
				}
				//再表示
				idDumpTable.refresh();
			}
		});	

		idDumpEndRaw.setCellFactory(
				new Callback<TableColumn<DumpTableRecord, String>, TableCell<DumpTableRecord, String>>(){
					@Override
					public TableCell<DumpTableRecord, String> call(TableColumn<DumpTableRecord, String> record) {	
						return new TextFieldTableCell<DumpTableRecord, String>(new DefaultStringConverter());
					}});
		idDumpEndRaw.setOnEditCommit(new EventHandler<CellEditEvent<DumpTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<DumpTableRecord, String> t) {
				
				String newData			= t.getNewValue();
				Pattern p				= Pattern.compile("^[0-9A-F]{8}$");
				DumpTableRecord	record	= t.getRowValue();

				if(!record.getEndRaw().equals(newData) && newData.length()==8){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						int startRaw			= ac.getStringToInt(record.getStartRaw(), false);
						int endRaw				= ac.getStringToInt(newData, false);
						int size				= 0;
						boolean zerodump		= record.getZeroDump();
						int binTableLastByteNum = ac.getBinTableLastByteNum();
											
						//バイナリテーブルのサイズを超えていないか
						if(endRaw < binTableLastByteNum && !zerodump){
							record.setEndRaw(newData);
							if(endRaw>=startRaw){
								size	= endRaw-startRaw+1;
								record.setSize(String.format("%08X", size));
							}
						}else{
							record.setEndRaw("00000000");
						}
					}else{
						record.setEndRaw("00000000");
					}
				}
				//再表示
				idDumpTable.refresh();
			}
		});	
		
		idDumpSize.setCellFactory(
				new Callback<TableColumn<DumpTableRecord, String>, TableCell<DumpTableRecord, String>>(){
					@Override
					public TableCell<DumpTableRecord, String> call(TableColumn<DumpTableRecord, String> record) {	
						return new TextFieldTableCell<DumpTableRecord, String>(new DefaultStringConverter());
					}});
		idDumpSize.setOnEditCommit(new EventHandler<CellEditEvent<DumpTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<DumpTableRecord, String> t) {
				
				String newData			= t.getNewValue();
				Pattern p				= Pattern.compile("^[0-9A-F]{8}$");
				DumpTableRecord	record	= t.getRowValue();
				
				if(!record.getSize().equals(newData) && newData.length()==8){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						int startRaw			= ac.getStringToInt(record.getStartRaw(), false);
						int endRaw				= ac.getStringToInt(record.getEndRaw(), false);
						int size				= ac.getStringToInt(newData, false);
						boolean zerodump		= record.getZeroDump();
						int binTableLastByteNum = ac.getBinTableLastByteNum();
											
						//バイナリテーブルのサイズを超えていないか
						if(startRaw+size-1 < binTableLastByteNum && !zerodump){
							record.setSize(newData);
							if(size!=0 && endRaw!=startRaw+size-1){
								endRaw	= startRaw+size-1;
								record.setEndRaw(String.format("%08X", endRaw));
							}
						}else if(zerodump){
							record.setSize(newData);					
							//startRawとEndRawをリセット
							record.setStartRaw("00000000");
							record.setEndRaw("00000000");
						}else{
							record.setSize("00000000");
						}
					}else{
						record.setSize("00000000");
					}
				}
				//再表示
				idDumpTable.refresh();
			}
		});	
		
		idDump00Dump.setCellFactory(CheckBoxTableCell.forTableColumn(idDump00Dump));
		
		
//		idDump00Dump.setCellFactory(new Callback<TableColumn<DumpTableRecord, Boolean>, TableCell<DumpTableRecord, Boolean>>(){
//		@Override
//		public TableCell<DumpTableRecord, Boolean> call(TableColumn<DumpTableRecord, Boolean> record) {
//			return new ZeroDumpCheckBoxTableCell();
//		}});
//	
//		idDump00Dump.setCellFactory(new Callback<TableColumn<DumpTableRecord, Boolean>, TableCell<DumpTableRecord, Boolean>>(){
//			@Override
//			public TableCell<DumpTableRecord, Boolean> call(TableColumn<DumpTableRecord, Boolean> record) {
//				final CheckBoxTableCell<DumpTableRecord, Boolean> cell = new CheckBoxTableCell<>();				
//				final BooleanProperty selected = new SimpleBooleanProperty();
//				cell.setSelectedStateCallback(new Callback<Integer, ObservableValue<Boolean>>(){
//					@Override
//					public ObservableValue<Boolean> call(Integer index){
//						return selected;
//					}
//				});
//				selected.addListener(new ChangeListener<Boolean>(){
//					@Override
//					public void changed(ObservableValue<? extends Boolean> obs, Boolean wasSelected, Boolean isSelected){					
//						int cellrow				= cell.getTableRow().getIndex();							
//						DumpTableRecord record	= (DumpTableRecord)cell.getTableView().getItems().get(cellrow);
//						if(isSelected){
//							record.setZeroDump(true);
//							//startRawとEndRawをリセット
//							record.setStartRaw("00000000");
//							record.setEndRaw("00000000");	
////							System.out.println(record.getZeroDump());
//						}
//						//再表示
//						idDumpTable.refresh();
//					}});				
//				return cell;
//		}});
		
		idDumpTable.setItems(dumpTableRecordList);	
			
//		idDumpTable.setEditable(true);
//		idDumpStartRaw.setEditable(true);
//		idDumpEndRaw.setEditable(true);
//		idDumpSize.setEditable(true);
	}
	
//	public class ZeroDumpCheckBoxTableCell extends CheckBoxTableCell<DumpTableRecord, Boolean> {
//		public ZeroDumpCheckBoxTableCell() {
//			super();
//		}
//		
//		@Override
//		public void updateItem(Boolean item, boolean empty){
//			super.updateItem(item, empty);
//			if(item != null){
//				int cellrow				= getTableRow().getIndex();							
//				DumpTableRecord record	= getTableView().getItems().get(cellrow);
//				if(record.getZeroDump()){
//					//record.setZeroDump(true);
//					//startRawとEndRawをリセット
//					record.setStartRaw("00000000");
//					record.setEndRaw("00000000");	
//					
//					//再表示
//					idDumpTable.refresh();
//				}
//			}
//		}
//	}
	
	@FXML
	protected void onDumpOk(ActionEvent evt) {
	
		ac.setConsoleClear();
		
		int binTableSize	= ac.getBinTableLastByteNum();
		
		if(binTableSize!=0){
		
			File outputBinFile	= fileExportChooser.showSaveDialog(dumpstage);
			
			if(outputBinFile!=null){
				
				try{
					
					FileOutputStream fos		= new FileOutputStream(outputBinFile);
					BufferedOutputStream bos	= new BufferedOutputStream(fos);
					
					int totalDumpSize		= 0;
					DumpTableRecord	record	= null;
					Iterator<DumpTableRecord> dumpTableRecordList_Iterator	= dumpTableRecordList.iterator();
					
					while(dumpTableRecordList_Iterator.hasNext()){
						record			= (DumpTableRecord)dumpTableRecordList_Iterator.next();	
						totalDumpSize  += ac.getStringToInt(record.getSize(), false);
					}
							
					int startRaw		= 0;
					int size			= 0;
					boolean zerodump	= false;
					ByteBuffer byteBuf	= ByteBuffer.allocate(totalDumpSize);
					
					dumpTableRecordList_Iterator = dumpTableRecordList.iterator();
					
					while(dumpTableRecordList_Iterator.hasNext()){
						record		= (DumpTableRecord)dumpTableRecordList_Iterator.next();	
						startRaw	= ac.getStringToInt(record.getStartRaw(), false);
						size		= ac.getStringToInt(record.getSize(), false);
						zerodump	= record.getZeroDump();
						
						if(size>0){
							byte[] data	= null;
							if(zerodump){
								data = new byte[size];
								for(int i=0; i<size; i++){
									data[i] = 0x00;
								}
							}else{
								data	= ac.getBintableBytes(startRaw, size);
							}
							byteBuf.put(data);
						}
					}

					byte[] outputData	= byteBuf.array();				
					bos.write(outputData);
					
					bos.flush();
					bos.close();
					
				}catch(Exception e){
					
					String message	= "An error occured.";	
//					message.concat("Please look at the error file(error.txt).");
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
			}else{
				ac.setConsoleMessage("Please select a file to export.");
				return;
			}			
		}else{
			ac.setConsoleMessage("There are no export data.");
			return;
		}		
		
		dumpstage.close();
	}

	@FXML
	protected void onDumpCancel(ActionEvent evt) {
		dumpstage.close();
	}
	
}
