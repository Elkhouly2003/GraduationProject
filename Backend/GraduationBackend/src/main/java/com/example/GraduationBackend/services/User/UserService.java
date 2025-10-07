package com.example.GraduationBackend.services.User;

import com.example.GraduationBackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService implements IUser{
    private final UserRepository userRepository;

}
