package com.cjnet.tdd_sample;

import com.cjnet.tdd_sample.api.model.Posts;
import com.cjnet.tdd_sample.api.model.PostsList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class PostsEntityTest {

    private String id = "1";
    private String title = "Test Post";
    private String body = "This is Test post body";
    private String userId = "cjnet";

    @Mock
    Posts post;

    @Mock
    PostsList postList;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Mockito.when(post.getId()).thenReturn(id);
        Mockito.when(post.getTitle()).thenReturn(title);
        Mockito.when(post.getBody()).thenReturn(body);
        Mockito.when(post.getUserId()).thenReturn(userId);
    }

    @Test
    public void testNewsTitle(){
       // Mockito.when(post.getTitle()).thenReturn(title);
        Assert.assertEquals("Test Post",post.getTitle());
    }

    @Test
    public void testNewsTitleIncorrect(){
      //  Mockito.when(post.getTitle()).thenReturn(title);
        Assert.assertNotEquals("Title",post.getTitle());
    }



}
