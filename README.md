AndroidNetworkHandler
=====================

Handle network stuff in Android

[Retrieve JSON response or send JSON request though this API]

1. Set headers

		HashMap<String, String> headers = new HashMap<String, String>();
    	headers.put(HTTP.USER_AGENT, "Mozilla/5.0 (Macintosh; U; PPC Mac OS X; en) AppleWebKit/125.2 (KHTML, like Gecko) Safari/85.8");
        // ... more headers here ...

2. Send request - Sysetm will help to to decide which HttpClient will be used

		CustomHttpResponse response = NetworkConnectionManager.getJsonData("https://sample.com/sample_get_json", headers);

3. Handle response

		if(response.getStatusCode() == HttpStatus.SC_OK){
            Object obj = response.getJsonObj();
            if(obj != null){
                if (obj instanceof JSONObject) {
                    // you have an object
                    JSONObject jobj = (JSONObject)obj;
                    // Handle here...
                } else if (obj instanceof JSONArray) {
                    // you have an array
                    JSONArray jary = (JSONArray)obj;
                    // Handle here...
                }
            }
        }