package com.intuit.craft;

import com.intuit.craft.controller.FriendshipResource;
import com.intuit.craft.dto.FriendshipDTO;
import com.intuit.craft.service.FriendshipService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

//The JUnit Runner which causes all the initialization magic with
// @Mock and @InjectMocks to happen before the tests are run.
@RunWith(PowerMockRunner.class)
@PrepareForTest({FriendshipResource.class})
public class FriendshipResourceUniTest {

    //Inject the mocks as dependencies into FriendshipResource
    @InjectMocks
    private FriendshipResource friendshipResource;

    //Create a mock for FriendshipService.
    @Mock
    FriendshipService friendshipService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void followTest(){
        FriendshipDTO friendshipDTO = new FriendshipDTO();
        friendshipDTO.setFrom_user_id(1);
        friendshipDTO.setTo_user_id(2);
        friendshipResource.follow(friendshipDTO);
    }
}

