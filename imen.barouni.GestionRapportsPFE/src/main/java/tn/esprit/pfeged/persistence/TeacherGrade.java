package tn.esprit.pfeged.persistence;

public enum TeacherGrade {
	ST("Stagiaire"),
	AD("Assistant D�l�gu�"),
	AT("Assistant Technologue"),
	T("Technologue"),
	PES("Professeur de l'enseignement secondaire"),
	VAC("Vacataire");
	
	private String description;
	
	private TeacherGrade(String description){
		this.description = description;
	}

	public String getDescription() {
		return description;
	}	

}