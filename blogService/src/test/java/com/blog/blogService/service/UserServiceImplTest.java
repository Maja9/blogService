package com.blog.blogService.service;

import com.blog.blogService.dto.UserDto;
import com.blog.blogService.entity.User;
import com.blog.blogService.mapper.UserMapper;
import com.blog.blogService.repository.UserRepository;
import com.blog.blogService.service.impl.UserServiceImpl;
import com.blog.blogService.mocks.UserDtoMock;
import com.blog.blogService.mocks.UserMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.given;

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
