package myproject.application.eplusviewer;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EPlusViewerTreeTableRecord {
	
	private StringProperty check;
	private StringProperty name;
	private StringProperty raw;
	private StringProperty rva;
	private StringProperty lma;
	private StringProperty offset;
	private StringProperty size;
	private StringProperty value;
	private StringProperty analysis;
	private StringProperty notes;

	public EPlusViewerTreeTableRecord(String name,
								  String raw,
								  String rva,
								  String lma,
								  String offset,
								  String size,
								  String value,
								  String analysis,
								  String notes) {
		this.check		= new SimpleStringProperty("");
		this.name		= new SimpleStringProperty(name);
		this.raw		= new SimpleStringProperty(raw);
		this.rva		= new SimpleStringProperty(rva);
		this.lma		= new SimpleStringProperty(lma);
		this.offset		= new SimpleStringProperty(offset);
		this.size		= new SimpleStringProperty(size);
		this.value		= new SimpleStringProperty(value);
		this.analysis	= new SimpleStringProperty(analysis);
		this.notes		= new SimpleStringProperty(notes);
	}
	
	public EPlusViewerTreeTableRecord(String name,
			  String raw,
			  String rva,
			  String offset,
			  String size,
			  String value,
			  String analysis,
			  String notes) {
		this.check		= new SimpleStringProperty("");
		this.name		= new SimpleStringProperty(name);
		this.raw		= new SimpleStringProperty(raw);
		this.rva		= new SimpleStringProperty(rva);
		this.lma		= new SimpleStringProperty("");
		this.offset		= new SimpleStringProperty(offset);
		this.size		= new SimpleStringProperty(size);
		this.value		= new SimpleStringProperty(value);
		this.analysis	= new SimpleStringProperty(analysis);
		this.notes		= new SimpleStringProperty(notes);
	}
	
	public EPlusViewerTreeTableRecord(String name,
								  String raw,
								  String offset,
								  String size,
								  String value,
								  String analysis,
								  String notes) {
		this.check		= new SimpleStringProperty("");
		this.name		= new SimpleStringProperty(name);
		this.raw		= new SimpleStringProperty(raw);
		this.rva		= new SimpleStringProperty("");
		this.lma		= new SimpleStringProperty("");
		this.offset		= new SimpleStringProperty(offset);
		this.size		= new SimpleStringProperty(size);
		this.value		= new SimpleStringProperty(value);
		this.analysis	= new SimpleStringProperty(analysis);
		this.notes		= new SimpleStringProperty(notes);
	}
	
	public StringProperty checkProperty() {
		return check;
	}
	
	public void setCheck(String check) {
		this.check = new SimpleStringProperty(check);
	}

	public String getCheck() {
		return check.getValue();
	}
	
	public StringProperty nameProperty() {
		return name;
	}
	
	public void setName(String name) {
		this.name = new SimpleStringProperty(name);
	}

	public String getName() {
		return name.getValue();
	}
	
	public StringProperty rawProperty() {
		return raw;
	}
	
	public void setRaw(String raw) {
		this.raw = new SimpleStringProperty(raw);
	}
	
	public String getRaw() {
		return raw.getValue();
	}
	
	public StringProperty rvaProperty() {
		return rva;
	}
	
	public void setRVA(String rva) {
		this.rva = new SimpleStringProperty(rva);
	}
	
	public String getRVA() {
		return rva.getValue();
	}
	
	public StringProperty lmaProperty() {
		return lma;
	}
	
	public void setLMA(String lma) {
		this.lma = new SimpleStringProperty(lma);
	}
	
	public String getLMA() {
		return lma.getValue();
	}
	
	public StringProperty offsetProperty() {
		return offset;
	}
	
	public void setOffset(String offset) {
		this.offset = new SimpleStringProperty(offset);
	}
	
	public String getOffset() {
		return offset.getValue();
	}
	
	public StringProperty sizeProperty() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = new SimpleStringProperty(size);
	}
	
	public String getSize() {
		return size.getValue();
	}
	
	public StringProperty valueProperty() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = new SimpleStringProperty(value);
	}
	
	public String getValue() {
		return value.getValue();
	}
	
	public StringProperty analysisProperty() {
		return analysis;
	}
	
	public void setAnalysis(String analysis) {
		this.analysis = new SimpleStringProperty(analysis);
	}
	
	public String getAnalysis() {
		return analysis.getValue();
	}
	
	public StringProperty notesProperty() {
		return notes;
	}
	
	public void setNotes(String notes) {
		this.notes = new SimpleStringProperty(notes);
	}

	public String getNotes() {
		return notes.getValue();
	}
	
}
