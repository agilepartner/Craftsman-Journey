public class CustomerService {
    public void ActivateLogin(Customer customer) {
        /*
            Code to create login and save in database
        */

        MailChimpService emailService = new MailChimpService();
        emailService.sendWelcomeEmail(customer);
    }

    public class MailChimpService {
        public void sendWelcomeEmail(Customer customer) {
            /*
                Code to send email through MailChimp
            */
        }
    }
}
