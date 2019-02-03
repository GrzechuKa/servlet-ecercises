package pl.sdacademy.registration;

import javax.inject.Singleton;
import javax.inject.Inject;

@Singleton
public class UserService {

    @Inject
    private UserDao userDao;


    void saveUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());

        AddressDTO addressDTO = userDTO.getAddressDTO();
        if(addressDTO != null){
            Address address = new Address();
            address.setCity(addressDTO.getCity());
            address.setStreet(addressDTO.getStreet());
            address.setHouseNo(addressDTO.getHouseNo());
        }
        userDao.saveUser(user);
    }


}
