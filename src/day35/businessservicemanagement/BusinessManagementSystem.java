package day35.businessservicemanagement;

import java.util.ArrayList;

public class BusinessManagementSystem {

    private ArrayList<Program> programs = new ArrayList<>();
    private ArrayList<Service> services = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Inquiry> inquiries = new ArrayList<>();
    private ArrayList<ServiceRequest> serviceRequests = new ArrayList<>();

    public BusinessManagementSystem() {
        // Default constructor
    }

    // Add Program
    public void addProgram(Program program) {
        if (searchProgramByName(program.getProgramName()) != null) {
            System.out.println("Program already exists!");
            return;
        }

        programs.add(program);
        System.out.println("Program added successfully!");
    }

    // Display Programs
    public void displayPrograms() {
        for (Program program : programs) {
            System.out.println(program);
        }
    }

    // Display Services
    public void displayServices() {
        for (Service service : services) {
            System.out.println(service);
        }
    }

    // Add Customer
    public void addCustomer(Customer customer) {

        for (Customer existingCustomer : customers) {

            if (existingCustomer.getEmail().equalsIgnoreCase(customer.getEmail())) {
                System.out.println("Customer email already exists!");
                return;
            }

            if (existingCustomer.getPhone().equals(customer.getPhone())) {
                System.out.println("Customer phone number already exists!");
                return;
            }
        }

        if (searchCustomerById(customer.getCustomerId()) != null) {
            System.out.println("Customer ID already exists!");
            return;
        }

        customers.add(customer);
        System.out.println("Customer added successfully!");
    }

    // Display Customers
    public void displayCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    // Add Inquiry
    public void addInquiry(Inquiry inquiry) {

        if (searchInquiryById(inquiry.getInquiryId()) != null) {
            System.out.println("Inquiry ID already exists!");
            return;
        }

        inquiries.add(inquiry);
        System.out.println("Inquiry added successfully!");
    }

    // Display Inquiries
    public void displayInquiries() {
        for (Inquiry inquiry : inquiries) {
            System.out.println(inquiry);
        }
    }

    // Add Service
    public void addService(Service service) {

        for (Service existingService : services) {

            if (existingService.getServiceName().equalsIgnoreCase(service.getServiceName())) {
                System.out.println("Service name already exists!");
                return;
            }
        }

        if (searchServiceById(service.getServiceId()) != null) {
            System.out.println("Service ID already exists!");
            return;
        }

        services.add(service);
        System.out.println("Service added successfully!");
    }

    // Display Service Requests
    public void displayServiceRequests() {
        for (ServiceRequest request : serviceRequests) {
            System.out.println(request);
        }
    }

    // Add Service Request
    public void addServiceRequest(ServiceRequest request) {

        if (searchServiceRequestById(request.getRequestId()) != null) {
            System.out.println("Service Request ID already exists!");
            return;
        }

        serviceRequests.add(request);
        System.out.println("Service request added successfully!");
    }

    // Search Customer by ID
    public Customer searchCustomerById(int customerId) {

        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }

