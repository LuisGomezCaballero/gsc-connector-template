package net.atos.mcs.gscconnectortemplate.domain;

public class TemplateRequest {

	private int myInt;

	public TemplateRequest() {
		super();
	}

	public TemplateRequest(int myInt) {
		super();
		this.myInt = myInt;
	}

	public int getMyInt() {
		return myInt;
	}

	public void setMyInt(int myInt) {
		this.myInt = myInt;
	}

	@Override
	public String toString() {
		return "TemplateResponse [myInt=" + myInt + "]";
	}

}
