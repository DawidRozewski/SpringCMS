package pl.coderslab.SpringCMS.controller;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sendSMS")
public class TwilioController {

    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "AC5e740d3e156ec55d9e1e0c64b3845041";
    public static final String AUTH_TOKEN = "42aeb8fd5efcad2b4f8e681d018b93e6";


    @GetMapping("/test")
    @ResponseBody
    public String sendSMS() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(new PhoneNumber("+48789024803"),
                new PhoneNumber("+15073354937"),
                "UDALO SIEEEEEE").create();
        System.out.println(message.getSid());
        return "Przypominam, ze za 3 dni wizyta:)";

    }
}
