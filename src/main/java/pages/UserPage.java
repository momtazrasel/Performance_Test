package pages;

import org.apache.jmeter.protocol.http.control.Header;
import org.apache.jmeter.protocol.http.control.HeaderManager;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;

public class UserPage {

    public HTTPSamplerProxy createUserSampler(String token, String userData) {
        HTTPSamplerProxy userSampler = new HTTPSamplerProxy();

        userSampler.setDomain("example.com"); // Replace with your domain
        userSampler.setPath("/api/users");
        userSampler.setMethod("POST");
        userSampler.setPort(443);
        userSampler.setProtocol("https");

        // Add user data
        userSampler.addNonEncodedArgument("", userData, "");

        // Add headers
        HeaderManager headerManager = new HeaderManager();
        headerManager.add(new Header("Content-Type", "application/json"));
        headerManager.add(new Header("Authorization", "Bearer " + token));
        userSampler.setHeaderManager(headerManager);

        return userSampler;
    }
}
