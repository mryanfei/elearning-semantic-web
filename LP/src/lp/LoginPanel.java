package lp;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import db.WebOperation;
import java.io.File;
import jena.impl.ELearnerModelImpl;
import lp.navigator.NavigatorDialog;
import ontology.people.ELearner;
import util.Constant;
import util.LogConstant;

/**
 *
 * @author Shuaiguo
 */
public class LoginPanel extends javax.swing.JPanel {

    /** Creates new form LoginPanel */
    public LoginPanel() {
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

        username = new javax.swing.JTextField();
        regBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tipLabel = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();

        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 439));

        username.setName("username"); // NOI18N
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(LoginPanel.class);
        regBtn.setText(resourceMap.getString("regBtn.text")); // NOI18N
        regBtn.setName("regBtn"); // NOI18N
        regBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        loginBtn.setText(resourceMap.getString("loginBtn.text")); // NOI18N
        loginBtn.setName("loginBtn"); // NOI18N
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        tipLabel.setFont(resourceMap.getFont("tipLabel.font")); // NOI18N
        tipLabel.setText(resourceMap.getString("tipLabel.text")); // NOI18N
        tipLabel.setName("tipLabel"); // NOI18N

        password.setText(resourceMap.getString("password.text")); // NOI18N
        password.setName("password"); // NOI18N
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(loginBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(regBtn))
                            .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(tipLabel)))
                .addContainerGap(188, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(tipLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regBtn)
                    .addComponent(loginBtn))
                .addContainerGap(120, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void doLoginTask() {
        final LPView view = LPApp.getApplication().view;
        LPApp.getApplication().user = new EUser(username.getText());

        view.setBusy("正在验证密码...");
        Thread authThread = new Thread() {

            @Override
            public void run() {
                LPApp.getApplication().initModel();
                //long t1 = System.currentTimeMillis();
                String rtvMsg = LPApp.getApplication().user.login(new String(password.getPassword()));
                //long t2 = System.currentTimeMillis();
                //System.out.println("用户通过认证时间:" + (t2 - t1) + "ms");
                view.setBusy("正在从服务器取回用户信息...");
                //跳过身份验证
                //String rtvMsg = null;
                if (rtvMsg == null) {
                    //if the elearner is in the model, then init its data
                    //else create a new elearner and show him the usage navigator.
                    String uid = LPApp.getApplication().user.learner.getId();
                    File f = new File("files/owl/" + uid + ".owl");
                    long t3 = System.currentTimeMillis();
                    boolean hasInfoFile = f.exists();
                    System.out.println("是否存在用户文件:" + hasInfoFile);
                    // hasInfoFile true: user info exist
                    //              false: not exist
                    if (!hasInfoFile) {
                        boolean isDownloadFile = WebOperation.downloadUserFile(new ELearner(uid));
                        System.out.println("是否成功下载OWL文件:" + isDownloadFile);
                        if (isDownloadFile) {
                            f = new File("files/owl/" + uid + ".owl");
                            LPApp.lpModel = new ELearnerModelImpl(new java.io.File(Constant.OWLFileEmptyUser), f);
                        } else {
                            try {
                                f.createNewFile();
                                LPApp.lpModel = new ELearnerModelImpl(new java.io.File(Constant.OWLFileEmptyUser));
                            } catch (IOException ex) {
                                Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            LPApp.lpModel.addELearner(new ELearner(uid));
                            //pop the navigator dialogs
                            NavigatorDialog d = new NavigatorDialog(LPApp.getApplication().getMainFrame());
                            d.setTitle("向导");
                            d.setModal(true);
                            d.pack();
                            d.setVisible(true);
                        }
                    } else {
                        System.out.println("fff:" + f.getName());
                        File bak = new File("files/owl/" + f.getName() + ".bak");
                        f.renameTo(bak);
                        boolean isDownloadFile = WebOperation.downloadUserFile(new ELearner(uid));
                        System.out.println("是否成功下载OWL文件:" + isDownloadFile);
                        if (isDownloadFile) {
                            f = new File("files/owl/" + uid + ".owl");
                            if(f.exists()){
                                 LPApp.lpModel = new ELearnerModelImpl(new java.io.File(Constant.OWLFileEmptyUser), f);
                            }else{
                                LPApp.lpModel = new ELearnerModelImpl(new java.io.File(Constant.OWLFileEmptyUser), bak);
                            }
                        }
                        LPApp.getApplication().user.learner = LPApp.lpModel.getELearner(uid);
                    }
                    long t4 = System.currentTimeMillis();
                    System.out.println("初始化模型:" + (t4 - t3) + "ms");

                    view.setBusy("正在加载数据...");
                    view.initTools();
                    LPApp.lpLogs.writeLog(101, LPApp.getApplication().user.username, "登入", LogConstant.STATUS101);
                    long t5 = System.currentTimeMillis();
                    System.out.println("界面初始化" + (t5 - t4) + "ms");
                } else {
                    tipLabel.setText(rtvMsg);
                    tipLabel.setForeground(Color.red);
                    username.grabFocus();
//                    LPApp.lpLogs.writeLog(101, LPApp.getApplication().user.username , "登出", LogConstant.STATUS101);
                }
                view.setIdle();
            }
        };
        authThread.start();
    }

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        doLoginTask();
}//GEN-LAST:event_loginBtnActionPerformed

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ImageIcon aboutimage = new ImageIcon(LoginPanel.class.getResource("/lp/resources/bg.png"));
        aboutimage.paintIcon(this, g, 0, 0);
    }

    public void prepareLogin() {
        final LPView view = LPApp.getApplication().view;
        view.setBusy("正在加载数据...");
        Thread authThread = new Thread() {

            @Override
            public void run() {
                LPApp.getApplication().user.learner = LPApp.lpModel.getELearner(LPApp.getApplication().user.username);
                view.setBusy("正在加载数据...");
                view.initTools();
                view.setIdle();
            }
        };
        authThread.start();
    }

    private void regBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regBtnActionPerformed
//
////            LPApp.getApplication().view.setMainTool(LPApp.REGIST);
//        JDialog d = new NavigatorDialog(LPApp.getApplication().getMainFrame());
//        d.setTitle("注册向导");
//        d.setModal(true);
//        d.pack();
//        d.setVisible(true);
        WebOperation.registBroswer("http://e6.thss.tsinghua.edu.cn/registerPage.jsp?roleId=0");
    }//GEN-LAST:event_regBtnActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        if (this.password.getPassword().length < 1) {
            password.requestFocus();
        } else {
            doLoginTask();
        }
    }//GEN-LAST:event_usernameActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        doLoginTask();
    }//GEN-LAST:event_passwordActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton regBtn;
    private javax.swing.JLabel tipLabel;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
