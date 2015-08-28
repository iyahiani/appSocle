/**
 * 
 */
package com.avancial.socle.init;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.avancial.socle.jobs.JobTest;

/**
 * @author bruno.legloahec
 *
 */
@WebServlet(loadOnStartup = 1, urlPatterns = "/init")
public class SocleInit extends HttpServlet {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   /*
    * (non-Javadoc)
    * 
    * @see javax.servlet.GenericServlet#init()
    */
   @Override
   public void init() throws ServletException {
      super.init();
      System.out.println("**********************************************");
      System.out.println("********  Application initialization  ********");
      System.out.println("**********************************************");
      try {
         this.quartzInit();
      } catch (SchedulerException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   /**
    * @throws SchedulerException
    * 
    */
   private void quartzInit() throws SchedulerException {
      SchedulerFactory sf = new StdSchedulerFactory();
      Scheduler sched = sf.getScheduler();
      // define the job and tie it to our HelloJob class
      JobDetail job = JobBuilder.newJob(JobTest.class).withIdentity("dummyJobName", "group1").build();

      // Trigger the job to run on the next round minute
      Trigger trigger = TriggerBuilder.newTrigger().withIdentity("dummyTriggerName", "group1").withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever()).build();
      sched.start();
      // sched.scheduleJob(job, trigger);
   }

}
