/**
 * 
 */
package com.avancial.socle.exceptions;

/**
 * C'est le point d'entrée pour le client
 * 
 * @author bruno.legloahec
 *
 */
public class SocleExceptionManager {

   public static ASocleException getException(Exception e) {

      ISocleExceptionBuilder builder = new SocleExceptionBuilderSqlDuplicateId(null, e);
      return builder.getSocleException();
   }
}
