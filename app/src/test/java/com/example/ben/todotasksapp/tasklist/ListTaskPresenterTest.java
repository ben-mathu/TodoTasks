package com.example.ben.todotasksapp.tasklist;

import android.content.Context;

import com.example.ben.todotasksapp.R;
import com.example.ben.todotasksapp.data.ItemsLab;

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
    private ItemsLab itemsLab;

    @Mock
    private ListTaskView listTaskView;
    @Mock
    private Context context;
    private ListTaskPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new ListTaskPresenter(listTaskView);
    }

    @Test
    public void showErrorMessageIfListIsEmpty() throws Exception{
        itemsLab = new ItemsLab(context);
        when(listTaskView.getTaskList()).thenReturn(itemsLab.getItems());

        verify(listTaskView).showErrorMassage(R.string.error_list_task);
    }

//    @Test
//    public void produceTaskItems() {
//        int expected = 100;
//        int actual = 40;
//        int delta = 30;
//
//        assertEquals(expected,actual,delta);
//    }
}