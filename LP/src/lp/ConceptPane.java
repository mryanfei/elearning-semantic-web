/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConceptPane.java
 *
 * Created on 2011-1-9, 16:51:23
 */
package lp;

import exception.jena.IndividualExistException;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import lp.display.ResourceTable;
import lp.display.URILabel;
import ontology.EConcept;
import ontology.EPerformance;
import ontology.people.ELearner;
import ontology.resources.ISCB_Resource;

/**
 *
 * @author student
 */
public class ConceptPane extends javax.swing.JPanel {

    public EConcept cdec = null;

    /** Creates new form ConceptPane */
    public ConceptPane() {
        initComponents();
        resourceTable = new ResourceTable();
        jScrollPane1.setViewportView(resourceTable);
        this.validate();
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
        examScore = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setDoubleBuffered(false);
        setPreferredSize(new java.awt.Dimension(800, 500));

        jLabel1.setText("知识点：");
        jLabel1.setName("jLabel1"); // NOI18N

        conceptName.setText("概念名");
        conceptName.setName("conceptName"); // NOI18N

        jLabel2.setText("URI:");
        jLabel2.setName("jLabel2"); // NOI18N

        uriLabel.setText("URI");
        uriLabel.setName("uriLabel"); // NOI18N

        learnBtn.setText("学习它");
        learnBtn.setName("learnBtn"); // NOI18N
        learnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                learnBtnActionPerformed(evt);
            }
        });

        examBtn.setText("学习效果评估");
        examBtn.setEnabled(false);
        examBtn.setName("examBtn"); // NOI18N
        examBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examBtnActionPerformed(evt);
            }
        });

        examScore.setName("examScore"); // NOI18N

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(160, 160, 160), 1, true), "相关资源", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("微软雅黑", 0, 14))); // NOI18N
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(conceptName, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                    .addComponent(uriLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
                .addGap(116, 116, 116)
                .addComponent(examScore, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(309, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(learnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(examBtn)
                .addGap(554, 554, 554))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(examScore, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(conceptName, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(uriLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(learnBtn)
                    .addComponent(examBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(410, Short.MAX_VALUE))
        );
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
            try {
                LPApp.lpModel.addEPerfomance(ep);
            } catch (IndividualExistException ex) {
                Logger.getLogger(ConceptDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.updateData();
}//GEN-LAST:event_learnBtnActionPerformed
    public String toString() {
        return conceptName.getText() + "\t" + uriLabel.getText();
    }

    public void updateResouceTable(EConcept ec) {
        ArrayList<ISCB_Resource> ra = LPApp.lpModel.getEResourcesByEConcept(ec);
       resourceTable.clearModel();
        resourceTable.updateRes(ra);

//        DefaultTableModel model = (DefaultTableModel) resourceTable.getModel();
//        for (int index = model.getRowCount() - 1; index >= 0; index--) {
//            model.removeRow(index);
//        }
//        for (ISCB_Resource er : ra) {
////            Object[] oa = {er.getName(), er.getDifficulty(), new javax.swing.JLabel(util.Constant.SERVERTESTURL + "/resources/" + er.getRid())};
//            Object[] oa = {er.getName(), er.getDifficulty(), new URILabel(util.Constant.SERVERTESTURL + "/resources/" + er.getRid())};
//            model.addRow(oa);
//        }
    }

    public void setConceptName(String name) {
        conceptName.setText(name);
    }

    public void setURIName(String uri) {
        uriLabel.setText(uri);
    }

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
    private void examBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examBtnActionPerformed
        this.jScrollPane1.setViewportView(new RadarPanel());
}//GEN-LAST:event_examBtnActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel conceptName;
    private javax.swing.JButton examBtn;
    private javax.swing.JLabel examScore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton learnBtn;
    public javax.swing.JLabel uriLabel;
    // End of variables declaration//GEN-END:variables
public ResourceTable resourceTable;
}
