/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Navigator_MyConcept1.java
 *
 * Created on 2011-1-15, 0:47:48
 */

package lp.navigator;

import javax.swing.JButton;
import lp.LPApp;

/**
 *
 * @author ghh
 */
public class Navigator_MyConcept1 extends javax.swing.JPanel {
private NavigatorDialog parent;
    /** Creates new form Navigator_MyConcept1 */
    public Navigator_MyConcept1(NavigatorDialog parent1) {
         this.parent = parent1;
         initComponents();
    }

     private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.parent.setNext();
}
     private void ignorButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
         parent.setVisible(false);
         parent.dispose();
}

          private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.parent.setPrevious();
}
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
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lp/resources/c1.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lp/resources/c2.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setName("jLabel2"); // NOI18N

        JButton nextButton = new JButton();
        nextButton.setBounds(507, 435,120,33);
        nextButton.setText("下一步");
        this.add(nextButton);
        nextButton.grabFocus();
        nextButton.setVisible(true);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        JButton ignorButton = new JButton();
        ignorButton.setBounds(10, 435,120,33);
        ignorButton.setText("跳过向导");
        this.add(ignorButton);
        ignorButton.setVisible(true);
        ignorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ignorButtonActionPerformed(evt);
            }
        });

        JButton previousButton = new JButton();
        previousButton.setBounds(377, 435,120,33);
        previousButton.setText("上一步");
        this.add(previousButton);
        previousButton.setVisible(true);
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lp/resources/7.png"))); // NOI18N
        jLabel3.setText("查看用户学过的知识");
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText("向导：默认以用户为中心展开知识地图；若点击某知识点，将重新以该知识点为中心展示地图；");
        jLabel4.setName("jLabel4"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(268, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                .addGap(108, 108, 108))
        );

        jLabel4.getAccessibleContext().setAccessibleName("向导：点击某知识点，试图将重新以该点为中心");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables

}
