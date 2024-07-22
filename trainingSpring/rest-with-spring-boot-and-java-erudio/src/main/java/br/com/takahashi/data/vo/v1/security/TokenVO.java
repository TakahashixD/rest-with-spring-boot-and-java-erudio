package br.com.takahashi.data.vo.v1.security;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class TokenVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String username;
	private Boolean autheticated;
	private LocalDateTime created;
	private LocalDateTime expiration;
	private String accessToken;
	private String refreshToken;
	
	public TokenVO() {
		
	}
	public TokenVO(String username, Boolean autheticated, LocalDateTime created, LocalDateTime expiration,
			String accessToken, String refreshToken) {
		this.username = username;
		this.autheticated = autheticated;
		this.created = created;
		this.expiration = expiration;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Boolean getAutheticated() {
		return autheticated;
	}
	public void setAutheticated(Boolean autheticated) {
		this.autheticated = autheticated;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public LocalDateTime getExpiration() {
		return expiration;
	}
	public void setExpiration(LocalDateTime expiration) {
		this.expiration = expiration;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(accessToken, autheticated, created, expiration, refreshToken, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TokenVO other = (TokenVO) obj;
		return Objects.equals(accessToken, other.accessToken) && Objects.equals(autheticated, other.autheticated)
				&& Objects.equals(created, other.created) && Objects.equals(expiration, other.expiration)
				&& Objects.equals(refreshToken, other.refreshToken) && Objects.equals(username, other.username);
	}
	
	
	
}
