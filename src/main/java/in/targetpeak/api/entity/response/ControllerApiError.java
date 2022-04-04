package in.targetpeak.api.entity.response;

public class ControllerApiError {
	String txtHeader;
	String txtCardTitle;
	String txtCardText;

	public ControllerApiError() {
		super();
	}

	public ControllerApiError(String txtHeader, String txtCardTitle, String txtCardText) {
		super();
		this.txtHeader = txtHeader;
		this.txtCardTitle = txtCardTitle;
		this.txtCardText = txtCardText;
	}

	public String getTxtHeader() {
		return txtHeader;
	}

	public void setTxtHeader(String txtHeader) {
		this.txtHeader = txtHeader;
	}

	public String getTxtCardTitle() {
		return txtCardTitle;
	}

	public void setTxtCardTitle(String txtCardTitle) {
		this.txtCardTitle = txtCardTitle;
	}

	public String getTxtCardText() {
		return txtCardText;
	}

	public void setTxtCardText(String txtCardText) {
		this.txtCardText = txtCardText;
	}

	@Override
	public String toString() {
		return "ControllerApiError [txtHeader=" + txtHeader + ", txtCardTitle=" + txtCardTitle + ", txtCardText="
				+ txtCardText + "]";
	}

}
