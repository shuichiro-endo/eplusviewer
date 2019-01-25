package myproject.application.eplusviewer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import javax.xml.bind.DatatypeConverter;

public class ProgramHeader {

	private String p_type_str	= "";
	private String p_flags_str	= "";
	private String p_offset_str	= "";
	private String p_vaddr_str	= "";
	private String p_paddr_str	= "";
	private String p_filesz_str	= "";
	private String p_memsz_str	= "";
	private String p_align_str	= "";
	private int p_offset_int	= 0;
	private int p_vaddr_int		= 0;
	private int p_paddr_int		= 0;
	private int p_filesz_int	= 0;
	private int p_memsz_int		= 0;
	private int p_align_int		= 0;
	private long p_offset_long	= 0;
	private long p_vaddr_long	= 0;
	private long p_paddr_long	= 0;
	private long p_filesz_long	= 0;
	private long p_memsz_long	= 0;
	private long p_align_long	= 0;
	private int bitFlag			= 0;	//0:32bit 1:64bit
	
	public ProgramHeader(String p_type_str, int bitFlag){
		this.p_type_str	= p_type_str;
		this.bitFlag	= bitFlag;
	}
	
	public String getVaddrToPaddrInt(String strVaddr){	
		//アドレスを数値に変換
		long vaddr_long	= Integer.toUnsignedLong(getStringToInt(strVaddr, false));

		long startVaddr	= Integer.toUnsignedLong(p_vaddr_int);
		long endVaddr	= Integer.toUnsignedLong(p_vaddr_int)+Integer.toUnsignedLong(p_memsz_int);
		
		long diffaddr	= 0;
		long paddr_long	= 0;
		String strPaddr	= null;
		
		//比較
		if((vaddr_long>=startVaddr) && (vaddr_long<=endVaddr)){
			
			diffaddr	= vaddr_long-startVaddr;
			paddr_long	= Integer.toUnsignedLong(p_paddr_int)+diffaddr;
			strPaddr	= String.format("%08X", (int)paddr_long).toUpperCase();
		}
		
		return strPaddr;
	}
	
