/**
 * 
 */
package com.avancial.socle.params;

import com.avancial.socle.params.beans.IParamBean;
import com.avancial.socle.params.beans.ParamBeanGeneric;

/**
 * @author bruno
 *
 */
public class ParamReaderPropertieFileDir extends AParamReaderFile {

   /**
    * @param filePath
    * @param paramsName
    */
   public ParamReaderPropertieFileDir(String filePath) {
      super(filePath);
   }

   /*
    * (non-Javadoc)
    * 
    * @see appsocle.params.IParamReader#loadParams(java.lang.String)
    */
   @Override
   public void loadParams(String paramsName) {
      this.paramsName = paramsName;
      IParamBean paramBean = new ParamBeanGeneric();
      paramBean.setName("Temp Directory");
      paramBean.SetValue("c:/tmp");
      this.colIParamBeans.add(paramBean);

      paramBean = new ParamBeanGeneric();
      paramBean.setName("Work Directory");
      paramBean.SetValue("c:/work");
      this.colIParamBeans.add(paramBean);

   }

}
