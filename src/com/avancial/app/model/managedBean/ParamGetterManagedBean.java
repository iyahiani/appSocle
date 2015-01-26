/**
 * 
 */
package com.avancial.app.model.managedBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.avancial.socle.params.AParamGetter;

/**
 * Classe impl�mentant un point unique de gestion des param�tres. Inspir� du
 * design patttern Facade. <br>
 * Voir{@link IParamBean, IParamReader}
 * 
 * @author bruno
 *
 */
@Named("paramGetterBean")
@ApplicationScoped
public class ParamGetterManagedBean extends AParamGetter {

   /**
    * Constructeur
    * 
    * @throws Exception
    */
   public ParamGetterManagedBean() throws Exception {
      super();
   }

}
