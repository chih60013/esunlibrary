package com.esun.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;



@Controller
public class CountryApiController {




    @GetMapping("/getRestCountriesData")
    @ResponseBody
    public String getRestCountriesData() {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://restcountries.com/v3.1/all");  //匯入 api  呼叫

        try {
            HttpResponse response = httpClient.execute(httpGet);
            String responseBody = EntityUtils.toString(response.getEntity());

            return responseBody;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while fetching data from Rest Countries API.";
        }
    }
}
