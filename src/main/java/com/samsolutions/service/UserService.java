package com.samsolutions.service;

import com.samsolutions.dto.data.UserDataDTO;
import com.samsolutions.dto.form.TicketFormDTO;
import com.samsolutions.dto.form.UserFormDTO;
import com.samsolutions.entity.Role;
import com.samsolutions.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * User service determine methods for working with user table.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.service
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Service
public interface UserService extends IEntity<UserDataDTO, UserFormDTO> {

    void registration(UserFormDTO formDTO);

    /**
     * Method for find user by username.
     *
     * @param username username of desired user.
     * @return UserDTO.
     */
    User findByUsername(String username);

    UserDataDTO findWithRolesById(Long id);

    Map<String, Object> getMapAndPageForDoctors(Integer pageNo, Integer pageSize, Boolean desc, String sort);

    void updatePhoto(Long id, MultipartFile file) throws IOException;

    List<UserDataDTO> getPage(Integer pageNo, Integer pageSize, Boolean desc, String sort);

    Map<String, Object> getMapAndPageByRole(Long id, Integer pageNo, Integer pageSize, Boolean desc, String sort);

    Map<String, Object> getMapAndPage(Integer pageNo, Integer pageSize, Boolean desc, String sort);

    void updatePassword(UserFormDTO formDTO);

    void updateProfile(UserFormDTO formDTO);

    void updateRoles(UserFormDTO formDTO);
}