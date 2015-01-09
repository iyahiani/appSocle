/**
 * 
 */
package com.avancial.socle.params;

import java.util.HashMap;
import java.util.Map;

import com.avancial.socle.params.beans.IParamBean;
import com.avancial.socle.params.exception.ParamCollectionNotLoadedException;
import com.avancial.socle.params.exception.ParamNotFoundException;

/**
 * @author bruno
 *
 */
public class ParamGetterBean {
   private Map<String, Map<String, IParamBean>> mapParamBean;

   /**
    * Initialise la structure qui va accueillir les paramBean
    * 
    * @param listeParam
    * 
    */
   public ParamGetterBean() {
      this.mapParamBean = new HashMap<>();
   }

   /**
    * @param iParamReader
    */
   public void add(IParamReader iParamReader) {

      HashMap<String, IParamBean> mapParamBeanTmp = new HashMap<>();
      for (IParamBean iParamBean : iParamReader.getParams()) {
         mapParamBeanTmp.put(iParamBean.getName(), iParamBean);
      }
      this.mapParamBean.put(iParamReader.getParamsName(), mapParamBeanTmp);

   }

   /**
    * Permet de récupérer le paramètre sous forme de bean
    * 
    * @param paramType
    *           Le nom de la collection des paramètres
    * @param paramName
    *           Le nom d'un paramètre de cette collection
    * @return parametre sous forme de bean
    * @throws Exception
    */
   public IParamBean getParam(String paramType, String paramName) throws Exception {
      if (this.mapParamBean.containsKey(paramType)) {

         IParamBean bean = this.mapParamBean.get(paramType).get(paramName);
         if (null != bean)
            return bean;
         throw new ParamNotFoundException(paramType, paramName);
      }
      throw new ParamCollectionNotLoadedException(paramType);
   }
}
