/*
 * Autopsy Forensic Browser
 *
 * Copyright 2011 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.casemodule;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

/**
 * The "Add Image" wizard panel 2. Provides checkbox to enable indexing, button
 * to start process, and progress bar.
 */
final class AddImageVisualPanel2 extends JPanel {

    private String nonCriticalErrors = null;
    private JLabel progressLabel = null;
    private JButton errorButton = null;

    /**
     * Creates new form AddImageVisualPanel2
     */
    AddImageVisualPanel2() {
        initComponents();
        customizeComponents();
    }

    private void customizeComponents() {
        progressLabel = new JLabel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.PAGE_AXIS));
        infoPanel.add(progressLabel);
        infoPanel.add(Box.createRigidArea(new Dimension(10, 10))); //spacer
    }

    void resetInfoPanel() {
        if (errorButton != null) {
            infoPanel.remove(errorButton);
            errorButton = null;
        }
        progressLabel.setText("");
    }

    /**
     * Returns the name of the this panel. This name will be shown on the left
     * panel of the "Add Image" wizard panel.
     *
     * @return name the name of this panel
     */
    @Override
    public String getName() {
        return "Add Image and Start Ingest";
    }

    public JProgressBar getCrDbProgressBar() {
        return this.crDbProgressBar;
    }

    public JLabel getProgressLabel() {
        return this.progressLabel;
    }

    /**
     * Changes the progress bar text and color.
     *
     * @param text the text to be shown
     * @param value the current value of the progress bar
     * @param color the color of the progress bar text
     */
    public void changeProgressBarTextAndColor(String text, int value, Color color) {
        progressLabel.setText(text);
        progressLabel.setForeground(color);
        crDbProgressBar.setValue(value);
    }
    
    /**
     * append progress text to progress label
     * @param text 
     */
    public void appendProgressText(String text) {
        progressLabel.setText(progressLabel.getText() + " " + text);
    }

    

    void setErrors(final String errors, boolean critical) {
        crDbProgressBar.setValue(100); //always invoked when process completed
        if (critical) {
            progressLabel.setText("*Failed to add image (critical errors encountered). Click below to view the Add Image Log.");
        }
        else {
            progressLabel.setText("*Image added (non-critical image errors encountered). Click below to view the Add Image Log.");
        }
        errorButton = new JButton();
        errorButton.setText("View Log");
        infoPanel.add(errorButton);
        errorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, errors, "Add image non-critical errors", JOptionPane.WARNING_MESSAGE);
                AddImageErrorsDialog dialog = new AddImageErrorsDialog(null, true);
                dialog.setErrors(errors);
                dialog.setVisible(true);
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        crDbProgressBar = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        crDbLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        infoPanel = new javax.swing.JPanel();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(AddImageVisualPanel2.class, "AddImageVisualPanel2.jLabel5.text")); // NOI18N

        crDbLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(crDbLabel, org.openide.util.NbBundle.getMessage(AddImageVisualPanel2.class, "AddImageVisualPanel2.crDbLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(AddImageVisualPanel2.class, "AddImageVisualPanel2.jLabel1.text")); // NOI18N

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(crDbLabel)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(0, 36, Short.MAX_VALUE))
                    .addComponent(crDbProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(crDbLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(crDbProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel crDbLabel;
    private javax.swing.JProgressBar crDbProgressBar;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
