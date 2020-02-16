package edu.smxy.blockchain;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Block { 
	public String hash;  
	public String previousHash; 
	public String data; //数据        
	public String timeStamp; //时间戳        //区块构造函数       
	public Block(String data,String previousHash ) {
		this.data = data;                
		this.previousHash = previousHash;    
		this.timeStamp =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
		//new Timestamp(new Date().getTime()).toString(); 
		this.hash = calculateHash(); //确保hash值的来源
	}
	public Block(String hash,String previousHash,String data,String timeStamp) {
		this.hash = hash;
		this.previousHash = previousHash;  
		this.data = data;   
		this.timeStamp = timeStamp;
	}
	public String calculateHash() {
		String calculatedhash = StringUtil.applySha256(
				previousHash 
				+timeStamp
				+data);	  
		return calculatedhash;  
	}

}


