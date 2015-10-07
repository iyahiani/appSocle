/**
 * 
 */
package com.avancial.socle.params;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.avancial.socle.data.controller.dao.RefDirectoryDao;
import com.avancial.socle.params.beans.IParamBean;
import com.avancial.socle.params.exception.ParamCollectionNotLoadedException;
import com.avancial.socle.params.exception.ParamNotFoundException;
import com.avancial.socle.resources.constants.SOCLE_constants;

/**
 * Classe abstraite servant de base pour cr�er une classe impl�mentant la gestion des param�tres d'une application
 * 
 * 
 * @author bruno.legloahec
 *
 */
public abstract class AParamGetter implements IParamGetter {
   private Map<String, Map<String, IParamBean>> mapParamBean;
   private String                               pathToWebInf;

   /**
    * Constructeur
    * 
    * @throws Exception
    */
   public AParamGetter() throws Exception {
      this.mapParamBean = new HashMap<>();
      this.initPathToWebInf();

      // On instancie les Param�tres du socle
      ParamReaderFileGeneric socle = new ParamReaderFileGeneric(this.pathToWebInf + SOCLE_constants.SOCLE_PROPERTIES_PATH.toString());
      socle.loadParams("socle");
      this.add(socle);

      AParamReaderDB paramDb = new ParamReaderDBDirectory(new RefDirectoryDao());
      paramDb.loadParams("directories");
      this.add(paramDb);
   }

   /**
    * Ajouter un reader de param�tre � la collection
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
    * Permet de r�cup�rer le chemin d'acc�s au r�pertoire web-inf. Utilis� pour atteindre les fichiers de param�tres (.properties)
    */
   private void initPathToWebInf() {
      String path = "";
      String WEBINF = "WEB-INF";
      URL url = AParamGetter.class.getResource("AParamGetter.class");

      String className = url.getFile();

      path = className.substring(0, className.indexOf(WEBINF) + WEBINF.length());
      this.pathToWebInf = path;

   }

   /**
    * Permet de r�cup�rer le param�tre sous forme de bean
    * 
    * @param paramType
    *           Le nom de la collection des param�tres
    * @param paramName
    *           Le nom d'un param�tre de cette collection
    * @return parametre sous forme de bean
    * @throws ParamNotFoundException
    * @throws ParamCollectionNotLoadedException
    */
   @Override
   public IParamBean getParam(String paramType, String paramName) throws ParamNotFoundException, ParamCollectionNotLoadedException {
      if (this.mapParamBean.containsKey(paramType)) {

         IParamBean bean = this.mapParamBean.get(paramType).get(paramName);
         if (null != bean)
            return bean;
         throw new ParamNotFoundException(paramType, paramName);
      }
      throw new ParamCollectionNotLoadedException(paramType);
   }

   /**
    * Permet de r�cup�rer tous les param�tres associ�s � un type
    * 
    * @param paramType
    * @return La liste des param�tres associ�s � la collection
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
    * @return Le chemin d'acc�s au r�pertoire Web-inf de l'application
    */
   protected String getPathToWebInf() {

      return this.pathToWebInf;
   }

   public Map<String, Map<String, IParamBean>> getMapParamBean() {
      return this.mapParamBean;
   }

   public void setMapParamBean(Map<String, Map<String, IParamBean>> mapParamBean) {
      this.mapParamBean = mapParamBean;
   }

   public void setPathToWebInf(String pathToWebInf) {
      this.pathToWebInf = pathToWebInf;
   }
}
