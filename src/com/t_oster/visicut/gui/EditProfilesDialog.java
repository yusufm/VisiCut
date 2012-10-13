/**
 * This file is part of VisiCut.
 * Copyright (C) 2012 Thomas Oster <thomas.oster@rwth-aachen.de>
 * RWTH Aachen University - 52062 Aachen, Germany
 * 
 *     VisiCut is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *    VisiCut is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 * 
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with VisiCut.  If not, see <http://www.gnu.org/licenses/>.
 **/

/*
 * EditMaterialsDialog.java
 *
 * Created on 06.09.2011, 14:03:48
 */
package com.t_oster.visicut.gui;

import com.t_oster.visicut.gui.beans.EditableTableProvider;
import com.t_oster.visicut.model.*;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Thomas Oster <thomas.oster@rwth-aachen.de>
 */
public class EditProfilesDialog extends javax.swing.JDialog implements EditableTableProvider
{

  protected List<LaserProfile> currentProfiles = null;
  public static final String PROP_CURRENTPROFILES = "currentProfiles";

  /**
   * Get the value of currentMaterials
   *
   * @return the value of currentMaterials
   */
  public List<LaserProfile> getCurrentProfiles()
  {
    return currentProfiles;
  }

  /**
   * Set the value of currentMaterials
   *
   * @param currentProfiles new value of currentMaterials
   */
  public void setCurrentProfiles(List<LaserProfile> currentProfiles)
  {
    List<LaserProfile> oldCurrentProfiles = this.currentProfiles;
    this.currentProfiles = currentProfiles;
    firePropertyChange(PROP_CURRENTPROFILES, oldCurrentProfiles, currentProfiles);
  }
  protected List<LaserProfile> profiles = null;
  public static final String PROP_PROFILES = "profiles";

  /**
   * Get the value of materials
   *
   * @return the value of materials
   */
  public List<LaserProfile> getProfiles()
  {
    return profiles;
  }

  /**
   * Set the value of materials
   *
   * @param profile new value of materials
   */
  public void setProfiles(List<LaserProfile> profiles)
  {
    List<LaserProfile> oldMaterials = this.profiles;
    this.profiles = profiles;
    firePropertyChange(PROP_PROFILES, oldMaterials, profiles);
    List<LaserProfile> cur = new LinkedList<LaserProfile>();
    if (profiles != null)
    {
      cur.addAll(profiles);
    }
    this.setCurrentProfiles(cur);
  }
  
  /** Creates new form EditMaterialsDialog */
  public EditProfilesDialog(java.awt.Frame parent, boolean modal)
  {
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        Profiles = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        editableTablePanel1 = new com.t_oster.visicut.gui.beans.EditableTablePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/t_oster/visicut/gui/resources/EditProfilesDialog"); // NOI18N
        setTitle(bundle.getString("TITLE")); // NOI18N
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.t_oster.visicut.gui.VisicutApp.class).getContext().getResourceMap(EditProfilesDialog.class);
        Profiles.setText(resourceMap.getString("Profiles.text")); // NOI18N
        Profiles.setName("Profiles"); // NOI18N

        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setName("jButton4"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText(resourceMap.getString("jButton5.text")); // NOI18N
        jButton5.setName("jButton5"); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        editableTablePanel1.setName("editableTablePanel1"); // NOI18N
        editableTablePanel1.setProvider(this);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentProfiles}"), editableTablePanel1, org.jdesktop.beansbinding.BeanProperty.create("objects"), "materials");
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editableTablePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                    .addComponent(Profiles)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Profiles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editableTablePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
  this.setProfiles(this.getCurrentProfiles());
  this.setVisible(false);
}//GEN-LAST:event_jButton4ActionPerformed

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
  this.setProfiles(null);
  this.setVisible(false);
}//GEN-LAST:event_jButton5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Profiles;
    private com.t_oster.visicut.gui.beans.EditableTablePanel editableTablePanel1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public Object getNewInstance() {
      JComboBox choose = new JComboBox();
      choose.addItem(java.util.ResourceBundle.getBundle("com/t_oster/visicut/gui/resources/EditProfilesDialog").getString("LINE PROFILE"));
      choose.addItem(java.util.ResourceBundle.getBundle("com/t_oster/visicut/gui/resources/EditProfilesDialog").getString("RASTER PROFILE"));
      choose.addItem(java.util.ResourceBundle.getBundle("com/t_oster/visicut/gui/resources/EditProfilesDialog").getString("RASTER3D PROFILE"));
      if (JOptionPane.showConfirmDialog(this, choose, java.util.ResourceBundle.getBundle("com/t_oster/visicut/gui/resources/EditProfilesDialog").getString("WHICH KIND OF PROFILE?"), JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
          if (choose.getSelectedItem().equals(java.util.ResourceBundle.getBundle("com/t_oster/visicut/gui/resources/EditProfilesDialog").getString("LINE PROFILE"))) {
              return editObject(new VectorProfile());
          } else if (choose.getSelectedItem().equals(java.util.ResourceBundle.getBundle("com/t_oster/visicut/gui/resources/EditProfilesDialog").getString("RASTER PROFILE"))) {
              return editObject(new RasterProfile());
          } else if (choose.getSelectedItem().equals(java.util.ResourceBundle.getBundle("com/t_oster/visicut/gui/resources/EditProfilesDialog").getString("RASTER3D PROFILE"))) {
              return editObject(new Raster3dProfile());
          }

      }
      return null;
}

    public Object editObject(Object selected) {
      if (selected instanceof VectorProfile) {
          EditVectorProfileDialog d = new EditVectorProfileDialog(null, true);
          d.setVectorProfile((VectorProfile) selected);
          d.setVisible(true);
          return d.getVectorProfile();
      } else if (selected instanceof RasterProfile) {
          EditRasterProfileDialog d = new EditRasterProfileDialog(null, true);
          d.setRasterProfile((RasterProfile) selected);
          d.setVisible(true);
          return d.getRasterProfile();
      } else if (selected instanceof Raster3dProfile) {
          EditRaster3dProfileDialog d = new EditRaster3dProfileDialog(null, true);
          d.setRasterProfile((Raster3dProfile) selected);
          d.setVisible(true);
          return d.getRasterProfile();
      }
      return null;
  }
}