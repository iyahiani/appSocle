/**
 * 
 */
package com.avancial.socle.exceptions;

/**
 * @author bruno.legloahec
 *
 */
public class SocleExceptionBuilderSqlDuplicateId extends ASocleExceptionBuilder {

   /**
    * Constructeur
    * 
    * @param next
    * @param e
    */
   public SocleExceptionBuilderSqlDuplicateId(ISocleExceptionBuilder next, Exception e) {
      super(next, e);

   }

   /*
    * (non-Javadoc)
    * 
    * @see
    * com.avancial.socle.exceptions.ASocleExceptionBuilder#getSocleException()
    */
   @Override
   public ISocleException getSocleException() {
      // TODO Auto-generated method stub
      return null;
   }

}
