package edu.smxy.info.i;

public class tinfo {
	private String name;
	private String pz;
	private String cd;
	private String rlsj;

	public tinfo() {
		super();
	}

	public tinfo(String name, String pz, String cd,String rlsj) {
		super();
		this.name=name;
		this.pz=pz;
		this.cd=cd;
		this.rlsj=rlsj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPz() {
		return pz;
	}

	public void setPz(String pz) {
		this.pz = pz;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getRlsj() {
		return rlsj;
	}

	public void setRlsj(String rlsj) {
		this.rlsj = rlsj;
	}

	@Override
	public String toString() {
		return "tinfo [name=" + name + ", pz=" + pz + ", cd=" + cd + ", rlsj="
				+ rlsj + "]";
	}
	
}
