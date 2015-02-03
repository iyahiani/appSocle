/**
 * 
 */
package com.avancial.socle.model.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.avancial.socle.data.controller.dao.UserRoleDao;
import com.avancial.socle.data.model.databean.UserRoleDataBean;

/**
 * @author bruno.legloahec
 *
 */
@Named("userRoleManagedBean")
@RequestScoped
public class UserRoleManagedBean {
   private List<UserRoleDataBean> userRoles;

   /**
    * Constructeur
    */
   public UserRoleManagedBean() {
      this.userRoles = new ArrayList<>();
      this.userRoles.addAll(new UserRoleDao().getAll());

   }

   /**
    * @return the userRoleList
    */
   public List<UserRoleDataBean> getUserRoles() {
      return this.userRoles;
   }

}
