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
public class ParamReaderPropertieFileDays extends AParamReaderFile {

   /**
    * @param filePath
    * @param paramsName
    */
   public ParamReaderPropertieFileDays(String filePath) {
      super(filePath);
   }

   @Override
   public void loadParams(String paramsName) {
      this.paramsName = paramsName;
      IParamBean paramBean = new ParamBeanGeneric();
      paramBean.setName("Lundi");
      paramBean.SetValue("Monday");
      this.colIParamBeans.add(paramBean);

      paramBean = new ParamBeanGeneric();
      paramBean.setName("Mardi");
      paramBean.SetValue("Tuesday");
      this.colIParamBeans.add(paramBean);

   }

}
