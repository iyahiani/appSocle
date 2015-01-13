/**
 * 
 */
package com.avancial.socle.params;

import com.avancial.socle.data.controller.dao.AbstractDao;

/**
 * @author bruno.legloahec
 *
 */
public class ParamReaderDB extends AParamReader {
   private AbstractDao dao;

   /**
    * Constructeur
    */
   public ParamReaderDB(AbstractDao dao) {
      this.setDao(dao);
   }

   /*
    * (non-Javadoc)
    * 
    * @see com.avancial.socle.params.IParamReader#loadParams(java.lang.String)
    */
   @Override
   public void loadParams(String paramsName) throws Exception {
      // TODO ou pas
   }

   /**
    * @return the dao
    */
   public AbstractDao getDao() {
      return this.dao;
   }

   /**
    * @param dao
    *           the dao to set
    */
   public void setDao(AbstractDao dao) {
      this.dao = dao;
   }

}
