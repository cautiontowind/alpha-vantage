package com.jalpha_vantage.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.jalpha_vantage.exception.*;

import java.util.Map;

public class ExceptionUtil {

    static final String INVALID_API_KEY = "\"Please make sure your API key is valid. Alternatively, claim your free API key on (https://www.alphavantage.co/support/#api-key). It should take less than 20 seconds, and is free permanently.\"";
    static final String MISSING_API_KEY = "\"The parameter apikey is invalid or missing. Please claim your free API key on (https://www.alphavantage.co/support/#api-key). It should take less than 20 seconds, and is free permanently.\"";
    static final String HIGH_USUAGE = "\"Please consider optimizing your API call frequency\"";
    static final String API_LIMIT = "\"Thank you for using Alpha Vantage! Our standard API call frequency is 5 calls per minute and 500 calls per day. Please visit https://www.alphavantage.co/premium/ if you would like to target a higher API call frequency.\"";

    public static void handleExceptions(String value, String function) throws MissingApiKeyException, InvalidApiKeyException, MalFormattedFunctionException, InvalidFunctionOptionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        String invalidFunction = "\"This API function (" + function + ") does not exist.\"";
        String missingOrInvalidFunctionParam = "\"Invalid API call, please visit documentation (https://www.alphavantage.co/documentation/) for function: " + function + "\"";

        if (value.equals(MISSING_API_KEY)) {
            throw new MissingApiKeyException(MISSING_API_KEY);
        } else if (value.equals(INVALID_API_KEY)) {
            throw new InvalidApiKeyException(INVALID_API_KEY);
        } else if (value.equals(invalidFunction)) {
            throw new MalFormattedFunctionException(function);
        } else if (value.equals(missingOrInvalidFunctionParam)) {
            throw new InvalidFunctionOptionException(function);
        } else if (value.equals(HIGH_USUAGE)) {
            throw new UltraHighFrequencyRequestException(HIGH_USUAGE);
        }else if(value.equals(API_LIMIT)) {
            throw new ApiLimitExceeded(API_LIMIT);
        }

    }

    public static void handleException(Map.Entry<String, JsonNode> mapEntry, String function)
            throws InvalidApiKeyException,
            InvalidFunctionOptionException,
            MalFormattedFunctionException,
            MissingApiKeyException,
            UltraHighFrequencyRequestException,
            ApiLimitExceeded {
        String value = mapEntry.getValue().toString();
        handleExceptions(value, function);
    }

}

