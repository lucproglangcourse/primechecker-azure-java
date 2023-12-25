package edu.luc.cs.cs371.primechecker;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

import edu.luc.cs.cs371.primechecker.core.PrimeChecker;

import java.math.BigInteger;
import java.util.Optional;

/**
 * Azure Functions with HTTP Trigger.
 */
public class PrimeCheckerFunction {
    /**
     * This function listens at endpoint "/api/Hello". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/Hello
     * 2. curl "{your host}/api/Hello?name=HTTP%20Query"
     */
    @FunctionName("isPrime")
    public HttpResponseMessage run(
            @HttpTrigger(
                name = "req",
                methods = {HttpMethod.GET, HttpMethod.POST},
                authLevel = AuthorizationLevel.ANONYMOUS)
                HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        // Parse query parameter
        final var query = request.getQueryParameters().get("number");
        final var numberString = request.getBody().orElse(query);

        if (numberString == null) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("Please pass a number on the query string or in the request body").build();
        } else {
            final var number = new BigInteger(numberString);
            final var result = PrimeChecker.isPrimeSlow(number);
            if (result) {
                return request.createResponseBuilder(HttpStatus.OK).body("Yay, " + number + " is a prime!").build();
            } else {
                return request.createResponseBuilder(HttpStatus.NOT_FOUND).body("Bummer, " + number + " is not a prime!").build();
            }
        }
    }
}
