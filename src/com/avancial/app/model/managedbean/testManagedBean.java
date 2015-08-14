/**
 * 
 */
package com.avancial.app.model.managedbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.avancial.socle.data.controller.dao.User2RoleDao;
import com.avancial.socle.data.model.databean.User2RoleDataBean;
import com.avancial.socle.model.managedbean.IhmManagedBean;

/**
 * @author bruno.legloahec
 *
 */
@Named("test")
@RequestScoped
public class testManagedBean implements Serializable {
   private static final long serialVersionUID = 1L;
   private User2RoleDataBean user2Role;

   @Inject
   private IhmManagedBean    ihmManagedBean;

   /**
    * Constructeur
    */
   public testManagedBean() {

   }

   @PostConstruct
   public void init() {
      User2RoleDao dao = new User2RoleDao();
      // dao.getAll();
      if (null != this.ihmManagedBean)
         if (null != this.ihmManagedBean.getCurrentUser())
            dao.getUser2RoleByIdUser(this.ihmManagedBean.getCurrentUser().getIdUser());
   }

   /**
    * @return the user2Role
    */
   public User2RoleDataBean getUser2Role() {
      return this.user2Role;
   }

   /**
    * @param user2Role
    *           the user2Role to set
    */
   public void setUser2Role(User2RoleDataBean user2Role) {
      this.user2Role = user2Role;
   }
}
