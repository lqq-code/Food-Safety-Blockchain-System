package edu.smxy.warehs;

import java.io.File;
import edu.smxy.db.CMDUs;
public class WareHs extends Thread {
	private String ta;
	private int length;
	private String hash1;
	private String hash2;
	public WareHs(String ta,int length,String hash1,String hash2) {
		this.ta=ta;
		this.length=length;
		this.hash1=hash1;
		this.hash2=hash2;
	}
	@Override
	public void run() {
		//首先肯定是关闭文件的写入，打入名单
		File file = new File("c:/BlockChain/"+ ta + ".sql");
		Thread t1=new FileCopy(ta,file);
		t1.start();
		//执行完
		BagDao d=new BagDao();
		d.createTable();
		Bag bag=new Bag(ta,length,hash1,hash2);
		d.insert(bag);
	}
}
