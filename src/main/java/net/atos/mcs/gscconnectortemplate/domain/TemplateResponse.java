package net.atos.mcs.gscconnectortemplate.domain;

public class TemplateResponse {

	private String myString;

	public TemplateResponse() {
		super();
	}

	public TemplateResponse(String myString) {
		super();
		this.myString = myString;
	}

	public String getMyString() {
		return myString;
	}

	public void setMyString(String myString) {
		this.myString = myString;
	}

	@Override
	public String toString() {
		return "TemplateRequest [myString=" + myString + "]";
	}

}
