package myproject.application.eplusviewer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import javax.xml.bind.DatatypeConverter;

public class SectionHeader {

	private String name				= "";
	private String sh_name_str		= "";
	private String sh_type_str		= "";
	private String sh_flags_str		= "";
	private String sh_addr_str		= "";
	private String sh_offset_str	= "";
	private String sh_size_str		= "";
	private String sh_link_str		= "";
	private String sh_info_str		= "";
	private String sh_addralign_str	= "";
	private String sh_entsize_str	= "";
	private int sh_type_int			= 0;
	private int sh_addr_int			= 0;
	private int sh_offset_int		= 0;
	private int sh_size_int			= 0;
	private int sh_link_int			= 0;
	private int sh_addralign_int	= 0;
	private int sh_entsize_int		= 0;
	private long sh_addr_long		= 0;
	private long sh_offset_long		= 0;
	private long sh_size_long		= 0;
	private long sh_addralign_long	= 0;
	private long sh_entsize_long	= 0;
	private int bitFlag				= 0;	//0:32bit 1:64bit
	
	
	public SectionHeader(String sh_name_str, int bitFlag){
		this.sh_name_str	= sh_name_str;
		this.bitFlag		= bitFlag;
	}

	public boolean addrCheckInt(String strStartAddr, int size){	
		//アドレスを数値に変換
		long startAddr	= Integer.toUnsignedLong(getStringToInt(strStartAddr, false));
		long endAddr	= startAddr + size;
		
		//比較
		if((startAddr>=Integer.toUnsignedLong(sh_addr_int)) && (endAddr<=Integer.toUnsignedLong(sh_addr_int)+Integer.toUnsignedLong(sh_size_int))){
			return true;
		}else {
			return false;
		}
	}
	
	public boolean addrCheckLong(String strStartAddr, long size){	
		//アドレスを数値に変換
		long startAddr	= getStringToLong(strStartAddr, false);
		long endAddr	= startAddr + size;
		
		//比較
		if((Long.compareUnsigned(startAddr, sh_addr_long)==0 || Long.compareUnsigned(startAddr, sh_addr_long)>0) &&
		   (Long.compareUnsigned(endAddr, sh_addr_long+sh_size_long)==0 || Long.compareUnsigned(endAddr, sh_addr_long+sh_size_long)<0)){
			return true;
		}else {
			return false;
		}
	}
	
	public boolean offsetCheckInt(String strStartAddr, int size){	
		//アドレスを数値に変換
		long startAddr	= Integer.toUnsignedLong(getStringToInt(strStartAddr, false));
		long endAddr	= startAddr + size;
		
		//比較
		if((startAddr>=Integer.toUnsignedLong(sh_offset_int)) && (endAddr<=Integer.toUnsignedLong(sh_offset_int)+Integer.toUnsignedLong(sh_size_int))){
			return true;
		}else {
			return false;
		}
	}
	
	public boolean offsetCheckLong(String strStartAddr, long size){	
		//アドレスを数値に変換
		long startAddr	= getStringToLong(strStartAddr, false);
		long endAddr		= startAddr + size;
		
		//比較
		if((Long.compareUnsigned(startAddr, sh_offset_long)==0 || Long.compareUnsigned(startAddr, sh_offset_long)>0) &&
		   (Long.compareUnsigned(endAddr, sh_offset_long+sh_size_long)==0 || Long.compareUnsigned(endAddr, sh_offset_long+sh_size_long)<0)){
			return true;
		}else {
			return false;
		}
	}
	
	private int getStringToInt(String str, boolean little) {
		
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
		
		return num;
	}
	
	private long getStringToLong(String str, boolean little) {
		
		long num 			= 0;
		byte[] bytes	 	= null;
		ByteBuffer bytesBuf = null;
		
		bytes	= DatatypeConverter.parseHexBinary(str);
		bytesBuf = ByteBuffer.wrap(bytes);
		
		if(little) {
			bytesBuf.order(ByteOrder.LITTLE_ENDIAN);
		}
		
		num	= bytesBuf.getLong(0);
		
		return num;
	}
	

	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSh_name_str() {
		return sh_name_str;
	}
	
	public void setSh_name_str(String sh_name_str) {
		this.sh_name_str = sh_name_str;
	}

	
	public String getSh_type_str() {
		return sh_type_str;
	}

	public void setSh_type_str(String sh_type_str) {
		this.sh_type_str = sh_type_str;
		if(bitFlag==0){	//32bit
			this.sh_type_int	= getStringToInt(sh_type_str, false);
		}else{	//64bit
			this.sh_type_int	= getStringToInt(sh_type_str, false);
		}
	}
	
	public int getSh_type_int() {
		return sh_type_int;
	}

	public void setSh_type_int(int sh_type_int) {
		this.sh_type_int = sh_type_int;
	}
	
	
	public String getSh_flags_str() {
		return sh_flags_str;
	}

