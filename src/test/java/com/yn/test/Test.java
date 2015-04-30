package com.yn.test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class Test {
	public static void main(String[] args) throws MalformedURLException, IOException {
		FileSystemResourceLoader resourceLoader = new FileSystemResourceLoader();
		System.out.println(resourceLoader.getResource("classpath:").getURI().toURL().getPath());
		RestTemplate r = new RestTemplate();
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<String>(map);
//		r.exchange(url, method, requestEntity, responseType, uriVariables);
	}
}
