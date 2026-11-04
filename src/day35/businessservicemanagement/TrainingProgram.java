package day35.businessservicemanagement;

public class TrainingProgram extends Program {

	public TrainingProgram(String programName, double fee, String duration, String trainerName, int availableSeats) {
		super(programName, fee, duration);
		this.trainerName = trainerName;
		this.availableSeats = availableSeats;
	}
	private String trainerName;
	private int availableSeats;
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	@Override
	public String toString() {
		return super.toString() + ", TrainingProgram [trainerName=" + trainerName
		        + ", availableSeats=" + availableSeats + "]";
	}
}