        return null;
    }

    // Search Service by ID
    public Service searchServiceById(int serviceId) {

        for (Service service : services) {
            if (service.getServiceId() == serviceId) {
                return service;
            }
        }

        return null;
    }

    // Search Program by Exact Name
    public Program searchProgramByName(String programName) {

        for (Program program : programs) {

            if (program.getProgramName() != null &&
                programName != null &&
                program.getProgramName().equalsIgnoreCase(programName)) {

                return program;
            }
        }

        return null;
    }

    // Search Programs by Name
    public ArrayList<Program> searchProgramsByName(String name) {

        ArrayList<Program> results = new ArrayList<>();

        for (Program program : programs) {

            if (program.getProgramName() != null &&
                name != null &&
                program.getProgramName().toLowerCase().contains(name.toLowerCase())) {

                results.add(program);
            }
        }

        return results;
    }

    // Search Inquiry by ID
    public Inquiry searchInquiryById(int inquiryId) {

        for (Inquiry inquiry : inquiries) {
            if (inquiry.getInquiryId() == inquiryId) {
                return inquiry;
            }
        }

        return null;
    }

    // Search Service Request by ID
    public ServiceRequest searchServiceRequestById(int requestId) {

        for (ServiceRequest request : serviceRequests) {
            if (request.getRequestId() == requestId) {
                return request;
            }
        }

        return null;
    }

    // Update Inquiry Status
    public boolean updateInquiryStatus(int inquiryId, String newStatus) {

        Inquiry inquiry = searchInquiryById(inquiryId);

        if (inquiry != null &&
        		(newStatus.equalsIgnoreCase("Pending") ||
        				newStatus.equalsIgnoreCase("In Progress") ||
        				newStatus.equalsIgnoreCase("Resolved") ||
        				newStatus.equalsIgnoreCase("Closed"))) {
            inquiry.setStatus(newStatus);
            return true;
        }

        return false;
    }

    // Update Service Request Status
    public boolean updateServiceRequestStatus(int requestId, String newStatus) {

        ServiceRequest request = searchServiceRequestById(requestId);

        if (request != null &&
            (newStatus.equalsIgnoreCase("Pending") ||
             newStatus.equalsIgnoreCase("In Progress") ||
             newStatus.equalsIgnoreCase("Completed") ||
             newStatus.equalsIgnoreCase("Cancelled"))) {

            request.setStatus(newStatus);
            return true;
        }

        return false;
    }

    // Search Customers by Name
    public ArrayList<Customer> searchCustomersByName(String name) {

        ArrayList<Customer> results = new ArrayList<>();

        for (Customer customer : customers) {

            if (customer.getCustomerName() != null &&
                name != null &&
                customer.getCustomerName().toLowerCase().contains(name.toLowerCase())) {

                results.add(customer);
            }
        }

        return results;
    }

    // Search Services by Name
    public ArrayList<Service> searchServicesByName(String name) {

        ArrayList<Service> results = new ArrayList<>();

        for (Service service : services) {

            if (service.getServiceName() != null &&
                name != null &&
                service.getServiceName().toLowerCase().contains(name.toLowerCase())) {

                results.add(service);
            }
        }

        return results;
    }

    // Generate Report
    public void generateReport() {

        System.out.println("\n===== BUSINESS MANAGEMENT REPORT =====");

        System.out.println("Total Programs: " + programs.size());
        System.out.println("Total Services: " + services.size());
        System.out.println("Total Customers: " + customers.size());
        System.out.println("Total Inquiries: " + inquiries.size());
        System.out.println("Total Service Requests: " + serviceRequests.size());
    }

    // Display Dashboard
    public void displayDashboard() {

        System.out.println("\n===== BUSINESS MANAGEMENT DASHBOARD =====");

        System.out.println("Programs: " + programs.size());
        System.out.println("Services: " + services.size());
        System.out.println("Customers: " + customers.size());
        System.out.println("Inquiries: " + inquiries.size());
        System.out.println("Service Requests: " + serviceRequests.size());
    }

    // Filter Inquiries by Status
    public void filterInquiriesByStatus(String status) {

        boolean found = false;

        for (Inquiry inquiry : inquiries) {

            if (status.equalsIgnoreCase(inquiry.getStatus())) {
                System.out.println(inquiry);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No inquiries found with status: " + status);
        }
    }

    // Filter Service Requests by Status
    public void filterServiceRequestsByStatus(String status) {

        boolean found = false;

        for (ServiceRequest request : serviceRequests) {

            if (status.equalsIgnoreCase(request.getStatus())) {
                System.out.println(request);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No service requests found with status: " + status);
        }
    }

    // Filter Services by Category
    public void filterServicesByCategory(String category) {

        boolean found = false;

        for (Service service : services) {

            if (category.equalsIgnoreCase(service.getCategory())) {
                System.out.println(service);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No services found in category: " + category);
        }
    }
}