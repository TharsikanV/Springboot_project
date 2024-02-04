package bookstoreservices.service;

import bookstoreservices.common.APIResponse;
import bookstoreservices.dto.SignUpRequestDTO;
import bookstoreservices.entity.User;
import bookstoreservices.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;
    public APIResponse signUp(SignUpRequestDTO signUpRequestDTO) {
        APIResponse apiResponse=new APIResponse();

        //validation

        //dto to entity
        User userEntity=new User();
        userEntity.setName(signUpRequestDTO.getName());
        userEntity.setEmailId(signUpRequestDTO.getEmailId());
        userEntity.setActive(Boolean.TRUE);
        userEntity.setGender(signUpRequestDTO.getGender());
        userEntity.setPhoneNumber(signUpRequestDTO.getPhoneNumber());
        userEntity.setPassword(signUpRequestDTO.getPassword());

        //store entity
        userEntity=userRepository.save(userEntity);

        //return
        apiResponse.setData(userEntity);
        return apiResponse;
    }
}
