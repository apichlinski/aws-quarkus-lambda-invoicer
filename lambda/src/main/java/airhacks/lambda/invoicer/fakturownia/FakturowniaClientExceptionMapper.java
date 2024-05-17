package airhacks.lambda.invoicer.fakturownia;

import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

@Provider
public class FakturowniaClientExceptionMapper implements ResponseExceptionMapper<RuntimeException> {

    @Override
    public boolean handles(int status, MultivaluedMap<String, Object> headers) {
        return status >= 400 && status < 500;
    }

    @Override
    public RuntimeException toThrowable(Response response) {
        return new ClientErrorException(response);
    }
}