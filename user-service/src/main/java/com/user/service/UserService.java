package com.user.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.common.model.UserDto;
import com.user.dto.SignUpDto;
import com.user.dto.UserCredentialDto;
import com.user.entity.User;
import com.user.entity.UserCredential;
import com.user.exception.DataException;
import com.user.repo.UserCredentialRepo;
import com.user.repo.UserRepo;
import com.user.util.Util;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final UserCredentialRepo userCrendentialRepo;

    public UserService(final UserRepo userRepo, UserCredentialRepo userCrendentialRepo) {
	this.userRepo = userRepo;
	this.userCrendentialRepo = userCrendentialRepo;
    }

    @Transactional
    public UserDto signUp(final SignUpDto signUpdto) {
	userRepo.findByUserIdOrUserEmailIgnoreCase(signUpdto.getUser().getUserId(), signUpdto.getUser().getUserEmail())
		.ifPresent(s -> {
		    throw new DataException("", "user already registered");
		});
	User saved = userRepo.save(Util.mapObject(signUpdto.getUser(), User.class));
	signUpdto.getUserCredential().setId(saved.getUserId());
	userCrendentialRepo.save(Util.mapObject(signUpdto.getUserCredential(), UserCredential.class));
	return Util.mapObject(saved, UserDto.class);
    }

    public UserDto signIn(final UserCredentialDto userCreddentialDto) {
	return userCrendentialRepo.signIn(userCreddentialDto.getUserName(), userCreddentialDto.getPassword()).map(c -> {
	    return userRepo.findById(c).map(u -> Util.mapObject(u, UserDto.class)).orElse(new UserDto());
	}).orElse(new UserDto());
    }

    public UserDto findById(int id) {
	return userRepo.findById(id).map(u -> Util.mapObject(u, UserDto.class)).orElse(new UserDto());
    }
}
