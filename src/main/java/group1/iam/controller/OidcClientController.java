package group1.iam.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OidcClientController {

    /**
     * Home page endpoint. This page is accessible after authentication.
     * @return The name of the Thymeleaf template (index.html).
     */
    @GetMapping("/")
    public String index() {
        return "index"; // Assuming you have an 'index.html' template
    }

    /**
     * Secured endpoint that triggers the OIDC login flow if the user is unauthenticated.
     * After successful authentication, Spring Security injects the OidcUser object.
     * @param oidcUser The authenticated user principal, containing OIDC claims.
     * @param model The model for passing data to the view.
     * @return The name of the Thymeleaf template (secured.html).
     */
    @GetMapping("/securedprofile")
    public String viewProfile(@AuthenticationPrincipal OidcUser oidcUser, Model model) {
        
        // 1. Check if the user is authenticated (should be, or Spring Security would intercept)
        if (oidcUser != null) {
            // 2. Extract and expose key claims from the OIDC User to the view
            model.addAttribute("fullName", oidcUser.getFullName());
            model.addAttribute("preferredUsername", oidcUser.getPreferredUsername());
            model.addAttribute("email", oidcUser.getEmail());
            model.addAttribute("subject", oidcUser.getSubject());
            model.addAttribute("profile", oidcUser.getProfile());
            model.addAttribute("claims", oidcUser.getClaims()); // All claims for debugging
            System.out.println(oidcUser.getAttributes().toString());
        }

        // Redirects to a secured HTML page to display the user claims
        return "securedprofile"; 
    }
}