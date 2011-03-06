package db;import java.io.BufferedInputStream;import java.io.File;import java.io.FileInputStream;import java.io.FileOutputStream;import java.io.IOException;import java.io.InputStream;import java.sql.Connection;import java.sql.Date;import java.sql.ResultSet;import java.sql.SQLException;import ontology.people.ELearner;import com.hp.hpl.jena.ontology.OntModel;import com.hp.hpl.jena.rdf.model.Model;import com.mysql.jdbc.PreparedStatement;import com.mysql.jdbc.Statement;public class OwlOperation {	/*****************************************************************	 * Save the owl file to the database	 * @param owl file id	 * @param file	 * @param the date when the file was saved	 * @return true/false	 * 	 ****************************************************************/	public static boolean saveOwlFile(String rid, File file,Date date){		try{			Connection con = DataFactory.getConnection();			FileInputStream fin = new FileInputStream(file);	        String sql = "insert into owlfile values(?,?,?)";	        PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);	        stmt.setString(1,rid);	        InputStream in = new BufferedInputStream(new FileInputStream(file));	        stmt.setBinaryStream(2, in,(int)file.length());	        stmt.setDate(3, date);	        stmt.executeUpdate();	        stmt.close();	        fin.close();	        con.close();	        System.out.println("upload the file successfully");	        return true;		}catch(Exception e){			e.printStackTrace();			return false;		}	}	/***********************************************************************	 * read the blob data from the database, and write it to the File	 * @param rid	 * @param file	 * @return	 */	public static boolean getOwlFile(String rid,File file){		byte[] Buffer = new byte[4096]; 		try { 			Connection conn = DataFactory.getConnection(); 			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("select * from owlfile where owl_id=?"); 			pstmt.setString(1,rid);			ResultSet rs = pstmt.executeQuery(); 			while(rs.next()){				FileOutputStream fos = new FileOutputStream(file); 				InputStream is = rs.getBinaryStream("owl_file"); 				int size = 0; 				while((size = is.read(Buffer)) != -1) { 					fos.write(Buffer,0,size); 				} 				fos.close();			}						rs.close();			pstmt.close();			conn.close();			return true;		}catch(Exception e) { 			System.out.println("[OutPutFile error : ]" + e.getMessage()); 			return false;		} 	}	public static Date getOwlFileDate(String rid){		try { 			Connection conn = DataFactory.getConnection(); 			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("select * from owlfile where owl_id=?"); 			pstmt.setString(1,rid);			ResultSet rs = pstmt.executeQuery(); 			Date date = new Date(20101216);			while(rs.next()){				date = rs.getDate("owl_date"); 			}			rs.close();			pstmt.close();			conn.close();			return date;		}catch(Exception e) { 			System.out.println("[OutPutFile error : ]" + e.getMessage()); 			return null;		} 	}	public static boolean removeOwlFile(String rid){		try{			Connection conn = DataFactory.getConnection();			String sql = "delete from owlfile where owl_id='"+rid+"'";			Statement stmt = (Statement) conn.createStatement();			stmt.execute(sql);			stmt.close();			conn.close();			return true;		}catch(SQLException sqle){			sqle.printStackTrace();			return false;		}	}		/****************************************************************	 * update the model into the given file	 * @throws IOException 	 * 	 */	public static void writeOwlFile(OntModel model,File file) throws IOException{		FileOutputStream out = new FileOutputStream(file);		model.write(out,"N3");		//model.write(out, "N3");		out.flush();		out.close();		System.out.println("Owl File Update Success");	}	//"RDF/XML-ABBREV", "N-TRIPLE", "TURTLE", (and "TTL") and "N3"	public static void writeOwlFile(Model model,File file,String lang) throws IOException{		FileOutputStream out = new FileOutputStream(file);		model.write(out, lang);		//model.write(out, "N3");		out.flush();		out.close();		System.out.println("Owl File Update Success");	}		public static void main(String [] args) throws Exception{		//Model model = OwlFactory.getGenericRuleReasonerModel();		//File file =new File("D:\\EclipseWorkspace\\elearning\\src\\jena\\owlsample.owl");		//updateOwlFile(model,file);		ELearner el = new ELearner("ghh","ghh");		el.setEmail("ghh@163.com");		el.setGrade("ghh@Address");		DbOperation.addELearner(el);	}	}