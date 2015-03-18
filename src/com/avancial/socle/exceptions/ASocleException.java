/**
 * 
 */
package com.avancial.socle.exceptions;

/**
 * @author bruno.legloahec
 *
 */
public abstract class ASocleException implements ISocleException {

   private Exception originalException;

   /**
    * Constructeur
    */
   public ASocleException(Exception originalException) {
      this.setOriginalException(originalException);
   }

   /*
    * (non-Javadoc)
    * 
    * @see com.avancial.socle.exceptions.ISocleException#getOriginalException()
    */
   @Override
   abstract public Exception getOriginalException();

   /*
    * (non-Javadoc)
    * 
    * @see com.avancial.socle.exceptions.ISocleException#getClientMessage()
    */
   @Override
   abstract public String getClientMessage();

   /**
    * @param originalException the originalException to set
    */
   public void setOriginalException(Exception originalException) {
      this.originalException = originalException;
   }

}
