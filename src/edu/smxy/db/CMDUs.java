package edu.smxy.db;

import java.io.File;
import java.io.IOException;
public class CMDUs {
	public static void getCommand(String cmd){
		try{Runtime.getRuntime().exec(cmd);
		} catch (Exception e) {e.printStackTrace();}
	}
	public static void export(String database,String table,File f){
		String path="C:\\Program Files\\MySQL\\MySQL Server 5.5\\bin";
		String cmd = "cmd /c c:&cd "+path+"&mysqldump -hlocalhost -P3306 -uroot -p123456 "+database+" "+table+">"+f;
		CMDUs.getCommand(cmd);
	}
	public static void inport(String database,File f){
		String path="C:\\Program Files\\MySQL\\MySQL Server 5.5\\bin";
		String cmd = "cmd /c c:&cd "+path+"&mysql -hlocalhost -P3306 -uroot -p123456 "+database+"<"+f;
		CMDUs.getCommand(cmd);
	}
}
