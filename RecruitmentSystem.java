// RecruitmentSystem.java
package recruitment.system;

import java.util.*;

// JobPosting Class
class JobPosting {
    private String jobId;
    private String title;
    private String department;
    private String description;
    private boolean isActive;

    public JobPosting(String jobId, String title, String department, String description) {
        this.jobId = jobId;
        this.title = title;
        this.department = department;
        this.description = description;
        this.isActive = true;
    }

    public String getJobId() {
        return jobId;
    }

    public String getTitle() {
        return title;
    }

    public String getDepartment() {
        return department;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Job ID: " + jobId + ", Title: " + title + 
               ", Department: " + department + ", Status: " + (isActive ? "Active" : "Inactive");
    }
}

// Applicant Class
class Applicant {
    private String applicantId;
    private String name;
    private String email;
    private String phone;
    private String resume;

    public Applicant(String applicantId, String name, String email, String phone, String resume) {
        this.applicantId = applicantId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.resume = resume;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getResume() {
        return resume;
    }

    @Override
    public String toString() {
        return "Applicant ID: " + applicantId + ", Name: " + name + 
               ", Email: " + email + ", Phone: " + phone;
    }
}

// Application Class
class Application {
    private String applicationId;
    private Applicant applicant;
    private JobPosting jobPosting;
    private String status; // applied, interview, offer, onboarding, employee, rejected
    private String applicationDate;

