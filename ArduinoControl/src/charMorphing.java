public class charMorphing implements penPlugin {
	public charMorphing(){
		
	}
	
	public String str2Half(String str){
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < str.length(); i++){
			int c = (int)str.charAt(i);
			if((c >= 65345 && c <= 65370)
				|| (c >= 65313 && c <= 65338)
				|| (c >= 65296 && c <= 65305)){
				c -= 65248;
			}
			sb.append((char)c);
		}
		return sb.toString();
	}
	
	public String str2Double(String str){
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < str.length(); i++){
			int c = (int)str.charAt(i);
			if((c >= 97 && c <= 122)
				|| (c >= 65 && c <= 90)
				|| (c >= 48 && c <= 57)){
				c += 65248;
			}
			sb.append((char)c);
		}
		return sb.toString();
		
	}
	public void init() {
		
	}
	
	public void destruction() {
	}
}
