package com.learn_spring_security.basic.jwt;

import static org.springframework.security.config.Customizer.withDefaults;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPublicKey;
import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.KeySourceException;
import com.nimbusds.jose.jwk.JWKSelector;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

@Configuration
public class JwtSecurityConfiguration {
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
		//http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		http.sessionManagement(session -> 
			session.sessionCreationPolicy(
					SessionCreationPolicy.STATELESS));
		
		http.csrf(csrf -> csrf.disable());
		
		http.headers(
				headers -> headers.frameOptions(
					t -> t.sameOrigin()));
		
		http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
		
		return http.build();
	}
	
	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
				.build();
	}
	
	@Bean UserDetailsService userDetailsService(DataSource dataSource) {
		var user = User.withUsername("Lee")
				.password("pass")
				.passwordEncoder(str -> passwordEncoder().encode(str))
				.roles("USER")
				.build();
		
		UserDetails admin = User.withUsername("admin")
				.password("pass")
				.passwordEncoder(str -> passwordEncoder().encode(str))
				.roles("ADMIN")
				.build();
		
		var jdbcUserDetailsManger = new JdbcUserDetailsManager(dataSource);
		jdbcUserDetailsManger.createUser(user);
		jdbcUserDetailsManger.createUser(admin);
		
		return jdbcUserDetailsManger;
	} 
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// KeyPair 생성
	@Bean
	public KeyPair keyPair() {
		try {
			var keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(2048);
			
			return keyPairGenerator.genKeyPair();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	// KeyPair를 이용해서 RSA Key 만들기
	@Bean
	public RSAKey rsaKey(KeyPair keyPair) {
		return new RSAKey
			.Builder((RSAPublicKey)keyPair.getPublic())
			.privateKey(keyPair.getPrivate())
			.keyID(UUID.randomUUID().toString())
			.build();
	}
	
	@Bean
	public JWKSource<SecurityContext> jwkSource(RSAKey rsaKey) {
		var jwkSet = new JWKSet(rsaKey);
		
		return (jwkSelector, context) -> jwkSelector.select(jwkSet);
	}
	
	@Bean
	public JwtDecoder jwtDecorder(RSAKey rsaKey) throws JOSEException {
		return NimbusJwtDecoder
				.withPublicKey(rsaKey.toRSAPublicKey())
				.build();
	}
	
	// Encoder
	@Bean
	public JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource) {
		return new NimbusJwtEncoder(jwkSource);
	}
}
