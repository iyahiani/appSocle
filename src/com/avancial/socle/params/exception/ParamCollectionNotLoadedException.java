/**
 * 
 */
package com.avancial.socle.params.exception;

/**
 * @author bruno.legloahec
 *
 */
public class ParamCollectionNotLoadedException extends Exception {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   /**
    * Constructeur
    */
   public ParamCollectionNotLoadedException(String type) {
      super(String.format("La collection '%s' n'a pas �t� charg�e", type));
   }
}
