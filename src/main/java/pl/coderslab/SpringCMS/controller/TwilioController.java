package pl.coderslab.SpringCMS.controller;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sendSMS")
public class TwilioController {

    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "AC5e740d3e156ec55d9e1e0c64b3845041";
    public static final String AUTH_TOKEN = "4f6c115abecce154dd6c7eed7d4e0115";

    @GetMapping("/test")
    @ResponseBody
    @Scheduled(fixedRate = 5000)
    public String sendSMS() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(new PhoneNumber("+48789024803"),
                new PhoneNumber("+15073354937"),
                "Przypominam, ze za 3 dni wizyta").create();
        System.out.println(message.getSid());

        return "Udalo sie wyslac smsa";

    }
}
