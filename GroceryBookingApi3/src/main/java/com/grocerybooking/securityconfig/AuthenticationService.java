//package com.grocerybooking.securityconfig;
//
//import javax.servlet.http.HttpServletRequest;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.authority.AuthorityUtils;
//import org.springframework.security.authentication.BadCredentialsException;
//
//public class AuthenticationService {
//
//	private static final String AUTH_TOKEN_HEADER_NAME = "G-API-KEY";
//    private static final String AUTH_TOKEN = "grocerybooking";
//
//    public static Authentication getAuthentication(HttpServletRequest request) {
//        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);
//        if (apiKey == null || !apiKey.equals(AUTH_TOKEN)) {
//            throw new BadCredentialsException("Invalid API Key");
//        }
//
//        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
//    }
//}
