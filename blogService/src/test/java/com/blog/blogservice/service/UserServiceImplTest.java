package com.blog.blogservice.service;

import com.blog.blogservice.dto.UserDto;
import com.blog.blogservice.entity.User;
import com.blog.blogservice.mapper.UserMapper;
import com.blog.blogservice.mocks.UserDtoMock;
import com.blog.blogservice.mocks.UserMock;
import com.blog.blogservice.repository.UserRepository;
import com.blog.blogservice.service.impl.UserServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class UserServiceImplTest {

    @Mock
    private UserMapper userMapper;

    @Mock
    private UserRepository userRepository;

    private UserServiceImpl userService;

    @Before
    public void before() {
        openMocks(this);
        userService = new UserServiceImpl(userRepository, userMapper);
    }

    @After
    public void after() {
        reset(userMapper, userRepository);
    }

    @Test
    public void shouldSaveUserInDB() {

        //given
        final UserDto userToSave = UserDtoMock.getBasicUserDto();
        final User user = UserMock.getBasicUser();

        given(userMapper.map(userToSave, User.class)).willReturn(user);

        given(userRepository.save(any(User.class))).willReturn(user);

        //when
        final Long saveUserId = userService.createUser(userToSave);

        //then
        verify(userRepository, times(1)).save(any());
        assertNotNull(saveUserId);

    }

}
