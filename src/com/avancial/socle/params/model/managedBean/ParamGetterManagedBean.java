/**
 * 
 */
package com.avancial.socle.params.model.managedBean;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.avancial.socle.data.controller.dao.RefDirectoryDao;
import com.avancial.socle.params.AParamGetter;
import com.avancial.socle.params.IParamReader;
import com.avancial.socle.params.ParamReaderDB;
import com.avancial.socle.params.ParamReaderDBDirectory;
import com.avancial.socle.params.ParamReaderFileGeneric;
import com.avancial.socle.params.beans.IParamBean;
import com.avancial.socle.params.exception.ParamCollectionNotLoadedException;
import com.avancial.socle.params.exception.ParamNotFoundException;

/**
 * Classe implémentant un point unique de gestion des paramètres. Inspiré du
 * design patttern Facade. <br>
 * Voir{@link IParamBean, IParamReader}
 * 
 * @author bruno
 *
 */
@Named("paramGetterBean")
@ApplicationScoped
public class ParamGetterManagedBean extends AParamGetter implements Serializable {
   /**
    * 
    */
   private static final long                    serialVersionUID = 1L;
   private Map<String, Map<String, IParamBean>> mapParamBean;
   private String                               pathToWebInf;

   /**
    * Initialise la structure qui va accueillir les paramBean
    * 
    * @param listeParam
    * @throws Exception
    * 
    */
   public ParamGetterManagedBean() throws Exception {
      this.mapParamBean = new HashMap<>();
      this.initPathToWebInf();

      // On instancie les Paramètres du socle
      ParamReaderFileGeneric socle = new ParamReaderFileGeneric(this.pathToWebInf + "/classes/com/avancial/socle/resources/socle.properties");
      socle.loadParams("socle");
      this.add(socle);

      ParamReaderDB paramDb = new ParamReaderDBDirectory(new RefDirectoryDao());
      paramDb.loadParams("directories");
      this.add(paramDb);

   }

   /**
    * Permet de récupérer le chemin d'accès au répertoire web-inf. Utilisé pour
    * atteindre les fichiers de paramètres (.properties)
    */
   private void initPathToWebInf() {
      String path = "";
      String WEBINF = "WEB-INF";
      URL url = ParamGetterManagedBean.class.getResource("ParamGetterManagedBean.class");

      String className = url.getFile();

      path = className.substring(0, className.indexOf(WEBINF) + WEBINF.length());
      this.pathToWebInf = path;

   }

   /**
    * Ajouter un reader de paramètre à la collection
    * 
    * @param iParamReader
    */
   @Override
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
   @Override
   public IParamBean getParam(String paramType, String paramName) throws Exception {
      if (this.mapParamBean.containsKey(paramType)) {

         IParamBean bean = this.mapParamBean.get(paramType).get(paramName);
         if (null != bean)
            return bean;
         throw new ParamNotFoundException(paramType, paramName);
      }
      throw new ParamCollectionNotLoadedException(paramType);
   }

   /**
    * @param paramType
    * @return La liste des paramètres associés à la collection
    * @throws ParamCollectionNotLoadedException
    */
   @Override
   public List<IParamBean> getParamsFromCollection(String paramType) throws ParamCollectionNotLoadedException {
      if (this.mapParamBean.containsKey(paramType)) {
         ArrayList<IParamBean> liste = new ArrayList<>();
         liste.addAll(this.mapParamBean.get(paramType).values());
         return liste;
      }
      throw new ParamCollectionNotLoadedException(paramType);
   }

   /**
    * @return Le chemin d'accès au répertoire Web-inf de l'application
    */
   protected String getPathToWebInf() {

      return this.pathToWebInf;
   }

}
