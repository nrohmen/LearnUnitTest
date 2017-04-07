package com.dicoding.unittest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by rohmen on 1/5/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock
    private MainPresenter presenter;
    private MainView view;

    @Before
    public void setUp() throws Exception {
        view = mock(MainView.class);
        presenter = new MainPresenter(view);
    }

    @Test
    public void testLuas() throws Exception {
        double luas = presenter.luas(2, 8);
        assertEquals(24.42, luas);
    }

    @Test
    public void testHitungLuas() throws Exception {
        presenter.hitungLuas(11.1, 2.2);
        verify(view).tampilLuas(any(MainModel.class));
    }
}