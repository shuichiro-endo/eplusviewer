package myproject.application.eplusviewer;

public class SLEB128Result{
	private long value;
	private int size;
	private int nextOffset;

	public SLEB128Result(byte[] data, int offset) {
		readSLEB128(data, offset);
	}

	private void readSLEB128(byte[] data, int offset) {
		long result	= 0;
		int shift	= 0;
		int pos		= offset;
		int b		= 0;

		while(true){
			if(pos>=data.length){
				throw new IllegalArgumentException("Unexpected end of data");
			}

			b 		= data[pos++]&0xFF;
			result	|= (long)(b&0x7F)<<shift;
			shift 	+= 7;

			if((b&0x80)==0){
				break;
			}

			if(shift>=64){
				throw new IllegalArgumentException("SLEB128 too large");
			}
		}

		if((shift<64)&&((b&0x40)!=0)){
			result |= -1L<<shift;
		}

		this.value		= result;
		this.size		= pos-offset;
		this.nextOffset	= pos;
	}

	public long getValue(){
		return value;
	}

	public int getSize(){
		return size;
	}

	public int getNextOffset(){
		return nextOffset;
	}
}
