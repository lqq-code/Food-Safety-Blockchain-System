package edu.smxy.warehs;

import java.io.*;
import edu.smxy.db.CMDUs;

public class FileCopy extends Thread {
	private String ta;
	private File file;
	public FileCopy(String ta,File file) {
		this.ta=ta;
		this.file=file;
	}
	@Override
	public void run() {
		CMDUs.export("blockchain", "t_" + ta, file);
	}
}
