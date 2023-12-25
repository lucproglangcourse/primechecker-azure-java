package edu.luc.cs.cs371.primechecker.web;

import com.microsoft.azure.functions.*;

import edu.luc.cs.cs371.primechecker.PrimeCheckerFunction;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.*;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;


/**
 * Unit test for PrimeCheckerunction class.
 */
public class PrimeCheckerFunctionTest {
    /**
     * Unit test for HttpTriggerJava method.
     */
    @Test
    public void test6007() throws Exception {
        assertEquals(HttpStatus.OK, runPrimeCheckerFunction("6007"));
    }

    @Test
    public void test6008() throws Exception {
        assertEquals(HttpStatus.NOT_FOUND, runPrimeCheckerFunction("6008"));
    }
    
    private HttpStatusType runPrimeCheckerFunction(final String numberString) throws Exception {
        // Setup
        @SuppressWarnings("unchecked")
        final HttpRequestMessage<Optional<String>> req = mock(HttpRequestMessage.class);

        final var queryParams = new HashMap<String, String>();
        queryParams.put("number", numberString);
        doReturn(queryParams).when(req).getQueryParameters();

        final var queryBody = Optional.<String>empty();
        doReturn(queryBody).when(req).getBody();

        doAnswer(new Answer<HttpResponseMessage.Builder>() {
            @Override
            public HttpResponseMessage.Builder answer(InvocationOnMock invocation) {
                final var status = (HttpStatus) invocation.getArguments()[0];
                return new HttpResponseMessageMock.HttpResponseMessageBuilderMock().status(status);
            }
        }).when(req).createResponseBuilder(any(HttpStatus.class));

        final var context = mock(ExecutionContext.class);
        doReturn(Logger.getGlobal()).when(context).getLogger();

        // Invoke
        final var ret = new PrimeCheckerFunction().run(req, context);

        // Return status
        return ret.getStatus();
    }
}
