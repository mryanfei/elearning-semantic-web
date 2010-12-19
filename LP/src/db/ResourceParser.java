package db;

import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import jena.ELearnerModelImpl;

import ontology.EConcept;
import ontology.resources.EResource;
import util.Constant;

import com.mysql.jdbc.Connection;

public class ResourceParser {
	public ResourceParser(){
		emi = new ELearnerModelImpl(owl);
	}
	public boolean writeToFile(File file){
		return emi.writeToFile(file);
	}
	public ArrayList<EConcept> getAllEConcepts() throws Exception{
		ArrayList<EConcept> concepts = new ArrayList<EConcept>();
		con = DataFactory.getConnection();
		Statement st = con.createStatement();
		String sql = "select course_resource_id,course_resource_title,courser_resource_location,concept1,concept2 from courseresourceinfo";
		ResultSet rs =  st.executeQuery(sql);
		String idprefix = "cid";
		System.out.println("all concepts size:"+emi.getAllEConcepts().size());
		HashMap<String,EConcept> record = new HashMap<String,EConcept>();
		ArrayList<EResource> resources = new ArrayList<EResource>();
		while(rs.next()){
			EResource resource = new EResource();
			resource.setDifficulty("easy");
			resource.setRid(rs.getString("course_resource_id"));
			resource.setName(rs.getString("course_resource_title"));
			resource.setFileLocation(rs.getString("courser_resource_location"));
			emi.addEResource(resource);
			
			String con1=(String)rs.getString("concept1");
			EConcept conceptTemp = null;
			boolean isContain1 = record.containsKey(con1);
			
			if(!isContain1){
				conceptTemp = new EConcept(idprefix+(concepts.size()+1),con1);
				record.put(con1,conceptTemp);
				concepts.add(conceptTemp);
				emi.addEConcept(conceptTemp);
				emi.addPropertyIsSonOf(emi.getRootConcept(),conceptTemp);
			}else{
				conceptTemp = record.get(con1);
				
			}
			String con2=(String)rs.getString("concept2");
			boolean isContain2 = record.containsKey(con2);
			if(!isContain2){
				EConcept temp = new EConcept(idprefix+(concepts.size()+1),con1);
				record.put(con2,temp);
				concepts.add(temp);
				emi.addEConcept(temp);
				emi.addPropertyIsSonOf(conceptTemp,temp);
			}
			System.out.println(con1+"\t"+con2);
		}
	//	emi.writeToFile(new File(newOwl));
		System.out.println("all concepts new size:"+emi.getAllEConcepts().size());
		System.out.println("new Concepts Size:"+concepts.size());
		System.out.println("hah\n"+emi.getSonConcepts(emi.getRootConcept()));
		rs.close();
		st.close();
		con.close();
		return concepts;
	}
	 
	public static  void main(String []args) throws Exception{
		ResourceParser rp = new ResourceParser();
		rp.getAllEConcepts();
	}
	private ELearnerModelImpl emi;
	private Connection con;
	private String newOwl = Constant.newOwlFile;
	private String owl = Constant.OWLFile;
	private String rule = Constant.RulesFile;
	
}
