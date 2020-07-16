package com.wm.spring.boot.entity;

public class User {
	private Long id;
	private String username;
	private String note;

	public User(){
	}

	public User(Builder builder) {
		this.id = builder.id;
		this.username = builder.username;
		this.note = builder.note;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public static class Builder{
		private Long id;
		private String username;
		private String note;

		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setNote(String note) {
			this.note = note;
			return this;
		}

		public Builder setUsername(String username) {
			this.username = username;
			return this;
		}

		public User builder(){
			return new User(this);
		}
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", note='" + note + '\'' +
				'}';
	}
}
