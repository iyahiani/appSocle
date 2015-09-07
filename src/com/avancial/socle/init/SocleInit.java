/**
 * 
 */
package com.avancial.socle.init;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.avancial.socle.data.controller.dao.JobPlanifDao;
import com.avancial.socle.data.model.databean.JobPlanifDataBean;
import com.avancial.socle.resources.constants.SOCLE_constants;

/**
 * @author bruno.legloahec
 *
 */
@WebServlet(loadOnStartup = 1, urlPatterns = "/init")
public class SocleInit extends HttpServlet {
   public Scheduler          sched;

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
         FacesContext.getCurrentInstance().getExternalContext().redirect(SOCLE_constants.NAVIGATION_ACCUEIL.name());
      } catch (SchedulerException | IOException e) {
         e.printStackTrace();
      }
   }

   /**
    * @throws SchedulerException
    * 
    */
   private void quartzInit() throws SchedulerException {

      JobPlanifDao dao = new JobPlanifDao();
      List<JobPlanifDataBean> jobs = new ArrayList<>();
      jobs = dao.getAll();

      SchedulerFactory sf = new StdSchedulerFactory();
      this.sched = sf.getScheduler();

      for (JobPlanifDataBean jobPlanifDataBean : jobs) {
         Job newjob = null;
         try {
            newjob = (Job) Class.forName(jobPlanifDataBean.getJob().getClasseJob()).newInstance();

         } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
         }
         JobDetail job = JobBuilder.newJob(newjob.getClass()).withIdentity(jobPlanifDataBean.getLibelleJobPlanif(), "group1").build();
         Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobPlanifDataBean.getLibelleJobPlanif() + " trigger", "group1").withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever()).build();
         this.sched.scheduleJob(job, trigger);

      }

      // define the job and tie it to our HelloJob class

      // Trigger the job to run on the next round minute

      this.sched.start();
   }
}
