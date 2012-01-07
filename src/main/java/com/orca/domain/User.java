package com.orca.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
@Entity
@Table(name = "User")
public class User implements UserDetails {

	@Id
	@GeneratedValue
	private Integer id;
	private String username;
	private String password;
	private String confirmPassword;
	private boolean isAdmin;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="user")
	private Set <Evaluation> evaluationSet = new HashSet<Evaluation>();
	
	
	public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authenticationList = new ArrayList<GrantedAuthority>(2);
        authenticationList.add(new GrantedAuthorityImpl("ROLE_USER"));
        if (isAdmin) {
        	authenticationList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
        }
        return authenticationList;
    }
	
	public void addEvaluation(Evaluation evaluation) {
		evaluationSet.add(evaluation);
		evaluation.setUser(this);
	}
	
	public Set<Evaluation> getEvaluationSet() {
		return evaluationSet;
	}

	public void setEvaluationSet(Set<Evaluation> evaluationSet) {
		this.evaluationSet = evaluationSet;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((confirmPassword == null) ? 0 : confirmPassword.hashCode());
		result = prime * result
				+ ((evaluationSet == null) ? 0 : evaluationSet.hashCode());
		result = prime * result + (isAdmin ? 1231 : 1237);
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (confirmPassword == null) {
			if (other.confirmPassword != null)
				return false;
		} else if (!confirmPassword.equals(other.confirmPassword))
			return false;
		if (evaluationSet == null) {
			if (other.evaluationSet != null)
				return false;
		} else if (!evaluationSet.equals(other.evaluationSet))
			return false;
		if (isAdmin != other.isAdmin)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	
}

