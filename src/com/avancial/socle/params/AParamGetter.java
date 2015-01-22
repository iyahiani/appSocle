/**
 * 
 */
package com.avancial.socle.params;

import java.util.List;

import com.avancial.socle.params.beans.IParamBean;

/**
 * @author bruno.legloahec
 *
 */
public abstract class AParamGetter implements IParamGetter {

   /**
    * Constructeur
    */
   public AParamGetter() {
      // TODO Auto-generated constructor stub
   }

   /* (non-Javadoc)
    * @see com.avancial.socle.params.IParamGetter#add(com.avancial.socle.params.IParamReader)
    */
   @Override
   public void add(IParamReader iParamReader) {
      // TODO Auto-generated method stub

   }

   /* (non-Javadoc)
    * @see com.avancial.socle.params.IParamGetter#getParam(java.lang.String, java.lang.String)
    */
   @Override
   public IParamBean getParam(String paramType, String paramName) {
      // TODO Auto-generated method stub
      return null;
   }

   /* (non-Javadoc)
    * @see com.avancial.socle.params.IParamGetter#getParamsFromCollection(java.lang.String)
    */
   @Override
   public List<IParamBean> getParamsFromCollection(String paramType) {
      // TODO Auto-generated method stub
      return null;
   }

}
