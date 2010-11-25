package jena;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.reasoner.rulesys.GenericRuleReasoner;

import util.Constant;

public class ElearnerQuery {
	public static void main(String [] args) throws IOException{
		test();
	}
	public static ArrayList<String> getAllConceptName()throws IOException{
		// Open the bloggers RDF graph from the filesystem
		InputStream in = new FileInputStream(new File(Constant.OWLFile));

		// Create an empty in-memory model and populate it from the graph
		Model model = ModelFactory.createMemModelMaker().createModel(null);
		model.read(in,null); // null base URI, since model URIs are absolute
		in.close();
		// Create a new query
		String queryString = 
			"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "+
			"PREFIX base: <http://www.owl-ontologies.com/e-learning.owl#> " +
			"SELECT ?concept " +
			"WHERE {" +
			"      ?concept rdf:type base:E_Concept . " +
			"      }";

		Query query = QueryFactory.create(queryString);

		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		ResultSet results = qe.execSelect();
		ArrayList<String> concepts = new ArrayList<String>();
		while(results.hasNext()){
			QuerySolution qs = results.next();
			//trim() eliminates the blank space behind the uri, which make the getResource() method working.
			String uri = qs.get("?concept").toString().trim();
			String name = model.getResource(uri).getLocalName();
			concepts.add(name);
		}
		qe.close();
		return concepts;
	}
	
	public static void getPartOfConcept(String conceptName) throws IOException{
		InputStream in = new FileInputStream(new File(Constant.OWLFile));
		Model model = ModelFactory.createMemModelMaker().createModel(null);
		model.read(in,null); // null base URI, since model URIs are absolute
		in.close();

		// Create a new query
		String queryString = 
			"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "+
			"PREFIX base: <http://www.owl-ontologies.com/e-learning.owl#> " +
			"SELECT ?concept " +
			"WHERE {" +
			"      ?concept rdf:type base:E_Concept . " +
			"      ?concept base:is_part_of base:Database ."+
			"      }";

		Query query = QueryFactory.create(queryString);

		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		ResultSet results = qe.execSelect();
		// Output query results	
		ResultSetFormatter.out(System.out, results, query);
		
		qe.close();
	}
	public static void test() throws IOException{
		// Open the bloggers RDF graph from the filesystem
		InputStream in = new FileInputStream(new File(Constant.OWLFile));

		// Create an empty in-memory model and populate it from the graph
		Model model = OwlFactory.getGenericRuleReasonerModel();
		// Create a new query
		String queryString = 
			"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "+
			"PREFIX base: <http://www.owl-ontologies.com/e-learning.owl#> " +
			"SELECT ?concept " +
			"WHERE {" +
			"      ?concept rdf:type base:E_Concept . " +
			"      ?concept base:is_part_of base:Software_Engineer . "+
			"      }";

		Query query = QueryFactory.create(queryString);

		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		ResultSet results = qe.execSelect();
		 
		// Output query results	
		ResultSetFormatter.out(System.out, results, query);
		
		// Important - free up resources used running the query
		qe.close();
	}
}
