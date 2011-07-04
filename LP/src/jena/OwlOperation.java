package jena;import java.io.File;import java.io.FileNotFoundException;import java.io.FileOutputStream;import java.io.IOException;import java.util.logging.Level;import java.util.logging.Logger;import ontology.people.ELearner;import com.hp.hpl.jena.rdf.model.Model;import java.io.FileInputStream;import org.semanticweb.owlapi.model.OWLOntologyCreationException;import org.semanticweb.owlapi.model.OWLOntologyStorageException;import util.Constant;public class OwlOperation {    /******************************************************************************************     * Write a serialization of this model as an XML document.     *     * The language in which to write the model is specified by the lang argument.     * Predefined values are "RDF/XML", "RDF/XML-ABBREV", "N-TRIPLE" and "N3".     * The default value is represented by null is "RDF/XML".     *     * Parameters:     * @param model     * @param file THE FILE for the output stream to which the XML will be written     * @param lang     * @throws IOException     */    public static void writeRdfFile(Model model, File file, String lang) throws IOException {        FileOutputStream out = new FileOutputStream(file);        model.write(out, lang);        //model.write(out, "N3");        out.flush();        out.close();        System.out.println("RDF File Update Success");    }    /***************************************************************************     * Operation On OWL API 3.2.3     */    public static void writeOwlFile(org.semanticweb.owlapi.model.OWLOntology ontology, File file) throws IOException {        try {            org.semanticweb.owlapi.model.OWLOntologyManager manager = org.semanticweb.owlapi.apibinding.OWLManager.createOWLOntologyManager();            manager.setOntologyDocumentIRI(ontology, org.semanticweb.owlapi.model.IRI.create(file));            manager.saveOntology(ontology);            System.out.println("Owl File Update Success");        } catch (OWLOntologyStorageException ex) {            Logger.getLogger(OwlOperation.class.getName()).log(Level.SEVERE, null, ex);        }    }    public static void writeOwlFileFromRdfFile(File rdfFile, File owlFile) {        try {            org.semanticweb.owlapi.model.OWLOntologyManager manager = org.semanticweb.owlapi.apibinding.OWLManager.createOWLOntologyManager();            org.semanticweb.owlapi.model.OWLOntology ontology = manager.loadOntologyFromOntologyDocument(rdfFile);            manager.saveOntology(ontology);            System.out.println("Owl File Update Success");        } catch (OWLOntologyCreationException ex) {            Logger.getLogger(OwlOperation.class.getName()).log(Level.SEVERE, null, ex);        } catch (OWLOntologyStorageException ex) {            Logger.getLogger(OwlOperation.class.getName()).log(Level.SEVERE, null, ex);        }    }    public static int getVersion() {        FileInputStream in = null;        try {            in = new FileInputStream(new File(Constant.USERVERSION));            int ch1 = in.read();            int ch2 = in.read();            int ch3 = in.read();            int ch4 = in.read();            return ((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0));        } catch (IOException ex) {            Logger.getLogger(OwlOperation.class.getName()).log(Level.SEVERE, null, ex);        } finally {            try {                in.close();            } catch (IOException ex) {                Logger.getLogger(OwlOperation.class.getName()).log(Level.SEVERE, null, ex);            }        }        return -1;    }    public static void setVersion(int v) {        try {            FileOutputStream out = new FileOutputStream(new File(Constant.USERVERSION));            out.write((v >>> 24) & 0xFF);            out.write((v >>> 16) & 0xFF);            out.write((v >>> 8) & 0xFF);            out.write((v >>> 0) & 0xFF);            out.flush();            out.close();        } catch (IOException ex) {            Logger.getLogger(OwlOperation.class.getName()).log(Level.SEVERE, null, ex);        }    }    public static void main(String[] args) {        setVersion(1232);        int s = getVersion();        System.out.println("s:" + s);    }}