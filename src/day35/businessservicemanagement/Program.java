package day35.businessservicemanagement;

public class Program {

	private String programName;
	private double fee;
	private String duration;
	
	public Program(String programName, double fee, String duration) {
	    this.programName = programName;
	    this.fee = fee;
	    this.duration = duration;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Program [programName=" + programName + ", fee=" + fee + ", duration=" + duration + "]";
	}
}
