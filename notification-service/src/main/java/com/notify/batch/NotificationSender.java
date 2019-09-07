package com.notify.batch;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.notify.dto.Key;
import com.notify.dto.NotificatonDTO;
import com.notify.service.NotificationService;
import com.notify.util.NotificationUtil;

public abstract class NotificationSender {

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private JavaMailSender javaMailSender;

    public List<Key> sendMail(final int numberOfDaysLeft) {
	prepareAndSendMail(numberOfDaysLeft >= 0 ? notificationService.getNotificationFor(numberOfDaysLeft)
		: notificationService.getOverdueSchedule(), numberOfDaysLeft);
	return null;
    }

    private void prepareAndSendMail(final Map<Key, List<NotificatonDTO>> data, int numberOfDaysLeft) {
	data.forEach((k, v) -> {
	    try {
		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setFrom("info@notification.com", "Schedule");
		helper.setTo(k.getEmail());
		helper.setSubject("Schedule Maintainence for " + k.getVehicle());
		StringBuilder taskData = new StringBuilder(0);
		v.forEach(s -> {
		    taskData.append("<tr>");
		    taskData.append("<td>");
		    taskData.append(s.getTaskName());
		    taskData.append("</td>");
		    taskData.append("<td>");
		    taskData.append(s.getLastChangedDate());
		    taskData.append("</td>");
		    taskData.append("<td>");
		    taskData.append(numberOfDaysLeft >= 0 ? numberOfDaysLeft : "OverDue");
		    taskData.append("</td>");
		    taskData.append("</tr>");
		});
		String mailMsg = NotificationUtil.MAIL_TEMPLATE;
		mailMsg = mailMsg.replace("$$header$$", k.getVehicle()).replace("$$data$$", taskData);
		helper.setText(mailMsg, true);
		javaMailSender.send(msg);
	    } catch (MessagingException | UnsupportedEncodingException e) {
		e.printStackTrace();
	    }
	});
    }
}
