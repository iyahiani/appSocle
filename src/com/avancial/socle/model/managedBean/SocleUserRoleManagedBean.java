/**
 * 
 */
package com.avancial.socle.model.managedBean;

import java.util.ArrayList;

import javax.inject.Named;

import com.avancial.socle.data.controller.dao.UserRoleDao;

/**
 * @author bruno.legloahec
 *
 */
@Named("userRole")
public class SocleUserRoleManagedBean {

   /**
    * Constructeur
    */
   public SocleUserRoleManagedBean() {

   }

   /**
    * @return the userRoleList
    */
   public ArrayList<UserRoleDao> getUserRoleList() {
      return new UserRoleDao().getAll();
   }

}
