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

    private final TwilioAcc twilioAcc;

    public TwilioController(TwilioAcc twilioAcc) {
        this.twilioAcc = twilioAcc;
    }


    @GetMapping("/test")
    @ResponseBody
    @Scheduled(fixedRate = 5000)
    public String sendSMS() {
        Twilio.init(
                twilioAcc.getAccSid(),
                twilioAcc.getAuthToken());
        Message message = Message.creator(new PhoneNumber("+48789024803"),
                new PhoneNumber(twilioAcc.getPhoneNumber()),
                "Przypominam, ze za 3 dni wizyta").create();
        System.out.println(message.getSid());

        return "Udalo sie wyslac smsa";

    }
}
