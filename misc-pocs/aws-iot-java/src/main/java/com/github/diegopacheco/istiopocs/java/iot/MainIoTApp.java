package com.github.diegopacheco.istiopocs.java.iot;

import java.io.FileInputStream;
import java.security.KeyStore;

import com.amazonaws.services.iot.client.AWSIotMqttClient;

//
// More on: https://github.com/aws/aws-iot-device-sdk-java
//
public class MainIoTApp {
	public static void main(String[] args) throws Throwable {
		
		String clientEndpoint = "<prefix>.iot.<region>.amazonaws.com";       // replace <prefix> and <region> with your own
		String clientId = "<unique client id>";                              // replace with your own client ID. Use unique client IDs for concurrent connections.
		
		String keyStoreFile     = "<my.keystore>";                           // replace with your own key store file
		String keyStorePassword = "<keystore-password>";                     // replace with your own key store password
		String keyPassword      = "<key-password>";                          // replace with your own key password
		KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
		keyStore.load(new FileInputStream(keyStoreFile), keyStorePassword.toCharArray());
		
		AWSIotMqttClient client = new AWSIotMqttClient(clientEndpoint, clientId, keyStore, keyPassword);
		client.connect();
		
	}
}
