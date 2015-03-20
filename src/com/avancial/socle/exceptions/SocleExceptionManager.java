/**
 * 
 */
package com.avancial.socle.exceptions;

/**
 * @author bruno.legloahec
 *
 */
public class SocleExceptionManager {

   public static ASocleException getException(Exception e) {

      ISocleExceptionBuilder builder = new SocleExceptionBuilderSqlDuplicateId(null, e);
      return builder.getSocleException();
   }
}