    public Application(String applicationId, Applicant applicant, JobPosting jobPosting, String applicationDate) {
        this.applicationId = applicationId;
        this.applicant = applicant;
        this.jobPosting = jobPosting;
        this.status = "applied";
        this.applicationDate = applicationDate;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public JobPosting getJobPosting() {
        return jobPosting;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public boolean isActive() {
        return status.equals("applied") || status.equals("interview");
    }

    @Override
    public String toString() {
        return "Application ID: " + applicationId + ", Applicant: " + applicant.getName() +
               ", Job: " + jobPosting.getTitle() + ", Status: " + status + 
               ", Date: " + applicationDate;
    }
}

// Interview Class
class Interview {
    private String interviewId;
    private Application application;
    private String interviewDate;
    private String interviewTime;
    private String interviewer;
    private String result; // pending, successful, unsuccessful

    public Interview(String interviewId, Application application, 
                    String interviewDate, String interviewTime, String interviewer) {
        this.interviewId = interviewId;
        this.application = application;
        this.interviewDate = interviewDate;
        this.interviewTime = interviewTime;
        this.interviewer = interviewer;
        this.result = "pending";
    }

    public String getInterviewId() {
        return interviewId;
    }

    public Application getApplication() {
        return application;
    }

    public String getInterviewDate() {
        return interviewDate;
    }

    public String getInterviewTime() {
        return interviewTime;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Interview ID: " + interviewId + ", Applicant: " + 
               application.getApplicant().getName() + ", Date: " + interviewDate +
               ", Time: " + interviewTime + ", Interviewer: " + interviewer + 
               ", Result: " + result;
    }
}

// Offer Class
class Offer {
    private String offerId;
    private Application application;
    private double salary;
    private String position;
    private String offerDate;
    private String status; // pending, accepted, rejected

    public Offer(String offerId, Application application, double salary, 
                String position, String offerDate) {
        this.offerId = offerId;
        this.application = application;
        this.salary = salary;
        this.position = position;
        this.offerDate = offerDate;
        this.status = "pending";
    }

    public String getOfferId() {
        return offerId;
    }

    public Application getApplication() {
        return application;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public String getOfferDate() {
        return offerDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Offer ID: " + offerId + ", Applicant: " + 
               application.getApplicant().getName() + ", Position: " + position +
               ", Salary: " + salary + ", Date: " + offerDate + ", Status: " + status;
    }
}

// OnboardingTask Class
class OnboardingTask {
    private String taskId;
    private Offer offer;
    private String taskDescription;
    private boolean isCompleted;
    private String assignedDate;

    public OnboardingTask(String taskId, Offer offer, String taskDescription, String assignedDate) {
        this.taskId = taskId;
        this.offer = offer;
        this.taskDescription = taskDescription;
        this.isCompleted = false;
        this.assignedDate = assignedDate;
    }

    public String getTaskId() {
        return taskId;
    }

    public Offer getOffer() {
        return offer;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getAssignedDate() {
        return assignedDate;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId + ", Applicant: " + 
               offer.getApplication().getApplicant().getName() + 
               ", Description: " + taskDescription + ", Status: " + 
               (isCompleted ? "Completed" : "Pending") + ", Date: " + assignedDate;
    }
}

// Employee Class
class Employee {
    private String employeeId;
    private Applicant applicant;
    private String position;
    private double salary;
    private String joiningDate;
    private String department;

    public Employee(String employeeId, Applicant applicant, String position, 
                   double salary, String joiningDate, String department) {
        this.employeeId = employeeId;
        this.applicant = applicant;
        this.position = position;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + applicant.getName() +
               ", Position: " + position + ", Department: " + department + 
               ", Salary: " + salary + ", Joining Date: " + joiningDate;
    }
}

// Main RecruitmentSystem Class
public class RecruitmentSystem {
    private List<JobPosting> jobPostings;
    private List<Applicant> applicants;
    private List<Application> applications;
    private List<Interview> interviews;
    private List<Offer> offers;
    private List<OnboardingTask> onboardingTasks;
    private List<Employee> employees;
    
    private Scanner scanner;
    
    public RecruitmentSystem() {
        jobPostings = new ArrayList<>();
        applicants = new ArrayList<>();
        applications = new ArrayList<>();
        interviews = new ArrayList<>();
        offers = new ArrayList<>();
        onboardingTasks = new ArrayList<>();
        employees = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    // Add Job Posting
    public void addJob() {
        System.out.println("\n=== Add New Job Posting ===");
        System.out.print("Enter Job ID: ");
        String jobId = scanner.nextLine();
        
        if (jobId.trim().isEmpty()) {
            System.out.println("Error: Job ID cannot be empty!");
            return;
        }
        
        System.out.print("Enter Job Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Job Description: ");
        String description = scanner.nextLine();
        
        JobPosting job = new JobPosting(jobId, title, department, description);
        jobPostings.add(job);
        System.out.println("✓ Job posting added successfully!");
    }
    
    // Add Applicant
    public void addApplicant() {
        System.out.println("\n=== Add New Applicant ===");
        System.out.print("Enter Applicant ID: ");
        String applicantId = scanner.nextLine();
        
        if (applicantId.trim().isEmpty()) {
            System.out.println("Error: Applicant ID cannot be empty!");
            return;
        }
        
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Resume Details: ");
        String resume = scanner.nextLine();
        
        Applicant applicant = new Applicant(applicantId, name, email, phone, resume);
        applicants.add(applicant);
        System.out.println("✓ Applicant added successfully!");
    }
    
    // Apply for Job
    public void applyForJob() {
        System.out.println("\n=== Apply for Job ===");
        
        if (applicants.isEmpty()) {
            System.out.println("Error: No applicants available. Add applicant first!");
            return;
        }
        
        if (jobPostings.isEmpty()) {
            System.out.println("Error: No job postings available. Add job first!");
            return;
        }
        
        System.out.println("\nAvailable Applicants:");
        for (int i = 0; i < applicants.size(); i++) {
            System.out.println((i + 1) + ". " + applicants.get(i));
        }
        
        System.out.print("Select Applicant (1-" + applicants.size() + "): ");
        int applicantChoice = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (applicantChoice < 0 || applicantChoice >= applicants.size()) {
            System.out.println("Error: Invalid applicant selection!");
            return;
        }
        
        System.out.println("\nAvailable Job Postings:");
        List<JobPosting> activeJobs = new ArrayList<>();
        for (JobPosting job : jobPostings) {
            if (job.isActive()) {
                activeJobs.add(job);
                System.out.println(activeJobs.size() + ". " + job);
            }
        }
        
        if (activeJobs.isEmpty()) {
            System.out.println("Error: No active job postings available!");
            return;
        }
        
        System.out.print("Select Job Posting (1-" + activeJobs.size() + "): ");
        int jobChoice = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (jobChoice < 0 || jobChoice >= activeJobs.size()) {
            System.out.println("Error: Invalid job selection!");
            return;
        }
        
        System.out.print("Enter Application Date (DD-MM-YYYY): ");
        String date = scanner.nextLine();
        
        String applicationId = "APP" + (applications.size() + 1);
        Application application = new Application(applicationId, 
                                                 applicants.get(applicantChoice), 
                                                 activeJobs.get(jobChoice), date);
        applications.add(application);
        System.out.println("✓ Application submitted successfully! Application ID: " + applicationId);
    }
    
    // Schedule Interview
    public void scheduleInterview() {
        System.out.println("\n=== Schedule Interview ===");
        
        List<Application> activeApplications = new ArrayList<>();
        for (Application app : applications) {
            if (app.isActive() && app.getStatus().equals("applied")) {
                activeApplications.add(app);
            }
        }
        
        if (activeApplications.isEmpty()) {
            System.out.println("Error: No active applications available for interview!");
            return;
        }
        
        System.out.println("\nActive Applications:");
        for (int i = 0; i < activeApplications.size(); i++) {
            System.out.println((i + 1) + ". " + activeApplications.get(i));
        }
        
        System.out.print("Select Application (1-" + activeApplications.size() + "): ");
        int choice = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (choice < 0 || choice >= activeApplications.size()) {
            System.out.println("Error: Invalid selection!");
            return;
        }
        
        System.out.print("Enter Interview Date (DD-MM-YYYY): ");
        String date = scanner.nextLine();
        System.out.print("Enter Interview Time: ");
        String time = scanner.nextLine();
        System.out.print("Enter Interviewer Name: ");
        String interviewer = scanner.nextLine();
        
        String interviewId = "INT" + (interviews.size() + 1);
        Interview interview = new Interview(interviewId, activeApplications.get(choice), 
                                           date, time, interviewer);
        interviews.add(interview);
        
        activeApplications.get(choice).setStatus("interview");
        System.out.println("✓ Interview scheduled successfully! Interview ID: " + interviewId);
    }
    
    // Issue Offer
    public void issueOffer() {
        System.out.println("\n=== Issue Offer ===");
        
        List<Interview> successfulInterviews = new ArrayList<>();
        for (Interview interview : interviews) {
            if (interview.getResult().equals("successful")) {
                successfulInterviews.add(interview);
            }
        }
        
        if (successfulInterviews.isEmpty()) {
            System.out.println("Error: No successful interviews available!");
            System.out.println("Tip: First mark interviews as successful.");
            return;
        }
        
        System.out.println("\nSuccessful Interviews:");
        for (int i = 0; i < successfulInterviews.size(); i++) {
            System.out.println((i + 1) + ". " + successfulInterviews.get(i));
        }
        
        System.out.print("Select Interview (1-" + successfulInterviews.size() + "): ");
        int choice = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (choice < 0 || choice >= successfulInterviews.size()) {
            System.out.println("Error: Invalid selection!");
            return;
        }
        
        System.out.print("Enter Position: ");
        String position = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Offer Date (DD-MM-YYYY): ");
        String date = scanner.nextLine();
        
        String offerId = "OFR" + (offers.size() + 1);
        Offer offer = new Offer(offerId, successfulInterviews.get(choice).getApplication(), 
                               salary, position, date);
        offers.add(offer);
        
        successfulInterviews.get(choice).getApplication().setStatus("offer");
        System.out.println("✓ Offer issued successfully! Offer ID: " + offerId);
    }
    
    // Accept or Reject Offer
    public void respondToOffer() {
        System.out.println("\n=== Accept/Reject Offer ===");
        
        List<Offer> pendingOffers = new ArrayList<>();
        for (Offer offer : offers) {
            if (offer.getStatus().equals("pending")) {
                pendingOffers.add(offer);
            }
        }
        
        if (pendingOffers.isEmpty()) {
            System.out.println("Error: No pending offers available!");
            return;
        }
        
        System.out.println("\nPending Offers:");
        for (int i = 0; i < pendingOffers.size(); i++) {
            System.out.println((i + 1) + ". " + pendingOffers.get(i));
        }
        
        System.out.print("Select Offer (1-" + pendingOffers.size() + "): ");
        int choice = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (choice < 0 || choice >= pendingOffers.size()) {
            System.out.println("Error: Invalid selection!");
            return;
        }
        
        System.out.print("Accept or Reject? (A/R): ");
        String response = scanner.nextLine().toUpperCase();
        
        if (response.equals("A")) {
            pendingOffers.get(choice).setStatus("accepted");
            pendingOffers.get(choice).getApplication().setStatus("onboarding");
            System.out.println("✓ Offer accepted successfully!");
        } else if (response.equals("R")) {
            pendingOffers.get(choice).setStatus("rejected");
            pendingOffers.get(choice).getApplication().setStatus("rejected");
            System.out.println("✓ Offer rejected!");
        } else {
            System.out.println("Error: Invalid response!");
        }
    }
    
    // Create Onboarding Tasks
    public void createOnboardingTasks() {
        System.out.println("\n=== Create Onboarding Tasks ===");
        
        List<Offer> acceptedOffers = new ArrayList<>();
        for (Offer offer : offers) {
            if (offer.getStatus().equals("accepted")) {
                acceptedOffers.add(offer);
            }
        }
        
        if (acceptedOffers.isEmpty()) {
            System.out.println("Error: No accepted offers available!");
            return;
        }
        
        System.out.println("\nAccepted Offers:");
        for (int i = 0; i < acceptedOffers.size(); i++) {
            System.out.println((i + 1) + ". " + acceptedOffers.get(i));
        }
        
        System.out.print("Select Offer (1-" + acceptedOffers.size() + "): ");
        int choice = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (choice < 0 || choice >= acceptedOffers.size()) {
            System.out.println("Error: Invalid selection!");
            return;
        }
        
        System.out.print("Enter Task Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Assigned Date (DD-MM-YYYY): ");
        String date = scanner.nextLine();
        
        String taskId = "TASK" + (onboardingTasks.size() + 1);
        OnboardingTask task = new OnboardingTask(taskId, acceptedOffers.get(choice), 
                                                 description, date);
        onboardingTasks.add(task);
        System.out.println("✓ Onboarding task created successfully! Task ID: " + taskId);
    }
    
    // Convert to Employee
    public void convertToEmployee() {
        System.out.println("\n=== Convert to Employee ===");
        
        List<Application> onboardingApplications = new ArrayList<>();
        for (Application app : applications) {
            if (app.getStatus().equals("onboarding")) {
                boolean allTasksCompleted = true;
                for (OnboardingTask task : onboardingTasks) {
                    if (task.getOffer().getApplication().equals(app) && !task.isCompleted()) {
                        allTasksCompleted = false;
                        break;
                    }
                }
                if (allTasksCompleted) {
                    onboardingApplications.add(app);
                }
            }
        }
        
        if (onboardingApplications.isEmpty()) {
            System.out.println("Error: No applications ready for employee conversion!");
            System.out.println("Tip: Complete all onboarding tasks first.");
            return;
        }
        
        System.out.println("\nApplications Ready for Conversion:");
        for (int i = 0; i < onboardingApplications.size(); i++) {
            System.out.println((i + 1) + ". " + onboardingApplications.get(i));
        }
        
        System.out.print("Select Application (1-" + onboardingApplications.size() + "): ");
        int choice = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (choice < 0 || choice >= onboardingApplications.size()) {
            System.out.println("Error: Invalid selection!");
            return;
        }
        
        Application selectedApp = onboardingApplications.get(choice);
        
        Offer selectedOffer = null;
        for (Offer offer : offers) {
            if (offer.getApplication().equals(selectedApp)) {
                selectedOffer = offer;
                break;
            }
        }
        
        System.out.print("Enter Joining Date (DD-MM-YYYY): ");
        String joiningDate = scanner.nextLine();
        
        String employeeId = "EMP" + (employees.size() + 1);
        Employee employee = new Employee(employeeId, selectedApp.getApplicant(), 
                                        selectedOffer.getPosition(), 
                                        selectedOffer.getSalary(), 
                                        joiningDate, 
                                        selectedApp.getJobPosting().getDepartment());
        employees.add(employee);
        
        selectedApp.setStatus("employee");
        System.out.println("✓ Converted to employee successfully! Employee ID: " + employeeId);
    }
    
    // Show Application and Interview Summaries
    public void showSummaries() {
        System.out.println("\n=== Application & Interview Summaries ===");
        
        System.out.println("\n--- Applications Summary ---");
        if (applications.isEmpty()) {
            System.out.println("No applications available.");
        } else {
            for (Application app : applications) {
                System.out.println(app);
            }
        }
        
        System.out.println("\n--- Interviews Summary ---");
        if (interviews.isEmpty()) {
            System.out.println("No interviews scheduled.");
        } else {
            for (Interview interview : interviews) {
                System.out.println(interview);
            }
        }
    }
    
    // Show Offer Details
    public void showOfferDetails() {
        System.out.println("\n=== Offer Details ===");
        
        if (offers.isEmpty()) {
            System.out.println("No offers available.");
            return;
        }
        
        for (Offer offer : offers) {
            System.out.println(offer);
        }
    }
    
    // Show Onboarding Task List
    public void showOnboardingTasks() {
        System.out.println("\n=== Onboarding Task List ===");
        
        if (onboardingTasks.isEmpty()) {
            System.out.println("No onboarding tasks available.");
            return;
        }
        
        for (OnboardingTask task : onboardingTasks) {
            System.out.println(task);
        }
    }
    
    // Mark interview result
    public void markInterviewResult() {
        System.out.println("\n=== Mark Interview Result ===");
        
        List<Interview> pendingInterviews = new ArrayList<>();
        for (Interview interview : interviews) {
            if (interview.getResult().equals("pending")) {
                pendingInterviews.add(interview);
            }
        }
        
        if (pendingInterviews.isEmpty()) {
            System.out.println("Error: No pending interviews available!");
            return;
        }
        
        System.out.println("\nPending Interviews:");
        for (int i = 0; i < pendingInterviews.size(); i++) {
            System.out.println((i + 1) + ". " + pendingInterviews.get(i));
        }
        
        System.out.print("Select Interview (1-" + pendingInterviews.size() + "): ");
        int choice = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (choice < 0 || choice >= pendingInterviews.size()) {
            System.out.println("Error: Invalid selection!");
            return;
        }
        
        System.out.print("Result (successful/unsuccessful): ");
        String result = scanner.nextLine().toLowerCase();
        
        if (result.equals("successful") || result.equals("unsuccessful")) {
            pendingInterviews.get(choice).setResult(result);
            System.out.println("✓ Interview result updated!");
        } else {
            System.out.println("Error: Invalid result!");
        }
    }
    
    // Complete onboarding task
    public void completeOnboardingTask() {
        System.out.println("\n=== Complete Onboarding Task ===");
        
        List<OnboardingTask> pendingTasks = new ArrayList<>();
        for (OnboardingTask task : onboardingTasks) {
            if (!task.isCompleted()) {
                pendingTasks.add(task);
            }
        }
        
        if (pendingTasks.isEmpty()) {
            System.out.println("Error: No pending onboarding tasks!");
            return;
        }
        
        System.out.println("\nPending Onboarding Tasks:");
        for (int i = 0; i < pendingTasks.size(); i++) {
            System.out.println((i + 1) + ". " + pendingTasks.get(i));
        }
        
        System.out.print("Select Task to Complete (1-" + pendingTasks.size() + "): ");
        int choice = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (choice < 0 || choice >= pendingTasks.size()) {
            System.out.println("Error: Invalid selection!");
            return;
        }
        
        pendingTasks.get(choice).setCompleted(true);
        System.out.println("✓ Task marked as completed!");
    }
    
    public static void main(String[] args) {
        RecruitmentSystem system = new RecruitmentSystem();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n╔════════════════════════════════════════════════╗");
            System.out.println("║   RECRUITMENT & ONBOARDING SYSTEM              ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.println("1.  Add Job Posting");
            System.out.println("2.  Add Applicant");
            System.out.println("3.  Apply for Job");
            System.out.println("4.  Schedule Interview");
            System.out.println("5.  Mark Interview Result");
            System.out.println("6.  Issue Offer");
            System.out.println("7.  Accept/Reject Offer");
            System.out.println("8.  Create Onboarding Tasks");
            System.out.println("9.  Complete Onboarding Task");
            System.out.println("10. Convert to Employee");
            System.out.println("11. Show Application & Interview Summaries");
            System.out.println("12. Show Offer Details");
            System.out.println("13. Show Onboarding Tasks");
            System.out.println("14. Exit");
            System.out.println("════════════════════════════════════════════════");
            System.out.print("Enter your choice (1-14): ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1:
                        system.addJob();
                        break;
                    case 2:
                        system.addApplicant();
                        break;
                    case 3:
                        system.applyForJob();
                        break;
                    case 4:
                        system.scheduleInterview();
                        break;
                    case 5:
                        system.markInterviewResult();
                        break;
                    case 6:
                        system.issueOffer();
                        break;
                    case 7:
                        system.respondToOffer();
                        break;
                    case 8:
                        system.createOnboardingTasks();
                        break;
                    case 9:
                        system.completeOnboardingTask();
                        break;
                    case 10:
                        system.convertToEmployee();
                        break;
                    case 11:
                        system.showSummaries();
                        break;
                    case 12:
                        system.showOfferDetails();
                        break;
                    case 13:
                        system.showOnboardingTasks();
                        break;
                    case 14:
                        System.out.println("\n✓ Thank you for using Recruitment System!");
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Error: Invalid choice! Please enter 1-14.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number!");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
