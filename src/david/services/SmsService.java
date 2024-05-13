package david.services;
import david.entities.Sms;
import java.util.List;

public interface SmsService {
    void addSms(Sms sms);
    Sms getSmsById(int id);
    List<Sms> getAllSms();
    void updateSms(Sms sms);
    void deleteSms(int id);
}
