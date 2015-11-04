package com.tw.todolist.controller;


import com.tw.todolist.domain.PremiumResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/pricing")
public class PricingController {


    @RequestMapping(method = GET)
    public ModelAndView showPremiumSummary() {
        return new ModelAndView("premiumSummary");
    }



    @RequestMapping(value = "/calculate", method = GET)
    @ResponseBody
    public List<PremiumResponse> getPremiumResponse()
    {
        List<PremiumResponse> premiumResponses = new ArrayList<PremiumResponse>();
        PremiumResponse premiumResponse = new PremiumResponse();
        premiumResponses.add(premiumResponse);
        return premiumResponses;
    }


}
