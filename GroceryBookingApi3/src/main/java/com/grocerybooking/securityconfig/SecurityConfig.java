//package com.grocerybooking.securityconfig;
//
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//	
//	@Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf()
//          .disable()
//          .authorizeRequests()
//          .antMatchers("/**")
//          .authenticated()
//          .and()
//          .httpBasic()
//          .and()
//          .sessionManagement()
//          .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//          .and()
//          .addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//
//
//}
