package bookstoreservices.controller;

import bookstoreservices.common.APIResponse;
import bookstoreservices.dto.SignUpRequestDTO;
import bookstoreservices.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/signup")
    public ResponseEntity<APIResponse> signUp(@RequestBody SignUpRequestDTO signUpRequestDTO){

        APIResponse apiResponse=loginService.signUp(signUpRequestDTO);
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);

    }
}
