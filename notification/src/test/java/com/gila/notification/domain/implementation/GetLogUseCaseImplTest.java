package com.gila.notification.domain.implementation;

import com.gila.notification.application.port.inbound.GetLogsUseCase;
import com.gila.notification.domain.exception.HeaderNotFoundException;
import com.gila.notification.domain.implementation.testobjctmapper.LogTestObjectMother;
import com.gila.notification.domain.models.Log;
import com.gila.notification.infrastructure.adapters.inbound.rest.LogRestAdapter;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GetLogUseCaseImplTest {
    private final GetLogsUseCase getLogsUseCase = mock(GetLogsUseCase.class);
    private final LogRestAdapter logRestAdapter =
            new LogRestAdapter(getLogsUseCase);
@Test
public void logsFindAll() {
    Pageable pageable = PageRequest.of(0, 10);
//GIVEN
    Page page= new PageImpl<>(
            LogTestObjectMother.aLog(),
            pageable,
            23);

    when(getLogsUseCase.findAllPageable( pageable))
            .thenReturn(page);

    //WHEN
    ResponseEntity<Page<Log>> testResponse =
            logRestAdapter.logsFindAll( String.valueOf(0),String.valueOf(10));

    verify(getLogsUseCase, times(1))
            .findAllPageable(pageable);
    assertEquals(HttpStatus.OK, testResponse.getStatusCode());
    assertNotNull(testResponse.getBody());
    assertEquals(page, testResponse.getBody());


}
    @Test
    public void logsFindAllwithOutHeader() {
        Pageable pageable = PageRequest.of(0, 10);
//GIVEN
        Page page= new PageImpl<>(
                LogTestObjectMother.aLog(),
                pageable,
                23);

        when(getLogsUseCase.findAllPageable( pageable))
                .thenReturn(page);

        //WHEN
       /// ResponseEntity<Page<Log>> testResponse =

        assertThrows(HeaderNotFoundException.class, () -> {
            logRestAdapter.logsFindAll( null,null);
        });
/*
        verify(getLogsUseCase, times(1))
                .findAllPageable(pageable);
        assertEquals(HttpStatus.OK, testResponse.getStatusCode());
        assertNotNull(testResponse.getBody());
        assertEquals(page, testResponse.getBody());
*/

    }
}
