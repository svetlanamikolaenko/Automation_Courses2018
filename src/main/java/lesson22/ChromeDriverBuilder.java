package lesson22;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ChromeDriverBuilder {
    private ChromeOptions options = new ChromeOptions();

    public ChromeDriverBuilder setMobileEmulation(String deviceName) {
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", deviceName);
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        return this;
    }


    public ChromeDriverBuilder

    setPageLoadStrategy(String strategy) {
        this.options.setPageLoadStrategy(PageLoadStrategy.fromString(strategy));
        return this;
    }

    public ChromeDriver build() {

        return new ChromeDriver(options);
    }
}