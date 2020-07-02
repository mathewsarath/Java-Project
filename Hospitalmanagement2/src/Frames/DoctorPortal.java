package Frames;

import hospitalmanagement2.*;
import java.sql.*;
import javax.swing.*;

public class DoctorPortal extends javax.swing.JFrame {

    /**
     * Creates new form DoctorPortal
     */
    private ResultSet result, pres;
    private int id;

    public DoctorPortal(ResultSet res) {
        this.result = res;
        initComponents();
        try {
            String name, spec;
            name = result.getString("name");
            spec = result.getString("specialized");
            this.id = result.getInt("Did");
            docNameLabel.setText(name.toUpperCase());
            jLabel2.setText(spec.toUpperCase());
            jLabel1.setText(new java.util.Date().toString());
            currPatient();
            System.out.println("doctor portal work");
        } catch (SQLException e) {
            System.out.println("doctor portal");
        }

    }

    private void msgbox(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

    private void currPatient() throws SQLException {
        String query = "SELECT * from Patient JOIN current where Patient.pid=current.pid";
        Connection con = DocConnect.conn;
        Statement stm = con.createStatement();
        ResultSet res = stm.executeQuery(query);
        pres = res;
        nextAvail();
    }

    void nextAvail() throws SQLException {
        if (pres.next() && pres.getInt("doctor_id") == this.id) {
            nameDisplayLabel.setText(pres.getString("name"));
            sexDisplayLabel.setText(pres.getString("sex"));
            heightDisplayLabel.setText(String.valueOf(pres.getFloat("height")));
            weightDisplayLabel.setText(String.valueOf(pres.getFloat("weight")));
            ageDisplay.setText(String.valueOf(pres.getInt("age")));
            notesTextArea.setText(pres.getString("notes"));
            checkupHistory(pres.getInt("pid"));

        } else {
            new NewJFrame2().setVisible(true);
        }
    }

    private void checkupHistory(int a) {
        String query = "select date from checkup where pid=" + a;
        String[] carr;
        try {
            int i = 1;
            Connection con = DocConnect.conn;
            Statement stm = con.createStatement();
            ResultSet check = stm.executeQuery(query);
            check.last();
            carr = new String[check.getRow() + 1];
            System.out.println(a);
            check.beforeFirst();
            carr[0] = "- - -";
            while (check.next()) {
                carr[i] = check.getString("date");
                System.out.println(a);
                i++;
            }
            System.out.println(a);
            checkupItembox.setModel(new javax.swing.DefaultComboBoxModel(carr));
        } catch (SQLException e) {
            System.out.println("error");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        docName = new javax.swing.JPanel();
        docNameLabel = new javax.swing.JLabel();
        special = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameDisplayLabel = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        ageDisplay = new javax.swing.JLabel();
        sexLabel = new javax.swing.JLabel();
        sexDisplayLabel = new javax.swing.JLabel();
        heightLabel = new javax.swing.JLabel();
        heightDisplayLabel = new javax.swing.JLabel();
        wightLabel = new javax.swing.JLabel();
        weightDisplayLabel = new javax.swing.JLabel();
        doctorEdit = new javax.swing.JPanel();
        TestLable = new javax.swing.JLabel();
        checkupLabel = new javax.swing.JLabel();
        checkupItembox = new javax.swing.JComboBox<>();
        notesLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        notesTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        checkupDisplayFeild = new javax.swing.JTextArea();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        nextButton = new javax.swing.JButton();
        callButton = new javax.swing.JButton();
        PrintButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 188, 156), 5));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 188, 156), 10));

        docName.setBackground(new java.awt.Color(26, 188, 156));

        docNameLabel.setBackground(new java.awt.Color(59, 111, 106));
        docNameLabel.setForeground(new java.awt.Color(15, 23, 22));
        docNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        docNameLabel.setText("<doctorName>");
        docNameLabel.setAlignmentX(0.5F);
        docNameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout docNameLayout = new javax.swing.GroupLayout(docName);
        docName.setLayout(docNameLayout);
        docNameLayout.setHorizontalGroup(
            docNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(docNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        docNameLayout.setVerticalGroup(
            docNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(docNameLayout.createSequentialGroup()
                .addComponent(docNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        special.setBackground(new java.awt.Color(189, 195, 199));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("<Specialised>");
        jLabel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jLabel2ComponentHidden(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<date>");

        javax.swing.GroupLayout specialLayout = new javax.swing.GroupLayout(special);
        special.setLayout(specialLayout);
        specialLayout.setHorizontalGroup(
            specialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        specialLayout.setVerticalGroup(
            specialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, specialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(docName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(special, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(docName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(special, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(189, 195, 199));

        nameLabel.setText("Name:");

        nameDisplayLabel.setBackground(new java.awt.Color(246, 241, 236));
        nameDisplayLabel.setText("<name>");

        ageLabel.setText("Age :");

        ageDisplay.setText("<age>");

        sexLabel.setText("Sex :");

        sexDisplayLabel.setText("<sex>");

        heightLabel.setText("Height :");

        heightDisplayLabel.setText("<Height>");

        wightLabel.setText("Wieght :");

        weightDisplayLabel.setText("<weight>");

        doctorEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 188, 156), 4));

        TestLable.setText("   Lab Tests");

        checkupLabel.setText("Check Up");

        checkupItembox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        checkupItembox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkupItemboxItemStateChanged(evt);
            }
        });
        checkupItembox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkupItemboxActionPerformed(evt);
            }
        });

        notesLabel.setText("Notes");

        notesTextArea.setColumns(20);
        notesTextArea.setRows(5);
        jScrollPane2.setViewportView(notesTextArea);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Medicine given on checkup");

        checkupDisplayFeild.setEditable(false);
        checkupDisplayFeild.setColumns(20);
        checkupDisplayFeild.setRows(5);
        checkupDisplayFeild.setWrapStyleWord(true);
        checkupDisplayFeild.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jScrollPane3.setViewportView(checkupDisplayFeild);

        jCheckBox1.setText("Blood Pressure");

        jCheckBox2.setText("X-Ray");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setText("Blood");

        jCheckBox4.setText("Urine");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jCheckBox5.setText("MRI");

        javax.swing.GroupLayout doctorEditLayout = new javax.swing.GroupLayout(doctorEdit);
        doctorEdit.setLayout(doctorEditLayout);
        doctorEditLayout.setHorizontalGroup(
            doctorEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doctorEditLayout.createSequentialGroup()
                .addGroup(doctorEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(doctorEditLayout.createSequentialGroup()
                        .addGroup(doctorEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TestLable, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(doctorEditLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jCheckBox5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, doctorEditLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(doctorEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(doctorEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox4))
                        .addGap(61, 61, 61)))
                .addGroup(doctorEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkupLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkupItembox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(doctorEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(notesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(doctorEditLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE))))
        );
        doctorEditLayout.setVerticalGroup(
            doctorEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, doctorEditLayout.createSequentialGroup()
                .addGroup(doctorEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(notesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(doctorEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(doctorEditLayout.createSequentialGroup()
                        .addComponent(checkupItembox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, doctorEditLayout.createSequentialGroup()
                .addComponent(TestLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addGroup(doctorEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addGap(18, 18, 18)
                .addGroup(doctorEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox4))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox5)
                .addGap(91, 91, 91))
        );

        jPanel4.setBackground(new java.awt.Color(26, 188, 156));

        nextButton.setBackground(new java.awt.Color(41, 128, 185));
        nextButton.setText("Next >>");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        callButton.setBackground(new java.awt.Color(41, 128, 185));
        callButton.setText("Call Nurse");

        PrintButton.setText("Print");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(callButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PrintButton, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nextButton, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
            .addComponent(PrintButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(callButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameDisplayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(ageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ageDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(sexLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sexDisplayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(heightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(heightDisplayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(weightDisplayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(doctorEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ageDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameDisplayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(heightLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(wightLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sexDisplayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sexLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(weightDisplayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(heightDisplayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doctorEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel2ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2ComponentHidden

    private void checkupItemboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkupItemboxActionPerformed

        try {
            Connection con = DocConnect.conn;
            String query = "select medicine.mname from checkup inner join check_med on checkup.cid=check_med.checkid inner join medicine on check_med.mid=medicine.mid where checkup.date=\"" + checkupItembox.getSelectedItem() + "\"";
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);
            int i = 1;
            String str = "";
            while (res.next()) {
                str += i + ". " + res.getString("mname") + "\n";
                i++;
            }
            checkupDisplayFeild.setText(str);
        } catch (SQLException e) {
            System.out.print("dberror");
        }

    }//GEN-LAST:event_checkupItemboxActionPerformed

    private void checkupItemboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkupItemboxItemStateChanged
        //        System.out.println(checkupItembox.getSelectedItem());
    }//GEN-LAST:event_checkupItemboxItemStateChanged

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = DocConnect.conn;
       // String disease = jTextField1.getText();
       // String description = jTextArea1.getText();
        String notes = notesTextArea.getText();
        String query = "UPDATE Patient SET  disease=?,description=?,notes=?  WHERE pid=?;";
        String q2="insert into checkup(date,pid) values (\""+jLabel1.getText()+"\",\""+pres.getInt("pid")+"\")";
        System.out.println(q2);
        PreparedStatement stm=con.prepareStatement(query);
        
        Statement st=con.createStatement();
        st.execute(q2);
        //stm.setString(1,disease);
        //stm.setString(2,description);
        stm.setString(3,notes);
        stm.setInt(4,pres.getInt("pid"));
        stm.executeUpdate();
            nextAvail();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DoctorPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorPortal(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PrintButton;
    private javax.swing.JLabel TestLable;
    private javax.swing.JLabel ageDisplay;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JButton callButton;
    private javax.swing.JTextArea checkupDisplayFeild;
    private javax.swing.JComboBox<String> checkupItembox;
    private javax.swing.JLabel checkupLabel;
    private javax.swing.JPanel docName;
    private javax.swing.JLabel docNameLabel;
    private javax.swing.JPanel doctorEdit;
    private javax.swing.JLabel heightDisplayLabel;
    private javax.swing.JLabel heightLabel;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel nameDisplayLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel notesLabel;
    private javax.swing.JTextArea notesTextArea;
    private javax.swing.JLabel sexDisplayLabel;
    private javax.swing.JLabel sexLabel;
    private javax.swing.JPanel special;
    private javax.swing.JLabel weightDisplayLabel;
    private javax.swing.JLabel wightLabel;
    // End of variables declaration//GEN-END:variables
}
