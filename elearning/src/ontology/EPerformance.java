package ontology;

import java.util.Date;

import ontology.people.ELearner;

public class EPerformance {
	public EPerformance(){
		
	}
	
	public ELearner getElearner() {
		return elearner;
	}
	public void setElearner(ELearner elearner) {
		this.elearner = elearner;
	}
	public EConcept getConcept() {
		return concept;
	}
	public void setConcept(EConcept concept) {
		this.concept = concept;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String toString(){
		return id+"\t"+value+"\t"+elearner.getId()+"\t"+concept.getCid()+"\t"+datetime;
	}
	
	private ELearner elearner;
	private EConcept concept;
	private float value;
	private String id;
	private Date datetime;
}
