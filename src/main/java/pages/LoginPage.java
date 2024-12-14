package pages;

import org.apache.jmeter.protocol.http.control.Header;
import org.apache.jmeter.protocol.http.control.HeaderManager;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;

public class LoginPage {

    public HTTPSamplerProxy createLoginSampler(String username, String password) {
        HTTPSamplerProxy loginSampler = new HTTPSamplerProxy();

        loginSampler.setDomain("example.com"); // Replace with your domain
        loginSampler.setPath("/auth/login");
        loginSampler.setMethod("POST");
        loginSampler.setPort(443);
        loginSampler.setProtocol("https");

        // Add login parameters
        loginSampler.addArgument("username", username);
        loginSampler.addArgument("password", password);

        // Add headers
        HeaderManager headerManager = new HeaderManager();
        headerManager.add(new Header("Content-Type", "application/json"));
        loginSampler.setHeaderManager(headerManager);

        return loginSampler;
    }
}
