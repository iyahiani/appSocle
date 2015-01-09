/**
 * 
 */
package com.avancial.socle.model.managedBean;

import java.io.Serializable;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.avancial.socle.params.IParamReader;
import com.avancial.socle.params.ParamReaderFileGeneric;
import com.avancial.socle.params.beans.IParamBean;
import com.avancial.socle.params.exception.ParamCollectionNotLoadedException;
import com.avancial.socle.params.exception.ParamNotFoundException;

/**
 * @author bruno
 *
 */
@Named("paramGetterBean")
@ApplicationScoped
public class ParamGetterBean implements Serializable {
   /**
    * 
    */
   private static final long                    serialVersionUID = 1L;
   private Map<String, Map<String, IParamBean>> mapParamBean;

   /**
    * Initialise la structure qui va accueillir les paramBean
    * 
    * @param listeParam
    * @throws Exception
    * 
    */
   public ParamGetterBean() throws Exception {
      this.mapParamBean = new HashMap<>();
      String filePath = "";
      String WEBINF = "WEB-INF";
      URL url = ParamGetterBean.class.getResource("ParamGetterBean.class");

      String className = url.getFile();

      filePath = className.substring(0, className.indexOf(WEBINF) + WEBINF.length());

      // On instancie les Paramètres du socle
      ParamReaderFileGeneric socle = new ParamReaderFileGeneric(filePath + "/classes/com/avancial/socle/resources/socle.properties");
      socle.loadParams("socle");
      this.add(socle);
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
