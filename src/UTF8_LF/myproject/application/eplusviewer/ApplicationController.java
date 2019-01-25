package myproject.application.eplusviewer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.xml.bind.DatatypeConverter;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;

import javafx.stage.Stage;
import javafx.stage.FileChooser;

import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.DefaultStringConverter;
import myproject.application.eplusviewer.BinTableRecord;
import myproject.application.eplusviewer.EPlusViewerTreeTableRecord;


public class ApplicationController implements Initializable {

	//FXML
	@FXML
	private MenuItem idFileOpen;
	
	@FXML
	private MenuItem idFileExport;
	
	@FXML
	private MenuItem idReadMe;
	
	@FXML
	private MenuItem idInputKey;
	
	@FXML
	private TableView<BinTableRecord> idBinTable;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBinLineNo;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin00;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin01;	
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin02;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin03;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin04;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin05;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin06;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin07;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin08;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin09;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin0A;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin0B;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin0C;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin0D;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin0E;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin0F;

	@FXML
	private TableColumn<BinTableRecord, String> idBinSpace;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin0;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin1;	
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin2;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin3;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin4;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin5;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin6;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin7;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin8;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin9;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBinA;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBinB;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBinC;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBinD;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBinE;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBinF;	
	
	@FXML
	private Button idRerun;
	
	@FXML
	private Button idDump;
	
	@FXML
	private Button idDisasm;
	
	@FXML
	private TextArea idConsole;
	
	@FXML
	private TreeTableView<EPlusViewerTreeTableRecord> idEPlusViewerTreeTableView;
	
	@FXML
	private TreeTableColumn<EPlusViewerTreeTableRecord, String> idEPlusViewerTreeTableColumnName;
	
	@FXML
	private TreeTableColumn<EPlusViewerTreeTableRecord, String> idEPlusViewerTreeTableColumnCheck;
	
	@FXML
	private TreeTableColumn<EPlusViewerTreeTableRecord, String> idEPlusViewerTreeTableColumnRaw;
	
	@FXML
	private TreeTableColumn<EPlusViewerTreeTableRecord, String> idEPlusViewerTreeTableColumnRVA;
	
	@FXML
	private TreeTableColumn<EPlusViewerTreeTableRecord, String> idEPlusViewerTreeTableColumnLMA;
	
	@FXML
	private TreeTableColumn<EPlusViewerTreeTableRecord, String> idEPlusViewerTreeTableColumnOffset;
	
	@FXML
	private TreeTableColumn<EPlusViewerTreeTableRecord, String> idEPlusViewerTreeTableColumnSize;
	
	@FXML
	private TreeTableColumn<EPlusViewerTreeTableRecord, String> idEPlusViewerTreeTableColumnValue;

	@FXML
	private TreeTableColumn<EPlusViewerTreeTableRecord, String> idEPlusViewerTreeTableColumnAnalysis;
	
	@FXML
	private TreeTableColumn<EPlusViewerTreeTableRecord, String> idEPlusViewerTreeTableColumnNotes;
	
	
	//
	private Stage stage;
	private FileChooser fileOpenChooser		= new FileChooser();
	private FileChooser fileExportChooser	= new FileChooser();
	
	private ObservableList<BinTableRecord> binTableRecordList = FXCollections.observableArrayList();
	private ObservableList<EPlusViewerTreeTableRecord> ePlusViewerTreeTableRecordList = FXCollections.observableArrayList();
	
	//inputfile
	private String inputBinFilePath	= "";
	
	//root
	private String rootName		= "";
	private String rootRaw		= "00000000";
	private String rootOffset	= "00000000";
	private String rootSize		= "00000000";
	private String rootRVA		= "";
	private String rootValue	= "";
	private String rootAnalysis	= "";
	private String rootNotes	= "";
	private TreeItem<EPlusViewerTreeTableRecord> root;
	
	//notes
	//ELF_HEADER notes
	private String ELF_HEADER_Notes							= "";
	private String ELF_HEADER_e_ident_Notes					= "";
	private String ELF_HEADER_e_type_Notes					= "";
	private String ELF_HEADER_e_machine_Notes				= "";
	private String ELF_HEADER_e_version_Notes				= "";
	private String ELF_HEADER_e_entry_Notes					= "";
	private String ELF_HEADER_e_phoff_Notes					= "";
	private String ELF_HEADER_e_shoff_Notes					= "";
	private String ELF_HEADER_e_flags_Notes					= "";
	private String ELF_HEADER_e_ehsize_Notes				= "";
	private String ELF_HEADER_e_phentsize_Notes				= "";
	private String ELF_HEADER_e_phnum_Notes					= "";
	private String ELF_HEADER_e_shentsize_Notes				= "";
	private String ELF_HEADER_e_shnum_Notes					= "";
	private String ELF_HEADER_e_shstrndx_Notes				= "";
	
	//ELF_PROGRAM_HEADER notes
	private String ELF_PROGRAM_HEADER_Notes					= "";
	private String ELF_PROGRAM_HEADER_p_type_Notes			= "";
	private String ELF_PROGRAM_HEADER_p_offset_Notes		= "";
	private String ELF_PROGRAM_HEADER_p_vaddr_Notes			= "";
	private String ELF_PROGRAM_HEADER_p_paddr_Notes			= "";
	private String ELF_PROGRAM_HEADER_p_filesz_Notes		= "";
	private String ELF_PROGRAM_HEADER_p_memsz_Notes			= "";
	private String ELF_PROGRAM_HEADER_p_flags_Notes			= "";
	private String ELF_PROGRAM_HEADER_p_align_Notes			= "";
	
	//ELF_PROGRAM_DATA notes
	private String ELF_PROGRAM_DATA_Notes					= "";
	private String ELF_PROGRAM_DATA_path_Notes				= "";
	
	//
	private String ELF_DYNAMIC_Entry_Data_Notes				= "";
	
	//
	private String ELF_DYNAMIC_Entry_Addr_Array_Notes		= "";
	
	
	//ELF_SECTION_HEADER notes
	private String ELF_SECTION_HEADER_Notes					= "";	
	private String ELF_SECTION_HEADER_sh_name_Notes			= "";
	private String ELF_SECTION_HEADER_sh_type_Notes			= "";
	private String ELF_SECTION_HEADER_sh_flags_Notes		= "";
	private String ELF_SECTION_HEADER_sh_addr_Notes			= "";
	private String ELF_SECTION_HEADER_sh_offset_Notes		= "";
	private String ELF_SECTION_HEADER_sh_size_Notes			= "";
	private String ELF_SECTION_HEADER_sh_link_Notes			= "";
	private String ELF_SECTION_HEADER_sh_info_Notes			= "";
	private String ELF_SECTION_HEADER_sh_addralign_Notes	= "";
	private String ELF_SECTION_HEADER_sh_entsize_Notes		= "";
	
	//ELF_SECTION_DATA notes
	private String ELF_SECTION_DATA_Notes					= "";
	
	//ELF_NOTE notes
	private String ELF_NOTE_Notes							= "";
	private String ELF_NOTE_n_namesz_Notes					= "";
	private String ELF_NOTE_n_descsz_Notes					= "";
	private String ELF_NOTE_n_type_Notes					= "";
	private String ELF_NOTE_n_name_Notes					= "";
	private String ELF_NOTE_n_desc_Notes					= "";
	
	//ELF_DYNAMIC_ENTRY notes
	private String ELF_DYNAMIC_ENTRY_Notes					= "";
	private String ELF_DYNAMIC_ENTRY_d_tag_Notes			= "";
	private String ELF_DYNAMIC_ENTRY_d_val_Notes			= "";
	private String ELF_DYNAMIC_ENTRY_d_ptr_Notes			= "";
	
	//ELF_DYNAMIC_SYMBOL_NAME notes
	private String ELF_DYNAMIC_SYMBOL_NAME_Notes			= "";
	
	//ELF_RELOCATION_ADDEND_TABLE notes
	private String ELF_RELOCATION_ADDEND_TABLE_Notes			= "";
	private String ELF_RELOCATION_ADDEND_TABLE_r_offset_Notes	= "";
	private String ELF_RELOCATION_ADDEND_TABLE_r_info_Notes		= "";
	private String ELF_RELOCATION_ADDEND_TABLE_r_addend_Notes	= "";
	
	//ELF_RELOCATION_TABLE notes
	private String ELF_RELOCATION_TABLE_Notes					= "";
	private String ELF_RELOCATION_TABLE_r_offset_Notes			= "";
	private String ELF_RELOCATION_TABLE_r_info_Notes			= "";
	
	//ELF_SYMBOL_TABLE notes
	private String ELF_SYMBOL_TABLE_Notes					= "";
	private String ELF_SYMBOL_TABLE_st_name_Notes			= "";
	private String ELF_SYMBOL_TABLE_st_value_Notes			= "";
	private String ELF_SYMBOL_TABLE_st_size_Notes			= "";
	private String ELF_SYMBOL_TABLE_st_info_Notes			= "";
	private String ELF_SYMBOL_TABLE_st_other_Notes			= "";
	private String ELF_SYMBOL_TABLE_st_shndx_Notes			= "";
	
	//ELF_DYNAMIC_SYMBOL_TABLE notes
	private String ELF_DYNAMIC_SYMBOL_TABLE_Notes			= "";
	private String ELF_DYNAMIC_SYMBOL_TABLE_st_name_Notes	= "";
	private String ELF_DYNAMIC_SYMBOL_TABLE_st_value_Notes	= "";
	private String ELF_DYNAMIC_SYMBOL_TABLE_st_size_Notes	= "";
	private String ELF_DYNAMIC_SYMBOL_TABLE_st_info_Notes	= "";
	private String ELF_DYNAMIC_SYMBOL_TABLE_st_other_Notes	= "";
	private String ELF_DYNAMIC_SYMBOL_TABLE_st_shndx_Notes	= "";
		
	//ELF_STRING_TABLE_NAME notes
	private String ELF_STRING_TABLE_NAME_Notes				= "";
	
	//ELF_DYNAMIC_STRING_TABLE_NAME notes
	private String ELF_DYNAMIC_STRING_TABLE_NAME_Notes		= "";
	
	//R_offset_Addr notes
	private String R_offset_Addr_Notes						= "";
	
	//Data notes
	private String Data_Notes								= "";
	
	
	
	//サイズ定数
	private final static int UNSIGNED_CHAR_SIZE	= 0x1;
	private final static int ELF32_ADDR_SIZE	= 0x4;
	private final static int ELF32_HALF_SIZE	= 0x2;
	private final static int ELF32_OFF_SIZE		= 0x4;
	private final static int ELF32_SWORD_SIZE	= 0x4;
	private final static int ELF32_WORD_SIZE	= 0x4;
	private final static int ELF32_SECTION_SIZE	= 0x2;	
	private final static int ELF64_ADDR_SIZE	= 0x8;
	private final static int ELF64_HALF_SIZE	= 0x2;
	private final static int ELF64_SHALF_SIZE	= 0x2;
	private final static int ELF64_OFF_SIZE		= 0x8;
	private final static int ELF64_SWORD_SIZE	= 0x4;
	private final static int ELF64_WORD_SIZE	= 0x4;
	private final static int ELF64_SXWORD_SIZE	= 0x8;
	private final static int ELF64_XWORD_SIZE	= 0x8;
	private final static int ELF64_SECTION_SIZE	= 0x2;
	
	
	/*
	 * 定数
	 */
	//e_ident
	private final static int EI_NIDENT			= 16;
	private final static int EI_MAG0			= 0;
	private final static int EI_MAG1			= 1;
	private final static int EI_MAG2			= 2;
	private final static int EI_MAG3			= 3;
	private final static int EI_CLASS			= 4;
	private final static int EI_DATA			= 5;
	private final static int EI_VERSION			= 6;
	private final static int EI_OSABI			= 7;
	private final static int EI_PAD				= 8;
	private final static int ELFCLASSNONE		= 0;
	private final static int ELFCLASS32			= 1;
	private final static int ELFCLASS64			= 2;
	private final static int ELFCLASSNUM		= 3;
	private final static int ELFDATANONE		= 0;
	private final static int ELFDATA2LSB		= 1;
	private final static int ELFDATA2MSB		= 2;
	private final static int EV_NONE			= 0;
	private final static int EV_CURRENT			= 1;
	private final static int EV_NUM				= 2;
	private final static int ELFOSABI_NONE		= 0;
	private final static int ELFOSABI_LINUX		= 3;
	
	//e_type
	private final static int ET_NONE			= 0;
	private final static int ET_REL				= 1;
	private final static int ET_EXEC			= 2;
	private final static int ET_DYN				= 3;
	private final static int ET_CORE			= 4;
	private final static int ET_LOPROC			= 0xff00;
	private final static int ET_HIPROC			= 0xffff;
	
	//e_machine
	private final static int EM_NONE			= 0;
	private final static int EM_M32				= 1;
	private final static int EM_SPARC			= 2;
	private final static int EM_386				= 3;
	private final static int EM_68K				= 4;
	private final static int EM_88K				= 5;
	private final static int EM_486				= 6;
	private final static int EM_860				= 7;
	private final static int EM_MIPS			= 8;
//	private final static int EM_MIPS_RS3_LE		= 10;
	private final static int EM_MIPS_RS4_BE		= 10;
	private final static int EM_PARISC			= 15;
	private final static int EM_SPARC32PLUS		= 18;
	private final static int EM_PPC				= 20;
	private final static int EM_PPC64			= 21;
	private final static int EM_SPU				= 23;
	private final static int EM_ARM				= 40;
	private final static int EM_SH				= 42;
	private final static int EM_SPARCV9			= 43;
	private final static int EM_H8_300			= 46;
	private final static int EM_IA_64			= 50;
	private final static int EM_X86_64			= 62;
	private final static int EM_S390			= 22;
	private final static int EM_CRIS			= 76;
	private final static int EM_V850			= 87;
	private final static int EM_M32R			= 88;
	private final static int EM_MN10300			= 89;
	private final static int EM_OPENRISC		= 92;
	private final static int EM_BLACKFIN		= 106;
	private final static int EM_ALTERA_NIOS2	= 113;
	private final static int EM_TI_C6000		= 140;
	private final static int EM_AARCH64			= 183;
	private final static int EM_FRV				= 0x5441;
	private final static int EM_AVR32			= 0x18ad;
	private final static int EM_ALPHA			= 0x9026;
	private final static int EM_CYGNUS_V850		= 0x9080;
	private final static int EM_CYGNUS_M32R		= 0x9041;
	private final static int EM_S390_OLD		= 0xa390;
	private final static int EM_CTGNUS_MN10300	= 0xbeef;
	
	//p_type
	private final static int PT_NULL			= 0;
	private final static int PT_LOAD			= 1;
	private final static int PT_DYNAMIC			= 2;
	private final static int PT_INTERP			= 3;
	private final static int PT_NOTE			= 4;
	private final static int PT_SHLIB			= 5;
	private final static int PT_PHDR			= 6;
	private final static int PT_TLS				= 7;
	private final static int PT_LOOS			= 0x60000000;
	private final static int PT_HIOS			= 0x6fffffff;
	private final static int PT_LOPROC			= 0x70000000;
	private final static int PT_HIPROC			= 0x7fffffff;
	private final static int PT_GNU_EH_FRAME	= 0x6474e550;
	private final static int PT_GNU_STACK		= 0x6474e551;
	private final static int PT_GNU_RELRO		= 0x6474e552;
	
	//p_flags
	private final static int PF_R				= 0x4;
	private final static int PF_W				= 0x2;
	private final static int PF_X				= 0x1;
	
	//sh_type
	private final static int SHT_NULL			= 0;
	private final static int SHT_PROGBITS		= 1;
	private final static int SHT_SYMTAB			= 2;
	private final static int SHT_STRTAB			= 3;
	private final static int SHT_RELA			= 4;
	private final static int SHT_HASH			= 5;
	private final static int SHT_DYNAMIC		= 6;
	private final static int SHT_NOTE			= 7;
	private final static int SHT_NOBITS			= 8;
	private final static int SHT_REL			= 9;
	private final static int SHT_SHLIB			= 10;
	private final static int SHT_DYNSYM			= 11;
	private final static int SHT_INIT_ARRAY		= 14;
	private final static int SHT_FINI_ARRAY		= 15;		
	private final static int SHT_PREINIT_ARRAY	= 16;
	private final static int SHT_GROUP			= 17;
	private final static int SHT_SYMTAB_SHNDX	= 18;
	private final static int SHT_NUM			= 19;
	private final static int SHT_LOOS			= 0x60000000;
//	private final static int SHT_HIOS			= 0x6fffffff;
	private final static int SHT_GNU_HASH		= 0x6ffffff6;
	private final static int SHT_GNU_LIBLIST	= 0x6ffffff7;
	private final static int SHT_CHECKSUM		= 0x6ffffff8;
//	private final static int SHT_LOSUNW			= 0x6ffffffa;
	private final static int SHT_SUNW_MOVE		= 0x6ffffffa;
	private final static int SHT_SUNW_COMDAT	= 0x6ffffffb;
	private final static int SHT_SUNW_SYMINFO	= 0x6ffffffc;
	private final static int SHT_GNU_VERDEF		= 0x6ffffffd;
	private final static int SHT_GNU_VERNEED	= 0x6ffffffe;
	private final static int SHT_GNU_VERSYM		= 0x6fffffff;	
	private final static int SHT_LOPROC			= 0x70000000;
	private final static int SHT_HIPROC			= 0x7fffffff;
	private final static int SHT_LOUSER			= 0x80000000;
	private final static int SHT_HIUSER			= 0xffffffff;

	//sh_flags
	private final static int SHF_WRITE				= 0x1;
	private final static int SHF_ALLOC				= 0x2;
	private final static int SHF_EXECINSTR			= 0x4;
	private final static int SHF_MERGE				= 0x10;
	private final static int SHF_STRINGS			= 0x20;
	private final static int SHF_INFO_LINK			= 0x40;
	private final static int SHF_LINK_ORDER			= 0x80;
	private final static int SHF_OS_NONCONFORMING	= 0x100;
	private final static int SHF_GROUP				= 0x200;
	private final static int SHF_TLS				= 0x400;
	private final static int SHF_MASKOS				= 0x0ff00000;
	private final static int SHF_MASKPROC			= 0xf0000000;
	private final static int SHF_ORDERED			= 0x40000000;
	private final static int SHF_EXCLUDE			= 0x80000000;
	
	//r_info(Relocation Type)
	private final static int R_386_NONE				= 0;
	private final static int R_386_32				= 1;
	private final static int R_386_PC32				= 2;
	private final static int R_386_GOT32			= 3;
	private final static int R_386_PLT32			= 4;
	private final static int R_386_COPY				= 5;
	private final static int R_386_GLOB_DAT			= 6;
	private final static int R_386_JMP_SLOT			= 7;
	private final static int R_386_RELATIVE			= 8;
	private final static int R_386_GOTOFF			= 9;
	private final static int R_386_GOTPC			= 10;
	private final static int R_386_NUM				= 11;
	
	private final static int R_X86_64_NONE			= 0;
	private final static int R_X86_64_64			= 1;
	private final static int R_X86_64_PC32			= 2;
	private final static int R_X86_64_GOT32			= 3;
	private final static int R_X86_64_PLT32			= 4;
	private final static int R_X86_64_COPY			= 5;
	private final static int R_X86_64_GLOB_DAT		= 6;
	private final static int R_X86_64_JUMP_SLOT		= 7;
	private final static int R_X86_64_RELATIVE		= 8;
	private final static int R_X86_64_GOTPCREL		= 9;
	private final static int R_X86_64_32			= 10;
	private final static int R_X86_64_32S			= 11;
	private final static int R_X86_64_16			= 12;
	private final static int R_X86_64_PC16			= 13;
	private final static int R_X86_64_8				= 14;
	private final static int R_X86_64_PC8			= 15;
	private final static int R_X86_64_NUM			= 16;
	
	//st_info
	private final static int STB_LOCAL				= 0x0;
	private final static int STB_GLOBAL				= 0x1;
	private final static int STB_WEAK				= 0x2;
	private final static int STT_NOTYPE				= 0x0;
	private final static int STT_OBJECT				= 0x1;
	private final static int STT_FUNC				= 0x2;
	private final static int STT_SECTION			= 0x3;
	private final static int STT_FILE				= 0x4;
	private final static int STT_COMMON				= 0x5;
	private final static int STT_TLS				= 0x6;
	
	//st_shndx
	private final static int SHN_UNDEF				= 0x0;
	private final static int SHN_LORESERVE			= 0xff00;
	private final static int SHN_LOPROC				= 0xff00;
	private final static int SHN_BEFORE				= 0xff00;
	private final static int SHN_AFTER				= 0xff01;
	private final static int SHN_HIPROC				= 0xff1f;
	private final static int SHN_ABS				= 0xfff1;
	private final static int SHN_COMMON				= 0xfff2;
	private final static int SHN_HIRESERVE			= 0xffff;
	
	//d_tag
	private final static int DT_NULL				= 0;
	private final static int DT_NEEDED				= 1;
	private final static int DT_PLTRELSZ			= 2;
	private final static int DT_PLTGOT				= 3;
	private final static int DT_HASH				= 4;
	private final static int DT_STRTAB				= 5;
	private final static int DT_SYMTAB				= 6;
	private final static int DT_RELA				= 7;
	private final static int DT_RELASZ				= 8;
	private final static int DT_RELAENT				= 9;
	private final static int DT_STRSZ				= 10;
	private final static int DT_SYMENT				= 11;
	private final static int DT_INIT				= 12;
	private final static int DT_FINI				= 13;
	private final static int DT_SONAME				= 14;
	private final static int DT_RPATH				= 15;
	private final static int DT_SYMBOLIC			= 16;
	private final static int DT_REL					= 17;
	private final static int DT_RELSZ				= 18;
	private final static int DT_RELENT				= 19;
	private final static int DT_PLTREL				= 20;
	private final static int DT_DEBUG				= 21;
	private final static int DT_TEXTREL				= 22;
	private final static int DT_JMPREL				= 23;
	private final static int DT_BIND_NOW			= 24;
	private final static int DT_INIT_ARRAY			= 25;
	private final static int DT_FINI_ARRAY			= 26;
	private final static int DT_INIT_ARRAYSZ		= 27;
	private final static int DT_FINI_ARRAYSZ		= 28;
	private final static int DT_RUNPATH				= 29;
	private final static int DT_FLAGS				= 30;	
	private final static int DT_ENCODING			= 32;
	private final static int DT_PREINIT_ARRAY		= 32;
	private final static int DT_PREINIT_ARRAYSZ		= 33;
	private final static int OLD_DT_LOOS			= 0x60000000;
	private final static int DT_LOOS				= 0x6000000d;
	private final static int DT_HIOS				= 0x6ffff000;
	private final static int DT_VALRNGLO			= 0x6ffffd00;
	private final static int DT_VALRNGHI			= 0x6ffffdff;
	private final static int DT_ADDRRNGLO			= 0x6ffffe00;
	private final static int DT_ADDRRNGHI			= 0x6ffffeff;
	private final static int DT_VERSYM				= 0x6ffffff0;
	private final static int DT_RELACOUNT			= 0x6ffffff9;
	private final static int DT_RELCOUNT			= 0x6ffffffa;
	private final static int DT_FLAGS_1				= 0x6ffffffb;
	private final static int DT_VERDEF				= 0x6ffffffc;
	private final static int DT_VERDEFNUM			= 0x6ffffffd;
	private final static int DT_VERNEED				= 0x6ffffffe;
	private final static int DT_VERNEEDNUM			= 0x6fffffff;
	private final static int OLD_DT_HIOS			= 0x6fffffff;
	private final static int DT_LOPROC				= 0x70000000;
	private final static int DT_HIPROC				= 0x7fffffff;
	
	private final static int DT_GNU_PRELINKED		= 0x6ffffdf5;
	private final static int DT_GNU_CONFLICTSZ		= 0x6ffffdf6;
	private final static int DT_GNU_LIBLISTSZ		= 0x6ffffdf7;
	private final static int DT_GNU_HASH			= 0x6ffffef5;
	private final static int DT_GNU_CONFLICT		= 0x6ffffef8;
	private final static int DT_GNU_LIBLIST			= 0x6ffffef9;
	
//	private final static int DT_TLSDESC_PLT			= 0x6ffffef6;
//	private final static int DT_TLSDESC_GOT			= 0x6ffffef7;
//	private final static int DT_CONFIG				= 0x6ffffefa;
//	private final static int DT_DEPAUDIT			= 0x6ffffefb;
//	private final static int DT_AUDIT				= 0x6ffffefc;
//	private final static int DT_PLTPAD				= 0x6ffffefd;
//	private final static int DT_MOVETAB				= 0x6ffffefe;
//	private final static int DT_SYMINFO				= 0x6ffffeff;
//	private final static int DT_ADDRRNGHI			= 0x6ffffeff;
//	private final static int DT_AUXILIARY			= 0x7ffffffd;
//	private final static int DT_FILTER				= 0x7fffffff;
	
	
	
	/*
	 * 構造体サイズ
	 */
	//32bit
	private int ELF32_HDR_SIZE		= 0;
	private int ELF32_PHDR_SIZE		= 0;
	private int ELF32_SHDR_SIZE		= 0;
	private int ELF32_NOTE_SIZE		= 0;
	private int ELF32_SYM_SIZE		= 0;
	private int ELF32_SYMINFO_SIZE	= 0;
	private int ELF32_REL_SIZE		= 0;
	private int ELF32_RELA_SIZE		= 0;
	private int ELF32_DYN_SIZE		= 0;
	
	
	//64bit
	private int ELF64_HDR_SIZE		= 0;
	private int ELF64_PHDR_SIZE		= 0;
	private int ELF64_SHDR_SIZE		= 0;
	private int ELF64_NOTE_SIZE		= 0;
	private int ELF64_SYM_SIZE		= 0;
	private int ELF64_SYMINFO_SIZE	= 0;
	private int ELF64_REL_SIZE		= 0;
	private int ELF64_RELA_SIZE		= 0;
	private int ELF64_DYN_SIZE		= 0;
	
	
	
	//先頭アドレス
	private String ELF_HEADER_START_ADDR			= "";
	private String ELF_PROGRAM_HEADER_START_ADDR	= "";
	private String ELF_SECTION_HEADER_START_ADDR	= "";
	
	//エントリーポイント
	private String ELF_ENTRY_START_ADDR				= "";
	


	
	//テーブル数
	private int ELF_PHDR_NUM		= 0;
	private int ELF_SHDR_NUM		= 0;
	private int ELF_SHDR_STR_INDEX	= 0;
	
	//ELF情報
	private int ELFCLASS	= 0;
	private int ELFDATA		= 0;
	private int ELFVERSION	= 0;
	private int ELFOSABI	= 0;
	private int E_TYPE		= 0;
	
	//Item
	private TreeItem<EPlusViewerTreeTableRecord> ELF_PROGRAM_HEADER_TABLE_ITEM			= null;
	private TreeItem<EPlusViewerTreeTableRecord> ELF_SECTION_HEADER_TABLE_ITEM			= null;
	
	
	//各ヘッダーリスト
	private ArrayList<ProgramHeader> programHeaderList		= null;
	private ArrayList<SectionHeader> sectionHeaderList		= null;
	
	//ストリングテーブルリスト
	private ArrayList<String> stringTableList				= null;
	
	
	//残りデータ情報
	private String remainingDataRawAddr	= "";
	private int reaminingDataRawSize	= 0;
	
	//Magic number
	private String magicNumber	= "";
	
	//ハイライト用
	private int highlightStartAddr	= 0;
	private int highlightEndAddr	= 0;
	
	
	public ApplicationController(Stage stage) {
		this.stage = stage;
		fileOpenChooser.setTitle("File Open");
		fileExportChooser.setTitle("File Export");		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//機能停止
		idFileExport.setDisable(true);
		idBinTable.setEditable(false);
		idRerun.setDisable(true);
		idDump.setDisable(true);
		idDisasm.setDisable(true);
	}
	
	@FXML
	protected void onFileOpen(ActionEvent evt) {
		
		idConsole.clear();
		inputBinFilePath	= "";
		
		//バイナリテーブル表示
		boolean b	= binTableShow();
		
		//PE解析、表示
		if(b) {
			ePlusViewerTreeTableShow();
		}else {
			idConsole.setText("Please select a file to open.");
		}
	}
	
	@FXML
	protected void onFileExport(ActionEvent evt){
		
		idConsole.clear();
		
		int lastLineno	= binTableRecordList.size()-1;
		
		if(lastLineno>-1){
			
			int lastByteNum	= binTableRecordList.get(lastLineno).getBlankColumnStartBinNumber();	
			int byteCount	= lastLineno*16+lastByteNum;
			
//			System.out.println("lastLineno="+lastLineno);
//			System.out.println("lastByteNum="+lastByteNum);
//			System.out.println("byteCount="+byteCount);
			
			File outputBinFile	= fileExportChooser.showSaveDialog(stage);
			
			if(outputBinFile!=null){
				
				try{
					
					FileOutputStream fos		= new FileOutputStream(outputBinFile);
					BufferedOutputStream bos	= new BufferedOutputStream(fos);
					
					//出力データの作成
					byte[] outputData	= getBintableBytes(0, byteCount);
					
					bos.write(outputData);
					
					bos.flush();
					bos.close();
					
				}catch(Exception e){
					
					String message	= "An error occured.";	
//					message.concat("Please look at the error file(error.txt).");
					idConsole.setText(message);
					
					String alertType				= "ERROR";
					String title					= "ERROR";
					String headerText				= "ERROR";
					String contentText				= "An error occured.";
					StringWriter sw	= new StringWriter();
					e.printStackTrace(new PrintWriter(sw));
					String expandableContentText	= sw.toString();
				
					alertMessageBox(alertType, title, headerText, contentText, expandableContentText);					
				}
			}else{
				idConsole.setText("Please select a file to export.");
			}			
		}else{
			idConsole.setText("There are no export data.");
		}
	}
	
	@FXML
	protected void onMouseClickedEPlusViewerTreeTableView(MouseEvent evt) {
		
		TreeItem<EPlusViewerTreeTableRecord> item	= idEPlusViewerTreeTableView.getSelectionModel().getSelectedItem();

		if(item != null) {
			EPlusViewerTreeTableRecord record	= item.getValue();
			String strStartAddr				= record.getRaw();
			String strSize					= record.getSize();
			int startAddr					= 0;
			int size						= 0;
			int endAddr						= 0;	
			int lineno						= 0;
			
//			System.out.println("startAddr="+startAddr);
//			System.out.println("size="+size);
			
			//アドレスがあれば
			if(!strStartAddr.equals("") && !strSize.equals("00000000")){
				startAddr					= getStringToInt(strStartAddr, false);
				size						= getStringToInt(strSize, false);
				endAddr						= startAddr+size;		
				lineno						= startAddr/16;
				
				//行移動
				BinTableRecord binTableRecord 	= idBinTable.getItems().get(lineno);
				idBinTable.scrollTo(binTableRecord);
				
				//ハイライト
				highlightStartAddr	= startAddr;
				highlightEndAddr	= endAddr;			
				idBinTable.refresh();	
			
			}
		}		
	}
	
	@FXML
	protected void onClose(ActionEvent evt) {
		System.exit(0);
	}
	
	@FXML
	protected void onReadMe(ActionEvent evt) {
		
		String alertType				= "INFORMATION";
		String title					= "ReadMe";
		String headerText				= "E+Viewer";
		String contentText				= "";
		String expandableContentText	= "";
		String OS_NAME					= System.getProperty("os.name").toLowerCase();

		try {
			BufferedReader br	= null;				
			if(OS_NAME.startsWith("windows")){
				br	= new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("ReadMe_windows.txt")));
			}else{
				br	= new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("ReadMe_linux.txt")));
			}						
			String str	= "";
			
			while((str = br.readLine()) != null) {
				contentText	+= str;
				contentText	+= "\n";
			}

			br.close();
		}catch(Exception e) {
			String message	= "An error occured.";	
			idConsole.setText(message);
			StringWriter sw	= new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			alertMessageBox("ERROR", "ERROR", "ERROR", "An error occured.", sw.toString());
		}
		
		try {
			BufferedReader br	= null;	
			if(OS_NAME.startsWith("windows")){
				br	= new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("Manual_windows.txt")));			
			}else{
				br	= new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("Manual_linux.txt")));
			}
			String str	= "";
			
			while((str = br.readLine()) != null) {
				expandableContentText	+= str;
				expandableContentText	+= "\n";
			}

			br.close();
		}catch(Exception e) {
			String message	= "An error occured.";	
			idConsole.setText(message);
			StringWriter sw	= new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			alertMessageBox("ERROR", "ERROR", "ERROR", "An error occured.", sw.toString());
		}		
		
		alertMessageBox(alertType, title, headerText, contentText, expandableContentText);
		
	}
	
	@FXML
	protected void onInputKey(ActionEvent evt) {
		
		String title			= "Key Input";
		String headerText		= "Key Input";
		String contentText		= "Key:";
		String hash				= "2baf98674c17ac229b339e848376616f8344ead350a6887d0790dde50246a486";
		String potato			= "";
		
		TextInputDialog dialog	= new TextInputDialog();
		dialog.setTitle(title);
		dialog.setHeaderText(headerText);
		dialog.setContentText(contentText);	
		Optional<String> result = dialog.showAndWait();	
		
		if(result.isPresent()){
			potato				= toEncryptedHashValue("SHA-256", result.get());
			
			if(potato.equals(hash)){			
				//機能解放
				idFileExport.setDisable(false);
				idBinTable.setEditable(true);
				idRerun.setDisable(false);
				idDump.setDisable(false);
				idDisasm.setDisable(false);
			}
		}
	}
	
	@FXML
	protected void onRerun(ActionEvent evt){
		
		idConsole.clear();
		
		//解析、表示
		if(binTableRecordList.size()!=0) {
			ePlusViewerTreeTableShow();
		}

	}
	
	@FXML
	protected void onDump(ActionEvent evt){
		
		if(!binTableRecordList.isEmpty()){
			try {
				URL dumpfxml 		= getClass().getResource("layout_dump.fxml");
				FXMLLoader dumpldr 	= new FXMLLoader(dumpfxml, null);
				Stage dumpstage 	= new Stage();
				DumpController dc 	= new DumpController(dumpstage, this);
				dumpldr.setController(dc);
				Parent dumproot 	= dumpldr.load();
				dumpstage.setTitle("Data Dump");
				Scene dumpscene		= new Scene(dumproot);
				dumpscene.getStylesheets().add(getClass().getResource("application_dump.css").toExternalForm());
				dumpstage.setScene(dumpscene);
				dumpstage.show();
			}catch(Exception e) {
				String message	= "An error occured.";	
//				message.concat("Please look at the error file(error.txt).");
				idConsole.setText(message);
				
				String alertType				= "ERROR";
				String title					= "ERROR";
				String headerText				= "ERROR";
				String contentText				= "An error occured.";
				StringWriter sw	= new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String expandableContentText	= sw.toString();
			
				alertMessageBox(alertType, title, headerText, contentText, expandableContentText);
			}
		}
	}
	
	@FXML
	protected void onDisasm(ActionEvent evt){
		
		if(!binTableRecordList.isEmpty()){
			try {
				URL dumpfxml 			= getClass().getResource("layout_disasm.fxml");
				FXMLLoader disasmldr 	= new FXMLLoader(dumpfxml, null);
				Stage disasmstage 		= new Stage();
				DisasmController dc 	= new DisasmController(disasmstage, this);
				disasmldr.setController(dc);
				Parent disasmroot 		= disasmldr.load();
				disasmstage.setTitle("Disassemble");
				Scene disasmscene		= new Scene(disasmroot);
				disasmscene.getStylesheets().add(getClass().getResource("application_disasm.css").toExternalForm());
				disasmstage.setScene(disasmscene);
				disasmstage.show();
			}catch(Exception e) {
				String message	= "An error occured.";	
//				message.concat("Please look at the error file(error.txt).");
				idConsole.setText(message);
				
				String alertType				= "ERROR";
				String title					= "ERROR";
				String headerText				= "ERROR";
				String contentText				= "An error occured.";
				StringWriter sw	= new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String expandableContentText	= sw.toString();
			
				alertMessageBox(alertType, title, headerText, contentText, expandableContentText);
			}
		}
	}
	
	private boolean binTableShow() {
		
		try {
			File inputBinFile 		= fileOpenChooser.showOpenDialog(stage);
			
			if(inputBinFile == null) {
				return false;
			}
				
			FileInputStream fis 	= new FileInputStream(inputBinFile);
			BufferedInputStream bis = new BufferedInputStream(fis);	
			
			rootName				= inputBinFile.getName();
			inputBinFilePath			= inputBinFile.getPath();
			
			int rb 					= 0;
			int bytecount			= 0;
			int lineno				= 0;	
			String hexStr			= null;
			String charStr			= null;
			ByteBuffer buffer		= null;
			
			if(binTableRecordList.size() != 0 ) {
				binTableRecordList.clear();
			}
			
			if(ePlusViewerTreeTableRecordList.size() != 0) {
				ePlusViewerTreeTableRecordList.clear();
			}
			
			//1レコード目
			BinTableRecord	record	= new BinTableRecord(String.format("%08X", lineno));
			binTableRecordList.add(record);

			while((rb = bis.read()) != -1) {
				switch (bytecount) {
					case 0:
						//2レコード目以降
						if(lineno != 0){
							record	= new BinTableRecord(String.format("%08X", lineno));
							binTableRecordList.add(record);
							//System.out.println("lineno="+String.format("%08X", lineno));
						}
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", );
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						//charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
						charStr = Character.toString((char)(rb & 0xff));
						
						//System.out.println(hexStr);
						record.setBin00(hexStr);
						record.setBin0(charStr);
						
						//初期データ保存
						record.setBin00Old(hexStr);
						record.setBin0Old(charStr);
						
						bytecount++;
						
						//次レコードのため
						lineno += 16;
						break;
					case 1:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						//charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
						charStr = Character.toString((char)(rb & 0xff));
						
						//System.out.println(hexStr);
						record.setBin01(hexStr);	
						record.setBin1(charStr);
						
						//初期データ保存
						record.setBin01Old(hexStr);
						record.setBin1Old(charStr);
						
						bytecount++;
						break;
					case 2:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						//charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
						charStr = Character.toString((char)(rb & 0xff));
						
						//System.out.println(hexStr);
						record.setBin02(hexStr);
						record.setBin2(charStr);
						
						//初期データ保存
						record.setBin02Old(hexStr);
						record.setBin2Old(charStr);
						
						bytecount++;
						break;
					case 3:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						//charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
						charStr = Character.toString((char)(rb & 0xff));
						
						//System.out.println(hexStr);
						record.setBin03(hexStr);
						record.setBin3(charStr);
						
						//初期データ保存
						record.setBin03Old(hexStr);
						record.setBin3Old(charStr);
						
						bytecount++;
						break;
					case 4:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						//charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
						charStr = Character.toString((char)(rb & 0xff));
						
						//System.out.println(hexStr);
						record.setBin04(hexStr);
						record.setBin4(charStr);
						
						//初期データ保存
						record.setBin04Old(hexStr);
						record.setBin4Old(charStr);
						
						bytecount++;
						break;
					case 5:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						//charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
						charStr = Character.toString((char)(rb & 0xff));						
						
						//System.out.println(hexStr);
						record.setBin05(hexStr);
						record.setBin5(charStr);
						
						//初期データ保存
						record.setBin05Old(hexStr);
						record.setBin5Old(charStr);
						
						bytecount++;
						break;
					case 6:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						//charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
						charStr = Character.toString((char)(rb & 0xff));
						
						//System.out.println(hexStr);
						record.setBin06(hexStr);
						record.setBin6(charStr);
						
						//初期データ保存
						record.setBin06Old(hexStr);
						record.setBin6Old(charStr);
						
						bytecount++;
						break;
					case 7:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						//charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
						charStr = Character.toString((char)(rb & 0xff));
						
						//System.out.println(hexStr);
						record.setBin07(hexStr);
						record.setBin7(charStr);
						
						//初期データ保存
						record.setBin07Old(hexStr);
						record.setBin7Old(charStr);
						
						bytecount++;
						break;
					case 8:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						//charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
						charStr = Character.toString((char)(rb & 0xff));
						
						//System.out.println(hexStr);
						record.setBin08(hexStr);
						record.setBin8(charStr);
						
						//初期データ保存
						record.setBin08Old(hexStr);
						record.setBin8Old(charStr);
						
						bytecount++;
						break;
					case 9:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						//charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
						charStr = Character.toString((char)(rb & 0xff));
						
						//System.out.println(hexStr);
						record.setBin09(hexStr);
						record.setBin9(charStr);
						
						//初期データ保存
						record.setBin09Old(hexStr);
						record.setBin9Old(charStr);
						
						bytecount++;
						break;
					case 10:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						//charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
						charStr = Character.toString((char)(rb & 0xff));
						
						//System.out.println(hexStr);
						record.setBin0A(hexStr);
						record.setBinA(charStr);
						
						//初期データ保存
						record.setBin0AOld(hexStr);
						record.setBinAOld(charStr);
						
						bytecount++;
						break;
					case 11:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						//charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
						charStr = Character.toString((char)(rb & 0xff));
						
						//System.out.println(hexStr);
						record.setBin0B(hexStr);
						record.setBinB(charStr);
						
						//初期データ保存
						record.setBin0BOld(hexStr);
						record.setBinBOld(charStr);
						
						bytecount++;
						break;
					case 12:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						//charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
						charStr = Character.toString((char)(rb & 0xff));
						
						//System.out.println(hexStr);
						record.setBin0C(hexStr);
						record.setBinC(charStr);
						
						//初期データ保存
						record.setBin0COld(hexStr);
						record.setBinCOld(charStr);
						
						bytecount++;
						break;
					case 13:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						//charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
						charStr = Character.toString((char)(rb & 0xff));
						
						//System.out.println(hexStr);
						record.setBin0D(hexStr);
						record.setBinD(charStr);
						
						//初期データ保存
						record.setBin0DOld(hexStr);
						record.setBinDOld(charStr);
						
						bytecount++;
						break;
					case 14:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						//charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
						charStr = Character.toString((char)(rb & 0xff));
						
						//System.out.println(hexStr);
						record.setBin0E(hexStr);
						record.setBinE(charStr);
						
						//初期データ保存
						record.setBin0EOld(hexStr);
						record.setBinEOld(charStr);
						
						bytecount++;
						break;
					case 15:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						//charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
						charStr = Character.toString((char)(rb & 0xff));
						
						//System.out.println(hexStr);
						record.setBin0F(hexStr);
						record.setBinF(charStr);
						
						//初期データ保存
						record.setBin0FOld(hexStr);
						record.setBinFOld(charStr);
						
						bytecount = 0;
						break;
					default:
						break;			
				}				
			}

			bis.close();
			fis.close();
			
		} catch(Exception e) {
			
//			try{
//				StringWriter sw	= new StringWriter();
//				e.printStackTrace(new PrintWriter(sw));	
//				File errorFile			= new File("error.txt");
//				FileWriter fileWriter	= new FileWriter(errorFile);
//				fileWriter.write(sw.toString());
//				fileWriter.close();
//			}catch(Exception e2) {
//				e.printStackTrace();
//			}
		
			String message	= "An error occured.";	
//			message.concat("Please look at the error file(error.txt).");
			idConsole.setText(message);
			
			String alertType				= "ERROR";
			String title					= "ERROR";
			String headerText				= "ERROR";
			String contentText				= "An error occured.";
			StringWriter sw	= new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String expandableContentText	= sw.toString();
		
			alertMessageBox(alertType, title, headerText, contentText, expandableContentText);
								
		}

		idBinLineNo.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("lineno"));
		idBin00.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin00"));
		idBin01.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin01"));
		idBin02.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin02"));
		idBin03.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin03"));
		idBin04.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin04"));
		idBin05.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin05"));
		idBin06.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin06"));
		idBin07.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin07"));
		idBin08.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin08"));
		idBin09.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin09"));
		idBin0A.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin0A"));
		idBin0B.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin0B"));
		idBin0C.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin0C"));
		idBin0D.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin0D"));
		idBin0E.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin0E"));
		idBin0F.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin0F"));
//		idBinSpace.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("binspace"));
		idBin0.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin0"));
		idBin1.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin1"));
		idBin2.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin2"));
		idBin3.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin3"));
		idBin4.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin4"));
		idBin5.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin5"));
		idBin6.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin6"));
		idBin7.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin7"));
		idBin8.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin8"));
		idBin9.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin9"));
		idBinA.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("binA"));
		idBinB.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("binB"));
		idBinC.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("binC"));
		idBinD.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("binD"));
		idBinE.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("binE"));
		idBinF.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("binF"));
	
		idBin00.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin00(record.getBin00Old());
								record.setBin0(record.getBin0Old());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin00.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin00(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							//String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							String newCharData = Character.toString((char)(rb & 0xff));
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin0(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin01.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin01(record.getBin01Old());
								record.setBin1(record.getBin1Old());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin01.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin01(newData);
						
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							//String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							String newCharData = Character.toString((char)(rb & 0xff));
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin1(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
			
		idBin02.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin02(record.getBin02Old());
								record.setBin2(record.getBin2Old());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin02.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin02(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							//String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							String newCharData = Character.toString((char)(rb & 0xff));
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin2(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin03.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin03(record.getBin03Old());
								record.setBin3(record.getBin3Old());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin03.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin03(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							//String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							String newCharData = Character.toString((char)(rb & 0xff));
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin3(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin04.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin04(record.getBin04Old());
								record.setBin4(record.getBin4Old());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin04.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin04(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							//String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							String newCharData = Character.toString((char)(rb & 0xff));
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin4(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin05.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin05(record.getBin05Old());
								record.setBin5(record.getBin5Old());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin05.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin05(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							//String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							String newCharData = Character.toString((char)(rb & 0xff));
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin5(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin06.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin06(record.getBin06Old());
								record.setBin6(record.getBin6Old());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin06.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin06(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							//String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							String newCharData = Character.toString((char)(rb & 0xff));
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin6(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin07.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin07(record.getBin07Old());
								record.setBin7(record.getBin7Old());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin07.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin07(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							//String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							String newCharData = Character.toString((char)(rb & 0xff));
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin7(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin08.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin08(record.getBin08Old());
								record.setBin8(record.getBin8Old());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin08.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin08(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							//String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							String newCharData = Character.toString((char)(rb & 0xff));
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin8(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin09.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin09(record.getBin09Old());
								record.setBin9(record.getBin9Old());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin09.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin09(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							//String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							String newCharData = Character.toString((char)(rb & 0xff));
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin9(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin0A.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin0A(record.getBin0AOld());
								record.setBinA(record.getBinAOld());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin0A.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin0A(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							//String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							String newCharData = Character.toString((char)(rb & 0xff));
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBinA(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin0B.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin0B(record.getBin0BOld());
								record.setBinB(record.getBinBOld());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin0B.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin0B(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							//String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							String newCharData = Character.toString((char)(rb & 0xff));
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBinB(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin0C.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin0C(record.getBin0COld());
								record.setBinC(record.getBinCOld());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin0C.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin0C(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							//String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							String newCharData = Character.toString((char)(rb & 0xff));
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBinC(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin0D.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin0D(record.getBin0DOld());
								record.setBinD(record.getBinDOld());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin0D.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin0D(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							//String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							String newCharData = Character.toString((char)(rb & 0xff));
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBinD(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin0E.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin0E(record.getBin0EOld());
								record.setBinE(record.getBinEOld());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin0E.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin0E(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							//String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							String newCharData = Character.toString((char)(rb & 0xff));
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBinE(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin0F.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin0F(record.getBin0FOld());
								record.setBinF(record.getBinFOld());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin0F.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin0F(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							//String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							String newCharData = Character.toString((char)(rb & 0xff));
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBinF(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
//		idBinSpace.setCellFactory(
//				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
//					@Override
//					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
//						return new BinTableCell();
//					}});
		
		idBin0.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});
		idBin1.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});		
		idBin2.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});		
		idBin3.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});		
		idBin4.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});		
		idBin5.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});		
		idBin6.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});	
		idBin7.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});
		idBin8.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});
		idBin9.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});
		idBinA.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});
		idBinB.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});
		idBinC.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});
		idBinD.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});
		idBinE.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});
		idBinF.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});		
			
		idBinTable.setItems(binTableRecordList);		
		
		return true;
	}
	
	public class EditBinTableCell extends TextFieldTableCell<BinTableRecord, String> {
		
		EditBinTableCell(StringConverter<String> converter){
			super(converter);			
		}		
		
		@Override
		public void updateItem(String item, boolean empty) {
			super.updateItem(item, empty);
			
			int cellrow		= getTableRow().getIndex();
			int cellcolumn	= Integer.parseInt(getTableColumn().getText(), 16);		
			int cellno		= cellrow*16+cellcolumn;
						
//			System.out.println("cellno="+ Integer.toHexString(cellno));
//			System.out.println("highlightStartAddr="+ Integer.toHexString(highlightStartAddr));
//			System.out.println("highlightEndAddr="+ Integer.toHexString(highlightEndAddr));
			
			if(item != null) {
				if(cellno ==0 && highlightStartAddr == 0) {
					setText(item.toString());			
					getStyleClass().clear();
										
					if(binTableRecordList.get(cellrow).getBin0OldData(cellcolumn).equals(item.toString())){
						getStyleClass().add("bin-table-cell-highlight");
					}else {
						getStyleClass().add("bin-table-cell-highlight-change");
					}
				
				}else if(cellno >= highlightStartAddr && cellno < highlightEndAddr) {
					setText(item.toString());
					getStyleClass().clear();
					
					if(binTableRecordList.get(cellrow).getBin0OldData(cellcolumn).equals(item.toString())){
						getStyleClass().add("bin-table-cell-highlight");
					}else {
						getStyleClass().add("bin-table-cell-highlight-change");
					}

				}else {
					setText(item.toString());
					getStyleClass().clear();
					
					if(binTableRecordList.get(cellrow).getBin0OldData(cellcolumn).equals(item.toString())){
						getStyleClass().add("bin-table-cell");
					}else {
						getStyleClass().add("bin-table-cell-change");
					}					
				}
			}
		}
	};
	
	public class BinTableCell extends TableCell<BinTableRecord, String> {
		
		@Override
		public void updateItem(String item, boolean empty) {
			super.updateItem(item, empty);
			
			int cellrow		= getTableRow().getIndex();
			int cellcolumn	= Integer.parseInt(getTableColumn().getText(), 16);		
			int cellno		= cellrow*16+cellcolumn;
						
//			System.out.println("cellno="+ Integer.toHexString(cellno));
//			System.out.println("highlightStartAddr="+ Integer.toHexString(highlightStartAddr));
//			System.out.println("highlightEndAddr="+ Integer.toHexString(highlightEndAddr));
					
			if(item != null) {
				if(cellno ==0 && highlightStartAddr == 0) {
					setText(item.toString());			
					getStyleClass().clear();
										
					if(binTableRecordList.get(cellrow).getBinOldData(cellcolumn).equals(item.toString())){
						getStyleClass().add("bin-table-cell-highlight");
					}else {
						getStyleClass().add("bin-table-cell-highlight-change");
					}
				
				}else if(cellno >= highlightStartAddr && cellno < highlightEndAddr) {
					setText(item.toString());
					getStyleClass().clear();
					
					if(binTableRecordList.get(cellrow).getBinOldData(cellcolumn).equals(item.toString())){
						getStyleClass().add("bin-table-cell-highlight");
					}else {
						getStyleClass().add("bin-table-cell-highlight-change");
					}

				}else {
					setText(item.toString());
					getStyleClass().clear();
					
					if(binTableRecordList.get(cellrow).getBinOldData(cellcolumn).equals(item.toString())){
						getStyleClass().add("bin-table-cell");
					}else {
						getStyleClass().add("bin-table-cell-change");
					}	
				}
			}
		}
	};	
	
	private void ePlusViewerTreeTableShow() {
		
		/*
		 * データ初期化
		 */		
		//構造体サイズ
		ELF32_HDR_SIZE		= UNSIGNED_CHAR_SIZE*EI_NIDENT+ELF32_HALF_SIZE*8+ELF32_WORD_SIZE*2+ELF32_ADDR_SIZE+ELF32_OFF_SIZE*2;
		ELF32_PHDR_SIZE		= 0;
		ELF32_SHDR_SIZE		= 0;		
		ELF32_NOTE_SIZE		= ELF32_WORD_SIZE*3;		
		ELF32_SYM_SIZE		= UNSIGNED_CHAR_SIZE*2+ELF32_WORD_SIZE*2+ELF32_ADDR_SIZE+ELF32_SECTION_SIZE;
		ELF32_SYMINFO_SIZE	= ELF32_HALF_SIZE*2;
		ELF32_REL_SIZE		= ELF32_WORD_SIZE+ELF32_ADDR_SIZE;
		ELF32_RELA_SIZE		= ELF32_WORD_SIZE+ELF32_SWORD_SIZE+ELF32_ADDR_SIZE;
		ELF32_DYN_SIZE		= ELF32_SWORD_SIZE*2;
				
		ELF64_HDR_SIZE		= UNSIGNED_CHAR_SIZE*EI_NIDENT+ELF64_HALF_SIZE*8+ELF64_WORD_SIZE*2+ELF64_ADDR_SIZE+ELF64_OFF_SIZE*2;	
		ELF64_PHDR_SIZE		= 0;
		ELF64_SHDR_SIZE		= 0;	
		ELF64_NOTE_SIZE		= ELF64_WORD_SIZE*3;
		ELF64_SYM_SIZE		= UNSIGNED_CHAR_SIZE*2+ELF64_WORD_SIZE+ELF64_XWORD_SIZE+ELF64_ADDR_SIZE+ELF64_SECTION_SIZE;
		ELF64_SYMINFO_SIZE	= ELF64_HALF_SIZE*2;
		ELF64_REL_SIZE		= ELF64_XWORD_SIZE+ELF64_ADDR_SIZE;
		ELF64_RELA_SIZE		= ELF64_XWORD_SIZE+ELF64_SXWORD_SIZE+ELF64_ADDR_SIZE;
		ELF64_DYN_SIZE		= ELF64_SXWORD_SIZE+ELF64_XWORD_SIZE;
			
		//先頭アドレス
		ELF_HEADER_START_ADDR					= "00000000";
		ELF_PROGRAM_HEADER_START_ADDR			= "";
		ELF_SECTION_HEADER_START_ADDR			= "";
		
		//エントリーポイント
		ELF_ENTRY_START_ADDR	= "";
		
		//テーブル数
		ELF_PHDR_NUM		= 0;
		ELF_SHDR_NUM		= 0;
		ELF_SHDR_STR_INDEX	= 0;
		
		//ELF情報
		ELFCLASS	= 0;
		ELFDATA		= 0;
		ELFVERSION	= 0;
		ELFOSABI	= 0;
		E_TYPE		= 0;
			
		//各ヘッダーリスト
		programHeaderList		= new ArrayList<ProgramHeader>();
		sectionHeaderList		= new ArrayList<SectionHeader>();	
		
		//ストリングテーブルリスト
		stringTableList			= new ArrayList<String>();
		
		//残りデータ情報
		remainingDataRawAddr	= "00000000";
		reaminingDataRawSize	= 0;
		
		//Item
		ELF_PROGRAM_HEADER_TABLE_ITEM	= null;
		ELF_SECTION_HEADER_TABLE_ITEM	= null;
		
		
		//ハイライト用
		highlightStartAddr	= 0;
		highlightEndAddr	= 0;
		
		
		/*
		 * 作成
		 */
		//root作成
		root	= new TreeItem<>(new EPlusViewerTreeTableRecord(rootName, rootRaw, rootRVA, rootOffset, rootSize, rootValue, rootAnalysis, rootNotes));
		root.setExpanded(true);
		idEPlusViewerTreeTableView.setRoot(root);		
		
		idEPlusViewerTreeTableColumnName.setCellValueFactory(new TreeItemPropertyValueFactory<EPlusViewerTreeTableRecord, String>("name"));
		idEPlusViewerTreeTableColumnCheck.setCellValueFactory(new TreeItemPropertyValueFactory<EPlusViewerTreeTableRecord, String>("check"));
		idEPlusViewerTreeTableColumnRaw.setCellValueFactory(new TreeItemPropertyValueFactory<EPlusViewerTreeTableRecord, String>("raw"));
		idEPlusViewerTreeTableColumnRVA.setCellValueFactory(new TreeItemPropertyValueFactory<EPlusViewerTreeTableRecord, String>("rva"));
		idEPlusViewerTreeTableColumnLMA.setCellValueFactory(new TreeItemPropertyValueFactory<EPlusViewerTreeTableRecord, String>("lma"));
		idEPlusViewerTreeTableColumnOffset.setCellValueFactory(new TreeItemPropertyValueFactory<EPlusViewerTreeTableRecord, String>("offset"));
		idEPlusViewerTreeTableColumnSize.setCellValueFactory(new TreeItemPropertyValueFactory<EPlusViewerTreeTableRecord, String>("size"));
		idEPlusViewerTreeTableColumnValue.setCellValueFactory(new TreeItemPropertyValueFactory<EPlusViewerTreeTableRecord, String>("value"));
		idEPlusViewerTreeTableColumnAnalysis.setCellValueFactory(new TreeItemPropertyValueFactory<EPlusViewerTreeTableRecord, String>("analysis"));
		idEPlusViewerTreeTableColumnNotes.setCellValueFactory(new TreeItemPropertyValueFactory<EPlusViewerTreeTableRecord, String>("notes"));

		idEPlusViewerTreeTableView.getColumns().set(0, idEPlusViewerTreeTableColumnName);
		idEPlusViewerTreeTableView.getColumns().set(1, idEPlusViewerTreeTableColumnCheck);
		idEPlusViewerTreeTableView.getColumns().set(2, idEPlusViewerTreeTableColumnRaw);
		idEPlusViewerTreeTableView.getColumns().set(3, idEPlusViewerTreeTableColumnRVA);
		idEPlusViewerTreeTableView.getColumns().set(4, idEPlusViewerTreeTableColumnLMA);
		idEPlusViewerTreeTableView.getColumns().set(5, idEPlusViewerTreeTableColumnOffset);
		idEPlusViewerTreeTableView.getColumns().set(6, idEPlusViewerTreeTableColumnSize);
		idEPlusViewerTreeTableView.getColumns().set(7, idEPlusViewerTreeTableColumnValue);
		idEPlusViewerTreeTableView.getColumns().set(8, idEPlusViewerTreeTableColumnAnalysis);
		idEPlusViewerTreeTableView.getColumns().set(9, idEPlusViewerTreeTableColumnNotes);
			
		idEPlusViewerTreeTableColumnName.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
		idEPlusViewerTreeTableColumnCheck.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
		idEPlusViewerTreeTableColumnRaw.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
		idEPlusViewerTreeTableColumnRVA.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
		idEPlusViewerTreeTableColumnLMA.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
		idEPlusViewerTreeTableColumnOffset.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
		idEPlusViewerTreeTableColumnSize.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());	
		idEPlusViewerTreeTableColumnValue.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
		idEPlusViewerTreeTableColumnAnalysis.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
		idEPlusViewerTreeTableColumnNotes.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
		
		idEPlusViewerTreeTableView.expandedItemCountProperty();
		
		boolean	b	= false;
				
		try {
			/*
			 * ELF_HEADER
			 */
			b =	makeElfHeader(root, ELF_HEADER_START_ADDR); 

			if(!b) {
				idConsole.setText("It's not Executable and Linking Format.");
				return;
			}
			
			
			if(ELFCLASS==ELFCLASS32){
				
				if(!ELF_PROGRAM_HEADER_START_ADDR.equals("00000000")){
					/*
					 * ELF_PROGRAM_HEADER
					 */
					makeElfProgramHeader(root, ELF_PROGRAM_HEADER_START_ADDR);
			
				}
				
				if(!ELF_SECTION_HEADER_START_ADDR.equals("00000000")){
					/*
					 * ELF_SECTION_HEADER
					 */
					makeElfSectionHeader(root, ELF_SECTION_HEADER_START_ADDR);
				}
					
			}else if(ELFCLASS==ELFCLASS64){
				
				if(!ELF_PROGRAM_HEADER_START_ADDR.equals("0000000000000000")){
					/*
					 * ELF_PROGRAM_HEADER
					 */
					makeElfProgramHeader(root, ELF_PROGRAM_HEADER_START_ADDR);
			
				}
				
				if(!ELF_SECTION_HEADER_START_ADDR.equals("0000000000000000")){
					/*
					 * ELF_SECTION_HEADER
					 */
					makeElfSectionHeader(root, ELF_SECTION_HEADER_START_ADDR);
				}
				
			}
			
		}catch(Exception e) {
			
//			try{
//				StringWriter sw	= new StringWriter();
//				e.printStackTrace(new PrintWriter(sw));	
//				File errorFile			= new File("error.txt");
//				FileWriter fileWriter	= new FileWriter(errorFile);
//				fileWriter.write(sw.toString());
//				fileWriter.close();
//			}catch(Exception e2) {
//				e.printStackTrace();
//			}
			
			String message	= "An error occured.";	
//			message.concat("Please look at the error file(error.txt).");
			idConsole.setText(message);
			
			String alertType				= "ERROR";
			String title					= "ERROR";
			String headerText				= "ERROR";
			String contentText				= "An error occured.";
			StringWriter sw	= new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String expandableContentText	= sw.toString();
			
			alertMessageBox(alertType, title, headerText, contentText, expandableContentText);
				
		}
		
	}
	
	private boolean makeElfHeader(TreeItem<EPlusViewerTreeTableRecord> root, String strStartAddr) {
		
		//開始アドレス取得
		int startAddr	= getStringToInt(strStartAddr, false);
		
		//データ取得
		int dataSize	= ELF64_HDR_SIZE;	//とりあえず64bitのサイズで取っておく
		byte[] data		= getBintableBytes(startAddr, dataSize);
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= startAddr;	
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		String notes	= "";
		int v			= 0;
		long vl			= 0;
//		ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);

		
		//ELF_HEADER
		name		= "ELF_HEADER";
		rawAddr		+= beforesize;
		raw			= rawAddr;
		offset		= 0x0;
		size		= 0;	//後で更新
		value		= "";
		analysis 	= "";
		notes		= ELF_HEADER_Notes;
		beforesize	= 0;
		
		EPlusViewerTreeTableRecord ELF_HEADER					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
		TreeItem<EPlusViewerTreeTableRecord> ELF_HEADER_Item 	= new TreeItem<>(ELF_HEADER);
//		ELF_HEADER_Item.setExpanded(true);
		root.getChildren().add(ELF_HEADER_Item);
		
		
		//0x00	unsigned char	e_ident[EI_NIDENT]
		name	= "e_ident";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= UNSIGNED_CHAR_SIZE*EI_NIDENT;
		value	= "";
		for(int i=offset; i<offset+size; i++){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis		= "";
		
//		String ELFMAG	= "";
//		for(int i=EI_MAG0; i<=EI_MAG3; i++){
//			try{
//				ELFMAG	+= new String(buffer.putInt(data[i]&0xff).array(), "US-ASCII");
//			}catch(Exception e){
//				e.printStackTrace();
//			}
//		}
//		analysis	+= "ELFMAG="+ELFMAG+"\n";
		
		ELFCLASS	= (int)data[EI_CLASS];
		if(ELFCLASS==ELFCLASSNONE){
			analysis	+= "ELFCLASS=ELFCLASSNONE(0x00)"+"\n";
		}else if(ELFCLASS==ELFCLASS32){
			analysis	+= "ELFCLASS=ELFCLASS32(0x01)"+"\n";
		}else if(ELFCLASS==ELFCLASS64){
			analysis	+= "ELFCLASS=ELFCLASS64(0x02)"+"\n";
		}
		
		ELFDATA		= (int)data[EI_DATA];
		if(ELFDATA==ELFDATANONE){
			analysis	+= "ELFDATA=ELFDATANONE(0x00)"+"\n";
		}else if(ELFDATA==ELFDATA2LSB){
			analysis	+= "ELFDATA=ELFDATA2LSB(0x01)"+"\n";
		}else if(ELFDATA==ELFDATA2MSB){
			analysis	+= "ELFDATA=ELFDATA2MSB(0x02)"+"\n";
		}
		
		ELFVERSION	= (int)data[EI_VERSION];
		if(ELFVERSION==EV_NONE){
			analysis	+= "ELFVERSION=EV_NONE(0x00)"+"\n";
		}else if(ELFVERSION==EV_CURRENT){
			analysis	+= "ELFVERSION=EV_CURRENT(0x01)"+"\n";
		}else if(ELFVERSION==EV_NUM){
			analysis	+= "ELFVERSION=EV_NUM(0x02)"+"\n";
		}	
		
		ELFOSABI	= (int)data[EI_OSABI];
		if(ELFOSABI==ELFOSABI_NONE){
			analysis	+= "ELFOSABI=ELFOSABI_NONE(0x00)"+"\n";
		}else if(ELFOSABI==ELFOSABI_LINUX){
			analysis	+= "ELFOSABI=ELFOSABI_LINUX(0x03)"+"\n";
		}
		
		notes		= ELF_HEADER_e_ident_Notes;
		beforesize	= size;
		
		if(data[EI_MAG0]!=0x7F || data[EI_MAG1]!='E' || data[EI_MAG2]!='L' && data[EI_MAG3]!='F'){
			return false;
		}
		
		EPlusViewerTreeTableRecord e_ident					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<EPlusViewerTreeTableRecord> e_ident_Item	= new TreeItem<>(e_ident);
//		e_ident_Item.setExpanded(true);
		ELF_HEADER_Item.getChildren().add(e_ident_Item);
		
		
		if(ELFCLASS==ELFCLASS32){	//32bit	
			
			//0x10	Elf32_Half	e_type
			name	= "e_type";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF32_HALF_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			switch(getStringToInt(value, false)){
			case ET_NONE	:
				analysis	+= "ET_NONE(0)";
				break;
			case ET_REL		:
				analysis	+= "ET_REL(1)";
				break;
			case ET_EXEC	:
				analysis	+= "ET_EXEC(2)";
				break;				
			case ET_DYN		:
				analysis	+= "ET_DYN(3)";
				break;
			case ET_CORE	:
				analysis	+= "ET_CORE(4)";
				break;
			case ET_LOPROC	:
				analysis	+= "ET_LOPROC(0xff00)";
				break;
			case ET_HIPROC	:
				analysis	+= "ET_HIPROC(0xffff)";
				break;
			}
			notes		= ELF_HEADER_e_type_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_type					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_type_Item	= new TreeItem<>(e_type);
//			e_type_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_type_Item);

			//e_type取得
			E_TYPE	= getStringToInt(value, false);
			
			
			//0x12	Elf32_Half	e_machine
			name	= "e_machine";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF32_HALF_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			switch(getStringToInt(value, false)){
			case EM_NONE			:
				analysis	+= "EM_NONE(0)";
				break;
			case EM_M32				:
				analysis	+= "EM_M32(1)";
				break;
			case EM_SPARC			:
				analysis	+= "EM_SPARC(2)";
				break;
			case EM_386				:
				analysis	+= "EM_386(3)";
				break;
			case EM_68K				:
				analysis	+= "EM_68K(4)";
				break;
			case EM_88K				:
				analysis	+= "EM_88K(5)";
				break;
			case EM_486				:
				analysis	+= "EM_486(6)";
				break;
			case EM_860				:
				analysis	+= "EM_860(7)";
				break;
			case EM_MIPS			:
				analysis	+= "EM_MIPS(8)";
				break;
			case EM_MIPS_RS4_BE		:
				analysis	+= "EM_MIPS_RS4_BE(10)";
				break;
			case EM_PARISC			:
				analysis	+= "EM_PARISC(15)";
				break;
			case EM_SPARC32PLUS		:
				analysis	+= "EM_SPARC32PLUS(18)";
				break;
			case EM_PPC				:
				analysis	+= "EM_PPC(20)";
				break;
			case EM_PPC64			:
				analysis	+= "EM_PPC64(21)";
				break;
			case EM_SPU				:
				analysis	+= "EM_SPU(23)";
				break;
			case EM_ARM				:
				analysis	+= "EM_ARM(40)";
				break;
			case EM_SH				:
				analysis	+= "EM_SH(42)";
				break;
			case EM_SPARCV9			:
				analysis	+= "EM_SPARCV9(43)";
				break;
			case EM_H8_300			:
				analysis	+= "EM_H8_300(46)";
				break;
			case EM_IA_64			:
				analysis	+= "EM_IA_64(50)";
				break;
			case EM_X86_64			:
				analysis	+= "EM_X86_64(62)";
				break;
			case EM_S390			:
				analysis	+= "EM_S390(22)";
				break;
			case EM_CRIS			:
				analysis	+= "EM_CRIS(76)";
				break;
			case EM_V850			:
				analysis	+= "EM_V850(87)";
				break;
			case EM_M32R			:
				analysis	+= "EM_M32R(88)";
				break;
			case EM_MN10300			:
				analysis	+= "EM_MN10300(89)";
				break;
			case EM_OPENRISC		:
				analysis	+= "EM_OPENRISC(92)";
				break;
			case EM_BLACKFIN		:
				analysis	+= "EM_BLACKFIN(106)";
				break;
			case EM_ALTERA_NIOS2	:
				analysis	+= "EM_ALTERA_NIOS2(113)";
				break;
			case EM_TI_C6000		:
				analysis	+= "EM_TI_C6000(140)";
				break;
			case EM_AARCH64			:
				analysis	+= "EM_AARCH64(183)";
				break;
			case EM_FRV				:
				analysis	+= "EM_FRV(0x5441)";
				break;
			case EM_AVR32			:
				analysis	+= "EM_AVR32(0x18ad)";
				break;
			case EM_ALPHA			:
				analysis	+= "EM_ALPHA(0x9026)";
				break;
			case EM_CYGNUS_V850		:
				analysis	+= "EM_CYGNUS_V850(0x9080)";
				break;
			case EM_CYGNUS_M32R		:
				analysis	+= "EM_CYGNUS_M32R(0x9041)";
				break;
			case EM_S390_OLD		:
				analysis	+= "EM_S390_OLD(0xa390)";
				break;
			case EM_CTGNUS_MN10300	:
				analysis	+= "EM_CTGNUS_MN10300(0xbeef)";
				break;
			}
			notes		= ELF_HEADER_e_machine_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_machine				= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_machine_Item	= new TreeItem<>(e_machine);
//			e_machine_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_machine_Item);
			
			
			//0x14	Elf32_Word	e_version
			name	= "e_version";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF32_WORD_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			switch(getStringToInt(value, false)){
			case EV_NONE	:
				analysis	+= "EV_NONE(0)";
				break;
			case EV_CURRENT	:
				analysis	+= "EV_CURRENT(1)";
				break;
			case EV_NUM		:
				analysis	+= "EV_NUM(2)";
				break;
			}
			notes		= ELF_HEADER_e_version_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_version				= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_version_Item	= new TreeItem<>(e_version);
//			e_version_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_version_Item);
			
			
			//0x18	Elf32_Addr	e_entry
			name	= "e_entry";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF32_ADDR_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			notes		= ELF_HEADER_e_entry_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_entry					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_entry_Item	= new TreeItem<>(e_entry);
//			e_entry_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_entry_Item);		
			
			//エントリーポイント格納
			ELF_ENTRY_START_ADDR	= value;
			
			
			//0x1c	Elf32_Off	e_phoff
			name	= "e_phoff";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF32_OFF_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			notes		= ELF_HEADER_e_phoff_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_phoff					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_phoff_Item	= new TreeItem<>(e_phoff);
//			e_phoff_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_phoff_Item);			
			
			//プログラムヘッダーテーブル開始アドレス格納
			ELF_PROGRAM_HEADER_START_ADDR	= value;
			
			
			//0x20	Elf32_Off	e_shoff
			name	= "e_shoff";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF32_OFF_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			notes		= ELF_HEADER_e_shoff_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_shoff					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_shoff_Item	= new TreeItem<>(e_shoff);
//			e_shoff_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_shoff_Item);			
			
			//セクションヘッダーテーブル開始アドレス格納
			ELF_SECTION_HEADER_START_ADDR	= value;
			
			
			//0x24	Elf32_Word	e_flags
			name	= "e_flags";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF32_WORD_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			notes		= ELF_HEADER_e_flags_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_flags					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_flags_Item	= new TreeItem<>(e_flags);
//			e_flags_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_flags_Item);
			
			
			//0x28	Elf32_Half	e_ehsize
			name	= "e_ehsize";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF32_HALF_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			v			= getStringToInt(value, false);
			analysis	= String.valueOf(v)+" bytes";
			notes		= ELF_HEADER_e_ehsize_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_ehsize					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_ehsize_Item	= new TreeItem<>(e_ehsize);
//			e_ehsize_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_ehsize_Item);			
			
			//ELFヘッダーサイズ格納
			ELF32_HDR_SIZE	= v;
			ELF_HEADER.setSize(String.format("%08X", ELF32_HDR_SIZE).toUpperCase());
			
			
			//0x2a	Elf32_Half	e_phentsize
			name	= "e_phentsize";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF32_HALF_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			v			= getStringToInt(value, false);
			analysis	= String.valueOf(v)+" bytes";
			notes		= ELF_HEADER_e_phentsize_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_phentsize					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_phentsize_Item	= new TreeItem<>(e_phentsize);
//			e_phentsize_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_phentsize_Item);				
			
			//プログラムヘッダーテーブルサイズ格納
			ELF32_PHDR_SIZE	= v;
			
	
			//0x2c	Elf32_Half	e_phnum
			name	= "e_phnum";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF32_HALF_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			v			= getStringToInt(value, false);
			analysis	= String.valueOf(v);
			notes		= ELF_HEADER_e_phnum_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_phnum					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_phnum_Item	= new TreeItem<>(e_phnum);
//			e_phnum_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_phnum_Item);
			
			//プログラムヘッダーテーブル数格納
			ELF_PHDR_NUM	= v;
			
			
			//0x2e	Elf32_Half	e_shentsize
			name	= "e_shentsize";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF32_HALF_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			v			= getStringToInt(value, false);
			analysis	= String.valueOf(v)+" bytes";
			notes		= ELF_HEADER_e_shentsize_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_shentsize					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_shentsize_Item	= new TreeItem<>(e_shentsize);
//			e_shentsize_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_shentsize_Item);				
			
			//プログラムヘッダーテーブルサイズ格納
			ELF32_SHDR_SIZE	= v;
			
	
			//0x30	Elf32_Half	e_shnum
			name	= "e_shnum";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF32_HALF_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			v			= getStringToInt(value, false);
			analysis	= String.valueOf(v);
			notes		= ELF_HEADER_e_shnum_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_shnum					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_shnum_Item	= new TreeItem<>(e_shnum);
//			e_shnum_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_shnum_Item);
			
			//セクションヘッダーテーブル数格納
			ELF_SHDR_NUM	= v;
			
		
			//0x32	Elf32_Half	e_shstrndx
			name	= "e_shstrndx";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF32_HALF_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			v			= getStringToInt(value, false);
			analysis	= String.valueOf(v);
			notes		= ELF_HEADER_e_shstrndx_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_shstrndx					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_shstrndx_Item	= new TreeItem<>(e_shstrndx);
//			e_shstrndx_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_shstrndx_Item);
			
			//セクション名文字列テーブルインデックス格納
			ELF_SHDR_STR_INDEX	= v;
			
		}else if(ELFCLASS==ELFCLASS64){	//64bit
			
			//0x10	Elf64_Half	e_type
			name	= "e_type";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF64_HALF_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			switch(getStringToInt(value, false)){
			case ET_NONE	:
				analysis	+= "ET_NONE(0)";
				break;
			case ET_REL		:
				analysis	+= "ET_REL(1)";
				break;
			case ET_EXEC	:
				analysis	+= "ET_EXEC(2)";
				break;				
			case ET_DYN		:
				analysis	+= "ET_DYN(3)";
				break;
			case ET_CORE	:
				analysis	+= "ET_CORE(4)";
				break;
			case ET_LOPROC	:
				analysis	+= "ET_LOPROC(0xff00)";
				break;
			case ET_HIPROC	:
				analysis	+= "ET_HIPROC(0xffff)";
				break;
			}
			notes		= ELF_HEADER_e_type_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_type					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_type_Item	= new TreeItem<>(e_type);
//			e_type_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_type_Item);
			
			//e_type取得
			E_TYPE	= getStringToInt(value, false);
			
			
			//0x12	Elf64_Half	e_machine
			name	= "e_machine";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF64_HALF_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			switch(getStringToInt(value, false)){
			case EM_NONE			:
				analysis	+= "EM_NONE(0)";
				break;
			case EM_M32				:
				analysis	+= "EM_M32(1)";
				break;
			case EM_SPARC			:
				analysis	+= "EM_SPARC(2)";
				break;
			case EM_386				:
				analysis	+= "EM_386(3)";
				break;
			case EM_68K				:
				analysis	+= "EM_68K(4)";
				break;
			case EM_88K				:
				analysis	+= "EM_88K(5)";
				break;
			case EM_486				:
				analysis	+= "EM_486(6)";
				break;
			case EM_860				:
				analysis	+= "EM_860(7)";
				break;
			case EM_MIPS			:
				analysis	+= "EM_MIPS(8)";
				break;
			case EM_MIPS_RS4_BE		:
				analysis	+= "EM_MIPS_RS4_BE(10)";
				break;
			case EM_PARISC			:
				analysis	+= "EM_PARISC(15)";
				break;
			case EM_SPARC32PLUS		:
				analysis	+= "EM_SPARC32PLUS(18)";
				break;
			case EM_PPC				:
				analysis	+= "EM_PPC(20)";
				break;
			case EM_PPC64			:
				analysis	+= "EM_PPC64(21)";
				break;
			case EM_SPU				:
				analysis	+= "EM_SPU(23)";
				break;
			case EM_ARM				:
				analysis	+= "EM_ARM(40)";
				break;
			case EM_SH				:
				analysis	+= "EM_SH(42)";
				break;
			case EM_SPARCV9			:
				analysis	+= "EM_SPARCV9(43)";
				break;
			case EM_H8_300			:
				analysis	+= "EM_H8_300(46)";
				break;
			case EM_IA_64			:
				analysis	+= "EM_IA_64(50)";
				break;
			case EM_X86_64			:
				analysis	+= "EM_X86_64(62)";
				break;
			case EM_S390			:
				analysis	+= "EM_S390(22)";
				break;
			case EM_CRIS			:
				analysis	+= "EM_CRIS(76)";
				break;
			case EM_V850			:
				analysis	+= "EM_V850(87)";
				break;
			case EM_M32R			:
				analysis	+= "EM_M32R(88)";
				break;
			case EM_MN10300			:
				analysis	+= "EM_MN10300(89)";
				break;
			case EM_OPENRISC		:
				analysis	+= "EM_OPENRISC(92)";
				break;
			case EM_BLACKFIN		:
				analysis	+= "EM_BLACKFIN(106)";
				break;
			case EM_ALTERA_NIOS2	:
				analysis	+= "EM_ALTERA_NIOS2(113)";
				break;
			case EM_TI_C6000		:
				analysis	+= "EM_TI_C6000(140)";
				break;
			case EM_AARCH64			:
				analysis	+= "EM_AARCH64(183)";
				break;
			case EM_FRV				:
				analysis	+= "EM_FRV(0x5441)";
				break;
			case EM_AVR32			:
				analysis	+= "EM_AVR32(0x18ad)";
				break;
			case EM_ALPHA			:
				analysis	+= "EM_ALPHA(0x9026)";
				break;
			case EM_CYGNUS_V850		:
				analysis	+= "EM_CYGNUS_V850(0x9080)";
				break;
			case EM_CYGNUS_M32R		:
				analysis	+= "EM_CYGNUS_M32R(0x9041)";
				break;
			case EM_S390_OLD		:
				analysis	+= "EM_S390_OLD(0xa390)";
				break;
			case EM_CTGNUS_MN10300	:
				analysis	+= "EM_CTGNUS_MN10300(0xbeef)";
				break;
			}
			notes		= ELF_HEADER_e_machine_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_machine				= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_machine_Item	= new TreeItem<>(e_machine);
//			e_machine_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_machine_Item);
			
			
			//0x14	Elf64_Word	e_version
			name	= "e_version";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF64_WORD_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			switch(getStringToInt(value, false)){
			case EV_NONE	:
				analysis	+= "EV_NONE(0)";
				break;
			case EV_CURRENT	:
				analysis	+= "EV_CURRENT(1)";
				break;
			case EV_NUM		:
				analysis	+= "EV_NUM(2)";
				break;
			}
			notes		= ELF_HEADER_e_version_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_version				= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_version_Item	= new TreeItem<>(e_version);
//			e_version_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_version_Item);
			
			
			//0x18	Elf64_Addr	e_entry
			name	= "e_entry";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF64_ADDR_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			notes		= ELF_HEADER_e_entry_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_entry					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_entry_Item	= new TreeItem<>(e_entry);
//			e_entry_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_entry_Item);		
			
			//エントリーポイント格納
			ELF_ENTRY_START_ADDR	= value;
			
			
			//0x20	Elf64_Off	e_phoff
			name	= "e_phoff";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF64_OFF_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			vl			= getStringToLong(value, false);
			analysis	= String.valueOf(vl)+" bytes";
			notes		= ELF_HEADER_e_phoff_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_phoff					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_phoff_Item	= new TreeItem<>(e_phoff);
//			e_phoff_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_phoff_Item);			
			
			//プログラムヘッダーテーブル開始アドレス格納
			ELF_PROGRAM_HEADER_START_ADDR	= value;
			
			
			//0x28	Elf64_Off	e_shoff
			name	= "e_shoff";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF64_OFF_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			vl			= getStringToLong(value, false);
			analysis	= String.valueOf(vl)+" bytes";
			notes		= ELF_HEADER_e_shoff_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_shoff					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_shoff_Item	= new TreeItem<>(e_shoff);
//			e_shoff_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_shoff_Item);			
			
			//セクションヘッダーテーブル開始アドレス格納
			ELF_SECTION_HEADER_START_ADDR	= value;
			
			
			//0x30	Elf64_Word	e_flags
			name	= "e_flags";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF64_WORD_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			notes		= ELF_HEADER_e_flags_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_flags					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_flags_Item	= new TreeItem<>(e_flags);
//			e_flags_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_flags_Item);
			
			
			//0x34	Elf64_Half	e_ehsize
			name	= "e_ehsize";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF64_HALF_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			v			= getStringToInt(value, false);
			analysis	= String.valueOf(v)+" bytes";
			notes		= ELF_HEADER_e_ehsize_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_ehsize					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_ehsize_Item	= new TreeItem<>(e_ehsize);
//			e_ehsize_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_ehsize_Item);			
			
			//ELFヘッダーサイズ格納
			ELF64_HDR_SIZE	= v;
			ELF_HEADER.setSize(String.format("%08X", ELF64_HDR_SIZE).toUpperCase());
			
			
			//0x36	Elf64_Half	e_phentsize
			name	= "e_phentsize";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF64_HALF_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			v			= getStringToInt(value, false);
			analysis	= String.valueOf(v)+" bytes";
			notes		= ELF_HEADER_e_phentsize_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_phentsize					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_phentsize_Item	= new TreeItem<>(e_phentsize);
//			e_phentsize_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_phentsize_Item);				
			
			//プログラムヘッダーテーブルサイズ格納
			ELF64_PHDR_SIZE	= v;
			
	
			//0x38	Elf64_Half	e_phnum
			name	= "e_phnum";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF64_HALF_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			v			= getStringToInt(value, false);
			analysis	= String.valueOf(v);
			notes		= ELF_HEADER_e_phnum_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_phnum					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_phnum_Item	= new TreeItem<>(e_phnum);
//			e_phnum_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_phnum_Item);
			
			//プログラムヘッダーテーブル数格納
			ELF_PHDR_NUM	= v;
			
			
			//0x3a	Elf64_Half	e_shentsize
			name	= "e_shentsize";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF64_HALF_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			v			= getStringToInt(value, false);
			analysis	= String.valueOf(v)+" bytes";
			notes		= ELF_HEADER_e_shentsize_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_shentsize					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_shentsize_Item	= new TreeItem<>(e_shentsize);
//			e_shentsize_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_shentsize_Item);				
			
			//プログラムヘッダーテーブルサイズ格納
			ELF64_SHDR_SIZE	= v;
			
	
			//0x3c	Elf64_Half	e_shnum
			name	= "e_shnum";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF64_HALF_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			v			= getStringToInt(value, false);
			analysis	= String.valueOf(v);
			notes		= ELF_HEADER_e_shnum_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_shnum					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_shnum_Item	= new TreeItem<>(e_shnum);
//			e_shnum_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_shnum_Item);
			
			//セクションヘッダーテーブル数格納
			ELF_SHDR_NUM	= v;
			
		
			//0x3e	Elf64_Half	e_shstrndx
			name	= "e_shstrndx";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ELF64_HALF_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			v			= getStringToInt(value, false);
			analysis	= String.valueOf(v);
			notes		= ELF_HEADER_e_shstrndx_Notes;
			beforesize	= size;
			
			EPlusViewerTreeTableRecord e_shstrndx					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<EPlusViewerTreeTableRecord> e_shstrndx_Item	= new TreeItem<>(e_shstrndx);
//			e_shstrndx_Item.setExpanded(true);
			ELF_HEADER_Item.getChildren().add(e_shstrndx_Item);
			
			//セクション名文字列テーブルインデックス格納
			ELF_SHDR_STR_INDEX	= v;
			
			
		}else{	//None
			return false;
		}
		
		return true;
		
	}
	
	private void makeElfProgramHeader(TreeItem<EPlusViewerTreeTableRecord> root, String strStartAddr) {
		
		if(ELFCLASS==ELFCLASS32){	//32bit			
			//開始アドレス取得
			int startAddr32		= getStringToInt(strStartAddr, false);
			
			//データ取得用
			int dataSize	= 0;
			byte[] data		= null;
			
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;	
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			int v			= 0;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;

			//初期化
			rawAddr		= startAddr32;
			offset		= 0;
			startOffset	= offset;
			beforesize	= 0;
			
			//データ取得
			dataSize	= ELF32_PHDR_SIZE*ELF_PHDR_NUM;
			data		= getBintableBytes(startAddr32, dataSize);
			
			
			//ELF_PROGRAM_HEADER_TABLE
			name		= "ELF_PROGRAM_HEADER_TABLE";
			rawAddr		+= beforesize;
			raw			= rawAddr;
			offset		+= beforesize;
			size		= ELF32_PHDR_SIZE*ELF_PHDR_NUM;
			value		= "";
			analysis	= "";
			notes		= ELF_PROGRAM_HEADER_Notes;
			beforesize	= 0;
			
			EPlusViewerTreeTableRecord ELF_PROGRAM_HEADER_TABLE					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			TreeItem<EPlusViewerTreeTableRecord> ELF_PROGRAM_HEADER_TABLE_Item 	= new TreeItem<>(ELF_PROGRAM_HEADER_TABLE);
//			ELF_PROGRAM_HEADER_TABLE_Item.setExpanded(true);
			root.getChildren().add(ELF_PROGRAM_HEADER_TABLE_Item);
			
			//ヘッダー保存
			ELF_PROGRAM_HEADER_TABLE_ITEM	= ELF_PROGRAM_HEADER_TABLE_Item;

			for(int c=0; c<ELF_PHDR_NUM; c++){
				
				//ELF_PROGRAM_HEADER
				name		= "ELF_PROGRAM_HEADER"+"["+c+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				size		= ELF32_PHDR_SIZE;
				value		= "";
				analysis	= "";
				notes		= ELF_PROGRAM_HEADER_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_PROGRAM_HEADER					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				TreeItem<EPlusViewerTreeTableRecord> ELF_PROGRAM_HEADER_Item 	= new TreeItem<>(ELF_PROGRAM_HEADER);
//				ELF_PROGRAM_HEADER_Item.setExpanded(true);
				ELF_PROGRAM_HEADER_TABLE_Item.getChildren().add(ELF_PROGRAM_HEADER_Item);
				
				
				//0x00	Elf32_Word	p_type
				name	= "p_type";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				switch(getStringToInt(value, false)){
				case PT_NULL	:
					analysis	+= "PT_NULL(0)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":NULL");
					break;
				case PT_LOAD	:
					analysis	+= "PT_LOAD(1)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":LOAD");
					break;
				case PT_DYNAMIC	:
					analysis	+= "PT_DYNAMIC(2)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":DYNAMIC");
					break;
				case PT_INTERP	:
					analysis	+= "PT_INTERP(3)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":INTERP");
					break;
				case PT_NOTE	:
					analysis	+= "PT_NOTE(4)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":NOTE");
					break;
				case PT_SHLIB	:
					analysis	+= "PT_SHLIB(5)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":SHLIB");
					break;
				case PT_PHDR	:
					analysis	+= "PT_PHDR(6)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":PHDR");
					break;
				case PT_TLS	:
					analysis	+= "PT_TLS(7)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":TLS");
					break;
				case PT_LOOS	:
					analysis	+= "PT_LOOS(0x60000000)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":LOOS");
					break;
				case PT_HIOS	:
					analysis	+= "PT_HIOS(0x6fffffff)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":HIOS");
					break;
				case PT_LOPROC	:
					analysis	+= "PT_LOPROC(0x70000000)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":LOPROC");
					break;
				case PT_HIPROC	:
					analysis	+= "PT_HIPROC(0x7fffffff)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":HIPROC");
					break;
				case PT_GNU_EH_FRAME	:
					analysis	+= "PT_GNU_EH_FRAME(0x6474e550)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":GNU_EH_FRAME");
					break;
				case PT_GNU_STACK	:
					analysis	+= "PT_GNU_STACK(0x6474e551)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":GNU_STACK");
					break;
				case PT_GNU_RELRO	:
					analysis	+= "PT_GNU_RELRO(0x6474e552)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":GNU_RELRO");
					break;
				}
				notes		= ELF_PROGRAM_HEADER_p_type_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord p_type					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> p_type_Item	= new TreeItem<>(p_type);
//				p_type_Item.setExpanded(true);
				ELF_PROGRAM_HEADER_Item.getChildren().add(p_type_Item);
				
				//プログラムヘッダー作成
				ProgramHeader ph	= new ProgramHeader(value, 0);
				programHeaderList.add(ph);
				
				
				//0x04	Elf32_Off	p_offset
				name	= "p_offset";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF32_OFF_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_PROGRAM_HEADER_p_offset_Notes;
				beforesize	= size;
				ph.setP_offset_str(value);
				
				EPlusViewerTreeTableRecord p_offset					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> p_offset_Item	= new TreeItem<>(p_offset);
//				p_offset_Item.setExpanded(true);
				ELF_PROGRAM_HEADER_Item.getChildren().add(p_offset_Item);
				
				
				//0x08	Elf32_Addr	p_vaddr
				name	= "p_vaddr";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF32_ADDR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_PROGRAM_HEADER_p_vaddr_Notes;
				beforesize	= size;
				ph.setP_vaddr_str(value);
				
				EPlusViewerTreeTableRecord p_vaddr					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> p_vaddr_Item	= new TreeItem<>(p_vaddr);
//				p_vaddr_Item.setExpanded(true);
				ELF_PROGRAM_HEADER_Item.getChildren().add(p_vaddr_Item);			
				
				
				//0x0c	Elf32_Addr	p_paddr
				name	= "p_paddr";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF32_ADDR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_PROGRAM_HEADER_p_paddr_Notes;
				beforesize	= size;
				ph.setP_paddr_str(value);
				
				EPlusViewerTreeTableRecord p_paddr					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> p_paddr_Item	= new TreeItem<>(p_paddr);
//				p_paddr_Item.setExpanded(true);
				ELF_PROGRAM_HEADER_Item.getChildren().add(p_paddr_Item);			
				
				
				//0x10	Elf32_Word	p_filesz
				name	= "p_filesz";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				analysis	= String.valueOf(v)+" bytes";
				notes		= ELF_PROGRAM_HEADER_p_filesz_Notes;
				beforesize	= size;
				ph.setP_filesz_str(value);
				
				EPlusViewerTreeTableRecord p_filesz					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> p_filesz_Item	= new TreeItem<>(p_filesz);
//				p_filesz_Item.setExpanded(true);
				ELF_PROGRAM_HEADER_Item.getChildren().add(p_filesz_Item);
				
				
				//0x14	Elf32_Word	p_memsz
				name	= "p_memsz";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				analysis	= String.valueOf(v)+" bytes";
				notes		= ELF_PROGRAM_HEADER_p_memsz_Notes;
				beforesize	= size;
				ph.setP_memsz_str(value);
				
				EPlusViewerTreeTableRecord p_memsz					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> p_memsz_Item	= new TreeItem<>(p_memsz);
//				p_memsz_Item.setExpanded(true);
				ELF_PROGRAM_HEADER_Item.getChildren().add(p_memsz_Item);			
				
				
				//0x18	Elf32_Word	p_flags
				name	= "p_flags";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				if((v&PF_R)!=0){
					analysis	+= "PF_R(0x4)"+"\n";
				}
				if((v&PF_W)!=0){
					analysis	+= "PF_W(0x2)"+"\n";
				}
				if((v&PF_X)!=0){
					analysis	+= "PF_X(0x1)"+"\n";
				}
				notes		= ELF_PROGRAM_HEADER_p_flags_Notes;
				beforesize	= size;
				ph.setP_flags_str(value);
				
				EPlusViewerTreeTableRecord p_flags					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> p_flags_Item	= new TreeItem<>(p_flags);
//				p_flags_Item.setExpanded(true);
				ELF_PROGRAM_HEADER_Item.getChildren().add(p_flags_Item);			
				
				
				//0x1c	Elf32_Word	p_align
				name	= "p_align";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_PROGRAM_HEADER_p_align_Notes;
				beforesize	= size;
				ph.setP_align_str(value);
				
				EPlusViewerTreeTableRecord p_align					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> p_align_Item	= new TreeItem<>(p_align);
//				p_align_Item.setExpanded(true);
				ELF_PROGRAM_HEADER_Item.getChildren().add(p_align_Item);
						
			}
						
			//プログラムヘッダー取得
			ObservableList<TreeItem<EPlusViewerTreeTableRecord>> ELF_PROGRAM_HEADER_TABLE_Item_List = ELF_PROGRAM_HEADER_TABLE_Item.getChildren();
			Iterator<TreeItem<EPlusViewerTreeTableRecord>> ELF_PROGRAM_HEADER_TABLE_Item_Iterator	= ELF_PROGRAM_HEADER_TABLE_Item_List.iterator();		
			TreeItem<EPlusViewerTreeTableRecord> ELF_PROGRAM_HEADER_Item							= null;			
			ProgramHeader ph		= null;
			int programHeaderCount	= 0;
			
			while(ELF_PROGRAM_HEADER_TABLE_Item_Iterator.hasNext()){
				
				ELF_PROGRAM_HEADER_Item = (TreeItem<EPlusViewerTreeTableRecord>)ELF_PROGRAM_HEADER_TABLE_Item_Iterator.next();
				ph						= programHeaderList.get(programHeaderCount);

				//プログラムデータ作成
				makeElfProgramData(ELF_PROGRAM_HEADER_Item, ph);
			
				programHeaderCount++;
			}

		}else if(ELFCLASS==ELFCLASS64){	//64bit
			//開始アドレス取得
			long startAddr64	= getStringToLong(strStartAddr, false);
			int startAddr32		= (int)startAddr64;

			//データ取得用
			int dataSize	= 0;
			byte[] data		= null;
			
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;	
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			int v			= 0;
			long vl			= 0;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;
			

			rawAddr		= startAddr32;
			offset		= 0;
			startOffset	= offset;
			beforesize	= 0;
			
			//データ取得
			dataSize	= ELF64_PHDR_SIZE*ELF_PHDR_NUM;
			data		= getBintableBytes(startAddr32, dataSize);
			
			//ELF_PROGRAM_HEADER_TABLE
			name		= "ELF_PROGRAM_HEADER_TABLE";
			rawAddr		+= beforesize;
			raw			= rawAddr;
			offset		+= beforesize;
			size		= ELF64_PHDR_SIZE*ELF_PHDR_NUM;
			value		= "";
			analysis	= "";
			notes		= ELF_PROGRAM_HEADER_Notes;
			beforesize	= 0;
			
			EPlusViewerTreeTableRecord ELF_PROGRAM_HEADER_TABLE					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			TreeItem<EPlusViewerTreeTableRecord> ELF_PROGRAM_HEADER_TABLE_Item 	= new TreeItem<>(ELF_PROGRAM_HEADER_TABLE);
//			ELF_PROGRAM_HEADER_TABLE_Item.setExpanded(true);
			root.getChildren().add(ELF_PROGRAM_HEADER_TABLE_Item);
			
			//ヘッダー保存
			ELF_PROGRAM_HEADER_TABLE_ITEM	= ELF_PROGRAM_HEADER_TABLE_Item;
			
			
			for(int c=0; c<ELF_PHDR_NUM; c++){
				
				//ELF_PROGRAM_HEADER
				name		= "ELF_PROGRAM_HEADER"+"["+c+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				size		= ELF64_PHDR_SIZE;
				value		= "";
				analysis	= "";
				notes		= ELF_PROGRAM_HEADER_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_PROGRAM_HEADER					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				TreeItem<EPlusViewerTreeTableRecord> ELF_PROGRAM_HEADER_Item 	= new TreeItem<>(ELF_PROGRAM_HEADER);
//				ELF_PROGRAM_HEADER_Item.setExpanded(true);
				ELF_PROGRAM_HEADER_TABLE_Item.getChildren().add(ELF_PROGRAM_HEADER_Item);
				
				
				//0x00	Elf64_Word	p_type
				name	= "p_type";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF64_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				switch(getStringToInt(value, false)){
				case PT_NULL	:
					analysis	+= "PT_NULL(0)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":NULL");
					break;
				case PT_LOAD	:
					analysis	+= "PT_LOAD(1)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":LOAD");
					break;
				case PT_DYNAMIC	:
					analysis	+= "PT_DYNAMIC(2)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":DYNAMIC");
					break;
				case PT_INTERP	:
					analysis	+= "PT_INTERP(3)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":INTERP");
					break;
				case PT_NOTE	:
					analysis	+= "PT_NOTE(4)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":NOTE");
					break;
				case PT_SHLIB	:
					analysis	+= "PT_SHLIB(5)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":SHLIB");
					break;
				case PT_PHDR	:
					analysis	+= "PT_PHDR(6)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":PHDR");
					break;
				case PT_TLS	:
					analysis	+= "PT_TLS(7)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":TLS");
					break;
				case PT_LOOS	:
					analysis	+= "PT_LOOS(0x60000000)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":LOOS");
					break;
				case PT_HIOS	:
					analysis	+= "PT_HIOS(0x6fffffff)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":HIOS");
					break;
				case PT_LOPROC	:
					analysis	+= "PT_LOPROC(0x70000000)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":LOPROC");
					break;
				case PT_HIPROC	:
					analysis	+= "PT_HIPROC(0x7fffffff)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":HIPROC");
					break;
				case PT_GNU_EH_FRAME	:
					analysis	+= "PT_GNU_EH_FRAME(0x6474e550)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":GNU_EH_FRAME");
					break;
				case PT_GNU_STACK	:
					analysis	+= "PT_GNU_STACK(0x6474e551)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":GNU_STACK");
					break;
				case PT_GNU_RELRO	:
					analysis	+= "PT_GNU_RELRO(0x6474e552)";
					ELF_PROGRAM_HEADER.setName(ELF_PROGRAM_HEADER.getName()+":GNU_RELRO");
					break;
				}
				notes		= ELF_PROGRAM_HEADER_p_type_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord p_type					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> p_type_Item	= new TreeItem<>(p_type);
//				p_type_Item.setExpanded(true);
				ELF_PROGRAM_HEADER_Item.getChildren().add(p_type_Item);
				
				//プログラムヘッダー作成
				ProgramHeader ph	= new ProgramHeader(value, 1);
				programHeaderList.add(ph);
				
				
				//0x04	Elf64_Word	p_flags
				name	= "p_flags";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF64_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				if((v&PF_R)!=0){
					analysis	+= "PF_R(0x4)"+"\n";
				}
				if((v&PF_W)!=0){
					analysis	+= "PF_W(0x2)"+"\n";
				}
				if((v&PF_X)!=0){
					analysis	+= "PF_X(0x1)"+"\n";
				}
				notes		= ELF_PROGRAM_HEADER_p_flags_Notes;
				beforesize	= size;
				ph.setP_flags_str(value);
				
				EPlusViewerTreeTableRecord p_flags					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> p_flags_Item	= new TreeItem<>(p_flags);
//				p_flags_Item.setExpanded(true);
				ELF_PROGRAM_HEADER_Item.getChildren().add(p_flags_Item);
				

				//0x08	Elf64_Off	p_offset
				name	= "p_offset";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF64_OFF_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_PROGRAM_HEADER_p_offset_Notes;
				beforesize	= size;
				ph.setP_offset_str(value);
				
				EPlusViewerTreeTableRecord p_offset					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> p_offset_Item	= new TreeItem<>(p_offset);
//				p_offset_Item.setExpanded(true);
				ELF_PROGRAM_HEADER_Item.getChildren().add(p_offset_Item);
				
				
				//0x10	Elf64_Addr	p_vaddr
				name	= "p_vaddr";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF64_ADDR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_PROGRAM_HEADER_p_vaddr_Notes;
				beforesize	= size;
				ph.setP_vaddr_str(value);
				
				EPlusViewerTreeTableRecord p_vaddr					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> p_vaddr_Item	= new TreeItem<>(p_vaddr);
//				p_vaddr_Item.setExpanded(true);
				ELF_PROGRAM_HEADER_Item.getChildren().add(p_vaddr_Item);			
				
				
				//0x18	Elf32_Addr	p_paddr
				name	= "p_paddr";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF64_ADDR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_PROGRAM_HEADER_p_paddr_Notes;
				beforesize	= size;
				ph.setP_paddr_str(value);
				
				EPlusViewerTreeTableRecord p_paddr					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> p_paddr_Item	= new TreeItem<>(p_paddr);
//				p_paddr_Item.setExpanded(true);
				ELF_PROGRAM_HEADER_Item.getChildren().add(p_paddr_Item);			
				
				
				//0x20	Elf64_XWord	p_filesz
				name	= "p_filesz";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF64_XWORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				vl			= getStringToLong(value, false);
				analysis	= String.valueOf(vl)+" bytes";
				notes		= ELF_PROGRAM_HEADER_p_filesz_Notes;
				beforesize	= size;
				ph.setP_filesz_str(value);
				
				EPlusViewerTreeTableRecord p_filesz					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> p_filesz_Item	= new TreeItem<>(p_filesz);
//				p_filesz_Item.setExpanded(true);
				ELF_PROGRAM_HEADER_Item.getChildren().add(p_filesz_Item);
				
				
				//0x28	Elf64_XWord	p_memsz
				name	= "p_memsz";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF64_XWORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				vl			= getStringToLong(value, false);
				analysis	= String.valueOf(vl)+" bytes";
				notes		= ELF_PROGRAM_HEADER_p_memsz_Notes;
				beforesize	= size;
				ph.setP_memsz_str(value);
				
				EPlusViewerTreeTableRecord p_memsz					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> p_memsz_Item	= new TreeItem<>(p_memsz);
//				p_memsz_Item.setExpanded(true);
				ELF_PROGRAM_HEADER_Item.getChildren().add(p_memsz_Item);			
				
				
				//0x30	Elf64_XWord	p_align
				name	= "p_align";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF64_XWORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_PROGRAM_HEADER_p_align_Notes;
				beforesize	= size;
				ph.setP_align_str(value);
				
				EPlusViewerTreeTableRecord p_align					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> p_align_Item	= new TreeItem<>(p_align);
//				p_align_Item.setExpanded(true);
				ELF_PROGRAM_HEADER_Item.getChildren().add(p_align_Item);
				
			}
			
			//プログラムヘッダー取得
			ObservableList<TreeItem<EPlusViewerTreeTableRecord>> ELF_PROGRAM_HEADER_TABLE_Item_List = ELF_PROGRAM_HEADER_TABLE_Item.getChildren();
			Iterator<TreeItem<EPlusViewerTreeTableRecord>> ELF_PROGRAM_HEADER_TABLE_Item_Iterator	= ELF_PROGRAM_HEADER_TABLE_Item_List.iterator();		
			TreeItem<EPlusViewerTreeTableRecord> ELF_PROGRAM_HEADER_Item							= null;			
			ProgramHeader ph		= null;
			int programHeaderCount	= 0;
			
			while(ELF_PROGRAM_HEADER_TABLE_Item_Iterator.hasNext()){
				
				ELF_PROGRAM_HEADER_Item = (TreeItem<EPlusViewerTreeTableRecord>)ELF_PROGRAM_HEADER_TABLE_Item_Iterator.next();
				ph						= programHeaderList.get(programHeaderCount);

				//プログラムデータ作成
				makeElfProgramData(ELF_PROGRAM_HEADER_Item, ph);
			
				programHeaderCount++;
			}
		}
	}
	
	private void makeElfProgramData(TreeItem<EPlusViewerTreeTableRecord> item, ProgramHeader ph){

		if(ELFCLASS==ELFCLASS32){	//32bit
			
			if(ph.getP_filesz_int()==0){
				//プログラムデータがないので終了
				return;
			}
			
			//開始アドレス取得
			int startAddr32	= ph.getP_offset_int();
			
			//データ取得用
			int dataSize	= ph.getP_filesz_int();
			byte[] data		= null;
			
			//データ取得
			data			= getBintableBytes(startAddr32, dataSize);
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			int rva			= 0;
			int lma			= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;
			
			
			//ELF_PROGRAM_DATA
			name		= "ELF_PROGRAM_DATA";
			rawAddr		= startAddr32;
			raw			= rawAddr;
			rva			= ph.getP_vaddr_int();
			lma			= ph.getP_paddr_int();
			offset		+= beforesize;
			size		= dataSize;
			value		= "";
			analysis	= "";
			notes		= ELF_PROGRAM_DATA_Notes;
			beforesize	= 0;
			baseOffset	= offset;
			
			EPlusViewerTreeTableRecord ELF_PROGRAM_DATA	= null;
			if(rva!=0 && lma!=0){
				ELF_PROGRAM_DATA	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}else if(rva!=0){
				ELF_PROGRAM_DATA	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}else{
				ELF_PROGRAM_DATA	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}
			TreeItem<EPlusViewerTreeTableRecord> ELF_PROGRAM_DATA_Item 	= new TreeItem<>(ELF_PROGRAM_DATA);
//			ELF_PROGRAM_DATA_Item.setExpanded(true);
			item.getChildren().add(ELF_PROGRAM_DATA_Item);
					
			if(getStringToInt(ph.getP_type_str(), false)==PT_INTERP){
				//0x00	Variable	path
				name	= "path";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= dataSize;
				value	= "";
				analysis	= "";
				for(int i=offset; i<offset+size; i++){
					value		+= String.format("%02X", data[i]).toUpperCase();
					analysis	+= String.format("%c", data[i]);
				}
				notes		= ELF_PROGRAM_DATA_path_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord path	= null;
				if(rva!=0 && lma!=0){
					path	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					path	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					path	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> path_Item	= new TreeItem<>(path);
//				path_Item.setExpanded(true);
				ELF_PROGRAM_DATA_Item.getChildren().add(path_Item);
				
			}else if(getStringToInt(ph.getP_type_str(), false)==PT_DYNAMIC){
				
				makeElfDinamic(ELF_PROGRAM_DATA_Item, ph);
				
			}else if(getStringToInt(ph.getP_type_str(), false)==PT_NOTE){
				
				makeElfNote(ELF_PROGRAM_DATA_Item, ph);
				
			}
			
		}else if(ELFCLASS==ELFCLASS64){	//64bit
			
			if(ph.getP_filesz_long()==0){
				//プログラムデータがないので終了
				return;
			}
			
			//開始アドレス取得
			long startAddr64	= ph.getP_offset_long();
			int startAddr32 	= (int)startAddr64;
			
			//データ取得用
			int dataSize	= (int)ph.getP_filesz_long();
			byte[] data		= null;
			
			//データ取得
			data			= getBintableBytes(startAddr32, dataSize);
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			long rva		= 0;
			long lma		= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;
			
			//ELF_PROGRAM_DATA
			name		= "ELF_PROGRAM_DATA";
			rawAddr		= startAddr32;
			raw			= rawAddr;
			offset		+= beforesize;
			rva			= ph.getP_vaddr_long();
			lma			= ph.getP_paddr_long();
			size		= dataSize;
			value		= "";
			analysis	= "";
			notes		= ELF_PROGRAM_DATA_Notes;
			beforesize	= 0;
			baseOffset	= offset;
			
			EPlusViewerTreeTableRecord ELF_PROGRAM_DATA	= null;
			if(rva!=0 && lma!=0){
				ELF_PROGRAM_DATA	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}else if(rva!=0){
				ELF_PROGRAM_DATA	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}else{
				ELF_PROGRAM_DATA	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}
			TreeItem<EPlusViewerTreeTableRecord> ELF_PROGRAM_DATA_Item 	= new TreeItem<>(ELF_PROGRAM_DATA);
//			ELF_PROGRAM_DATA_Item.setExpanded(true);
			item.getChildren().add(ELF_PROGRAM_DATA_Item);

			if(getStringToInt(ph.getP_type_str(), false)==PT_INTERP){
				//0x00	Variable	path
				name	= "path";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= dataSize;
				value	= "";
				analysis	= "";
				for(int i=offset; i<offset+size; i++){
					value		+= String.format("%02X", data[i]).toUpperCase();
					analysis	+= String.format("%c", data[i]);
				}
				notes		= ELF_PROGRAM_DATA_path_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord path	= null;
				if(rva!=0 && lma!=0){
					path = new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					path = new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					path = new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> path_Item	= new TreeItem<>(path);
//				path_Item.setExpanded(true);
				ELF_PROGRAM_DATA_Item.getChildren().add(path_Item);
				
			}else if(getStringToInt(ph.getP_type_str(), false)==PT_DYNAMIC){				
				
				makeElfDinamic(ELF_PROGRAM_DATA_Item, ph);
				
			}else if(getStringToInt(ph.getP_type_str(), false)==PT_NOTE){
				
				makeElfNote(ELF_PROGRAM_DATA_Item, ph);
				
			}

		}
	}
	
	private void makeElfDinamic(TreeItem<EPlusViewerTreeTableRecord> item, ProgramHeader ph){
		
		if(ELFCLASS==ELFCLASS32){	//32bit
			//開始アドレス取得
			int startAddr32	= ph.getP_offset_int();
			
			//データ取得用
			int dataSize	= ph.getP_filesz_int();
			byte[] data		= null;
			
			//データ取得
			data		= getBintableBytes(startAddr32, dataSize);
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			int rva			= 0;
			int lma			= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			int v			= 0;
			String tag		= null;
				
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;
			
			//カウント
			int count		= 0;
			
			//データ格納用HashMap
			HashMap<String, String> map = new HashMap<String, String>();
			
			//シンボルテーブル
			TreeItem<EPlusViewerTreeTableRecord> DT_SYMTAB_item	= null;
		
			//アドレス設定
			rawAddr		= startAddr32;
			rva			= ph.getP_vaddr_int();
			lma			= ph.getP_paddr_int();
			
			for(int c=0; c<dataSize; c+=ELF32_DYN_SIZE){			
				//ELF_DYNAMIC_ENTRY
				name		= "ELF_DYNAMIC_ENTRY"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size		= ELF32_DYN_SIZE;
				value		= "";
				analysis	= "";
				notes		= ELF_DYNAMIC_ENTRY_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_DYNAMIC_ENTRY	= null;
				if(rva!=0 && lma!=0){
					ELF_DYNAMIC_ENTRY	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					ELF_DYNAMIC_ENTRY	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					ELF_DYNAMIC_ENTRY	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> ELF_DYNAMIC_ENTRY_Item 	= new TreeItem<>(ELF_DYNAMIC_ENTRY);
//				ELF_DYNAMIC_ENTRY_Item.setExpanded(true);
				item.getChildren().add(ELF_DYNAMIC_ENTRY_Item);
				
				
				//0x00	Elf32_Sword	d_tag
				name	= "d_tag";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF32_SWORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				tag			= value;
				switch(v){
				case DT_NULL		:
					analysis	+= "DT_NULL(0)";
					break;
				case DT_NEEDED		:
					analysis	+= "DT_NEEDED(1)";
					break;
				case DT_PLTRELSZ		:
					analysis	+= "DT_PLTRELSZ(2)";
					break;
				case DT_PLTGOT		:
					analysis	+= "DT_PLTGOT(3)";
					break;
				case DT_HASH		:
					analysis	+= "DT_HASH(4)";
					break;
				case DT_STRTAB		:
					analysis	+= "DT_STRTAB(5)";
					break;
				case DT_SYMTAB		:
					analysis	+= "DT_SYMTAB(6)";
					break;
				case DT_RELA		:
					analysis	+= "DT_RELA(7)";
					break;
				case DT_RELASZ		:
					analysis	+= "DT_RELASZ(8)";
					break;
				case DT_RELAENT		:
					analysis	+= "DT_RELAENT(9)";
					break;
				case DT_STRSZ		:
					analysis	+= "DT_STRSZ(10)";
					break;
				case DT_SYMENT		:
					analysis	+= "DT_SYMENT(11)";
					break;
				case DT_INIT		:
					analysis	+= "DT_INIT(12)";
					break;
				case DT_FINI		:
					analysis	+= "DT_FINI(13)";
					break;
				case DT_SONAME		:
					analysis	+= "DT_SONAME(14)";
					break;
				case DT_RPATH		:
					analysis	+= "DT_RPATH(15)";
					break;
				case DT_SYMBOLIC	:
					analysis	+= "DT_SYMBOLIC(16)";
					break;
				case DT_REL		:
					analysis	+= "DT_REL(17)";
					break;
				case DT_RELSZ		:
					analysis	+= "DT_RELSZ(18)";
					break;
				case DT_RELENT		:
					analysis	+= "DT_RELENT(19)";
					break;
				case DT_PLTREL		:
					analysis	+= "DT_PLTREL(20)";
					break;
				case DT_DEBUG		:
					analysis	+= "DT_DEBUG(21)";
					break;
				case DT_TEXTREL		:
					analysis	+= "DT_TEXTREL(22)";
					break;
				case DT_JMPREL		:
					analysis	+= "DT_JMPREL(23)";
					break;			
				case DT_BIND_NOW		:
					analysis	+= "DT_BIND_NOW(24)";
					break;
				case DT_INIT_ARRAY		:
					analysis	+= "DT_INIT_ARRAY(25)";
					break;
				case DT_FINI_ARRAY		:
					analysis	+= "DT_FINI_ARRAY(26)";
					break;
				case DT_INIT_ARRAYSZ		:
					analysis	+= "DT_INIT_ARRAYSZ(27)";
					break;
				case DT_FINI_ARRAYSZ		:
					analysis	+= "DT_FINI_ARRAYSZ(28)";
					break;
				case DT_RUNPATH		:
					analysis	+= "DT_RUNPATH(29)";
					break;
				case DT_FLAGS		:
					analysis	+= "DT_FLAGS(30)";
					break;				
				case DT_PREINIT_ARRAY		:
					analysis	+= "DT_PREINIT_ARRAY(32)";
					break;
				case DT_PREINIT_ARRAYSZ		:
					analysis	+= "DT_PREINIT_ARRAYSZ(33)";
					break;	
				case DT_LOOS		:
					analysis	+= "DT_LOOS(0x6000000d)";
					break;
				case DT_HIOS		:
					analysis	+= "DT_HIOS(0x6ffff000)";
					break;
				case DT_VALRNGLO		:
					analysis	+= "DT_VALRNGLO(0x6ffffd00)";
					break;
				case DT_VALRNGHI		:
					analysis	+= "DT_VALRNGHI(0x6ffffdff)";
					break;
				case DT_ADDRRNGLO		:
					analysis	+= "DT_ADDRRNGLO(0x6ffffe00)";
					break;
				case DT_ADDRRNGHI		:
					analysis	+= "DT_ADDRRNGHI(0x6ffffeff)";
					break;			
				case DT_VERSYM		:
					analysis	+= "DT_VERSYM(0x6ffffff0)";
					break;
				case DT_RELACOUNT		:
					analysis	+= "DT_RELACOUNT(0x6ffffff9)";
					break;	
				case DT_RELCOUNT		:
					analysis	+= "DT_RELCOUNT(0x6ffffffa)";
					break;
				case DT_FLAGS_1		:
					analysis	+= "DT_FLAGS_1(0x6ffffffb)";
					break;	
				case DT_VERDEF		:
					analysis	+= "DT_VERDEF(0x6ffffffc)";
					break;
				case DT_VERDEFNUM		:
					analysis	+= "DT_VERDEFNUM(0x6ffffffd)";
					break;	
				case DT_VERNEED		:
					analysis	+= "DT_VERNEED(0x6ffffffe)";
					break;
				case DT_VERNEEDNUM		:
					analysis	+= "DT_VERNEEDNUM(0x6fffffff)";
					break;	
				case DT_LOPROC		:
					analysis	+= "DT_LOPROC(0x70000000)";
					break;
				case DT_HIPROC		:
					analysis	+= "DT_HIPROC(0x7fffffff)";
					break;
				case DT_GNU_PRELINKED		:
					analysis	+= "DT_GNU_PRELINKED(0x6ffffdf5)";
					break;
				case DT_GNU_CONFLICTSZ		:
					analysis	+= "DT_GNU_CONFLICTSZ(0x6ffffdf6)";
					break;
				case DT_GNU_LIBLISTSZ		:
					analysis	+= "DT_GNU_LIBLISTSZ(0x6ffffdf7)";
					break;
				case DT_GNU_HASH		:
					analysis	+= "DT_GNU_HASH(0x6ffffef5)";
					break;
				case DT_GNU_CONFLICT		:
					analysis	+= "DT_GNU_CONFLICT(0x6ffffef8)";
					break;
				case DT_GNU_LIBLIST		:
					analysis	+= "DT_GNU_LIBLIST(0x6ffffef9)";
					break;
				}
				notes		= ELF_DYNAMIC_ENTRY_d_tag_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord d_tag	= null;
				if(rva!=0 && lma!=0){
					d_tag	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					d_tag	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					d_tag	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> d_tag_Item	= new TreeItem<>(d_tag);
//				d_tag_Item.setExpanded(true);
				ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_tag_Item);
	
				//ELF_DYNAMIC_ENTRY名更新
				ELF_DYNAMIC_ENTRY.setName(ELF_DYNAMIC_ENTRY.getName()+":"+analysis);
				
				//DT_SYMTABなら保存
				if(v==DT_SYMTAB){
					DT_SYMTAB_item	= ELF_DYNAMIC_ENTRY_Item;
				}
				
				if(v==DT_NEEDED){	//シンボル名
					
					//0x04	Elf32_Sword	d_val
					name	= "d_val";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= ELF32_SWORD_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					analysis	= "";
					v			= getStringToInt(value, false);
					//analysis	+= "sh_link=0x"+sh.getSh_link_str()+"\n";
					//analysis	+= "=>"+ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(sh.getSh_link_int()).getValue().getName()+"\n";
					analysis	+= "index=0x"+value+"\n";
					notes		= ELF_DYNAMIC_ENTRY_d_val_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_val	= null;
					if(rva!=0 && lma!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else if(rva!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else{
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_val_Item	= new TreeItem<>(d_val);
//					d_val_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_val_Item);
					
					//HashMapに格納
					map.put(tag, value);				
					
				}else if(v==DT_SONAME){//共有オブジェクトの名前
					
					//0x04	Elf32_Sword	d_val
					name	= "d_val";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= ELF32_SWORD_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					analysis	= "";
					notes		= ELF_DYNAMIC_ENTRY_d_val_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_val	= null;
					if(rva!=0 && lma!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else if(rva!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else{
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_val_Item	= new TreeItem<>(d_val);
//					d_val_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_val_Item);
					
					//HashMapに格納
					map.put(tag, value);				
					
				}else if(v==DT_RPATH ||
						 v==DT_RUNPATH){	//path
					
					//0x04	Elf32_Sword	d_val
					name	= "d_val";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= ELF32_SWORD_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					analysis	= "";
					notes		= ELF_DYNAMIC_ENTRY_d_val_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_val	= null;
					if(rva!=0 && lma!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else if(rva!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else{
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_val_Item	= new TreeItem<>(d_val);
//					d_val_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_val_Item);
					
					//HashMapに格納
					map.put(tag, value);
					
				}else if(v==DT_PLTRELSZ ||
						 v==DT_RELASZ ||
						 v==DT_RELAENT ||
						 v==DT_STRSZ ||
						 v==DT_SYMENT ||
						 v==DT_RELSZ ||
						 v==DT_RELENT ||
						 v==DT_INIT_ARRAYSZ ||
						 v==DT_FINI_ARRAYSZ ||
						 v==DT_PREINIT_ARRAYSZ){		//サイズ
				
					//0x04	Elf32_Sword	d_val
					name	= "d_val";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= ELF32_SWORD_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					analysis	= "";
					v			= getStringToInt(value, false);
					analysis	= String.valueOf(v)+" bytes";
					notes		= ELF_DYNAMIC_ENTRY_d_val_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_val	= null;
					if(rva!=0 && lma!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else if(rva!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else {
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_val_Item	= new TreeItem<>(d_val);
//					d_val_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_val_Item);
					
					//HashMapに格納
					map.put(tag, value);
					
				}else if(v==DT_PLTGOT ||
						 v==DT_HASH ||
						 v==DT_STRTAB ||
						 v==DT_SYMTAB ||
						 v==DT_RELA ||
						 v==DT_INIT ||
						 v==DT_FINI ||
						 v==DT_REL ||
						 v==DT_JMPREL ||
						 v==DT_INIT_ARRAY ||
						 v==DT_FINI_ARRAY ||
						 v==DT_PREINIT_ARRAY ||
						 v==DT_VERSYM ||
						 v==DT_VERNEED ||
						 v==DT_GNU_HASH){		//アドレス
					
					//0x04	Elf32_Addr	d_ptr
					name	= "d_ptr";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= ELF32_ADDR_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					analysis	= "";
					analysis	+= "Raw=0x"+getVaddrToFileoffset(value, false)+"\n";
					notes		= ELF_DYNAMIC_ENTRY_d_ptr_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_ptr	= null;
					if(rva!=0 && lma!=0){
						d_ptr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else if(rva!=0){
						d_ptr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else {
						d_ptr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_ptr_Item	= new TreeItem<>(d_ptr);
//					d_ptr_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_ptr_Item);
					
					//HashMapに格納
					map.put(tag, value);
				
				}else if(v==DT_PLTREL){	//再配置エントリ型		
					
					//0x04	Elf32_Sword	d_val
					name	= "d_val";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= ELF32_SWORD_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					v			= getStringToInt(value, false);
					analysis	= "";
					if(v==DT_RELA){
						analysis	+= "RELA(7)"+"\n";
					}else if(v==DT_REL){
						analysis	+= "REL(17)"+"\n";
					}
					notes		= ELF_DYNAMIC_ENTRY_d_val_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_val	= null;
					if(rva!=0 && lma!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else if(rva!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else{
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_val_Item	= new TreeItem<>(d_val);
//					d_val_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_val_Item);
					
					//HashMapに格納
					map.put(tag, value);	
					
				}else{
				
					//0x04	Elf32_Sword	d_val
					name	= "d_val";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= ELF32_SWORD_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					analysis	= "";
					notes		= ELF_DYNAMIC_ENTRY_d_val_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_val	= null;
					if(rva!=0 && lma!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else if(rva!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else{
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_val_Item	= new TreeItem<>(d_val);
//					d_val_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_val_Item);
					
					//HashMapに格納
					map.put(tag, value);

					//DT_NULLならループから抜ける
					if(v==DT_NULL){
						break;
					}					
				}

				count++;
			}
			
			//参照先の作成
			ObservableList<TreeItem<EPlusViewerTreeTableRecord>> ELF_DYNAMIC_ENTRY_Item_List 	= null;
			Iterator<TreeItem<EPlusViewerTreeTableRecord>> ELF_DYNAMIC_ENTRY_Item_List_Iterator	= null;
			TreeItem<EPlusViewerTreeTableRecord> ELF_DYNAMIC_ENTRY_Item							= null;
			
			ELF_DYNAMIC_ENTRY_Item_List 			= item.getChildren();
			ELF_DYNAMIC_ENTRY_Item_List_Iterator	= ELF_DYNAMIC_ENTRY_Item_List.iterator();
			
			while(ELF_DYNAMIC_ENTRY_Item_List_Iterator.hasNext()){
				
				ELF_DYNAMIC_ENTRY_Item = ELF_DYNAMIC_ENTRY_Item_List_Iterator.next();
				
				TreeItem<EPlusViewerTreeTableRecord> item0 = ELF_DYNAMIC_ENTRY_Item.getChildren().get(0);
				TreeItem<EPlusViewerTreeTableRecord> item1 = ELF_DYNAMIC_ENTRY_Item.getChildren().get(1);
				
				String strVaddr			= null;
				String strDataSize		= null;
				
				String strStrVaddr		= null;
				String strStrDataSize	= null;
				
				String strSymVaddr		= null;
				String strSymEntSize	= null;
				
				String strRelaVaddr		= null;
				String strRelaDataSize	= null;
				String strRelaEntSize	= null;
				
				String strRelVaddr		= null;
				String strRelDataSize	= null;
				String strRelEntSize	= null;
				
				String strJmpRelVaddr	= null;
				String strPltRelSize	= null;
				String strPltRel		= null;
				
				String rtnStrVal		= null;
				
				switch(getStringToInt(item0.getValue().getValue(), false)){
					case DT_NEEDED:
						strVaddr	= map.get(String.format("%08X", DT_STRTAB).toUpperCase());
						strDataSize	= map.get(String.format("%08X", DT_STRSZ).toUpperCase());						
						//ストリングテーブルからシンボル名取得
						rtnStrVal = makeDynamicSymbolName(item1, strVaddr, strDataSize, getStringToInt(item1.getValue().getValue(), false));						
						break;
					case DT_SONAME:
						strVaddr	= map.get(String.format("%08X", DT_STRTAB).toUpperCase());
						strDataSize	= map.get(String.format("%08X", DT_STRSZ).toUpperCase());						
						//ストリングシンボルテーブルからシンボル名取得
						rtnStrVal = makeDynamicSymbolName(item1, strVaddr, strDataSize, getStringToInt(item1.getValue().getValue(), false));						
						break;
					case DT_RPATH:
						strVaddr	= map.get(String.format("%08X", DT_STRTAB).toUpperCase());
						strDataSize	= map.get(String.format("%08X", DT_STRSZ).toUpperCase());						
						//ストリングシンボルテーブルからシンボル名取得
						rtnStrVal = makeDynamicSymbolName(item1, strVaddr, strDataSize, getStringToInt(item1.getValue().getValue(), false));						
						break;
					case DT_RUNPATH:
						strVaddr	= map.get(String.format("%08X", DT_STRTAB).toUpperCase());
						strDataSize	= map.get(String.format("%08X", DT_STRSZ).toUpperCase());						
						//ストリングシンボルテーブルからシンボル名取得
						rtnStrVal = makeDynamicSymbolName(item1, strVaddr, strDataSize, getStringToInt(item1.getValue().getValue(), false));						
						break;
					case DT_INIT:	
						break;
					case DT_FINI:
						break;
					case DT_INIT_ARRAY:
						strVaddr	= map.get(String.format("%08X", DT_INIT_ARRAY).toUpperCase());
						strDataSize	= map.get(String.format("%08X", DT_INIT_ARRAYSZ).toUpperCase());					
						makeDynamicEntryAddrArray(item1, strVaddr, strDataSize);	
						break;
					case DT_FINI_ARRAY:
						strVaddr	= map.get(String.format("%08X", DT_FINI_ARRAY).toUpperCase());
						strDataSize	= map.get(String.format("%08X", DT_FINI_ARRAYSZ).toUpperCase());					
						makeDynamicEntryAddrArray(item1, strVaddr, strDataSize);	
						break;
					case DT_STRTAB:
						strStrVaddr		= map.get(String.format("%08X", DT_STRTAB).toUpperCase());
						strStrDataSize	= map.get(String.format("%08X", DT_STRSZ).toUpperCase());					
						makeDynamicEntryData(item1, strStrVaddr, strStrDataSize);
						break;
					case DT_SYMTAB:
						strSymVaddr		= map.get(String.format("%08X", DT_SYMTAB).toUpperCase());
						strSymEntSize	= map.get(String.format("%08X", DT_SYMENT).toUpperCase());					
						strStrVaddr		= map.get(String.format("%08X", DT_STRTAB).toUpperCase());	
						strStrDataSize	= map.get(String.format("%08X", DT_STRSZ).toUpperCase());
						makeElfDynamicSymbolTable(item1, strSymVaddr, strSymEntSize, strStrVaddr, strStrDataSize);
						break;	
					case DT_PLTGOT:
						strVaddr	= map.get(String.format("%08X", DT_PLTGOT).toUpperCase());				
						//.rel.gotサイズ取得
						int relgotSize	= ELF32_ADDR_SIZE*3;	//まずgot[0],got[1],got[2]分
						strPltRelSize	= map.get(String.format("%08X", DT_PLTRELSZ).toUpperCase());
						strPltRel		= map.get(String.format("%08X", DT_PLTREL).toUpperCase());
						if(getStringToInt(strPltRel, false)==DT_RELA) {	//DT_RELAなら
							relgotSize += getStringToInt(strPltRelSize, false)/ELF32_RELA_SIZE * ELF32_ADDR_SIZE;
						}else if(getStringToInt(strPltRel, false)==DT_REL){	//DT_RELなら
							relgotSize += getStringToInt(strPltRelSize, false)/ELF32_REL_SIZE * ELF32_ADDR_SIZE;
						}
						//System.out.println("relgotSize="+relgotSize);
						makeDynamicEntryAddrArray(item1, strVaddr, String.format("%08X", relgotSize).toUpperCase());
						break;
					case DT_RELA:
						strRelaVaddr   	= map.get(String.format("%08X", DT_RELA).toUpperCase());
						strRelaDataSize	= map.get(String.format("%08X", DT_RELASZ).toUpperCase());
						strRelaEntSize	= map.get(String.format("%08X", DT_RELAENT).toUpperCase());
						if(strRelaEntSize==null){
							strRelaEntSize	= String.format("%08X", ELF32_RELA_SIZE).toUpperCase();
						}
						makeElfRelocationAddendTable(item1, strRelaVaddr, strRelaDataSize, strRelaEntSize, DT_SYMTAB_item);
						break;
					case DT_REL:
						strRelVaddr   	= map.get(String.format("%08X", DT_REL).toUpperCase());
						strRelDataSize	= map.get(String.format("%08X", DT_RELSZ).toUpperCase());
						strRelEntSize	= map.get(String.format("%08X", DT_RELENT).toUpperCase());
						if(strRelEntSize==null){
							strRelEntSize	= String.format("%08X", ELF32_REL_SIZE).toUpperCase();
						}
						makeElfRelocationTable(item1, strRelVaddr, strRelDataSize, strRelEntSize, DT_SYMTAB_item);
						break;
					case DT_JMPREL:
						strJmpRelVaddr  = map.get(String.format("%08X", DT_JMPREL).toUpperCase());
						strPltRelSize	= map.get(String.format("%08X", DT_PLTRELSZ).toUpperCase());
						strPltRel		= map.get(String.format("%08X", DT_PLTREL).toUpperCase());
					
						if(getStringToInt(strPltRel, false)==DT_RELA) {	//DT_RELAなら
							strRelaEntSize	= map.get(String.format("%08X", DT_RELAENT).toUpperCase());
							if(strRelaEntSize==null){
								strRelaEntSize	= String.format("%08X", ELF32_RELA_SIZE).toUpperCase();
							}
							makeElfRelocationAddendTable(item1, strJmpRelVaddr, strPltRelSize, strRelaEntSize, DT_SYMTAB_item);
						}else if(getStringToInt(strPltRel, false)==DT_REL){	//DT_RELなら
							strRelEntSize	= map.get(String.format("%08X", DT_RELENT).toUpperCase());
							if(strRelEntSize==null){
								strRelEntSize	= String.format("%08X", ELF32_REL_SIZE).toUpperCase();
							}
							makeElfRelocationTable(item1, strJmpRelVaddr, strPltRelSize, strRelEntSize, DT_SYMTAB_item);
						}
						break;
					default:
						break;
				}
			}
			
		}else if(ELFCLASS==ELFCLASS64){	//64bit
			//開始アドレス取得
			long startAddr64	= ph.getP_offset_long();
			int startAddr32		= (int)startAddr64;
			
			//データ取得用
			int dataSize	= (int)ph.getP_filesz_long();
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			long rva		= 0;
			long lma		= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			int v			= 0;
			long vl			= 0;
			String tag		= null;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;
			
			//カウント
			int count		= 0;
			
			//データ格納用HashMap
			HashMap<String, String> map = new HashMap<String, String>();
			
			//シンボルテーブル
			TreeItem<EPlusViewerTreeTableRecord> DT_SYMTAB_item	= null;
				
			//アドレス設定
			rawAddr		= startAddr32;
			rva			= ph.getP_vaddr_long();
			lma			= ph.getP_paddr_long();
			
			for(int c=0; c<dataSize; c+=ELF64_DYN_SIZE){			
				//ELF_DYNAMIC_ENTRY
				name		= "ELF_DYNAMIC_ENTRY"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size		= ELF64_DYN_SIZE;
				value		= "";
				analysis	= "";
				notes		= ELF_DYNAMIC_ENTRY_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_DYNAMIC_ENTRY	= null;
				if(rva!=0 && lma!=0){
					ELF_DYNAMIC_ENTRY	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					ELF_DYNAMIC_ENTRY	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					ELF_DYNAMIC_ENTRY	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> ELF_DYNAMIC_ENTRY_Item 	= new TreeItem<>(ELF_DYNAMIC_ENTRY);
//				ELF_DYNAMIC_ENTRY_Item.setExpanded(true);
				item.getChildren().add(ELF_DYNAMIC_ENTRY_Item);
				
				
				//0x00	Elf64_Sxword	d_tag
				name	= "d_tag";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_SXWORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= (int)getStringToLong(value, false);
				tag			= value;
				switch(v){
				case DT_NULL		:
					analysis	+= "DT_NULL(0)";
					break;
				case DT_NEEDED		:
					analysis	+= "DT_NEEDED(1)";
					break;
				case DT_PLTRELSZ		:
					analysis	+= "DT_PLTRELSZ(2)";
					break;
				case DT_PLTGOT		:
					analysis	+= "DT_PLTGOT(3)";
					break;
				case DT_HASH		:
					analysis	+= "DT_HASH(4)";
					break;
				case DT_STRTAB		:
					analysis	+= "DT_STRTAB(5)";
					break;
				case DT_SYMTAB		:
					analysis	+= "DT_SYMTAB(6)";
					break;
				case DT_RELA		:
					analysis	+= "DT_RELA(7)";
					break;
				case DT_RELASZ		:
					analysis	+= "DT_RELASZ(8)";
					break;
				case DT_RELAENT		:
					analysis	+= "DT_RELAENT(9)";
					break;
				case DT_STRSZ		:
					analysis	+= "DT_STRSZ(10)";
					break;
				case DT_SYMENT		:
					analysis	+= "DT_SYMENT(11)";
					break;
				case DT_INIT		:
					analysis	+= "DT_INIT(12)";
					break;
				case DT_FINI		:
					analysis	+= "DT_FINI(13)";
					break;
				case DT_SONAME		:
					analysis	+= "DT_SONAME(14)";
					break;
				case DT_RPATH		:
					analysis	+= "DT_RPATH(15)";
					break;
				case DT_SYMBOLIC	:
					analysis	+= "DT_SYMBOLIC(16)";
					break;
				case DT_REL		:
					analysis	+= "DT_REL(17)";
					break;
				case DT_RELSZ		:
					analysis	+= "DT_RELSZ(18)";
					break;
				case DT_RELENT		:
					analysis	+= "DT_RELENT(19)";
					break;
				case DT_PLTREL		:
					analysis	+= "DT_PLTREL(20)";
					break;
				case DT_DEBUG		:
					analysis	+= "DT_DEBUG(21)";
					break;
				case DT_TEXTREL		:
					analysis	+= "DT_TEXTREL(22)";
					break;
				case DT_JMPREL		:
					analysis	+= "DT_JMPREL(23)";
					break;			
				case DT_BIND_NOW		:
					analysis	+= "DT_BIND_NOW(24)";
					break;
				case DT_INIT_ARRAY		:
					analysis	+= "DT_INIT_ARRAY(25)";
					break;
				case DT_FINI_ARRAY		:
					analysis	+= "DT_FINI_ARRAY(26)";
					break;
				case DT_INIT_ARRAYSZ		:
					analysis	+= "DT_INIT_ARRAYSZ(27)";
					break;
				case DT_FINI_ARRAYSZ		:
					analysis	+= "DT_FINI_ARRAYSZ(28)";
					break;
				case DT_RUNPATH		:
					analysis	+= "DT_RUNPATH(29)";
					break;
				case DT_FLAGS		:
					analysis	+= "DT_FLAGS(30)";
					break;				
				case DT_PREINIT_ARRAY		:
					analysis	+= "DT_PREINIT_ARRAY(32)";
					break;
				case DT_PREINIT_ARRAYSZ		:
					analysis	+= "DT_PREINIT_ARRAYSZ(33)";
					break;	
				case DT_LOOS		:
					analysis	+= "DT_LOOS(0x6000000d)";
					break;
				case DT_HIOS		:
					analysis	+= "DT_HIOS(0x6ffff000)";
					break;
				case DT_VALRNGLO		:
					analysis	+= "DT_VALRNGLO(0x6ffffd00)";
					break;
				case DT_VALRNGHI		:
					analysis	+= "DT_VALRNGHI(0x6ffffdff)";
					break;
				case DT_ADDRRNGLO		:
					analysis	+= "DT_ADDRRNGLO(0x6ffffe00)";
					break;
				case DT_ADDRRNGHI		:
					analysis	+= "DT_ADDRRNGHI(0x6ffffeff)";
					break;			
				case DT_VERSYM		:
					analysis	+= "DT_VERSYM(0x6ffffff0)";
					break;
				case DT_RELACOUNT		:
					analysis	+= "DT_RELACOUNT(0x6ffffff9)";
					break;	
				case DT_RELCOUNT		:
					analysis	+= "DT_RELCOUNT(0x6ffffffa)";
					break;
				case DT_FLAGS_1		:
					analysis	+= "DT_FLAGS_1(0x6ffffffb)";
					break;	
				case DT_VERDEF		:
					analysis	+= "DT_VERDEF(0x6ffffffc)";
					break;
				case DT_VERDEFNUM		:
					analysis	+= "DT_VERDEFNUM(0x6ffffffd)";
					break;	
				case DT_VERNEED		:
					analysis	+= "DT_VERNEED(0x6ffffffe)";
					break;
				case DT_VERNEEDNUM		:
					analysis	+= "DT_VERNEEDNUM(0x6fffffff)";
					break;	
				case DT_LOPROC		:
					analysis	+= "DT_LOPROC(0x70000000)";
					break;
				case DT_HIPROC		:
					analysis	+= "DT_HIPROC(0x7fffffff)";
					break;
				case DT_GNU_PRELINKED		:
					analysis	+= "DT_GNU_PRELINKED(0x6ffffdf5)";
					break;
				case DT_GNU_CONFLICTSZ		:
					analysis	+= "DT_GNU_CONFLICTSZ(0x6ffffdf6)";
					break;
				case DT_GNU_LIBLISTSZ		:
					analysis	+= "DT_GNU_LIBLISTSZ(0x6ffffdf7)";
					break;
				case DT_GNU_HASH		:
					analysis	+= "DT_GNU_HASH(0x6ffffef5)";
					break;
				case DT_GNU_CONFLICT		:
					analysis	+= "DT_GNU_CONFLICT(0x6ffffef8)";
					break;
				case DT_GNU_LIBLIST		:
					analysis	+= "DT_GNU_LIBLIST(0x6ffffef9)";
					break;
				}
				notes		= ELF_DYNAMIC_ENTRY_d_tag_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord d_tag	= null;
				if(rva!=0 && lma!=0){
					d_tag	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					d_tag	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					d_tag	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> d_tag_Item	= new TreeItem<>(d_tag);
//				d_tag_Item.setExpanded(true);
				ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_tag_Item);
	
				//ELF_DYNAMIC_ENTRY名更新
				ELF_DYNAMIC_ENTRY.setName(ELF_DYNAMIC_ENTRY.getName()+":"+analysis);
				
				//DT_SYMTABなら保存
				if(v==DT_SYMTAB){
					DT_SYMTAB_item	= ELF_DYNAMIC_ENTRY_Item;
				}	
				
				if(v==DT_NEEDED){	//シンボル名
					
					//0x08	Elf64_Xword	d_val
					name	= "d_val";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= ELF64_XWORD_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					analysis	= "";
					vl			= getStringToLong(value, false);
					//analysis	+= "sh_link=0x"+sh.getSh_link_str()+"\n";
					//analysis	+= "=>"+ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(sh.getSh_link_int()).getValue().getName()+"\n";
					analysis	+= "index=0x"+value+"\n";
					notes		= ELF_DYNAMIC_ENTRY_d_val_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_val	= null;
					if(rva!=0 && lma!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else if(rva!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else{
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_val_Item	= new TreeItem<>(d_val);
//					d_val_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_val_Item);
					
					//HashMapに格納
					map.put(tag, value);
					
				}else if(v==DT_SONAME){//共有オブジェクトの名前
					
					//0x08	Elf64_Xword	d_val
					name	= "d_val";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= ELF64_XWORD_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					analysis	= "";
					notes		= ELF_DYNAMIC_ENTRY_d_val_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_val	= null;
					if(rva!=0 && lma!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else if(rva!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else{
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_val_Item	= new TreeItem<>(d_val);
//					d_val_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_val_Item);
					
					//HashMapに格納
					map.put(tag, value);
					
				}else if(v==DT_RPATH ||
						 v==DT_RUNPATH){	//path
					
					//0x08	Elf64_Xword	d_val
					name	= "d_val";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= ELF64_XWORD_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					analysis	= "";
					notes		= ELF_DYNAMIC_ENTRY_d_val_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_val	= null;
					if(rva!=0 && lma!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else if(rva!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else{
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_val_Item	= new TreeItem<>(d_val);
//					d_val_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_val_Item);
					
					//HashMapに格納
					map.put(tag, value);
					
				}else if(v==DT_PLTRELSZ ||
						 v==DT_RELASZ ||
						 v==DT_RELAENT ||
						 v==DT_STRSZ ||
						 v==DT_SYMENT ||
						 v==DT_RELSZ ||
						 v==DT_RELENT ||
						 v==DT_INIT_ARRAYSZ ||
						 v==DT_FINI_ARRAYSZ ||
						 v==DT_PREINIT_ARRAYSZ){		//サイズ
				
					//0x08	Elf64_Xword	d_val
					name	= "d_val";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= ELF64_XWORD_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					analysis	= "";
					vl			= getStringToLong(value, false);
					analysis	= String.valueOf(vl)+" bytes";
					notes		= ELF_DYNAMIC_ENTRY_d_val_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_val	= null;
					if(rva!=0 && lma!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else if(rva!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else{
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_val_Item	= new TreeItem<>(d_val);
//					d_val_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_val_Item);
					
					//HashMapに格納
					map.put(tag, value);
					
				}else if(v==DT_PLTGOT ||
						 v==DT_HASH ||
						 v==DT_STRTAB ||
						 v==DT_SYMTAB ||
						 v==DT_RELA ||
						 v==DT_INIT ||
						 v==DT_FINI ||
						 v==DT_REL ||
						 v==DT_JMPREL ||
						 v==DT_INIT_ARRAY ||
						 v==DT_FINI_ARRAY ||
						 v==DT_PREINIT_ARRAY ||
						 v==DT_VERSYM ||
						 v==DT_VERNEED ||
						 v==DT_GNU_HASH){		//アドレス
					
					//0x08	Elf64_Addr	d_ptr
					name	= "d_ptr";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= ELF64_ADDR_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					analysis	= "";
					analysis	+= "Raw=0x"+getVaddrToFileoffset(value, false)+"\n";
					notes		= ELF_DYNAMIC_ENTRY_d_ptr_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_ptr	= null;
					if(rva!=0 && lma!=0){
						d_ptr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else if(rva!=0){
						d_ptr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else{
						d_ptr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_ptr_Item	= new TreeItem<>(d_ptr);
//					d_ptr_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_ptr_Item);
						
					//HashMapに格納
					map.put(tag, value);
					
				}else if(v==DT_PLTREL){	//再配置エントリ型
				
					//0x08	Elf64_Xword	d_val
					name	= "d_val";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= ELF64_XWORD_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					v			= (int)getStringToLong(value, false);
					analysis	= "";
					if(v==DT_RELA){
						analysis	+= "RELA(7)"+"\n";
					}else if(v==DT_REL){
						analysis	+= "REL(17)"+"\n";
					}
					notes		= ELF_DYNAMIC_ENTRY_d_val_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_val	= null;
					if(rva!=0 && lma!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else if(rva!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else{
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_val_Item	= new TreeItem<>(d_val);
//					d_val_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_val_Item);

					//HashMapに格納
					map.put(tag, value);
				
				}else{
				
					//0x08	Elf64_Xword	d_val
					name	= "d_val";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= ELF64_XWORD_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					analysis	= "";
					notes		= ELF_DYNAMIC_ENTRY_d_val_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_val	= null;
					if(rva!=0 && lma!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else if(rva!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else{
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_val_Item	= new TreeItem<>(d_val);
//					d_val_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_val_Item);

					//HashMapに格納
					map.put(tag, value);
					
					//DT_NULLならループから抜ける
					if(v==DT_NULL){
						break;
					}
					
				}

				count++;
			}
			
			//参照先の作成
			ObservableList<TreeItem<EPlusViewerTreeTableRecord>> ELF_DYNAMIC_ENTRY_Item_List 	= null;
			Iterator<TreeItem<EPlusViewerTreeTableRecord>> ELF_DYNAMIC_ENTRY_Item_List_Iterator	= null;
			TreeItem<EPlusViewerTreeTableRecord> ELF_DYNAMIC_ENTRY_Item							= null;
			
			ELF_DYNAMIC_ENTRY_Item_List 			= item.getChildren();
			ELF_DYNAMIC_ENTRY_Item_List_Iterator	= ELF_DYNAMIC_ENTRY_Item_List.iterator();
			
			while(ELF_DYNAMIC_ENTRY_Item_List_Iterator.hasNext()){
				
				ELF_DYNAMIC_ENTRY_Item = ELF_DYNAMIC_ENTRY_Item_List_Iterator.next();
				
				TreeItem<EPlusViewerTreeTableRecord> item0 = ELF_DYNAMIC_ENTRY_Item.getChildren().get(0);
				TreeItem<EPlusViewerTreeTableRecord> item1 = ELF_DYNAMIC_ENTRY_Item.getChildren().get(1);
				
				String strVaddr			= null;
				String strDataSize		= null;
				
				String strStrVaddr		= null;
				String strStrDataSize	= null;
				
				String strSymVaddr		= null;
				String strSymEntSize	= null;
				
				String strRelaVaddr		= null;
				String strRelaDataSize	= null;
				String strRelaEntSize	= null;
				
				String strRelVaddr		= null;
				String strRelDataSize	= null;
				String strRelEntSize	= null;
				
				String strJmpRelVaddr	= null;
				String strPltRelSize	= null;
				String strPltRel		= null;
				
				String rtnStrVal		= null;
				
				switch((int)getStringToLong(item0.getValue().getValue(), false)){
					case DT_NEEDED:
						strVaddr	= map.get(String.format("%016X", DT_STRTAB).toUpperCase());
						strDataSize	= map.get(String.format("%016X", DT_STRSZ).toUpperCase());						
						//ストリングテーブルからシンボル名取得
						rtnStrVal = makeDynamicSymbolName(item1, strVaddr, strDataSize, (int)getStringToLong(item1.getValue().getValue(), false));												
						break;
					case DT_SONAME:	
						strVaddr	= map.get(String.format("%016X", DT_STRTAB).toUpperCase());
						strDataSize	= map.get(String.format("%016X", DT_STRSZ).toUpperCase());						
						//ストリングテーブルからシンボル名取得
						rtnStrVal = makeDynamicSymbolName(item1, strVaddr, strDataSize, (int)getStringToLong(item1.getValue().getValue(), false));												
						break;
					case DT_RPATH:
						strVaddr	= map.get(String.format("%016X", DT_STRTAB).toUpperCase());
						strDataSize	= map.get(String.format("%016X", DT_STRSZ).toUpperCase());						
						//ストリングテーブルからシンボル名取得
						rtnStrVal = makeDynamicSymbolName(item1, strVaddr, strDataSize, (int)getStringToLong(item1.getValue().getValue(), false));												
						break;
					case DT_RUNPATH:
						strVaddr	= map.get(String.format("%016X", DT_STRTAB).toUpperCase());
						strDataSize	= map.get(String.format("%016X", DT_STRSZ).toUpperCase());						
						//ストリングテーブルからシンボル名取得
						rtnStrVal = makeDynamicSymbolName(item1, strVaddr, strDataSize, (int)getStringToLong(item1.getValue().getValue(), false));												
						break;
					case DT_INIT:				
						break;
					case DT_FINI:					
						break;
					case DT_INIT_ARRAY:
						strVaddr	= map.get(String.format("%016X", DT_INIT_ARRAY).toUpperCase());
						strDataSize	= map.get(String.format("%016X", DT_INIT_ARRAYSZ).toUpperCase());					
						makeDynamicEntryAddrArray(item1, strVaddr, strDataSize);	
						break;
					case DT_FINI_ARRAY:
						strVaddr	= map.get(String.format("%016X", DT_FINI_ARRAY).toUpperCase());
						strDataSize	= map.get(String.format("%016X", DT_FINI_ARRAYSZ).toUpperCase());					
						makeDynamicEntryAddrArray(item1, strVaddr, strDataSize);	
						break;
					case DT_STRTAB:
						strStrVaddr		= map.get(String.format("%016X", DT_STRTAB).toUpperCase());
						strStrDataSize	= map.get(String.format("%016X", DT_STRSZ).toUpperCase());					
						makeDynamicEntryData(item1, strStrVaddr, strStrDataSize);
						break;
					case DT_SYMTAB:
						strSymVaddr		= map.get(String.format("%016X", DT_SYMTAB).toUpperCase());
						strSymEntSize	= map.get(String.format("%016X", DT_SYMENT).toUpperCase());					
						strStrVaddr		= map.get(String.format("%016X", DT_STRTAB).toUpperCase());	
						strStrDataSize	= map.get(String.format("%016X", DT_STRSZ).toUpperCase());
						makeElfDynamicSymbolTable(item1, strSymVaddr, strSymEntSize, strStrVaddr, strStrDataSize);
						break;
					case DT_PLTGOT:
						strVaddr	= map.get(String.format("%016X", DT_PLTGOT).toUpperCase());				
						//.rel.gotサイズ取得
						long relgotSize	= ELF64_ADDR_SIZE*3;	//まずgot[0],got[1],got[2]分
						strPltRelSize	= map.get(String.format("%016X", DT_PLTRELSZ).toUpperCase());
						strPltRel		= map.get(String.format("%016X", DT_PLTREL).toUpperCase());
						if((int)getStringToLong(strPltRel, false)==DT_RELA) {	//DT_RELAなら
							relgotSize += getStringToLong(strPltRelSize, false)/ELF64_RELA_SIZE * ELF64_ADDR_SIZE;
						}else if((int)getStringToLong(strPltRel, false)==DT_REL){	//DT_RELなら
							relgotSize += getStringToLong(strPltRelSize, false)/ELF64_REL_SIZE * ELF64_ADDR_SIZE;
						}
						//System.out.println("relgotSize="+relgotSize);
						makeDynamicEntryAddrArray(item1, strVaddr, String.format("%016X", relgotSize).toUpperCase());
						break;
					case DT_RELA:
						strRelaVaddr   	= map.get(String.format("%016X", DT_RELA).toUpperCase());
						strRelaDataSize	= map.get(String.format("%016X", DT_RELASZ).toUpperCase());
						strRelaEntSize	= map.get(String.format("%016X", DT_RELAENT).toUpperCase());
						if(strRelaEntSize==null){
							strRelaEntSize	= String.format("%016X", ELF64_RELA_SIZE).toUpperCase();
						}
						makeElfRelocationAddendTable(item1, strRelaVaddr, strRelaDataSize, strRelaEntSize, DT_SYMTAB_item);
						break;
					case DT_REL:
						strRelVaddr   	= map.get(String.format("%016X", DT_REL).toUpperCase());
						strRelDataSize	= map.get(String.format("%016X", DT_RELSZ).toUpperCase());
						strRelEntSize	= map.get(String.format("%016X", DT_RELENT).toUpperCase());
						if(strRelEntSize==null){
							strRelEntSize	= String.format("%016X", ELF64_REL_SIZE).toUpperCase();
						}
						makeElfRelocationTable(item1, strRelVaddr, strRelDataSize, strRelEntSize, DT_SYMTAB_item);
						break;
					case DT_JMPREL:
						strJmpRelVaddr  = map.get(String.format("%016X", DT_JMPREL).toUpperCase());
						strPltRelSize	= map.get(String.format("%016X", DT_PLTRELSZ).toUpperCase());
						strPltRel		= map.get(String.format("%016X", DT_PLTREL).toUpperCase());

						if((int)getStringToLong(strPltRel, false)==DT_RELA) {	//DT_RELAなら
							strRelaEntSize	= map.get(String.format("%016X", DT_RELAENT).toUpperCase());
							if(strRelaEntSize==null){
								strRelaEntSize	= String.format("%016X", ELF64_RELA_SIZE).toUpperCase();
							}
							makeElfRelocationAddendTable(item1, strJmpRelVaddr, strPltRelSize, strRelaEntSize, DT_SYMTAB_item);
						}else if((int)getStringToLong(strPltRel, false)==DT_REL){	//DT_RELなら
							strRelEntSize	= map.get(String.format("%016X", DT_RELENT).toUpperCase());
							if(strRelEntSize==null){
								strRelEntSize	= String.format("%016X", ELF64_REL_SIZE).toUpperCase();
							}
							makeElfRelocationTable(item1, strJmpRelVaddr, strPltRelSize, strRelEntSize, DT_SYMTAB_item);
						}
						break;					
					default:
						break;
				}				
			}
		}
	}
	
	private String makeDynamicSymbolName(TreeItem<EPlusViewerTreeTableRecord> item, String strVaddr, String strDataSize, int index){
		
		//戻り値
		String symName	= "";
		
		if(ELFCLASS==ELFCLASS32){	//32bit
			//開始アドレス取得
			int startAddr32		= getStringToInt(getVaddrToFileoffset(strVaddr, false), false);
			
			//データ取得用
			int dataSize	= getStringToInt(strDataSize, false);
			byte[] data		= null;
			
			//データ取得
			data		= getBintableBytes(startAddr32, dataSize);
			
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			int rva			= 0;
			int lma			= 0;
			int offset		= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			String strLma	= null;
			

			//0x00	Variable	name	
			name			= "name";
			rawAddr			= startAddr32+index;	
			raw				= rawAddr;	
			offset			= index;
			if(getStringToInt(strVaddr, false)!=0){
				rva			= getStringToInt(strVaddr, false)+index;
				strLma		= getVaddrToPaddr(String.format("%08X", rva).toUpperCase());
			}
			if(strLma!=null){
				lma			= getStringToInt(strLma, false);
			}
			size			= 0;
			int dataCount	= 0;
			value			= "";
			analysis		= "";
			notes			= ELF_DYNAMIC_SYMBOL_NAME_Notes;					
			
			while(data[index]!=0 && index<dataSize){
				value		+= String.format("%02X", data[index]).toUpperCase();
				analysis	+= String.format("%c", data[index]);
				dataCount++;
				index++;
			}
				
			if(dataCount!=0){
				//サイズ更新
				size		= dataCount;
				
				//戻り値格納
				symName		= analysis;
				
				EPlusViewerTreeTableRecord Name	= null;
				if(rva!=0 && lma!=0){
					Name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					Name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					Name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> Name_Item	= new TreeItem<>(Name);
//				Name_Item.setExpanded(true);
				item.getChildren().add(Name_Item);
			}
			
		}else if(ELFCLASS==ELFCLASS64){	//64bit
			//開始アドレス取得
			long startAddr64	= getStringToLong(getVaddrToFileoffset(strVaddr, false), false);
			int startAddr32		= (int)startAddr64;
			
			//データ取得用
			int dataSize	= (int)getStringToLong(strDataSize, false);
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
			
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			long rva		= 0;
			long lma		= 0;
			int offset		= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			String strLma	= null;
			

			//0x00	Variable	name	
			name			= "name";
			rawAddr			= startAddr32+index;	
			raw				= rawAddr;	
			offset			= index;
			if(getStringToLong(strVaddr, false)!=0){
				rva			= getStringToLong(strVaddr, false)+index;
				strLma		= getVaddrToPaddr(String.format("%016X", rva).toUpperCase());
			}
			if(strLma!=null){
				lma			= getStringToLong(strLma, false);
			}
			size			= 0;
			int dataCount	= 0;
			value			= "";
			analysis		= "";
			notes			= ELF_DYNAMIC_SYMBOL_NAME_Notes;					
			
			while(data[index]!=0 && index<dataSize){
				value		+= String.format("%02X", data[index]).toUpperCase();
				analysis	+= String.format("%c", data[index]);
				dataCount++;
				index++;
			}
				
			if(dataCount!=0){
				//サイズ更新
				size		= dataCount;
				
				//戻り値格納
				symName		= analysis;
				
				EPlusViewerTreeTableRecord Name	= null;
				if(rva!=0 && lma!=0){
					Name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					Name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					Name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> Name_Item	= new TreeItem<>(Name);
//				Name_Item.setExpanded(true);
				item.getChildren().add(Name_Item);
			}
		}
		
		return symName;
	}
	
	private void makeDynamicEntryData(TreeItem<EPlusViewerTreeTableRecord> item, String strVaddr, String strDataSize){
		
		if(ELFCLASS==ELFCLASS32){	//32bit
			//開始アドレス取得
			int startAddr32	= getStringToInt(getVaddrToFileoffset(strVaddr, false), false);
			
			//データ取得用
			int dataSize	= getStringToInt(strDataSize, false);
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
			
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			int rva			= 0;
			int lma			= 0;
			int offset		= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			String strLma	= null;
			

			//0x00	Variable	data	
			name			= "data";
			rawAddr			= startAddr32;	
			raw				= rawAddr;	
			offset			= 0x0;
			if(getStringToInt(strVaddr, false)!=0){
				rva			= getStringToInt(strVaddr, false);
				strLma		= getVaddrToPaddr(String.format("%08X", rva).toUpperCase());
			}
			if(strLma!=null){
				lma			= getStringToInt(strLma, false);
			}
			size			= dataSize;
			value			= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			notes		= ELF_DYNAMIC_Entry_Data_Notes;
			
			EPlusViewerTreeTableRecord Data	= null;
			if(rva!=0 && lma!=0){
				Data	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			}else if(rva!=0){
				Data	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}else{
				Data	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}
			TreeItem<EPlusViewerTreeTableRecord> Data_Item	= new TreeItem<>(Data);
//			Data_Item.setExpanded(true);
			item.getChildren().add(Data_Item);			

		}else if(ELFCLASS==ELFCLASS64){	//64bit
			//開始アドレス取得
			long startAddr64	= getStringToLong(getVaddrToFileoffset(strVaddr, false), false);
			int startAddr32		= (int)startAddr64;
			
			//データ取得用
			int dataSize	= (int)getStringToLong(strDataSize, false);
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
			
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			long rva		= 0;
			long lma		= 0;
			int offset		= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			String strLma	= null;

			
			//0x00	Variable	data	
			name			= "data";
			rawAddr			= startAddr32;	
			raw				= rawAddr;	
			offset			= 0x0;
			if(getStringToLong(strVaddr, false)!=0){
				rva			= getStringToLong(strVaddr, false);
				strLma		= getVaddrToPaddr(String.format("%016X", rva).toUpperCase());
			}
			if(strLma!=null){
				lma			= getStringToLong(strLma, false);
			}
			size			= dataSize;
			value			= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}			
			analysis		= "";
			notes			= ELF_DYNAMIC_Entry_Data_Notes;
				
			EPlusViewerTreeTableRecord Data	= null;
			if(rva!=0 && lma!=0){
				Data	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			}else if(rva!=0){
				Data	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}else{
				Data	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}
			TreeItem<EPlusViewerTreeTableRecord> Data_Item	= new TreeItem<>(Data);
//			Data_Item.setExpanded(true);
			item.getChildren().add(Data_Item);

		}		
	}	
	
	private void makeDynamicEntryAddrArray(TreeItem<EPlusViewerTreeTableRecord> item, String strVaddr, String strDataSize){
				
		if(ELFCLASS==ELFCLASS32){	//32bit
			//開始アドレス取得
			int startAddr32	= getStringToInt(getVaddrToFileoffset(strVaddr, false), false);
			
			//データ取得用
			int dataSize	= getStringToInt(strDataSize, false);
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
			
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			int rva			= 0;
			int lma			= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			String strLma	= null;
			
			//カウント
			int count			= 0;
			int dataSizeCount	= 0;
			
			//チェックフラグ
			boolean checkFlag	= false;
			
			//アドレス設定
			rawAddr	= startAddr32;
			rva		= getStringToInt(strVaddr, false);
			strLma	= getVaddrToPaddr(String.format("%08X", rva).toUpperCase());
			if(strLma!=null){
				lma		= getStringToInt(strLma, false);
			}
			
			while(dataSizeCount < dataSize) {				
				//0x00	Variable	addr[]
				name		= "addr"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size		= ELF32_ADDR_SIZE;
				value		= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				if(getVaddrToFileoffset(value, false)!=null){
					analysis	+= "Raw=0x"+getVaddrToFileoffset(value, false)+"\n";
				}else if(getStringToInt(value, false)!=0){
					checkFlag	= true;
				}
				notes		= ELF_DYNAMIC_Entry_Addr_Array_Notes;	
				beforesize	= size;
				
				EPlusViewerTreeTableRecord Addr	= null;
				if(rva!=0 && lma!=0){
					Addr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					Addr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else {
					Addr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> Addr_Item	= new TreeItem<>(Addr);
//				Addr_Item.setExpanded(true);
				item.getChildren().add(Addr_Item);	
				
				//チェックあり
				if(checkFlag){
					Addr.setCheck("*");
				}
				
				count++;
				dataSizeCount	+= ELF32_ADDR_SIZE;
				checkFlag		= false;
			}
			
		}else if(ELFCLASS==ELFCLASS64){	//64bit
			//開始アドレス取得
			long startAddr64	= getStringToLong(getVaddrToFileoffset(strVaddr, false), false);
			int startAddr32		= (int)startAddr64;
			
			//データ取得用
			int dataSize	= (int)getStringToLong(strDataSize, false);
			byte[] data		= null;

			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);

			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			long rva		= 0;
			long lma		= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			String strLma	= null;
			
			//カウント
			int count			= 0;
			int dataSizeCount	= 0;
			
			//チェックフラグ
			boolean checkFlag	= false;
			
			//アドレス設定
			rawAddr	= startAddr32;
			rva		= getStringToLong(strVaddr, false);
			strLma	= getVaddrToPaddr(String.format("%016X", rva).toUpperCase());
			if(strLma!=null){
				lma	= getStringToLong(strLma, false);
			}
			
			while(dataSizeCount < dataSize) {				
				//0x00	Variable	addr[]
				name		= "addr"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size		= ELF64_ADDR_SIZE;
				value		= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				if(getVaddrToFileoffset(value, false)!=null){
					analysis	+= "Raw=0x"+getVaddrToFileoffset(value, false)+"\n";
				}else if(getStringToLong(value, false)!=0){
					checkFlag	= true;
				}
				notes		= ELF_DYNAMIC_Entry_Addr_Array_Notes;	
				beforesize	= size;
				
				EPlusViewerTreeTableRecord Addr	= null;
				if(rva!=0 && lma!=0){
					Addr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					Addr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					Addr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> Addr_Item	= new TreeItem<>(Addr);
//				Addr_Item.setExpanded(true);
				item.getChildren().add(Addr_Item);
					
				//チェックあり
				if(checkFlag){
					Addr.setCheck("*");
				}
				
				count++;
				dataSizeCount	+= ELF64_ADDR_SIZE;
				checkFlag		= false;
			}
		}		
	}
	
	private void makeElfDynamicSymbolTable(TreeItem<EPlusViewerTreeTableRecord> item, String strSymVaddr, String strSymEntSize, String strStrVaddr ,String strStrDataSize){
		
		if(ELFCLASS==ELFCLASS32){	//32bit
			//開始アドレス取得
			int startAddr32	= getStringToInt(getVaddrToFileoffset(strSymVaddr, false), false);

			//サイズ取得用
			int entSize			= getStringToInt(strSymEntSize, false);
			int strDataSize		= getStringToInt(strStrDataSize, false);
			
			//データ取得用
			int dataSize	= 0;
			byte[] data		= null;
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			int rva			= 0;
			int lma			= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			int v			= 0;
			long vl			= 0;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;
			
			//カウント
			int count		= 0;
			
			//戻り値格納用
			String rtnStrVal	= null;
			
			//取得用
			String stValue	= "";
			String stSize	= "";
			int sttBind		= 0;
			int sttType		= 0;
			int stShndx		= 0;
			
			//アドレス設定
			rawAddr			= startAddr32;
			rva				= getStringToInt(strSymVaddr, false);
			String strLma	= getVaddrToPaddr(String.format("%08X", rva).toUpperCase());
			if(strLma!=null){
				lma			= getStringToInt(strLma, false);
			}
					
			//最初のデータ取得
			data	= getBintableBytes(startAddr32, entSize);
				
			
			while(true){	
				//ELF_DYNAMIC_SYMBOL_TABLE
				name		= "ELF_DYNAMIC_SYMBOL_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size		= entSize;
				value		= "";
				analysis	= "";
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_DYNAMIC_SYMBOL_TABLE	= null;
				if(rva!=0 && lma!=0){
					ELF_DYNAMIC_SYMBOL_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					ELF_DYNAMIC_SYMBOL_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					ELF_DYNAMIC_SYMBOL_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> ELF_DYNAMIC_SYMBOL_TABLE_Item 	= new TreeItem<>(ELF_DYNAMIC_SYMBOL_TABLE);
//				ELF_DYNAMIC_SYMBOL_TABLE_Item.setExpanded(true);
				
				
				//0x00	Elf32_Word	st_name
				name	= "st_name";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				v			=  getStringToInt(value, false);
				analysis	= "";
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_st_name_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_name	= null;
				if(rva!=0 && lma!=0){
					st_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					st_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					st_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> st_name_Item	= new TreeItem<>(st_name);
//				st_name_Item.setExpanded(true);
				ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().add(st_name_Item);
						
				//name取得
				if(v>=0 && v<strDataSize){
					rtnStrVal = makeDynamicSymbolName(st_name_Item, strStrVaddr, strStrDataSize, v);
					ELF_DYNAMIC_SYMBOL_TABLE.setName(ELF_DYNAMIC_SYMBOL_TABLE.getName()+":"+rtnStrVal);
				}else{
					//データがおかしいので抜ける
					break;
				}
				

				//0x04	Elf32_Addr	st_value
				name	= "st_value";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size	= ELF32_ADDR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_st_value_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_value	= null;
				if(rva!=0 && lma!=0){
					st_value	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					st_value	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					st_value	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> st_value_Item	= new TreeItem<>(st_value);
//				st_value_Item.setExpanded(true);
				ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().add(st_value_Item);
				
				//st_value取得
				stValue	= value;
				
				
				//0x08	Elf32_Word	st_size
				name	= "st_size";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				analysis	= String.valueOf(v)+" bytes";
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_st_size_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_size	= null;
				if(rva!=0 && lma!=0){
					st_size	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					st_size	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					st_size	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> st_size_Item	= new TreeItem<>(st_size);
//				st_size_Item.setExpanded(true);
				ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().add(st_size_Item);					
				
				//st_size取得
				stSize	= value;
				
				
				//0x0c	unsigned char	st_info
				name	= "st_info";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size	= UNSIGNED_CHAR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				byte vb		= data[offset+size-1];						
				//上位4bit
				if((vb>>4)==0){
					analysis	+= "STB_LOCAL(0x0)"+"\n";
				}else if((vb>>4)==STB_GLOBAL){
					analysis	+= "STB_GLOBAL(0x1)"+"\n";
				}else if((vb>>4)==STB_WEAK){
					analysis	+= "STB_WEAK(0x2)"+"\n";
				}else{
					//データがおかしいので抜ける
					break;
				}
				//下位4bit
				if((vb&0xf)==0){
					analysis	+= "STT_NOTYPE(0x0)"+"\n";
				}else if((vb&0xf)==STT_OBJECT){
					analysis	+= "STT_OBJECT(0x1)"+"\n";
				}else if((vb&0xf)==STT_FUNC){
					analysis	+= "STT_FUNC(0x2)"+"\n";
				}else if((vb&0xf)==STT_SECTION){
					analysis	+= "STT_SECTION(0x3)"+"\n";
				}else if((vb&0xf)==STT_FILE){
					analysis	+= "STT_FILE(0x4)"+"\n";
				}else if((vb&0xf)==STT_COMMON){
					analysis	+= "STT_COMMON(0x5)"+"\n";
				}else if((vb&0xf)==STT_TLS){
					analysis	+= "STT_TLS(0x6)"+"\n";
				}
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_st_info_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_info	= null;
				if(rva!=0 && lma!=0){
					st_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					st_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					st_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> st_info_Item	= new TreeItem<>(st_info);
//				st_info_Item.setExpanded(true);
				ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().add(st_info_Item);
				
				//stt_bindとstt_type取得
				sttBind	= vb>>4;
				sttType	= vb&0xf;
				
				
				//0x0d	unsigned char	st_other
				name	= "st_other";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size	= UNSIGNED_CHAR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_st_other_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_other	= null;
				if(rva!=0 && lma!=0){
					st_other	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					st_other	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					st_other	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> st_other_Item	= new TreeItem<>(st_other);
//				st_other_Item.setExpanded(true);
				ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().add(st_other_Item);
			
				
				//0x0e	Elf32_Half	st_shndx
				name	= "st_shndx";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size	= ELF32_HALF_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				v			= v&0xffff;
				if(v==0){
					analysis	+= "SHN_UNDEF(0x0)";
				}else if(v==SHN_LORESERVE || v==SHN_LOPROC || v==SHN_BEFORE){
					analysis	+= "SHN_LORESERVE(0xff00),SHN_LOPROC(0xff00),SHN_BEFORE(0xff00)";
				}else if(v==SHN_AFTER){
					analysis	+= "SHN_AFTER(0xff01)";			
				}else if(v==SHN_HIPROC){
					analysis	+= "SHN_HIPROC(0xff1f)";
				}else if(v==SHN_ABS){
					analysis	+= "SHN_ABS(0xfff1)";
				}else if(v==SHN_COMMON){
					analysis	+= "SHN_COMMON(0xfff2)";
				}else if(v==SHN_HIRESERVE){
					analysis	+= "SHN_HIRESERVE(0xffff)";
				}else if(v>ELF_SHDR_NUM){
					//データがおかしいので抜ける
					break;
				}
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_st_shndx_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_shndx	= null;
				if(rva!=0 && lma!=0){
					st_shndx	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					st_shndx	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					st_shndx	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> st_shndx_Item	= new TreeItem<>(st_shndx);
//				st_shndx_Item.setExpanded(true);
				ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().add(st_shndx_Item);
				
				//st_shndx取得
				stShndx	= v;
				

				//問題なければ追加
				item.getChildren().add(ELF_DYNAMIC_SYMBOL_TABLE_Item);

				
				//st_valueの参照先を作成
				if(E_TYPE==ET_REL || E_TYPE==ET_DYN || E_TYPE==ET_EXEC || E_TYPE==ET_CORE){			
					if(sttType==STT_OBJECT || sttType==STT_FUNC){
						if(getStringToInt(stSize, false)>0 && stShndx>0 && stShndx<ELF_SHDR_NUM){		
							String address			= null;
							String vaddress			= stValue;
							if(getVaddrToFileoffset(stValue, false)!=null){
								if(sttType==STT_OBJECT){								
									//Data作成
									makeData(st_value_Item, address, vaddress, stSize, true);
								}else if(sttType==STT_FUNC){
									//Data作成
									makeData(st_value_Item, address, vaddress, stSize, false);
								}
							}
						}
					}
				}else{
					//なにもしない
				}

				count++;
				
				//次のデータも含めて取得する
				data	= getBintableBytes(startAddr32, entSize*(count+1));	
			}
			
		}else if(ELFCLASS==ELFCLASS64){	//64bit
			//開始アドレス取得
			long startAddr64	= getStringToLong(getVaddrToFileoffset(strSymVaddr, false), false);
			int startAddr32		= (int)startAddr64;
			
			//サイズ用
			int entSize			= (int)getStringToLong(strSymEntSize, false);
			int strDataSize		= (int)getStringToLong(strStrDataSize, false);	
			
			//データ取得用
			int dataSize	= 0;
			byte[] data		= null;
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			long rva		= 0;
			long lma		= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			int v			= 0;
			long vl			= 0;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;
			
			//カウント
			int count		= 0;
			
			//戻り値格納用
			String rtnStrVal	= null;
			
			//取得用
			String stValue	= "";
			String stSize	= "";
			int sttBind		= 0;
			int sttType		= 0;
			int stShndx		= 0;
			
			//アドレス設定
			rawAddr			= startAddr32;
			rva				= getStringToLong(strSymVaddr, false);
			String strLma	= getVaddrToPaddr(String.format("%016X", rva).toUpperCase());
			if(strLma!=null){
				lma			= getStringToLong(strLma, false);
			}
					
			//最初のデータ取得
			data	= getBintableBytes(startAddr32, entSize);			
			
			while(true){		
				//ELF_DYNAMIC_SYMBOL_TABLE
				name		= "ELF_DYNAMIC_SYMBOL_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size		= entSize;
				value		= "";
				analysis	= "";
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_DYNAMIC_SYMBOL_TABLE	= null;
				if(rva!=0 && lma!=0){
					ELF_DYNAMIC_SYMBOL_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					ELF_DYNAMIC_SYMBOL_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					ELF_DYNAMIC_SYMBOL_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> ELF_DYNAMIC_SYMBOL_TABLE_Item 	= new TreeItem<>(ELF_DYNAMIC_SYMBOL_TABLE);
//				ELF_DYNAMIC_SYMBOL_TABLE_Item.setExpanded(true);
				
				
				//0x00	Elf64_Word	st_name
				name	= "st_name";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				v			= getStringToInt(value, false);
				analysis	= "";
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_st_name_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_name	= null;
				if(rva!=0 && lma!=0){
					st_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					st_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);			
				}
				TreeItem<EPlusViewerTreeTableRecord> st_name_Item	= new TreeItem<>(st_name);
//				st_name_Item.setExpanded(true);
				ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().add(st_name_Item);

				//name取得
				if(v>=0 && v<strDataSize){
					rtnStrVal = makeDynamicSymbolName(st_name_Item, strStrVaddr, strStrDataSize, v);
					ELF_DYNAMIC_SYMBOL_TABLE.setName(ELF_DYNAMIC_SYMBOL_TABLE.getName()+":"+rtnStrVal);
				}else{
					//データがおかしいので抜ける
					break;
				}
				
				
				//0x04	unsigned char	st_info
				name	= "st_info";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= UNSIGNED_CHAR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				byte vb		= data[offset+size-1];	
				//上位4bit
				if((vb>>4)==0){
					analysis	+= "STB_LOCAL(0x0)"+"\n";
				}else if((vb>>4)==STB_GLOBAL){
					analysis	+= "STB_GLOBAL(0x1)"+"\n";
				}else if((vb>>4)==STB_WEAK){
					analysis	+= "STB_WEAK(0x2)"+"\n";
				}else{
					//データがおかしいので抜ける
					break;
				}			
				//下位4bit
				if((vb&0xf)==0){
					analysis	+= "STT_NOTYPE(0x0)"+"\n";
				}else if((vb&0xf)==STT_OBJECT){
					analysis	+= "STT_OBJECT(0x1)"+"\n";
				}else if((vb&0xf)==STT_FUNC){
					analysis	+= "STT_FUNC(0x2)"+"\n";
				}else if((vb&0xf)==STT_SECTION){
					analysis	+= "STT_SECTION(0x3)"+"\n";
				}else if((vb&0xf)==STT_FILE){
					analysis	+= "STT_FILE(0x4)"+"\n";
				}else if((vb&0xf)==STT_COMMON){
					analysis	+= "STT_COMMON(0x5)"+"\n";
				}else if((vb&0xf)==STT_TLS){
					analysis	+= "STT_TLS(0x6)"+"\n";
				}					
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_st_info_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_info	= null;
				if(rva!=0 && lma!=0){
					st_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);	
				}else if(rva!=0){
					st_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}
				TreeItem<EPlusViewerTreeTableRecord> st_info_Item	= new TreeItem<>(st_info);
//				st_info_Item.setExpanded(true);
				ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().add(st_info_Item);
				
				//stt_bindとstt_type取得
				sttBind	= vb>>4;
				sttType	= vb&0xf;
				
				
				//0x05	unsigned char	st_other
				name	= "st_other";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= UNSIGNED_CHAR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_st_other_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_other	= null;
				if(rva!=0 && lma!=0){
					st_other	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);	
				}else if(rva!=0){
					st_other	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_other	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}
				TreeItem<EPlusViewerTreeTableRecord> st_other_Item	= new TreeItem<>(st_other);
//				st_other_Item.setExpanded(true);
				ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().add(st_other_Item);
			
				
				//0x06	Elf64_Half	st_shndx
				name	= "st_shndx";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_HALF_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				v			= v&0xffff;
				if(v==0){
					analysis	+= "SHN_UNDEF(0x0)";
				}else if(v==SHN_LORESERVE || v==SHN_LOPROC || v==SHN_BEFORE){
					analysis	+= "SHN_LORESERVE(0xff00),SHN_LOPROC(0xff00),SHN_BEFORE(0xff00)";
				}else if(v==SHN_AFTER){
					analysis	+= "SHN_AFTER(0xff01)";			
				}else if(v==SHN_HIPROC){
					analysis	+= "SHN_HIPROC(0xff1f)";
				}else if(v==SHN_ABS){
					analysis	+= "SHN_ABS(0xfff1)";
				}else if(v==SHN_COMMON){
					analysis	+= "SHN_COMMON(0xfff2)";
				}else if(v==SHN_HIRESERVE){
					analysis	+= "SHN_HIRESERVE(0xffff)";
				}else if(v>ELF_SHDR_NUM){
					//データがおかしいので抜ける
					break;
				}
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_st_shndx_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_shndx	= null;
				if(rva!=0 && lma!=0){
					st_shndx	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_shndx	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_shndx	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> st_shndx_Item	= new TreeItem<>(st_shndx);
//				st_shndx_Item.setExpanded(true);
				ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().add(st_shndx_Item);

				//st_shndx取得
				stShndx	= v;
				
				
				//0x08	Elf64_Addr	st_value
				name	= "st_value";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_ADDR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_st_value_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_value	= null;
				if(rva!=0 && lma!=0){
					st_value	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_value	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_value	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> st_value_Item	= new TreeItem<>(st_value);
//				st_value_Item.setExpanded(true);
				ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().add(st_value_Item);
				
				//st_value取得
				stValue	= value;
				
				
				//0x10	Elf64_Xword	st_size
				name	= "st_size";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_XWORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				vl			= getStringToLong(value, false);
				analysis	= String.valueOf(vl)+" bytes";
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_st_size_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_size	= null;
				if(rva!=0 && lma!=0){
					st_size	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_size	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_size	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> st_size_Item	= new TreeItem<>(st_size);
//				st_size_Item.setExpanded(true);
				ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().add(st_size_Item);					
					
				//st_size取得
				stSize	= value;
				
				
				//問題なければ追加
				item.getChildren().add(ELF_DYNAMIC_SYMBOL_TABLE_Item);
				
				//st_valueの参照先を作成
				if(E_TYPE==ET_REL || E_TYPE==ET_DYN || E_TYPE==ET_EXEC || E_TYPE==ET_CORE){			
					if(sttType==STT_OBJECT || sttType==STT_FUNC){
						if(getStringToLong(stSize, false)>0 && stShndx>0 && stShndx<ELF_SHDR_NUM){
							String address		= null;
							String vaddress		= stValue;
							if(getVaddrToFileoffset(stValue, false)!=null){
								if(sttType==STT_OBJECT){
									//Data作成
									makeData(st_value_Item, address, vaddress, stSize, true);
								}else if(sttType==STT_FUNC){
									//Data作成
									makeData(st_value_Item, address, vaddress, stSize, false);
								}
							}
						}
					}
				}else{
					//なにもしない
				}
				
				count++;
				
				//次のデータも含めて取得する
				data	= getBintableBytes(startAddr32, entSize*(count+1));	
			}
		}
	}
	
	private void makeElfRelocationAddendTable(TreeItem<EPlusViewerTreeTableRecord> item, String strRelaVaddr, String strRelaDataSize, String strRelaEntSize, TreeItem<EPlusViewerTreeTableRecord> DT_SYMTAB_item){

		if(ELFCLASS==ELFCLASS32){	//32bit	
			//開始アドレス取得
			int startAddr32	= getStringToInt(getVaddrToFileoffset(strRelaVaddr, false), false);
			
			//エントリサイズ
			int entSize		= getStringToInt(strRelaEntSize, false);
			
			//データ取得用
			int dataSize	= getStringToInt(strRelaDataSize, false);
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			int rva			= 0;
			int lma			= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			int v			= 0;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;
			
			//カウント
			int count		= 0;
			
			//取得用
			String rOffset	= null;
			
			//アドレス設定
			rawAddr			= startAddr32;
			rva				= getStringToInt(strRelaVaddr, false);
			String strLma	= getVaddrToPaddr(String.format("%08X", rva).toUpperCase());
			if(strLma!=null){
				lma			= getStringToInt(strLma, false);
			}
			
			for(int c=0; c<dataSize; c+=entSize){								
				//ELF_RELOCATION_ADDEND_TABLE
				name		= "ELF_RELOCATION_ADDEND_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size		= entSize;
				value		= "";
				analysis	= "";
				notes		= ELF_RELOCATION_ADDEND_TABLE_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_RELOCATION_ADDEND_TABLE	= null;
				if(rva!=0 && lma!=0){
					ELF_RELOCATION_ADDEND_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					ELF_RELOCATION_ADDEND_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					ELF_RELOCATION_ADDEND_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> ELF_RELOCATION_ADDEND_TABLE_Item 	= new TreeItem<>(ELF_RELOCATION_ADDEND_TABLE);
//				ELF_RELOCATION_ADDEND_TABLE_Item.setExpanded(true);
				item.getChildren().add(ELF_RELOCATION_ADDEND_TABLE_Item);
				
				
				//0x00	Elf32_Addr	r_offset
				name	= "r_offset";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF32_ADDR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_RELOCATION_ADDEND_TABLE_r_offset_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord r_offset	= null;
				if(rva!=0 && lma!=0){
					r_offset	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					r_offset	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					r_offset	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> r_offset_Item	= new TreeItem<>(r_offset);
//				r_offset_Item.setExpanded(true);
				ELF_RELOCATION_ADDEND_TABLE_Item.getChildren().add(r_offset_Item);
			
				//r_offset取得
				rOffset	= value;
				
			
				//0x04	Elf32_Word	r_info
				name	= "r_info";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);				
				analysis	+= "R_SYM=0x"+(v>>8)+"\n";
				if(DT_SYMTAB_item!=null && (v>>8)>0){
					analysis	+= "=>"+DT_SYMTAB_item.getChildren().get(1).getChildren().get(v>>8).getValue().getName()+"\n";;
				
					//シンボル名を設定
					int symindex	= DT_SYMTAB_item.getChildren().get(1).getChildren().get(v>>8).getValue().getName().indexOf(":");
					if(symindex!=-1){
						String symname	= DT_SYMTAB_item.getChildren().get(1).getChildren().get(v>>8).getValue().getName().substring(symindex);
						ELF_RELOCATION_ADDEND_TABLE.setName(ELF_RELOCATION_ADDEND_TABLE.getName()+symname);
					}
				}
				analysis	+= "R_TYPE=0x"+(v&0xff)+"\n";
				if((v&0xff)==R_386_NONE){
					analysis	+= "=>R_386_NONE(0)"+"\n";
				}else if((v&0xff)==R_386_32){
					analysis	+= "=>R_386_32(1)"+"\n";
				}else if((v&0xff)==R_386_PC32){
					analysis	+= "=>R_386_PC32(2)"+"\n";
				}else if((v&0xff)==R_386_GOT32){
					analysis	+= "=>R_386_GOT32(3)"+"\n";
				}else if((v&0xff)==R_386_PLT32){
					analysis	+= "=>R_386_PLT32(4)"+"\n";
				}else if((v&0xff)==R_386_COPY){
					analysis	+= "=>R_386_COPY(5)"+"\n";
				}else if((v&0xff)==R_386_GLOB_DAT){
					analysis	+= "=>R_386_GLOB_DAT(6)"+"\n";
				}else if((v&0xff)==R_386_JMP_SLOT){
					analysis	+= "=>R_386_JMP_SLOT(7)"+"\n";
				}else if((v&0xff)==R_386_RELATIVE){
					analysis	+= "=>R_386_RELATIVE(8)"+"\n";
				}else if((v&0xff)==R_386_GOTOFF){
					analysis	+= "=>R_386_GOTOFF(9)"+"\n";
				}else if((v&0xff)==R_386_GOTPC){
					analysis	+= "=>R_386_GOTPC(10)"+"\n";
				}else if((v&0xff)==R_386_NUM){
					analysis	+= "=>R_386_NUM(16)"+"\n";
				}
				notes		= ELF_RELOCATION_ADDEND_TABLE_r_info_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord r_info	= null;
				if(rva!=0 && lma!=0){
					r_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					r_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					r_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> r_info_Item	= new TreeItem<>(r_info);
//				r_info_Item.setExpanded(true);
				ELF_RELOCATION_ADDEND_TABLE_Item.getChildren().add(r_info_Item);				
							
				if((v&0xff)!=R_386_COPY){
					//参照先のアドレスデータを作成
					makeR_OffsetAddr(r_offset_Item, rOffset);
				}

				
				//0x08	Elf32_Sword	r_addend
				name	= "r_addend";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF32_SWORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_RELOCATION_ADDEND_TABLE_r_addend_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord r_addend	= null;
				if(rva!=0 && lma!=0){
					r_addend	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					r_addend	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else {
					r_addend	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> r_addend_Item	= new TreeItem<>(r_addend);
//				r_addend_Item.setExpanded(true);
				ELF_RELOCATION_ADDEND_TABLE_Item.getChildren().add(r_addend_Item);
				
				count++;
			}
		}else if(ELFCLASS==ELFCLASS64){	//64bit
			//開始アドレス取得
			long startAddr64	= getStringToLong(getVaddrToFileoffset(strRelaVaddr, false), false);
			int startAddr32		= (int)startAddr64;
			
			//エントリサイズ
			int entSize		= (int)getStringToLong(strRelaEntSize, false);
			
			//データ取得用
			int dataSize	= (int)getStringToLong(strRelaDataSize, false);
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			long rva		= 0;
			long lma		= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			long vl			= 0;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;
			
			//カウント
			int count		= 0;
			
			//取得用
			String rOffset	= null;
			
			//アドレス設定
			rawAddr			= startAddr32;
			rva				= getStringToLong(strRelaVaddr, false);
			String strLma	= getVaddrToPaddr(String.format("%016X", rva).toUpperCase());
			if(strLma!=null){
				lma			= getStringToLong(strLma, false);
			}
			
			for(int c=0; c<dataSize; c+=entSize){								
				//ELF_RELOCATION_ADDEND_TABLE
				name		= "ELF_RELOCATION_ADDEND_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size		= entSize;
				value		= "";
				analysis	= "";
				notes		= ELF_RELOCATION_ADDEND_TABLE_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_RELOCATION_ADDEND_TABLE	= null;
				if(rva!=0 && lma!=0){
					ELF_RELOCATION_ADDEND_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					ELF_RELOCATION_ADDEND_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					ELF_RELOCATION_ADDEND_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> ELF_RELOCATION_ADDEND_TABLE_Item 	= new TreeItem<>(ELF_RELOCATION_ADDEND_TABLE);
//				ELF_RELOCATION_ADDEND_TABLE_Item.setExpanded(true);
				item.getChildren().add(ELF_RELOCATION_ADDEND_TABLE_Item);
				
				
				//0x00	Elf64_Addr	r_offset
				name	= "r_offset";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_ADDR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_RELOCATION_ADDEND_TABLE_r_offset_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord r_offset	= null;
				if(rva!=0 && lma!=0){
					r_offset	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					r_offset	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					r_offset	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> r_offset_Item	= new TreeItem<>(r_offset);
//				r_offset_Item.setExpanded(true);
				ELF_RELOCATION_ADDEND_TABLE_Item.getChildren().add(r_offset_Item);
			
				//r_offset取得
				rOffset	= value;
				
			
				//0x04	Elf64_Xword	r_info
				name	= "r_info";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_XWORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				vl			= getStringToLong(value, false);
				int r_type	= (int)(vl&0xffffffff);
				analysis	+= "R_SYM=0x"+(vl>>32)+"\n";
				if(DT_SYMTAB_item!=null && (vl>>32)>0){
					analysis	+= "=>"+DT_SYMTAB_item.getChildren().get(1).getChildren().get((int)(vl>>32)).getValue().getName()+"\n";;
				
					//シンボル名を設定
					int symindex	= DT_SYMTAB_item.getChildren().get(1).getChildren().get((int)(vl>>32)).getValue().getName().indexOf(":");
					if(symindex!=-1){
						String symname	= DT_SYMTAB_item.getChildren().get(1).getChildren().get((int)(vl>>32)).getValue().getName().substring(symindex);
						ELF_RELOCATION_ADDEND_TABLE.setName(ELF_RELOCATION_ADDEND_TABLE.getName()+symname);
					}
				}
				analysis	+= "R_TYPE=0x"+r_type+"\n";
				if(r_type==R_X86_64_NONE){
					analysis	+= "=>R_X86_64_NONE(0)"+"\n";
				}else if(r_type==R_X86_64_64){
					analysis	+= "=>R_X86_64_64(1)"+"\n";
				}else if(r_type==R_X86_64_PC32){
					analysis	+= "=>R_X86_64_PC32(2)"+"\n";
				}else if(r_type==R_X86_64_GOT32){
					analysis	+= "=>R_X86_64_GOT32(3)"+"\n";
				}else if(r_type==R_X86_64_PLT32){
					analysis	+= "=>R_X86_64_PLT32(4)"+"\n";
				}else if(r_type==R_X86_64_COPY){
					analysis	+= "=>R_X86_64_COPY(5)"+"\n";
				}else if(r_type==R_X86_64_GLOB_DAT){
					analysis	+= "=>R_X86_64_GLOB_DAT(6)"+"\n";
				}else if(r_type==R_X86_64_JUMP_SLOT){
					analysis	+= "=>R_X86_64_JUMP_SLOT(7)"+"\n";
				}else if(r_type==R_X86_64_RELATIVE){
					analysis	+= "=>R_X86_64_RELATIVE(8)"+"\n";
				}else if(r_type==R_X86_64_GOTPCREL){
					analysis	+= "=>R_X86_64_GOTPCREL(9)"+"\n";
				}else if(r_type==R_X86_64_32){
					analysis	+= "=>R_X86_64_32(10)"+"\n";
				}else if(r_type==R_X86_64_32S){
					analysis	+= "=>R_X86_64_32S(11)"+"\n";
				}else if(r_type==R_X86_64_16){
					analysis	+= "=>R_X86_64_16(12)"+"\n";
				}else if(r_type==R_X86_64_PC16){
					analysis	+= "=>R_X86_64_PC16(13)"+"\n";
				}else if(r_type==R_X86_64_8){
					analysis	+= "=>R_X86_64_8(14)"+"\n";
				}else if(r_type==R_X86_64_PC8){
					analysis	+= "=>R_X86_64_PC8(15)"+"\n";
				}else if(r_type==R_X86_64_NUM){
					analysis	+= "=>R_X86_64_NUM(16)"+"\n";
				}
				notes		= ELF_RELOCATION_ADDEND_TABLE_r_info_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord r_info	= null;
				if(rva!=0 && lma!=0){
					r_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					r_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					r_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> r_info_Item	= new TreeItem<>(r_info);
//				r_info_Item.setExpanded(true);
				ELF_RELOCATION_ADDEND_TABLE_Item.getChildren().add(r_info_Item);				
				
				if(r_type!=R_X86_64_COPY){
					//参照先のアドレスデータを作成
					makeR_OffsetAddr(r_offset_Item, rOffset);
				}
				
				
				//0x08	Elf64_Sxword	r_addend
				name	= "r_addend";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_SXWORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_RELOCATION_ADDEND_TABLE_r_addend_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord r_addend	= null;
				if(rva!=0 && lma!=0){
					r_addend	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					r_addend	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					r_addend	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> r_addend_Item	= new TreeItem<>(r_addend);
//				r_addend_Item.setExpanded(true);
				ELF_RELOCATION_ADDEND_TABLE_Item.getChildren().add(r_addend_Item);
				
				count++;
			}
		}
	}
	
	private void makeElfRelocationTable(TreeItem<EPlusViewerTreeTableRecord> item, String strRelVaddr, String strRelDataSize, String strRelEntSize, TreeItem<EPlusViewerTreeTableRecord> DT_SYMTAB_item){
				
		if(ELFCLASS==ELFCLASS32){	//32bit
			//開始アドレス取得
			int startAddr32	= getStringToInt(getVaddrToFileoffset(strRelVaddr, false), false);
			
			//エントリサイズ
			int entSize			= getStringToInt(strRelEntSize, false);
			
			//データ取得用
			int dataSize	= getStringToInt(strRelDataSize, false);
			byte[] data		= null;
			
			//データ取得
			data		= getBintableBytes(startAddr32, dataSize);
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			int rva			= 0;
			int lma			= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			int v			= 0;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;
			
			//カウント
			int count		= 0;
			
			//取得用
			String rOffset	= null;
			
			//アドレス設定
			rawAddr			= startAddr32;
			rva				= getStringToInt(strRelVaddr, false);
			String strLma	= getVaddrToPaddr(String.format("%08X", rva).toUpperCase());
			if(strLma!=null){
				lma			= getStringToInt(strLma, false);
			}
			
			for(int c=0; c<dataSize; c+=entSize){			
				//ELF_RELOCATION_TABLE
				name		= "ELF_RELOCATION_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size		= entSize;
				value		= "";
				analysis	= "";
				notes		= ELF_RELOCATION_TABLE_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_RELOCATION_TABLE	= null;
				if(rva!=0 && lma!=0){
					ELF_RELOCATION_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					ELF_RELOCATION_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					ELF_RELOCATION_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> ELF_RELOCATION_TABLE_Item 	= new TreeItem<>(ELF_RELOCATION_TABLE);
//				ELF_RELOCATION_TABLE_Item.setExpanded(true);
				item.getChildren().add(ELF_RELOCATION_TABLE_Item);
				
				
				//0x00	Elf32_Addr	r_offset
				name	= "r_offset";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF32_ADDR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_RELOCATION_TABLE_r_offset_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord r_offset	= null;
				if(rva!=0 && lma!=0){
					r_offset	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					r_offset	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					r_offset	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> r_offset_Item	= new TreeItem<>(r_offset);
//				r_offset_Item.setExpanded(true);
				ELF_RELOCATION_TABLE_Item.getChildren().add(r_offset_Item);
			
				//r_offset取得
				rOffset	= value;
				

				//0x04	Elf32_Word	r_info
				name	= "r_info";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				analysis	+= "R_SYM=0x"+(v>>8)+"\n";
				if(DT_SYMTAB_item!=null && (v>>8)>0){
					analysis	+= "=>"+DT_SYMTAB_item.getChildren().get(1).getChildren().get(v>>8).getValue().getName()+"\n";
				
					//シンボル名を設定
					int symindex	= DT_SYMTAB_item.getChildren().get(1).getChildren().get(v>>8).getValue().getName().indexOf(":");
					if(symindex!=-1){
						String symname	= DT_SYMTAB_item.getChildren().get(1).getChildren().get(v>>8).getValue().getName().substring(symindex);
						ELF_RELOCATION_TABLE.setName(ELF_RELOCATION_TABLE.getName()+symname);
					}
				}
				analysis	+= "R_TYPE=0x"+(v&0xff)+"\n";
				if((v&0xff)==R_386_NONE){
					analysis	+= "=>R_386_NONE(0)"+"\n";
				}else if((v&0xff)==R_386_32){
					analysis	+= "=>R_386_32(1)"+"\n";
				}else if((v&0xff)==R_386_PC32){
					analysis	+= "=>R_386_PC32(2)"+"\n";
				}else if((v&0xff)==R_386_GOT32){
					analysis	+= "=>R_386_GOT32(3)"+"\n";
				}else if((v&0xff)==R_386_PLT32){
					analysis	+= "=>R_386_PLT32(4)"+"\n";
				}else if((v&0xff)==R_386_COPY){
					analysis	+= "=>R_386_COPY(5)"+"\n";
				}else if((v&0xff)==R_386_GLOB_DAT){
					analysis	+= "=>R_386_GLOB_DAT(6)"+"\n";
				}else if((v&0xff)==R_386_JMP_SLOT){
					analysis	+= "=>R_386_JMP_SLOT(7)"+"\n";
				}else if((v&0xff)==R_386_RELATIVE){
					analysis	+= "=>R_386_RELATIVE(8)"+"\n";
				}else if((v&0xff)==R_386_GOTOFF){
					analysis	+= "=>R_386_GOTOFF(9)"+"\n";
				}else if((v&0xff)==R_386_GOTPC){
					analysis	+= "=>R_386_GOTPC(10)"+"\n";
				}else if((v&0xff)==R_386_NUM){
					analysis	+= "=>R_386_NUM(16)"+"\n";
				}
				notes		= ELF_RELOCATION_ADDEND_TABLE_r_info_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord r_info	= null;
				if(rva!=0 && lma!=0){
					r_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					r_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					r_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> r_info_Item	= new TreeItem<>(r_info);
//				r_info_Item.setExpanded(true);
				ELF_RELOCATION_TABLE_Item.getChildren().add(r_info_Item);
			
				if((v&0xff)!=R_386_COPY){
					//参照先のアドレスデータを作成
					makeR_OffsetAddr(r_offset_Item, rOffset);
				}

				count++;
			}
		}else if(ELFCLASS==ELFCLASS64){	//64bit
			//開始アドレス取得
			long startAddr64	= getStringToLong(getVaddrToFileoffset(strRelVaddr, false), false);
			int startAddr32		= (int)startAddr64;
			
			//エントリサイズ
			int entSize		= (int)getStringToLong(strRelEntSize, false);
			
			//データ取得用
			int dataSize	= (int)getStringToLong(strRelDataSize, false);
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			long rva		= 0;
			long lma		= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			long vl			= 0;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;
			
			//カウント
			int count		= 0;
			
			//取得用
			String rOffset	= null;
			
			//アドレス設定
			rawAddr			= startAddr32;
			rva				= getStringToLong(strRelVaddr, false);
			String strLma	= getVaddrToPaddr(String.format("%016X", rva).toUpperCase());
			if(strLma!=null){
				lma			= getStringToLong(strLma, false);
			}
			
			for(int c=0; c<dataSize; c+=entSize){			
				//ELF_RELOCATION_TABLE
				name		= "ELF_RELOCATION_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size		= entSize;
				value		= "";
				analysis	= "";
				notes		= ELF_RELOCATION_TABLE_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_RELOCATION_TABLE	= null;
				if(rva!=0 && lma!=0){
					ELF_RELOCATION_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					ELF_RELOCATION_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					ELF_RELOCATION_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> ELF_RELOCATION_TABLE_Item 	= new TreeItem<>(ELF_RELOCATION_TABLE);
//				ELF_RELOCATION_TABLE_Item.setExpanded(true);
				item.getChildren().add(ELF_RELOCATION_TABLE_Item);
				
				
				//0x00	Elf64_Addr	r_offset
				name	= "r_offset";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_ADDR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_RELOCATION_TABLE_r_offset_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord r_offset	= null;
				if(rva!=0 && lma!=0){	
					r_offset	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					r_offset	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					r_offset	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> r_offset_Item	= new TreeItem<>(r_offset);
//				r_offset_Item.setExpanded(true);
				ELF_RELOCATION_TABLE_Item.getChildren().add(r_offset_Item);
			
				//r_offset取得
				rOffset	= value;
				
			
				//0x04	Elf64_Xword	r_info
				name	= "r_info";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_XWORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				vl			= getStringToLong(value, false);
				int r_type	= (int)(vl&0xffffffff);
				analysis	+= "R_SYM=0x"+(vl>>32)+"\n";
				if(DT_SYMTAB_item!=null && (vl>>32)>0){
					analysis	+= "=>"+DT_SYMTAB_item.getChildren().get(1).getChildren().get((int)(vl>>32)).getValue().getName()+"\n";;
				
					//シンボル名を設定
					int symindex	= DT_SYMTAB_item.getChildren().get(1).getChildren().get((int)(vl>>32)).getValue().getName().indexOf(":");
					if(symindex!=-1){
						String symname	= DT_SYMTAB_item.getChildren().get(1).getChildren().get((int)(vl>>32)).getValue().getName().substring(symindex);
						ELF_RELOCATION_TABLE.setName(ELF_RELOCATION_TABLE.getName()+symname);
					}
				}
				analysis	+= "R_TYPE=0x"+r_type+"\n";
				if(r_type==R_X86_64_NONE){
					analysis	+= "=>R_X86_64_NONE(0)"+"\n";
				}else if(r_type==R_X86_64_64){
					analysis	+= "=>R_X86_64_64(1)"+"\n";
				}else if(r_type==R_X86_64_PC32){
					analysis	+= "=>R_X86_64_PC32(2)"+"\n";
				}else if(r_type==R_X86_64_GOT32){
					analysis	+= "=>R_X86_64_GOT32(3)"+"\n";
				}else if(r_type==R_X86_64_PLT32){
					analysis	+= "=>R_X86_64_PLT32(4)"+"\n";
				}else if(r_type==R_X86_64_COPY){
					analysis	+= "=>R_X86_64_COPY(5)"+"\n";
				}else if(r_type==R_X86_64_GLOB_DAT){
					analysis	+= "=>R_X86_64_GLOB_DAT(6)"+"\n";
				}else if(r_type==R_X86_64_JUMP_SLOT){
					analysis	+= "=>R_X86_64_JUMP_SLOT(7)"+"\n";
				}else if(r_type==R_X86_64_RELATIVE){
					analysis	+= "=>R_X86_64_RELATIVE(8)"+"\n";
				}else if(r_type==R_X86_64_GOTPCREL){
					analysis	+= "=>R_X86_64_GOTPCREL(9)"+"\n";
				}else if(r_type==R_X86_64_32){
					analysis	+= "=>R_X86_64_32(10)"+"\n";
				}else if(r_type==R_X86_64_32S){
					analysis	+= "=>R_X86_64_32S(11)"+"\n";
				}else if(r_type==R_X86_64_16){
					analysis	+= "=>R_X86_64_16(12)"+"\n";
				}else if(r_type==R_X86_64_PC16){
					analysis	+= "=>R_X86_64_PC16(13)"+"\n";
				}else if(r_type==R_X86_64_8){
					analysis	+= "=>R_X86_64_8(14)"+"\n";
				}else if(r_type==R_X86_64_PC8){
					analysis	+= "=>R_X86_64_PC8(15)"+"\n";
				}else if(r_type==R_X86_64_NUM){
					analysis	+= "=>R_X86_64_NUM(16)"+"\n";
				}
				notes		= ELF_RELOCATION_ADDEND_TABLE_r_info_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord r_info	= null;
				if(rva!=0 && lma!=0){
					r_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					r_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					r_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> r_info_Item	= new TreeItem<>(r_info);
//				r_info_Item.setExpanded(true);
				ELF_RELOCATION_TABLE_Item.getChildren().add(r_info_Item);
			
				if(r_type!=R_X86_64_COPY){
					//参照先のアドレスデータを作成
					makeR_OffsetAddr(r_offset_Item, rOffset);
				}
				
				count++;
			}
		}
	}
	
	private void makeR_OffsetAddr(TreeItem<EPlusViewerTreeTableRecord> item, String r_offset){
			
		if(ELFCLASS==ELFCLASS32){	//32bit	
			//開始アドレス取得
			int startAddr32		= 0; 
			String fileOffset	= getVaddrToFileoffset(r_offset, false);
			if(fileOffset!=null){
				startAddr32	= getStringToInt(fileOffset, false);
			}else{
				//ファイルにないなら終了
				return;
			}
			
			//データ取得用
			int dataSize	= ELF32_ADDR_SIZE;
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
			
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			int rva			= 0;
			int lma			= 0;
			int offset		= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			String strLma	= null;
			
			//チェックフラグ
			boolean checkFlag	= false;

							
			//0x00	Elf32_Addr	addr
			name	= "addr";
			rawAddr	= startAddr32;
			raw		= rawAddr;
			offset	= 0x0;
			if(getStringToInt(r_offset, false)!=0){
				rva		= getStringToInt(r_offset, false);
				strLma	= getVaddrToPaddr(String.format("%08X", rva).toUpperCase());
			}
			if(strLma!=null){
				lma		= getStringToInt(strLma, false);
			}
			size	= ELF32_ADDR_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			if(getVaddrToFileoffset(value, false)!=null){
				analysis	+= "Raw=0x"+getVaddrToFileoffset(value, false)+"\n";
			}else if(getStringToInt(value, false)!=0){
				checkFlag	= true;
			}
			notes		= R_offset_Addr_Notes;
			
			EPlusViewerTreeTableRecord addr	= null;
			if(rva!=0 && lma!=0){
				addr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			}else if(rva!=0){
				addr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}else{
				addr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}
			TreeItem<EPlusViewerTreeTableRecord> addr_Item	= new TreeItem<>(addr);
//			addr_Item.setExpanded(true);
			item.getChildren().add(addr_Item);
			
			//チェックあり
			if(checkFlag){
				addr.setCheck("*");
			}

		}else if(ELFCLASS==ELFCLASS64){	//64bit
			//開始アドレス取得
			long startAddr64	= 0;
			int startAddr32		= 0;
			String fileOffset	= getVaddrToFileoffset(r_offset, false);
			if(fileOffset!=null){
				startAddr64	= getStringToLong(fileOffset, false);
				startAddr32	= (int)startAddr64;
			}else{
				//ファイルにないなら終了
				return;
			}
			
			//データ取得用
			int dataSize	= ELF64_ADDR_SIZE;
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
			
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			long rva		= 0;
			long lma		= 0;
			int offset		= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			String strLma	= null;
			
			//チェックフラグ
			boolean checkFlag	= false;
			
			
			//0x00	Elf64_Addr	addr
			name	= "addr";
			rawAddr	= startAddr32;
			raw		= rawAddr;
			offset	= 0x0;
			if(getStringToLong(r_offset, false)!=0){
				rva		= getStringToLong(r_offset, false);
				strLma	= getVaddrToPaddr(String.format("%016X", rva).toUpperCase());
			}
			if(strLma!=null){
				lma			= getStringToLong(strLma, false);
			}
			size	= ELF64_ADDR_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			if(getVaddrToFileoffset(value, false)!=null){
				analysis	+= "Raw=0x"+getVaddrToFileoffset(value, false)+"\n";
			}else if(getStringToLong(value, false)!=0){
				checkFlag	= true;
			}
			notes		= R_offset_Addr_Notes;
			
			EPlusViewerTreeTableRecord addr	= null;
			if(rva!=0 && lma!=0){
				addr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			}else if(rva!=0){
				addr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}else{
				addr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}
			TreeItem<EPlusViewerTreeTableRecord> addr_Item	= new TreeItem<>(addr);
//			addr_Item.setExpanded(true);
			item.getChildren().add(addr_Item);
			
			//チェックあり
			if(checkFlag){
				addr.setCheck("*");
			}
		}
	}
	
	private void makeElfNote(TreeItem<EPlusViewerTreeTableRecord> item, ProgramHeader ph){
		
		if(ELFCLASS==ELFCLASS32){	//32bit	
			//開始アドレス取得
			int startAddr32	= ph.getP_offset_int();
			
			//データ取得用
			int dataSize	= ph.getP_filesz_int();
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			int rva			= 0;
			int lma			= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			int v			= 0;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;

			//カウント
			int count		= 0;
			int sizeCount	= 0;
			
			//取得用
			int nameSize_int		= 0;
			int descSize_int		= 0;
			int alimentNameSize_int	= 0;
			int alimentDescSize_int	= 0;
			int quotient_int		= 0;
			int remainder_int		= 0;
			
			//アドレス設定
			rawAddr		= startAddr32;
			rva			= ph.getP_vaddr_int();
			lma			= ph.getP_paddr_int();
		
			for(int c=0; c<dataSize; c+=sizeCount){				
				//ELF_NOTE
				name		= "ELF_NOTE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size		= dataSize;
				value		= "";
				analysis	= "";
				notes		= ELF_NOTE_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_NOTE	= null;
				if(rva!=0 && lma!=0){
					ELF_NOTE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					ELF_NOTE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					ELF_NOTE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> ELF_NOTE_Item 	= new TreeItem<>(ELF_NOTE);
//				ELF_NOTE_Item.setExpanded(true);
				item.getChildren().add(ELF_NOTE_Item);
				
				//サイズカウント初期化
				sizeCount	=	0;
				
				
				//0x00	Elf32_Word	n_namesz
				name	= "n_namesz";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				analysis	= String.valueOf(v)+ " bytes";			
				notes		= ELF_NOTE_n_namesz_Notes;
				beforesize	= size;
				nameSize_int = v;
				sizeCount	+= size;
				
				EPlusViewerTreeTableRecord n_namesz	= null;
				if(rva!=0 && lma!=0){
					n_namesz	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					n_namesz	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					n_namesz	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> n_namesz_Item	= new TreeItem<>(n_namesz);
//				n_namesz_Item.setExpanded(true);
				ELF_NOTE_Item.getChildren().add(n_namesz_Item);
					
				//サイズ計算
				quotient_int	= nameSize_int/ELF32_WORD_SIZE;
				remainder_int	= nameSize_int%ELF32_WORD_SIZE;			
				if(quotient_int!=0&&remainder_int>0){
					alimentNameSize_int	= (quotient_int+1)*ELF32_WORD_SIZE;
				}else if(quotient_int!=0&&remainder_int==0){
					alimentNameSize_int	= quotient_int*ELF32_WORD_SIZE;
				}else {
					alimentNameSize_int	= 0;
				}
				
				
				//0x04	Elf32_Word	n_descsz
				name	= "n_descsz";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				analysis	= String.valueOf(v)+ " bytes";			
				notes		= ELF_NOTE_n_descsz_Notes;
				beforesize	= size;
				descSize_int = v;
				sizeCount	+= size;
				
				EPlusViewerTreeTableRecord n_descsz	= null;
				if(rva!=0 && lma!=0){
					n_descsz	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					n_descsz	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					n_descsz	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> n_descsz_Item	= new TreeItem<>(n_descsz);
//				n_descsz_Item.setExpanded(true);
				ELF_NOTE_Item.getChildren().add(n_descsz_Item);
				
				//サイズ計算
				quotient_int	= descSize_int/ELF32_WORD_SIZE;
				remainder_int	= descSize_int%ELF32_WORD_SIZE;			
				if(quotient_int!=0&&remainder_int>0){
					alimentDescSize_int	= (quotient_int+1)*ELF32_WORD_SIZE;
				}else if(quotient_int!=0&&remainder_int==0){
					alimentDescSize_int	= quotient_int*ELF32_WORD_SIZE;
				}else{
					alimentDescSize_int = 0;
				}
				
				
				//0x08	Elf32_Word	n_type
				name	= "n_type";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";			
				notes		= ELF_NOTE_n_type_Notes;
				beforesize	= size;
				sizeCount	+= size;
				
				EPlusViewerTreeTableRecord n_type	= null;
				if(rva!=0 && lma!=0){
					n_type	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);	
				}else if(rva!=0){
					n_type	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					n_type	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> n_type_Item	= new TreeItem<>(n_type);
//				n_descsz_Item.setExpanded(true);
				ELF_NOTE_Item.getChildren().add(n_type_Item);
				
				
				if(alimentNameSize_int>0){			
					//0x0c	Variable	n_name
					name	= "n_name";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva		+= beforesize;
					}
					if(lma!=0){
						lma		+= beforesize;
					}
					size	= nameSize_int;
					value	= "";
					analysis = "";	
					for(int i=offset; i<offset+size; i++){
						value		+= String.format("%02X", data[i]).toUpperCase();
						analysis	+= String.format("%c", data[i]).toUpperCase();
					}	
					notes		= ELF_NOTE_n_name_Notes;
					beforesize	= alimentNameSize_int;
					sizeCount	+= alimentNameSize_int;
					
					EPlusViewerTreeTableRecord n_name	= null;
					if(rva!=0 && lma!=0){
						n_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else if(rva!=0){
						n_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else{
						n_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> n_name_Item	= new TreeItem<>(n_name);
//					n_name_Item.setExpanded(true);
					ELF_NOTE_Item.getChildren().add(n_name_Item);
					
					//name設定
					ELF_NOTE.setName(ELF_NOTE.getName()+":"+analysis);
				}
				
				
				if(alimentDescSize_int>0){
					//0x00	Variable	n_desc
					name	= "n_desc";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva		+= beforesize;
					}
					if(lma!=0){
						lma		+= beforesize;
					}
					size	= descSize_int;
					value	= "";
					analysis = "";	
					for(int i=offset; i<offset+size; i++){
						value		+= String.format("%02X", data[i]).toUpperCase();
//						analysis	+= String.format("%c", data[i]).toUpperCase();
					}	
					notes		= ELF_NOTE_n_desc_Notes;
					beforesize	= alimentDescSize_int;
					sizeCount	+= alimentDescSize_int;
					
					EPlusViewerTreeTableRecord n_desc	= null;
					if(rva!=0 && lma!=0){
						n_desc	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else if(rva!=0){
						n_desc	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else{
						n_desc	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> n_desc_Item	= new TreeItem<>(n_desc);
//					n_desc_Item.setExpanded(true);
					ELF_NOTE_Item.getChildren().add(n_desc_Item);
					
				}
				
				//サイズ更新
				ELF_NOTE.setSize(String.format("%08X", sizeCount).toUpperCase());
				
				count++;
			}
		}else if(ELFCLASS==ELFCLASS64){	//64bit
			//開始アドレス取得
			long startAddr64	= ph.getP_offset_long();
			int startAddr32		= (int)startAddr64;
			
			//データ取得用
			int dataSize	= (int)ph.getP_filesz_long();
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			long rva		= 0;
			long lma		= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			int v			= 0;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;

			//カウント
			int count		= 0;
			int sizeCount	= 0;
			
			//取得用
			int nameSize_int		= 0;
			int descSize_int		= 0;
			int alimentNameSize_int	= 0;
			int alimentDescSize_int	= 0;
			int quotient_int		= 0;
			int remainder_int		= 0;
			
			//アドレス設定
			rawAddr		= startAddr32;
			rva			= ph.getP_vaddr_long();
			lma			= ph.getP_paddr_long();
		
			for(int c=0; c<dataSize; c+=sizeCount){
				//ELF_NOTE
				name		= "ELF_NOTE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size		= dataSize;
				value		= "";
				analysis	= "";
				notes		= ELF_NOTE_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_NOTE	= null;
				if(rva!=0 && lma!=0){
					ELF_NOTE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					ELF_NOTE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					ELF_NOTE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> ELF_NOTE_Item 	= new TreeItem<>(ELF_NOTE);
//				ELF_NOTE_Item.setExpanded(true);
				item.getChildren().add(ELF_NOTE_Item);
				
				//サイズカウント初期化
				sizeCount	=	0;
				
				
				//0x00	Elf64_Word	n_namesz
				name	= "n_namesz";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size	= ELF64_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				analysis	= String.valueOf(v)+ " bytes";			
				notes		= ELF_NOTE_n_namesz_Notes;
				beforesize	= size;
				nameSize_int = v;
				sizeCount	+= size;
				
				EPlusViewerTreeTableRecord n_namesz	= null;
				if(rva!=0 && lma!=0){
					n_namesz	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					n_namesz	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					n_namesz	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> n_namesz_Item	= new TreeItem<>(n_namesz);
//				n_namesz_Item.setExpanded(true);
				ELF_NOTE_Item.getChildren().add(n_namesz_Item);
					
				//サイズ計算
				quotient_int	= nameSize_int/ELF64_WORD_SIZE;
				remainder_int	= nameSize_int%ELF64_WORD_SIZE;			
				if(quotient_int!=0&&remainder_int>0){
					alimentNameSize_int	= (quotient_int+1)*ELF64_WORD_SIZE;
				}else if(quotient_int!=0&&remainder_int==0){
					alimentNameSize_int	= quotient_int*ELF64_WORD_SIZE;
				}else {
					alimentNameSize_int	= 0;
				}
				
				
				//0x04	Elf64_Word	n_descsz
				name	= "n_descsz";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size	= ELF64_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				analysis	= String.valueOf(v)+ " bytes";			
				notes		= ELF_NOTE_n_descsz_Notes;
				beforesize	= size;
				descSize_int = v;
				sizeCount	+= size;
				
				EPlusViewerTreeTableRecord n_descsz	= null;
				if(rva!=0 && lma!=0){
					n_descsz	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					n_descsz	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					n_descsz	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> n_descsz_Item	= new TreeItem<>(n_descsz);
//				n_descsz_Item.setExpanded(true);
				ELF_NOTE_Item.getChildren().add(n_descsz_Item);
				
				//サイズ計算
				quotient_int	= descSize_int/ELF64_WORD_SIZE;
				remainder_int	= descSize_int%ELF64_WORD_SIZE;			
				if(quotient_int!=0&&remainder_int>0){
					alimentDescSize_int	= (quotient_int+1)*ELF64_WORD_SIZE;
				}else if(quotient_int!=0&&remainder_int==0){
					alimentDescSize_int	= quotient_int*ELF64_WORD_SIZE;
				}else{
					alimentDescSize_int = 0;
				}
				
				
				//0x08	Elf64_Word	n_type
				name	= "n_type";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size	= ELF64_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";			
				notes		= ELF_NOTE_n_type_Notes;
				beforesize	= size;
				sizeCount	+= size;
				
				EPlusViewerTreeTableRecord n_type	= null;
				if(rva!=0 && lma!=0){
					n_type	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					n_type	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					n_type	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> n_type_Item	= new TreeItem<>(n_type);
//				n_descsz_Item.setExpanded(true);
				ELF_NOTE_Item.getChildren().add(n_type_Item);
				
				
				if(alimentNameSize_int>0){			
					//0x0c	Variable	n_name
					name	= "n_name";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva		+= beforesize;
					}
					if(lma!=0){
						lma		+= beforesize;
					}
					size	= nameSize_int;
					value	= "";
					analysis = "";	
					for(int i=offset; i<offset+size; i++){
						value		+= String.format("%02X", data[i]).toUpperCase();
						analysis	+= String.format("%c", data[i]).toUpperCase();
					}	
					notes		= ELF_NOTE_n_name_Notes;
					beforesize	= alimentNameSize_int;
					sizeCount	+= alimentNameSize_int;
					
					EPlusViewerTreeTableRecord n_name	= null;
					if(rva!=0 && lma!=0){
						n_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else if(rva!=0){
						n_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else{
						n_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> n_name_Item	= new TreeItem<>(n_name);
//					n_name_Item.setExpanded(true);
					ELF_NOTE_Item.getChildren().add(n_name_Item);
					
					//name設定
					ELF_NOTE.setName(ELF_NOTE.getName()+":"+analysis);
				}
				
				
				if(alimentDescSize_int>0){
					//0x00	Variable	n_desc
					name	= "n_desc";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva		+= beforesize;
					}
					if(lma!=0){
						lma		+= beforesize;
					}
					size	= descSize_int;
					value	= "";
					analysis = "";	
					for(int i=offset; i<offset+size; i++){
						value		+= String.format("%02X", data[i]).toUpperCase();
//						analysis	+= String.format("%c", data[i]).toUpperCase();
					}	
					notes		= ELF_NOTE_n_desc_Notes;
					beforesize	= alimentDescSize_int;
					sizeCount	+= alimentDescSize_int;
					
					EPlusViewerTreeTableRecord n_desc	= null;
					if(rva!=0 && lma!=0){
						n_desc	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else if(rva!=0){
						n_desc	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else{
						n_desc	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> n_desc_Item	= new TreeItem<>(n_desc);
//					n_desc_Item.setExpanded(true);
					ELF_NOTE_Item.getChildren().add(n_desc_Item);			
				}
				
				//サイズ更新
				ELF_NOTE.setSize(String.format("%08X", sizeCount).toUpperCase());
				
				count++;
			}
		}
	}
	
	private void makeElfSectionHeader(TreeItem<EPlusViewerTreeTableRecord> root, String strStartAddr) {
				
		if(ELFCLASS==ELFCLASS32){	//32bit
			//開始アドレス取得
			int startAddr32	= getStringToInt(strStartAddr, false);
			
			//データ取得用
			int dataSize	= ELF32_SHDR_SIZE*ELF_SHDR_NUM;
			byte[] data		= null;
			
			//データがなかったら終了
			long sectionHeaderRawEnd_long	= Integer.toUnsignedLong(startAddr32)+Integer.toUnsignedLong(dataSize);
			long bibTableLastNum_long		= Integer.toUnsignedLong(getBinTableLastByteNum());
			if(sectionHeaderRawEnd_long>bibTableLastNum_long){
				return;
			}
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
			
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;	
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			int v			= 0;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;
			
			//ストリングテーブル開始アドレスとサイズ
			String stringTableAddr		= "";
			int	stringTableSize_int		= 0;
			
			//アドレス設定
			rawAddr		= startAddr32;
			offset		= 0;
			startOffset	= offset;
			beforesize	= 0;
			
			
			//ELF_SECTION_HEADER_TABLE
			name		= "ELF_SECTION_HEADER_TABLE";
			rawAddr		+= beforesize;
			raw			= rawAddr;
			offset		+= beforesize;
			size		= ELF32_SHDR_SIZE*ELF_SHDR_NUM;
			value		= "";
			analysis	= "";
			notes		= ELF_SECTION_HEADER_Notes;
			beforesize	= 0;
			
			EPlusViewerTreeTableRecord ELF_SECTION_HEADER_TABLE					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			TreeItem<EPlusViewerTreeTableRecord> ELF_SECTION_HEADER_TABLE_Item 	= new TreeItem<>(ELF_SECTION_HEADER_TABLE);
//			ELF_SECTION_HEADER_TABLE_Item.setExpanded(true);
			root.getChildren().add(ELF_SECTION_HEADER_TABLE_Item);
			
			//ヘッダー保存
			ELF_SECTION_HEADER_TABLE_ITEM	= ELF_SECTION_HEADER_TABLE_Item;
			

			for(int c=0; c<ELF_SHDR_NUM; c++){			
				//ELF_SECTION_HEADER
				name		= "ELF_SECTION_HEADER"+"["+c+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				size		= ELF32_SHDR_SIZE;
				value		= "";
				analysis	= "";
				notes		= ELF_SECTION_HEADER_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_SECTION_HEADER					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				TreeItem<EPlusViewerTreeTableRecord> ELF_SECTION_HEADER_Item 	= new TreeItem<>(ELF_SECTION_HEADER);
//				ELF_SECTION_HEADER_Item.setExpanded(true);
				ELF_SECTION_HEADER_TABLE_Item.getChildren().add(ELF_SECTION_HEADER_Item);
				
				
				//0x00	Elf32_Word	sh_name
				name	= "sh_name";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_SECTION_HEADER_sh_name_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord sh_name					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> sh_name_Item	= new TreeItem<>(sh_name);
//				sh_name_Item.setExpanded(true);
				ELF_SECTION_HEADER_Item.getChildren().add(sh_name_Item);
				
				//セクションヘッダー作成
				SectionHeader sh	= new SectionHeader(value, 0);
				sectionHeaderList.add(sh);
				
				
				//0x04	Elf32_Word	sh_type
				name	= "sh_type";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				switch(getStringToInt(value, false)){
				case SHT_NULL		:
					analysis	+= "SHT_NULL(0)";
					break;
				case SHT_PROGBITS	:
					analysis	+= "SHT_PROGBITS(1)";
					break;
				case SHT_SYMTAB		:
					analysis	+= "SHT_SYMTAB(2)";
					break;
				case SHT_STRTAB		:
					analysis	+= "SHT_STRTAB(3)";
					break;
				case SHT_RELA		:
					analysis	+= "SHT_RELA(4)";
					break;
				case SHT_HASH		:
					analysis	+= "SHT_HASH(5)";
					break;
				case SHT_DYNAMIC	:
					analysis	+= "SHT_DYNAMIC(6)";
					break;
				case SHT_NOTE		:
					analysis	+= "SHT_NOTE(7)";
					break;
				case SHT_NOBITS		:
					analysis	+= "SHT_NOBITS(8)";
					break;
				case SHT_REL		:
					analysis	+= "SHT_REL(9)";
					break;
				case SHT_SHLIB		:
					analysis	+= "SHT_SHLIB(10)";
					break;
				case SHT_DYNSYM		:
					analysis	+= "SHT_DYNSYM(11)";
					break;
				case SHT_INIT_ARRAY	:
					analysis	+= "SHT_INIT_ARRAY(14)";
					break;	
				case SHT_FINI_ARRAY	:
					analysis	+= "SHT_FINI_ARRAY(15)";
					break;
				case SHT_PREINIT_ARRAY	:
					analysis	+= "SHT_PREINIT_ARRAY(16)";
					break;	
				case SHT_GROUP		:
					analysis	+= "SHT_GROUP(17)";
					break;	
				case SHT_SYMTAB_SHNDX	:
					analysis	+= "SHT_SYMTAB_SHNDX(18)";
					break;	
				case SHT_NUM		:
					analysis	+= "SHT_NUM(19)";
					break;
				case SHT_LOOS		:
					analysis	+= "SHT_LOOS(0x60000000)";
					break;	
				case SHT_GNU_HASH	:
					analysis	+= "SHT_GNU_HASH(0x6ffffff6)";
					break;	
				case SHT_GNU_LIBLIST	:
					analysis	+= "SHT_GNU_LIBLIST(0x6ffffff7)";
					break;	
				case SHT_CHECKSUM	:
					analysis	+= "SHT_CHECKSUM(0x6ffffff8)";
					break;	
				case SHT_SUNW_MOVE	:
					analysis	+= "SHT_SUNW_MOVE(0x6ffffffa)";
					break;	
				case SHT_SUNW_COMDAT	:
					analysis	+= "SHT_SUNW_COMDAT(0x6ffffffb)";
					break;	
				case SHT_SUNW_SYMINFO	:
					analysis	+= "SHT_SUNW_SYMINFO(0x6ffffffc)";
					break;	
				case SHT_GNU_VERDEF	:
					analysis	+= "SHT_GNU_VERDEF(0x6ffffffd)";
					break;	
				case SHT_GNU_VERNEED	:
					analysis	+= "SHT_GNU_VERNEED(0x6ffffffe)";
					break;	
				case SHT_GNU_VERSYM	:
					analysis	+= "SHT_GNU_VERSYM(0x6fffffff)";
					break;			
				case SHT_LOPROC		:
					analysis	+= "SHT_LOPROC(0x70000000)";
					break;
				case SHT_HIPROC		:
					analysis	+= "SHT_HIPROC(0x7fffffff)";
					break;
				case SHT_LOUSER		:
					analysis	+= "SHT_LOUSER(0x80000000)";
					break;
				case SHT_HIUSER		:
					analysis	+= "SHT_HIUSER(0xffffffff)";
					break;
				}
				notes		= ELF_SECTION_HEADER_sh_type_Notes;
				beforesize	= size;
				sh.setSh_type_str(value);
							
				EPlusViewerTreeTableRecord sh_type					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> sh_type_Item	= new TreeItem<>(sh_type);
//				sh_type_Item.setExpanded(true);
				ELF_SECTION_HEADER_Item.getChildren().add(sh_type_Item);
				
				
				//0x08	Elf32_Word	sh_flags
				name	= "sh_flags";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				if((v&SHF_WRITE)!=0){
					analysis	+= "SHF_WRITE(0x1)"+"\n";
				}
				if((v&SHF_ALLOC)!=0){
					analysis	+= "SHF_ALLOC(0x2)"+"\n";
				}
				if((v&SHF_EXECINSTR)!=0){
					analysis	+= "SHF_EXECINSTR(0x4)"+"\n";
				}
				if((v&SHF_MERGE)!=0){
					analysis	+= "SHF_MERGE(0x10)"+"\n";
				}				
				if((v&SHF_STRINGS)!=0){
					analysis	+= "SHF_STRINGS(0x20)"+"\n";
				}	
				if((v&SHF_INFO_LINK)!=0){
					analysis	+= "SHF_INFO_LINK(0x40)"+"\n";
				}	
				if((v&SHF_LINK_ORDER)!=0){
					analysis	+= "SHF_LINK_ORDER(0x80)"+"\n";
				}	
				if((v&SHF_OS_NONCONFORMING)!=0){
					analysis	+= "SHF_OS_NONCONFORMING(0x100)"+"\n";
				}	
				if((v&SHF_GROUP)!=0){
					analysis	+= "SHF_GROUP(0x200)"+"\n";
				}	
				if((v&SHF_TLS)!=0){
					analysis	+= "SHF_TLS(0x400)"+"\n";
				}	
				if((v&SHF_MASKOS)!=0){
					analysis	+= "SHF_MASKOS(0x0ff00000)"+"\n";
				}	
				if((v&SHF_MASKPROC)!=0){
					analysis	+= "SHF_MASKPROC(0xf0000000)"+"\n";
				}
				if((v&SHF_ORDERED)!=0){
					analysis	+= "SHF_ORDERED(0x40000000)"+"\n";
				}
				if((v&SHF_EXCLUDE)!=0){
					analysis	+= "SHF_EXCLUDE(0x80000000)"+"\n";
				}
				notes		= ELF_SECTION_HEADER_sh_flags_Notes;
				beforesize	= size;
				sh.setSh_flags_str(value);
				
				EPlusViewerTreeTableRecord sh_flags					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> sh_flags_Item	= new TreeItem<>(sh_flags);
//				sh_flags_Item.setExpanded(true);
				ELF_SECTION_HEADER_Item.getChildren().add(sh_flags_Item);
				
				
				//0x0c	Elf32_Addr	sh_addr
				name	= "sh_addr";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF32_ADDR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_SECTION_HEADER_sh_addr_Notes;
				beforesize	= size;
				sh.setSh_addr_str(value);
				
				EPlusViewerTreeTableRecord sh_addr					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> sh_addr_Item	= new TreeItem<>(sh_addr);
//				sh_addr_Item.setExpanded(true);
				ELF_SECTION_HEADER_Item.getChildren().add(sh_addr_Item);
				
				
				//0x10	Elf32_Off	sh_offset
				name	= "sh_offset";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF32_OFF_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_SECTION_HEADER_sh_offset_Notes;
				beforesize	= size;
				sh.setSh_offset_str(value);
				
				EPlusViewerTreeTableRecord sh_offset					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> sh_offset_Item	= new TreeItem<>(sh_offset);
//				sh_offset_Item.setExpanded(true);
				ELF_SECTION_HEADER_Item.getChildren().add(sh_offset_Item);
				
				//ストリングテーブルの開始アドレスなら保存
				if(c==ELF_SHDR_STR_INDEX){
					stringTableAddr	= value;
				}
				
				
				//0x14	Elf32_Word	sh_size
				name	= "sh_size";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				analysis	= String.valueOf(v)+" bytes";
				notes		= ELF_SECTION_HEADER_sh_size_Notes;
				beforesize	= size;
				sh.setSh_size_str(value);
				
				EPlusViewerTreeTableRecord sh_size					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> sh_size_Item	= new TreeItem<>(sh_size);
//				sh_size_Item.setExpanded(true);
				ELF_SECTION_HEADER_Item.getChildren().add(sh_size_Item);
				
				//ストリングテーブルのサイズなら保存
				if(c==ELF_SHDR_STR_INDEX){
					stringTableSize_int	= v;
				}			
				
				
				//0x18	Elf32_Word	sh_link
				name	= "sh_link";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_SECTION_HEADER_sh_link_Notes;
				beforesize	= size;
				sh.setSh_link_str(value);
				
				EPlusViewerTreeTableRecord sh_link					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> sh_link_Item	= new TreeItem<>(sh_link);
//				sh_link_Item.setExpanded(true);
				ELF_SECTION_HEADER_Item.getChildren().add(sh_link_Item);
				
				
				//0x1c	Elf32_Word	sh_info
				name	= "sh_info";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_SECTION_HEADER_sh_info_Notes;
				beforesize	= size;
				sh.setSh_info_str(value);
				
				EPlusViewerTreeTableRecord sh_info					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> sh_info_Item	= new TreeItem<>(sh_info);
//				sh_info_Item.setExpanded(true);
				ELF_SECTION_HEADER_Item.getChildren().add(sh_info_Item);
				
				
				//0x20	Elf32_Word	sh_addralign
				name	= "sh_addralign";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_SECTION_HEADER_sh_addralign_Notes;
				beforesize	= size;
				sh.setSh_addralign_str(value);
				
				EPlusViewerTreeTableRecord sh_addralign					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> sh_addralign_Item	= new TreeItem<>(sh_addralign);
//				sh_addralign_Item.setExpanded(true);
				ELF_SECTION_HEADER_Item.getChildren().add(sh_addralign_Item);
				
			
				//0x24	Elf32_Word	sh_entsize
				name	= "sh_entsize";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				analysis	= String.valueOf(v)+" bytes";
				notes		= ELF_SECTION_HEADER_sh_entsize_Notes;
				beforesize	= size;
				sh.setSh_entsize_str(value);
				
				EPlusViewerTreeTableRecord sh_entsize					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> sh_entsize_Item	= new TreeItem<>(sh_entsize);
//				sh_entsize_Item.setExpanded(true);
				ELF_SECTION_HEADER_Item.getChildren().add(sh_entsize_Item);
								
			}
			
			
			//ストリングテーブルのデータ開始アドレスとサイズからデータを取得
			startAddr32	= getStringToInt(stringTableAddr, false);
			dataSize	= stringTableSize_int;			

			//データがなかったら終了
			long StringDataRawEnd_long	= Integer.toUnsignedLong(startAddr32)+Integer.toUnsignedLong(dataSize);
			bibTableLastNum_long		= Integer.toUnsignedLong(getBinTableLastByteNum());
			if(StringDataRawEnd_long>bibTableLastNum_long){
				return;
			}

			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);			
			
			//ストリングテーブルがある場合のみ
			if(dataSize>0){
				//セクションヘッダー取得
				ObservableList<TreeItem<EPlusViewerTreeTableRecord>> ELF_SECTION_HEADER_TABLE_Item_List = ELF_SECTION_HEADER_TABLE_Item.getChildren();
				Iterator<TreeItem<EPlusViewerTreeTableRecord>> ELF_SECTION_HEADER_TABLE_Item_Iterator	= ELF_SECTION_HEADER_TABLE_Item_List.iterator();
				
				TreeItem<EPlusViewerTreeTableRecord> ELF_SECTION_HEADER_Item	= null;
				EPlusViewerTreeTableRecord ELF_SECTION_HEADER					= null;
				TreeItem<EPlusViewerTreeTableRecord> sh_name_Item				= null;
				EPlusViewerTreeTableRecord sh_name								= null;
				
				int sectionHeaderCount	= 0;
				
				while(ELF_SECTION_HEADER_TABLE_Item_Iterator.hasNext()){
					
					ELF_SECTION_HEADER_Item	= (TreeItem<EPlusViewerTreeTableRecord>)ELF_SECTION_HEADER_TABLE_Item_Iterator.next();
					ELF_SECTION_HEADER		= ELF_SECTION_HEADER_Item.getValue();
					sh_name_Item			= ELF_SECTION_HEADER_Item.getChildren().get(0);
					sh_name					= sh_name_Item.getValue();
					//0x00	Variable	name;	
					name			= "name";
					int index		= getStringToInt(sh_name.getValue(), false);
					rawAddr			= startAddr32+index;	
					raw				= rawAddr;	
					offset			= index;
					size			= 0;
					int dataCount	= 0;
					value			= "";
					analysis		= "";
					notes			= ELF_STRING_TABLE_NAME_Notes;
				
					while(data[index]!=0 && index<dataSize){
						value		+= String.format("%02X", data[index]).toUpperCase();
						analysis	+= String.format("%c", data[index]);
						dataCount++;
						index++;
					}
					
					if(dataCount!=0){
						//サイズ更新
						size		= dataCount;
						
						EPlusViewerTreeTableRecord Name					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<EPlusViewerTreeTableRecord> Name_Item	= new TreeItem<>(Name);
//						Name_Item.setExpanded(true);
						sh_name_Item.getChildren().add(Name_Item);
						
						//セクションヘッダー名追加
						ELF_SECTION_HEADER.setName(ELF_SECTION_HEADER.getName()+":"+analysis);
						
						//セクションヘッダーリストに保存
						sectionHeaderList.get(sectionHeaderCount).setName(analysis);
					}			
					sectionHeaderCount++;
				}
				
				//1回目（シンボルだけ）
				//セクションヘッダー取得
				ELF_SECTION_HEADER_TABLE_Item_List 		= ELF_SECTION_HEADER_TABLE_Item.getChildren();
				ELF_SECTION_HEADER_TABLE_Item_Iterator	= ELF_SECTION_HEADER_TABLE_Item_List.iterator();		
				ELF_SECTION_HEADER_Item					= null;		
				SectionHeader sh	= null;
				sectionHeaderCount	= 0;
				
				while(ELF_SECTION_HEADER_TABLE_Item_Iterator.hasNext()){
				
					ELF_SECTION_HEADER_Item	= (TreeItem<EPlusViewerTreeTableRecord>)ELF_SECTION_HEADER_TABLE_Item_Iterator.next();
					sh						= sectionHeaderList.get(sectionHeaderCount);
					int type				= sh.getSh_type_int();
					
					if(type==SHT_SYMTAB || type==SHT_STRTAB){
						//SectionData作成			
						makeElfSectionData(ELF_SECTION_HEADER_Item, sh);
					}
				
					sectionHeaderCount++;
				}
				
				//2回目（シンボル以外）
				ELF_SECTION_HEADER_TABLE_Item_List 		= ELF_SECTION_HEADER_TABLE_Item.getChildren();
				ELF_SECTION_HEADER_TABLE_Item_Iterator	= ELF_SECTION_HEADER_TABLE_Item_List.iterator();		
				ELF_SECTION_HEADER_Item					= null;
				sh										= null;
				sectionHeaderCount						= 0;
				
				while(ELF_SECTION_HEADER_TABLE_Item_Iterator.hasNext()){
				
					ELF_SECTION_HEADER_Item	= (TreeItem<EPlusViewerTreeTableRecord>)ELF_SECTION_HEADER_TABLE_Item_Iterator.next();
					sh						= sectionHeaderList.get(sectionHeaderCount);
					int type				= sh.getSh_type_int();
					
					if(type!=SHT_SYMTAB && type!=SHT_STRTAB && type!=SHT_NOBITS){
						//SectionData作成			
						makeElfSectionData(ELF_SECTION_HEADER_Item, sh);
					}
					
					sectionHeaderCount++;
				}
			}

		}else if(ELFCLASS==ELFCLASS64){	//64bit
			//開始アドレス取得
			long startAddr64	= getStringToLong(strStartAddr, false);
			int startAddr32		= (int)startAddr64;
			
			//データ取得用
			int dataSize	= ELF64_SHDR_SIZE*ELF_SHDR_NUM;
			byte[] data		= null;
			
			//データがなかったら終了
			long sectionHeaderRawEnd_long	= startAddr64+Integer.toUnsignedLong(dataSize);
			long bibTableLastNum_long		= Integer.toUnsignedLong(getBinTableLastByteNum());
			if(sectionHeaderRawEnd_long>bibTableLastNum_long){
				return;
			}
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
			
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;	
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			int v			= 0;
			long vl			= 0;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;
			
			//ストリングテーブル開始アドレスとサイズ
			String stringTableAddr		= "";
			long stringTableSize_long	= 0;

			//アドレス設定
			rawAddr		= startAddr32;
			offset		= 0;
			startOffset	= offset;
			beforesize	= 0;
			
			
			//ELF_SECTION_HEADER_TABLE
			name		= "ELF_SECTION_HEADER_TABLE";
			rawAddr		+= beforesize;
			raw			= rawAddr;
			offset		+= beforesize;
			size		= ELF64_SHDR_SIZE*ELF_SHDR_NUM;
			value		= "";
			analysis	= "";
			notes		= ELF_SECTION_HEADER_Notes;
			beforesize	= 0;
			
			EPlusViewerTreeTableRecord ELF_SECTION_HEADER_TABLE					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			TreeItem<EPlusViewerTreeTableRecord> ELF_SECTION_HEADER_TABLE_Item 	= new TreeItem<>(ELF_SECTION_HEADER_TABLE);
//			ELF_SECTION_HEADER_TABLE_Item.setExpanded(true);
			root.getChildren().add(ELF_SECTION_HEADER_TABLE_Item);
			
			//ヘッダー保存
			ELF_SECTION_HEADER_TABLE_ITEM	= ELF_SECTION_HEADER_TABLE_Item;
			

			for(int c=0; c<ELF_SHDR_NUM; c++){
				
				//ELF_SECTION_HEADER
				name		= "ELF_SECTION_HEADER"+"["+c+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				size		= ELF64_SHDR_SIZE;
				value		= "";
				analysis	= "";
				notes		= ELF_SECTION_HEADER_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_SECTION_HEADER					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				TreeItem<EPlusViewerTreeTableRecord> ELF_SECTION_HEADER_Item 	= new TreeItem<>(ELF_SECTION_HEADER);
//				ELF_SECTION_HEADER_Item.setExpanded(true);
				ELF_SECTION_HEADER_TABLE_Item.getChildren().add(ELF_SECTION_HEADER_Item);
				
				
				//0x00	Elf64_Word	sh_name
				name	= "sh_name";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF64_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_SECTION_HEADER_sh_name_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord sh_name					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> sh_name_Item	= new TreeItem<>(sh_name);
//				sh_name_Item.setExpanded(true);
				ELF_SECTION_HEADER_Item.getChildren().add(sh_name_Item);			
				
				//セクションヘッダー作成
				SectionHeader sh	= new SectionHeader(value, 1);
				sectionHeaderList.add(sh);
				
				
				//0x04	Elf64_Word	sh_type
				name	= "sh_type";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF64_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				switch(getStringToInt(value, false)){
				case SHT_NULL		:
					analysis	+= "SHT_NULL(0)";
					break;
				case SHT_PROGBITS	:
					analysis	+= "SHT_PROGBITS(1)";
					break;
				case SHT_SYMTAB		:
					analysis	+= "SHT_SYMTAB(2)";
					break;
				case SHT_STRTAB		:
					analysis	+= "SHT_STRTAB(3)";
					break;
				case SHT_RELA		:
					analysis	+= "SHT_RELA(4)";
					break;
				case SHT_HASH		:
					analysis	+= "SHT_HASH(5)";
					break;
				case SHT_DYNAMIC	:
					analysis	+= "SHT_DYNAMIC(6)";
					break;
				case SHT_NOTE		:
					analysis	+= "SHT_NOTE(7)";
					break;
				case SHT_NOBITS		:
					analysis	+= "SHT_NOBITS(8)";
					break;
				case SHT_REL		:
					analysis	+= "SHT_REL(9)";
					break;
				case SHT_SHLIB		:
					analysis	+= "SHT_SHLIB(10)";
					break;
				case SHT_DYNSYM		:
					analysis	+= "SHT_DYNSYM(11)";
					break;
				case SHT_INIT_ARRAY	:
					analysis	+= "SHT_INIT_ARRAY(14)";
					break;	
				case SHT_FINI_ARRAY	:
					analysis	+= "SHT_FINI_ARRAY(15)";
					break;
				case SHT_PREINIT_ARRAY	:
					analysis	+= "SHT_PREINIT_ARRAY(16)";
					break;	
				case SHT_GROUP		:
					analysis	+= "SHT_GROUP(17)";
					break;	
				case SHT_SYMTAB_SHNDX	:
					analysis	+= "SHT_SYMTAB_SHNDX(18)";
					break;	
				case SHT_NUM		:
					analysis	+= "SHT_NUM(19)";
					break;
				case SHT_LOOS		:
					analysis	+= "SHT_LOOS(0x60000000)";
					break;	
				case SHT_GNU_HASH	:
					analysis	+= "SHT_GNU_HASH(0x6ffffff6)";
					break;	
				case SHT_GNU_LIBLIST	:
					analysis	+= "SHT_GNU_LIBLIST(0x6ffffff7)";
					break;	
				case SHT_CHECKSUM	:
					analysis	+= "SHT_CHECKSUM(0x6ffffff8)";
					break;	
				case SHT_SUNW_MOVE	:
					analysis	+= "SHT_SUNW_MOVE(0x6ffffffa)";
					break;	
				case SHT_SUNW_COMDAT	:
					analysis	+= "SHT_SUNW_COMDAT(0x6ffffffb)";
					break;	
				case SHT_SUNW_SYMINFO	:
					analysis	+= "SHT_SUNW_SYMINFO(0x6ffffffc)";
					break;	
				case SHT_GNU_VERDEF	:
					analysis	+= "SHT_GNU_VERDEF(0x6ffffffd)";
					break;	
				case SHT_GNU_VERNEED	:
					analysis	+= "SHT_GNU_VERNEED(0x6ffffffe)";
					break;	
				case SHT_GNU_VERSYM	:
					analysis	+= "SHT_GNU_VERSYM(0x6fffffff)";
					break;
				case SHT_LOPROC		:
					analysis	+= "SHT_LOPROC(0x70000000)";
					break;
				case SHT_HIPROC		:
					analysis	+= "SHT_HIPROC(0x7fffffff)";
					break;
				case SHT_LOUSER		:
					analysis	+= "SHT_LOUSER(0x80000000)";
					break;
				case SHT_HIUSER		:
					analysis	+= "SHT_HIUSER(0xffffffff)";
					break;
				}
				notes		= ELF_SECTION_HEADER_sh_type_Notes;
				beforesize	= size;
				sh.setSh_type_str(value);
							
				EPlusViewerTreeTableRecord sh_type					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> sh_type_Item	= new TreeItem<>(sh_type);
//				sh_type_Item.setExpanded(true);
				ELF_SECTION_HEADER_Item.getChildren().add(sh_type_Item);
				
				
				//0x08	Elf64_Xword	sh_flags
				name	= "sh_flags";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF64_XWORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				vl			= getStringToLong(value, false);
				if((vl&SHF_WRITE)!=0){
					analysis	+= "SHF_WRITE(0x1)"+"\n";
				}
				if((vl&SHF_ALLOC)!=0){
					analysis	+= "SHF_ALLOC(0x2)"+"\n";
				}
				if((vl&SHF_EXECINSTR)!=0){
					analysis	+= "SHF_EXECINSTR(0x4)"+"\n";
				}
				if((v&SHF_MERGE)!=0){
					analysis	+= "SHF_MERGE(0x10)"+"\n";
				}				
				if((v&SHF_STRINGS)!=0){
					analysis	+= "SHF_STRINGS(0x20)"+"\n";
				}	
				if((v&SHF_INFO_LINK)!=0){
					analysis	+= "SHF_INFO_LINK(0x40)"+"\n";
				}	
				if((v&SHF_LINK_ORDER)!=0){
					analysis	+= "SHF_LINK_ORDER(0x80)"+"\n";
				}	
				if((v&SHF_OS_NONCONFORMING)!=0){
					analysis	+= "SHF_OS_NONCONFORMING(0x100)"+"\n";
				}	
				if((v&SHF_GROUP)!=0){
					analysis	+= "SHF_GROUP(0x200)"+"\n";
				}	
				if((v&SHF_TLS)!=0){
					analysis	+= "SHF_TLS(0x400)"+"\n";
				}	
				if((v&SHF_MASKOS)!=0){
					analysis	+= "SHF_MASKOS(0x0ff00000)"+"\n";
				}	
				if((v&SHF_MASKPROC)!=0){
					analysis	+= "SHF_MASKPROC(0xf0000000)"+"\n";
				}
				if((v&SHF_ORDERED)!=0){
					analysis	+= "SHF_ORDERED(0x40000000)"+"\n";
				}
				if((v&SHF_EXCLUDE)!=0){
					analysis	+= "SHF_EXCLUDE(0x80000000)"+"\n";
				}
				notes		= ELF_SECTION_HEADER_sh_flags_Notes;
				beforesize	= size;
				sh.setSh_flags_str(value);
				
				EPlusViewerTreeTableRecord sh_flags					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> sh_flags_Item	= new TreeItem<>(sh_flags);
//				sh_flags_Item.setExpanded(true);
				ELF_SECTION_HEADER_Item.getChildren().add(sh_flags_Item);
				
				
				//0x10	Elf64_Addr	sh_addr
				name	= "sh_addr";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF64_ADDR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_SECTION_HEADER_sh_addr_Notes;
				beforesize	= size;
				sh.setSh_addr_str(value);
				
				EPlusViewerTreeTableRecord sh_addr					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> sh_addr_Item	= new TreeItem<>(sh_addr);
//				sh_addr_Item.setExpanded(true);
				ELF_SECTION_HEADER_Item.getChildren().add(sh_addr_Item);
				
				
				//0x18	Elf64_Off	sh_offset
				name	= "sh_offset";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF64_OFF_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_SECTION_HEADER_sh_offset_Notes;
				beforesize	= size;
				sh.setSh_offset_str(value);
				
				EPlusViewerTreeTableRecord sh_offset					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> sh_offset_Item	= new TreeItem<>(sh_offset);
//				sh_offset_Item.setExpanded(true);
				ELF_SECTION_HEADER_Item.getChildren().add(sh_offset_Item);
				
				//ストリングテーブルの開始アドレスなら保存
				if(c==ELF_SHDR_STR_INDEX){
					stringTableAddr	= value;
				}			
				
				
				//0x20	Elf64_Xword	sh_size
				name	= "sh_size";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF64_XWORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				vl			= getStringToLong(value, false);
				analysis	= String.valueOf(vl)+" bytes";
				notes		= ELF_SECTION_HEADER_sh_size_Notes;
				beforesize	= size;
				sh.setSh_size_str(value);
				
				EPlusViewerTreeTableRecord sh_size					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> sh_size_Item	= new TreeItem<>(sh_size);
//				sh_size_Item.setExpanded(true);
				ELF_SECTION_HEADER_Item.getChildren().add(sh_size_Item);
				
				//ストリングテーブルのサイズなら保存
				if(c==ELF_SHDR_STR_INDEX){
					stringTableSize_long	= vl;
				}	
				
				
				//0x28	Elf64_Word	sh_link
				name	= "sh_link";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF64_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_SECTION_HEADER_sh_link_Notes;
				beforesize	= size;
				sh.setSh_link_str(value);
				
				EPlusViewerTreeTableRecord sh_link					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> sh_link_Item	= new TreeItem<>(sh_link);
//				sh_link_Item.setExpanded(true);
				ELF_SECTION_HEADER_Item.getChildren().add(sh_link_Item);
				
				
				//0x2c	Elf64_Word	sh_info
				name	= "sh_info";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF64_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_SECTION_HEADER_sh_info_Notes;
				beforesize	= size;
				sh.setSh_info_str(value);
				
				EPlusViewerTreeTableRecord sh_info					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> sh_info_Item	= new TreeItem<>(sh_info);
//				sh_info_Item.setExpanded(true);
				ELF_SECTION_HEADER_Item.getChildren().add(sh_info_Item);
				
				
				//0x30	Elf64_Xword	sh_addralign
				name	= "sh_addralign";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF64_XWORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_SECTION_HEADER_sh_addralign_Notes;
				beforesize	= size;
				sh.setSh_addralign_str(value);
				
				EPlusViewerTreeTableRecord sh_addralign					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> sh_addralign_Item	= new TreeItem<>(sh_addralign);
//				sh_addralign_Item.setExpanded(true);
				ELF_SECTION_HEADER_Item.getChildren().add(sh_addralign_Item);
				
			
				//0x38	Elf64_Xword	sh_entsize
				name	= "sh_entsize";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				size	= ELF64_XWORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				vl			= getStringToLong(value, false);
				analysis	= String.valueOf(vl)+" bytes";
				notes		= ELF_SECTION_HEADER_sh_entsize_Notes;
				beforesize	= size;
				sh.setSh_entsize_str(value);
				
				EPlusViewerTreeTableRecord sh_entsize					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<EPlusViewerTreeTableRecord> sh_entsize_Item	= new TreeItem<>(sh_entsize);
//				sh_entsize_Item.setExpanded(true);
				ELF_SECTION_HEADER_Item.getChildren().add(sh_entsize_Item);

			}
			
			//ストリングテーブルのデータ開始アドレスとサイズからデータを取得
			startAddr64	= getStringToLong(stringTableAddr, false);
			startAddr32	= (int)startAddr64;
			dataSize	= (int)stringTableSize_long;
			
			//データがなかったら終了
			long StringDataRawEnd_long	= startAddr64+stringTableSize_long;
			bibTableLastNum_long		= Integer.toUnsignedLong(getBinTableLastByteNum());
			if(StringDataRawEnd_long>bibTableLastNum_long){
				return;
			}
			
			//データ取得
			data		= getBintableBytes(startAddr32, dataSize);			
			
			//ストリングテーブルがある場合のみ
			if(dataSize>0){
				//セクションヘッダー取得
				ObservableList<TreeItem<EPlusViewerTreeTableRecord>> ELF_SECTION_HEADER_TABLE_Item_List = ELF_SECTION_HEADER_TABLE_Item.getChildren();
				Iterator<TreeItem<EPlusViewerTreeTableRecord>> ELF_SECTION_HEADER_TABLE_Item_Iterator	= ELF_SECTION_HEADER_TABLE_Item_List.iterator();
				
				TreeItem<EPlusViewerTreeTableRecord> ELF_SECTION_HEADER_Item	= null;
				EPlusViewerTreeTableRecord ELF_SECTION_HEADER					= null;
				TreeItem<EPlusViewerTreeTableRecord> sh_name_Item				= null;
				EPlusViewerTreeTableRecord sh_name								= null;
				
				int sectionHeaderCount	= 0;
				
				while(ELF_SECTION_HEADER_TABLE_Item_Iterator.hasNext()){
					
					ELF_SECTION_HEADER_Item	= (TreeItem<EPlusViewerTreeTableRecord>)ELF_SECTION_HEADER_TABLE_Item_Iterator.next();
					ELF_SECTION_HEADER		= ELF_SECTION_HEADER_Item.getValue();
					sh_name_Item			= ELF_SECTION_HEADER_Item.getChildren().get(0);
					sh_name					= sh_name_Item.getValue();
					
								
					//0x00	Variable	name;	
					name			= "name";
					int index		= getStringToInt(sh_name.getValue(), false);
					rawAddr			= startAddr32+index;	
					raw				= rawAddr;	
					offset			= index;
					size			= 0;
					int dataCount	= 0;
					value			= "";
					analysis		= "";
					notes			= ELF_STRING_TABLE_NAME_Notes;
						
					while(data[index]!=0 && index<dataSize){
						value		+= String.format("%02X", data[index]).toUpperCase();
						analysis	+= String.format("%c", data[index]);
						dataCount++;
						index++;
					}
						
					if(dataCount!=0){
						//サイズ更新
						size		= dataCount;
						
						EPlusViewerTreeTableRecord Name					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<EPlusViewerTreeTableRecord> Name_Item	= new TreeItem<>(Name);
//						Name_Item.setExpanded(true);
						sh_name_Item.getChildren().add(Name_Item);
						
						//セクションヘッダー名追加
						ELF_SECTION_HEADER.setName(ELF_SECTION_HEADER.getName()+":"+analysis);
						
						//セクションヘッダーリストに保存
						sectionHeaderList.get(sectionHeaderCount).setName(analysis);
					}
					sectionHeaderCount++;
				}
				
				
				//1回目（シンボルだけ）
				//セクションヘッダー取得
				ELF_SECTION_HEADER_TABLE_Item_List 		= ELF_SECTION_HEADER_TABLE_Item.getChildren();
				ELF_SECTION_HEADER_TABLE_Item_Iterator	= ELF_SECTION_HEADER_TABLE_Item_List.iterator();		
				ELF_SECTION_HEADER_Item					= null;			
				SectionHeader sh						= null;
				sectionHeaderCount						= 0;
				
				while(ELF_SECTION_HEADER_TABLE_Item_Iterator.hasNext()){
				
					ELF_SECTION_HEADER_Item	= (TreeItem<EPlusViewerTreeTableRecord>)ELF_SECTION_HEADER_TABLE_Item_Iterator.next();
					sh						= sectionHeaderList.get(sectionHeaderCount);
					int type				= sh.getSh_type_int();
					
					if(type==SHT_SYMTAB || type==SHT_STRTAB){
						//SectionData作成			
						makeElfSectionData(ELF_SECTION_HEADER_Item, sh);
					}
					sectionHeaderCount++;
				}
				
				//2回目（シンボル、ファイル内にセクションデータがないセクション以外）
				ELF_SECTION_HEADER_TABLE_Item_List 		= ELF_SECTION_HEADER_TABLE_Item.getChildren();
				ELF_SECTION_HEADER_TABLE_Item_Iterator	= ELF_SECTION_HEADER_TABLE_Item_List.iterator();		
				ELF_SECTION_HEADER_Item					= null;			
				sh										= null;
				sectionHeaderCount						= 0;
				
				while(ELF_SECTION_HEADER_TABLE_Item_Iterator.hasNext()){
				
					ELF_SECTION_HEADER_Item	= (TreeItem<EPlusViewerTreeTableRecord>)ELF_SECTION_HEADER_TABLE_Item_Iterator.next();
					sh						= sectionHeaderList.get(sectionHeaderCount);
					int type				= sh.getSh_type_int();
					
					if(type!=SHT_SYMTAB && type!=SHT_STRTAB && type!=SHT_NOBITS){
						//SectionData作成			
						makeElfSectionData(ELF_SECTION_HEADER_Item, sh);
					}
					sectionHeaderCount++;
				}
			}
		}
	}
	
	private void makeElfSectionData(TreeItem<EPlusViewerTreeTableRecord> item, SectionHeader sh){
			
		if(ELFCLASS==ELFCLASS32){	//32bit
			//開始アドレス取得
			int startAddr32	= sh.getSh_offset_int();
			
			//データ取得用
			int dataSize	= sh.getSh_size_int();
//			byte[] data		= null;
			
			//データがなかったら終了
			long sectionDataRawEnd_long	= Integer.toUnsignedLong(startAddr32)+Integer.toUnsignedLong(dataSize);
			long bibTableLastNum_long	= Integer.toUnsignedLong(getBinTableLastByteNum());
			if(sectionDataRawEnd_long>bibTableLastNum_long || dataSize==0){
				return;
			}
			
			//データ取得
//			data		= getBintableBytes(startAddr32, dataSize);
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			int rva			= 0;
			int lma			= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			String strLma	= null;
			
			//オフセット
			int startOffset	= 0;
			

			//ELF_SECTION_DATA
			name		= "ELF_SECTION_DATA";
			rawAddr		= startAddr32;
			raw			= rawAddr;
			rva			= sh.getSh_addr_int();
			if(rva!=0){
				strLma	= getVaddrToPaddr(String.format("%08X", rva).toUpperCase());
			}
			if(strLma!=null){
				lma		= getStringToInt(strLma, false);
			}
			offset		+= beforesize;
			size		= dataSize;
			value		= "";
			analysis	= "";
			notes		= ELF_SECTION_DATA_Notes;
			beforesize	= 0;
			
			EPlusViewerTreeTableRecord ELF_SECTION_DATA	= null;
			if(rva!=0 && lma!=0){
				ELF_SECTION_DATA	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}else if(rva!=0){
				ELF_SECTION_DATA	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}else{
				ELF_SECTION_DATA	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}
			TreeItem<EPlusViewerTreeTableRecord> ELF_SECTION_DATA_Item 	= new TreeItem<>(ELF_SECTION_DATA);
//			ELF_SECTION_DATA_Item.setExpanded(true);
			item.getChildren().add(ELF_SECTION_DATA_Item);
			
			switch(sh.getSh_type_int()){
			case SHT_NULL		:				
				break;
			case SHT_PROGBITS	:
				break;
			case SHT_SYMTAB		:				
				makeElfSymbolTable(ELF_SECTION_DATA_Item, sh);
				break;
			case SHT_STRTAB		:				
				break;
			case SHT_RELA		:
				makeElfRelocationAddendTable(ELF_SECTION_DATA_Item, sh);			
				break;
			case SHT_HASH		:			
				break;
			case SHT_DYNAMIC	:
				makeElfDinamic(ELF_SECTION_DATA_Item, sh);	
				break;
			case SHT_NOTE		:
				makeElfNote(ELF_SECTION_DATA_Item, sh);
				break;
			case SHT_NOBITS		:
				break;
			case SHT_REL		:
				makeElfRelocationTable(ELF_SECTION_DATA_Item, sh);
				break;
			case SHT_SHLIB		:		
				break;
			case SHT_DYNSYM		:
				makeElfDynamicSymbolTable(ELF_SECTION_DATA_Item, sh);
				break;
			case SHT_INIT_ARRAY	:				
				break;	
			case SHT_FINI_ARRAY	:				
				break;
			case SHT_PREINIT_ARRAY	:				
				break;	
			case SHT_GROUP		:			
				break;	
			case SHT_SYMTAB_SHNDX	:			
				break;	
			case SHT_NUM		:
				break;
			case SHT_LOOS		:				
				break;	
			case SHT_GNU_HASH	:			
				break;	
			case SHT_GNU_LIBLIST	:				
				break;	
			case SHT_CHECKSUM	:				
				break;	
			case SHT_SUNW_MOVE	:				
				break;	
			case SHT_SUNW_COMDAT	:				
				break;	
			case SHT_SUNW_SYMINFO	:				
				break;	
			case SHT_GNU_VERDEF	:				
				break;	
			case SHT_GNU_VERNEED	:			
				break;	
			case SHT_GNU_VERSYM	:		
				break;			
			case SHT_LOPROC		:			
				break;
			case SHT_HIPROC		:		
				break;
			case SHT_LOUSER		:			
				break;
			case SHT_HIUSER		:			
				break;	
			}
			
		}else if(ELFCLASS==ELFCLASS64){	//64bit
			//開始アドレス取得
			long startAddr64	= sh.getSh_offset_long();
			int startAddr32		= (int)startAddr64;
			
			//データ取得用
			int dataSize	= (int)sh.getSh_size_long();
//			byte[] data		= null;
			

			//データがなかったら終了
			long sectionDataRawEnd_long	= startAddr64+sh.getSh_size_long();
			long bibTableLastNum_long	= Integer.toUnsignedLong(getBinTableLastByteNum());
			if(sectionDataRawEnd_long>bibTableLastNum_long || dataSize==0){
				return;
			}
			
			//データ取得
//			data		= getBintableBytes(startAddr32, dataSize);
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			long rva		= 0;
			long lma		= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			String strLma	= null;
			
			//オフセット
			int startOffset	= 0;
			
			
			//ELF_SECTION_DATA
			name		= "ELF_SECTION_DATA";
			rawAddr		= startAddr32;
			raw			= rawAddr;
			offset		+= beforesize;
			rva			= sh.getSh_addr_long();
			if(rva!=0){
				strLma	= getVaddrToPaddr(String.format("%016X", rva).toUpperCase());
			}
			if(strLma!=null){
				lma		= getStringToLong(strLma, false);
			}
			size		= dataSize;
			value		= "";
			analysis	= "";
			notes		= ELF_SECTION_DATA_Notes;
			beforesize	= 0;
			
			EPlusViewerTreeTableRecord ELF_SECTION_DATA	= null;
			if(rva!=0 && lma!=0){
				ELF_SECTION_DATA	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}else if(rva!=0){
				ELF_SECTION_DATA	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}else{
				ELF_SECTION_DATA	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}
			TreeItem<EPlusViewerTreeTableRecord> ELF_SECTION_DATA_Item 	= new TreeItem<>(ELF_SECTION_DATA);
//			ELF_SECTION_DATA_Item.setExpanded(true);
			item.getChildren().add(ELF_SECTION_DATA_Item);
		
			switch(sh.getSh_type_int()){
			case SHT_NULL		:				
				break;
			case SHT_PROGBITS	:
				break;
			case SHT_SYMTAB		:				
				makeElfSymbolTable(ELF_SECTION_DATA_Item, sh);
				break;
			case SHT_STRTAB		:				
				break;
			case SHT_RELA		:
				makeElfRelocationAddendTable(ELF_SECTION_DATA_Item, sh);			
				break;
			case SHT_HASH		:			
				break;
			case SHT_DYNAMIC	:
				makeElfDinamic(ELF_SECTION_DATA_Item, sh);	
				break;
			case SHT_NOTE		:
				makeElfNote(ELF_SECTION_DATA_Item, sh);
				break;
			case SHT_NOBITS		:
				break;
			case SHT_REL		:
				makeElfRelocationTable(ELF_SECTION_DATA_Item, sh);
				break;
			case SHT_SHLIB		:		
				break;
			case SHT_DYNSYM		:
				makeElfDynamicSymbolTable(ELF_SECTION_DATA_Item, sh);
				break;
			case SHT_INIT_ARRAY	:				
				break;	
			case SHT_FINI_ARRAY	:				
				break;
			case SHT_PREINIT_ARRAY	:				
				break;	
			case SHT_GROUP		:			
				break;	
			case SHT_SYMTAB_SHNDX	:			
				break;	
			case SHT_NUM		:
				break;
			case SHT_LOOS		:				
				break;	
			case SHT_GNU_HASH	:			
				break;	
			case SHT_GNU_LIBLIST	:				
				break;	
			case SHT_CHECKSUM	:				
				break;	
			case SHT_SUNW_MOVE	:				
				break;	
			case SHT_SUNW_COMDAT	:				
				break;	
			case SHT_SUNW_SYMINFO	:				
				break;	
			case SHT_GNU_VERDEF	:				
				break;	
			case SHT_GNU_VERNEED	:			
				break;	
			case SHT_GNU_VERSYM	:		
				break;			
			case SHT_LOPROC		:			
				break;
			case SHT_HIPROC		:		
				break;
			case SHT_LOUSER		:			
				break;
			case SHT_HIUSER		:			
				break;	
			}
		}	
	}
	
	private void makeElfDinamic(TreeItem<EPlusViewerTreeTableRecord> item, SectionHeader sh){
		
		if(ELFCLASS==ELFCLASS32){	//32bit
			//開始アドレス取得
			int startAddr32	= sh.getSh_offset_int();
			
			//データ取得用
			int dataSize	= sh.getSh_size_int();
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			int rva			= 0;
			int lma			= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			int v			= 0;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;
			
			//カウント
			int count		= 0;
			
			//アドレス設定
			rawAddr			= startAddr32;
			rva				= sh.getSh_addr_int();
			String strLma	= getVaddrToPaddr(String.format("%08X", rva).toUpperCase());
			if(strLma!=null){
				lma			= getStringToInt(strLma, false);
			}		
			
			for(int c=0; c<dataSize; c+=ELF32_DYN_SIZE){			
				//ELF_DYNAMIC_ENTRY
				name		= "ELF_DYNAMIC_ENTRY"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size		= ELF32_DYN_SIZE;
				value		= "";
				analysis	= "";
				notes		= ELF_DYNAMIC_ENTRY_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_DYNAMIC_ENTRY	= null;
				if(rva!=0 && lma!=0){
					ELF_DYNAMIC_ENTRY	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					ELF_DYNAMIC_ENTRY	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					ELF_DYNAMIC_ENTRY	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> ELF_DYNAMIC_ENTRY_Item 	= new TreeItem<>(ELF_DYNAMIC_ENTRY);
//				ELF_DYNAMIC_ENTRY_Item.setExpanded(true);
				item.getChildren().add(ELF_DYNAMIC_ENTRY_Item);
				
				
				//0x00	Elf32_Sword	d_tag
				name	= "d_tag";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF32_SWORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				switch(v){
				case DT_NULL		:
					analysis	+= "DT_NULL(0)";
					break;
				case DT_NEEDED		:
					analysis	+= "DT_NEEDED(1)";
					break;
				case DT_PLTRELSZ		:
					analysis	+= "DT_PLTRELSZ(2)";
					break;
				case DT_PLTGOT		:
					analysis	+= "DT_PLTGOT(3)";
					break;
				case DT_HASH		:
					analysis	+= "DT_HASH(4)";
					break;
				case DT_STRTAB		:
					analysis	+= "DT_STRTAB(5)";
					break;
				case DT_SYMTAB		:
					analysis	+= "DT_SYMTAB(6)";
					break;
				case DT_RELA		:
					analysis	+= "DT_RELA(7)";
					break;
				case DT_RELASZ		:
					analysis	+= "DT_RELASZ(8)";
					break;
				case DT_RELAENT		:
					analysis	+= "DT_RELAENT(9)";
					break;
				case DT_STRSZ		:
					analysis	+= "DT_STRSZ(10)";
					break;
				case DT_SYMENT		:
					analysis	+= "DT_SYMENT(11)";
					break;
				case DT_INIT		:
					analysis	+= "DT_INIT(12)";
					break;
				case DT_FINI		:
					analysis	+= "DT_FINI(13)";
					break;
				case DT_SONAME		:
					analysis	+= "DT_SONAME(14)";
					break;
				case DT_RPATH		:
					analysis	+= "DT_RPATH(15)";
					break;
				case DT_SYMBOLIC	:
					analysis	+= "DT_SYMBOLIC(16)";
					break;
				case DT_REL		:
					analysis	+= "DT_REL(17)";
					break;
				case DT_RELSZ		:
					analysis	+= "DT_RELSZ(18)";
					break;
				case DT_RELENT		:
					analysis	+= "DT_RELENT(19)";
					break;
				case DT_PLTREL		:
					analysis	+= "DT_PLTREL(20)";
					break;
				case DT_DEBUG		:
					analysis	+= "DT_DEBUG(21)";
					break;
				case DT_TEXTREL		:
					analysis	+= "DT_TEXTREL(22)";
					break;
				case DT_JMPREL		:
					analysis	+= "DT_JMPREL(23)";
					break;			
				case DT_BIND_NOW		:
					analysis	+= "DT_BIND_NOW(24)";
					break;
				case DT_INIT_ARRAY		:
					analysis	+= "DT_INIT_ARRAY(25)";
					break;
				case DT_FINI_ARRAY		:
					analysis	+= "DT_FINI_ARRAY(26)";
					break;
				case DT_INIT_ARRAYSZ		:
					analysis	+= "DT_INIT_ARRAYSZ(27)";
					break;
				case DT_FINI_ARRAYSZ		:
					analysis	+= "DT_FINI_ARRAYSZ(28)";
					break;
				case DT_RUNPATH		:
					analysis	+= "DT_RUNPATH(29)";
					break;
				case DT_FLAGS		:
					analysis	+= "DT_FLAGS(30)";
					break;				
				case DT_PREINIT_ARRAY		:
					analysis	+= "DT_PREINIT_ARRAY(32)";
					break;
				case DT_PREINIT_ARRAYSZ		:
					analysis	+= "DT_PREINIT_ARRAYSZ(33)";
					break;	
				case DT_LOOS		:
					analysis	+= "DT_LOOS(0x6000000d)";
					break;
				case DT_HIOS		:
					analysis	+= "DT_HIOS(0x6ffff000)";
					break;
				case DT_VALRNGLO		:
					analysis	+= "DT_VALRNGLO(0x6ffffd00)";
					break;
				case DT_VALRNGHI		:
					analysis	+= "DT_VALRNGHI(0x6ffffdff)";
					break;
				case DT_ADDRRNGLO		:
					analysis	+= "DT_ADDRRNGLO(0x6ffffe00)";
					break;
				case DT_ADDRRNGHI		:
					analysis	+= "DT_ADDRRNGHI(0x6ffffeff)";
					break;			
				case DT_VERSYM		:
					analysis	+= "DT_VERSYM(0x6ffffff0)";
					break;
				case DT_RELACOUNT		:
					analysis	+= "DT_RELACOUNT(0x6ffffff9)";
					break;	
				case DT_RELCOUNT		:
					analysis	+= "DT_RELCOUNT(0x6ffffffa)";
					break;
				case DT_FLAGS_1		:
					analysis	+= "DT_FLAGS_1(0x6ffffffb)";
					break;	
				case DT_VERDEF		:
					analysis	+= "DT_VERDEF(0x6ffffffc)";
					break;
				case DT_VERDEFNUM		:
					analysis	+= "DT_VERDEFNUM(0x6ffffffd)";
					break;	
				case DT_VERNEED		:
					analysis	+= "DT_VERNEED(0x6ffffffe)";
					break;
				case DT_VERNEEDNUM		:
					analysis	+= "DT_VERNEEDNUM(0x6fffffff)";
					break;	
				case DT_LOPROC		:
					analysis	+= "DT_LOPROC(0x70000000)";
					break;
				case DT_HIPROC		:
					analysis	+= "DT_HIPROC(0x7fffffff)";
					break;
				case DT_GNU_PRELINKED		:
					analysis	+= "DT_GNU_PRELINKED(0x6ffffdf5)";
					break;
				case DT_GNU_CONFLICTSZ		:
					analysis	+= "DT_GNU_CONFLICTSZ(0x6ffffdf6)";
					break;
				case DT_GNU_LIBLISTSZ		:
					analysis	+= "DT_GNU_LIBLISTSZ(0x6ffffdf7)";
					break;
				case DT_GNU_HASH		:
					analysis	+= "DT_GNU_HASH(0x6ffffef5)";
					break;
				case DT_GNU_CONFLICT		:
					analysis	+= "DT_GNU_CONFLICT(0x6ffffef8)";
					break;
				case DT_GNU_LIBLIST		:
					analysis	+= "DT_GNU_LIBLIST(0x6ffffef9)";
					break;
				}
				notes		= ELF_DYNAMIC_ENTRY_d_tag_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord d_tag	= null;
				if(rva!=0 && lma!=0){
					d_tag	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					d_tag	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					d_tag	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> d_tag_Item	= new TreeItem<>(d_tag);
//				d_tag_Item.setExpanded(true);
				ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_tag_Item);
	
				//ELF_DYNAMIC_ENTRY名更新
				ELF_DYNAMIC_ENTRY.setName(ELF_DYNAMIC_ENTRY.getName()+":"+analysis);
				
			
				if(v==DT_NEEDED){	//シンボル名
					
					//0x04	Elf32_Sword	d_val
					name	= "d_val";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= ELF32_SWORD_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					analysis	= "";
					v			= getStringToInt(value, false);
					analysis	+= "sh_link=0x"+sh.getSh_link_str()+"\n";
					analysis	+= "=>"+ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(sh.getSh_link_int()).getValue().getName()+"\n";
					analysis	+= "index=0x"+value+"\n";
					notes		= ELF_DYNAMIC_ENTRY_d_val_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_val	= null;
					if(rva!=0 && lma!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else if(rva!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else{
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_val_Item	= new TreeItem<>(d_val);
//					d_val_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_val_Item);
					
					//動的リンク用シンボルテーブルからシンボル名取得
					makeDynamicSymbolName(d_val_Item, sh, v);
					
				}else if(v==DT_SONAME){//共有オブジェクトの名前
					
					//0x04	Elf32_Sword	d_val
					name	= "d_val";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva		+= beforesize;
					}
					if(lma!=0){
						lma		+= beforesize;
					}
					size	= ELF32_SWORD_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					analysis	= "";
					notes		= ELF_DYNAMIC_ENTRY_d_val_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_val	= null;
					if(rva!=0 && lma!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else if(rva!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else{
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_val_Item	= new TreeItem<>(d_val);
//					d_val_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_val_Item);
					
				}else if(v==DT_RPATH ||
						 v==DT_RUNPATH){	//path
					
					//0x04	Elf32_Sword	d_val
					name	= "d_val";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= ELF32_SWORD_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					analysis	= "";
					notes		= ELF_DYNAMIC_ENTRY_d_val_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_val	= null;
					if(rva!=0 && lma!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else if(rva!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else{
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_val_Item	= new TreeItem<>(d_val);
//					d_val_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_val_Item);
					
				}else if(v==DT_PLTRELSZ ||
						 v==DT_RELASZ ||
						 v==DT_RELAENT ||
						 v==DT_STRSZ ||
						 v==DT_SYMENT ||
						 v==DT_RELSZ ||
						 v==DT_RELENT ||
						 v==DT_INIT_ARRAYSZ ||
						 v==DT_FINI_ARRAYSZ ||
						 v==DT_PREINIT_ARRAYSZ){		//サイズ
				
					//0x04	Elf32_Sword	d_val
					name	= "d_val";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= ELF32_SWORD_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					analysis	= "";
					v			= getStringToInt(value, false);
					analysis	= String.valueOf(v)+" bytes";
					notes		= ELF_DYNAMIC_ENTRY_d_val_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_val	= null;
					if(rva!=0 && lma!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else if(rva!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else{
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_val_Item	= new TreeItem<>(d_val);
//					d_val_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_val_Item);
					
				}else if(v==DT_HASH ||
						 v==DT_STRTAB ||
						 v==DT_SYMTAB ||
						 v==DT_RELA ||
						 v==DT_INIT ||
						 v==DT_FINI ||
						 v==DT_REL ||
						 v==DT_JMPREL ||
						 v==DT_INIT_ARRAY ||
						 v==DT_FINI_ARRAY ||
						 v==DT_PREINIT_ARRAY){		//アドレス
					
					//0x04	Elf32_Addr	d_ptr
					name	= "d_ptr";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= ELF32_ADDR_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					analysis	= "";
					notes		= ELF_DYNAMIC_ENTRY_d_ptr_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_ptr	= null;
					if(rva!=0 && lma!=0){
						d_ptr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else if(rva!=0){
						d_ptr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else{
						d_ptr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_ptr_Item	= new TreeItem<>(d_ptr);
//					d_ptr_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_ptr_Item);
							
				}else{
				
					//0x04	Elf32_Sword	d_val
					name	= "d_val";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva		+= beforesize;
					}
					if(lma!=0){
						lma		+= beforesize;
					}
					size	= ELF32_SWORD_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					analysis	= "";
					notes		= ELF_DYNAMIC_ENTRY_d_val_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_val	= null;
					if(rva!=0 && lma!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else if(rva!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else{
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_val_Item	= new TreeItem<>(d_val);
//					d_val_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_val_Item);

				}
				count++;
			}
		}else if(ELFCLASS==ELFCLASS64){	//64bit
			//開始アドレス取得
			long startAddr64	= sh.getSh_offset_long();
			int startAddr32		= (int)startAddr64;

			
			//データ取得用
			int dataSize	= (int)sh.getSh_size_long();
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			long rva		= 0;
			long lma		= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			int v			= 0;
			long vl			= 0;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;
			
			//カウント
			int count		= 0;
			
			//アドレス設定
			rawAddr			= startAddr32;
			rva				= sh.getSh_addr_long();
			String strLma	= getVaddrToPaddr(String.format("%016X", rva).toUpperCase());
			if(strLma!=null){
				lma			= getStringToLong(strLma, false);
			}
			
			for(int c=0; c<dataSize; c+=ELF64_DYN_SIZE){			
				//ELF_DYNAMIC_ENTRY
				name		= "ELF_DYNAMIC_ENTRY"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size		= ELF64_DYN_SIZE;
				value		= "";
				analysis	= "";
				notes		= ELF_DYNAMIC_ENTRY_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_DYNAMIC_ENTRY	= null;
				if(rva!=0 && lma!=0){
					ELF_DYNAMIC_ENTRY	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					ELF_DYNAMIC_ENTRY	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					ELF_DYNAMIC_ENTRY	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> ELF_DYNAMIC_ENTRY_Item 	= new TreeItem<>(ELF_DYNAMIC_ENTRY);
//				ELF_DYNAMIC_ENTRY_Item.setExpanded(true);
				item.getChildren().add(ELF_DYNAMIC_ENTRY_Item);
				
				
				//0x00	Elf64_Sxword	d_tag
				name	= "d_tag";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_SXWORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= (int)getStringToLong(value, false);
				switch(v){
				case DT_NULL		:
					analysis	+= "DT_NULL(0)";
					break;
				case DT_NEEDED		:
					analysis	+= "DT_NEEDED(1)";
					break;
				case DT_PLTRELSZ		:
					analysis	+= "DT_PLTRELSZ(2)";
					break;
				case DT_PLTGOT		:
					analysis	+= "DT_PLTGOT(3)";
					break;
				case DT_HASH		:
					analysis	+= "DT_HASH(4)";
					break;
				case DT_STRTAB		:
					analysis	+= "DT_STRTAB(5)";
					break;
				case DT_SYMTAB		:
					analysis	+= "DT_SYMTAB(6)";
					break;
				case DT_RELA		:
					analysis	+= "DT_RELA(7)";
					break;
				case DT_RELASZ		:
					analysis	+= "DT_RELASZ(8)";
					break;
				case DT_RELAENT		:
					analysis	+= "DT_RELAENT(9)";
					break;
				case DT_STRSZ		:
					analysis	+= "DT_STRSZ(10)";
					break;
				case DT_SYMENT		:
					analysis	+= "DT_SYMENT(11)";
					break;
				case DT_INIT		:
					analysis	+= "DT_INIT(12)";
					break;
				case DT_FINI		:
					analysis	+= "DT_FINI(13)";
					break;
				case DT_SONAME		:
					analysis	+= "DT_SONAME(14)";
					break;
				case DT_RPATH		:
					analysis	+= "DT_RPATH(15)";
					break;
				case DT_SYMBOLIC	:
					analysis	+= "DT_SYMBOLIC(16)";
					break;
				case DT_REL		:
					analysis	+= "DT_REL(17)";
					break;
				case DT_RELSZ		:
					analysis	+= "DT_RELSZ(18)";
					break;
				case DT_RELENT		:
					analysis	+= "DT_RELENT(19)";
					break;
				case DT_PLTREL		:
					analysis	+= "DT_PLTREL(20)";
					break;
				case DT_DEBUG		:
					analysis	+= "DT_DEBUG(21)";
					break;
				case DT_TEXTREL		:
					analysis	+= "DT_TEXTREL(22)";
					break;
				case DT_JMPREL		:
					analysis	+= "DT_JMPREL(23)";
					break;			
				case DT_BIND_NOW		:
					analysis	+= "DT_BIND_NOW(24)";
					break;
				case DT_INIT_ARRAY		:
					analysis	+= "DT_INIT_ARRAY(25)";
					break;
				case DT_FINI_ARRAY		:
					analysis	+= "DT_FINI_ARRAY(26)";
					break;
				case DT_INIT_ARRAYSZ		:
					analysis	+= "DT_INIT_ARRAYSZ(27)";
					break;
				case DT_FINI_ARRAYSZ		:
					analysis	+= "DT_FINI_ARRAYSZ(28)";
					break;
				case DT_RUNPATH		:
					analysis	+= "DT_RUNPATH(29)";
					break;
				case DT_FLAGS		:
					analysis	+= "DT_FLAGS(30)";
					break;				
				case DT_PREINIT_ARRAY		:
					analysis	+= "DT_PREINIT_ARRAY(32)";
					break;
				case DT_PREINIT_ARRAYSZ		:
					analysis	+= "DT_PREINIT_ARRAYSZ(33)";
					break;	
				case DT_LOOS		:
					analysis	+= "DT_LOOS(0x6000000d)";
					break;
				case DT_HIOS		:
					analysis	+= "DT_HIOS(0x6ffff000)";
					break;
				case DT_VALRNGLO		:
					analysis	+= "DT_VALRNGLO(0x6ffffd00)";
					break;
				case DT_VALRNGHI		:
					analysis	+= "DT_VALRNGHI(0x6ffffdff)";
					break;
				case DT_ADDRRNGLO		:
					analysis	+= "DT_ADDRRNGLO(0x6ffffe00)";
					break;
				case DT_ADDRRNGHI		:
					analysis	+= "DT_ADDRRNGHI(0x6ffffeff)";
					break;			
				case DT_VERSYM		:
					analysis	+= "DT_VERSYM(0x6ffffff0)";
					break;
				case DT_RELACOUNT		:
					analysis	+= "DT_RELACOUNT(0x6ffffff9)";
					break;	
				case DT_RELCOUNT		:
					analysis	+= "DT_RELCOUNT(0x6ffffffa)";
					break;
				case DT_FLAGS_1		:
					analysis	+= "DT_FLAGS_1(0x6ffffffb)";
					break;	
				case DT_VERDEF		:
					analysis	+= "DT_VERDEF(0x6ffffffc)";
					break;
				case DT_VERDEFNUM		:
					analysis	+= "DT_VERDEFNUM(0x6ffffffd)";
					break;	
				case DT_VERNEED		:
					analysis	+= "DT_VERNEED(0x6ffffffe)";
					break;
				case DT_VERNEEDNUM		:
					analysis	+= "DT_VERNEEDNUM(0x6fffffff)";
					break;	
				case DT_LOPROC		:
					analysis	+= "DT_LOPROC(0x70000000)";
					break;
				case DT_HIPROC		:
					analysis	+= "DT_HIPROC(0x7fffffff)";
					break;
				case DT_GNU_PRELINKED		:
					analysis	+= "DT_GNU_PRELINKED(0x6ffffdf5)";
					break;
				case DT_GNU_CONFLICTSZ		:
					analysis	+= "DT_GNU_CONFLICTSZ(0x6ffffdf6)";
					break;
				case DT_GNU_LIBLISTSZ		:
					analysis	+= "DT_GNU_LIBLISTSZ(0x6ffffdf7)";
					break;
				case DT_GNU_HASH		:
					analysis	+= "DT_GNU_HASH(0x6ffffef5)";
					break;
				case DT_GNU_CONFLICT		:
					analysis	+= "DT_GNU_CONFLICT(0x6ffffef8)";
					break;
				case DT_GNU_LIBLIST		:
					analysis	+= "DT_GNU_LIBLIST(0x6ffffef9)";
					break;
				}
				notes		= ELF_DYNAMIC_ENTRY_d_tag_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord d_tag	= null;
				if(rva!=0 && lma!=0){
					d_tag	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					d_tag	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					d_tag	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> d_tag_Item	= new TreeItem<>(d_tag);
//				d_tag_Item.setExpanded(true);
				ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_tag_Item);
	
				//ELF_DYNAMIC_ENTRY名更新
				ELF_DYNAMIC_ENTRY.setName(ELF_DYNAMIC_ENTRY.getName()+":"+analysis);
				
			
				if(v==DT_NEEDED){	//シンボル名
					
					//0x08	Elf64_Xword	d_val
					name	= "d_val";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= ELF64_XWORD_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					analysis	= "";
					vl			= getStringToLong(value, false);
					analysis	+= "sh_link=0x"+sh.getSh_link_str()+"\n";
					analysis	+= "=>"+ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(sh.getSh_link_int()).getValue().getName()+"\n";
					analysis	+= "index=0x"+value+"\n";
					notes		= ELF_DYNAMIC_ENTRY_d_val_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_val	= null;
					if(rva!=0 && lma!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else if(rva!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else{
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_val_Item	= new TreeItem<>(d_val);
//					d_val_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_val_Item);
					
					//動的リンク用シンボルテーブルからシンボル名取得
					makeDynamicSymbolName(d_val_Item, sh, (int)vl);
					
				}else if(v==DT_SONAME){//共有オブジェクトの名前
					
					//0x08	Elf64_Xword	d_val
					name	= "d_val";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= ELF64_XWORD_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					analysis	= "";
					notes		= ELF_DYNAMIC_ENTRY_d_val_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_val	= null;
					if(rva!=0 && lma!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else if(rva!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else{
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_val_Item	= new TreeItem<>(d_val);
//					d_val_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_val_Item);
					
				}else if(v==DT_RPATH ||
						 v==DT_RUNPATH){	//path
					
					//0x08	Elf64_Xword	d_val
					name	= "d_val";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= ELF64_XWORD_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					analysis	= "";
					notes		= ELF_DYNAMIC_ENTRY_d_val_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_val	= null;
					if(rva!=0 && lma!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else if(rva!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else{
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_val_Item	= new TreeItem<>(d_val);
//					d_val_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_val_Item);
					
				}else if(v==DT_PLTRELSZ ||
						 v==DT_RELASZ ||
						 v==DT_RELAENT ||
						 v==DT_STRSZ ||
						 v==DT_SYMENT ||
						 v==DT_RELSZ ||
						 v==DT_RELENT ||
						 v==DT_INIT_ARRAYSZ ||
						 v==DT_FINI_ARRAYSZ ||
						 v==DT_PREINIT_ARRAYSZ){		//サイズ
				
					//0x08	Elf64_Xword	d_val
					name	= "d_val";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= ELF64_XWORD_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					analysis	= "";
					vl			= getStringToLong(value, false);
					analysis	= String.valueOf(vl)+" bytes";
					notes		= ELF_DYNAMIC_ENTRY_d_val_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_val	= null;
					if(rva!=0 && lma!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else if(rva!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else{
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_val_Item	= new TreeItem<>(d_val);
//					d_val_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_val_Item);
					
				}else if(v==DT_HASH ||
						 v==DT_STRTAB ||
						 v==DT_SYMTAB ||
						 v==DT_RELA ||
						 v==DT_INIT ||
						 v==DT_FINI ||
						 v==DT_REL ||
						 v==DT_JMPREL ||
						 v==DT_INIT_ARRAY ||
						 v==DT_FINI_ARRAY ||
						 v==DT_PREINIT_ARRAY){		//アドレス
					
					//0x08	Elf64_Addr	d_ptr
					name	= "d_ptr";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= ELF64_ADDR_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					analysis	= "";
					notes		= ELF_DYNAMIC_ENTRY_d_ptr_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_ptr	= null;
					if(rva!=0 && lma!=0){
						d_ptr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else if(rva!=0){
						d_ptr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else{
						d_ptr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_ptr_Item	= new TreeItem<>(d_ptr);
//					d_ptr_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_ptr_Item);
							
				}else{
				
					//0x08	Elf64_Xword	d_val
					name	= "d_val";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= ELF64_XWORD_SIZE;
					value	= "";
					if(ELFDATA==ELFDATA2LSB){	//LSB
						for(int i=offset+size-1; i>=offset; i--){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}else{	//MSB
						for(int i=offset; i<offset+size; i++){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
					}
					analysis	= "";
					notes		= ELF_DYNAMIC_ENTRY_d_val_Notes;
					beforesize	= size;
					
					EPlusViewerTreeTableRecord d_val	= null;
					if(rva!=0 && lma!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else if(rva!=0){
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else{
						d_val	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> d_val_Item	= new TreeItem<>(d_val);
//					d_val_Item.setExpanded(true);
					ELF_DYNAMIC_ENTRY_Item.getChildren().add(d_val_Item);

				}
				count++;
			}		
		}
	}
	
	private void makeElfSymbolTable(TreeItem<EPlusViewerTreeTableRecord> item, SectionHeader sh){
		
		if(ELFCLASS==ELFCLASS32){	//32bit	
			//開始アドレス取得
			int startAddr32	= sh.getSh_offset_int();
			
			//データ取得用
			int dataSize	= sh.getSh_size_int();
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			int rva			= 0;
			int lma			= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			int v			= 0;
			long vl			= 0;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;
			
			//カウント
			int count		= 0;	
			
			//取得用
			String stValue	= "";
			String stSize	= "";
			int sttBind		= 0;
			int sttType		= 0;
			int stShndx		= 0;
			
			//アドレス設定
			rawAddr			= startAddr32;
			rva				= sh.getSh_addr_int();
			String strLma	= getVaddrToPaddr(String.format("%08X", rva).toUpperCase());
			if(strLma!=null){
				lma			= getStringToInt(strLma, false);
			}
			
			for(int c=0; c<dataSize; c+=ELF32_SYM_SIZE){				
				//ELF_SYMBOL_TABLE
				name		= "ELF_SYMBOL_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size		= ELF32_SYM_SIZE;
				value		= "";
				analysis	= "";
				notes		= ELF_SYMBOL_TABLE_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_SYMBOL_TABLE	= null;
				if(rva!=0 && lma!=0){
					ELF_SYMBOL_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					ELF_SYMBOL_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					ELF_SYMBOL_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);					
				}
				TreeItem<EPlusViewerTreeTableRecord> ELF_SYMBOL_TABLE_Item 	= new TreeItem<>(ELF_SYMBOL_TABLE);
//				ELF_SYMBOL_TABLE_Item.setExpanded(true);
				item.getChildren().add(ELF_SYMBOL_TABLE_Item);
				
				
				//0x00	Elf32_Word	st_name
				name	= "st_name";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_SYMBOL_TABLE_st_name_Notes;
				beforesize	= size;

				EPlusViewerTreeTableRecord st_name	= null;
				if(rva!=0 && lma!=0){
					st_name					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_name					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					st_name					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> st_name_Item	= new TreeItem<>(st_name);
//				st_name_Item.setExpanded(true);
				ELF_SYMBOL_TABLE_Item.getChildren().add(st_name_Item);

				
				//0x04	Elf32_Addr	st_value
				name	= "st_value";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF32_ADDR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_SYMBOL_TABLE_st_value_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_value	= null;
				if(rva!=0 && lma!=0){
					st_value	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_value	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_value	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> st_value_Item	= new TreeItem<>(st_value);
//				st_value_Item.setExpanded(true);
				ELF_SYMBOL_TABLE_Item.getChildren().add(st_value_Item);
				
				//st_value取得
				stValue	= value;
				
				
				//0x08	Elf32_Word	st_size
				name	= "st_size";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				analysis	= String.valueOf(v)+" bytes";
				notes		= ELF_SYMBOL_TABLE_st_size_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_size	= null;
				if(rva!=0 && lma!=0){
					st_size = new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_size = new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_size = new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> st_size_Item	= new TreeItem<>(st_size);
//				st_size_Item.setExpanded(true);
				ELF_SYMBOL_TABLE_Item.getChildren().add(st_size_Item);					
				
				//st_size取得
				stSize	= value;
				
				
				//0x0c	unsigned char	st_info
				name	= "st_info";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= UNSIGNED_CHAR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				byte vb		= data[offset+size-1];					
				//上位4bit
				if((vb>>4)==0){
					analysis	+= "STB_LOCAL(0x0)"+"\n";
				}else if((vb>>4)==STB_GLOBAL){
					analysis	+= "STB_GLOBAL(0x1)"+"\n";
				}else if((vb>>4)==STB_WEAK){
					analysis	+= "STB_WEAK(0x2)"+"\n";
				}				
				//下位4bit
				if((vb&0xf)==0){
					analysis	+= "STT_NOTYPE(0x0)"+"\n";
				}else if((vb&0xf)==STT_OBJECT){
					analysis	+= "STT_OBJECT(0x1)"+"\n";
				}else if((vb&0xf)==STT_FUNC){
					analysis	+= "STT_FUNC(0x2)"+"\n";
				}else if((vb&0xf)==STT_SECTION){
					analysis	+= "STT_SECTION(0x3)"+"\n";
				}else if((vb&0xf)==STT_FILE){
					analysis	+= "STT_FILE(0x4)"+"\n";
				}else if((vb&0xf)==STT_COMMON){
					analysis	+= "STT_COMMON(0x5)"+"\n";
				}else if((vb&0xf)==STT_TLS){
					analysis	+= "STT_TLS(0x6)"+"\n";
				}
				notes		= ELF_SYMBOL_TABLE_st_info_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_info	= null;
				if(rva!=0 && lma!=0){
					st_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> st_info_Item	= new TreeItem<>(st_info);
//				st_info_Item.setExpanded(true);
				ELF_SYMBOL_TABLE_Item.getChildren().add(st_info_Item);
				
				//stt_bindとstt_type取得
				sttBind	= vb>>4;
				sttType	= vb&0xf;
				
				
				//0x0d	unsigned char	st_other
				name	= "st_other";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= UNSIGNED_CHAR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_SYMBOL_TABLE_st_other_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_other	= null;
				if(rva!=0 && lma!=0){
					st_other = new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_other = new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_other = new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> st_other_Item	= new TreeItem<>(st_other);
//				st_other_Item.setExpanded(true);
				ELF_SYMBOL_TABLE_Item.getChildren().add(st_other_Item);
			
				
				//0x0e	Elf32_Half	st_shndx
				name	= "st_shndx";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF32_HALF_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				v			= v&0xffff;
				if(v==0){
					analysis	+= "SHN_UNDEF(0x0)";
				}else if(v==SHN_LORESERVE || v==SHN_LOPROC || v==SHN_BEFORE){
					analysis	+= "SHN_LORESERVE(0xff00),SHN_LOPROC(0xff00),SHN_BEFORE(0xff00)";
				}else if(v==SHN_AFTER){
					analysis	+= "SHN_AFTER(0xff01)";			
				}else if(v==SHN_HIPROC){
					analysis	+= "SHN_HIPROC(0xff1f)";
				}else if(v==SHN_ABS){
					analysis	+= "SHN_ABS(0xfff1)";
				}else if(v==SHN_COMMON){
					analysis	+= "SHN_COMMON(0xfff2)";
				}else if(v==SHN_HIRESERVE){
					analysis	+= "SHN_HIRESERVE(0xffff)";
				}else if(v>0 && v<ELF_SHDR_NUM){
					analysis	+= ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(v).getValue().getName();
				}
				notes		= ELF_SYMBOL_TABLE_st_shndx_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_shndx	= null;
				if(rva!=0 && lma!=0){
					st_shndx = new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){				
					st_shndx = new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_shndx = new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> st_shndx_Item	= new TreeItem<>(st_shndx);
//				st_shndx_Item.setExpanded(true);
				ELF_SYMBOL_TABLE_Item.getChildren().add(st_shndx_Item);
				
				//st_shndx取得
				stShndx	= v;
				
				
				//st_valueの参照先を作成
				if(E_TYPE==ET_REL){			
					if(sttType==STT_OBJECT || sttType==STT_FUNC){
						if(getStringToInt(stSize, false)>0 && stShndx>0 && stShndx<ELF_SHDR_NUM){
							SectionHeader section	= sectionHeaderList.get(stShndx);
							String address			= getAddStrAddrInt(section.getSh_offset_str(), false, stValue, false);
							if(getStringToInt(address, false)+getStringToInt(stSize, false)> section.getSh_offset_int()+section.getSh_size_int()){
								address		= stValue;
							}
							String vaddress			= null;
							if(section.getSh_addr_int()!=0){
								vaddress	= section.getSh_addr_str();
							}	
							if(sttType==STT_OBJECT && section.getSh_type_int()!=SHT_NOBITS){								
								//Data作成
								makeData(st_value_Item, address, vaddress, stSize, true);
							}else if(sttType==STT_FUNC){
								//Data作成
								makeData(st_value_Item, address, vaddress, stSize, false);
							}
						}
					}
				}else if(E_TYPE==ET_DYN){	
					if(sttType==STT_OBJECT || sttType==STT_FUNC){
						if(getStringToInt(stSize, false)>0 && stShndx>0 && stShndx<ELF_SHDR_NUM){
							SectionHeader section	= sectionHeaderList.get(stShndx);
							String vaddress			= stValue;
							String address			= getVaddrToFileoffset(stValue, false);			
							if(address!=null){
								if(sttType==STT_OBJECT && section.getSh_type_int()!=SHT_NOBITS){								
									//Data作成
									makeData(st_value_Item, address, vaddress, stSize, true);
								}else if(sttType==STT_FUNC){
									//Data作成
									makeData(st_value_Item, address, vaddress, stSize, false);
								}
							}
						}
					}
				}else if(E_TYPE==ET_EXEC || E_TYPE==ET_CORE){
					if(sttType==STT_OBJECT || sttType==STT_FUNC){
						if(getStringToInt(stSize, false)>0 && stShndx>0 && stShndx<ELF_SHDR_NUM){
							SectionHeader section	= sectionHeaderList.get(stShndx);
							String address			= null;
							String vaddress			= stValue;
							if(sttType==STT_OBJECT && section.getSh_type_int()!=SHT_NOBITS){
								//Data作成
								makeData(st_value_Item, address, vaddress, stSize, true);
							}else if(sttType==STT_FUNC){
								//Data作成
								makeData(st_value_Item, address, vaddress, stSize, false);
							}
						}
					}
				}else{
					//なにもしない
				}
				
				count++;
			}

			//セクション名文字列テーブルを取得
			SectionHeader ELF_SYMBOL_TABLE_sh	= sectionHeaderList.get(sh.getSh_link_int());
			
			//ストリングテーブルのデータ開始アドレスとサイズを取得
			startAddr32	= ELF_SYMBOL_TABLE_sh.getSh_offset_int();
			dataSize	= ELF_SYMBOL_TABLE_sh.getSh_size_int();
			data		= getBintableBytes(startAddr32, dataSize);

			//ELF_SYMBOL_TABLE取得
			ObservableList<TreeItem<EPlusViewerTreeTableRecord>> ELF_SECTION_DATA_Item_List	= item.getChildren();
			Iterator<TreeItem<EPlusViewerTreeTableRecord>> ELF_SECTION_DATA_Item_Iterator	= ELF_SECTION_DATA_Item_List.iterator();
			
			TreeItem<EPlusViewerTreeTableRecord> ELF_SYMBOL_TABLE_Item	= null;
			EPlusViewerTreeTableRecord ELF_SYMBOL_TABLE					= null;
			TreeItem<EPlusViewerTreeTableRecord> st_name_Item			= null;
			EPlusViewerTreeTableRecord st_name							= null;	
			
			while(ELF_SECTION_DATA_Item_Iterator.hasNext()){
				
				ELF_SYMBOL_TABLE_Item	= (TreeItem<EPlusViewerTreeTableRecord>)ELF_SECTION_DATA_Item_Iterator.next();
				ELF_SYMBOL_TABLE		= ELF_SYMBOL_TABLE_Item.getValue();
				st_name_Item			= ELF_SYMBOL_TABLE_Item.getChildren().get(0);
				st_name					= st_name_Item.getValue();
								
				//0x00	Variable	name;	
				name			= "name";
				int index		= getStringToInt(st_name.getValue(), false);
				rawAddr			= startAddr32+index;	
				raw				= rawAddr;	
				offset			= index;
				if(ELF_SYMBOL_TABLE_sh.getSh_addr_int()!=0){
					rva			= ELF_SYMBOL_TABLE_sh.getSh_addr_int()+index;
				}else{
					rva			= 0;
				}
				strLma			= getVaddrToPaddr(String.format("%08X", rva).toUpperCase());
				if(strLma!=null){
					lma			= getStringToInt(strLma, false);
				}else {
					lma			= 0;
				}
				size			= 0;
				int dataCount	= 0;
				value			= "";
				analysis		= "";
				notes			= ELF_STRING_TABLE_NAME_Notes;
			
				while(data[index]!=0 && index<dataSize){
					value		+= String.format("%02X", data[index]).toUpperCase();
					analysis	+= String.format("%c", data[index]);
					dataCount++;
					index++;
				}
				
				if(dataCount!=0){
					//サイズ更新
					size		= dataCount;
					
					EPlusViewerTreeTableRecord Name	= null;
					if(rva!=0 && lma!=0){
						Name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else if(rva!=0){
						Name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else{
						Name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}
					TreeItem<EPlusViewerTreeTableRecord> Name_Item	= new TreeItem<>(Name);
//					Name_Item.setExpanded(true);
					st_name_Item.getChildren().add(Name_Item);
				
					//ELF_SYMBOL_TABLEにname追加
					ELF_SYMBOL_TABLE.setName(ELF_SYMBOL_TABLE.getName()+":"+analysis);
				}
			}
			
		}else if(ELFCLASS==ELFCLASS64){	//64bit	
			//開始アドレス取得
			long startAddr64	= sh.getSh_offset_long();
			int startAddr32		= (int)startAddr64;
	
			//データ取得用
			int dataSize	= (int)sh.getSh_size_long();
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			long rva		= 0;
			long lma		= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			int v			= 0;
			long vl			= 0;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;
			
			//カウント
			int count		= 0;	
			
			//取得用
			String stValue	= "";
			String stSize	= "";
			int sttBind		= 0;
			int sttType		= 0;
			int stShndx		= 0;
			
			//アドレス設定
			rawAddr			= startAddr32;
			rva				= sh.getSh_addr_long();
			String strLma	= getVaddrToPaddr(String.format("%016X", rva).toUpperCase());
			if(strLma!=null){
				lma			= getStringToLong(strLma, false);
			}
					
			for(int c=0; c<dataSize; c+=ELF64_SYM_SIZE){				
				//ELF_SYMBOL_TABLE
				name		= "ELF_SYMBOL_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size		= ELF64_SYM_SIZE;
				value		= "";
				analysis	= "";
				notes		= ELF_SYMBOL_TABLE_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_SYMBOL_TABLE	= null;
				if(rva!=0 && lma!=0){
					ELF_SYMBOL_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					ELF_SYMBOL_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					ELF_SYMBOL_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> ELF_SYMBOL_TABLE_Item 	= new TreeItem<>(ELF_SYMBOL_TABLE);
//				ELF_SYMBOL_TABLE_Item.setExpanded(true);
				item.getChildren().add(ELF_SYMBOL_TABLE_Item);
				
				
				//0x00	Elf64_Word	st_name
				name	= "st_name";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_SYMBOL_TABLE_st_name_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_name	= null;
				if(rva!=0 && lma!=0){
					st_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> st_name_Item	= new TreeItem<>(st_name);
//				st_name_Item.setExpanded(true);
				ELF_SYMBOL_TABLE_Item.getChildren().add(st_name_Item);

				
				//0x04	unsigned char	st_info
				name	= "st_info";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= UNSIGNED_CHAR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				byte vb		= data[offset+size-1];	
				//上位4bit
				if((vb>>4)==0){
					analysis	+= "STB_LOCAL(0x0)"+"\n";
				}else if((vb>>4)==STB_GLOBAL){
					analysis	+= "STB_GLOBAL(0x1)"+"\n";
				}else if((vb>>4)==STB_WEAK){
					analysis	+= "STB_WEAK(0x2)"+"\n";
				}					
				//下位4bit
				if((vb&0xf)==0){
					analysis	+= "STT_NOTYPE(0x0)"+"\n";
				}else if((vb&0xf)==STT_OBJECT){
					analysis	+= "STT_OBJECT(0x1)"+"\n";
				}else if((vb&0xf)==STT_FUNC){
					analysis	+= "STT_FUNC(0x2)"+"\n";
				}else if((vb&0xf)==STT_SECTION){
					analysis	+= "STT_SECTION(0x3)"+"\n";
				}else if((vb&0xf)==STT_FILE){
					analysis	+= "STT_FILE(0x4)"+"\n";
				}else if((vb&0xf)==STT_COMMON){
					analysis	+= "STT_COMMON(0x5)"+"\n";
				}else if((vb&0xf)==STT_TLS){
					analysis	+= "STT_TLS(0x6)"+"\n";
				}				
				notes		= ELF_SYMBOL_TABLE_st_info_Notes;
				beforesize	= size;
			
				EPlusViewerTreeTableRecord st_info	= null;
				if(rva!=0 && lma!=0){
					st_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}
				TreeItem<EPlusViewerTreeTableRecord> st_info_Item	= new TreeItem<>(st_info);
//				st_info_Item.setExpanded(true);
				ELF_SYMBOL_TABLE_Item.getChildren().add(st_info_Item);
			
				//stt_bindとstt_type取得
				sttBind	= vb>>4;
				sttType	= vb&0xf;
				
			
				//0x05	unsigned char	st_other
				name	= "st_other";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= UNSIGNED_CHAR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_SYMBOL_TABLE_st_other_Notes;
				beforesize	= size;
			
				EPlusViewerTreeTableRecord st_other	= null;
				if(rva!=0 && lma!=0){
					st_other	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_other	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_other	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);							
				}
				TreeItem<EPlusViewerTreeTableRecord> st_other_Item	= new TreeItem<>(st_other);
//				st_other_Item.setExpanded(true);
				ELF_SYMBOL_TABLE_Item.getChildren().add(st_other_Item);				
		
			
				//0x06	Elf64_Half	st_shndx
				name	= "st_shndx";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_HALF_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				v			= v&0xffff;
				if(v==0){
					analysis	+= "SHN_UNDEF(0x0)";
				}else if(v==SHN_LORESERVE || v==SHN_LOPROC || v==SHN_BEFORE){
					analysis	+= "SHN_LORESERVE(0xff00),SHN_LOPROC(0xff00),SHN_BEFORE(0xff00)";
				}else if(v==SHN_AFTER){
					analysis	+= "SHN_AFTER(0xff01)";			
				}else if(v==SHN_HIPROC){
					analysis	+= "SHN_HIPROC(0xff1f)";
				}else if(v==SHN_ABS){
					analysis	+= "SHN_ABS(0xfff1)";
				}else if(v==SHN_COMMON){
					analysis	+= "SHN_COMMON(0xfff2)";
				}else if(v==SHN_HIRESERVE){
					analysis	+= "SHN_HIRESERVE(0xffff)";
				}else if(v>0 && v<ELF_SHDR_NUM){
					analysis	+= ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(v).getValue().getName();
				}				
				notes		= ELF_SYMBOL_TABLE_st_shndx_Notes;
				beforesize	= size;
			
				EPlusViewerTreeTableRecord st_shndx	= null;
				if(rva!=0 && lma!=0){
					st_shndx	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_shndx	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_shndx	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}
				TreeItem<EPlusViewerTreeTableRecord> st_shndx_Item	= new TreeItem<>(st_shndx);
//				st_shndx_Item.setExpanded(true);
				ELF_SYMBOL_TABLE_Item.getChildren().add(st_shndx_Item);				
			
				//st_shndx取得
				stShndx	= v;
				

				//0x08	Elf64_Addr	st_value
				name	= "st_value";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_ADDR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_SYMBOL_TABLE_st_value_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_value	= null;
				if(rva!=0 && lma!=0){
					st_value = new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_value = new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_value = new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);	
				}
				TreeItem<EPlusViewerTreeTableRecord> st_value_Item	= new TreeItem<>(st_value);
//				st_value_Item.setExpanded(true);
				ELF_SYMBOL_TABLE_Item.getChildren().add(st_value_Item);
				
				//st_value取得
				stValue	= value;
				
				
				//0x10	Elf64_Xword	st_size
				name	= "st_size";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_XWORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				vl			= getStringToLong(value, false);
				analysis	= String.valueOf(vl)+" bytes";
				notes		= ELF_SYMBOL_TABLE_st_size_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_size	= null;
				if(rva!=0 && lma!=0){
					st_size	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_size	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_size	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);			
				}
				TreeItem<EPlusViewerTreeTableRecord> st_size_Item	= new TreeItem<>(st_size);
//				st_size_Item.setExpanded(true);
				ELF_SYMBOL_TABLE_Item.getChildren().add(st_size_Item);					
					
				//st_size取得
				stSize	= value;
				
				
				//st_valueの参照先を作成
				if(E_TYPE==ET_REL){			
					if(sttType==STT_OBJECT || sttType==STT_FUNC){
						if(getStringToLong(stSize, false)>0 && stShndx>0 && stShndx<ELF_SHDR_NUM){
							SectionHeader section	= sectionHeaderList.get(stShndx);
							String address			= getAddStrAddrLong(section.getSh_offset_str(), false, stValue, false);							
							if(getStringToLong(address, false)+getStringToLong(stSize, false)> section.getSh_offset_long()+section.getSh_size_long()){
								address		= stValue;
							}
							
							String vaddress	= null;
							if(section.getSh_addr_long()!=0){
								vaddress	= section.getSh_addr_str();
							}	
							if(sttType==STT_OBJECT && section.getSh_type_int()!=SHT_NOBITS){
								//Data作成
								makeData(st_value_Item, address, vaddress, stSize, true);
							}else if(sttType==STT_FUNC){
								//Data作成
								makeData(st_value_Item, address, vaddress, stSize, false);
							}
						}
					}
				}else if(E_TYPE==ET_DYN){	
					if(sttType==STT_OBJECT || sttType==STT_FUNC){
						if(getStringToLong(stSize, false)>0 && stShndx>0 && stShndx<ELF_SHDR_NUM){
							SectionHeader section	= sectionHeaderList.get(stShndx);
							String vaddress			= stValue;
							String address			= getVaddrToFileoffset(stValue, false);
							if(address!=null){
								if(sttType==STT_OBJECT && section.getSh_type_int()!=SHT_NOBITS){
									//Data作成
									makeData(st_value_Item, address, vaddress, stSize, true);
								}else if(sttType==STT_FUNC){
									//Data作成
									makeData(st_value_Item, address, vaddress, stSize, false);
								}
							}
						}
					}
				}else if(E_TYPE==ET_EXEC || E_TYPE==ET_CORE){
					if(sttType==STT_OBJECT || sttType==STT_FUNC){
						if(getStringToLong(stSize, false)>0 && stShndx>0 && stShndx<ELF_SHDR_NUM){
							SectionHeader section	= sectionHeaderList.get(stShndx);
							String address			= null;
							String vaddress			= stValue;
							if(sttType==STT_OBJECT && section.getSh_type_int()!=SHT_NOBITS){
								//Data作成
								makeData(st_value_Item, address, vaddress, stSize, true);
							}else if(sttType==STT_FUNC){
								//Data作成
								makeData(st_value_Item, address, vaddress, stSize, false);
							}
						}
					}
				}else{
					//なにもしない
				}

				count++;
			}

			//セクション名文字列テーブルを取得
			SectionHeader ELF_SYMBOL_TABLE_sh	= sectionHeaderList.get(sh.getSh_link_int());
			
			//ストリングテーブルのデータ開始アドレスとサイズを取得
			startAddr64	= ELF_SYMBOL_TABLE_sh.getSh_offset_long();
			startAddr32	= (int)startAddr64;
			dataSize	= (int)ELF_SYMBOL_TABLE_sh.getSh_size_long();
			data		= getBintableBytes(startAddr32, dataSize);

			//ELF_SYMBOL_TABLE取得
			ObservableList<TreeItem<EPlusViewerTreeTableRecord>> ELF_SECTION_DATA_Item_List = item.getChildren();
			Iterator<TreeItem<EPlusViewerTreeTableRecord>> ELF_SECTION_DATA_Item_Iterator	= ELF_SECTION_DATA_Item_List.iterator();
			
			TreeItem<EPlusViewerTreeTableRecord> ELF_SYMBOL_TABLE_Item	= null;
			EPlusViewerTreeTableRecord ELF_SYMBOL_TABLE					= null;
			TreeItem<EPlusViewerTreeTableRecord> st_name_Item			= null;
			EPlusViewerTreeTableRecord st_name							= null;	
			
			while(ELF_SECTION_DATA_Item_Iterator.hasNext()){
				
				ELF_SYMBOL_TABLE_Item	= (TreeItem<EPlusViewerTreeTableRecord>)ELF_SECTION_DATA_Item_Iterator.next();
				ELF_SYMBOL_TABLE		= ELF_SYMBOL_TABLE_Item.getValue();
				st_name_Item			= ELF_SYMBOL_TABLE_Item.getChildren().get(0);
				st_name					= st_name_Item.getValue();
								
				//0x00	Variable	name;	
				name			= "name";
				int index		= getStringToInt(st_name.getValue(), false);
				rawAddr			= startAddr32+index;	
				raw				= rawAddr;	
				offset			= index;
				if(ELF_SYMBOL_TABLE_sh.getSh_addr_long()!=0){
					rva			= ELF_SYMBOL_TABLE_sh.getSh_addr_long()+index;
				}else{
					rva			= 0;
				}
				strLma			= getVaddrToPaddr(String.format("%016X", rva).toUpperCase());
				if(strLma!=null){
					lma			= getStringToLong(strLma, false);
				}else{
					lma			= 0;
				}
				size			= 0;
				int dataCount	= 0;
				value			= "";
				analysis		= "";
				notes			= ELF_STRING_TABLE_NAME_Notes;
			
				while(data[index]!=0 && index<dataSize){
					value		+= String.format("%02X", data[index]).toUpperCase();
					analysis	+= String.format("%c", data[index]);
					dataCount++;
					index++;
				}
				
				if(dataCount!=0){
					//サイズ更新
					size		= dataCount;
					
					EPlusViewerTreeTableRecord Name	= null;
					if(rva!=0 && lma!=0){
						Name = new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else if(rva!=0){
						Name = new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else{
						Name = new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);			
					}
					TreeItem<EPlusViewerTreeTableRecord> Name_Item	= new TreeItem<>(Name);
//					Name_Item.setExpanded(true);
					st_name_Item.getChildren().add(Name_Item);
				
					//ELF_SYMBOL_TABLEにname追加
					ELF_SYMBOL_TABLE.setName(ELF_SYMBOL_TABLE.getName()+":"+analysis);				
				}
			}
		}
	}
	
	private void makeDynamicSymbolName(TreeItem<EPlusViewerTreeTableRecord> item, SectionHeader sh, int index){
				
		if(ELFCLASS==ELFCLASS32){	//32bit
			//開始アドレス取得
			int startAddr32		= 0;
			
			//データ取得用
			int dataSize	= 0;
			byte[] data		= null;
			
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			int rva			= 0;
			int lma			= 0;
			int offset		= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			
			//セクション名文字列テーブルを取得
			SectionHeader ELF_SYMBOL_TABLE_sh	= sectionHeaderList.get(sh.getSh_link_int());
			
			//ストリングテーブルのデータ開始アドレスとサイズを取得
			startAddr32	= ELF_SYMBOL_TABLE_sh.getSh_offset_int();
			dataSize	= ELF_SYMBOL_TABLE_sh.getSh_size_int();
			data		= getBintableBytes(startAddr32, dataSize);
			
			//0x00	Variable	name;	
			name			= "name";
			rawAddr			= startAddr32+index;	
			raw				= rawAddr;	
			offset			= index;
			if(ELF_SYMBOL_TABLE_sh.getSh_addr_int()!=0){
				rva			= ELF_SYMBOL_TABLE_sh.getSh_addr_int()+index;
			}
			String strLma	= getVaddrToPaddr(String.format("%08X", rva).toUpperCase());
			if(strLma!=null){
				lma			= getStringToInt(strLma, false);
			}
			size			= 0;
			int dataCount	= 0;
			value			= "";
			analysis		= "";
			notes			= ELF_DYNAMIC_SYMBOL_NAME_Notes;					
			
			while(data[index]!=0 && index<dataSize){
				value		+= String.format("%02X", data[index]).toUpperCase();
				analysis	+= String.format("%c", data[index]);
				dataCount++;
				index++;
			}
				
			if(dataCount!=0){
				//サイズ更新
				size		= dataCount;
				
				EPlusViewerTreeTableRecord Name	= null;
				if(rva!=0 && lma!=0){
					Name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					Name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					Name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> Name_Item	= new TreeItem<>(Name);
//				Name_Item.setExpanded(true);
				item.getChildren().add(Name_Item);
			}
			
		}else if(ELFCLASS==ELFCLASS64){	//64bit
			//開始アドレス取得
			long startAddr64	= 0;
			int startAddr32		= 0;
	
			//データ取得用
			int dataSize	= 0;
			byte[] data		= null;
			
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			long rva		= 0;
			long lma		= 0;
			int offset		= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			
			//セクション名文字列テーブルを取得
			SectionHeader ELF_SYMBOL_TABLE_sh	= sectionHeaderList.get(sh.getSh_link_int());
			
			//ストリングテーブルのデータ開始アドレスとサイズを取得
			startAddr64	= ELF_SYMBOL_TABLE_sh.getSh_offset_long();
			startAddr32 = (int)startAddr64;
			dataSize	= (int)ELF_SYMBOL_TABLE_sh.getSh_size_long();
			data		= getBintableBytes(startAddr32, dataSize);
			
			//0x00	Variable	name;	
			name			= "name";
			rawAddr			= startAddr32+index;	
			raw				= rawAddr;	
			offset			= index;
			if(ELF_SYMBOL_TABLE_sh.getSh_addr_long()!=0){
				rva			= ELF_SYMBOL_TABLE_sh.getSh_addr_long()+index;
			}
			String strLma	= getVaddrToPaddr(String.format("%016X", rva).toUpperCase());
			if(strLma!=null){
				lma			= getStringToLong(strLma, false);
			}
			size			= 0;
			int dataCount	= 0;
			value			= "";
			analysis		= "";
			notes			= ELF_DYNAMIC_SYMBOL_NAME_Notes;					
			
			while(data[index]!=0 && index<dataSize){
				value		+= String.format("%02X", data[index]).toUpperCase();
				analysis	+= String.format("%c", data[index]);
				dataCount++;
				index++;
			}
				
			if(dataCount!=0){
				//サイズ更新
				size		= dataCount;
				
				EPlusViewerTreeTableRecord Name	= null;
				if(rva!=0 && lma!=0){
					Name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else if(rva!=0){
					Name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					Name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> Name_Item	= new TreeItem<>(Name);
//				Name_Item.setExpanded(true);
				item.getChildren().add(Name_Item);
			}
		}		
	}

	private void makeElfRelocationAddendTable(TreeItem<EPlusViewerTreeTableRecord> item, SectionHeader sh){
		
		if(ELFCLASS==ELFCLASS32){	//32bit	
			//開始アドレス取得
			int startAddr32	= sh.getSh_offset_int();
			
			//データ取得用
			int dataSize	= sh.getSh_size_int();
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			int rva			= 0;
			int lma			= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			int v			= 0;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;
			
			//カウント
			int count		= 0;
			
			//取得用
			String rOffset		= null;
			int rInfo			= 0;
			String address		= null;
			String raddress		= null;
			
			//アドレス設定
			rawAddr			= startAddr32;
			rva				= sh.getSh_addr_int();
			String strLma	= getVaddrToPaddr(String.format("%08X", rva).toUpperCase());
			if(strLma!=null){
				lma			= getStringToInt(strLma, false);
			}
			
			for(int c=0; c<dataSize; c+=ELF32_RELA_SIZE){								
				//ELF_RELOCATION_ADDEND_TABLE
				name		= "ELF_RELOCATION_ADDEND_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size		= ELF32_RELA_SIZE;
				value		= "";
				analysis	= "";
				notes		= ELF_RELOCATION_ADDEND_TABLE_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_RELOCATION_ADDEND_TABLE	= null;
				if(rva!=0 && lma!=0){
					ELF_RELOCATION_ADDEND_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					ELF_RELOCATION_ADDEND_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					ELF_RELOCATION_ADDEND_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> ELF_RELOCATION_ADDEND_TABLE_Item 	= new TreeItem<>(ELF_RELOCATION_ADDEND_TABLE);
//				ELF_RELOCATION_ADDEND_TABLE_Item.setExpanded(true);
				item.getChildren().add(ELF_RELOCATION_ADDEND_TABLE_Item);
				
				
				//0x00	Elf32_Addr	r_offset
				name	= "r_offset";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF32_ADDR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_RELOCATION_ADDEND_TABLE_r_offset_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord r_offset	= null;
				if(rva!=0 && lma!=0){
					r_offset	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					r_offset	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					r_offset	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> r_offset_Item	= new TreeItem<>(r_offset);
//				r_offset_Item.setExpanded(true);
				ELF_RELOCATION_ADDEND_TABLE_Item.getChildren().add(r_offset_Item);
			
				//r_offset取得
				rOffset	= value;
				
			
				//0x04	Elf32_Word	r_info
				name	= "r_info";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				analysis	+= "sh_info=0x"+sh.getSh_info_str()+"\n";
				if(getStringToInt(sh.getSh_info_str(), false)!=0){
					analysis	+= "=>"+ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(getStringToInt(sh.getSh_info_str(), false)).getValue().getName()+"\n";
				}
				analysis	+= "sh_link=0x"+sh.getSh_link_str()+"\n";
				if(sh.getSh_link_int()!=0){
					analysis	+= "=>"+ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(sh.getSh_link_int()).getValue().getName()+"\n";
				}
				analysis	+= "R_SYM=0x"+(v>>8)+"\n";
				if(sh.getSh_link_int()!=0 && (v>>8)>0){
					analysis	+= "=>"+ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(sh.getSh_link_int()).getChildren().get(10).getChildren().get((v>>8)).getValue().getName()+"\n";
				
					//シンボル名を設定
					int symindex	= ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(sh.getSh_link_int()).getChildren().get(10).getChildren().get((v>>8)).getValue().getName().indexOf(":");
					if(symindex!=-1){
						String symname	= ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(sh.getSh_link_int()).getChildren().get(10).getChildren().get((v>>8)).getValue().getName().substring(symindex);
						ELF_RELOCATION_ADDEND_TABLE.setName(ELF_RELOCATION_ADDEND_TABLE.getName()+symname);
					}
				}
				analysis	+= "R_TYPE=0x"+(v&0xff)+"\n";
				if((v&0xff)==R_386_NONE){
					analysis	+= "=>R_386_NONE(0)"+"\n";
				}else if((v&0xff)==R_386_32){
					analysis	+= "=>R_386_32(1)"+"\n";
				}else if((v&0xff)==R_386_PC32){
					analysis	+= "=>R_386_PC32(2)"+"\n";
				}else if((v&0xff)==R_386_GOT32){
					analysis	+= "=>R_386_GOT32(3)"+"\n";
				}else if((v&0xff)==R_386_PLT32){
					analysis	+= "=>R_386_PLT32(4)"+"\n";
				}else if((v&0xff)==R_386_COPY){
					analysis	+= "=>R_386_COPY(5)"+"\n";
				}else if((v&0xff)==R_386_GLOB_DAT){
					analysis	+= "=>R_386_GLOB_DAT(6)"+"\n";
				}else if((v&0xff)==R_386_JMP_SLOT){
					analysis	+= "=>R_386_JMP_SLOT(7)"+"\n";
				}else if((v&0xff)==R_386_RELATIVE){
					analysis	+= "=>R_386_RELATIVE(8)"+"\n";
				}else if((v&0xff)==R_386_GOTOFF){
					analysis	+= "=>R_386_GOTOFF(9)"+"\n";
				}else if((v&0xff)==R_386_GOTPC){
					analysis	+= "=>R_386_GOTPC(10)"+"\n";
				}else if((v&0xff)==R_386_NUM){
					analysis	+= "=>R_386_NUM(16)"+"\n";
				}
				notes		= ELF_RELOCATION_ADDEND_TABLE_r_info_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord r_info	= null;
				if(rva!=0 && lma!=0){
					r_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					r_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					r_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> r_info_Item	= new TreeItem<>(r_info);
//				r_info_Item.setExpanded(true);
				ELF_RELOCATION_ADDEND_TABLE_Item.getChildren().add(r_info_Item);				
					
				//r_info取得
				rInfo	= v;
				
				
				//0x08	Elf32_Sword	r_addend
				name	= "r_addend";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF32_SWORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_RELOCATION_ADDEND_TABLE_r_addend_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord r_addend	= null;
				if(rva!=0 && lma!=0){
					r_addend	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					r_addend	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					r_addend	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> r_addend_Item	= new TreeItem<>(r_addend);
//				r_addend_Item.setExpanded(true);
				ELF_RELOCATION_ADDEND_TABLE_Item.getChildren().add(r_addend_Item);
				
				//r_offsetの参照先を作成	
				if(E_TYPE==ET_REL){	
					if((rInfo&0xff)!=R_386_COPY){
						//セクションを特定
						int sectionHeaderIndex		= getStringToInt(sh.getSh_info_str(), false);
						SectionHeader sectionHeader	= sectionHeaderList.get(sectionHeaderIndex);
						
						address		= getAddStrAddrInt(sectionHeader.getSh_offset_str(), false, rOffset, false);
						raddress	= null;
						
						//参照先のアドレスデータを作成
						makeR_OffsetAddr(r_offset_Item, address, raddress, sectionHeaderIndex);
				
					}
				}else if(E_TYPE==ET_EXEC || E_TYPE==ET_DYN || E_TYPE==ET_CORE){
					if((rInfo&0xff)!=R_386_COPY){
						address		= null;
						raddress	= rOffset;
						
						//セクションを特定
						Iterator<SectionHeader> sectionHeader_Iterator	= sectionHeaderList.iterator();
						SectionHeader sectionHeader						= null;
						int sectionHeaderIndex							= 0;
						long diffAddr									= 0;
						long address_long								= 0;
						
						while(sectionHeader_Iterator.hasNext()){
							sectionHeader	= (SectionHeader)sectionHeader_Iterator.next();				
							if(sectionHeader.addrCheckInt(raddress, ELF32_ADDR_SIZE)){
								diffAddr		= Integer.toUnsignedLong(sectionHeader.getSh_addr_int())-Integer.toUnsignedLong(sectionHeader.getSh_offset_int());
								address_long	= Integer.toUnsignedLong(getStringToInt(raddress, false))-diffAddr;
								address			= String.format("%08X", (int)address_long).toUpperCase();	
								break;
							}else {
								sectionHeader = null;
							}
							sectionHeaderIndex++;
						}
						
						if(address!=null && sectionHeader!=null){
							//参照先のアドレスデータを作成
							makeR_OffsetAddr(r_offset_Item, address, raddress, sectionHeaderIndex);
						}					
					}
				}else{
					//何もしない
				}

				count++;
			}
		}else if(ELFCLASS==ELFCLASS64){	//64bit
			//開始アドレス取得
			long startAddr64	= sh.getSh_offset_long();
			int startAddr32		= (int)startAddr64;

			//データ取得用
			int dataSize	= (int)sh.getSh_size_long();
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			long rva		= 0;
			long lma		= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			long vl			= 0;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;
			
			//カウント
			int count		= 0;
			
			//取得用
			String rOffset		= null;
			int rType			= 0;
			String address		= null;
			String raddress		= null;
			
			//アドレス設定
			rawAddr			= startAddr32;
			rva				= sh.getSh_addr_long();
			String strLma	= getVaddrToPaddr(String.format("%016X", rva).toUpperCase());
			if(strLma!=null){
				lma			= getStringToLong(strLma, false);
			}	
			
			for(int c=0; c<dataSize; c+=ELF64_RELA_SIZE){								
				//ELF_RELOCATION_ADDEND_TABLE
				name		= "ELF_RELOCATION_ADDEND_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size		= ELF64_RELA_SIZE;
				value		= "";
				analysis	= "";
				notes		= ELF_RELOCATION_ADDEND_TABLE_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_RELOCATION_ADDEND_TABLE	= null;
				if(rva!=0 && lma!=0){
					ELF_RELOCATION_ADDEND_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					ELF_RELOCATION_ADDEND_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					ELF_RELOCATION_ADDEND_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> ELF_RELOCATION_ADDEND_TABLE_Item 	= new TreeItem<>(ELF_RELOCATION_ADDEND_TABLE);
//				ELF_RELOCATION_ADDEND_TABLE_Item.setExpanded(true);
				item.getChildren().add(ELF_RELOCATION_ADDEND_TABLE_Item);
				
				
				//0x00	Elf64_Addr	r_offset
				name	= "r_offset";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_ADDR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_RELOCATION_ADDEND_TABLE_r_offset_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord r_offset	= null;
				if(rva!=0 && lma!=0){
					r_offset	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					r_offset	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					r_offset	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> r_offset_Item	= new TreeItem<>(r_offset);
//				r_offset_Item.setExpanded(true);
				ELF_RELOCATION_ADDEND_TABLE_Item.getChildren().add(r_offset_Item);
			
				//r_offset取得
				rOffset	= value;
				
			
				//0x04	Elf64_Xword	r_info
				name	= "r_info";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_XWORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				vl			= getStringToLong(value, false);
				int r_type	= (int)(vl&0xffffffff);
				analysis	+= "sh_info=0x"+sh.getSh_info_str()+"\n";
				if(getStringToInt(sh.getSh_info_str(), false)!=0){
					analysis	+= "=>"+ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(getStringToInt(sh.getSh_info_str(), false)).getValue().getName()+"\n";
				}
				analysis	+= "sh_link=0x"+sh.getSh_link_str()+"\n";
				if(sh.getSh_link_int()!=0){
					analysis	+= "=>"+ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(sh.getSh_link_int()).getValue().getName()+"\n";
				}
				analysis	+= "R_SYM=0x"+(vl>>32)+"\n";
				if(sh.getSh_link_int()!=0 && (vl>>32)>0){
					analysis	+= "=>"+ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(sh.getSh_link_int()).getChildren().get(10).getChildren().get((int)(vl>>32)).getValue().getName()+"\n";
				
					//シンボル名を設定
					int symindex	= ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(sh.getSh_link_int()).getChildren().get(10).getChildren().get((int)(vl>>32)).getValue().getName().indexOf(":");
					if(symindex!=-1){
						String symname	= ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(sh.getSh_link_int()).getChildren().get(10).getChildren().get((int)(vl>>32)).getValue().getName().substring(symindex);
						ELF_RELOCATION_ADDEND_TABLE.setName(ELF_RELOCATION_ADDEND_TABLE.getName()+symname);
					}
				}
				analysis	+= "R_TYPE=0x"+r_type+"\n";
				if(r_type==R_X86_64_NONE){
					analysis	+= "=>R_X86_64_NONE(0)"+"\n";
				}else if(r_type==R_X86_64_64){
					analysis	+= "=>R_X86_64_64(1)"+"\n";
				}else if(r_type==R_X86_64_PC32){
					analysis	+= "=>R_X86_64_PC32(2)"+"\n";
				}else if(r_type==R_X86_64_GOT32){
					analysis	+= "=>R_X86_64_GOT32(3)"+"\n";
				}else if(r_type==R_X86_64_PLT32){
					analysis	+= "=>R_X86_64_PLT32(4)"+"\n";
				}else if(r_type==R_X86_64_COPY){
					analysis	+= "=>R_X86_64_COPY(5)"+"\n";
				}else if(r_type==R_X86_64_GLOB_DAT){
					analysis	+= "=>R_X86_64_GLOB_DAT(6)"+"\n";
				}else if(r_type==R_X86_64_JUMP_SLOT){
					analysis	+= "=>R_X86_64_JUMP_SLOT(7)"+"\n";
				}else if(r_type==R_X86_64_RELATIVE){
					analysis	+= "=>R_X86_64_RELATIVE(8)"+"\n";
				}else if(r_type==R_X86_64_GOTPCREL){
					analysis	+= "=>R_X86_64_GOTPCREL(9)"+"\n";
				}else if(r_type==R_X86_64_32){
					analysis	+= "=>R_X86_64_32(10)"+"\n";
				}else if(r_type==R_X86_64_32S){
					analysis	+= "=>R_X86_64_32S(11)"+"\n";
				}else if(r_type==R_X86_64_16){
					analysis	+= "=>R_X86_64_16(12)"+"\n";
				}else if(r_type==R_X86_64_PC16){
					analysis	+= "=>R_X86_64_PC16(13)"+"\n";
				}else if(r_type==R_X86_64_8){
					analysis	+= "=>R_X86_64_8(14)"+"\n";
				}else if(r_type==R_X86_64_PC8){
					analysis	+= "=>R_X86_64_PC8(15)"+"\n";
				}else if(r_type==R_X86_64_NUM){
					analysis	+= "=>R_X86_64_NUM(16)"+"\n";
				}
				notes		= ELF_RELOCATION_ADDEND_TABLE_r_info_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord r_info	= null;
				if(rva!=0 && lma!=0){
					r_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					r_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					r_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> r_info_Item	= new TreeItem<>(r_info);
//				r_info_Item.setExpanded(true);
				ELF_RELOCATION_ADDEND_TABLE_Item.getChildren().add(r_info_Item);				
					
				//r_type取得
				rType	= r_type;
				
				
				//0x08	Elf64_Sxword	r_addend
				name	= "r_addend";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_SXWORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_RELOCATION_ADDEND_TABLE_r_addend_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord r_addend	= null;
				if(rva!=0 && lma!=0){
					r_addend	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					r_addend	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					r_addend	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}
				TreeItem<EPlusViewerTreeTableRecord> r_addend_Item	= new TreeItem<>(r_addend);
//				r_addend_Item.setExpanded(true);
				ELF_RELOCATION_ADDEND_TABLE_Item.getChildren().add(r_addend_Item);
				
				//r_offsetの参照先を作成	
				if(E_TYPE==ET_REL){	
					if(r_type!=R_X86_64_COPY){
						//セクションを特定
						int sectionHeaderIndex		= getStringToInt(sh.getSh_info_str(), false);
						SectionHeader sectionHeader	= sectionHeaderList.get(sectionHeaderIndex);
						
						address		= getAddStrAddrLong(sectionHeader.getSh_offset_str(), false, rOffset, false);
						raddress	= null;
						
						//参照先のアドレスデータを作成
						makeR_OffsetAddr(r_offset_Item, address, raddress, sectionHeaderIndex);
					}
				}else if(E_TYPE==ET_EXEC || E_TYPE==ET_DYN || E_TYPE==ET_CORE){
					if(r_type!=R_X86_64_COPY){
						address		= null;
						raddress	= rOffset;
						
						//セクションを特定
						Iterator<SectionHeader> sectionHeader_Iterator	= sectionHeaderList.iterator();
						SectionHeader sectionHeader						= null;
						int sectionHeaderIndex							= 0;
						long diffAddr									= 0;
								
						while(sectionHeader_Iterator.hasNext()){
							sectionHeader	= (SectionHeader)sectionHeader_Iterator.next();				
							if(sectionHeader.addrCheckLong(raddress, ELF64_ADDR_SIZE)){
								diffAddr	= sectionHeader.getSh_addr_long()-sectionHeader.getSh_offset_long();
								address		= String.format("%016X", getStringToLong(raddress, false)-diffAddr).toUpperCase();	
								break;
							}else {
								sectionHeader = null;
							}
							sectionHeaderIndex++;
						}
						
						if(address!=null && sectionHeader!=null){
							//参照先のアドレスデータを作成
							makeR_OffsetAddr(r_offset_Item, address, raddress, sectionHeaderIndex);
						}
					}
				}else{
					//何もしない
				}

				count++;
			}
		}
	}
	
	private void makeElfRelocationTable(TreeItem<EPlusViewerTreeTableRecord> item, SectionHeader sh){
				
		if(ELFCLASS==ELFCLASS32){	//32bit
			//開始アドレス取得
			int startAddr32	= sh.getSh_offset_int();
			
			//データ取得用
			int dataSize	= sh.getSh_size_int();
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			int rva			= 0;
			int lma			= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			int v			= 0;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;
			
			//カウント
			int count		= 0;
			
			//取得用
			String rOffset		= null;
			int rInfo			= 0;
			String address		= null;
			String raddress		= null;
			
			//アドレス設定
			rawAddr			= startAddr32;
			rva				= sh.getSh_addr_int();
			String strLma	= getVaddrToPaddr(String.format("%08X", rva).toUpperCase());
			if(strLma!=null){
				lma			= getStringToInt(strLma, false);
			}		
			
			for(int c=0; c<dataSize; c+=ELF32_REL_SIZE){			
				//ELF_RELOCATION_TABLE
				name		= "ELF_RELOCATION_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size		= ELF32_REL_SIZE;
				value		= "";
				analysis	= "";
				notes		= ELF_RELOCATION_TABLE_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_RELOCATION_TABLE	= null;
				if(rva!=0 && lma!=0){
					ELF_RELOCATION_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					ELF_RELOCATION_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					ELF_RELOCATION_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> ELF_RELOCATION_TABLE_Item 	= new TreeItem<>(ELF_RELOCATION_TABLE);
//				ELF_RELOCATION_TABLE_Item.setExpanded(true);
				item.getChildren().add(ELF_RELOCATION_TABLE_Item);
				
				
				//0x00	Elf32_Addr	r_offset
				name	= "r_offset";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF32_ADDR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_RELOCATION_TABLE_r_offset_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord r_offset	= null;
				if(rva!=0 && lma!=0){
					r_offset	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					r_offset	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					r_offset	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> r_offset_Item	= new TreeItem<>(r_offset);
//				r_offset_Item.setExpanded(true);
				ELF_RELOCATION_TABLE_Item.getChildren().add(r_offset_Item);
					
				//r_offset取得
				rOffset	= value;
				

				//0x04	Elf32_Word	r_info
				name	= "r_info";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				analysis	+= "sh_info=0x"+sh.getSh_info_str()+"\n";
				if(getStringToInt(sh.getSh_info_str(), false)!=0){
					analysis	+= "=>"+ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(getStringToInt(sh.getSh_info_str(), false)).getValue().getName()+"\n";
				}
				analysis	+= "sh_link=0x"+sh.getSh_link_str()+"\n";
				if(sh.getSh_link_int()!=0){
					analysis	+= "=>"+ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(sh.getSh_link_int()).getValue().getName()+"\n";					
				}
				analysis	+= "R_SYM=0x"+(v>>8)+"\n";
				if(sh.getSh_link_int()!=0 && (v>>8)>0){
					analysis	+= "=>"+ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(sh.getSh_link_int()).getChildren().get(10).getChildren().get((v>>8)).getValue().getName()+"\n";
				
					//シンボル名を設定
					int symindex	= ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(sh.getSh_link_int()).getChildren().get(10).getChildren().get((v>>8)).getValue().getName().indexOf(":");
					if(symindex!=-1){
						String symname	= ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(sh.getSh_link_int()).getChildren().get(10).getChildren().get((v>>8)).getValue().getName().substring(symindex);
						ELF_RELOCATION_TABLE.setName(ELF_RELOCATION_TABLE.getName()+symname);
					}
				}
				analysis	+= "R_TYPE=0x"+(v&0xff)+"\n";
				if((v&0xff)==R_386_NONE){
					analysis	+= "=>R_386_NONE(0)"+"\n";
				}else if((v&0xff)==R_386_32){
					analysis	+= "=>R_386_32(1)"+"\n";
				}else if((v&0xff)==R_386_PC32){
					analysis	+= "=>R_386_PC32(2)"+"\n";
				}else if((v&0xff)==R_386_GOT32){
					analysis	+= "=>R_386_GOT32(3)"+"\n";
				}else if((v&0xff)==R_386_PLT32){
					analysis	+= "=>R_386_PLT32(4)"+"\n";
				}else if((v&0xff)==R_386_COPY){
					analysis	+= "=>R_386_COPY(5)"+"\n";
				}else if((v&0xff)==R_386_GLOB_DAT){
					analysis	+= "=>R_386_GLOB_DAT(6)"+"\n";
				}else if((v&0xff)==R_386_JMP_SLOT){
					analysis	+= "=>R_386_JMP_SLOT(7)"+"\n";
				}else if((v&0xff)==R_386_RELATIVE){
					analysis	+= "=>R_386_RELATIVE(8)"+"\n";
				}else if((v&0xff)==R_386_GOTOFF){
					analysis	+= "=>R_386_GOTOFF(9)"+"\n";
				}else if((v&0xff)==R_386_GOTPC){
					analysis	+= "=>R_386_GOTPC(10)"+"\n";
				}else if((v&0xff)==R_386_NUM){
					analysis	+= "=>R_386_NUM(16)"+"\n";
				}
				notes		= ELF_RELOCATION_ADDEND_TABLE_r_info_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord r_info	= null;
				if(rva!=0 && lma!=0){
					r_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					r_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					r_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> r_info_Item	= new TreeItem<>(r_info);
//				r_info_Item.setExpanded(true);
				ELF_RELOCATION_TABLE_Item.getChildren().add(r_info_Item);
				
				//r_info取得
				rInfo	= v;
				
				
				//r_offsetの参照先を作成	
				if(E_TYPE==ET_REL){
					if((rInfo&0xff)!=R_386_COPY){
						//セクションを特定
						int sectionHeaderIndex		= getStringToInt(sh.getSh_info_str(), false);
						SectionHeader sectionHeader	= sectionHeaderList.get(sectionHeaderIndex);
						
						address		= getAddStrAddrInt(sectionHeader.getSh_offset_str(), false, rOffset, false);
						raddress	= null;
						
						//参照先のアドレスデータを作成
						makeR_OffsetAddr(r_offset_Item, address, raddress, sectionHeaderIndex);
					}
				}else if(E_TYPE==ET_EXEC || E_TYPE==ET_DYN || E_TYPE==ET_CORE){
					if((rInfo&0xff)!=R_386_COPY){
						address		= null;
						raddress	= rOffset;
						
						//セクションを特定
						Iterator<SectionHeader> sectionHeader_Iterator	= sectionHeaderList.iterator();
						SectionHeader sectionHeader						= null;
						int sectionHeaderIndex							= 0;
						long diffAddr									= 0;
						long address_long								= 0;
								
						while(sectionHeader_Iterator.hasNext()){
							sectionHeader	= (SectionHeader)sectionHeader_Iterator.next();				
							if(sectionHeader.addrCheckInt(raddress, ELF32_ADDR_SIZE)){
								diffAddr		= Integer.toUnsignedLong(sectionHeader.getSh_addr_int())-Integer.toUnsignedLong(sectionHeader.getSh_offset_int());
								address_long	= Integer.toUnsignedLong(getStringToInt(raddress, false))-diffAddr;
								address			= String.format("%08X", (int)address_long).toUpperCase();	
								break;
							}else {
								sectionHeader = null;
							}
							sectionHeaderIndex++;
						}
						
						if(address!=null && sectionHeader!=null){
							//参照先のアドレスデータを作成
							makeR_OffsetAddr(r_offset_Item, address, raddress, sectionHeaderIndex);
						}					
					}
				}else{
					//何もしない
				}
				
				count++;
			}
		}else if(ELFCLASS==ELFCLASS64){	//64bit
			//開始アドレス取得
			long startAddr64	= sh.getSh_offset_long();
			int startAddr32		= (int)startAddr64;

			//データ取得用
			int dataSize	= (int)sh.getSh_size_long();
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			long rva		= 0;
			long lma		= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			long vl			= 0;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;
			
			//カウント
			int count		= 0;
			
			//取得用
			String rOffset	= null;
			int rType		= 0;
			String address	= null;
			String raddress	= null;
			
			//アドレス設定
			rawAddr			= startAddr32;
			rva				= sh.getSh_addr_long();
			String strLma	= getVaddrToPaddr(String.format("%016X", rva).toUpperCase());
			if(strLma!=null){
				lma			= getStringToLong(strLma, false);
			}
			
			for(int c=0; c<dataSize; c+=ELF64_REL_SIZE){			
				//ELF_RELOCATION_TABLE
				name		= "ELF_RELOCATION_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size		= ELF64_REL_SIZE;
				value		= "";
				analysis	= "";
				notes		= ELF_RELOCATION_TABLE_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_RELOCATION_TABLE	= null;
				if(rva!=0 && lma!=0){
					ELF_RELOCATION_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					ELF_RELOCATION_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					ELF_RELOCATION_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> ELF_RELOCATION_TABLE_Item 	= new TreeItem<>(ELF_RELOCATION_TABLE);
//				ELF_RELOCATION_TABLE_Item.setExpanded(true);
				item.getChildren().add(ELF_RELOCATION_TABLE_Item);
				
				
				//0x00	Elf64_Addr	r_offset
				name	= "r_offset";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_ADDR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_RELOCATION_TABLE_r_offset_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord r_offset	= null;
				if(rva!=0 && lma!=0){
					r_offset	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					r_offset	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					r_offset	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> r_offset_Item	= new TreeItem<>(r_offset);
//				r_offset_Item.setExpanded(true);
				ELF_RELOCATION_TABLE_Item.getChildren().add(r_offset_Item);
			
				//r_offset取得
				rOffset	= value;
				
			
				//0x04	Elf64_Xword	r_info
				name	= "r_info";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_XWORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				vl			= getStringToLong(value, false);
				int r_type	= (int)(vl&0xffffffff);
				analysis	+= "sh_info=0x"+sh.getSh_info_str()+"\n";
				if(getStringToInt(sh.getSh_info_str(), false)!=0){
					analysis	+= "=>"+ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(getStringToInt(sh.getSh_info_str(), false)).getValue().getName()+"\n";
				}
				analysis	+= "sh_link=0x"+sh.getSh_link_str()+"\n";
				if(sh.getSh_link_int()!=0){
					analysis	+= "=>"+ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(sh.getSh_link_int()).getValue().getName()+"\n";
				}
				analysis	+= "R_SYM=0x"+(vl>>32)+"\n";
				if(sh.getSh_link_int()!=0 && (vl>>32)>0){
					analysis	+= "=>"+ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(sh.getSh_link_int()).getChildren().get(10).getChildren().get((int)(vl>>32)).getValue().getName()+"\n";
				
					//シンボル名を設定
					int symindex	= ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(sh.getSh_link_int()).getChildren().get(10).getChildren().get((int)(vl>>32)).getValue().getName().indexOf(":");
					if(symindex!=-1){
						String symname	= ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(sh.getSh_link_int()).getChildren().get(10).getChildren().get((int)(vl>>32)).getValue().getName().substring(symindex);
						ELF_RELOCATION_TABLE.setName(ELF_RELOCATION_TABLE.getName()+symname);
					}
				}
				analysis	+= "R_TYPE=0x"+r_type+"\n";
				if(r_type==R_X86_64_NONE){
					analysis	+= "=>R_X86_64_NONE(0)"+"\n";
				}else if(r_type==R_X86_64_64){
					analysis	+= "=>R_X86_64_64(1)"+"\n";
				}else if(r_type==R_X86_64_PC32){
					analysis	+= "=>R_X86_64_PC32(2)"+"\n";
				}else if(r_type==R_X86_64_GOT32){
					analysis	+= "=>R_X86_64_GOT32(3)"+"\n";
				}else if(r_type==R_X86_64_PLT32){
					analysis	+= "=>R_X86_64_PLT32(4)"+"\n";
				}else if(r_type==R_X86_64_COPY){
					analysis	+= "=>R_X86_64_COPY(5)"+"\n";
				}else if(r_type==R_X86_64_GLOB_DAT){
					analysis	+= "=>R_X86_64_GLOB_DAT(6)"+"\n";
				}else if(r_type==R_X86_64_JUMP_SLOT){
					analysis	+= "=>R_X86_64_JUMP_SLOT(7)"+"\n";
				}else if(r_type==R_X86_64_RELATIVE){
					analysis	+= "=>R_X86_64_RELATIVE(8)"+"\n";
				}else if(r_type==R_X86_64_GOTPCREL){
					analysis	+= "=>R_X86_64_GOTPCREL(9)"+"\n";
				}else if(r_type==R_X86_64_32){
					analysis	+= "=>R_X86_64_32(10)"+"\n";
				}else if(r_type==R_X86_64_32S){
					analysis	+= "=>R_X86_64_32S(11)"+"\n";
				}else if(r_type==R_X86_64_16){
					analysis	+= "=>R_X86_64_16(12)"+"\n";
				}else if(r_type==R_X86_64_PC16){
					analysis	+= "=>R_X86_64_PC16(13)"+"\n";
				}else if(r_type==R_X86_64_8){
					analysis	+= "=>R_X86_64_8(14)"+"\n";
				}else if(r_type==R_X86_64_PC8){
					analysis	+= "=>R_X86_64_PC8(15)"+"\n";
				}else if(r_type==R_X86_64_NUM){
					analysis	+= "=>R_X86_64_NUM(16)"+"\n";
				}
				notes		= ELF_RELOCATION_ADDEND_TABLE_r_info_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord r_info	= null;
				if(rva!=0 && lma!=0){
					r_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					r_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					r_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> r_info_Item	= new TreeItem<>(r_info);
//				r_info_Item.setExpanded(true);
				ELF_RELOCATION_TABLE_Item.getChildren().add(r_info_Item);
			
				//r_type取得
				rType	= r_type;
				
			
				//r_offsetの参照先を作成	
				if(E_TYPE==ET_REL){	
					if(rType!=R_X86_64_COPY){
						//セクションを特定
						int sectionHeaderIndex		= getStringToInt(sh.getSh_info_str(), false);
						SectionHeader sectionHeader	= sectionHeaderList.get(sectionHeaderIndex);
						
						address		= getAddStrAddrLong(sectionHeader.getSh_offset_str(), false, rOffset, false);
						raddress	= null;
						
						//参照先のアドレスデータを作成
						makeR_OffsetAddr(r_offset_Item, address, raddress, sectionHeaderIndex);
					}
				}else if(E_TYPE==ET_EXEC || E_TYPE==ET_DYN || E_TYPE==ET_CORE){
					if(rType!=R_X86_64_COPY){
						address		= null;
						raddress	= rOffset;
						
						//セクションを特定
						Iterator<SectionHeader> sectionHeader_Iterator	= sectionHeaderList.iterator();
						SectionHeader sectionHeader						= null;
						int sectionHeaderIndex							= 0;
						long diffAddr									= 0;
								
						while(sectionHeader_Iterator.hasNext()){
							sectionHeader	= (SectionHeader)sectionHeader_Iterator.next();				
							if(sectionHeader.addrCheckLong(raddress, ELF64_ADDR_SIZE)){
								diffAddr	= sectionHeader.getSh_addr_long()-sectionHeader.getSh_offset_long();
								address		= String.format("%016X", getStringToLong(raddress, false)-diffAddr).toUpperCase();	
								break;
							}else {
								sectionHeader = null;
							}
							sectionHeaderIndex++;
						}
						
						if(address!=null && sectionHeader!=null){
							//参照先のアドレスデータを作成
							makeR_OffsetAddr(r_offset_Item, address, raddress, sectionHeaderIndex);
						}
					}
				}else{
					//何もしない
				}
				
				count++;
			}
		}
	}
	
	private void makeElfDynamicSymbolTable(TreeItem<EPlusViewerTreeTableRecord> item, SectionHeader sh){
				
		if(ELFCLASS==ELFCLASS32){	//32bit
			//開始アドレス取得
			int startAddr32	= sh.getSh_offset_int();
			
			//データ取得用
			int dataSize	= sh.getSh_size_int();
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			int rva			= 0;
			int lma			= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			int v			= 0;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;
			
			//カウント
			int count		= 0;
			
			//取得用
			String stValue	= "";
			String stSize	= "";
			int sttBind		= 0;
			int sttType		= 0;
			int stShndx		= 0;
			
			//アドレス設定
			rawAddr			= startAddr32;
			rva				= sh.getSh_addr_int();
			String strLma	= getVaddrToPaddr(String.format("%08X", rva).toUpperCase());
			if(strLma!=null){
				lma			= getStringToInt(strLma, false);
			}
					
			for(int c=0; c<dataSize; c+=ELF32_SYM_SIZE){				
				//ELF_DYNAMIC_SYMBOL_TABLE
				name		= "ELF_DYNAMIC_SYMBOL_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size		= ELF32_SYM_SIZE;
				value		= "";
				analysis	= "";
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_DYNAMIC_SYMBOL_TABLE	= null;
				if(rva!=0 && lma!=0){
					ELF_DYNAMIC_SYMBOL_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					ELF_DYNAMIC_SYMBOL_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					ELF_DYNAMIC_SYMBOL_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> ELF_DYNAMIC_SYMBOL_TABLE_Item 	= new TreeItem<>(ELF_DYNAMIC_SYMBOL_TABLE);
//				ELF_DYNAMIC_SYMBOL_TABLE_Item.setExpanded(true);
				item.getChildren().add(ELF_DYNAMIC_SYMBOL_TABLE_Item);
				
				
				//0x00	Elf32_Word	st_name
				name	= "st_name";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_st_name_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_name	= null;
				if(rva!=0 && lma!=0){
					st_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> st_name_Item	= new TreeItem<>(st_name);
//				st_name_Item.setExpanded(true);
				ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().add(st_name_Item);

				
				//0x04	Elf32_Addr	st_value
				name	= "st_value";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF32_ADDR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_st_value_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_value	= null;
				if(rva!=0 && lma!=0){
					st_value	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_value	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_value	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);			
				}
				TreeItem<EPlusViewerTreeTableRecord> st_value_Item	= new TreeItem<>(st_value);
//				st_value_Item.setExpanded(true);
				ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().add(st_value_Item);
				
				//st_value取得
				stValue	= value;
				
				
				//0x08	Elf32_Word	st_size
				name	= "st_size";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				analysis	= String.valueOf(v)+" bytes";
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_st_size_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_size	= null;
				if(rva!=0 && lma!=0){
					st_size	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_size	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_size	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}
				TreeItem<EPlusViewerTreeTableRecord> st_size_Item	= new TreeItem<>(st_size);
//				st_size_Item.setExpanded(true);
				ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().add(st_size_Item);					
				
				//st_size取得
				stSize	= value;
				
				
				//0x0c	unsigned char	st_info
				name	= "st_info";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= UNSIGNED_CHAR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				byte vb		= data[offset+size-1];						
				//上位4bit
				if((vb>>4)==0){
					analysis	+= "STB_LOCAL(0x0)"+"\n";
				}else if((vb>>4)==STB_GLOBAL){
					analysis	+= "STB_GLOBAL(0x1)"+"\n";
				}else if((vb>>4)==STB_WEAK){
					analysis	+= "STB_WEAK(0x2)"+"\n";
				}	
				//下位4bit
				if((vb&0xf)==0){
					analysis	+= "STT_NOTYPE(0x0)"+"\n";
				}else if((vb&0xf)==STT_OBJECT){
					analysis	+= "STT_OBJECT(0x1)"+"\n";
				}else if((vb&0xf)==STT_FUNC){
					analysis	+= "STT_FUNC(0x2)"+"\n";
				}else if((vb&0xf)==STT_SECTION){
					analysis	+= "STT_SECTION(0x3)"+"\n";
				}else if((vb&0xf)==STT_FILE){
					analysis	+= "STT_FILE(0x4)"+"\n";
				}else if((vb&0xf)==STT_COMMON){
					analysis	+= "STT_COMMON(0x5)"+"\n";
				}else if((vb&0xf)==STT_TLS){
					analysis	+= "STT_TLS(0x6)"+"\n";
				}
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_st_info_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_info	= null;
				if(rva!=0 && lma!=0){
					st_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}
				TreeItem<EPlusViewerTreeTableRecord> st_info_Item	= new TreeItem<>(st_info);
//				st_info_Item.setExpanded(true);
				ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().add(st_info_Item);
				
				//stt_bindとstt_type取得
				sttBind	= vb>>4;
				sttType	= vb&0xf;
				
				
				//0x0d	unsigned char	st_other
				name	= "st_other";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= UNSIGNED_CHAR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_st_other_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_other	= null;
				if(rva!=0 && lma!=0){
					st_other	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_other	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_other	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> st_other_Item	= new TreeItem<>(st_other);
//				st_other_Item.setExpanded(true);
				ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().add(st_other_Item);
			
				
				//0x0e	Elf32_Half	st_shndx
				name	= "st_shndx";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF32_HALF_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				v			= v&0xffff;
				if(v==0){
					analysis	+= "SHN_UNDEF(0x0)";
				}else if(v==SHN_LORESERVE || v==SHN_LOPROC || v==SHN_BEFORE){
					analysis	+= "SHN_LORESERVE(0xff00),SHN_LOPROC(0xff00),SHN_BEFORE(0xff00)";
				}else if(v==SHN_AFTER){
					analysis	+= "SHN_AFTER(0xff01)";			
				}else if(v==SHN_HIPROC){
					analysis	+= "SHN_HIPROC(0xff1f)";
				}else if(v==SHN_ABS){
					analysis	+= "SHN_ABS(0xfff1)";
				}else if(v==SHN_COMMON){
					analysis	+= "SHN_COMMON(0xfff2)";
				}else if(v==SHN_HIRESERVE){
					analysis	+= "SHN_HIRESERVE(0xffff)";
				}else if(v>0 && v<ELF_SHDR_NUM){
					analysis	+= ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(v).getValue().getName();
				}
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_st_shndx_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_shndx	= null;
				if(rva!=0 && lma!=0){
					st_shndx	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){	
					st_shndx	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_shndx	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> st_shndx_Item	= new TreeItem<>(st_shndx);
//				st_shndx_Item.setExpanded(true);
				ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().add(st_shndx_Item);
				
				//st_shndx取得
				stShndx	= v;

				//st_valueの参照先を作成
				if(E_TYPE==ET_REL){			
					if(sttType==STT_OBJECT || sttType==STT_FUNC){
						if(getStringToInt(stSize, false)>0 && stShndx>0 && stShndx<ELF_SHDR_NUM){
							SectionHeader section	= sectionHeaderList.get(stShndx);
							String address			= getAddStrAddrInt(section.getSh_offset_str(), false, stValue, false);
							long addr1	= Integer.toUnsignedLong(getStringToInt(address, false))+Integer.toUnsignedLong(getStringToInt(stSize, false));
							long addr2	= Integer.toUnsignedLong(section.getSh_offset_int())+Integer.toUnsignedLong(section.getSh_size_int());
							if(addr1>addr2){
								address		= stValue;
							}
							String vaddress			= null;
							if(section.getSh_addr_int()!=0){
								vaddress	= section.getSh_addr_str();
							}			
							if(sttType==STT_OBJECT && section.getSh_type_int()!=SHT_NOBITS){								
								//Data作成
								makeData(st_value_Item, address, vaddress, stSize, true);
							}else if(sttType==STT_FUNC){
								//Data作成
								makeData(st_value_Item, address, vaddress, stSize, false);
							}
						}
					}
				}else if(E_TYPE==ET_DYN){
					if(sttType==STT_OBJECT || sttType==STT_FUNC){
						if(getStringToInt(stSize, false)>0 && stShndx>0 && stShndx<ELF_SHDR_NUM){
							SectionHeader section	= sectionHeaderList.get(stShndx);
							String vaddress	= stValue;
							String address	= getVaddrToFileoffset(stValue, false);
							if(address!=null){
								if(sttType==STT_OBJECT && section.getSh_type_int()!=SHT_NOBITS){								
									//Data作成
									makeData(st_value_Item, address, vaddress, stSize, true);
								}else if(sttType==STT_FUNC){
									//Data作成
									makeData(st_value_Item, address, vaddress, stSize, false);
								}
							}
						}
					}	
				}else if(E_TYPE==ET_EXEC || E_TYPE==ET_CORE){
					if(sttType==STT_OBJECT || sttType==STT_FUNC){
						if(getStringToInt(stSize, false)>0 && stShndx>0 && stShndx<ELF_SHDR_NUM){
							SectionHeader section	= sectionHeaderList.get(stShndx);
							String address			= null;
							String vaddress			= stValue;
							if(sttType==STT_OBJECT && section.getSh_type_int()!=SHT_NOBITS){
								//Data作成
								makeData(st_value_Item, address, vaddress, stSize, true);
							}else if(sttType==STT_FUNC){
								//Data作成
								makeData(st_value_Item, address, vaddress, stSize, false);
							}
						}
					}
				}else{
					//なにもしない
				}
				
				count++;
			}
						
			//セクション名文字列テーブルを取得
			SectionHeader ELF_DYNAMIC_SYMBOL_TABLE_sh	= sectionHeaderList.get(sh.getSh_link_int());
			
			//ストリングテーブルのデータ開始アドレスとサイズを取得
			startAddr32	= ELF_DYNAMIC_SYMBOL_TABLE_sh.getSh_offset_int();
			dataSize	= ELF_DYNAMIC_SYMBOL_TABLE_sh.getSh_size_int();
			data		= getBintableBytes(startAddr32, dataSize);

			//ELF_DYNAMIC_SYMBOL_TABLE取得
			ObservableList<TreeItem<EPlusViewerTreeTableRecord>> ELF_SECTION_DATA_Item_List 	= item.getChildren();
			Iterator<TreeItem<EPlusViewerTreeTableRecord>> ELF_SECTION_DATA_Item_Iterator		= ELF_SECTION_DATA_Item_List.iterator();
			
			TreeItem<EPlusViewerTreeTableRecord> ELF_DYNAMIC_SYMBOL_TABLE_Item	= null;
			EPlusViewerTreeTableRecord ELF_DYNAMIC_SYMBOL_TABLE					= null;
			TreeItem<EPlusViewerTreeTableRecord> st_name_Item					= null;
			EPlusViewerTreeTableRecord st_name									= null;	
			
			while(ELF_SECTION_DATA_Item_Iterator.hasNext()){
				
				ELF_DYNAMIC_SYMBOL_TABLE_Item	= (TreeItem<EPlusViewerTreeTableRecord>)ELF_SECTION_DATA_Item_Iterator.next();
				ELF_DYNAMIC_SYMBOL_TABLE		= ELF_DYNAMIC_SYMBOL_TABLE_Item.getValue();
				st_name_Item					= ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().get(0);
				st_name							= st_name_Item.getValue();
								
				//0x00	Variable	name;	
				name			= "name";
				int index		= getStringToInt(st_name.getValue(), false);
				rawAddr			= startAddr32+index;	
				raw				= rawAddr;	
				offset			= index;
				if(ELF_DYNAMIC_SYMBOL_TABLE_sh.getSh_addr_int()!=0){
					rva			= ELF_DYNAMIC_SYMBOL_TABLE_sh.getSh_addr_int()+index;
				}else{
					rva			= 0;
				}
				strLma	= getVaddrToPaddr(String.format("%08X", rva).toUpperCase());
				if(strLma!=null){
					lma			= getStringToInt(strLma, false);
				}else {
					lma			= 0;
				}
				size			= 0;
				int dataCount	= 0;
				value			= "";
				analysis		= "";
				notes			= ELF_DYNAMIC_STRING_TABLE_NAME_Notes;
			
				while(data[index]!=0 && index<dataSize){
					value		+= String.format("%02X", data[index]).toUpperCase();
					analysis	+= String.format("%c", data[index]);
					dataCount++;
					index++;
				}
				
				if(dataCount!=0){
					//サイズ更新
					size		= dataCount;
					
					EPlusViewerTreeTableRecord Name		= null;
					if(rva!=0 && lma!=0){
						Name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else if(rva!=0){
						Name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else{
						Name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> Name_Item	= new TreeItem<>(Name);
//					Name_Item.setExpanded(true);
					st_name_Item.getChildren().add(Name_Item);
				
					//ELF_DYNAMIC_SYMBOL_TABLEにname追加
					ELF_DYNAMIC_SYMBOL_TABLE.setName(ELF_DYNAMIC_SYMBOL_TABLE.getName()+":"+analysis);
				
				}
			}
		}else if(ELFCLASS==ELFCLASS64){	//64bit
			//開始アドレス取得
			long startAddr64	= sh.getSh_offset_long();
			int startAddr32		= (int)startAddr64;
	
			//データ取得用
			int dataSize	= (int)sh.getSh_size_long();
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			long rva		= 0;
			long lma		= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			int v			= 0;
			long vl			= 0;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;
			
			//カウント
			int count		= 0;
			
			//取得用
			String stValue	= "";
			String stSize	= "";
			int sttBind		= 0;
			int sttType		= 0;
			int stShndx		= 0;
			
			//アドレス設定
			rawAddr			= startAddr32;
			rva				= sh.getSh_addr_long();
			String strLma	= getVaddrToPaddr(String.format("%016X", rva).toUpperCase());
			if(strLma!=null){
				lma			= getStringToLong(strLma, false);
			}
			
			for(int c=0; c<dataSize; c+=ELF64_SYM_SIZE){
				
				//ELF_DYNAMIC_SYMBOL_TABLE
				name		= "ELF_DYNAMIC_SYMBOL_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size		= ELF64_SYM_SIZE;
				value		= "";
				analysis	= "";
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_DYNAMIC_SYMBOL_TABLE	= null;
				if(rva!=0 && lma!=0){
					ELF_DYNAMIC_SYMBOL_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					ELF_DYNAMIC_SYMBOL_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					ELF_DYNAMIC_SYMBOL_TABLE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> ELF_DYNAMIC_SYMBOL_TABLE_Item 	= new TreeItem<>(ELF_DYNAMIC_SYMBOL_TABLE);
//				ELF_DYNAMIC_SYMBOL_TABLE_Item.setExpanded(true);
				item.getChildren().add(ELF_DYNAMIC_SYMBOL_TABLE_Item);
				
				
				//0x00	Elf64_Word	st_name
				name	= "st_name";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_st_name_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_name	= null;
				if(rva!=0 && lma!=0){
					st_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}
				TreeItem<EPlusViewerTreeTableRecord> st_name_Item	= new TreeItem<>(st_name);
//				st_name_Item.setExpanded(true);
				ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().add(st_name_Item);

				
				//0x04	unsigned char	st_info
				name	= "st_info";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= UNSIGNED_CHAR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				byte vb		= data[offset+size-1];	
				//上位4bit
				if((vb>>4)==0){
					analysis	+= "STB_LOCAL(0x0)"+"\n";
				}else if((vb>>4)==STB_GLOBAL){
					analysis	+= "STB_GLOBAL(0x1)"+"\n";
				}else if((vb>>4)==STB_WEAK){
					analysis	+= "STB_WEAK(0x2)"+"\n";
				}			
				//下位4bit
				if((vb&0xf)==0){
					analysis	+= "STT_NOTYPE(0x0)"+"\n";
				}else if((vb&0xf)==STT_OBJECT){
					analysis	+= "STT_OBJECT(0x1)"+"\n";
				}else if((vb&0xf)==STT_FUNC){
					analysis	+= "STT_FUNC(0x2)"+"\n";
				}else if((vb&0xf)==STT_SECTION){
					analysis	+= "STT_SECTION(0x3)"+"\n";
				}else if((vb&0xf)==STT_FILE){
					analysis	+= "STT_FILE(0x4)"+"\n";
				}else if((vb&0xf)==STT_COMMON){
					analysis	+= "STT_COMMON(0x5)"+"\n";
				}else if((vb&0xf)==STT_TLS){
					analysis	+= "STT_TLS(0x6)"+"\n";
				}					
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_st_info_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_info	= null;
				if(rva!=0 && lma!=0){
					st_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_info	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> st_info_Item	= new TreeItem<>(st_info);
//				st_info_Item.setExpanded(true);
				ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().add(st_info_Item);
				
				//stt_bindとstt_type取得
				sttBind	= vb>>4;
				sttType	= vb&0xf;
				
				
				//0x05	unsigned char	st_other
				name	= "st_other";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= UNSIGNED_CHAR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_st_other_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_other	= null;
				if(rva!=0 && lma!=0){
					st_other	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_other	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_other	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> st_other_Item	= new TreeItem<>(st_other);
//				st_other_Item.setExpanded(true);
				ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().add(st_other_Item);
			
				
				//0x06	Elf64_Half	st_shndx
				name	= "st_shndx";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_HALF_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				v			= v&0xffff;
				if(v==0){
					analysis	+= "SHN_UNDEF(0x0)";
				}else if(v==SHN_LORESERVE || v==SHN_LOPROC || v==SHN_BEFORE){
					analysis	+= "SHN_LORESERVE(0xff00),SHN_LOPROC(0xff00),SHN_BEFORE(0xff00)";
				}else if(v==SHN_AFTER){
					analysis	+= "SHN_AFTER(0xff01)";			
				}else if(v==SHN_HIPROC){
					analysis	+= "SHN_HIPROC(0xff1f)";
				}else if(v==SHN_ABS){
					analysis	+= "SHN_ABS(0xfff1)";
				}else if(v==SHN_COMMON){
					analysis	+= "SHN_COMMON(0xfff2)";
				}else if(v==SHN_HIRESERVE){
					analysis	+= "SHN_HIRESERVE(0xffff)";
				}else if(v>0 && v<ELF_SHDR_NUM){
					analysis	+= ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(v).getValue().getName();
				}
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_st_shndx_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_shndx	= null;
				if(rva!=0 && lma!=0){
					st_shndx	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_shndx	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_shndx	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> st_shndx_Item	= new TreeItem<>(st_shndx);
//				st_shndx_Item.setExpanded(true);
				ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().add(st_shndx_Item);

				//st_shndx取得
				stShndx	= v;
				
				
				//0x08	Elf64_Addr	st_value
				name	= "st_value";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_ADDR_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_st_value_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_value	= null;
				if(rva!=0 && lma!=0){
					st_value	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_value	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_value	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> st_value_Item	= new TreeItem<>(st_value);
//				st_value_Item.setExpanded(true);
				ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().add(st_value_Item);
				
				//st_value取得
				stValue	= value;
				
				
				//0x10	Elf64_Xword	st_size
				name	= "st_size";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_XWORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				vl			= getStringToLong(value, false);
				analysis	= String.valueOf(vl)+" bytes";
				notes		= ELF_DYNAMIC_SYMBOL_TABLE_st_size_Notes;
				beforesize	= size;
				
				EPlusViewerTreeTableRecord st_size	= null;
				if(rva!=0 && lma!=0){
					st_size	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					st_size	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					st_size	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> st_size_Item	= new TreeItem<>(st_size);
//				st_size_Item.setExpanded(true);
				ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().add(st_size_Item);					
						
				//st_size取得
				stSize	= value;
				
				
				//st_valueの参照先を作成
				if(E_TYPE==ET_REL){			
					if(sttType==STT_OBJECT || sttType==STT_FUNC){
						if(getStringToLong(stSize, false)>0 && stShndx>0 && stShndx<ELF_SHDR_NUM){
							SectionHeader section	= sectionHeaderList.get(stShndx);
							String address			= getAddStrAddrLong(section.getSh_offset_str(), false, stValue, false);
							if(getStringToLong(address, false)+getStringToLong(stSize, false)> section.getSh_offset_long()+section.getSh_size_long()){
								address		= stValue;
							}
							String vaddress			= null;
							if(section.getSh_addr_long()!=0){
								vaddress	= section.getSh_addr_str();
							}	
							if(sttType==STT_OBJECT && section.getSh_type_int()!=SHT_NOBITS){
								//Data作成
								makeData(st_value_Item, address, vaddress, stSize, true);
							}else if(sttType==STT_FUNC){
								//Data作成
								makeData(st_value_Item, address, vaddress, stSize, false);
							}
						}
					}
				}else if(E_TYPE==ET_DYN){
					if(getStringToLong(stSize, false)>0 && stShndx>0 && stShndx<ELF_SHDR_NUM){
						SectionHeader section	= sectionHeaderList.get(stShndx);
						String vaddress			= stValue;
						String address			= getVaddrToFileoffset(stValue, false);
						if(address!=null){
							if(sttType==STT_OBJECT && section.getSh_type_int()!=SHT_NOBITS){
								//Data作成
								makeData(st_value_Item, address, vaddress, stSize, true);
							}else if(sttType==STT_FUNC){
								//Data作成
								makeData(st_value_Item, address, vaddress, stSize, false);
							}
						}
					}
				}else if(E_TYPE==ET_EXEC || E_TYPE==ET_CORE){
					if(sttType==STT_OBJECT || sttType==STT_FUNC){
						if(getStringToLong(stSize, false)>0 && stShndx>0 && stShndx<ELF_SHDR_NUM){
							SectionHeader section	= sectionHeaderList.get(stShndx);
							String address			= null;
							String vaddress			= stValue;
							if(sttType==STT_OBJECT && section.getSh_type_int()!=SHT_NOBITS){
								//Data作成
								makeData(st_value_Item, address, vaddress, stSize, true);
							}else if(sttType==STT_FUNC){
								//Data作成
								makeData(st_value_Item, address, vaddress, stSize, false);
							}
						}
					}
				}else{
					//なにもしない
				}
				
				count++;
			}
						
			//セクション名文字列テーブルを取得
			SectionHeader ELF_DYNAMIC_SYMBOL_TABLE_sh	= sectionHeaderList.get(sh.getSh_link_int());
			
			//ストリングテーブルのデータ開始アドレスとサイズを取得
			startAddr64	= ELF_DYNAMIC_SYMBOL_TABLE_sh.getSh_offset_long();
			startAddr32	= (int)startAddr64;
			dataSize	= (int)ELF_DYNAMIC_SYMBOL_TABLE_sh.getSh_size_long();
			data		= getBintableBytes(startAddr32, dataSize);

			//ELF_DYNAMIC_SYMBOL_TABLE取得
			ObservableList<TreeItem<EPlusViewerTreeTableRecord>> ELF_SECTION_DATA_Item_List		= item.getChildren();
			Iterator<TreeItem<EPlusViewerTreeTableRecord>> ELF_SECTION_DATA_Item_Iterator		= ELF_SECTION_DATA_Item_List.iterator();
			
			TreeItem<EPlusViewerTreeTableRecord> ELF_DYNAMIC_SYMBOL_TABLE_Item	= null;
			EPlusViewerTreeTableRecord ELF_DYNAMIC_SYMBOL_TABLE					= null;
			TreeItem<EPlusViewerTreeTableRecord> st_name_Item					= null;
			EPlusViewerTreeTableRecord st_name									= null;	
			
			while(ELF_SECTION_DATA_Item_Iterator.hasNext()){
				
				ELF_DYNAMIC_SYMBOL_TABLE_Item	= (TreeItem<EPlusViewerTreeTableRecord>)ELF_SECTION_DATA_Item_Iterator.next();
				ELF_DYNAMIC_SYMBOL_TABLE		= ELF_DYNAMIC_SYMBOL_TABLE_Item.getValue();
				st_name_Item					= ELF_DYNAMIC_SYMBOL_TABLE_Item.getChildren().get(0);
				st_name							= st_name_Item.getValue();
								
				//0x00	Variable	name;	
				name			= "name";
				int index		= getStringToInt(st_name.getValue(), false);
				rawAddr			= startAddr32+index;	
				raw				= rawAddr;	
				offset			= index;
				if(ELF_DYNAMIC_SYMBOL_TABLE_sh.getSh_addr_long()!=0){
					rva			= ELF_DYNAMIC_SYMBOL_TABLE_sh.getSh_addr_long()+index;
				}else{
					rva			= 0;
				}	
				strLma	= getVaddrToPaddr(String.format("%016X", rva).toUpperCase());
				if(strLma!=null){
					lma			= getStringToLong(strLma, false);
				}else {
					lma			= 0;
				}
				size			= 0;
				int dataCount	= 0;
				value			= "";
				analysis		= "";
				notes			= ELF_DYNAMIC_STRING_TABLE_NAME_Notes;
			
				while(data[index]!=0 && index<dataSize){
					value		+= String.format("%02X", data[index]).toUpperCase();
					analysis	+= String.format("%c", data[index]);
					dataCount++;
					index++;
				}
				
				if(dataCount!=0){
					//サイズ更新
					size		= dataCount;
					
					EPlusViewerTreeTableRecord Name	= null;
					if(rva!=0 && lma!=0){
						Name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else if(rva!=0){
						Name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else{
						Name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);	
					}
					TreeItem<EPlusViewerTreeTableRecord> Name_Item	= new TreeItem<>(Name);
//					Name_Item.setExpanded(true);
					st_name_Item.getChildren().add(Name_Item);
				
					//ELF_DYNAMIC_SYMBOL_TABLEにname追加
					ELF_DYNAMIC_SYMBOL_TABLE.setName(ELF_DYNAMIC_SYMBOL_TABLE.getName()+":"+analysis);
				}
			}
		}
	}

	private void makeR_OffsetAddr(TreeItem<EPlusViewerTreeTableRecord> item, String strAddr, String strVaddr, int sectionHeaderIndex){
		
		if(ELFCLASS==ELFCLASS32){	//32bit			
			//開始アドレス取得
			int startAddr32	= getStringToInt(strAddr, false);
			
			//データ取得用
			int dataSize	= ELF32_ADDR_SIZE;
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
			
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			int rva			= 0;
			int lma			= 0;
			int offset		= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			String strLma	= null;
			
			//0x00	Elf32_Addr	addr
			name	= "addr";
			rawAddr	= startAddr32;
			raw		= rawAddr;
			offset	= 0x0;
			if(strVaddr!=null){
				rva	= getStringToInt(strVaddr, false);
			}else{
				rva	= 0;
			}
			strLma	= getVaddrToPaddr(String.format("%08X", rva).toUpperCase());
			if(strLma!=null){
				lma	= getStringToInt(strLma, false);
			}
			size	= ELF32_ADDR_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			analysis	+= ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(sectionHeaderIndex).getValue().getName();
			notes		= R_offset_Addr_Notes;
			
			EPlusViewerTreeTableRecord addr	= null;
			if(rva!=0 && lma!=0){
				addr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}else if(rva!=0){
				addr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			}else{
				addr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			}
			TreeItem<EPlusViewerTreeTableRecord> addr_Item	= new TreeItem<>(addr);
//			addr_Item.setExpanded(true);
			item.getChildren().add(addr_Item);
			
		}else if(ELFCLASS==ELFCLASS64){	//64bit
			//開始アドレス取得
			long startAddr64	= getStringToLong(strAddr, false);
			int startAddr32		= (int)startAddr64;
			
			//データ取得用
			int dataSize	= ELF64_ADDR_SIZE;
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
			
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			long rva		= 0;
			long lma		= 0;
			int offset		= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			String strLma	= null;
			
			
			//0x00	Elf64_Addr	addr
			name	= "addr";
			rawAddr	= startAddr32;
			raw		= rawAddr;
			offset	= 0x0;
			if(strVaddr!=null){
				rva	= getStringToLong(strVaddr, false);
			}else{
				rva	= 0;
			}
			strLma	= getVaddrToPaddr(String.format("%016X", rva).toUpperCase());
			if(strLma!=null){
				lma	= getStringToLong(strLma, false);
			}
			size	= ELF64_ADDR_SIZE;
			value	= "";
			if(ELFDATA==ELFDATA2LSB){	//LSB
				for(int i=offset+size-1; i>=offset; i--){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}else{	//MSB
				for(int i=offset; i<offset+size; i++){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
			}
			analysis	= "";
			analysis	+= ELF_SECTION_HEADER_TABLE_ITEM.getChildren().get(sectionHeaderIndex).getValue().getName();
			notes		= R_offset_Addr_Notes;
			
			EPlusViewerTreeTableRecord addr	= null;
			if(rva!=0 && lma!=0){
				addr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}else if(rva!=0){
				addr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			}else{
				addr	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}
			TreeItem<EPlusViewerTreeTableRecord> addr_Item	= new TreeItem<>(addr);
//			addr_Item.setExpanded(true);
			item.getChildren().add(addr_Item);
		}
	}
	
	private void makeElfNote(TreeItem<EPlusViewerTreeTableRecord> item, SectionHeader sh){
		
		if(ELFCLASS==ELFCLASS32){	//32bit	
			//開始アドレス取得
			int startAddr32	= sh.getSh_offset_int();
			
			//データ取得用
			int dataSize	= sh.getSh_size_int();
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			int rva			= 0;
			int lma			= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			int v			= 0;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;

			//カウント
			int count		= 0;
			int sizeCount	= 0;
			
			//取得用
			int nameSize_int		= 0;
			int descSize_int		= 0;
			int alimentNameSize_int	= 0;
			int alimentDescSize_int	= 0;
			int quotient_int		= 0;
			int remainder_int		= 0;
			
			//アドレス設定
			rawAddr			= startAddr32;
			rva				= sh.getSh_addr_int();
			String strLma	= getVaddrToPaddr(String.format("%08X", rva).toUpperCase());
			if(strLma!=null){
				lma			= getStringToInt(strLma, false);
			}	
		
			for(int c=0; c<dataSize; c+=sizeCount){				
				//ELF_NOTE
				name		= "ELF_NOTE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size		= dataSize;
				value		= "";
				analysis	= "";
				notes		= ELF_NOTE_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_NOTE	= null;
				if(rva!=0 && lma!=0){
					ELF_NOTE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					ELF_NOTE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					ELF_NOTE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> ELF_NOTE_Item 	= new TreeItem<>(ELF_NOTE);
//				ELF_NOTE_Item.setExpanded(true);
				item.getChildren().add(ELF_NOTE_Item);
				
				//サイズカウント初期化
				sizeCount	=	0;
				
				
				//0x00	Elf32_Word	n_namesz
				name	= "n_namesz";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				analysis	= String.valueOf(v)+ " bytes";			
				notes		= ELF_NOTE_n_namesz_Notes;
				beforesize	= size;
				nameSize_int = v;
				sizeCount	+= size;
				
				EPlusViewerTreeTableRecord n_namesz	= null;
				if(rva!=0 && lma!=0){
					n_namesz	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					n_namesz	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					n_namesz	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> n_namesz_Item	= new TreeItem<>(n_namesz);
//				n_namesz_Item.setExpanded(true);
				ELF_NOTE_Item.getChildren().add(n_namesz_Item);
					
				//サイズ計算
				quotient_int	= nameSize_int/ELF32_WORD_SIZE;
				remainder_int	= nameSize_int%ELF32_WORD_SIZE;			
				if(quotient_int!=0&&remainder_int>0){
					alimentNameSize_int	= (quotient_int+1)*ELF32_WORD_SIZE;
				}else if(quotient_int!=0&&remainder_int==0){
					alimentNameSize_int	= quotient_int*ELF32_WORD_SIZE;
				}else {
					alimentNameSize_int	= 0;
				}
				
				
				//0x04	Elf32_Word	n_descsz
				name	= "n_descsz";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				analysis	= String.valueOf(v)+ " bytes";			
				notes		= ELF_NOTE_n_descsz_Notes;
				beforesize	= size;
				descSize_int = v;
				sizeCount	+= size;
				
				EPlusViewerTreeTableRecord n_descsz	= null;
				if(rva!=0 && lma!=0){
					n_descsz	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					n_descsz	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					n_descsz	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> n_descsz_Item	= new TreeItem<>(n_descsz);
//				n_descsz_Item.setExpanded(true);
				ELF_NOTE_Item.getChildren().add(n_descsz_Item);
				
				//サイズ計算
				quotient_int	= descSize_int/ELF32_WORD_SIZE;
				remainder_int	= descSize_int%ELF32_WORD_SIZE;			
				if(quotient_int!=0&&remainder_int>0){
					alimentDescSize_int	= (quotient_int+1)*ELF32_WORD_SIZE;
				}else if(quotient_int!=0&&remainder_int==0){
					alimentDescSize_int	= quotient_int*ELF32_WORD_SIZE;
				}else{
					alimentDescSize_int = 0;
				}
				
				
				//0x08	Elf32_Word	n_type
				name	= "n_type";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF32_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";			
				notes		= ELF_NOTE_n_type_Notes;
				beforesize	= size;
				sizeCount	+= size;
				
				EPlusViewerTreeTableRecord n_type	= null;
				if(rva!=0 && lma!=0){
					n_type	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					n_type	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					n_type	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> n_type_Item	= new TreeItem<>(n_type);
//				n_descsz_Item.setExpanded(true);
				ELF_NOTE_Item.getChildren().add(n_type_Item);
				
				
				if(alimentNameSize_int>0){			
					//0x0c	Variable	n_name
					name	= "n_name";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= nameSize_int;
					value	= "";
					analysis = "";	
					for(int i=offset; i<offset+size; i++){
						value		+= String.format("%02X", data[i]).toUpperCase();
						analysis	+= String.format("%c", data[i]).toUpperCase();
					}	
					notes		= ELF_NOTE_n_name_Notes;
					beforesize	= alimentNameSize_int;
					sizeCount	+= alimentNameSize_int;
					
					EPlusViewerTreeTableRecord n_name	= null;
					if(rva!=0 && lma!=0){
						n_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else if(rva!=0){
						n_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else{
						n_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> n_name_Item	= new TreeItem<>(n_name);
//					n_name_Item.setExpanded(true);
					ELF_NOTE_Item.getChildren().add(n_name_Item);
					
					//name設定
					ELF_NOTE.setName(ELF_NOTE.getName()+":"+analysis);
				}
				
				
				if(alimentDescSize_int>0){
					//0x00	Variable	n_desc
					name	= "n_desc";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= descSize_int;
					value	= "";
					analysis = "";	
					for(int i=offset; i<offset+size; i++){
						value		+= String.format("%02X", data[i]).toUpperCase();
//						analysis	+= String.format("%c", data[i]).toUpperCase();
					}	
					notes		= ELF_NOTE_n_desc_Notes;
					beforesize	= alimentDescSize_int;
					sizeCount	+= alimentDescSize_int;
					
					EPlusViewerTreeTableRecord n_desc	= null;
					if(rva!=0 && lma!=0){
						n_desc	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else if(rva!=0){
						n_desc	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else{
						n_desc	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> n_desc_Item	= new TreeItem<>(n_desc);
//					n_desc_Item.setExpanded(true);
					ELF_NOTE_Item.getChildren().add(n_desc_Item);
					
				}
				
				//サイズ更新
				ELF_NOTE.setSize(String.format("%08X", sizeCount).toUpperCase());
				
				count++;
			}
		}else if(ELFCLASS==ELFCLASS64){	//64bit
			//開始アドレス取得
			long startAddr64	= sh.getSh_offset_long();
			int startAddr32		= (int)startAddr64;
			
			//データ取得用
			int dataSize	= (int)sh.getSh_size_long();
			byte[] data		= null;
			
			//データ取得
			data	= getBintableBytes(startAddr32, dataSize);
				
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			long rva		= 0;
			long lma		= 0;
			int offset		= 0;
			int beforesize	= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			int v			= 0;
			
			//オフセット
			int startOffset	= 0;
			int baseOffset	= 0;

			//カウント
			int count		= 0;
			int sizeCount	= 0;
			
			//取得用
			int nameSize_int		= 0;
			int descSize_int		= 0;
			int alimentNameSize_int	= 0;
			int alimentDescSize_int	= 0;
			int quotient_int		= 0;
			int remainder_int		= 0;
			
			//アドレス設定
			rawAddr			= startAddr32;
			rva				= sh.getSh_addr_long();
			String strLma	= getVaddrToPaddr(String.format("%016X", rva).toUpperCase());
			if(strLma!=null){
				lma			= getStringToLong(strLma, false);
			}
		
			for(int c=0; c<dataSize; c+=sizeCount){
				//ELF_NOTE
				name		= "ELF_NOTE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				if(rva!=0){
					rva		+= beforesize;
				}
				if(lma!=0){
					lma		+= beforesize;
				}
				size		= dataSize;
				value		= "";
				analysis	= "";
				notes		= ELF_NOTE_Notes;
				beforesize	= 0;
				baseOffset	= offset;
				
				EPlusViewerTreeTableRecord ELF_NOTE	= null;
				if(rva!=0 && lma!=0){
					ELF_NOTE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					ELF_NOTE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else{
					ELF_NOTE	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> ELF_NOTE_Item 	= new TreeItem<>(ELF_NOTE);
//				ELF_NOTE_Item.setExpanded(true);
				item.getChildren().add(ELF_NOTE_Item);
				
				//サイズカウント初期化
				sizeCount	=	0;
				
				
				//0x00	Elf64_Word	n_namesz
				name	= "n_namesz";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				analysis	= String.valueOf(v)+ " bytes";			
				notes		= ELF_NOTE_n_namesz_Notes;
				beforesize	= size;
				nameSize_int = v;
				sizeCount	+= size;
				
				EPlusViewerTreeTableRecord n_namesz	= null;
				if(rva!=0 && lma!=0){
					n_namesz	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					n_namesz	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					n_namesz	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> n_namesz_Item	= new TreeItem<>(n_namesz);
//				n_namesz_Item.setExpanded(true);
				ELF_NOTE_Item.getChildren().add(n_namesz_Item);
					
				//サイズ計算
				quotient_int	= nameSize_int/ELF64_WORD_SIZE;
				remainder_int	= nameSize_int%ELF64_WORD_SIZE;			
				if(quotient_int!=0&&remainder_int>0){
					alimentNameSize_int	= (quotient_int+1)*ELF64_WORD_SIZE;
				}else if(quotient_int!=0&&remainder_int==0){
					alimentNameSize_int	= quotient_int*ELF64_WORD_SIZE;
				}else {
					alimentNameSize_int	= 0;
				}
				
				
				//0x04	Elf64_Word	n_descsz
				name	= "n_descsz";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				analysis	= String.valueOf(v)+ " bytes";			
				notes		= ELF_NOTE_n_descsz_Notes;
				beforesize	= size;
				descSize_int = v;
				sizeCount	+= size;
				
				EPlusViewerTreeTableRecord n_descsz	= null;
				if(rva!=0 && lma!=0){
					n_descsz	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					n_descsz	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					n_descsz	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> n_descsz_Item	= new TreeItem<>(n_descsz);
//				n_descsz_Item.setExpanded(true);
				ELF_NOTE_Item.getChildren().add(n_descsz_Item);
				
				//サイズ計算
				quotient_int	= descSize_int/ELF64_WORD_SIZE;
				remainder_int	= descSize_int%ELF64_WORD_SIZE;			
				if(quotient_int!=0&&remainder_int>0){
					alimentDescSize_int	= (quotient_int+1)*ELF64_WORD_SIZE;
				}else if(quotient_int!=0&&remainder_int==0){
					alimentDescSize_int	= quotient_int*ELF64_WORD_SIZE;
				}else{
					alimentDescSize_int = 0;
				}
				
				
				//0x08	Elf64_Word	n_type
				name	= "n_type";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				if(rva!=0){
					rva	+= beforesize;
				}
				if(lma!=0){
					lma	+= beforesize;
				}
				size	= ELF64_WORD_SIZE;
				value	= "";
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
				analysis	= "";			
				notes		= ELF_NOTE_n_type_Notes;
				beforesize	= size;
				sizeCount	+= size;
				
				EPlusViewerTreeTableRecord n_type	= null;
				if(rva!=0 && lma!=0){
					n_type	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}else if(rva!=0){
					n_type	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				}else{
					n_type	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				}
				TreeItem<EPlusViewerTreeTableRecord> n_type_Item	= new TreeItem<>(n_type);
//				n_descsz_Item.setExpanded(true);
				ELF_NOTE_Item.getChildren().add(n_type_Item);
				
				
				if(alimentNameSize_int>0){			
					//0x0c	Variable	n_name
					name	= "n_name";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= nameSize_int;
					value	= "";
					analysis = "";	
					for(int i=offset; i<offset+size; i++){
						value		+= String.format("%02X", data[i]).toUpperCase();
						analysis	+= String.format("%c", data[i]).toUpperCase();
					}	
					notes		= ELF_NOTE_n_name_Notes;
					beforesize	= alimentNameSize_int;
					sizeCount	+= alimentNameSize_int;
					
					EPlusViewerTreeTableRecord n_name	= null;
					if(rva!=0 && lma!=0){
						n_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else if(rva!=0){
						n_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else{
						n_name	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> n_name_Item	= new TreeItem<>(n_name);
//					n_name_Item.setExpanded(true);
					ELF_NOTE_Item.getChildren().add(n_name_Item);
					
					//name設定
					ELF_NOTE.setName(ELF_NOTE.getName()+":"+analysis);
				}
				
				
				if(alimentDescSize_int>0){
					//0x00	Variable	n_desc
					name	= "n_desc";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					if(rva!=0){
						rva	+= beforesize;
					}
					if(lma!=0){
						lma	+= beforesize;
					}
					size	= descSize_int;
					value	= "";
					analysis = "";	
					for(int i=offset; i<offset+size; i++){
						value		+= String.format("%02X", data[i]).toUpperCase();
//						analysis	+= String.format("%c", data[i]).toUpperCase();
					}	
					notes		= ELF_NOTE_n_desc_Notes;
					beforesize	= alimentDescSize_int;
					sizeCount	+= alimentDescSize_int;
					
					EPlusViewerTreeTableRecord n_desc	= null;
					if(rva!=0 && lma!=0){
						n_desc	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}else if(rva!=0){
						n_desc	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					}else{
						n_desc	= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					}
					TreeItem<EPlusViewerTreeTableRecord> n_desc_Item	= new TreeItem<>(n_desc);
//					n_desc_Item.setExpanded(true);
					ELF_NOTE_Item.getChildren().add(n_desc_Item);			
				}
				
				//サイズ更新
				ELF_NOTE.setSize(String.format("%08X", sizeCount).toUpperCase());
				
				count++;
			}
		}
	}
	
	private void makeData(TreeItem<EPlusViewerTreeTableRecord> item, String strAddr, String strVaddr, String strDataSize, boolean dataFlag){
				
		if(ELFCLASS==ELFCLASS32){	//32bit	
			//開始アドレス取得
			int startAddr32		= 0;
			
			//データ取得用
			int dataSize	= 0;
			byte[] data		= null;
			
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			int rva			= 0;
			int lma			= 0;
			int offset		= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			String strPaddr	= null;

			//データ開始アドレスとサイズを取得
			if(strAddr!=null){
				startAddr32	= getStringToInt(strAddr, false);
			}else{
				startAddr32	= getStringToInt(getVaddrToFileoffset(strVaddr, false), false);
			}
			dataSize	= getStringToInt(strDataSize, false);
			data		= getBintableBytes(startAddr32, dataSize);
			
			//0x00	Variable	data	
			name			= "data";
			rawAddr			= startAddr32;	
			raw				= rawAddr;	
			offset			= 0x0;
			if(strVaddr!=null){
				rva			= getStringToInt(strVaddr, false);
				strPaddr	= getVaddrToPaddr(strVaddr);
			}
			if(strPaddr!=null){
				lma			= getStringToInt(strPaddr, false);
			}
			size			= dataSize;
			value			= "";
			if(dataFlag){
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
			}
			analysis	= "";
			notes		= Data_Notes;	

			EPlusViewerTreeTableRecord Data	= null;
			if(strVaddr!=null && strPaddr!=null){
				Data					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", lma).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}else if(strVaddr!=null){
				Data					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}else{
				Data					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);						
			}
			TreeItem<EPlusViewerTreeTableRecord> Data_Item	= new TreeItem<>(Data);
//			Data_Item.setExpanded(true);
			item.getChildren().add(Data_Item);	

		}else if(ELFCLASS==ELFCLASS64){	//64bit
			//開始アドレス取得
			long startAddr64	= 0;
			int startAddr32		= 0;

			//データ取得用
			int dataSize	= 0;
			byte[] data		= null;
			
			//設定用変数
			String name		= "";
			int raw			= 0;
			int rawAddr		= 0;
			long rva		= 0;
			long lma		= 0;
			int offset		= 0;
			int size		= 0;
			String value	= "";
			String analysis = "";
			String notes	= "";
			String strPaddr	= null;
	
			//データ開始アドレスとサイズを取得
			if(strAddr!=null){
				startAddr64	= getStringToLong(strAddr, false);
			}else{
				startAddr64	= getStringToLong(getVaddrToFileoffset(strVaddr, false), false);
			}
			startAddr32 = (int)startAddr64;
			dataSize	= (int)getStringToLong(strDataSize, false);
			data		= getBintableBytes(startAddr32, dataSize);
			
			//0x00	Variable	data	
			name			= "data";
			rawAddr			= startAddr32;	
			raw				= rawAddr;	
			offset			= 0x0;
			if(strVaddr!=null){
				rva			= getStringToLong(strVaddr, false);
				strPaddr	= getVaddrToPaddr(strVaddr);
			}
			if(strPaddr!=null){
				lma			= getStringToLong(strPaddr, false);
			}
			size			= dataSize;
			value			= "";
			if(dataFlag){
				if(ELFDATA==ELFDATA2LSB){	//LSB
					for(int i=offset+size-1; i>=offset; i--){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}else{	//MSB
					for(int i=offset; i<offset+size; i++){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
				}
			}	
			analysis		= "";
			notes			= Data_Notes;
				
			EPlusViewerTreeTableRecord Data	= null;
			if(strVaddr!=null && strPaddr!=null){
				Data					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%016X", lma).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			}else if(strVaddr!=null){
				Data					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%016X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			}else{
				Data					= new EPlusViewerTreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);						
			}
			TreeItem<EPlusViewerTreeTableRecord> Data_Item	= new TreeItem<>(Data);
//			Data_Item.setExpanded(true);
			item.getChildren().add(Data_Item);

		}
	}

	protected int getBinTableLastByteNum(){
		
		if(binTableRecordList.isEmpty()){
			return 0;
		}
		
		int lastLineno	= binTableRecordList.size()-1;
		int lastByteNum	= binTableRecordList.get(lastLineno).getBlankColumnStartBinNumber();
		
		return lastLineno*0x10+lastByteNum;
	}
	
	protected String getVaddrToPaddr(String strVaddr){

		String strPaddr	= null;
		
		Iterator<ProgramHeader> programHeaderListIterator = programHeaderList.iterator();
		ProgramHeader ph	= null;
		
		if(ELFCLASS==ELFCLASS32){
			while(programHeaderListIterator.hasNext()){				
				ph			= programHeaderListIterator.next();	
				strPaddr	= ph.getVaddrToPaddrInt(strVaddr);
				if(strPaddr!=null){
					break;
				}
			}
		}else if(ELFCLASS==ELFCLASS64){
			while(programHeaderListIterator.hasNext()){				
				ph			= programHeaderListIterator.next();	
				strPaddr	= ph.getVaddrToPaddrLong(strVaddr);
				if(strPaddr!=null){
					break;
				}
			}
		}
		
		return strPaddr;
	}
	
	protected String getVaddrToFileoffset(String strVaddr, boolean endian){

		String strFileoffset 	= null;
		
		if(ELFCLASS==ELFCLASS32){
			int vaddr32       		= 0;
			int offset32			= 0;
			long vaddr64			= 0;
			long offset64			= 0;
			
			Iterator<ProgramHeader> programHeaderListIterator = programHeaderList.iterator();
			ProgramHeader ph	= null;

			vaddr32 = getStringToInt(strVaddr, endian);
			vaddr64 = Integer.toUnsignedLong(vaddr32);

			while(programHeaderListIterator.hasNext()){				
				ph = programHeaderListIterator.next();
				
				long start	= Integer.toUnsignedLong(ph.getP_vaddr_int());
				long end	= Integer.toUnsignedLong(ph.getP_vaddr_int())+Integer.toUnsignedLong(ph.getP_filesz_int());
				
				if(vaddr64 >= start && vaddr64 <= end){
					offset32	= vaddr32-ph.getP_vaddr_int()+ph.getP_offset_int();
//					offset64	= vaddr64-Integer.toUnsignedLong(ph.getP_vaddr_int())+Integer.toUnsignedLong(ph.getP_offset_int());
//					offset32	= (int)offset64;
					strFileoffset = String.format("%08X", offset32).toUpperCase();		
					break;
				}
			}
			
		}else if(ELFCLASS==ELFCLASS64){
			long vaddr64			= 0;
			long offset64			= 0;
			
			Iterator<ProgramHeader> programHeaderListIterator = programHeaderList.iterator();
			ProgramHeader ph	= null;
			
			vaddr64 = getStringToLong(strVaddr, endian);
			
			while(programHeaderListIterator.hasNext()){
				ph = programHeaderListIterator.next();
				
//				if(vaddr64 >= ph.getP_vaddr_long() && vaddr64 <= (ph.getP_vaddr_long()+ph.getP_filesz_long())){
				if((Long.compareUnsigned(vaddr64, ph.getP_vaddr_long())==0 || Long.compareUnsigned(vaddr64, ph.getP_vaddr_long())>0) &&
				   (Long.compareUnsigned(vaddr64, ph.getP_vaddr_long()+ph.getP_filesz_long())==0 || Long.compareUnsigned(vaddr64, ph.getP_vaddr_long()+ph.getP_filesz_long())<0)){
					offset64 = vaddr64-ph.getP_vaddr_long()+ph.getP_offset_long();
					strFileoffset = String.format("%016X", offset64).toUpperCase();
					break;
				}
			}
		}
		
		return strFileoffset;
	}
	
	protected String getAddStrAddrInt(String strAddr1, boolean endian1, String strAddr2, boolean endian2) {
		
		long intAddr1	= Integer.toUnsignedLong(getStringToInt(strAddr1, endian1));
		long intAddr2	= Integer.toUnsignedLong(getStringToInt(strAddr2, endian2));
		long intAddr	= intAddr1 + intAddr2;
		String strAddr	= String.format("%08X", (int)intAddr).toUpperCase();
		
		return strAddr;
	}
	
	protected String getAddStrAddrLong(String strAddr1, boolean endian1, String strAddr2, boolean endian2) {
		
		long longAddr1	= getStringToLong(strAddr1, endian1);
		long longAddr2	= getStringToLong(strAddr2, endian2);
		long longAddr	= longAddr1 + longAddr2;
		String strAddr	= String.format("%016X", longAddr).toUpperCase();
		
		return strAddr;
	}
	
	protected int getStringToInt(String str, boolean little) {
		
		int num 			= 0;
		byte[] bytes	 	= null;
		ByteBuffer bytesBuf = null;
		
		bytes	= DatatypeConverter.parseHexBinary(str);
		bytesBuf = ByteBuffer.wrap(bytes);
		
		if(little) {
			bytesBuf.order(ByteOrder.LITTLE_ENDIAN);
		}
		
		if(bytes.length == 2) {
			num	= (int)bytesBuf.getShort(0);
		}else {
			num = bytesBuf.getInt(0);
		}
		
//		System.out.println("str="+str);
//		System.out.println("little="+little);		
//		System.out.println("num="+num);
		
		return num;
	}
	
	protected long getStringToLong(String str, boolean little) {
		
		long num 			= 0;
		byte[] bytes	 	= null;
		ByteBuffer bytesBuf = null;
		
		bytes	= DatatypeConverter.parseHexBinary(str);
		bytesBuf = ByteBuffer.wrap(bytes);
		
		if(little) {
			bytesBuf.order(ByteOrder.LITTLE_ENDIAN);
		}
		
		num	= bytesBuf.getLong(0);
		
//		System.out.println("str="+str);
//		System.out.println("little="+little);		
//		System.out.println("num="+num);
		
		return num;
	}
	
	protected byte[] getBintableBytes(int startAddr, int size) {
		
//		byte[] startBytes = null;
//		ByteBuffer startBuf = null;
		
		int lineno		= 0;
		int offset		= 0;
		String dataStr	= null;
		byte[] data		= null;
		int datacount	= 0;
		
		//開始番地（文字列）を開始番地（数値）に変換する
//		startBytes	= DatatypeConverter.parseHexBinary(startStr);
//		startBuf = ByteBuffer.wrap(startBytes);
//		startBuf.order(ByteOrder.LITTLE_ENDIAN);
//		//System.out.println(startBuf.getInt(0));
		
		//開始番地からリストの開始行数とオフセットを求める
		lineno	= Integer.divideUnsigned(startAddr, 16);
		offset	= Integer.remainderUnsigned(startAddr, 16);
		
//		System.out.println("lineno="+lineno);
//		System.out.println("offset="+offset);
		
		//バイナリのリストからデータを取得する		
		BinTableRecord binTableRecord 	= binTableRecordList.get(lineno);
		data	= new byte[size];
		
		if(offset+size >= 16) {	//次の行にまたがる場合
			//最初の1行
			for(int i=offset; i<16; i++){
				dataStr = binTableRecord.getBinData(i);
				data[datacount] = DatatypeConverter.parseHexBinary(dataStr)[0];				
				datacount++;
			}
			lineno++;
			
			//次の行から			
			while(datacount < size) {			
				binTableRecord 	= binTableRecordList.get(lineno);
				for(int j=0; j<16 ;j++){
//					System.out.println("lineno="+lineno);
//					System.out.println("j="+j);
//					System.out.println("datacount="+datacount);
//					System.out.println("size="+size);
					if(datacount < size) {
						dataStr = binTableRecord.getBinData(j);
						data[datacount] = DatatypeConverter.parseHexBinary(dataStr)[0];
						datacount++;
					}else {
						break;
					}
				}
				lineno++;
			}
			
		}else {
			//最初の1行
			for(int i=offset; i<offset+size; i++){
				dataStr = binTableRecord.getBinData(i);
				data[datacount]	= DatatypeConverter.parseHexBinary(dataStr)[0];
				datacount++;
			}		
		}

		return data;
	}
	
	private String toEncryptedHashValue(String algorithmName, String value) {
	    MessageDigest md = null;
	    StringBuilder sb = null;
	    try {
	        md = MessageDigest.getInstance(algorithmName);
	    } catch (NoSuchAlgorithmException e) {
			String message	= "An error occured.";	
			idConsole.setText(message);
			StringWriter sw	= new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			alertMessageBox("ERROR", "ERROR", "ERROR", "An error occured.", sw.toString());
	    }
	    md.update(value.getBytes());
	    sb = new StringBuilder();
	    for (byte b : md.digest()) {
	        String hex = String.format("%02x", b);
	        sb.append(hex);
	    }
	    return sb.toString();
	}
	
	protected void alertMessageBox(String alertType, String title, String headerText, String contentText, String expandableContentText) {
		
		Alert alert;
		
		if(alertType.equals("INFORMATION")) {
			alert	= new Alert(AlertType.INFORMATION);
		}else if(alertType.equals("ERROR")){
			alert	= new Alert(AlertType.ERROR);
		}else if(alertType.equals("WARNING")){
			alert	= new Alert(AlertType.WARNING);
		}else {
			alert	= new Alert(AlertType.NONE);
		}
				
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		
		if(!expandableContentText.isEmpty()) {
			TextArea textArea	= new TextArea(expandableContentText);
			textArea.setEditable(false);
			alert.getDialogPane().setExpandableContent(textArea);
		}

		alert.setResizable(true);
		alert.getDialogPane().setPrefSize(600, 700);
		
		alert.showAndWait();
		
	}
	
	protected void setConsoleMessage(String message){
		idConsole.setText(message);
	}
	
	protected void setConsoleClear(){
		idConsole.clear();
	}
	
	protected String getInputBinFilePath(){
		return inputBinFilePath;
	}
	
}

