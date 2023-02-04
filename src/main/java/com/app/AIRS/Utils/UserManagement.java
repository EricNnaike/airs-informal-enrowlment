//package com.app.AIRS.Utils;
//
//import com.app.AIRS.entity.User;
//import com.app.AIRS.repository.*;
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//
//@Data
//@Component
//public class UserManagement {
//
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private ShopRepository marketUserRepository;
//    @Autowired
//    private TinRepository tinRepository;
//    @Autowired
//    private UserGroupRepository userGroupRepository;
//    @Autowired
//    private UserRolesReposiroty userRolesReposiroty;
//
//
//    @Transactional
//    public User persistUser(User user) {
//        User userRecord = getUserRepository().findByEmail(user.getEmail());
//        if (userRecord instanceof User) {
//            user.setId(userRecord.getId());
//        } else {
//            user.setTimeCreated(LocalDateTime.now());
//        }
//
//        if (user.getEmail() == null) {
//            user.setEnabled(true);
//        } else {
//            user.setEnabled(true);
//        }
//        user.setAccountNonExpired(true);
//        user.setCredentialsNonExpired(true);
//        user.setAccountNonLocked(true);
//
//        return getUserRepository().save(user);
//    }
//}
