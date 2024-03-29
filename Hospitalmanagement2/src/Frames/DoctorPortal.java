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
    public DoctorPortal(){
        initComponents();
    }
    public DoctorPortal(ResultSet res) {
        this();
        this.result = res;
        
        try {
            String name, spec;
            name = result.getString("name");
            spec = result.getString("specialized");
            this.id = result.getInt("Did");
            docNameLabel.setText(name.toUpperCase());
            jLabel2.setText(spec.toUpperCase());
            jLabel1.setText(new java.util.Date().toString());
            currPatient();
            waitPat();
            //System.out.println("doctor portal work");
        } catch (SQLException e) {
            System.out.println("doctor portal");
        }

    }
    private void labReset(){
        urine.setEnabled(false);
        mri.setEnabled(false);
        xray.setEnabled(false);
        bp.setEnabled(false);
        blood.setEnabled(false);
        urine.setSelected(false);
        mri.setSelected(false);
        blood.setSelected(false);
        bp.setSelected(false);
        xray.setSelected(false);
    }
    private void labSet(){
        urine.setEnabled(true);
        mri.setEnabled(true);
        xray.setEnabled(true);
        bp.setEnabled(true);
        blood.setEnabled(true);
    }
    private void msgbox(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

    private void currPatient() throws SQLException {
        String query = "SELECT * from Patient INNER JOIN current ON Patient.PatientID=current.pid WHERE doctor_id="+String.valueOf(id)+" ORDER BY currentid LIMIT 1" ;
        Connection con = DashBoard.conn;
        Statement st=con.createStatement();
        ResultSet res = st.executeQuery(query);
        pres = res;
        nextAvail();
    }
    private void currPatient(String i)throws SQLException{
        String query = "SELECT * from Patient INNER JOIN current ON Patient.PatientID=current.pid WHERE doctor_id="+String.valueOf(id)+" and PatientID="+i+" ORDER BY currentid LIMIT 1" ;
        Connection con = DashBoard.conn;
        Statement st=con.createStatement();
        ResultSet res = st.executeQuery(query);
        pres = res;
        nextAvail();
    }

    void nextAvail() throws SQLException {
        if (pres.next() ) {
            nameDisplayLabel.setText(pres.getString("Patientname"));
            sexDisplayLabel.setText(pres.getString("Gen"));
            heightDisplayLabel.setText(String.valueOf(pres.getFloat("Height")));
            weightDisplayLabel.setText(String.valueOf(pres.getFloat("Weight")));
            ageDisplay.setText(String.valueOf(pres.getInt("Age")));
            notesTextArea.setText(pres.getString("Remarks"));
            diseaseVariable.setText(pres.getString("disease"));
            checkupHistory(pres.getInt("PatientID"));
            labReset();

        } else {
            System.out.print("check");
            new NewJFrame2(this).setVisible(true);
            
            
        }
    }
    private void waitPat(){
        String query = "select PatientID,Patientname from Patient inner join current on Patient.PatientID=current.pid where doctor_id=?";
        String[] carr;
        try {
            int i = 1;
            Connection con = DashBoard.conn;
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1,id);
            ResultSet check = stm.executeQuery();
            check.last();
            carr = new String[check.getRow() + 1];
            check.beforeFirst();
            carr[0] = "- - -";
            while (check.next()) {
                carr[i] = check.getString("PatientID")+"-"+check.getString("Patientname");
                i++;
            }
            waitpat.setModel(new javax.swing.DefaultComboBoxModel(carr));
            stm.close();
        } catch (SQLException e) {
            System.out.println("error");
        }
    }

    private void checkupHistory(int a) {
        String query = "select date from checkup where pid=" + a;
        String[] carr;
        try {
            int i = 1;
            Connection con = DashBoard.conn;
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
            stm.close();
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

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        docName = new javax.swing.JPanel();
        docNameLabel = new javax.swing.JLabel();
        waitpat = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
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
        checkupLabel = new javax.swing.JLabel();
        checkupItembox = new javax.swing.JComboBox<>();
        notesLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        notesTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        checkupDisplayFeild = new javax.swing.JTextArea();
        bp = new javax.swing.JCheckBox();
        xray = new javax.swing.JCheckBox();
        blood = new javax.swing.JCheckBox();
        urine = new javax.swing.JCheckBox();
        mri = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        diseaseVariable = new javax.swing.JTextField();
        lab = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        nextButton = new javax.swing.JButton();
        callButton = new javax.swing.JButton();
        PrintButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        jLabel4.setText("jLabel4");

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

        waitpat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        waitpat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waitpatActionPerformed(evt);
            }
        });

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout docNameLayout = new javax.swing.GroupLayout(docName);
        docName.setLayout(docNameLayout);
        docNameLayout.setHorizontalGroup(
            docNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, docNameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(waitpat, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128)
                .addComponent(docNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        docNameLayout.setVerticalGroup(
            docNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(docNameLayout.createSequentialGroup()
                .addGroup(docNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(docNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(waitpat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
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

        bp.setText("Blood Pressure");
        bp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bpActionPerformed(evt);
            }
        });

        xray.setText("X-Ray");
        xray.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xrayActionPerformed(evt);
            }
        });

        blood.setText("Blood");
        blood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bloodActionPerformed(evt);
            }
        });

        urine.setText("Urine");
        urine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urineActionPerformed(evt);
            }
        });

        mri.setText("MRI");

        jLabel5.setText("Disease");

        lab.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lab.setForeground(new java.awt.Color(1, 1, 1));
        lab.setText("LAB TEST");
        lab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout doctorEditLayout = new javax.swing.GroupLayout(doctorEdit);
        doctorEdit.setLayout(doctorEditLayout);
        doctorEditLayout.setHorizontalGroup(
            doctorEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doctorEditLayout.createSequentialGroup()
                .addGroup(doctorEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(doctorEditLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(doctorEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(doctorEditLayout.createSequentialGroup()
                                .addComponent(blood)
                                .addGap(136, 136, 136)
                                .addComponent(xray))
                            .addGroup(doctorEditLayout.createSequentialGroup()
                                .addComponent(mri)
                                .addGap(153, 153, 153)
                                .addComponent(urine))
                            .addComponent(bp)
                            .addComponent(diseaseVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(doctorEditLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(lab)))
                .addGap(23, 23, 23)
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
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        doctorEditLayout.setVerticalGroup(
            doctorEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, doctorEditLayout.createSequentialGroup()
                .addGroup(doctorEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(notesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(doctorEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(doctorEditLayout.createSequentialGroup()
                        .addGroup(doctorEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkupItembox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(doctorEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(doctorEditLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(doctorEditLayout.createSequentialGroup()
                                .addComponent(diseaseVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lab)
                                .addGap(18, 18, 18)
                                .addComponent(bp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(doctorEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(blood)
                                    .addComponent(xray))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(doctorEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(mri)
                                    .addComponent(urine)))))))
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
            .addComponent(nextButton, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
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
                    .addComponent(heightLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(wightLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sexDisplayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sexLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(weightDisplayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(heightDisplayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doctorEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed

        try {
            Connection con = DashBoard.conn;
            String disease = diseaseVariable.getText();
            //        String description = jTextArea1.getText();
            String notes = notesTextArea.getText();
            boolean b=lab.isSelected();
            int finish=0;
            if(b){
                String sql2="SELECT `AUTO_INCREMENT`\n" +
                "FROM  INFORMATION_SCHEMA.TABLES\n" +
                "WHERE TABLE_SCHEMA = 'Demo'\n" +
                "AND   TABLE_NAME   = 'checkup';";
                String labs="insert into labPatient(labid,cid) values(?,?)";
                Statement st=con.createStatement();
                PreparedStatement state=con.prepareStatement(labs);
                ResultSet r=st.executeQuery(sql2);
                System.out.println("lab");
                if(r.next()){
                    System.out.println("lab");
                    String cid=r.getString("AUTO_INCREMENT");
                    if(bp.isSelected()){
                        state.setInt(1,1);

                        System.out.println("lab");

                        state.setString(2, cid);
                        int i=state.executeUpdate();
                        if(i>0){
                            System.out.println("success");
                        }
                    }
                    if(blood.isSelected()){
                        state.setInt(1,2);
                        state.setString(2, cid);
                        int i=state.executeUpdate();
                        if(i>0){
                            System.out.println("success");
                        }
                    }
                    if(xray.isSelected()){
                        state.setInt(1,4);
                        state.setString(2, cid);
                        int i=state.executeUpdate();
                        if(i>0){
                            System.out.println("success");
                        }
                    }
                    if(mri.isSelected()){
                        state.setInt(1,5);
                        state.setString(2, cid);
                        int i=state.executeUpdate();
                        if(i>0){
                            System.out.println("success");
                        }
                    }
                    if(urine.isSelected()){
                        state.setInt(1,6);
                        state.setString(2, cid);
                        int i=state.executeUpdate();
                        if(i>0){
                            System.out.println("success");
                        }
                    }
                }
            }else{
                finish=1;
            }

            String q2="insert into checkup(cid,date,pid,labfinish) values(null,?,?,?)";
            PreparedStatement st=con.prepareStatement(q2);
            st.setString(1,jLabel1.getText());
            st.setInt(2,pres.getInt("PatientID"));
            st.setInt(3, finish);
            st.executeUpdate();
            System.out.println("hello");

            String q3="delete from current where pid=?";
            PreparedStatement s=con.prepareStatement(q3);
            s.setString(1,pres.getString("PatientID"));
            System.out.println("hello");
            int i=s.executeUpdate();
            if(i>0){
                s.close();
            }

            String query = "UPDATE Patient SET  disease=?,notes=?  WHERE PatientID=?;";
            PreparedStatement stm=con.prepareStatement(query);
            stm.setString(1,disease);
            //        stm.setString(2,description);
            stm.setString(2,notes);
            stm.setInt(3,pres.getInt("PatientID"));
            stm.executeUpdate();

            System.out.println("hello");
            st.close();
            stm.close();
            currPatient();
            waitPat();
            jLabel1.setText(new java.util.Date().toString());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void labActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labActionPerformed
        if(lab.isSelected()){
            labSet();
        }
        else{
            labReset();
        }
    }//GEN-LAST:event_labActionPerformed

    private void urineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_urineActionPerformed

    private void bloodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bloodActionPerformed

    private void xrayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xrayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xrayActionPerformed

    private void bpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bpActionPerformed

    private void checkupItemboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkupItemboxActionPerformed

        try {
            Connection con = DashBoard.conn;
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

    private void jLabel2ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel2ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2ComponentHidden

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        waitPat();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void waitpatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waitpatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_waitpatActionPerformed

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
                new DoctorPortal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PrintButton;
    private javax.swing.JLabel ageDisplay;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JCheckBox blood;
    private javax.swing.JCheckBox bp;
    private javax.swing.JButton callButton;
    private javax.swing.JTextArea checkupDisplayFeild;
    private javax.swing.JComboBox<String> checkupItembox;
    private javax.swing.JLabel checkupLabel;
    private javax.swing.JTextField diseaseVariable;
    private javax.swing.JPanel docName;
    private javax.swing.JLabel docNameLabel;
    private javax.swing.JPanel doctorEdit;
    private javax.swing.JLabel heightDisplayLabel;
    private javax.swing.JLabel heightLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JCheckBox lab;
    private javax.swing.JCheckBox mri;
    private javax.swing.JLabel nameDisplayLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel notesLabel;
    private javax.swing.JTextArea notesTextArea;
    private javax.swing.JLabel sexDisplayLabel;
    private javax.swing.JLabel sexLabel;
    private javax.swing.JPanel special;
    private javax.swing.JCheckBox urine;
    private javax.swing.JComboBox<String> waitpat;
    private javax.swing.JLabel weightDisplayLabel;
    private javax.swing.JLabel wightLabel;
    private javax.swing.JCheckBox xray;
    // End of variables declaration//GEN-END:variables
}
