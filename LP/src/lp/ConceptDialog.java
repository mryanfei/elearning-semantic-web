/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConceptDialog.java
 *
 * Created on 2010-12-13, 16:34:24
 */
package lp;

import java.util.Date;
import ontology.EConcept;
import ontology.EPerformance;
import ontology.people.ELearner;

/**
 *
 * @author william
 */
public class ConceptDialog extends javax.swing.JDialog {

    public EConcept cdec = null;

    /** Creates new form ConceptDialog */
    public ConceptDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
        conceptName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        uriLabel = new javax.swing.JLabel();
        learnBtn = new javax.swing.JButton();
        examBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resouceTable = new javax.swing.JTable();
        examScore = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(lp.LPApp.class).getContext().getResourceMap(ConceptDialog.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        conceptName.setText(resourceMap.getString("conceptName.text")); // NOI18N
        conceptName.setName("conceptName"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        uriLabel.setText(resourceMap.getString("uriLabel.text")); // NOI18N
        uriLabel.setName("uriLabel"); // NOI18N

        learnBtn.setText(resourceMap.getString("learnBtn.text")); // NOI18N
        learnBtn.setName("learnBtn"); // NOI18N
        learnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                learnBtnActionPerformed(evt);
            }
        });

        examBtn.setText(resourceMap.getString("examBtn.text")); // NOI18N
        examBtn.setEnabled(false);
        examBtn.setName("examBtn"); // NOI18N
        examBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examBtnActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(resourceMap.getColor("jScrollPane1.border.border.lineColor"), 1, true), resourceMap.getString("jScrollPane1.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("jScrollPane1.border.titleFont"), resourceMap.getColor("jScrollPane1.border.titleColor"))); // NOI18N
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        resouceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "资源名", "难易度", "下载"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        resouceTable.setName("resouceTable"); // NOI18N
        jScrollPane1.setViewportView(resouceTable);
        resouceTable.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("resouceTable.columnModel.title0")); // NOI18N
        resouceTable.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("resouceTable.columnModel.title2")); // NOI18N
        resouceTable.getColumnModel().getColumn(2).setResizable(false);
        resouceTable.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("resouceTable.columnModel.title3")); // NOI18N

        examScore.setText(resourceMap.getString("examScore.text")); // NOI18N
        examScore.setName("examScore"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uriLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                            .addComponent(conceptName, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
                        .addGap(104, 104, 104))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(learnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(examBtn)
                        .addGap(77, 77, 77)
                        .addComponent(examScore)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(conceptName, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(uriLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(learnBtn)
                        .addComponent(examBtn))
                    .addComponent(examScore))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void learnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_learnBtnActionPerformed
        EPerformance ep = LPApp.lpModel.getEPerformance(new ELearner(LPApp.getApplication().user.username), cdec);
        if (ep == null) {
            ep = new EPerformance();
            ep.setValue(-1);
            ep.setConcept(cdec);
            ep.setElearner(LPApp.getApplication().user.learner);
            ep.setId(LPApp.getApplication().user.learner.getId() + cdec.getCid() + "_p");
            ep.setDatetime(new Date(System.currentTimeMillis()));
            LPApp.lpModel.addEPerfomance(ep);
        }
        this.updateData();
    }//GEN-LAST:event_learnBtnActionPerformed

    private void examBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examBtnActionPerformed
        this.jScrollPane1.setViewportView(new RadarPanel());
    }//GEN-LAST:event_examBtnActionPerformed

    public void updateData() {
        if (cdec != null) {
            EPerformance ep = LPApp.lpModel.getEPerformance(new ELearner(LPApp.getApplication().user.username), cdec);
            this.examScore.setText("");
            if (ep != null) {
                if (ep.getValue() > -0.5) {
                    this.learnBtn.setText("已学过");
                    examScore.setVisible(true);
                    examScore.setText("成绩为" + ep.getValue());
                } else {
                    this.learnBtn.setText("正在学习");
                    examScore.setVisible(false);
                }
                this.learnBtn.setEnabled(false);
                this.examBtn.setEnabled(true);
            } else {
                learnBtn.setText("学习它");
                learnBtn.setEnabled(true);
                examBtn.setEnabled(false);
                examScore.setVisible(false);
            }
        }
    }

    @Override
    public void setVisible(boolean b) {
        if (b) {
            this.updateData();
        }
        super.setVisible(b);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                ConceptDialog dialog = new ConceptDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel conceptName;
    private javax.swing.JButton examBtn;
    private javax.swing.JLabel examScore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton learnBtn;
    public javax.swing.JTable resouceTable;
    public javax.swing.JLabel uriLabel;
    // End of variables declaration//GEN-END:variables
}
