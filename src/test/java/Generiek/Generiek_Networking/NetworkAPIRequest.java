package Generiek.Generiek_Networking;

import Utilities.GWD;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v126.network.Network;
import org.openqa.selenium.devtools.v126.network.model.Request;
import org.openqa.selenium.devtools.v126.network.model.Response;

import java.util.Optional;
//https://www.youtube.com/watch?v=h-1bon3dMac

public class NetworkAPIRequest {
    public void APKRequestControl(){
        // WebDriver'ı al ve DevTools'u etkinleştir
        DevTools devTools = GWD.getDevTools();

        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));


        devTools.addListener(Network.requestWillBeSent(), request ->
        {
            Request req = request.getRequest();
            System.out.println("Request: " + req.getUrl());
        });

        devTools.addListener(Network.responseReceived(), response -> {
            Response res = response.getResponse();
            System.out.println("Response: " + res.getStatus());
        });

        GWD.getDriver().getCurrentUrl();
    }
}
