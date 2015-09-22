/**
 * 
 */
package com.avancial.socle.model.managedbean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.avancial.socle.data.controller.dao.Item2RoleDao;
import com.avancial.socle.data.model.databean.Item2RoleDataBean;

/**
 * @author bruno
 *
 */
@Named("security")
@ApplicationScoped
public class SecurityManagedBean implements Serializable {
   /**
    * 
    */
   private static final long              serialVersionUID = 1L;
   private Map<String, Item2RoleDataBean> listeItem2Role;
   @Inject
   private IhmManagedBean                 ihmManagedBean;

   /**
    * Constructeur
    */
   public SecurityManagedBean() {
      this.listeItem2Role = new HashMap<>();
   }

   @PostConstruct
   public void init() {

      this.remplirListeItem2Role();
   }

   public boolean isRendered(String itemName) {
      Boolean result = false;
      Item2RoleDataBean bean = this.listeItem2Role.get(itemName);
      if (null != bean)
         result = bean.getIsRendered();
      return result;
   }

   public void reload() {
      this.listeItem2Role.clear();
      this.remplirListeItem2Role();

   }

   /**
    * 
    */
   private void remplirListeItem2Role() {
      Item2RoleDao dao = new Item2RoleDao();
      if (null == this.ihmManagedBean)
         return;
      for (Item2RoleDataBean bean : dao.getitemByListId(this.ihmManagedBean.getCurrentUser().getRoles())) {
         this.listeItem2Role.put(bean.getNameItem2Role(), bean);
      }

   }

}
