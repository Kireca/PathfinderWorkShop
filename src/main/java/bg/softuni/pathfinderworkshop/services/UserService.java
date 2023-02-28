package bg.softuni.pathfinderworkshop.services;

import bg.softuni.pathfinderworkshop.models.entity.User;
import bg.softuni.pathfinderworkshop.models.enums.LevelEnum;
import bg.softuni.pathfinderworkshop.models.service.UserServiceDTO;
import bg.softuni.pathfinderworkshop.repositories.UserRepository;
import bg.softuni.pathfinderworkshop.utils.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;


    public UserService(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    public void registerUser(UserServiceDTO userServiceDTO) {
        User user = modelMapper.map(userServiceDTO, User.class);
        user.setLevel(LevelEnum.BEGINNER);

        userRepository.save(user);
    }

    public UserServiceDTO findUserByUsernameAndPassword(String username, String password) {

        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceDTO.class)).orElse(null);


    }

    public void loginUser(Long id, String username) {
        currentUser.setUsername(username);
        currentUser.setId(id);
    }

    public void logout() {
        currentUser.setId(null);
        currentUser.setUsername(null);
    }

    public UserServiceDTO findById(Long id) {
        return userRepository.findById(id)
                .map(user -> modelMapper.map(user, UserServiceDTO.class))
                .orElse(null);
    }

}
