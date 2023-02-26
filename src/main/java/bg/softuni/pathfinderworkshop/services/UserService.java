package bg.softuni.pathfinderworkshop.services;

import bg.softuni.pathfinderworkshop.models.entity.User;
import bg.softuni.pathfinderworkshop.models.enums.LevelEnum;
import bg.softuni.pathfinderworkshop.models.service.UserServiceDTO;
import bg.softuni.pathfinderworkshop.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public void registerUser(UserServiceDTO userServiceDTO) {
        User user = modelMapper.map(userServiceDTO, User.class);
        user.setLevel(LevelEnum.BEGINNER);

        userRepository.save(user);
    }

}
