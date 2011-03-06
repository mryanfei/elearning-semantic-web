/*
 * LPApp.java
 */
package lp;

import db.OwlOperation;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import jena.OwlFactory;
import jena.impl.ELearnerModelImpl;
import lp.log.LPLogger;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import util.Constant;
import util.StringExchanger;

/**
 * The main class of the application.
 */
public class LPApp extends SingleFrameApplication {

    public EUser user;
    public LPView view;
    public LoginPanel loginPane;
    public static ELearnerModelImpl lpModel;
    public static LPLogger lpLog;
    public static int TOOL_STATE = -1;
    public static final int MY_CONCEPT = 0;
    public static final int ALL_CONCEPT = 1;
    public static final int RECOMMEND = 2;
    public static final int SEARCH = 3;
    public static final int PROFILE = 4;
    public static final int NAVIGATOR = 5;
    public static final int REGIST = 6;

    /**
     * At startup create and show the main frame of the application.
     */
    @Override
    protected void startup() {

        String sepstr = File.separator;
        lpModel = new ELearnerModelImpl(new java.io.File(Constant.OWLFile));
        lpLog = new LPLogger();
        user = null;
        view = new LPView(this);
        view.mainPanel.setLayout(new CentralLayout());
        loginPane = new LoginPanel();

        view.mainPanel.add(loginPane);
        view.lpToolBar.setVisible(false);
        view.getFrame().setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        show(view);

    }

    @Override
    protected void shutdown() {
        Date date = new Date(System.currentTimeMillis());
        File file = new File("test\\owl\\conceptsAndresource_RDF-XML.owl");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
            }
        }
//        try {
//            OwlOperation.writeOwlFile(LPApp.lpModel.getOntModel(), file);
//            System.out.println("Complete saving the file before exiting the program.");
//        } catch (IOException ex) {
//            Logger.getLogger(LPApp.class.getName()).log(Level.SEVERE, null, ex);
//        }
        lpLog.close();
        super.shutdown();
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override
    protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of LPApp
     */
    public static LPApp getApplication() {
        return Application.getInstance(LPApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(LPApp.class, args);
        // new TestFrame();
    }
}
