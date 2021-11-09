//package pl.coderslab.SpringCMS;
//import com.twilio.Twilio;
//import com.twilio.exception.AuthenticationException;
//import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.type.PhoneNumber;
//
//public class Example {
//    // Find your Account Sid and Token at twilio.com/user/account
//    public static final String ACCOUNT_SID = "AC5e740d3e156ec55d9e1e0c64b3845041";
//    public static final String AUTH_TOKEN = "42aeb8fd5efcad2b4f8e681d018b93e6";
//
//    public static void main(String[] args) {
//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//        Message message = Message.creator(new PhoneNumber("+48789024803"),
//                new PhoneNumber("+15073354937"),
//                "Czy był Pan u mnie w kuchni?").create();
//        System.out.println(message.getSid());
//
//    }
//}
