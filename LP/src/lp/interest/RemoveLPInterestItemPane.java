/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LPItemPane.java
 *
 * Created on 2011-1-4, 17:46:21
 */
package lp.interest;

import exception.jena.IndividualNotExistException;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import lp.LPApp;
import util.ColorConstant;

/**
 *
 * @author student
 */
public class RemoveLPInterestItemPane extends javax.swing.JPanel {

    public UserInterestPane parent;
    public boolean valueEditable;
    private Color backgroundColor;

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
        UserInterestPane uip = new UserInterestPane();
        for (int i = 0; i < interests.size(); i++) {
            RemoveLPInterestItemPane p = new RemoveLPInterestItemPane(uip, interests.get(i));
            pane.add(p);
        }
        frame.add(pane);
        frame.pack();
        frame.setVisible(true);
    }

    /** Creates new form LPItemPane */
    public RemoveLPInterestItemPane(UserInterestPane parent) {
        initComponents();
        myInit(parent);

    }

    public RemoveLPInterestItemPane(UserInterestPane parent, ontology.EInterest interest) {
        this.interest = interest;
        initComponents();
        myInit(parent);
    }

    private void myInit(UserInterestPane parent) {
        valueEditable = false;
        this.parent = parent;
        jLabel1.setIcon(null);
        jLabel2.setText(interest.getEConcept().getName());
        mouseEnteredColor = new Color(255, 255, 255);
        backgroundColor = ColorConstant.backgroundGrayColor;
    }
    public Color mouseEnteredColor;
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

        setName("Form"); // NOI18N
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeItemEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeItemPaneMouseExited(evt);
            }
        });

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(RemoveLPInterestItemPane.class);
        jLabel1.setBackground(resourceMap.getColor("jLabel1.background")); // NOI18N
        jLabel1.setIcon(resourceMap.getIcon("jLabel1.icon")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        icon = resourceMap.getIcon("jLabel1.icon");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeInterestClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });

        jLabel2.setBackground(resourceMap.getColor("jLabel2.background")); // NOI18N
        jLabel2.setIcon(resourceMap.getIcon("jLabel2.icon")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void removeInterestClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeInterestClicked
        // TODO add your handling code here:
        System.out.println("delete interest " + interest);
        jLabel2.setBackground(Color.RED);
        parent.removeInterest(this);
        LPApp.lpLog.writeMessage("用户移除了一个感兴趣:" + interest.getId() + ":" + interest.getEConcept().getCid() + "+" + interest.getELearner().getId()+"\n");
    }//GEN-LAST:event_removeInterestClicked

    private void removeItemPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeItemPaneMouseExited
        jLabel1.setIcon(null);
        this.setBackground(backgroundColor);
        jLabel1.setBackground(backgroundColor);
        jLabel2.setBackground(backgroundColor);
        this.updateUI();
    }//GEN-LAST:event_removeItemPaneMouseExited

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        removeItemEntered(evt);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        removeItemPaneMouseExited(evt);
    }//GEN-LAST:event_jLabel1MouseExited

    private void removeItemEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeItemEntered
        jLabel1.setIcon(icon);
        this.setBackground(mouseEnteredColor);
        jLabel2.setBackground(mouseEnteredColor);
        jLabel1.setBackground(mouseEnteredColor);
        this.updateUI();
    }//GEN-LAST:event_removeItemEntered
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
