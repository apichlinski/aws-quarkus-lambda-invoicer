package com.github.apichlinski.invoicer.fakturownia;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;
import org.slf4j.Logger;

@Priority(Priorities.USER)
class RestClientExceptionMapper implements ResponseExceptionMapper<RuntimeException> {

    @Inject
    Logger logger;

    @Override
    public boolean handles(int status, MultivaluedMap<String, Object> headers) {
        return status >= 400 && status < 500;
    }

    @Override
    public RuntimeException toThrowable(Response response) {
        return new ClientErrorException(response);
    }
}