package com.travelpedia.api.AuthService;

//package com.example.travelediabackendjwt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Async
    public Boolean send(String to, String subject, String body) {
        try {

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(body, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom("${app.mailFrom}");
            mailSender.send(mimeMessage);
            System.out.println("mail sent");
        } catch (MessagingException e) {
            // TODO : logging as sending email failed
            // throw new IllegalStateException("failed to send email");
            return false;
        }
        return true;
    }

	public Boolean sendOtpVerificationEmail(String email, String userName, String otp) {
		// TODO Auto-generated method stu

		String subject="Verify your Travelpedia Account";
		String body="<!DOCTYPE html>\n"
        + "<html lang=\"en\">\n"
        + "  <head>\n"
        + "    <meta charset=\"UTF-8\" />\n"
        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n"
        + "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />\n"
        + "    <title>Account Verification</title>\n"
        + "    <link\n"
        + "      href=\"https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap\"\n"
        + "      rel=\"stylesheet\"\n"
        + "    />\n"
        + "  </head>\n"
        + "  <body\n"
        + "    style=\"\n"
        + "      margin: 0;\n"
        + "      font-family: 'Poppins', sans-serif;\n"
        + "      background: #ffffff;\n"
        + "      font-size: 14px;\n"
        + "    \"\n"
        + "  >\n"
        + "    <div\n"
        + "      style=\"\n"
        + "        max-width: 680px;\n"
        + "        margin: 0 auto;\n"
        + "        padding: 45px 30px 60px;\n"
        + "        background: #f4f7ff;\n"
       + "        font-size: 14px;\n"
        + "        color: #434343;\n"
        + "      \"\n"
        + "    >\n"
        + "      <main>\n"
        + "        <div\n"
        + "          style=\"\n"
        + "            margin: 0;\n"
        + "            margin-top: 70px;\n"
        + "            padding: 92px 30px 115px;\n"
        + "            background: #ffffff;\n"
        + "            border-radius: 30px;\n"
        + "            text-align: center;\n"
        + "          \"\n"
        + "        >\n"
        + "          <div style=\"width: 100%; max-width: 489px; margin: 0 auto;\">\n"
        + "            <h1\n"
        + "              style=\"\n"
        + "                margin: 0;\n"
        + "                font-size: 24px;\n"
        + "                font-weight: 500;\n"
        + "                color: #1f1f1f;\n"
        + "              \"\n"
        + "            >\n"
        + "              Your OTP\n"
        + "            </h1>\n"
        + "            <p\n"
        + "              style=\"\n"
        + "                margin: 0;\n"
        + "                margin-top: 17px;\n"
        + "                font-size: 16px;\n"
        + "                font-weight: 500;\n"
        + "              \"\n"
        + "            >\n"
        + "              Hey ,"+ userName + "\n"
        + "            </p>\n"
        + "            <p\n"
        + "              style=\"\n"
        + "                margin: 0;\n"
        + "                margin-top: 17px;\n"
        + "                font-weight: 500;\n"
        + "                letter-spacing: 0.56px;\n"
        + "              \"\n"
        + "            >\n"
        + "              Thank you for choosing Travelpedia. Use the following OTP\n"
        + "              to complete the procedure to verify your account. OTP is\n"
        + "              valid for\n"
        + "              <span style=\"font-weight: 600; color: #1f1f1f;\">5 minutes</span>.\n"
        + "              Do not share this code with others, including Travelpedia employees.\n"
        + "            </p>\n"
        + "            <p\n"
        + "              style=\"\n"
        + "                margin: 0;\n"
        + "                margin-top: 60px;\n"
        + "                font-size: 40px;\n"
        + "                font-weight: 600;\n"
        + "                letter-spacing: 25px;\n"
        + "                color: #ba3d4f;\n"
        + "              \"\n"
        + "            >\n" + otp + "\n"
        + "            </p>\n"
        + "          </div>\n"
        + "        </div>\n"
        + "        <p\n"
        + "          style=\"\n"
        + "            max-width: 400px;\n"
        + "            margin: 0 auto;\n"
        + "            margin-top: 90px;\n"
        + "            text-align: center;\n"
        + "            font-weight: 500;\n"
        + "            color: #8c8c8c;\n"
        + "          \"\n"
        + "        >\n"
        + "          Need help? Ask at\n"
        + "          <a\n"
        + "            href=\"mailto:travelpediacustomerservice@gmail.com\"\n"
        + "            style=\"color: #499fb6; text-decoration: none;\"\n"
        + "            >travelpediacustomerservice@gmail.com</a\n"
        + "          >\n"
        + "          or visit our website.\n"
        + "        </p>\n"
        + "      </main>\n"
        + "      <footer\n"
        + "        style=\"\n"
        + "          width: 100%;\n"
        + "          max-width: 490px;\n"
        + "          margin: 20px auto 0;\n"
        + "          text-align: center;\n"
        + "          border-top: 1px solid #e6ebf1;\n"
        + "        \"\n"
        + "      >\n"
        + "        <p\n"
        + "          style=\"\n"
        + "            margin: 0;\n"
        + "            margin-top: 40px;\n"
        + "            font-size: 16px;\n"
        + "            font-weight: 600;\n"
        + "            color: #434343;\n"
        + "          \"\n"
        + "        >\n"
        + "          Travelpedia\n"
        + "        </p>\n"
        + "        <p style=\"margin: 0; margin-top: 8px; color: #434343;\">\n"
        + "          Indian Institute Of Information Technology,Lucknow\n"
        + "        </p>\n"
        + "        <p style=\"margin: 0; margin-top: 16px; color: #434343;\">\n"
        + "          Copyright © 2023 Company. All rights reserved.\n"
        + "        </p>\n"
        + "      </footer>\n"
        + "    </div>\n"
        + "  </body>\n"
        + "</html>";
//				+ "Please click <a href=\"${app.url}/api/auth/verifyEmail?token="+token+"\"> here </a> to verify your travelpedia account.";
		return send(email, subject, body);
	}

    public Boolean sendqueryEmail(String email, String userName) {
        // TODO Auto-generated method stu

        String subject="Query Recieved";
        String body="<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\" />\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />\n" +
                "    <title>Query Received</title>\n" +
                "    <link href=\"https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap\" rel=\"stylesheet\" />\n" +
                "</head>\n" +
                "<body style=\"margin: 0; font-family: 'Poppins', sans-serif; background: #ffffff; font-size: 14px;\">\n" +
                "    <div style=\"max-width: 680px; margin: 0 auto; padding: 45px 30px 60px; background: #f4f7ff; font-size: 14px; color: #434343;\">\n" +
                "        <main>\n" +
                "            <div style=\"margin: 0; margin-top: 70px; padding: 92px 30px 115px; background: #ffffff; border-radius: 30px; text-align: center;\">\n" +
                "                <div style=\"width: 100%; max-width: 489px; margin: 0 auto;\">\n" +
                "                    <h1 style=\"margin: 0; font-size: 24px; font-weight: 500; color: #1f1f1f;\">Query Received</h1>\n" +
                "                    <p style=\"margin: 0; margin-top: 17px; font-size: 16px; font-weight: 500;\">Hello " + userName + ",</p>\n" +
                "                    <p style=\"margin: 0; margin-top: 17px; font-weight: 500; letter-spacing: 0.56px;\">\n" +
                "                        Thank you for reaching out to us. Your query has been received and our team is working on it we \n will get back to you as soon as possible.\n" +
                "                    </p>\n" +
//                "                    <p style=\"margin: 0; margin-top: 20px; font-size: 16px; font-weight: 500; color: #1f1f1f;\">\n" +
//                "                        <strong>Query Number:</strong> " + queryNumber + "\n" +
//                "                    </p>\n" +
//                "                    <p style=\"margin: 0; margin-top: 10px; font-size: 16px; font-weight: 500; color: #1f1f1f;\">\n" +
//                "                        <strong>Query Details:</strong> " + queryDetails + "\n" +
//                "                    </p>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <p style=\"max-width: 400px; margin: 0 auto; margin-top: 90px; text-align: center; font-weight: 500; color: #8c8c8c;\">\n" +
                "                Need help? Ask at\n" +
                "                <a href=\"mailto:travelpediacustomerservice@gmail.com\" style=\"color: #499fb6; text-decoration: none;\">travelpediacustomerservice@gmail.com</a>\n" +
                "                or visit our website.\n" +
                "            </p>\n" +
                "        </main>\n" +
                "        <footer style=\"width: 100%; max-width: 490px; margin: 20px auto 0; text-align: center; border-top: 1px solid #e6ebf1;\">\n" +
                "            <p style=\"margin: 0; margin-top: 40px; font-size: 16px; font-weight: 600; color: #434343;\">Travelpedia</p>\n" +
                "            <p style=\"margin: 0; margin-top: 8px; color: #434343;\">Indian Institute Of Information Technology,Lucknow</p>\n" +
                "            <p style=\"margin: 0; margin-top: 16px; color: #434343;\">Copyright © 2023 Company. All rights reserved.</p>\n" +
                "        </footer>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";


//				+ "Please click <a href=\"${app.url}/api/auth/verifyEmail?token="+token+"\"> here </a> to verify your travelpedia account.";
        return send(email, subject, body);
    }

}
