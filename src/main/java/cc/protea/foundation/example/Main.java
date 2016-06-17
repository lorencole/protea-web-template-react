package cc.protea.foundation.example;

import org.eclipse.jetty.servlet.ServletContextHandler;

import cc.protea.foundation.ProteaFoundation;
import cc.protea.foundation.template.model.TemplateUser;
import cc.protea.foundation.utility.ProfoundConfiguration;
import cc.protea.foundation.utility.ProfoundConfiguration.Storage.Service;
import cc.protea.foundation.utility.ProfoundServer;

public class Main {

	public static void main(final String[] args) throws Exception {

		ProfoundConfiguration.systemEmails.defaultTemplate = "platform-email";
		//ProfoundConfiguration.publicUrl = "http://localhost:8080";
		ProfoundConfiguration.publicUrl = "http://protea-web-template.herokuapp.com/";
		ProfoundConfiguration.servicePackages.add("cc.protea.foundation.template.services");
		ProfoundConfiguration.createSocialAccounts = true;

		ProfoundConfiguration.storage.sessions = Service.REDIS;
		ProfoundConfiguration.userClass = TemplateUser.class;
		
		ProteaFoundation foundation = new ProteaFoundation() {
			@Override
			public void addStaticHtmlServlet(final ServletContextHandler context) {
				super.addStaticHtmlServlet(context);
				context.setResourceBase("webapp/public");
				context.setWelcomeFiles(new String[] {"app/index.html"});
			}
		};
		
		ProfoundServer.start(foundation);

	}

}
