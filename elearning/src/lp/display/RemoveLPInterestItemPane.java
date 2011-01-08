/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LPItemPane.java
 *
 * Created on 2011-1-4, 17:46:21
 */
package lp.display;

import java.awt.Color;
import java.awt.event.MouseEvent;

/**
 *
 * @author student
 */
public class RemoveLPInterestItemPane extends javax.swing.JPanel implements java.awt.event.MouseListener {

    public static void main(String[] args) {
        jena.impl.ELearnerModelImpl emi = new jena.impl.ELearnerModelImpl(new java.io.File("test\\owl\\conceptsAndresource_RDF-XML.owl"));
        ontology.people.ELearner el = emi.getELearner("el001");
        java.util.ArrayList<ontology.EInterest> interests = emi.getEInterests(el);
        System.out.println(interests);
        javax.swing.JFrame frame = new javax.swing.JFrame();
        // LPListPane lppane = new LPListPane(interests);
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        javax.swing.JPanel pane = new javax.swing.JPanel();
        pane.setLayout(new javax.swing.BoxLayout(pane, javax.swing.BoxLayout.Y_AXIS));
        for (int i = 0; i < interests.size(); i++) {
            RemoveLPInterestItemPane p = new RemoveLPInterestItemPane(interests.get(i));
            pane.add(p);
        }
        frame.add(pane);
        frame.pack();
        frame.setVisible(true);
    }

    /** Creates new form LPItemPane */
    public RemoveLPInterestItemPane() {
        initComponents();
        myInit();
    }

    public RemoveLPInterestItemPane(ontology.EInterest interest) {
        this.interest = interest;
        initComponents();
        myInit();
    }

    private void myInit() {
        jLabel1.setOpaque(true);
        jLabel2.setOpaque(true);
        jLabel3.setOpaque(true);
        this.setBackground(Color.WHITE);
        jLabel1.setIcon(null);
        jLabel2.setText(interest.getEConcept().getName());
        jLabel3.setText(String.valueOf(interest.getValue()));
        color = new Color(244, 244, 245);
        addMouseListener(this);
    }
    public Color color;
    public ontology.EInterest interest;
    public javax.swing.Icon icon;

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(RemoveLPInterestItemPane.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setName("Form"); // NOI18N

        jLabel1.setBackground(resourceMap.getColor("jLabel1.background")); // NOI18N
        jLabel1.setIcon(resourceMap.getIcon("jLabel1.icon")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        icon = resourceMap.getIcon("jLabel1.icon");

        jLabel2.setBackground(resourceMap.getColor("jLabel2.background")); // NOI18N
        jLabel2.setIcon(resourceMap.getIcon("jLabel2.icon")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setBackground(resourceMap.getColor("jLabel3.background")); // NOI18N
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel2;
    protected javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("delete interest " + interest);
        jLabel2.setBackground(Color.RED);

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        jLabel1.setIcon(icon);
        this.setBackground(color);
        jLabel2.setBackground(color);
        jLabel1.setBackground(color);
        jLabel3.setBackground(color);
        this.updateUI();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        jLabel1.setIcon(null);
        this.setBackground(Color.WHITE);
        jLabel1.setBackground(Color.WHITE);
        jLabel3.setBackground(Color.WHITE);
        jLabel2.setBackground(Color.WHITE);
        this.updateUI();
    }
}
