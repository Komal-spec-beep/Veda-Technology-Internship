package day35.businessservicemanagement;

public class InternshipProgram extends Program{

	public InternshipProgram(String programName, double fee, String duration, String mentorName, double stipend) {
		super(programName, fee, duration);
		this.mentorName = mentorName;
		this.stipend = stipend;
	}
	private String mentorName;
	private double stipend;
	
	public String getMentorName() {
		return mentorName;
	}
	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}
	public double getStipend() {
		return stipend;
	}
	public void setStipend(double stipend) {
		this.stipend = stipend;
	}
	@Override
	public String toString() {
		return super.toString() + ", InternshipProgram [mentorName=" + mentorName
		        + ", stipend=" + stipend + "]";
	}
}
