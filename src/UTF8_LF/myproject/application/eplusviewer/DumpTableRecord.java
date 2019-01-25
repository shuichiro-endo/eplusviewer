package myproject.application.eplusviewer;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DumpTableRecord {

	private StringProperty no;
	private StringProperty startRaw;
	private StringProperty endRaw;
	private StringProperty size;
	private BooleanProperty zeroDump;
	
	public DumpTableRecord(String no) {
		this.no			= new SimpleStringProperty(no);
		this.startRaw	= new SimpleStringProperty("00000000");
		this.endRaw		= new SimpleStringProperty("00000000");
		this.size		= new SimpleStringProperty("00000000");	
		this.zeroDump	= new SimpleBooleanProperty(false);
	}
	
	public StringProperty noProperty() {
		return no;
	}

	public void setNo(String no) {
		this.no = new SimpleStringProperty(no);
	}
	
	public String getNo(){
		return no.getValue();
	}

	public StringProperty startRawProperty() {
		return startRaw;
	}

	public void setStartRaw(String startRaw) {
		this.startRaw = new SimpleStringProperty(startRaw);
	}
	
	public String getStartRaw(){
		return startRaw.getValue();
	}

	public StringProperty endRawProperty() {
		return endRaw;
	}

	public void setEndRaw(String endRaw) {
		this.endRaw = new SimpleStringProperty(endRaw);
	}
	
	public String getEndRaw(){
		return endRaw.getValue();
	}
	
	public StringProperty sizeProperty() {
		return size;
	}

	public void setSize(String size) {
		this.size = new SimpleStringProperty(size);
	}
	
	public String getSize(){
		return size.getValue();
	}
	
	public BooleanProperty zeroDumpProperty() {
		return zeroDump;
	}
	
	public void setZeroDump(boolean zeroDump) {
		this.zeroDump	= new SimpleBooleanProperty(zeroDump);
	}
	
	public boolean getZeroDump(){
		return zeroDump.getValue();
	}
}
