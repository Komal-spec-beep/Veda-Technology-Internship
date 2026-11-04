package day35.businessservicemanagement;
import java.util.ArrayList;

public class BusinessManagementSystem {

	public BusinessManagementSystem() {
	    // Default constructor
	}
	
	public void addProgram(Program program) {
	    programs.add(program);
	    System.out.println("Program added successfully!");
	}
	
	public void displayPrograms() {
	    for (Program program : programs) {
	        System.out.println(program);
	    }
	}
	
	public void addService(Service service) {
	    services.add(service);
	    System.out.println("Service added successfully!");
	}
	
	public void displayServices() {
	    for (Service service : services) {
	        System.out.println(service);
	    }
	}
	
	public void addCustomer(Customer customer) {
	    customers.add(customer);
	    System.out.println("Customer added successfully!");
	}
	
	public void displayCustomers() {
	    for (Customer customer : customers) {
	        System.out.println(customer);
	    }
	}
	
	public void addInquiry(Inquiry inquiry) {
	    inquiries.add(inquiry);
	    System.out.println("Inquiry added successfully!");
	}
	
	public void displayInquiries() {
	    for (Inquiry inquiry : inquiries) {
	        System.out.println(inquiry);
	    }
	}
	
	public void addServiceRequest(ServiceRequest request) {
	    serviceRequests.add(request);
	    System.out.println("Service request added successfully!");
	}
	
	public void displayServiceRequests() {
	    for (ServiceRequest request : serviceRequests) {
	        System.out.println(request);
	    }
	}
	
	public Customer searchCustomerById(int customerId) {
	    for (Customer customer : customers) {
	        if (customer.getCustomerId() == customerId) {
	            return customer;
	        }
	    }

	    return null;
	}
	
	public Service searchServiceById(int serviceId) {
	    for (Service service : services) {
	        if (service.getServiceId() == serviceId) {
	            return service;
	        }
	    }

	    return null;
	}
	
	public Program searchProgramByName(String programName) {
	    for (Program program : programs) {
	        if (program.getProgramName().equalsIgnoreCase(programName)) {
	            return program;
	        }
	    }

	    return null;
	}
	
	public Inquiry searchInquiryById(int inquiryId) {
	    for (Inquiry inquiry : inquiries) {
	        if (inquiry.getInquiryId() == inquiryId) {
	            return inquiry;
	        }
	    }

	    return null;
	}
	
	public ServiceRequest searchServiceRequestById(int requestId) {
	    for (ServiceRequest request : serviceRequests) {
	        if (request.getRequestId() == requestId) {
	            return request;
	        }
	    }

	    return null;
	}
	
	public boolean updateInquiryStatus(int inquiryId, String newStatus) {
	    Inquiry inquiry = searchInquiryById(inquiryId);

	    if (inquiry != null) {
	        inquiry.setStatus(newStatus);
	        return true;
	    }

	    return false;
	}
	
	public boolean updateServiceRequestStatus(int requestId, String newStatus) {
	    ServiceRequest request = searchServiceRequestById(requestId);

	    if (request != null) {
	        request.setStatus(newStatus);
	        return true;
	    }

	    return false;
	}
	
	public ArrayList<Customer> searchCustomersByName(String name) {
	    ArrayList<Customer> results = new ArrayList<>();

	    for (Customer customer : customers) {
	        if (customer.getCustomerName().toLowerCase().contains(name.toLowerCase())) {
	            results.add(customer);
	        }
	    }

	    return results;
	}
	
	public ArrayList<Service> searchServicesByName(String name) {
	    ArrayList<Service> results = new ArrayList<>();

	    for (Service service : services) {
	        if (service.getServiceName().toLowerCase().contains(name.toLowerCase())) {
	            results.add(service);
	        }
	    }

	    return results;
	}
	
	public ArrayList<Program> searchProgramsByName(String name) {
	    ArrayList<Program> results = new ArrayList<>();

	    for (Program program : programs) {
	        if (program.getProgramName().toLowerCase().contains(name.toLowerCase())) {
	            results.add(program);
	        }
	    }

	    return results;
	}
	
	public void generateReport() {
	    System.out.println("\n===== BUSINESS MANAGEMENT REPORT =====");
	    System.out.println("Total Programs: " + programs.size());
	    System.out.println("Total Services: " + services.size());
	    System.out.println("Total Customers: " + customers.size());
	    System.out.println("Total Inquiries: " + inquiries.size());
	    System.out.println("Total Service Requests: " + serviceRequests.size());
	}
	
	public void displayDashboard() {
	    System.out.println("\n===== BUSINESS MANAGEMENT DASHBOARD =====");
	    System.out.println("Programs: " + programs.size());
	    System.out.println("Services: " + services.size());
	    System.out.println("Customers: " + customers.size());
	    System.out.println("Inquiries: " + inquiries.size());
	    System.out.println("Service Requests: " + serviceRequests.size());
	}
	
	private ArrayList<Program> programs = new ArrayList<>();
	private ArrayList<Service> services = new ArrayList<>();
	private ArrayList<Customer> customers = new ArrayList<>();
	private ArrayList<Inquiry> inquiries = new ArrayList<>();
	private ArrayList<ServiceRequest> serviceRequests = new ArrayList<>();
}
