package edu.smxy.pp;

public class Px implements Comparable<Px>{
	private String id,pz,cd,rlsj;
	private int step;
	public Px() {
		super();
		// TODO Auto-generated constructor stub
	} 
	public Px(String id,int step,String pz,String cd,String rlsj){
		this.id=id;
		this.step=step;
		this.pz=pz;
		this.cd=cd;
		this.rlsj=rlsj;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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


	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}

	@Override
	public int compareTo(Px arg0) {
			// TODO Auto-generated method stub
			if(this.step>arg0.step)
				return -1;
			else if(this.step<arg0.step)
				return 1;
			return 0;
	}
	
}