	public String getVaddrToPaddrLong(String strVaddr){	
		//アドレスを数値に変換
		long vaddr_long	= getStringToLong(strVaddr, false);

		long startVaddr	= p_vaddr_long;
		long endVaddr	= p_vaddr_long+p_memsz_long;
		
		long diffaddr	= 0;
		long paddr_long	= 0;
		String strPaddr	= null;
		
		//比較
		if((Long.compareUnsigned(vaddr_long, startVaddr)==0 || Long.compareUnsigned(vaddr_long, startVaddr)>0) && 
		   (Long.compareUnsigned(vaddr_long, endVaddr)==0 || Long.compareUnsigned(vaddr_long, endVaddr)<0)){
			
			diffaddr	= vaddr_long-startVaddr;
			paddr_long	= p_paddr_long+diffaddr;
			strPaddr	= String.format("%016X", paddr_long).toUpperCase();
		}
		
		return strPaddr;
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
	
	
	public String getP_type_str() {
		return p_type_str;
	}

	public void setP_type_str(String p_type_str) {
		this.p_type_str = p_type_str;
	}	

	public String getP_flags_str() {
		return p_flags_str;
	}

	public void setP_flags_str(String p_flags_str) {
		this.p_flags_str = p_flags_str;
	}
	
	public String getP_offset_str() {
		return p_offset_str;
	}

	public void setP_offset_str(String p_offset_str) {
		this.p_offset_str = p_offset_str;
		
		if(bitFlag==0){	//32bit
			this.p_offset_int	= getStringToInt(p_offset_str, false);
		}else{	//64bit
			this.p_offset_long	= getStringToLong(p_offset_str, false);
		}
	}

	public int getP_offset_int() {
		return p_offset_int;
	}

	public void setP_offset_int(int p_offset_int) {
		this.p_offset_int = p_offset_int;
	}
	
	public long getP_offset_long() {
		return p_offset_long;
	}

	public void setP_offset_long(long p_offset_long) {
		this.p_offset_long = p_offset_long;
	}
	
	
	public String getP_vaddr_str() {
		return p_vaddr_str;
	}

	public void setP_vaddr_str(String p_vaddr_str) {
		this.p_vaddr_str = p_vaddr_str;
		
		if(bitFlag==0){	//32bit
			this.p_vaddr_int	= getStringToInt(p_vaddr_str, false);
		}else{	//64bit
			this.p_vaddr_long	= getStringToLong(p_vaddr_str, false);
		}
	}
	
	public int getP_vaddr_int() {
		return p_vaddr_int;
	}

	public void setP_vaddr_int(int p_vaddr_int) {
		this.p_vaddr_int = p_vaddr_int;
	}
	
	public long getP_vaddr_long() {
		return p_vaddr_long;
	}

	public void setP_vaddr_long(long p_vaddr_long) {
		this.p_vaddr_long = p_vaddr_long;
	}
	
	
	public String getP_paddr_str() {
		return p_paddr_str;
	}

	public void setP_paddr_str(String p_paddr_str) {
		this.p_paddr_str = p_paddr_str;
		
		if(bitFlag==0){	//32bit
			this.p_paddr_int	= getStringToInt(p_paddr_str, false);
		}else{	//64bit
			this.p_paddr_long	= getStringToLong(p_paddr_str, false);
		}
	}
	
	public int getP_paddr_int() {
		return p_paddr_int;
	}

	public void setP_paddr_int(int p_paddr_int) {
		this.p_paddr_int = p_paddr_int;
	}
	
	public long getP_paddr_long() {
		return p_paddr_long;
	}

	public void setP_paddr_long(long p_paddr_long) {
		this.p_paddr_long = p_paddr_long;
	}
	
	
	public String getP_filesz_str() {
		return p_filesz_str;
	}

	public void setP_filesz_str(String p_filesz_str) {
		this.p_filesz_str = p_filesz_str;
		
		if(bitFlag==0){	//32bit
			this.p_filesz_int	= getStringToInt(p_filesz_str, false);
		}else{	//64bit
			this.p_filesz_long	= getStringToLong(p_filesz_str, false);
		}
	}

	public int getP_filesz_int() {
		return p_filesz_int;
	}

	public void setP_filesz_int(int p_filesz_int) {
		this.p_filesz_int = p_filesz_int;
	}

	public long getP_filesz_long() {
		return p_filesz_long;
	}

	public void setP_filesz_long(long p_filesz_long) {
		this.p_filesz_long = p_filesz_long;
	}
	
	
	public String getP_memsz_str() {
		return p_memsz_str;
	}

	public void setP_memsz_str(String p_memsz_str) {
		this.p_memsz_str = p_memsz_str;
		
		if(bitFlag==0){	//32bit
			this.p_memsz_int	= getStringToInt(p_memsz_str, false);
		}else{	//64bit
			this.p_memsz_long	= getStringToLong(p_memsz_str, false);
		}
	}
	
	public int getP_memsz_int() {
		return p_memsz_int;
	}

	public void setP_memsz_int(int p_memsz_int) {
		this.p_memsz_int = p_memsz_int;
	}
	
	public long getP_memsz_long() {
		return p_memsz_long;
	}

	public void setP_memsz_long(long p_memsz_long) {
		this.p_memsz_long = p_memsz_long;
	}
	

	public String getP_align_str() {
		return p_align_str;
	}

	public void setP_align_str(String p_align_str) {
		this.p_align_str = p_align_str;
		
		if(bitFlag==0){	//32bit
			this.p_align_int	= getStringToInt(p_align_str, false);
		}else{	//64bit
			this.p_align_long	= getStringToLong(p_align_str, false);
		}		
	}

	public int getP_align_int() {
		return p_align_int;
	}

	public void setP_align_int(int p_align_int) {
		this.p_align_int = p_align_int;
	}

	public long getP_align_long() {
		return p_align_long;
	}

	public void setP_align_long(long p_align_long) {
		this.p_align_long = p_align_long;
	}


	public int getBitFlag() {
		return bitFlag;
	}

	public void setBitFlag(int bitFlag) {
		this.bitFlag = bitFlag;
	}
}
