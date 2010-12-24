package jena;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import db.OwlOperation;
import db.ResourceParser;

import jena.impl.ELearnerModel;
import jena.impl.ELearnerModelImpl;
import jena.impl.ELearnerModelImplTwo;
import ontology.EConcept;
import ontology.EPerformance;
import ontology.people.ELearner;
import util.Constant;
import util.ConstantForTest;

public class ModelTest {
	//the contrast between ELearnerModelImpl and ELearnerModelImplTwo
	public static void  contrastPerformance1(){
		for(int i =0;i<10000;i++){
			//start up the program
		}
		long time = System.currentTimeMillis();
		ELearnerModelImpl emi = new ELearnerModelImpl();
		ELearner el = new ELearner("el001");
		ArrayList<EPerformance> c = emi.getEPerformances(el);
		System.out.println("csize:"+c.size());
		long time1 = System.currentTimeMillis();
		ELearnerModelImplTwo emi2 = new ELearnerModelImplTwo();
		ArrayList<EPerformance> c2 = emi2.getEPerformances(el);
		System.out.println("csize:"+c2.size());
		long time2 = System.currentTimeMillis();
		System.out.println("time1"+(time1-time));
		System.out.println("time2"+(time2-time1));
	}
	public static void fileWritingPerformanceTest() throws IOException{
		ResourceParser rp = new ResourceParser();
		rp.getBasicEConcepts();
		rp.getDataStructureResrouces();
		System.out.println("Begin Writing ....");
		String lang[] = {"N3","RDF/XML-ABBREV","N-TRIPLE","TURTLE"};
		String head ="conceptsAndresource_";

		long time1 = System.currentTimeMillis();
		File file = new File(ConstantForTest.TestOwlFileLocation+head+"RDF-XML.owl");
		if(!file.exists()){
			file.createNewFile();
		}
		OwlOperation.writeOwlFile(rp.getOntModel(), file);

		long time2 = System.currentTimeMillis();
		File file2 = new File( ConstantForTest.TestOwlFileLocation+head+"N3.owl");
		if(!file2.exists()){
			file2.createNewFile();
		}
		OwlOperation.writeOwlFile(rp.getOntModel(), file2, lang[0]);

		long time3 = System.currentTimeMillis();
		File file3 = new File( ConstantForTest.TestOwlFileLocation+head+"RDF-XML-ABBREV.owl");
		if(!file3.exists()){
			file3.createNewFile();
		}
		OwlOperation.writeOwlFile(rp.getOntModel(), file3, lang[1]);
		
		long time4 = System.currentTimeMillis();
		File file4 = new File( ConstantForTest.TestOwlFileLocation+head+"N-TRIPLE.owl");
		if(!file4.exists()){
			file4.createNewFile();
		}
		OwlOperation.writeOwlFile(rp.getOntModel(), file4, lang[2]);
		
		long time5 = System.currentTimeMillis();
		File file5 = new File( ConstantForTest.TestOwlFileLocation+head+"TURTLE.owl");
		if(!file5.exists()){
			file5.createNewFile();
		}
		OwlOperation.writeOwlFile(rp.getOntModel(), file5, lang[3]);
		long time6 = System.currentTimeMillis();
		System.out.println("write basic concepts results"); 
		
		ELearnerModelImpl newEMI = new ELearnerModelImpl(file);
		long time7 = System.currentTimeMillis();
		ELearnerModelImpl newEMI2 = new ELearnerModelImpl(file2,lang[0]);
		long time8 = System.currentTimeMillis();
		ELearnerModelImpl newEMI3 = new ELearnerModelImpl(file3,lang[1]);
		long time9 = System.currentTimeMillis();
		ELearnerModelImpl newEMI4 = new ELearnerModelImpl(file4,lang[2]);
		long time10 = System.currentTimeMillis();
		ELearnerModelImpl newEMI5 = new ELearnerModelImpl(file5,lang[3]);
		long time11 = System.currentTimeMillis();
		
		System.out.println("writing default value RDF/XML: "+(time2-time1)+"ms");
		System.out.println("writing N3: "+(time3-time2)+"ms");
		System.out.println("writing RDF/XML-ABBREV: "+(time4-time3)+"ms");
		System.out.println("writing N-TRIPLE: "+(time5-time4)+"ms");
		System.out.println("writing TURTLE: "+(time6-time5)+"ms");
		
		System.out.println("reading RDF/XML: "+(time7-time6)+"ms");
		System.out.println("reading N3: "+(time8-time7)+"ms");
		System.out.println("reading RDF/XML-ABBREV: "+(time9-time8)+"ms");
		System.out.println("reading N-TRIPLE: "+(time10-time9)+"ms");
		System.out.println("reading TURTLE: "+(time11-time10)+"ms");
		
		long time12 = System.currentTimeMillis();
		newEMI.getAllEConcepts();
		long time13 = System.currentTimeMillis();
		newEMI2.getAllEConcepts();
		long time14 = System.currentTimeMillis();
		newEMI3.getAllEConcepts();
		long time15 = System.currentTimeMillis();
		newEMI4.getAllEConcepts();
		long time16 = System.currentTimeMillis();
		newEMI5.getAllEConcepts();
		long time17 = System.currentTimeMillis();
		System.out.println("querying model time");
		System.out.println("querying RDF/XML: "+(time13-time12)+"ms");
		System.out.println("querying N3: "+(time14-time13)+"ms");
		System.out.println("querying RDF/XML-ABBREV: "+(time15-time14)+"ms");
		System.out.println("querying N-TRIPLE: "+(time16-time15)+"ms");
		System.out.println("querying TURTLE: "+(time17-time16)+"ms");
		
	}
	public static void main(String [] args) throws IOException{
		ELearnerModelImpl emi = new ELearnerModelImpl(new File("test\\owl\\conceptsAndresource_RDF-XML.owl"));
		System.out.println(emi.getAllEConcepts().size()+"concepts");
	}
}
