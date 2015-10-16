/**
 * 
 */
package com.avancial.app.model.managedbean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 * @author bruno.legloahec
 *
 */
// @Named("test")
@ManagedBean(name = "test")
@RequestScoped
public class testManagedBean implements Serializable {
   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   @ManagedProperty(name = "message", value = "#{message}")
   private TestMessage       message;

   public void click() {
      System.err.println(this.message.getMessage());
   }

   public void sayHello() {
      // System.out.println(this.message.getMessage());
   }

   /**
    * @return the message
    */
   public TestMessage getMessage() {
      return this.message;
   }

   /**
    * @param message
    *           the message to set
    */
   public void setMessage(TestMessage message) {
      this.message = message;
   }
}
