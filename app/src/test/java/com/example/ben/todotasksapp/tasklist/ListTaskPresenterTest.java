package com.example.ben.todotasksapp.tasklist;

import com.example.ben.todotasksapp.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ListTaskPresenterTest {

    @Mock
    private ListTaskView listTaskView;
    private ListTaskPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new ListTaskPresenter(listTaskView);
    }

    @Test
    public void showErrorMessageIfListIsEmpty() throws Exception{
        when(listTaskView.getTaskList(items)).thenReturn("");

        verify(listTaskView).showErrorMassage(R.string.error_list_task);
    }

    @Test
    public void produceTaskItems() {
        int expected = 100;
        int actual = 40;
        int delta = 30;

        assertEquals(expected,actual,delta);
    }
}