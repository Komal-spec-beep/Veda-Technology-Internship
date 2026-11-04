package day35.businessservicemanagement;

public class ServiceRequest {

	public ServiceRequest(int requestId, Customer customer, Service service, String requestDate, String status) {
		super();
		this.requestId = requestId;
		this.customer = customer;
		this.service = service;
		this.requestDate = requestDate;
		this.status = status;
	}
	private int requestId;
	private Customer customer;
	private Service service;
	private String requestDate;
	private String status;
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public Customer getCustomer() {
		return customer;
	}
	@Override
	public String toString() {
		return "ServiceRequest [requestId=" + requestId + ", customer=" + customer + ", service=" + service
				+ ", requestDate=" + requestDate + ", status=" + status + "]";
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
