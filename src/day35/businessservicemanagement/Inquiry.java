package day35.businessservicemanagement;

public class Inquiry {

	public Inquiry(int inquiryId, Customer customer, String message, String inquiryDate, String status) {
		super();
		this.inquiryId = inquiryId;
		this.customer = customer;
		this.message = message;
		this.inquiryDate = inquiryDate;
		this.status = status;
	}
	private int inquiryId;
	private Customer customer;
	private String message;
	private String inquiryDate;
	private String status;
	public int getInquiryId() {
		return inquiryId;
	}
	public void setInquiryId(int inquiryId) {
		this.inquiryId = inquiryId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getInquiryDate() {
		return inquiryDate;
	}
	public void setInquiryDate(String inquiryDate) {
		this.inquiryDate = inquiryDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
	    return "Inquiry [inquiryId=" + inquiryId
	            + ", customer=" + customer
	            + ", message=" + message
	            + ", inquiryDate=" + inquiryDate
	            + ", status=" + status + "]";
	}
	
}
