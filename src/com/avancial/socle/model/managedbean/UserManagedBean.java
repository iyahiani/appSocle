package com.avancial.socle.model.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.avancial.socle.data.controller.dao.UserDao;
import com.avancial.socle.data.model.databean.UserDataBean;

@Named("userManagedBean")
@ViewScoped
public class UserManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<UserDataBean> users;

	public UserManagedBean() {
		this.users = new ArrayList<>();
		this.users.addAll(new UserDao().getAll());
	}

	public List<UserDataBean> getUsers() {
		return this.users;
	}
}