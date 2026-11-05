
package day35.businessservicemanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BusinessManagementSystem system = new BusinessManagementSystem();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== BUSINESS & SERVICE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Training Program");
            System.out.println("2. Add Internship Program");
            System.out.println("3. Display Programs");
            System.out.println("4. Add Service");
            System.out.println("5. Display Services");
            System.out.println("6. Add Customer");
            System.out.println("7. Display Customers");
            System.out.println("8. Add Inquiry");
            System.out.println("9. Display Inquiries");
            System.out.println("10. Update Inquiry Status");
            System.out.println("11. Add Service Request");
            System.out.println("12. Display Service Requests");
            System.out.println("13. Update Service Request Status");
            System.out.println("14. Search Records");
            System.out.println("15. Generate Report");
            System.out.println("17. Filter Inquiries by Status");
            System.out.println("18. Filter Service Requests by Status");
            System.out.println("19. Filter Services by Category");
            System.out.println("20. Exit");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addTrainingProgram();
                    break;

                case 2:
                    addInternshipProgram();
                    break;

                case 3:
                    system.displayPrograms();
                    break;

                case 4:
                    addService();
                    break;

                case 5:
                    system.displayServices();
                    break;

                case 6:
                    addCustomer();
                    break;

                case 7:
                    system.displayCustomers();
                    break;

                case 8:
                    addInquiry();
                    break;

                case 9:
                    system.displayInquiries();
                    break;

                case 10:
                    updateInquiryStatus();
                    break;

                case 11:
                    addServiceRequest();
                    break;

                case 12:
                    system.displayServiceRequests();
                    break;

                case 13:
                    updateServiceRequestStatus();
                    break;

                case 14:
                    searchRecords();
                    break;

                case 15:
                    system.generateReport();
                    break;

                case 20:
                    System.out.println("Thank you for using the system!");
                    break;
                    
                case 17:
                    String inquiryStatus = readText("Enter inquiry status: ");
                    system.filterInquiriesByStatus(inquiryStatus);
                    break;

                case 18:
                    String requestStatus = readText("Enter service request status: ");
                    system.filterServiceRequestsByStatus(requestStatus);
                    break;

                case 19:
                    String category = readText("Enter service category: ");
                    system.filterServicesByCategory(category);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 20);

        sc.close();
    }

    // Add Training Program
    public static void addTrainingProgram() {

        String name = readText("Enter program name: ");
        double fee = readDouble("Enter fee: ");
        String duration = readText("Enter duration: ");
        String trainer = readText("Enter trainer name: ");
        int seats = readInt("Enter available seats: ");

        TrainingProgram program = new TrainingProgram(
                name, fee, duration, trainer, seats);

        system.addProgram(program);
    }

    // Add Internship Program
    public static void addInternshipProgram() {

        String name = readText("Enter program name: ");
        double fee = readDouble("Enter fee: ");
        String duration = readText("Enter duration: ");
        String mentor = readText("Enter mentor name: ");
        double stipend = readDouble("Enter stipend: ");

        InternshipProgram program = new InternshipProgram(
                name, fee, duration, mentor, stipend);

        system.addProgram(program);
    }

    // Add Service
    public static void addService() {

        int id = readInt("Enter service ID: ");
        String name = readText("Enter service name: ");
        String description = readText("Enter description: ");
        double price = readDouble("Enter price: ");
        String category = readText("Enter service category: ");

        Service service = new Service(id, name, description, price, category);

        system.addService(service);
    }

    // Add Customer
    public static void addCustomer() {

        int id = readInt("Enter customer ID: ");
        String name = readText("Enter customer name: ");
        String email = readText("Enter email: ");
        String phone = readText("Enter phone: ");

        Customer customer = new Customer(id, name, email, phone);

        system.addCustomer(customer);
    }

    // Add Inquiry
    public static void addInquiry() {

        int id = readInt("Enter inquiry ID: ");
        int customerId = readInt("Enter customer ID: ");

        Customer customer = system.searchCustomerById(customerId);

        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        String message = readText("Enter inquiry message: ");
        String date = readText("Enter inquiry date: ");
        String status = "Pending";

        Inquiry inquiry = new Inquiry(
                id, customer, message, date, status);

        system.addInquiry(inquiry);
    }

    // Update Inquiry Status
    public static void updateInquiryStatus() {

        int id = readInt("Enter inquiry ID: ");
        String status = readText("Enter new status: ");

        boolean updated = system.updateInquiryStatus(id, status);

        if (updated) {
            System.out.println("Inquiry status updated successfully!");
        } else {
            System.out.println("Inquiry not found!");
        }
    }

    // Add Service Request
    public static void addServiceRequest() {

        int requestId = readInt("Enter request ID: ");
        int customerId = readInt("Enter customer ID: ");

        Customer customer = system.searchCustomerById(customerId);

        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        int serviceId = readInt("Enter service ID: ");

        Service service = system.searchServiceById(serviceId);

        if (service == null) {
            System.out.println("Service not found!");
            return;
        }

        String date = readText("Enter request date: ");
        String status = "Pending";

        ServiceRequest request = new ServiceRequest(
                requestId, customer, service, date, status);

        system.addServiceRequest(request);
    }

    // Update Service Request Status
    public static void updateServiceRequestStatus() {

        int id = readInt("Enter request ID: ");
        String status = readText("Enter new status: ");

        boolean updated = system.updateServiceRequestStatus(id, status);

        if (updated) {
            System.out.println("Service request status updated successfully!");
        } else {
            System.out.println("Service request not found!");
        }
    }

    // Search Records
    public static void searchRecords() {

        System.out.println("\n===== SEARCH RECORDS =====");
        System.out.println("1. Search Customer by ID");
        System.out.println("2. Search Service by ID");
        System.out.println("3. Search Program by Name");
        System.out.println("4. Search Inquiry by ID");
        System.out.println("5. Search Service Request by ID");
        System.out.println("6. Search Customers by Name");
        System.out.println("7. Search Services by Name");
        System.out.println("8. Search Programs by Name");

        int choice = readInt("Enter your choice: ");

        switch (choice) {

            case 1: {
                int id = readInt("Enter customer ID: ");
                Customer customer = system.searchCustomerById(id);

                if (customer != null) {
                    System.out.println(customer);
                } else {
                    System.out.println("Customer not found!");
                }
                break;
            }

            case 2: {
                int id = readInt("Enter service ID: ");
                Service service = system.searchServiceById(id);

                if (service != null) {
                    System.out.println(service);
                } else {
                    System.out.println("Service not found!");
                }
                break;
            }

            case 3: {
                String name = readText("Enter program name: ");
                Program program = system.searchProgramByName(name);

                if (program != null) {
                    System.out.println(program);
                } else {
                    System.out.println("Program not found!");
                }
                break;
            }

            case 4: {
                int id = readInt("Enter inquiry ID: ");
                Inquiry inquiry = system.searchInquiryById(id);

                if (inquiry != null) {
                    System.out.println(inquiry);
                } else {
                    System.out.println("Inquiry not found!");
                }
                break;
            }

            case 5: {
                int id = readInt("Enter request ID: ");
                ServiceRequest request =
                        system.searchServiceRequestById(id);

                if (request != null) {
                    System.out.println(request);
                } else {
                    System.out.println("Service request not found!");
                }
                break;
            }

            case 6: {
                String name = readText("Enter customer name: ");
                ArrayList<Customer> results =
                        system.searchCustomersByName(name);

                if (results.isEmpty()) {
                    System.out.println("No matching customers found!");
                } else {
                    for (Customer customer : results) {
                        System.out.println(customer);
                    }
                }
                break;
            }

            case 7: {
                String name = readText("Enter service name: ");
                ArrayList<Service> results =
                        system.searchServicesByName(name);

                if (results.isEmpty()) {
                    System.out.println("No matching services found!");
                } else {
                    for (Service service : results) {
                        System.out.println(service);
                    }
                }
                break;
            }

            case 8: {
                String name = readText("Enter program name: ");
                ArrayList<Program> results =
                        system.searchProgramsByName(name);

                if (results.isEmpty()) {
                    System.out.println("No matching programs found!");
                } else {
                    for (Program program : results) {
                        System.out.println(program);
                    }
                }
                break;
            }

            default:
                System.out.println("Invalid search choice!");
        }
    }

    // Read Integer
    public static int readInt(String message) {

        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer!");
            }
        }
    }

    // Read Double
    public static double readDouble(String message) {

        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    // Read Text
    public static String readText(String message) {

        while (true) {
            System.out.print(message);
            String value = sc.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("Input cannot be empty!");
        }
    }
}
