package ru.itis.javalab.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.javalab.models.CartUser;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MailsOrderGeneratorImpl implements MailsOrderGenerator {
    @Autowired
    private Configuration configuration;

    @Override
    public String getMailForOrder(String serverUrl, List<CartUser> cartUsers) {
        Template OrderMailTemplate;
        try {
            OrderMailTemplate = configuration.getTemplate("mails/order_mail.ftlh");
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("cartUsers", cartUsers);
        attributes.put("server_url", serverUrl);

        StringWriter writer = new StringWriter();
        try {
            OrderMailTemplate.process(attributes, writer);
        } catch (TemplateException | IOException e) {
            throw new IllegalStateException(e);
        }
        return writer.toString();
    }
}
