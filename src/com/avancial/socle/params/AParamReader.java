/**
 * 
 */
package com.avancial.socle.params;

import java.util.Collection;

import com.avancial.socle.params.beans.IParamBean;

/**
 * @author bruno
 *
 */
public abstract class AParamReader implements IParamReader {
   protected String                 paramsName;
   protected Collection<IParamBean> colIParamBeans;

   /**
    * get value for paramName
    * 
    * @return the paramName
    */
   @Override
   public String getParamsName() {
      return this.paramsName;
   }

   /**
    * sets value for paramName
    * 
    * @param paramsName
    *           the paramName to set
    */
   public void setParamsName(String paramsName) {
      this.paramsName = paramsName;
   }

   @Override
   public Collection<IParamBean> getParams() {
      return this.colIParamBeans;
   }

}