	public void setSh_flags_str(String sh_flags_str) {
		this.sh_flags_str = sh_flags_str;
	}


	public String getSh_addr_str() {
		return sh_addr_str;
	}

	public void setSh_addr_str(String sh_addr_str) {
		this.sh_addr_str = sh_addr_str;
		
		if(bitFlag==0){	//32bit
			this.sh_addr_int	= getStringToInt(sh_addr_str, false);
		}else{	//64bit
			this.sh_addr_long	= getStringToLong(sh_addr_str, false);
		}
	}

	public int getSh_addr_int() {
		return sh_addr_int;
	}

	public void setSh_addr_int(int sh_addr_int) {
		this.sh_addr_int = sh_addr_int;
	}
	
	public long getSh_addr_long() {
		return sh_addr_long;
	}

	public void setSh_addr_long(long sh_addr_long) {
		this.sh_addr_long = sh_addr_long;
	}
	

	public String getSh_offset_str() {
		return sh_offset_str;
	}

	public void setSh_offset_str(String sh_offset_str) {
		this.sh_offset_str = sh_offset_str;
		
		if(bitFlag==0){	//32bit
			this.sh_offset_int	= getStringToInt(sh_offset_str, false);
		}else{	//64bit
			this.sh_offset_long	= getStringToLong(sh_offset_str, false);
		}	
	}

	public int getSh_offset_int() {
		return sh_offset_int;
	}

	public void setSh_offset_int(int sh_offset_int) {
		this.sh_offset_int = sh_offset_int;
	}
	
	public long getSh_offset_long() {
		return sh_offset_long;
	}

	public void setSh_offset_long(long sh_offset_long) {
		this.sh_offset_long = sh_offset_long;
	}
	

	public String getSh_size_str() {
		return sh_size_str;
	}

	public void setSh_size_str(String sh_size_str) {
		this.sh_size_str = sh_size_str;
		
		if(bitFlag==0){	//32bit
			this.sh_size_int	= getStringToInt(sh_size_str, false);
		}else{	//64bit
			this.sh_size_long	= getStringToLong(sh_size_str, false);
		}
	}

	public int getSh_size_int() {
		return sh_size_int;
	}

	public void setSh_size_int(int sh_size_int) {
		this.sh_size_int = sh_size_int;
	}
	
	public long getSh_size_long() {
		return sh_size_long;
	}

	public void setSh_size_long(long sh_size_long) {
		this.sh_size_long = sh_size_long;
	}
	
	
	public String getSh_link_str() {
		return sh_link_str;
	}

	public void setSh_link_str(String sh_link_str) {
		this.sh_link_str = sh_link_str;
		this.sh_link_int = getStringToInt(sh_link_str, false);
	}
	
	public int getSh_link_int() {
		return sh_link_int;
	}

	public void setSh_link_int(int sh_link_int) {
		this.sh_link_int = sh_link_int;
	}
	
	
	public String getSh_info_str() {
		return sh_info_str;
	}

	public void setSh_info_str(String sh_info_str) {
		this.sh_info_str = sh_info_str;
	}

	
	public String getSh_addralign_str() {
		return sh_addralign_str;
	}

	public void setSh_addralign_str(String sh_addralign_str) {
		this.sh_addralign_str = sh_addralign_str;
		
		if(bitFlag==0){	//32bit
			this.sh_addralign_int	= getStringToInt(sh_addralign_str, false);
		}else{	//64bit
			this.sh_addralign_long	= getStringToLong(sh_addralign_str, false);
		}	
	}

	public int getSh_addralign_int() {
		return sh_addralign_int;
	}

	public void setSh_addralign_int(int sh_addralign_int) {
		this.sh_addralign_int = sh_addralign_int;
	}
	
	public long getSh_addralign_long() {
		return sh_addralign_long;
	}

	public void setSh_addralign_long(long sh_addralign_long) {
		this.sh_addralign_long = sh_addralign_long;
	}


	public String getSh_entsize_str() {
		return sh_entsize_str;
	}

	public void setSh_entsize_str(String sh_entsize_str) {
		this.sh_entsize_str = sh_entsize_str;
		
		if(bitFlag==0){	//32bit
			this.sh_entsize_int		= getStringToInt(sh_entsize_str, false);
		}else{	//64bit
			this.sh_entsize_long	= getStringToLong(sh_entsize_str, false);
		}	
	}

	public int getSh_entsize_int() {
		return sh_entsize_int;
	}

	public void setSh_entsize_int(int sh_entsize_int) {
		this.sh_entsize_int = sh_entsize_int;
	}

	public long getSh_entsize_long() {
		return sh_entsize_long;
	}

	public void setSh_entsize_long(long sh_entsize_long) {
		this.sh_entsize_long = sh_entsize_long;
	}


	public int getBitFlag() {
		return bitFlag;
	}

	public void setBitFlag(int bitFlag) {
		this.bitFlag = bitFlag;
	}

}
