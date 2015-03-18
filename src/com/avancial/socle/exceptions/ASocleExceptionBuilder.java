/**
 * 
 */
package com.avancial.socle.exceptions;

/**
 * @author bruno.legloahec
 *
 */
public abstract class ASocleExceptionBuilder implements ISocleExceptionBuilder {
   private ISocleExceptionBuilder next;
   private Exception              e;
   protected StringBuilder        buffer = new StringBuilder();

   /**
    * Constructeur
    */
   public ASocleExceptionBuilder(ISocleExceptionBuilder next, Exception e) {
      this.setE(e);
      this.next = next;
      // On tente de récupérer l'exception parente
      Throwable t = e.getCause();
      this.buffer.append(t.getCause().getMessage());
   }

   /*
    * (non-Javadoc)
    * 
    * @see
    * com.avancial.socle.exceptions.ISocleExceptionBuilder#getSocleException
    * (com.avancial.socle.exceptions.ISocleExceptionBuilder,
    * java.lang.Exception)
    */
   @Override
   abstract public ISocleException getSocleException();

   /*
    * (non-Javadoc)
    * 
    * @see com.avancial.socle.exceptions.ISocleExceptionBuilder#getNext()
    */
   @Override
   public ISocleExceptionBuilder getNext() {
      return this.next;
   };

   /**
    * @param next
    *           the next to set
    */
   public void setNext(ISocleExceptionBuilder next) {
      this.next = next;
   }

   /**
    * @return the e
    */
   public Exception getE() {
      return this.e;
   }

   /**
    * @param e
    *           the e to set
    */
   public void setE(Exception e) {
      this.e = e;
   }

}
